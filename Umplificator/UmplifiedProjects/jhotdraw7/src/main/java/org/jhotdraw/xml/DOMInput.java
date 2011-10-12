/*
 * @(#)DOMInput.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */


package org.jhotdraw.xml;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.io.IOException;

/**
 * DOMInput.
 * <p>
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Abstract Factory</em><br>
 * {@code DOMFactory} is used by {@code DOMInput} and {@code DOMOutput} for
 * creating Java objects and DOM elements.
 * Abstract Factory: {@link DOMFactory}<br>
 * Client: {@link DOMInput}, {@link DOMOutput}.
 *
 * <p><em>Strategy</em><br>
 * {@code DOMFactory} is used by {@code DOMInput} and {@code DOMOutput} for
 * reading and writing objects.
 * Client: {@link DOMInput}, {@link DOMOutput}.<br>
 * Strategy: {@link DOMFactory}.<br>
 *
 * @author  Werner Randelshofer
 * @version $Id: DOMInput.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface DOMInput {
    /**
     * Returns the tag name of the current element.
     */
    public String getTagName();
    /**
     * Gets an attribute of the current element of the DOM Document.
     */
    @Nullable public String getAttribute(String name, @Nullable  String defaultValue);
    /**
     * Gets the text of the current element of the DOM Document.
     */
    @Nullable public String getText();
    /**
     * Gets the text of the current element of the DOM Document.
     */
    @Nullable public String getText(@Nullable String defaultValue);
    
    /**
     * Gets an attribute of the current element of the DOM Document.
     */
    public int getAttribute(String name, int defaultValue);
    /**
     * Gets an attribute of the current element of the DOM Document.
     */
    public double getAttribute(String name, double defaultValue);
    /**
     * Gets an attribute of the current element of the DOM Document.
     */
    public boolean getAttribute(String name, boolean defaultValue);
    /**
     * Gets an attribute of the current element of the DOM Document and of
     * all parent DOM elements.
     */
    public java.util.List<String> getInheritedAttribute(String name);
    
    /**
     * Returns the number of child elements of the current element.
     */
    public int getElementCount();
    /**
     * Returns the number of child elements with the specified tag name
     * of the current element.
     */
    public int getElementCount(String tagName);
    
    /**
     * Opens the element with the specified index and makes it the current node.
     */
    public void openElement(int index) throws IOException;
    
    /**
     * Opens the last element with the specified name and makes it the current node.
     */
    public void openElement(String tagName) throws IOException;
    /**
     * Opens the element with the specified name and index and makes it the
     * current node.
     */
    public void openElement(String tagName, int index) throws IOException;
    
    /**
     * Closes the current element of the DOM Document.
     * The parent of the current element becomes the current element.

     * @exception IllegalArgumentException if the provided tagName does
     * not match the tag name of the element.
     */
    public void closeElement();
    
    /**
     * Reads an object from the current element.
     */
    public Object readObject() throws IOException;
    /**
     * Reads an object from the current element.
     */
    public Object readObject(int index) throws IOException ;
}
