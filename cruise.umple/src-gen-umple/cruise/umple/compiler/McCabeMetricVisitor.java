/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;

/**
 * McCabe = Edges - Nodes + 2 * ExitNodes
 * McCabe = Edges - Nodes + ExitNodes
 * McCabe = Number of logical points + 1
 * @see LLOCMetricVisitor
 * @umplesource Generator_CodeAnalysis.ump 363
 */
// line 363 "../../../../src/Generator_CodeAnalysis.ump"
public class McCabeMetricVisitor extends UmpleModelVisitor
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //McCabeMetricVisitor Attributes
  private HtmlDocument doc;
  private int total_conditions;
  private int total_iteration;
  private int cur_conditions;
  private int cur_iterations;
  private String cur_clazz;
  private TableElement tbl;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={376},file={"Generator_CodeAnalysis.ump"},javaline={48},length={4})
  public McCabeMetricVisitor(HtmlDocument aDoc)
  {
    super();
    doc = aDoc;
    total_conditions = 0;
    total_iteration = 0;
    cur_conditions = 0;
    cur_iterations = 0;
    cur_clazz = null;
    tbl = null;
    // line 376 "../../../../src/Generator_CodeAnalysis.ump"
    doc.createParagraphElement("McCabe Metrics", false);
    		tbl = doc.createTable(4);
    		tbl.setBorder(1);
    		tbl.setTitles(new String[] {"Class Name","#Conditions","#Iterations","Total"});
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDoc(HtmlDocument aDoc)
  {
    boolean wasSet = false;
    doc = aDoc;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotal_conditions(int aTotal_conditions)
  {
    boolean wasSet = false;
    total_conditions = aTotal_conditions;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotal_iteration(int aTotal_iteration)
  {
    boolean wasSet = false;
    total_iteration = aTotal_iteration;
    wasSet = true;
    return wasSet;
  }

  public boolean setCur_conditions(int aCur_conditions)
  {
    boolean wasSet = false;
    cur_conditions = aCur_conditions;
    wasSet = true;
    return wasSet;
  }

  public boolean setCur_iterations(int aCur_iterations)
  {
    boolean wasSet = false;
    cur_iterations = aCur_iterations;
    wasSet = true;
    return wasSet;
  }

  public boolean setCur_clazz(String aCur_clazz)
  {
    boolean wasSet = false;
    cur_clazz = aCur_clazz;
    wasSet = true;
    return wasSet;
  }

  public boolean setTbl(TableElement aTbl)
  {
    boolean wasSet = false;
    tbl = aTbl;
    wasSet = true;
    return wasSet;
  }

  public HtmlDocument getDoc()
  {
    return doc;
  }

  public int getTotal_conditions()
  {
    return total_conditions;
  }

  public int getTotal_iteration()
  {
    return total_iteration;
  }

  public int getCur_conditions()
  {
    return cur_conditions;
  }

  public int getCur_iterations()
  {
    return cur_iterations;
  }

  public String getCur_clazz()
  {
    return cur_clazz;
  }

  public TableElement getTbl()
  {
    return tbl;
  }

  public void delete()
  {
    super.delete();
  }

  @umplesourcefile(line={383},file={"Generator_CodeAnalysis.ump"},javaline={155},length={5})
  public void done(){
    addTableEntry(null);
		int mcabe = total_conditions + total_iteration + 1;
		tbl.addRow(new String [] {"Total",String.valueOf(total_conditions),String.valueOf(total_iteration),String.valueOf(mcabe)});
  }

  @umplesourcefile(line={389},file={"Generator_CodeAnalysis.ump"},javaline={162},length={11})
  public void addTableEntry(UmpleElement element){
    if(cur_clazz != null) {
			int mcabe = cur_conditions + cur_iterations + 1;
			tbl.addRow(new String [] {cur_clazz,String.valueOf(cur_conditions),String.valueOf(cur_iterations),String.valueOf(mcabe)});
			total_conditions+= cur_conditions;
			total_iteration+= cur_iterations;
		}
		cur_clazz = element!= null ? element.getName() : "";
		cur_conditions = 0; 
		cur_iterations = 0;
  }


  /**
   * Umple Classifiers
   */
  @umplesourcefile(line={402},file={"Generator_CodeAnalysis.ump"},javaline={175},length={3})
  public void visit(UmpleClass umpleClass){
    addTableEntry(umpleClass);
  }

  @umplesourcefile(line={405},file={"Generator_CodeAnalysis.ump"},javaline={184},length={3})
  public void visit(UmpleInterface umpleInterface){
    addTableEntry(umpleInterface);
  }

  @umplesourcefile(line={408},file={"Generator_CodeAnalysis.ump"},javaline={189},length={3})
  public void visit(AssociationClass associationC){
    addTableEntry(associationC);
  }


  /**
   * Attributes
   */
  @umplesourcefile(line={413},file={"Generator_CodeAnalysis.ump"},javaline={194},length={5})
  public void visit(Attribute attribute){
    if(attribute.isIsDerived()) {
			cur_conditions++;			
		}
  }

  @umplesourcefile(line={418},file={"Generator_CodeAnalysis.ump"},javaline={205},length={3})
  public void visit(Key keyO){
    cur_conditions++;
  }

  @umplesourcefile(line={421},file={"Generator_CodeAnalysis.ump"},javaline={210},length={3})
  public void visit(ConstraintVariable cnstVar){
    cur_conditions++;
  }

  @umplesourcefile(line={424},file={"Generator_CodeAnalysis.ump"},javaline={215},length={3})
  public void visit(UniqueIdentifier uid){
    cur_conditions++;
  }


  /**
   * Logical
   */
  @umplesourcefile(line={429},file={"Generator_CodeAnalysis.ump"},javaline={220},length={3})
  public void visit(Condition cond){
    cur_conditions++;
  }

  @umplesourcefile(line={432},file={"Generator_CodeAnalysis.ump"},javaline={229},length={3})
  public void visit(Precondition pre){
    cur_conditions++;
  }

  @umplesourcefile(line={435},file={"Generator_CodeAnalysis.ump"},javaline={234},length={3})
  public void visit(Constraint constraint){
    cur_conditions++;
  }


  /**
   * Aspect
   */
  @umplesourcefile(line={440},file={"Generator_CodeAnalysis.ump"},javaline={239},length={3})
  public void visit(CodeInjection codeInjection){
    cur_conditions++;
  }


  /**
   * Association
   */
  @umplesourcefile(line={445},file={"Generator_CodeAnalysis.ump"},javaline={248},length={3})
  public void visit(Association associationE){
    cur_conditions++;
  }


  /**
   * void visit(AssociationVariable var) {
   * cur_conditions++;
   * }
   * Statemachine
   */
  @umplesourcefile(line={453},file={"Generator_CodeAnalysis.ump"},javaline={257},length={3})
  public void visit(StateMachine sm){
    cur_conditions++; // Default case
  }

  @umplesourcefile(line={456},file={"Generator_CodeAnalysis.ump"},javaline={269},length={3})
  public void visit(State state){
    cur_conditions++; // Each state is a case statement
  }

  @umplesourcefile(line={459},file={"Generator_CodeAnalysis.ump"},javaline={274},length={5})
  public void visit(Event event){
    if(event.isIsTimer()) {
			cur_iterations++; // While statement			
		}
  }

  @umplesourcefile(line={464},file={"Generator_CodeAnalysis.ump"},javaline={281},length={3})
  public void visit(Guard guard){
    cur_conditions++;
  }

  @umplesourcefile(line={467},file={"Generator_CodeAnalysis.ump"},javaline={286},length={24})
  public void visit(Transition transition){
    State nextState = transition.getNextState();
		State fromState = transition.getFromState();
							
		StateMachine targetStateMachine = nextState.getStateMachine();
		StateMachine sourceStateMachine = fromState.getStateMachine();
		if(targetStateMachine!= sourceStateMachine){
			//Means that we are going to a different statemachine (another switch statement), so complexity is increased so increment by 2
			cur_conditions= cur_conditions+ 2;
		}else{
			State targetParentState = targetStateMachine.getParentState();
			State sourceParentState = sourceStateMachine.getParentState();
								
			//If the parent states are the same then we are at the same level, in that case, this means less complexity, thus only increment the
			//complexity by one; otherwise, this requires more thinking and therefore, the complexity will be increased by "2"
			//If targetParentState and sourceParentState are null, then this means that they are the root states, and also means
			//that they are at the same level, so the equality condition is ennough to catch this case
			if(targetParentState== sourceParentState){
				cur_conditions= cur_conditions+ 1;
			}else{
				cur_conditions= cur_conditions+ 2;
			}
		}
  }

  @umplesourcefile(line={491},file={"Generator_CodeAnalysis.ump"},javaline={312},length={3})
  public void visit(Activity activity){
    cur_iterations++; // Concurrent Iterative statement
  }


  /**
   * Trace
   */
  @umplesourcefile(line={496},file={"Generator_CodeAnalysis.ump"},javaline={317},length={11})
  public void visit(AttributeTraceItem attributeT){
    if(attributeT.isConditionallyWhere()) {
			cur_conditions++;
		}
		if(attributeT.getPeriodClause() != null && attributeT.getPeriodClause().length() > 0) {
			cur_iterations++;
		}
		if(attributeT.getDuringClause() != null && attributeT.getDuringClause().length() > 0) {
			cur_iterations++;
		}
  }

  @umplesourcefile(line={507},file={"Generator_CodeAnalysis.ump"},javaline={334},length={3})
  public void visit(TraceCase traceCase){
    cur_conditions++;
  }

  @umplesourcefile(line={510},file={"Generator_CodeAnalysis.ump"},javaline={339},length={3})
  public void visit(TraceCondition traceCondition){
    cur_conditions++;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "total_conditions" + ":" + getTotal_conditions()+ "," +
            "total_iteration" + ":" + getTotal_iteration()+ "," +
            "cur_conditions" + ":" + getCur_conditions()+ "," +
            "cur_iterations" + ":" + getCur_iterations()+ "," +
            "cur_clazz" + ":" + getCur_clazz()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "doc" + "=" + (getDoc() != null ? !getDoc().equals(this)  ? getDoc().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "tbl" + "=" + (getTbl() != null ? !getTbl().equals(this)  ? getTbl().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}