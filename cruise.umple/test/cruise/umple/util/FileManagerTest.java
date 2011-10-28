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

import cruise.umple.util.FileManager;

public class FileManagerTest {

  
  @After
  public void TearDown()
  {
    (new File("abc.txt")).delete();
  }
  
  @Test
  public void loadFile_nullFile()
  {
    String actual;
    
    actual = FileManager.loadFile((File)null);
    Assert.assertEquals(null,actual);

    actual = FileManager.loadFile((String)null);
    Assert.assertEquals(null,actual);
  }  
  
  @Test
  public void loadFile_unknown()
  {
    String actual;
    
    actual = FileManager.loadFile(new File("unknown.txt"));
    Assert.assertEquals(null,actual);

    actual = FileManager.loadFile("unknown.txt");
    Assert.assertEquals(null,actual);
  }

  @Test
  public void loadFile_okay()
  {
    FileManager.writeFileToDisk("abc.txt", "aha");
    String actual;
    actual = FileManager.loadFile("abc.txt");
    Assert.assertEquals("aha",actual);

    actual = FileManager.loadFile(new File("abc.txt"));
    Assert.assertEquals("aha",actual);
  }  
  
  @Test(expected=Exception.class)
  public void writeFileToDisk_nullFile()
  {
    FileManager.writeFileToDisk((File)null, "aha");
  }   

  @Test(expected=Exception.class)
  public void writeFileToDisk_nullString()
  {
    FileManager.writeFileToDisk((String)null, "aha");
  }  
  
  
  @Test
  public void writeFileToDisk_okay()
  {
    Assert.assertEquals(false, (new File("abc.txt")).exists());
    File file = FileManager.writeFileToDisk("abc.txt", "aha");
    Assert.assertEquals(true, file.exists());
    Assert.assertEquals("abc.txt", file.getName());
    String actual;
    actual = FileManager.loadFile("abc.txt");
    Assert.assertEquals("aha",actual);

  }   
  
  
}
