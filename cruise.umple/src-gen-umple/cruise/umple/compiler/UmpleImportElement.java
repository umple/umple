/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;

/**
 * Defines import prototype for package, class, interface 
 * and associations
 * @umplesource UmpleImport.ump 40
 */
// line 40 "../../../../src/UmpleImport.ump"
public abstract class UmpleImportElement
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleImportElement Attributes
  private String id;
  private String name;
  private StringBuilder umpleBuilder;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleImportElement(String aId, String aName)
  {
    id = aId;
    name = aName;
    umpleBuilder = new StringBuilder();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setId(String aId)
  {
    boolean wasSet = false;
    id = aId;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setUmpleBuilder(StringBuilder aUmpleBuilder)
  {
    boolean wasSet = false;
    umpleBuilder = aUmpleBuilder;
    wasSet = true;
    return wasSet;
  }

  /**
   * identifier from xmi
   */
  public String getId()
  {
    return id;
  }

  /**
   * name attribute from xmi
   */
  public String getName()
  {
    return name;
  }

  public StringBuilder getUmpleBuilder()
  {
    return umpleBuilder;
  }

  public void delete()
  {}

  @umplesourcefile(line={51},file={"UmpleImport.ump"},javaline={90},length={3})
  public abstract String generateUmple();

  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "id" + ":" + getId()+ "," +
            "name" + ":" + getName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "umpleBuilder" + "=" + (getUmpleBuilder() != null ? !getUmpleBuilder().equals(this)  ? getUmpleBuilder().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}