/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.1751 modeling language!*/

package cruise.associations;
import java.util.*;

public class MentorAQ
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //MentorAQ Associations
  private List<StudentAQ> studentAQs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public MentorAQ(StudentAQ... allStudentAQs)
  {
    studentAQs = new ArrayList<StudentAQ>();
    boolean didAddStudentAQs = setStudentAQs(allStudentAQs);
    if (!didAddStudentAQs)
    {
      throw new RuntimeException("Unable to create MentorAQ, must have 2 studentAQs");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public StudentAQ getStudentAQ(int index)
  {
    StudentAQ aStudentAQ = studentAQs.get(index);
    return aStudentAQ;
  }

  public List<StudentAQ> getStudentAQs()
  {
    List<StudentAQ> newStudentAQs = Collections.unmodifiableList(studentAQs);
    return newStudentAQs;
  }

  public int numberOfStudentAQs()
  {
    int number = studentAQs.size();
    return number;
  }

  public boolean hasStudentAQs()
  {
    boolean has = studentAQs.size() > 0;
    return has;
  }

  public int indexOfStudentAQ(StudentAQ aStudentAQ)
  {
    int index = studentAQs.indexOf(aStudentAQ);
    return index;
  }

  public static int requiredNumberOfStudentAQs()
  {
    return 2;
  }

  public static int minimumNumberOfStudentAQs()
  {
    return 2;
  }

  public static int maximumNumberOfStudentAQs()
  {
    return 2;
  }

  public boolean setStudentAQs(StudentAQ... newStudentAQs)
  {
    boolean wasSet = false;
    ArrayList<StudentAQ> checkNewStudentAQs = new ArrayList<StudentAQ>();
    for (StudentAQ newStudentAQ : newStudentAQs)
    {
      if (checkNewStudentAQs.contains(newStudentAQ))
      {
        return wasSet;
      }
      else if (newStudentAQ.getMentorAQ() != null && !this.equals(newStudentAQ.getMentorAQ()))
      {
        return wasSet;
      }
      checkNewStudentAQs.add(newStudentAQ);
    }

    if (checkNewStudentAQs.size() != minimumNumberOfStudentAQs())
    {
      return wasSet;
    }

    studentAQs.removeAll(checkNewStudentAQs);
    
    for (StudentAQ orphan : studentAQs)
    {
      setMentorAQ(orphan, null);
    }
    studentAQs.clear();
    for (StudentAQ newStudentAQ : newStudentAQs)
    {
      setMentorAQ(newStudentAQ, this);
      studentAQs.add(newStudentAQ);
    }
    wasSet = true;
    return wasSet;
  }

  private void setMentorAQ(StudentAQ aStudentAQ, MentorAQ aMentorAQ)
  {
    try
    {
      java.lang.reflect.Field mentorField = aStudentAQ.getClass().getDeclaredField("mentorAQ");
      mentorField.setAccessible(true);
      mentorField.set(aStudentAQ, aMentorAQ);
    }
    catch (Exception e)
    {
      throw new RuntimeException("Issue internally setting aMentorAQ to aStudentAQ", e);
    }
  }

  public void delete()
  {
    for(StudentAQ aStudentAQ : studentAQs)
    {
      setMentorAQ(aStudentAQ,null);
    }
    studentAQs.clear();
  }

}