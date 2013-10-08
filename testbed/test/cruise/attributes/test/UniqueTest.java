package cruise.attributes.test;

import org.junit.*;
import java.sql.*;

public class UniqueTest
{
  private ItemWithUniqueId one, two;
  
  @Before
  public void setUp() {
    one = new ItemWithUniqueId("1");
    two = new ItemWithUniqueId("2");
  }

  @After
  public void tearDown() {
    one.delete();
    two.delete();
  }

  @Test(expected = RuntimeException.class)
  public void testCreateWithDuplicates() {
    ItemWithUniqueId duplicate = new ItemWithUniqueId("1"); 
  }
  
  @Test
  public void testHasWithGetWith() {
    Assert.assertTrue(ItemWithUniqueId.hasWithId("1"));
    Assert.assertFalse(ItemWithUniqueId.hasWithId("3"));
    Assert.assertEquals(ItemWithUniqueId.getWithId("1"), one);
    Assert.assertEquals(ItemWithUniqueId.getWithId("2"), two);
    Assert.assertNull(ItemWithUniqueId.getWithId("3"));
  }
  
  @Test
  public void testSetId() {
    // Attempt to change id to "1", which is already used.
    // This should fail and so id should still be "2".
    Assert.assertFalse(two.setId("1"));
    Assert.assertEquals(two.getId(), "2");
    // Attempt to change id to "3", which is free.
    // This should succeed and "2" should become available.
    Assert.assertTrue(two.setId("3"));
    Assert.assertEquals(two.getId(), "3");
    Assert.assertFalse(ItemWithUniqueId.hasWithId("2"));
    // Now that "2" is available, we can create a new ItemWithUniqueId with id "2" with no error.
    ItemWithUniqueId newTwo = new ItemWithUniqueId("2");
    newTwo.delete();
  }
}
