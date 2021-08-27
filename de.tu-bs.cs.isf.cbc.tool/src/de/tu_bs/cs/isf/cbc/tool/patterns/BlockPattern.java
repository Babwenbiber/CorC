package de.tu_bs.cs.isf.cbc.tool.patterns;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
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
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.util.IColorConstant;
import org.eclipse.graphiti.util.PredefinedColoredAreas;

import de.tu_bs.cs.isf.cbc.cbcmodel.BlockStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbcmodelFactory;
import de.tu_bs.cs.isf.cbc.cbcmodel.Condition;
import de.tu_bs.cs.isf.cbc.cbcmodel.JMLAnnotation;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.JavaVariables;
import de.tu_bs.cs.isf.cbc.cbcmodel.SelectionStatement;
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.JMLExpressionExtension;
import de.tu_bs.cs.isf.cbc.tool.diagram.CbCImageProvider;
import de.tu_bs.cs.isf.cbc.tool.helper.UpdateModifiableOfConditions;
import de.tu_bs.cs.isf.cbc.util.FileUtil;
import de.tu_bs.cs.isf.toolkit.support.compare.CompareMethodBodies;

/**
 * Class that creates the graphical representation of Conditions
 * 
 * @author Tobias
 *
 */
public class BlockPattern extends IdPattern implements IPattern {

	private static final String ID_NAME_TEXT = "statementText";
	private static final String ID_PRE_TEXT = "preText";
	private static final String ID_POST_TEXT = "postText";
	private static final String ID_PRE_BLOCK_TEXT = "preBlockText";
	private static final String ID_POST_BLOCK_TEXT = "postBlockText";
	private static final String ID_MAIN_RECTANGLE = "mainRectangle";
	private static final String ID_IMAGE_PROVEN = "imageproven";
	// Headers:
	private static final String ID_PRE_HEADER = "preHeader";
	private static final String ID_POST_HEADER = "postHeader";
	private static final String ID_NAME_HEADER = "statementHeader";
	private static final String ID_PRE_BLOCK_HEADER = "preBlockHeader";
	private static final String ID_POST_BLOCK_HEADER = "postBlockHeader";
	// Separating lines:
	private static final String ID_HEADER_SEPARATER = "headerSeparater";
	private static final String ID_BLOCK_HEADER_SEPARATER = "blockHeaderSeparater";
	private static final String ID_STATEMENT_HEADER_SEPARATOR = "statementHeaderSeparater";
	private static final String ID_CONDITION_SEP = "conditionSep";
	private static final String ID_BLOCK_CONDITION_SEPARATOR = "blockConditionSeparater";
	private static final String ID_STATEMENT_BLOCK_SEPARATOR = "statementBlockSeparater";

	/**
	 * Constructor of the class
	 */
	public BlockPattern() {
		super();
	}

	@Override
	public String getCreateName() {
		return "Block";
	}

	@Override
	public String getCreateDescription() {
		return "Create a Block-Statement.";
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof BlockStatement;
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public Object[] create(ICreateContext context) {
		BlockStatement statement = CbcmodelFactory.eINSTANCE.createBlockStatement();
		statement.setName("Block-Statement");
		Condition pre = CbcmodelFactory.eINSTANCE.createCondition();
		pre.setName("");
		statement.setPreCondition(pre);
		Condition post = CbcmodelFactory.eINSTANCE.createCondition();
		post.setName("");
		statement.setPostCondition(post);
		JMLExpressionExtension requires = new JMLExpressionExtension(CbcmodelFactory.eINSTANCE.createJMLAnnotation().getRequires());
		requires.stringRepresentation = "i=1";
		JMLExpressionExtension ensures = new JMLExpressionExtension(CbcmodelFactory.eINSTANCE.createJMLAnnotation().getEnsures());
		ensures.stringRepresentation = "i=3";
		JMLAnnotation annotation = CbcmodelFactory.eINSTANCE.createJMLAnnotation();
		annotation.setRequires(requires);
		annotation.setEnsures(ensures);
		statement.setJmlAnnotation(annotation);

		addGraphicalRepresentation(context, statement);
		return new Object[] { statement };
	}

	@Override
	public boolean canAdd(IAddContext context) {
		return super.canAdd(context) && context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public PictogramElement doAdd(IAddContext context) {
		manageColor(IColorConstant.DARK_GREEN);

		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		BlockStatement addedStatement = (BlockStatement) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		int width = context.getWidth() <= 0 ? 300 : context.getWidth();
		int height = context.getHeight() <= 0 ? 300 : context.getHeight();
		// Font:

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
		link(outerContainerShape, addedStatement);

		// Statement name
		Shape textShape = setContent(ID_NAME_TEXT, addedStatement.getName(),
				true, outerContainerShape, peCreateService, gaService);
		Shape preShape = setContent(ID_PRE_TEXT, "{" + addedStatement.getPreCondition().getName() + "}", 
				false, outerContainerShape, peCreateService, gaService);
		Shape postShape = setContent(ID_POST_TEXT, "{" + addedStatement.getPostCondition().getName() + "}",
				false, outerContainerShape, peCreateService, gaService);
		Shape preBlockShape = setContent(ID_PRE_BLOCK_TEXT, "{" + ((JMLExpressionExtension)addedStatement.getJmlAnnotation().getRequires()).stringRepresentation + "}", 
				true, outerContainerShape, peCreateService, gaService);
		Shape postBlockShape = setContent(ID_POST_BLOCK_TEXT, "{" +  ((JMLExpressionExtension)addedStatement.getJmlAnnotation().getEnsures()).stringRepresentation + "}", 
				true, outerContainerShape, peCreateService, gaService);

		Shape proveShape = peCreateService.createShape(outerContainerShape, false);
		Image image = gaService.createImage(proveShape, CbCImageProvider.IMG_UNPROVEN);
		setId(image, ID_IMAGE_PROVEN);

		setHeader(ID_NAME_HEADER, "statement", outerContainerShape, peCreateService, gaService);
		setHeader(ID_PRE_HEADER, "precondition", outerContainerShape, peCreateService, gaService);
		setHeader(ID_POST_HEADER, "postcondition", outerContainerShape, peCreateService, gaService);
		setHeader(ID_PRE_BLOCK_HEADER, "requires", outerContainerShape, peCreateService, gaService);
		setHeader(ID_POST_BLOCK_HEADER, "ensures", outerContainerShape, peCreateService, gaService);
		
		createSeperator(ID_HEADER_SEPARATER, outerContainerShape, peCreateService, gaService);
		createSeperator(ID_BLOCK_HEADER_SEPARATER, outerContainerShape, peCreateService, gaService);
		createSeperator(ID_STATEMENT_HEADER_SEPARATOR, outerContainerShape, peCreateService, gaService);
		createSeperator(ID_CONDITION_SEP, outerContainerShape, peCreateService, gaService);
		createSeperator(ID_BLOCK_CONDITION_SEPARATOR, outerContainerShape, peCreateService, gaService);
		createSeperator(ID_STATEMENT_BLOCK_SEPARATOR, outerContainerShape, peCreateService, gaService);

		peCreateService.createChopboxAnchor(outerContainerShape);
		peCreateService.createChopboxAnchor(textShape);
		peCreateService.createChopboxAnchor(preBlockShape);
		peCreateService.createChopboxAnchor(postBlockShape);

		link(outerContainerShape, addedStatement);
		link(textShape, addedStatement);
		link(preShape, addedStatement.getPreCondition());
		link(postShape, addedStatement.getPostCondition());
		link(preBlockShape, addedStatement.getJmlAnnotation().getRequires());
		link(postBlockShape, addedStatement.getJmlAnnotation().getEnsures());
		link(proveShape, addedStatement);

		return outerContainerShape;
	}

	private Shape setContent(String name, String text, boolean active, ContainerShape outerContainerShape, IPeCreateService peCreateService, IGaService gaService) {
		Shape shape = peCreateService.createShape(outerContainerShape, active);
		MultiText multiText = gaService.createMultiText(shape, text);
		setId(multiText, name);
		multiText.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		multiText.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		return shape;
	}
	
	private void setHeader(String name, String text, ContainerShape outerContainerShape, IPeCreateService peCreateService, IGaService gaService) {
		Font headerFont = gaService.manageFont(getDiagram(), "Arial", 9, false, true);
		Shape textHeader = peCreateService.createShape(outerContainerShape, false);
		Text statementNameHeader = gaService.createText(textHeader, text);
		setId(statementNameHeader, name);
		statementNameHeader.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		statementNameHeader.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);
		statementNameHeader.setFont(headerFont);
	}
	
	private void createSeperator(String name, ContainerShape outerContainerShape, IPeCreateService peCreateService, IGaService gaService) {
		Shape statementHeaderSepShape = peCreateService.createShape(outerContainerShape, false);
		Polyline polyLine = gaService.createPolyline(statementHeaderSepShape);
		setId(polyLine, name);
	}
	
	@Override
	protected boolean layout(IdLayoutContext context, String id) {


		if (id.equals(ID_NAME_TEXT)) {
			return setLocationAndSize(context, 0.0, 2.0/3+0.1, 1.0, 1.0);
		} else if (id.equals(ID_PRE_TEXT)) {
			return setLocationAndSize(context, 0.0, 0.1, 1.0/2, 1.0/3);
		} else if (id.equals(ID_POST_TEXT)) {
			return setLocationAndSize(context, 1.0/2, 0.1, 1.0, 1.0/3);
		} else if (id.equals(ID_PRE_BLOCK_TEXT)) {
			return setLocationAndSize(context, 0.0, 1.0/3+0.1, 1.0/2, 2.0/3);
		} else if (id.equals(ID_POST_BLOCK_TEXT)) {
			return setLocationAndSize(context, 1.0/2, 1.0/3+0.1, 1.0, 2.0/3);
		} else if (id.equals(ID_IMAGE_PROVEN)) {
			return setLocationAndSize(context, 0.9, 0.02, 0.95, 0.08);
			// Header:
		} else if (id.equals(ID_NAME_HEADER)) {
			return setLocationAndSize(context, 0, 2.0/3+0.05, 1, 2.0/3+0.1);
		} else if (id.equals(ID_PRE_HEADER)) {
			return setLocationAndSize(context, 0, 0.05, 0.5, 0.1);
		} else if (id.equals(ID_POST_HEADER)) {
			return setLocationAndSize(context, 0.5, 0.05, 1, 0.1);
		} else if (id.equals(ID_PRE_BLOCK_HEADER)) {
			return setLocationAndSize(context, 0, 1.0/3+0.05, 0.5, 1.0/3+0.1);
		} else if (id.equals(ID_POST_BLOCK_HEADER)) {
			return setLocationAndSize(context, 0.5, 1.0/3+0.05, 1, 1.0/3+0.1);
			// LINES:
		} else if (id.equals(ID_HEADER_SEPARATER)) {
			return drawLine(context, 0, 0.1, 1, 0.1);
		} else if (id.equals(ID_BLOCK_HEADER_SEPARATER)) {
			return drawLine(context, 0, 1.0/3+0.1, 1, 1.0/3+0.1);
		} else if (id.equals(ID_STATEMENT_HEADER_SEPARATOR)) {
			return drawLine(context, 0, 2.0/3+0.1, 1, 2.0/3+0.1);
		} else if (id.equals(ID_CONDITION_SEP)) {
			return drawLine(context, 0.5, 0, 0.5, 2.0/3);
		} else if (id.equals(ID_BLOCK_CONDITION_SEPARATOR)) {
			return drawLine(context, 0, 1.0/3, 1, 1.0/3);
		} else if (id.equals(ID_STATEMENT_BLOCK_SEPARATOR)) {
			return drawLine(context, 0, 2.0/3, 1, 2.0/3);
		}
		
		return false;
	}

	private boolean drawLine(IdLayoutContext context, double startX, double startY, double endX, double endY) {
		GraphicsAlgorithm mainRectangle = context.getRootPictogramElement().getGraphicsAlgorithm();
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		Polyline polyline = (Polyline) ga;
		double width = mainRectangle.getWidth();
		double height= (mainRectangle.getHeight());
		polyline.getPoints().clear();
		List<Point> pointList = Graphiti.getGaService()
				.createPointList(new int[] { (int)(startX*width), (int)(startY*height),
						(int)(endX*width), (int)(endY*height) });
		polyline.getPoints().addAll(pointList);
		return true;
	}
	
	private boolean setLocationAndSize(IdLayoutContext context, double startX, double startY, double endX, double endY) {
		GraphicsAlgorithm mainRectangle = context.getRootPictogramElement().getGraphicsAlgorithm();
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		double width = mainRectangle.getWidth();
		double height= (mainRectangle.getHeight());
		int itemWidth = (int)((endX-startX)*width);
		int itemHeight= (int)((endY-startY)*height);
		Graphiti.getGaService().setLocationAndSize(ga, (int)(startX*width), (int)(startY*height), itemWidth, itemHeight);
		return true;
	}
	
	@Override
	protected IReason updateNeeded(IdUpdateContext context, String id) {
		if (context.getGraphicsAlgorithm() instanceof MultiText &&
				(context.getDomainObject() instanceof BlockStatement || context.getDomainObject() instanceof Condition)) {
//			MultiText nameText = (MultiText) context.getGraphicsAlgorithm();
//			String newText = "";
//			if (context.getDomainObject() instanceof Condition) {
//				newText = ((Condition)context.getDomainObject()).getName();
//			}
//			BlockStatement domainObject = (BlockStatement) context.getDomainObject();
//			if (id.equals(ID_NAME_TEXT)) {
//				newText = domainObject.getJavaStatement().getName();
//			} else if (id.equals(ID_PRE_BLOCK_TEXT)) {
//				newText = domainObject.getJmlAnnotation().getRequires().getName();
//			} else if (id.equals(ID_POST_BLOCK_TEXT)) {
//				newText = domainObject.getJmlAnnotation().getEnsures().getName();
//			} else {
//				return Reason.createFalseReason();
//			}
//			if (newText == null || !newText.equals(nameText.getValue())) {
//				return Reason.createTrueReason("Name differs. Expected: '" + newText + "'");
//			} 
		} else if (id.equals(ID_MAIN_RECTANGLE)) {
			RoundedRectangle rectangle = (RoundedRectangle) context.getGraphicsAlgorithm();
			BlockStatement domainObject = (BlockStatement) context.getDomainObject();
			if (domainObject.isProven() && ((rectangle.getForeground() != null
					&& !rectangle.getForeground().equals(manageColor(IColorConstant.DARK_GREEN)))
					|| rectangle.getForeground() == null)) {
				return Reason.createTrueReason("Statement is proven. Expected green color.");
			} else if (!domainObject.isProven() && ((rectangle.getForeground() != null
					&& rectangle.getForeground().equals(manageColor(IColorConstant.DARK_GREEN)))
					|| rectangle.getForeground() == null)) {
				return Reason.createTrueReason("Statement is not proven. Expected red color.");
			}
		} else if (id.equals(ID_IMAGE_PROVEN)) {
			BlockStatement domainObject = (BlockStatement) context.getDomainObject();
			Image image = (Image) context.getGraphicsAlgorithm();
			if (domainObject.isProven() && image.getId().equals(CbCImageProvider.IMG_UNPROVEN)) {
				return Reason.createTrueReason("Statement is proven. Expected green color.");
			} else if (!domainObject.isProven() && image.getId().equals(CbCImageProvider.IMG_PROVEN)) {
				return Reason.createTrueReason("Statement is not proven. Expected red color.");
			}
		}

		return Reason.createFalseReason();
	}

	@Override
	protected boolean update(IdUpdateContext context, String id) {
		if (context.getGraphicsAlgorithm() instanceof MultiText &&
				context.getDomainObject() != null) {
			MultiText nameText = (MultiText) context.getGraphicsAlgorithm();
			
			String newText = "";
			if (id.equals(ID_NAME_TEXT)) {
				BlockStatement domainObject = (BlockStatement) context.getDomainObject();
				newText = domainObject.getName();
			} else if (id.equals(ID_PRE_TEXT) || id.equals(ID_POST_TEXT)) {
				Condition domainObject = (Condition) context.getDomainObject();
				newText = "{" + domainObject.getName() + "}";
			} else if (id.equals(ID_PRE_BLOCK_TEXT) || id.equals(ID_POST_BLOCK_TEXT)) {
				JMLExpressionExtension domainObject = (JMLExpressionExtension) context.getDomainObject();
				newText = "{" + domainObject.stringRepresentation + "}";
			} else {
				return false;
			}
			nameText.setValue(newText);
			return true;	
		} else if (id.equals(ID_MAIN_RECTANGLE)) {
			RoundedRectangle rectangle = (RoundedRectangle) context.getGraphicsAlgorithm();
			BlockStatement domainObject = (BlockStatement) context.getDomainObject();
			if (domainObject.isProven()) {
				rectangle.setForeground(manageColor(IColorConstant.DARK_GREEN));
				if (domainObject.getParent() != null) {
					IPeService pe = Graphiti.getPeService();
					EObject[] objArray = { domainObject.getParent() };
					Object[] obj = pe.getLinkedPictogramElements(objArray, getDiagram());
					Shape pElement = (Shape) obj[0];
					if (pElement.getContainer() != null)
						updatePictogramElement(pElement.getContainer());
				}
			} else {
				rectangle.setForeground(manageColor(IColorConstant.RED));
				if (domainObject.getParent() != null) {
					IPeService pe = Graphiti.getPeService();
					EObject[] objArray = { domainObject.getParent() };
					Object[] obj = pe.getLinkedPictogramElements(objArray, getDiagram());
					if (obj.length > 0) {
						Shape pElement = (Shape) obj[0];
						if (pElement.getContainer() != null)
							updatePictogramElement(pElement.getContainer());
					}
				}
			}
			return true;
		} else if (id.equals(ID_IMAGE_PROVEN)) {
			BlockStatement domainObject = (BlockStatement) context.getDomainObject();
			Image image = (Image) context.getGraphicsAlgorithm();
			if (domainObject.isProven()) {
				image.setId(CbCImageProvider.IMG_PROVEN);
			} else {
				image.setId(CbCImageProvider.IMG_UNPROVEN);
			}
		}
		return false;
	}	

	public void squareTwoNumbers(Integer i, Integer j) {
		i = i*i;
		j = j*j;		
	}
	
	@Override
	public int getEditingType() {
		return TYPE_MULTILINETEXT;
	}
	
	@Override
	public boolean canDirectEdit(IDirectEditingContext context) {
		Object domainObject = getBusinessObjectForPictogramElement(context.getPictogramElement());
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
		if (domainObject instanceof BlockStatement && ga instanceof MultiText) {
			return true;
		}
		return false;
	}

	@Override
	public String getInitialValue(IDirectEditingContext context) {
		BlockStatement statement = (BlockStatement) getBusinessObjectForPictogramElement(
				context.getPictogramElement());
		return System.getProperty("line.separator") + statement.getName() + System.getProperty("line.separator");
	}

	@Override
	public String checkValueValid(String value, IDirectEditingContext context) {
		if (value == null || value.length() == 0) {
			return "Statement must not be empty";
		}
		if (value.contains(";") && !CompareMethodBodies.readAndTestMethodBodyWithJaMoPP2(value)) {
			return "Statement has not the correct syntax.";
		}
		return null;
	}

	@Override
	public void setValue(String value, IDirectEditingContext context) {
		BlockStatement statement = (BlockStatement) getBusinessObjectForPictogramElement(
				context.getPictogramElement());
		statement.setName(value.trim());
		statement.setProven(false);
		JavaVariables vars = null;
		for (Shape shape : getDiagram().getChildren()) {
			Object obj = getBusinessObjectForPictogramElement(shape);
			if (obj instanceof JavaVariables) {
				vars = (JavaVariables) obj;
			}
		}
		UpdateModifiableOfConditions.setVars(vars);
		FileUtil.setApplicationUri(getDiagram().eResource().getURI());
		UpdateModifiableOfConditions.updateAssignmentStatement(statement);
		updatePictogramElement(context.getPictogramElement());
	}
}
