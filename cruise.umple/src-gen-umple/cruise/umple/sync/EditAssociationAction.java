/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.sync;
import cruise.umple.compiler.*;
import cruise.umple.util.*;

/**
 * @umplesource UmpleSync.ump 66
 * @umplesource UmpleSync_Code.ump 835
 */
// line 66 "../../../../src/UmpleSync.ump"
// line 835 "../../../../src/UmpleSync_Code.ump"
public class EditAssociationAction extends SynchronizationAction
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public EditAssociationAction(String aDeltaCode, String aUmpleCode)
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

  @umplesourcefile(line={839},file={"UmpleSync_Code.ump"},javaline={42},length={171})
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
      
      Json position1 = json.getAttribute("offsetOnePosition");
      Json position2 = json.getAttribute("offsetTwoPosition");
      String class1 = json.getValue("classOneId");
      String x1 = position1.getValue("x");
      String y1 = position1.getValue("y");
      String x2 = position2.getValue("x");
      String y2 = position2.getValue("y");  
      String associationName = json.getValue("name");
      
	  Token lastAssociationPositionT = null;  
      Token classPositionT = null;
      boolean didEdit = false;
      boolean isInline = false;
      
      for(Token t : umpleParser.getRootToken().getSubTokens())
      {
        if (!t.is("classDefinition") && !t.is("associationClassDefinition"))
        {
          continue;
        }
        
        String currentClassName = t.getValue("name");
        Token currentClassPosition = t.getSubToken("elementPosition");
        
        if (!currentClassName.equals(class1))
        {
          continue;
        }
        
        if (currentClassPosition != null && currentClassName.equals(class1))
        {
          classPositionT = currentClassPosition;
        }
          
        for(Token subT : t.getSubTokens())
        {
          String currentName = "";
          String firstClassName = t.getValue("name");
    	  String secondClassName = "";
          String firstRole = "";
    	  String secondRole = "";
          
          if (subT.is("inlineAssociation"))
          {
            secondClassName = subT.getSubToken("associationEnd").getValue("type");
            firstRole = subT.getSubToken("inlineAssociationEnd").getValue("roleName");
    	    secondRole = subT.getSubToken("associationEnd").getValue("roleName");
    	    firstRole = firstRole == null? "" : ":" + firstRole; 
    	    secondRole = secondRole == null? "" : ":" + secondRole;
    	  
    	    String firstHalf = firstClassName + firstRole;
    	    String secondHalf = secondClassName + secondRole;
    	    
    	    if (firstHalf.compareTo(secondHalf) <= 0)
            {
              currentName = firstHalf + "__" + secondHalf;
            }
            else
            {
              currentName = secondHalf + "__" + firstHalf;
            }
            
            if (currentName.equals(associationName))
            {
              isInline = true;
            }
          }
          else if (subT.is("singleAssociationEnd"))
          {
            secondClassName = subT.getValue("type");
            secondRole = subT.getValue("roleName");
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
              isInline = true;
            }
          }
          
          if (!subT.is("associationPosition"))
          {
            continue;
          }
          
          lastAssociationPositionT = subT;
            
          if (!subT.getValue("name").equals(associationName))
          {
            continue;
          }
          
          Token coordinate1 = subT.getSubToken("coordinate",0);
          Token coordinate2 = subT.getSubToken("coordinate",1);
              
          textParser.replace(coordinate1.getSubToken("x"), x1);
          textParser.replace(coordinate1.getSubToken("y"), y1);
          textParser.replace(coordinate2.getSubToken("x"), x2);
          textParser.replace(coordinate2.getSubToken("y"), y2);
          
          didEdit = true;
          isInline = true;
          setUmpleCode(textParser.getText());
          break;
        }
      }   
      
      if (isInline && !didEdit && lastAssociationPositionT != null)
      {
        textParser.insertAfter(lastAssociationPositionT, StringFormatter.format("  position.association {0} {1},{2} {3},{4};\n",associationName,x1,y1,x2,y2));
        didEdit = true;
        setUmpleCode(textParser.getText());
      }
         
      else if (isInline && !didEdit && classPositionT != null)
      {
        textParser.insertAfter(classPositionT, StringFormatter.format("  position.association {0} {1},{2} {3},{4};\n",associationName,x1,y1,x2,y2));
        didEdit = true;
        setUmpleCode(textParser.getText());
      }
    
      else if (isInline && !didEdit)
      {
        String newUmple = getUmpleCode();
        if (newUmple.length() > 0)
        {
          newUmple += "\n";
        }
        newUmple += StringFormatter.format("class {0}\n{1}\n  position.association {2} {3},{4} {5},{6};\n{7}\n",class1,"{",associationName,x1,y1,x2,y2,"}");
        setUmpleCode(newUmple);
      }
      
    }
    catch (Exception e)
    {
      handleException(e);
    }
  }

  @umplesourcefile(line={1012},file={"UmpleSync_Code.ump"},javaline={215},length={10})
   private boolean handleException(Exception e){
    String output = "FATAL ERROR PARSING UMPLE DIAGRAM\n\n";
    
    for (StackTraceElement trace : e.getStackTrace())
    {
      output += trace.toString() + "\n";
    }
    setUmpleCode(output);
    return false;
  }

}