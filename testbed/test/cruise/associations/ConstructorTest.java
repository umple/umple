package cruise.associations;

import org.junit.*;

public class ConstructorTest
{
  @Test
  public void constructorMayHaveMultipleToManyRelationships()
  {
    Otherclass other1 = new Otherclass("one");
    Otherclass other2 = new Otherclass("two");
    Otherclass other3 = new Otherclass("three");
    Otherclass other = new Otherclass("other");
    ConstructorManyClass clazz = new ConstructorManyClass(new Otherclass[]{other1, other2, other3}, new Otherclass[]{other});
    Assert.assertEquals(clazz.numberOfOthersOne(), 3);
    Assert.assertEquals(clazz.numberOfOthersTwo(), 1);
  }
}  
