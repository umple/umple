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
  protected final String TEXT_5 = NL + "CREATE TABLE `";
  protected final String TEXT_6 = "`";
  protected final String TEXT_7 = " (" + NL;
  protected final String TEXT_8 = NL + "  " + NL + ");";
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
    
/*
A brief outline of what needs to be done:

Associations, Auto-unique variables

*/

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
    stringBuffer.append( gen.translate("isA",uClass) /* a bit of work needs to be done here, if we inherit, do we just add those attributes to the table?*/ );
    stringBuffer.append(TEXT_7);
    
  
  // SQL doesn't have a notion of a static 'member' or variable,
  // however, it may be useful to document static members in the code
  // so this template has been left as is.
  
  if (uClass.getIsSingleton())
  {
    append(stringBuffer, "  include Singleton");
  }

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
      appendln(stringBuffer, "");
      appendln(stringBuffer, "  /*-----------------------*/");
      appendln(stringBuffer, "  /* STATIC VARIABLES      */");
      appendln(stringBuffer, "  /*-----------------------*/");
      isFirst = false;
    }
  
    appendln(stringBuffer, "");
    appendln(stringBuffer, "  {0} {1} DEFAULT '{2}' CHECK ({1} = '{2}'),", gen.translate("attributeConstant",av), gen.translate("type",av), gen.translate("parameterValue",av));
  }
  

    
{
  appendln(stringBuffer, "");
  appendln(stringBuffer, "");
  appendln(stringBuffer, "  /*------------------------*/");
  appendln(stringBuffer, "  /* MEMBER VARIABLES       */");
  append(stringBuffer, "  /*------------------------*/");

  //Check for Primary Key
  boolean noKey = false;
  String genKeyName = gen.translate("type", uClass) + "_id";
  if (uClass.getKey().getMembers().length == 0)
  {
  	noKey = true;
  }

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
      appendln(stringBuffer, "");
      appendln(stringBuffer,"  /*{0} Attributes*/", gen.translate("type", uClass));      
      if (noKey)
      {
        appendln(stringBuffer, "  /*Warning: No Primary Key specified. {0} was generated.*/", genKeyName);
        appendln(stringBuffer, "  {0} INT AUTO_INCREMENT,", genKeyName);
      }
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
    else if (gen.translate("parameterValue",av).compareToIgnoreCase("null") != 0)
    {
   	  append(stringBuffer, " DEFAULT '{0}'", gen.translate("parameterValue",av));
    }
        
    appendln(stringBuffer, ",");
  }
  
  
  //Primary Key Generation
  if (!noKey)
  {
  	String tKey = "";
  	for(String key : uClass.getKey().getMembers())
  	{
  	  if (uClass.getAttribute(key) == null) //Check if the given key is a constant.
  	  {
  	    tKey += "/*Warning: Constant attribute in Primary Key*/ ";
  	  }
	  tKey += StringFormatter.toUnderscore(key) + ", ";
  	}
  	//Remove trailing comma
  	tKey = tKey.substring(0, tKey.length()-2);
  	appendln(stringBuffer, "  PRIMARY KEY({0}),", tKey);
  }
  else
  {
  	appendln(stringBuffer, "  PRIMARY KEY({0}),", genKeyName);
  }
}

    
  /*
   This class needs a lot of work, for every possible association type,
   a relationship between the different tables must be established.
   
   You may want to break these into separate files as the other projects do, 
   I.e:
    association_ManyToOne.jet
    association_MNToMany.jet 
    etc...
  */
  isFirst = true;
  for (AssociationVariable av : uClass.getAssociationVariables())
  {
    if (!av.getIsNavigable())
    {
      continue;
    }
    
    String attribute = av.isOne() ? gen.translate("attributeOne",av) : gen.translate("attributeMany",av);
 
    if (isFirst)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      appendln(stringBuffer,"  /*{0} Associations*/", gen.translate("type", uClass));
      isFirst = false;
    }
    
    if (av.isN() || av.isMandatoryOne())
    { 
      UmpleClass associatedUClass = av.getRelatedAssociation().getUmpleClass();
      for(int i = 0; i < av.getMultiplicity().getUpperBound(); i += 1)
      { 
	    for(String foreignPrimaryKeyName : associatedUClass.getKey().getMembers())
	    {
	      Attribute foreignPK = associatedUClass.getAttribute(foreignPrimaryKeyName);
	      if (foreignPK == null) //Check if the given key is a constant.
  	      {
  	        append(stringBuffer, "/*Warning: Constant attribute in associated class' Primary Key*/ ");
  	      }
  	      else
  	      {
	        appendln(stringBuffer, "  {0}_{1}{2} {3},", gen.translate("type", associatedUClass),
	                                                    gen.translate("attributeOne", foreignPK), 
	                                                    av.isN() ? "_" + i : "", 
	                                                    gen.translate("type", foreignPK));
	      }
	    }
      }
    }
    
  }

    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(gen.translate("packageDefinitionEnd",uClass));
    return stringBuffer.toString();
  }
}