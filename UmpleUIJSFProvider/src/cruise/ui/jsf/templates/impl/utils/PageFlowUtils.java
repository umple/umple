package cruise.ui.jsf.templates.impl.utils;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.*;
import cruise.ui.jsf.*;

public class PageFlowUtils implements IGenerator {

  protected static String nl;
  public static synchronized PageFlowUtils create(String lineSeparator)
  {
    nl = lineSeparator;
    PageFlowUtils result = new PageFlowUtils();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "package ";
  protected final String TEXT_2 = ".utils;" + NL + "" + NL + "import java.util.Map;" + NL + "import java.util.HashMap;" + NL + "import java.util.Stack;" + NL + "import javax.faces.context.FacesContext;" + NL + "import dao.factory.DAOFactory;" + NL + "import ";
  protected final String TEXT_3 = ".control.BeanLinker;" + NL + "import ";
  protected final String TEXT_4 = ".control.MainBean;" + NL + "import javax.servlet.http.HttpSession;" + NL + "" + NL + "public class PageFlowUtils {" + NL + "" + NL + "\tpublic static final String STACK =\"STACK\";" + NL + "\t" + NL + "\tprivate  static HttpSession getSession(){" + NL + "\t\tHttpSession session = (HttpSession)  FacesContext.getCurrentInstance().getExternalContext().getSession(false);" + NL + "\t\treturn session;" + NL + "\t}" + NL + "\t@SuppressWarnings(\"unchecked\")" + NL + "\tpublic static Map getPageFlow() {" + NL + "\t//\tHttpSession session = (HttpSession)  FacesContext.getCurrentInstance().getExternalContext().getSession(false);" + NL + "\t\t//if(session.getAttribute(\"pageFlow\")==null){" + NL + "\t//\t\tsession.setAttribute(\"pageFlow\", new HashMap());" + NL + "\t//\t}" + NL + "\t\treturn peekBeanLinker().getAttributeMap();" + NL + "\t}" + NL + "\t" + NL + "\t@SuppressWarnings(\"unchecked\")" + NL + "\tpublic static void clearPageFlow() {" + NL + "\t//\tgetSession().clear();" + NL + "\t\tStack<BeanLinker> stack =new Stack<BeanLinker>();" + NL + "\t\tBeanLinker linker=new BeanLinker();" + NL + "\t\tstack.add(linker);" + NL + "\t\tgetSession().setAttribute(STACK,  stack);" + NL + "\t}" + NL + "\t" + NL + "\t@SuppressWarnings(\"unchecked\")" + NL + "\tpublic static void pushBeanLinker(BeanLinker linker) {" + NL + "\t\t((Stack<BeanLinker>)getSession().getAttribute(STACK)).push(linker);" + NL + "\t}" + NL + "\t" + NL + "\t@SuppressWarnings(\"unchecked\")" + NL + "\tpublic static BeanLinker peekBeanLinker() {" + NL + "\t\treturn ((Stack<BeanLinker>)getSession().getAttribute(STACK)).peek();" + NL + "\t}" + NL + "\t" + NL + "\t@SuppressWarnings(\"unchecked\")" + NL + "\tpublic static BeanLinker popBeanLinker() {" + NL + "\t\treturn ((Stack<BeanLinker>)getSession().getAttribute(STACK)).pop();" + NL + "\t}" + NL + "" + NL + "\t@SuppressWarnings(\"unchecked\")" + NL + "\tpublic static boolean  isStackEmpty(){" + NL + "\t\treturn ((Stack<BeanLinker>)getSession().getAttribute(STACK)).size()==0;" + NL + "\t\t" + NL + "\t} " + NL + "\t" + NL + "\tpublic static DAOFactory getDAOFactory(){" + NL + "\tMainBean mainBean = (MainBean) FacesContext.getCurrentInstance()" + NL + "\t.getELContext().getELResolver().getValue(" + NL + "\t\t\tFacesContext.getCurrentInstance().getELContext(), null," + NL + "\t\t\t\"mainBean\");" + NL + "\treturn mainBean.getDAOFactory();" + NL + "\t}" + NL + "}";
  protected final String TEXT_5 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
 String preffix=JSFProvider.properties.getProperty(cruise.model.Constants.PACKAGE_PREFIX);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(preffix);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(preffix);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(preffix);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}