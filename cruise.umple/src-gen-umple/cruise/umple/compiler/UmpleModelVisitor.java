/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;

/**
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

  @umplesourcefile(line={62},file={"Generator_UmpleModelWalker.ump"},javaline={38},length={3})
  public void visit(UmpleModel umpleModel){
    
  }


  /**
   * Comment
   */
  @umplesourcefile(line={65},file={"Generator_UmpleModelWalker.ump"},javaline={43},length={3})
  public void visit(Comment comment){
    
  }


  /**
   * Umple Classifiers
   */
  @umplesourcefile(line={68},file={"Generator_UmpleModelWalker.ump"},javaline={52},length={3})
  public void visit(UmpleElement umpleElement){
    
  }

  @umplesourcefile(line={69},file={"Generator_UmpleModelWalker.ump"},javaline={61},length={3})
  public void visit(UmpleClassifier umpleClassifier){
    
  }

  @umplesourcefile(line={70},file={"Generator_UmpleModelWalker.ump"},javaline={66},length={3})
  public void visit(UmpleClass umpleClass){
    
  }

  @umplesourcefile(line={71},file={"Generator_UmpleModelWalker.ump"},javaline={71},length={3})
  public void visit(UmpleInterface umpleInterface){
    
  }


  /**
   * Dependency
   */
  @umplesourcefile(line={74},file={"Generator_UmpleModelWalker.ump"},javaline={76},length={3})
  public void visit(Depend dependE){
    
  }

  @umplesourcefile(line={75},file={"Generator_UmpleModelWalker.ump"},javaline={85},length={3})
  public void visit(Package pkg){
    
  }

  @umplesourcefile(line={76},file={"Generator_UmpleModelWalker.ump"},javaline={90},length={3})
  public void visit(ClassPattern ptrn){
    
  }

  @umplesourcefile(line={77},file={"Generator_UmpleModelWalker.ump"},javaline={95},length={3})
  public void visit(Hierarchy hier){
    
  }


  /**
   * Types
   */
  @umplesourcefile(line={80},file={"Generator_UmpleModelWalker.ump"},javaline={100},length={3})
  public void visit(Type type){
    
  }

  @umplesourcefile(line={81},file={"Generator_UmpleModelWalker.ump"},javaline={109},length={3})
  public void visit(PrimitiveType primitiveType){
    
  }

  @umplesourcefile(line={82},file={"Generator_UmpleModelWalker.ump"},javaline={114},length={3})
  public void visit(ReferenceType referenceType){
    
  }


  /**
   * Attributes
   */
  @umplesourcefile(line={85},file={"Generator_UmpleModelWalker.ump"},javaline={119},length={3})
  public void visit(Constant cnst){
    
  }

  @umplesourcefile(line={86},file={"Generator_UmpleModelWalker.ump"},javaline={128},length={3})
  public void visit(Attribute attribute){
    
  }

  @umplesourcefile(line={87},file={"Generator_UmpleModelWalker.ump"},javaline={133},length={3})
  public void visit(Key keyO){
    
  }

  @umplesourcefile(line={88},file={"Generator_UmpleModelWalker.ump"},javaline={138},length={3})
  public void visit(ConstraintVariable cnstVar){
    
  }

  @umplesourcefile(line={89},file={"Generator_UmpleModelWalker.ump"},javaline={143},length={3})
  public void visit(UmpleVariable var){
    
  }

  @umplesourcefile(line={90},file={"Generator_UmpleModelWalker.ump"},javaline={148},length={3})
  public void visit(UniqueIdentifier uid){
    
  }


  /**
   * Methods
   */
  @umplesourcefile(line={93},file={"Generator_UmpleModelWalker.ump"},javaline={153},length={3})
  public void visit(Method method){
    
  }

  @umplesourcefile(line={94},file={"Generator_UmpleModelWalker.ump"},javaline={162},length={3})
  public void visit(MethodParameter param){
    
  }

  @umplesourcefile(line={95},file={"Generator_UmpleModelWalker.ump"},javaline={167},length={3})
  public void visit(MethodBody methodBody){
    
  }


  /**
   * Logical
   */
  @umplesourcefile(line={98},file={"Generator_UmpleModelWalker.ump"},javaline={172},length={3})
  public void visit(Condition cond){
    
  }

  @umplesourcefile(line={99},file={"Generator_UmpleModelWalker.ump"},javaline={181},length={3})
  public void visit(Precondition pre){
    
  }

  @umplesourcefile(line={100},file={"Generator_UmpleModelWalker.ump"},javaline={186},length={3})
  public void visit(Constraint constraint){
    
  }


  /**
   * Aspect
   */
  @umplesourcefile(line={103},file={"Generator_UmpleModelWalker.ump"},javaline={191},length={3})
  public void visit(CodeInjection codeInjection){
    
  }


  /**
   * Association
   */
  @umplesourcefile(line={106},file={"Generator_UmpleModelWalker.ump"},javaline={200},length={3})
  public void visit(Association associationE){
    
  }

  @umplesourcefile(line={107},file={"Generator_UmpleModelWalker.ump"},javaline={209},length={3})
  public void visit(AssociationClass associationC){
    
  }

  @umplesourcefile(line={108},file={"Generator_UmpleModelWalker.ump"},javaline={214},length={3})
  public void visit(AssociationEnd associationE){
    
  }

  @umplesourcefile(line={109},file={"Generator_UmpleModelWalker.ump"},javaline={219},length={3})
  public void visit(AssociationVariable var){
    
  }


  /**
   * Statemachine
   */
  @umplesourcefile(line={112},file={"Generator_UmpleModelWalker.ump"},javaline={224},length={3})
  public void visit(StateMachine sm){
    
  }

  @umplesourcefile(line={113},file={"Generator_UmpleModelWalker.ump"},javaline={233},length={3})
  public void visit(State state){
    
  }

  @umplesourcefile(line={114},file={"Generator_UmpleModelWalker.ump"},javaline={238},length={3})
  public void visit(Guard guard){
    
  }

  @umplesourcefile(line={115},file={"Generator_UmpleModelWalker.ump"},javaline={243},length={3})
  public void visit(Action action){
    
  }

  @umplesourcefile(line={116},file={"Generator_UmpleModelWalker.ump"},javaline={248},length={3})
  public void visit(Event event){
    
  }

  @umplesourcefile(line={117},file={"Generator_UmpleModelWalker.ump"},javaline={253},length={3})
  public void visit(Transition transition){
    
  }

  @umplesourcefile(line={118},file={"Generator_UmpleModelWalker.ump"},javaline={258},length={3})
  public void visit(Activity activity){
    
  }


  /**
   * Trace
   */
  @umplesourcefile(line={121},file={"Generator_UmpleModelWalker.ump"},javaline={263},length={3})
  public void visit(Tracer tracer){
    
  }

  @umplesourcefile(line={122},file={"Generator_UmpleModelWalker.ump"},javaline={272},length={3})
  public void visit(TraceDirective traceDirective){
    
  }

  @umplesourcefile(line={123},file={"Generator_UmpleModelWalker.ump"},javaline={277},length={3})
  public void visit(TraceItem traceItem){
    
  }

  @umplesourcefile(line={124},file={"Generator_UmpleModelWalker.ump"},javaline={282},length={3})
  public void visit(TraceRecord traceRecord){
    
  }

  @umplesourcefile(line={125},file={"Generator_UmpleModelWalker.ump"},javaline={287},length={3})
  public void visit(AttributeTraceItem attributeT){
    
  }

  @umplesourcefile(line={126},file={"Generator_UmpleModelWalker.ump"},javaline={292},length={3})
  public void visit(TraceCase traceCase){
    
  }

  @umplesourcefile(line={127},file={"Generator_UmpleModelWalker.ump"},javaline={297},length={3})
  public void visit(TraceCondition traceCondition){
    
  }

  @umplesourcefile(line={128},file={"Generator_UmpleModelWalker.ump"},javaline={302},length={3})
  public void visit(MethodTraceEntity methodTraceEntity){
    
  }

  @umplesourcefile(line={129},file={"Generator_UmpleModelWalker.ump"},javaline={307},length={3})
  public void visit(StateMachineTraceItem stateMachineTraceItem){
    
  }


  /**
   * User Code
   */
  @umplesourcefile(line={133},file={"Generator_UmpleModelWalker.ump"},javaline={312},length={3})
  public void visit(CodeBlock block){
    
  }

  @umplesourcefile(line={134},file={"Generator_UmpleModelWalker.ump"},javaline={321},length={3})
  public void visit(UserCode userCode){
    
  }


  /**
   * Visitor Events
   */
  @umplesourcefile(line={137},file={"Generator_UmpleModelWalker.ump"},javaline={326},length={3})
  public void done(){
    
  }

}