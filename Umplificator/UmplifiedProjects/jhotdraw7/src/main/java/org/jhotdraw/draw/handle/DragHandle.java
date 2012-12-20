/*
 * @(#)DragHandle.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.handle;

import org.jhotdraw.draw.*;
import org.jhotdraw.draw.event.TransformEdit;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
/**
 * A handle that changes the location of the owning figure, the handle
 * covers all visible points of the figure.
 * <p>
 * Usually, DragHandle is not needed, because of the
 * {@link org.jhotdraw.draw.tool.DragTracker}
 * in the |@code SelectionTool}. Use a (subclass of) {@code DragHandle}, if you want
 * to implement figure specific drag behavior. A {@code CompositeFigure} can
 * create {@code DragHandle}s for all its child figures, to support dragging
 * of child figures without having to decompose the CompositeFigure.
 *
 * @author Werner Randelshofer
 * @version $Id: DragHandle.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class DragHandle extends AbstractHandle {
    /**
     * The previously handled x and y coordinates.
     */
    private Point2D.Double oldPoint;
    
    /** Creates a new instance. */
    public DragHandle(Figure owner) {
        super(owner);
    }
    
    /**
     * Draws nothing.
     * Drag Handles have no visual appearance of their own.
     */
    @Override
    public void draw(Graphics2D g) {
    }
    @Override
    public void trackStart(Point anchor, int modifiersEx) {
        oldPoint = view.getConstrainer().constrainPoint(view.viewToDrawing(anchor));
    }
    @Override
    public void trackStep(Point anchor, Point lead, int modifiersEx) {
        Figure f = getOwner();
        Point2D.Double newPoint = view.getConstrainer().constrainPoint(view.viewToDrawing(lead));
        AffineTransform tx = new AffineTransform();
        tx.translate(newPoint.x - oldPoint.x, newPoint.y - oldPoint.y);
        f.willChange();
        f.transform(tx);
        f.changed();
        
        oldPoint = newPoint;
    }
    @Override
    public void trackEnd(Point anchor, Point lead, int modifiersEx) {
        AffineTransform tx = new AffineTransform();
        tx.translate(lead.x - anchor.x, lead.y - anchor.y);
        
        LinkedList<Figure> draggedFigures = new LinkedList<Figure>();
        draggedFigures.add(getOwner());
        Point2D.Double dropPoint = getView().viewToDrawing(lead);
        Figure dropTarget = getView().getDrawing().findFigureExcept(
                dropPoint, draggedFigures);
        if (dropTarget != null) {
            boolean snapBack = dropTarget.handleDrop(dropPoint, draggedFigures, getView());
            if (snapBack) {
                tx = new AffineTransform();
                tx.translate(anchor.x - lead.x, anchor.y - lead.y);
                for (Figure f : draggedFigures) {
                    f.willChange();
                    f.transform(tx);
                    f.changed();
                }
            } else {
                fireUndoableEditHappened(
                        new TransformEdit(getOwner(),tx)
                        );
            }
        } else {
            fireUndoableEditHappened(
                    new TransformEdit(getOwner(),tx)
                    );
        }
    }
    
    @Override
    public boolean contains(Point p) {
        return getOwner().contains(getView().viewToDrawing(p));
    }
    
    @Override
    protected Rectangle basicGetBounds() {
        return getView().drawingToView(getOwner().getDrawingArea());
    }
    /**
     * Returns a cursor for the handle.
     */
    @Override
    public Cursor getCursor() {
        return Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
    }
}

