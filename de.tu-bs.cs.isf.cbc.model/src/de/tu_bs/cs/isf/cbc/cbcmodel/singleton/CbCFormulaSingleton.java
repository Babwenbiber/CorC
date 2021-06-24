package de.tu_bs.cs.isf.cbc.cbcmodel.singleton;
import de.tu_bs.cs.isf.cbc.cbcmodel.CbCFormula;

public class CbCFormulaSingleton {

	 private CbCFormula formula;
	 private static final CbCFormulaSingleton OBJ = new CbCFormulaSingleton(); 
     
     private CbCFormulaSingleton() { 
         System.out.println("building CbCFormula Instance..."); 
     } 
          
//     public static CbCFormulaSingleton getInstance() { 
//       return OBJ; 
//     } 
     
     public static void init(CbCFormula formula) {
    	 OBJ.formula = formula;
     }
     
     public static CbCFormula getCbCFormula() {
    	 return OBJ.formula;
     }
}
