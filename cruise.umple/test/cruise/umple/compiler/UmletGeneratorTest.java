package cruise.umple.compiler;

import org.junit.*;

import cruise.umple.util.AssertHelper;

public class UmletGeneratorTest
{
  
  UmletGenerator c;
  
  @Before
  public void setUp()
  {
    c = new UmletGenerator();
  }

  @Test
  public void CreateUmletGeneratorFromUmpleSystem_Classes()
  {
    UmpleModel model = new UmpleModel(null);
    
    model.addUmpleClass("Mentor");
    model.addUmpleClass("Student");
    
    
    c.draw(model);
    
    UmletElement class1 = c.getClassElement(0);
    UmletElement class2 = c.getClassElement(1);
    
    if (isClass("Student",class1))
    {
      assertClass("Student",class1);
      assertClass("Mentor",class2);
    }
    else
    {
      assertClass("Student",class2);
      assertClass("Mentor",class1);
    }
  }
  
  @Test
  public void CreateUmletGeneratorFromUmpleSystem_Associations()
  {
    UmpleModel model = new UmpleModel(null);
    
    model.addUmpleClass("Mentor");
    model.addUmpleClass("Student");
    
    AssociationEnd end1 = new AssociationEnd("mentor","Mentor",null,"Student",createMultiplicity(0, 1));
    AssociationEnd end2 = new AssociationEnd("student","Student",null,"Mentor",createMultiplicity(0,-1));
    Association association = new Association(true,true,end1,end2);
    model.addAssociation(association);
    
    UmletGenerator UmletGenerator = new UmletGenerator();
    UmletGenerator.draw(model);
    
    String result1 = "lt=-\nm1=0..1\nm2=*\nr1=mentor\nr2=student";
    String result2 = "lt=-\nm1=*\nm2=0..1\nr1=student\nr2=mentor";
    
    AssertHelper.assertEitherEquals(result1,result2,UmletGenerator.getAssociationElement(0).getPanelAttributes());
  }

  private boolean isClass(String className, UmletElement classElement)
  {
    UmletElement expected = c.newClass(className);
    return expected.getPanelAttributes().equals(classElement.getPanelAttributes());
  }

  private void assertClass(String className, UmletElement classElement)
  {
    UmletElement expected = c.newClass(className);
    Assert.assertEquals(expected.getPanelAttributes(),classElement.getPanelAttributes());
  }
  

  @Test
  public void newClass_attributes()
  {
    UmletElement e = c.newClass("Mentor");
    Assert.assertEquals("Mentor\n--",e.getPanelAttributes());
    Assert.assertEquals("com.umlet.element.base.Class",e.getType());
    Assert.assertEquals("",e.getAdditionalAttributes());
  }
  
  @Test
  public void newClass_addsIt()
  {
    UmletElement e = c.newClass("Mentor");
    Assert.assertEquals(e,c.getClassElement(0));
  }  

  @Test
  public void newAssociation_addsIt()
  {
    UmletElement class1 = new UmletElement("class","Mentor","",new Coordinate(10,20,50,100));
    UmletElement class2 = new UmletElement("class","Student","",new Coordinate(30,260,150,200));
    UmletElement association = c.newAssociation(class1,class2,"0..*", "0..1", "mentor", "student");
    Assert.assertEquals(association,c.getAssociationElement(0));
  }  

  
  @Test
  public void newClass_coordinates()
  {
    UmletElement e = c.newClass("Mentor");
    Coordinate c = e.getCoordinate();
    Assert.assertEquals(new Coordinate(40,20,100,100),c);
  }  
  
  
  @Test
  public void newAssociation_topToBottom()
  {
    UmletElement class1 = new UmletElement("class","Mentor","",new Coordinate(10,20,50,100));
    UmletElement class2 = new UmletElement("class","Student","",new Coordinate(30,260,150,200));
    
    UmletElement association = c.newAssociation(class1,class2,"0..*", "0..1", "mentor", "student");

    Assert.assertEquals("com.umlet.element.base.Relation",association.getType());
    Assert.assertEquals("lt=-\nm1=0..*\nm2=0..1\nr1=mentor\nr2=student",association.getPanelAttributes());
    Assert.assertEquals("70;140;0;0", association.getAdditionalAttributes());
    Assert.assertEquals(new Coordinate(35,120,1,1),association.getCoordinate());
    
    
    UmletElement association2 = c.newAssociation(class2,class1,"0..1","0..*", "student","mentor");
    Assert.assertEquals("com.umlet.element.base.Relation",association2.getType());
    Assert.assertEquals("lt=-\nm1=0..*\nm2=0..1\nr1=mentor\nr2=student",association2.getPanelAttributes());
    Assert.assertEquals("70;140;0;0", association2.getAdditionalAttributes());
    Assert.assertEquals(new Coordinate(35,120,1,1),association2.getCoordinate());
    
  }
  
  @Test
  public void newAssociation_leftToRight()
  {
    UmletElement leftClass = new UmletElement("class","Mentor","",new Coordinate(10,20,50,100));
    UmletElement rightClass = new UmletElement("class","Student","",new Coordinate(530,20,150,200));
    
    UmletElement association = c.newAssociation(leftClass,rightClass,"0..*", "0..1", "mentor", "student");
    
    Assert.assertEquals("com.umlet.element.base.Relation",association.getType());
    Assert.assertEquals("lt=-\nm1=0..*\nm2=0..1\nr1=mentor\nr2=student",association.getPanelAttributes());
    Assert.assertEquals("470;50;0;0", association.getAdditionalAttributes());
    Assert.assertEquals(new Coordinate(60,70,1,1),association.getCoordinate());
    
    
    UmletElement association2 = c.newAssociation(rightClass,leftClass,"0..1","0..*", "student","mentor");
    Assert.assertEquals("com.umlet.element.base.Relation",association2.getType());
    Assert.assertEquals("lt=-\nm1=0..*\nm2=0..1\nr1=mentor\nr2=student",association2.getPanelAttributes());
    Assert.assertEquals("470;50;0;0", association2.getAdditionalAttributes());
    Assert.assertEquals(new Coordinate(60,70,1,1),association2.getCoordinate());
    
  }  
  
  @Test
  public void newClass_growCoordinates()
  {
    Assert.assertEquals(new Coordinate(40,20,100,100),c.newClass("X").getCoordinate());
    Assert.assertEquals(new Coordinate(240,20,100,100),c.newClass("X").getCoordinate());
    Assert.assertEquals(new Coordinate(240,220,100,100),c.newClass("X").getCoordinate());
    Assert.assertEquals(new Coordinate(40,220,100,100),c.newClass("X").getCoordinate());
  }   
  
  @Test
  public void toXml()
  {
    UmletElement class1 = c.newClass("Mentor");
    UmletElement class2 = c.newClass("Mentor");
    UmletElement association = c.newAssociation(class1,class2,"0..*", "0..1", "mentor", "student");
    
    UmletDiagram diagram = new UmletDiagram();
    diagram.addUmletElement(class1);
    diagram.addUmletElement(class2);
    diagram.addUmletElement(association);
    
    String expected = diagram.toXml();
    String actual = c.toXml();
    Assert.assertEquals(expected,actual);
    
  }

  private Multiplicity createMultiplicity(int lower, int upper)
  {
    Multiplicity m = new Multiplicity();
    m.setRange(lower + "", upper + "");
    return m;
  }
}
