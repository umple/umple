package cruise.data.impl.dao.generic;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.Attribute;
import cruise.model.abstractObjects.BackingObject;

public class KeyClass implements IGenerator {

  protected static String nl;
  public static synchronized KeyClass create(String lineSeparator)
  {
    nl = lineSeparator;
    KeyClass result = new KeyClass();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " ";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "package dao.keys.";
  protected final String TEXT_4 = ";" + NL + "" + NL + "import java.sql.Date;" + NL + "import java.sql.Time;" + NL + "" + NL + "" + NL + "public class ";
  protected final String TEXT_5 = "Key implements dao.keys.IKey{" + NL + "\t\tprivate int cachedHashCode=-1;" + NL + "\t";
  protected final String TEXT_6 = NL + "\t\tprivate ";
  protected final String TEXT_7 = " a";
  protected final String TEXT_8 = ";" + NL + "\t";
  protected final String TEXT_9 = NL + "\t";
  protected final String TEXT_10 = NL + "\tpublic ";
  protected final String TEXT_11 = "Key(";
  protected final String TEXT_12 = "){" + NL + "\t\t";
  protected final String TEXT_13 = NL + "\t\tthis.a";
  protected final String TEXT_14 = "= a";
  protected final String TEXT_15 = " ;" + NL + "\t\t";
  protected final String TEXT_16 = NL + "\t" + NL + "\t}" + NL + "\t";
  protected final String TEXT_17 = NL + "\tpublic boolean equals(Object obj)" + NL + "  \t{" + NL + "    \tif (obj == null) { return false; }" + NL + "    \tif (!getClass().equals(obj.getClass())) { return false; }" + NL + "\t    ";
  protected final String TEXT_18 = "Key compareTo = (";
  protected final String TEXT_19 = "Key)obj;" + NL + "  \t\t";
  protected final String TEXT_20 = NL + "\t\t";
  protected final String TEXT_21 = NL + "\t\t    if (";
  protected final String TEXT_22 = "!=compareTo.";
  protected final String TEXT_23 = ")" + NL + "\t    \t{" + NL + "\t     \t return false;" + NL + "\t    \t}" + NL + "\t\t";
  protected final String TEXT_24 = NL + "\t\t" + NL + "\t\tif (";
  protected final String TEXT_25 = " == null && compareTo.";
  protected final String TEXT_26 = " != null)" + NL + "\t    \t{" + NL + "\t      \treturn false;" + NL + "\t    \t}" + NL + "\t    \telse if (";
  protected final String TEXT_27 = " != null && !";
  protected final String TEXT_28 = ".equals(compareTo.";
  protected final String TEXT_29 = "))" + NL + "\t    \t{" + NL + "\t     \t return false;" + NL + "\t    \t}" + NL + "\t\t";
  protected final String TEXT_30 = NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_31 = NL + "\t\t" + NL + "    \treturn true;" + NL + "\t}" + NL + "\t" + NL + "\t" + NL + "\tpublic int hashCode()" + NL + "   \t{" + NL + "    \tif (cachedHashCode != -1)" + NL + "    \t{" + NL + "      \t\treturn cachedHashCode;" + NL + "    \t}" + NL + "   \t\tcachedHashCode = 17;" + NL + "    \t";
  protected final String TEXT_32 = NL + "\t\t";
  protected final String TEXT_33 = NL + "\t    \tcachedHashCode = cachedHashCode * 23 + (int)";
  protected final String TEXT_34 = ";" + NL + "\t\t";
  protected final String TEXT_35 = NL + "\t\t\tcachedHashCode = cachedHashCode * 23 + (";
  protected final String TEXT_36 = " ? 1 : 0);" + NL + "\t\t";
  protected final String TEXT_37 = NL + "    \tif (";
  protected final String TEXT_38 = " != null)" + NL + "    \t{" + NL + "      \t\tcachedHashCode = cachedHashCode * 23 + ";
  protected final String TEXT_39 = ".hashCode();" + NL + "    \t}\t" + NL + "    \telse" + NL + "    \t{" + NL + "      \t\tcachedHashCode = cachedHashCode * 23;" + NL + "\t    }" + NL + "    \t";
  protected final String TEXT_40 = "   \t\t" + NL + "\t    return cachedHashCode;" + NL + "  }" + NL + "\t" + NL + "\t" + NL + "\t\t";
  protected final String TEXT_41 = NL + "}";
  protected final String TEXT_42 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
     	
	BackingObject clazz =(BackingObject)argument;
	ArrayList<Attribute> keyClasses = clazz.getKeysAttributes(); 


    stringBuffer.append(TEXT_3);
    stringBuffer.append(clazz.getPackageName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_5);
     for (Attribute attVar: keyClasses) { 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(attVar.getType());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
    
	Iterator<Attribute> keyIter=keyClasses.iterator();
	String signature="";
	while (keyIter.hasNext()){
		Attribute att=keyIter.next();
		signature=signature+" "+att.getType()+" a"+ att.getUpperCaseName();
		if(keyIter.hasNext())
			signature=signature+", ";
	
	}
	

    stringBuffer.append(TEXT_10);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(signature);
    stringBuffer.append(TEXT_12);
     for (Attribute attVar: keyClasses) { 
    stringBuffer.append(TEXT_13);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(attVar.getUpperCaseName());
    stringBuffer.append(TEXT_15);
     } 
    stringBuffer.append(TEXT_16);
     if(signature.trim().length()>0){ 
    stringBuffer.append(TEXT_17);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_19);
     for (Attribute att: keyClasses) { 
    stringBuffer.append(TEXT_20);
     if ("int".equals(att.getType())|| "double".equals(att.getType()) || "boolean".equals(att.getType()) ) { 
    stringBuffer.append(TEXT_21);
    stringBuffer.append("a"+ att.getUpperCaseName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append("a"+ att.getUpperCaseName());
    stringBuffer.append(TEXT_23);
     } else { 
    stringBuffer.append(TEXT_24);
    stringBuffer.append("a"+ att.getUpperCaseName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append("a"+ att.getUpperCaseName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append("a"+ att.getUpperCaseName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append("a"+ att.getUpperCaseName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append("a"+ att.getUpperCaseName());
    stringBuffer.append(TEXT_29);
     } 
    stringBuffer.append(TEXT_30);
     } 
    stringBuffer.append(TEXT_31);
     for (Attribute att: keyClasses) { 
    stringBuffer.append(TEXT_32);
     if ("int".equals(att.getType())|| "double".equals(att.getType()) || "boolean".equals(att.getType()) ) { 
    stringBuffer.append(TEXT_33);
    stringBuffer.append("a"+ att.getUpperCaseName());
    stringBuffer.append(TEXT_34);
     } else if ("boolean".equals(att.getType()) ) { 
    stringBuffer.append(TEXT_35);
    stringBuffer.append("a"+ att.getUpperCaseName());
    stringBuffer.append(TEXT_36);
     } else{ 
    stringBuffer.append(TEXT_37);
    stringBuffer.append("a"+ att.getUpperCaseName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append("a"+ att.getUpperCaseName());
    stringBuffer.append(TEXT_39);
     } 
     } 
    stringBuffer.append(TEXT_40);
     } 
    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    return stringBuffer.toString();
  }
}