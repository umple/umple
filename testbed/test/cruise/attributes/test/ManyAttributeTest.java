package cruise.attributes.test;

import org.junit.*;
import java.sql.*;

/*unit test for many attributes in Java code*/
public class ManyAttributeTest
{
  private ManyAttribute m1,m2;
  
  @Before
  public void setUp() {
    m1 = new ManyAttribute();
    m2 = new ManyAttribute();
  }

  @After
  public void tearDown() {
    m1.delete();
    m2.delete();
  }
//test addAttribute, removeAttribute
  @Test
  public void testAddRemoveAttributes() {
    Assert.assertTrue(m1.addWork(1));
    Assert.assertTrue(m1.removeWork(1));
    Assert.assertFalse(m1.hasWorks());
  }
//test getAttribute and getAttribute 
  @Test
  public void testGetAttributes() {
    m1.addWork(1);
    m1.addWork(2);
    m1.addWork(3);
    Assert.assertEquals(1, m1.getWork(0).intValue());
    Integer[] works = {1,2,3};
    Assert.assertArrayEquals(works, m1.getWorks());
  }
//test hasAttribute and getAttributeNumber
  @Test
  public void testGetAttributesNum()
  {
    m2.addWork(1);
    Assert.assertEquals(1,m2.numberOfWorks());
    m2.addWork(2);
    m2.addWork(3);    
    Assert.assertEquals(3,m2.numberOfWorks());
    Assert.assertTrue(m2.hasWorks());
  }

}
