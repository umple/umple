package cruise.umple.builder;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.util.SampleFileWriter;

public class BuilderTest {

  public static class TestAntTask extends Task {

    @Override
    public void execute() throws BuildException {
      super.execute();

      SampleFileWriter.createFile("foo-bar.txt", "");
    }
  }
  
  ByteArrayOutputStream stream;
  
  @Before
  public void setUp()
  {
    stream = new ByteArrayOutputStream();
    
    { 
      String buildfileContent = "<project name=\"blah\" default=\"mydefault\" basedir=\".\">" +
        "<target name=\"mydefault\">" +
        "<touch file=\"deleteme.txt\"/>" +
        "</target>" +
        "</project>";
    
      String simpleJavaContent = "public class MeToo {}";
      String complexJavaContent = "package Aha; public class MeThree {}";
    
    
      SampleFileWriter.createFile("mybuild.xml", buildfileContent);
      SampleFileWriter.createFile("MyApp/MeToo.java", simpleJavaContent);
      SampleFileWriter.createFile("MyApp/Aha/MeThree.java", complexJavaContent);
    }
    
    {
      String buildfileContent = "<project name=\"blah\" basedir=\".\">" +
              "<target name=\"mytarget\">" +
            "<taskdef name=\"foo\" classname=\"cruise.umple.builder.BuilderTest$TestAntTask\" " + 
                "classpath=\"../dist/umple.jar\" />" +
            "<foo />" + 
              "</target>" +
              "</project>";
      SampleFileWriter.createFile("reqLib.xml", buildfileContent);
    }
  }
  
  @After
  public void tearDown()
  {
    SampleFileWriter.destroy("mybuild.xml");
    SampleFileWriter.destroy("deleteme.txt");
    SampleFileWriter.destroy("MyApp");
    SampleFileWriter.destroy("reqLib.xml");
    SampleFileWriter.destroy("foo-bar.txt");
  }


/* Temporary commenting out of everything
   @Ignore   @Test 
  public void compile()
  {
    Builder builder = new Builder();
    builder.compile("MyApp","myproject.jar","myproject","1.6");
    Assert.assertEquals(true,(new File("MyApp/MeToo.class")).exists());
    Assert.assertEquals(true,(new File("MyApp/myproject.jar")).exists());
  }
  
 
   @Ignore   @Test 
      public void loadWithPackage() throws ClassNotFoundException
   {
     Builder builder = new Builder();
     builder.compile("MyApp","myproject.jar","myproject","1.6");
     builder.load("MyApp","myproject.jar");
   
     Class<?> myClass = Class.forName("Aha.MeThree");
     Assert.assertNotNull(myClass);
   }
   
    
   
   @Ignore   @Test 
   public void compileTwiceInARow()
   {
     Builder builder = new Builder();
     builder.compile("MyApp","myproject.jar","myproject","1.6");
     builder.compile("MyApp","myproject.jar","myproject","1.6");
     Assert.assertEquals(true,(new File("MyApp/MeToo.class")).exists());
     Assert.assertEquals(true,(new File("MyApp/myproject.jar")).exists());
   }  
   
   @Ignore   @Test 
   public void compileReturnsUrlToJar()
   {
     Builder builder = new Builder();
   
     URL url = builder.compile("blah","blah.jar","doesnotmatter","1.6");
     Assert.assertNull(url);
     
     url = builder.compile("MyApp","myproject2.jar","myproject2","1.6");
     Assert.assertNotNull(url);
   }  
   
   
   @Ignore   @Test 
   public void load() throws MalformedURLException, ClassNotFoundException
   {
     Builder builder = new Builder();
     builder.compile("MyApp","myproject.jar","myproject","1.6");
     builder.load("MyApp","myproject.jar");
   
     Class<?> myClass = Class.forName("MeToo");
     Assert.assertNotNull(myClass);
   }    

*/   
   
  @Test 
  public void executeSimpleAntScript()
  {
    Builder builder = new Builder();
    assertTrue(builder.runAnt("mybuild.xml", "mydefault"));
    SampleFileWriter.assertExists("deleteme.txt");
  }
   
  @Test
  public void executeAntScriptWithExternalLib() {
    Builder builder = new Builder();
    assertTrue("Failed to run ant on 'reqLib.xml' -- try to run `packageJars` and rerun if this fails", 
        builder.runAnt("reqLib.xml", "mytarget"));
    
    assertTrue("Created file does not exist", (new File("foo-bar.txt")).exists());   
  }

  
}
