/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.2716 modeling language!*/

package cruise.associations;
import java.util.*;

// line 638 "../../../src/TestHarnessAssociations.ump"
public class ClassWithManySortedAssociations
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int line();String file();int javaline();int length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassWithManySortedAssociations Attributes
  private Comparator<StudentC> studentCsPriority;
  private Comparator<StudentAL> studentALsPriority;

  //ClassWithManySortedAssociations Associations
  private List<StudentC> studentCs;
  private List<StudentAL> studentALs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassWithManySortedAssociations()
  {
    studentCsPriority = 
      new Comparator<StudentC>(){
        @Override
        public int compare(StudentC arg0, StudentC arg1)
        {
          return ((Integer)arg0.getId()).compareTo(
                 ((Integer)arg1.getId()));
        }
      };
    studentALsPriority = 
      new Comparator<StudentAL>(){
        @Override
        public int compare(StudentAL arg0, StudentAL arg1)
        {
          return ((Integer)arg0.getNumber()).compareTo(
                 ((Integer)arg1.getNumber()));
        }
      };
    studentCs = new ArrayList<StudentC>();
    studentALs = new ArrayList<StudentAL>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStudentCsPriority(Comparator<StudentC> aStudentCsPriority)
  {
    boolean wasSet = false;
    studentCsPriority = aStudentCsPriority;
    wasSet = true;
    return wasSet;
  }

  public boolean setStudentALsPriority(Comparator<StudentAL> aStudentALsPriority)
  {
    boolean wasSet = false;
    studentALsPriority = aStudentALsPriority;
    wasSet = true;
    return wasSet;
  }

  public Comparator<StudentC> getStudentCsPriority()
  {
    return studentCsPriority;
  }

  public Comparator<StudentAL> getStudentALsPriority()
  {
    return studentALsPriority;
  }

  public StudentC getStudentC(int index)
  {
    StudentC aStudentC = studentCs.get(index);
    return aStudentC;
  }

  public List<StudentC> getStudentCs()
  {
    List<StudentC> newStudentCs = Collections.unmodifiableList(studentCs);
    return newStudentCs;
  }

  public int numberOfStudentCs()
  {
    int number = studentCs.size();
    return number;
  }

  public boolean hasStudentCs()
  {
    boolean has = studentCs.size() > 0;
    return has;
  }

  public int indexOfStudentC(StudentC aStudentC)
  {
    int index = studentCs.indexOf(aStudentC);
    return index;
  }

  public StudentAL getStudentAL(int index)
  {
    StudentAL aStudentAL = studentALs.get(index);
    return aStudentAL;
  }

  public List<StudentAL> getStudentALs()
  {
    List<StudentAL> newStudentALs = Collections.unmodifiableList(studentALs);
    return newStudentALs;
  }

  public int numberOfStudentALs()
  {
    int number = studentALs.size();
    return number;
  }

  public boolean hasStudentALs()
  {
    boolean has = studentALs.size() > 0;
    return has;
  }

  public int indexOfStudentAL(StudentAL aStudentAL)
  {
    int index = studentALs.indexOf(aStudentAL);
    return index;
  }

  public static int minimumNumberOfStudentCs()
  {
    return 0;
  }

  public boolean addStudentC(StudentC aStudentC)
  {
    boolean wasAdded = false;
    if (studentCs.contains(aStudentC)) { return false; }
    studentCs.add(aStudentC);
    wasAdded = true;
    if(wasAdded)
        Collections.sort(studentCs, studentCsPriority);
    
    return wasAdded;
  }

  public boolean removeStudentC(StudentC aStudentC)
  {
    boolean wasRemoved = false;
    if (studentCs.contains(aStudentC))
    {
      studentCs.remove(aStudentC);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  
  public static int minimumNumberOfStudentALs()
  {
    return 0;
  }

  public boolean addStudentAL(StudentAL aStudentAL)
  {
    boolean wasAdded = false;
    if (studentALs.contains(aStudentAL)) { return false; }
    studentALs.add(aStudentAL);
    wasAdded = true;
    if(wasAdded)
        Collections.sort(studentALs, studentALsPriority);
    
    return wasAdded;
  }

  public boolean removeStudentAL(StudentAL aStudentAL)
  {
    boolean wasRemoved = false;
    if (studentALs.contains(aStudentAL))
    {
      studentALs.remove(aStudentAL);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public void delete()
  {
    studentCs.clear();
    studentALs.clear();
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "studentCsPriority" + "=" + (getStudentCsPriority() != null ? !getStudentCsPriority().equals(this)  ? getStudentCsPriority().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "studentALsPriority" + "=" + (getStudentALsPriority() != null ? !getStudentALsPriority().equals(this)  ? getStudentALsPriority().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}