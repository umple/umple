package cruise.umple;

import static org.junit.Assert.*;

import java.io.File;

import joptsimple.OptionSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UmpleConsoleConfigTest {

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }
  
  private static OptionSet set(String... args) {
    return UmpleConsoleMain.optParse(args);
  }

  @Test
  public void testGetVersion() {
    UmpleConsoleConfig cfg = new UmpleConsoleConfig(set("-v"));
    
    assertTrue("Version flag was not triggered by '-v'", cfg.getVersion());
  }

  @Test
  public void testGetHelp() {
    UmpleConsoleConfig cfg = new UmpleConsoleConfig(set("--help"));
    
    assertTrue("Help flag was not triggered by '--help'", cfg.getHelp());
  }

  @Test
  public void testGetGenerate() {
    UmpleConsoleConfig cfg = new UmpleConsoleConfig(set("-g", "Java", "test.ump"));
    
    assertEquals("Generate flag was not triggered or value is not Java", 
        "Java", cfg.getGenerate().get());
  }

  @Test
  public void testGetOverride() {
    UmpleConsoleConfig cfg = new UmpleConsoleConfig(set("--override", "test.ump"));
    
    assertTrue("Override flag was not triggered", cfg.getOverride());
  }

  @Test
  public void testGetPath() {
    UmpleConsoleConfig cfg = new UmpleConsoleConfig(set("--path", "output/", "test.ump"));
    
    assertEquals("Path flag was not triggered or value is not output/", 
        "output/", cfg.getPath().get());
  }

  @Test
  public void testGetCompile() {
    UmpleConsoleConfig cfg = new UmpleConsoleConfig(set("--compile", "-", "test.ump"));
    
    assertEquals("Compile flag was not triggered or value is not -", 
        "-", cfg.getCompile().get());
  }

  @Test
  public void testGetImportFile() {
    UmpleConsoleConfig cfg = new UmpleConsoleConfig(set("--import", "test.xmi"));
    assertEquals("Import flag was not honoured.", "test.xmi", cfg.getImportFile().get());
  }

  @Test
  public void testGetSuboptions() {
    UmpleConsoleConfig cfg = new UmpleConsoleConfig(set("test.ump", "-s", "AAA"));
    assertEquals("Failed to get single suboption.", "AAA", cfg.getSuboptions().get(0));
    
    UmpleConsoleConfig cfg2 = new UmpleConsoleConfig(set("test.ump", "-s", "AAA", "-s", "BBB"));
    assertEquals("Failed to get multiple suboptions. [0]", "AAA", cfg2.getSuboptions().get(0));
    assertEquals("Failed to get multiple suboptions. [1]", "BBB", cfg2.getSuboptions().get(1));
  }

  @Test
  public void testGetUmpleFile() {
    UmpleConsoleConfig cfg = new UmpleConsoleConfig(set("test.ump"));
    assertEquals("Failed to get umple file.", "test.ump", cfg.getUmpleFile());
  }

  @Test
  public void testGetLinkedFilesAndAsFile() {
    UmpleConsoleConfig cfg = new UmpleConsoleConfig(set("test.ump", "1.cmd", "2.cmd"));
    assertEquals("Failed to get umple file.", "test.ump", cfg.getUmpleFile());
    assertEquals("Failed to get linked files. [0]", "1.cmd", cfg.getLinkedFile(0));
    assertEquals("Failed to get linked files. [1]", "2.cmd", cfg.getLinkedFile(1));
    
    assertEquals("Failed to get linked files (as java.io.File). [0]", 
        new File("1.cmd"), cfg.getLinkedFilesAsFile().get(0));
    assertEquals("Failed to get linked files (as java.io.File). [1]", 
        new File("2.cmd"), cfg.getLinkedFilesAsFile().get(1));
  }
}
