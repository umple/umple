/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

import cruise.umple.compiler.UmpleModel;
import cruise.umple.compiler.java.JavaClassGenerator;
import cruise.umple.util.SampleFileWriter;

import java.io.File;
public class DistributedClassTest extends TemplateTest
{
	public void assertObjectFactory(String umpleFile, String codeFile, String codeFileI)
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
  String actualI = null;

    if (model.getGeneratedCode().get("IUmpleObjectFactory") == null)
    {
      Assert.fail("No generated code:" + "IUmpleObjectFactory");
    }
    if (model.getGeneratedCode().get("UmpleObjectFactory") == null)
    {
      Assert.fail("No generated code:" + "UmpleObjectFactory");
    }
    actual = model.getGeneratedCode().get("UmpleObjectFactory");
    actualI= model.getGeneratedCode().get("IUmpleObjectFactory");
  File expected = new File(pathToInput, codeFile);
  File expectedI = new File(pathToInput, codeFileI);
  System.out.println(actual);

      SampleFileWriter.assertFileContent(expected, actual, true);
      SampleFileWriter.assertFileContent(expectedI, actualI, true);

  }	
	
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

	public void assertUmpleProxyFor(String umpleFile, String codeFile, String className,String ProxyName, boolean isFullMatch, boolean ignoreLineComments)
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

	      if (model.getGeneratedCode().get(ProxyName) == null)
	      {
	        Assert.fail("No generated code:" + ProxyName);
	      }

	      actual = model.getGeneratedCode().get(ProxyName);
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
	

  @After
  public void tearDown() {
	/* Nullify mainMainClass. It's a static variable, if we don't do this the state will
	 * affect the next set of JUnit tests that use mainMainClass.
	 */
	
	JavaClassGenerator.mainMainClass = null;
  }	
	
  @Test
  public void TestDistributableDirectivesTest1()
  {
	UmpleModel model = createUmpleSystem(pathToInput , languagePath + "/Class_DistributableRMI_directives1.ump");
	model.generate();
		  
	Assert.assertEquals(true, model.getUmpleClass(0).getIsDistributed());  
	Assert.assertEquals(true, model.getUmpleClass(1).getIsDistributed());
	Assert.assertEquals(true, model.getUmpleClass(2).getIsDistributed());
	Assert.assertEquals(true, model.getUmpleClass(3).getIsDistributed());
  }  	
  @Test
  public void TestDistributableDirectivesTest2()
  {
	UmpleModel model = createUmpleSystem(pathToInput , languagePath + "/Class_DistributableRMI_directives2.ump");
	model.generate();
		  
	Assert.assertEquals(false, model.getUmpleClass(0).getIsDistributed());  
	Assert.assertEquals(false, model.getUmpleClass(1).getIsDistributed());
	Assert.assertEquals(false, model.getUmpleClass(2).getIsDistributed());
	Assert.assertEquals(false, model.getUmpleClass(3).getIsDistributed());
	Assert.assertEquals(false, model.getDistributed());
  } 
  @Test
  public void TestDistributableDirectivesTest3()
  {
	UmpleModel model = createUmpleSystem(pathToInput , languagePath + "/Class_DistributableRMI_directives3.ump");
	model.generate();
		  
	Assert.assertEquals(false, model.getUmpleClass(0).getIsDistributed());  
	Assert.assertEquals(false, model.getUmpleClass(1).getIsDistributed());
	Assert.assertEquals(true, model.getUmpleClass(2).getIsDistributed());
	Assert.assertEquals(false, model.getUmpleClass(3).getIsDistributed());
	Assert.assertEquals(true, model.getDistributed());
  }
  /*
  @Test
  public void ClassProxyPatternTest()
  {
	  assertUmpleTemplateFor("java/Class_ProxyPattern.ump", languagePath + "/Class_ProxyPattern_Microwave."+ languagePath +".txt", "Microwave");
  }
  
    @Test
  public void ClassProxyPatternTest_client()
  {
	  assertUmpleTemplateFor("java/Class_ProxyPattern.ump", languagePath + "/Class_ProxyPattern_Client."+ languagePath +".txt", "Client");
  }
    @Test
  public void ClassProxyPatternTest_clientInterface()
  {
	
	  assertUmpleProxyInterfaceFor("java/Class_ProxyPattern.ump", languagePath + "/Class_ProxyPattern_ClientInterface."+ languagePath +".txt", "Client","IClient",true,true);
  }
    @Test
  public void ClassProxyPatternTest_microwaveInterface()
  {
	  assertUmpleProxyInterfaceFor("java/Class_ProxyPattern.ump", languagePath + "/Class_ProxyPattern_MicrowaceInterface."+ languagePath +".txt", "Microwave","IMicrowave",true,true);
  }
    @Test
  public void ClassProxyPatternTest_proxy()
  {
	  assertUmpleProxyFor("java/Class_ProxyPattern.ump", languagePath + "/Class_ProxyPattern_MicrowaveProxy."+ languagePath +".txt","Microwave", "MicrowaveProxy",true,true);
  }*/
  @Test
  public void TestClassModel()
  {
	  UmpleModel model = createUmpleSystem(pathToInput , languagePath + "/Class_DistributableRMI.ump");
	  model.generate();
	  
	  Assert.assertEquals(true, model.getUmpleClass(0).getIsDistributed());  
	  Assert.assertEquals(true, model.getUmpleClass(0).getIsDistributable());
	 // Assert.assertEquals(false, model.getUmpleClass(0).getHasProxyPattern());
	  
	  Assert.assertEquals("RMI", model.getUmpleClass(0).getDistributeTechnology());
  }
  @Test
  public void TestClassModel2()
  {
	  UmpleModel model2 = createUmpleSystem(pathToInput , languagePath + "/Class_DistributableRMI_WithMethods.ump");
	  model2.generate();
	    
	  Assert.assertEquals(true, model2.getUmpleClass(0).getIsDistributable());
	  Assert.assertEquals(false, model2.getUmpleClass(0).getHasProxyPattern()); 
	  Assert.assertEquals("RMI", model2.getUmpleClass(0).getDistributeTechnology());
  }
  @Test
  public void TestInterfaceModel()
  {
	 UmpleModel modelI = createUmpleSystem(pathToInput , languagePath + "/Interface_DistributableRMI.ump");
	 modelI.generate();
	  
	// Assert.assertEquals(true, modelI.getUmpleInterface(0).getIsDistributed());  
	 Assert.assertEquals("RMI", modelI.getUmpleInterface(0).getDistributeTechnology());
	 Assert.assertEquals(true, modelI.getUmpleInterface(0).getIsDistributable());
  }
  /*
  @Test
  public void InterfaceDependencyTest(){
		assertUmpleTemplateFor("java/Interface_DistributableRMI.ump", languagePath + "/Interface_DistributableRMI."+ languagePath +".txt", "IClient");

  }
  
  @Test
  public void MethodProxyTest(){
		assertUmpleTemplateFor("java/Class_DistributableRMI_WithMethods.ump", languagePath + "/Class_DistributableRMI_WithMethods."+ languagePath +".txt", "Microwave");
  }*/
					    /*
					  @Test
					  public void MethodProxyTest_interface(){
							assertUmpleProxyInterfaceFor("java/Class_DistributableRMI_WithMethods.ump", languagePath + "/Class_DistributableRMI_WithMethods_interface."+ languagePath +".txt", "Microwave","IMicrowave",true,true);
					  } 
					  */ 
  
  /*
  @Test
  public void MethodProxyTest_remoteInterface(){
		assertUmpleProxyInterfaceFor("java/Class_DistributableRMI_WithMethods.ump", languagePath + "/Class_DistributableRMI_WithMethods_remoteInterface."+ languagePath +".txt", "Microwave","IMicrowaveImpl",true,true);
  }  
  @Test
  public void MethodProxyTest_proxy(){
		assertUmpleProxyFor("java/Class_DistributableRMI_WithMethods.ump", languagePath + "/Class_DistributableRMI_WithMethods_proxy."+ languagePath +".txt","Microwave", "MicrowaveProxy",true,true);
  }
  @Test
  public void ClassDependencyTest()
  {
		assertUmpleTemplateFor("java/Class_DistributableRMI.ump", languagePath + "/Class_DistributableRMI."+ languagePath +".txt", "Client");
  }
  
  @Test
  public void ClassDistributedExtention()
  {
	  assertUmpleTemplateFor("java/Class_DistributableRMI2.ump", languagePath + "/Class_DistributableRMI2."+ languagePath +".txt", "Client");
  }
    
  @Test
  public void ClassDistributedExtention_parent()
  {
	  assertUmpleTemplateFor("java/Class_DistributableRMI2.ump", languagePath + "/Class_DistributableRMI2_parent."+ languagePath +".txt", "CC");
  }
    
  @Test
  public void ClassDistributedExtention_parentInterface()
  {
	  assertUmpleProxyInterfaceFor("java/Class_DistributableRMI2.ump", languagePath + "/Class_DistributableRMI2_parentInterface."+ languagePath +".txt", "CC","ICCImpl",true,true);
  }
  @Test
  public void ClassDistributedExtention_remoteInterface()
  {
	  assertUmpleProxyInterfaceFor("java/Class_DistributableRMI2.ump", languagePath + "/Class_DistributableRMI2_remoteInterface."+ languagePath +".txt", "Client","IClientImpl",true,true);
  }
  
  @Test
  public void ClassDistributedExtention2()
  {
		assertUmpleTemplateFor("java/Class_DistributableRMI_WithMethods2.ump", languagePath + "/Class_DistributableRMI_WithMethods2."+ languagePath +".txt", "Microwave");
  }
  @Test
  public void ClassDistributedExtention2_remoteInterface()
  {
		assertUmpleProxyInterfaceFor("java/Class_DistributableRMI_WithMethods2.ump", languagePath + "/Class_DistributableRMI_WithMethods_remoteInterface2."+ languagePath +".txt", "Microwave","IMicrowaveImpl",true,true);
  }
    
  @Test
  public void ClassDistributedExtention2_proxy()
  {
		assertUmpleProxyFor("java/Class_DistributableRMI_WithMethods2.ump", languagePath + "/Class_DistributableRMI_WithMethods_proxy2."+ languagePath +".txt","Microwave", "MicrowaveProxy",true,true);
  }
    
  @Test
  public void ClassDistributedExtention2_parentInterface()
  {
  		assertUmpleProxyInterfaceFor("java/Class_DistributableRMI_WithMethods2.ump", languagePath + "/Class_DistributableRMI_WithMethods_parentInterface2."+ languagePath +".txt", "CC","ICCImpl",true,true);
  }
  
  @Test
  public void ClassDistributedExtention3()
  {
	  assertUmpleTemplateFor("java/Class_DistributableRMI3.ump", languagePath + "/Class_DistributableRMI3."+ languagePath +".txt", "Client");
  }
   
  @Test
  public void ClassDistributedExtention3_parent()
  {
	  assertUmpleTemplateFor("java/Class_DistributableRMI3.ump", languagePath + "/Class_DistributableRMI3_parent."+ languagePath +".txt", "CC");
  }
    
    
  @Test
  public void ClassDistributedExtention3_distributableInterface()
  {
	  assertUmpleProxyInterfaceFor("java/Class_DistributableRMI3.ump", languagePath + "/Class_DistributableRMI3_distributableInterface."+ languagePath +".txt", "Client","ClientI",true,true);
  }
   
  @Test
  public void ClassDistributedExtention3_remoteInterface()
  {
	  assertUmpleProxyInterfaceFor("java/Class_DistributableRMI3.ump", languagePath + "/Class_DistributableRMI3_remoteInterface."+ languagePath +".txt", "Client","IClientImpl",true,true);
  }
    
  @Test
  public void ClassDistributedExtention3_proxy()
  {
	  assertUmpleProxyFor("java/Class_DistributableRMI3.ump", languagePath + "/Class_DistributableRMI3_proxy."+ languagePath +".txt","Client", "ClientProxy",true,true);
  }
  @Test
  public void ClassDistributedExtention4()
  {
	  assertUmpleTemplateFor("java/Class_DistributableRMI4.ump", languagePath + "/Class_DistributableRMI4."+ languagePath +".txt", "Microwave");
  }
  @Test
  public void ClassDistributedExtention4_parent()
  {
	  assertUmpleTemplateFor("java/Class_DistributableRMI4.ump", languagePath + "/Class_DistributableRMI4_parent."+ languagePath +".txt", "CC");
  }
  @Test
  public void ClassDistributedExtention4_parentInterface()
  {
	  assertUmpleProxyInterfaceFor("java/Class_DistributableRMI4.ump", languagePath + "/Class_DistributableRMI4_parentInterface."+ languagePath +".txt", "CC","ICCImpl",true,true);
  }
  @Test
  public void ClassDistributedExtention4_remoteInterface()
  {
	  assertUmpleProxyInterfaceFor("java/Class_DistributableRMI4.ump", languagePath + "/Class_DistributableRMI4_remoteInterface."+ languagePath +".txt", "Microwave","IMicrowaveImpl",true,true);
  }
  @Test
  public void ClassDistributedExtention4_proxy()
  {
	  assertUmpleProxyFor("java/Class_DistributableRMI4.ump", languagePath + "/Class_DistributableRMI4_proxy."+ languagePath +".txt","Microwave", "MicrowaveProxy",true,true);

  }
  @Test
  public void ClassDistributedExtention5()
  {
	  assertUmpleTemplateFor("java/Class_DistributableRMI5.ump", languagePath + "/Class_DistributableRMI5."+ languagePath +".txt", "Microwave");
  }
  
  @Test
  public void ClassDistributedExtention5_parent()
  {
	  assertUmpleTemplateFor("java/Class_DistributableRMI5.ump", languagePath + "/Class_DistributableRMI5_parent."+ languagePath +".txt", "Client");
  }
  @Test
  public void ClassDistributedExtention5_parentInterface()
  {
	  assertUmpleProxyInterfaceFor("java/Class_DistributableRMI5.ump", languagePath + "/Class_DistributableRMI5_parentInterface."+ languagePath +".txt", "Client","ClientI",true,true);
  }

  @Test
  public void ClassDistributedExtention5_remoteInterface()
  {
	  assertUmpleProxyInterfaceFor("java/Class_DistributableRMI5.ump", languagePath + "/Class_DistributableRMI5_remoteInterface."+ languagePath +".txt", "Microwave","IMicrowaveImpl",true,true);
  }
  @Test
  public void ClassDistributedExtention5_proxy()
  {
	  assertUmpleProxyFor("java/Class_DistributableRMI5.ump", languagePath + "/Class_DistributableRMI5_proxy."+ languagePath +".txt","Microwave", "MicrowaveProxy",true,true);

  }
  /*
  @Test
  public void ClassDistributedExtention5_objectFactory()
  {
	  assertObjectFactory("java/Class_DistributableRMI5.ump", languagePath + "/Class_DistributableRMI5_UmpleObjectFactory."+ languagePath +".txt",languagePath + "/Class_DistributableRMI5_IUmpleObjectFactory."+ languagePath +".txt");
  } */
}