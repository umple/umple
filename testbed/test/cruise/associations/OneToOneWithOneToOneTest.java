package cruise.associations;

import org.junit.*;

import cruise.associations.MentorAP;
import cruise.associations.StudentAP;

public class OneToOneWithOneToOneTest
{

  @Test
  public void CreateMentorWithoutStudents()
  {
    MentorAP m = new MentorAP("blah",999);
    Assert.assertTrue(m.getStudent() != null);
    Assert.assertEquals(m.getStudent().getNumber(), 999);
    Assert.assertTrue(m.getGradStudent() != null);
  }

}
