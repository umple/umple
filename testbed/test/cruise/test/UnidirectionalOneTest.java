package cruise.test;

import org.junit.*;

public class UnidirectionalOneTest
{

  @Test
  public void ConstructorManySide()
  {
    StudentAH s = new StudentAH(1);
    MentorAH m = new MentorAH("a",s);
    Assert.assertEquals("a",m.getName());
    Assert.assertEquals(1, m.getStudent().getNumber());
  }
  
  @Test(expected=RuntimeException.class)
  public void ConstructorSetNull()
  {
    new MentorAH("a",(StudentAH)null);
  }   
  
  @Test
  public void deleteLeavesStudentAlone()
  {
    MentorAH m = new MentorAH("a",new StudentAH(1));
    StudentAH s = m.getStudent();
    ProgramAH p = new ProgramAH();
    s.setProgram(p);
    m.delete();
    Assert.assertEquals(null, m.getStudent());
    Assert.assertEquals(null, m.getProgram());
    Assert.assertEquals(p, s.getProgram());
    
  }
  
}
