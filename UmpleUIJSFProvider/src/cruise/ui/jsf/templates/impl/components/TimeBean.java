package cruise.ui.jsf.templates.impl.components;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.*;
import cruise.ui.jsf.*;

public class TimeBean implements IGenerator {

  protected static String nl;
  public static synchronized TimeBean create(String lineSeparator)
  {
    nl = lineSeparator;
    TimeBean result = new TimeBean();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ".components.bean;" + NL + "" + NL + "import java.util.ArrayList;" + NL + "import java.util.List;" + NL + "import javax.faces.model.SelectItem;" + NL + "" + NL + "" + NL + "public class TimeBean {" + NL + "\tprivate List<SelectItem> hours;" + NL + "\tprivate List<SelectItem> minutes;" + NL + "\tpublic TimeBean() {" + NL + "\t\thours=new ArrayList<SelectItem>();" + NL + "\t\tminutes=new ArrayList<SelectItem>();" + NL + "\t\tfor (int i=0; i<24; i++)" + NL + "\t\t\thours.add(new SelectItem(i,String.valueOf(i)));" + NL + "\t\tfor (int i=0; i<60; i++)" + NL + "\t\t\tminutes.add(new SelectItem(i,String.valueOf(i)));" + NL + "\t\t" + NL + "\t}" + NL + "\tpublic List<SelectItem> getHours() {" + NL + "\t\treturn hours;" + NL + "\t}" + NL + "\tpublic void setHours(List<SelectItem> hours) {" + NL + "\t\tthis.hours = hours;" + NL + "\t}" + NL + "\tpublic List<SelectItem> getMinutes() {" + NL + "\t\treturn minutes;" + NL + "\t}" + NL + "\tpublic void setMinutes(List<SelectItem> minutes) {" + NL + "\t\tthis.minutes = minutes;" + NL + "\t}" + NL + "\tpublic static java.sql.Time getSqlTime(int hours, int minutes){" + NL + "\t\t java.sql.Time jsqlT = java.sql.Time.valueOf( hours+\":\"+minutes+\":00\" );" + NL + "\t\treturn jsqlT;" + NL + "\t}" + NL + "" + NL + "\t" + NL + "}";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     String preffix=JSFProvider.properties.getProperty(cruise.model.Constants.PACKAGE_PREFIX);
    stringBuffer.append(TEXT_1);
    stringBuffer.append(preffix);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}