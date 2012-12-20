package cruise.associations;

import org.junit.*;

import cruise.associations.MentorAI;
import cruise.associations.ProgramAI;
import cruise.associations.StudentAI;

public class UnidirectionalOptionalOneTest
{

  @Test
  public void setStudent()
  {
    StudentAI s = new StudentAI(1);
    MentorAI m = new MentorAI("a");
    Assert.assertEquals("a",m.getName());
    Assert.assertEquals(null,m.getStudent());

    m.setStudent(s);
    Assert.assertEquals(s,m.getStudent());
    Assert.assertEquals(1, m.getStudent().getNumber());
  }
  
  @Test
  public void deleteLeavesStudentAlone()
  {
    MentorAI m = new MentorAI("a");
    StudentAI s = new StudentAI(1);
    m.setStudent(s);
    ProgramAI p = new ProgramAI();
    s.setProgram(p);
    m.delete();
    Assert.assertEquals(null, m.getStudent());
    Assert.assertEquals(null, m.getProgram());
    Assert.assertEquals(p, s.getProgram());
    
  }
  
}
