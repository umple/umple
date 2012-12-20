/*
 * @(#)Handle.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */


package org.jhotdraw.draw.handle;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.event.HandleListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * A <em>handle</em> is used to change one aspect of a {@link Figure} by direct
 * manipulation.
 * <p>
 * A handle is owned by a figure and associated to a {@link DrawingView}.
 * {@code Handle} knows its owning figure and its associated drawing view.
 * <p>
 * Handles are drawn using the view coordinates of the associated
 * {@link DrawingView}. {@code Handle} uses methods of the drawing view to
 * translate the view coordinates into drawing coordinates, which is the
 * coordinate system used by the owning figure.
 * <p>
 * Mouse and keyboard events of the user occur on a drawing view, and are
 * preprocessed by the {@link org.jhotdraw.draw.tool.DragTracker} of a
 * {@link org.jhotdraw.draw.tool.SelectionTool}. {@code DragTracker} invokes
 * "track" methods on the handle, such as {@code trackStart},
 * {@code trackStep} and {@code trackEnd}.
 * <p>
 * Handle forwards {@code UndoableEdit} events to the drawing object onto
 * which it is performing changes.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Framework</em><br>
 * The following interfaces define the contracts of a framework for structured
 * drawing editors:<br>
 * Contract: {@link Drawing}, {@link Figure}, {@link DrawingView},
 * {@link DrawingEditor}, {@link Handle} and {@link org.jhotdraw.draw.tool.Tool}.
 *
 * <p><em>Observer</em><br>
 * State changes of handles can be observed by other objects. Specifically
 * {@code DrawingView} observes area invalidations and remove requests of
 * handles.<br>
 * Subject: {@link Handle}; 
 * Observer: {@link org.jhotdraw.draw.event.HandleListener};
 * Event: {@link org.jhotdraw.draw.event.HandleEvent};
 * Concrete Observer: {@link org.jhotdraw.draw.DrawingView}.
 *
 * <p><em>Chain of responsibility</em><br>
 * Mouse and keyboard events of the user occur on the drawing view, and are
 * preprocessed by the {@code DragTracker} of a {@code SelectionTool}. In
 * turn {@code DragTracker} invokes "track" methods on a {@code Handle} which in
 * turn changes an aspect of a figure.<br>
 * Client: {@link org.jhotdraw.draw.tool.SelectionTool};
 * Handler: {@link org.jhotdraw.draw.tool.DragTracker}, {@link Handle}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: Handle.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface Handle extends KeyListener {
    /**
     * Returns the owner of this handle.
     */
    public Figure getOwner();
    /**
     * Sets the view of the handle.
     */
    public void setView(@Nullable DrawingView view);
    /**
     * Adds a listener for this handle.
     */
    public void addHandleListener(HandleListener l);
    
    /**
     * Removes a listener for this handle.
     */
    void removeHandleListener(HandleListener l);
    /**
     * Returns the bounding box of the handle.
     * Note: The bounding box must be returned in the coordinate 
     * system of the DrawingView.
     */
    Rectangle getBounds();
    /**
     * Returns the drawing area of the handle.
     * Note: The drawing area must be returned in the coordinate 
     * system of the DrawingView.
     */
    Rectangle getDrawingArea();
    
    /**
     * Tests if a point is contained in the handle.
     */
    public boolean contains(Point p);
    
    /**
     * Draws this handle. 
     * Note: The handle is drawn with the coordinate system of
     * the DrawingView.
     */
    public void draw(Graphics2D g);
    /**
     * Invalidates the handle. This method informs its listeners
     * that its current display box is invalid and should be
     * refreshed.
     */
    public void invalidate();
    
    /**
     * Disposes the resources aquired by the handler.
     */
    public void dispose();
    
    /**
     * Returns a cursor for the handle.
     */
    public Cursor getCursor();
    
    /**
     * Returns true, if this handle is combinable with the specified handle.
     * This method is used to determine, if multiple handles need to be tracked,
     * when more than one figure is selected.
     */
    public boolean isCombinableWith(Handle handle);
    
    /**
     * Tracks the start of the interaction. The default implementation
     * does nothing.
     *  @param anchor the position where the interaction started
     */
    public void trackStart(Point anchor, int modifiersEx);
    
    /**
     * Tracks a step of the interaction.
     *  @param anchor the position where the interaction started
     * @param lead the current position
     */
    public void trackStep(Point anchor, Point lead, int modifiersEx);
    
    /**
     * Tracks the end of the interaction.
     *  @param anchor the position where the interaction started
     * @param lead the current position
     */
    public void trackEnd(Point anchor, Point lead, int modifiersEx);
    
    /**
     * Tracks a double click.
     */
    public void trackDoubleClick(Point p, int modifiersEx);
    
    /**
     * This method is invoked by the drawing view, when its transform
     * has changed. This means, that DrawingView.viewToDrawing and
     * DrawingView.drawingToView will return different values than they
     * did before.
     */
    public void viewTransformChanged();
    
    /**
     * Creates secondary handles.
     */
    @Nullable public Collection<Handle> createSecondaryHandles();
    /**
     * Returns a tooltip for the specified location.
     */
    @Nullable public String getToolTipText(Point p);
}
