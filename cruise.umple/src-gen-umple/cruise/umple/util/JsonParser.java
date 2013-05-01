/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.util;
import cruise.umple.compiler.*;
import java.util.*;

/**
 * @umplesource Json.ump 12
 * @umplesource Json_Code.ump 12
 */
// line 12 "../../../../src/Json.ump"
// line 12 "../../../../src/Json_Code.ump"
public class JsonParser extends Parser
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public JsonParser(String aName)
  {
    super(aName);
    // line 15 "../../../../src/Json_Code.ump"
    init();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  // line 16 ../../../../src/Json_Code.ump
  private void init()
  {
    addCouple(new Couple("{", "}"));
    addRule("json : { } |  { [[json_entity]] ( , [[json_entity]] )* }");
    addRule("json_entity : [[name_json_array]] | [[name_array]] | [[name_json]] | [[name_value]] ");
    addRule("name_json_array : [[name]] : [  [[json]]  (, [[json]])*  ] ");
    addRule("name_array : [[name]] : [ [item] (, [item])*  ] ");
    addRule("name_json : [[name]] : [[json]]");
    addRule("name_value : [[name]] : [[value]]");
    addRule("name- : \" [**name] \" | [name] ");
    addRule("value- : \" [**value] \" | [value] ");
  }
  
  public Json analyze()
  {
    return handleJson(null,getRootToken());
  }
  
  private Json handleJsonEntity(Json json, Token t)
  {
    for(Token subT : t.getSubTokens())
    {
      if (subT.is("json") && json == null)
      {
        json = new Json("json",null);
        handleJson(json,subT);
      }
      else if (subT.is("json_entity"))
      {
        handleJsonEntity(json,subT);
      }
      else if (subT.is("name_value"))
      {
        String name = stripQuotes(subT.getValue("name"));
        String value = stripQuotes(subT.getValue("value"));
        json.addComposite(name,value);
      }
      else if (subT.is("name_json"))
      {
        String name = stripQuotes(subT.getValue("name"));
        Token next = subT.getSubToken("json");
        Json attr = new Json(name,null);
        json.addComposite(handleJson(attr,next));
      }
      else if (subT.is("name_json_array"))
      {
        String name = stripQuotes(subT.getValue("name"));
        Json array = new Json(name,null);
        
        for(Token jsonT : subT.getSubTokens())
        {
          if (jsonT.is("name") || jsonT.isStatic())
          {
            continue;
          }
          Json attr = new Json(null,null);
          
          handleJson(attr,jsonT);
          array.addComposite(attr);
        }
        json.addArray(array);
      }
      else if (subT.is("name_array"))
      {
        String name = stripQuotes(subT.getValue("name"));
        
        Json jsonArray = new Json(name,null);
        for(Token arrayT : subT.getSubTokens())
        {
          if (arrayT.is("item"))
          {
            jsonArray.addArrayEntity(arrayT.getValue());
          }
        }
        json.addArray(jsonArray);
      }
    }    
    return json;
  }
  
  private Json handleJson(Json json, Token t)
  {
    for(Token subT : t.getSubTokens())
    {
      if (subT.is("json") && json == null)
      {
        json = new Json("json",null);
        handleJson(json,subT);
      }
      else if (subT.is("json_entity"))
      {
        handleJsonEntity(json,subT);
      }
    }   
    return json;
  }
  
  private String stripQuotes(String input)
  {
    if (input == null)
    {
      return null;
    }
    
    input = input.startsWith("\"") ? input.substring(1) : input;
    input = input.endsWith("\"") ? input.substring(0,input.length()-1) : input;
    return input;
  }
}