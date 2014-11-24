package cruise.umplificator.examples;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.compiler.Attribute;
import cruise.umple.compiler.UmpleClass;
import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleModel;
import cruise.umplificator.FileHelper;
import cruise.umplificator.core.Umplificator;
import cruise.umplificator.core.Umplificator.RefactoringLevel;

public class UmpleExamplesTest_LevelAttributes {
	
	String pathToRoot;
	Umplificator umplificator;
	List<String> filesToDelete = new ArrayList<String>();


	@Before
	public void setUp() throws Exception {
		umplificator = new Umplificator();
		// Avoid generating files 
		umplificator.setTestMode(true);
		umplificator.setCurrentLevel(RefactoringLevel.ATTRIBUTES);
		pathToRoot = "test/cruise/umplificator/examples/";
	}

	@After
	public void cleanModel() throws Exception {
		umplificator.setOutputModel(null);
	}

	@Test
	public void ShapesExample(){
		String folderName = "2DShapes";
		File inputFile = new File(pathToRoot+ File.separator +folderName +".ump");
		UmpleFile inputUmpleFile = new UmpleFile(inputFile);
		// Umplify all the files in folder
		List<File> inputFiles = FileHelper.getListOfFilesFromPath(pathToRoot+ File.separator + folderName, new ArrayList<File>());
			
		// Umplify files. Process must succeed!
		assertTrue(umplificator.umplify(inputFiles));
		
		// This is the actual model, the one umplified 
		UmpleModel umplifiedModel = umplificator.getOutputModel();
		UmpleModel expectedModel = new UmpleModel(inputUmpleFile);
		expectedModel.run();
		
		// Compare both models generally
		assertTrue(areModelsEqual(umplifiedModel,expectedModel));
		// Compare Attributes from each class
		//1. Class Shape2D
		UmpleClass shapeClassA = umplifiedModel.getUmpleClass("Shape2D");
		UmpleClass shapeClassE = expectedModel.getUmpleClass("Shape2D");
		assertEquals(shapeClassA.numberOfAttributes(),shapeClassE.numberOfAttributes());
		//2. Class EllipticalShape
		UmpleClass ellipticalShapeA = umplifiedModel.getUmpleClass("EllipticalShape");
		UmpleClass ellipticalShape = expectedModel.getUmpleClass("EllipticalShape");
		assertEquals(ellipticalShapeA.numberOfAttributes(),ellipticalShape.numberOfAttributes());
		
	}
	
	@Test
	public void AccessControlExample(){
		String folderName = "AccessControl";
		File inputFile = new File(pathToRoot+ File.separator +folderName +".ump");
		UmpleFile inputUmpleFile = new UmpleFile(inputFile);
		// Umplify all the files in folder
		List<File> inputFiles = FileHelper.getListOfFilesFromPath(pathToRoot+ File.separator + folderName, new ArrayList<File>());
			
		// Umplify files. Process must succeed!
		assertTrue(umplificator.umplify(inputFiles));
		
		// This is the actual model, the one umplified 
		UmpleModel umplifiedModel = umplificator.getOutputModel();
		UmpleModel expectedModel = new UmpleModel(inputUmpleFile);
		expectedModel.run();
		
		//1. Class FacilityType
		UmpleClass facilityTypeA = umplifiedModel.getUmpleClass("FacilityType");
		UmpleClass facilityTypeE = expectedModel.getUmpleClass("FacilityType");
		
		Assert.assertEquals(1, facilityTypeA.numberOfAttributes());
		Attribute lazyAttributeA = facilityTypeA.getAttribute("code");
		Attribute lazyAttributeE = facilityTypeE.getAttribute("code");
		
		assertEquals(lazyAttributeA.getIsLazy(),lazyAttributeE.getIsLazy());
		assertEquals(lazyAttributeA.getType(),lazyAttributeE.getType());
		
		// 2. Class User
		UmpleClass userA = umplifiedModel.getUmpleClass("User");
		UmpleClass userE = expectedModel.getUmpleClass("User");
		
		Attribute id = userA.getAttribute("id");
		Attribute firstname = userA.getAttribute("first_name");
		Attribute lastname = userA.getAttribute("last_name");
		Attribute other_details = userA.getAttribute("other_details");
		Attribute password = userA.getAttribute("password");
		
		Assert.assertEquals(userA.numberOfAttributes(), userE.numberOfAttributes());
		Assert.assertEquals("Integer", id.getType());
		Assert.assertEquals("String", firstname.getType());
		Assert.assertEquals("String", lastname.getType());
		Assert.assertEquals("String", other_details.getType());
		Assert.assertEquals("String", password.getType());

		// 3. Facility Class
		UmpleClass facilityA = umplifiedModel.getUmpleClass("Facility");
		UmpleClass facilityE = expectedModel.getUmpleClass("Facility");
		Assert.assertEquals(facilityA.numberOfAttributes(), facilityE.numberOfAttributes());

		Attribute timeAttr = facilityA.getAttribute("t");
		Attribute idAttr = facilityA.getAttribute("id");
		Attribute accessAttr = facilityA.getAttribute("access_count");
		Attribute nameAttr = facilityA.getAttribute("name");
		Attribute descAttr = facilityA.getAttribute("description");
		Attribute otherAttr = facilityA.getAttribute("other_details");
		
		Assert.assertTrue(timeAttr.isIsLazy());
		Assert.assertFalse(idAttr.isIsLazy());
		Assert.assertFalse(accessAttr.isIsLazy());
		Assert.assertFalse(nameAttr.isIsLazy());
		Assert.assertFalse(descAttr.isIsLazy());
		Assert.assertFalse(otherAttr.isIsLazy());
		// Compare both models, generally
		assertTrue(areModelsEqual(umplifiedModel,expectedModel));
	}
	
	
	//@Test
	public void AccessControlExample2(){
		String folderName = "AccessControl2";
		File inputFile = new File(pathToRoot+ File.separator +folderName +".ump");
		UmpleFile inputUmpleFile = new UmpleFile(inputFile);
		// Umplify all the files in folder
		List<File> inputFiles = FileHelper.getListOfFilesFromPath(pathToRoot+ File.separator + folderName, new ArrayList<File>());
			
		// Umplify files. Process must succeed!
		assertTrue(umplificator.umplify(inputFiles));
		
		// This is the actual model, the one umplified 
		UmpleModel umplifiedModel = umplificator.getOutputModel();
		UmpleModel expectedModel = new UmpleModel(inputUmpleFile);
		expectedModel.run();
		
		// Compare both models, generally
		assertTrue(areModelsEqual(umplifiedModel,expectedModel));
	}
	
	//@Test
	public void Accidents(){
		String folderName = "Accidents";
		File inputFile = new File(pathToRoot+ File.separator +folderName +".ump");
		UmpleFile inputUmpleFile = new UmpleFile(inputFile);
		// Umplify all the files in folder
		List<File> inputFiles = FileHelper.getListOfFilesFromPath(pathToRoot+ File.separator + folderName, new ArrayList<File>());
			
		// Umplify files. Process must succeed!
		assertTrue(umplificator.umplify(inputFiles));
		
		// This is the actual model, the one umplified 
		UmpleModel umplifiedModel = umplificator.getOutputModel();
		UmpleModel expectedModel = new UmpleModel(inputUmpleFile);
		expectedModel.run();
		
		// Compare both models, generally
		assertTrue(areModelsEqual(umplifiedModel,expectedModel));
	}
	
	//@Test
	public void Accommodations(){
		String folderName = "Accommodations";
		File inputFile = new File(pathToRoot+ File.separator +folderName +".ump");
		UmpleFile inputUmpleFile = new UmpleFile(inputFile);
		// Umplify all the files in folder
		List<File> inputFiles = FileHelper.getListOfFilesFromPath(pathToRoot+ File.separator + folderName, new ArrayList<File>());
			
		// Umplify files. Process must succeed!
		assertTrue(umplificator.umplify(inputFiles));
		
		// This is the actual model, the one umplified 
		UmpleModel umplifiedModel = umplificator.getOutputModel();
		UmpleModel expectedModel = new UmpleModel(inputUmpleFile);
		expectedModel.run();
		
		// Compare both models, generally
		assertTrue(areModelsEqual(umplifiedModel,expectedModel));
	}
	
	//@Test
	public void AfghanRainDesign(){
		String folderName = "AfghanRainDesign";
		File inputFile = new File(pathToRoot+ File.separator +folderName +".ump");
		UmpleFile inputUmpleFile = new UmpleFile(inputFile);
		// Umplify all the files in folder
		List<File> inputFiles = FileHelper.getListOfFilesFromPath(pathToRoot+ File.separator + folderName, new ArrayList<File>());
			
		// Umplify files. Process must succeed!
		assertTrue(umplificator.umplify(inputFiles));
		
		// This is the actual model, the one umplified 
		UmpleModel umplifiedModel = umplificator.getOutputModel();
		UmpleModel expectedModel = new UmpleModel(inputUmpleFile);
		expectedModel.run();
		
		// Compare both models, generally
		assertTrue(areModelsEqual(umplifiedModel,expectedModel));
	}
	
	//@Test
	public void AgentsCommunication(){
		String folderName = "AgentsCommunication";
		File inputFile = new File(pathToRoot+ File.separator +folderName +".ump");
		UmpleFile inputUmpleFile = new UmpleFile(inputFile);
		// Umplify all the files in folder
		List<File> inputFiles = FileHelper.getListOfFilesFromPath(pathToRoot+ File.separator + folderName, new ArrayList<File>());
			
		// Umplify files. Process must succeed!
		assertTrue(umplificator.umplify(inputFiles));
		
		// This is the actual model, the one umplified 
		UmpleModel umplifiedModel = umplificator.getOutputModel();
		UmpleModel expectedModel = new UmpleModel(inputUmpleFile);
		expectedModel.run();
		
		// Compare both models, generally
		assertTrue(areModelsEqual(umplifiedModel,expectedModel));
	}
	
	//@Test
	public void Airline(){
		String folderName = "Airline";
		File inputFile = new File(pathToRoot+ File.separator +folderName +".ump");
		UmpleFile inputUmpleFile = new UmpleFile(inputFile);
		// Umplify all the files in folder
		List<File> inputFiles = FileHelper.getListOfFilesFromPath(pathToRoot+ File.separator + folderName, new ArrayList<File>());
			
		// Umplify files. Process must succeed!
		assertTrue(umplificator.umplify(inputFiles));
		
		// This is the actual model, the one umplified 
		UmpleModel umplifiedModel = umplificator.getOutputModel();
		UmpleModel expectedModel = new UmpleModel(inputUmpleFile);
		expectedModel.run();
		
		// Compare both models, generally
		assertTrue(areModelsEqual(umplifiedModel,expectedModel));
	}
	
	//@Test
	public void AirlineExample(){
		String folderName = "AirlineExample";
		File inputFile = new File(pathToRoot+ File.separator +folderName +".ump");
		UmpleFile inputUmpleFile = new UmpleFile(inputFile);
		// Umplify all the files in folder
		List<File> inputFiles = FileHelper.getListOfFilesFromPath(pathToRoot+ File.separator + folderName, new ArrayList<File>());
			
		// Umplify files. Process must succeed!
		assertTrue(umplificator.umplify(inputFiles));
		
		// This is the actual model, the one umplified 
		UmpleModel umplifiedModel = umplificator.getOutputModel();
		UmpleModel expectedModel = new UmpleModel(inputUmpleFile);
		expectedModel.run();
		
		// Compare both models, generally
		assertTrue(areModelsEqual(umplifiedModel,expectedModel));
	}
	
	// Helper Functions
	public boolean areModelsEqual(UmpleModel actualModel, UmpleModel expectedModel)
	{
		boolean areModelsEqual = true;
		// 1. Compare Number of classes 
		if (actualModel.numberOfUmpleClasses() != expectedModel.numberOfUmpleClasses())
		{
			areModelsEqual = false;	
		}
		// 1. Compare Classes
		// 1.1 Compare Depends
		// 1.2 Compare namespace
		// 1.3 Compare Attributes
		// 1.3 Compare Associations	
		// 2. Compare Interfaces
		if (actualModel.numberOfUmpleInterfaces() != expectedModel.numberOfUmpleInterfaces())
		{
			areModelsEqual = false;	
		}
		return areModelsEqual;
		
	}
	
	
}
