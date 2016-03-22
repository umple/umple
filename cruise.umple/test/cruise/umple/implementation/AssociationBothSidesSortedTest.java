package cruise.umple.implementation;

import org.junit.*;

public class AssociationBothSidesSortedTest extends TemplateTest {
	
	@Test
	public void AssociationBothSidesSorted1()
	{
		assertUmpleTemplateFor("AssociationBothSidesSorted.ump", languagePath + "/AssociationBothSidesSorted_Mentor."+ languagePath +".txt", "Mentor");
	}
	@Test
	public void AssociationBothSidesSorted2()
	{
		assertUmpleTemplateFor("AssociationBothSidesSorted.ump", languagePath + "/AssociationBothSidesSorted_Student."+ languagePath +".txt", "Student");
	}
}
