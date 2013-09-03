/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.sync;
import cruise.umple.compiler.*;
import cruise.umple.util.*;
import java.util.*;

/**
 * @umplesource UmpleSync.ump 20
 * @umplesource UmpleSync_Code.ump 23
 */
// line 20 "../../../../src/UmpleSync.ump"
// line 23 "../../../../src/UmpleSync_Code.ump"
public class UpdatePositioningAction extends SynchronizationAction
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UpdatePositioningAction Attributes
  private UmpleParser umpleParser;
  private TextParser textParser;
  private JsonParser jsonParser;
  private Json json;
  private List<String> addedPositions;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UpdatePositioningAction(String aDeltaCode, String aUmpleCode)
  {
    super(aDeltaCode, aUmpleCode);
    umpleParser = null;
    textParser = null;
    jsonParser = null;
    json = null;
    addedPositions = new ArrayList<String>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

  @umplesourcefile(line={26},file={"UmpleSync_Code.ump"},javaline={55},length={32})
   public void go(){
    try
    {
      textParser = new TextParser(getUmpleCode());
      umpleParser = new UmpleInternalParser();
      ParseResult result = umpleParser.parse("program", getUmpleCode());

      if (!result.getWasSuccess())
      {
        //uncomment for testing purposes
        //textParser.insert("//Unable to update umple code due to error at " + result.getPosition());
        return;
      }
      
      jsonParser = new JsonParser("json");
      ParseResult jsonResult = jsonParser.parse("json", getDeltaCode());
      
      if (!jsonResult.getWasSuccess())
      {
        //uncomment for testing purposes
        //setUmpleCode("//****Failed at: " + jsonResult.getPosition() + "\n\n//" + getDeltaCode() + "\n\n" + getUmpleCode());
        return;
      }
      json = jsonParser.analyze();
      verifySubClasses(umpleParser.getRootToken());
      
    }
    catch (Exception e)
    {
      handleException(e, "yo5");
    }
  }

  @umplesourcefile(line={60},file={"UmpleSync_Code.ump"},javaline={89},length={31})
   private void verifySubClasses(Token root){
    try
    {
      for (Token t : root.getSubTokens())
      {
        if (!t.is("classDefinition") && !t.is("associationClassDefinition"))
        {
          continue;
        }
        
        if (!classHasPositioning(umpleParser.getRootToken(), t))
        {
          addPositioning(t);
        }
        else if (!classHasDefinition(umpleParser.getRootToken(), t))
        {
          textParser.replace(t, "");
          setUmpleCode(textParser.getText());
        }
                
        if (t.hasSubTokens())
        {
          verifySubClasses(t);
        }
      }
    }
    catch (Exception e)
    {
      handleException(e, "yo4");
    }
  }

  @umplesourcefile(line={93},file={"UmpleSync_Code.ump"},javaline={122},length={35})
   private boolean classHasPositioning(Token root, Token t){
    boolean hasPositioning = false;
    try
    {
      String targetClassName = t.getValue("name");
      
      if (addedPositions.contains(targetClassName))
      {
        return true;
      }
      
      for (Token classT : root.getSubTokens())
      {
        if (!classT.is("classDefinition") && !classT.is("associationClassDefinition"))
        {
          continue;
        }
        if (!classT.getValue("name").equals(targetClassName))
        {
          continue;
        }
        if (classT.getSubToken("elementPosition") == null)
        {
          continue;
        }
        hasPositioning = true;
        break;
      }
    }
    catch (Exception e)
    {
      handleException(e, "yo3");
    }
    return hasPositioning;
  }

  @umplesourcefile(line={131},file={"UmpleSync_Code.ump"},javaline={159},length={38})
   private boolean classHasDefinition(Token root, Token t){
    try
    {
      String targetClassName = t.getValue("name");
      for (Token classT : root.getSubTokens())
      {
        if (!classT.is("classDefinition") && !classT.is("associationClassDefinition"))
        {
          continue;
        }
        
        if (classT.hasSubTokens())
        {
          if (classHasDefinition(classT, t))
          {
            return true;
          }
        }
        
        if (!classT.getValue("name").equals(targetClassName))
        {
          continue;
        }
        
        if (classT.getSubToken("elementPosition") != null)
        {
          continue;
        }
        
        return true;
      }
    }
    catch (Exception e)
    {
      handleException(e, "yo");
    }
    return false;
  }

  @umplesourcefile(line={171},file={"UmpleSync_Code.ump"},javaline={199},length={46})
   private void addPositioning(Token classT){
    try
    {
      addedPositions.add(classT.getValue("name"));
      Json[] jsonClasses = json.getArray("umpleClasses");
      String targetClassName = classT.getValue("name");
      for (Json jsonClass : jsonClasses)
      {
        String jsonName = jsonClass.getValue("name");
        if (jsonName.equals(targetClassName))
        {
          Json jsonPosition = jsonClass.getAttribute("position");
          String x = jsonPosition.getValue("x");
          String y = jsonPosition.getValue("y");
          String width = jsonPosition.getValue("width");
          String height = jsonPosition.getValue("height");
        
          String newUmple = getUmpleCode();
          if (newUmple.length() > 0)
          {
            newUmple += "\n";
          }
          
          //String umpleClassType = "";
          //if (classT.is("associationClassDefinition"))
          //{
          //  umpleClassType = "associationClass";
          //}
          //else if (classT.is("classDefinition"))
          //{
          //  umpleClassType = "class";
          //}
          //String newPosition = StringFormatter.format("{0} {1}\n{\n  position {2} {3} {4} {5};\n}\n", umpleClassType, targetClassName, x, y, width, height);
          
          String newPosition = StringFormatter.format("{0} {1}\n{\n  position {2} {3} {4} {5};\n}\n", "class", targetClassName, x, y, width, height);
           
          newUmple += newPosition;
          setUmpleCode(newUmple);
        }
      }
    }
    catch (Exception e)
    {
      handleException(e, "yo2");
    }
  }

  @umplesourcefile(line={219},file={"UmpleSync_Code.ump"},javaline={247},length={8})
   private void handleException(Exception e, String message){
    String output = "FATAL ERROR PARSING UMPLE DIAGRAM\n\n";
    for (StackTraceElement trace : e.getStackTrace())
    {
      output += trace.toString() + "\n";
    }
    setUmpleCode(message + " " + output);
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]"
     + outputString;
  }
}