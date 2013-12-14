package cruise.attributes.test;

import org.junit.*;
import java.sql.*;

public class ConstTest
{
  
  @Test
  public void constant()
  {
    ConstDefault cd = new ConstDefault();

    Date currentDate = new Date(System.currentTimeMillis());
    
    Assert.assertEquals(0, cd.I1);
    Assert.assertEquals(0, cd.I2);
    Assert.assertEquals((double)0.0, cd.D1, (double)0.0);
    Assert.assertEquals((double)0.0, cd.D2, (double)0.0);
    Assert.assertEquals((float)0.0, cd.F1, (float)0.0);
    Assert.assertEquals((float)0.0, cd.F2, (float)0.0);
    Assert.assertEquals(false, cd.B1);
    Assert.assertEquals(false, cd.B2);
    Assert.assertEquals(new String(""), cd.STR);
    Assert.assertEquals(Time.valueOf("00:00:00"), cd.TIME);
    Assert.assertEquals(currentDate.toString(), cd.DATE.toString());
  }

  @Test
  public void constantInterface()
  {
    ConstDefaultInterfaceObject cd = new ConstDefaultInterfaceObject();

    Date currentDate = new Date(System.currentTimeMillis());
    
    Assert.assertEquals(0, cd.I1);
    Assert.assertEquals(0, cd.I2);
    Assert.assertEquals((double)0.0, cd.D1, (double)0.0);
    Assert.assertEquals((double)0.0, cd.D2, (double)0.0);
    Assert.assertEquals((float)0.0, cd.F1, (float)0.0);
    Assert.assertEquals((float)0.0, cd.F2, (float)0.0);
    Assert.assertEquals(false, cd.B1);
    Assert.assertEquals(false, cd.B2);
    Assert.assertEquals(new String(""), cd.STR);
    Assert.assertEquals(Time.valueOf("00:00:00"), cd.TIME);
    Assert.assertEquals(currentDate.toString(), cd.DATE.toString());
  }

}
