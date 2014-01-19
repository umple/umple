/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;

/**
 * It is designed to visit different types of umple elemnts so it can process and understand
 * the defined walkers (@see IWalker). Any umple IWalker can use this visitor in order to ensure 
 * that the given visitor will be able to interact with the contents in temrs of being Umple-related
 * It is designed to visit different types of umple elemnts so it can process and understand
 * the defined walkers (@see IWalker). Any umple IWalker can use this visitor in order to ensure 
 * that the given visitor will be able to interact with the contents in temrs of being Umple-related
 * @umplesource Generator_UmpleModelWalker.ump 60
 */
// line 60 "../../../../src/Generator_UmpleModelWalker.ump"
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

  @umplesourcefile(line={62},file={"Generator_UmpleModelWalker.ump"},javaline={41},length={3})
  public void visit(UmpleModel umpleModel){
    
  }


  /**
   * Comment
   */
  @umplesourcefile(line={65},file={"Generator_UmpleModelWalker.ump"},javaline={46},length={3})
  public void visit(Comment comment){
    
  }


  /**
   * Umple Classifiers
   */
  @umplesourcefile(line={68},file={"Generator_UmpleModelWalker.ump"},javaline={55},length={3})
  public void visit(UmpleElement umpleElement){
    
  }

  @umplesourcefile(line={69},file={"Generator_UmpleModelWalker.ump"},javaline={64},length={3})
  public void visit(UmpleClassifier umpleClassifier){
    
  }

  @umplesourcefile(line={70},file={"Generator_UmpleModelWalker.ump"},javaline={69},length={3})
  public void visit(UmpleClass umpleClass){
    
  }

  @umplesourcefile(line={71},file={"Generator_UmpleModelWalker.ump"},javaline={74},length={3})
  public void visit(UmpleInterface umpleInterface){
    
  }


  /**
   * Dependency
   */
  @umplesourcefile(line={74},file={"Generator_UmpleModelWalker.ump"},javaline={79},length={3})
  public void visit(Depend dependE){
    
  }

  @umplesourcefile(line={75},file={"Generator_UmpleModelWalker.ump"},javaline={88},length={3})
  public void visit(Package pkg){
    
  }

  @umplesourcefile(line={76},file={"Generator_UmpleModelWalker.ump"},javaline={93},length={3})
  public void visit(ClassPattern ptrn){
    
  }

  @umplesourcefile(line={77},file={"Generator_UmpleModelWalker.ump"},javaline={98},length={3})
  public void visit(Hierarchy hier){
    
  }


  /**
   * Types
   */
  @umplesourcefile(line={80},file={"Generator_UmpleModelWalker.ump"},javaline={103},length={3})
  public void visit(Type type){
    
  }

  @umplesourcefile(line={81},file={"Generator_UmpleModelWalker.ump"},javaline={112},length={3})
  public void visit(PrimitiveType primitiveType){
    
  }

  @umplesourcefile(line={82},file={"Generator_UmpleModelWalker.ump"},javaline={117},length={3})
  public void visit(ReferenceType referenceType){
    
  }


  /**
   * Attributes
   */
  @umplesourcefile(line={85},file={"Generator_UmpleModelWalker.ump"},javaline={122},length={3})
  public void visit(Constant cnst){
    
  }

  @umplesourcefile(line={86},file={"Generator_UmpleModelWalker.ump"},javaline={131},length={3})
  public void visit(Attribute attribute){
    
  }

  @umplesourcefile(line={87},file={"Generator_UmpleModelWalker.ump"},javaline={136},length={3})
  public void visit(Key keyO){
    
  }

  @umplesourcefile(line={88},file={"Generator_UmpleModelWalker.ump"},javaline={141},length={3})
  public void visit(ConstraintVariable cnstVar){
    
  }

  @umplesourcefile(line={89},file={"Generator_UmpleModelWalker.ump"},javaline={146},length={3})
  public void visit(UmpleVariable var){
    
  }

  @umplesourcefile(line={90},file={"Generator_UmpleModelWalker.ump"},javaline={151},length={3})
  public void visit(UniqueIdentifier uid){
    
  }


  /**
   * Methods
   */
  @umplesourcefile(line={93},file={"Generator_UmpleModelWalker.ump"},javaline={156},length={3})
  public void visit(Method method){
    
  }

  @umplesourcefile(line={94},file={"Generator_UmpleModelWalker.ump"},javaline={165},length={3})
  public void visit(MethodParameter param){
    
  }

  @umplesourcefile(line={95},file={"Generator_UmpleModelWalker.ump"},javaline={170},length={3})
  public void visit(MethodBody methodBody){
    
  }


  /**
   * Logical
   */
  @umplesourcefile(line={98},file={"Generator_UmpleModelWalker.ump"},javaline={175},length={3})
  public void visit(Condition cond){
    
  }

  @umplesourcefile(line={99},file={"Generator_UmpleModelWalker.ump"},javaline={184},length={3})
  public void visit(Precondition pre){
    
  }

  @umplesourcefile(line={100},file={"Generator_UmpleModelWalker.ump"},javaline={189},length={3})
  public void visit(Constraint constraint){
    
  }


  /**
   * Aspect
   */
  @umplesourcefile(line={103},file={"Generator_UmpleModelWalker.ump"},javaline={194},length={3})
  public void visit(CodeInjection codeInjection){
    
  }


  /**
   * Association
   */
  @umplesourcefile(line={106},file={"Generator_UmpleModelWalker.ump"},javaline={203},length={3})
  public void visit(Association associationE){
    
  }

  @umplesourcefile(line={107},file={"Generator_UmpleModelWalker.ump"},javaline={212},length={3})
  public void visit(AssociationClass associationC){
    
  }

  @umplesourcefile(line={108},file={"Generator_UmpleModelWalker.ump"},javaline={217},length={3})
  public void visit(AssociationEnd associationE){
    
  }

  @umplesourcefile(line={109},file={"Generator_UmpleModelWalker.ump"},javaline={222},length={3})
  public void visit(AssociationVariable var){
    
  }


  /**
   * Statemachine
   */
  @umplesourcefile(line={112},file={"Generator_UmpleModelWalker.ump"},javaline={227},length={3})
  public void visit(StateMachine sm){
    
  }

  @umplesourcefile(line={113},file={"Generator_UmpleModelWalker.ump"},javaline={236},length={3})
  public void visit(State state){
    
  }

  @umplesourcefile(line={114},file={"Generator_UmpleModelWalker.ump"},javaline={241},length={3})
  public void visit(Guard guard){
    
  }

  @umplesourcefile(line={115},file={"Generator_UmpleModelWalker.ump"},javaline={246},length={3})
  public void visit(Action action){
    
  }

  @umplesourcefile(line={116},file={"Generator_UmpleModelWalker.ump"},javaline={251},length={3})
  public void visit(Event event){
    
  }

  @umplesourcefile(line={117},file={"Generator_UmpleModelWalker.ump"},javaline={256},length={3})
  public void visit(Transition transition){
    
  }

  @umplesourcefile(line={118},file={"Generator_UmpleModelWalker.ump"},javaline={261},length={3})
  public void visit(Activity activity){
    
  }


  /**
   * Trace
   */
  @umplesourcefile(line={121},file={"Generator_UmpleModelWalker.ump"},javaline={266},length={3})
  public void visit(Tracer tracer){
    
  }

  @umplesourcefile(line={122},file={"Generator_UmpleModelWalker.ump"},javaline={275},length={3})
  public void visit(TraceDirective traceDirective){
    
  }

  @umplesourcefile(line={123},file={"Generator_UmpleModelWalker.ump"},javaline={280},length={3})
  public void visit(TraceItem traceItem){
    
  }

  @umplesourcefile(line={124},file={"Generator_UmpleModelWalker.ump"},javaline={285},length={3})
  public void visit(TraceRecord traceRecord){
    
  }

  @umplesourcefile(line={125},file={"Generator_UmpleModelWalker.ump"},javaline={290},length={3})
  public void visit(AttributeTraceItem attributeT){
    
  }

  @umplesourcefile(line={126},file={"Generator_UmpleModelWalker.ump"},javaline={295},length={3})
  public void visit(TraceCase traceCase){
    
  }

  @umplesourcefile(line={127},file={"Generator_UmpleModelWalker.ump"},javaline={300},length={3})
  public void visit(TraceCondition traceCondition){
    
  }

  @umplesourcefile(line={128},file={"Generator_UmpleModelWalker.ump"},javaline={305},length={3})
  public void visit(MethodTraceEntity methodTraceEntity){
    
  }

  @umplesourcefile(line={129},file={"Generator_UmpleModelWalker.ump"},javaline={310},length={3})
  public void visit(StateMachineTraceItem stateMachineTraceItem){
    
  }


  /**
   * User Code
   */
  @umplesourcefile(line={133},file={"Generator_UmpleModelWalker.ump"},javaline={315},length={3})
  public void visit(CodeBlock block){
    
  }

  @umplesourcefile(line={134},file={"Generator_UmpleModelWalker.ump"},javaline={324},length={3})
  public void visit(UserCode userCode){
    
  }


  /**
   * Visitor Events
   */
  @umplesourcefile(line={137},file={"Generator_UmpleModelWalker.ump"},javaline={329},length={3})
  public void done(){
    
  }

}