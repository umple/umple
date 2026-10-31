package cruise.umple.implementation.gv;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cruise.umple.implementation.TemplateTest;
import cruise.umple.util.SampleFileWriter;

public class GvUseCaseDiagramGeneratorTest extends TemplateTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    language = "GvUseCaseDiagram";
    languagePath = "gv";
  }

  @After
  public void tearDown()
  {
    super.tearDown();
    SampleFileWriter.destroy(pathToInput + "/gv/UseCaseRelationshipsucd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/UseCaseFreeTextucd.gv");
    SampleFileWriter.destroy(pathToInput + "/gv/UseCaseNoneucd.gv");
  }

  // Actors shared by several use cases appear once; include and isA become arrows
  @Test
  public void actorsAndRelationships()
  {
    assertUmpleTemplateFor("gv/UseCaseRelationships.ump", "gv/UseCaseRelationships.gv.txt");
  }

  // A free text use case is drawn with its identifier only, and user stories are not drawn
  @Test
  public void freeTextUseCase()
  {
    assertUmpleTemplateFor("gv/UseCaseFreeText.ump", "gv/UseCaseFreeText.gv.txt");
  }

  @Test
  public void noUseCase()
  {
    assertUmpleTemplateFor("gv/UseCaseNone.ump", "gv/UseCaseNone.gv.txt");
  }
}
