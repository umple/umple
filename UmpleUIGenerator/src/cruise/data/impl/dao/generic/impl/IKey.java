package cruise.data.impl.dao.generic.impl;

import cruise.model.abstractObjects.IGenerator;

public class IKey implements IGenerator {

  protected static String nl;
  public static synchronized IKey create(String lineSeparator)
  {
    nl = lineSeparator;
    IKey result = new IKey();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package dao.keys;" + NL + "" + NL + "public interface IKey {" + NL + "" + NL + "}";
  protected final String TEXT_2 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}