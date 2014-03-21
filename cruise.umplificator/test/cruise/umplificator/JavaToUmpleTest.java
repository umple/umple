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

public class JavaToUmpleTest {
	
	String pathToRoot;
	Umplificator umplificator;
	List<String> filesToDelete = new ArrayList<String>();


	@Before
	public void setUp() throws Exception {
		umplificator = new Umplificator();
		pathToRoot = "test/cruise/umplificator/";
	}

	@After
	public void cleanModel() throws Exception {
		umplificator.setOutputModel(null);
	}

	@Test
	public void JavaToUmple_class_and_depends_001(){
		String fileName = "001_JavaToUmple_class_and_depends";
		File javaFile = new File(pathToRoot+fileName+"_java.txt"); //INPUT
		File umpleFile = new File(pathToRoot+fileName+"_umple.ump"); //OUTPUT
		// Umplify file. Process must succeed!
		assertTrue(umplificator.umplifyElement(javaFile));
		// Get the output content
		assertOuputAndFile(umpleFile);
		// Clean files 
		filesToDelete.add(fileName);
	}
	
	@Test
	public void JavaToUmple_class_and_namespace_002(){
		String fileName = "002_JavaToUmple_class_and_namespace";
		File javaFile = new File(pathToRoot+fileName+"_java.txt"); //INPUT
		File umpleFile = new File(pathToRoot+fileName+"_umple.ump"); //OUTPUT
		// Umplify file. Process must succeed!
		assertTrue(umplificator.umplifyElement(javaFile));
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
