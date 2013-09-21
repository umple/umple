package cruise.umple.implementation.yuml;

import org.junit.*;

import cruise.umple.implementation.*;
import cruise.umple.util.SampleFileWriter;

public class YumlTemplateTest extends TemplateTest
{
  
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Yuml";
    languagePath = "yuml";
  }
  
  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/yuml/umple.yuml");
  }
  
  
  @Test
  public void YumlLanguage()
  {
    language = null;
    assertUmpleTemplateFor("yuml/ClassTemplateTest_Yuml.ump","yuml/ClassTemplateTest_Yuml.yuml.txt");
  }
  
  @Test
  public void MultipleClasses()
  {
    language = null;
    assertEitherUmpleTemplateFor("yuml/ClassTemplateTest2_Yuml.ump","yuml/ClassTemplateTest2_Yuml.yuml.txt","yuml/ClassTemplateTest2b_Yuml.yuml.txt");
  }
  
  @Test
  public void Attributes()
  {
    assertUmpleTemplateFor("yuml/ClassTemplateTest_Attributes.ump","yuml/ClassTemplateTest_Attributes.yuml.txt");
  }
  
  @Test
  public void Association()
  {
    assertEitherUmpleTemplateFor("yuml/AssociationTemplateTest1_Yuml.ump","yuml/AssociationTemplateTest1_Yuml.yuml.txt","yuml/AssociationTemplateTest1b_Yuml.yuml.txt");
  }

  @Test
  public void OneWayAssociation_Left()
  {
    assertEitherUmpleTemplateFor("yuml/AssociationTemplateTest2_Yuml.ump","yuml/AssociationTemplateTest2_Yuml.yuml.txt","yuml/AssociationTemplateTest2b_Yuml.yuml.txt");
  }
  
  @Test
  public void OneWayAssociation_Right()
  {
    assertEitherUmpleTemplateFor("yuml/AssociationTemplateTest3_Yuml.ump","yuml/AssociationTemplateTest3_Yuml.yuml.txt","yuml/AssociationTemplateTest3b_Yuml.yuml.txt");
  }
  
  @Test
  public void Inheritance()
  {
    assertEitherUmpleTemplateFor("yuml/InheritanceTemplateTest1_Yuml.ump","yuml/InheritanceTemplateTest1_Yuml.yuml.txt","yuml/InheritanceTemplateTest1b_Yuml.yuml.txt");
  }
  @Test
  public void RoleNameWithMultiplicity()
  {
	  assertUmpleTemplateFor("yuml/RoleNameWIthMultiplicity.ump","yuml/RoleNameWIthMultiplicity.yuml.txt");  
  }
}
