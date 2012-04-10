package cruise.associations;

import org.junit.*;

import cruise.associations.MentorAO;
import cruise.associations.StudentAO;

public class OneToOneWithOneToNTest
{

  @Test
  public void CreateMentorWithoutStudents()
  {
    MentorAO m = new MentorAO("blah");
    Assert.assertEquals(0,m.numberOfStudents());
    Assert.assertTrue(m.getGradStudent() != null);
  }

}

