/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.sync;
import cruise.umple.compiler.*;
import cruise.umple.util.*;

/**
 * @umplesource UmpleSync.ump 82
 * @umplesource UmpleSync_Code.ump 1159
 */
// line 82 "../../../../src/UmpleSync.ump"
// line 1159 "../../../../src/UmpleSync_Code.ump"
public class DeleteGeneralizationAction extends SynchronizationAction
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DeleteGeneralizationAction(String aDeltaCode, String aUmpleCode)
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

  @umplesourcefile(line={1165},file={"UmpleSync_Code.ump"},javaline={43},length={76})
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
        
        Token isAToken = null;
        Token semicolonToken = null;
        Token extendsNameToken = t.getSubToken("extendsName");
        
        if (extendsNameToken == null)
        {
          continue;
        }
        
        int i = 0;
        for(Token subT : t.getSubTokens())
        {
          if (subT.is("extendsName"))
          {
            extendsNameToken = subT;
            semicolonToken = t.getSubToken(i+1);
            isAToken = t.getSubToken(i-1);
            break;
          }
          i += 1;
        }
        textParser.replace(isAToken,"");
        textParser.replace(extendsNameToken,"");
        textParser.replace(semicolonToken,"");
      }
      setUmpleCode(textParser.getText());
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