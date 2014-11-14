package cruise.umplificator.examples;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleModel;
import cruise.umplificator.FileHelper;
import cruise.umplificator.core.Umplificator;
import cruise.umplificator.core.Umplificator.RefactoringLevel;

public class UmpleExamplesTest {
	
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
		
		// Compare both models
		assertTrue(areModelsEqual(umplifiedModel,expectedModel));
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
		
		// Compare both models, generally
		assertTrue(areModelsEqual(umplifiedModel,expectedModel));
	}
	
	
	@Test
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
	
	
	// Helper Functions
	public boolean areModelsEqual(UmpleModel actualModel, UmpleModel expectedModel)
	{
		boolean areModelsEqual = true;
		// 1. Compare Classes
		if (actualModel.numberOfUmpleClasses() != expectedModel.numberOfUmpleClasses())
		{
			areModelsEqual = false;	
		}

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
