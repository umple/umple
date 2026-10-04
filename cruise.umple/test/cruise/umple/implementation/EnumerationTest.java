/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 https://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class EnumerationTest extends TemplateTest
{
   
  
  @Test
  public void EnumerationTest_1(){
    assertUmpleTemplateFor("EnumerationTest_1.ump",
        languagePath + "/EnumerationTest_1." + languagePath + ".txt",
        "Student");
  }
  
  @Test
  public void EnumerationTest_2(){
    assertUmpleTemplateFor("EnumerationTest_2.ump",
        languagePath + "/EnumerationTest_2." + languagePath + ".txt",
        "X");
  }
  
  @Test
  public void EnumerationTest_3(){
    assertUmpleTemplateFor("EnumerationTest_3.ump",
        languagePath + "/EnumerationTest_3_c1." + languagePath + ".txt",
        "C1");
    assertUmpleTemplateFor("EnumerationTest_3.ump",
        languagePath + "/EnumerationTest_3_c2." + languagePath + ".txt",
        "C2");
  }
  
  @Test
  public void EnumerationTest_4(){
    assertUmpleTemplateFor("EnumerationTest_4.ump",
        languagePath + "/EnumerationTest_4_c1." + languagePath + ".txt",
        "C1");
    assertUmpleTemplateFor("EnumerationTest_4.ump",
        languagePath + "/EnumerationTest_4_c2." + languagePath + ".txt",
        "C2");
  }
  
  @Test
  public void EnumerationTest_5(){
    assertUmpleTemplateFor("EnumerationTest_5.ump",
        languagePath + "/EnumerationTest_5_X1." + languagePath + ".txt",
        "X1");
    assertUmpleTemplateFor("EnumerationTest_5.ump",
        languagePath + "/EnumerationTest_5_X2." + languagePath + ".txt",
        "X2");
  }
  
  @Test
  public void EnumerationTest_6(){
    assertUmpleTemplateFor("EnumerationTest_6.ump",
        languagePath + "/EnumerationTest_6_X." + languagePath + ".txt",
        "X");
    assertUmpleTemplateFor("EnumerationTest_6.ump",
        languagePath + "/EnumerationTest_6_X2." + languagePath + ".txt",
        "X2");
  }
  
  @Test
  public void EnumerationTest_7(){
    assertUmpleTemplateFor("EnumerationTest_7.ump",
        languagePath + "/EnumerationTest_7_X." + languagePath + ".txt",
        "X");
    assertUmpleTemplateFor("EnumerationTest_7.ump",
        languagePath + "/EnumerationTest_7_Y." + languagePath + ".txt",
        "Y");
    assertUmpleTemplateFor("EnumerationTest_7.ump",
        languagePath + "/EnumerationTest_7_Z." + languagePath + ".txt",
        "Z");
  }
  
  @Test
  public void EnumerationTest_8(){
    assertUmpleTemplateFor("EnumerationTest_8.ump",
        languagePath + "/EnumerationTest_8." + languagePath + ".txt",
        "A");
  }

  @Test
  public void EnumerationTest_innerQualified(){
    assertUmpleTemplateFor("EnumerationTest_innerQualified_1.ump",
        languagePath + "/EnumerationTest_innerQualified_1." + languagePath + ".txt",
        "Driver");
  }

  @Test
  public void EnumerationTest_9(){
    assertUmpleTemplateFor("EnumerationTest_9.ump", 
        languagePath + "/EnumerationTest_9." + languagePath + ".txt",
        "Bar");
  }

}
