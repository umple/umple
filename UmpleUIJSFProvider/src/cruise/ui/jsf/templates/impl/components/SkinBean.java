package cruise.ui.jsf.templates.impl.components;

import cruise.model.abstractObjects.IGenerator;

import cruise.ui.jsf.*;

public class SkinBean implements IGenerator {

  protected static String nl;
  public static synchronized SkinBean create(String lineSeparator)
  {
    nl = lineSeparator;
    SkinBean result = new SkinBean();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ".components.bean;" + NL + "" + NL + "public class SkinBean {" + NL + " " + NL + "   private String skin;" + NL + " " + NL + "   public String getSkin() {" + NL + "   if(skin==null){" + NL + "   \tskin= \"wine\";" + NL + "   }" + NL + "\treturn skin;" + NL + "   }" + NL + "   public void setSkin(String skin) {" + NL + "\tthis.skin = skin;" + NL + "   }" + NL + "}";

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