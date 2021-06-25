package de.tu_bs.cs.isf.cbc.cbcmodel.singleton;

import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;
import de.tu_bs.cs.isf.cbc.cbcmodel.string_saver.CbCFormulaExtension;

public class CbCFormulaSingleton {

	 private CbCFormulaExtension formula;
	 private static final CbCFormulaSingleton OBJ = new CbCFormulaSingleton(); 
     
     private CbCFormulaSingleton() { 
         System.out.println("building CbCFormula Instance..."); 
     } 
          
//     public static CbCFormulaSingleton getInstance() { 
//       return OBJ; 
//     } 
     
     public static void init(CbCFormula formula) {
    	 OBJ.formula = new CbCFormulaExtension(formula);
     }
     
     public static CbCFormulaExtension getCbCFormula() {
    	 return OBJ.formula;
     }
}
