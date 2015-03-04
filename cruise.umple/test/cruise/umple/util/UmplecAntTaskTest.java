package cruise.umple.util;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.builder.Builder;

public class UmplecAntTaskTest {

  @Test
  public void test() {
    // no-op
  }

  // private final static String TEST_TASKDEF_CONTENT = "<project name=\"TestTaskDefFile\" default=\"test\" basedir=\"%s\">" +
  //     "<target name=\"test\">" +
  //     "<taskdef name=\"foo\" classname=\"cruise.umple.util.UmplecAntTask\" " +
  //               "classpath=\"../../dist/umple.jar\" />" +
  //     "<touch file=\"deleteme.txt\"/>" +
  //     "</target>" +
  //     "</project>";

  // private final static String TEST_TASKDEF_FILE = "test.taskdef.xml";

  // private final static String UMPLEC_TASKDEF_CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
  //     "<project default=\"test\" name=\"Umple\" basedir=\"%s\">" +
  //     "<target name=\"test\">" +
  //     "<taskdef name=\"umplec\" classname=\"cruise.umple.util.UmplecAntTask\" " +
  //               "classpath=\"../../dist/umple.jar\" />" +
  //     "<umplec src=\"SimpleUmple.ump\"/>" +
  //     "</target>" +
  //     "</project>";

  // private final static String UMPLEC_TASKDEF_FILE = "test.simpleumple.xml";

  // private final static String SIMPLE_UMPLE_FILE = "SimpleUmple.ump";
  // private final static String SIMPLE_UMPLE_CONTENT = "namespace cruise.umple.util;\n" +
  //   "class SimpleClass {\n" +
  //     "depend cruise.umple.UmpleRunMain;\n" +

  //     "String name;\n" +
  //   "}\n";

  // private final static String SIMPLE_UMPLE_FILE2 = "SimpleUmple2.ump";
  // private final static String SIMPLE_UMPLE_CONTENT2 = "generate Java;\n" +
  // "namespace cruise.umple.util;\n" +
  //   "class SimpleClass {\n" +
  //     "String name2;\n" +
  //   "}\n";

  // private final static String SIMPLE_UMPLE_FILE3 = "SimpleUmple3.ump";
  // private final static String SIMPLE_UMPLE_CONTENT3 = "generate Java;\n" + 
  // "namespace cruise.umple.util;\n" + 
  //   "class SimpleClass {\n" + 
  //     "String name3;\n" + 
  //   "}\n";
  
  // private final static String UMPLEC_LINKED_LONG_CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
  //     "<project default=\"test\" name=\"Umple\" basedir=\"%s\">" +
  //     "<taskdef name=\"umplec\" classname=\"cruise.umple.util.UmplecAntTask\" " +
  //       "classpath=\"../../dist/umple.jar\" />" +
  //     "<target name=\"test\">" +
  //     "<umplec src=\"SimpleUmple.ump\">" +
  //       "<linkedFile src=\"SimpleUmple2.ump\"/>" +
  //       "<linkedFile src=\"SimpleUmple3.ump\"/>" +
  //     "</umplec>" +
  //     "</target>" +
  //     "</project>";
  // private final static String UMPLEC_LINKED_LONG_FILE = "test.linkedfile.long.xml";

  // private final static String UMPLEC_LINKED_ATTR_CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
  //     "<project default=\"test\" name=\"Umple\" basedir=\"%s\">" +
  //     "<taskdef name=\"umplec\" classname=\"cruise.umple.util.UmplecAntTask\" " + 
  //       "classpath=\"../../dist/umple.jar\" />" +
  //     "<target name=\"test\">" +
  //     "<umplec src=\"SimpleUmple.ump\" linkedFile=\"SimpleUmple2.ump\"/>" +
  //     "</target>" +
  //     "</project>";
  // private final static String UMPLEC_LINKED_ATTR_FILE = "test.linkedfile.attr.xml";

  // private final static String UMPLEC_GENERATE_CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
  //     "<project default=\"test\" name=\"Umple\" basedir=\"%s\">" +
  //     "<taskdef name=\"umplec\" classname=\"cruise.umple.util.UmplecAntTask\" " +
  //       "classpath=\"../../dist/umple.jar\" />" +
  //     "<target name=\"test\">" +
  //     "<umplec src=\"SimpleUmple.ump\" generate=\"Cpp\"/>" +
  //     "</target>" +
  //     "</project>";

  // private final static String UMPLEC_GENERATE_FILE = "test.generate.xml";
  // private final static String UMPLEC_OVERRIDE_CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
  //     "<project default=\"test\" name=\"Umple\" basedir=\"%s\">" +
  //     "<taskdef name=\"umplec\" classname=\"cruise.umple.util.UmplecAntTask\" " +
  //       "classpath=\"../../dist/umple.jar\" />" +
  //     "<target name=\"test\">" +
  //     "<umplec src=\"SimpleUmple2.ump\" generate=\"Cpp\" override=\"on\"/>" +
  //     "</target>" +
  //     "</project>";

  // private final static String UMPLEC_OVERRIDE_FILE = "test.override.xml";

  // private String TEST_DIR;
  
  // private void assertFileExists(String path) {
	 //  SampleFileWriter.assertFileExists(TEST_DIR + path);
  // }
  
  // private void createFile(String path, String content) {
	 //  SampleFileWriter.createFile(TEST_DIR + path, 
		// 	  String.format(content, SampleFileWriter.rationalize(".") + TEST_DIR));
  // }
  
  // private boolean runAnt(final String buildFile, final String target) {
	 //  Builder b = new Builder();
	 //  return b.runAnt(TEST_DIR + buildFile, target);
  // }

  // /**
  //  * Setup for Ant tests
  //  */
  // @Before
  // public void setup() {
  //   try {
  //     Path p = Files.createTempDirectory(Paths.get("."), "TestOutput");
  //     TEST_DIR = SampleFileWriter.rationalize(p.toString() + '/');
  //   } catch (IOException e) {
  //     throw new IllegalStateException(e);
  //   }  

  //   createFile(TEST_TASKDEF_FILE, TEST_TASKDEF_CONTENT);

  //   createFile(SIMPLE_UMPLE_FILE, SIMPLE_UMPLE_CONTENT);
  //   createFile(SIMPLE_UMPLE_FILE2, SIMPLE_UMPLE_CONTENT2);
  //   createFile(SIMPLE_UMPLE_FILE3, SIMPLE_UMPLE_CONTENT3);
    
  //   createFile(UMPLEC_TASKDEF_FILE, UMPLEC_TASKDEF_CONTENT);
  //   createFile(UMPLEC_LINKED_LONG_FILE, UMPLEC_LINKED_LONG_CONTENT);
  //   createFile(UMPLEC_LINKED_ATTR_FILE, UMPLEC_LINKED_ATTR_CONTENT);
  //   createFile(UMPLEC_GENERATE_FILE, UMPLEC_GENERATE_CONTENT);
  //   createFile(UMPLEC_OVERRIDE_FILE, UMPLEC_OVERRIDE_CONTENT);
  // }
  
  // @After
  // public void teardown() {
	 //  SampleFileWriter.destroy(TEST_DIR);
  // }

  // @Test
  // public void isTaskAvailable() {
  //   assertTrue(runAnt(TEST_TASKDEF_FILE, "test"));
  //   assertFileExists("deleteme.txt");
  // }

  // @Test
  // public void simpleProcess() {
  //   assertTrue(runAnt(UMPLEC_TASKDEF_FILE, "test"));
  //   assertFileExists("cruise/umple/util/SimpleClass.java");
  // }

  // @Test 
  // public void multiLinkedFiles() {
  //   assertTrue(runAnt(UMPLEC_LINKED_LONG_FILE, "test"));
  //   assertFileExists("cruise/umple/util/SimpleClass.java");
    

  // }

  // @Test
  // public void linkedFileAttr() {
  //   assertTrue(runAnt(UMPLEC_LINKED_ATTR_FILE, "test"));
  //   assertFileExists("cruise/umple/util/SimpleClass.java");
  // }

  // @Test
  // public void generate() {
  //   assertTrue(runAnt(UMPLEC_GENERATE_FILE, "test"));
  //   assertFileExists("SimpleUmple_Main.cpp");
  //   assertFileExists("SimpleUmple_Model.h");
  //   assertFileExists("cruise/umple/util/SimpleClass.h");
  //   assertFileExists("cruise/umple/util/SimpleClass.cpp");
  // }
  
  // @Test
  // public void override() {
  //   // This is the same test as the generate one, but instead the file has `generate Java;` in it and we try to generate
  //   // Cpp code. 
  //   assertTrue(runAnt(UMPLEC_OVERRIDE_FILE, "test"));
  //   assertFileExists("SimpleUmple2_Main.cpp");
  //   assertFileExists("SimpleUmple2_Model.h");
  //   assertFileExists("cruise/umple/util/SimpleClass.h");
  //   assertFileExists("cruise/umple/util/SimpleClass.cpp");
  // }

}
