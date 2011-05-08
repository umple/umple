package cruise.ui.jsf.templates.impl.fragment.get;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.Attribute;
import cruise.ui.jsf.*;;

public class DefaultedTimeGet implements IGenerator {

  protected static String nl;
  public static synchronized DefaultedTimeGet create(String lineSeparator)
  {
    nl = lineSeparator;
    DefaultedTimeGet result = new DefaultedTimeGet();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t" + NL + "\t\tpublic ";
  protected final String TEXT_2 = " get";
  protected final String TEXT_3 = "() {" + NL + "\t\t\treturn ";
  protected final String TEXT_4 = ".components.bean.TimeBean.getSqlTime(";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ");" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic int get";
  protected final String TEXT_7 = "() {" + NL + "\t\t\treturn ";
  protected final String TEXT_8 = ";" + NL + "\t\t}" + NL + "\t\tpublic int get";
  protected final String TEXT_9 = "() {" + NL + "\t\t\treturn ";
  protected final String TEXT_10 = ";" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic int getDefaulted";
  protected final String TEXT_11 = "Minute() {" + NL + "\t\t\t\treturn getInitial";
  protected final String TEXT_12 = "Minute();" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic int getDefaulted";
  protected final String TEXT_13 = "Hour() {" + NL + "\t\t\t\treturn getInitial";
  protected final String TEXT_14 = "Hour();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic void resetToDefaulted";
  protected final String TEXT_15 = "() {" + NL + "\t\t\t";
  protected final String TEXT_16 = " =getDefaulted";
  protected final String TEXT_17 = "Hour();" + NL + "\t\t\t";
  protected final String TEXT_18 = "=getDefaulted";
  protected final String TEXT_19 = "Minute();" + NL + "\t\t}" + NL + "\t" + NL + "\t\tpublic ";
  protected final String TEXT_20 = " getDefaulted";
  protected final String TEXT_21 = "() {" + NL + "\t\t\t\treturn getInitial";
  protected final String TEXT_22 = "();" + NL + "\t\t}\t" + NL + "\t\t" + NL + "\t\tpublic ";
  protected final String TEXT_23 = " getInitial";
  protected final String TEXT_24 = "() {" + NL + "\t\t\t";
  protected final String TEXT_25 = NL + "\t\t\ttry{" + NL + "\t\t\t \treturn java.sql.Time.valueOf( ";
  protected final String TEXT_26 = " );" + NL + "\t\t\t}catch(Exception e){" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_27 = NL + "\t\t    \treturn null;" + NL + "\t\t    ";
  protected final String TEXT_28 = NL + "\t\t}" + NL + "\t\t\t" + NL + "\t\tpublic int getInitial";
  protected final String TEXT_29 = "Minute() {" + NL + "\t\t\tTime time=getInitial";
  protected final String TEXT_30 = "();" + NL + "\t\t\tif (time!=null){" + NL + "\t\t\t\tCalendar cal=Calendar.getInstance();" + NL + "\t\t    \tcal.setTime(time);" + NL + "   \t\t\t\treturn cal.get(Calendar.MINUTE); " + NL + "\t\t      }" + NL + "\t\t    \treturn 0;" + NL + "\t\t}" + NL + "\t\t    " + NL + "\t\tpublic int getInitial";
  protected final String TEXT_31 = "Hour() {" + NL + "\t\t\tTime time=getInitial";
  protected final String TEXT_32 = "();" + NL + "\t\t\tif (time!=null){" + NL + "\t\t\t\tCalendar cal=Calendar.getInstance();" + NL + "\t\t    \tcal.setTime(time);" + NL + "   \t\t\t\treturn cal.get(Calendar.HOUR_OF_DAY);" + NL + "\t\t      }" + NL + "\t\t    \treturn 0;" + NL + "\t\t}";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
    	String preffix=JSFProvider.properties.getProperty(cruise.model.Constants.PACKAGE_PREFIX); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append( attVar.getType());
    stringBuffer.append(TEXT_2);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(preffix);
    stringBuffer.append(TEXT_4);
    stringBuffer.append( "a"+attVar.getUpperCaseName()+"Hour");
    stringBuffer.append(TEXT_5);
    stringBuffer.append( "a"+attVar.getUpperCaseName()+"Minute");
    stringBuffer.append(TEXT_6);
    stringBuffer.append( attVar.getUpperCaseName()+"Minute");
    stringBuffer.append(TEXT_7);
    stringBuffer.append("a"+ attVar.getUpperCaseName()+"Minute");
    stringBuffer.append(TEXT_8);
    stringBuffer.append( attVar.getUpperCaseName()+"Hour");
    stringBuffer.append(TEXT_9);
    stringBuffer.append("a"+ attVar.getUpperCaseName()+"Hour");
    stringBuffer.append(TEXT_10);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append("a"+ attVar.getUpperCaseName()+"Hour");
    stringBuffer.append(TEXT_16);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append("a"+ attVar.getUpperCaseName()+"Minute");
    stringBuffer.append(TEXT_18);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append( attVar.getType());
    stringBuffer.append(TEXT_20);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append( attVar.getType());
    stringBuffer.append(TEXT_23);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_24);
     if (attVar.getValue()!=null){ 
    stringBuffer.append(TEXT_25);
    stringBuffer.append( attVar.getValue() );
    stringBuffer.append(TEXT_26);
     }  else{
    stringBuffer.append(TEXT_27);
     }
    stringBuffer.append(TEXT_28);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_32);
    return stringBuffer.toString();
  }
}