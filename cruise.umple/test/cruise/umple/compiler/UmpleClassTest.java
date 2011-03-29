package cruise.umple.compiler;

import java.util.*;

import org.junit.*;

import cruise.umple.compiler.exceptions.UmpleCompilerException;

public class UmpleClassTest
{
  private UmpleClass umpleClass;

  @Before
  public void setUp() throws Exception
  {
    umpleClass = new UmpleClass("xx");
  }

  @After
  public void tearDown()
  {
    umpleClass = null;
  }

  @Test
  public void Constructor_fileName() throws Exception
  {
    HashMap<String,String> codeInjectionMap = new HashMap<String,String>();
    codeInjectionMap.put("a", "b");
    codeInjectionMap.get("a");
    codeInjectionMap.containsKey("a");
    
    Assert.assertEquals("xx", umpleClass.getName());
  }

  @Test
  public void Constructor_packageSetting() throws Exception
  {
    Assert.assertEquals("", umpleClass.getPackageName());
  }

  @Test
  public void addAttribute_WithAttributeVar()
  {
    int valsBefore = umpleClass.getAttributes().size();
    umpleClass.addAttribute(new Attribute("asd", "sad", "immutable", "asd", false));
    Assert.assertEquals(valsBefore + 1, umpleClass.getAttributes().size());
  }

  @Test
  public void addExtends()
  {
    UmpleClass booking = new UmpleClass("Booking");
    umpleClass.setExtendsClass(booking);
    Assert.assertEquals("Booking", umpleClass.getExtendsClass().getName());
  }

  @Test
  public void getAssociationVariableByName()
  {
    AssociationVariable v = new AssociationVariable("aMentor","Mentor",null,"1",createMultiplicity(1,1),true);
    umpleClass.addAssociationVariable(v);
    
    Assert.assertEquals(v,umpleClass.getAssociationVariable("aMentor"));
    Assert.assertEquals(null,umpleClass.getAssociationVariable("aSomethingElse"));
  }

  
  @Test
  public void getAttributeByName()
  {
    Attribute v = new Attribute("aName",null,null,null,false);
    umpleClass.addAttribute(v);
    Assert.assertEquals(v,umpleClass.getAttribute("aName"));
    Assert.assertEquals(null,umpleClass.getAttribute("aSomethingElse"));
  }
  
  @Test
  public void makeSingleton_AddingOfStaticVariable() throws UmpleCompilerException
  {
    int count = umpleClass.getAssociationVariables().size();
    umpleClass.setIsSingleton(true);
    Assert.assertEquals(true,umpleClass.getIsSingleton());
    Assert.assertEquals(count, umpleClass.getAssociationVariables().size());
  }

 
  @Test
  public void DoNotNeedAnUmpleFile()
  {
    UmpleModel model = new UmpleModel(null);
    UmpleClass c = model.addUmpleClass("Student");
    Assert.assertEquals("Student",c.getName());
    Assert.assertEquals("",c.getPackageName());
  }

  @Test
  public void setPackageName()
  {
    UmpleModel model = new UmpleModel(null);
    UmpleClass c = model.addUmpleClass("Student");
    Assert.assertEquals("Student",c.getName());
    Assert.assertEquals("",c.getPackageName());
    
    c.setPackageName("");
    Assert.assertEquals("", c.getPackageName());

    c.setPackageName("abc");
    Assert.assertEquals("abc", c.getPackageName());

    Assert.assertEquals(false,c.setPackageName(null));
    Assert.assertEquals("abc", c.getPackageName());

  }
  /*
   * @Test public void runPregenOps_NormalCase() throws UmpleCompilerException {
   * Assert.assertNull(umpleClass.getGeneratedClass());
   * 
   * 
   * umpleClass.runPregenOps(Template.newJavaTemplate(),"cruise.umple.compiler.java"
   * ); Assert.assertNotNull(umpleClass.getGeneratedClass()); }
   */

  /*
   * @Test(expected = UmpleCompilerException.class) public void
   * runPregenOps_ExceptionalCase() throws UmpleCompilerException {
   * umpleClass.runPregenOps(null, null); }
   */

  @Test
  public void getName_Normal()
  {
    umpleClass = new UmpleClass("Booking");
    Assert.assertEquals("Booking", umpleClass.getName());
  }

  @Test
  public void getPackageName_Normal()
  {
    Assert.assertEquals("", umpleClass.getPackageName());
  }

  @Test
  public void setPackageName_OkayToSetEmpty()
  {
    Assert.assertTrue(umpleClass.setPackageName(""));
  }

  @Test
  public void setPackageName_ExceptionalCase2()
  {
    Assert.assertFalse(umpleClass.setPackageName(null));
  }

  @Test
  public void addReferencedPackage()
  {
    umpleClass.addReferencedPackage("abc");
    umpleClass.addReferencedPackage("def");
    
    String[] references = umpleClass.getNamespaces();
    Assert.assertEquals(2,references.length);
    Assert.assertEquals("abc", references[0]);
    Assert.assertEquals("def", references[1]);
  }
  
  @Test
  public void addReferencedPackage_doNotAddDuplicate()
  {
    umpleClass.addReferencedPackage("abc");
    umpleClass.addReferencedPackage("def");
    umpleClass.addReferencedPackage("abc");
    
    String[] references = umpleClass.getNamespaces();
    Assert.assertEquals(2,references.length);
    Assert.assertEquals("abc", references[0]);
    Assert.assertEquals("def", references[1]);
  }
  
  @Test
  public void addReferencedPackage_doNotAddMyOwn()
  {
    umpleClass.setPackageName("abc");
    umpleClass.addReferencedPackage("abc");
    
    String[] references = umpleClass.getNamespaces();
    Assert.assertEquals(0,references.length);
  }
  
  @Test
  public void getReferencedPackages()
  {
    Assert.assertEquals(0,umpleClass.getNamespaces().length);
  }
  
  @Test
  public void isAttributeClass_simple()
  {
    Assert.assertEquals(true, umpleClass.isAttributeClass());
    umpleClass.addAttribute(new Attribute("aName","aType",null,"",false));
    Assert.assertEquals(true, umpleClass.isAttributeClass());
  }
  
  @Test
  public void isAttributeClass_navigableAssociation()
  {
    umpleClass.addAssociationVariable(new AssociationVariable("aName","aType","aMod","aVal",createMultiplicity(0,-1),true));
    Assert.assertEquals(false, umpleClass.isAttributeClass());
  }
  
  @Test
  public void isAttributeClass_oneWayAssociation()
  {
    umpleClass.addAssociationVariable(new AssociationVariable("aName","aType","aMod","aVal",createMultiplicity(0,-1),false));
    Assert.assertEquals(true, umpleClass.isAttributeClass());
  }
  
  @Test
  public void doNotAllowDuplicateDepends()
  {
    umpleClass.addDepend(new Depend("a"));
    Assert.assertEquals(1,umpleClass.numberOfDepends());
    umpleClass.addDepend(new Depend("b"));
    Assert.assertEquals(2,umpleClass.numberOfDepends());
    umpleClass.addDepend(new Depend("a"));
    Assert.assertEquals(2,umpleClass.numberOfDepends());
  }

  @Test
  public void findOrCreateEvent_New()
  {
    StateMachine sm = new StateMachine("sm");
    sm.setUmpleClass(umpleClass);
    Event e1 = umpleClass.findOrCreateEvent("e1");
    Assert.assertEquals("e1",e1.getName());
  }

  
  @Test
  public void findOrCreateEvent_NewBecauseNotAssociatedToAnyStateMachine()
  {
    StateMachine sm = new StateMachine("sm");
    sm.setUmpleClass(umpleClass);
    
    Event e1 = umpleClass.findOrCreateEvent("e1");
    Event e2 = umpleClass.findOrCreateEvent("e1");
    
    Assert.assertEquals("e1",e1.getName());
    Assert.assertEquals("e1",e2.getName());
    Assert.assertNotSame(e1, e2);
  }
  
  @Test
  public void findOrCreateEvent_Existing()
  {
    StateMachine sm2 = new StateMachine("sm2");
    sm2.setUmpleClass(umpleClass);

    StateMachine sm = new StateMachine("sm");
    sm.setUmpleClass(umpleClass);
    
    Event e1 = umpleClass.findOrCreateEvent("e1");
    State s1 = new State("s1",sm);
    State s2 = new State("s2",sm);
    Transition t1 = new Transition(s1, s2);
    t1.setEvent(e1);
    
    Event alsoE1 = umpleClass.findOrCreateEvent("e1");
    
    Assert.assertEquals("e1",e1.getName());
    Assert.assertEquals("e1",alsoE1.getName());
    Assert.assertSame(e1, alsoE1);
  }
  
  @Test
  public void findOrCreateEvent_NoStateMachines()
  {
    Assert.assertEquals(0, umpleClass.numberOfStateMachines());
    Event e = umpleClass.findOrCreateEvent("blah");
    Assert.assertEquals("blah",e.getName());
  }

  @Test
  public void findOrCreateEvent_InvalidInput()
  {
    Event e = umpleClass.findOrCreateEvent(null);
    Assert.assertEquals(null,e);
    
    StateMachine sm = new StateMachine("sm");
    sm.setUmpleClass(umpleClass);
    Event e1 = new Event(null);
    State s1 = new State("s1",sm);
    State s2 = new State("s2",sm);
    Transition t1 = new Transition(s1, s2);
    t1.setEvent(e1);
    
    Event e2 = umpleClass.findOrCreateEvent("blah");
    Assert.assertEquals("blah",e2.getName());
  } 
  
  @Test
  public void getEvents_noStateMachines()
  {
    Assert.assertEquals(0,umpleClass.getEvents().size());  
  }

  @Test
  public void getEvents_none()
  {
    StateMachine sm = new StateMachine("sm");
    sm.setUmpleClass(umpleClass);
    Assert.assertEquals(0,umpleClass.getEvents().size());
  }
  
  @Test
  public void getEvents_fromAllStateMachines()
  {
    StateMachine sm = new StateMachine("sm");
    sm.setUmpleClass(umpleClass);

    StateMachine sm2 = new StateMachine("sm2");
    sm2.setUmpleClass(umpleClass);
    
    Event flip = new Event("flip");
    Event push = new Event("push");
    
    State s1 = new State("s1",sm);
    State s2 = new State("s2",sm);
    Transition t1 = new Transition(s1, s2);
    t1.setEvent(flip);
    
    State s3 = new State("s3",sm2);
    State s4 = new State("s4",sm2);
    Transition t2 = new Transition(s3, s4);
    t2.setEvent(push);

    Transition t3 = new Transition(s4, s3);
    t3.setEvent(flip);

    List<Event> actual = umpleClass.getEvents();
    Assert.assertEquals(2,actual.size());
    Assert.assertEquals(flip,actual.get(0));
    Assert.assertEquals(push,actual.get(1));
  }
  
  @Test
  public void getEvents_fromNestedStateMachines()
  {
    StateMachine sm = new StateMachine("sm");
    sm.setUmpleClass(umpleClass);

    Event flip = new Event("flip");
    Event push = new Event("push");
    
    State s1 = new State("s1",sm);
    State s2 = new State("s2",sm);
    Transition t1 = new Transition(s1, s2);
    t1.setEvent(flip);

    StateMachine sm2 = new StateMachine("sm2");
    sm2.setParentState(s1);
    
    State s3 = new State("s3",sm2);
    State s4 = new State("s4",sm2);
    Transition t2 = new Transition(s3, s4);
    t2.setEvent(push);

    Transition t3 = new Transition(s4, s3);
    t3.setEvent(flip);

    Assert.assertEquals(2,umpleClass.getAllStateMachines().size());
    
    List<Event> actual = umpleClass.getEvents();
    Assert.assertEquals(2,actual.size());
    Assert.assertEquals(flip,actual.get(0));
    Assert.assertEquals(push,actual.get(1));
  }  
  
  @Test
  public void getStateMachinesFromEvent_some()
  {
    StateMachine sm = new StateMachine("sm");
    sm.setUmpleClass(umpleClass);

    StateMachine sm2 = new StateMachine("sm2");
    sm2.setUmpleClass(umpleClass);
    
    Event flip = new Event("flip");
    Event push = new Event("push");
    
    State s1 = new State("s1",sm);
    State s2 = new State("s2",sm);
    Transition t1 = new Transition(s1, s2);
    t1.setEvent(flip);
    
    State s3 = new State("s3",sm2);
    State s4 = new State("s4",sm2);
    Transition t2 = new Transition(s3, s4);
    t2.setEvent(push);

    Transition t3 = new Transition(s4, s3);
    t3.setEvent(flip);
    
    List<StateMachine> allSms = umpleClass.getStateMachines(flip);
    Assert.assertEquals(2, allSms.size());
    Assert.assertEquals(sm, allSms.get(0));
    Assert.assertEquals(sm2, allSms.get(1));
    
    allSms = umpleClass.getStateMachines(push);
    Assert.assertEquals(1, allSms.size());
    Assert.assertEquals(sm2, allSms.get(0));
  }

  @Test
  public void getStateMachinesFromEvent_nested()
  {
    StateMachine sm = new StateMachine("sm");
    sm.setUmpleClass(umpleClass);

    Event flip = new Event("flip");
    Event push = new Event("push");
    
    State s1 = new State("s1",sm);
    State s2 = new State("s2",sm);
    Transition t1 = new Transition(s1, s2);
    t1.setEvent(flip);

    StateMachine sm2 = new StateMachine("sm2");
    sm2.setParentState(s1);
    
    State s3 = new State("s3",sm2);
    State s4 = new State("s4",sm2);
    Transition t2 = new Transition(s3, s4);
    t2.setEvent(push);

    Transition t3 = new Transition(s4, s3);
    t3.setEvent(flip);
    
    List<StateMachine> allSms = umpleClass.getStateMachines(flip);
    Assert.assertEquals(2, allSms.size());
    Assert.assertEquals(sm, allSms.get(0));
    Assert.assertEquals(sm2, allSms.get(1));
    
    allSms = umpleClass.getStateMachines(push);
    Assert.assertEquals(1, allSms.size());
    Assert.assertEquals(sm2, allSms.get(0));
  }

  @Test
  public void getStateMachinesFromEvent_none()
  {
    Event e = new Event("blah");
    Assert.assertEquals(0,umpleClass.getStateMachines(e).size());
  }
  
  @Test
  public void getCodeInjectionsFor_perfectMatch()
  {
    UmpleClass c = new UmpleClass("Student");
    CodeInjection code = new CodeInjection("before","myOpp","//the code");
    List<CodeInjection> allCodes;
    
    allCodes = c.getApplicableCodeInjections(null,"myOpp");
    Assert.assertEquals(0,allCodes.size());

    allCodes = c.getApplicableCodeInjections("before",null);
    Assert.assertEquals(0,allCodes.size());
    
    allCodes = c.getApplicableCodeInjections("before","myOpp");
    Assert.assertEquals(0,allCodes.size());
    

    c.addCodeInjection(code);

    allCodes = c.getApplicableCodeInjections("before","blah");
    Assert.assertEquals(0,allCodes.size());
    
    allCodes = c.getApplicableCodeInjections("after","myOpp");
    Assert.assertEquals(0,allCodes.size());
    
    allCodes = c.getApplicableCodeInjections("before","myOpp");
    Assert.assertEquals(1,allCodes.size());
    Assert.assertEquals(code,allCodes.get(0));
    
  }
  
  @Test
  public void getCodeInjectionsFor_supportStar()
  {
    UmpleClass c = new UmpleClass("Student");
    CodeInjection code = new CodeInjection("before","myOpp","//the code");
    CodeInjection code2 = new CodeInjection("before","yourOpp","//the code");
    CodeInjection code3 = new CodeInjection("before","*Opp","//the code");
    CodeInjection code4 = new CodeInjection("before","*Opp*","//the code");

    List<CodeInjection> allCodes;
        
    c.addCodeInjection(code);
    c.addCodeInjection(code2);
    c.addCodeInjection(code3);
    c.addCodeInjection(code4);

    allCodes = c.getApplicableCodeInjections("before","myOpp");
    Assert.assertEquals(3,allCodes.size());
    Assert.assertEquals(code,allCodes.get(0));
    Assert.assertEquals(code3,allCodes.get(1));

    allCodes = c.getApplicableCodeInjections("before","myOppStuff");
    Assert.assertEquals(1,allCodes.size());
  }  
  
  @Test
  public void getCodeInjectionsFor_supportDifferentNamingConvention()
  {
    UmpleClass c = new UmpleClass("Student");
    CodeInjection code = new CodeInjection("before","my_opp","//the code");

    List<CodeInjection> allCodes;
        
    c.addCodeInjection(code);

    allCodes = c.getApplicableCodeInjections("before","myOpp");
    Assert.assertEquals(1,allCodes.size());
    Assert.assertEquals(code,allCodes.get(0));

  }
  
  @Test
  public void getCodeInjectionsFor_commaDelimit()
  {
    List<CodeInjection> allCodes;
    UmpleClass c = new UmpleClass("Student");
    c.addCodeInjection(new CodeInjection("before","get*,setOne","//the code"));
    
    allCodes = c.getApplicableCodeInjections("before","getX");
    Assert.assertEquals(1,allCodes.size());
    Assert.assertEquals("//the code",allCodes.get(0).getCode());

    allCodes = c.getApplicableCodeInjections("before","setOne");
    Assert.assertEquals(1,allCodes.size());
    Assert.assertEquals("//the code",allCodes.get(0).getCode());

    allCodes = c.getApplicableCodeInjections("before","setX");
    Assert.assertEquals(0,allCodes.size());
  }
  
  @Test
  public void getCodeInjectionsFor_multipleNots()
  {
    List<CodeInjection> allCodes;
    UmpleClass c = new UmpleClass("Student");
    c.addCodeInjection(new CodeInjection("before","!constructor,!set*","//a1"));

    allCodes = c.getApplicableCodeInjections("before","constructor");
    Assert.assertEquals(0,allCodes.size());

    allCodes = c.getApplicableCodeInjections("before","setSomething");
    Assert.assertEquals(0,allCodes.size());

    allCodes = c.getApplicableCodeInjections("before","getSomething");
    Assert.assertEquals(1,allCodes.size());
    Assert.assertEquals("//a1",allCodes.get(0).getCode());

    
  }
  
  @Test
  public void getCodeInjectionsFor_notNotation()
  {
    List<CodeInjection> allCodes;
    UmpleClass c = new UmpleClass("Student");
    c.addCodeInjection(new CodeInjection("before","get*,!getX","//a1"));
    c.addCodeInjection(new CodeInjection("before","!get*,getX","//a2"));
    c.addCodeInjection(new CodeInjection("before","!getY","//b"));
    c.addCodeInjection(new CodeInjection("before","!getZ,getZ2*","//c"));
    c.addCodeInjection(new CodeInjection("before","!","//d"));
    
    allCodes = c.getApplicableCodeInjections("before","getX");
    Assert.assertEquals(3,allCodes.size());
    Assert.assertEquals("//a2",allCodes.get(0).getCode());
    Assert.assertEquals("//b",allCodes.get(1).getCode());
    Assert.assertEquals("//d",allCodes.get(2).getCode());

    allCodes = c.getApplicableCodeInjections("before","getY");
    Assert.assertEquals(2,allCodes.size());
    Assert.assertEquals("//a1",allCodes.get(0).getCode());
    Assert.assertEquals("//d",allCodes.get(1).getCode());

    allCodes = c.getApplicableCodeInjections("before","getZ");
    Assert.assertEquals(3,allCodes.size());
    Assert.assertEquals("//a1",allCodes.get(0).getCode());
    Assert.assertEquals("//b",allCodes.get(1).getCode());
    Assert.assertEquals("//d",allCodes.get(2).getCode());

    allCodes = c.getApplicableCodeInjections("before","getZ2b");
    Assert.assertEquals(4,allCodes.size());
    Assert.assertEquals("//a1",allCodes.get(0).getCode());
    Assert.assertEquals("//b",allCodes.get(1).getCode());
    Assert.assertEquals("//c",allCodes.get(2).getCode());
    Assert.assertEquals("//d",allCodes.get(3).getCode());
    
    allCodes = c.getApplicableCodeInjections("before","setX");
    Assert.assertEquals(2,allCodes.size());
    Assert.assertEquals("//b",allCodes.get(0).getCode());
    Assert.assertEquals("//d",allCodes.get(1).getCode());
  }
  
  @Test
  public void getAllStateMachines_none()
  {
    Assert.assertEquals(0,umpleClass.getAllStateMachines().size());
  }
  
  @Test
  public void getAllStateMachines_oneLevel()
  {
    umpleClass.addStateMachine(new StateMachine("x"));
    umpleClass.addStateMachine(new StateMachine("y"));
    Assert.assertEquals(2,umpleClass.getAllStateMachines().size());
  }
  
  @Test
  public void getAllStateMachines_multiLevel()
  {
    StateMachine sm = new StateMachine("x");
    StateMachine sm2 = new StateMachine("y");
    StateMachine sm3 = new StateMachine("z");
    StateMachine sm4 = new StateMachine("q");

    umpleClass.addStateMachine(sm);
    
    State s = new State("One",sm);
    s.setNestedStateMachine(sm2);
    
    State s2 = new State("Two",sm2);
    s2.setNestedStateMachine(sm3);
    
    State s3 = new State("Two",sm3);
    s3.setNestedStateMachine(sm4);

    Assert.assertEquals(4,umpleClass.getAllStateMachines().size());
  }  
  
  private Multiplicity createMultiplicity(int lower, int upper)
  {
    Multiplicity m = new Multiplicity();
    m.setRange(lower + "", upper + "");
    return m;
  }
}
