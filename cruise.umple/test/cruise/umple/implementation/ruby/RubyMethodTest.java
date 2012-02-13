package cruise.umple.implementation.ruby;

import org.junit.*;

import cruise.umple.implementation.*;
import cruise.umple.util.SampleFileWriter;

public class RubyMethodTest extends TemplateTest
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
		SampleFileWriter.destroy(pathToInput + "/ruby/Foo.java");
		SampleFileWriter.destroy(pathToInput + "/ruby/foo.rb");
	}
	
	@Test
	public void basicMethod()
	{
		assertUmpleTemplateFor("ruby/RubyBasicMethod.ump", "ruby/RubyBasicMethod.ruby.txt", "Foo");
	}
	
	@Test
	public void complexMethod()
	{
		assertUmpleTemplateFor("ruby/RubyComplexMethod.ump", "ruby/RubyComplexMethod.ruby.txt", "Foo");
	}
}
