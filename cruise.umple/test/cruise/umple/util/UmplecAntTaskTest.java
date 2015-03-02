package cruise.umple.util;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cruise.umple.builder.Builder;


public class UmplecAntTaskTest {

  private final static String TEST_TASKDEF_CONTENT = "<project name=\"TestTaskDefFile\" default=\"test\" basedir=\".\">" +
      "<target name=\"test\">" +
      "<taskdef name=\"foo\" classname=\"cruise.umple.util.UmplecAntTask\" " + 
                "classpath=\"../dist/umple.jar\" />" +
      "<touch file=\"deleteme.txt\"/>" +
      "</target>" +
      "</project>";
  
  private final static String TEST_TASKDEF_FILE = "test.taskdef.xml";
  
  
  private final static String UMPLEC_TASKDEF_CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
      "<project default=\"test\" name=\"Umple\" basedir=\".\">" +
      "<target name=\"test\">" +
      "<taskdef name=\"umplec\" classname=\"cruise.umple.util.UmplecAntTask\" " + 
                "classpath=\"../dist/umple.jar\" />" +
      "<umplec src=\"SimpleUmple.ump\"/>" +
      "</target>" +
      "</project>";
  
  private final static String UMPLEC_TASKDEF_FILE = "test.simpleumple.xml";
  
  private final static String SIMPLE_UMPLE_FILE = "SimpleUmple.ump";
  private final static String SIMPLE_UMPLE_CONTENT = "namespace cruise.umple.util;\n" + 
    "class SimpleClass {\n" + 
      "depend cruise.umple.UmpleRunMain;\n" + 
      
      "String name;\n" + 
    "}\n";
  
  private final static String SIMPLE_UMPLE_FILE2 = "SimpleUmple2.ump";
  private final static String SIMPLE_UMPLE_CONTENT2 = "generate Java;\n" + 
  "namespace cruise.umple.util;\n" + 
    "class SimpleClass {\n" + 
      "depend cruise.umple.UmpleRunMain;\n" + 
      
      "String name2;\n" + 
    "}\n";
  
  private final static String UMPLEC_DEBUG_FILE = "test.simpleumple.xml";
  
  private final static String UMPLEC_LINKED_CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
      "<project default=\"test\" name=\"Umple\" basedir=\".\">" +
      "<taskdef name=\"umplec\" classname=\"cruise.umple.util.UmplecAntTask\" " + 
        "classpath=\"../dist/umple.jar\" />" +
      "<target name=\"test\">" +
      "<umplec src=\"SimpleUmple.ump\">" +
        "<linkedFile src=\"SimpleUmple2.ump\"/>" +
      "</umplec>" +
      "</target>" +
      "</project>";
  
  private final static String UMPLEC_LINKED_FILE = "test.linkedfiles.xml";
  
  private final static String UMPLEC_GENERATE_CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
      "<project default=\"test\" name=\"Umple\" basedir=\".\">" +
      "<taskdef name=\"umplec\" classname=\"cruise.umple.util.UmplecAntTask\" " + 
        "classpath=\"../dist/umple.jar\" />" +
      "<target name=\"test\">" +
      "<umplec src=\"SimpleUmple.ump\" generate=\"Cpp\"/>" +
      "</target>" +
      "</project>";
  
  private final static String UMPLEC_GENERATE_FILE = "test.generate.xml";
  
  private final static String UMPLEC_OVERRIDE_CONTENT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
      "<project default=\"test\" name=\"Umple\" basedir=\".\">" +
      "<taskdef name=\"umplec\" classname=\"cruise.umple.util.UmplecAntTask\" " + 
        "classpath=\"../dist/umple.jar\" />" +
      "<target name=\"test\">" +
      "<umplec src=\"SimpleUmple2.ump\" generate=\"Cpp\" override=\"on\"/>" +
      "</target>" +
      "</project>";
  
  private final static String UMPLEC_OVERRIDE_FILE = "test.override.xml";
  
  /**
   * Setup for Ant tests
   */
  @BeforeClass
  public static void setup() {
    SampleFileWriter.createFile(TEST_TASKDEF_FILE, TEST_TASKDEF_CONTENT);

    SampleFileWriter.createFile(SIMPLE_UMPLE_FILE, SIMPLE_UMPLE_CONTENT);
    SampleFileWriter.createFile(SIMPLE_UMPLE_FILE2, SIMPLE_UMPLE_CONTENT2);
    
    SampleFileWriter.createFile(UMPLEC_TASKDEF_FILE, UMPLEC_TASKDEF_CONTENT);
    SampleFileWriter.createFile(UMPLEC_LINKED_FILE, UMPLEC_LINKED_CONTENT);
    SampleFileWriter.createFile(UMPLEC_GENERATE_FILE, UMPLEC_GENERATE_CONTENT);
    SampleFileWriter.createFile(UMPLEC_OVERRIDE_FILE, UMPLEC_OVERRIDE_CONTENT);
  }
  
  @AfterClass
  public static void teardown() {
    SampleFileWriter.destroy(TEST_TASKDEF_FILE);
    
    SampleFileWriter.destroy(SIMPLE_UMPLE_FILE);
    SampleFileWriter.destroy(SIMPLE_UMPLE_FILE2);
    SampleFileWriter.destroy(UMPLEC_TASKDEF_FILE);
    SampleFileWriter.destroy(UMPLEC_LINKED_FILE);
    SampleFileWriter.destroy(UMPLEC_GENERATE_FILE);
    SampleFileWriter.destroy(UMPLEC_OVERRIDE_FILE);
  }
  
  
  
  @Test
  public void testAntTaskIsAvailable() {
    try {
      Builder b = new Builder();
      assertTrue(b.runAnt(TEST_TASKDEF_FILE, "test"));
      SampleFileWriter.assertFileExists("deleteme.txt");
      
    } finally {
      SampleFileWriter.destroy("deleteme.txt");
    }
  }
  
  @Test
  public void testAntTaskUmplec() {
    try {
      Builder b = new Builder();
      assertTrue(b.runAnt(UMPLEC_TASKDEF_FILE, "test"));
      SampleFileWriter.assertFileExists("cruise/umple/util/SimpleClass.java");
      
    } finally {
      SampleFileWriter.destroy("cruise/umple/util/SimpleClass.java");
    }
  }
  
  @Test 
  public void testAntTaskUmplecDebug() {
    try {
      Builder b = new Builder();
      assertTrue(b.runAnt(UMPLEC_DEBUG_FILE, "test"));
      SampleFileWriter.assertFileExists("cruise/umple/util/SimpleClass.java");
      
    } finally {
      SampleFileWriter.destroy("cruise/umple/util/SimpleClass.java");
    }
  }
  
  @Test 
  public void testAntUmplecLinkedFile() {
    try {
      Builder b = new Builder();
      assertTrue(b.runAnt(UMPLEC_LINKED_FILE, "test"));
      SampleFileWriter.assertFileExists("cruise/umple/util/SimpleClass.java");
    } finally {
      SampleFileWriter.destroy("cruise/umple/util/SimpleClass.java");
    }
  }
  
  @Test
  public void testAntUmplecGenerate() {
    try {
      Builder b = new Builder();
      assertTrue(b.runAnt(UMPLEC_GENERATE_FILE, "test"));
      SampleFileWriter.assertFileExists("SimpleUmple_Main.cpp");
      SampleFileWriter.assertFileExists("SimpleUmple_Model.h");
      SampleFileWriter.assertFileExists("cruise/umple/util/SimpleClass.h");
      SampleFileWriter.assertFileExists("cruise/umple/util/SimpleClass.cpp");
    } finally {
      SampleFileWriter.destroy("SimpleUmple_Main.cpp");
      SampleFileWriter.destroy("SimpleUmple_Model.h");
      SampleFileWriter.destroy("cruise/");
    }
  }
  
  @Test
  public void testAntUmplecOverride() {
    // This is the same test as the generate one, but instead the file has `generate Java;` in it and we try to generate
    // Cpp code. 
    try {
      Builder b = new Builder();
      assertTrue(b.runAnt(UMPLEC_OVERRIDE_FILE, "test"));
      SampleFileWriter.assertFileExists("SimpleUmple2_Main.cpp");
      SampleFileWriter.assertFileExists("SimpleUmple2_Model.h");
      SampleFileWriter.assertFileExists("cruise/umple/util/SimpleClass.h");
      SampleFileWriter.assertFileExists("cruise/umple/util/SimpleClass.cpp");
    } finally {
      SampleFileWriter.destroy("SimpleUmple2_Main.cpp");
      SampleFileWriter.destroy("SimpleUmple2_Model.h");
      SampleFileWriter.destroy("cruise/");
    }
  }
  
}
