package cruise.umple.implementation.json;

import org.junit.*;

import cruise.umple.implementation.*;
import cruise.umple.util.SampleFileWriter;

public class JsonTemplateTest extends TemplateTest
{

  @Before
  public void setUp()
  {
    super.setUp();
    language = "Json";
    languagePath = "json";
  }

  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/json/umple.json");
  }

  @Test
  public void defaultPosition()
  {
    assertUmpleTemplateFor("json/DefaultPosition.ump", "json/DefaultPosition.json.txt");
  }

  @Test
  public void defaultAssociationPosition()
  {
    assertUmpleTemplateFor("json/DefaultAssociationPosition.ump", "json/DefaultAssociationPosition.json.txt");
  }

  @Test
  public void JsonLanguage()
  {
    language = null;
    assertUmpleTemplateFor("json/ClassTemplateTest_Json.ump", "json/ClassTemplateTest_Json.json.txt");
  }

  @Test
  public void Position()
  {
    assertUmpleTemplateFor("json/Position.ump", "json/Position.json.txt");
  }

  @Test
  public void MultipleClasses()
  {
    language = null;
    assertEitherUmpleTemplateFor("json/ClassTemplateTest_Json2.ump", "json/ClassTemplateTest_Json2.json.txt", "json/ClassTemplateTest_Json2b.json.txt");
  }

  @Test
  public void Attributes()
  {
    assertUmpleTemplateFor("json/ClassTemplateTest_Attributes.ump", "json/ClassTemplateTest_Attributes.json.txt");
  }
  
  @Test
  public void AttributesConst()
  {
    assertUmpleTemplateFor("json/ClassTemplateTest_Attributes2.ump", "json/ClassTemplateTest_Attributes2.json.txt");
  }

  @Test
  public void AttributesTraced()
  {
    assertUmpleTemplateFor("json/ClassTemplateTest_Attributes3.ump", "json/ClassTemplateTest_Attributes3.json.txt");
  }

  @Test
  public void Association()
  {
    assertEitherUmpleTemplateFor("json/AssociationTemplateTest_Json.ump", "json/AssociationTemplateTest_Jsonb.json.txt", "json/AssociationTemplateTest_Json.json.txt");
  }

  @Test
  public void AssociationUnidirectional()
  {
    assertEitherUmpleTemplateFor("json/UnidirectionalAssociationTemplateTest_Json.ump", "json/UnidirectionalAssociationTemplateTest_Jsonb.json.txt", "json/UnidirectionalAssociationTemplateTest_Json.json.txt");
  }

  @Test
  public void Generalization()
  {
    assertUmpleTemplateFor("json/Generalization.ump", "json/Generalization.json.txt");
  }

  @Test
  public void AssociationClass()
  {
    assertUmpleTemplateFor("json/AssociationClass.ump", "json/AssociationClass.json.txt");
  }

  @Test
  public void AssociationClassPositionsSeparate()
  {
    assertUmpleTemplateFor("json/AssociationClassPositionsSeparate.ump", "json/AssociationClassPositionsSeparate.json.txt");
  }
  
  @Test
  public void SymmetricReflexiveAssociation()
  {
    assertUmpleTemplateFor("json/SymmetricReflexiveAssociation.ump", "json/SymmetricReflexiveAssociation.json.txt");
  }
  // @Test
  // public void ExtraCode()
  // {
  // language = null;
  // assertUmpleTemplateFor("php/ClassTemplateTest_ExtraCode.ump","php/ClassTemplateTest_ExtraCode.php.txt","Mentor");
  // }

}
