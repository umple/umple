/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

public class KeyTest
{

  @Test
  public void isProvided()
  {
    Key key = new Key();
    Assert.assertEquals(false, key.isProvided());
    key.setIsDefault(true);
    Assert.assertEquals(true, key.isProvided());
    key.setIsDefault(false);
    Assert.assertEquals(false, key.isProvided());
    key.addMember("id");
    Assert.assertEquals(true, key.isProvided());
  }
  
  @Test
  public void isKey_Attribute()
  {
    Attribute av = new Attribute("id","String",null,null,false);
    Key key = new Key();
    
    Assert.assertEquals(false, key.isMember(av));
    key.addMember("id");
    Assert.assertEquals(true, key.isMember(av));
  
    Assert.assertEquals(false, key.isMember((Attribute)null));
  }
  
  @Test
  public void isKey_AssociationVariable()
  {
    AssociationVariable av = new AssociationVariable("student","Student",null,null,createMultiplicity(-1,-1),true);

    Key key = new Key();
    
    Assert.assertEquals(false, key.isMember(av));
    key.addMember("student");
    Assert.assertEquals(true, key.isMember(av));
  
    Assert.assertEquals(false, key.isMember((AssociationVariable)null));

  }

  private Multiplicity createMultiplicity(int lower, int upper)
  {
    Multiplicity m = new Multiplicity();
    m.setRange(lower + "", upper + "");
    return m;
  }
  
}
