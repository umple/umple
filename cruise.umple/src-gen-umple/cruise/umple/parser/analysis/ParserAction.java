/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/
package cruise.umple.parser.analysis;
import java.util.*;
import cruise.umple.compiler.*;
import cruise.umple.parser.rules.*;

public interface ParserAction
{
  //method that will be called when this Action's token has been created successfully
  public void onSuccess(Token token, ParserDataPackage data);
}