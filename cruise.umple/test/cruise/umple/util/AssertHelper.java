/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license
 
 */

package cruise.umple.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;

import org.junit.Assert;

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
  
  public static void assertEqualsSafe(String expected, String actual)
  {
	  BufferedReader expectedReader = null;
	  BufferedReader actualReader = null;
	    
	    try
	    {
	      expectedReader = new BufferedReader(new StringReader(expected));
	      actualReader = new BufferedReader(new StringReader(actual));

	      String expectedLine = null;
	      String actualLine = null;
	      
	      int line = 0;
	      do 
	      {
	        actualLine = actualReader.readLine();
	        // HACK: To deal with line number comments (start with // [java] or # [ruby])
	        while (actualLine != null && actualLine.matches("(//|#) line.*"))
	        { //Ignore the line, go to next
	          actualLine = actualReader.readLine();
	        }
	        expectedLine = expectedReader.readLine();
	        
	        line++;
	        
	        // HACK: To deal with umple version issues
	        if (expectedLine != null && expectedLine.indexOf("This code was generated using the UMPLE") == -1)
	        {
	          Assert.assertEquals("Failed at:" + line,expectedLine,actualLine);  
	        }
	      } 
	      while (expectedLine != null && actualLine != null);
	      if (expectedReader != null)
	      {
	    	  expectedReader.close();
	      }
	      if (actualReader != null)
	      {
	    	  actualReader.close();
	      }
	    }
	    catch (Exception e)
	    {
	      Assert.fail(e.getMessage());
	    }
  }
  
}
