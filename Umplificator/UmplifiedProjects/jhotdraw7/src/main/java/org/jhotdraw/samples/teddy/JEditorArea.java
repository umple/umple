/*
 * @(#)JEditorArea.java
 *
 * Copyright (c) 2006 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.teddy;

import javax.swing.*;
import javax.swing.text.*;
/**
 * A happy marriage between JTextArea and JEditorPane.
 *
 * @author Werner Randelshofer
 * @version $Id: JEditorArea.java 723 2010-12-28 14:31:24Z rawcoder $
 */
public class JEditorArea extends JEditorPane {
    private boolean wrap;
    
    /** Creates a new instance. */
    public JEditorArea() {
        setEditorKit(new StyledEditorKit());
        initComponents();
    }
    
    public StyledEditorKit getStyledEditorKit() {
        return (StyledEditorKit) getEditorKit();
    }
    
    
    /**
     * Sets the line-wrapping policy of the text area.  If set
     * to true the lines will be wrapped if they are too long
     * to fit within the allocated width.  If set to false,
     * the lines will always be unwrapped.  A <code>PropertyChange</code>
     * event ("lineWrap") is fired when the policy is changed.
     * By default this property is false.
     *
     * @param newValue indicates if lines should be wrapped
     * @see #getLineWrap
     */
    public void setLineWrap(boolean newValue) {
        boolean oldValue = wrap;
        if (oldValue != newValue) {
        this.wrap = newValue;
        firePropertyChange("lineWrap", oldValue, newValue);
        rebuildView();
        }
    }

    /**
     * Gets the line-wrapping policy of the text area.  If set
     * to true the lines will be wrapped if they are too long
     * to fit within the allocated width.  If set to false,
     * the lines will always be unwrapped.
     *
     * @return if lines will be wrapped
     */
    public boolean getLineWrap() {
        return wrap;
    }

    
    /**
     * Returns true if a viewport should always force the width of this 
     * Scrollable to match the width of the viewport.  This is implemented
     * to return true if the line wrapping policy is true, and false
     * if lines are not being wrapped.
     * 
     * @return true if a viewport should force the Scrollables width
     * to match its own.
     */
    @Override
    public boolean getScrollableTracksViewportWidth() {
        return wrap;
    }
    
    public void rebuildView() {
        revalidate();
        repaint();
    }

    /**
     * Replaces text from the indicated start to end position with the
     * new text specified.  Does nothing if the model is null.  Simply
     * does a delete if the new string is null or empty.
     * <p>
     * This method is thread safe, although most Swing methods
     * are not. Please see 
     * <A HREF="http://java.sun.com/products/jfc/swingdoc-archive/threads.html">Threads
     * and Swing</A> for more information.     
     *
     * @param str the text to use as the replacement
     * @param start the start position >= 0
     * @param end the end position >= start
     * @exception IllegalArgumentException  if part of the range is an
     *  invalid position in the model
     */
     public void replaceRange(String str, int start, int end) {
        if (end < start) {
            throw new IllegalArgumentException("end before start");
        }
        Document doc = getDocument();
        if (doc != null) {
            try {
                if (doc instanceof AbstractDocument) {
                    ((AbstractDocument)doc).replace(start, end - start, str,
                                                    null);
                }
                else {
                    doc.remove(start, end - start);
                    doc.insertString(start, str, null);
                }
            } catch (BadLocationException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }
    /**
     * Translates an offset into the components text to a 
     * line number.
     *
     * @param offset the offset >= 0
     * @return the line number >= 0
     * @exception BadLocationException thrown if the offset is
     *   less than zero or greater than the document length.
     */
    public int getLineOfOffset(int offset) throws BadLocationException {
        Document doc = getDocument();
        if (offset < 0) {
            throw new BadLocationException("Can't translate offset to line", -1);
        } else if (offset > doc.getLength()) {
            throw new BadLocationException("Can't translate offset to line", doc.getLength()+1);
        } else {
            Element map = getDocument().getDefaultRootElement();
            return map.getElementIndex(offset);
        }
    }
    
    /**
     * Determines the offset of the start of the given line.
     *
     * @param line  the line number to translate >= 0
     * @return the offset >= 0
     * @exception BadLocationException thrown if the line is
     * less than zero or greater or equal to the number of
     * lines contained in the document (as reported by 
     * getLineCount).
     */
    public int getLineStartOffset(int line) throws BadLocationException {
        Document doc = getDocument();
        Element map = doc.getDefaultRootElement();
        int lineCount = map.getElementCount();
        //int lineCount = getLineCount();
        if (line < 0) {
            throw new BadLocationException("Negative line", -1);
        } else if (line >= lineCount) {
            throw new BadLocationException("No such line", doc.getLength()+1);
        } else {
            Element lineElem = map.getElement(line);
            return lineElem.getStartOffset();
        }
    }

     /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

    }
    // </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
}
