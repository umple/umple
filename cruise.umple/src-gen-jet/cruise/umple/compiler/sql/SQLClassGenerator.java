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
  protected final String TEXT_5 = NL + "CREATE TABLE ";
  protected final String TEXT_6 = " (" + NL;
  protected final String TEXT_7 = NL + "  " + NL + ");";
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
     if (uClass.numberOfComments() > 0) { if(!uClass.getComments().get(0).isInline) {append(stringBuffer, "\n{0}", Comment.format("RubyMultiline",uClass.getComments()));} else { append(stringBuffer, "\n{0}", Comment.format("Hash",uClass.getComments()));} } 
    stringBuffer.append(TEXT_5);
    stringBuffer.append(uClass.getName() );
    stringBuffer.append( gen.translate("isA",uClass) /* a bit of work needs to be done here, if we inherit, do we just add those attributes to the table?*/ );
    stringBuffer.append(TEXT_6);
    
  
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
  
    if (!av.isConstant() && !av.getIsAutounique())
    {
      continue;
    }

    if (isFirst)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      appendln(stringBuffer, "  -------------------------");
      appendln(stringBuffer, "  -- STATIC VARIABLES");
      appendln(stringBuffer, "  -------------------------");
      isFirst = false;
    }
  
    if (av.isConstant())
    {
      appendln(stringBuffer, "");
      append(stringBuffer, "  {0} = {1};", gen.translate("attributeConstant",av), gen.translate("parameterValue",av));
    }
    else if (av.getIsAutounique())
    {
      String defaultValue = av.getValue() == null ? "1" : av.getValue();
      appendln(stringBuffer, "");
      append(stringBuffer, "  @@{0} = {1}", gen.translate("parameterNext",av), defaultValue);
    }
  }
  

    
{
  appendln(stringBuffer, "  --------------------------");
  appendln(stringBuffer, "  -- MEMBER VARIABLES");
  append(stringBuffer, "  --------------------------");

  isFirst = true;
  for(Attribute av : uClass.getAttributes())
  {
    if (av.isConstant() || av.getIsAutounique() || av.getIsDerived())
    {
      continue;
    }
    if (isFirst)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      append(stringBuffer,"  --{0} Attributes", uClass.getName());
      isFirst = false;
    }
    
    String type = gen.translate("type",av);
    String attribute = gen.translate("attributeOne",av);
    
    if (av.getIsList())
    {
      attribute = gen.translate("attributeMany",av);
      type = StringFormatter.format("List<{0}>",gen.translate("typeMany",av));
    }

    appendln(stringBuffer, "");
    append(stringBuffer, "  {0} {1},", attribute, type);
  }
  
  isFirst = true;
  for(Attribute av : uClass.getAttributes())
  {
    if (!av.getIsAutounique())
    {
      continue;
    }
    if (isFirst)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      append(stringBuffer,"  --Autounique Attributes");
      isFirst = false;
    }
    appendln(stringBuffer, "");
    append(stringBuffer, "   {0} INTEGER AUTO INCREMENT,", gen.translate("attributeOne",av));
  }
  String tKey = "";
  for(String key : uClass.getKey().getMembers()){
		  tKey += key + ", ";
  }
  append(stringBuffer, "   PRIMARY KEY({0}),", tKey);
}

    
  /*
   This class needs a lot of work, for every possible assoxciation type,
   a relationship between the different tables must be established.
   
   You may want to break these into seperate files as the other projects do, 
   I.e:
    association_ManyToOne.jet
    association_MNToMany.jet 
    etc...
    
    I've left it as it appears from the ruby generator.
  */
  boolean isFirstAssociation = true;
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
      appendln(stringBuffer, "  #------------------------");
      appendln(stringBuffer, "  # MEMBER VARIABLES");
      append(stringBuffer, "  #------------------------");
      isFirst = false;
    }
    
    if (isFirstAssociation)
    {
      appendln(stringBuffer, "");
      appendln(stringBuffer, "");
      appendln(stringBuffer,"  #{0} Associations - for documentation purposes", uClass.getName());
      append(stringBuffer,"  #attr_reader :{0}",attribute);
      isFirstAssociation = false;
    }
    else
    {
      append(stringBuffer,", :{0}",attribute);
    }
  }

    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(gen.translate("packageDefinitionEnd",uClass));
    return stringBuffer.toString();
  }
}