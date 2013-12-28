/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE ${last.version} modeling language!*/
package cruise.umple.compiler;

public interface CodeGenerator
{
  
  // ABSTRACT METHODS 

 public boolean setModel(UmpleModel aUmpleModel);
 public boolean setOutput(String aString);
 public void generate();
 public void prepare();
 public void postpare();
}