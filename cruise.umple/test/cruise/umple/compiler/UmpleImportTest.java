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
    
    private static String getAbsFile(final String name) {
        return pathToInput + "/" + name;
    }

    private static String loadScxmlFile(final String name) throws Exception {
        assertTrue((new File(name)).exists());

        ScxmlImportHandler handler = new ScxmlImportHandler();
        UmpleImportModel umple = handler.readDataFromXML(name);
        return umple.generateUmple();
    }

    private static String loadECoreFile(final String name) throws Exception {
        assertTrue((new File(name)).exists());

        EcoreImportHandler handler = new EcoreImportHandler();
        UmpleImportModel umple = handler.readDataFromXML(name);
        return umple.generateUmple();
    }

    private static void assertImportFile(final UmpleImportType type, 
            final String expectedPath, 
            final String importFile) throws Exception {
        final String realImportFile = getAbsFile(importFile);
        String content;
        if (type == UmpleImportType.ECORE) {
            content = loadECoreFile(realImportFile);
        } else if (type == UmpleImportType.SCXML) {
            content = loadScxmlFile(realImportFile);
        } else {
            throw new IllegalArgumentException("Unknown UmpleImportType parameter = " + type);
        }

        final File expectedFile = new File(getAbsFile(expectedPath));
        assertTrue(expectedFile.exists());
        SampleFileWriter.assertFileContent(expectedFile, content);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void EcoreClassParsingTest() throws Exception {
        assertImportFile(UmpleImportType.ECORE, 
            "ECoreImport_ClassWithNamespace.ump", 
            "ECoreImport_ClassWithNamespace.ecore");
    }

    @Test
    public void EcoreInterfaceParsingTest() throws Exception {
        assertImportFile(UmpleImportType.ECORE,
            "ECoreImport_InterfaceWithNamespace.ump", 
            "ECoreImport_InterfaceWithNamespace.ecore");
    }

    @Test
    public void EcoreClassAttributesParsingTest() throws Exception {

        assertImportFile(UmpleImportType.ECORE,
            "ECoreImport_ClassAttributes.ump", 
            "ECoreImport_ClassAttributes.ecore");
    }

    @Test
    public void EcoreClassAssociationParsingTest() throws Exception {

        assertImportFile(UmpleImportType.ECORE,
            "ECoreImport_Association.ump", 
            "ECoreImport_Association.ecore");
    }

    @Test
    public void EcoreLargeScaleACGParsingTest() throws Exception {

        assertImportFile(UmpleImportType.ECORE,
            "ECoreImport_largeScale_ACG.ump", 
            "ECoreImport_largeScale_ACG.ecore");
    }

    @Test
    public void EcoreLargeScaleACMEParsingTest() throws Exception {

        assertImportFile(UmpleImportType.ECORE,
            "ECoreImport_largeScale_ACME.ump",
            "ECoreImport_largeScale_ACME.ecore");
    }

    @Test
    public void ScxmlEmptyStateMachineTest() throws Exception {
        assertImportFile(UmpleImportType.SCXML,
            "ScxmlImport_empty.ump",
            "ScxmlImport_empty.scxml.txt");
    }

    @Test
    public void ScxmlOneStateTest() throws Exception {
        assertImportFile(UmpleImportType.SCXML,
            "ScxmlImport_one_state.ump",
            "ScxmlImport_one_state.scxml.txt");
    }

    @Test
    public void ScxmlMultipleStatesTest() throws Exception {
        assertImportFile(UmpleImportType.SCXML,
            "ScxmlImport_multiple_states.ump",
            "ScxmlImport_multiple_states.scxml.txt");
    }

    @Test
    public void ScxmlOneNestedStateTest() throws Exception {
        assertImportFile(UmpleImportType.SCXML,
            "ScxmlImport_one_nested_state.ump",
            "ScxmlImport_one_nested_state.scxml.txt");
    }

    @Test
    public void ScxmlMultipleNestedStatesTest() throws Exception {
        assertImportFile(UmpleImportType.SCXML,
            "ScxmlImport_multiple_nested_states.ump",
            "ScxmlImport_multiple_nested_states.scxml.txt");
    }

    @Test
    public void ScxmlTransitionTest() throws Exception {
        assertImportFile(UmpleImportType.SCXML,
            "ScxmlImport_transition.ump",
            "ScxmlImport_transition.scxml.txt");
    }

    @Test
    public void ScxmlTransitionWithGuardTest() throws Exception {
        assertImportFile(UmpleImportType.SCXML,
            "ScxmlImport_transition_with_guard.ump",
            "ScxmlImport_transition_with_guard.scxml.txt");
    }
    
    @Test
    public void ScxmlOnEntryEmptyTest() throws Exception {
        assertImportFile(UmpleImportType.SCXML,
            "ScxmlImport_onentry_empty.ump",
            "ScxmlImport_onentry_empty.scxml.txt");
    }
    
    @Test
    public void ScxmlOnEntryWithActionTest() throws Exception {
        assertImportFile(UmpleImportType.SCXML,
            "ScxmlImport_onentry_with_action.ump",
            "ScxmlImport_onentry_with_action.scxml.txt"); 
    }
    
    @Test
    public void ScxmlOnEntryWithMultilineActionTest() throws Exception {
        assertImportFile(UmpleImportType.SCXML,
            "ScxmlImport_onentry_with_multiline_action.ump",
            "ScxmlImport_onentry_with_multiline_action.scxml.txt");
    }
    
    @Test
    public void ScxmlOnEntryAndOnExitTest() throws Exception {
        assertImportFile(UmpleImportType.SCXML,
            "ScxmlImport_onentry_and_onexit.ump",
            "ScxmlImport_onentry_and_onexit.scxml.txt");
    }
    
    @Test 
    public void ScxmlTransitionActionTest() throws Exception {
        assertImportFile(UmpleImportType.SCXML,
            "ScxmlImport_transition_action.ump",
            "ScxmlImport_transition_action.scxml.txt"); 
    }
    
    @Test 
    public void ScxmlInitialStateTest() throws Exception {
        assertImportFile(UmpleImportType.SCXML,
            "ScxmlImport_initial_state.ump",
            "ScxmlImport_initial_state.scxml.txt"); 
    }
    
    @Test 
    public void ScxmlInitialNestedStateTest() throws Exception {
        assertImportFile(UmpleImportType.SCXML,
            "ScxmlImport_initial_nested_state.ump",
            "ScxmlImport_initial_nested_state.scxml.txt"); 
    }

}
