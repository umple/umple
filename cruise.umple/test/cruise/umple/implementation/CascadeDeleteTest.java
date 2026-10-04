package cruise.umple.implementation;

import org.junit.*;


public class CascadeDeleteTest extends TemplateTest {
	
	@Test
	public void CascadeDelete()
	{
		assertUmpleTemplateFor("CascadeDelete.ump", languagePath + "/CascadeDeleteB."+ languagePath +".txt", "B");
		assertUmpleTemplateFor("CascadeDelete.ump", languagePath + "/CascadeDeleteC."+ languagePath +".txt", "C");
		assertUmpleTemplateFor("CascadeDelete.ump", languagePath + "/CascadeDeleteD."+ languagePath +".txt", "D");
	}

}
