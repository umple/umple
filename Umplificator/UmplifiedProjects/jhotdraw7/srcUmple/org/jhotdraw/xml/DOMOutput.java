/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package org.jhotdraw.xml;
import java.io.IOException;

public class DOMOutput
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DOMOutput()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  public void setDoctype(String doctype);
/**
     * Adds a new element to the DOM Document and opens it.
     * The new element is added as a child to the current element in the DOM
     * document. Then it becomes the current element.
     * The element must be closed using closeElement.
     */
    public void openElement(String tagName);
/**
     * Closes the current element of the DOM Document.
     * The parent of the current element becomes the current element.
     * @exception IllegalArgumentException if the provided tagName does
     * not match the tag name of the element.
     */
    public void closeElement();
/**
     * Adds a comment to the current element of the DOM Document.
     */
    public void addComment(String comment);
/**
     * Adds a text to current element of the DOM Document.
     * Note: Multiple consecutives texts will be merged.
     */
    public void addText(String text);
/**
     * Adds an attribute to current element of the DOM Document.
     */
    public void addAttribute(String name, String value);
/**
     * Adds an attribute to current element of the DOM Document if it is
     * different from the default value.
     */
    public void addAttribute(String name, String value, String defaultValue);
/**
     * Adds an attribute to current element of the DOM Document.
     */
    public void addAttribute(String name, int value);
/**
     * Adds an attribute to current element of the DOM Document if it is
     * different from the default value.
     */
    public void addAttribute(String name, int value, int defaultValue);
/**
     * Adds an attribute to current element of the DOM Document.
     */
    public void addAttribute(String name, boolean value);
/**
     * Adds an attribute to current element of the DOM Document if it is
     * different from the default value.
     */
    public void addAttribute(String name, boolean value, boolean defaultValue);
/**
     * Adds an attribute to current element of the DOM Document.
     */
    public void addAttribute(String name, float value);
/**
     * Adds an attribute to current element of the DOM Document if it is
     * different from the default value.
     */
    public void addAttribute(String name, float value, float defaultValue);
/**
     * Adds an attribute to current element of the DOM Document.
     */
    public void addAttribute(String name, double value);
/**
     * Adds an attribute to current element of the DOM Document if it is
     * different from the default value.
     */
    public void addAttribute(String name, double value, double defaultValue);
/**
     * Writes an object.
     */
    public void writeObject(Object o) throws IOException;
/**
     * Returns a prototype for the object currently being written.
     * This can be used, to reduce the amount of data written to DOMOutput.
     * For example, by not writing object attributes, which have the same values
     * as the prototype.
     */
    public Object getPrototype();
}