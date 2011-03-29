package cruise.umple.implementation.php;

import org.junit.*;

import cruise.umple.implementation.*;
import cruise.umple.util.SampleFileWriter;

public class PhpClassTemplateTest extends ClassTemplateTest
{
  
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Php";
    languagePath = "php";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/php/Mentor.php");
  }
  
  
  @Test
  public void Php()
  {
    language = null;
    assertUmpleTemplateFor("php/ClassTemplateTest_Php.ump","php/ClassTemplateTest_Php.php.txt","Mentor");
  }

  @Test
  public void ExtraCode()
  {
    language = null;
    assertUmpleTemplateFor("php/ClassTemplateTest_ExtraCode.ump","php/ClassTemplateTest_ExtraCode.php.txt","Mentor");
  }
  
}
