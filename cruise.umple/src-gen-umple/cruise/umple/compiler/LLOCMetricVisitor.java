/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.io.IOException;

/**
 * LLOC metrics vistor. It walks through given root model in order to extract the required LLOC 
 * metrics information (@see IWalker) and have it represented in an analytical manner (@see IHtmlElement)
 * LLOC metrics vistor. It walks through given root model in order to extract the required LLOC 
 * metrics information (@see IWalker) and have it represented in an analytical manner (@see IHtmlElement)
 * @umplesource Generator_CodeAnalysis.ump 176
 */
// line 176 "../../../../src/Generator_CodeAnalysis.ump"
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

  @umplesourcefile(line={189},file={"Generator_CodeAnalysis.ump"},javaline={49},length={4})
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

  @umplesourcefile(line={197},file={"Generator_CodeAnalysis.ump"},javaline={157},length={4})
  public void done(){
    addTableEntry(null);
		tbl.addRow(new String [] {"Total",String.valueOf(total_lloc),String.valueOf(total_comments),String.valueOf(total_lloc+total_comments)});
  }

  @umplesourcefile(line={202},file={"Generator_CodeAnalysis.ump"},javaline={163},length={10})
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
  @umplesourcefile(line={214},file={"Generator_CodeAnalysis.ump"},javaline={175},length={3})
  public void visit(Comment comment){
    cur_comments++;
  }


  /**
   * Umple Classifiers
   */
  @umplesourcefile(line={219},file={"Generator_CodeAnalysis.ump"},javaline={184},length={4})
  public void visit(UmpleClass umpleClass){
    addTableEntry(umpleClass);
		cur_lloc+= 2;
  }

  @umplesourcefile(line={223},file={"Generator_CodeAnalysis.ump"},javaline={194},length={4})
  public void visit(UmpleInterface umpleInterface){
    addTableEntry(umpleInterface);
		cur_lloc+= 2;
  }

  @umplesourcefile(line={227},file={"Generator_CodeAnalysis.ump"},javaline={200},length={4})
  public void visit(AssociationClass associationC){
    addTableEntry(associationC);
		cur_lloc+= 2;
  }


  /**
   * Dependency
   */
  @umplesourcefile(line={233},file={"Generator_CodeAnalysis.ump"},javaline={206},length={3})
  public void visit(Depend dependE){
    cur_lloc++;
  }

  @umplesourcefile(line={236},file={"Generator_CodeAnalysis.ump"},javaline={215},length={3})
  public void visit(Package pkg){
    cur_lloc++;
  }

  @umplesourcefile(line={239},file={"Generator_CodeAnalysis.ump"},javaline={220},length={3})
  public void visit(ClassPattern ptrn){
    cur_lloc++;
  }

  @umplesourcefile(line={242},file={"Generator_CodeAnalysis.ump"},javaline={225},length={6})
  public void visit(Hierarchy hier){
    cur_lloc+= hier.getParentInterfaces().size();
		if(hier.getParentClass() != null) {
			cur_lloc++;			
		}
  }


  /**
   * Attributes
   */
  @umplesourcefile(line={250},file={"Generator_CodeAnalysis.ump"},javaline={233},length={3})
  public void visit(Constant cnst){
    cur_lloc++;
  }

  @umplesourcefile(line={253},file={"Generator_CodeAnalysis.ump"},javaline={242},length={7})
  public void visit(Attribute attribute){
    if(attribute.isIsDerived()) {
			cur_lloc+= 2;			
		} else {
			cur_lloc++;
		}
  }

  @umplesourcefile(line={260},file={"Generator_CodeAnalysis.ump"},javaline={251},length={3})
  public void visit(Key keyO){
    cur_lloc++;
  }

  @umplesourcefile(line={264},file={"Generator_CodeAnalysis.ump"},javaline={256},length={3})
  public void visit(UniqueIdentifier uid){
    cur_lloc++;
  }


  /**
   * Methods
   */
  @umplesourcefile(line={269},file={"Generator_CodeAnalysis.ump"},javaline={261},length={7})
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
  @umplesourcefile(line={278},file={"Generator_CodeAnalysis.ump"},javaline={274},length={3})
  public void visit(Precondition pre){
    cur_lloc++;
  }

  @umplesourcefile(line={281},file={"Generator_CodeAnalysis.ump"},javaline={283},length={3})
  public void visit(Constraint constraint){
    cur_lloc++;
  }


  /**
   * Aspect
   */
  @umplesourcefile(line={286},file={"Generator_CodeAnalysis.ump"},javaline={288},length={3})
  public void visit(CodeInjection codeInjection){
    cur_lloc+= 2;
  }


  /**
   * Association
   */
  @umplesourcefile(line={291},file={"Generator_CodeAnalysis.ump"},javaline={297},length={3})
  public void visit(Association associationE){
    cur_lloc++;
  }


  /**
   * void visit(AssociationVariable var) {
   * cur_lloc++;
   * }
   * Statemachine
   */
  @umplesourcefile(line={299},file={"Generator_CodeAnalysis.ump"},javaline={306},length={3})
  public void visit(StateMachine sm){
    cur_lloc+= 2;
  }

  @umplesourcefile(line={302},file={"Generator_CodeAnalysis.ump"},javaline={318},length={3})
  public void visit(State state){
    cur_lloc+= 2;
  }


  /**
   * void visit(Guard guard) {
   * cur_lloc++;
   * }
   */
  @umplesourcefile(line={308},file={"Generator_CodeAnalysis.ump"},javaline={323},length={3})
  public void visit(Action action){
    cur_lloc++;
  }

  @umplesourcefile(line={311},file={"Generator_CodeAnalysis.ump"},javaline={334},length={3})
  public void visit(Event event){
    cur_lloc+= 2;
  }


  /**
   * void visit(Transition transition) {
   * cur_lloc++;
   * }
   */
  @umplesourcefile(line={317},file={"Generator_CodeAnalysis.ump"},javaline={339},length={3})
  public void visit(Activity activity){
    cur_lloc+= 2;
  }


  /**
   * Trace
   */
  @umplesourcefile(line={322},file={"Generator_CodeAnalysis.ump"},javaline={350},length={3})
  public void visit(Tracer tracer){
    cur_lloc++;
  }

  @umplesourcefile(line={325},file={"Generator_CodeAnalysis.ump"},javaline={359},length={3})
  public void visit(TraceItem traceItem){
    cur_lloc++;
  }

  @umplesourcefile(line={328},file={"Generator_CodeAnalysis.ump"},javaline={364},length={3})
  public void visit(TraceRecord traceRecord){
    cur_lloc++;
  }

  @umplesourcefile(line={331},file={"Generator_CodeAnalysis.ump"},javaline={369},length={3})
  public void visit(AttributeTraceItem attributeT){
    cur_lloc++;
  }

  @umplesourcefile(line={334},file={"Generator_CodeAnalysis.ump"},javaline={374},length={3})
  public void visit(MethodTraceEntity methodTraceEntity){
    cur_lloc++;
  }

  @umplesourcefile(line={337},file={"Generator_CodeAnalysis.ump"},javaline={379},length={3})
  public void visit(StateMachineTraceItem stateMachineTraceItem){
    cur_lloc++;
  }


  /**
   * User Code
   */
  @umplesourcefile(line={343},file={"Generator_CodeAnalysis.ump"},javaline={384},length={7})
  public void visit(CodeBlock block){
    MeasurmentObject m;
	  	try {
			m = UmpleModelHelper.getInstance().countLOC(block.getCode());
			cur_lloc+= m.getCodeCount();
	  	} catch (IOException e) {}
  }

  @umplesourcefile(line={350},file={"Generator_CodeAnalysis.ump"},javaline={397},length={7})
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