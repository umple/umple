package cruise.umple.compiler;

import org.junit.*;

public class UniqueIdentifierTest
{

  @Test
  public void constructor()
  {
    UniqueIdentifier id = new UniqueIdentifier("myId","int",null,null);
    Assert.assertEquals("myId",id.getName());
  }
  
}
