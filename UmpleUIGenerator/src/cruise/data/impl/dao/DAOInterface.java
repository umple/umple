package cruise.data.impl.dao;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.Attribute;
import cruise.umple.compiler.UmpleClass;
import cruise.model.abstractObjects.BackingObject;;

public class DAOInterface implements IGenerator {

  protected static String nl;
  public static synchronized DAOInterface create(String lineSeparator)
  {
    nl = lineSeparator;
    DAOInterface result = new DAOInterface();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package dao.";
  protected final String TEXT_2 = ";" + NL + "import ";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = ";" + NL + "import dao.keys.";
  protected final String TEXT_5 = ".";
  protected final String TEXT_6 = "Key;" + NL + "import dao.generic.GenericDAO;" + NL + "public interface ";
  protected final String TEXT_7 = "DAO extends GenericDAO<";
  protected final String TEXT_8 = ", ";
  protected final String TEXT_9 = "Key> {" + NL + "}";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     BackingObject clazz =(BackingObject)argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(clazz.getPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(clazz.getPackageName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(clazz.getPackageName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(clazz.getDAOTable());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}