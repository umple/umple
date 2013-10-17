/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;

/**
 * This class is used like a structure to help keep values about lines
 * @umplesource SimpleMetrics_CodeLines.ump 225
 */
// line 225 "../../../../src/SimpleMetrics_CodeLines.ump"
public class CountLines
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //CountLines Attributes
  private int countLines;
  private int countComments;
  private int countBlanks;
  private int countCode;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public CountLines()
  {
    countLines = 0;
    countComments = 0;
    countBlanks = 0;
    countCode = 0;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCountLines(int aCountLines)
  {
    boolean wasSet = false;
    countLines = aCountLines;
    wasSet = true;
    return wasSet;
  }

  public boolean setCountComments(int aCountComments)
  {
    boolean wasSet = false;
    countComments = aCountComments;
    wasSet = true;
    return wasSet;
  }

  public boolean setCountBlanks(int aCountBlanks)
  {
    boolean wasSet = false;
    countBlanks = aCountBlanks;
    wasSet = true;
    return wasSet;
  }

  public boolean setCountCode(int aCountCode)
  {
    boolean wasSet = false;
    countCode = aCountCode;
    wasSet = true;
    return wasSet;
  }

  /**
   * total of lines
   */
  public int getCountLines()
  {
    return countLines;
  }

  /**
   * total of comment lines
   */
  public int getCountComments()
  {
    return countComments;
  }

  /**
   * total of blank lines
   */
  public int getCountBlanks()
  {
    return countBlanks;
  }

  /**
   * total of code line
   */
  public int getCountCode()
  {
    return countCode;
  }

  public void delete()
  {}

  @umplesourcefile(line={230},file={"SimpleMetrics_CodeLines.ump"},javaline={110},length={3})
  public void incCountLines(){
    ++this.countLines;
  }

  @umplesourcefile(line={233},file={"SimpleMetrics_CodeLines.ump"},javaline={115},length={3})
  public void incCountComments(){
    ++this.countComments;
  }

  @umplesourcefile(line={236},file={"SimpleMetrics_CodeLines.ump"},javaline={120},length={3})
  public void incCountBlanks(){
    ++this.countBlanks;
  }

  @umplesourcefile(line={239},file={"SimpleMetrics_CodeLines.ump"},javaline={125},length={3})
  public void incCountCode(){
    ++this.countCode;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "countLines" + ":" + getCountLines()+ "," +
            "countComments" + ":" + getCountComments()+ "," +
            "countBlanks" + ":" + getCountBlanks()+ "," +
            "countCode" + ":" + getCountCode()+ "]"
     + outputString;
  }
}