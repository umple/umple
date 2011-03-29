package cruise.umple.compiler;

import org.junit.*;

public class VioletDiagramTest
{

  VioletDiagram d;
  
  @Before
  public void setUp()
  {
    d = new VioletDiagram();
  }
  
  @Test
  public void ToXml_empty()
  {
    String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><java version=\"1.6.0_04\" class=\"java.beans.XMLDecoder\">";
    expected += "<object class=\"com.horstmann.violet.ClassDiagramGraph\">";
    expected += "</object></java>";
    assertXml(d,expected);
  }
  
  @Test
  public void toXml_oneClass()
  {
    d.addVioletClass(new VioletClass("Student",10.1,10.2));
    
    String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><java version=\"1.6.0_04\" class=\"java.beans.XMLDecoder\">";
    expected += "<object class=\"com.horstmann.violet.ClassDiagramGraph\">";
    expected += "<void method=\"addNode\"><object id=\"ClassNodeStudent\" class=\"com.horstmann.violet.ClassNode\"><void property=\"name\"><void property=\"text\"><string>Student</string></void></void></object><object class=\"java.awt.geom.Point2D$Double\"><void method=\"setLocation\"><double>10.1</double><double>10.2</double></void></object></void>";
    expected += "</object></java>";
    assertXml(d,expected);
    
  }  
  
  @Test
  public void toXml_multipleClasses()
  {
    
    VioletClass v1 = new VioletClass("Student",10.1,10.2);
    VioletClass v2 = new VioletClass("Mentor",20.1,20.2);
    
    d.addVioletClass(v1);
    d.addVioletClass(v2);
    
    String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><java version=\"1.6.0_04\" class=\"java.beans.XMLDecoder\">";
    expected += "<object class=\"com.horstmann.violet.ClassDiagramGraph\">";
    expected += "<void method=\"addNode\"><object id=\"ClassNodeStudent\" class=\"com.horstmann.violet.ClassNode\"><void property=\"name\"><void property=\"text\"><string>Student</string></void></void></object><object class=\"java.awt.geom.Point2D$Double\"><void method=\"setLocation\"><double>10.1</double><double>10.2</double></void></object></void>";
    expected += "<void method=\"addNode\"><object id=\"ClassNodeMentor\" class=\"com.horstmann.violet.ClassNode\"><void property=\"name\"><void property=\"text\"><string>Mentor</string></void></void></object><object class=\"java.awt.geom.Point2D$Double\"><void method=\"setLocation\"><double>20.1</double><double>20.2</double></void></object></void>";
    expected += "</object></java>";
    assertXml(d,expected);
  }  
  
  @Test
  public void toXml_inheritance()
  {
    VioletClass v1 = new VioletClass("Student",10.1,10.2);
    VioletClass v2 = new VioletClass("Mentor",20.1,20.2);
    v2.setParentClass(v1);
    
    d.addVioletClass(v1);
    d.addVioletClass(v2);
    
    String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><java version=\"1.6.0_04\" class=\"java.beans.XMLDecoder\">";
    expected += "<object class=\"com.horstmann.violet.ClassDiagramGraph\">";
    expected += "<void method=\"addNode\"><object id=\"ClassNodeStudent\" class=\"com.horstmann.violet.ClassNode\"><void property=\"name\"><void property=\"text\"><string>Student</string></void></void></object><object class=\"java.awt.geom.Point2D$Double\"><void method=\"setLocation\"><double>10.1</double><double>10.2</double></void></object></void>";
    expected += "<void method=\"addNode\"><object id=\"ClassNodeMentor\" class=\"com.horstmann.violet.ClassNode\"><void property=\"name\"><void property=\"text\"><string>Mentor</string></void></void></object><object class=\"java.awt.geom.Point2D$Double\"><void method=\"setLocation\"><double>20.1</double><double>20.2</double></void></object></void>";
    expected += "<void method=\"connect\">";
    expected += "<object class=\"com.horstmann.violet.ClassRelationshipEdge\"><void property=\"bentStyle\"><object class=\"com.horstmann.violet.BentStyle\" field=\"VHV\"/></void><void property=\"endArrowHead\"><object class=\"com.horstmann.violet.ArrowHead\" field=\"TRIANGLE\"/></void></object>";
    expected += "<object idref=\"ClassNodeMentor\"/>";
    expected += "<object idref=\"ClassNodeStudent\"/>";
    expected += "</void>";
    expected += "</object></java>";
    assertXml(d,expected);
  }
  
  @Test
  public void toXml_association()
  {
    
    VioletClass v1 = new VioletClass("Student",10.1,10.2);
    VioletClass v2 = new VioletClass("Mentor",20.1,20.2);
    VioletAssociation a1 = new VioletAssociation("0..1","*",v1,v2);
    
    d.addVioletClass(v1);
    d.addVioletClass(v2);
    d.addVioletAssociation(a1);
    
    
    String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?><java version=\"1.6.0_04\" class=\"java.beans.XMLDecoder\">";
    expected += "<object class=\"com.horstmann.violet.ClassDiagramGraph\">";
    expected += "<void method=\"addNode\"><object id=\"ClassNodeStudent\" class=\"com.horstmann.violet.ClassNode\"><void property=\"name\"><void property=\"text\"><string>Student</string></void></void></object><object class=\"java.awt.geom.Point2D$Double\"><void method=\"setLocation\"><double>10.1</double><double>10.2</double></void></object></void>";
    expected += "<void method=\"addNode\"><object id=\"ClassNodeMentor\" class=\"com.horstmann.violet.ClassNode\"><void property=\"name\"><void property=\"text\"><string>Mentor</string></void></void></object><object class=\"java.awt.geom.Point2D$Double\"><void method=\"setLocation\"><double>20.1</double><double>20.2</double></void></object></void>";
    expected += "<void method=\"connect\">";
    expected += "<object class=\"com.horstmann.violet.ClassRelationshipEdge\">";
    expected += "<void property=\"bentStyle\"><object class=\"com.horstmann.violet.BentStyle\" field=\"HVH\"/></void>";
    expected += "<void property=\"startLabel\"><string>0..1</string></void>";
    expected += "<void property=\"endLabel\"><string>*</string></void>";
    expected += "</object>";
    expected += "<object idref=\"ClassNodeStudent\"/>";
    expected += "<object idref=\"ClassNodeMentor\"/>";
    expected += "</void>";
    expected += "</object></java>";
    assertXml(d,expected);
    
  }   
    
  private void assertXml(VioletDiagram d, String expected)
  {
    Assert.assertEquals(expected,d.toXml());
  }
  
}
