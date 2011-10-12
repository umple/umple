/*
 * @(#)TransformHandleKit.java
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
import org.jhotdraw.draw.event.TransformRestoreEdit;
import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import org.jhotdraw.util.ResourceBundleUtil;
import static org.jhotdraw.draw.AttributeKeys.*;
import static org.jhotdraw.draw.handle.HandleAttributeKeys.*;

/**
 * A set of utility methods to create Handles which transform a Figure by using
 * its <code>transform</code> method.
 * 
 * 
 * @author Werner Randelshofer
 * @version $Id: TransformHandleKit.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class TransformHandleKit {

    /** Creates a new instance. */
    public TransformHandleKit() {
    }

    /**
     * Creates handles for each corner of a
     * figure and adds them to the provided collection.
     */
    static public void addCornerTransformHandles(Figure f, Collection<Handle> handles) {
        if (f.isTransformable()) {
            handles.add(southEast(f));
            handles.add(southWest(f));
            handles.add(northEast(f));
            handles.add(northWest(f));
        }
    }

    /**
     * Fills the given Vector with handles at each
     * the north, south, east, and west of the figure.
     */
    static public void addEdgeTransformHandles(Figure f, Collection<Handle> handles) {
        if (f.isTransformable()) {
            handles.add(south(f));
            handles.add(north(f));
            handles.add(east(f));
            handles.add(west(f));
        }
    }

    /**
     * Adds handles for scaling and moving a Figure.
     */
    static public void addScaleMoveTransformHandles(Figure f, Collection<Handle> handles) {
        if (f.isTransformable()) {
            addCornerTransformHandles(f, handles);
            addEdgeTransformHandles(f, handles);
        }
    }

    /**
     * Adds handles for scaling, moving, rotating and shearing a Figure.
     */
    static public void addTransformHandles(Figure f, Collection<Handle> handles) {
        handles.add(new BoundsOutlineHandle(f, true, false));
        if (f.isTransformable()) {
            addCornerTransformHandles(f, handles);
            addEdgeTransformHandles(f, handles);
            handles.add(new RotateHandle(f));
        }
    }

    /**
     * Adds handles for scaling, moving, rotating and shearing a Figure.
     */
    static public void addGroupTransformHandles(Figure f, Collection<Handle> handles) {
        handles.add(new BoundsOutlineHandle(f,
                GROUP_BOUNDS_STROKE_1, GROUP_BOUNDS_COLOR_1,
                GROUP_BOUNDS_STROKE_2, GROUP_BOUNDS_COLOR_2,
                GROUP_BOUNDS_STROKE_1_DISABLED, GROUP_BOUNDS_COLOR_1_DISABLED,
                GROUP_BOUNDS_STROKE_2_DISABLED, GROUP_BOUNDS_COLOR_2_DISABLED));
        addCornerTransformHandles(f, handles);
        addEdgeTransformHandles(f, handles);
        handles.add(new RotateHandle(f));
    }

    /**
     * Adds handles for scaling, moving, rotating and shearing a Figure.
     */
    static public void addGroupHoverHandles(Figure f, Collection<Handle> handles) {
        handles.add(new BoundsOutlineHandle(f,
                GROUP_BOUNDS_STROKE_1_HOVER, GROUP_BOUNDS_COLOR_1_HOVER,
                GROUP_BOUNDS_STROKE_2_HOVER, GROUP_BOUNDS_COLOR_2_HOVER,
                GROUP_BOUNDS_STROKE_1_DISABLED, GROUP_BOUNDS_COLOR_1_DISABLED,
                GROUP_BOUNDS_STROKE_2_DISABLED, GROUP_BOUNDS_COLOR_2_DISABLED));
    }

    static public Handle south(Figure owner) {
        return new SouthHandle(owner);
    }

    static public Handle southEast(Figure owner) {
        return new SouthEastHandle(owner);
    }

    static public Handle southWest(Figure owner) {
        return new SouthWestHandle(owner);
    }

    static public Handle north(Figure owner) {
        return new NorthHandle(owner);
    }

    static public Handle northEast(Figure owner) {
        return new NorthEastHandle(owner);
    }

    static public Handle northWest(Figure owner) {
        return new NorthWestHandle(owner);
    }

    static public Handle east(Figure owner) {
        return new EastHandle(owner);
    }

    static public Handle west(Figure owner) {
        return new WestHandle(owner);
    }

    private static class TransformHandle extends LocatorHandle {

        private int dx, dy;
        private Object geometry;
        /** Caches the value returned by getOwner().isTransformable(): */
        private boolean isTransformableCache;

        TransformHandle(Figure owner, Locator loc) {
            super(owner, loc);
        }

        @Override
        public String getToolTipText(Point p) {
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            return labels.getString("handle.transform.toolTipText");
        }

        /**
         * Draws this handle.
         */
        @Override
        public void draw(Graphics2D g) {
            if (getEditor().getTool().supportsHandleInteraction()) {
                //drawArc(g);

                drawDiamond(g,
                        (Color) getEditor().getHandleAttribute(HandleAttributeKeys.TRANSFORM_HANDLE_FILL_COLOR),
                        (Color) getEditor().getHandleAttribute(HandleAttributeKeys.TRANSFORM_HANDLE_STROKE_COLOR));

            } else {
                drawDiamond(g,
                        (Color) getEditor().getHandleAttribute(HandleAttributeKeys.TRANSFORM_HANDLE_FILL_COLOR_DISABLED),
                        (Color) getEditor().getHandleAttribute(HandleAttributeKeys.TRANSFORM_HANDLE_STROKE_COLOR_DISABLED));
            }
        }

        protected void drawArc(Graphics2D g) {
            Point p = getLocation();
            g.drawArc(p.x, p.y, 6, 6, 0, 180);
        }

        protected Rectangle2D.Double getTransformedBounds() {
            Figure owner = getOwner();
            Rectangle2D.Double bounds = owner.getBounds();
            if (owner.get(TRANSFORM) != null) {
                Rectangle2D r = owner.get(TRANSFORM).
                        createTransformedShape(bounds).getBounds2D();
                bounds.x = r.getX();
                bounds.y = r.getY();
                bounds.width = r.getWidth();
                bounds.height = r.getHeight();
            }
            return bounds;
        }

        @Override
        public void trackStart(Point anchor, int modifiersEx) {
            isTransformableCache = getOwner().isTransformable();
            if (!isTransformableCache) {
                return;
            }
            geometry = getOwner().getTransformRestoreData();
            Point location = getLocation();
            dx = -anchor.x + location.x;
            dy = -anchor.y + location.y;
        }

        @Override
        public void trackStep(Point anchor, Point lead, int modifiersEx) {
            if (!isTransformableCache) {
                return;
            }
            Point2D.Double p = view.viewToDrawing(new Point(lead.x + dx, lead.y + dy));
            view.getConstrainer().constrainPoint(p);

            trackStepNormalized(p);
        }

        @Override
        public void trackEnd(Point anchor, Point lead, int modifiersEx) {
            if (!isTransformableCache) {
                return;
            }
            fireUndoableEditHappened(
                    new TransformRestoreEdit(getOwner(), geometry, getOwner().getTransformRestoreData()));

        }

        protected void trackStepNormalized(Point2D.Double p) {
        }

        protected void transform(Point2D.Double anchor, Point2D.Double lead) {
            Figure f = getOwner();
            f.willChange();
            Rectangle2D.Double oldBounds = getTransformedBounds();
            Rectangle2D.Double newBounds = new Rectangle2D.Double(
                    Math.min(anchor.x, lead.x),
                    Math.min(anchor.y, lead.y),
                    Math.abs(anchor.x - lead.x),
                    Math.abs(anchor.y - lead.y));
            double sx = newBounds.width / oldBounds.width;
            double sy = newBounds.height / oldBounds.height;

            AffineTransform tx = new AffineTransform();
            tx.translate(-oldBounds.x, -oldBounds.y);
            if (!Double.isNaN(sx) && !Double.isNaN(sy)
                    && (sx != 1d || sy != 1d)
                    && !(sx < 0.0001) && !(sy < 0.0001)) {
                f.transform(tx);
                tx.setToIdentity();
                tx.scale(sx, sy);
                f.transform(tx);
                tx.setToIdentity();
            }
            tx.translate(newBounds.x, newBounds.y);
            f.transform(tx);
            f.changed();
        }
    }

    private static class NorthEastHandle extends TransformHandle {

        NorthEastHandle(Figure owner) {
            super(owner, RelativeLocator.northEast());
        }

        @Override
        protected void trackStepNormalized(Point2D.Double p) {
            Rectangle2D.Double r = getTransformedBounds();
            transform(
                    new Point2D.Double(r.x, Math.min(r.y + r.height - 1, p.y)),
                    new Point2D.Double(Math.max(r.x, p.x), r.y + r.height));
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (!getOwner().isTransformable()) {
                evt.consume();
                return;
            }
            Object geom = getOwner().getTransformRestoreData();
            Rectangle2D.Double r = getTransformedBounds();

            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                    transform(
                            new Point2D.Double(r.x, r.y - 1),
                            new Point2D.Double(r.x + r.width, r.y + r.height));
                    evt.consume();
                    break;
                case KeyEvent.VK_DOWN:
                    if (r.height > 1) {
                        transform(
                                new Point2D.Double(r.x, r.y + 1),
                                new Point2D.Double(r.x + r.width, r.y + r.height));
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_LEFT:
                    if (r.width > 1) {
                        transform(
                                new Point2D.Double(r.x, r.y),
                                new Point2D.Double(r.x + r.width - 1, r.y + r.height));
                    }
                    evt.consume();
                    break;

                case KeyEvent.VK_RIGHT:
                    transform(
                            new Point2D.Double(r.x, r.y),
                            new Point2D.Double(r.x + r.width + 1, r.y + r.height));
                    evt.consume();
                    break;
            }

            fireUndoableEditHappened(
                    new TransformRestoreEdit(getOwner(), geom, getOwner().getTransformRestoreData()));
        }

        @Override
        public Cursor getCursor() {
            return Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
        }
    }

    private static class EastHandle
            extends TransformHandle {

        EastHandle(Figure owner) {
            super(owner, RelativeLocator.east());
        }

        @Override
        protected void trackStepNormalized(Point2D.Double p) {
            Rectangle2D.Double r = getTransformedBounds();
            transform(
                    new Point2D.Double(r.x, r.y),
                    new Point2D.Double(Math.max(r.x + 1, p.x), r.y + r.height));
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (!getOwner().isTransformable()) {
                evt.consume();
                return;
            }
            Object geom = getOwner().getTransformRestoreData();
            Rectangle2D.Double r = getTransformedBounds();

            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                    evt.consume();
                    break;
                case KeyEvent.VK_DOWN:
                    evt.consume();
                    break;
                case KeyEvent.VK_LEFT:
                    if (r.width > 1) {
                        transform(
                                new Point2D.Double(r.x, r.y),
                                new Point2D.Double(r.x + r.width - 1, r.y + r.height));
                    }
                    evt.consume();
                    break;

                case KeyEvent.VK_RIGHT:
                    transform(
                            new Point2D.Double(r.x, r.y),
                            new Point2D.Double(r.x + r.width + 1, r.y + r.height));
                    evt.consume();
                    break;
            }

            fireUndoableEditHappened(
                    new TransformRestoreEdit(getOwner(), geom, getOwner().getTransformRestoreData()));
        }

        @Override
        public Cursor getCursor() {
            return Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
        }
    }

    private static class NorthHandle extends TransformHandle {

        NorthHandle(Figure owner) {
            super(owner, RelativeLocator.north());
        }

        @Override
        protected void trackStepNormalized(Point2D.Double p) {
            Rectangle2D.Double r = getTransformedBounds();
            transform(
                    new Point2D.Double(r.x, Math.min(r.y + r.height - 1, p.y)),
                    new Point2D.Double(r.x + r.width, r.y + r.height));
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (!getOwner().isTransformable()) {
                evt.consume();
                return;
            }
            Object geom = getOwner().getTransformRestoreData();
            Rectangle2D.Double r = getTransformedBounds();

            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                    transform(
                            new Point2D.Double(r.x, r.y - 1),
                            new Point2D.Double(r.x + r.width, r.y + r.height));
                    evt.consume();
                    break;
                case KeyEvent.VK_DOWN:
                    if (r.height > 1) {
                        transform(
                                new Point2D.Double(r.x, r.y + 1),
                                new Point2D.Double(r.x + r.width, r.y + r.height));
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_LEFT:
                    evt.consume();
                    break;

                case KeyEvent.VK_RIGHT:
                    evt.consume();
                    break;
            }

            fireUndoableEditHappened(
                    new TransformRestoreEdit(getOwner(), geom, getOwner().getTransformRestoreData()));
        }

        @Override
        public Cursor getCursor() {
            return Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
        }
    }

    private static class NorthWestHandle extends TransformHandle {

        NorthWestHandle(Figure owner) {
            super(owner, RelativeLocator.northWest());
        }

        @Override
        protected void trackStepNormalized(Point2D.Double p) {
            Rectangle2D.Double r = getTransformedBounds();
            transform(
                    new Point2D.Double(Math.min(r.x + r.width - 1, p.x), Math.min(r.y + r.height - 1, p.y)),
                    new Point2D.Double(r.x + r.width, r.y + r.height));
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (!getOwner().isTransformable()) {
                evt.consume();
                return;
            }
            Object geom = getOwner().getTransformRestoreData();
            Rectangle2D.Double r = getTransformedBounds();

            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                    transform(
                            new Point2D.Double(r.x, r.y - 1),
                            new Point2D.Double(r.x + r.width, r.y + r.height));
                    evt.consume();
                    break;
                case KeyEvent.VK_DOWN:
                    if (r.height > 1) {
                        transform(
                                new Point2D.Double(r.x, r.y + 1),
                                new Point2D.Double(r.x + r.width, r.y + r.height));
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_LEFT:
                    transform(
                            new Point2D.Double(r.x - 1, r.y),
                            new Point2D.Double(r.x + r.width, r.y + r.height));
                    evt.consume();
                    break;

                case KeyEvent.VK_RIGHT:
                    if (r.width > 1) {
                        transform(
                                new Point2D.Double(r.x + 1, r.y),
                                new Point2D.Double(r.x + r.width, r.y + r.height));
                    }
                    evt.consume();
                    break;
            }

            fireUndoableEditHappened(
                    new TransformRestoreEdit(getOwner(), geom, getOwner().getTransformRestoreData()));
        }

        @Override
        public Cursor getCursor() {
            return Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
        }
    }

    private static class SouthEastHandle extends TransformHandle {

        SouthEastHandle(Figure owner) {
            super(owner, RelativeLocator.southEast());
        }

        @Override
        protected void trackStepNormalized(Point2D.Double p) {
            Rectangle2D.Double r = getTransformedBounds();
            transform(
                    new Point2D.Double(r.x, r.y),
                    new Point2D.Double(Math.max(r.x + 1, p.x), Math.max(r.y + 1, p.y)));
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (!getOwner().isTransformable()) {
                evt.consume();
                return;
            }
            Object geom = getOwner().getTransformRestoreData();
            Rectangle2D.Double r = getTransformedBounds();

            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (r.height > 1) {
                        transform(
                                new Point2D.Double(r.x, r.y),
                                new Point2D.Double(r.x + r.width, r.y + r.height - 1));
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_DOWN:
                    transform(
                            new Point2D.Double(r.x, r.y),
                            new Point2D.Double(r.x + r.width, r.y + r.height + 1));
                    evt.consume();
                    break;
                case KeyEvent.VK_LEFT:
                    if (r.width > 1) {
                        transform(
                                new Point2D.Double(r.x, r.y),
                                new Point2D.Double(r.x + r.width - 1, r.y + r.height));
                    }
                    evt.consume();
                    break;

                case KeyEvent.VK_RIGHT:
                    transform(
                            new Point2D.Double(r.x, r.y),
                            new Point2D.Double(r.x + r.width + 1, r.y + r.height));
                    evt.consume();
                    break;
            }

            fireUndoableEditHappened(
                    new TransformRestoreEdit(getOwner(), geom, getOwner().getTransformRestoreData()));
        }

        @Override
        public Cursor getCursor() {
            return Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
        }
    }

    private static class SouthHandle extends TransformHandle {

        SouthHandle(Figure owner) {
            super(owner, RelativeLocator.south());
        }

        @Override
        protected void trackStepNormalized(Point2D.Double p) {
            Rectangle2D.Double r = getTransformedBounds();
            transform(
                    new Point2D.Double(r.x, r.y),
                    new Point2D.Double(r.x + r.width, Math.max(r.y + 1, p.y)));
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (!getOwner().isTransformable()) {
                evt.consume();
                return;
            }
            Object geom = getOwner().getTransformRestoreData();
            Rectangle2D.Double r = getTransformedBounds();

            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (r.height > 1) {
                        transform(
                                new Point2D.Double(r.x, r.y),
                                new Point2D.Double(r.x + r.width, r.y + r.height - 1));
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_DOWN:
                    transform(
                            new Point2D.Double(r.x, r.y),
                            new Point2D.Double(r.x + r.width, r.y + r.height + 1));
                    evt.consume();
                    break;
                case KeyEvent.VK_LEFT:
                    evt.consume();
                    break;

                case KeyEvent.VK_RIGHT:
                    evt.consume();
                    break;
            }

            fireUndoableEditHappened(
                    new TransformRestoreEdit(getOwner(), geom, getOwner().getTransformRestoreData()));
        }

        @Override
        public Cursor getCursor() {
            return Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);
        }
    }

    private static class SouthWestHandle extends TransformHandle {

        SouthWestHandle(Figure owner) {
            super(owner, RelativeLocator.southWest());
        }

        @Override
        protected void trackStepNormalized(Point2D.Double p) {
            Rectangle2D.Double r = getTransformedBounds();
            transform(
                    new Point2D.Double(Math.min(r.x + r.width - 1, p.x), r.y),
                    new Point2D.Double(r.x + r.width, Math.max(r.y + 1, p.y)));
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (!getOwner().isTransformable()) {
                evt.consume();
                return;
            }
            Object geom = getOwner().getTransformRestoreData();
            Rectangle2D.Double r = getTransformedBounds();

            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (r.height > 1) {
                        transform(
                                new Point2D.Double(r.x, r.y),
                                new Point2D.Double(r.x + r.width, r.y + r.height - 1));
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_DOWN:
                    transform(
                            new Point2D.Double(r.x, r.y),
                            new Point2D.Double(r.x + r.width, r.y + r.height + 1));
                    evt.consume();
                    break;
                case KeyEvent.VK_LEFT:
                    transform(
                            new Point2D.Double(r.x - 1, r.y),
                            new Point2D.Double(r.x + r.width, r.y + r.height));
                    evt.consume();
                    break;

                case KeyEvent.VK_RIGHT:
                    if (r.width > 1) {
                        transform(
                                new Point2D.Double(r.x + 1, r.y),
                                new Point2D.Double(r.x + r.width, r.y + r.height));
                    }
                    evt.consume();
                    break;
            }

            fireUndoableEditHappened(
                    new TransformRestoreEdit(getOwner(), geom, getOwner().getTransformRestoreData()));
        }

        @Override
        public Cursor getCursor() {
            return Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
        }
    }

    private static class WestHandle extends TransformHandle {

        WestHandle(Figure owner) {
            super(owner, RelativeLocator.west());
        }

        @Override
        protected void trackStepNormalized(Point2D.Double p) {
            Rectangle2D.Double r = getTransformedBounds();
            transform(
                    new Point2D.Double(Math.min(r.x + r.width - 1, p.x), r.y),
                    new Point2D.Double(r.x + r.width, r.y + r.height));
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (!getOwner().isTransformable()) {
                evt.consume();
                return;
            }
            Object geom = getOwner().getTransformRestoreData();
            Rectangle2D.Double r = getTransformedBounds();

            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                    evt.consume();
                    break;
                case KeyEvent.VK_DOWN:
                    evt.consume();
                    break;
                case KeyEvent.VK_LEFT:
                    transform(
                            new Point2D.Double(r.x - 1, r.y),
                            new Point2D.Double(r.x + r.width, r.y + r.height));
                    evt.consume();
                    break;

                case KeyEvent.VK_RIGHT:
                    if (r.width > 1) {
                        transform(
                                new Point2D.Double(r.x + 1, r.y),
                                new Point2D.Double(r.x + r.width, r.y + r.height));
                    }
                    evt.consume();
                    break;
            }

            fireUndoableEditHappened(
                    new TransformRestoreEdit(getOwner(), geom, getOwner().getTransformRestoreData()));
        }

        @Override
        public Cursor getCursor() {
            return Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);
        }
    }
}
