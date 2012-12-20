package cruise.ui.jsf.templates.impl.control;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.*;
import cruise.ui.jsf.*;

public class BeanLinker implements IGenerator {

  protected static String nl;
  public static synchronized BeanLinker create(String lineSeparator)
  {
    nl = lineSeparator;
    BeanLinker result = new BeanLinker();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ".control;" + NL + "" + NL + "import java.util.List;" + NL + "import java.util.Map;" + NL + "import java.util.HashMap;" + NL + "" + NL + "public class BeanLinker {" + NL + "" + NL + "\tprivate Object initBean;" + NL + "\tprivate List linkerCollection;" + NL + "\tprivate Object linker;" + NL + "\tprivate boolean singleSelection;" + NL + "\tprivate boolean multipleSelection;" + NL + "\tprivate String roleName;" + NL + "\tprivate Map attributeMap=new HashMap();" + NL + "\t" + NL + "\tpublic Map getAttributeMap() {" + NL + "\t\treturn attributeMap;" + NL + "\t}\t" + NL + "\t" + NL + "\tpublic void setRoleName(String roleName) {" + NL + "\t\tthis.roleName = roleName;" + NL + "\t}" + NL + "" + NL + "\tpublic String getRoleName() {" + NL + "\t\treturn roleName;" + NL + "\t}" + NL + "\t" + NL + "\tpublic boolean isSingleSelection() {" + NL + "\t\treturn singleSelection;" + NL + "\t}" + NL + "" + NL + "\tpublic void setSingleSelection(boolean singleSelection) {" + NL + "\t\tthis.singleSelection = singleSelection;" + NL + "\t}" + NL + "" + NL + "\tpublic boolean isMultipleSelection() {" + NL + "\t\treturn multipleSelection;" + NL + "\t}" + NL + "" + NL + "\tpublic void setMultipleSelection(boolean multipleSelection) {" + NL + "\t\tthis.multipleSelection = multipleSelection;" + NL + "\t}" + NL + "" + NL + "\tpublic Object getInitBean() {" + NL + "\t\treturn initBean;" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setInitBean(Object initBean) {" + NL + "\t\tthis.initBean = initBean;" + NL + "\t}" + NL + "\t" + NL + "\tpublic List getLinkerCollection() {" + NL + "\t\treturn linkerCollection;" + NL + "\t}" + NL + "\t" + NL + "\tpublic void setLinkerCollection(List linkerCollection) {" + NL + "\t\tthis.linkerCollection = linkerCollection;" + NL + "\t}" + NL + "" + NL + "\tpublic void setLinker(Object linker) {" + NL + "\t\tthis.linker = linker;" + NL + "\t}" + NL + "" + NL + "\tpublic Object getLinker() {" + NL + "\t\treturn linker;" + NL + "\t}" + NL + "\t" + NL + "\t" + NL + "\t" + NL + "}";
  protected final String TEXT_3 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     String preffix=JSFProvider.properties.getProperty(cruise.model.Constants.PACKAGE_PREFIX);
    stringBuffer.append(TEXT_1);
    stringBuffer.append(preffix);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}