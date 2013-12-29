/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3287 modeling language!*/

package cruise.attributes.test;

// line 58 "../../../../src/TestHarnessAttributes.ump"
public class TypeInference
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TypeInference Attributes
  private int a;
  private double b;
  private boolean c;
  private String d;
  private String e;
  private int f;
  private int g;
  private String h;
  private String i;
  private int j;
  private double k;
  private String l;
  private String m;
  private String n;
  private boolean o;
  private boolean p;
  private double q;
  private double r;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TypeInference(String aE, int aF, String aI, boolean aP, double aQ)
  {
    a = 2;
    b = 3.0;
    c = false;
    d = "hello world!";
    e = aE;
    f = aF;
    g = 42;
    h = "hello";
    i = aI;
    j = -1;
    k = -3.33333;
    l = "-6";
    m = "-3.1415926";
    n = "99";
    o = false;
    p = aP;
    q = aQ;
    r = 3;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setA(int aA)
  {
    boolean wasSet = false;
    a = aA;
    wasSet = true;
    return wasSet;
  }

  public boolean setB(double aB)
  {
    boolean wasSet = false;
    b = aB;
    wasSet = true;
    return wasSet;
  }

  public boolean setC(boolean aC)
  {
    boolean wasSet = false;
    c = aC;
    wasSet = true;
    return wasSet;
  }

  public boolean setD(String aD)
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

  public boolean setF(int aF)
  {
    boolean wasSet = false;
    f = aF;
    wasSet = true;
    return wasSet;
  }

  public boolean setG(int aG)
  {
    boolean wasSet = false;
    g = aG;
    wasSet = true;
    return wasSet;
  }

  public boolean setH(String aH)
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

  public boolean setJ(int aJ)
  {
    boolean wasSet = false;
    j = aJ;
    wasSet = true;
    return wasSet;
  }

  public boolean setK(double aK)
  {
    boolean wasSet = false;
    k = aK;
    wasSet = true;
    return wasSet;
  }

  public boolean setL(String aL)
  {
    boolean wasSet = false;
    l = aL;
    wasSet = true;
    return wasSet;
  }

  public boolean setM(String aM)
  {
    boolean wasSet = false;
    m = aM;
    wasSet = true;
    return wasSet;
  }

  public boolean setN(String aN)
  {
    boolean wasSet = false;
    n = aN;
    wasSet = true;
    return wasSet;
  }

  public boolean setO(boolean aO)
  {
    boolean wasSet = false;
    o = aO;
    wasSet = true;
    return wasSet;
  }

  public boolean setP(boolean aP)
  {
    boolean wasSet = false;
    p = aP;
    wasSet = true;
    return wasSet;
  }

  public boolean setQ(double aQ)
  {
    boolean wasSet = false;
    q = aQ;
    wasSet = true;
    return wasSet;
  }

  public boolean setR(double aR)
  {
    boolean wasSet = false;
    r = aR;
    wasSet = true;
    return wasSet;
  }

  public int getA()
  {
    return a;
  }

  public double getB()
  {
    return b;
  }

  public boolean getC()
  {
    return c;
  }

  public String getD()
  {
    return d;
  }

  public String getE()
  {
    return e;
  }

  public int getF()
  {
    return f;
  }

  public int getG()
  {
    return g;
  }

  public String getH()
  {
    return h;
  }

  public String getI()
  {
    return i;
  }

  public int getJ()
  {
    return j;
  }

  public double getK()
  {
    return k;
  }

  public String getL()
  {
    return l;
  }

  public String getM()
  {
    return m;
  }

  public String getN()
  {
    return n;
  }

  public boolean getO()
  {
    return o;
  }

  public boolean getP()
  {
    return p;
  }

  public double getQ()
  {
    return q;
  }

  public double getR()
  {
    return r;
  }

  public boolean isC()
  {
    return c;
  }

  public boolean isO()
  {
    return o;
  }

  public boolean isP()
  {
    return p;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "a" + ":" + getA()+ "," +
            "b" + ":" + getB()+ "," +
            "c" + ":" + getC()+ "," +
            "d" + ":" + getD()+ "," +
            "e" + ":" + getE()+ "," +
            "f" + ":" + getF()+ "," +
            "g" + ":" + getG()+ "," +
            "h" + ":" + getH()+ "," +
            "i" + ":" + getI()+ "," +
            "j" + ":" + getJ()+ "," +
            "k" + ":" + getK()+ "," +
            "l" + ":" + getL()+ "," +
            "m" + ":" + getM()+ "," +
            "n" + ":" + getN()+ "," +
            "o" + ":" + getO()+ "," +
            "p" + ":" + getP()+ "," +
            "q" + ":" + getQ()+ "," +
            "r" + ":" + getR()+ "]"
     + outputString;
  }
}