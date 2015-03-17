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

		assertEquals(expectedText, actualText);
	}
	
	@Test
	public void EcoreClassAssociationParsingTest() throws Exception {
		
		String expectedText = loadUmpleFile("ECoreImport_Association.ump");
		String actualText = loadECoreFile("ECoreImport_Association.ecore");

		assertEquals(expectedText, actualText);
	}
	
	@Test
	public void EcoreLargeScaleACGParsingTest() throws Exception {
		
		String expectedText = loadUmpleFile("ECoreImport_largeScale_ACG.ump");
		String actualText = loadECoreFile("ECoreImport_largeScale_ACG.ecore");

		assertEquals(expectedText, actualText);
	}
	
	@Test
	public void EcoreLargeScaleACMEParsingTest() throws Exception {
		
		String expectedText = loadUmpleFile("ECoreImport_largeScale_ACME.ump");
		String actualText = loadECoreFile("ECoreImport_largeScale_ACME.ecore");

		assertEquals(expectedText, actualText);
	}
	
	@Test
	public void SCXMLEmptyStateMachineTest() throws Exception {
	  String expectedText = loadUmpleFile("SCXMLImport_empty.ump").trim();
	  String actualText = loadSCXMLFile("SCXMLImport_empty.scxml").trim();
	   
	  assertEquals(expectedText, actualText);
	}
	 
	private static String loadSCXMLFile(String name) throws Exception {
	  String filename = getFullFilePath(name);
	  assertEquals(true, (new File(filename)).exists());
	 
	  SCXMLImportHandler handler = new SCXMLImportHandler();
	  UmpleImportModel umple = handler.readDataFromXML(filename);
	  return umple.generateUmple();
  }

	private static String loadECoreFile(String name) throws Exception {
		String filename = getFullFilePath(name);
		assertEquals(true, (new File(filename)).exists());

		EcoreImportHandler handler = new EcoreImportHandler();
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
