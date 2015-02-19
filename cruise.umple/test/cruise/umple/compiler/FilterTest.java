/*

 Copyright: All contributers to the Umple Project

 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;


import static org.junit.Assert.*;

import org.junit.*;
import cruise.umple.util.SampleFileWriter;

public class FilterTest
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
  public void byDefaultNoFilterPresent()
  {
    assertEquals(null, model.getFilter());
  }

  @Test
  public void isSettableInModel()
  {
    Filter d = new Filter();
    model.setFilter(d);
    //model.getDiagram().addValue("Student");
    assertEquals(d, model.getFilter());
    //System.out.println("The diagram in this model is: "+ model.getDiagram().toString());
  }

}