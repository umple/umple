/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/
package cruise.umple.compiler;

public interface CodeTranslator
{
  // TODO: LH#171
  //String translate(String id, AssociationVariable associationVariable);
  // ABSTRACT METHODS 

 public String translate(String id, Attribute attribute);
 public String translate(String id, StateMachine stm);
}