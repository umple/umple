package cruise.data.impl.dao.generic;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.Attribute;
import cruise.umple.compiler.UmpleClass;;

public class GenericDAO implements IGenerator {

  protected static String nl;
  public static synchronized GenericDAO create(String lineSeparator)
  {
    nl = lineSeparator;
    GenericDAO result = new GenericDAO();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package dao.generic;" + NL + "" + NL + "import java.util.List;" + NL + "" + NL + "public interface GenericDAO<T, PK> {" + NL + "" + NL + "\t" + NL + "\t    T findById(PK id);" + NL + "" + NL + "\t    List<T> findAll();" + NL + "" + NL + " \t\tList<T> findAll(Class clazz);" + NL + " " + NL + "\t    List<T> findByInstance(T instance);" + NL + "" + NL + "\t    T save(T entity, PK pk);" + NL + "" + NL + "\t    void delete(PK pk);" + NL + "\t\t" + NL + "\t\tvoid deleteTree(T obj);" + NL + "\t\t" + NL + "\t\tvoid cascadeDelete(T obj);" + NL + "" + NL + "}";
  protected final String TEXT_2 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}