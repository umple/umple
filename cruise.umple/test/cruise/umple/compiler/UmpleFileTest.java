/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.util.SampleFileWriter;

/**
 * Tests for CommonFileTest
 * <p>
 * <a href="http://cruise.site.uottawa.ca">CRuiSE lab, University of Ottawa</a>
 * <p>
 * Modification History: none.
 *
 * @author Dusan Brestovansky
 */
public class UmpleFileTest {

  
  @Before
  public void setUp()
  {
    SampleFileWriter.createFile("aha.txt","class Teacher {}");
    SampleFileWriter.createFile("aha2.txt","class Student {}");
  }
  
  @After
  public void tearDown()
  {
    SampleFileWriter.destroy("aha.txt");
    SampleFileWriter.destroy("aha2.txt");
  }

  @Test
  public void constructorFileOnlyMakeSureThePathIsProperlyResolved()

  {
    File f = new File("aha.txt");
    String fullName = f.getAbsolutePath();
    UmpleFile file = new UmpleFile(fullName);
    Assert.assertEquals(f.getAbsoluteFile().getParentFile().getAbsolutePath(), file.getPath());
  }

  @Test
  public void constructorFileOnly()
  {
    UmpleFile file = new UmpleFile("aha.txt");
    Assert.assertEquals("aha.txt", file.getFileName());
  }

  @Test
  public void constructorWithPathAndFilenameSeparate()
  {
    File ahaFile = new File("aha.txt");
    String path = ahaFile.getAbsoluteFile().getParent();

    UmpleFile file = new UmpleFile(path,"aha.txt");
    Assert.assertEquals("aha.txt", file.getFileName());
  }   

  @Test
  public void constructorWithRelativeButComplexPath()
  {
    String path = SampleFileWriter.rationalize("test/data/Election");
    UmpleFile file = new UmpleFile(path,"ElectionSystem.ump");
    Assert.assertEquals("ElectionSystem.ump", file.getFileName());
  }   

  @Test
  public void getSimpleFileName_manyExtensions()
  {
    UmpleFile file = new UmpleFile("blah.moreBlah.txt");
    Assert.assertEquals("blah.moreBlah", file.getSimpleFileName());
  }   
  
  @Test
  public void getSimpleFileName_noExtension()
  {
    UmpleFile file = new UmpleFile("blah2");
    Assert.assertEquals("blah2", file.getSimpleFileName());
  }     
  
  
  @Test
  public void getSimpleFileName_hasExtension()
  {
    UmpleFile file = new UmpleFile("blah.txt");
    Assert.assertEquals("blah", file.getSimpleFileName());
  }     

  @Test
  public void AddLinkedFiles() {
   UmpleFile file = new UmpleFile("blah.txt");
   file.addLinkedFiles("test1.ump");
   Assert.assertEquals("\nuse test1.ump;\n", file.getLinkedFiles());
  }  
   
}
