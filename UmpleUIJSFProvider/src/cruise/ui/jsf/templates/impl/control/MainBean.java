package cruise.ui.jsf.templates.impl.control;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.*;
import cruise.ui.jsf.*;

public class MainBean implements IGenerator {

  protected static String nl;
  public static synchronized MainBean create(String lineSeparator)
  {
    nl = lineSeparator;
    MainBean result = new MainBean();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ".control;" + NL + "" + NL + "import javax.faces.context.ExternalContext;" + NL + "import javax.faces.context.FacesContext;" + NL + "import javax.servlet.http.HttpSession;" + NL + "import dao.factory.DAOFactory;" + NL + "import ";
  protected final String TEXT_3 = ".utils.PageFlowUtils;" + NL + "" + NL + "public class MainBean {" + NL + "" + NL + "\tprivate String menuOption;" + NL + "\t" + NL + "\t" + NL + "\tprivate DAOFactory daoFactory=DAOFactory.instance(DAOFactory.FakeDAO);" + NL + "\t" + NL + "\t" + NL + "\tpublic DAOFactory getDAOFactory() {" + NL + "\t\treturn daoFactory;" + NL + "\t}" + NL + "" + NL + "\tpublic MainBean() {" + NL + "\t}" + NL + "\t" + NL + "\tpublic String invalidateSession(){" + NL + "\t\tExternalContext ectx = FacesContext.getCurrentInstance().getExternalContext();" + NL + "\t\tHttpSession session = (HttpSession)ectx.getSession(false);" + NL + "\t\tsession.invalidate(); " + NL + "\t\treturn \"home\";" + NL + "\t}" + NL + "" + NL + "" + NL + "\tpublic String navigate(){" + NL + "\t\tPageFlowUtils.clearPageFlow();" + NL + "\t\treturn menuOption;" + NL + "\t}" + NL + "\t" + NL + "\t\t" + NL + "\tpublic void setMenuOption(String menuOption) {" + NL + "\t\tthis.menuOption = menuOption;" + NL + "\t}" + NL + "" + NL + "\tpublic String getMenuOption() {" + NL + "\t\treturn menuOption;" + NL + "\t}" + NL + "\t" + NL + "\tpublic String getKey(){" + NL + "\t\tString uid=java.util.UUID.randomUUID().toString();" + NL + "\t\tSystem.out.println(\"UIIIIIID:  \"+uid);" + NL + "\t\treturn uid;" + NL + "\t}" + NL + "\tpublic void setKey(String some){" + NL + "\t\t" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_4 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     String preffix=JSFProvider.properties.getProperty(cruise.model.Constants.PACKAGE_PREFIX);
    stringBuffer.append(TEXT_1);
    stringBuffer.append(preffix);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(preffix);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}