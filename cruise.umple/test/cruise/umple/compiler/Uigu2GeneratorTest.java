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
import java.nio.file.*;

public class Uigu2GeneratorTest
{
  Uigu2Generator generator;
  UmpleModel model;
  List<String> defaultFiles;

  @Before
  public void setUp()
  {
//  model = new UmpleModel(null);
//  generator = new Uigu2Generator();
//  generator.setModel(model);
    defaultFiles = new ArrayList<String>();
    defaultFiles.add("setup.php");
    defaultFiles.add("app/kissmvc_core.php");
    defaultFiles.add("app/kissmvc_uigu2.php");
    defaultFiles.add("app/views/layout.php");
    defaultFiles.add("app/views/layout.css");
    defaultFiles.add("app/views/main/index.php");
    defaultFiles.add("app/views/main/show_element.php");
    defaultFiles.add("app/controllers/main/index.php");
    defaultFiles.add("app/controllers/main/clear.php");
    defaultFiles.add("app/controllers/main/show_element.php");
    defaultFiles.add("app/controllers/main/new_instance.php");
  }

  @Test
  public void defaultFilesPresent() throws IOException
  {
    Path uigu2RootPath = Paths.get("../umpleonline/scripts/uigu2");
    for(String filePath : defaultFiles){
      Path p = uigu2RootPath.resolve(filePath);
      //throws NoSuchFileException if file doesn't exist
      p.toRealPath();
    }
  }
} 
