/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

import cruise.umple.compiler.UmpleModel;
import cruise.umple.util.SampleFileWriter;

import java.io.File;
public class DistributedClassTest extends TemplateTest
{
	public void assertUmpleProxyInterfaceFor(String umpleFile, String codeFile, String className,String interfaceName, boolean isFullMatch, boolean ignoreLineComments)
	  {
	    
	    String checkFile = pathToInput + "/" + umpleFile;
	    if (!(new File(checkFile).exists()))
	    {
	      Assert.fail("Unable to locate umple file: " + checkFile);
	    }

	    checkFile = pathToInput + "/" + codeFile;
	    if (!(new File(pathToInput + "/" + codeFile).exists()))
	    {
	      Assert.fail("Unable to locate code file: " + checkFile);
	    }
	        
	    UmpleModel model = createUmpleSystem(pathToInput, umpleFile);
	    

	    String actual = null;
	    if (className == null)
	    {
	      actual = model.getCode();
	    }
	    else
	    {
	      if (model.getUmpleClass(className) == null && model.getUmpleInterface(className) == null)
	      {
	        Assert.fail("Unknown class / interface:" + className);
	      }

	      if (model.getGeneratedCode().get(interfaceName) == null)
	      {
	        Assert.fail("No generated code:" + interfaceName);
	      }

	      actual = model.getGeneratedCode().get(interfaceName);
	    }

	    File expected = new File(pathToInput, codeFile);
	    System.out.println(actual);


	    if (isFullMatch)
	    {
	      if (ignoreLineComments)
	        SampleFileWriter.assertFileContent(expected, actual, true);
	      else
	        SampleFileWriter.assertFileContent(expected, actual, false);

	    }
	    else
	    {
	      SampleFileWriter.assertPartialFileContent(expected, actual);
	    }

	  }	
   
  @Test
  public void TestClassModel()
  {
	  UmpleModel model = createUmpleSystem(pathToInput , languagePath + "/Class_DistributableRMI.ump");
	  model.generate();
	  
	  Assert.assertEquals(true, model.getUmpleClass(0).getIsDistributed());  
	  Assert.assertEquals(true, model.getUmpleClass(0).getIsDistributable());
	  Assert.assertEquals(true, model.getUmpleClass(0).getHasProxyPattern());
	  
	  Assert.assertEquals("distributableRMI", model.getUmpleClass(0).getDistributeTechnology());
  }
  @Test
  public void TestClassModel2()
  {
	  UmpleModel model2 = createUmpleSystem(pathToInput , languagePath + "/Class_DistributableRMI_WithMethods.ump");
	  model2.generate();
	  
	  Assert.assertEquals(true, model2.getUmpleClass(0).getIsDistributed());  
	  Assert.assertEquals(true, model2.getUmpleClass(0).getIsDistributable());
	  Assert.assertEquals(true, model2.getUmpleClass(0).getHasProxyPattern()); 
	  Assert.assertEquals("distributableRMI", model2.getUmpleClass(0).getDistributeTechnology());
  }
  @Test
  public void TestInterfaceModel()
  {
	 UmpleModel modelI = createUmpleSystem(pathToInput , languagePath + "/Interface_DistributableRMI.ump");
	 modelI.generate();
	  
	 Assert.assertEquals(true, modelI.getUmpleInterface(0).getIsDistributed());  
	 Assert.assertEquals("distributableRMI", modelI.getUmpleInterface(0).getDistributeTechnology());
	 Assert.assertEquals(true, modelI.getUmpleInterface(0).getIsDistributable());
	 //Assert.assertEquals(true, modelI.getUmpleInterface(0).getDepends());
  }
  @Test
  public void ClassDependencyTest()
  {
		assertUmpleTemplateFor("java/Class_DistributableRMI.ump", languagePath + "/Class_DistributableRMI."+ languagePath +".txt", "Client");
  }
  @Test
  public void InterfaceDependencyTest(){
		assertUmpleTemplateFor("java/Interface_DistributableRMI.ump", languagePath + "/Interface_DistributableRMI."+ languagePath +".txt", "IClient");

  }
  @Test
  public void MethodProxyTest(){
		assertUmpleTemplateFor("java/Class_DistributableRMI_WithMethods.ump", languagePath + "/Class_DistributableRMI_WithMethods."+ languagePath +".txt", "Microwave");
		assertUmpleProxyInterfaceFor("java/Class_DistributableRMI_WithMethods.ump", languagePath + "/Class_DistributableRMI_WithMethods_interface."+ languagePath +".txt", "Microwave","IMicrowave",true,true);
		
  }
  @Test
  public void MethodProxyTest2(){
		//assertUmpleTemplateFor("java/Class_DistributableRMI_WithMethods2.ump", languagePath + "/Class_DistributableRMI_WithMethods2."+ languagePath +".txt", "Client");

  }
}