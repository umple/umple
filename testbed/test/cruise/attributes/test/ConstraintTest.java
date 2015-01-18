package cruise.attributes.test;

import org.junit.*;

public class ConstraintTest
{

  @Test
  public void checkConstraint()
  {
    BoatA boat = new BoatA(20);
    Assert.assertEquals(false, boat.setAge(18));
    Assert.assertEquals(true, boat.setAge(19));
  }

  @Test
  public void checkNegation()
  {
    BoatB boat = new BoatB(2);
    Assert.assertEquals(true, boat.setAge(18));
    Assert.assertEquals(false, boat.setAge(19));
  }

}
