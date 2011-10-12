/*
 * @(#)AbstractFigure.java
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
import org.jhotdraw.draw.tool.Tool;
import org.jhotdraw.draw.connector.Connector;
import org.jhotdraw.draw.connector.ChopRectangleConnector;
import org.jhotdraw.draw.event.SetBoundsEdit;
import org.jhotdraw.draw.event.FigureListener;
import org.jhotdraw.draw.event.FigureEvent;
import org.jhotdraw.beans.AbstractBean;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import javax.swing.undo.*;
import org.jhotdraw.draw.handle.BoundsOutlineHandle;
import org.jhotdraw.draw.handle.Handle;
import org.jhotdraw.draw.handle.ResizeHandleKit;
import org.jhotdraw.geom.*;

/**
 * This abstract class can be extended to implement a {@link Figure}.
 *
 *
 * @author Werner Randelshofer
 * @version $Id: AbstractFigure.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public abstract class AbstractFigure
        extends AbstractBean
        implements Figure {

    protected EventListenerList listenerList = new EventListenerList();
    @Nullable private Drawing drawing;
    private boolean isSelectable = true;
    private boolean isRemovable = true;
    private boolean isVisible = true;
    private boolean isTransformable = true;
    private boolean isConnectable=true;
    /**
     * This variable is used to prevent endless change loops.
     * We increase its value on each invocation of willChange() and
     * decrease it on each invocation of changed().
     */
    protected int changingDepth = 0;

    /** Creates a new instance. */
    public AbstractFigure() {
    }

    // DRAWING
    // SHAPE AND BOUNDS
    // ATTRIBUTES
    // EDITING
    // CONNECTING
    // COMPOSITE FIGURES
    // CLONING
    // EVENT HANDLING
    @Override
    public void addFigureListener(FigureListener l) {
        listenerList.add(FigureListener.class, l);
    }

    @Override
    public void removeFigureListener(FigureListener l) {
        listenerList.remove(FigureListener.class, l);
    }

    @Override
    public void addNotify(Drawing d) {
        this.drawing = d;
        fireFigureAdded();
    }

    @Override
    public void removeNotify(Drawing d) {
        fireFigureRemoved();
        this.drawing = null;
    }

    protected Drawing getDrawing() {
        return drawing;
    }

    protected Object getLock() {
        return (getDrawing() == null) ? this : getDrawing().getLock();
    }

    /**
     *  Notify all listenerList that have registered interest for
     * notification on this event type.
     */
    public void fireAreaInvalidated() {
        fireAreaInvalidated(getDrawingArea());
    }

    /**
     *  Notify all listenerList that have registered interest for
     * notification on this event type.
     */
    protected void fireAreaInvalidated(Rectangle2D.Double invalidatedArea) {
        if (listenerList.getListenerCount() > 0) {
            FigureEvent event = null;
            // Notify all listeners that have registered interest for
            // Guaranteed to return a non-null array
            Object[] listeners = listenerList.getListenerList();
            // Process the listeners last to first, notifying
            // those that are interested in this event
            for (int i = listeners.length - 2; i >= 0; i -= 2) {
                if (listeners[i] == FigureListener.class) {
                    // Lazily create the event:
                    if (event == null) {
                        event = new FigureEvent(this, invalidatedArea);
                    }
                    ((FigureListener) listeners[i + 1]).areaInvalidated(event);
                }
            }
        }
    }

    /**
     *  Notify all listenerList that have registered interest for
     * notification on this event type.
     */
    protected void fireAreaInvalidated(FigureEvent event) {
        // Notify all listeners that have registered interest for
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == FigureListener.class) {
                ((FigureListener) listeners[i + 1]).areaInvalidated(event);
            }
        }
    }

    /**
     *  Notify all listenerList that have registered interest for
     * notification on this event type.
     */
    protected void fireFigureRequestRemove() {
        if (listenerList.getListenerCount() > 0) {
            FigureEvent event = null;
            // Notify all listeners that have registered interest for
            // Guaranteed to return a non-null array
            Object[] listeners = listenerList.getListenerList();
            // Process the listeners last to first, notifying
            // those that are interested in this event
            for (int i = listeners.length - 2; i >= 0; i -= 2) {
                if (listeners[i] == FigureListener.class) {
                    // Lazily create the event:
                    if (event == null) {
                        event = new FigureEvent(this, getBounds());
                    }
                    ((FigureListener) listeners[i + 1]).figureRequestRemove(event);
                }
            }
        }
    }

    /**
     *  Notify all listenerList that have registered interest for
     * notification on this event type.
     */
    protected void fireFigureAdded() {
        if (listenerList.getListenerCount() > 0) {
            FigureEvent event = null;
            // Notify all listeners that have registered interest for
            // Guaranteed to return a non-null array
            Object[] listeners = listenerList.getListenerList();
            // Process the listeners last to first, notifying
            // those that are interested in this event
            for (int i = listeners.length - 2; i >= 0; i -= 2) {
                if (listeners[i] == FigureListener.class) {
                    // Lazily create the event:
                    if (event == null) {
                        event = new FigureEvent(this, getBounds());
                    }
                    ((FigureListener) listeners[i + 1]).figureAdded(event);
                }
            }
        }
    }

    /**
     *  Notify all listenerList that have registered interest for
     * notification on this event type.
     */
    protected void fireFigureRemoved() {
        if (listenerList.getListenerCount() > 0) {
            FigureEvent event = null;
            // Notify all listeners that have registered interest for
            // Guaranteed to return a non-null array
            Object[] listeners = listenerList.getListenerList();
            // Process the listeners last to first, notifying
            // those that are interested in this event
            for (int i = listeners.length - 2; i >= 0; i -= 2) {
                if (listeners[i] == FigureListener.class) {
                    // Lazily create the event:
                    if (event == null) {
                        event = new FigureEvent(this, getBounds());
                    }
                    ((FigureListener) listeners[i + 1]).figureRemoved(event);
                }
            }
        }
    }

    public void fireFigureChanged() {
        fireFigureChanged(getDrawingArea());
    }

    /**
     *  Notify all listenerList that have registered interest for
     * notification on this event type.
     */
    protected void fireFigureChanged(Rectangle2D.Double changedArea) {
        if (listenerList.getListenerCount() > 0) {
            FigureEvent event = null;
            // Notify all listeners that have registered interest for
            // Guaranteed to return a non-null array
            Object[] listeners = listenerList.getListenerList();
            // Process the listeners last to first, notifying
            // those that are interested in this event
            for (int i = listeners.length - 2; i >= 0; i -= 2) {
                if (listeners[i] == FigureListener.class) {
                    // Lazily create the event:
                    if (event == null) {
                        event = new FigureEvent(this, changedArea);
                    }
                    ((FigureListener) listeners[i + 1]).figureChanged(event);
                }
            }
        }
    }

    protected void fireFigureChanged(FigureEvent event) {
        if (listenerList.getListenerCount() > 0) {
            // Notify all listeners that have registered interest for
            // Guaranteed to return a non-null array
            Object[] listeners = listenerList.getListenerList();
            // Process the listeners last to first, notifying
            // those that are interested in this event
            for (int i = listeners.length - 2; i >= 0; i -= 2) {
                if (listeners[i] == FigureListener.class) {
                    // Lazily create the event:
                    ((FigureListener) listeners[i + 1]).figureChanged(event);
                }
            }
        }
    }

    /**
     *  Notify all listenerList that have registered interest for
     * notification on this event type.
     */
    protected void fireAttributeChanged(AttributeKey attribute, Object oldValue, Object newValue) {
        if (listenerList.getListenerCount() > 0 &&
                (oldValue == null || newValue == null || !oldValue.equals(newValue))) {
            FigureEvent event = null;
            // Notify all listeners that have registered interest for
            // Guaranteed to return a non-null array
            Object[] listeners = listenerList.getListenerList();
            // Process the listeners last to first, notifying
            // those that are interested in this event
            for (int i = listeners.length - 2; i >= 0; i -= 2) {
                if (listeners[i] == FigureListener.class) {
                    // Lazily create the event:
                    if (event == null) {
                        event = new FigureEvent(this, attribute, oldValue, newValue);
                    }
                    ((FigureListener) listeners[i + 1]).attributeChanged(event);
                }
            }
        }
    }

    /**
     *  Notify all listenerList that have registered interest for
     * notification on this event type.
     */
    protected void fireFigureHandlesChanged() {
        Rectangle2D.Double changedArea = getDrawingArea();
        if (listenerList.getListenerCount() > 0) {
            FigureEvent event = null;
            // Notify all listeners that have registered interest for
            // Guaranteed to return a non-null array
            Object[] listeners = listenerList.getListenerList();
            // Process the listeners last to first, notifying
            // those that are interested in this event
            for (int i = listeners.length - 2; i >= 0; i -= 2) {
                if (listeners[i] == FigureListener.class) {
                    // Lazily create the event:
                    if (event == null) {
                        event = new FigureEvent(this, changedArea);
                    }
                    ((FigureListener) listeners[i + 1]).figureHandlesChanged(event);
                }
            }
        }
    }

    /**
     * Notify all UndoableEditListener of the Drawing, to which this Figure has
     * been added to. If this Figure is not part of a Drawing, the event is
     * lost.
     */
    protected void fireUndoableEditHappened(UndoableEdit edit) {
        if (getDrawing() != null) {
            getDrawing().fireUndoableEditHappened(edit);
        }
    }
    /*
    public Set createHandles() {
    return new HashSet();
    }
     */

    @Override
    public AbstractFigure clone() {
        AbstractFigure that = (AbstractFigure) super.clone();
        that.listenerList = new EventListenerList();
        that.drawing = null; // Clones need to be explictly added to a drawing
        return that;
    }

    @Override
    public void remap(Map<Figure, Figure> oldToNew, boolean disconnectIfNotInMap) {
    }

    @Override
    public Collection<Handle> createHandles(int detailLevel) {
        LinkedList<Handle> handles = new LinkedList<Handle>();
        switch (detailLevel) {
            case -1:
                handles.add(new BoundsOutlineHandle(this,false,true));
                break;
            case 0:
                ResizeHandleKit.addResizeHandles(this, handles);
                break;
        }
        return handles;
    }

    @Override
    public Cursor getCursor(Point2D.Double p) {
        if (contains(p)) {
            return Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        } else {
            return Cursor.getDefaultCursor();
        }
    }

    public final void setBounds(Rectangle2D.Double bounds) {
        setBounds(new Point2D.Double(bounds.x, bounds.y), new Point2D.Double(bounds.x + bounds.width, bounds.y + bounds.height));
    }

    @Override
    public void setBounds(Point2D.Double anchor, Point2D.Double lead) {
        Point2D.Double oldAnchor = getStartPoint();
        Point2D.Double oldLead = getEndPoint();
        if (!oldAnchor.equals(anchor) || !oldLead.equals(lead)) {
            willChange();
            setBounds(anchor, lead);
            changed();
            fireUndoableEditHappened(new SetBoundsEdit(this, oldAnchor, oldLead, anchor, lead));
        }
    }

    /**
     * Invalidates cached data of the Figure.
     * This method must execute fast, because it can be called very often. 
     */
    protected void invalidate() {
    }

    protected boolean isChanging() {
        return changingDepth != 0;
    }

    protected int getChangingDepth() {
        return changingDepth;
    }

    /**
     * Informs that a figure is about to change something that
     * affects the contents of its display box.
     */
    @Override
    public void willChange() {
        if (changingDepth == 0) {
            fireAreaInvalidated();
            invalidate();
        }
        changingDepth++;
    }

    protected void validate() {
    }

    /**
     * Informs that a figure changed the area of its display box.
     */
    @Override
    public void changed() {
        if (changingDepth == 1) {
            validate();
            fireFigureChanged(getDrawingArea());
        } else if (changingDepth < 0) {
            throw new InternalError("changed was called without a prior call to willChange. "+changingDepth);
        }
        changingDepth--;
    }

    /**
     * Returns the Figures connector for the specified location.
     * By default a ChopBoxConnector is returned.
     *
     *
     * @see ChopRectangleConnector
     */
    @Override
    public Connector findConnector(Point2D.Double p, ConnectionFigure prototype) {
        return new ChopRectangleConnector(this);
    }

    @Override
    public boolean includes(Figure figure) {
        return figure == this;
    }

    @Override
    @Nullable public Figure findFigureInside(Point2D.Double p) {
        return (contains(p)) ? this : null;
    }

    @Override
    public Connector findCompatibleConnector(Connector c, boolean isStart) {
        return new ChopRectangleConnector(this);
    }

    /**
     * Returns a collection of actions which are presented to the user
     * in a popup menu.
     * <p>The collection may contain null entries. These entries are used
     * interpreted as separators in the popup menu.
     */
    @Override
    public Collection<Action> getActions(Point2D.Double p) {
        return Collections.emptyList();
    }

    /**
     * Returns a specialized tool for the given coordinate.
     * <p>Returns null, if no specialized tool is available.
     */
    @Override
    public Tool getTool(Point2D.Double p) {
        return null;
    }

    /**
     * Handles a mouse click.
     */
    @Override
    public boolean handleMouseClick(Point2D.Double p, MouseEvent evt, DrawingView view) {
        return false;
    }

    @Override
    public boolean handleDrop(Point2D.Double p, Collection<Figure> droppedFigures, DrawingView view) {
        return false;
    }

    @Override
    public Point2D.Double getEndPoint() {
        Rectangle2D.Double r = getBounds();
        return new Point2D.Double(r.x + r.width, r.y + r.height);
    }

    @Override
    public Point2D.Double getStartPoint() {
        Rectangle2D.Double r = getBounds();
        return new Point2D.Double(r.x, r.y);
    }
    /*
    public Rectangle2D.Double getHitBounds() {
    return getBounds();
    }
     */

    @Override
    public Dimension2DDouble getPreferredSize() {
        Rectangle2D.Double r = getBounds();
        return new Dimension2DDouble(r.width, r.height);
    }
    /**
     * Checks whether this figure is connectable. By default
     * {@code AbstractFigure} can be connected.
     */
    @Override
    public boolean isConnectable() {
        return isConnectable;
    }

    public void setConnectable(boolean newValue) {
        boolean oldValue = isConnectable;
        isConnectable = newValue;
        firePropertyChange(CONNECTABLE_PROPERTY, oldValue, newValue);
    }

    /**
     * Checks whether this figure is selectable. By default
     * {@code AbstractFigure} can be selected.
     */
    @Override
    public boolean isSelectable() {
        return isSelectable;
    }

    public void setSelectable(boolean newValue) {
        boolean oldValue = isSelectable;
        isSelectable = newValue;
        firePropertyChange(SELECTABLE_PROPERTY, oldValue, newValue);
    }

    /**
     * Checks whether this figure is removable. By default
     * {@code AbstractFigure} can be removed.
     */
    @Override
    public boolean isRemovable() {
        return isRemovable;
    }

    public void setRemovable(boolean newValue) {
        boolean oldValue = isRemovable;
        isRemovable = newValue;
        firePropertyChange(REMOVABLE_PROPERTY, oldValue, newValue);
    }

    /**
     * Checks whether this figure is transformable. By default
     * {@code AbstractFigure} can be transformed.
     */
    @Override
    public boolean isTransformable() {
        return isTransformable;
    }

    public void setTransformable(boolean newValue) {
        boolean oldValue = isTransformable;
        isTransformable = newValue;
        firePropertyChange(TRANSFORMABLE_PROPERTY, oldValue, newValue);
    }

    /**
     * Checks whether this figure is visible. By default
     * {@code AbstractFigure} is visible.
     */
    @Override
    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean newValue) {
        if (newValue != isVisible) {
            willChange();
            isVisible = newValue;
            changed();
        }
    }

    @Override
    public Collection<Figure> getDecomposition() {
        LinkedList<Figure> list = new LinkedList<Figure>();
        list.add(this);
        return list;
    }

    protected FontRenderContext getFontRenderContext() {
        FontRenderContext frc = null;
        if (frc == null) {
            frc = new FontRenderContext(new AffineTransform(), true, true);
        }
        return frc;
    }

    @Override
    public void requestRemove() {
        fireFigureRequestRemove();
    }

    /** AbstractFigure always returns 0.
     * Override this method if your figure needs to be on a different layer.
     */
    @Override
    public int getLayer() {
        return 0;
    }

    @Override
    public String getToolTipText(Point2D.Double p) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append(getClass().getName().substring(getClass().getName().lastIndexOf('.') + 1));
        buf.append('@');
        buf.append(hashCode());
        return buf.toString();
    }

    @Override
    public Collection<Connector> getConnectors(ConnectionFigure prototype) {
        LinkedList<Connector> connectors = new LinkedList<Connector>();
        connectors.add(new ChopRectangleConnector(this));
        return connectors;
    }
}
