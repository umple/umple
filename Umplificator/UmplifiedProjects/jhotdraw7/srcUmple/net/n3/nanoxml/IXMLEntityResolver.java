/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package net.n3.nanoxml;
import java.util.Hashtable;
import java.io.Reader;
import java.io.StringReader;

public class IXMLEntityResolver
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public IXMLEntityResolver()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public void addInternalEntity(String name,
                                 String value);
/**
    * Adds an external entity.
    *
    * @param name     the name of the entity.
    * @param publicID the public ID of the entity, which may be null.
    * @param systemID the system ID of the entity.
    */
   public void addExternalEntity(String name,
                                 String publicID,
                                 String systemID);
/**
    * Returns a Java reader containing the value of an entity.
    *
    * @param xmlReader the current NanoXML reader.
    * @param name      the name of the entity.
    *
    * @return the reader, or null if the entity could not be resolved.
    *
    * @throws net.n3.nanoxml.XMLParseException
    *     If an exception occurred while resolving the entity.
    */
   public Reader getEntity(IXMLReader xmlReader,
                           String     name)
      throws XMLParseException;
/**
    * Returns true if an entity is external.
    *
    * @param name the name of the entity.
    */
   public boolean isExternalEntity(String name);
}