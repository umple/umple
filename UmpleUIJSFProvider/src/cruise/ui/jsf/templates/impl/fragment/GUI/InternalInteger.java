package cruise.ui.jsf.templates.impl.fragment.GUI;

import cruise.model.abstractObjects.IGenerator;

public class InternalInteger implements IGenerator {

  protected static String nl;
  public static synchronized InternalInteger create(String lineSeparator)
  {
    nl = lineSeparator;
    InternalInteger result = new InternalInteger();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}