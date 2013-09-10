package cruise.umple.compiler.sql;

import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

@SuppressWarnings("unused")
public class SqlClassGenerator implements ILang 
{

  protected static String nl;
  public static synchronized SqlClassGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    SqlClassGenerator result = new SqlClassGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "-- PLEASE DO NOT EDIT THIS CODE" + NL + "-- This code was generated using the UMPLE 1.17.0.2716 modeling language!";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "CREATE TABLE IF NOT EXISTS ";
  protected final String TEXT_5 = NL + "(";
  protected final String TEXT_6 = "  ";
  protected final String TEXT_7 = NL + ");";
  protected final String TEXT_8 = NL;

  // Add a newline to the end of the input
  private void appendln(StringBuffer buffer, String input, Object... variables)
  {
    append(buffer, input + "\n", variables);
  }  

  // This method will be used to append formatted strings
  // i.e. format("Hello {0} {1}", "andrew","forward");
  private void append(StringBuffer buffer, String input, Object... variables)
  {
    buffer.append(StringFormatter.format(input,variables));
  }

  /* 
  * This method will return the generated code.
  */
  public String getCode(UmpleModel model, UmpleElement uElement)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
  UmpleClass uClass = (UmpleClass) uElement;
  GeneratedClass gClass = uClass.getGeneratedClass();
  SqlGenerator gen = new SqlGenerator();
  gen.setModel(model);
  
  appendln(stringBuffer, gen.translate("beforeCode", uClass));

  HashMap<String,String> codeInjectionMap = new HashMap<String,String>();
  for (CodeInjection inject : uClass.getCodeInjections())
  {
    String operation = StringFormatter.toUnderscore(inject.getOperation());
    String key = inject.getType() + ":" + operation;
    String newCodeToInject = "";
    if (codeInjectionMap.containsKey(key))
    {
      newCodeToInject = StringFormatter.format("{0}\n    {1}",codeInjectionMap.get(key),inject.getCode());
    }
    else
    {
      newCodeToInject = inject.getCode();
    }
    codeInjectionMap.put(key,newCodeToInject);
  }
  boolean isFirst = true;

    stringBuffer.append(TEXT_2);
    stringBuffer.append(gen.translate("packageDefinition",uClass));
    stringBuffer.append(TEXT_3);
     if (uClass.numberOfComments() > 0) { if(!uClass.getComments().get(0).getIsInline()) {append(stringBuffer, "\n{0}", Comment.format("Multiline",uClass.getComments()));} else { append(stringBuffer, "\n{0}", Comment.format("Multiline",uClass.getComments()));} } 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(gen.translate("typeWithPackage", uClass) );
    stringBuffer.append(TEXT_5);
    
/*
This file creates the necessary attributes that the class will need for a successful foreign key to another class (association)
It creates local copies of the foreign class' private key attributes. 
Note: The foreign key constraint is not defined here, as the associated class may not be defined yet. See the members_AllForeignKeys.jet file for those.
*/
  appendln(stringBuffer, "");
  appendln(stringBuffer, "  /*------------------------*/");
  appendln(stringBuffer, "  /* MEMBER VARIABLES       */");
  appendln(stringBuffer, "  /*------------------------*/");
  
  isFirst = true;
  
  for (AssociationVariable av : uClass.getAssociationVariables())
  {
    if (!av.getIsNavigable())
    {
      continue;
    }
    
    String attribute = av.isOne() ? gen.translate("attributeOne",av) : gen.translate("attributeMany",av);
 
    if (av.isOptionalOne() || av.isOnlyOne() || av.isN())
    { 
      if (isFirst)
      {
        appendln(stringBuffer, "");
        appendln(stringBuffer,"  /*{0} Associations*/", gen.translate("type", uClass));
        isFirst = false;
      }
      UmpleClass associatedUClass = av.getRelatedAssociation().getUmpleClass();
      List<Attribute> foreignPKList = gen.resolvePrimaryKey(associatedUClass);
      for(int i = 1; i <= av.getMultiplicity().getUpperBound(); i += 1)
      { 
	    for(Attribute foreignPK : foreignPKList)
	    {
	      appendln(stringBuffer, "  {0}_{1}{2} {3},", gen.translate("type", associatedUClass),
	                                                     gen.translate("attributeOne", foreignPK), 
	                                                     av.isN() ? "_" + i : "", 
	                                                     gen.translate("type", foreignPK));
	    }
      }
    }
  }

    stringBuffer.append(TEXT_6);
    
  /*
  This file declares constant attributes for tables. 
  The "constant" requirement is enforced with a check statement.
  */
  
  isFirst = true;
  for(Attribute av : uClass.getAttributes())
  {
  
    if (!av.isConstant())
    {
      continue;
    }

    if (isFirst)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer,"  /*{0} Constants*/", gen.translate("type", uClass));      
      isFirst = false;
    }
  
    appendln(stringBuffer, "  {0} {1} DEFAULT {2} CHECK ({0} = {2}),", gen.translate("attributeConstant",av), gen.translate("type",av), gen.translate("parameterValueQuoted",av));
  }

    
  //This file declares the state machines of the class as Sql ENUM types.

  isFirst = true;
  for(StateMachine sm : uClass.getStateMachines())
  {
    List<StateMachine> allNested = sm.getNestedStateMachines();

    if (isFirst)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer,"  /*{0} State Machines*/", uClass.getName());
      isFirst = false;
    }
  
    appendln(stringBuffer, "  {0} ENUM({1}),", gen.translate("type",sm), gen.translate("listStates",sm));

    for (StateMachine nestedSm : allNested)
    {
      appendln(stringBuffer, "  {0} ENUM({1}),", gen.translate("type",nestedSm), gen.translate("listStates",nestedSm));
    }
  }

    
/*
This file generates Sql attributes for a given class. Once all the attributes have been defined, it generates the Sql Primary Key for the table.
*/

  isFirst = true;
  for(Attribute av : uClass.getAttributes())
  {
    if (av.isConstant() || av.getModifier().equals("internal"))
    {
      continue;
    }
    if (isFirst)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer,"  /*{0} Attributes*/", gen.translate("type", uClass));      
      isFirst = false;
    }
     
    String type = gen.translate("type",av);
    String attribute = gen.translate("attributeOne",av);
    if (av.getIsList())
    {
      attribute = gen.translate("attributeMany",av);
      type = StringFormatter.format("List<{0}>",gen.translate("typeMany",av));
    }
    
    append(stringBuffer, "  {0} {1}", attribute, type);
    
    if (av.getIsAutounique())
    {
   	  append(stringBuffer, " AUTO_INCREMENT");
    }
    if (gen.translate("parameterValue",av).compareToIgnoreCase("null") != 0)
    {
   	  append(stringBuffer, " DEFAULT {0}", gen.translate("parameterValueQuoted",av));
    }
    /* Unique not implemented yet.
    if (av.getIsUnique())
    {
   	  append(stringBuffer, " UNIQUE");
    }
    */
        
    appendln(stringBuffer, ",");
  }
  
  
  //Primary Key Generation
  String tKey = "";
  List<Attribute> PKList = gen.resolvePrimaryKey(uClass);
  for(Attribute PK : PKList)
  {
    tKey += gen.translate("attributeOne", PK) + ", ";
  }
  //Remove trailing comma
  if (tKey.length() > 0)
  {
    tKey = tKey.substring(0, tKey.length()-2);
  }
  else
  {
    tKey = "/*No Possible Primary Key*/";
  }
  appendln(stringBuffer, "  PRIMARY KEY({0})", tKey);

    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(gen.translate("packageDefinitionEnd",uClass));
    
{
  /*
  This file declares constant attributes for tables. 
  The "constant" requirement is enforced with a check statement.
  */
  
  isFirst = true;
  String triggerContents = "";
  for(Attribute av : uClass.getAttributes())
  {
  
    if (!av.isConstant())
    {
      continue;
    }

    if (isFirst)
    {  
      isFirst = false;
    }
    else
    {
      triggerContents += "\n";
    }

    triggerContents += "  IF NEW." + gen.translate("attributeConstantQuoted",av) + " <> " +gen.translate("parameterValueQuoted",av) + " THEN" + "\n";
    triggerContents += "    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ERROR: Attempt to modify constant attribute " + gen.translate("attributeConstantQuoted",av) + " in  " + gen.translate("typeQuoted",uClass) + "';" + "\n";
    triggerContents += "  END IF;";
  }
  if (!isFirst)
  {      
    appendln(stringBuffer, "");
    appendln(stringBuffer, "/*{0} Constant Enforcement*/", gen.translate("type", uClass));   
    appendln(stringBuffer, "DELIMITER //");   
    appendln(stringBuffer, "CREATE TRIGGER `const_insert` BEFORE insert ON {0}", gen.translate("typeWithPackage",uClass));
    appendln(stringBuffer, "FOR EACH ROW BEGIN");
    appendln(stringBuffer, triggerContents);
    appendln(stringBuffer, "END;");
    appendln(stringBuffer, "//");
    appendln(stringBuffer, "CREATE TRIGGER `const_update` BEFORE update ON {0}", gen.translate("typeWithPackage",uClass));
    appendln(stringBuffer, "FOR EACH ROW BEGIN");
    appendln(stringBuffer, triggerContents);
    appendln(stringBuffer, "END;");
    appendln(stringBuffer, "//");
    appendln(stringBuffer, "DELIMITER ;");
  }
}

     appendln(stringBuffer, gen.translate("afterCode", uClass));
    
//This is the declaration of the foreign key constraints. This should appear after all classes have already been output (currently not the case).
/* Argument 6 is added to ensure no two constraints end up having the same name. Often constraints do not have the same name
but sometimes when two tables have a foreign key referring to the same table */
  for (AssociationVariable av : uClass.getAssociationVariables())
  {

    if (av.getIsNavigable() && (av.isOptionalOne() || av.isOnlyOne() || av.isN()))
    { 
      UmpleClass associatedUClass = av.getRelatedAssociation().getUmpleClass();
      List<Attribute> foreignPKList = gen.resolvePrimaryKey(associatedUClass);
      for(int i = 1; i <= av.getMultiplicity().getUpperBound(); i += 1)
      { 
        for(Attribute foreignPK : foreignPKList)
        {
          appendln(stringBuffer, "ALTER TABLE {0} ADD CONSTRAINT `fk_{6}_{2}_{3}{5}` FOREIGN KEY (`{2}_{3}{5}`) REFERENCES {1}({4});", gen.translate("typeWithPackage", uClass),
                                                                                                                                   gen.translate("typeWithPackage", associatedUClass), 
                                                                                                                                   gen.translate("type", associatedUClass), 
                                                                                                                                   gen.translate("attributeOne", foreignPK), 
                                                                                                                                   gen.translate("attributeOneQuoted", foreignPK),
                                                                                                                                   av.isN() ? "_" + i : "", uClass.getName().toLowerCase());
        }
      }
    }
  }

    return stringBuffer.toString();
  }
}