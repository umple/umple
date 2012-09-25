/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.attributes.test;
import java.sql.Date;

public class DoorE
{

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

}