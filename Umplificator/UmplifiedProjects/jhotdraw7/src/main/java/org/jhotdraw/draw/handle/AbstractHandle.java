/*
 * @(#)AbstractHandle.java
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
import org.jhotdraw.draw.event.HandleEvent;
import org.jhotdraw.draw.event.FigureListener;
import org.jhotdraw.draw.event.FigureEvent;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.undo.*;
import java.util.*;

/**
 * This abstract class can be extended to implement a {@link Handle}.
 *
 * @author Werner Randelshofer
 * @version $Id: AbstractHandle.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public abstract class AbstractHandle implements Handle, FigureListener {

    final private Figure owner;
    @Nullable protected DrawingView view;
    /** Holds the tool tip text. By default a handle has no tool tip text. */
    private String toolTipText;
    protected EventListenerList listenerList = new EventListenerList();
    /**
     * The bounds of the abstract handle.
     */
    @Nullable private Rectangle bounds;

    /** Creates a new instance. */
    public AbstractHandle(Figure owner) {
        if (owner == null) {
            throw new IllegalArgumentException("owner must not be null");
        }
        this.owner = owner;
        owner.addFigureListener(this);
    }

    protected int getHandlesize() {
        return (Integer) getEditor().getHandleAttribute(HandleAttributeKeys.HANDLE_SIZE);
    }

    /**
     * Adds a listener for this handle.
     */
    @Override
    public void addHandleListener(HandleListener l) {
        listenerList.add(HandleListener.class, l);
    }

    /**
     * Removes a listener for this handle.
     */
    @Override
    public void removeHandleListener(HandleListener l) {
        listenerList.remove(HandleListener.class, l);
    }

    @Override
    public Figure getOwner() {
        return owner;
    }

    @Override
    public void setView(@Nullable DrawingView view) {
        this.view = view;
    }

    @Nullable public DrawingView getView() {
        return view;
    }

    public DrawingEditor getEditor() {
        return view.getEditor();
    }

    /**
     *  Notify all listenerList that have registered interest for
     * notification on this event type.
     */
    protected void fireAreaInvalidated(Rectangle invalidatedArea) {
        HandleEvent event = null;
        // Notify all listeners that have registered interest for
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == HandleListener.class) {
                // Lazily create the event:
                if (event == null) {
                    event = new HandleEvent(this, invalidatedArea);
                }
                ((HandleListener) listeners[i + 1]).areaInvalidated(event);
            }
        }
    }

    /**
     *  Notify all listenerList that have registered interest for
     * notification on this event type.
     */
    protected void fireUndoableEditHappened(UndoableEdit edit) {
        view.getDrawing().fireUndoableEditHappened(edit);
    }

    /**
     *  Notify all listenerList that have registered interest for
     * notification on this event type.
     */
    protected void fireHandleRequestRemove(Rectangle invalidatedArea) {
        HandleEvent event = null;
        // Notify all listeners that have registered interest for
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == HandleListener.class) {
                // Lazily create the event:
                if (event == null) {
                    event = new HandleEvent(this, invalidatedArea);
                }
                ((HandleListener) listeners[i + 1]).handleRequestRemove(event);
            }
        }
    }

    /**
     *  Notify all listenerList that have registered interest for
     * notification on this event type.
     */
    protected void fireHandleRequestSecondaryHandles() {
        HandleEvent event = null;
        // Notify all listeners that have registered interest for
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == HandleListener.class) {
                // Lazily create the event:
                if (event == null) {
                    event = new HandleEvent(this, null);
                }
                ((HandleListener) listeners[i + 1]).handleRequestSecondaryHandles(event);
            }
        }
    }

    /**
     * Draws this handle.
     */
    @Override
    public void draw(Graphics2D g) {
        drawCircle(g,
                (Color) getEditor().getHandleAttribute(HandleAttributeKeys.HANDLE_FILL_COLOR),
                (Color) getEditor().getHandleAttribute(HandleAttributeKeys.HANDLE_STROKE_COLOR));
    }

    protected void drawCircle(Graphics2D g, Color fill, Color stroke) {
        Rectangle r = getBounds();
        if (fill != null) {
            g.setColor(fill);
            g.fillOval(r.x + 1, r.y + 1, r.width - 2, r.height - 2);
        }
        if (stroke != null) {
            g.setStroke(new BasicStroke());
            g.setColor(stroke);
            g.drawOval(r.x, r.y, r.width - 1, r.height - 1);

            if (getView().getActiveHandle() == this) {
                g.fillOval(r.x + 2, r.y + 2, r.width - 4, r.height - 4);
            }
        }
    }

    protected void drawRectangle(Graphics2D g, Color fill, Color stroke) {
        if (fill != null) {
            Rectangle r = getBounds();
            g.setColor(fill);
            r.x += 1;
            r.y += 1;
            r.width -= 2;
            r.height -= 2;
            g.fill(r);
        }
            g.setStroke(new BasicStroke());
        if (stroke != null) {
            Rectangle r = getBounds();
            r.width -= 1;
            r.height -= 1;
            g.setColor(stroke);
            g.draw(r);
            if (getView().getActiveHandle() == this) {
                r.x += 2;
                r.y += 2;
                r.width -= 3;
                r.height -= 3;
                g.fill(r);
            }
        }
    }

    protected void drawDiamond(Graphics2D g, Color fill, Color stroke) {
        if (stroke != null) {
            Rectangle r = getBounds();
            r.grow(1, 1);
            Path2D.Double p = new Path2D.Double();
            p.moveTo(r.x + r.width / 2f, r.y);
            p.lineTo(r.x + r.width, r.y + r.height / 2f);
            p.lineTo(r.x + r.width / 2f, r.y + r.height);
            p.lineTo(r.x, r.y + r.height / 2f);
            p.closePath();
            g.setColor(stroke);
            g.fill(p);
        }
        if (fill != null) {
            Rectangle r = getBounds();
            Path2D.Double p = new Path2D.Double();
            p.moveTo(r.x + r.width / 2f, r.y);
            p.lineTo(r.x + r.width, r.y + r.height / 2f);
            p.lineTo(r.x + r.width / 2f, r.y + r.height);
            p.lineTo(r.x, r.y + r.height / 2f);
            p.closePath();
            g.setColor(fill);
            g.fill(p);
        }
        if (stroke != null && getView().getActiveHandle() == this) {
            Rectangle r = getBounds();
            r.grow(-1, -1);
            Path2D.Double p = new Path2D.Double();
            p.moveTo(r.x + r.width / 2f, r.y);
            p.lineTo(r.x + r.width, r.y + r.height / 2f);
            p.lineTo(r.x + r.width / 2f, r.y + r.height);
            p.lineTo(r.x, r.y + r.height / 2f);
            p.closePath();
            g.setColor(stroke);
            g.fill(p);
        }
    }

    @Override
    public boolean contains(Point p) {
        return getBounds().contains(p);
    }

    @Override
    public void invalidate() {
        bounds = null;
    }

    @Override
    public void dispose() {
        owner.removeFigureListener(this);
    //owner = null;
    }

    /**
     * Sent when a region used by the figure needs to be repainted.
     * The implementation of this method assumes that the handle
     * is located on the bounds of the figure or inside the figure.
     * If the handle is located elsewhere this method must be reimpleted
     * by the subclass.
     */
    @Override
    public void areaInvalidated(FigureEvent evt) {
        updateBounds();
    }

    /**
     * Sent when a figure was added.
     */
    @Override
    public void figureAdded(FigureEvent e) {
        // Empty
    }

    /**
     * Sent when a figure was removed.
     */
    @Override
    public void figureRemoved(FigureEvent e) {
        // Empty
    }

    /**
     * Sent when a figure requests to be removed.
     */
    @Override
    public void figureRequestRemove(FigureEvent e) {
        // Empty
    }

    /**
     * Sent when the bounds or shape of a figure has changed.
     */
    @Override
    public void figureChanged(FigureEvent evt) {
        updateBounds();
    }

    /**
     * Returns a cursor for the handle.
     */
    @Override
    public Cursor getCursor() {
        return Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
    }

    /**
     * Returns true, if the given handle is an instance of the same
     * class or of a subclass of this handle,.
     */
    @Override
    public boolean isCombinableWith(Handle handle) {
        return getClass().isAssignableFrom(handle.getClass());
    }

    @Override
    public void keyTyped(KeyEvent evt) {
    }

    @Override
    public void keyReleased(KeyEvent evt) {
    }

    @Override
    public void keyPressed(KeyEvent evt) {
    }

    @Override
    public final Rectangle getBounds() {
        if (bounds == null) {
            bounds = basicGetBounds();
        }
        return (Rectangle) bounds.clone();
    }

    @Override
    public Rectangle getDrawingArea() {
        Rectangle r = getBounds();
        r.grow(2, 2); // grow by two pixels to take antialiasing into account

        return r;
    }

    protected abstract Rectangle basicGetBounds();

    protected void updateBounds() {
        Rectangle newBounds = basicGetBounds();
        if (bounds == null || !newBounds.equals(bounds)) {
            if (bounds != null) {
                fireAreaInvalidated(getDrawingArea());
            }
            bounds = newBounds;
            fireAreaInvalidated(getDrawingArea());
        }
    }

    /**
     * Tracks a double click.
     */
    @Override
    public void trackDoubleClick(Point p, int modifiersEx) {
    }

    @Override
    public void attributeChanged(FigureEvent e) {
    }

    @Override
    public void viewTransformChanged() {
        invalidate();
    }

    @Override
    public Collection<Handle> createSecondaryHandles() {
        return Collections.emptyList();
    }

    /**
     * Returns a tooltip for the specified location.
     * By default, AbstractHandle returns null.
     */
    @Override
    public String getToolTipText(Point p) {
        return toolTipText;
    }

    /**
     * Changes the default tool tip text returned by AbstractHandle.
     */
    public void setToolTipText(String newValue) {
         toolTipText = newValue;
    }

    @Override
    public void figureHandlesChanged(FigureEvent e) {
    }
}
