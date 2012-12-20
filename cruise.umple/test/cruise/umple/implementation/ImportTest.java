/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.implementation;

import org.junit.*;

import cruise.umple.compiler.*;
import cruise.umple.compiler.java.*;
import cruise.umple.util.SampleFileWriter;

public class ImportTest {

  @After
  public void tearDown()
  {
    SampleFileWriter.destroy("ump1.txt");
    SampleFileWriter.destroy("example");
  }  
  
  @Test
  public void Time()
  {
    SampleFileWriter.createFile("ump1.txt","namespace example;\nclass HasTime { Time t; Time t2; }\nclass NoTime {}\n");
    
    UmpleFile file = new UmpleFile("ump1.txt");
    UmpleModel model = new UmpleModel(file);
    model.run();
    model.generate();
    
    JavaClassGenerator generator = new JavaClassGenerator();
    
    UmpleClass hasTime = model.getUmpleClass("HasTime");
    String code = generator.getCode(model,hasTime);
    Assert.assertEquals(true, code.indexOf("import java.sql.Time;") != -1);
    Assert.assertEquals(code.indexOf("import java.sql.Time;"), code.lastIndexOf("import java.sql.Time;"));
    

    UmpleClass noTime = model.getUmpleClass("NoTime");
    code = generator.getCode(model,noTime);
    Assert.assertEquals(-1, code.indexOf("import java.sql.Time;"));
    
  }
  
  @Test
  public void Date()
  {
    SampleFileWriter.createFile("ump1.txt","namespace example;\nclass HasDate { Date d; Date d2; }\nclass NoDate {}\n");
    
    UmpleFile file = new UmpleFile("ump1.txt");
    UmpleModel model = new UmpleModel(file);
    model.run();
    model.generate();
    
    JavaClassGenerator generator = new JavaClassGenerator();
    
    UmpleClass hasDate = model.getUmpleClass("HasDate");
    String code = generator.getCode(model,hasDate);
    
    Assert.assertEquals(true, code.indexOf("import java.sql.Date;") != -1);
    Assert.assertEquals(code.indexOf("import java.sql.Date;"), code.lastIndexOf("import java.sql.Date;"));
    
    UmpleClass noDate = model.getUmpleClass("NoDate");
    code = generator.getCode(model,noDate);
    Assert.assertEquals(-1, code.indexOf("import java.sql.Date;"));
  }  
  
  
}
