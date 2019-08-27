package cruise.umple.implementation;

import org.junit.*;

public class NameSpaceTest extends TemplateTest {
	
	@Test
	public void nameSpaceDefault()
	{
		assertUmpleTemplateFor("nameSpaceDefaultTest1.ump", languagePath + "/nameSpaceDefaultTest1_A."+ languagePath +".txt", "A");
		assertUmpleTemplateFor("nameSpaceDefaultTest1.ump", languagePath + "/nameSpaceDefaultTest1_B."+ languagePath +".txt", "B");
		assertUmpleTemplateFor("nameSpaceDefaultTest1.ump", languagePath + "/nameSpaceDefaultTest1_C."+ languagePath +".txt", "C");
		assertUmpleTemplateFor("nameSpaceDefaultTest1.ump", languagePath + "/nameSpaceDefaultTest1_I."+ languagePath +".txt", "I");

		assertUmpleTemplateFor("nameSpaceDefaultTest2.ump", languagePath + "/nameSpaceDefaultTest2_X."+ languagePath +".txt", "X");
		assertUmpleTemplateFor("nameSpaceDefaultTest2.ump", languagePath + "/nameSpaceDefaultTest2_Y."+ languagePath +".txt", "Y");
		assertUmpleTemplateFor("nameSpaceDefaultTest2.ump", languagePath + "/nameSpaceDefaultTest2_I."+ languagePath +".txt", "I");
		assertUmpleTemplateFor("nameSpaceDefaultTest2.ump", languagePath + "/nameSpaceDefaultTest2_J."+ languagePath +".txt", "J");
	}
	
	@Test
	public void nameSpaceRedefined()
	{
		assertUmpleTemplateFor("nameSpaceRedefinedTest1.ump", languagePath + "/nameSpaceRedefinedTest1_A."+ languagePath +".txt", "A");
		assertUmpleTemplateFor("nameSpaceRedefinedTest1.ump", languagePath + "/nameSpaceRedefinedTest1_B."+ languagePath +".txt", "B");
		assertUmpleTemplateFor("nameSpaceRedefinedTest1.ump", languagePath + "/nameSpaceRedefinedTest1_I."+ languagePath +".txt", "I");

		assertUmpleTemplateFor("nameSpaceRedefinedTest2.ump", languagePath + "/nameSpaceRedefinedTest2_X."+ languagePath +".txt", "X");
		assertUmpleTemplateFor("nameSpaceRedefinedTest2.ump", languagePath + "/nameSpaceRedefinedTest2_Y."+ languagePath +".txt", "Y");
		assertUmpleTemplateFor("nameSpaceRedefinedTest2.ump", languagePath + "/nameSpaceRedefinedTest2_I."+ languagePath +".txt", "I");
		assertUmpleTemplateFor("nameSpaceRedefinedTest2.ump", languagePath + "/nameSpaceRedefinedTest2_J."+ languagePath +".txt", "J");
	}

}
