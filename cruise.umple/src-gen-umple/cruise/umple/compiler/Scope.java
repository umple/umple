/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Local variables
 * @umplesource Generator_CodeUmple.ump 314
 */
// line 314 "../../../../src/Generator_CodeUmple.ump"
public class Scope extends UmpleGenerator
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Scope()
  {
    super();
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
  //  @umplesourcefile(line={316},file={"Generator_CodeUmple.ump"},javaline={43},length={27})
  public int id = 0 ;

//  @umplesourcefile(line={317},file={"Generator_CodeUmple.ump"},javaline={46},length={24})
  public double candidateRulesSatisfied = 0 ;

//  @umplesourcefile(line={318},file={"Generator_CodeUmple.ump"},javaline={49},length={21})
  @umplesourcefile(line={319},file={"Generator_CodeUmple.ump"},javaline={50},length={20})
  public StringBuilder candidateCode = new StringBuilder() ;

//  @umplesourcefile(line={319},file={"Generator_CodeUmple.ump"},javaline={53},length={18})
  public double acceptedRulesSatisfied = this.candidateRulesSatisfied ;

//  @umplesourcefile(line={320},file={"Generator_CodeUmple.ump"},javaline={56},length={15})
  public StringBuilder acceptedCode = this.candidateCode ;

//  @umplesourcefile(line={321},file={"Generator_CodeUmple.ump"},javaline={59},length={12})
  @umplesourcefile(line={322},file={"Generator_CodeUmple.ump"},javaline={60},length={11})
  public HashMap<String,Object> state = new HashMap<String,Object>() ;

//  @umplesourcefile(line={322},file={"Generator_CodeUmple.ump"},javaline={63},length={9})
  public boolean isOptional = false ;

//  @umplesourcefile(line={324},file={"Generator_CodeUmple.ump"},javaline={66},length={6})
  @umplesourcefile(line={325},file={"Generator_CodeUmple.ump"},javaline={67},length={5})
  public Scope (int id, boolean isOptional) // scope for a grammar rule 
  {
    this.id = id;
        this.isOptional = isOptional;
  }

  
}