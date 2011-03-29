package cruise.umple.util;
import junit.framework.Assert;

public class AssertHelper 
{

  public static void assertEitherEquals(String expectedOne, String expectedTwo, String actual)
  {
    if (!expectedOne.equals(actual))
    {
      if (!expectedTwo.equals(actual))
      {
        Assert.assertEquals(expectedOne + ":" + expectedTwo, actual + ":" + actual);
      }
    }
  }

  public static void assertPathEquals(String expected, String actual)
  {
    if (!expected.equals(actual))
    {
      String macExpected = expected.replace("\\", "/");
      if (!macExpected.equals(actual))
      {
        Assert.assertEquals(expected, actual);
      }
    }
  }
  
}
