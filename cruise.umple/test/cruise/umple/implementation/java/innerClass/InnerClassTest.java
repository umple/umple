package cruise.umple.implementation.java.innerClass;

import org.junit.*;
import cruise.umple.implementation.TemplateTest;

public class InnerClassTest extends TemplateTest {
	
	@Test
	public void TestInnerStaticClass()
	{
		assertUmpleTemplateFor("/java/innerClass/innerStatic.ump", languagePath + "/innerClass/innerStatic.java.txt", "OuterClass");
	}

	@Test
	public void TestInnerNonStaticClass()
	{
		assertUmpleTemplateFor("/java/innerClass/innerNonStatic.ump", languagePath + "/innerClass/InnerNotStatic.java.txt", "OuterClass");
	}

	public void TestInnerStaticAndNonStaticClass()
	{
		assertUmpleTemplateFor("/java/innerClass/innerClasses.ump", languagePath + "/innerClass/innerClasses.java.txt", "OuterClass");
	}
}



