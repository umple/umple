package cruise.data.impl.dao.factory;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.model.abstractObjects.BackingObject;;

public class DAOFactory implements IGenerator {

  protected static String nl;
  public static synchronized DAOFactory create(String lineSeparator)
  {
    nl = lineSeparator;
    DAOFactory result = new DAOFactory();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "package dao.factory;" + NL;
  protected final String TEXT_2 = NL + "import dao.";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = "DAO;";
  protected final String TEXT_5 = NL + NL + "public abstract class DAOFactory {" + NL + "" + NL + "\tpublic static final Class FakeDAO = FakeDAOFactory.class;" + NL + "" + NL + "\tpublic static DAOFactory instance(Class factory) {" + NL + "\t\ttry {" + NL + "\t\t\treturn (DAOFactory) factory.newInstance();" + NL + "\t\t} catch (Exception ex) {" + NL + "\t\t\tthrow new RuntimeException(\"Couldn't create DAOFactory: \" + factory);" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_6 = NL + "\tpublic abstract ";
  protected final String TEXT_7 = "DAO get";
  protected final String TEXT_8 = "DAO();  ";
  protected final String TEXT_9 = NL + "}";
  protected final String TEXT_10 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     ArrayList<BackingObject> clazzez =(ArrayList<BackingObject>)argument; 
    stringBuffer.append(TEXT_1);
     for (Iterator<BackingObject> iterClazzez =clazzez.iterator(); iterClazzez.hasNext(); ) { 
  	BackingObject clazz= iterClazzez.next(); 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(clazz.getPackageName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_4);
     } 
    stringBuffer.append(TEXT_5);
     for (Iterator<BackingObject> iterClazzez =clazzez.iterator(); iterClazzez.hasNext(); ) { 
  	BackingObject clazz= iterClazzez.next(); 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_8);
     } 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}