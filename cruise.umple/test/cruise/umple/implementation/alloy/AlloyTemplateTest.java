package cruise.umple.implementation.alloy;

import java.io.File;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

@SuppressWarnings("deprecation")
public class AlloyTemplateTest extends TemplateTest{
	  @Before
	  public void setUp()
	  {
	    super.setUp();
	    language = "Alloy";
	    languagePath = "alloy";
	  }
	  
	  @After
	  public void tearDown()
	  {
	    super.tearDown();
	    SampleFileWriter.destroy(pathToInput + "/alloy/Alloy_AssociationOneToOne.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/Alloy_AssociationOneToMany.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/Alloy_Associations.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/AlloySophisticatedAssociations.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/AlloyAssociation.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/AlloyAssociations.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/UmpleClass.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/AssociationWithNumericBounds.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/AlloyReflexiveRelation.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/AlloySymmetricReflexive.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/FiniteSat.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/isARelationship.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/singleton.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/abstractSingleton.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/Alloy_Unidirectional.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/AlloyExample1.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/AlloyShapes.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/AlloyGenHierarchy.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/AlloyRealEstateSystem.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/ExampleFile.als");
	    SampleFileWriter.destroy(pathToInput + "/alloy/BankingSystem.als");
	  }
	  	  
	  @Test //@Ignore
	  public void BankingSystem()
	  {
		assertUmpleTemplateFor("alloy/BankingSystem.ump","alloy/BankingSystem.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/BankingSystem.als")).exists());
	  }
	  
	  @Test //@Ignore
	  public void Shapes()
	  {
		assertUmpleTemplateFor("alloy/AlloyShapes.ump","alloy/AlloyShapes.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/AlloyShapes.als")).exists());
	  }
	  
	  @Test //@Ignore
	  public void RealEstateSystem()
	  {
		assertUmpleTemplateFor("alloy/AlloyRealEstateSystem.ump","alloy/AlloyRealEstateSystem.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/AlloyRealEstateSystem.als")).exists());
	  }
	  
	  @Test //@Ignore
	  public void Example1()
	  {
		assertUmpleTemplateFor("alloy/AlloyExample1.ump","alloy/AlloyExample1.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/AlloyExample1.als")).exists());
	  }
	  
	  @Test //@Ignore
	  public void AlloyGenHierarchy()
	  {
		assertUmpleTemplateFor("alloy/AlloyGenHierarchy.ump","alloy/AlloyGenHierarchy.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/AlloyGenHierarchy.als")).exists());
	  }

	  @Test //@Ignore
	  public void AlloyAssociations()
	  {
		assertUmpleTemplateFor("alloy/AlloyAssociations.ump","alloy/AlloyAssociations.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/AlloyAssociations.als")).exists());
	  }
	  
	  @Test //@Ignore
	  public void abstractSingleton()
	  { 
		assertUmpleTemplateFor("alloy/abstractSingleton.ump","alloy/abstractSingleton.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/abstractSingleton.als")).exists());
	  }
	  
	  @Test //@Ignore
	  public void singleton()
	  {
		assertUmpleTemplateFor("alloy/singleton.ump","alloy/singleton.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/singleton.als")).exists());
	  }
	  
	  @Test //@Ignore
	  public void isARelationship()
	  {
		assertUmpleTemplateFor("alloy/isARelationship.ump","alloy/isARelationship.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/isARelationship.als")).exists());
	  }
	  
	  @Test //@Ignore
	  public void AlloySophisticatedAssociations()
	  {
		assertUmpleTemplateFor("alloy/AlloySophisticatedAssociations.ump","alloy/AlloySophisticatedAssociations.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/AlloySophisticatedAssociations.als")).exists());
	  }
	  
	  @Test //@Ignore
	  public void oneToOneAssociation()
	  {
		assertUmpleTemplateFor("alloy/Alloy_AssociationOneToOne.ump","alloy/AlloyAssociationOneToOne.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/Alloy_AssociationOneToOne.als")).exists());
	  } 
	  
	  @Test //@Ignore
	  public void oneToManyAssociation()
	  {
		assertUmpleTemplateFor("alloy/Alloy_AssociationOneToMany.ump","alloy/AlloyAssociationOneToMany.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/Alloy_AssociationOneToMany.als")).exists());
	  }
	  
	  @Test //@Ignore
	  public void unidirectional()
	  {
		assertUmpleTemplateFor("alloy/Alloy_Unidirectional.ump","alloy/AlloyUnidirectional.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/Alloy_Unidirectional.als")).exists());
	  }
	  
	  @Test //@Ignore
	  public void Association()
	  {
		assertUmpleTemplateFor("alloy/AlloyAssociation.ump","alloy/AlloyAssociation.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/AlloyAssociation.als")).exists());
	  }
	  
	  @Test //@Ignore
	  public void UmpleClass()
	  {
		assertUmpleTemplateFor("alloy/UmpleClass.ump","alloy/UmpleClass.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/UmpleClass.als")).exists());
	  }
	  
	  @Test //@Ignore
	  public void FiniteSat()
	  {
		assertUmpleTemplateFor("alloy/FiniteSat.ump","alloy/FiniteSat.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/FiniteSat.als")).exists());
	  }
	  
	  @Test //@Ignore
	  public void AssociationWithNumericBounds()
	  {
		assertUmpleTemplateFor("alloy/AssociationWithNumericBounds.ump","alloy/AssociationWithNumericBounds.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/AssociationWithNumericBounds.als")).exists());
	  }
	  
	  @Test //@Ignore
	  public void AlloyReflexiveRelation()
	  {
		assertUmpleTemplateFor("alloy/AlloyReflexiveRelation.ump","alloy/AlloyReflexiveRelation.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/AlloyReflexiveRelation.als")).exists());
	  }
	  @Test //@Ignore
	  public void AlloySymmetricReflexive()
	  { 
		assertUmpleTemplateFor("alloy/AlloySymmetricReflexive.ump","alloy/AlloySymmetricReflexive.alloy.txt");
		Assert.assertEquals(true, (new File(pathToInput + "/alloy/AlloySymmetricReflexive.als")).exists()); 
	  }
	  @Test @Ignore
	  public void temp(){}
}
