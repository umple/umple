/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;
import java.io.IOException;

/**
 * LLOC metrics vistor. It walks through given root model in order to extract the required LLOC 
 * metrics information (@see IWalker) and have it represented in an analytical manner (@see IHtmlElement)
 * @umplesource Generator_CodeAnalysis.ump 177
 */
// line 177 "../../../../src/Generator_CodeAnalysis.ump"
public class LLOCMetricVisitor extends UmpleModelVisitor
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //LLOCMetricVisitor Attributes
  private HtmlDocument doc;
  private int total_lloc;
  private int total_comments;
  private int cur_lloc;
  private int cur_comments;
  private String cur_clazz;
  private TableElement tbl;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={189},file={"Generator_CodeAnalysis.ump"},javaline={47},length={4})
  public LLOCMetricVisitor(HtmlDocument aDoc)
  {
    super();
    doc = aDoc;
    total_lloc = 0;
    total_comments = 0;
    cur_lloc = 0;
    cur_comments = 0;
    cur_clazz = null;
    tbl = null;
    // line 189 "../../../../src/Generator_CodeAnalysis.ump"
    doc.createParagraphElement("LLOC Metrics", false);
    		tbl = doc.createTable(4);
    		tbl.setBorder(1);
    		tbl.setTitles(new String[] {"Class Name","LLOC","Comments","Total"});
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

  public boolean setTotal_lloc(int aTotal_lloc)
  {
    boolean wasSet = false;
    total_lloc = aTotal_lloc;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotal_comments(int aTotal_comments)
  {
    boolean wasSet = false;
    total_comments = aTotal_comments;
    wasSet = true;
    return wasSet;
  }

  public boolean setCur_lloc(int aCur_lloc)
  {
    boolean wasSet = false;
    cur_lloc = aCur_lloc;
    wasSet = true;
    return wasSet;
  }

  public boolean setCur_comments(int aCur_comments)
  {
    boolean wasSet = false;
    cur_comments = aCur_comments;
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

  public int getTotal_lloc()
  {
    return total_lloc;
  }

  public int getTotal_comments()
  {
    return total_comments;
  }

  public int getCur_lloc()
  {
    return cur_lloc;
  }

  public int getCur_comments()
  {
    return cur_comments;
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

  @umplesourcefile(line={196},file={"Generator_CodeAnalysis.ump"},javaline={154},length={4})
  public void done(){
    addTableEntry(null);
		tbl.addRow(new String [] {"Total",String.valueOf(total_lloc),String.valueOf(total_comments),String.valueOf(total_lloc+total_comments)});
  }

  @umplesourcefile(line={201},file={"Generator_CodeAnalysis.ump"},javaline={160},length={10})
  public void addTableEntry(UmpleElement element){
    if(cur_clazz != null) {
			tbl.addRow(new String [] {cur_clazz,String.valueOf(cur_lloc),String.valueOf(cur_comments),String.valueOf(cur_lloc+cur_comments)});
			total_lloc+= cur_lloc;
			total_comments+= cur_comments;
		}
		cur_clazz = element!= null ? element.getName() : "";
		cur_lloc = 0; 
		cur_comments = 0;
  }


  /**
   * Comment
   */
  @umplesourcefile(line={213},file={"Generator_CodeAnalysis.ump"},javaline={172},length={3})
  public void visit(Comment comment){
    cur_comments++;
  }


  /**
   * Umple Classifiers
   */
  @umplesourcefile(line={218},file={"Generator_CodeAnalysis.ump"},javaline={181},length={4})
  public void visit(UmpleClass umpleClass){
    addTableEntry(umpleClass);
		cur_lloc+= 2;
  }

  @umplesourcefile(line={222},file={"Generator_CodeAnalysis.ump"},javaline={191},length={4})
  public void visit(UmpleInterface umpleInterface){
    addTableEntry(umpleInterface);
		cur_lloc+= 2;
  }

  @umplesourcefile(line={226},file={"Generator_CodeAnalysis.ump"},javaline={197},length={4})
  public void visit(AssociationClass associationC){
    addTableEntry(associationC);
		cur_lloc+= 2;
  }


  /**
   * Dependency
   */
  @umplesourcefile(line={232},file={"Generator_CodeAnalysis.ump"},javaline={203},length={3})
  public void visit(Depend dependE){
    cur_lloc++;
  }

  @umplesourcefile(line={235},file={"Generator_CodeAnalysis.ump"},javaline={212},length={3})
  public void visit(Package pkg){
    cur_lloc++;
  }

  @umplesourcefile(line={238},file={"Generator_CodeAnalysis.ump"},javaline={217},length={3})
  public void visit(ClassPattern ptrn){
    cur_lloc++;
  }

  @umplesourcefile(line={241},file={"Generator_CodeAnalysis.ump"},javaline={222},length={6})
  public void visit(Hierarchy hier){
    cur_lloc+= hier.getParentInterfaces().size();
		if(hier.getParentClass() != null) {
			cur_lloc++;			
		}
  }


  /**
   * Attributes
   */
  @umplesourcefile(line={249},file={"Generator_CodeAnalysis.ump"},javaline={230},length={3})
  public void visit(Constant cnst){
    cur_lloc++;
  }

  @umplesourcefile(line={252},file={"Generator_CodeAnalysis.ump"},javaline={239},length={7})
  public void visit(Attribute attribute){
    if(attribute.isIsDerived()) {
			cur_lloc+= 2;			
		} else {
			cur_lloc++;
		}
  }

  @umplesourcefile(line={259},file={"Generator_CodeAnalysis.ump"},javaline={248},length={3})
  public void visit(Key keyO){
    cur_lloc++;
  }

  @umplesourcefile(line={263},file={"Generator_CodeAnalysis.ump"},javaline={253},length={3})
  public void visit(UniqueIdentifier uid){
    cur_lloc++;
  }


  /**
   * Methods
   */
  @umplesourcefile(line={268},file={"Generator_CodeAnalysis.ump"},javaline={258},length={7})
  public void visit(Method method){
    if(method.isIsImplemented()) {
			cur_lloc+= 2;
		} else {
			cur_lloc++;			
		}
  }


  /**
   * Logical
   */
  @umplesourcefile(line={277},file={"Generator_CodeAnalysis.ump"},javaline={271},length={3})
  public void visit(Precondition pre){
    cur_lloc++;
  }

  @umplesourcefile(line={280},file={"Generator_CodeAnalysis.ump"},javaline={280},length={3})
  public void visit(Constraint constraint){
    cur_lloc++;
  }


  /**
   * Aspect
   */
  @umplesourcefile(line={285},file={"Generator_CodeAnalysis.ump"},javaline={285},length={3})
  public void visit(CodeInjection codeInjection){
    cur_lloc+= 2;
  }


  /**
   * Association
   */
  @umplesourcefile(line={290},file={"Generator_CodeAnalysis.ump"},javaline={294},length={3})
  public void visit(Association associationE){
    cur_lloc++;
  }


  /**
   * void visit(AssociationVariable var) {
   * cur_lloc++;
   * }
   * Statemachine
   */
  @umplesourcefile(line={298},file={"Generator_CodeAnalysis.ump"},javaline={303},length={3})
  public void visit(StateMachine sm){
    cur_lloc+= 2;
  }

  @umplesourcefile(line={301},file={"Generator_CodeAnalysis.ump"},javaline={315},length={3})
  public void visit(State state){
    cur_lloc+= 2;
  }


  /**
   * void visit(Guard guard) {
   * cur_lloc++;
   * }
   */
  @umplesourcefile(line={307},file={"Generator_CodeAnalysis.ump"},javaline={320},length={3})
  public void visit(Action action){
    cur_lloc++;
  }

  @umplesourcefile(line={310},file={"Generator_CodeAnalysis.ump"},javaline={331},length={3})
  public void visit(Event event){
    cur_lloc+= 2;
  }


  /**
   * void visit(Transition transition) {
   * cur_lloc++;
   * }
   */
  @umplesourcefile(line={316},file={"Generator_CodeAnalysis.ump"},javaline={336},length={3})
  public void visit(Activity activity){
    cur_lloc+= 2;
  }


  /**
   * Trace
   */
  @umplesourcefile(line={321},file={"Generator_CodeAnalysis.ump"},javaline={347},length={3})
  public void visit(Tracer tracer){
    cur_lloc++;
  }

  @umplesourcefile(line={324},file={"Generator_CodeAnalysis.ump"},javaline={356},length={3})
  public void visit(TraceItem traceItem){
    cur_lloc++;
  }

  @umplesourcefile(line={327},file={"Generator_CodeAnalysis.ump"},javaline={361},length={3})
  public void visit(TraceRecord traceRecord){
    cur_lloc++;
  }

  @umplesourcefile(line={330},file={"Generator_CodeAnalysis.ump"},javaline={366},length={3})
  public void visit(AttributeTraceItem attributeT){
    cur_lloc++;
  }

  @umplesourcefile(line={333},file={"Generator_CodeAnalysis.ump"},javaline={371},length={3})
  public void visit(MethodTraceEntity methodTraceEntity){
    cur_lloc++;
  }

  @umplesourcefile(line={336},file={"Generator_CodeAnalysis.ump"},javaline={376},length={3})
  public void visit(StateMachineTraceItem stateMachineTraceItem){
    cur_lloc++;
  }


  /**
   * User Code
   */
  @umplesourcefile(line={342},file={"Generator_CodeAnalysis.ump"},javaline={381},length={7})
  public void visit(CodeBlock block){
    MeasurmentObject m;
	  	try {
			m = UmpleModelHelper.getInstance().countLOC(block.getCode());
			cur_lloc+= m.getCodeCount();
	  	} catch (IOException e) {}
  }

  @umplesourcefile(line={349},file={"Generator_CodeAnalysis.ump"},javaline={394},length={7})
  public void visit(UserCode userCode){
    MeasurmentObject m;
	  	try {
			m = UmpleModelHelper.getInstance().countLOC(userCode.getUserCode());
			cur_lloc+= m.getCodeCount();
	  	} catch (IOException e) {}
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "total_lloc" + ":" + getTotal_lloc()+ "," +
            "total_comments" + ":" + getTotal_comments()+ "," +
            "cur_lloc" + ":" + getCur_lloc()+ "," +
            "cur_comments" + ":" + getCur_comments()+ "," +
            "cur_clazz" + ":" + getCur_clazz()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "doc" + "=" + (getDoc() != null ? !getDoc().equals(this)  ? getDoc().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "tbl" + "=" + (getTbl() != null ? !getTbl().equals(this)  ? getTbl().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}