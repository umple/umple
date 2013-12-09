/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.util.*;

/**
 * Local variables
 * @umplesource Generator_CodeUmple.ump 339
 */
// line 339 "../../../../src/Generator_CodeUmple.ump"
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
  //  @umplesourcefile(line={341},file={"Generator_CodeUmple.ump"},javaline={43},length={48})
  public int id = 0 ;

//  @umplesourcefile(line={342},file={"Generator_CodeUmple.ump"},javaline={46},length={45})
  public double candidateRulesSatisfied = 0 ;

//  @umplesourcefile(line={343},file={"Generator_CodeUmple.ump"},javaline={49},length={42})
  @umplesourcefile(line={344},file={"Generator_CodeUmple.ump"},javaline={50},length={41})
  public StringBuilder candidateCode = new StringBuilder() ;

//  @umplesourcefile(line={344},file={"Generator_CodeUmple.ump"},javaline={53},length={39})
  public double acceptedRulesSatisfied = 0 ;

//  @umplesourcefile(line={345},file={"Generator_CodeUmple.ump"},javaline={56},length={36})
  public StringBuilder acceptedCode = this.candidateCode ;

//  @umplesourcefile(line={346},file={"Generator_CodeUmple.ump"},javaline={59},length={33})
  @umplesourcefile(line={347},file={"Generator_CodeUmple.ump"},javaline={60},length={32})
  public HashMap<String,Object> state = new HashMap<String,Object>() ;

//  @umplesourcefile(line={347},file={"Generator_CodeUmple.ump"},javaline={63},length={30})
  public boolean isOptional = false ;

//  @umplesourcefile(line={348},file={"Generator_CodeUmple.ump"},javaline={66},length={27})
  public boolean candidateFailed = false ;

//  @umplesourcefile(line={349},file={"Generator_CodeUmple.ump"},javaline={69},length={24})
  public boolean acceptedFailed = true ;

//  @umplesourcefile(line={353},file={"Generator_CodeUmple.ump"},javaline={72},length={21})
  public HashMap<String,Integer> candidateIterators ;

//  @umplesourcefile(line={354},file={"Generator_CodeUmple.ump"},javaline={75},length={18})
  public HashMap<String,Integer> acceptedIterators ;

//  @umplesourcefile(line={356},file={"Generator_CodeUmple.ump"},javaline={78},length={15})
  @umplesourcefile(line={357},file={"Generator_CodeUmple.ump"},javaline={79},length={14})
  public Scope (int id, boolean isOptional) // scope for a grammar rule 
  {
    this.id = id;
      this.isOptional = isOptional;

      candidateIterators = new HashMap<String,Integer>();
      candidateIterators.put("Method", 0);
      candidateIterators.put("Parameter", 0);
      candidateIterators.put("Association", 0);
      candidateIterators.put("AssociationEnd", 0);
      candidateIterators.put("Attribute", 0);
      candidateIterators.put("Extends", 0);
      acceptedIterators = new HashMap<String, Integer>(candidateIterators);
  }

  
}