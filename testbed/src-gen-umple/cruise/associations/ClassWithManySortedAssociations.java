/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;
import java.util.*;

// line 638 "../../../src/TestHarnessAssociations.ump"
public class ClassWithManySortedAssociations
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassWithManySortedAssociations Attributes
  private String studentCsPriority;
  private String studentALsPriority;

  //ClassWithManySortedAssociations Associations
  private List<StudentC> studentCs;
  private List<StudentAL> studentALs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassWithManySortedAssociations()
  {
    studentCsPriority = "id";
    studentALsPriority = "number";
    studentCs = new ArrayList<StudentC>();
    studentALs = new ArrayList<StudentAL>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStudentCsPriority(String aStudentCsPriority)
  {
    boolean wasSet = false;
    studentCsPriority = aStudentCsPriority;
    wasSet = true;
    return wasSet;
  }

  public boolean setStudentALsPriority(String aStudentALsPriority)
  {
    boolean wasSet = false;
    studentALsPriority = aStudentALsPriority;
    wasSet = true;
    return wasSet;
  }

  public String getStudentCsPriority()
  {
    return studentCsPriority;
  }

  public String getStudentALsPriority()
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
    sort(studentCs, studentCsPriority);
    
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
    sort(studentCs, studentCsPriority);
    
    return wasRemoved;
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public void sort(List toSort, final String thePriority)
  {
    if(toSort.size() > 0)
    {
      Collections.sort(toSort, new Comparator<Object>()
      {
        @Override
        public int compare(Object arg0, Object arg1)
        {
          try
          {
            String methodName = "get" + thePriority.substring(0, 1).toUpperCase() + thePriority.substring(1);
            return ((Comparable)arg0.getClass().getMethod(methodName).invoke(arg0)).compareTo((Comparable)arg1.getClass().getMethod(methodName).invoke(arg1));
          }
          catch (Exception e)
          {
            e.printStackTrace();
          }
          return 0;
        }
      });
    }
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
    sort(studentALs, studentALsPriority);
    
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
    sort(studentALs, studentALsPriority);
    
    return wasRemoved;
  }

  public void delete()
  {
    studentCs.clear();
    studentALs.clear();
  }

}