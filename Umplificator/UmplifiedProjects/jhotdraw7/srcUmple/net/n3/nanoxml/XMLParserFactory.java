/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package net.n3.nanoxml;
import java.io.IOException;
import java.security.AccessControlException;

public class XMLParserFactory
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public XMLParserFactory()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public static final String DEFAULT_CLASS = "net.n3.nanoxml.StdXMLParser";
/**
     * The Java properties key of the XML parser class name.
     */
    public static final String CLASS_KEY = "net.n3.nanoxml.XMLParser";
/**
     * Creates a default parser.
     *
     * @see #DEFAULT_CLASS
     * @see #CLASS_KEY
     *
     * @return the non-null parser.
     *
     * @throws java.lang.ClassNotFoundException
     *		if the class of the parser or validator could not be found.
     * @throws java.lang.InstantiationException
     *		if the parser could not be created
     * @throws java.lang.IllegalAccessException
     *		if the parser could not be created
     */
    public static IXMLParser createDefaultXMLParser()
    throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException {
        // BEGIN PATCH W. Randelshofer catch AccessControlException
        String className = XMLParserFactory.DEFAULT_CLASS;
        try {
            className = System.getProperty(XMLParserFactory.CLASS_KEY,
                    XMLParserFactory.DEFAULT_CLASS);
        } catch (AccessControlException e) {
            // do nothing
        }
        // END PATCH W. Randelshofer catch AccessControlException
        return XMLParserFactory.createXMLParser(className,
                new StdXMLBuilder());
    }
/**
     * Creates a default parser.
     *
     * @see #DEFAULT_CLASS
     * @see #CLASS_KEY
     *
     * @param builder the XML builder.
     *
     * @return the non-null parser.
     *
     * @throws java.lang.ClassNotFoundException
     *		if the class of the parser could not be found.
     * @throws java.lang.InstantiationException
     *		if the parser could not be created
     * @throws java.lang.IllegalAccessException
     *		if the parser could not be created
     */
    public static IXMLParser createDefaultXMLParser(IXMLBuilder builder)
    throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException {
        // BEGIN PATCH W. Randelshofer catch AccessControlException
        String className = XMLParserFactory.DEFAULT_CLASS;
        try {
         className = System.getProperty(XMLParserFactory.CLASS_KEY,
                XMLParserFactory.DEFAULT_CLASS);
         } catch (AccessControlException e) {
             // do nothing
         }
        // END PATCH W. Randelshofer catch AccessControlException
        return XMLParserFactory.createXMLParser(className, builder);
    }
/**
     * Creates a parser.
     *
     * @param className the name of the class of the XML parser
     * @param builder the XML builder.
     *
     * @return the non-null parser.
     *
     * @throws java.lang.ClassNotFoundException
     *		if the class of the parser could not be found.
     * @throws java.lang.InstantiationException
     *		if the parser could not be created
     * @throws java.lang.IllegalAccessException
     *		if the parser could not be created
     */
    public static IXMLParser createXMLParser(String      className,
            IXMLBuilder builder)
            throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException {
        Class cls = Class.forName(className);
        IXMLParser parser = (IXMLParser) cls.newInstance();
        parser.setBuilder(builder);
        parser.setValidator(new NonValidator());
        return parser;
    }
}