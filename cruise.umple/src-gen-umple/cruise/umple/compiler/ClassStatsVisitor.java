/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import java.io.IOException;

/**
 * Used to extract the required metrics information for the states of a given class. It is designed to
 * to be used by other metrics to show states information. @See StateMachineStatsVisitor
 * @umplesource Generator_CodeAnalysis.ump 517
 */
// line 517 "../../../../src/Generator_CodeAnalysis.ump"
public class ClassStatsVisitor extends UmpleModelVisitor
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassStatsVisitor Attributes
  private HtmlDocument doc;
  private int total_assoc;
  private int total_attributes;
  private int total_subclass;
  private int total_classMethods;
  private int total_classMethodParams;
  private int cur_assoc;
  private int cur_attributes;
  private int cur_subclass;
  private int cur_classMethods;
  private int cur_classMethodParams;
  private String cur_clazz;
  private TableElement tbl;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  @umplesourcefile(line={537},file={"Generator_CodeAnalysis.ump"},javaline={59},length={4})
  public ClassStatsVisitor(HtmlDocument aDoc)
  {
    super();
    doc = aDoc;
    total_assoc = 0;
    total_attributes = 0;
    total_subclass = 0;
    total_classMethods = 0;
    total_classMethodParams = 0;
    cur_assoc = 0;
    cur_attributes = 0;
    cur_subclass = 0;
    cur_classMethods = 0;
    cur_classMethodParams = 0;
    cur_clazz = null;
    tbl = null;
    // line 537 "../../../../src/Generator_CodeAnalysis.ump"
    doc.createParagraphElement("Class Statistics", false);
    		tbl = doc.createTable(6);
    		tbl.setBorder(1);
    		tbl.setTitles(new String[] {"Class Name","#Attributes","#Association","#Sub-Classes","#Methods","#Method Parameters"});
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

  public boolean setTotal_assoc(int aTotal_assoc)
  {
    boolean wasSet = false;
    total_assoc = aTotal_assoc;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotal_attributes(int aTotal_attributes)
  {
    boolean wasSet = false;
    total_attributes = aTotal_attributes;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotal_subclass(int aTotal_subclass)
  {
    boolean wasSet = false;
    total_subclass = aTotal_subclass;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotal_classMethods(int aTotal_classMethods)
  {
    boolean wasSet = false;
    total_classMethods = aTotal_classMethods;
    wasSet = true;
    return wasSet;
  }

  public boolean setTotal_classMethodParams(int aTotal_classMethodParams)
  {
    boolean wasSet = false;
    total_classMethodParams = aTotal_classMethodParams;
    wasSet = true;
    return wasSet;
  }

  public boolean setCur_assoc(int aCur_assoc)
  {
    boolean wasSet = false;
    cur_assoc = aCur_assoc;
    wasSet = true;
    return wasSet;
  }

  public boolean setCur_attributes(int aCur_attributes)
  {
    boolean wasSet = false;
    cur_attributes = aCur_attributes;
    wasSet = true;
    return wasSet;
  }

  public boolean setCur_subclass(int aCur_subclass)
  {
    boolean wasSet = false;
    cur_subclass = aCur_subclass;
    wasSet = true;
    return wasSet;
  }

  public boolean setCur_classMethods(int aCur_classMethods)
  {
    boolean wasSet = false;
    cur_classMethods = aCur_classMethods;
    wasSet = true;
    return wasSet;
  }

  public boolean setCur_classMethodParams(int aCur_classMethodParams)
  {
    boolean wasSet = false;
    cur_classMethodParams = aCur_classMethodParams;
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

  public int getTotal_assoc()
  {
    return total_assoc;
  }

  public int getTotal_attributes()
  {
    return total_attributes;
  }

  public int getTotal_subclass()
  {
    return total_subclass;
  }

  public int getTotal_classMethods()
  {
    return total_classMethods;
  }

  public int getTotal_classMethodParams()
  {
    return total_classMethodParams;
  }

  public int getCur_assoc()
  {
    return cur_assoc;
  }

  public int getCur_attributes()
  {
    return cur_attributes;
  }

  public int getCur_subclass()
  {
    return cur_subclass;
  }

  public int getCur_classMethods()
  {
    return cur_classMethods;
  }

  public int getCur_classMethodParams()
  {
    return cur_classMethodParams;
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

  @umplesourcefile(line={545},file={"Generator_CodeAnalysis.ump"},javaline={245},length={4})
  public void done(){
    addTableEntry(null);
		tbl.addRow(new String [] {"Total",String.valueOf(total_attributes),String.valueOf(total_assoc),String.valueOf(total_subclass),String.valueOf(total_classMethods),String.valueOf(total_classMethodParams)});
  }

  @umplesourcefile(line={550},file={"Generator_CodeAnalysis.ump"},javaline={251},length={17})
  public void addTableEntry(UmpleElement element){
    if(cur_clazz != null) {
			tbl.addRow(new String [] {cur_clazz,String.valueOf(cur_attributes),String.valueOf(cur_assoc),String.valueOf(cur_subclass),String.valueOf(cur_classMethods),String.valueOf(cur_classMethodParams)});
			
			total_assoc+= cur_assoc;
			total_attributes+= cur_attributes;
			total_subclass+= cur_subclass;
			total_classMethods+= cur_classMethods;
			total_classMethodParams= Math.max(total_classMethodParams, cur_classMethodParams);
		}
		cur_clazz = element!= null ? element.getName() : "";
		cur_assoc = 0;
		cur_attributes = 0;
		cur_subclass = 0;
		cur_classMethods = 0;
		cur_classMethodParams = 0;
  }


  /**
   * Umple Classifiers
   */
  @umplesourcefile(line={569},file={"Generator_CodeAnalysis.ump"},javaline={270},length={4})
  public void visit(UmpleClass umpleClass){
    addTableEntry(umpleClass);
		cur_subclass = umpleClass.getSubclasses().size();
  }

  @umplesourcefile(line={574},file={"Generator_CodeAnalysis.ump"},javaline={280},length={4})
  public void visit(AssociationClass associationC){
    addTableEntry(associationC);
		cur_subclass = associationC.getSubclasses().size();
  }


  /**
   * Attributes
   */
  @umplesourcefile(line={580},file={"Generator_CodeAnalysis.ump"},javaline={286},length={3})
  public void visit(Attribute attribute){
    cur_attributes++;
  }


  /**
   * Methods
   */
  @umplesourcefile(line={585},file={"Generator_CodeAnalysis.ump"},javaline={295},length={4})
  public void visit(Method method){
    cur_classMethods++;
		cur_classMethods = Math.max(cur_classMethods, method.getMethodParameters().size());
  }


  /**
   * Association
   */
  @umplesourcefile(line={591},file={"Generator_CodeAnalysis.ump"},javaline={305},length={3})
  public void visit(Association associationE){
    cur_assoc++;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "total_assoc" + ":" + getTotal_assoc()+ "," +
            "total_attributes" + ":" + getTotal_attributes()+ "," +
            "total_subclass" + ":" + getTotal_subclass()+ "," +
            "total_classMethods" + ":" + getTotal_classMethods()+ "," +
            "total_classMethodParams" + ":" + getTotal_classMethodParams()+ "," +
            "cur_assoc" + ":" + getCur_assoc()+ "," +
            "cur_attributes" + ":" + getCur_attributes()+ "," +
            "cur_subclass" + ":" + getCur_subclass()+ "," +
            "cur_classMethods" + ":" + getCur_classMethods()+ "," +
            "cur_classMethodParams" + ":" + getCur_classMethodParams()+ "," +
            "cur_clazz" + ":" + getCur_clazz()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "doc" + "=" + (getDoc() != null ? !getDoc().equals(this)  ? getDoc().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "tbl" + "=" + (getTbl() != null ? !getTbl().equals(this)  ? getTbl().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}