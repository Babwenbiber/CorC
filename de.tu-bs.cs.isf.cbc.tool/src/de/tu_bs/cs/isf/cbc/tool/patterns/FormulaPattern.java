package de.tu_bs.cs.isf.cbc.tool.patterns;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.algorithms.MultiText;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Font;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.IPattern;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.pattern.id.IdPattern;
import org.eclipse.graphiti.pattern.id.IdUpdateContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.graphiti.util.PredefinedColoredAreas;

import de.tu_bs.cs.isf.cbc.cbcmodel.AbstractStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbcmodelFactory;
import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.ConditionExtension;
import de.tu_bs.cs.isf.cbc.tool.diagram.CbCImageProvider;
import de.tu_bs.cs.isf.cbc.tool.model.CbcModelUtil;

/**
 * Class that creates the graphical representation of Conditions
 * 
 * @author Tobias
 *
 */
public class FormulaPattern extends IdPattern implements IPattern {

	private static final String ID_STATEMENT_TEXT = "statementNameText";
	private static final String ID_NAME_TEXT = "nameText";
	private static final String ID_PRE_TEXT = "preConditionText";
	private static final String ID_POST_TEXT = "postConditionText";
	private static final String ID_MAIN_RECTANGLE = "mainRectangle";
	private static final String ID_IMAGE_PROVEN = "imageproven";
	// Header:
	private static final String ID_PRE_HEADER = "preHeader";
	private static final String ID_ST_HEADER = "stHeader";
	private static final String ID_POST_HEADER = "postHeader";
	// lines:
	private static final String ID_HOR1_LINE = "hor1Line";
	private static final String ID_HOR2_LINE = "hor2Line";
	private static final String ID_VER1_LINE = "ver1Line";
	private static final String ID_VER2_LINE = "ver2Line";

	/**
	 * Constructor of the class
	 */
	public FormulaPattern() {
		super();
	}

	@Override
	public String getCreateName() {
		return "Formula";
	}

	@Override
	public String getCreateDescription() {
		return "Create a Formula.";
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof CbCFormula;
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		CbCFormula formula = null;
		for (Shape shape : getDiagram().getChildren()) {
			Object obj = getBusinessObjectForPictogramElement(shape);
			if (obj instanceof CbCFormula) {
				formula = (CbCFormula) obj;
			}
		}
		if (formula != null)
			return false;
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) {
		CbCFormula formula = CbcmodelFactory.eINSTANCE.createCbCFormula();
		formula.setName(getDiagram().getName());
		AbstractStatement statement = CbcmodelFactory.eINSTANCE.createAbstractStatement();
		statement.setName("statement");
		formula.setStatement(statement);
		Condition preCondition = new ConditionExtension("pre");
		statement.setPreCondition(preCondition);
		Condition postCondition = new ConditionExtension("post");
		statement.setPostCondition(postCondition);

		// Use the following instead of the above line to store the model
		// data in a seperate file parallel to the diagram file
		try {
			CbcModelUtil.saveFormulaToModelFile(formula, getDiagram());
		} catch (CoreException | IOException e) {
			e.printStackTrace();
		}

		addGraphicalRepresentation(context, formula);
		return new Object[] { formula };
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public PictogramElement doAdd(IAddContext context) {
		manageColor(IColorConstant.DARK_GREEN);
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		CbCFormula addedFormula = (CbCFormula) context.getNewObject();
		ConditionExtension pre = new ConditionExtension(addedFormula.getStatement().getPreCondition());
		ConditionExtension post = new ConditionExtension(addedFormula.getStatement().getPostCondition());
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		int width = context.getWidth() <= 0 ? 300 : context.getWidth();
		int height = context.getHeight() <= 0 ? 150 : context.getHeight();
		// header font:
		Font headerFont = gaService.manageFont(getDiagram(), "Arial", 9, false, true);

		// Main contents area
		ContainerShape outerContainerShape = peCreateService.createContainerShape(targetDiagram, true);
		RoundedRectangle mainRectangle = gaService.createRoundedRectangle(outerContainerShape, 20, 20);
		mainRectangle.setFilled(true);
		gaService.setRenderingStyle(mainRectangle, PredefinedColoredAreas.getBlueWhiteAdaptions());
		mainRectangle.setForeground(manageColor(IColorConstant.RED));
		mainRectangle.setLineWidth(2);
		setId(mainRectangle, ID_MAIN_RECTANGLE);
		gaService.setLocationAndSize(mainRectangle, context.getX(), context.getY(), width, height);

		// create link and wire it
		link(outerContainerShape, addedFormula);

		// Statement name
		Shape textShapePreCondition = peCreateService.createShape(outerContainerShape, true);
		MultiText preConditionText = gaService.createMultiText(textShapePreCondition, "");
		setId(preConditionText, ID_PRE_TEXT);
		preConditionText.setValue("{" +pre.stringRepresentation + "}");
		preConditionText.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		preConditionText.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);

		Shape textShapeStatement = peCreateService.createShape(outerContainerShape, true);
		MultiText statementText = gaService.createMultiText(textShapeStatement, "");
		setId(statementText, ID_STATEMENT_TEXT);
		statementText.setValue(addedFormula.getStatement().getName());
		statementText.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		statementText.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);

		Shape textShapePostCondition = peCreateService.createShape(outerContainerShape, true);
		MultiText postConditionText = gaService.createMultiText(textShapePostCondition, "");
		postConditionText.setValue("{" + post.stringRepresentation + "}");
		setId(postConditionText, ID_POST_TEXT);
		postConditionText.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		postConditionText.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);

		Shape textShapeName = peCreateService.createShape(outerContainerShape, false);
		MultiText nameText = gaService.createMultiText(textShapeName, "Formula");
		setId(nameText, ID_NAME_TEXT);
		nameText.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		nameText.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		nameText.setFont(headerFont);

		Shape proveShape = peCreateService.createShape(outerContainerShape, false);
		Image image = gaService.createImage(proveShape, CbCImageProvider.IMG_UNPROVEN);
		setId(image, ID_IMAGE_PROVEN);

		// Header:
		Shape preHeaderShape = peCreateService.createShape(outerContainerShape, false);
		Text preHeader = gaService.createText(preHeaderShape, "precondition");
		setId(preHeader, ID_PRE_HEADER);
		preHeader.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		preHeader.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		preHeader.setFont(headerFont);

		Shape postHeaderShape = peCreateService.createShape(outerContainerShape, false);
		Text postHeader = gaService.createText(postHeaderShape, "postcondition");
		setId(postHeader, ID_POST_HEADER);
		postHeader.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		postHeader.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		postHeader.setFont(headerFont);

		Shape stHeaderShape = peCreateService.createShape(outerContainerShape, false);
		Text stHeader = gaService.createText(stHeaderShape, "statement");
		setId(stHeader, ID_ST_HEADER);
		stHeader.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		stHeader.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		stHeader.setFont(headerFont);
		// lines:
		Shape hor1LineShape = peCreateService.createShape(outerContainerShape, false);
		Polyline hor1Polyline = gaService.createPolyline(hor1LineShape);
		setId(hor1Polyline, ID_HOR1_LINE);

		Shape hor2LineShape = peCreateService.createShape(outerContainerShape, false);
		Polyline hor2Polyline = gaService.createPolyline(hor2LineShape);
		setId(hor2Polyline, ID_HOR2_LINE);

		Shape ver1LineShape = peCreateService.createShape(outerContainerShape, false);
		Polyline ver1Polyline = gaService.createPolyline(ver1LineShape);
		setId(ver1Polyline, ID_VER1_LINE);

		Shape ver2LineShape = peCreateService.createShape(outerContainerShape, false);
		Polyline ver2Polyline = gaService.createPolyline(ver2LineShape);
		setId(ver2Polyline, ID_VER2_LINE);

		peCreateService.createChopboxAnchor(textShapeStatement);

		link(outerContainerShape, addedFormula);
		link(getDiagram(), addedFormula);
		link(textShapePreCondition, pre);
		link(textShapeStatement, addedFormula.getStatement());
		link(textShapePostCondition, post);
		link(proveShape, addedFormula);

		return outerContainerShape;
	}

	@Override
	protected boolean layout(IdLayoutContext context, String id) {
		boolean changesDone = false;

		GraphicsAlgorithm mainRectangle = context.getRootPictogramElement().getGraphicsAlgorithm();
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		int third = mainRectangle.getWidth() / 3;
		// stable sizes from Name and Header save space when the diagram gets big!
		int sizeName = 30; // size from Formular block
		int sizeHeader = 20; // size from the Header
		int positionHeader = 40; // position where the Header is
		int sizeText = mainRectangle.getHeight() - positionHeader - sizeHeader; // size from the blocks (pre, statement,
																				// post)
		int positionText = positionHeader + sizeHeader; // position from the blocks (pre, statement, post)

		if (id.equals(ID_NAME_TEXT)) {
			Graphiti.getGaService().setLocationAndSize(ga, 0, 5, mainRectangle.getWidth(), sizeName);
			changesDone = true;
		} else if (id.equals(ID_PRE_TEXT)) {
			Graphiti.getGaService().setLocationAndSize(ga, 0, positionText, third, sizeText);
			changesDone = true;
		} else if (id.equals(ID_STATEMENT_TEXT)) {
			Graphiti.getGaService().setLocationAndSize(ga, third, positionText, third, sizeText);
			changesDone = true;
		} else if (id.equals(ID_POST_TEXT)) {
			Graphiti.getGaService().setLocationAndSize(ga, third * 2, positionText, third, sizeText);
			changesDone = true;
		} else if (id.equals(ID_IMAGE_PROVEN)) {
			Graphiti.getGaService().setLocationAndSize(ga, mainRectangle.getWidth() - 20, 10, 10, 10);
			changesDone = true;
		} else if (id.equals(ID_PRE_HEADER)) {
			Graphiti.getGaService().setLocationAndSize(ga, 0, positionHeader, third, sizeHeader);
			changesDone = true;
		} else if (id.equals(ID_ST_HEADER)) {
			Graphiti.getGaService().setLocationAndSize(ga, third, positionHeader, third, sizeHeader);
			changesDone = true;
		} else if (id.equals(ID_POST_HEADER)) {
			Graphiti.getGaService().setLocationAndSize(ga, third * 2, positionHeader, third, sizeHeader);
			changesDone = true;
		} else if (id.equals(ID_HOR1_LINE)) {
			Polyline polyline = (Polyline) ga;
			polyline.getPoints().clear();
			List<Point> pointList = Graphiti.getGaService()
					.createPointList(new int[] { 0, positionHeader, mainRectangle.getWidth(), positionHeader });
			polyline.getPoints().addAll(pointList);
			changesDone = true;
		} else if (id.equals(ID_HOR2_LINE)) {
			Polyline polyline = (Polyline) ga;
			polyline.getPoints().clear();
			List<Point> pointList = Graphiti.getGaService().createPointList(new int[] { 0, positionHeader + sizeHeader,
					mainRectangle.getWidth(), positionHeader + sizeHeader });
			polyline.getPoints().addAll(pointList);
			changesDone = true;
		} else if (id.equals(ID_VER1_LINE)) {
			Polyline polyline = (Polyline) ga;
			polyline.getPoints().clear();
			List<Point> pointList = Graphiti.getGaService()
					.createPointList(new int[] { third, positionHeader, third, mainRectangle.getHeight() });
			polyline.getPoints().addAll(pointList);
			changesDone = true;
		} else if (id.equals(ID_VER2_LINE)) {
			Polyline polyline = (Polyline) ga;
			polyline.getPoints().clear();
			List<Point> pointList = Graphiti.getGaService()
					.createPointList(new int[] { third * 2, positionHeader, third * 2, mainRectangle.getHeight() });
			polyline.getPoints().addAll(pointList);
			changesDone = true;
		}

		return changesDone;
	}

	@Override
	protected IReason updateNeeded(IdUpdateContext context, String id) {
		if (id.equals(ID_MAIN_RECTANGLE)) {
			RoundedRectangle rectangle = (RoundedRectangle) context.getGraphicsAlgorithm();
			CbCFormula domainObject = (CbCFormula) context.getDomainObject();
			AbstractStatement statement = domainObject.getStatement();
			AbstractStatement statementToCheck = null;
			if (statement.getRefinement() != null) {
				statementToCheck = statement.getRefinement();
			} else {
				statementToCheck = statement;
			}
			if (statementToCheck.isProven() && ((rectangle.getForeground() != null
					&& !rectangle.getForeground().equals(manageColor(IColorConstant.DARK_GREEN)))
					|| rectangle.getForeground() == null)) {
				return Reason.createTrueReason("Statement is proven. Expected green color.");
			} else if (!statementToCheck.isProven() && ((rectangle.getForeground() != null
					&& rectangle.getForeground().equals(manageColor(IColorConstant.DARK_GREEN)))
					|| rectangle.getForeground() == null)) {
				return Reason.createTrueReason("Statement is not proven. Expected red color.");
			}
		} else if (id.equals(ID_IMAGE_PROVEN)) {
			CbCFormula domainObject = (CbCFormula) context.getDomainObject();
			AbstractStatement statement = domainObject.getStatement();
			AbstractStatement statementToCheck = null;
			if (statement.getRefinement() != null) {
				statementToCheck = statement.getRefinement();
			} else {
				statementToCheck = statement;
			}
			Image image = (Image) context.getGraphicsAlgorithm();
			if (statementToCheck.isProven() && image.getId().equals(CbCImageProvider.IMG_UNPROVEN)) {
				return Reason.createTrueReason("Statement is proven. Expected green color.");
			} else if (!statementToCheck.isProven() && image.getId().equals(CbCImageProvider.IMG_PROVEN)) {
				return Reason.createTrueReason("Statement is not proven. Expected red color.");
			}
		}

		return Reason.createFalseReason();
	}

	@Override
	protected boolean update(IdUpdateContext context, String id) {
		if (id.equals(ID_MAIN_RECTANGLE)) {
			RoundedRectangle rectangle = (RoundedRectangle) context.getGraphicsAlgorithm();
			CbCFormula domainObject = (CbCFormula) context.getDomainObject();
			AbstractStatement statement = domainObject.getStatement();
			AbstractStatement statementToCheck = null;
			if (statement.getRefinement() != null) {
				statementToCheck = statement.getRefinement();
			} else {
				statementToCheck = statement;
			}
			if (statementToCheck.isProven()) {
				domainObject.setProven(true);
				rectangle.setForeground(manageColor(IColorConstant.DARK_GREEN));
			} else {
				domainObject.setProven(false);
				rectangle.setForeground(manageColor(IColorConstant.RED));
			}
			return true;
		} else if (id.equals(ID_IMAGE_PROVEN)) {
			CbCFormula domainObject = (CbCFormula) context.getDomainObject();
			Image image = (Image) context.getGraphicsAlgorithm();
			AbstractStatement statement = domainObject.getStatement();
			AbstractStatement statementToCheck = null;
			if (statement.getRefinement() != null) {
				statementToCheck = statement.getRefinement();
			} else {
				statementToCheck = statement;
			}
			if (statementToCheck.isProven()) {
				image.setId(CbCImageProvider.IMG_PROVEN);
			} else {
				image.setId(CbCImageProvider.IMG_UNPROVEN);
			}
		}

		return false;
	}

	
}
