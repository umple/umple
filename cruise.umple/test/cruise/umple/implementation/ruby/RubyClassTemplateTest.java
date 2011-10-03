package cruise.umple.implementation.ruby;

import java.io.File;

import org.junit.*;

import cruise.umple.compiler.UmpleModel;
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
    SampleFileWriter.destroy(pathToInput + "/ruby/student.rb");
    SampleFileWriter.destroy(pathToInput + "/ruby/course.rb");
    SampleFileWriter.destroy(pathToInput + "/ruby/mentor.rb");
    SampleFileWriter.destroy(pathToInput + "/sub_mentor_2.rb");
    SampleFileWriter.destroy(pathToInput + "/sub_mentor.rb");
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

  @Test
  public void GeneratePathTest()
  {
	  UmpleModel model = createUmpleSystem(pathToInput ,languagePath + "/ClassTemplateTest_BuildOutputPath.ump");
	  model.generate();

	  String actual = SampleFileWriter.readContent(new File(pathToInput, languagePath + "/ruby_code/student.rb"));
	  System.out.print(actual);
	  
	  String expected = SampleFileWriter.readContent(new File(pathToInput, languagePath + "/ClassTemplateTest_BuildOutputPath.ump.txt"));
	  Assert.assertEquals(expected, actual);
  }
}
