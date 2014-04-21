/*
 
 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.util;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import cruise.umple.util.SampleFileWriter;

public class SampleFileWriterTest {

  
  @After
  public void TearDown()
  {
    (new File("abc.txt")).delete();
  }
  
  @Test(expected=RuntimeException.class)
  public void loadFile_nullFile()
  {
    String actual;
    
    actual = SampleFileWriter.readContent((File)null);
    Assert.assertEquals(null,actual);
  }  
  
  @Test(expected=RuntimeException.class)
  public void loadFile_unknown()
  {
    String actual;
    
    actual = SampleFileWriter.readContent(new File("unknown.txt"));
    Assert.assertEquals(null,actual);
  }

  @Test
  public void loadFile_okay()
  {
    SampleFileWriter.createFile("abc.txt", "aha");
    String actual;
    
    actual = SampleFileWriter.readContent(new File("abc.txt"));
    Assert.assertEquals("aha" + System.getProperty("line.separator"),actual);
  }  

  @Test(expected=Exception.class)
  public void writeFileToDisk_nullString()
  {
    SampleFileWriter.createFile((String)null, "aha");
  }  
  
  
  @Test
  public void writeFileToDisk_okay()
  {
    Assert.assertEquals(false, (new File("abc.txt")).exists());
    SampleFileWriter.createFile("abc.txt", "aha");
    File file = new File("abc.txt");
    Assert.assertEquals(true, file.exists());
    Assert.assertEquals("abc.txt", file.getName());
    String actual;
    actual = SampleFileWriter.readContent(new File("abc.txt"));
    Assert.assertEquals("aha" + System.getProperty("line.separator"),actual);

  }   
  
  
}
