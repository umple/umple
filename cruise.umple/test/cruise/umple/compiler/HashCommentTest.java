/*
 Copyright: All contributors to the Umple Project
 This file is made available subject to the open source license found at:
 https://umple.org/license
*/
package cruise.umple.compiler;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import cruise.umple.parser.ErrorTypeSingleton;

import static org.junit.Assert.*;

public class HashCommentTest
{
  @Rule
  public TemporaryFolder temporary = new TemporaryFolder();

  private UmpleModel compile(String source, String language) throws Exception
  {
    File directory = temporary.newFolder();
    File input = new File(directory, "comments.ump");
    Files.write(input.toPath(), ("generate " + language + ";\n" + source).getBytes(StandardCharsets.UTF_8));
    ErrorTypeSingleton.getInstance().reset();
    UmpleModel model = new UmpleModel(new UmpleFile(input.getAbsolutePath()));
    model.run();
    assertTrue(model.getLastResult().toString(), model.getLastResult().getWasSuccess());
    return model;
  }

  private void assertCommentOrder(String code, String first, String second)
  {
    assertNotNull(code);
    assertTrue("Missing " + first + " in:\n" + code, code.contains(first));
    assertTrue("Missing " + second + " in:\n" + code, code.contains(second));
    assertTrue(code.indexOf(first) < code.indexOf(second));
  }

  @Test
  public void quotesAndBracesInHashCommentsDoNotAffectClassParsing() throws Exception
  {
    for (String text : new String[] {"don't change this", "an unmatched \" quote", "Example {", "Example }", "( [ /*"})
    {
      UmpleModel model = compile("class Foo {\n  # " + text + "\n  name;\n}\n", "Java");
      assertEquals(text, model.getUmpleClass("Foo").getAttribute(0).getComment(0).getText());
      assertTrue(model.getGeneratedCode().get("Foo").contains("private String name;"));
    }
  }

  @Test
  public void hashCommentsInsideNativeMethodBodiesDoNotAffectBraceMatching() throws Exception
  {
    UmpleModel model = compile("class Foo {\nvoid run() {\n# don't count this } or \"\nprint('ok')\n}\n}\n", "Python");
    String code = model.getGeneratedCode().get("Foo");
    assertTrue(code.contains("# don't count this } or \""));
    assertTrue(code.contains("print('ok')"));
  }

  @Test
  public void consecutiveClassCommentsPreserveHashAndSlashLines() throws Exception
  {
    UmpleModel model = compile("# FIRST\n// MIDDLE\n# LAST\nclass Foo {}\n", "Java");
    assertEquals(3, model.getUmpleClass("Foo").numberOfComments());
    String code = model.getGeneratedCode().get("Foo");
    assertCommentOrder(code, "FIRST", "MIDDLE");
    assertCommentOrder(code, "MIDDLE", "LAST");
  }

  @Test
  public void consecutiveAttributeAssociationAndMethodCommentsArePreserved() throws Exception
  {
    UmpleModel model = compile("class Foo {\n"
      + "# ATTRIBUTE_FIRST\n# ATTRIBUTE_LAST\nname;\n"
      + "# ASSOCIATION_FIRST\n# ASSOCIATION_LAST\n1 -- * Bar;\n"
      + "# METHOD_FIRST\n# METHOD_LAST\nvoid run() {}\n}\nclass Bar {}\n", "Java");
    UmpleClass foo = model.getUmpleClass("Foo");
    assertEquals(2, foo.getAttribute(0).numberOfComments());
    assertEquals(2, foo.getAssociationVariable(0).numberOfComments());
    String code = model.getGeneratedCode().get("Foo");
    assertCommentOrder(code, "ATTRIBUTE_FIRST", "ATTRIBUTE_LAST");
    assertCommentOrder(code, "ASSOCIATION_FIRST", "ASSOCIATION_LAST");
    assertCommentOrder(code, "METHOD_FIRST", "METHOD_LAST");
  }

  @Test
  public void consecutiveTraitCommentsArePreserved() throws Exception
  {
    UmpleModel model = compile("trait Named {\n# FIRST\n# LAST\nname;\n}\nclass Foo { isA Named; }\n", "Java");
    assertEquals(2, model.getUmpleTrait("Named").getAttribute(0).numberOfComments());
    assertCommentOrder(model.getGeneratedCode().get("Foo"), "FIRST", "LAST");
  }

  @Test
  public void emptyAndBracketStartingHashCommentsRemainComments() throws Exception
  {
    UmpleModel model = compile("#\nclass Foo {\n  #\n  # [a comment]\n  name; # trailing comment\n}\n#", "Java");
    String code = model.getGeneratedCode().get("Foo");
    assertTrue(code.contains("[a comment]"));
    assertTrue(code.contains("trailing comment"));
    assertTrue(code.contains("private String name;"));
  }

  @Test
  public void hashInQuotedAttributeValueIsPreserved() throws Exception
  {
    String value = "\"#[Marker] don't count { or //\"";
    UmpleModel model = compile("class Foo { value = " + value + "; }\n", "Java");
    assertEquals(value, model.getUmpleClass("Foo").getAttribute(0).getValue());
    assertTrue(model.getGeneratedCode().get("Foo").contains(value));
  }

  @Test
  public void hashesInRawTemplatesDoNotHideTemplateDelimiters() throws Exception
  {
    UmpleModel model = compile("class Foo {\nbody <<!#ifdef TEST\nvalue\n#endif!>>\nemit render()(body);\n}\n", "Java");
    String code = model.getGeneratedCode().get("Foo");
    assertTrue(code.contains("#ifdef TEST"));
    assertTrue(code.contains("#endif"));
  }

  @Test
  public void traitTypeParametersRemainNativeCode() throws Exception
  {
    UmpleModel model = compile("class Foo { isA T<X=Bar>; } class Bar {}\n"
      + "trait T<X> { void run() {#X# value = new #X#();} }\n", "Java");
    assertTrue(model.getGeneratedCode().get("Foo").contains("Bar value = new Bar();"));
  }

  @Test(timeout = 5000)
  public void commentGrammarCanBeReadByTheDocumentationParser()
  {
    Parser parser = new Parser(null);
    assertTrue(parser.addRulesInFile("/umple_core.grammar") > 0);
    assertTrue(parser.toGrammar().contains("hashCommentAhead"));
  }

  @Test
  public void phpAttributesRemainNativeCodeInsteadOfDocumentation() throws Exception
  {
    UmpleModel model = compile("strictness allow 1007;\nstrictness allow 1008;\nclass Foo {\n#[Marker]\n#[Other(\"don't count {\")]\npublic function marked() {}\n}\n", "Php");
    String code = model.getGeneratedCode().get("Foo");
    assertCommentOrder(code, "#[Marker]", "#[Other(\"don't count {\")]");
    assertTrue(code.contains("function marked"));
    assertFalse(code.contains("* [Marker]"));
  }
}
