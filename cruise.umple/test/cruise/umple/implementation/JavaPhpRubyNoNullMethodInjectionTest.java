package cruise.umple.implementation;

import org.junit.*;

public class JavaPhpRubyNoNullMethodInjectionTest extends TemplateTest {
	
	@Test
	public void NoNullMethodInjection()
	{
		assertUmpleTemplateFor("JavaPhpRubyNoNullMethodInjection.ump", languagePath + "/JavaPhpRubyNoNullMethodInjection."+ languagePath +".txt", "JavaPhpRubyNoNullMethodInjection");
	}

}
