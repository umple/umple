package cruise.data.impl.dao.session;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.Attribute;
import cruise.umple.compiler.UmpleClass;
import cruise.model.abstractObjects.BackingObject;;

public class ObjectRepository implements IGenerator {

  protected static String nl;
  public static synchronized ObjectRepository create(String lineSeparator)
  {
    nl = lineSeparator;
    ObjectRepository result = new ObjectRepository();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package dao.session;" + NL + "" + NL + "import java.util.HashMap;" + NL + "import java.util.Map;" + NL + "" + NL + "public class ObjectRepository {" + NL + "\t" + NL + "\t @SuppressWarnings(\"unchecked\")" + NL + "\tprotected ObjectRepository(){" + NL + "\t\t//initialize";
  protected final String TEXT_2 = NL + " \t\tmap.put(";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = ".class, new HashMap());";
  protected final String TEXT_5 = NL + NL + "\t}" + NL + "\t" + NL + "    @SuppressWarnings(\"unchecked\")" + NL + "\tprivate  HashMap<Class, Map> map= new HashMap<Class, Map>();" + NL + "" + NL + "\t" + NL + "    @SuppressWarnings(\"unchecked\")" + NL + "\tpublic HashMap<Class, Map> getMap() {" + NL + "\t\treturn map;" + NL + "\t}" + NL + "" + NL + "" + NL + "    @SuppressWarnings(\"unchecked\")" + NL + "\tpublic Map getTable(Class persistenceEntity){" + NL + "\t\t" + NL + "\t\treturn map.get(persistenceEntity);" + NL + "\t}" + NL + "    " + NL + "    @SuppressWarnings(\"unchecked\")" + NL + "\tpublic void save(Class persistenceEntity, Object key, Object obj){" + NL + "\t\tif (map.get(persistenceEntity).get(key)!=null)" + NL + "\t\t\tthrow new RuntimeException(\"An entity with the same key field(s) exists!\");" + NL + "\t\tmap.get(persistenceEntity).put(key, obj);" + NL + "\t\t" + NL + "\t}" + NL + "\t" + NL + "    @SuppressWarnings(\"unchecked\")" + NL + "\tpublic void delete(Class persistenceEntity, Object key){" + NL + "\t\tmap.get(persistenceEntity).remove(key);" + NL + "\t\t" + NL + "\t}" + NL + "}";

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     ArrayList<BackingObject> clazzez =(ArrayList<BackingObject>)argument; 
    stringBuffer.append(TEXT_1);
     for (Iterator<BackingObject> iterClazzez =clazzez.iterator(); iterClazzez.hasNext(); ) { 
  	BackingObject clazz= iterClazzez.next(); 
  	if(!clazz.hasParent()){
  	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(clazz.getPackageName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_4);
     } } 
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}