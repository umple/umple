/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource Generator_CodeSimpleMetrics.ump 680
 */
// line 680 "../../../../src/Generator_CodeSimpleMetrics.ump"
public class Format
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Format()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  //  @umplesourcefile(line={680},file={"Generator_CodeSimpleMetrics.ump"},javaline={37},length={8})
  @umplesourcefile(line={681},file={"Generator_CodeSimpleMetrics.ump"},javaline={38},length={7})
  public static String repeat(String string, int quantidade) {   
    StringBuffer retorno = new StringBuffer();   
    for (int j=0; j<quantidade; j++){   
      retorno.append(string);   
    }   
    return retorno.toString();   
  }

}