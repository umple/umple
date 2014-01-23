/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/

package cruise.umple.compiler;
import cruise.umple.util.StringFormatter;

/**
 * @umplesource UmpleImport.ump 95
 * @umplesource UmpleImport_CodeModels.ump 139
 */
// line 95 "../../../../src/UmpleImport.ump"
// line 139 "../../../../src/UmpleImport_CodeModels.ump"
public class UmpleImportAssociation extends UmpleImportElement
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //UmpleImportAssociation Attributes
  private String startClass;
  private String endClass;
  private String endClassName;
  private int lowerBound;
  private int upperBound;
  private int otherLowerBound;
  private int otherUpperBound;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public UmpleImportAssociation(String aId, String aName, String aStartClass, String aEndClass, String aEndClassName)
  {
    super(aId, aName);
    startClass = aStartClass;
    endClass = aEndClass;
    endClassName = aEndClassName;
    lowerBound = 0;
    upperBound = 1;
    otherLowerBound = 0;
    otherUpperBound = 1;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartClass(String aStartClass)
  {
    boolean wasSet = false;
    startClass = aStartClass;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndClass(String aEndClass)
  {
    boolean wasSet = false;
    endClass = aEndClass;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndClassName(String aEndClassName)
  {
    boolean wasSet = false;
    endClassName = aEndClassName;
    wasSet = true;
    return wasSet;
  }

  public boolean setLowerBound(int aLowerBound)
  {
    boolean wasSet = false;
    lowerBound = aLowerBound;
    wasSet = true;
    return wasSet;
  }

  public boolean setUpperBound(int aUpperBound)
  {
    boolean wasSet = false;
    upperBound = aUpperBound;
    wasSet = true;
    return wasSet;
  }

  public boolean setOtherLowerBound(int aOtherLowerBound)
  {
    boolean wasSet = false;
    otherLowerBound = aOtherLowerBound;
    wasSet = true;
    return wasSet;
  }

  public boolean setOtherUpperBound(int aOtherUpperBound)
  {
    boolean wasSet = false;
    otherUpperBound = aOtherUpperBound;
    wasSet = true;
    return wasSet;
  }

  /**
   * root class
   */
  public String getStartClass()
  {
    return startClass;
  }

  /**
   * eType
   */
  public String getEndClass()
  {
    return endClass;
  }

  /**
   * eOpposite
   */
  public String getEndClassName()
  {
    return endClassName;
  }

  public int getLowerBound()
  {
    return lowerBound;
  }

  public int getUpperBound()
  {
    return upperBound;
  }

  public int getOtherLowerBound()
  {
    return otherLowerBound;
  }

  public int getOtherUpperBound()
  {
    return otherUpperBound;
  }

  public void delete()
  {
    super.delete();
  }

  @umplesourcefile(line={143},file={"UmpleImport_CodeModels.ump"},javaline={158},length={15})
  public String generateUmple(){
    StringBuilder builder = this.getUmpleBuilder();
    	builder.append("\n\t");
		boolean isUniDirection = this.getEndClassName() == null;
		if (isUniDirection)
			builder.append("0..1 -> ");
		else {
			builder.append(this.generateMultiplicityBound(
					this.getOtherLowerBound(), this.getOtherUpperBound())
					+ " " + this.getEndClassName() + " -- ");
		}
		builder.append(this.generateMultiplicityBound(this.getLowerBound(),
				this.getUpperBound()) + " " + this.getEndClass() + " " + this.getName() + ";");
    	return builder.toString();
  }

  @umplesourcefile(line={159},file={"UmpleImport_CodeModels.ump"},javaline={175},length={14})
   private String generateMultiplicityBound(int lowerBound, int upperBound){
    String rtn = "";
		if (upperBound == -1) {
			if (lowerBound == 0)
				rtn = "*";
			else
				rtn = StringFormatter.format("{0}..*", lowerBound);
		} else if (lowerBound == upperBound) {
			rtn = StringFormatter.format("{0}", lowerBound);
		} else {
			rtn = StringFormatter.format("{0}..{1}", lowerBound, upperBound);
		}
		return rtn;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "startClass" + ":" + getStartClass()+ "," +
            "endClass" + ":" + getEndClass()+ "," +
            "endClassName" + ":" + getEndClassName()+ "," +
            "lowerBound" + ":" + getLowerBound()+ "," +
            "upperBound" + ":" + getUpperBound()+ "," +
            "otherLowerBound" + ":" + getOtherLowerBound()+ "," +
            "otherUpperBound" + ":" + getOtherUpperBound()+ "]"
     + outputString;
  }
}