/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;

/**
 * @umplesource SimpleMetrics_Util.ump 28
 */
// line 28 "../../../../src/SimpleMetrics_Util.ump"
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

  @umplesourcefile(line={31},file={"SimpleMetrics_Util.ump"},javaline={35},length={7})
   public static  String repeat(String string, int quantidade){
    StringBuffer retorno = new StringBuffer();   
    for (int j=0; j<quantidade; j++){   
      retorno.append(string);   
    }   
    return retorno.toString();
  }

}