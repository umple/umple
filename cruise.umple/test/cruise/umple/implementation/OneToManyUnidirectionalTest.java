/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.Assert;

import org.junit.*;

public class OneToManyUnidirectionalTest extends TemplateTest
{

  @Test(expected = RuntimeException.class)
  public void cannotCreateNullStudent()
  {
    new Student("aha", null);
  }

  @Test
  public void addStudent()
  {
    Mentor m = new Mentor();
    Student s = m.addStudent("123");

    Assert.assertEquals(s, m.getStudent(0));
  }

  @Test
  public void replaceMentor()
  {
    Mentor m = new Mentor();
    Mentor m2 = new Mentor();

    Student s = m.addStudent("123");

    Assert.assertEquals(1, m.numberOfStudents());
    Assert.assertEquals(0, m2.numberOfStudents());
    
    m2.addStudent(s);

    Assert.assertEquals(0, m.numberOfStudents());
    Assert.assertEquals(1, m2.numberOfStudents());

    Assert.assertEquals(s, m2.getStudent(0));
  }

  @Test
  public void addToNewMentor()
  {
    Mentor m = new Mentor();
    Mentor m2 = new Mentor();

    Student s = m.addStudent("123");
    m2.addStudent(s);

    Assert.assertEquals(0, m.numberOfStudents());
    Assert.assertEquals(1, m2.numberOfStudents());

    Assert.assertEquals(s, m2.getStudent(0));
  }

  @Test
  public void removeFromExistingMentor()
  {
    Mentor m = new Mentor();
    Mentor m2 = new Mentor();

    Student s1 = m.addStudent("123");
    Student s2 = m.addStudent("124");
    Student s3 = m.addStudent("125");

    Assert.assertEquals(3, m.numberOfStudents());
    Assert.assertEquals(0, m2.numberOfStudents());

    m2.addStudent(s1);

    Assert.assertEquals(2, m.numberOfStudents());
    Assert.assertEquals(s2, m.getStudent(0));
    Assert.assertEquals(s3, m.getStudent(1));

    Assert.assertEquals(1, m2.numberOfStudents());
    Assert.assertEquals(s1, m2.getStudent(0));
  }
  
  // Below represents the ideal implementation of a Driver / Subordinate
  // relationship representing 1 -- * when unidirectional
  // Mentor knows about Student, but Student does not know about Mentor

  public class Mentor
  {

    private List<Student> students;

    public Mentor()
    {
      students = new ArrayList<Student>();
    }

    public Student addStudent(String aNumber)
    {
      try
      {
        Class<?>[] argumentTypes = new Class<?>[] {OneToManyUnidirectionalTest.class, String.class, Mentor.class};
        Object[] argumentsValues = new Object[] {new OneToManyUnidirectionalTest(),aNumber,this};
        java.lang.reflect.Constructor<?> constructor = Student.class.getDeclaredConstructor(argumentTypes);
        constructor.setAccessible(true);
        return (Student)constructor.newInstance(argumentsValues);     
      }
      catch (Exception e)
      {
        e.printStackTrace();
        throw new RuntimeException("Unable to add student",e);
        
      }
    }

    public boolean addStudent(Student aStudent)
    {
      if (students.contains(aStudent))
      {
        return false;
      }

      try
      {
        java.lang.reflect.Field mentorField = aStudent.getClass().getDeclaredField("mentor");
        mentorField.setAccessible(true);
        Mentor existingMentor = (Mentor) mentorField.get(aStudent);
        boolean isNewMentor = existingMentor != null && !existingMentor.equals(this);
        if (isNewMentor)
        {
          existingMentor.students.remove(aStudent);
          mentorField.set(aStudent, this);
        }
        students.add(aStudent);
        return true;
      }
      catch (Exception e)
      {
        e.printStackTrace();
        throw new RuntimeException("Unable to add student [2]", e);
      }
    }

    public Student getStudent(int index)
    {
      return students.get(index);
    }

    public Iterator<Student> getStudents()
    {
      return students.iterator();
    }

    public int numberOfStudents()
    {
      return students.size();
    }

    public boolean hasStudents()
    {
      return students.size() > 0;
    }

  }

  @SuppressWarnings("unused")
  public class Student
  {
    private String name;
    private Mentor mentor;

    private Student(String aName, Mentor aMentor)
    {
      name = aName;
      mentor = aMentor;
      aMentor.addStudent(this);
    }

  }

}
