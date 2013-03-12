package cruise.attributes.test;

import org.junit.*;

public class ConstraintTest
{
  
  @Test
  public void defaulted()
  {
    Student studentA = new Student(20);
    Assert.assertEquals(false, studentA.setAge(2));
    Assert.assertEquals(true, studentA.setAge(20));
  }
}
