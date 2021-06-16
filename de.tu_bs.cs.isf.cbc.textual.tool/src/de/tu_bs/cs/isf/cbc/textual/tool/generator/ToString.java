package de.tu_bs.cs.isf.cbc.textual.tool.generator;

import org.eclipse.emf.ecore.EObject;  
import org.eclipse.xtext.parsetree.reconstr.Serializer;  
import com.google.inject.Guice;

import de.tu_bs.cs.isf.cbc.textual.tool.CustomDslRunTimeModule;  
  
public class ToString {  
 private static Serializer SERIALIZER = null;  
  
 private static Serializer getSerializer() {  
  if (SERIALIZER == null) { // lazy creation  
   SERIALIZER = Guice.createInjector(new CustomDslRunTimeModule())  
        .getInstance(Serializer.class);  
  }  
  return SERIALIZER;  
 }  
  
 public static String valueOf(EObject eobj) {  
  if (eobj==null) {  
   return "null";  
  }  
  try {  
   return getSerializer().serialize(eobj);  
  } catch (Exception ex) { // fall back:  
   return eobj.getClass().getSimpleName()+'@'+eobj.hashCode();  
  }  
 }  
  
}  