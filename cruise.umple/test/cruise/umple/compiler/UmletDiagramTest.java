/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import org.junit.*;

public class UmletDiagramTest
{

  UmletDiagram d;
  
  @Before
  public void setUp()
  {
    d = new UmletDiagram();
  }
  
  @Test
  public void ToXml_empty()
  {
    assertXml(d,"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><umlet_diagram></umlet_diagram>");
  }
  
  @Test
  public void toXml_oneEntity()
  {
    d.addUmletElement(new UmletElement("aClass","myAttr","addAttr",new Coordinate(1,2,3,4)));
    
    String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><umlet_diagram>";
    expected += "<element><type>aClass</type><coordinates><x>1</x><y>2</y><w>3</w><h>4</h></coordinates><panel_attributes>myAttr</panel_attributes><additional_attributes>addAttr</additional_attributes></element>";
    expected += "</umlet_diagram>";
    assertXml(d,expected);
    
  }
  
  @Test
  public void toXml_multipleEntities()
  {
    d.addUmletElement(new UmletElement("aClass","myAttr","addAttr",new Coordinate(1,2,3,4)));
    d.addUmletElement(new UmletElement("yourClass","yourAttr","yourAddAttr",new Coordinate(5,6,7,8)));
    
    String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><umlet_diagram>";
    expected += "<element><type>aClass</type><coordinates><x>1</x><y>2</y><w>3</w><h>4</h></coordinates><panel_attributes>myAttr</panel_attributes><additional_attributes>addAttr</additional_attributes></element>";
    expected += "<element><type>yourClass</type><coordinates><x>5</x><y>6</y><w>7</w><h>8</h></coordinates><panel_attributes>yourAttr</panel_attributes><additional_attributes>yourAddAttr</additional_attributes></element>";
    expected += "</umlet_diagram>";
    assertXml(d,expected);
    
  }  
    
  private void assertXml(UmletDiagram d, String expected)
  {
    Assert.assertEquals(expected,d.toXml());
  }
  
}
