package cruise.umple.implementation;

import org.junit.*;

// THESE ARE IGNORED BECAUSE FOR SOME REASON THE ENTIRE FILE IS DUMPED
// TO STANDARD OUTPUT ... it would be good to unignore and figure out why

public class AssociationSortedWithNameSpace extends TemplateTest {
	
	@Test @Ignore
	public void AssociationShouldHaveSortMethod1()
	{
		assertUmpleTemplateFor("AssociationSortedWithNameSpace.ump", languagePath + "/AssociationSortedWithNameSpace_Student."+ languagePath +".txt", "Student");
	}
	
	@Test @Ignore
	public void AssociationShouldHaveSortMethod2()
	{
		assertUmpleTemplateFor("AssociationSortedWithNameSpace.ump", languagePath + "/AssociationSortedWithNameSpace_Mentor."+ languagePath +".txt", "Mentor");
	}

}
