/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package net.n3.nanoxml;

public class XMLAttribute
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public XMLAttribute()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private String fullName;
/**
    * The short name of the attribute.
    */
   private String name;
/**
    * The namespace URI of the attribute.
    */
   private String namespace;
/**
    * The value of the attribute.
    */
   private String value;
/**
    * The type of the attribute.
    */
   private String type;
/**
    * Returns the full name of the attribute.
    */
   String getFullName()
   {
      return this.fullName;
   }
/**
    * Returns the short name of the attribute.
    */
   String getName()
   {
      return this.name;
   }
/**
    * Returns the namespace of the attribute.
    */
   String getNamespace()
   {
      return this.namespace;
   }
/**
    * Returns the value of the attribute.
    */
   String getValue()
   {
      return this.value;
   }
/**
    * Sets the value of the attribute.
    *
    * @param value the new value.
    */
   void setValue(String value)
   {
      this.value = value;
   }
/**
    * Returns the type of the attribute.
    */
   String getType()
   {
      return this.type;
   }
}