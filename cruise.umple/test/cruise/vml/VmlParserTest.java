package cruise.vml;

import java.io.File;

import org.junit.*;

import cruise.umple.util.SampleFileWriter;
import cruise.vml.VariationPoint.Kind;

public class VmlParserTest
{
  VmlParser parser;
  VmlSystem system;
  String pathToInput;

  @Before
  public void setUp()
  {
    pathToInput = SampleFileWriter.rationalize("test/cruise/vml");
  }

  private void assertParse(String filename, String expectedOutput)
  {
    assertParse(filename, expectedOutput, true);
  }

//  private void assertFailedParse(String filename, Position expectedPosition)
//  {
//    assertParse(filename, "", false);
//    Assert.assertEquals(expectedPosition, parser.getParseResult().getPosition());
//  }

  private void assertParse(String filename, String expectedOutput, boolean expected)
  {
    String input = SampleFileWriter.readContent(new File(pathToInput, filename));
    parser = new VmlParser("vml");
    boolean answer = parser.parse("program",input).getWasSuccess();

    if (answer)
    {
      answer = parser.analyze().getWasSuccess();
    }

    if (answer == false && expected)
    {
      System.out.println("failed at:" + parser.getParseResult().getPosition());
    }
    
    Assert.assertEquals(expected, answer);
    if (expected)
    {
      Assert.assertEquals(expectedOutput, parser.toString());  
    }
    system = parser.getSystem();
  }
  

  
  
  @Test
  public void empty()
  {
    assertParse("001_empty.vml", "");
  }

  @Test
  public void comment()
  {
    assertParse("001_comments.vml", "[inlineComment:This is a simple comment][multilineComment:This is \nmore complex]");
    Assert.assertEquals(0, system.numberOfCodeSnippets());
  }  

  @Test
  public void freeText()
  {
    assertParse("001_freeText.vml", "[codeSnippet:this is \njust\n\nfree\n\ntext]");
    
    
    Assert.assertEquals(1, system.numberOfCodeSnippets());
    Assert.assertEquals(new CodeSnippet("this is \njust\n\nfree\n\ntext"),system.getCodeSnippet(0));
  }  
  
  @Test
  public void concern_Empty()
  {
    assertParse("002_concern_Empty.vml", "[concern][name:CTimeEntry]");
    Assert.assertEquals(1, system.numberOfConcerns());

    Concern c1 = new Concern("CTimeEntry");
    Assert.assertEquals(c1,system.getConcern(0));
  }   
  
  @Test
  public void concern_Brackets()
  {
    assertParse("002_concern_Brackets.vml", "[concern][name:CTimeEntry]");
    Assert.assertEquals(1, system.numberOfConcerns());

    Concern c1 = new Concern("CTimeEntry");
    Assert.assertEquals(c1,system.getConcern(0));
  }   

  @Test
  public void concern_Kind()
  {
    assertParse("002_concern_Kind.vml", "[concern][name:C][variationPoint][name:VP1][kind:Alternative][variationPoint][name:VP2][kind:Alternative][variationPoint][name:VP3]");
    
    Concern c1 = new Concern("C");
    
    Assert.assertEquals(1, system.numberOfConcerns());
    Assert.assertEquals(c1,system.getConcern(0));
    c1 = system.getConcern(0);
    
    VariationPoint vp1 = new VariationPoint("VP1");
    vp1.setKind(Kind.Alternative);
    
    VariationPoint vp2 = new VariationPoint("VP2");
    vp2.setKind(Kind.Optional);
    
    VariationPoint vp3 = new VariationPoint("VP3");
    vp3.setKind(Kind.Optional);
    
    vp1.setConcern(c1);
    vp2.setConcern(c1);
    vp3.setConcern(c1);
    
    
    Assert.assertEquals(3, c1.numberOfVariationPoints());
    Assert.assertEquals(vp1,c1.getVariationPoint(0));
    Assert.assertEquals(vp2,c1.getVariationPoint(1));
    Assert.assertEquals(vp3,c1.getVariationPoint(2));

    
  }
  
  @Test
  public void concern_Optional()
  {
    assertParse("002_concern_Optional.vml", "[concern][name:C][variationPoint][name:VP1][kind:Optional][codeSnippet:this\n    is\n    extra]");
    
    Concern c1 = new Concern("C");
    Assert.assertEquals(1, system.numberOfConcerns());
    Assert.assertEquals(c1,system.getConcern(0));
    c1 = system.getConcern(0);

    VariationPoint vp1 = new VariationPoint("VP1");
    vp1.setKind(Kind.Optional);
    vp1.setCodeSnippet(new CodeSnippet("this\n    is\n    extra"));

    vp1.setConcern(c1);
    
    Assert.assertEquals(1, c1.numberOfVariationPoints());
    Assert.assertEquals(vp1,c1.getVariationPoint(0));

  }

  @Test
  public void concern_Variant()
  {
    assertParse("002_concern_Variant.vml", "[concern][name:C][variationPoint][name:VP1][kind:Alternative][variant][name:var1][codeSnippet:do this;][variant][name:var2][codeSnippet:do that;]");
 
    Concern c1 = new Concern("C");
    Assert.assertEquals(1, system.numberOfConcerns());
    Assert.assertEquals(c1,system.getConcern(0));
    c1 = system.getConcern(0);

    VariationPoint vp1 = new VariationPoint("VP1");
    vp1.setKind(Kind.Alternative);
    vp1.setConcern(c1);
    
    Assert.assertEquals(1, c1.numberOfVariationPoints());
    Assert.assertEquals(vp1,c1.getVariationPoint(0));
    vp1 = c1.getVariationPoint(0);
    
    Assert.assertEquals(2, vp1.numberOfVariants());
    
    Variant v1 = new Variant("var1");
    v1.setCodeSnippet(new CodeSnippet("do this;"));
    
    Variant v2 = new Variant("var2");
    v2.setCodeSnippet(new CodeSnippet("do that;"));
    
    Assert.assertEquals(v1,vp1.getVariant(0));
    Assert.assertEquals(v2,vp1.getVariant(1));
    
  }

  @Test
  public void concern_RequiresBrackets()
  {
    assertParse("002_concern_RequiresBrackets.vml", "[concern][name:C][variationPoint][name:VP1][kind:Optional][variationPoint][name:VP2][requiresList][name:VP1][kind:Alternative][variant][name:var1][codeSnippet:do this;][variationPoint][name:VP3][requiresList][name:VP1][name:VP2][kind:Optional]");

  }
  
  @Test
  public void concern_Requires()
  {
    assertParse("002_concern_Requires.vml", "[concern][name:C][variationPoint][name:VP1][kind:Optional][variationPoint][name:VP2][requiresList][name:VP1][kind:Alternative][variant][name:var1][codeSnippet:do this;][variationPoint][name:VP3][requiresList][name:VP1][name:VP2][kind:Optional]");

    Assert.assertEquals(1, system.numberOfConcerns());
    Concern c1 = system.getConcern(0);
    
    VariationPoint vp1 = c1.getVariationPoint(0);
    VariationPoint vp2 = c1.getVariationPoint(1);
    VariationPoint vp3 = c1.getVariationPoint(2);
    
    Assert.assertEquals(0,vp1.numberOfRequires());
    Assert.assertEquals(1,vp2.numberOfRequires());
    Assert.assertEquals(2,vp3.numberOfRequires());
  }

  @Test
  public void invoke_Optional()
  {
    assertParse("003_invoke_Optional.vml", "[concern][name:C][variationPoint][name:VP2][kind:Optional][codeSnippet:do what;][invokeOptional][concern:C][variationPoint:VP2]");

    Assert.assertEquals(1, system.numberOfCodeSnippets());
    Assert.assertEquals(new CodeSnippet("do what;"),system.getCodeSnippet(0));
  }  

  @Test
  public void invoke_Alternative()
  {
    assertParse("003_invoke_Alternative.vml", "[concern][name:C][variationPoint][name:VP1][kind:Alternative][variant][name:var1][codeSnippet:do this;][variant][name:var2][codeSnippet:do that;][invokeAlternative][concern:C][variationPoint:VP1][variant:var1]");
    
    Assert.assertEquals(1, system.numberOfCodeSnippets());
    Assert.assertEquals(new CodeSnippet("do this;"),system.getCodeSnippet(0));
  }

  @Test
  public void invoke_RequiresAlready()
  {
    assertParse("003_invoke_RequiresAlready.vml", "[concern][name:C][variationPoint][name:VP1][requiresList][name:VP2][kind:Alternative][variant][name:var1][codeSnippet:do this;][variant][name:var2][codeSnippet:do that;][variationPoint][name:VP2][kind:Optional][codeSnippet:do what;][invokeOptional][concern:C][variationPoint:VP2][invokeAlternative][concern:C][variationPoint:VP1][variant:var1]");
    
    Assert.assertEquals(2, system.numberOfCodeSnippets());
    Assert.assertEquals(new CodeSnippet("do what;"),system.getCodeSnippet(0));
    Assert.assertEquals(new CodeSnippet("do this;"),system.getCodeSnippet(1));
  }

  @Test
  public void invoke_RequiresMustBeAdded()
  {
    assertParse("003_invoke_RequiresMustBeAdded.vml", "[concern][name:C][variationPoint][name:VP1][requiresList][name:VP2][kind:Alternative][variant][name:var1][codeSnippet:do this;][variant][name:var2][codeSnippet:do that;][variationPoint][name:VP2][kind:Optional][codeSnippet:do what;][invokeAlternative][concern:C][variationPoint:VP1][variant:var1]");
    
    Assert.assertEquals(2, system.numberOfCodeSnippets());
    Assert.assertEquals(new CodeSnippet("do what;"),system.getCodeSnippet(0));
    Assert.assertEquals(new CodeSnippet("do this;"),system.getCodeSnippet(1));
  }
  
  @Test
  public void invoke_RequiresAlternative()
  {
    assertParse("003_invoke_RequiresAlternative.vml", "[concern][name:C][variationPoint][name:VP1][kind:Alternative][variant][name:var1][codeSnippet:do this;][variant][name:var2][codeSnippet:do that;][variationPoint][name:VP2][requiresList][name:VP1][kind:Optional][codeSnippet:do what;][invokeOptional][concern:C][variationPoint:VP2]");
    
    Assert.assertEquals(2, system.numberOfCodeSnippets());
    Assert.assertEquals(new CodeSnippet("do this;"),system.getCodeSnippet(0));
    Assert.assertEquals(new CodeSnippet("do what;"),system.getCodeSnippet(1));
  }
  
  @Test
  public void FullExample()
  {
    String input = SampleFileWriter.readContent(new File(pathToInput, "099_fullExample.vml"));
    parser = new VmlParser("vml");
    
    
    boolean answer = parser.parse("program",input).getWasSuccess();
    Assert.assertEquals(true,answer);
    answer = parser.analyze().getWasSuccess();
    Assert.assertEquals(true,answer);
    
    system = parser.getSystem();
    System.out.println(system.getCode());
    
  }
}
