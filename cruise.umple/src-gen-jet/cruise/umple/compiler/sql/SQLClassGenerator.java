package cruise.umple.compiler.sql;

import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

@SuppressWarnings("unused")
public class SQLClassGenerator implements ILang 
{

  protected static String nl;
  public static synchronized SQLClassGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    SQLClassGenerator result = new SQLClassGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "-- PLEASE DO NOT EDIT THIS CODE" + NL + "-- This code was generated using the UMPLE @UMPLE_VERSION@ modeling language!";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "CREATE TABLE IF NOT EXISTS `";
  protected final String TEXT_6 = "`" + NL + "(";
  protected final String TEXT_7 = "  ";
  protected final String TEXT_8 = NL + ");";
  protected final String TEXT_9 = NL;

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
  SQLGenerator gen = new SQLGenerator();
  gen.setModel(model);

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
    stringBuffer.append(TEXT_3);
    stringBuffer.append(gen.translate("packageDefinition",uClass));
    stringBuffer.append(TEXT_4);
     if (uClass.numberOfComments() > 0) { if(!uClass.getComments().get(0).isInline) {append(stringBuffer, "\n{0}", Comment.format("Multiline",uClass.getComments()));} else { append(stringBuffer, "\n{0}", Comment.format("Multiline",uClass.getComments()));} } 
    stringBuffer.append(TEXT_5);
     if (uClass.getPackageName() != "") { append(stringBuffer, "{0}`.`", gen.translate("packageName", uClass));} 
    stringBuffer.append(gen.translate("type", uClass) );
    stringBuffer.append(TEXT_6);
    

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
	      appendln(stringBuffer, "  {0}_{1}{2} {3}{4},", gen.translate("type", associatedUClass),
	                                                       gen.translate("attributeOne", foreignPK), 
	                                                       av.isN() ? "_" + i : "", 
	                                                       gen.translate("type", foreignPK),
	                                                       av.isN() ? " NOT NULL" : "");
	    }
      }
    }
  }

    stringBuffer.append(TEXT_7);
    
  
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
  
    appendln(stringBuffer, "  {0} {1} DEFAULT '{2}' CHECK ({1} = '{2}'),", gen.translate("attributeConstant",av), gen.translate("type",av), gen.translate("parameterValue",av));
  }
  

    
{

/*
This file generates SQL attributes for a given class. Once all the attributes have been defined, it generates the SQL Primary Key for the table.
*/

  isFirst = true;
  for(Attribute av : uClass.getAttributes())
  {
    if (av.isConstant())
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
   	  append(stringBuffer, " DEFAULT '{0}'", gen.translate("parameterValue",av));
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
  tKey = tKey.substring(0, tKey.length()-2);
  appendln(stringBuffer, "  PRIMARY KEY({0})", tKey);
  
}

    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(gen.translate("packageDefinitionEnd",uClass));
    return stringBuffer.toString();
  }
}