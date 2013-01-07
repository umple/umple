/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;
import java.util.*;

// line 635 "../../../src/TestHarnessAssociations.ump"
public class ClassWithOneSortedAssociations
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassWithOneSortedAssociations Attributes
  private String studentCsPriority;

  //ClassWithOneSortedAssociations Associations
  private List<StudentC> studentCs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassWithOneSortedAssociations()
  {
    studentCsPriority = "id";
    studentCs = new ArrayList<StudentC>();
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

  public String getStudentCsPriority()
  {
    return studentCsPriority;
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

  public void delete()
  {
    studentCs.clear();
  }

}