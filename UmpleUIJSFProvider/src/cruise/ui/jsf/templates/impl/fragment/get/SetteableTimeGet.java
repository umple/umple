package cruise.ui.jsf.templates.impl.fragment.get;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.Attribute;
import cruise.ui.jsf.*;;

public class SetteableTimeGet implements IGenerator {

  protected static String nl;
  public static synchronized SetteableTimeGet create(String lineSeparator)
  {
    nl = lineSeparator;
    SetteableTimeGet result = new SetteableTimeGet();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t\tpublic int get";
  protected final String TEXT_3 = "() {" + NL + "\t\t\treturn ";
  protected final String TEXT_4 = ";" + NL + "\t\t}" + NL + "\t\tpublic int get";
  protected final String TEXT_5 = "() {" + NL + "\t\t\treturn ";
  protected final String TEXT_6 = ";" + NL + "\t\t}" + NL + "\t\tpublic Time get";
  protected final String TEXT_7 = "() {" + NL + "\t\t\treturn ";
  protected final String TEXT_8 = ".components.bean.TimeBean.getSqlTime(";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ");" + NL + "\t\t}\t\t" + NL + "" + NL + "\t\tpublic ";
  protected final String TEXT_11 = " getInitial";
  protected final String TEXT_12 = "() {" + NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\ttry{" + NL + "\t\t\t \treturn java.sql.Time.valueOf( ";
  protected final String TEXT_14 = " );" + NL + "\t\t\t}catch(Exception e){" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_15 = NL + "\t\t    \treturn null;" + NL + "\t\t    ";
  protected final String TEXT_16 = NL + "\t\t}" + NL + "\t\t" + NL + "\t\tpublic int getInitial";
  protected final String TEXT_17 = "Minute() {" + NL + "\t\t\tTime time=getInitial";
  protected final String TEXT_18 = "();" + NL + "\t\t\tif (time!=null){" + NL + "\t\t\t\tCalendar cal=Calendar.getInstance();" + NL + "\t\t    \tcal.setTime(time);" + NL + "   \t\t\t\treturn cal.get(Calendar.MINUTE); " + NL + "\t\t      }" + NL + "\t\t    \treturn 0;" + NL + "\t\t}" + NL + "\t\t    " + NL + "\t\tpublic int getInitial";
  protected final String TEXT_19 = "Hour() {" + NL + "\t\t\tTime time=getInitial";
  protected final String TEXT_20 = "();" + NL + "\t\t\tif (time!=null){" + NL + "\t\t\t\tCalendar cal=Calendar.getInstance();" + NL + "\t\t    \tcal.setTime(time);" + NL + "   \t\t\t\treturn cal.get(Calendar.HOUR_OF_DAY);" + NL + "\t\t      }" + NL + "\t\t    \treturn 0;" + NL + "\t\t}" + NL + "\t\t  " + NL + "\t\t";
  protected final String TEXT_21 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Attribute attVar = (Attribute) argument; 
    stringBuffer.append(TEXT_1);
    	String preffix=JSFProvider.properties.getProperty(cruise.model.Constants.PACKAGE_PREFIX); 
    stringBuffer.append(TEXT_2);
    stringBuffer.append( attVar.getUpperCaseName()+"Minute");
    stringBuffer.append(TEXT_3);
    stringBuffer.append("a"+ attVar.getUpperCaseName()+"Minute");
    stringBuffer.append(TEXT_4);
    stringBuffer.append( attVar.getUpperCaseName()+"Hour");
    stringBuffer.append(TEXT_5);
    stringBuffer.append("a"+ attVar.getUpperCaseName()+"Hour");
    stringBuffer.append(TEXT_6);
    stringBuffer.append( attVar.getUpperCaseName()+"");
    stringBuffer.append(TEXT_7);
    stringBuffer.append(preffix);
    stringBuffer.append(TEXT_8);
    stringBuffer.append( "a"+attVar.getUpperCaseName()+"Hour");
    stringBuffer.append(TEXT_9);
    stringBuffer.append( "a"+attVar.getUpperCaseName()+"Minute");
    stringBuffer.append(TEXT_10);
    stringBuffer.append( attVar.getType());
    stringBuffer.append(TEXT_11);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_12);
     if (attVar.getValue()!=null){ 
    stringBuffer.append(TEXT_13);
    stringBuffer.append( attVar.getValue() );
    stringBuffer.append(TEXT_14);
     }  else{
    stringBuffer.append(TEXT_15);
     }
    stringBuffer.append(TEXT_16);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append( attVar.getUpperCaseName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}