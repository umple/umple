package cruise.umplificator;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.commons.io.FileUtils;

import cruise.umple.util.SampleFileWriter;
import cruise.umplificator.core.Umplificator;
import cruise.umplificator.core.Umplificator.RefactoringLevel;

public class JavaToUmpleTest {
	
	String pathToRoot;
	Umplificator umplificator;
	List<String> filesToDelete = new ArrayList<String>();
	List<File> filesToUmplify = new ArrayList<File>();

	@Before
	public void setUp() throws Exception {
		umplificator = new Umplificator();
		umplificator.setTestMode(false);
		umplificator.setOutputFolder("");
		pathToRoot = "test/cruise/umplificator/transformationTestFiles/";
	}

	@After
	public void cleanModel() throws Exception {
		umplificator.setOutputModel(null);
	}

	@Test
	public void JavaToUmple_class_and_depends_001(){
		String fileName = "001_JavaToUmple_class_and_depends";
		File javaFile = new File(pathToRoot+fileName+"_java.java"); //INPUT
		File umpleFile = new File(pathToRoot+fileName+"_umple.ump"); //OUTPUT
		// Umplify file. Process must succeed!
		filesToUmplify.add(javaFile);
		assertTrue(umplificator.umplify(filesToUmplify));
		// Get the output content
		assertOuputAndFile(umpleFile);
		// Clean files 
		filesToDelete.add(fileName);
	}
	
	@Test
	public void JavaToUmple_class_and_namespace_002(){
		String fileName = "002_JavaToUmple_class_and_namespace";
		File javaFile = new File(pathToRoot+fileName+"_java.java"); //INPUT
		File umpleFile = new File(pathToRoot+fileName+"_umple.ump"); //OUTPUT
		// Umplify file. Process must succeed!
		filesToUmplify.add(javaFile);
		assertTrue(umplificator.umplify(filesToUmplify));
		// Get the output content
		assertOuputAndFile(umpleFile);
		// Clean files 
		filesToDelete.add(fileName);
	}
	
	@Test
	public void JavaToUmple_VariablesToAttributes_003(){
		String fileName = "003_JavaToUmple_VariablesToAttributes";
		File javaFile = new File(pathToRoot+fileName+"_java.java"); //INPUT
		File umpleFile = new File(pathToRoot+fileName+"_umple.ump"); //OUTPUT
		// Umplify file. Process must succeed!
		filesToUmplify.add(javaFile);
		assertTrue(umplificator.umplify(filesToUmplify));
		// Get the output content
		assertOuputAndFile(umpleFile);
		// Clean files 
		filesToDelete.add(fileName);
	}
	
	@Test
	public void JavaToUmple_Level0(){
		String fileName = "Test";
		File javaFile = new File(pathToRoot+fileName+".java"); //INPUT
		File umpleFile = new File(pathToRoot+fileName+"_Level0.ump"); //OUTPUT
		// Umplify file. Process must succeed!
		umplificator.setCurrentLevel(RefactoringLevel.CLASS);
		filesToUmplify.add(javaFile);
		assertTrue(umplificator.umplify(filesToUmplify));
		// Get the output content
		assertOuputAndFile(umpleFile);
		// Clean files 
		filesToDelete.add(fileName);
	}
	
	@Test
	public void JavaToUmple_Level0_Interfaces(){
		String fileName = "RegisterCapable";
		File javaFile = new File(pathToRoot+fileName+".java"); //INPUT
		File umpleFile = new File(pathToRoot+fileName+"_Level0.ump"); //OUTPUT
		// Umplify file. Process must succeed!
		umplificator.setCurrentLevel(RefactoringLevel.CLASS);
		filesToUmplify.add(javaFile);
		assertTrue(umplificator.umplify(filesToUmplify));
		// Get the output content
		assertOuputAndFile(umpleFile);
		// Clean files 
		filesToDelete.add(fileName);
	}
	
	@Test
	public void JavaToUmple_Level1(){
		String fileName = "Test";
		File javaFile = new File(pathToRoot+fileName+".java"); //INPUT
		File umpleFile = new File(pathToRoot+fileName+"_Level1.ump"); //OUTPUT
		// Umplify file. Process must succeed!
		umplificator.setCurrentLevel(RefactoringLevel.ATTRIBUTES);
		filesToUmplify.add(javaFile);
		assertTrue(umplificator.umplify(filesToUmplify));
		// Get the output content
		assertOuputAndFile(umpleFile);
		// Clean files 
		filesToDelete.add(fileName);
	}
	
	@Test
	public void JavaToUmple_Level2(){
		String fileName = "Test";
		File javaFile = new File(pathToRoot+fileName+".java"); //INPUT
		File umpleFile = new File(pathToRoot+fileName+"_Level2.ump"); //OUTPUT
		// Umplify file. Process must succeed!
		umplificator.setCurrentLevel(RefactoringLevel.ASSOCIATIONS);
		filesToUmplify.add(javaFile);
		assertTrue(umplificator.umplify(filesToUmplify));
		// Get the output content
		assertOuputAndFile(umpleFile);
		// Clean files 
		filesToDelete.add(fileName);
	}
	

	@After
	public void tearDown() throws Exception {
		for (String file: filesToDelete){
			SampleFileWriter.destroy(pathToRoot + file + "_java.ump");
		}
	}
	
	// Helper Functions
	public void assertOuputAndFile(File expectedContentFile)
	{
		try {
			String inputFileContent = FileUtils.readFileToString(expectedContentFile);
			String outputModel  = umplificator.getOutputModel().getCode();
			assertEquals(inputFileContent, outputModel);
		} catch (IOException e) {
			fail();
		}
	}
	

	
}
