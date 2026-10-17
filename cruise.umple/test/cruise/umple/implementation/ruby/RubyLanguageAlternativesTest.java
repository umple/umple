/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 https://umple.org/license

*/

package cruise.umple.implementation.ruby;

import org.junit.*;

import cruise.umple.implementation.LanguageAlternativesTest;

public class RubyLanguageAlternativesTest extends LanguageAlternativesTest
{
  @Before
  public void setUp()
  {
    super.setUp();
    language = "Ruby";
    languagePath = "ruby";
  }

  @Ignore("Ruby state machine code is generated in Java syntax (switch, case, break), so its guards are not checked")
  @Test
  public void guardsTaggedEntryAndExitActions()
  {
  }
}
