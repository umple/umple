/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.13.0.605 modeling language!*/

package cruise.umple.sync;
import cruise.umple.compiler.*;
import cruise.umple.util.*;

public class DeleteAssociationAction extends SynchronizationAction
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DeleteAssociationAction(String aDeltaCode, String aUmpleCode)
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
  
  public void go()
  {
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
      
      String associationName = json.getValue("name");
      String classOfAssociationDefinition = json.getValue("classOneId");
      
      boolean didDeletePosition = false;
      for(Token t : umpleParser.getRootToken().getSubTokens())
      {
        if (!t.is("classDefinition"))
        {
          continue;
        }
  
        if (!t.getValue("name").equals(classOfAssociationDefinition))
        {
          continue;
        }
        
        for(Token positionT : t.getSubTokens())
        {
          if (!positionT.is("associationPosition"))
          {
            continue;
          }
          
          if (!positionT.getValue("name").equals(associationName))
          {
            continue;
          }
          
          textParser.replace(positionT, "");
          didDeletePosition = true;
          break;
        }
        
        if (didDeletePosition)
        {
          break;
        }
      }   
      
      boolean didDeleteDefinition = false;
      for (Token t : umpleParser.getRootToken().getSubTokens())
      {
        if (!t.is("classDefinition"))
        {
          continue;
        }
        
        if (!t.getValue("name").equals(classOfAssociationDefinition))
        {
          continue;
        }
        
        for (Token subT : t.getSubTokens())
        {
          if (!subT.is("inlineAssociation"))
          {
            continue;
          }
          
          String currentName = "";
          String firstClassName = t.getValue("name");
          String secondClassName = subT.getSubToken("associationEnd").getValue("type");
          String firstRole = subT.getSubToken("inlineAssociationEnd").getValue("roleName");
          String secondRole = subT.getSubToken("associationEnd").getValue("roleName");
          firstRole = firstRole == null? "" : ":" + firstRole; 
          secondRole = secondRole == null? "" : ":" + secondRole;
          
          if (firstClassName.compareTo(secondClassName) < 0)
          {
            currentName = firstClassName + firstRole + "__" + secondClassName + secondRole;
          }
          else
          {
            currentName = secondClassName + secondRole + "__" + firstClassName + firstRole;
          }
          
          if (currentName.equals(associationName))
          {
            textParser.replace(subT, "");
            classOfAssociationDefinition = t.getValue("name");
            didDeleteDefinition = true;
            break;
          }
        }
        
        if (didDeleteDefinition)
        {
          break;
        }
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