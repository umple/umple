package cruise.attributes.test;

import org.junit.*;
import java.sql.*;

public class UniqueImmutableTest
{
  private ItemWithUniqueImmutableId one, two;
  
  @Before
  public void setUp() {
    one = new ItemWithUniqueImmutableId("1");
    two = new ItemWithUniqueImmutableId("2");
  }

  @After
  public void tearDown() {
    one.delete();
    two.delete();
  }

  @Test(expected = RuntimeException.class)
  public void testCreateWithDuplicates() {
    ItemWithUniqueImmutableId duplicate = new ItemWithUniqueImmutableId("1"); 
  }
  
  @Test
  public void testHasWithGetWith() {
    Assert.assertTrue(ItemWithUniqueImmutableId.hasWithId("1"));
    Assert.assertFalse(ItemWithUniqueImmutableId.hasWithId("3"));
    Assert.assertEquals(ItemWithUniqueImmutableId.getWithId("1"), one);
    Assert.assertEquals(ItemWithUniqueImmutableId.getWithId("2"), two);
    Assert.assertNull(ItemWithUniqueImmutableId.getWithId("3"));
  }
  
  @Test
  public void testSetId() {
    // Attempt to change id to "1", which is already used.
    // This should fail and so id should still be "2".
    Assert.assertFalse(two.setId("1"));
    Assert.assertEquals(two.getId(), "2");
    // Attempt to change id to "3", which is free, but attribute is immutable
    // This should fail and so id should still be "2".
    Assert.assertFalse(two.setId("3"));
    Assert.assertEquals(two.getId(), "2");
    Assert.assertFalse(ItemWithUniqueImmutableId.hasWithId("3"));
    // Since "3" is still free, create ItemWithUniqueImmutableId with "3". 
    ItemWithUniqueImmutableId three = new ItemWithUniqueImmutableId("3");
    three.delete();
  }
}
