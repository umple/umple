/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license
 
 */

package cruise.umple.util;
import java.io.File;

import junit.framework.Assert;

public class AssertHelper 
{

  public static void assertFileExists(String rawPath)
  {
    String filename = SampleFileWriter.rationalize(rawPath);
    System.out.println("LOOKING FOR:" + filename);
    Assert.assertEquals(true,(new File(filename)).exists());
  }
  
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
