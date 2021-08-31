package cruise.umple.implementation;

import org.junit.*;

public class RequirementFullCheckWithCommentsTest extends TemplateTest {
	
	@Test
	public void X()
	{
		assertUmpleTemplateFor("RequirementFullCheckWithComments.ump", languagePath + "/RequirementFullCheckWithComments_X."+ languagePath +".txt", "X");
	}

    @Test
	public void Y()
	{
		assertUmpleTemplateFor("RequirementFullCheckWithComments.ump", languagePath + "/RequirementFullCheckWithComments_Y."+ languagePath +".txt", "Y");
	}
}
