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
  public void GeneratePathTest()
  {
	  UmpleModel model = createUmpleSystem(pathToInput ,languagePath + "/ClassTemplateTest_BuildOutputPath.ump");
	  model.generate();

	  String actual = SampleFileWriter.readContent(new File(pathToInput, languagePath + "/ruby_code/student.rb"));
	  System.out.print(actual);
	  
	  SampleFileWriter.assertFileContent(new File(pathToInput, languagePath + "/ClassTemplateTest_BuildOutputPath.ump.txt"), actual);
  }

  // 2025-10: Ruby does not have abstract classes
  @Test @Ignore
  public void AbstractClass()
  {
		assertUmpleTemplateFor("ClassTemplateTest_AbstractClass.ump",languagePath + "/ClassTemplateTest_AbstractClass."+languagePath+".txt","Foo");
  }

  // 2025-10: Ruby does not have abstract classes
  @Test @Ignore
  public void AbstractClassInheritance()
  {
		assertUmpleTemplateFor("ClassTemplateTest_AbstractClassInheritance.ump",languagePath + "/ClassTemplateTest_AbstractClassInheritance."+languagePath+".txt","Teacher");
  }

  // 2025-10: Ruby does not have abstract classes
  @Test @Ignore
  public void AbstractClassAvoidingInstantiation()
  {
		assertUmpleTemplateFor("ClassTemplateTest_AbstractClassAvoidingInstantiation.ump",languagePath + "/ClassTemplateTest_AbstractClassAvoidingInstantiation."+languagePath+".txt","Teacher");
  }

  // 2025-10: Ruby does not have abstract classes
  @Test @Ignore
  public void AbstractClassAvoidingInstantiationMN()
  {
		assertUmpleTemplateFor("ClassTemplateTest_AbstractClassAvoidingInstantiation2.ump",languagePath + "/ClassTemplateTest_AbstractClassAvoidingInstantiation2."+languagePath+".txt","Teacher");
  }
}
