package cruise.umple.implementation.ruby;

import org.junit.*;

import cruise.umple.implementation.*;
import cruise.umple.util.SampleFileWriter;

public class RubyClassTemplateTest extends ClassTemplateTest
{
  
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Ruby";
    languagePath = "ruby";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/ruby/Mentor.rb");
  }
  
  
  @Test
  public void Ruby()
  {
    language = null;
    assertUmpleTemplateFor("ruby/ClassTemplateTest_Ruby.ump","ruby/ClassTemplateTest_Ruby.ruby.txt","Mentor");
  }
  
  @Test
  public void Generated()
  {
    assertUmpleTemplateFor("ruby/ClassTemplateTest_Generated.ump","ruby/ClassTemplateTest_Generated.ruby.txt","Mentor");
    
  }
  
  @Test
  public void ImportAssociations()
  {
    language = null;
    assertUmpleTemplateFor("ruby/ClassTemplateTest_Import.ump","ruby/ClassTemplateTest_Import.ruby.txt","Mentor");
    assertUmpleTemplateFor("ruby/ClassTemplateTest_Import.ump","ruby/ClassTemplateTest_Import2.ruby.txt","Student");
    assertUmpleTemplateFor("ruby/ClassTemplateTest_Import.ump","ruby/ClassTemplateTest_Import3.ruby.txt","Course");
  }  
  
}
