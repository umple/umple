/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;


import static org.junit.Assert.*;

import org.junit.*;
import cruise.umple.util.SampleFileWriter;

public class DiagramTest
{

  UmpleFile uFile;
  UmpleModel model;

  @Before
  public void setUp()
  {
    SampleFileWriter.createFile("model.ump", "class Student {}");
    uFile = new UmpleFile("model.ump");
    model = new UmpleModel(new UmpleFile("model.ump"));
  }

  @After
  public void tearDown()
  {
    SampleFileWriter.destroy("model.ump");
  }

  @Test
  public void byDefaultNoDiagramsPresent()
  {
    assertEquals(null, model.getDiagram());
  }

  @Test
  public void isSettableInModel()
  {
    Diagram d = new Diagram();
    model.setDiagram(d);
    assertEquals(d, model.getDiagram());
  }

}