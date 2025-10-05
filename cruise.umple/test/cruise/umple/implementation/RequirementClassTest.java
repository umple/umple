package cruise.umple.implementation;

import org.junit.*;

public class RequirementClassTest extends TemplateTest {
	
	@Test
	public void RequirementFullCheckWithComments()
	{
		assertUmpleTemplateFor("RequirementFullCheckWithComments.ump", languagePath + "/RequirementFullCheckWithComments_X."+ languagePath +".txt", "X");
		assertUmpleTemplateFor("RequirementFullCheckWithComments.ump", languagePath + "/RequirementFullCheckWithComments_Y."+ languagePath +".txt", "Y");
	}

	@Test
	public void RequirementBeforeAttribute()
	{
		assertUmpleTemplateFor("RequirementBeforeAttribute.ump", languagePath + "/RequirementBeforeAttribute."+ languagePath +".txt", "Example");
	}

	@Test
	public void RequirementBeforeClass()
	{
		assertUmpleTemplateFor("RequirementBeforeClass.ump", languagePath + "/RequirementBeforeClass."+ languagePath +".txt", "Example");
	}

	// @Ignore - Currently fails for Java and Python... Could be an issue with the requirements implementation
	@Test @Ignore
	public void RequirementMultipleImplementsReq()
	{
		assertUmpleTemplateFor("RequirementMultipleImplementsReq.ump", languagePath + "/RequirementMultipleImplementsReq."+ languagePath +".txt", "Example");
	}

	@Test
	public void RequirementWithMethod()
	{
		assertUmpleTemplateFor("RequirementWithMethod.ump", languagePath + "/RequirementWithMethod."+ languagePath +".txt", "Example");
	}

}

