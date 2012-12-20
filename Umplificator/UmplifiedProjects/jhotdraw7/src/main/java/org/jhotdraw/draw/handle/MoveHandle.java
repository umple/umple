/*
 * @(#)MoveHandle.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw.handle;

import org.jhotdraw.draw.locator.RelativeLocator;
import org.jhotdraw.draw.locator.Locator;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.event.TransformEdit;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.*;
import java.util.*;

/**
 * A handle that changes the location of the owning figure, if the figure is
 * transformable. 
 *
 * @author Werner Randelshofer
 * @version $Id: MoveHandle.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class MoveHandle extends LocatorHandle {

    /**
     * The previously handled x and y coordinates.
     */
    private Point2D.Double oldPoint;

    /** Creates a new instance. */
    public MoveHandle(Figure owner, Locator locator) {
        super(owner, locator);
    }

    /**
     * Creates handles for each corner of a
     * figure and adds them to the provided collection.
     */
    static public void addMoveHandles(Figure f, Collection<Handle> handles) {
        handles.add(southEast(f));
        handles.add(southWest(f));
        handles.add(northEast(f));
        handles.add(northWest(f));
    }

    /**
     * Draws this handle.
     * <p>
     * If the figure is transformable, the handle is drawn as a filled rectangle.
     * If the figure is not transformable, the handle is drawn as an unfilled
     * rectangle.
     */
    @Override
    public void draw(Graphics2D g) {
        if (getOwner().isTransformable()) {
            drawRectangle(g,
                    (Color) getEditor().getHandleAttribute(HandleAttributeKeys.MOVE_HANDLE_FILL_COLOR),
                    (Color) getEditor().getHandleAttribute(HandleAttributeKeys.MOVE_HANDLE_STROKE_COLOR));
        } else {
            drawRectangle(g,
                    (Color) getEditor().getHandleAttribute(HandleAttributeKeys.NULL_HANDLE_FILL_COLOR),
                    (Color) getEditor().getHandleAttribute(HandleAttributeKeys.NULL_HANDLE_STROKE_COLOR));
        }
    }

    /**
     * Returns a cursor for the handle. 
     * 
     * @return Returns a move cursor, if the figure
     * is transformable. Returns a default cursor otherwise. 
     */
    @Override
    public Cursor getCursor() {
        return Cursor.getPredefinedCursor(
                getOwner().isTransformable() ? Cursor.MOVE_CURSOR : Cursor.DEFAULT_CURSOR);
    }

    @Override
    public void trackStart(Point anchor, int modifiersEx) {
        oldPoint = view.getConstrainer().constrainPoint(view.viewToDrawing(anchor));
    }

    @Override
    public void trackStep(Point anchor, Point lead, int modifiersEx) {
        Figure f = getOwner();
        if (f.isTransformable()) {
            Point2D.Double newPoint = view.getConstrainer().constrainPoint(view.viewToDrawing(lead));
            AffineTransform tx = new AffineTransform();
            tx.translate(newPoint.x - oldPoint.x, newPoint.y - oldPoint.y);
            f.willChange();
            f.transform(tx);
            f.changed();

            oldPoint = newPoint;
        }
    }

    @Override
    public void trackEnd(Point anchor, Point lead, int modifiersEx) {
        if (getOwner().isTransformable()) {
            AffineTransform tx = new AffineTransform();
            tx.translate(lead.x - anchor.x, lead.y - anchor.y);
            fireUndoableEditHappened(
                    new TransformEdit(getOwner(), tx));
        }
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        Figure f = getOwner();
        if (f.isTransformable()) {
            AffineTransform tx = new AffineTransform();

            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                    tx.translate(0, -1);
                    evt.consume();
                    break;
                case KeyEvent.VK_DOWN:
                    tx.translate(0, +1);
                    evt.consume();
                    break;
                case KeyEvent.VK_LEFT:
                    tx.translate(-1, 0);
                    evt.consume();
                    break;
                case KeyEvent.VK_RIGHT:
                    tx.translate(+1, 0);
                    evt.consume();
                    break;
            }
            f.willChange();
            f.transform(tx);
            f.changed();
            fireUndoableEditHappened(
                    new TransformEdit(f, tx));
        }

    }

    static public Handle south(
            Figure owner) {
        return new MoveHandle(owner, RelativeLocator.south());
    }

    static public Handle southEast(
            Figure owner) {
        return new MoveHandle(owner, RelativeLocator.southEast());
    }

    static public Handle southWest(
            Figure owner) {
        return new MoveHandle(owner, RelativeLocator.southWest());
    }

    static public Handle north(
            Figure owner) {
        return new MoveHandle(owner, RelativeLocator.north());
    }

    static public Handle northEast(
            Figure owner) {
        return new MoveHandle(owner, RelativeLocator.northEast());
    }

    static public Handle northWest(
            Figure owner) {
        return new MoveHandle(owner, RelativeLocator.northWest());
    }

    static public Handle east(
            Figure owner) {
        return new MoveHandle(owner, RelativeLocator.east());
    }

    static public Handle west(
            Figure owner) {
        return new MoveHandle(owner, RelativeLocator.west());
    }
}
