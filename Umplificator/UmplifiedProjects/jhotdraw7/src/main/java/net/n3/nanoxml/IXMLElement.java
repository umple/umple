/* Werner Randelshofer 2009-06-01
 * Added dispose method.
 /* Werner Randelshofer 2006-12-31
 * Made methods return typed collections.
 * Werner Randelshofer 2006-11-26 
 * Added method getAttribute(String name, Map valueSet, String defaultKey, boolean allowLiterals);
 */
/* IXMLElement.java                                                NanoXML/Java
 *
 * $Revision: 1.4 $
 * $Date: 2002/01/04 21:03:28 $
 * $Name: RELEASE_2_2_1 $
 *
 * This file is part of NanoXML 2 for Java.
 * Copyright (C) 2000-2002 Marc De Scheemaecker, All Rights Reserved.
 *
 * This software is provided 'as-is', without any express or implied warranty.
 * In no event will the authors be held liable for any damages arising from the
 * use of this software.
 *
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it
 * freely, subject to the following restrictions:
 *
 *  1. The origin of this software must not be misrepresented; you must not
 *     claim that you wrote the original software. If you use this software in
 *     a product, an acknowledgment in the product documentation would be
 *     appreciated but is not required.
 *
 *  2. Altered source versions must be plainly marked as such, and must not be
 *     misrepresented as being the original software.
 *
 *  3. This notice may not be removed or altered from any source distribution.
 */

package net.n3.nanoxml;


import java.io.Serializable;
import java.util.*;


/**
 * IXMLElement is an XML element. It provides an easy to use generic interface
 * on top of an XML like data structure like e.g. a DOM like structure.
 * Elements returned by StdXMLBuilder also implement this interface.
 *
 * @see net.n3.nanoxml.StdXMLBuilder
 *
 * @author Marc De Scheemaecker
 * @version $Name: RELEASE_2_2_1 $, $Revision: 1.4 $
 */
public interface IXMLElement
{

   /**
    * No line number defined.
    */
   public static final int NO_LINE = -1;


   /**
    * Creates an element to be used for #PCDATA content.
    */
   public IXMLElement createPCDataElement();


   /**
    * Creates an empty element.
    *
    * @param fullName the name of the element.
    */
   public IXMLElement createElement(String fullName);


   /**
    * Creates an empty element.
    *
    * @param fullName the name of the element.
    * @param systemID the system ID of the XML data where the element starts.
    * @param lineNr   the line in the XML data where the element starts.
    */
   public IXMLElement createElement(String fullName,
                                    String systemID,
                                    int    lineNr);


   /**
    * Creates an empty element.
    *
    * @param fullName  the full name of the element
    * @param namespace the namespace URI.
    */
   public IXMLElement createElement(String fullName,
                                    String namespace);


   /**
    * Creates an empty element.
    *
    * @param fullName  the full name of the element
    * @param namespace the namespace URI.
    * @param systemID  the system ID of the XML data where the element starts.
    * @param lineNr    the line in the XML data where the element starts.
    */
   public IXMLElement createElement(String fullName,
                                    String namespace,
                                    String systemID,
                                    int    lineNr);


   /**
    * Returns the parent element. This method returns null for the root
    * element.
    */
   public IXMLElement getParent();


   /**
    * Returns the full name (i.e. the name including an eventual namespace
    * prefix) of the element.
    *
    * @return the name, or null if the element only contains #PCDATA.
    */
   public String getFullName();


   /**
    * Returns the name of the element.
    *
    * @return the name, or null if the element only contains #PCDATA.
    */
   public String getName();


   /**
    * Returns the namespace of the element.
    *
    * @return the namespace, or null if no namespace is associated with the
    *         element.
    */
   public String getNamespace();


   /**
    * Sets the full name. This method also sets the short name and clears the
    * namespace URI.
    *
    * @param name the non-null name.
    */
   public void setName(String name);


   /**
    * Sets the name.
    *
    * @param fullName  the non-null full name.
    * @param namespace the namespace URI, which may be null.
    */
   public void setName(String fullName,
                       String namespace);


   /**
    * Adds a child element.
    *
    * @param child the non-null child to add.
    */
   public void addChild(IXMLElement child);


   /**
    * Removes a child element.
    *
    * @param child the non-null child to remove.
    */
   public void removeChild(IXMLElement child);


   /**
    * Removes the child located at a certain index.
    *
    * @param index the index of the child, where the first child has index 0.
    */
   public void removeChildAtIndex(int index);


   /**
    * Returns an enumeration of all child elements.
    *
    * @return the non-null enumeration
    */
   public Iterator<IXMLElement> iterateChildren();


   /**
    * Returns whether the element is a leaf element.
    *
    * @return true if the element has no children.
    */
   public boolean isLeaf();


   /**
    * Returns whether the element has children.
    *
    * @return true if the element has children.
    */
   public boolean hasChildren();


   /**
    * Returns the number of children.
    *
    * @return the count.
    */
   public int getChildrenCount();


   /**
    * Returns a vector containing all the child elements.
    *
    * @return the vector.
    */
   public ArrayList<IXMLElement> getChildren();


   /**
    * Returns the child at a specific index.
    *
    * @param index the index of the child
    *
    * @return the non-null child
    *
    * @throws java.lang.ArrayIndexOutOfBoundsException
    *		if the index is out of bounds.
    */
   public IXMLElement getChildAtIndex(int index)
      throws ArrayIndexOutOfBoundsException;


   /**
    * Searches a child element.
    *
    * @param name the full name of the child to search for.
    *
    * @return the child element, or null if no such child was found.
    */
   public IXMLElement getFirstChildNamed(String name);


   /**
    * Searches a child element.
    *
    * @param name      the name of the child to search for.
    * @param namespace the namespace, which may be null.
    *
    * @return the child element, or null if no such child was found.
    */
   public IXMLElement getFirstChildNamed(String name,
                                         String namespace);


   /**
    * Returns a vector of all child elements named <I>name</I>.
    *
    * @param name the full name of the children to search for.
    *
    * @return the non-null vector of child elements.
    */
   public ArrayList<IXMLElement> getChildrenNamed(String name);


   /**
    * Returns a vector of all child elements named <I>name</I>.
    *
    * @param name      the name of the children to search for.
    * @param namespace the namespace, which may be null.
    *
    * @return the non-null vector of child elements.
    */
   public ArrayList<IXMLElement> getChildrenNamed(String name,
                                  String namespace);



   /**
    * Returns the number of attributes.
    */
   public int getAttributeCount();


   /**
    * @deprecated As of NanoXML/Java 2.0.1, replaced by
    *             {@link #getAttribute(java.lang.String,java.lang.String)}
    * Returns the value of an attribute.
    *
    * @param name the non-null name of the attribute.
    *
    * @return the value, or null if the attribute does not exist.
    */
   public String getAttribute(String name);


   /**
    * Returns the value of an attribute.
    *
    * @param name the non-null full name of the attribute.
    * @param defaultValue the default value of the attribute.
    *
    * @return the value, or defaultValue if the attribute does not exist.
    */
   public String getAttribute(String name,
                              String defaultValue);


   /**
    * Returns the value of an attribute.
    *
    * @param name the non-null name of the attribute.
    * @param namespace the namespace URI, which may be null.
    * @param defaultValue the default value of the attribute.
    *
    * @return the value, or defaultValue if the attribute does not exist.
    */
   public String getAttribute(String name,
                              String namespace,
                              String defaultValue);


   /**
    * Returns the value of an attribute.
    *
    * @param name the non-null full name of the attribute.
    * @param defaultValue the default value of the attribute.
    *
    * @return the value, or defaultValue if the attribute does not exist.
    */
   public int getAttribute(String name,
                           int    defaultValue);


   /**
    * Returns the value of an attribute.
    *
    * @param name the non-null name of the attribute.
    * @param namespace the namespace URI, which may be null.
    * @param defaultValue the default value of the attribute.
    *
    * @return the value, or defaultValue if the attribute does not exist.
    */
   public int getAttribute(String name,
                           String namespace,
                           int    defaultValue);

    /**
     * Returns an attribute by looking up a key in a hashtable.
     * If the attribute doesn't exist, the value corresponding to defaultKey
     * is returned.
     * <P>
     * As an example, if valueSet contains the mapping <code>"one" =&gt;
     * "1"</code>
     * and the element contains the attribute <code>attr="one"</code>, then
     * <code>getAttribute("attr", mapping, defaultKey, false)</code> returns
     * <code>"1"</code>.
     *
     * @param name
     *     The name of the attribute.
     * @param namespace the namespace URI, which may be null.
     * @param valueSet
     *     HashMap mapping keySet().iterator to values.
     * @param defaultKey
     *     Key to use if the attribute is missing.
     *
     * </dl><dl><dt><b>Preconditions:</b></dt><dd>
     * <ul><li><code>name != null</code>
     *     <li><code>name</code> is a valid XML identifier
     *     <li><code>valueSet</code> != null
     *     <li>the keySet().iterator of <code>valueSet</code> are strings
     * </ul></dd></dl><dl>
     *
     */
    public Object getAttribute(String name, String namespace,
                               Map valueSet,
                               String    defaultKey);
    

    /**
     * Returns an attribute of the element.
     * If the attribute doesn't exist, <code>defaultValue</code> is returned.
     *
     * @param name         The name of the attribute.
     * @param namespace the namespace URI, which may be null.
     * @param defaultValue Key to use if the attribute is missing.
     *
     */
    public double getDoubleAttribute(String name,
            String namespace,
            double defaultValue);
   /**
    * Returns the type of an attribute.
    *
    * @param name the non-null full name of the attribute.
    *
    * @return the type, or null if the attribute does not exist.
    */
   public String getAttributeType(String name);


   /**
    * Returns the namespace of an attribute.
    *
    * @param name the non-null full name of the attribute.
    *
    * @return the namespace, or null if there is none associated.
    */
   public String getAttributeNamespace(String name);


   /**
    * Returns the type of an attribute.
    *
    * @param name the non-null name of the attribute.
    * @param namespace the namespace URI, which may be null.
    *
    * @return the type, or null if the attribute does not exist.
    */
   public String getAttributeType(String name,
                                  String namespace);


   /**
    * Sets an attribute.
    *
    * @param name the non-null full name of the attribute.
    * @param value the non-null value of the attribute.
    */
   public void setAttribute(String name,
                            String value);


   /**
    * Sets an attribute.
    *
    * @param fullName the non-null full name of the attribute.
    * @param namespace the namespace URI of the attribute, which may be null.
    * @param value the non-null value of the attribute.
    */
   public void setAttribute(String fullName,
                            String namespace,
                            String value);


   /**
    * Removes an attribute.
    *
    * @param name the non-null name of the attribute.
    */
   public void removeAttribute(String name);


   /**
    * Removes an attribute.
    *
    * @param name the non-null name of the attribute.
    * @param namespace the namespace URI of the attribute, which may be null.
    */
   public void removeAttribute(String name,
                               String namespace);


   /**
    * Returns an enumeration of all attribute names.
    *
    * @return the non-null enumeration.
    */
   public Iterator<String> iterateAttributeNames();


   /**
    * Returns whether an attribute exists.
    *
    * @param name the non-null name of the attribute.
    *
    * @return true if the attribute exists.
    */
   public boolean hasAttribute(String name);


   /**
    * Returns whether an attribute exists.
    *
    * @param name the non-null name of the attribute.
    * @param namespace the namespace URI of the attribute, which may be null.
    *
    * @return true if the attribute exists.
    */
   public boolean hasAttribute(String name,
                               String namespace);


   /**
    * Returns all attributes as a Properties object.
    *
    * @return the non-null set.
    */
   public Properties getAttributes();


   /**
    * Returns all attributes in a specific namespace as a Properties object.
    *
    * @param namespace the namespace URI of the attributes, which may be null.
    *
    * @return the non-null set.
    */
   public Properties getAttributesInNamespace(String namespace);


   /**
    * Returns the system ID of the data where the element started.
    *
    * @return the system ID, or null if unknown.
    *
    * @see #getLineNr
    */
   public String getSystemID();


   /**
    * Returns the line number in the data where the element started.
    *
    * @return the line number, or NO_LINE if unknown.
    *
    * @see #NO_LINE
    * @see #getSystemID
    */
   public int getLineNr();


   /**
    * Return the #PCDATA content of the element. If the element has a
    * combination of #PCDATA content and child elements, the #PCDATA
    * sections can be retrieved as unnamed child objects. In this case,
    * this method returns null.
    *
    * @return the content.
    */
   public String getContent();


   /**
    * Sets the #PCDATA content. It is an error to call this method with a
    * non-null value if there are child objects.
    *
    * @param content the (possibly null) content.
    */
   public void setContent(String content);


   /**
    * Returns true if the element equals another element.
    *
    * @param rawElement the element to compare to
    */
   public boolean equals(Object rawElement);


   /**
    * Returns true if the element equals another element.
    *
    * @param elt the element to compare to
    */
   public boolean equalsXMLElement(IXMLElement elt);


    /** Gets rid of the IXMLElement and of all its children. */
    public void dispose() ;

}
