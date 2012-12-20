/*
 * @(#)Drawing.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.Graphics2D;
import org.jhotdraw.draw.io.InputFormat;
import org.jhotdraw.draw.io.OutputFormat;
import org.jhotdraw.xml.*;

import java.awt.font.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.undo.*;
import javax.swing.event.*;
import java.io.*;

/**
 * A <em>drawing</em> is a container for {@link Figure}s. A drawing can hold
 * multiple figures, but a figure can only be in one drawing at a time.
 * A drawing can be in one or multiple {@link DrawingView}s.
 * <p>
 * {@code Drawing} is essentially a {@link CompositeFigure} with a number of
 * additional functionality:
 * <ul>
 * <li>A drawing notifies a figure and its {@code CompositeFigureListener}'s when
 * the figure is added or removed from it. Like with {@code CompositeFigure}
 * basic add and remove methods are supplied for use cases where this is not
 * desired - for example when figures need to be temporarily removed in order to
 * group or ungroup them.</li>
 * 
 * <li>A drawing can find contained figures given a point or a rectangular
 * region.
 * Specialized implementations of the {@code Drawing} interface can use
 * optimized strategies and data structures to find figures faster.</li>
 * 
 * <li>The drawing object is used by {@code Figure}, {@code Tool} and
 * {@code Handle} as a mediator for undoable edit events. This way, undoable
 * edit listeners only need to register on the drawing object in order to
 * receive all undoable edit events related to changes made in the drawing.</li>
 *
 * <li>Drawing can hold a number of {@link org.jhotdraw.draw.io.InputFormat}s and
 * {@link org.jhotdraw.draw.io.OutputFormat}s, allowing to read and write a drawing from/to a
 * stream, a file or the clipboard.</li>
 * </ul>
 * Note that there are some restrictions too. Here are some things that a
 * drawing is not allowed to do:
 * <ul>
 * <li>A drawing may not access {@code DrawingView}, {@code DrawingEditor} or
 * {@code Tool}. The drawing framework is built on the assumption that a
 * drawing can be rendered at any time without the need for the creation of 
 * views and editing tools.</li>
 * </ul>
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Framework</em><br>
 * The following interfaces define the contracts of a framework for structured
 * drawing editors:<br>
 * Contract: {@link Drawing}, {@link Figure}, {@link DrawingView},
 * {@link DrawingEditor}, {@link org.jhotdraw.draw.handle.Handle} and
 * {@link org.jhotdraw.draw.tool.Tool}.
 *
 * <p><em>Model-View-Controller</em><br>
 * The following classes implement together the Model-View-Controller design
 * pattern:<br>
 * Model: {@link Drawing}; View: {@link DrawingView}; Controller:
 * {@link DrawingEditor}.
 *
 * <p><em>Strategy</em><br>
 * {@code org.jhotdraw.draw.io.OutputFormat} encapsulates a strategy for writing drawings to
 * output streams.<br>
 * Strategy: {@link org.jhotdraw.draw.io.OutputFormat}; Context: {@link Drawing}.
 *
 * <p><em>Strategy</em><br>
 * {@code org.jhotdraw.draw.io.InputFormat} encapsulates a strategy for 
 * reading drawings from input streams.<br>
 * Strategy: {@link org.jhotdraw.draw.io.InputFormat}; Context: {@link Drawing}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: Drawing.java 766 2011-09-29 19:40:06Z rawcoder $
 */
public interface Drawing extends CompositeFigure, Serializable, DOMStorable {

    /** Draws on the <em>canvas area</em>. The canvas is the background area
     * onto which the drawing is drawn.
     * <p>
     * By convention this method is only invoked by {@link DrawingView}.
     * <p>
     * {@link AttributeKeys} defines a number of attribute keys which can be
     * used to determine what to draw on the canvas.
     */
    public void drawCanvas(Graphics2D g);
    /**
     * Adds a figure to the drawing.
     * The drawing sends an {@code addNotify} message to the figure
     * after it has been added.
     *
     * @see Figure#addNotify
     *
     * @param figure to be added to the drawing
     */
    @Override
    boolean add(Figure figure);

    /**
     * Adds a figure to the drawing.
     * The drawing sends an {@code addNotify} message to the figure
     * after it has been added.
     *
     * @see Figure#addNotify
     *
     * @param index The z-index of the figure.
     * @param figure to be added to the drawing
     */
    @Override
    void add(int index, Figure figure);

    /**
     * Adds a collection of figures to the drawing.
     * The drawing sends an {@code addNotify}  message to each figure
     * after it has been added.
     *
     * @see Figure#addNotify
     *
     * @param figures to be added to the drawing
     */
    void addAll(Collection<? extends Figure> figures);

    /**
     * Adds a collection of figures to the drawing.
     * The drawing sends an {@code addNotify}  message to each figure
     * after it has been added.
     *
     * @see Figure#addNotify
     *
     * @param index The z-index of the figure.
     * @param figures to be added to the drawing
     */
    void addAll(int index, Collection<? extends Figure> figures);

    /**
     * Removes a figure from the drawing.
     * The drawing sends a {@code removeNotify} message to the figure
     * before it is removed.
     *
     * @see Figure#removeNotify
     *
     * @param figure that is part of the drawing and should be removed
     */
    @Override
    boolean remove(Figure figure);

    /**
     * Removes the specified figures from the drawing.
     * The drawing sends a {@code removeNotify}  message to each figure
     * before it is removed.
     *
     * @see Figure#removeNotify
     *
     * @param figures A collection of figures which are part of the drawing
     * and should be removed
     */
    void removeAll(Collection<? extends Figure> figures);

    /**
     * Removes a figure temporarily from the drawing.
     *
     * @see #basicAdd(Figure)
     * 
     * @param figure that is part of the drawing and should be removed
     */
    @Override
    int basicRemove(Figure figure);

    /**
     * Removes the specified figures temporarily from the drawing.
     *
     * @see #basicAddAll(int, Collection)
     * @param figures A collection of figures which are part of the drawing
     * and should be removed
     */
    void basicRemoveAll(Collection<? extends Figure> figures);

    /**
     * Reinserts a figure which was temporarily removed using basicRemove.
     * <p>
     * This is a convenience method for calling 
     * {@code basicAdd(size(), figure)}.
     * 
     * @param figure that is part of the drawing and should be removed
     * @see #basicRemove(Figure)
     */
    @Override
    void basicAdd(Figure figure);

    /**
     * Reinserts a figure which was temporarily removed using basicRemove.
     *
     * @see #basicRemove(Figure)
     * @param figure that is part of the drawing and should be removed
     */
    @Override
    void basicAdd(int index, Figure figure);

    /**
     * Reinserts the specified figures which were temporarily removed from
     * the drawing.
     * 
     * 
     * @param index The insertion index.
     * @param figures A collection of figures which are part of the drawing
     * and should be reinserted.
     * @see #basicRemoveAll(Collection)
     */
    void basicAddAll(int index, Collection<? extends Figure> figures);

    /**
     * Returns all figures that lie within or intersect the specified
     * bounds. The figures are returned in Z-order from back to front.
     */
    List<Figure> findFigures(Rectangle2D.Double bounds);

    /**
     * Returns all figures that lie within the specified
     * bounds. The figures are returned in Z-order from back to front.
     */
    List<Figure> findFiguresWithin(Rectangle2D.Double bounds);

    /**
     * Finds a top level Figure. Use this call for hit detection that
     * should not descend into children of composite figures.
     * <p>
     * Use {@link #findFigureInside} If you need to descend into children of
     * composite figures.
     */
    @Nullable Figure findFigure(Point2D.Double p);

    /**
     * Finds a top level Figure. Use this call for hit detection that
     * should not descend into the figure's children.
     */
    @Nullable Figure findFigureExcept(Point2D.Double p, Figure ignore);

    /**
     * Finds a top level Figure. Use this call for hit detection that
     * should not descend into the figure's children.
     */
    @Nullable Figure findFigureExcept(Point2D.Double p, Collection<? extends Figure> ignore);

    /**
     * Finds a top level Figure which is behind the specified Figure.
     */
    @Nullable Figure findFigureBehind(Point2D.Double p, Figure figure);

    /**
     * Finds a top level Figure which is behind the specified Figures.
     */
    @Nullable Figure findFigureBehind(Point2D.Double p, Collection<? extends Figure> figures);

    /**
     * Returns a list of the figures in Z-Order from front to back.
     */
    List<Figure> getFiguresFrontToBack();

    /**
     * Finds the innermost figure at the specified location.
     * <p>
     * In case a {@code CompositeFigure} is at the specified location, this
     * method descends into its children and into its children's children until
     * the innermost figure is found.
     * <p>
     * This functionality is implemented using the <em>Chain of
     * Responsibility</em> design pattern in the {@code Figure} interface.
     * Since it is often used from a drawing object as the starting point,
     * and since {@code Drawing} defines other find methods as well, it is
     * defined here again for clarity.
     *
     * @param p A location on the drawing.
     * @return Returns the innermost figure at the location, or null if the
     * location is not contained in a figure.
     */
    @Override
    @Nullable
    Figure findFigureInside(Point2D.Double p);

    /**
     * Sends a figure to the back of the drawing.
     *
     * @param figure that is part of the drawing
     */
    void sendToBack(Figure figure);

    /**
     * Brings a figure to the front.
     *
     * @param figure that is part of the drawing
     */
    void bringToFront(Figure figure);

    /**
     * Returns a copy of the provided collection which is sorted
     * in z order from back to front.
     */
    List<Figure> sort(Collection<? extends Figure> figures);

    /**
     * Adds a listener for undooable edit events.
     */
    void addUndoableEditListener(UndoableEditListener l);

    /**
     * Removes a listener for undoable edit events.
     */
    void removeUndoableEditListener(UndoableEditListener l);

    /**
     * Notify all listenerList that have registered interest for
     * notification on this event type.
     */
    void fireUndoableEditHappened(UndoableEdit edit);

    /**
     * Returns the font render context used to do text leyout and text drawing.
     */
    FontRenderContext getFontRenderContext();

    /**
     * Sets the font render context used to do text leyout and text drawing.
     */
    void setFontRenderContext(FontRenderContext frc);

    /**
     * Returns the lock object on which all threads acting on Figures in this
     * drawing synchronize to prevent race conditions.
     */
    Object getLock();

    /**
     * Adds an input format to the drawing.
     */
    void addInputFormat(InputFormat format);

    /**
     * Adds an output format to the drawing.
     */
    void addOutputFormat(OutputFormat format);

    /**
     * Sets input formats for the Drawing in order of preferred formats.
     * <p>
     * The input formats are used for loading the Drawing from a file and for
     * pasting Figures from the clipboard into the Drawing.
     */
    void setInputFormats(List<InputFormat> formats);

    /**
     * Gets input formats for the Drawing in order of preferred formats.
     */
    List<InputFormat> getInputFormats();

    /**
     * Sets output formats for the Drawing in order of preferred formats.
     * <p>
     * The output formats are used for saving the Drawing into a file and for
     * cutting and copying Figures from the Drawing into the clipboard.
     */
    void setOutputFormats(List<OutputFormat> formats);

    /**
     * Gets output formats for the Drawing in order of preferred formats.
     */
    List<OutputFormat> getOutputFormats();
}

