/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.28.0.4148.608b7c78e modeling language!*/
package cruise.umple.testgenerator;
import java.io.*;
import java.util.*;
import cruise.umple.util.*;
import cruise.umple.compiler.exceptions.*;
import cruise.umple.compiler.UmpleModel;
// line 3 "../../../../ump/TestCaseTemplate_Generator.ump"
public interface TestCaseGenerator
{
  
  // ABSTRACT METHODS 

 public boolean setModel(UmpleModel model);
 public void setCredential();
 public void prepare();
 public void generate();
 public void writeFile(TestSuite ts);
}