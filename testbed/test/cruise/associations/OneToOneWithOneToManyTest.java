package cruise.associations;

import org.junit.*;

import cruise.associations.MentorAN;
import cruise.associations.StudentAN;

public class OneToOneWithOneToManyTest
{

  @Test
  public void CreateMentorWithoutStudents()
  {
    MentorAN m = new MentorAN("blah");
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertTrue(m.getGradStudent() != null);
  }
}
