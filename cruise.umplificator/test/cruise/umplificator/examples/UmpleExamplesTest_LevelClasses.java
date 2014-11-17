package cruise.umplificator.examples;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.compiler.UmpleClass;
import cruise.umple.compiler.UmpleFile;
import cruise.umple.compiler.UmpleModel;
import cruise.umplificator.FileHelper;
import cruise.umplificator.core.Umplificator;
import cruise.umplificator.core.Umplificator.RefactoringLevel;

public class UmpleExamplesTest_LevelClasses {
	
	String pathToRoot;
	Umplificator umplificator;
	List<String> filesToDelete = new ArrayList<String>();


	@Before
	public void setUp() throws Exception {
		umplificator = new Umplificator();
		// Avoid generating files 
		umplificator.setTestMode(true);
		umplificator.setCurrentLevel(RefactoringLevel.CLASS);
		pathToRoot = "test/cruise/umplificator/examples/";
	}

	@After
	public void cleanModel() throws Exception {
		umplificator.setOutputModel(null);
	}
	
	@Test
	public void UmpleExamples(){
		List<File> inputUmpleFiles = FileHelper.getListOfFilesFromPath(pathToRoot, new ArrayList<File>());

		for (File inputUmpFile : inputUmpleFiles){

			if (inputUmpFile.isFile() && inputUmpFile.getName().endsWith("ump")) { 

				UmpleFile inputUmpleFile = new UmpleFile(inputUmpFile);
				// Umplify all the files in folder
				List<File> inputJavaFiles = FileHelper.getListOfFilesFromPath(pathToRoot+ File.separator + inputUmpleFile.getSimpleFileName(), new ArrayList<File>());
				System.out.println("Input program: " +inputUmpleFile.getSimpleFileName());
				// Umplify files. Process must succeed!
				assertTrue(umplificator.umplify(inputJavaFiles));

				// This is the actual model, the one umplified 
				UmpleModel umplifiedModel = umplificator.getOutputModel();
				UmpleModel expectedModel = new UmpleModel(inputUmpleFile);
				expectedModel.run();

				// Compare both models
				assertTrue(areModelsEqual(umplifiedModel,expectedModel));
			}
		}
	}
	
	// Helper Functions
	public boolean areModelsEqual(UmpleModel actualModel, UmpleModel expectedModel)
	{
		boolean areModelsEqual = true;
		// 1. Compare Classes
		// Taking into account  external classes
		int numberOfExternalClasses = 0;
		for (UmpleClass uClass : expectedModel.getUmpleClasses()){
			if ("external".equals(uClass.getModifier())){numberOfExternalClasses++; }
		}
		if (actualModel.numberOfUmpleClasses() != expectedModel.numberOfUmpleClasses()
		  && (actualModel.numberOfUmpleClasses() + numberOfExternalClasses) != expectedModel.numberOfUmpleClasses() )
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
