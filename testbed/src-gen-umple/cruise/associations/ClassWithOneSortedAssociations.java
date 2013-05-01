/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.17.0.${svn.Revision} modeling language!*/

package cruise.associations;
import java.util.*;

// line 635 "../../../src/TestHarnessAssociations.ump"
public class ClassWithOneSortedAssociations
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ClassWithOneSortedAssociations Attributes
  private Comparator<StudentC> studentCsPriority;

  //ClassWithOneSortedAssociations Associations
  private List<StudentC> studentCs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ClassWithOneSortedAssociations()
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
    studentCs = new ArrayList<StudentC>();
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

  public Comparator<StudentC> getStudentCsPriority()
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

  
  public void delete()
  {
    studentCs.clear();
  }


  public String toString()
  {
	  String outputString = "";
	  
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "studentCsPriority" + "=" + getStudentCsPriority() != null ? !getStudentCsPriority() .equals(this)  ? getStudentCsPriority().toString().replaceAll("  ","    ") : "this" : "null"
     + outputString;
  }
}