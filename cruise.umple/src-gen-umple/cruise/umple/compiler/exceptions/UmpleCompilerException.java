/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler.exceptions;

/**
 * @umplesource UmpleExceptions.ump 17
 */
// line 17 "../../../../../src/UmpleExceptions.ump"
public class UmpleCompilerException extends RuntimeException
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

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
  //  @umplesourcefile(line={21},file={"UmpleExceptions.ump"},javaline={39},length={2})
  static final long serialVersionUID = 1 ;

  
}