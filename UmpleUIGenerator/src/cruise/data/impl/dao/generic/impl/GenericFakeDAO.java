package cruise.data.impl.dao.generic.impl;

import cruise.model.abstractObjects.IGenerator;

public class GenericFakeDAO implements IGenerator {

  protected static String nl;
  public static synchronized GenericFakeDAO create(String lineSeparator)
  {
    nl = lineSeparator;
    GenericFakeDAO result = new GenericFakeDAO();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package dao.generic.impl;" + NL + "" + NL + "import java.lang.reflect.ParameterizedType;" + NL + "import java.util.ArrayList;" + NL + "import java.util.Collections;" + NL + "import java.util.List;" + NL + "" + NL + "import dao.generic.GenericDAO;" + NL + "import dao.session.Session;" + NL + "" + NL + "public abstract class GenericFakeDAO<T, PK> implements GenericDAO<T, PK>{" + NL + "" + NL + "\tprivate Class<T> persistentClass;" + NL + "   " + NL + "    @SuppressWarnings(\"unchecked\")" + NL + "\tpublic GenericFakeDAO() {" + NL + "        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()" + NL + "                                .getGenericSuperclass()).getActualTypeArguments()[0];" + NL + "     }" + NL + "" + NL + "    public Class<T> getPersistentClass() {" + NL + "        return persistentClass;" + NL + "    }" + NL + "" + NL + "    @SuppressWarnings(\"unchecked\")" + NL + "    public T findById(PK id) {" + NL + "        T entity;" + NL + "          entity = (T) Session.getInstance().getObjectRepository().getTable(getPersistentClass()).get(id);" + NL + "" + NL + "        return entity;" + NL + "    }" + NL + "" + NL + "    @SuppressWarnings(\"unchecked\")" + NL + "    public List<T> findAll() {" + NL + "        return Collections.unmodifiableList(new ArrayList<T>(Session.getInstance().getObjectRepository().getTable(getPersistentClass()).values()));" + NL + "    }" + NL + "" + NL + "    @SuppressWarnings(\"unchecked\")" + NL + "    public List<T> findAll(Class clazz) {" + NL + "        List<T> filteredCollection = new ArrayList<T>();" + NL + "        for (T obj : new ArrayList<T>(Session.getInstance().getObjectRepository().getTable(getPersistentClass()).values()) ) {" + NL + "        \tif (clazz.isInstance(obj)) {" + NL + "\t\t\t\tfilteredCollection.add(obj);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn Collections.unmodifiableList(filteredCollection);" + NL + "        //return Collections.unmodifiableList(new ArrayList<T>(Session.getInstance().getObjectRepository().getTable(getPersistentClass()).values()));" + NL + "    }" + NL + "" + NL + "" + NL + "    public List<T> findByInstance(T exampleInstance) {" + NL + "      " + NL + "        return null;" + NL + "    }" + NL + "" + NL + "" + NL + "    public T save(T entity, PK pk) {" + NL + "        Session.getInstance().getObjectRepository().save(getPersistentClass(), pk, entity);" + NL + "        return entity;" + NL + "    }" + NL + "" + NL + "    public void delete(PK pk) {" + NL + "    \tSession.getInstance().getObjectRepository().delete(getPersistentClass(), pk);" + NL + "    \tSystem.gc();" + NL + "    }" + NL + "" + NL + "" + NL + "" + NL + "   " + NL + "\t" + NL + "" + NL + "}";
  protected final String TEXT_2 = NL;

	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}