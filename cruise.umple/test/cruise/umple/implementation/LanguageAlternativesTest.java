/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 https://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

import cruise.umple.util.SampleFileWriter;

// Method bodies, their pre and postconditions and entry/exit guards across language alternatives
public class LanguageAlternativesTest extends TemplateTest
{
  @After
  public void tearDown()
  {
    super.tearDown();
    for (String name : new String[] {"Account", "Shape", "Lamp"})
    {
      SampleFileWriter.destroy(pathToInput + "/" + name + ".java");
      SampleFileWriter.destroy(pathToInput + "/" + name + ".php");
      SampleFileWriter.destroy(pathToInput + "/" + name.toLowerCase() + ".rb");
    }
  }

  // Each condition belongs to its method and to the body written with it (#2250)
  @Test
  public void contractsFollowTheirMethodAndBody()
  {
    assertUmpleTemplateFor("LanguageAlternativesContracts.ump", languagePath + "/LanguageAlternativesContracts." + languagePath + ".txt", "Account");
  }

  // An untagged body is every language's fallback; bodies only for other languages are not
  @Test
  public void untaggedBodyIsEveryLanguagesFallback()
  {
    assertUmpleTemplateFor("LanguageAlternativesBodies.ump", languagePath + "/LanguageAlternativesBodies." + languagePath + ".txt", "Shape");
  }

  // A guarded entry or exit action keeps its guard whichever body the language selects
  @Test
  public void guardsTaggedEntryAndExitActions()
  {
    assertUmpleTemplateFor("LanguageAlternativesGuards.ump", languagePath + "/LanguageAlternativesGuards." + languagePath + ".txt", "Lamp");
  }
}
