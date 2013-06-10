/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.16.0.2388 modeling language!*/

package cruise.umple.compiler.exceptions;

/**
 * @umplesource UmpleExceptions.ump 25
 */
// line 25 "../../../../../src/UmpleExceptions.ump"
public class SemanticException extends RuntimeException
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SemanticException(String aStr, Exception aParent)
  {
    super(aStr, aParent);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  // line 29 ../../../../../src/UmpleExceptions.ump
  static final long serialVersionUID = 2;

}