package cruise.umple.compiler;

import org.junit.*;

public class TokenTest
{

  
  @Test
  public void is_empty()
  {
    Token t = new Token(null,null);
    Assert.assertEquals(true,t.is(""));
    Assert.assertEquals(false,t.is(null));
    Assert.assertEquals(false,t.is("blah"));
  }

  @Test
  public void is_notEmpty()
  {
    Token t = new Token("aha",null);
    Assert.assertEquals(false,t.is(""));
    Assert.assertEquals(false,t.is(null));
    Assert.assertEquals(false,t.is("blah"));
    Assert.assertEquals(true,t.is("aha"));
    Assert.assertEquals(false,t.is("aHA"));
  }
  
  @Test
  public void is_ignoreStatus()
  {
    Token t = new Token(";","STATIC");
    Assert.assertEquals(false,t.is(";"));
  }  

  @Test
  public void isStatic_ignoreStatus()
  {
    Token t = new Token(";","STATIC");
    Assert.assertEquals(true,t.isStatic());
    
    t = new Token(";",";");
    Assert.assertEquals(false,t.isStatic());
  }  

  @Test
  public void isStatic_basedOnTheName()
  {
    Token t = new Token(";","STATIC");
    
    Assert.assertEquals(true,t.isStatic(";"));
    Assert.assertEquals(false,t.isStatic("blah"));
    
    t = new Token(";",";");
    Assert.assertEquals(false,t.isStatic(";"));
    Assert.assertEquals(false,t.isStatic("blah"));
  }  

  @Test
  public void isValue_empty()
  {
    Token t = new Token("aha",null);
    Assert.assertEquals(false,t.isValue("on"));
    Assert.assertEquals(false,t.isValue(null));
    Assert.assertEquals(true,t.isValue(""));
  }
  
  @Test
  public void isValue_notEmpty()
  {
    Token t = new Token("aha","on");
    Assert.assertEquals(true,t.isValue("on"));
    Assert.assertEquals(false,t.isValue("oN"));
    Assert.assertEquals(false,t.isValue("blah"));
    Assert.assertEquals(false,t.isValue(""));
    Assert.assertEquals(false,t.isValue(null));
  }

  @Test
  public void getValueSelf()
  {
    Token t = new Token("program","START");
    t.addSubToken(new Token("type","String"));
    t.addSubToken(new Token("name","Student"));
    
    Assert.assertEquals("START",t.getValue("program"));
  }
  
  @Test
  public void getIntValue()
  {
    Token t = new Token("program","1");
    t.addSubToken(new Token("type","2"));
    t.addSubToken(new Token("name","3"));
    t.addSubToken(new Token("ignore","garble"));
    
    Assert.assertEquals(1,t.getIntValue("program"));
    Assert.assertEquals(2,t.getIntValue("type"));
    Assert.assertEquals(3,t.getIntValue("name"));
    Assert.assertEquals(0,t.getIntValue("ignore"));
    Assert.assertEquals(0,t.getIntValue("unknown"));
  } 
  
  @Test
  public void getIntValue_default()
  {
    Token t = new Token("program","1");
    t.addSubToken(new Token("type","2"));
    t.addSubToken(new Token("name","3"));
    t.addSubToken(new Token("ignore","garble"));
    
    Assert.assertEquals(1,t.getIntValue("program",3));
    Assert.assertEquals(2,t.getIntValue("type",4));
    Assert.assertEquals(3,t.getIntValue("name",5));
    Assert.assertEquals(6,t.getIntValue("ignore",6));
    Assert.assertEquals(7,t.getIntValue("unknown",7));
  } 

  @Test
  public void getPositionInvalidTokenName()
  {
    Token t = new Token("program","START");
    t.setPosition(new Position(4,5,11));
    t.addSubToken(new Token("type","String"));
    t.addSubToken(new Token("name","Student"));
    
    Assert.assertEquals(null,t.getPosition("blah"));
  }

  
  @Test
  public void getPositionNone()
  {
    Token t = new Token("program","START");
    t.addSubToken(new Token("type","String"));
    t.addSubToken(new Token("name","Student"));
    
    Assert.assertEquals(null,t.getPosition("program"));
  }
  
  @Test
  public void getPositionSelf()
  {
    Token t = new Token("program","START");
    t.setPosition(new Position(4,5,11));
    t.addSubToken(new Token("type","String"));
    t.addSubToken(new Token("name","Student"));
    
    Assert.assertEquals(new Position(4,5,11),t.getPosition("program"));
  }
  
  @Test
  public void getPositionOnlyLookAtDirectSiblings()
  {
    Token t = new Token("program","START");
    Token t2 = new Token("name","Yes");
    Token t3 = new Token("name","No");
    Token t4 = new Token("type","String");
    
    t.setPosition(new Position(1,5,11));
    t2.setPosition(new Position(2,6,12));
    t3.setPosition(new Position(3,7,13));
    t4.setPosition(new Position(4,8,14));
    
    t.addSubToken(t2);
    t2.addSubToken(t3);
    t2.addSubToken(t4);
    
    Assert.assertEquals(new Position(2,6,12),t.getPosition("name"));
    Assert.assertEquals(null,t.getValue("type"));
    Assert.assertEquals(new Position(4,8,14),t2.getPosition("type"));
  }  
  
  @Test
  public void getValueOnlyLookAtDirectSiblings()
  {
    Token t = new Token("program","START");
    Token t2 = new Token("name","Yes");
    Token t3 = new Token("name","No");
    Token t4 = new Token("type","String");
    
    t.addSubToken(t2);
    t2.addSubToken(t3);
    t2.addSubToken(t4);
    
    Assert.assertEquals("Yes",t.getValue("name"));
    Assert.assertEquals(null,t.getValue("type"));
    Assert.assertEquals("String",t2.getValue("type"));
  }

  @Test
  public void addSubTokenByIndex()
  {
    Token t = new Token("program","START");
    t.addSubToken(new Token("last","a"));
    t.addSubToken(0,new Token("middle","b"));
    t.addSubToken(0,new Token("first","c"));
    
    Assert.assertEquals("first",t.getSubToken(0).getName());
  }
  
  @Test
  public void addSubTokenByName()
  {
    Token t = new Token("program","START");
    t.addSubToken(new Token("last","a"));
    t.addSubToken(0,new Token("middle","b"));
    t.addSubToken(0,new Token("first","c"));
    
    Assert.assertEquals("first",t.getSubToken("first").getName());
    Assert.assertEquals("middle",t.getSubToken("middle").getName());
    Assert.assertEquals("last",t.getSubToken("last").getName());
    Assert.assertEquals(null,t.getSubToken("blah"));
  }  

  @Test
  public void getValueSubToken()
  {
    Token t = new Token("program","START");
    t.addSubToken(new Token("type","String"));
    t.addSubToken(new Token("name","Student"));
    
    Assert.assertEquals("String",t.getValue("type"));
    Assert.assertEquals("Student",t.getValue("name"));
  }
  
  @Test
  public void numberOfSubTokens()
  {
    Token t = new Token("program","START");
    Assert.assertEquals(0,t.numberOfSubTokens());

    t.addSubToken(new Token("type","String"));
    Assert.assertEquals(1,t.numberOfSubTokens());
    
    t.addSubToken(new Token("name","Student"));
    Assert.assertEquals(2,t.numberOfSubTokens());
    
  }
  
  @Test
  public void getSubToken()
  {
    Token t = new Token("program","START");
    Assert.assertEquals(0,t.numberOfSubTokens());

    t.addSubToken(new Token("type","String"));
    Assert.assertEquals("type",t.getSubToken(0).getName());
    
    t.addSubToken(new Token("name","Student"));
    Assert.assertEquals("type",t.getSubToken(0).getName());
    Assert.assertEquals("name",t.getSubToken(1).getName());
  } 
  
  @Test
  public void getSubTokenIgnoreStatics()
  {
    Token t = new Token("program","START");
    t.addSubToken(new Token("type","STATIC"));
    t.addSubToken(new Token("type","String"));
    t.addSubToken(new Token("name","id"));
    t.addSubToken(new Token(";","STATIC"));
    
    Assert.assertEquals("String",t.getSubToken("type").getValue());
    Assert.assertEquals("id",t.getSubToken("name").getValue());
    Assert.assertEquals(null,t.getSubToken(";"));
  } 
  
  @Test
  public void getSubTokens()
  {
    Token t = new Token("program","START");
    Assert.assertEquals(0,t.getSubTokens().size());

    t.addSubToken(new Token("type","String"));
    Assert.assertEquals(1,t.getSubTokens().size());
    Assert.assertEquals("type",t.getSubTokens().get(0).getName());

  }
  
  @Test
  public void indexOfSubToken()
  {
    Token t = new Token("program","START");
    Token t2 = new Token("type","String");
    Token t3 = new Token("name","Student");
    t.addSubToken(t2);
    t.addSubToken(t3);
    
    Assert.assertEquals(0, t.indexOfSubToken(t2));
    Assert.assertEquals(1, t.indexOfSubToken(t3));
    Assert.assertEquals(-1, t.indexOfSubToken(new Token("blah","aha")));
  }   

  @Test
  public void remove()
  {
    Token t = new Token("program","START");
    Token t2 = new Token("type","String");
    Token t3 = new Token("name","Student");
    t.addSubToken(t2);
    t.addSubToken(t3);
    
    t.remove(-1);
    t.remove(3);
    
    t.remove(0);
    Assert.assertEquals(1, t.numberOfSubTokens());
    Assert.assertEquals(t3, t.getSubToken(0));
  }

  @Test
  public void TokenHasAPosition()
  {
    Token t = new Token("program","START");
    Assert.assertEquals(null,t.getPosition());
    
    Position p = new Position(1,3,3);
    t.setPosition(p);
    Assert.assertEquals(p,t.getPosition());
  }
  
  @Test
  public void getLength_noPosition()
  {
    Token t = new Token("p","START");
    Assert.assertEquals(5,t.getLength());
  }
  
  @Test
  public void getLength_noSiblings()
  {
    Token t = new Token("p","class what");
    t.setPosition(new Position(1,2,3));
    Assert.assertEquals(10,t.getLength());
  }
  
  @Test(expected=NullPointerException.class)
  public void getLength_siblingsButNoPosition()
  {
    Token parent = new Token("p","1");
    Token child1 = new Token("q","22");
    Token child2 = new Token("r","333");
    
    parent.addSubToken(child1);
    parent.addSubToken(child2);
    parent.getLength();
  }
  
  @Test
  public void getLength_siblingsAndPositions()
  {
    Token parent = new Token("p","1");
    Token child1 = new Token("q","22");
    Token child2 = new Token("r","333");
    Token end = new Token("s","");
    
    parent.setPosition(new Position(1,10,10));
    child1.setPosition(new Position(1,10,11));
    child2.setPosition(new Position(1,10,15));
    end.setPosition(new Position(1,10,20));
    
    parent.addSubToken(child1);
    parent.addSubToken(child2);
    parent.addSubToken(end);
    
    Assert.assertEquals(10,parent.getLength());
    Assert.assertEquals(4,child1.getLength());
    Assert.assertEquals(5,child2.getLength());
    Assert.assertEquals(0,end.getLength());
  }  
  
  @Test
  public void getLength_lastSibling()
  {
    Token grandParent = new Token("a","4444"); 
    Token parent = new Token("p","1");
    Token parent2 = new Token("p","55555");
    
    Token child1a = new Token("q","22");
    Token child1b = new Token("r","333");
    Token child2a = new Token("s","666666");
    Token end = new Token("end","");
    
    grandParent.setPosition(new Position(1,0,0));
    parent.setPosition(new Position(1,10,10));
    child1a.setPosition(new Position(1,22,22));
    child1b.setPosition(new Position(1,34,34));
    parent2.setPosition(new Position(1,50,50));
    child2a.setPosition(new Position(1,61,61));
    end.setPosition(new Position(1,75,75));
    
    grandParent.addSubToken(parent);
    grandParent.addSubToken(parent2);
    parent.addSubToken(child1a);
    parent.addSubToken(child1b);
    parent2.addSubToken(child2a);
    parent2.addSubToken(end);
    
    Assert.assertEquals(75,grandParent.getLength());
    Assert.assertEquals(40,parent.getLength());
    Assert.assertEquals(25,parent2.getLength());

    Assert.assertEquals(12,child1a.getLength());
    Assert.assertEquals(16,child1b.getLength());
    Assert.assertEquals(14,child2a.getLength());
    Assert.assertEquals(0,end.getLength());
  }  
  
  @Test
  public void getInnerLength_static()
  {
    Token t = new Token("class","STATIC");
    Assert.assertEquals(5,t.getInnerLength());
  }

  @Test
  public void getInnerLength_simple()
  {
    Token t = new Token("name","id");
    Assert.assertEquals(2,t.getInnerLength());
  }

  @Test
  public void getInnerLength_complex()
  {
    Token parent = new Token("p","START_TOKEN");
    Token child1a = new Token("q","22");
    Token child1b = new Token("r","333");
    
    parent.setPosition(new Position(1,10,10));
    child1a.setPosition(new Position(1,22,22));
    child1b.setPosition(new Position(1,34,34));
    
    parent.addSubToken(child1a);
    parent.addSubToken(child1b);

    Assert.assertEquals(27,parent.getInnerLength());
    
  }
  
  
  @Test
  public void getSubTokenByIndex_none()
  {
    Token t = new Token("a","1");
    Assert.assertEquals(null, t.getSubToken("x",0));
  }

  @Test
  public void getSubTokenByIndex_okay()
  {
    Token t = new Token("a","1");
    t.addSubToken(new Token("x","abc"));
    t.addSubToken(new Token("x","def"));
    t.addSubToken(new Token("y","123"));
    t.addSubToken(new Token("x","xyz"));
    t.addSubToken(new Token("q","abc"));
    
    Assert.assertEquals("abc", t.getSubToken("x",0).getValue());
    Assert.assertEquals("def", t.getSubToken("x",1).getValue());
    Assert.assertEquals("xyz", t.getSubToken("x",2).getValue());
    Assert.assertEquals(null, t.getSubToken("x",3));
  }
  
  

}
