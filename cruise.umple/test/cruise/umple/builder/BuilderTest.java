package cruise.umple.builder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.util.*;

public class BuilderTest {

  
  ByteArrayOutputStream stream;
  
  @Before
  public void setUp()
  {
    stream = new ByteArrayOutputStream();
    
    String buildfileContent = "<project name=\"blah\" default=\"mydefault\" basedir=\".\">" +
      "<target name=\"mydefault\">" +
      "<copy file=\"mybuild.xml\" tofile=\"deleteme.txt\"/>" +
      "</target>" +
      "</project>";
    
    String simpleJavaContent = "public class MeToo {}";
    String complexJavaContent = "package Aha; public class MeThree {}";
    
    
    SampleFileWriter.createFile("mybuild.xml", buildfileContent);
    SampleFileWriter.createFile("MyApp/MeToo.java", simpleJavaContent);
    SampleFileWriter.createFile("MyApp/Aha/MeThree.java", complexJavaContent);
  }
  
  @After
  public void tearDown()
  {
    SampleFileWriter.destroy("mybuild.xml");
    SampleFileWriter.destroy("deleteme.txt");
    SampleFileWriter.destroy("MyApp");
  }

  @Test
  public void compile()
  {
    Builder builder = new Builder();
    builder.compile("MyApp","myproject.jar","myproject","1.6");
    Assert.assertEquals(true,(new File("MyApp/MeToo.class")).exists());
    Assert.assertEquals(true,(new File("MyApp/myproject.jar")).exists());
  }
  
  
   @Test
   public void loadWithPackage() throws ClassNotFoundException
   {
     Builder builder = new Builder();
     builder.compile("MyApp","myproject.jar","myproject","1.6");
     builder.load("MyApp","myproject.jar");
   
     Class<?> myClass = Class.forName("Aha.MeThree");
     Assert.assertNotNull(myClass);
   }
   
    
   
   @Test
   public void compileTwiceInARow()
   {
     Builder builder = new Builder();
     builder.compile("MyApp","myproject.jar","myproject","1.6");
     builder.compile("MyApp","myproject.jar","myproject","1.6");
     Assert.assertEquals(true,(new File("MyApp/MeToo.class")).exists());
     Assert.assertEquals(true,(new File("MyApp/myproject.jar")).exists());
   }  
   
   @Test
   public void compileReturnsUrlToJar()
   {
     Builder builder = new Builder();
   
     URL url = builder.compile("blah","blah.jar","doesnotmatter","1.6");
     Assert.assertNull(url);
     
     url = builder.compile("MyApp","myproject2.jar","myproject2","1.6");
     Assert.assertNotNull(url);
   }  
   
   
   @Test
   public void load() throws MalformedURLException, ClassNotFoundException
   {
     Builder builder = new Builder();
     builder.compile("MyApp","myproject.jar","myproject","1.6");
     builder.load("MyApp","myproject.jar");
   
     Class<?> myClass = Class.forName("MeToo");
     Assert.assertNotNull(myClass);
   }    
   
   
   @Test
   public void executeSimpleAntScript()
   {
     Builder builder = new Builder();
     builder.runAnt("mybuild.xml");
     Assert.assertEquals(true,(new File("deleteme.txt")).exists());
   }
  
}
