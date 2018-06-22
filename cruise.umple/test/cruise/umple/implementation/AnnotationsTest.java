package cruise.umple.implementation;

import org.junit.*;

public class AnnotationsTest extends TemplateTest {
	
	@Test
	public void Annotations1()
	{
		assertUmpleTemplateFor("Annotations.ump", languagePath + "/Annotations_X."+ languagePath +".txt", "X");
	}
}
