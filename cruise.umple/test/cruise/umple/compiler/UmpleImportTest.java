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
	public void ScxmlEmptyStateMachineTest() throws Exception {
	  String expectedText = loadUmpleFile("ScxmlImport_empty.ump").trim();
	  String actualText = loadScxmlFile("ScxmlImport_empty.scxml.txt").trim();
	  assertEquals(expectedText, actualText);
	}

	@Test
  public void ScxmlOneStateTest() throws Exception {
    String expectedText = loadUmpleFile("ScxmlImport_one_state.ump").trim();
    String actualText = loadScxmlFile("ScxmlImport_one_state.scxml.txt").trim();

    assertEquals(expectedText, actualText);
  }

	@Test
  public void ScxmlMultipleStatesTest() throws Exception {
    String expectedText = loadUmpleFile("ScxmlImport_multiple_states.ump").trim();
    String actualText = loadScxmlFile("ScxmlImport_multiple_states.scxml.txt").trim();

    assertEquals(expectedText, actualText);
  }

	@Test
  public void ScxmlOneNestedStateTest() throws Exception {
    String expectedText = loadUmpleFile("ScxmlImport_one_nested_state.ump").trim();
    String actualText = loadScxmlFile("ScxmlImport_one_nested_state.scxml.txt").trim();

    assertEquals(expectedText, actualText);
  }

	@Test
  public void ScxmlMultipleNestedStatesTest() throws Exception {
    String expectedText = loadUmpleFile("ScxmlImport_multiple_nested_states.ump").trim();
    String actualText = loadScxmlFile("ScxmlImport_multiple_nested_states.scxml.txt").trim();

    assertEquals(expectedText, actualText);
  }

	@Test
	public void ScxmlTransitionTest() throws Exception {
	  String expectedText = loadUmpleFile("ScxmlImport_transition.ump").trim();
    String actualText = loadScxmlFile("ScxmlImport_transition.scxml.txt").trim();

    assertEquals(expectedText, actualText);
	}

	@Test
  public void ScxmlTransitionWithGuardTest() throws Exception {
    String expectedText = loadUmpleFile("ScxmlImport_transition_with_guard.ump").trim();
    String actualText = loadScxmlFile("ScxmlImport_transition_with_guard.scxml.txt").trim();

    assertEquals(expectedText, actualText);
  }
	
	@Test
	public void ScxmlOnEntryEmptyTest() throws Exception {
	  String expectedText = loadUmpleFile("ScxmlImport_onentry_empty.ump").trim();
    String actualText = loadScxmlFile("ScxmlImport_onentry_empty.scxml.txt").trim();

    assertEquals(expectedText, actualText);
	}
	
	@Test
	public void ScxmlOnEntryWithActionTest() throws Exception {
	  String expectedText = loadUmpleFile("ScxmlImport_onentry_with_action.ump").trim();
    String actualText = loadScxmlFile("ScxmlImport_onentry_with_action.scxml.txt").trim();

    assertEquals(expectedText, actualText); 
	}
	
	@Test
	public void ScxmlOnEntryWithMultilineActionTest() throws Exception {
	  String expectedText = loadUmpleFile("ScxmlImport_onentry_with_multiline_action.ump").trim();
    String actualText = loadScxmlFile("ScxmlImport_onentry_with_multiline_action.scxml.txt").trim();

    assertEquals(expectedText, actualText);
	}
	
	@Test
	public void ScxmlOnEntryAndOnExitTest() throws Exception {
	  String expectedText = loadUmpleFile("ScxmlImport_onentry_and_onexit.ump").trim();
    String actualText = loadScxmlFile("ScxmlImport_onentry_and_onexit.scxml.txt").trim();

    assertEquals(expectedText, actualText);
	}
	
	@Test 
	public void ScxmlTransitionActionTest() throws Exception {
	  String expectedText = loadUmpleFile("ScxmlImport_transition_action.ump").trim();
    String actualText = loadScxmlFile("ScxmlImport_transition_action.scxml.txt").trim();

    assertEquals(expectedText, actualText); 
	}
	
	@Test 
  public void ScxmlInitialStateTest() throws Exception {
    String expectedText = loadUmpleFile("ScxmlImport_initial_state.ump").trim();
    String actualText = loadScxmlFile("ScxmlImport_initial_state.scxml.txt").trim();

    assertEquals(expectedText, actualText); 
  }
	
	@Test 
  public void ScxmlInitialNestedStateTest() throws Exception {
    String expectedText = loadUmpleFile("ScxmlImport_initial_nested_state.ump").trim();
    String actualText = loadScxmlFile("ScxmlImport_initial_nested_state.scxml.txt").trim();

    assertEquals(expectedText, actualText); 
  }

	private static String loadScxmlFile(String name) throws Exception {
	  String filename = getFullFilePath(name);
	  assertEquals(true, (new File(filename)).exists());

	  ScxmlImportHandler handler = new ScxmlImportHandler();
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
