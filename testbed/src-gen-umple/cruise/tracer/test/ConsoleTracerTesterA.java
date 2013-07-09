/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.tracer.test;
import cruise.util.ConsoleTracer;
import java.util.Date;

// line 7 "../../../../src/TestHarnessTracer.ump"
public class ConsoleTracerTesterA
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ConsoleTracerTesterA Attributes
  private String name;
  private int numCond;
  private String strCond;
  private int number1;
  private int number2;
  private int number3;
  private int number4;
  private int number5;
  private boolean traceFlag1;
  private boolean traceFlag2;
  private int traceFlag3;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ConsoleTracerTesterA(String aName, int aNumCond, String aStrCond, int aNumber1, int aNumber2, int aNumber3, int aNumber4, int aNumber5)
  {
    name = aName;
    numCond = aNumCond;
    strCond = aStrCond;
    number1 = aNumber1;
    number2 = aNumber2;
    number3 = aNumber3;
    number4 = aNumber4;
    number5 = aNumber5;
    traceFlag1 = false;
    traceFlag2 = true;
    traceFlag3 = 0;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/Users/hjamaan/Documents/uOttawa/GoogleUmple/trunk/testbed/src/TestHarnessTracer.ump,10,ConsoleTracerTesterA,"+System.identityHashCode(this)+",at_s,name,"+name+","+aName );
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumCond(int aNumCond)
  {
    boolean wasSet = false;
    numCond = aNumCond;
    wasSet = true;
    if (numCond==1)
    {
      traceFlag1=true;
    }
    if (numCond<=0)
    {
      traceFlag2=false;
    }
    return wasSet;
  }

  public boolean setStrCond(String aStrCond)
  {
    boolean wasSet = false;
    strCond = aStrCond;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumber1(int aNumber1)
  {
    boolean wasSet = false;
    if (numCond>100)
    {
      ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/Users/hjamaan/Documents/uOttawa/GoogleUmple/trunk/testbed/src/TestHarnessTracer.ump,26,ConsoleTracerTesterA,"+System.identityHashCode(this)+",at_s,number1,"+number1+","+aNumber1 );
    }
    number1 = aNumber1;
    wasSet = true;
    return wasSet;
  }

  public boolean setNumber2(int aNumber2)
  {
    boolean wasSet = false;
    number2 = aNumber2;
    if (numCond==20)
    {
      ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/Users/hjamaan/Documents/uOttawa/GoogleUmple/trunk/testbed/src/TestHarnessTracer.ump,27,ConsoleTracerTesterA,"+System.identityHashCode(this)+",at_s,number2,"+number2 );
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setNumber3(int aNumber3)
  {
    boolean wasSet = false;
    number3 = aNumber3;
    if (traceFlag1)
    {
      ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/Users/hjamaan/Documents/uOttawa/GoogleUmple/trunk/testbed/src/TestHarnessTracer.ump,28,ConsoleTracerTesterA,"+System.identityHashCode(this)+",at_s,number3,"+number3 );
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setNumber4(int aNumber4)
  {
    boolean wasSet = false;
    number4 = aNumber4;
    if (traceFlag2)
    {
      ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/Users/hjamaan/Documents/uOttawa/GoogleUmple/trunk/testbed/src/TestHarnessTracer.ump,29,ConsoleTracerTesterA,"+System.identityHashCode(this)+",at_s,number4,"+number4 );
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setNumber5(int aNumber5)
  {
    boolean wasSet = false;
    if (traceFlag3<3)
    {
      ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/Users/hjamaan/Documents/uOttawa/GoogleUmple/trunk/testbed/src/TestHarnessTracer.ump,30,ConsoleTracerTesterA,"+System.identityHashCode(this)+",at_s,number5,"+number5+","+aNumber5 );
      traceFlag3++;
    }
    number5 = aNumber5;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  /**
   * address;
   * trace get address;
   * Trace attributes with conditions
   */
  public int getNumCond()
  {
    return numCond;
  }

  /**
   * ToBe added string constrints
   */
  public String getStrCond()
  {
    return strCond;
  }

  public int getNumber1()
  {
    return number1;
  }

  public int getNumber2()
  {
    return number2;
  }

  public int getNumber3()
  {
    return number3;
  }

  public int getNumber4()
  {
    return number4;
  }

  public int getNumber5()
  {
    return number5;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "numCond" + ":" + getNumCond()+ "," +
            "strCond" + ":" + getStrCond()+ "," +
            "number1" + ":" + getNumber1()+ "," +
            "number2" + ":" + getNumber2()+ "," +
            "number3" + ":" + getNumber3()+ "," +
            "number4" + ":" + getNumber4()+ "," +
            "number5" + ":" + getNumber5()+ "]"
     + outputString;
  }
}