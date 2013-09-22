/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.tracer.test;
import cruise.util.ConsoleTracer;
import java.util.Date;

// line 37 "../../../../src/TestHarnessTracer.ump"
public class TraceAttrCond
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TraceAttrCond Attributes
  private int n1;
  private int n2;
  private int n3;
  private double n4;
  private int n5;
  private int n6;
  private int n7;
  private int n8;
  private int n9;
  private int n10;
  private int numCond;
  private int traceFlag4;
  private int traceFlag5;
  private boolean traceFlag6;
  private int traceFlag7;
  private boolean traceFlag8;
  private int traceFlag9;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TraceAttrCond(int aN1, int aN2, int aN3, double aN4, int aN5, int aN6, int aN7, int aN8, int aN9, int aN10, int aNumCond)
  {
    n1 = aN1;
    n2 = aN2;
    n3 = aN3;
    n4 = aN4;
    n5 = aN5;
    n6 = aN6;
    n7 = aN7;
    n8 = aN8;
    n9 = aN9;
    n10 = aN10;
    numCond = aNumCond;
    traceFlag4 = 0;
    traceFlag5 = 0;
    traceFlag6 = false;
    traceFlag7 = 0;
    traceFlag8 = true;
    traceFlag9 = 0;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setN1(int aN1)
  {
    boolean wasSet = false;
    if (aN1>100&&traceFlag4<2)
    {
      ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/jc/subversion/umple/testbed/src/TestHarnessTracer.ump,53,TraceAttrCond,"+System.identityHashCode(this)+",at_s,n1,"+n1+","+(""+aN1).toString().replace("\n","").replace(",",";") );
      traceFlag4++;
    }
    n1 = aN1;
    wasSet = true;
    return wasSet;
  }

  public boolean setN2(int aN2)
  {
    boolean wasSet = false;
    n2 = aN2;
    if (aN2>50&&traceFlag5<2)
    {
      ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/jc/subversion/umple/testbed/src/TestHarnessTracer.ump,54,TraceAttrCond,"+System.identityHashCode(this)+",at_s,n2,"+n2 );
      traceFlag5++;
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setN3(int aN3)
  {
    boolean wasSet = false;
    n3 = aN3;
    if (traceFlag6&&traceFlag7<2)
    {
      ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/jc/subversion/umple/testbed/src/TestHarnessTracer.ump,55,TraceAttrCond,"+System.identityHashCode(this)+",at_s,n3,"+n3 );
      traceFlag7++;
    }
    wasSet = true;
    if (n3>20)
    {
      traceFlag6=true;
    }
    return wasSet;
  }

  public boolean setN4(double aN4)
  {
    boolean wasSet = false;
    n4 = aN4;
    if (traceFlag8&&traceFlag9<2)
    {
      ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/jc/subversion/umple/testbed/src/TestHarnessTracer.ump,56,TraceAttrCond,"+System.identityHashCode(this)+",at_s,n4,"+n4 );
      traceFlag9++;
    }
    wasSet = true;
    if (n4>10)
    {
      traceFlag8=false;
    }
    return wasSet;
  }

  public boolean setN5(int aN5)
  {
    boolean wasSet = false;
    n5 = aN5;
    wasSet = true;
    return wasSet;
  }

  public boolean setN6(int aN6)
  {
    boolean wasSet = false;
    n6 = aN6;
    wasSet = true;
    return wasSet;
  }

  public boolean setN7(int aN7)
  {
    boolean wasSet = false;
    n7 = aN7;
    wasSet = true;
    return wasSet;
  }

  public boolean setN8(int aN8)
  {
    boolean wasSet = false;
    n8 = aN8;
    wasSet = true;
    return wasSet;
  }

  public boolean setN9(int aN9)
  {
    boolean wasSet = false;
    n9 = aN9;
    wasSet = true;
    return wasSet;
  }

  public boolean setN10(int aN10)
  {
    boolean wasSet = false;
    n10 = aN10;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumCond(int aNumCond)
  {
    boolean wasSet = false;
    numCond = aNumCond;
    wasSet = true;
    return wasSet;
  }

  public int getN1()
  {
    return n1;
  }

  public int getN2()
  {
    return n2;
  }

  public int getN3()
  {
    return n3;
  }

  public double getN4()
  {
    return n4;
  }

  public int getN5()
  {
    return n5;
  }

  public int getN6()
  {
    return n6;
  }

  public int getN7()
  {
    return n7;
  }

  public int getN8()
  {
    return n8;
  }

  public int getN9()
  {
    return n9;
  }

  public int getN10()
  {
    return n10;
  }

  public int getNumCond()
  {
    return numCond;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "n1" + ":" + getN1()+ "," +
            "n2" + ":" + getN2()+ "," +
            "n3" + ":" + getN3()+ "," +
            "n4" + ":" + getN4()+ "," +
            "n5" + ":" + getN5()+ "," +
            "n6" + ":" + getN6()+ "," +
            "n7" + ":" + getN7()+ "," +
            "n8" + ":" + getN8()+ "," +
            "n9" + ":" + getN9()+ "," +
            "n10" + ":" + getN10()+ "," +
            "numCond" + ":" + getNumCond()+ "]"
     + outputString;
  }
}