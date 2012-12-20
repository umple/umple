/*
 * @(#)DOMOutput.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.xml;

import java.util.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;
import java.io.*;
/**
 * DOMOutput.
 * <p>
 * Design pattern:<br>
 * Name: Adapter.<br>
 * Role: Adapter.<br>
 * Partners: {@link org.w3c.dom.Document} as Adaptee.
 *
 * @author  Werner Randelshofer
 * @version $Id: JavaxDOMOutput.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class JavaxDOMOutput implements DOMOutput {
    /**
     * The doctype of the XML document.
     */
    private String doctype;
    
    /**
     * This map is used to marshall references to objects to
     * the XML DOM. A key in this map is a Java Object, a value in this map
     * is String representing a marshalled reference to that object.
     */
    private HashMap<Object,String> objectids;
    
    /**
     * This map is used to cache prototype objects.
     */
    private HashMap<String,Object> prototypes;
    
    /**
     * The document used for output.
     */
    private Document document;
    /**
     * The current node used for output.
     */
    private Node current;
    /**
     * The factory used to create objects.
     */
    private DOMFactory factory;
    
    /** Creates a new instance. */
    public JavaxDOMOutput(DOMFactory factory) throws IOException {
        this.factory = factory;
        }
    protected void reset() throws IOException {
        try {
            objectids = new HashMap<Object,String>();
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            current = document;
        } catch (ParserConfigurationException e) {
            IOException error = new IOException(e.getMessage());
            error.initCause(e);
            throw error;
        }
    }
    
    /**
     * Writes the contents of the DOMOutput into the specified output stream.
     */
    public void save(OutputStream out) throws IOException {
        reset();
        try {
            if (doctype != null) {
                OutputStreamWriter w = new OutputStreamWriter(out, "UTF8");
                w.write("<!DOCTYPE ");
                w.write(doctype);
                w.write(">\n");
                w.flush();
            }
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.transform(new DOMSource(document), new StreamResult(out));
        } catch (TransformerException e) {
            IOException error = new IOException(e.getMessage());
            error.initCause(e);
            throw error;
        }
    }
    /**
     * Writes the contents of the DOMOutput into the specified output stream.
     */
    public void save(Writer out) throws IOException {
        reset();
        try {
            if (doctype != null) {
                out.write("<!DOCTYPE ");
                out.write(doctype);
                out.write(">\n");
            }
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.transform(new DOMSource(document), new StreamResult(out));
        } catch (TransformerException e) {
            IOException error = new IOException(e.getMessage());
            error.initCause(e);
            throw error;
        }
    }
    
    /**
     * Puts a new element into the DOM Document.
     * The new element is added as a child to the current element in the DOM
     * document. Then it becomes the current element.
     * The element must be closed using closeElement.
     */
    @Override
    public void openElement(String tagName) {
        Element newElement = document.createElement(tagName);
        current.appendChild(newElement);
        current = newElement;
    }
    /**
     * Closes the current element of the DOM Document.
     * The parent of the current element becomes the current element.
     * @exception IllegalArgumentException if the provided tagName does
     * not match the tag name of the element.
     */
    @Override
    public void closeElement() {
        /*
        if (! ((Element) current).getName().equals(tagName)) {
            throw new IllegalArgumentException("Attempt to close wrong element:"+tagName +"!="+((Element) current).getName());
        }*/
        current = current.getParentNode();
    }
    /**
     * Adds a comment to the current element of the DOM Document.
     */
    @Override
    public void addComment(String comment) {
        current.appendChild(document.createComment(comment));
    }
    /**
     * Adds a text to current element of the DOM Document.
     * Note: Multiple consecutives texts will be merged.
     */
    @Override
    public void addText(String text) {
        current.appendChild(document.createTextNode(text));
    }
    /**
     * Adds an attribute to current element of the DOM Document.
     */
    @Override
    public void addAttribute(String name, String value) {
        if (value != null) {
            ((Element) current).setAttribute(name, value);
        }
    }
    /**
     * Adds an attribute to current element of the DOM Document.
     */
    @Override
    public void addAttribute(String name, int value) {
        ((Element) current).setAttribute(name, Integer.toString(value));
    }
    /**
     * Adds an attribute to current element of the DOM Document.
     */
    @Override
    public void addAttribute(String name, boolean value) {
        ((Element) current).setAttribute(name, Boolean.toString(value));
    }
    /**
     * Adds an attribute to current element of the DOM Document.
     */
    @Override
    public void addAttribute(String name, float value) {
        // Remove the awkard .0 at the end of each number
        String str = Float.toString(value);
        if (str.endsWith(".0")) str = str.substring(0, str.length() - 2);
        ((Element) current).setAttribute(name, str);
    }
    /**
     * Adds an attribute to current element of the DOM Document.
     */
    @Override
    public void addAttribute(String name, double value) {
        // Remove the awkard .0 at the end of each number
        String str = Double.toString(value);
        if (str.endsWith(".0")) str = str.substring(0, str.length() - 2);
        ((Element) current).setAttribute(name, str);
    }
    
    @Override
    public void writeObject(Object o) throws IOException {
        String tagName = factory.getName(o);
        if (tagName == null) throw new IllegalArgumentException("no tag name for:"+o);
        openElement(tagName);
        if (objectids.containsKey(o)) {
            addAttribute("ref", (String) objectids.get(o));
        } else {
            String id = Integer.toString(objectids.size(), 16);
            objectids.put(o, id);
            addAttribute("id", id);
            factory.write(this,o);
        }
        closeElement();
    }

    @Override
    public void addAttribute(String name, float value, float defaultValue) {
        if (value != defaultValue) {
            addAttribute(name, value);
        }
    }

    @Override
    public void addAttribute(String name, int value, int defaultValue) {
        if (value != defaultValue) {
            addAttribute(name, value);
        }
    }

    @Override
    public void addAttribute(String name, double value, double defaultValue) {
        if (value != defaultValue) {
            addAttribute(name, value);
        }
    }

    @Override
    public void addAttribute(String name, boolean value, boolean defaultValue) {
        if (value != defaultValue) {
            addAttribute(name, value);
        }
    }

    @Override
    public void addAttribute(String name, String value, String defaultValue) {
        if (! value.equals(defaultValue)) {
            addAttribute(name, value);
        }
    }

    @Override
    public Object getPrototype() {
        if (prototypes == null) {
            prototypes = new HashMap<String, Object>();
        }
        if (! prototypes.containsKey(current.getNodeName())) {
            prototypes.put(current.getNodeName(), factory.create(current.getNodeName()));
        }
        return prototypes.get(current.getNodeName());
    }

    @Override
    public void setDoctype(String doctype) {
        this.doctype = doctype;
    }
}
