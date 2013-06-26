/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.sync;
import cruise.umple.util.*;
import cruise.umple.compiler.*;

/**
 * @umplesource UmpleSync.ump 33
 * @umplesource UmpleSync_Code.ump 230
 */
// line 33 "../../../../src/UmpleSync.ump"
// line 230 "../../../../src/UmpleSync_Code.ump"
public class NewAction extends SynchronizationAction
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public NewAction(String aDeltaCode, String aUmpleCode)
  {
    super(aDeltaCode, aUmpleCode);
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
  //  @umplesourcefile(line={232},file={"UmpleSync_Code.ump"},javaline={45},length={103})
  @umplesourcefile(line={233},file={"UmpleSync_Code.ump"},javaline={46},length={102})
  public void go()
  {
    try
    {
      TextParser textParser = new TextParser(getUmpleCode());
      UmpleParser umpleParser = new UmpleInternalParser();
      ParseResult result = umpleParser.parse("program", getUmpleCode());

      JsonParser parser = new JsonParser("json");
      ParseResult jsonResult = parser.parse("json", getDeltaCode());
      Json json = parser.analyze();
      
      if (!result.getWasSuccess())
      {
        //textParser.insert("//Unable to update umple code due to error at " + result.getPosition());
        //setUmpleCode(textParser.getText());
        //return;
      }
      
      if (!jsonResult.getWasSuccess())
      {
        //setUmpleCode("//Failed at: " + jsonResult.getPosition() + "\n\n//" + getDeltaCode() + "\n\n" + getUmpleCode());
        //return;
      }

      Json position = json.getAttribute("position");
      String className = json.getValue("name");
      String x = position.getValue("x");
      String y = position.getValue("y");
      String width = position.getValue("width");
      String height = position.getValue("height");
      String delimiter = "$?[End_of_model]$?";
      
      Token addAfterModel = null;
      for (Token t : umpleParser.getRootToken().getSubTokens())
      {
        // inlineComment has two tokens: "//" and "comment text"
        // we need to add the new class after the "comment text"
        if (t.isStatic("//") || t.isStatic("/*"))
        {
          continue;
        }
        
        if (t.is("inlineComment")|| t.is("multilineComment"))
        {
          if (!t.isValue(delimiter))
          {
            addAfterModel = t;
            continue;
          }
          break;
        }
        
        if (!t.is("classDefinition"))
        {
          addAfterModel = t;
          continue;
        }
          
        if (t.getSubToken("elementPosition") == null)
        {
          addAfterModel = t;
          continue;
        }
        break;
      }
      
      boolean didAddInModel = false;
      String newClassForModel = StringFormatter.format("class {0}\n{\n}\n\n", className);
      if (addAfterModel != null)
      {
        textParser.insertAfter(addAfterModel, newClassForModel);
        setUmpleCode(textParser.getText());
        didAddInModel = true;
      }
    
      String newUmple = getUmpleCode();
      if (newUmple.length() > 0)
      {
        newUmple += "\n";
      }
    
      if (!didAddInModel)
      {
        newUmple = newClassForModel + newUmple;
      }
      newUmple += StringFormatter.format("class {0}\n{\n  position {1} {2} {3} {4};\n}\n", className, x, y, width, height);
      setUmpleCode(newUmple);
    }
    
    catch (Exception e)
    {
      e.printStackTrace();
      String output = "FATAL ERROR PARSING UMPLE DIAGRAM\n\n";
    
      for (StackTraceElement trace : e.getStackTrace())
      {
        output += trace.toString() + "\n";
      }
      setUmpleCode(output);
    }
  }

}