/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.umple.compiler;

/**
 * It is designed to visit different types of umple elemnts so it can process and understand
 * the defined walkers (@see IWalker). Any umple IWalker can use this visitor in order to ensure 
 * that the given visitor will be able to interact with the contents in temrs of being Umple-related
 * @umplesource Generator_UmpleModelWalker.ump 61
 */
// line 61 "../../../../src/Generator_UmpleModelWalker.ump"
public class UmpleModelVisitor
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleModelVisitor()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}

  @umplesourcefile(line={62},file={"Generator_UmpleModelWalker.ump"},javaline={37},length={3})
  public void visit(UmpleModel umpleModel){
    
  }


  /**
   * Comment
   */
  @umplesourcefile(line={65},file={"Generator_UmpleModelWalker.ump"},javaline={42},length={3})
  public void visit(Comment comment){
    
  }


  /**
   * Umple Classifiers
   */
  @umplesourcefile(line={68},file={"Generator_UmpleModelWalker.ump"},javaline={51},length={3})
  public void visit(UmpleElement umpleElement){
    
  }

  @umplesourcefile(line={69},file={"Generator_UmpleModelWalker.ump"},javaline={60},length={3})
  public void visit(UmpleClassifier umpleClassifier){
    
  }

  @umplesourcefile(line={70},file={"Generator_UmpleModelWalker.ump"},javaline={65},length={3})
  public void visit(UmpleClass umpleClass){
    
  }

  @umplesourcefile(line={71},file={"Generator_UmpleModelWalker.ump"},javaline={70},length={3})
  public void visit(UmpleInterface umpleInterface){
    
  }


  /**
   * Dependency
   */
  @umplesourcefile(line={74},file={"Generator_UmpleModelWalker.ump"},javaline={75},length={3})
  public void visit(Depend dependE){
    
  }

  @umplesourcefile(line={75},file={"Generator_UmpleModelWalker.ump"},javaline={84},length={3})
  public void visit(Package pkg){
    
  }

  @umplesourcefile(line={76},file={"Generator_UmpleModelWalker.ump"},javaline={89},length={3})
  public void visit(ClassPattern ptrn){
    
  }

  @umplesourcefile(line={77},file={"Generator_UmpleModelWalker.ump"},javaline={94},length={3})
  public void visit(Hierarchy hier){
    
  }


  /**
   * Types
   */
  @umplesourcefile(line={80},file={"Generator_UmpleModelWalker.ump"},javaline={99},length={3})
  public void visit(Type type){
    
  }

  @umplesourcefile(line={81},file={"Generator_UmpleModelWalker.ump"},javaline={108},length={3})
  public void visit(PrimitiveType primitiveType){
    
  }

  @umplesourcefile(line={82},file={"Generator_UmpleModelWalker.ump"},javaline={113},length={3})
  public void visit(ReferenceType referenceType){
    
  }


  /**
   * Attributes
   */
  @umplesourcefile(line={85},file={"Generator_UmpleModelWalker.ump"},javaline={118},length={3})
  public void visit(Constant cnst){
    
  }

  @umplesourcefile(line={86},file={"Generator_UmpleModelWalker.ump"},javaline={127},length={3})
  public void visit(Attribute attribute){
    
  }

  @umplesourcefile(line={87},file={"Generator_UmpleModelWalker.ump"},javaline={132},length={3})
  public void visit(Key keyO){
    
  }

  @umplesourcefile(line={88},file={"Generator_UmpleModelWalker.ump"},javaline={137},length={3})
  public void visit(ConstraintVariable cnstVar){
    
  }

  @umplesourcefile(line={89},file={"Generator_UmpleModelWalker.ump"},javaline={142},length={3})
  public void visit(UmpleVariable var){
    
  }

  @umplesourcefile(line={90},file={"Generator_UmpleModelWalker.ump"},javaline={147},length={3})
  public void visit(UniqueIdentifier uid){
    
  }


  /**
   * Methods
   */
  @umplesourcefile(line={93},file={"Generator_UmpleModelWalker.ump"},javaline={152},length={3})
  public void visit(Method method){
    
  }

  @umplesourcefile(line={94},file={"Generator_UmpleModelWalker.ump"},javaline={161},length={3})
  public void visit(MethodParameter param){
    
  }

  @umplesourcefile(line={95},file={"Generator_UmpleModelWalker.ump"},javaline={166},length={3})
  public void visit(MethodBody methodBody){
    
  }


  /**
   * Logical
   */
  @umplesourcefile(line={98},file={"Generator_UmpleModelWalker.ump"},javaline={171},length={3})
  public void visit(Condition cond){
    
  }

  @umplesourcefile(line={99},file={"Generator_UmpleModelWalker.ump"},javaline={180},length={3})
  public void visit(Precondition pre){
    
  }

  @umplesourcefile(line={100},file={"Generator_UmpleModelWalker.ump"},javaline={185},length={3})
  public void visit(Constraint constraint){
    
  }


  /**
   * Aspect
   */
  @umplesourcefile(line={103},file={"Generator_UmpleModelWalker.ump"},javaline={190},length={3})
  public void visit(CodeInjection codeInjection){
    
  }


  /**
   * Association
   */
  @umplesourcefile(line={106},file={"Generator_UmpleModelWalker.ump"},javaline={199},length={3})
  public void visit(Association associationE){
    
  }

  @umplesourcefile(line={107},file={"Generator_UmpleModelWalker.ump"},javaline={208},length={3})
  public void visit(AssociationClass associationC){
    
  }

  @umplesourcefile(line={108},file={"Generator_UmpleModelWalker.ump"},javaline={213},length={3})
  public void visit(AssociationEnd associationE){
    
  }

  @umplesourcefile(line={109},file={"Generator_UmpleModelWalker.ump"},javaline={218},length={3})
  public void visit(AssociationVariable var){
    
  }


  /**
   * Statemachine
   */
  @umplesourcefile(line={112},file={"Generator_UmpleModelWalker.ump"},javaline={223},length={3})
  public void visit(StateMachine sm){
    
  }

  @umplesourcefile(line={113},file={"Generator_UmpleModelWalker.ump"},javaline={232},length={3})
  public void visit(State state){
    
  }

  @umplesourcefile(line={114},file={"Generator_UmpleModelWalker.ump"},javaline={237},length={3})
  public void visit(Guard guard){
    
  }

  @umplesourcefile(line={115},file={"Generator_UmpleModelWalker.ump"},javaline={242},length={3})
  public void visit(Action action){
    
  }

  @umplesourcefile(line={116},file={"Generator_UmpleModelWalker.ump"},javaline={247},length={3})
  public void visit(Event event){
    
  }

  @umplesourcefile(line={117},file={"Generator_UmpleModelWalker.ump"},javaline={252},length={3})
  public void visit(Transition transition){
    
  }

  @umplesourcefile(line={118},file={"Generator_UmpleModelWalker.ump"},javaline={257},length={3})
  public void visit(Activity activity){
    
  }


  /**
   * Trace
   */
  @umplesourcefile(line={121},file={"Generator_UmpleModelWalker.ump"},javaline={262},length={3})
  public void visit(Tracer tracer){
    
  }

  @umplesourcefile(line={122},file={"Generator_UmpleModelWalker.ump"},javaline={271},length={3})
  public void visit(TraceDirective traceDirective){
    
  }

  @umplesourcefile(line={123},file={"Generator_UmpleModelWalker.ump"},javaline={276},length={3})
  public void visit(TraceItem traceItem){
    
  }

  @umplesourcefile(line={124},file={"Generator_UmpleModelWalker.ump"},javaline={281},length={3})
  public void visit(TraceRecord traceRecord){
    
  }

  @umplesourcefile(line={125},file={"Generator_UmpleModelWalker.ump"},javaline={286},length={3})
  public void visit(AttributeTraceItem attributeT){
    
  }

  @umplesourcefile(line={126},file={"Generator_UmpleModelWalker.ump"},javaline={291},length={3})
  public void visit(TraceCase traceCase){
    
  }

  @umplesourcefile(line={127},file={"Generator_UmpleModelWalker.ump"},javaline={296},length={3})
  public void visit(TraceCondition traceCondition){
    
  }

  @umplesourcefile(line={128},file={"Generator_UmpleModelWalker.ump"},javaline={301},length={3})
  public void visit(MethodTraceEntity methodTraceEntity){
    
  }

  @umplesourcefile(line={129},file={"Generator_UmpleModelWalker.ump"},javaline={306},length={3})
  public void visit(StateMachineTraceItem stateMachineTraceItem){
    
  }


  /**
   * User Code
   */
  @umplesourcefile(line={133},file={"Generator_UmpleModelWalker.ump"},javaline={311},length={3})
  public void visit(CodeBlock block){
    
  }

  @umplesourcefile(line={134},file={"Generator_UmpleModelWalker.ump"},javaline={320},length={3})
  public void visit(UserCode userCode){
    
  }


  /**
   * Visitor Events
   */
  @umplesourcefile(line={137},file={"Generator_UmpleModelWalker.ump"},javaline={325},length={3})
  public void done(){
    
  }

}