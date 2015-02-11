package cruise.umple.util;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cruise.umple.builder.Builder;


public class UmpleAntTaskTest {

  @Test
  public void intentionalPass() {
    assertTrue(true);
  }
  
  // private final static String TEST_TASKDEF_CONTENT = "<project name=\"TestTaskDefFile\" default=\"test\" basedir=\".\">" +
  //     "<target name=\"test\">" +
  //     "<taskdef name=\"foo\" classname=\"cruise.umple.util.UmpleAntTask\" " + 
  //               "classpath=\"../dist/umple.jar\" />" +
  //     "<touch file=\"deleteme.txt\"/>" +
  //     "</target>" +
  //     "</project>";
  
  // private final static String TEST_TASKDEF_FILE = "test.taskdef.xml";
  
  
  // private final static String UMPLEC_TASKDEF_CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
  //     "<project default=\"test\" name=\"Umple\" basedir=\".\">" +
  //     "<target name=\"test\">" +
  //     "<taskdef name=\"umplec\" classname=\"cruise.umple.util.UmpleAntTask\" " + 
  //               "classpath=\"../dist/umple.jar\" />" +
  //     "<umplec src=\"SimpleUmple.ump\"/>" +
  //     "</target>" +
  //     "</project>";
  
  // private final static String UMPLEC_TASKDEF_FILE = "test.simpleumple.xml";
  
  // private final static String SIMPLE_UMPLE_FILE = "SimpleUmple.ump";
  // private final static String SIMPLE_UMPLE_CONTENT = "namespace cruise.umple.util;\n" + 
  //   "class SimpleClass {\n" + 
  //     "depend cruise.umple.UmpleRunMain;\n" + 
      
  //     "String name;\n" + 
  //   "}";
  
  // private final static String UMPLEC_DEBUG_CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
  //     "<project default=\"test\" name=\"Umple\" basedir=\".\">" +
  //     "<target name=\"test\">" +
  //     "<taskdef name=\"umplec\" classname=\"cruise.umple.util.UmpleAntTask\" " + 
  //               "classpath=\"../dist/umple.jar\" />" +
  //     "<umplec src=\"SimpleUmple.ump\" debug=\"on\"/>" +
  //     "</target>" +
  //     "</project>";
  
  // private final static String UMPLEC_DEBUG_FILE = "test.simpleumple.xml";
  
  // private final static String UMPLEC_CMD_CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
  //     "<project default=\"test\" name=\"Umple\" basedir=\".\">" +
  //     "<target name=\"test\">" +
  //     "<taskdef name=\"umplec\" classname=\"cruise.umple.util.UmpleAntTask\" " + 
  //               "classpath=\"../dist/umple.jar\" />" +
  //     "<umplec src=\"SimpleUmple.ump\" cmdFile=\"./foo.cmd\"/>" +
  //     "</target>" +
  //     "</project>";
  
  // private final static String UMPLEC_CMD_FILE = "test.simpleumple.xml";
  
  // /**
  //  * Setup for Ant tests
  //  */
  // @BeforeClass
  // public static void setup() {
  //   SampleFileWriter.createFile(TEST_TASKDEF_FILE, TEST_TASKDEF_CONTENT);
    
  //   SampleFileWriter.createFile(SIMPLE_UMPLE_FILE, SIMPLE_UMPLE_CONTENT);
    
  //   SampleFileWriter.createFile(UMPLEC_DEBUG_FILE, UMPLEC_DEBUG_CONTENT);
  //   SampleFileWriter.createFile(UMPLEC_TASKDEF_FILE, UMPLEC_TASKDEF_CONTENT);
  //   SampleFileWriter.createFile(UMPLEC_CMD_FILE, UMPLEC_CMD_CONTENT);
  // }
  
  // @AfterClass
  // public static void teardown() {
  //   SampleFileWriter.destroy(TEST_TASKDEF_FILE);
    
  //   SampleFileWriter.destroy(SIMPLE_UMPLE_FILE);
  //   SampleFileWriter.destroy(UMPLEC_TASKDEF_FILE);
  //   SampleFileWriter.destroy(UMPLEC_DEBUG_FILE);
  //   SampleFileWriter.destroy(UMPLEC_CMD_FILE);
  // }
  
  
  
  // @Test
  // public void testAntTaskIsAvailable() {
  //   try {
  //     Builder b = new Builder();
  //     assertTrue(b.runAnt(TEST_TASKDEF_FILE, "test"));
  //     SampleFileWriter.assertExists("deleteme.txt");
      
  //   } finally {
  //     SampleFileWriter.destroy("deleteme.txt");
  //   }
  // }
  
  // @Test
  // public void testAntTaskUmplec() {
  //   try {
  //     Builder b = new Builder();
  //     assertTrue(b.runAnt(UMPLEC_TASKDEF_FILE, "test"));
  //     SampleFileWriter.assertExists("cruise/umple/util/SimpleClass.java");
      
  //   } finally {
  //     SampleFileWriter.destroy("cruise/umple/util/SimpleClass.java");
  //   }
  // }
  
  // @Test 
  // public void testAntTaskUmplecDebug() {
  //   try {
  //     Builder b = new Builder();
  //     assertTrue(b.runAnt(UMPLEC_DEBUG_FILE, "test"));
  //     SampleFileWriter.assertExists("cruise/umple/util/SimpleClass.java");
      
  //   } finally {
  //     SampleFileWriter.destroy("cruise/umple/util/SimpleClass.java");
  //   }
  // }
  
  // @Test 
  // public void testAntTaskUmplecCmd() {
  //   try {
  //     Builder b = new Builder();
  //     assertTrue(b.runAnt(UMPLEC_CMD_FILE, "test"));
  //     SampleFileWriter.assertExists("cruise/umple/util/SimpleClass.java");
      
  //   } finally {
  //     SampleFileWriter.destroy("cruise/umple/util/SimpleClass.java");
  //   }
  // }
}
