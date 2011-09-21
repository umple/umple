package cruise.umple.compiler;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class TextParserTest {

  TextParser parser;
  
  @Before
  public void SetUp()
  {
    parser = new TextParser();
  }

  @Test
  public void Empty()
  {
    Assert.assertEquals(null,parser.next());
  }
  
  @Test
  public void OnlyStopAtSpaces()
  {
    parser.load("abc-def= \"aha\"");
    Assert.assertEquals("abc-def=",parser.next());
    Assert.assertEquals("\"aha\"",parser.next());
  }

  @Test
  public void WhiteSpaceTest()
  {
    parser.load("a \t\r\n b");
    Assert.assertEquals("a",parser.next());
    Assert.assertEquals("b",parser.next());
  }
  @Test
  public void Peek()
  {
    parser.load("a bb c dd");
    Assert.assertEquals("a",parser.peek());
    Assert.assertEquals("a",parser.next());

    Assert.assertEquals("bb",parser.peek());
    Assert.assertEquals("bb",parser.next());

    Assert.assertEquals("c",parser.peek());
    Assert.assertEquals("c",parser.next());

    Assert.assertEquals("dd",parser.peek());
    Assert.assertEquals("dd",parser.next());

    Assert.assertEquals(null,parser.peek());
    Assert.assertEquals(null,parser.next());
}  
  
  @Test
  public void section()
  {
    
    parser.load("a bb cccc dd ");
    
    Assert.assertEquals("", parser.section(-2));
    Assert.assertEquals("", parser.section(12));
    Assert.assertEquals("", parser.section(13));
    Assert.assertEquals("", parser.section(14));
    Assert.assertEquals("d", parser.section(11));
    
    Assert.assertEquals("bb cccc dd", parser.section(1));
    
  }
  
  @Test
  public void previousIndex()
  {
    parser.load("a bb cccc dd");
    
    Assert.assertEquals(0,parser.previousIndex());
    parser.next();
    Assert.assertEquals(0,parser.previousIndex());
    parser.next();
    Assert.assertEquals(2,parser.previousIndex());
    parser.next();
    Assert.assertEquals(5,parser.previousIndex());
    parser.next();
    Assert.assertEquals(10,parser.previousIndex());
    parser.next();
    Assert.assertEquals(-1,parser.previousIndex());
  }

  @Test
  public void currentIndex()
  {
    parser.load("a bb cccc dd");
    
    Assert.assertEquals(0,parser.currentIndex());
    parser.next();
    Assert.assertEquals(2,parser.currentIndex());
    parser.next();
    Assert.assertEquals(5,parser.currentIndex());
    parser.next();
    Assert.assertEquals(10,parser.currentIndex());
    parser.next();
    Assert.assertEquals(12,parser.currentIndex());
    parser.next();
    Assert.assertEquals(12,parser.currentIndex());
  }

  @Test
  public void reset()
  {
    parser.load("a bb cccc dd");

    parser.next();
    parser.next();
    parser.next();
    parser.reset(2);
    
    Assert.assertEquals(null, parser.name());
    Assert.assertEquals("bb", parser.next());
    
  }
  
  @Test
  public void SimpleElement()
  {
    parser.load("a");
    
    Assert.assertEquals(null,parser.name());
    
    Assert.assertEquals("a",parser.next());
    Assert.assertEquals("a",parser.name());

    Assert.assertEquals(null,parser.next());
    Assert.assertEquals(null,parser.name());
  }  
  
  @Test
  public void MulipleSimpleElement()
  {
    parser.load("a bee stung me");
    
    Assert.assertEquals(null,parser.name());
    
    Assert.assertEquals("a",parser.next());
    Assert.assertEquals("a",parser.name());

    Assert.assertEquals("bee",parser.next());
    Assert.assertEquals("stung",parser.next());
    Assert.assertEquals("me",parser.next());
    Assert.assertEquals(null,parser.next());
  }   

  
  @Test
  public void BracesNoSpace()
  {
    parser.load("process Travel{}");
    
    Assert.assertEquals("process",parser.next());
    Assert.assertEquals("Travel{}",parser.next());
    Assert.assertEquals(null,parser.next());
  }

  @Test
  public void BracesWithSpace()
  {
    parser.load("process Travel {}");
    
    Assert.assertEquals("process",parser.next());
    Assert.assertEquals("Travel",parser.next());
    Assert.assertEquals("{}",parser.next());
  }
  
  
  @Test
  public void IncludeQuotes()
  {
    String input = "\"b\" c \"d\"";
    
    parser.load(input);
    Assert.assertEquals("\"b\"",parser.next());
    Assert.assertEquals("c",parser.next());
    Assert.assertEquals("\"d\"",parser.next());
  }

  @Test
  public void next_stopUntil()
  {
    parser.load("a=b");
    Assert.assertEquals("a", parser.nextUntil("="));
    Assert.assertEquals("=", parser.nextAt("="));
    Assert.assertEquals("b", parser.nextUntil());
    
  }

  @Test
  public void nextUntilEndWithNewlines()
  {
    parser.load("a b \n c=b");
    Assert.assertEquals("a b \n c=b", parser.nextUntil(false,(String[])null));
  }  
  
  @Test
  public void nextUntilWithNewlines()
  {
    parser.load("a b \n c=b");
    Assert.assertEquals("a b \n c", parser.nextUntil(false,"="));
    Assert.assertEquals("=", parser.nextAt("="));
    Assert.assertEquals("b", parser.nextUntil());
    
  }

  @Test
  public void nextAfterWithSpaces()
  {
    parser.load("a { blah blah } b");
    Assert.assertEquals("a { blah blah }", parser.nextAfter(false,"}"));
    Assert.assertEquals("b", parser.next());
  }
  
  @Test
  public void nextAfterWithSpaces_replace()
  {
    parser.load("a { blah blah } b");
    Assert.assertEquals("a { blah blah }", parser.nextAfter(false,"}"));
    Assert.assertEquals("a { blah blah }[ ]b",parser.toString());
    parser.replace("IGNOREME");
    Assert.assertEquals("IGNOREME b", parser.getText());
    Assert.assertEquals("b", parser.next());
  }
  
  @Test
  public void replaceToken_null()
  {
    parser.load("a { blah blah } b");
    
    parser.replace(null,"morebla");
    
    Assert.assertEquals("a { blah blah } b",parser.getText());
    Assert.assertEquals("a",parser.next());
  }

  @Test
  public void replaceToken_multipleTimes()
  {
    parser.load("1 2 3 4");

    Token t = new Token("x","1");
    t.setPosition(new Position(0,0,0));
    parser.replace(t,"10");
    
    t = new Token("y","2");
    t.setPosition(new Position(0,2,2));
    parser.replace(t,"20");    
    Assert.assertEquals("10 20 3 4",parser.getText());

    t = new Token("height","4");
    t.setPosition(new Position(0,6,6));
    parser.replace(t,"40");    
    Assert.assertEquals("10 20 3 40",parser.getText());

    t = new Token("height","3");
    t.setPosition(new Position(0,4,4));
    parser.replace(t,"30");    
    Assert.assertEquals("10 20 30 40",parser.getText());
    
  }
  
  @Test
  public void insertAfterAndReplaceToken()
  {
    parser.load("1 2 3 4");

    Token one = new Token("one","1");
    one.setPosition(new Position(0,0,0));

    Token two = new Token("two","2");
    two.setPosition(new Position(0,2,2));

    Token three = new Token("three","3");
    three.setPosition(new Position(0,4,4));

    Token four = new Token("four","4");
    four.setPosition(new Position(0,6,6));
    
    parser.insertAfter(one, "abc");
    Assert.assertEquals("1abc 2 3 4",parser.getText());

    parser.replace(two,"222");
    Assert.assertEquals("1abc 222 3 4",parser.getText());
    
    parser.insertAfter(null, "xxxx");
    Assert.assertEquals("xxxx1abc 222 3 4",parser.getText());

    parser.replace(four,"44");
    Assert.assertEquals("xxxx1abc 222 3 44",parser.getText());
    
    parser.insertAfter(two, "def");
    Assert.assertEquals("xxxx1abc 222def 3 44",parser.getText());

    parser.replace(three,"33 33");
    Assert.assertEquals("xxxx1abc 222def 33 33 44",parser.getText());
    
  }   
  
  @Test
  public void replaceToken_middle()
  {
    parser.load("a { blah blah } b");
    
    Token t = new Token("x","bla");
    t.setPosition(new Position(1,4,4));
    parser.replace(t,"morebla");
    
    Assert.assertEquals("a { moreblah blah } b",parser.getText());
    Assert.assertEquals("a",parser.next());
  }  
  
  @Test
  public void replaceToken_start()
  {
    parser.load("a { blah blah } b");
    
    Token t = new Token("x","a");
    t.setPosition(new Position(0,0,0));
    parser.replace(t,"nota");
    
    Assert.assertEquals("nota { blah blah } b",parser.getText());
    Assert.assertEquals("nota",parser.next());
  }  

  @Test
  public void replaceToken_end()
  {
    parser.load("a { blah blah } b");
    
    Token t = new Token("x","b");
    t.setPosition(new Position(0,16,16));
    parser.replace(t,"nolongerb");
    
    Assert.assertEquals("a { blah blah } nolongerb",parser.getText());
    Assert.assertEquals("a",parser.next());
  }
  
  @Test
  public void replaceToken_rememberIndexBefore()
  {
    parser.load("a { blah blah } b");
    parser.next();
    
    Token t = new Token("x","blah");
    t.setPosition(new Position(0,4,4));
    parser.replace(t,"noblah");
    
    Assert.assertEquals("a { noblah blah } b",parser.getText());
    Assert.assertEquals(2,parser.currentIndex());
    Assert.assertEquals("{",parser.next());
  }   
  
  @Test
  public void replaceToken_rememberIndexAfter()
  {
    parser.load("a { blah blah } b");
    parser.next();
    parser.next();
    
    Token t = new Token("x","{");
    t.setPosition(new Position(0,2,2));
    parser.replace(t,"[[[[[[");
    
    Assert.assertEquals("a [[[[[[ blah blah } b",parser.getText());
    Assert.assertEquals(9,parser.currentIndex());
    Assert.assertEquals("blah",parser.next());
  }  
  
  
  @Test
  public void nextUntil_newline()
  {
    parser.load("a = b \n c d e");
    Assert.assertEquals("a = b", parser.nextLine());
    Assert.assertEquals("a = b", parser.name());
    Assert.assertEquals(8,parser.currentIndex());
    Assert.assertEquals(0,parser.previousIndex());

    
    Assert.assertEquals("c d e", parser.nextLine());
    Assert.assertEquals("c d e", parser.name());
    Assert.assertEquals(13,parser.currentIndex());
    Assert.assertEquals(8,parser.previousIndex());
    
    Assert.assertEquals(null, parser.nextLine());
    Assert.assertEquals(null, parser.name());
    Assert.assertEquals(13,parser.currentIndex());
    Assert.assertEquals(13,parser.previousIndex());
    
    Assert.assertEquals(null, parser.nextLine());
    Assert.assertEquals(null, parser.name());
    Assert.assertEquals(13,parser.currentIndex());
    Assert.assertEquals(13,parser.previousIndex());

  }
  
  @Test
  public void nextAfter_newline()
  {
    parser.load("a = b \n c d e");
    Assert.assertEquals("a = b", parser.nextAfter("\n"));
    Assert.assertEquals(null, parser.nextAfter("\n"));
    Assert.assertEquals(null, parser.nextAfter("\n"));
  }
  
  @Test
  public void nextUntil_StopAtSpaceByDefault()
  {
    parser.load("a b = b");
    Assert.assertEquals("a", parser.nextUntil("x"));
    Assert.assertEquals("b", parser.nextUntil("y"));
    Assert.assertEquals("=", parser.nextUntil("z"));

    parser.reset(0);
    Assert.assertEquals("a", parser.nextUntil(true,"x"));
    Assert.assertEquals("b", parser.nextUntil(true,"y"));
    Assert.assertEquals("=", parser.nextUntil(true,"z"));

    parser.reset(0);
    Assert.assertEquals("a b", parser.nextUntil(false,"="));
    Assert.assertEquals("= b", parser.nextUntil(false,"y"));
  }  
  
  @Test
  public void nextUntil_multiple()
  {
    parser.load("a!=b");
    Assert.assertEquals("a",parser.nextUntil("!=","="));
  }
  
  @Test
  public void nextUntil_nullGoesUntilSpace()
  {
    parser.load("a = b");
    
    Assert.assertEquals("a", parser.nextUntil());
    Assert.assertEquals("=", parser.nextUntil());
    Assert.assertEquals("b", parser.nextUntil());
    Assert.assertEquals(null, parser.nextUntil());
  }
  
  
  @Test
  public void next_stopUntilComplex()
  {
    parser.load("a={{b");
    Assert.assertEquals("a", parser.nextUntil("={{"));
    Assert.assertEquals("=", parser.nextAt("="));
    Assert.assertEquals("{{", parser.nextAt("{{"));
    Assert.assertEquals("b", parser.nextUntil());
    
  }

  @Test
  public void nextUntil_includeWhiteSpace()
  {
    parser.load("a b c = d");
    Assert.assertEquals("a b c", parser.nextUntil(false,"="));
    Assert.assertEquals("=", parser.nextAt("="));
    Assert.assertEquals("d", parser.nextUntil());
    
  }
  
  @Test
  public void ConstructorWithInput()
  {
    TextParser p = new TextParser("class A");
    Assert.assertEquals("class",p.next());
  }
  
  @Test
  public void nextAt_notThere()
  {
    parser.load("class A");
    Assert.assertEquals(null, parser.nextAt("interface"));
    Assert.assertEquals("class", parser.next());
  }
  
  @Test
  public void peekAt_NotThere()
  {
    parser.load("class A");
    Assert.assertEquals(null, parser.peekAt("interface"));
    Assert.assertEquals("class", parser.peekAt("class"));
    Assert.assertEquals("class", parser.nextAt("class"));
  }  

  @Test
  public void peekAt_Multiple()
  {
    parser.load("interface A");
    Assert.assertEquals("interface", parser.peekAt("class","interface"));
    Assert.assertEquals(null, parser.peekAt("class","abstract"));
  }  

  @Test
  public void nextAt_Multiple()
  {
    parser.load("abstract interface A");
    Assert.assertEquals("abstract", parser.nextAt("public","abstract"));
    Assert.assertEquals("interface", parser.nextAt("interface","class"));
  }  
  
  
  @Test
  public void all_everything()
  {
    parser.load("class A");
    Assert.assertEquals("class A",parser.all());
    Assert.assertEquals(null, parser.next());
    
  }

  @Test
  public void all_fromCurrentPoint()
  {
    parser.load("class A");
    parser.next();
    Assert.assertEquals("A",parser.all());
    Assert.assertEquals(null, parser.next());
  }
  
  @Test
  public void lookFor_none()
  {
    parser.load("a b c");
    Assert.assertEquals(null, parser.lookFor("(", ")", true));
    Assert.assertEquals(null, parser.next());
  }
  
  @Test
  public void lookFor_first()
  {
    parser.load("(a b ) c");
    Assert.assertEquals("(a b )", parser.lookFor("(", ")", true));
    Assert.assertEquals("c", parser.next());
  }  

  @Test
  public void lookFor_last()
  {
    parser.load("a (b c)");
    Assert.assertEquals("(b c)", parser.lookFor("(", ")", true));
    Assert.assertEquals(null, parser.next());
  }  

  @Test
  public void lookFor_middle()
  {
    parser.load("a (b c) dd");
    Assert.assertEquals("(b c)", parser.lookFor("(", ")", true));
    Assert.assertEquals("dd", parser.next());
  }

  @Test
  public void lookFor_noEnding()
  {
    parser.load("a (b c dd");
    Assert.assertEquals(null, parser.lookFor("(", ")", true));
    Assert.assertEquals(null, parser.next());
  }

  
  @Test
  public void lookFor_stopAtSpace()
  {
    parser.load("a (b c)? dd");
    Assert.assertEquals("(b c)", parser.lookFor("(", ")", true));
    Assert.assertEquals("dd", parser.next());

    parser.reset(0);
    Assert.assertEquals("(b c)", parser.lookFor("(", ")", false));
    Assert.assertEquals("?", parser.next());
    Assert.assertEquals("dd", parser.next());
    
  }
  
  @Test
  public void lookFor_multiple()
  {
    parser.load("a (b c) dd (e)");
    Assert.assertEquals("(b c)", parser.lookFor("(", ")", true));
    Assert.assertEquals("(e)", parser.lookFor("(",")",true));
    Assert.assertEquals(null, parser.lookFor("(",")",true));
  }
  
  @Test
  public void replace()
  {
    parser.load("a bbb c de");
    parser.next();
    parser.next();
    parser.replace("BB");
    Assert.assertEquals("a BB c de",parser.getText());
    Assert.assertEquals("a BB[ ]c de",parser.toString());
    
    Assert.assertEquals("BB",parser.name());
    Assert.assertEquals("c",parser.next());
    
    parser.reset(0);
    Assert.assertEquals("a",parser.next());
    Assert.assertEquals("BB",parser.next());
    Assert.assertEquals("c",parser.next());
    Assert.assertEquals("de",parser.next());
    Assert.assertEquals(null,parser.next());
  }  
  
  @Test
  public void replace_Middle()
  {
    parser.load("class Blah {} class  NewClass    { }");
    parser.nextUntil(false, "class");
    parser.nextAt("class");
    parser.next();
    Assert.assertEquals("Blah",parser.name());
    parser.next();
    parser.nextAt("class");
    parser.next();
    Assert.assertEquals("NewClass",parser.name());
    Assert.assertEquals("class Blah {} class  NewClass    [{] }", parser.toString());
    
    parser.replace("Student");
    Assert.assertEquals("Student",parser.name());
    Assert.assertEquals("class Blah {} class  Student    { }", parser.getText());
  }

  @Test
  public void replace_End()
  {
    parser.load("class Blah {} class  NewClass");
    parser.nextUntil(false, "class");
    parser.nextAt("class");
    parser.next();
    Assert.assertEquals("Blah",parser.name());
    parser.next();
    parser.nextAt("class");
    parser.next();
    Assert.assertEquals("NewClass",parser.name());

    parser.replace("Student");
    Assert.assertEquals("Student",parser.name());
    Assert.assertEquals("class Blah {} class  Student", parser.getText());
  }
  

  @Test
  public void replace_NextToEnd()
  {
    parser.load("class Blah {} class  NewClass?");
    parser.nextUntil(false, "class");
    parser.nextAt("class");
    parser.next();
    Assert.assertEquals("Blah",parser.name());
    parser.next();
    parser.nextAt("class");
    parser.nextUntil("?");
    Assert.assertEquals("NewClass",parser.name());

    parser.replace("Student");
    Assert.assertEquals("Student",parser.name());
    Assert.assertEquals("class Blah {} class  Student?", parser.getText());
  }  
  
  @Test
  public void insert_start()
  {
    parser.load("class Blah {} class  NewClass{}");
    Assert.assertEquals("[c]lass Blah {} class  NewClass{}",parser.toString());
    parser.insert("interface X {}");
    Assert.assertEquals("interface X {}class Blah {} class  NewClass{}",parser.getText());
    Assert.assertEquals("interface X {}[c]lass Blah {} class  NewClass{}",parser.toString());
    Assert.assertEquals("class",parser.next());
  }

  @Test
  public void insert_middle()
  {
    parser.load("class Blah {} class  NewClass{}");
    parser.nextAfter("}");
    Assert.assertEquals("class Blah {}[ ]class  NewClass{}",parser.toString());
    parser.insert("interface X {}");
    Assert.assertEquals("class Blah {}interface X {} class  NewClass{}",parser.getText());
    Assert.assertEquals("class Blah {}interface X {}[ ]class  NewClass{}",parser.toString());
    Assert.assertEquals("class",parser.next());
    Assert.assertEquals("NewClass{}",parser.next());
  }  
  
  @Test
  public void insert_end()
  {
    parser.load("class Blah {} class  NewClass{}");
    parser.nextAfter("}");
    parser.nextAfter("}");
    Assert.assertEquals("class Blah {} class  NewClass{}[]",parser.toString());
    parser.insert("interface X {}");
    Assert.assertEquals("class Blah {} class  NewClass{}interface X {}",parser.getText());
    Assert.assertEquals("class Blah {} class  NewClass{}interface X {}[]",parser.toString());
    Assert.assertEquals(null,parser.next());
  }  
  
  @Test
  public void insertAfter_start()
  {
    parser.load("class Blah {} class  NewClass{}");
    Assert.assertEquals("[c]lass Blah {} class  NewClass{}",parser.toString());
    parser.insertAfter(null,"interface X {}");
    Assert.assertEquals("interface X {}class Blah {} class  NewClass{}",parser.getText());
    Assert.assertEquals("interface X {}[c]lass Blah {} class  NewClass{}",parser.toString());
    Assert.assertEquals("class",parser.next());
  }  
  
  @Test
  public void insertAfter_noSubTokens_middle()
  {
    parser.load("class Blah {} class  NewClass{}");
    parser.nextAfter("}");
    Assert.assertEquals("class Blah {}[ ]class  NewClass{}",parser.toString());
    Token t = new Token("x","{}");
    t.setPosition(new Position(1,11,11));
    parser.insertAfter(t,"this is new text");
    Assert.assertEquals("class Blah {}this is new text class  NewClass{}",parser.getText());
    Assert.assertEquals("class Blah {}this is new text[ ]class  NewClass{}",parser.toString());
    Assert.assertEquals("class",parser.next());
    Assert.assertEquals("NewClass{}",parser.next());
  }   
  
  @Test
  public void insertAfter_subTokens_middle()
  {
    parser.load("class Blah {} class  NewClass{}");
    parser.nextAfter("}");
    Assert.assertEquals("class Blah {}[ ]class  NewClass{}",parser.toString());
    Token t = new Token("x","START_TOKEN");
    t.setPosition(new Position(1,0,0));
    
    Token subT = new Token("y","class");
    subT.setPosition(new Position(1,0,0));
    t.addSubToken(subT);
    
    subT = new Token("z","Blah");
    subT.setPosition(new Position(1,6,6));
    t.addSubToken(subT);
    
    subT = new Token("p","{}");
    subT.setPosition(new Position(1,11,11));
    t.addSubToken(subT);
    
    parser.insertAfter(t,"this is new text");
    Assert.assertEquals("class Blah {}this is new text class  NewClass{}",parser.getText());
    Assert.assertEquals("class Blah {}this is new text[ ]class  NewClass{}",parser.toString());
    Assert.assertEquals("class",parser.next());
    Assert.assertEquals("NewClass{}",parser.next());
  }  
  
  @Test
  public void lookForThenReplace_nothingAfterBrackets()
  {
    parser.load("a (bbb) c de");
    parser.lookFor("(",")",true);
    parser.replace("[[BLAH]]");
    Assert.assertEquals("a [[BLAH]] c de", parser.getText());
  }  

  @Test
  public void replaceNothingParsedYet()
  {
    parser.load("a bbb c de");
    parser.replace("BB");
    Assert.assertEquals("a",parser.next());
    Assert.assertEquals("bbb",parser.next());
    Assert.assertEquals("c",parser.next());
    Assert.assertEquals("de",parser.next());
    Assert.assertEquals(null,parser.next());
  }  
  
  @Test
  public void toString_convertNewlines()
  {
    parser.load("a bbb\n c de");
    Assert.assertEquals("[a] bbb_ c de", parser.toString());
    parser.next();
    Assert.assertEquals("a [b]bb_ c de", parser.toString());
    parser.next();
    Assert.assertEquals("a bbb_ [c] de", parser.toString());
    parser.next();
    Assert.assertEquals("a bbb_ c [d]e", parser.toString());
    parser.next();
    Assert.assertEquals("a bbb_ c de[]", parser.toString());
    
  }
  
  @Test
  public void nextAfter()
  {
    parser.load("a=b");
    Assert.assertEquals("a=",parser.nextAfter("="));
    Assert.assertEquals("a=",parser.name());
    Assert.assertEquals("b",parser.next());
  }
  
  @Test
  public void nextAfterIndexesOkay()
  {
    parser.load("a b=1 c");
    parser.next();
    Assert.assertEquals("b=",parser.nextAfter("="));
    Assert.assertEquals("b=",parser.name());
    Assert.assertEquals(4,parser.currentIndex());
    Assert.assertEquals(2,parser.previousIndex());
  }  
  
  @Test
  public void nextAfterDoesNotExist()
  {
    parser.load("a b=1 c");
    parser.next();
    Assert.assertEquals("b=1 c",parser.nextAfter(";"));
    Assert.assertEquals(7,parser.currentIndex());
    Assert.assertEquals(2,parser.previousIndex());
  }  
  
  @Test
  public void extractFrom_start()
  {
    parser.load("a b=1 c");
    Assert.assertEquals(null,parser.extractFrom(0));
  }
  
  @Test
  public void extractFromStart()
  {
    parser.load("a b=1 c");
    parser.next();
    Assert.assertEquals("a",parser.extractFrom(0));
    parser.next();
    Assert.assertEquals("a b=1",parser.extractFrom(0));
    parser.next();
    Assert.assertEquals("a b=1 c",parser.extractFrom(0));
    parser.next();
    Assert.assertEquals("a b=1 c",parser.extractFrom(0));
  }  
  
  @Test
  public void extractFromMiddle()
  {
    parser.load("a b=1 c");
    parser.next();
    Assert.assertEquals(null,parser.extractFrom(1));
    parser.next();
    Assert.assertEquals("b=1",parser.extractFrom(1));
    Assert.assertEquals("b=1",parser.extractFrom(2));
    parser.next();
    Assert.assertEquals("=1 c",parser.extractFrom(3));
    parser.next();
    Assert.assertEquals("=1 c",parser.extractFrom(3));
  }  

  @Test
  public void nextVariable()
  {
    parser.load("a:b1?c_1+=d_b=3");
    Assert.assertEquals("a",parser.nextVariable());
    Assert.assertEquals("a",parser.name());
    Assert.assertEquals(":",parser.nextVariable());
    Assert.assertEquals(":",parser.name());
    Assert.assertEquals("b1",parser.nextVariable());
    Assert.assertEquals("b1",parser.name());
    Assert.assertEquals("?",parser.nextVariable());
    Assert.assertEquals("?",parser.name());
    Assert.assertEquals("c_1",parser.nextVariable());
    Assert.assertEquals("c_1",parser.name());
    Assert.assertEquals("+=",parser.nextVariable());
    Assert.assertEquals("+=",parser.name());
    Assert.assertEquals("d_b",parser.nextVariable());
    Assert.assertEquals("d_b",parser.name());
    Assert.assertEquals("=",parser.nextVariable());
    Assert.assertEquals("=",parser.name());
    Assert.assertEquals("3",parser.nextVariable());
    Assert.assertEquals("3",parser.name());
    
    
  }
  
  @Test
  public void getPosition_start()
  {
    parser.load("a = b");
    Assert.assertEquals(new Position(1,0,0), parser.currentPosition());
  }
  
  @Test
  public void getPosition_firstLine()
  {
    parser.load("a = b");
    parser.next();
    Assert.assertEquals(new Position(1,2,2),parser.currentPosition());
  }

  @Test
  public void getPosition_multiLines()
  {
    parser.load("a = b\na = c\na  = ddd");
    parser.next();
    parser.next();
    parser.next();
    Assert.assertEquals(new Position(2,0,6),parser.currentPosition());
    parser.next();
    Assert.assertEquals(new Position(2,2,8),parser.currentPosition());
    parser.next();
    Assert.assertEquals(new Position(2,4,10),parser.currentPosition());
    parser.next();
    Assert.assertEquals(new Position(3,0,12),parser.currentPosition());
    parser.next();
    Assert.assertEquals(new Position(3,3,15),parser.currentPosition());
    parser.next();
    Assert.assertEquals(new Position(3,5,17),parser.currentPosition());
    parser.next();
    Assert.assertEquals(new Position(3,8,20),parser.currentPosition());
  }
  
  @Test
  public void skipWhitespace()
  {
    parser.load("   a = b  c");
    parser.skipWhitespace();
    Assert.assertEquals(new Position(1,3,3),parser.currentPosition());
  }
  
}
