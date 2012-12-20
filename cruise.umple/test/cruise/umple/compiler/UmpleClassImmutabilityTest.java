package cruise.umple.compiler;

import org.junit.*;

public class UmpleClassImmutabilityTest {

  @Test
  public void isImmutable()
  {
    UmpleClass c = new UmpleClass("Student");
    Assert.assertEquals(false, c.isImmutable());
    
    Assert.assertTrue(c.setImmutable());
    Assert.assertEquals(true, c.isImmutable());
  }
  
  @Test
  public void classImmutabilityRulesDontInterfereWithNonImmutableClassAssociations()
  {
    UmpleClass a = new UmpleClass("a");
    UmpleClass b = new UmpleClass("b");
    
    Multiplicity mult = new Multiplicity();
    mult.setRange("0", "1");
    
    // bidirectional association
    AssociationVariable aEnd = new AssociationVariable("a","a","","",mult,true);  
    AssociationVariable bEnd = new AssociationVariable("b","b","","",mult,true); 
    aEnd.setRelatedAssociation(bEnd);
    
    Assert.assertTrue(a.addAssociationVariable(aEnd));
    Assert.assertTrue(b.addAssociationVariable(bEnd));
    
    // unidirectional association
    aEnd = new AssociationVariable("a","a","","",mult,false);  
    bEnd = new AssociationVariable("b","b","","",mult,true);
    aEnd.setRelatedAssociation(bEnd);
    
    Assert.assertTrue(a.addAssociationVariable(aEnd));
    Assert.assertTrue(b.addAssociationVariable(bEnd));
    
    // state machine
    StateMachine sm = new StateMachine("machine");
    Assert.assertTrue(a.addStateMachine(sm));
  }
  
  @Test
  public void classImmutabilityCanNotBeChangedWithInvalidRelationships()
  {    
    // all state machines prevent immutability
    UmpleClass a = new UmpleClass("A");
    StateMachine sm = new StateMachine("machine");
    a.addStateMachine(sm);
    Assert.assertFalse(a.setImmutable());
    
    // classes cannot be made immutable if they already have bidirectional associations
    a = new UmpleClass("A");
    UmpleClass b = new UmpleClass("B");

    Multiplicity mult = new Multiplicity();
    mult.setRange("0","1");
    AssociationVariable aEnd = new AssociationVariable("a","a","","",mult,true);  
    AssociationVariable bEnd = new AssociationVariable("b","b","","",mult,true);   
  
    a.addAssociationVariable(aEnd);
    b.addAssociationVariable(bEnd);
    Assert.assertTrue(aEnd.setRelatedAssociation(bEnd));
    Assert.assertFalse(a.setImmutable());
    Assert.assertFalse(b.setImmutable());
    
    // "immutable -> mutable" is invalid
    a = new UmpleClass("A");
    b = new UmpleClass("B");
    aEnd = new AssociationVariable("a","a","","",mult,true);  
    bEnd = new AssociationVariable("b","b","","",mult,false);
    a.addAssociationVariable(aEnd);
    b.addAssociationVariable(bEnd);
    Assert.assertTrue(aEnd.setRelatedAssociation(bEnd));
    Assert.assertTrue(b.addStateMachine(sm));
    Assert.assertFalse(a.setImmutable());
    
    // valid associations: "?mutable? -> immutable" and "immutable -> immutable"
    a = new UmpleClass("A");
    b = new UmpleClass("B");
    aEnd = new AssociationVariable("a","a","","",mult,true);  
    bEnd = new AssociationVariable("b","b","","",mult,false);
    a.addAssociationVariable(aEnd);
    b.addAssociationVariable(bEnd);
    Assert.assertTrue(aEnd.setRelatedAssociation(bEnd));
    // ... "?mutable? -> immutable" 
    // ("??" indicates the class has no immutability violations added, but is not set as immutable)
    Assert.assertTrue(b.setImmutable());  
    // ... "immutable -> immutable"
    Assert.assertTrue(a.setImmutable());
    
    // valid association: "mutable -> immutable"
    // (mutable class has explicit immutability violations added)
    a = new UmpleClass("A");
    aEnd = new AssociationVariable("a","a","","",mult,true);  
    bEnd = new AssociationVariable("b","b","","",mult,false);
    a.addAssociationVariable(aEnd);
    b.addAssociationVariable(bEnd);
    a.addStateMachine(sm);
    Assert.assertTrue(b.setImmutable());
    
    // asymmetric reflexive association should succeed
    a = new UmpleClass("A");   
    AssociationVariable cEnd = new AssociationVariable("c","c","","",mult,true);  
    AssociationVariable dEnd = new AssociationVariable("d","d","","",mult,false); 
    cEnd.setRelatedAssociation(dEnd);
    a.addAssociationVariable(cEnd);
    a.addAssociationVariable(dEnd);
    
    Assert.assertTrue(a.setImmutable());
  }
  
  @Test
  public void immutabilityPropagatesToDescendantClasses()
  {
    // As soon as a descendant class is added, it knows if its ancestor is immutable
    UmpleClass g1 = new UmpleClass("Generation1");
    UmpleClass g2 = new UmpleClass("Generation2");
    UmpleClass g3 = new UmpleClass("Generation3");
    Assert.assertTrue(g1.setImmutable());
    Assert.assertTrue(g2.setExtendsClass(g1));
    Assert.assertTrue(g2.isImmutable());
    Assert.assertTrue(g3.setExtendsClass(g2));
    Assert.assertTrue(g3.isImmutable());
   
    // Changes to ancestor's immutability propagates to descendants
    g1 = new UmpleClass("Generation1");
    g2 = new UmpleClass("Generation2");
    g3 = new UmpleClass("Generation3");
    g2.setExtendsClass(g1);
    g3.setExtendsClass(g2);
   
    Assert.assertTrue(g1.setImmutable());
    Assert.assertTrue(g2.isImmutable());
    Assert.assertTrue(g3.isImmutable()); 
   
    // removing the superclass removes the immutability constraint on the subclass
    Assert.assertTrue(g3.setExtendsClass(null));
    Assert.assertFalse(g3.isImmutable());
  }
  
  @Test
  public void immutabilityPropagatesToAllRelationshipsOfDescendantClasses()
  {
    UmpleClass g1 = new UmpleClass("Generation1");
    UmpleClass g2 = new UmpleClass("Generation2");
    UmpleClass g3 = new UmpleClass("Generation3");
    UmpleClass clazz = new UmpleClass("Clazz");
    clazz.setImmutable();
    
    Assert.assertTrue(g2.setExtendsClass(g1));
    Assert.assertTrue(g3.setExtendsClass(g2));

    Attribute attr = new Attribute("a",null,null,null,false,g3);
    
    AssociationVariable cEnd = new AssociationVariable("c","c","","",createMultiplicity(0,0),true);  
    AssociationVariable dEnd = new AssociationVariable("d","d","","",createMultiplicity(0,1),false);
    cEnd.setRelatedAssociation(dEnd);
    g3.addAssociationVariable(cEnd);
    clazz.addAssociationVariable(dEnd);
    
    Assert.assertFalse(attr.isImmutable());
    Assert.assertFalse(cEnd.isImmutable());
    Assert.assertFalse(dEnd.isImmutable());
    
    Assert.assertTrue(g1.setImmutable());
    
    Assert.assertTrue(attr.isImmutable());
    Assert.assertTrue(cEnd.isImmutable());
    Assert.assertTrue(dEnd.isImmutable());
  }
  
  @Test
  public void subclassCannotBeImutableIfSuperclassIsMutable()
  {
    // g1 can not be made mutable as long as it has a descendant that has been specifically set as immutable.
    UmpleClass g1 = new UmpleClass("Generation1");
    UmpleClass g2 = new UmpleClass("Generation2");
    UmpleClass g3 = new UmpleClass("Generation3");
    g2.setExtendsClass(g1);
    g3.setExtendsClass(g2);
    Assert.assertFalse(g3.setImmutable());
    
    Assert.assertTrue(g3.setExtendsClass(null));
    Assert.assertTrue(g3.setImmutable());
    Assert.assertFalse(g3.addStateMachine(new StateMachine("sm")));
  }
  
  @Test
  public void superclassCannotBeImmutableIfSubclassesCannotBeImmutable()
  {
    UmpleClass superclass = new UmpleClass("superclass");
    
    // state machine prevents immutability
    UmpleClass a = new UmpleClass("A");
    a.setExtendsClass(superclass);
    StateMachine sm = new StateMachine("sm");
    Assert.assertTrue(a.addStateMachine(sm));
    
    Assert.assertFalse(superclass.setImmutable());
    
    a.removeStateMachine(sm);
    Assert.assertTrue(superclass.setImmutable());
    
    // bidirectional association prevents immutability
    Multiplicity mult = new Multiplicity();
    mult.setRange("0", "1");
    AssociationVariable aEnd = new AssociationVariable("a","a","","",mult,true);  
    AssociationVariable bEnd = new AssociationVariable("b","b","","",mult,true); 
    a = new UmpleClass("A");
    superclass = new UmpleClass("superclass");
    a.setExtendsClass(superclass);
    
    a.addAssociationVariable(aEnd);
    aEnd.setRelatedAssociation(bEnd);
    Assert.assertFalse(superclass.setImmutable());
    
    a.removeAssociationVariable(aEnd);
    Assert.assertTrue(superclass.setImmutable());
    
    // unidirectional association "immutable -> mutable" prevents immutability
    aEnd = new AssociationVariable("a","a","","",mult,true);  
    bEnd = new AssociationVariable("b","b","","",mult,true); 
    aEnd.setRelatedAssociation(bEnd);
    
    a = new UmpleClass("A");
    UmpleClass b = new UmpleClass("B");
    superclass = new UmpleClass("superclass");
    a.setExtendsClass(superclass);
    b.addStateMachine(sm);
    
    Assert.assertTrue(a.addAssociationVariable(aEnd));
    Assert.assertTrue(b.addAssociationVariable(bEnd));
    Assert.assertFalse(superclass.setImmutable());
    
    a.removeAssociationVariable(aEnd);
    Assert.assertTrue(superclass.setImmutable());
  }

  @Test
  public void immutableClassCanOnlyExtendImmutableClass()
  {
    // Fails when superclass is not explicitly set as "immutable"
    UmpleClass superclass = new UmpleClass("superclass");
    UmpleClass subclass = new UmpleClass("Subclass");
    subclass.setExtendsClass(superclass);
    Assert.assertFalse(subclass.setImmutable());
    Assert.assertFalse(subclass.isImmutable());
    
    // Succeeds when superclass is explicitly immutable
    superclass.setImmutable();
    subclass = new UmpleClass("Subclass");
    Assert.assertTrue(subclass.setExtendsClass(superclass));
    Assert.assertTrue(subclass.setImmutable());
  }
  
  private Multiplicity createMultiplicity(int lower, int upper)
  {
    Multiplicity m = new Multiplicity();
    m.setRange(lower + "", upper + "");
    return m;
  }
}
