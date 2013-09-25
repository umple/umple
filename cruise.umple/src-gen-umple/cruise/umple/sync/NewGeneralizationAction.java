/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.sync;
import cruise.umple.compiler.*;
import cruise.umple.util.*;

/**
 * @umplesource UmpleSync.ump 91
 * @umplesource UmpleSync_Code.ump 1242
 */
// line 91 "../../../../src/UmpleSync.ump"
// line 1242 "../../../../src/UmpleSync_Code.ump"
public class NewGeneralizationAction extends SynchronizationAction
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public NewGeneralizationAction(String aDeltaCode, String aUmpleCode)
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

  @umplesourcefile(line={1245},file={"UmpleSync_Code.ump"},javaline={42},length={69})
   public void go(){
    try
    {
      TextParser textParser = new TextParser(getUmpleCode());
      UmpleParser umpleParser = new UmpleInternalParser();
      ParseResult result = umpleParser.parse("program", getUmpleCode());

      if (!result.getWasSuccess())
      {
        textParser.insert("//Unable to update umple code due to error at " + result.getPosition());
        setUmpleCode(textParser.getText());
        return;
      }
      
      JsonParser jsonParser = new JsonParser("json");
      ParseResult jsonResult = jsonParser.parse("json", getDeltaCode());
      
      if (!jsonResult.getWasSuccess())
      {
        setUmpleCode("//Failed at: " + jsonResult.getPosition() + "\n\n//" + getDeltaCode() + "\n\n" + getUmpleCode());
        return;
      }
      
      Json json = jsonParser.analyze();
      
      String childId = json.getValue("childId");
      String parentId = json.getValue("parentId");
      boolean alreadyHasExtends = false;
      
      for(Token t : umpleParser.getRootToken().getSubTokens())
      {
        if (!t.is("classDefinition"))
        {
          continue;
        }
        
        if (!childId.equals(t.getValue("name")))
        {
          continue;
        }
        
        if (t.getSubToken("extendsName") != null)
        {
          alreadyHasExtends = true;
        }
        
        for (Token subT : t.getSubTokens())
        {
          if (subT.isStatic("{") && !alreadyHasExtends)
          {
            String newGeneralization = StringFormatter.format("  isA {0};\n",parentId);
            textParser.insertAfter(subT, newGeneralization);
          }
        }
        break;
      }
      setUmpleCode(textParser.getText());
    }
    catch (Exception e)
    {
      String output = "FATAL ERROR PARSING UMPLE DIAGRAM\n\n";
    
      for (StackTraceElement trace : e.getStackTrace())
      {
        output += trace.toString() + "\n";
      }
      setUmpleCode(output);
    }
  }

}