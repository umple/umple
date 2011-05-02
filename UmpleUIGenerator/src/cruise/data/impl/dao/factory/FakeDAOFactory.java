package cruise.data.impl.dao.factory;

import cruise.model.abstractObjects.IGenerator;

import java.util.*;
import cruise.umple.compiler.*;
import cruise.umple.compiler.UmpleClass;
import cruise.model.abstractObjects.BackingObject;;

public class FakeDAOFactory implements IGenerator {

  protected static String nl;
  public static synchronized FakeDAOFactory create(String lineSeparator)
  {
    nl = lineSeparator;
    FakeDAOFactory result = new FakeDAOFactory();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package dao.factory;" + NL;
  protected final String TEXT_2 = NL + "import ";
  protected final String TEXT_3 = ".";
  protected final String TEXT_4 = ";";
  protected final String TEXT_5 = NL + "import dao.";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = "DAO;" + NL + "import dao.keys.";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = "Key;" + NL + "import java.util.List;" + NL + "import dao.keys.IKey;" + NL + "import dao.generic.GenericDAO;";
  protected final String TEXT_10 = NL + "import dao.generic.impl.GenericFakeDAO;" + NL + "" + NL + "public class FakeDAOFactory  extends DAOFactory{" + NL + " ";
  protected final String TEXT_11 = NL + "\tprivate ";
  protected final String TEXT_12 = "DAO a";
  protected final String TEXT_13 = "=new ";
  protected final String TEXT_14 = "FakeDAO();";
  protected final String TEXT_15 = NL;
  protected final String TEXT_16 = NL + "\tpublic   ";
  protected final String TEXT_17 = "DAO get";
  protected final String TEXT_18 = "DAO(){" + NL + "\t\treturn a";
  protected final String TEXT_19 = ";" + NL + "\t}";
  protected final String TEXT_20 = NL + NL + "\t" + NL;
  protected final String TEXT_21 = NL + "\tpublic static class ";
  protected final String TEXT_22 = "FakeDAO extends GenericFakeDAO<";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = "Key> implements ";
  protected final String TEXT_25 = "DAO {" + NL + "\t" + NL + "\t\tpublic void cascadeDelete(";
  protected final String TEXT_26 = " a";
  protected final String TEXT_27 = "){" + NL + "\t\t";
  protected final String TEXT_28 = NL + "\t\t";
  protected final String TEXT_29 = NL + "\t\tList<";
  protected final String TEXT_30 = ">  ";
  protected final String TEXT_31 = "s=((";
  protected final String TEXT_32 = ")a";
  protected final String TEXT_33 = ").get";
  protected final String TEXT_34 = "s();" + NL + "\t\tfor(";
  protected final String TEXT_35 = "  a";
  protected final String TEXT_36 = " : ";
  protected final String TEXT_37 = "s)" + NL + "    \t{   " + NL + "\t\t\tDAOUtils.getDAOByInstance(a";
  protected final String TEXT_38 = ").cascadeDelete(a";
  protected final String TEXT_39 = ");" + NL + "    \t}";
  protected final String TEXT_40 = NL + "    \t";
  protected final String TEXT_41 = NL + "    \tif (((";
  protected final String TEXT_42 = ")a";
  protected final String TEXT_43 = ").get";
  protected final String TEXT_44 = "()!=null)" + NL + "    \t\tDAOUtils.getDAOByInstance(((";
  protected final String TEXT_45 = ")a";
  protected final String TEXT_46 = ").get";
  protected final String TEXT_47 = "()).cascadeDelete(((";
  protected final String TEXT_48 = ")a";
  protected final String TEXT_49 = ").get";
  protected final String TEXT_50 = "());" + NL + "    \t";
  protected final String TEXT_51 = NL + "    \t";
  protected final String TEXT_52 = NL + "    \tList<";
  protected final String TEXT_53 = ">  ";
  protected final String TEXT_54 = "s=((";
  protected final String TEXT_55 = ")a";
  protected final String TEXT_56 = ").get";
  protected final String TEXT_57 = "s();" + NL + "\t\tfor(";
  protected final String TEXT_58 = "  a";
  protected final String TEXT_59 = " : ";
  protected final String TEXT_60 = "s)" + NL + "    \t{  " + NL + "    \tif (a";
  protected final String TEXT_61 = ".numberOf";
  protected final String TEXT_62 = "s()-1 < ";
  protected final String TEXT_63 = ".minimumNumberOf";
  protected final String TEXT_64 = "s())" + NL + "    \t\tDAOUtils.getDAOByInstance(a";
  protected final String TEXT_65 = ").cascadeDelete(a";
  protected final String TEXT_66 = ");" + NL + "    \t}";
  protected final String TEXT_67 = NL + "\t   \t";
  protected final String TEXT_68 = NL + "\t   \t\tthis.delete((";
  protected final String TEXT_69 = "Key)DAOUtils.generateKey(a";
  protected final String TEXT_70 = "));" + NL + " \t\t}" + NL + " \t\t" + NL + " \t\tpublic void deleteTree(";
  protected final String TEXT_71 = " a";
  protected final String TEXT_72 = "){" + NL + " \t\t\tthis.cascadeDelete( a";
  protected final String TEXT_73 = ");" + NL + " \t\t\ta";
  protected final String TEXT_74 = ".delete();" + NL + " \t\t}" + NL + " \t\t" + NL + " \t}" + NL + " \t";
  protected final String TEXT_75 = NL + "}" + NL + "" + NL + "" + NL + " class DAOUtils{" + NL + " " + NL + " \t\tprivate static DAOFactory daoFactory;" + NL + "\t\tstatic {" + NL + "\t\t\tdaoFactory=DAOFactory.instance(DAOFactory.FakeDAO);" + NL + "\t\t}" + NL + "" + NL + "\tpublic static IKey generateKey(Object entity){" + NL + "\t\t  ";
  protected final String TEXT_76 = " " + NL + " \t\tif (entity.getClass().getName().equals(";
  protected final String TEXT_77 = ".class.getName())){" + NL + " \t\t\t";
  protected final String TEXT_78 = "  a";
  protected final String TEXT_79 = "= (";
  protected final String TEXT_80 = ")entity;" + NL + " \t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_82 = "Key ";
  protected final String TEXT_83 = "Key= new ";
  protected final String TEXT_84 = "Key(";
  protected final String TEXT_85 = ");" + NL + " \t\t\treturn ";
  protected final String TEXT_86 = "Key;" + NL + " \t\t}" + NL + " \t\t";
  protected final String TEXT_87 = "\t\t" + NL + " \t\treturn null;" + NL + " \t\t}" + NL + " " + NL + " \t\t" + NL + "" + NL + "\t\tpublic static GenericDAO getDAOByInstance(Object entity){" + NL + "\t\t  ";
  protected final String TEXT_88 = " " + NL + " \t\tif (entity.getClass().getName().equals(";
  protected final String TEXT_89 = ".class.getName())){" + NL + " \t\treturn daoFactory.get";
  protected final String TEXT_90 = "DAO();" + NL + " \t\t}\t";
  protected final String TEXT_91 = NL + " \t\treturn null;\t\t" + NL + "\t\t}" + NL + "" + NL + "\t}";
  protected final String TEXT_92 = NL;

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
     for (Iterator<BackingObject> iterClazzez =clazzez.iterator(); iterClazzez.hasNext(); ) { 
  	BackingObject clazz= iterClazzez.next(); 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(clazz.getPackageName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(clazz.getPackageName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_9);
     } 
    stringBuffer.append(TEXT_10);
     for (Iterator<BackingObject> iterClazzez =clazzez.iterator(); iterClazzez.hasNext(); ) { 
  	BackingObject clazz= iterClazzez.next(); 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_14);
     } 
    stringBuffer.append(TEXT_15);
     for (Iterator<BackingObject> iterClazzez =clazzez.iterator(); iterClazzez.hasNext(); ) { 
  	BackingObject clazz= iterClazzez.next(); 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_19);
     } 
    stringBuffer.append(TEXT_20);
     for (Iterator<BackingObject> iterClazzez =clazzez.iterator(); iterClazzez.hasNext(); ) { 
  	BackingObject clazz= iterClazzez.next(); 
  	UmpleClass uClazz=clazz.getUClazz();  	
    stringBuffer.append(TEXT_21);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(clazz.getDAOTable());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(clazz.getDAOTable());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_27);
     for (AssociationVariable assocVar: uClazz.getAssociationVariables()) { 
    stringBuffer.append(TEXT_28);
     if (assocVar.getRelatedAssociation().isOnlyOne() && assocVar.isMany()) {		
    stringBuffer.append(TEXT_29);
    stringBuffer.append(assocVar.getType());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(assocVar.getName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(assocVar.getType());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(assocVar.getName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
     if (assocVar.getRelatedAssociation().isOnlyOne() && assocVar.isOne()) {		
    stringBuffer.append(TEXT_41);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_50);
    }
    stringBuffer.append(TEXT_51);
     if ((assocVar.getRelatedAssociation().isN() || assocVar.getRelatedAssociation().isMN()) && assocVar.isMany()) {		
    stringBuffer.append(TEXT_52);
    stringBuffer.append(assocVar.getType());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(assocVar.getName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(assocVar.getType());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(assocVar.getName());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(assocVar.getRelatedAssociation().getUpperCaseName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(assocVar.getType());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(assocVar.getRelatedAssociation().getUpperCaseName());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(assocVar.getUpperCaseName());
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
     }
    stringBuffer.append(TEXT_68);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(clazz.getDAOTable());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_74);
     } 
    stringBuffer.append(TEXT_75);
     for (Iterator<BackingObject> iterClazzez =clazzez.iterator(); iterClazzez.hasNext(); ) {
		  BackingObject clazz= iterClazzez.next(); 
    stringBuffer.append(TEXT_76);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_80);
    Iterator<Attribute> keyIter=clazz.getKeysAttributes().iterator();
				String deleteSignature="";
				while (keyIter.hasNext()){
				Attribute att=keyIter.next();
				deleteSignature=deleteSignature+"  a"+clazz.getClassName() +".get"+ att.getUpperCaseName()+"()";
				if(keyIter.hasNext())
					deleteSignature=deleteSignature+", ";	}		
    stringBuffer.append(TEXT_81);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(clazz.getClassName().toLowerCase());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(deleteSignature);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(clazz.getClassName().toLowerCase());
    stringBuffer.append(TEXT_86);
     } 
    stringBuffer.append(TEXT_87);
     for (Iterator<BackingObject> iterClazzez =clazzez.iterator(); iterClazzez.hasNext(); ) {
		  BackingObject clazz= iterClazzez.next(); 
    stringBuffer.append(TEXT_88);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(clazz.getClassName());
    stringBuffer.append(TEXT_90);
     } 
    stringBuffer.append(TEXT_91);
    stringBuffer.append(TEXT_92);
    return stringBuffer.toString();
  }
}