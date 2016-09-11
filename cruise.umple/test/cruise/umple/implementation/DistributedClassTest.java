/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

import cruise.umple.compiler.UmpleModel;
import java.io.File;
public class DistributedClassTest extends TemplateTest
{
	
   
  @Test
  public void TestClassModel()
  {
	  UmpleModel model = createUmpleSystem(pathToInput , languagePath + "/Class_DistributableRMI.ump");
	  model.generate();
	  
	  Assert.assertEquals(true, model.getUmpleClass(0).getIsDistributed());  
	  Assert.assertEquals(true, model.getUmpleClass(0).getIsDistributable());
	  Assert.assertEquals("distributableRMI", model.getUmpleClass(0).getDistributeTechnology());
  }
  @Test
  public void TestInterfaceModel()
  {
	  UmpleModel model2 = createUmpleSystem(pathToInput , languagePath + "/Interface_DistributableRMI.ump");
	  model2.generate();
	  
	  Assert.assertEquals(true, model2.getUmpleInterface(0).getIsDistributed());  
	  Assert.assertEquals("distributableRMI", model2.getUmpleInterface(0).getDistributeTechnology());
	 Assert.assertEquals(true, model2.getUmpleInterface(0).getIsDistributable());
  }
  
  
}