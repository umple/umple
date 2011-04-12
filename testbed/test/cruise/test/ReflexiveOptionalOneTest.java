package cruise.test;

import org.junit.*;

public class ReflexiveOptionalOneTest
{

  @Test
  public void SetSuperMentor()
  {
    MentorH m = new MentorH("m1");
    MentorH m2 = new MentorH("m2");
    
    m.setSuperMentor(m2);
    Assert.assertEquals(m, m2.getSuperMentor());
    Assert.assertEquals(m2, m.getSuperMentor());
  }
  
}
