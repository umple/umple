package cruise.umple.implementation;

import org.junit.*;

public class AssociationSortedSerializableTest extends TemplateTest {
	
	@Test
	public void AssociationSortedSerializableMany()
	{
		assertUmpleTemplateFor("AssociationSortedSerializable.ump", languagePath + "/AssociationSortedSerializable_Academy."+ languagePath +".txt", "Academy");
	}
	
	@Test
	public void AssociationSortedSerializableOne()
	{
		assertUmpleTemplateFor("AssociationSortedSerializable.ump", languagePath + "/AssociationSortedSerializable_Course."+ languagePath +".txt", "Course");
	}
		
	@Test
	public void AssociationSortedSerializableNone1()
	{
		assertUmpleTemplateFor("AssociationSortedSerializable.ump", languagePath + "/AssociationSortedSerializable_Student."+ languagePath +".txt", "Student");
	}
		
	@Test
	public void AssociationSortedSerializableNone2()
	{
		assertUmpleTemplateFor("AssociationSortedSerializable.ump", languagePath + "/AssociationSortedSerializable_Registration."+ languagePath +".txt", "Registration");
	}
}
