package cruise.associations;

import org.junit.*;

import cruise.associations.MentorAF;

public class ReflexiveOneTest
{

  @Test
  public void getFriend()
  {
    MentorAF m = new MentorAF("m1","m2");
    MentorAF m2 = m.getFriend();
    
    Assert.assertEquals(m2, m.getFriend());
    Assert.assertEquals(m, m2.getFriend());
  }
  
}
