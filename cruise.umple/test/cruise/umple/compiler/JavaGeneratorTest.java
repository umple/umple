/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import java.io.File;

import cruise.umple.compiler.java.JavaInterfaceGenerator;
import cruise.umple.util.SampleFileWriter;

import org.junit.*;

public class JavaGeneratorTest
{

  UmpleModel model;
  JavaGenerator generator;
  String umpleParserName;

  @Before
  public void setUp()
  {
    model = new UmpleModel(null);
    generator = new JavaGenerator();
    generator.setModel(model);
    umpleParserName = "cruise.umple.compiler.UmpleInternalParser";
  }
  
  @Test
  public void empty()
  {
    generator.prepare();
    
  }

  @Test
  public void addAutoTransitionEntryAction()
  {
    UmpleClass c = model.addUmpleClass("Student");
    StateMachine sm = new StateMachine("bulb");
    sm.setUmpleClass(c);
    State s1 = new State("s1",sm);
    State s2 = new State("s2",sm);
    
    s1.addAction(new Action("blah"));
    
    Transition t = new Transition(s1,s2);
    t.setAutoTransition(true);
    
    Event e = new Event("__myauto__");
    e.setAutoTransition(true);
    t.setEvent(e);
    
    generator.prepare();
    
    Assert.assertEquals(2, s1.numberOfActions());
    Action entryAction = s1.getAction(1);
    
    Assert.assertEquals("__myauto__();",entryAction.getActionCode());
    Assert.assertEquals("entry",entryAction.getActionType());
    Assert.assertEquals(true, entryAction.getIsInternal());
  }  
  
  @Test
  public void addDoActivityEntryAndExitActions()
  {
    UmpleClass c = model.addUmpleClass("Student");
    StateMachine sm = new StateMachine("bulb");
    sm.setUmpleClass(c);
    State s1 = new State("s1",sm);
    new Activity("blah",s1);
    
    generator.prepare();
    
    Assert.assertEquals(2,s1.numberOfActions());
    Action exitAction = s1.getAction(0);
    
    Assert.assertEquals("if (doActivityBulbS1Thread != null) { doActivityBulbS1Thread.interrupt(); }",exitAction.getActionCode());
    Assert.assertEquals("exit",exitAction.getActionType());
    
    Action entryAction = s1.getAction(1);
    
    Assert.assertEquals("doActivityBulbS1Thread = new DoActivityThread(this,\"doActivityBulbS1\");",entryAction.getActionCode());
    Assert.assertEquals("entry",entryAction.getActionType());
  }
  
  @Test
  public void addFinalState()
  {
    UmpleClass c = model.addUmpleClass("Student");
    StateMachine sm = new StateMachine("bulb");
    sm.setUmpleClass(c);
    State finalState = new State("Final",sm);
    Action action = new Action("blah");
    finalState.addAction(action);
    
    generator.prepare();
    Assert.assertEquals(2,finalState.numberOfActions());
    Action finalAction = finalState.getAction(1);
    Assert.assertEquals("delete();",finalAction.getActionCode());
    Assert.assertEquals("entry",finalAction.getActionType());
    
    GeneratorHelper.postpare(model);
    Assert.assertEquals(1,finalState.numberOfActions());
  }
  
  @Test
  public void addNestedFinalState()
  {
    UmpleClass c = model.addUmpleClass("Student");
    StateMachine sm = new StateMachine("bulb");
    sm.setUmpleClass(c);

    
    State s1 = new State("s1",sm);
    State s2 = new State("s2",sm);
    StateMachine n1 = new StateMachine("n1");
    StateMachine n2 = new StateMachine("n2");
    n1.setParentState(s1);
    n2.setParentState(s2);
    
    State final1 = new State("Final",n1);
    State final2 = new State("Final",n2);
    
    generator.prepare();
    Assert.assertEquals(1,final1.numberOfActions());
    Assert.assertEquals(1,final2.numberOfActions());

    Action finalAction = final1.getAction(0);
    Assert.assertEquals("delete();",finalAction.getActionCode());
    Assert.assertEquals("entry",finalAction.getActionType());
    
    finalAction = final2.getAction(0);
    Assert.assertEquals("delete();",finalAction.getActionCode());
    Assert.assertEquals("entry",finalAction.getActionType());

    GeneratorHelper.postpare(model);
    Assert.assertEquals(0,final1.numberOfActions());
    Assert.assertEquals(0,final2.numberOfActions());
  }  
  
  @Test
  public void addGeneratedClass()
  {
    UmpleClass c = model.addUmpleClass("Student");
    generator.prepare();
    Assert.assertEquals(true,c.getGeneratedClass() != null);
  }

  @Test
  public void addParentGeneratedClass()
  {
    UmpleClass parent = model.addUmpleClass("Person");
    UmpleClass c = model.addUmpleClass("Student");
    c.setExtendsClass(parent);
    
    generator.prepare();
    Assert.assertEquals(parent.getGeneratedClass(),c.getGeneratedClass().getParentClass());
  }

  @Test
  public void addSuperParentGeneratedClass()
  {
    UmpleClass parent = model.addUmpleClass("Parent");
    UmpleClass child = model.addUmpleClass("Child");
    child.setExtendsClass(parent);
    UmpleClass grandChild = model.addUmpleClass("GrandChild");
    grandChild.setExtendsClass(child);
    
    generator.prepare();
    Assert.assertEquals(parent.getGeneratedClass(),child.getGeneratedClass().getParentClass());
    Assert.assertEquals(child.getGeneratedClass(),grandChild.getGeneratedClass().getParentClass());
  }

  
  @Test
  public void emptyConstructor()
  {
    UmpleClass c = model.addUmpleClass("Student");
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("",g.getLookup("constructorSignature"));
  }
  
  @Test
  public void attributesConstructor_single()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Attribute attr = new Attribute("name","Integer",null,null,false,c);
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("int aName",g.getLookup("constructorSignature"));
    Assert.assertEquals("aName",g.getLookup("constructorSignature_caller"));
  }  

  @Test
  public void attributesConstructor_defaulted()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Attribute attr = new Attribute("name","Integer","defaulted",null,false,c);
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("",g.getLookup("constructorSignature"));
    Assert.assertEquals("",g.getLookup("constructorSignature_caller"));
  }

  @Test
  public void attributesConstructor_multiple()
  {
    Attribute attr;
    UmpleClass c = model.addUmpleClass("Student");
    
    attr = new Attribute("fname","Integer",null,null,false,c);
    attr = new Attribute("lname","Integer",null,null,false,c);
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("int aFname, int aLname",g.getLookup("constructorSignature"));
    Assert.assertEquals("aFname, aLname",g.getLookup("constructorSignature_caller"));
  }  
  
  @Test
  public void attributesConstructor_ignore()
  {
    Attribute attr;
    UmpleClass c = model.addUmpleClass("Student");
    attr = new Attribute("hasValue","Integer",null,"1",false,c);
    attr = new Attribute("isAutounique","Integer",null,null,true,c);
    attr = new Attribute("isUnique","Integer","unique",null,true,c);

    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("",g.getLookup("constructorSignature"));
    Assert.assertEquals("",g.getLookup("constructorSignature_caller"));
  }  

  @Test
  public void attributesConstructor_defaultedWithValue()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Attribute attr = new Attribute("name","String","defaulted","\"1\"",false,c);
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("",g.getLookup("constructorSignature"));
    Assert.assertEquals("",g.getLookup("constructorSignature_caller"));
  }  
  

  @Test
  public void typeOf()
  {
    Assert.assertEquals("int",JavaGenerator.typeOf("Integer"));
    Assert.assertEquals("String",JavaGenerator.typeOf(""));
    Assert.assertEquals("String",JavaGenerator.typeOf(null));
    Assert.assertEquals("double",JavaGenerator.typeOf("Double"));
    Assert.assertEquals("boolean",JavaGenerator.typeOf("Boolean"));
    Assert.assertEquals("Blah",JavaGenerator.typeOf("Blah"));
  }
  
  @Test
  public void nameOf()
  {
    Assert.assertEquals("aName",generator.nameOf("name",false));
    Assert.assertEquals("allName",generator.nameOf("name",true));
    Assert.assertEquals("a",generator.nameOf("",false));
    Assert.assertEquals("all",generator.nameOf("",true));
    Assert.assertEquals(null,generator.nameOf(null,false));
    Assert.assertEquals(null,generator.nameOf(null,true));
  }

  @Test
  public void nameOf_plural()
  {
    Assert.assertEquals("aNames",generator.nameOf("names",false));
    Assert.assertEquals("allNames",generator.nameOf("names",true));
  }

  
  @Test
  public void associationConstructor_oneToOne()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor",null,null,createMultiplicity(1,1),true);
    AssociationVariable relatedAv = new AssociationVariable("student","Student",null,null,createMultiplicity(1,1),true);
    av.setRelatedAssociation(relatedAv);
    
    c.addAssociationVariable(av);
    Attribute attr = new Attribute("id","Integer",null,null,false,c);

    c2.addAssociationVariable(relatedAv);
    attr = new Attribute("name","String",null,null,false,c2);
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("int aId, Mentor aMentor",g.getLookup("constructorSignature"));
    Assert.assertEquals("aId, aMentor",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("String aName, Student aStudent",g2.getLookup("constructorSignature"));
    Assert.assertEquals("aName, aStudent",g2.getLookup("constructorSignature_caller"));
    
    Assert.assertEquals("int aId, String aNameForMentor",g.getLookup("constructorSignature_mandatory"));
    Assert.assertEquals("aNameForMentor, this",g.getLookup("constructorSignature_mandatory_mentor"));
    
  }   

  @Test
  public void associationConstructor_unidirectionalOne()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor",null,null,createMultiplicity(1,1),true);
    AssociationVariable relatedAv = new AssociationVariable("student","Student",null,null,createMultiplicity(1,1),false);
    av.setRelatedAssociation(relatedAv);
    
    c.addAssociationVariable(av);
    Attribute attr = new Attribute("id","Integer",null,null,false,c);

    c2.addAssociationVariable(relatedAv);
    attr = new Attribute("name","String",null,null,false,c2);
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("int aId, Mentor aMentor",g.getLookup("constructorSignature"));
    Assert.assertEquals("aId, aMentor",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("String aName",g2.getLookup("constructorSignature"));
    Assert.assertEquals("aName",g2.getLookup("constructorSignature_caller"));

    Assert.assertEquals(null,g.getLookup("constructorSignature_mandatory"));
    Assert.assertEquals(null,g.getLookup("constructorSignature_mandatory_mentor"));

  }   
  
  @Test
  public void ignoreListAttributesInConstructor()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Attribute av = new Attribute("name","Integer","defaulted","\"1\"",false,c);
    av.setIsList(true);
    generator.prepare();

    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("",g.getLookup("constructorSignature"));
    Assert.assertEquals("",g.getLookup("constructorSignature_caller"));
    
  }   

  
  
  @Test
  public void associationConstructor_Many()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor",null,null,createMultiplicity(0,1),true);
    AssociationVariable relatedAv = new AssociationVariable("students","Student",null,null,createMultiplicity(1,-1),true);
    av.setRelatedAssociation(relatedAv);
    
    c.addAssociationVariable(av);
    Attribute attr = new Attribute("id","Integer",null,null,false,c);

    c2.addAssociationVariable(relatedAv);
    attr = new Attribute("name","String",null,null,false,c2);
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("int aId",g.getLookup("constructorSignature"));
    Assert.assertEquals("aId",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("String aName, Student... allStudents",g2.getLookup("constructorSignature"));
    Assert.assertEquals("aName, allStudents",g2.getLookup("constructorSignature_caller"));
    
  }   

  @Test
  public void associationConstructor_UnidirectionalMandatoryMany()
  {
    UmpleClass c = model.addUmpleClass("Mentor");
    UmpleClass c2 = model.addUmpleClass("Student");

    AssociationVariable av = new AssociationVariable("students","Student",null,null,createMultiplicity(1,5),true);
    AssociationVariable relatedAv = new AssociationVariable("mentors","Mentor",null,null,createMultiplicity(1,5),false);
    av.setRelatedAssociation(relatedAv);
    
    c.addAssociationVariable(av);
    Attribute attr = new Attribute("id","Integer",null,null,false,c);

    c2.addAssociationVariable(relatedAv);
    attr = new Attribute("name","String",null,null,false,c2);
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("int aId, Student... allStudents",g.getLookup("constructorSignature"));
    Assert.assertEquals("aId, allStudents",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("String aName",g2.getLookup("constructorSignature"));
    Assert.assertEquals("aName",g2.getLookup("constructorSignature_caller"));
    
  }   
  
  
  @Test
  public void associationConstructor_MN()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor",null,null,createMultiplicity(1,1),true);
    AssociationVariable relatedAv = new AssociationVariable("student","Student",null,null,createMultiplicity(1,3),true);
    av.setRelatedAssociation(relatedAv);
    
    c.addAssociationVariable(av);
    Attribute attr = new Attribute("id","Integer",null,null,false,c);

    c2.addAssociationVariable(relatedAv);
    attr = new Attribute("name","String",null,null,false,c2);
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("int aId, Mentor aMentor",g.getLookup("constructorSignature"));
    Assert.assertEquals("aId, aMentor",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("String aName",g2.getLookup("constructorSignature"));
    Assert.assertEquals("aName",g2.getLookup("constructorSignature_caller"));
    
  }   
  
  @Test
  public void associationConstructor_MNtoMN()
  {
    assertIgnoreMany(2,4,1,3);
  }   

  @Test
  public void associationConstructor_NtoMStar()
  {
    assertIgnoreMany(4,4,3,-1);
  }   

  @Test
  public void associationConstructor_MNtoOptionalN()
  {
    assertIgnoreMany(2,4,0,3);
  }   
  
  @Test
  public void associationConstructor_NtoOptionalN()
  {
    assertIgnoreMany(4,4,0,3);
  }
  
  @Test
  public void associationConstructor_MultipleToManyAssociationsInConstructor()
  {
    UmpleClass c = model.addUmpleClass("Someclass");
    UmpleClass other = model.addUmpleClass("Otherclass");

    AssociationVariable av = new AssociationVariable("otherOne","Otherclass",null,null,createMultiplicity(1,5),true);
    AssociationVariable relatedAv = new AssociationVariable("someclass","Someclass",null,null,createMultiplicity(1,5),false);
    av.setRelatedAssociation(relatedAv);   
    c.addAssociationVariable(av);
    other.addAssociationVariable(relatedAv);
    
    av = new AssociationVariable("otherTwo","Otherclass",null,null,createMultiplicity(4,-1),true);
    relatedAv = new AssociationVariable("someclass","Someclass",null,null,createMultiplicity(3,-1),false);
    av.setRelatedAssociation(relatedAv);
    c.addAssociationVariable(av);
    other.addAssociationVariable(relatedAv);
    
    Attribute attr = new Attribute("id","Integer",null,null,false,c);    
    attr = new Attribute("name","String",null,null,false,c);
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("int aId, String aName, Otherclass[] allOtherOne, Otherclass[] allOtherTwo",g.getLookup("constructorSignature"));
    Assert.assertEquals("aId, aName, allOtherOne, allOtherTwo",g.getLookup("constructorSignature_caller"));
  }
  
  @Test
  public void associationConstructor_SuperclassAndSubclassesAllHaveToManyAssociations()
  {
    UmpleClass c = model.addUmpleClass("Superclass");
    UmpleClass c2 = model.addUmpleClass("Subclass");
    UmpleClass c3 = model.addUmpleClass("SubSubclass");
    UmpleClass other = model.addUmpleClass("Otherclass");
    
    c2.setExtendsClass(c);
    c3.setExtendsClass(c2);

    AssociationVariable av = new AssociationVariable("superOther","Otherclass",null,null,createMultiplicity(1,5),true);
    AssociationVariable relatedAv = new AssociationVariable("superclass","Superclass",null,null,createMultiplicity(1,5),false);
    av.setRelatedAssociation(relatedAv);   
    c.addAssociationVariable(av);
    other.addAssociationVariable(relatedAv);
    
    Attribute attr = new Attribute("id","Integer",null,null,false,c);
    
    av = new AssociationVariable("subOther","Otherclass",null,null,createMultiplicity(4,-1),true);
    relatedAv = new AssociationVariable("subclass","Subclass",null,null,createMultiplicity(3,-1),false);
    av.setRelatedAssociation(relatedAv);
    c2.addAssociationVariable(av);
    other.addAssociationVariable(relatedAv);
    
    attr = new Attribute("name","String",null,null,false,c2);
    
    av = new AssociationVariable("subSubOther","Otherclass",null,null,createMultiplicity(4,-1),true);
    relatedAv = new AssociationVariable("subSubclass","SubSubclass",null,null,createMultiplicity(3,-1),false);
    av.setRelatedAssociation(relatedAv);
    c3.addAssociationVariable(av);
    other.addAssociationVariable(relatedAv);
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("int aId, Otherclass... allSuperOther",g.getLookup("constructorSignature"));
    Assert.assertEquals("aId, allSuperOther",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("int aId, Otherclass[] allSuperOther, String aName, Otherclass[] allSubOther",g2.getLookup("constructorSignature"));
    Assert.assertEquals("aId, allSuperOther, aName, allSubOther",g2.getLookup("constructorSignature_caller"));
    
    GeneratedClass g3 = c3.getGeneratedClass();
    Assert.assertEquals("int aId, Otherclass[] allSuperOther, String aName, Otherclass[] allSubOther, Otherclass[] allSubSubOther",g3.getLookup("constructorSignature"));
    Assert.assertEquals("aId, allSuperOther, aName, allSubOther, allSubSubOther",g3.getLookup("constructorSignature_caller"));
  }
  
  @Test
  public void associationConstructor_SubclassAddsNoNewToManyAssociationsToSuperclassConstructorWithVariableArgs()
  {
    UmpleClass c = model.addUmpleClass("Superclass");
    UmpleClass c2 = model.addUmpleClass("Subclass");
    UmpleClass c3 = model.addUmpleClass("SubSubclass");
    UmpleClass other = model.addUmpleClass("Otherclass");
    
    c2.setExtendsClass(c);
    c3.setExtendsClass(c2);

    AssociationVariable av = new AssociationVariable("other","Otherclass",null,null,createMultiplicity(1,5),true);
    AssociationVariable relatedAv = new AssociationVariable("superclass","Superclass",null,null,createMultiplicity(1,5),false);
    av.setRelatedAssociation(relatedAv);   
    c.addAssociationVariable(av);
    other.addAssociationVariable(relatedAv);
    
    Attribute attr = new Attribute("id","Integer",null,null,false,c2);
    
    attr = new Attribute("name","String",null,null,false,c3);
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("Otherclass... allOther",g.getLookup("constructorSignature"));
    Assert.assertEquals("allOther",g.getLookup("constructorSignature_caller"));
    
    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("int aId, Otherclass... allOther",g2.getLookup("constructorSignature"));
    Assert.assertEquals("aId, allOther",g2.getLookup("constructorSignature_caller"));

    GeneratedClass g3 = c3.getGeneratedClass();
    Assert.assertEquals("int aId, String aName, Otherclass... allOther",g3.getLookup("constructorSignature"));
    Assert.assertEquals("aId, aName, allOther",g3.getLookup("constructorSignature_caller"));
  }
  
  @Test
  public void associationConstructor_SubclassConstructorAddsNothingToSuperclassConstructorWithVariableArgs()
  {
    UmpleClass c = model.addUmpleClass("Superclass");
    UmpleClass c2 = model.addUmpleClass("Subclass");
    UmpleClass other = model.addUmpleClass("Otherclass");
    
    c2.setExtendsClass(c);

    AssociationVariable av = new AssociationVariable("other","Otherclass",null,null,createMultiplicity(1,5),true);
    AssociationVariable relatedAv = new AssociationVariable("superclass","Superclass",null,null,createMultiplicity(1,5),false);
    av.setRelatedAssociation(relatedAv);   
    c.addAssociationVariable(av);
    other.addAssociationVariable(relatedAv);
    
    Attribute attr = new Attribute("id","Integer",null,null,false,c);
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("int aId, Otherclass... allOther",g.getLookup("constructorSignature"));
    Assert.assertEquals("aId, allOther",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("int aId, Otherclass... allOther",g2.getLookup("constructorSignature"));
    Assert.assertEquals("aId, allOther",g2.getLookup("constructorSignature_caller"));
  }
  
  @Test
  public void associationConstructor_SubclassConstructorAddsFirstToManyAssociationToSuperclassConstructor()
  {
    UmpleClass c = model.addUmpleClass("Superclass");
    UmpleClass c2 = model.addUmpleClass("Subclass");
    UmpleClass other = model.addUmpleClass("Otherclass");
    
    c2.setExtendsClass(c);
    
    Attribute attr = new Attribute("id","Integer",null,null,false,c);
    
    AssociationVariable av = new AssociationVariable("subOther","Otherclass",null,null,createMultiplicity(4,-1),true);
    AssociationVariable relatedAv = new AssociationVariable("subclass","Subclass",null,null,createMultiplicity(3,-1),false);
    av.setRelatedAssociation(relatedAv);
    c2.addAssociationVariable(av);
    other.addAssociationVariable(relatedAv);
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("int aId",g.getLookup("constructorSignature"));
    Assert.assertEquals("aId",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("int aId, Otherclass... allSubOther",g2.getLookup("constructorSignature"));
    Assert.assertEquals("aId, allSubOther",g2.getLookup("constructorSignature_caller"));
  }
  
  @Test
  public void associationConstructor_SubclassConstructorAddsFirstToManyAssociationToEmptySuperclassConstructor()
  {
    UmpleClass c = model.addUmpleClass("Superclass");
    UmpleClass c2 = model.addUmpleClass("Subclass");
    UmpleClass other = model.addUmpleClass("Otherclass");
    
    c2.setExtendsClass(c);
    
    AssociationVariable av = new AssociationVariable("subOther","Otherclass",null,null,createMultiplicity(4,-1),true);
    AssociationVariable relatedAv = new AssociationVariable("subclass","Subclass",null,null,createMultiplicity(3,-1),false);
    av.setRelatedAssociation(relatedAv);
    c2.addAssociationVariable(av);
    other.addAssociationVariable(relatedAv);
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("",g.getLookup("constructorSignature"));
    Assert.assertEquals("",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("Otherclass... allSubOther",g2.getLookup("constructorSignature"));
    Assert.assertEquals("allSubOther",g2.getLookup("constructorSignature_caller"));
  }
  
  @Test
  public void imports_Time()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Attribute attr = new Attribute("name","Time","defaulted","\"1\"",false,c);
    generator.prepare();
    assertImport(c,"java.sql.Time");
  }
  
  @Test
  public void imports_ParentImports()
  {
    String input = "class Parent { Date d; class Child {}}";
    UmpleModel model = parse(input);
    
    UmpleClass child = model.getUmpleClass("Child");
    assertImport(child,"java.sql.Date");
  }
  
  @Test
  public void imports_Associations()
  {
    String input = "namespace one; class Activity {} namespace two; class ActivityTask { * -- 1 Activity; * -- 1 Result; } class Result {}";
    UmpleModel model = parse(input);

    UmpleClass activity = model.getUmpleClass("Activity");
    assertImport(activity,"java.util.*","two.*");

    UmpleClass activityTask = model.getUmpleClass("ActivityTask");
    assertImport(activityTask,"one.*");
    
    UmpleClass result = model.getUmpleClass("Result");
    assertImport(result,"java.util.*");
  }
  
  @Test
  public void imports_ExternalAssociations()
  {
    String input = "namespace one; class Activity {} namespace two; class ActivityTask { } class Result {} association { * ActivityTask -- 1 Activity; * ActivityTask -- 1 Result; }";
    UmpleModel model = parse(input);

    UmpleClass activity = model.getUmpleClass("Activity");
    assertImport(activity,"java.util.*","two.*");

    UmpleClass activityTask = model.getUmpleClass("ActivityTask");
    assertImport(activityTask,"one.*");
    
    UmpleClass result = model.getUmpleClass("Result");
    assertImport(result,"java.util.*");
  }
  
  @Test
  public void imports_IndirectFromOneStarRelationship()
  {
    String input = " class Activity {} class Task { Date d; class ActivityTask { * -- 1 Activity; * -- 1 Result; } } class Result {}";
    UmpleModel model = parse(input);

    UmpleClass activity = model.getUmpleClass("Activity");
    assertImport(activity,"java.util.*","java.sql.Date");

    UmpleClass task = model.getUmpleClass("Result");
    assertImport(task,"java.util.*","java.sql.Date");
  }
  
  @Test
  public void imports_indirectlyDate()
  {
    String input = "class Cheque { isA FinancialInstrument;  amount;  Date date; sequenceNumber; } class BankAccount { isA FinancialInstrument; accountNumber; balance; Double overdraftOrCreditLimit; 1..* -- * DebitCard; 1 -- * Cheque; } class Bank { 1--* BankAccount} class FinancialInstrument {} class DebitCard{}";
    UmpleModel model = parse(input);
    
    UmpleClass cheque = model.getUmpleClass("Cheque");
    assertImport(cheque,"java.sql.Date");
    
    UmpleClass bankAccount = model.getUmpleClass("BankAccount");
    assertImport(bankAccount,"java.util.*","java.sql.Date");
    
    UmpleClass bank = model.getUmpleClass("Bank");
    assertImport(bank);

  }
  
  @Test
  public void imports_indirectlyTime()
  {
    UmpleClass airline = model.addUmpleClass("Airline");
    
    UmpleClass flight = model.addUmpleClass("Flight");
    Attribute attr = new Attribute("time","Time",null,null,false,flight);
    
    AssociationVariable airlineVar = new AssociationVariable("airline","Airline","","",createMultiplicity(1,1),true);
    AssociationVariable flightVar = new AssociationVariable("flight","Flight","","",createMultiplicity(0,-1),true);

    airlineVar.setRelatedAssociation(flightVar);
    airline.addAssociationVariable(flightVar);
    flight.addAssociationVariable(airlineVar);
    
    generator.prepare();
    assertImport(airline,"java.util.*","java.sql.Time");
  }
  
  @Test
  public void imports_Date()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Attribute attr = new Attribute("name","Date","defaulted","\"1\"",false,c);
    generator.prepare();
    assertImport(c,"java.sql.Date");
  }  

  @Test
  public void imports_None()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Attribute attr = new Attribute("name","Integer","defaulted","\"1\"",false,c);
    generator.prepare();
    assertImport(c);
  }
  
  @Test
  public void imports_ListAttribute()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Attribute av = new Attribute("name","Integer","defaulted","\"1\"",false,c);
    av.setIsList(true);
    generator.prepare();
    assertImport(c,"java.util.*");
  }  

  @Test
  public void imports_ExtendsClass()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass extendsClass = model.addUmpleClass("Person");
    c.setExtendsClass(extendsClass);
    c.setPackageName("cruise.one");
    extendsClass.setPackageName("cruise.two");
    
    generator.prepare();
    assertImport(c,"cruise.two.*");
  }  
  
  @Test
  public void imports_NotExtendsClassIfSamePackage()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass extendsClass = model.addUmpleClass("Person");
    c.setExtendsClass(extendsClass);
    c.setPackageName("cruise.one");
    extendsClass.setPackageName("cruise.one");
    
    generator.prepare();
    assertImport(c);
  } 
  
  @Test
  public void imports_NotExtendsClassIfNoneSet()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass extendsClass = model.addUmpleClass("Person");
    c.setExtendsClass(extendsClass);
    generator.prepare();
    assertImport(c);
  }  
  
  @Test
  public void translate_ParameterValueDateTime()
  {
    UmpleClass c = new UmpleClass("Student");
    Attribute av;
    
    av = new Attribute("name","Time","defaulted","\"1\"",false,c);
    Assert.assertEquals("Time.valueOf(\"1\")", generator.translate("parameterValue", av));

    av = new Attribute("name","Date","defaulted","\"2\"",false,c);
    Assert.assertEquals("Date.valueOf(\"2\")", generator.translate("parameterValue", av));

    av = new Attribute("name","Time","defaulted","blah1()",false,c);
    Assert.assertEquals("blah1()", generator.translate("parameterValue", av));

    av = new Attribute("name","Date","defaulted","blah2()",false,c);
    Assert.assertEquals("blah2()", generator.translate("parameterValue", av));

    av = new Attribute("name","Time","defaulted",null,false,c);
    Assert.assertEquals("null", generator.translate("parameterValue", av));

    av = new Attribute("name","Date","defaulted",null,false,c);
    Assert.assertEquals("null", generator.translate("parameterValue", av));
    
  }
  
  @Test
  public void translate_plural()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Attribute attr = new Attribute("names","String",null,null,false,c);
    attr.setIsList(true);
    
    Assert.assertEquals("newNames",generator.translate("parameter",attr));
    Assert.assertEquals("aName",generator.translate("parameterOne",attr));
    Assert.assertEquals("placeholderName",generator.translate("removeParameterOne",attr));
    Assert.assertEquals("name",generator.translate("associationOne",attr));
    Assert.assertEquals("names",generator.translate("associationMany",attr));
    Assert.assertEquals("names",generator.translate("attribute",attr));
    Assert.assertEquals("name",generator.translate("attributeOne",attr));
    Assert.assertEquals("names",generator.translate("attributeMany",attr));
    Assert.assertEquals("addName",generator.translate("addMethod",attr));
    Assert.assertEquals("removeName",generator.translate("removeMethod",attr));
    Assert.assertEquals("setName",generator.translate("setMethod",attr));
    Assert.assertEquals("enterName",generator.translate("enterMethod",attr));
    Assert.assertEquals("exitName",generator.translate("exitMethod",attr));
    Assert.assertEquals("doExitName",generator.translate("doExitMethod",attr));
    Assert.assertEquals("getName",generator.translate("getMethod",attr));
    Assert.assertEquals("newNames",generator.translate("parameterMany",attr));
    Assert.assertEquals("aNewName",generator.translate("parameterNew",attr));
    Assert.assertEquals("allNames",generator.translate("parameterAll",attr));
    Assert.assertEquals("nextName",generator.translate("parameterNext",attr));
    Assert.assertEquals("setNames",generator.translate("setManyMethod",attr));
    Assert.assertEquals("didAddNames",generator.translate("didAddMany",attr));
    Assert.assertEquals("didAddName",generator.translate("didAdd",attr));
    Assert.assertEquals("numberOfNames",generator.translate("numberOfMethod",attr));
    Assert.assertEquals("indexOfName",generator.translate("indexOfMethod",attr));
    Assert.assertEquals("isNumberOfNamesValid",generator.translate("isNumberOfValidMethod",attr));
    Assert.assertEquals("verifiedNames",generator.translate("parameterVerifiedMany",attr));
    Assert.assertEquals("oldNames",generator.translate("parameterOldMany",attr));
    Assert.assertEquals("anOldName",generator.translate("parameterOld",attr));
    Assert.assertEquals("existingName",generator.translate("parameterExisting",attr));
    Assert.assertEquals("checkNewNames",generator.translate("parameterCheckNewMany",attr));
    Assert.assertEquals("isNewName",generator.translate("parameterIsNew",attr));
    Assert.assertEquals("newName",generator.translate("associationNew",attr));
    Assert.assertEquals("copyOfNames",generator.translate("parameterCopyOfMany",attr));
    Assert.assertEquals("canSetName",generator.translate("canSetMethod",attr));
    Assert.assertEquals("currentName",generator.translate("parameterCurrent",attr));
    Assert.assertEquals("deleteName",generator.translate("deleteMethod",attr));
    Assert.assertEquals("requiredNumberOfNames",generator.translate("requiredNumberOfMethod",attr));    
  }
  
  @Test
  public void translate_Association()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor",null,"3",createMultiplicity(1,1),true);
    AssociationVariable relatedAv = new AssociationVariable("students","Student",null,"2",createMultiplicity(-1,-1),true);
    av.setRelatedAssociation(relatedAv);
    c.addAssociationVariable(av);
    c2.addAssociationVariable(relatedAv);
    
    assertTranslate(av, av.getRelatedAssociation());
  }

  @Test
  public void translate_nestedStateMachines()
  {
    UmpleClass c = model.addUmpleClass("Student");
    StateMachine outerSm = new StateMachine("Vcr");
    outerSm.setUmpleClass(c);

    State s1 = new State("s1",outerSm);
    new State("s2",outerSm);
    
    StateMachine sm = new StateMachine("On");
    s1.addNestedStateMachine(sm);
    
    new State("s3",sm);
    new State("s4",sm);
    
    Assert.assertEquals("UNKNOWN ID: blah",generator.translate("blah",sm));
    Assert.assertEquals("VcrOn",generator.translate("stateMachineOne",sm));
    Assert.assertEquals("aVcrOn",generator.translate("parameterOne",sm));
    Assert.assertEquals("placeholderVcrOn",generator.translate("removeParameterOne",sm));    
    Assert.assertEquals("getVcrOn",generator.translate("getMethod",sm));
    Assert.assertEquals("getVcrOnFullName",generator.translate("getFullMethod",sm));
    Assert.assertEquals("isVcrOnFinal",generator.translate("isFinalMethod",sm));
    Assert.assertEquals("String",generator.translate("typeGet",sm));
    Assert.assertEquals("VcrOn",generator.translate("type",sm));
    Assert.assertEquals("Null",generator.translate("stateNull",sm));
    Assert.assertEquals("s3, s4",generator.translate("listStates",sm));
  }
  
  @Test
  public void translate_stateMachines()
  {
    UmpleClass c = model.addUmpleClass("Student");
    StateMachine sm = new StateMachine("Grade");
    sm.setUmpleClass(c);

    new State("s1",sm);
    new State("s2",sm);
    
    Assert.assertEquals("UNKNOWN ID: blah",generator.translate("blah",sm));
    Assert.assertEquals("Grade",generator.translate("stateMachineOne",sm));
    Assert.assertEquals("aGrade",generator.translate("parameterOne",sm));
    Assert.assertEquals("placeholderGrade",generator.translate("removeParameterOne",sm));    
    Assert.assertEquals("getGrade",generator.translate("getMethod",sm));
    Assert.assertEquals("getGradeFullName",generator.translate("getFullMethod",sm));
    Assert.assertEquals("isGradeFinal",generator.translate("isFinalMethod",sm));
    Assert.assertEquals("String",generator.translate("typeFull",sm));
    Assert.assertEquals("String",generator.translate("typeGet",sm));
    Assert.assertEquals("Grade",generator.translate("type",sm));
    Assert.assertEquals("Null",generator.translate("stateNull",sm));
    Assert.assertEquals("s1, s2",generator.translate("listStates",sm));
  }

  @Test
  public void translate_states()
  {
    UmpleClass c = model.addUmpleClass("Student");
    StateMachine sm = new StateMachine("grade");
    sm.setUmpleClass(c);
    
    State state = new State("Pass",sm);

    Assert.assertEquals("UNKNOWN ID: blah",generator.translate("blah",state));
    Assert.assertEquals("Pass",generator.translate("stateOne",state));
    Assert.assertEquals("\"Pass\"",generator.translate("stateString",state));
    Assert.assertEquals("Grade",generator.translate("type",state));
    Assert.assertEquals("UNKNOWN ID: doActivityMethod",generator.translate("doActivityMethod",state));
    Assert.assertEquals("UNKNOWN ID: doActivityThread",generator.translate("doActivityThread",state));
    
    Activity activity = new Activity("//the code",state);
    state.addActivity(activity);
    Assert.assertEquals("doActivityGradePass",generator.translate("doActivityMethod",activity));
    
  } 
  
  @Test
  public void translate_class()
  {
    UmpleClass c = model.addUmpleClass("Student");

    Assert.assertEquals("UNKNOWN ID: blah",generator.translate("blah",c));
    Assert.assertEquals("delete",generator.translate("deleteMethod",c));
    Assert.assertEquals("Student",generator.translate("type",c));
  }   
  
  @Test
  public void translate_event()
  {
    Event e = new Event("register");
    Assert.assertEquals("UNKNOWN ID: blah",generator.translate("blah",e));
    Assert.assertEquals("register",generator.translate("eventMethod",e));
    Assert.assertEquals("doRegister",generator.translate("doEventMethod",e));
    Assert.assertEquals("startRegisterHandler",generator.translate("eventStartMethod",e));
    Assert.assertEquals("stopRegisterHandler",generator.translate("eventStopMethod",e));
    Assert.assertEquals("registerHandler",generator.translate("eventHandler",e));
  }
  
  @Test
  public void translate_OtherAssociation()
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor",null,"3",createMultiplicity(1,1),true);
    AssociationVariable relatedAv = new AssociationVariable("students","Student",null,"2",createMultiplicity(0,-1),true);
    av.setRelatedAssociation(relatedAv);
    c.addAssociationVariable(av);
    c2.addAssociationVariable(relatedAv);
    
    assertOtherTranslate(c,av);
  }

  @Test
  public void translate_CanSetBasedOnMultiplicity_Attributes()
  {
    UmpleClass c = model.addUmpleClass("Student");

    Attribute avOne = new Attribute("id","String",null,null,false,c);
    Attribute avMany = new Attribute("values","String",null,null,false,c); 
    avMany.setIsList(true);
    
    Assert.assertEquals("canSetId", generator.translate("attributeCanSet", avOne));
    Assert.assertEquals("canSetValues", generator.translate("attributeCanSet", avMany));
  }
  
  @Test
  public void translate_CanSetBasedOnMultiplicity_Associations()
  {
    UmpleClass c = model.addUmpleClass("Student");

    AssociationVariable av = new AssociationVariable("mentor","Mentor",null,"3",createMultiplicity(1,1),true);
    AssociationVariable relatedAv = new AssociationVariable("students","Student",null,"2",createMultiplicity(0,-1),true);
    av.setRelatedAssociation(relatedAv);
    c.addAssociationVariable(av);

    Assert.assertEquals("canSetMentor", generator.translate("associationCanSet", av));
    Assert.assertEquals("canSetStudents", generator.translate("associationCanSet", relatedAv));
  }
  
  @Test
  public void translate_Attribute()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Attribute av = new Attribute("mentor","Mentor",null,"3",false,c);
    assertTranslate(av, null);
  }
  
  @Test
  public void translate_packageDefinition()
  {
    UmpleClass c = model.addUmpleClass("Student");
    Assert.assertEquals("",generator.translate("packageDefinition", c));
    
    c.setPackageName("cruise.umple");
    Assert.assertEquals("package cruise.umple;",generator.translate("packageDefinition", c));
  }  
  
  @Test
  public void getType_isNullable()
  {
    UmpleClass c = new UmpleClass("Student");
    Attribute av = new Attribute("mentor","Mentor",null,"3",false,c);
    Assert.assertEquals("Mentor",generator.getType(av));
    Assert.assertEquals(true,generator.isNullable(av));
    Assert.assertEquals("Mentor", generator.translate("type",av));
    Assert.assertEquals("Mentor", generator.translate("typeMany",av));

    av.setType("Integer");
    Assert.assertEquals("int",generator.getType(av));
    Assert.assertEquals(false,generator.isNullable(av));
    Assert.assertEquals("int", generator.translate("type",av));
    Assert.assertEquals("Integer", generator.translate("typeMany",av));

    av.setType("Boolean");
    Assert.assertEquals("boolean",generator.getType(av));
    Assert.assertEquals(false,generator.isNullable(av));
    Assert.assertEquals("boolean", generator.translate("type",av));
    
    av.setType("Double");
    Assert.assertEquals("double",generator.getType(av));
    Assert.assertEquals(false,generator.isNullable(av));
    Assert.assertEquals("double", generator.translate("type",av));

    av.setType("Float");
    Assert.assertEquals("float",generator.getType(av));
    Assert.assertEquals(false,generator.isNullable(av));
    Assert.assertEquals("float", generator.translate("type",av));

    av.setType("");
    Assert.assertEquals("String",generator.getType(av));
    Assert.assertEquals(true,generator.isNullable(av));
    Assert.assertEquals("String", generator.translate("type",av));
    
    av.setType(null);
    Assert.assertEquals("String",generator.getType(av));
    Assert.assertEquals(true,generator.isNullable(av));
    Assert.assertEquals("String", generator.translate("type",av));
    Assert.assertEquals("String", generator.translate("typeMany",av));

    
  }
  
  @Test
  public void translateCallerArguments()
  {
    Attribute attr;
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor","","",createMultiplicity(1,1),true);
    AssociationVariable relatedAv = new AssociationVariable("student","Student","","",createMultiplicity(2,-1),true);
    av.setRelatedAssociation(relatedAv);
    c.addAssociationVariable(av);
    c2.addAssociationVariable(relatedAv);
    attr = new Attribute("name","String",null,null,false,c2);
    attr = new Attribute("number","Integer",null,null,false,c);

    generator.prepare();
    
    String callerArgs = generator.translate("callerArgumentsExcept", av);
    String methodArgs = generator.translate("methodArgumentsExcept", av);

    Assert.assertEquals("aNumber, this", callerArgs);
    Assert.assertEquals("int aNumber", methodArgs);
    
  }
  
  @Test
  public void isA_extends()
  {
    UmpleClass parent = model.addUmpleClass("Parent");
    UmpleClass child = model.addUmpleClass("Child");
    child.setExtendsClass(parent);
    
    Assert.assertEquals("",generator.translate("isA", parent));
    Assert.assertEquals(" extends Parent",generator.translate("isA", child));
  }

  @Test
  public void isA_implements()
  {
    UmpleInterface parent = new UmpleInterface("Parent", model);
    model.addUmpleInterface(parent);
    UmpleClass child = model.addUmpleClass("Child");
    child.addParentInterface(parent);
    
    Assert.assertEquals("",generator.translate("isA", parent));
    Assert.assertEquals(" implements Parent",generator.translate("isA", child));
  }

  @Test
  public void callerArgumentsForMandatory()
  {
    Attribute attr;
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor","","",createMultiplicity(1,1),true);
    AssociationVariable relatedAv = new AssociationVariable("student","Student","","",createMultiplicity(1,1),true);
    av.setRelatedAssociation(relatedAv);
    c.addAssociationVariable(av);
    c2.addAssociationVariable(relatedAv);
    attr = new Attribute("name","String",null,null,false,c2);
    attr = new Attribute("number","Integer",null,null,false,c);

    generator.prepare();
    
    String callerArgFor1 = generator.translate("callerArgumentsForMandatory", av);
    Assert.assertEquals("aNumberForStudent, this", callerArgFor1);

    String callerArgFor2 = generator.translate("callerArgumentsForMandatory", relatedAv);
    Assert.assertEquals("aNameForMentor, this", callerArgFor2);

    Assert.assertEquals("int aNumber, String aNameForMentor", generator.translate("constructorMandatory",c));
    Assert.assertEquals("String aName, int aNumberForStudent", generator.translate("constructorMandatory",c2));
  }
  
  @Test
  public void getLanguageFor()
  {
    UmpleInterface aInterface = new UmpleInterface("Student", model);
    Assert.assertEquals(JavaInterfaceGenerator.class,generator.getLanguageFor(aInterface).getClass());
  }
  
  @Test
  public void attributesConstructionSetUnique()
  {	
	String pathToInput = SampleFileWriter.rationalize("test/cruise/umple/compiler/");
    model = createModelFromFile(pathToInput, "047_attributesConstructionSetUnique.ump");
    model.run();
    String actual = model.getGeneratedCode().get("RegularFlight");
    File generatedFile = new File(pathToInput+"RegularFlight.java");
    
    generatedFile.delete();
    File expected = new File(pathToInput + "RegularFlight.java.txt");
    SampleFileWriter.assertFileContent(expected, actual,true);
  }
  
  @Test
  public void attributesConstructionFloat()
  {	
	String pathToInput = SampleFileWriter.rationalize("test/cruise/umple/compiler/");
    model = createModelFromFile(pathToInput, "046_attributesConstructionFloat.ump");
    model.run();
    String actual = model.getGeneratedCode().get("FLoatGenerator");
    File generatedFile = new File(pathToInput+"FLoatGenerator.java");
    generatedFile.delete();
    File expected = new File(pathToInput + "FLoatGenerator.java.txt");
    SampleFileWriter.assertFileContent(expected, actual,false);
  }

  @Test
  public void prepare_postpare_nestedStateMachine()
  {
    UmpleClass c = model.addUmpleClass("LightFixture");
    StateMachine sm = new StateMachine("bulb");
    StateMachine nestedSm = new StateMachine("On");

    sm.setUmpleClass(c);
    
    State onState = new State("On",sm);
    onState.addNestedStateMachine(nestedSm);
    State normalState = new State("Normal",nestedSm);
    normalState.setIsStartState(true);

    generator.prepare();
    Assert.assertEquals(2,onState.numberOfActions());

    Assert.assertEquals("exit",onState.getAction(0).getActionType());
    Assert.assertEquals("exitBulbOn();",onState.getAction(0).getActionCode());
    
    Assert.assertEquals("entry",onState.getAction(1).getActionType());
    Assert.assertEquals("if (bulbOn == BulbOn.Null) { setBulbOn(BulbOn.Normal); }",onState.getAction(1).getActionCode());
    
    GeneratorHelper.postpare(model);
    Assert.assertEquals(1,onState.numberOfActions());
  }  

  @Test
  public void prepare_postpare_concurrentStateMachine()
  {
    UmpleClass c = model.addUmpleClass("LightFixture");
    StateMachine sm = new StateMachine("bulb");
    StateMachine nestedSm = new StateMachine("A");
    StateMachine nestedSm2 = new StateMachine("B");

    sm.setUmpleClass(c);
    
    State onState = new State("On",sm);
    onState.addNestedStateMachine(nestedSm);
    onState.addNestedStateMachine(nestedSm2);
    State normalState = new State("Normal",nestedSm);
    normalState.setIsStartState(true);

    State normalState2 = new State("Normal2",nestedSm2);
    normalState2.setIsStartState(true);

    Assert.assertEquals(0,onState.numberOfActions());
    Assert.assertEquals(0,onState.numberOfTransitions());
    Assert.assertEquals(0,normalState.numberOfTransitions());
    Assert.assertEquals(0,normalState2.numberOfTransitions());
    Assert.assertEquals(0,nestedSm.getEvents().size());
    Assert.assertEquals(0,nestedSm2.getEvents().size());
    Assert.assertEquals(1,nestedSm.numberOfStates());
    Assert.assertEquals(1,nestedSm2.numberOfStates());

    generator.prepare();

    Assert.assertEquals(3,onState.numberOfActions());
    Assert.assertEquals(0,onState.numberOfTransitions());
    Assert.assertEquals(1,normalState.numberOfTransitions());
    Assert.assertEquals(1,normalState2.numberOfTransitions());
    Assert.assertEquals(2,nestedSm.getEvents().size());
    Assert.assertEquals(2,nestedSm2.getEvents().size());
    Assert.assertEquals(2,nestedSm.numberOfStates());
    Assert.assertEquals(2,nestedSm2.numberOfStates());

    
    Assert.assertEquals("Null",nestedSm.getState(0).getName());

    Assert.assertEquals("enterOn",nestedSm.getEvents().get(0).getName());
    Assert.assertEquals("exitOn",nestedSm.getEvents().get(1).getName());
    Assert.assertEquals(true, nestedSm.getEvents().get(0) == nestedSm2.getEvents().get(0));
    Assert.assertEquals(true, nestedSm.getEvents().get(1) == nestedSm2.getEvents().get(1));
    
    Assert.assertEquals("Null",nestedSm2.getState(0).getName());
    
    Assert.assertEquals("exit",onState.getAction(0).getActionType());
    Assert.assertEquals("exitOn();",onState.getAction(0).getActionCode());
    
    Assert.assertEquals("entry",onState.getAction(1).getActionType());
    Assert.assertEquals("if (bulbOnA == BulbOnA.Null) { setBulbOnA(BulbOnA.Normal); }",onState.getAction(1).getActionCode());

    Assert.assertEquals("entry",onState.getAction(2).getActionType());
    Assert.assertEquals("if (bulbOnB == BulbOnB.Null) { setBulbOnB(BulbOnB.Normal2); }",onState.getAction(2).getActionCode());
    
    GeneratorHelper.postpare(model);
    Assert.assertEquals(0,onState.numberOfActions());
    Assert.assertEquals(0,onState.numberOfTransitions());
//    System.out.println("Found" + normalState.getTransition(0).getFromState().getName() + ":" + normalState.getTransition(0).getNextState().getName());
    Assert.assertEquals(0,normalState.numberOfTransitions());
    Assert.assertEquals(0,normalState2.numberOfTransitions());
    Assert.assertEquals(0,nestedSm.getEvents().size());
    Assert.assertEquals(0,nestedSm2.getEvents().size());
    Assert.assertEquals(1,nestedSm.numberOfStates());
    Assert.assertEquals(1,nestedSm2.numberOfStates());
  }  
  
  private void assertOtherTranslate(UmpleClass c, AssociationVariable av)
  {
    Assert.assertEquals("UNKNOWN ID: blah", generator.relatedTranslate("blah", av));
    Assert.assertEquals("newStudents",generator.relatedTranslate("parameter",av));
    Assert.assertEquals("aStudent",generator.relatedTranslate("parameterOne",av));
    Assert.assertEquals("placeholderStudent",generator.relatedTranslate("removeParameterOne",av));    
    Assert.assertEquals("2",generator.relatedTranslate("parameterValue",av));
    Assert.assertEquals("student",generator.relatedTranslate("associationOne",av));
    Assert.assertEquals("students",generator.relatedTranslate("associationMany",av));
    Assert.assertEquals("students",generator.relatedTranslate("attribute",av));
    Assert.assertEquals("student",generator.relatedTranslate("attributeOne",av));
    Assert.assertEquals("students",generator.relatedTranslate("attributeMany",av));
    Assert.assertEquals("addStudent",generator.relatedTranslate("addMethod",av));
    Assert.assertEquals("removeStudent",generator.relatedTranslate("removeMethod",av));
    Assert.assertEquals("setStudent",generator.relatedTranslate("setMethod",av));
    Assert.assertEquals("exitStudent",generator.relatedTranslate("exitMethod",av));
    Assert.assertEquals("doExitStudent",generator.relatedTranslate("doExitMethod",av));
    Assert.assertEquals("resetStudent",generator.relatedTranslate("resetMethod",av));
    Assert.assertEquals("getStudent",generator.relatedTranslate("getMethod",av));
    Assert.assertEquals("getDefaultStudent",generator.relatedTranslate("getDefaultMethod",av));
    Assert.assertEquals("newStudents",generator.relatedTranslate("parameterMany",av));
    Assert.assertEquals("aNewStudent",generator.relatedTranslate("parameterNew",av));
    Assert.assertEquals("allStudents",generator.relatedTranslate("parameterAll",av));
    Assert.assertEquals("nextStudent",generator.relatedTranslate("parameterNext",av));
    Assert.assertEquals("setStudents",generator.relatedTranslate("setManyMethod",av));
    Assert.assertEquals("didAddStudents",generator.relatedTranslate("didAddMany",av));
    Assert.assertEquals("didAddStudent",generator.relatedTranslate("didAdd",av));
    Assert.assertEquals("numberOfStudents",generator.relatedTranslate("numberOfMethod",av));
    Assert.assertEquals("indexOfStudent",generator.relatedTranslate("indexOfMethod",av));
    Assert.assertEquals("isNumberOfStudentsValid",generator.relatedTranslate("isNumberOfValidMethod",av));
    Assert.assertEquals("minimumNumberOfStudents",generator.relatedTranslate("minimumNumberOfMethod",av));
    Assert.assertEquals("maximumNumberOfStudents",generator.relatedTranslate("maximumNumberOfMethod",av));
    Assert.assertEquals("verifiedStudents",generator.relatedTranslate("parameterVerifiedMany",av));
    Assert.assertEquals("oldStudents",generator.relatedTranslate("parameterOldMany",av));
    Assert.assertEquals("anOldStudent",generator.relatedTranslate("parameterOld",av));
    Assert.assertEquals("existingStudent",generator.relatedTranslate("parameterExisting",av));
    Assert.assertEquals("checkNewStudents",generator.relatedTranslate("parameterCheckNewMany",av));
    Assert.assertEquals("isNewStudent",generator.relatedTranslate("parameterIsNew",av));
    Assert.assertEquals("newStudent",generator.relatedTranslate("associationNew",av));
    Assert.assertEquals("copyOfStudents",generator.relatedTranslate("parameterCopyOfMany",av));
    Assert.assertEquals("canSetStudent",generator.relatedTranslate("canSetMethod",av));
    Assert.assertEquals("currentStudent",generator.relatedTranslate("parameterCurrent",av));
    Assert.assertEquals("deleteStudent",generator.relatedTranslate("deleteMethod",av));
    Assert.assertEquals("getStudents",generator.relatedTranslate("getManyMethod",av));
    Assert.assertEquals("hasStudent",generator.relatedTranslate("hasMethod",av));
    Assert.assertEquals("hasStudents",generator.relatedTranslate("hasManyMethod",av));
    Assert.assertEquals("requiredNumberOfStudents",generator.relatedTranslate("requiredNumberOfMethod",av));
  }

  private void assertTranslate(Attribute av, Attribute relatedAv)
  {
    Assert.assertEquals("UNKNOWN ID: blah", generator.translate("blah", av));
    Assert.assertEquals("aMentor",generator.translate("parameter",av));
    Assert.assertEquals("aMentor",generator.translate("parameterOne",av));
    Assert.assertEquals("placeholderMentor",generator.translate("removeParameterOne",av));    
    Assert.assertEquals("3",generator.translate("parameterValue",av));
    Assert.assertEquals("mentor",generator.translate("associationOne",av));
    Assert.assertEquals("mentors",generator.translate("associationMany",av));
    Assert.assertEquals("mentor",generator.translate("attribute",av));
    Assert.assertEquals("mentor",generator.translate("attributeOne",av));
    Assert.assertEquals("mentors",generator.translate("attributeMany",av));
    Assert.assertEquals("addMentor",generator.translate("addMethod",av));
    Assert.assertEquals("removeMentor",generator.translate("removeMethod",av));
    Assert.assertEquals("setMentor",generator.translate("setMethod",av));
    Assert.assertEquals("exitMentor",generator.translate("exitMethod",av));
    Assert.assertEquals("doExitMentor",generator.translate("doExitMethod",av));
    Assert.assertEquals("getMentor",generator.translate("getMethod",av));
    Assert.assertEquals("newMentors",generator.translate("parameterMany",av));
    Assert.assertEquals("aNewMentor",generator.translate("parameterNew",av));
    Assert.assertEquals("allMentors",generator.translate("parameterAll",av));
    Assert.assertEquals("nextMentor",generator.translate("parameterNext",av));
    Assert.assertEquals("setMentors",generator.translate("setManyMethod",av));
    Assert.assertEquals("didAddMentors",generator.translate("didAddMany",av));
    Assert.assertEquals("didAddMentor",generator.translate("didAdd",av));
    Assert.assertEquals("numberOfMentors",generator.translate("numberOfMethod",av));
    Assert.assertEquals("indexOfMentor",generator.translate("indexOfMethod",av));
    Assert.assertEquals("isNumberOfMentorsValid",generator.translate("isNumberOfValidMethod",av));
    Assert.assertEquals("verifiedMentors",generator.translate("parameterVerifiedMany",av));
    Assert.assertEquals("oldMentors",generator.translate("parameterOldMany",av));
    Assert.assertEquals("anOldMentor",generator.translate("parameterOld",av));
    Assert.assertEquals("existingMentor",generator.translate("parameterExisting",av));
    Assert.assertEquals("checkNewMentors",generator.translate("parameterCheckNewMany",av));
    Assert.assertEquals("isNewMentor",generator.translate("parameterIsNew",av));
    Assert.assertEquals("newMentor",generator.translate("associationNew",av));
    Assert.assertEquals("copyOfMentors",generator.translate("parameterCopyOfMany",av));
    Assert.assertEquals("canSetMentor",generator.translate("canSetMethod",av));
    Assert.assertEquals("currentMentor",generator.translate("parameterCurrent",av));
    Assert.assertEquals("deleteMentor",generator.translate("deleteMethod",av));
    Assert.assertEquals("requiredNumberOfMentors",generator.translate("requiredNumberOfMethod",av));

    if (relatedAv == null)
    {
      return;
    }
    
    Assert.assertEquals("aStudent",generator.translate("parameterOne",relatedAv));
    Assert.assertEquals("placeholderStudent",generator.translate("removeParameterOne",relatedAv));    
    Assert.assertEquals("2",generator.translate("parameterValue",relatedAv));
    Assert.assertEquals("student",generator.translate("associationOne",relatedAv));
    Assert.assertEquals("students",generator.translate("associationMany",relatedAv));
    Assert.assertEquals("student",generator.translate("attributeOne",relatedAv));
    Assert.assertEquals("students",generator.translate("attributeMany",relatedAv));
    Assert.assertEquals("addStudent",generator.translate("addMethod",relatedAv));
    Assert.assertEquals("removeStudent",generator.translate("removeMethod",relatedAv));
    Assert.assertEquals("setStudent",generator.translate("setMethod",relatedAv));
    Assert.assertEquals("exitStudent",generator.translate("exitMethod",relatedAv));    
    Assert.assertEquals("doExitStudent",generator.translate("doExitMethod",relatedAv));    
    Assert.assertEquals("resetStudent",generator.translate("resetMethod",relatedAv));
    Assert.assertEquals("newStudents",generator.translate("parameterMany",relatedAv));
    Assert.assertEquals("aNewStudent",generator.translate("parameterNew",relatedAv));
    Assert.assertEquals("allStudents",generator.translate("parameterAll",relatedAv));
    Assert.assertEquals("nextStudent",generator.translate("parameterNext",relatedAv));
    Assert.assertEquals("setStudents",generator.translate("setManyMethod",relatedAv));
    Assert.assertEquals("didAddStudents",generator.translate("didAddMany",relatedAv));
    Assert.assertEquals("didAddStudent",generator.translate("didAdd",relatedAv));
    Assert.assertEquals("numberOfStudents",generator.translate("numberOfMethod",relatedAv));
    Assert.assertEquals("indexOfStudent",generator.translate("indexOfMethod",relatedAv));
    Assert.assertEquals("isNumberOfStudentsValid",generator.translate("isNumberOfValidMethod",relatedAv));
    Assert.assertEquals("minimumNumberOfStudents",generator.translate("minimumNumberOfMethod",relatedAv));
    Assert.assertEquals("maximumNumberOfStudents",generator.translate("maximumNumberOfMethod",relatedAv));
    Assert.assertEquals("verifiedStudents",generator.translate("parameterVerifiedMany",relatedAv));
    Assert.assertEquals("oldStudents",generator.translate("parameterOldMany",relatedAv));
    Assert.assertEquals("anOldStudent",generator.translate("parameterOld",relatedAv));
    Assert.assertEquals("existingStudent",generator.translate("parameterExisting",relatedAv));
    Assert.assertEquals("checkNewStudents",generator.translate("parameterCheckNewMany",relatedAv));
    Assert.assertEquals("isNewStudent",generator.translate("parameterIsNew",relatedAv));
    Assert.assertEquals("newStudent",generator.translate("associationNew",relatedAv));
    Assert.assertEquals("copyOfStudents",generator.translate("parameterCopyOfMany",relatedAv));
    Assert.assertEquals("canSetStudent",generator.translate("canSetMethod",relatedAv));
    Assert.assertEquals("currentStudent",generator.translate("parameterCurrent",relatedAv));
    Assert.assertEquals("deleteStudent",generator.translate("deleteMethod",relatedAv));
    Assert.assertEquals("requiredNumberOfStudents",generator.translate("requiredNumberOfMethod",relatedAv));
    

  }  
  
  private void assertTranslate(AssociationVariable av, AssociationVariable relatedAv)
  {
    Assert.assertEquals("UNKNOWN ID: blah", generator.translate("blah", av));
    Assert.assertEquals("aMentor",generator.translate("parameterOne",av));
    Assert.assertEquals("placeholderMentor",generator.translate("removeParameterOne",av));    
    Assert.assertEquals("3",generator.translate("parameterValue",av));
    Assert.assertEquals("mentor",generator.translate("associationOne",av));
    Assert.assertEquals("mentors",generator.translate("associationMany",av));
    Assert.assertEquals("mentor",generator.translate("attributeOne",av));
    Assert.assertEquals("mentors",generator.translate("attributeMany",av));
    Assert.assertEquals("addMentor",generator.translate("addMethod",av));
    Assert.assertEquals("removeMentor",generator.translate("removeMethod",av));
    Assert.assertEquals("setMentor",generator.translate("setMethod",av));
    Assert.assertEquals("exitMentor",generator.translate("exitMethod",av));
    Assert.assertEquals("doExitMentor",generator.translate("doExitMethod",av));
    Assert.assertEquals("getMentor",generator.translate("getMethod",av));
    Assert.assertEquals("newMentors",generator.translate("parameterMany",av));
    Assert.assertEquals("aNewMentor",generator.translate("parameterNew",av));
    Assert.assertEquals("allMentors",generator.translate("parameterAll",av));
    Assert.assertEquals("nextMentor",generator.translate("parameterNext",av));
    Assert.assertEquals("setMentors",generator.translate("setManyMethod",av));
    Assert.assertEquals("didAddMentors",generator.translate("didAddMany",av));
    Assert.assertEquals("didAddMentor",generator.translate("didAdd",av));
    Assert.assertEquals("numberOfMentors",generator.translate("numberOfMethod",av));
    Assert.assertEquals("indexOfMentor",generator.translate("indexOfMethod",av));
    Assert.assertEquals("isNumberOfMentorsValid",generator.translate("isNumberOfValidMethod",av));
    Assert.assertEquals("verifiedMentors",generator.translate("parameterVerifiedMany",av));
    Assert.assertEquals("oldMentors",generator.translate("parameterOldMany",av));
    Assert.assertEquals("anOldMentor",generator.translate("parameterOld",av));
    Assert.assertEquals("existingMentor",generator.translate("parameterExisting",av));
    Assert.assertEquals("checkNewMentors",generator.translate("parameterCheckNewMany",av));
    Assert.assertEquals("isNewMentor",generator.translate("parameterIsNew",av));
    Assert.assertEquals("newMentor",generator.translate("associationNew",av));
    Assert.assertEquals("copyOfMentors",generator.translate("parameterCopyOfMany",av));
    Assert.assertEquals("canSetMentor",generator.translate("canSetMethod",av));
    Assert.assertEquals("currentMentor",generator.translate("parameterCurrent",av));
    Assert.assertEquals("deleteMentor",generator.translate("deleteMethod",av));
    Assert.assertEquals("requiredNumberOfMentors",generator.translate("requiredNumberOfMethod",av));

    if (relatedAv == null)
    {
      return;
    }
    
    Assert.assertEquals("aStudent",generator.translate("parameterOne",relatedAv));
    Assert.assertEquals("placeholderStudent",generator.translate("removeParameterOne",relatedAv));    
    Assert.assertEquals("2",generator.translate("parameterValue",relatedAv));
    Assert.assertEquals("student",generator.translate("associationOne",relatedAv));
    Assert.assertEquals("students",generator.translate("associationMany",relatedAv));
    Assert.assertEquals("student",generator.translate("attributeOne",relatedAv));
    Assert.assertEquals("students",generator.translate("attributeMany",relatedAv));
    Assert.assertEquals("addStudent",generator.translate("addMethod",relatedAv));
    Assert.assertEquals("removeStudent",generator.translate("removeMethod",relatedAv));
    Assert.assertEquals("setStudent",generator.translate("setMethod",relatedAv));
    Assert.assertEquals("exitStudent",generator.translate("exitMethod",relatedAv));    
    Assert.assertEquals("doExitStudent",generator.translate("doExitMethod",relatedAv));    
    Assert.assertEquals("resetStudent",generator.translate("resetMethod",relatedAv));
    Assert.assertEquals("newStudents",generator.translate("parameterMany",relatedAv));
    Assert.assertEquals("aNewStudent",generator.translate("parameterNew",relatedAv));
    Assert.assertEquals("allStudents",generator.translate("parameterAll",relatedAv));
    Assert.assertEquals("nextStudent",generator.translate("parameterNext",relatedAv));
    Assert.assertEquals("setStudents",generator.translate("setManyMethod",relatedAv));
    Assert.assertEquals("didAddStudents",generator.translate("didAddMany",relatedAv));
    Assert.assertEquals("didAddStudent",generator.translate("didAdd",relatedAv));
    Assert.assertEquals("numberOfStudents",generator.translate("numberOfMethod",relatedAv));
    Assert.assertEquals("indexOfStudent",generator.translate("indexOfMethod",relatedAv));
    Assert.assertEquals("isNumberOfStudentsValid",generator.translate("isNumberOfValidMethod",relatedAv));
    Assert.assertEquals("minimumNumberOfStudents",generator.translate("minimumNumberOfMethod",relatedAv));
    Assert.assertEquals("maximumNumberOfStudents",generator.translate("maximumNumberOfMethod",relatedAv));
    Assert.assertEquals("verifiedStudents",generator.translate("parameterVerifiedMany",relatedAv));
    Assert.assertEquals("oldStudents",generator.translate("parameterOldMany",relatedAv));
    Assert.assertEquals("anOldStudent",generator.translate("parameterOld",relatedAv));
    Assert.assertEquals("existingStudent",generator.translate("parameterExisting",relatedAv));
    Assert.assertEquals("checkNewStudents",generator.translate("parameterCheckNewMany",relatedAv));
    Assert.assertEquals("isNewStudent",generator.translate("parameterIsNew",relatedAv));
    Assert.assertEquals("newStudent",generator.translate("associationNew",relatedAv));
    Assert.assertEquals("copyOfStudents",generator.translate("parameterCopyOfMany",relatedAv));
    Assert.assertEquals("canSetStudent",generator.translate("canSetMethod",relatedAv));
    Assert.assertEquals("currentStudent",generator.translate("parameterCurrent",relatedAv));
    Assert.assertEquals("deleteStudent",generator.translate("deleteMethod",relatedAv));
    Assert.assertEquals("requiredNumberOfStudents",generator.translate("requiredNumberOfMethod",relatedAv));
    

  }    
  
  private void assertIgnoreMany(int lowerOne, int upperOne, int lowerTwo, int upperTwo)
  {
    UmpleClass c = model.addUmpleClass("Student");
    UmpleClass c2 = model.addUmpleClass("Mentor");

    AssociationVariable av = new AssociationVariable("mentor","Mentor",null,null,createMultiplicity(lowerOne,upperOne),true);
    AssociationVariable relatedAv = new AssociationVariable("student","Student",null,null,createMultiplicity(lowerTwo,upperTwo),true);
    av.setRelatedAssociation(relatedAv);
    
    c.addAssociationVariable(av);
    Attribute attr = new Attribute("id","Integer",null,null,false,c);

    c2.addAssociationVariable(relatedAv);
    attr = new Attribute("name","String",null,null,false,c2);
    
    generator.prepare();
    GeneratedClass g = c.getGeneratedClass();
    Assert.assertEquals("int aId",g.getLookup("constructorSignature"));
    Assert.assertEquals("aId",g.getLookup("constructorSignature_caller"));

    GeneratedClass g2 = c2.getGeneratedClass();
    Assert.assertEquals("String aName",g2.getLookup("constructorSignature"));
    Assert.assertEquals("aName",g2.getLookup("constructorSignature_caller"));  
    }

  private void assertImport(UmpleClass c, String... expectedImports)
  {
    GeneratedClass g = c.getGeneratedClass();
    String[] actualImports = g.getMultiLookup("import");
    Assert.assertEquals(expectedImports.length,actualImports.length);
    
    for (int i=0; i<actualImports.length; i++)
    {
      Assert.assertEquals(expectedImports[i],actualImports[i]);  
    }
  }

  private UmpleModel parse(String input)
  {
    UmpleParser parser = UmpleParserFactory.create(umpleParserName,true);
    parser.parse("program", input);
    parser.analyze(false);
    UmpleModel model = parser.getModel();
    JavaGenerator generator = new JavaGenerator();
    generator.setModel(model);
    generator.prepare();
    return model;
  }
  
  private UmpleModel createModelFromFile(String pathToInput, String fileName){
	    File umpleFile = new File(pathToInput + fileName);
		UmpleFile umpFile  = new  UmpleFile(umpleFile);
		UmpleModel umpModel = new UmpleModel(umpFile);   
		model = umpModel;
		return model;	  
	  }

  private Multiplicity createMultiplicity(int lower, int upper)
  {
    Multiplicity m = new Multiplicity();
    m.setRange(lower + "", upper + "");
    return m;
  }
}
