/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.tracer.test;
import cruise.util.ConsoleTracer;
import java.util.Date;
import java.util.*;

// line 39 "../../../../src/TestHarnessTracer.ump"
public class TraceAttr
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TraceAttr Attributes
  private String name;
  private String address;
  private double salary;
  private List<Integer> id;
  private int numCond;
  private String strCond;
  private int number1;
  private int number2;
  private int number3;
  private double number4;
  private String str;
  private boolean traceFlag1;
  private boolean traceFlag2;
  private int traceFlag3;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TraceAttr(String aName, String aAddress, double aSalary, int aNumCond, String aStrCond, int aNumber1, int aNumber2, int aNumber3, double aNumber4, String aStr)
  {
    name = aName;
    address = aAddress;
    salary = aSalary;
    id = new ArrayList<Integer>();
    numCond = aNumCond;
    strCond = aStrCond;
    number1 = aNumber1;
    number2 = aNumber2;
    number3 = aNumber3;
    number4 = aNumber4;
    str = aStr;
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
    ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/geoff/programs/umple/umple/build/umple/testbed/src/TestHarnessTracer.ump,47,TraceAttr,"+System.identityHashCode(this)+",at_s,name,"+name+","+aName );
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setAddress(String aAddress)
  {
    boolean wasSet = false;
    address = aAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setSalary(double aSalary)
  {
    boolean wasSet = false;
    ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/geoff/programs/umple/umple/build/umple/testbed/src/TestHarnessTracer.ump,50,TraceAttr,"+System.identityHashCode(this)+",at_s,salary,"+salary+","+aSalary );
    salary = aSalary;
    wasSet = true;
    return wasSet;
  }

  public boolean addId(Integer aId)
  {
    boolean wasAdded = false;
    ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/geoff/programs/umple/umple/build/umple/testbed/src/TestHarnessTracer.ump,48,TraceAttr,"+System.identityHashCode(this)+",at_a,id,"+id+","+aId );
    wasAdded = id.add(aId);
    return wasAdded;
  }

  public boolean removeId(Integer aId)
  {
    boolean wasRemoved = false;
    ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/geoff/programs/umple/umple/build/umple/testbed/src/TestHarnessTracer.ump,48,TraceAttr,"+System.identityHashCode(this)+",at_r,id,"+id+","+aId );
    wasRemoved = id.remove(aId);
    return wasRemoved;
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
      ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/geoff/programs/umple/umple/build/umple/testbed/src/TestHarnessTracer.ump,63,TraceAttr,"+System.identityHashCode(this)+",at_s,number1,"+number1+","+aNumber1 );
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
      ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/geoff/programs/umple/umple/build/umple/testbed/src/TestHarnessTracer.ump,64,TraceAttr,"+System.identityHashCode(this)+",at_s,number2,"+number2 );
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
      ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/geoff/programs/umple/umple/build/umple/testbed/src/TestHarnessTracer.ump,65,TraceAttr,"+System.identityHashCode(this)+",at_s,number3,"+number3 );
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setNumber4(double aNumber4)
  {
    boolean wasSet = false;
    number4 = aNumber4;
    if (traceFlag2)
    {
      ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/geoff/programs/umple/umple/build/umple/testbed/src/TestHarnessTracer.ump,66,TraceAttr,"+System.identityHashCode(this)+",at_s,number4,"+number4 );
    }
    wasSet = true;
    return wasSet;
  }

  public boolean setStr(String aStr)
  {
    boolean wasSet = false;
    if (traceFlag3<3)
    {
      ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/geoff/programs/umple/umple/build/umple/testbed/src/TestHarnessTracer.ump,67,TraceAttr,"+System.identityHashCode(this)+",at_s,str,"+str+","+aStr );
      traceFlag3++;
    }
    str = aStr;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/geoff/programs/umple/umple/build/umple/testbed/src/TestHarnessTracer.ump,49,TraceAttr,"+System.identityHashCode(this)+",at_g,address,"+address );
    return address;
  }

  public double getSalary()
  {
    ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/home/geoff/programs/umple/umple/build/umple/testbed/src/TestHarnessTracer.ump,50,TraceAttr,"+System.identityHashCode(this)+",at_g,salary,"+salary );
    return salary;
  }

  public Integer getId(int index)
  {
    Integer aId = id.get(index);
    return aId;
  }

  public Integer[] getId()
  {
    Integer[] newId = id.toArray(new Integer[id.size()]);
    return newId;
  }

  public int numberOfId()
  {
    int number = id.size();
    return number;
  }

  public boolean hasId()
  {
    boolean has = id.size() > 0;
    return has;
  }

  public int indexOfId(Integer aId)
  {
    int index = id.indexOf(aId);
    return index;
  }

  /**
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

  public double getNumber4()
  {
    return number4;
  }

  public String getStr()
  {
    return str;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "address" + ":" + getAddress()+ "," +
            "salary" + ":" + getSalary()+ "," +
            "numCond" + ":" + getNumCond()+ "," +
            "strCond" + ":" + getStrCond()+ "," +
            "number1" + ":" + getNumber1()+ "," +
            "number2" + ":" + getNumber2()+ "," +
            "number3" + ":" + getNumber3()+ "," +
            "number4" + ":" + getNumber4()+ "," +
            "str" + ":" + getStr()+ "]"
     + outputString;
  }
}