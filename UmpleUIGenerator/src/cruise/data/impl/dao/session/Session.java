package cruise.data.impl.dao.session;

import cruise.model.abstractObjects.IGenerator;

public class Session implements IGenerator {

  protected static String nl;
  public static synchronized Session create(String lineSeparator)
  {
    nl = lineSeparator;
    Session result = new Session();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package dao.session;" + NL + "" + NL + "public class Session {" + NL + "\t" + NL + "\tprivate static Session session; " + NL + "\tprivate final ObjectRepository obj;" + NL + "\t" + NL + "\t" + NL + "\tprivate Session(){" + NL + "\t\t" + NL + "\t\tobj=new ObjectRepository();" + NL + "\t}" + NL + "" + NL + "\tpublic static void destroy(){" + NL + "\t\tsession=null;" + NL + "\t\t" + NL + "\t}" + NL + "\tpublic static Session getInstance(){" + NL + "\t\tif (session==null)" + NL + "\t\tsession= new Session();" + NL + "\t\t" + NL + "\t\treturn session;" + NL + "\t}" + NL + "" + NL + "" + NL + "\tpublic ObjectRepository getObjectRepository() {" + NL + "\t\treturn obj;" + NL + "\t}" + NL + "}";
  protected final String TEXT_2 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}