/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package net.n3.nanoxml;
import java.io.Reader;
import java.io.IOException;
import java.util.Properties;

public class IXMLValidator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public IXMLValidator()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public void setParameterEntityResolver(IXMLEntityResolver resolver);
/**
    * Returns the parameter entity resolver.
    *
    * @return the entity resolver.
    */
   public IXMLEntityResolver getParameterEntityResolver();
/**
    * Parses the DTD. The validator object is responsible for reading the
    * full DTD.
    *
    * @param publicID       the public ID, which may be null.
    * @param reader         the reader to read the DTD from.
    * @param entityResolver the entity resolver.
    * @param external       true if the DTD is external.
    *
    * @throws java.lang.Exception
    *     If something went wrong.
    */
   public void parseDTD(String             publicID,
                        IXMLReader         reader,
                        IXMLEntityResolver entityResolver,
                        boolean            external)
      throws Exception;
/**
    * Indicates that an element has been started.
    *
    * @param name       the name of the element.
    * @param systemId   the system ID of the XML data of the element.
    * @param lineNr     the line number in the XML data of the element.
    *
    * @throws java.lang.Exception
    *     If the element could not be validated.
    */
   public void elementStarted(String name,
                              String systemId,
                              int    lineNr)
      throws Exception;
/**
    * Indicates that the current element has ended.
    *
    * @param name       the name of the element.
    * @param systemId   the system ID of the XML data of the element.
    * @param lineNr     the line number in the XML data of the element.
    *
    * @throws java.lang.Exception
    *     If the element could not be validated.
    */
   public void elementEnded(String name,
                            String systemId,
                            int    lineNr)
      throws Exception;
/**
    * Indicates that an attribute has been added to the current element.
    *
    * @param key        the name of the attribute.
    * @param value      the value of the attribute.
    * @param systemId   the system ID of the XML data of the element.
    * @param lineNr     the line number in the XML data of the element.
    *
    * @throws java.lang.Exception
    *     If the attribute could not be validated.
    */
   public void attributeAdded(String key,
                              String value,
                              String systemId,
                              int    lineNr)
      throws Exception;
/**
    * This method is called when the attributes of an XML element have been
    * processed.
    * If there are attributes with a default value which have not been
    * specified yet, they have to be put into <I>extraAttributes</I>.
    *
    * @param name            the name of the element.
    * @param extraAttributes where to put extra attributes.
    * @param systemId        the system ID of the XML data of the element.
    * @param lineNr          the line number in the XML data of the element.
    *
    * @throws java.lang.Exception
    *     if the element could not be validated.
    */
   public void elementAttributesProcessed(String     name,
                                          Properties extraAttributes,
                                          String     systemId,
                                          int        lineNr)
      throws Exception;
/**
    * Indicates that a new #PCDATA element has been encountered.
    *
    * @param systemId the system ID of the XML data of the element.
    * @param lineNr   the line number in the XML data of the element.
    *
    * @throws java.lang.Exception
    *     if the element could not be validated.
    */
   public void PCDataAdded(String systemId,
                           int    lineNr)
      throws Exception;
}