/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.attributes.test;
import java.sql.Date;

// line 37 "../../../../src/TestHarnessAttributes.ump"
// line 18 "../../../../src/LocalHarness.ump"
public class DoorE
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DoorE Attributes
  private Date d1;
  private Date d2;
  private Date d3;
  private Date d4;

  //Helper Variables
  private boolean canSetD2;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DoorE()
  {
    d1 = Date.valueOf("1978-12-01");
    d2 = Date.valueOf("1978-12-02");
    canSetD2 = false;
    resetD3();
    d4 = Date.valueOf("1978-12-04");
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setD1(Date aD1)
  {
    boolean wasSet = false;
    d1 = aD1;
    wasSet = true;
    return wasSet;
  }

  public boolean setD3(Date aD3)
  {
    boolean wasSet = false;
    d3 = aD3;
    wasSet = true;
    return wasSet;
  }

  public boolean resetD3()
  {
    boolean wasReset = false;
    d3 = getDefaultD3();
    wasReset = true;
    return wasReset;
  }

  public boolean setD4(Date aD4)
  {
    boolean wasSet = false;
    d4 = aD4;
    wasSet = true;
    return wasSet;
  }

  public Date getD1()
  {
    return d1;
  }

  public Date getD2()
  {
    return d2;
  }

  public Date getD3()
  {
    return d3;
  }

  public Date getDefaultD3()
  {
    return Date.valueOf("1978-12-03");
  }

  public Date getD4()
  {
    return d4;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "d1" + "=" + getD1() != null ? !getD1() .equals(this)  ? getD1().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "d2" + "=" + getD2() != null ? !getD2() .equals(this)  ? getD2().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "d3" + "=" + getD3() != null ? !getD3() .equals(this)  ? getD3().toString().replaceAll("  ","    ") : "this" : "null" + System.getProperties().getProperty("line.separator") +
            "  " + "d4" + "=" + getD4() != null ? !getD4() .equals(this)  ? getD4().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }
}