/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.parser.analysis;
import java.lang.reflect.*;
import java.lang.reflect.Method;
import java.util.*;
import cruise.umple.compiler.*;

/**
 * Abstract class which gives has two major components:
 * a hashmap of Methods and a hashmap of Objects
 * it also contains a method called analyze which performs analysis on a token by taking all of its subtokens and finding a method name
 * corresponding to the token's name, and then calling that function with the subtoken as parameter.
 * The hashmap of objects is mainly estetic, where the idea is that you get and set and nothing else from this hashmap
 * @umplesource GrammarParsing.ump 8
 * @umplesource GrammarParsing_Code.ump 1
 */
// line 8 "../../../../../src/GrammarParsing.ump"
// line 1 "../../../../../src/GrammarParsing_Code.ump"
public class Analyzer
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Analyzer Attributes
  private boolean done;
  private boolean first;
  private HashMap<String,Method> handlers;
  private HashMap<String,Object> global;
  private Token rootToken;
  private ParserDataPackage data;
  private Position failedPosition;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Analyzer()
  {
    done = false;
    first = true;
    handlers = new HashMap<String,Method>();
    global = new HashMap<String,Object>();
    rootToken = null;
    data = null;
    failedPosition = null;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDone(boolean aDone)
  {
    boolean wasSet = false;
    done = aDone;
    wasSet = true;
    return wasSet;
  }

  public boolean setFirst(boolean aFirst)
  {
    boolean wasSet = false;
    first = aFirst;
    wasSet = true;
    return wasSet;
  }

  public boolean setHandlers(HashMap<String,Method> aHandlers)
  {
    boolean wasSet = false;
    handlers = aHandlers;
    wasSet = true;
    return wasSet;
  }

  public boolean setGlobal(HashMap<String,Object> aGlobal)
  {
    boolean wasSet = false;
    global = aGlobal;
    wasSet = true;
    return wasSet;
  }

  public boolean setRootToken(Token aRootToken)
  {
    boolean wasSet = false;
    rootToken = aRootToken;
    wasSet = true;
    return wasSet;
  }

  public boolean setData(ParserDataPackage aData)
  {
    boolean wasSet = false;
    data = aData;
    wasSet = true;
    return wasSet;
  }

  public boolean setFailedPosition(Position aFailedPosition)
  {
    boolean wasSet = false;
    failedPosition = aFailedPosition;
    wasSet = true;
    return wasSet;
  }

  public boolean getDone()
  {
    return done;
  }

  public boolean getFirst()
  {
    return first;
  }

  /**
   * HashMap of all the methods of this class
   */
  public HashMap<String,Method> getHandlers()
  {
    return handlers;
  }

  /**
   * hashmap of global variables(local to the class, not local to methods)
   */
  public HashMap<String,Object> getGlobal()
  {
    return global;
  }

  /**
   * rootToken which will be the result of the parsing of the umple file passed
   */
  public Token getRootToken()
  {
    return rootToken;
  }

  /**
   * the data package used during the parsing.
   */
  public ParserDataPackage getData()
  {
    return data;
  }

  /**
   * the failed position, if there was one, it will remain null if the parse was successful
   */
  public Position getFailedPosition()
  {
    return failedPosition;
  }

  public void delete()
  {}


  /**
   * This funciton is used for putting things into the global hashmap that contains all objects
   */
  @umplesourcefile(line={8},file={"GrammarParsing_Code.ump"},javaline={169},length={3})
   protected void set(String string, Object object){
    global.put(string, object);
  }


  /**
   * This function goes through all the subtokens and invokes this analyzer's method(if it exists) which has the same name as the token
   */
  @umplesourcefile(line={15},file={"GrammarParsing_Code.ump"},javaline={178},length={24})
   public void analyze(Token tokens){
    for(Token token: tokens.getSubTokens())
    {
      if(handlers.get(token.getName())!=null)
      {
        try
        {
          handlers.get(token.getName()).invoke(this,token);
        }
        catch (IllegalArgumentException e)
        {
          e.printStackTrace();
        } 
        catch (IllegalAccessException e)
        {
          e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
          e.printStackTrace();
        }
      }
    }
  }


  /**
   * abstract method for executing the rootrule onto the umplefile(for example)
   */
  @umplesourcefile(line={43},file={"GrammarParsing_Code.ump"},javaline={208},length={3})
   public void execute(){
    
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "done" + ":" + getDone()+ "," +
            "first" + ":" + getFirst()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "handlers" + "=" + (getHandlers() != null ? !getHandlers().equals(this)  ? getHandlers().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "global" + "=" + (getGlobal() != null ? !getGlobal().equals(this)  ? getGlobal().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "rootToken" + "=" + (getRootToken() != null ? !getRootToken().equals(this)  ? getRootToken().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "data" + "=" + (getData() != null ? !getData().equals(this)  ? getData().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "failedPosition" + "=" + (getFailedPosition() != null ? !getFailedPosition().equals(this)  ? getFailedPosition().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={47},file={"GrammarParsing_Code.ump"},javaline={233},length={12})
  public class Getter<T> 
  {
  @umplesourcefile(line={50},file={"GrammarParsing_Code.ump"},javaline={236},length={3})
    public Getter()
    {
    }
    @SuppressWarnings("unchecked")
  @umplesourcefile(line={54},file={"GrammarParsing_Code.ump"},javaline={241},length={4})
    public T get(String name)
    {
      return ((T)global.get(name));
    }
  }

  
}