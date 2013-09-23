/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.18.0.3036 modeling language!*/

package cruise.umple.compiler;

/**
 * Class that help measure data about lines
 * @umplesource Generator_CodeSimpleMetrics.ump 661
 */
// line 661 "../../../../src/Generator_CodeSimpleMetrics.ump"
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

  public int getCountLines()
  {
    return countLines;
  }

  /**
   * total of lines
   */
  public int getCountComments()
  {
    return countComments;
  }

  /**
   * total of comment lines
   */
  public int getCountBlanks()
  {
    return countBlanks;
  }

  /**
   * total of blank lines
   */
  public int getCountCode()
  {
    return countCode;
  }

  public void delete()
  {}


  /**
   * total of code line
   */
  @umplesourcefile(line={666},file={"Generator_CodeSimpleMetrics.ump"},javaline={107},length={3})
  public void incCountLines(){
    ++this.countLines;
  }

  @umplesourcefile(line={669},file={"Generator_CodeSimpleMetrics.ump"},javaline={116},length={3})
  public void incCountComments(){
    ++this.countComments;
  }

  @umplesourcefile(line={672},file={"Generator_CodeSimpleMetrics.ump"},javaline={121},length={3})
  public void incCountBlanks(){
    ++this.countBlanks;
  }

  @umplesourcefile(line={675},file={"Generator_CodeSimpleMetrics.ump"},javaline={126},length={3})
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