/*
 * @(#)AbstractDrawing.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw;

import org.jhotdraw.draw.io.InputFormat;
import org.jhotdraw.draw.io.OutputFormat;
import org.jhotdraw.xml.*;
import java.awt.font.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.undo.*;
import java.util.*;
import java.io.*;

/**
 * This abstract class can be extended to implement a {@link Drawing}.
 *
 * @author Werner Randelshofer
 * @version $Id: AbstractDrawing.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public abstract class AbstractDrawing extends AbstractAttributedCompositeFigure implements Drawing {
    private final static Object lock = new JPanel().getTreeLock();
    private transient FontRenderContext fontRenderContext;
    private LinkedList<InputFormat> inputFormats = new LinkedList<InputFormat>();
    private LinkedList<OutputFormat> outputFormats = new LinkedList<OutputFormat>();
    private final static boolean DEBUG = false;

    /** Creates a new instance. */
    public AbstractDrawing() {
    }

    @Override
    public void addUndoableEditListener(UndoableEditListener l) {
        listenerList.add(UndoableEditListener.class, l);
    }

    @Override
    public void removeUndoableEditListener(UndoableEditListener l) {
        listenerList.remove(UndoableEditListener.class, l);
    }

    /**
     *  Notify all listenerList that have registered interest for
     * notification on this event type.
     */
    @Override
    public void fireUndoableEditHappened(UndoableEdit edit) {
        UndoableEditEvent event = null;
        if (listenerList.getListenerCount() > 0) {
            // Notify all listeners that have registered interest for
            // Guaranteed to return a non-null array
            Object[] listeners = listenerList.getListenerList();
            // Process the listeners last to first, notifying
            // those that are interested in this event
            for (int i = listeners.length - 2; i >= 0; i -= 2) {
                if (event == null) {
                    event = new UndoableEditEvent(this, edit);
                }
                if (listeners[i] == UndoableEditListener.class) {
                    ((UndoableEditListener) listeners[i + 1]).undoableEditHappened(event);
                }
            }
        }
    }

    @Override
    public FontRenderContext getFontRenderContext() {
        return fontRenderContext;
    }

    @Override
    public void setFontRenderContext(FontRenderContext frc) {
        fontRenderContext = frc;
    }

    @Override
    public void read(DOMInput in) throws IOException {
        in.openElement("figures");
        for (int i = 0; i < in.getElementCount(); i++) {
            Figure f;
            add(f = (Figure) in.readObject(i));
        }
        in.closeElement();
    }

    @Override
    public void write(DOMOutput out) throws IOException {
        out.openElement("figures");
        for (Figure f : getChildren()) {
            out.writeObject(f);
        }
        out.closeElement();
    }

    /**
     * The drawing view synchronizes on the lock when drawing a drawing.
     */
    @Override
    public Object getLock() {
        return lock;
    }

    @Override
    public void addInputFormat(InputFormat format) {
        inputFormats.add(format);
    }

    @Override
    public void addOutputFormat(OutputFormat format) {
        outputFormats.add(format);
        if (DEBUG) {
            System.out.println(this + ".addOutputFormat(" + format + ")");
        }
    }

    @Override
    public void setOutputFormats(java.util.List<OutputFormat> formats) {
        this.outputFormats = new LinkedList<OutputFormat>(formats);
    }

    @Override
    public void setInputFormats(java.util.List<InputFormat> formats) {
        this.inputFormats = new LinkedList<InputFormat>(formats);
    }

    @Override
    public java.util.List<InputFormat> getInputFormats() {
        return inputFormats;
    }

    @Override
    public java.util.List<OutputFormat> getOutputFormats() {
        if (DEBUG) {
            System.out.println(this + ".getOutputFormats size:" + outputFormats.size());
        }
        return outputFormats;
    }

    @Override
    public Drawing getDrawing() {
        return this;
    }

    /*@Override
    public Rectangle2D.Double getDrawingArea() {
        Rectangle2D.Double drawingArea;

        Dimension2DDouble canvasSize = getCanvasSize();
        if (canvasSize != null) {
            drawingArea = new Rectangle2D.Double(
                    0d, 0d,
                    canvasSize.width, canvasSize.height);
        } else {
            drawingArea = super.getDrawingArea();
            drawingArea.add(0d, 0d);
            /*drawingArea = new Rectangle2D.Double(
                    0d, 0d,
                    canvasSize.width, canvasSize.height);* /
        }
        return drawingArea;
    }*/
    @Override
    @SuppressWarnings("unchecked")
    public AbstractDrawing clone() {
        AbstractDrawing that = (AbstractDrawing) super.clone();
        that.inputFormats =  (this.inputFormats == null) ? null : (LinkedList<InputFormat>) this.inputFormats.clone();
        that.outputFormats = (this.outputFormats == null) ? null : (LinkedList<OutputFormat>) this.outputFormats.clone();
        return that;
    }
}
