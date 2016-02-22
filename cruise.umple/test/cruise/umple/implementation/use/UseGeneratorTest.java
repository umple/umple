package cruise.umple.implementation.use;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class UseGeneratorTest extends TemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "USE";
    languagePath = "use";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/OneToManyTest.use");
    SampleFileWriter.destroy(pathToInput + "/useAssociations.use.use");
  }

  @Test @Ignore
  public void OneToMany()
  {
    language = "USE";
    assertUmpleTemplateFor("OneToManyTest.ump","use/OneToManyTest.use.txt");
    Assert.assertEquals(true, (new File(pathToInput + "/OneToManyTest.use")).exists());
  }
}