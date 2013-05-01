/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler.exceptions;

/**
 * @umplesource UmpleExceptions.ump 18
 */
// line 18 "../../../../../src/UmpleExceptions.ump"
public class UmpleCompilerException extends RuntimeException
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleCompilerException(String aStr, Exception aParent)
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
  
  // line 22 ../../../../../src/UmpleExceptions.ump
  static final long serialVersionUID = 1;
}