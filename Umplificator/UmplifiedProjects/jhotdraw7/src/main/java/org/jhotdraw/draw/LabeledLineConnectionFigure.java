/*
 * @(#)LabeledLineConnection.java
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
import org.jhotdraw.draw.layouter.Layouter;
import org.jhotdraw.draw.event.FigureAdapter;
import org.jhotdraw.draw.event.FigureEvent;
import org.jhotdraw.draw.event.CompositeFigureEvent;
import org.jhotdraw.draw.event.CompositeFigureListener;
import org.jhotdraw.util.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.Serializable;
import javax.swing.event.*;

/**
 * A LineConnection with labels.
 * <p>
 * Usage:
 * <pre>
 * LineConnectionFigure lcf = new LineConnectionFigure();
 * lcf.setLayouter(new LocatorLayouter());
 * TextFigure label = new TextFigure();
 * label.setText("Hello");
 * LocatorLayouter.LAYOUT_LOCATOR.set(label, new BezierLabelLocator(0, -Math.PI / 4, 8));
 * lcf.add(label);
 * </pre>
 *
 * @author Werner Randelshofer
 * @version $Id: LabeledLineConnectionFigure.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class LabeledLineConnectionFigure extends LineConnectionFigure
        implements CompositeFigure {
    
    private Layouter layouter;
    private ArrayList<Figure> children = new ArrayList<Figure>();
    @Nullable private transient Rectangle2D.Double cachedDrawingArea;
    
    /**
     * Handles figure changes in the children.
     */
    private ChildHandler childHandler = new ChildHandler(this);
    private static class ChildHandler extends FigureAdapter implements UndoableEditListener, Serializable {
        private LabeledLineConnectionFigure owner;
        private ChildHandler(LabeledLineConnectionFigure owner) {
            this.owner = owner;
        }
        @Override public void figureRequestRemove(FigureEvent e) {
            owner.remove(e.getFigure());
        }
        
        @Override public void figureChanged(FigureEvent e) {
            if (! owner.isChanging()) {
                owner.willChange();
                owner.fireFigureChanged(e);
                owner.changed();
            }
        }
        
        @Override public void areaInvalidated(FigureEvent e) {
            if (! owner.isChanging()) {
                owner.fireAreaInvalidated(e.getInvalidatedArea());
            }
        }

    @Override
        public void undoableEditHappened(UndoableEditEvent e) {
            owner.fireUndoableEditHappened(e.getEdit());
        }
    };
    /** Creates a new instance. */
    public LabeledLineConnectionFigure() {
    }
    // DRAWING
    /**
     * Draw the figure. This method is delegated to the encapsulated presentation figure.
     */
    @Override
    public void draw(Graphics2D g) {
        super.draw(g);
        for (Figure child : children) {
            if (child.isVisible()) {
                child.draw(g);
            }
        }
    }
    
    // SHAPE AND BOUNDS
    /**
     * Transforms the figure.
     */
    @Override
    public void transform(AffineTransform tx) {
        super.transform(tx);
        for (Figure f : children) {
            f.transform(tx);
        }
        invalidate();
    }
    @Override
    public Rectangle2D.Double getDrawingArea() {
        if (cachedDrawingArea == null) {
            cachedDrawingArea = super.getDrawingArea();
            for (Figure child : getChildrenFrontToBack()) {
                if (child.isVisible()) {
                    Rectangle2D.Double childBounds = child.getDrawingArea();
                    if (! childBounds.isEmpty()) {
                        cachedDrawingArea.add(childBounds);
                    }
                }
            }
        }
        return (Rectangle2D.Double) cachedDrawingArea.clone();
    }
    @Override
    public boolean contains(Point2D.Double p) {
        if (getDrawingArea().contains(p)) {
            for (Figure child : getChildrenFrontToBack()) {
                if (child.isVisible() && child.contains(p)) return true;
            }
            return super.contains(p);
        }
        return false;
    }
    // ATTRIBUTES
    /**
     * Sets an attribute of the figure.
     * AttributeKey name and semantics are defined by the class implementing
     * the figure interface.
     */
    @Override
    public <T> void set(AttributeKey<T> key, T newValue) {
        super.set(key, newValue);
        if (isAttributeEnabled(key)) {
            if (children != null) {
                for (Figure child : children) {
                    child.set(key, newValue);
                }
            }
        }
    }
    // EDITING
    @Override
    public Figure findFigureInside(Point2D.Double p) {
        if (getDrawingArea().contains(p)) {
            Figure found = null;
            for (Figure child : getChildrenFrontToBack()) {
                if (child.isVisible()) {
                    found = child.findFigureInside(p);
                    if (found != null) {
                        return found;
                    }
                }
            }
        }
        return null;
    }
    // CONNECTING
    @Override
    public void updateConnection() {
        super.updateConnection();
        layout();
    }
    
    // COMPOSITE FIGURES
    @Override
    public java.util.List<Figure> getChildren() {
        return Collections.unmodifiableList(children);
    }
    @Override
    public int getChildCount() {
        return children.size();
    }
    @Override
    public Figure getChild(int index) {
        return children.get(index);
    }
    /**
     * Returns an iterator to iterate in
     * Z-order front to back over the children.
     */
    public java.util.List<Figure> getChildrenFrontToBack() {
        return children ==  null ?
            new LinkedList<Figure>() :
            new ReversedList<Figure>(children);
    }
    
    @Override
    public boolean add(Figure figure) {
        basicAdd(figure);
        if (getDrawing() != null) {
            figure.addNotify(getDrawing());
        }
        return true;
    }
    @Override
    public void add(int index, Figure figure) {
        basicAdd(index, figure);
        if (getDrawing() != null) {
            figure.addNotify(getDrawing());
        }
    }
    @Override
    public void basicAdd(Figure figure) {
        basicAdd(children.size(), figure);
    }
    @Override
    public void basicAdd(int index, Figure figure) {
        children.add(index, figure);
        figure.addFigureListener(childHandler);
        invalidate();
    }
    @Override
    public boolean remove(final Figure figure) {
        int index = children.indexOf(figure);
        if (index == -1) {
            return false;
        } else {
            willChange();
            basicRemoveChild(index);
            if (getDrawing() != null) {
                figure.removeNotify(getDrawing());
            }
            changed();
            return true;
        }
    }
    @Override
    public Figure removeChild(int index) {
        willChange();
        Figure figure = basicRemoveChild(index);
        if (getDrawing() != null) {
            figure.removeNotify(getDrawing());
        }
        changed();
        return figure;
    }
    @Override
    public int basicRemove(final Figure figure) {
        int index = children.indexOf(figure);
        if (index != -1) {
            basicRemoveChild(index);
        }
        return index;
    }
    @Override
    public Figure basicRemoveChild(int index) {
        Figure figure = children.remove(index);
        figure.removeFigureListener(childHandler);
        return figure;
    }
    
    @Override
    public void removeAllChildren() {
        willChange();
        while (children.size() > 0) {
            Figure figure = basicRemoveChild(children.size() - 1);
            if (getDrawing() != null) {
                figure.removeNotify(getDrawing());
            }
        }
        changed();
    }
    @Override
    public void basicRemoveAllChildren() {
        while (children.size() > 0) {
            basicRemoveChild(children.size() - 1);
        }
    }
    // LAYOUT
    /**
     * Get a Layouter object which encapsulated a layout
     * algorithm for this figure. Typically, a Layouter
     * accesses the child components of this figure and arranges
     * their graphical presentation.
     *
     *
     * @return layout strategy used by this figure
     */
    @Override
    public Layouter getLayouter() {
        return layouter;
    }
    @Override
    public void setLayouter(Layouter newLayouter) {
        this.layouter = newLayouter;
    }
    
    /**
     * A layout algorithm is used to define how the child components
     * should be laid out in relation to each other. The task for
     * layouting the child components for presentation is delegated
     * to a Layouter which can be plugged in at runtime.
     */
    @Override
    public void layout() {
        if (getLayouter() != null) {
            Rectangle2D.Double bounds = getBounds();
            Point2D.Double p = new Point2D.Double(bounds.x, bounds.y);
            getLayouter().layout(this, p, p);
            invalidate();
        }
    }
    
// EVENT HANDLING
    
    @Override
    public void invalidate() {
        super.invalidate();
        cachedDrawingArea = null;
    }
    @Override
    public void validate() {
        super.validate();
        layout();
    }
    @Override
    public void addNotify(Drawing drawing) {
        for (Figure child : new LinkedList<Figure>(children)) {
            child.addNotify(drawing);
        }
        super.addNotify(drawing);
    }
    @Override
    public void removeNotify(Drawing drawing) {
        for (Figure child : new LinkedList<Figure>(children)) {
            child.removeNotify(drawing);
        }
        super.removeNotify(drawing);
    }
    @Override
    public void removeCompositeFigureListener(CompositeFigureListener listener) {
        listenerList.remove(CompositeFigureListener.class, listener);
    }

    @Override
    public void addCompositeFigureListener(CompositeFigureListener listener) {
        listenerList.add(CompositeFigureListener.class, listener);
    }
    /**
     *  Notify all listenerList that have registered interest for
     * notification on this event type.
     */
    protected void fireFigureAdded(Figure f, int zIndex) {
        CompositeFigureEvent event = null;
        // Notify all listeners that have registered interest for
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length-2; i>=0; i-=2) {
            if (listeners[i] == CompositeFigureListener.class) {
                // Lazily create the event:
                if (event == null)
                    event = new CompositeFigureEvent(this, f, f.getDrawingArea(), zIndex);
                ((CompositeFigureListener)listeners[i+1]).figureAdded(event);
            }
        }
    }
    
    /**
     *  Notify all listenerList that have registered interest for
     * notification on this event type.
     */
    protected void fireFigureRemoved(Figure f, int zIndex) {
        CompositeFigureEvent event = null;
        // Notify all listeners that have registered interest for
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length-2; i>=0; i-=2) {
            if (listeners[i] == CompositeFigureListener.class) {
                // Lazily create the event:
                if (event == null)
                    event = new CompositeFigureEvent(this, f, f.getDrawingArea(), zIndex);
                ((CompositeFigureListener)listeners[i+1]).figureRemoved(event);
            }
        }
    }
    
    // CLONING
    @Override
    public LabeledLineConnectionFigure clone() {
        LabeledLineConnectionFigure that = (LabeledLineConnectionFigure) super.clone();
        that.childHandler = new ChildHandler(that);
        that.children = new ArrayList<Figure>();
        for (Figure thisChild : this.children) {
            Figure thatChild = (Figure) thisChild.clone();
            that.children.add(thatChild);
            thatChild.addFigureListener(that.childHandler);
        }
        return that;
    }
    @Override
    public void remap(Map<Figure,Figure> oldToNew, boolean disconnectIfNotInMap) {
        super.remap(oldToNew, disconnectIfNotInMap);
        for (Figure child : children) {
            child.remap(oldToNew, disconnectIfNotInMap);
        }
    }

    @Override
    public boolean contains(Figure f) {
        return children.contains(f);
    }

    @Override
    public int indexOf(Figure child) {
        return children.indexOf(child);
    }
}
