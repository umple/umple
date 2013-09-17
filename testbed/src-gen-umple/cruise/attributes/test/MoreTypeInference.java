/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.attributes.test;
import java.sql.Time;
import java.sql.Date;

// line 78 "../../../../src/TestHarnessAttributes.ump"
public class MoreTypeInference
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MoreTypeInference Attributes
  private Time a;
  private Time b;
  private String c;
  private Time d;
  private String e;
  private String f;
  private Date g;
  private Date h;
  private String i;
  private String j;
  private Date k;
  private Object l;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MoreTypeInference(Time aB, Date aH)
  {
    a = Time.valueOf("12:12:12");
    b = aB;
    c = "12:12";
    d = Time.valueOf("12:12:12");
    e = "99:99:99";
    f = "2000:01:01";
    g = Date.valueOf("2000-01-01");
    h = aH;
    i = "2000-01";
    j = "2000:01:01";
    k = Date.valueOf("2000-01-01");
    l = new Object();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setA(Time aA)
  {
    boolean wasSet = false;
    a = aA;
    wasSet = true;
    return wasSet;
  }

  public boolean setB(Time aB)
  {
    boolean wasSet = false;
    b = aB;
    wasSet = true;
    return wasSet;
  }

  public boolean setC(String aC)
  {
    boolean wasSet = false;
    c = aC;
    wasSet = true;
    return wasSet;
  }

  public boolean setD(Time aD)
  {
    boolean wasSet = false;
    d = aD;
    wasSet = true;
    return wasSet;
  }

  public boolean setE(String aE)
  {
    boolean wasSet = false;
    e = aE;
    wasSet = true;
    return wasSet;
  }

  public boolean setF(String aF)
  {
    boolean wasSet = false;
    f = aF;
    wasSet = true;
    return wasSet;
  }

  public boolean setG(Date aG)
  {
    boolean wasSet = false;
    g = aG;
    wasSet = true;
    return wasSet;
  }

  public boolean setH(Date aH)
  {
    boolean wasSet = false;
    h = aH;
    wasSet = true;
    return wasSet;
  }

  public boolean setI(String aI)
  {
    boolean wasSet = false;
    i = aI;
    wasSet = true;
    return wasSet;
  }

  public boolean setJ(String aJ)
  {
    boolean wasSet = false;
    j = aJ;
    wasSet = true;
    return wasSet;
  }

  public boolean setK(Date aK)
  {
    boolean wasSet = false;
    k = aK;
    wasSet = true;
    return wasSet;
  }

  public boolean setL(Object aL)
  {
    boolean wasSet = false;
    l = aL;
    wasSet = true;
    return wasSet;
  }

  public Time getA()
  {
    return a;
  }

  public Time getB()
  {
    return b;
  }

  public String getC()
  {
    return c;
  }

  public Time getD()
  {
    return d;
  }

  public String getE()
  {
    return e;
  }

  public String getF()
  {
    return f;
  }

  public Date getG()
  {
    return g;
  }

  public Date getH()
  {
    return h;
  }

  public String getI()
  {
    return i;
  }

  public String getJ()
  {
    return j;
  }

  public Date getK()
  {
    return k;
  }

  public Object getL()
  {
    return l;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "c" + ":" + getC()+ "," +
            "e" + ":" + getE()+ "," +
            "f" + ":" + getF()+ "," +
            "i" + ":" + getI()+ "," +
            "j" + ":" + getJ()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "a" + "=" + (getA() != null ? !getA().equals(this)  ? getA().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "b" + "=" + (getB() != null ? !getB().equals(this)  ? getB().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "d" + "=" + (getD() != null ? !getD().equals(this)  ? getD().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "g" + "=" + (getG() != null ? !getG().equals(this)  ? getG().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "h" + "=" + (getH() != null ? !getH().equals(this)  ? getH().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "k" + "=" + (getK() != null ? !getK().equals(this)  ? getK().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "l" + "=" + (getL() != null ? !getL().equals(this)  ? getL().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}