/*
 * @(#)BoxHandleKit.java
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

/**
 * A set of utility methods to create handles which resize a Figure by
 * using its <code>setBounds</code> method, if the Figure is transformable.
 * 
 * @author Werner Randelshofer
 * @version $Id: ResizeHandleKit.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ResizeHandleKit {

    private final static boolean DEBUG = false;

    /** Creates a new instance. */
    public ResizeHandleKit() {
    }

    /**
     * Creates handles for each corner of a
     * figure and adds them to the provided collection.
     */
    static public void addCornerResizeHandles(Figure f, Collection<Handle> handles) {
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
    static public void addEdgeResizeHandles(Figure f, Collection<Handle> handles) {
        if (f.isTransformable()) {
            handles.add(south(f));
            handles.add(north(f));
            handles.add(east(f));
            handles.add(west(f));
        }
    }

    /**
     * Fills the given Vector with handles at each
     * the north, south, east, and west of the figure.
     */
    static public void addResizeHandles(Figure f, Collection<Handle> handles) {
        handles.add(new BoundsOutlineHandle(f));
        if (f.isTransformable()) {
            addCornerResizeHandles(f, handles);
            addEdgeResizeHandles(f, handles);
        }
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

    private static class ResizeHandle extends LocatorHandle {

        /** Mouse coordinates on track start. */
        private int sx, sy;
        /** Geometry for undo. */
        private Object geometry;
        /** Figure bounds on track start. */
        protected Rectangle2D.Double sb;
        /** Aspect ratio on track start. */
        double aspectRatio;
        /** Caches the value returned by getOwner().isTransformable(): */
        private boolean isTransformableCache;

        ResizeHandle(Figure owner, Locator loc) {
            super(owner, loc);
        }

        @Override
        public String getToolTipText(Point p) {
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            return labels.getString("handle.resize.toolTipText");
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
            if (getEditor().getTool().supportsHandleInteraction()) {
                if (getOwner().isTransformable()) {
                    drawRectangle(g,
                            (Color) getEditor().getHandleAttribute(HandleAttributeKeys.RESIZE_HANDLE_FILL_COLOR),
                            (Color) getEditor().getHandleAttribute(HandleAttributeKeys.RESIZE_HANDLE_STROKE_COLOR));
                } else {
                    drawRectangle(g,
                            (Color) getEditor().getHandleAttribute(HandleAttributeKeys.NULL_HANDLE_FILL_COLOR),
                            (Color) getEditor().getHandleAttribute(HandleAttributeKeys.NULL_HANDLE_STROKE_COLOR));
                }
            } else {
                drawRectangle(g,
                        (Color) getEditor().getHandleAttribute(HandleAttributeKeys.HANDLE_FILL_COLOR_DISABLED),
                        (Color) getEditor().getHandleAttribute(HandleAttributeKeys.HANDLE_STROKE_COLOR_DISABLED));
            }
        }

        @Override
        public void trackStart(Point anchor, int modifiersEx) {
            isTransformableCache = getOwner().isTransformable();
            if (!isTransformableCache) {
                return;
            }

            geometry = getOwner().getTransformRestoreData();
            Point location = getLocation();
            sx = -anchor.x + location.x;
            sy = -anchor.y + location.y;
            sb = getOwner().getBounds();
            aspectRatio = sb.height / sb.width;
        }

        @Override
        public void trackStep(Point anchor, Point lead, int modifiersEx) {
            if (!isTransformableCache) {
                return;
            }
            Point2D.Double p = view.viewToDrawing(new Point(lead.x + sx, lead.y + sy));
            view.getConstrainer().constrainPoint(p);

            if (getOwner().get(TRANSFORM) != null) {
                try {
                    getOwner().get(TRANSFORM).inverseTransform(p, p);
                } catch (NoninvertibleTransformException ex) {
                    if (DEBUG) {
                        ex.printStackTrace();
                    }
                }
            }
            trackStepNormalized(p, (modifiersEx & (InputEvent.ALT_DOWN_MASK | InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK)) != 0);
        }

        @Override
        public void trackEnd(Point anchor, Point lead, int modifiersEx) {
            if (!isTransformableCache) {
                return;
            }
            fireUndoableEditHappened(
                    new TransformRestoreEdit(getOwner(), geometry, getOwner().getTransformRestoreData()));
        }

        protected void trackStepNormalized(Point2D.Double p, boolean keepAspect) {
        }

        protected void setBounds(Point2D.Double anchor, Point2D.Double lead) {
            Figure f = getOwner();
            f.willChange();
            f.setBounds(anchor, lead);
            f.changed();
        }
    }

    private static class NorthEastHandle extends ResizeHandle {

        NorthEastHandle(Figure owner) {
            super(owner, RelativeLocator.northEast(true));
        }

        @Override
        protected void trackStepNormalized(Point2D.Double p, boolean keepAspect) {
            double nx = Math.max(sb.x + 1, p.x);
            double ny = Math.min(sb.y + sb.height - 1, p.y);
            if (keepAspect) {
                double nxx = sb.x + sb.width - 1 + Math.max(1, (sb.y - p.y) / aspectRatio);
                if (nxx >= p.x) {
                    nx = nxx;
                } else {
                    ny = sb.y + sb.height - Math.max(1, (p.x - sb.x) * aspectRatio);
                }
            }
            setBounds(
                    new Point2D.Double(sb.x, ny),
                    new Point2D.Double(nx, sb.y + sb.height));
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (!getOwner().isTransformable()) {
                evt.consume();
                return;
            }
            Rectangle2D.Double r = getOwner().getBounds();

            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                    setBounds(
                            new Point2D.Double(r.x, r.y - 1),
                            new Point2D.Double(r.x + r.width, r.y + r.height));
                    evt.consume();
                    break;
                case KeyEvent.VK_DOWN:
                    if (r.height > 1) {
                        setBounds(
                                new Point2D.Double(r.x, r.y + 1),
                                new Point2D.Double(r.x + r.width, r.y + r.height));
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_LEFT:
                    if (r.width > 1) {
                        setBounds(
                                new Point2D.Double(r.x, r.y),
                                new Point2D.Double(r.x + r.width - 1, r.y + r.height));
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_RIGHT:
                    setBounds(
                            new Point2D.Double(r.x, r.y),
                            new Point2D.Double(r.x + r.width + 1, r.y + r.height));
                    evt.consume();
                    break;
            }
        }

        @Override
        public Cursor getCursor() {
            return Cursor.getPredefinedCursor(
                    getOwner().isTransformable() ? Cursor.NE_RESIZE_CURSOR : Cursor.DEFAULT_CURSOR);
        }
    }

    private static class EastHandle extends ResizeHandle {

        EastHandle(Figure owner) {
            super(owner, RelativeLocator.east(true));
        }

        @Override
        protected void trackStepNormalized(Point2D.Double p, boolean keepAspect) {
            setBounds(
                    new Point2D.Double(sb.x, sb.y),
                    new Point2D.Double(Math.max(sb.x + 1, p.x), sb.y + sb.height));
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (!getOwner().isTransformable()) {
                evt.consume();
                return;
            }

            Rectangle2D.Double r = getOwner().getBounds();

            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_DOWN:
                    evt.consume();
                    break;
                case KeyEvent.VK_LEFT:
                    if (r.width > 1) {
                        setBounds(
                                new Point2D.Double(r.x, r.y),
                                new Point2D.Double(r.x + r.width - 1, r.y + r.height));
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_RIGHT:
                    setBounds(
                            new Point2D.Double(r.x, r.y),
                            new Point2D.Double(r.x + r.width + 1, r.y + r.height));
                    evt.consume();
                    break;
            }
        }

        @Override
        public Cursor getCursor() {
            return Cursor.getPredefinedCursor(
                    getOwner().isTransformable() ? Cursor.E_RESIZE_CURSOR : Cursor.DEFAULT_CURSOR);
        }
    }

    private static class NorthHandle extends ResizeHandle {

        NorthHandle(Figure owner) {
            super(owner, RelativeLocator.north(true));
        }

        @Override
        protected void trackStepNormalized(Point2D.Double p, boolean keepAspect) {
            setBounds(
                    new Point2D.Double(sb.x, Math.min(sb.y + sb.height - 1, p.y)),
                    new Point2D.Double(sb.x + sb.width, sb.y + sb.height));
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (!getOwner().isTransformable()) {
                evt.consume();
                return;
            }
            Rectangle2D.Double r = getOwner().getBounds();

            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                    setBounds(
                            new Point2D.Double(r.x, r.y - 1),
                            new Point2D.Double(r.x + r.width, r.y + r.height));
                    evt.consume();
                    break;
                case KeyEvent.VK_DOWN:
                    if (r.height > 1) {
                        setBounds(
                                new Point2D.Double(r.x, r.y + 1),
                                new Point2D.Double(r.x + r.width, r.y + r.height));
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_RIGHT:
                    evt.consume();
                    break;
            }
        }

        @Override
        public Cursor getCursor() {
            return Cursor.getPredefinedCursor(
                    getOwner().isTransformable() ? Cursor.N_RESIZE_CURSOR : Cursor.DEFAULT_CURSOR);
        }
    }

    private static class NorthWestHandle extends ResizeHandle {

        NorthWestHandle(Figure owner) {
            super(owner, RelativeLocator.northWest(true));
        }

        @Override
        protected void trackStepNormalized(Point2D.Double p, boolean keepAspect) {
            double nx = Math.min(sb.x + sb.width - 1, p.x);
            double ny = Math.min(sb.y + sb.height - 1, p.y);
            if (keepAspect) {
                double nxx = sb.x - Math.max(1, (sb.y - p.y) / aspectRatio);
                if (nxx <= p.x) {
                    nx = nxx;
                } else {
                    ny = sb.y - Math.max(1, (sb.x - p.x) * aspectRatio);
                }
            }
            setBounds(
                    new Point2D.Double(nx, ny),
                    new Point2D.Double(sb.x + sb.width, sb.y + sb.height));
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (!getOwner().isTransformable()) {
                evt.consume();
                return;
            }
            Rectangle2D.Double r = getOwner().getBounds();

            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                    setBounds(
                            new Point2D.Double(r.x, r.y - 1),
                            new Point2D.Double(r.x + r.width, r.y + r.height));
                    evt.consume();
                    break;
                case KeyEvent.VK_DOWN:
                    if (r.height > 1) {
                        setBounds(
                                new Point2D.Double(r.x, r.y + 1),
                                new Point2D.Double(r.x + r.width, r.y + r.height));
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_LEFT:
                    setBounds(
                            new Point2D.Double(r.x - 1, r.y),
                            new Point2D.Double(r.x + r.width, r.y + r.height));
                    evt.consume();
                    break;
                case KeyEvent.VK_RIGHT:
                    if (r.width > 1) {
                        setBounds(
                                new Point2D.Double(r.x + 1, r.y),
                                new Point2D.Double(r.x + r.width, r.y + r.height));
                    }
                    evt.consume();
                    break;
            }
        }

        @Override
        public Cursor getCursor() {
            return Cursor.getPredefinedCursor(
                    getOwner().isTransformable() ? Cursor.NW_RESIZE_CURSOR : Cursor.DEFAULT_CURSOR);
        }
    }

    private static class SouthEastHandle extends ResizeHandle {

        SouthEastHandle(Figure owner) {
            super(owner, RelativeLocator.southEast(true));
        }

        @Override
        protected void trackStepNormalized(Point2D.Double p, boolean keepAspect) {
            double nx = Math.max(sb.x + 1, p.x);
            double ny = Math.max(sb.y + 1, p.y);
            if (keepAspect) {
                double nxx = sb.x + Math.max(1, (p.y - sb.y) / aspectRatio);
                if (nxx >= p.x) {
                    nx = nxx;
                } else {
                    ny = sb.y + Math.max(1, (p.x - sb.x) * aspectRatio);
                }
            }
            setBounds(
                    new Point2D.Double(sb.x, sb.y),
                    new Point2D.Double(nx, ny));
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (!getOwner().isTransformable()) {
                evt.consume();
                return;
            }
            Rectangle2D.Double r = getOwner().getBounds();

            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (r.height > 1) {
                        setBounds(
                                new Point2D.Double(r.x, r.y),
                                new Point2D.Double(r.x + r.width, r.y + r.height - 1));
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_DOWN:
                    setBounds(
                            new Point2D.Double(r.x, r.y),
                            new Point2D.Double(r.x + r.width, r.y + r.height + 1));
                    evt.consume();
                    break;
                case KeyEvent.VK_LEFT:
                    if (r.width > 1) {
                        setBounds(
                                new Point2D.Double(r.x, r.y),
                                new Point2D.Double(r.x + r.width - 1, r.y + r.height));
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_RIGHT:
                    setBounds(
                            new Point2D.Double(r.x, r.y),
                            new Point2D.Double(r.x + r.width + 1, r.y + r.height));
                    evt.consume();
                    break;
            }
        }

        @Override
        public Cursor getCursor() {
            return Cursor.getPredefinedCursor(
                    getOwner().isTransformable() ? Cursor.SE_RESIZE_CURSOR : Cursor.DEFAULT_CURSOR);
        }
    }

    private static class SouthHandle extends ResizeHandle {

        SouthHandle(Figure owner) {
            super(owner, RelativeLocator.south(true));
        }

        @Override
        protected void trackStepNormalized(Point2D.Double p, boolean keepAspect) {
            setBounds(
                    new Point2D.Double(sb.x, sb.y),
                    new Point2D.Double(sb.x + sb.width, Math.max(sb.y + 1, p.y)));
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (!getOwner().isTransformable()) {
                evt.consume();
                return;
            }
            Rectangle2D.Double r = getOwner().getBounds();

            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (r.height > 1) {
                        setBounds(
                                new Point2D.Double(r.x, r.y),
                                new Point2D.Double(r.x + r.width, r.y + r.height - 1));
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_DOWN:
                    setBounds(
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
        }

        @Override
        public Cursor getCursor() {
            return Cursor.getPredefinedCursor(
                    getOwner().isTransformable() ? Cursor.S_RESIZE_CURSOR : Cursor.DEFAULT_CURSOR);
        }
    }

    private static class SouthWestHandle extends ResizeHandle {

        SouthWestHandle(Figure owner) {
            super(owner, RelativeLocator.southWest(true));
        }

        @Override
        protected void trackStepNormalized(Point2D.Double p, boolean keepAspect) {
            double nx = Math.min(sb.x + sb.width - 1, p.x);
            double ny = Math.max(sb.y + 1, p.y);
            if (keepAspect) {
                double nxx = sb.x + sb.width - Math.max(1, (p.y - sb.y) / aspectRatio);
                if (nxx <= p.x) {
                    nx = nxx;
                } else {
                    ny = sb.y + Math.max(1, (sb.x + sb.width - 1 - p.x) * aspectRatio);
                }
            }
            setBounds(
                    new Point2D.Double(nx, sb.y),
                    new Point2D.Double(sb.x + sb.width, ny));
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (!getOwner().isTransformable()) {
                evt.consume();
                return;
            }
            Rectangle2D.Double r = getOwner().getBounds();

            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (r.height > 1) {
                        setBounds(
                                new Point2D.Double(r.x, r.y),
                                new Point2D.Double(r.x + r.width, r.y + r.height - 1));
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_DOWN:
                    setBounds(
                            new Point2D.Double(r.x, r.y),
                            new Point2D.Double(r.x + r.width, r.y + r.height + 1));
                    evt.consume();
                    break;
                case KeyEvent.VK_LEFT:
                    setBounds(
                            new Point2D.Double(r.x - 1, r.y),
                            new Point2D.Double(r.x + r.width, r.y + r.height));
                    evt.consume();
                    break;
                case KeyEvent.VK_RIGHT:
                    if (r.width > 1) {
                        setBounds(
                                new Point2D.Double(r.x + 1, r.y),
                                new Point2D.Double(r.x + r.width, r.y + r.height));
                    }
                    evt.consume();
                    break;
            }
        }

        @Override
        public Cursor getCursor() {
            return Cursor.getPredefinedCursor(
                    getOwner().isTransformable() ? Cursor.SW_RESIZE_CURSOR : Cursor.DEFAULT_CURSOR);
        }
    }

    private static class WestHandle extends ResizeHandle {

        WestHandle(Figure owner) {
            super(owner, RelativeLocator.west(true));
        }

        @Override
        protected void trackStepNormalized(Point2D.Double p, boolean keepAspect) {
            setBounds(
                    new Point2D.Double(Math.min(sb.x + sb.width - 1, p.x), sb.y),
                    new Point2D.Double(sb.x + sb.width, sb.y + sb.height));
        }

        @Override
        public void keyPressed(KeyEvent evt) {
            if (!getOwner().isTransformable()) {
                evt.consume();
                return;
            }
            Rectangle2D.Double r = getOwner().getBounds();

            switch (evt.getKeyCode()) {
                case KeyEvent.VK_UP:
                case KeyEvent.VK_DOWN:
                    evt.consume();
                    break;
                case KeyEvent.VK_LEFT:
                    setBounds(
                            new Point2D.Double(r.x - 1, r.y),
                            new Point2D.Double(r.x + r.width, r.y + r.height));
                    evt.consume();
                    break;
                case KeyEvent.VK_RIGHT:
                    if (r.width > 1) {
                        setBounds(
                                new Point2D.Double(r.x + 1, r.y),
                                new Point2D.Double(r.x + r.width, r.y + r.height));
                    }
                    evt.consume();
                    break;
            }
        }

        @Override
        public Cursor getCursor() {
            return Cursor.getPredefinedCursor(
                    getOwner().isTransformable() ? Cursor.W_RESIZE_CURSOR : Cursor.DEFAULT_CURSOR);
        }
    }
}
