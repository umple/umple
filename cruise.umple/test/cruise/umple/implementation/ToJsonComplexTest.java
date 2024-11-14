/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 https://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

public class ToJsonComplexTest extends TemplateTest
{
  
  @Test
  public void GenJsonTest_2Course()
  {
    assertUmpleTemplateFor("ToJsonComplexTest.ump",languagePath + "/ToJsonTest_2_Course."+ languagePath +".txt","Course");
 }
  
  @Test
  public void GenJsonTest_2CourseSection()
  {
    assertUmpleTemplateFor("ToJsonComplexTest.ump",languagePath + "/ToJsonTest_2_CourseSection."+ languagePath +".txt","CourseSection");
  }
  
  @Test
  public void GenJsonTest_2Employee()
  {
    assertUmpleTemplateFor("ToJsonComplexTest.ump",languagePath + "/ToJsonTest_2_Employee."+ languagePath +".txt","Employee");
  } 
  
  @Test
  public void GenJsonTest_2PartTimeStudent()
  {
    assertUmpleTemplateFor("ToJsonComplexTest.ump",languagePath + "/ToJsonTest_2_PartTimeStudent."+ languagePath +".txt","PartTimeStudent");
  } 
  
  @Test
  public void GenJsonTest_2Person()
  {
    assertUmpleTemplateFor("ToJsonComplexTest.ump",languagePath + "/ToJsonTest_2_Person."+ languagePath +".txt","Person");
  } 
  
  @Test
  public void GenJsonTest_2Registration()
  {
    assertUmpleTemplateFor("ToJsonComplexTest.ump",languagePath + "/ToJsonTest_2_Registration."+ languagePath +".txt","Registration");
  } 
  
  @Test
  public void GenJsonTest_2Student()
  {
    assertUmpleTemplateFor("ToJsonComplexTest.ump",languagePath + "/ToJsonTest_2_Student."+ languagePath +".txt","Student");
  } 
  
  @Test
  public void GenJsonTest_2University()
  {
    assertUmpleTemplateFor("ToJsonComplexTest.ump",languagePath + "/ToJsonTest_2_University."+ languagePath +".txt","University");
  }
  
}
