/*

 Copyright: All contributers to the Umple Project
 
 This file is made available subject to the open source license found at:
 http://umple.org/license

*/

package cruise.umple.compiler;

import cruise.umple.compiler.uigu2.*;
import org.junit.*;
import java.util.*;
import java.io.*;

public class Uigu2GeneratorTest
{
  Uigu2Generator generator;
  UmpleModel model;

  @Before
  public void setUp()
  {
    model = new UmpleModel(null);
    generator = new Uigu2Generator();
    generator.setModel(model);
  }

  @Test
  public void filesToCopyPresent()throws IOException
  {
    Map<String,String> files = generator.getSharedFilesToCopy();
    Iterator iterator = files.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<String, String> entry = (Map.Entry) iterator.next();
      InputStream from = this.getClass().getResourceAsStream(Uigu2Generator.packageFilesPath + entry.getKey());
      Assert.assertTrue(from != null && from.read() != -1);
    }
  }

} 
