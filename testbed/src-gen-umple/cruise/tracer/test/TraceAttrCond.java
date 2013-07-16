/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.tracer.test;
import cruise.util.ConsoleTracer;
import java.util.Date;

// line 70 "../../../../src/TestHarnessTracer.ump"
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
  private int numCond;
  private int traceFlag4;
  private int traceFlag5;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TraceAttrCond(int aN1, int aN2, int aN3, double aN4, int aNumCond)
  {
    n1 = aN1;
    n2 = aN2;
    n3 = aN3;
    n4 = aN4;
    numCond = aNumCond;
    traceFlag4 = 0;
    traceFlag5 = 0;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setN1(int aN1)
  {
    boolean wasSet = false;
    if (aN1>100&&traceFlag4<2)
    {
      ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/geoff/programs/umple/umple/build/umple/testbed/src/TestHarnessTracer.ump,80,TraceAttrCond,"+System.identityHashCode(this)+",at_s,n1,"+n1+","+aN1 );
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
      ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/geoff/programs/umple/umple/build/umple/testbed/src/TestHarnessTracer.ump,81,TraceAttrCond,"+System.identityHashCode(this)+",at_s,n2,"+n2 );
      traceFlag5++;
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setN3(int aN3)
  {
    boolean wasSet = false;
    n3 = aN3;
    wasSet = true;
    return wasSet;
  }

  public boolean setN4(double aN4)
  {
    boolean wasSet = false;
    n4 = aN4;
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
            "numCond" + ":" + getNumCond()+ "]"
     + outputString;
  }
}