package cruise.umple.compiler;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.util.SampleFileWriter;

public class UmpleImportTest {
	private static String pathToInput = SampleFileWriter.rationalize("test/cruise/umple/compiler");
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void EcoreClassParsingTest() throws Exception {

		String expectedText = loadUmpleFile("ECoreImport_ClassWithNamespace.ump");
		String actualText = loadECoreFile("ECoreImport_ClassWithNamespace.ecore");

		assertEquals(expectedText, actualText);
	}

	@Test
	public void EcoreInterfaceParsingTest() throws Exception {
		
		String expectedText = loadUmpleFile("ECoreImport_InterfaceWithNamespace.ump");
		String actualText = loadECoreFile("ECoreImport_InterfaceWithNamespace.ecore");

		assertEquals(expectedText, actualText);
	}
	
	@Test
	public void EcoreClassAttributesParsingTest() throws Exception {
		
		String expectedText = loadUmpleFile("ECoreImport_ClassAttributes.ump");
		String actualText = loadECoreFile("ECoreImport_ClassAttributes.ecore");
        System.out.println(actualText);
		assertEquals(expectedText, actualText);
	}

	private static String loadECoreFile(String name) throws Exception {
		String filename = getFullFilePath(name);
		assertEquals(true, (new File(filename)).exists());

		ECoreImportHandler handler = new ECoreImportHandler();
		UmpleImportModel umple = handler.readDataFromXML(filename);
		return umple.generateUmple();
	}

	private static String loadUmpleFile(String name) throws IOException {

		String filename = getFullFilePath(name);
		StringBuilder builder = new StringBuilder();
		FileReader reader = new FileReader(new File(filename));

		int content;
		while ((content = reader.read()) != -1) {
			builder.append((char) content);
		}
		reader.close();

		return builder.toString();
	}

	private static String getFullFilePath(String name) {
		return pathToInput + "/"+ name;
	}

}
