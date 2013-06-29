/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.tracer.test;
import cruise.util.ConsoleTracer;
import java.util.Date;

/**
 * tracer String;
 */
// line 6 "../../../../src/TestHarnessTracer.ump"
public class PersonA
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PersonA Attributes
  private String name;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PersonA(String aName)
  {
    name = aName;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    ConsoleTracer.handle( System.currentTimeMillis()+","+Thread.currentThread().getId()+",/Users/tcl/nobackup-tmp/CheckoutForUmplePatchTest3/umple/testbed/src/TestHarnessTracer.ump,9,PersonA,"+System.identityHashCode(this)+",at_s,name,"+name+","+aName );
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "]"
     + outputString;
  }
}