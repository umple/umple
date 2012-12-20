package cruise.umple.implementation;

import org.junit.*;

public class AssociationSortedWithNameSpace extends TemplateTest {
	
	@Test
	public void AssociationShouldHaveSortMethod1()
	{
		assertUmpleTemplateFor("AssociationSortedWithNameSpace.ump", languagePath + "/AssociationSortedWithNameSpace_Student."+ languagePath +".txt", "Student");
	}
	
	@Test
	public void AssociationShouldHaveSortMethod2()
	{
		assertUmpleTemplateFor("AssociationSortedWithNameSpace.ump", languagePath + "/AssociationSortedWithNameSpace_Mentor."+ languagePath +".txt", "Mentor");
	}

}
