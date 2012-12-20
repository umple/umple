/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation.cpp;

import java.io.File;

import org.junit.*;

import cruise.umple.implementation.ExternalClassTemplateTest;

public class CppExternalClassTemplateTest extends ExternalClassTemplateTest
{
  
  @Test
  public void DoNotCreateExternalClasses()
  {
    assertUmpleTemplateFor("ExternalClassTest.ump",languagePath + "/ExternalClassTest_MyClass."+ languagePath +".txt","MyException");
    Assert.assertEquals(false, (new File(pathToInput + "/example/Exception.cpp")).exists());
  }
    
}