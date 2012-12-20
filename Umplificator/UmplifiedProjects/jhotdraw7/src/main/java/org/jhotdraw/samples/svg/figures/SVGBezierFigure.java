/*
 * @(#)SVGBezierFigure.java
 *
 * Copyright (c) 2007-2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.svg.figures;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.handle.TransformHandleKit;
import org.jhotdraw.draw.handle.Handle;
import org.jhotdraw.draw.handle.BezierNodeHandle;
import java.awt.BasicStroke;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.undo.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.geom.*;
import org.jhotdraw.util.ResourceBundleUtil;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

/**
 * SVGBezierFigure is not an actual SVG element, it is used by SVGPathFigure to
 * represent a single BezierPath segment within an SVG path.
 *
 * @author Werner Randelshofer
 * @version $Id: SVGBezierFigure.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class SVGBezierFigure extends BezierFigure {

    @Nullable private transient Rectangle2D.Double cachedDrawingArea;

    /** Creates a new instance. */
    public SVGBezierFigure() {
        this(false);
    }

    public SVGBezierFigure(boolean isClosed) {
        super(isClosed);
        set(UNCLOSED_PATH_FILLED, true);
    }

    public Collection<Handle> createHandles(SVGPathFigure pathFigure, int detailLevel) {
        LinkedList<Handle> handles = new LinkedList<Handle>();
        switch (detailLevel % 2) {
            case 0:
                for (int i = 0, n = path.size(); i < n; i++) {
                    handles.add(new BezierNodeHandle(this, i, pathFigure));
                }
                break;
            case 1:
                TransformHandleKit.addTransformHandles(this, handles);
                break;
            default:
                break;
        }
        return handles;
    }

    @Override
    public boolean handleMouseClick(Point2D.Double p, MouseEvent evt, DrawingView view) {
        if (evt.getClickCount() == 2/* && view.getHandleDetailLevel() == 0*/) {
            willChange();

            // Apply inverse of transform to point
            if (get(TRANSFORM) != null) {
                try {
                    p = (Point2D.Double) get(TRANSFORM).inverseTransform(p, new Point2D.Double());
                } catch (NoninvertibleTransformException ex) {
                    System.err.println("Warning: SVGBezierFigure.handleMouseClick. Figure has noninvertible Transform.");
                }
            }

            final int index = splitSegment(p, (float) (5f / view.getScaleFactor()));
            if (index != -1) {
                final BezierPath.Node newNode = getNode(index);
                fireUndoableEditHappened(new AbstractUndoableEdit() {
                    @Override
                    public String getPresentationName() {
                        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                        return labels.getString("edit.bezierPath.splitSegment.text");
                    }

                    @Override
                    public void redo() throws CannotRedoException {
                        super.redo();
                        willChange();
                        addNode(index, newNode);
                        changed();
                    }

                    @Override
                    public void undo() throws CannotUndoException {
                        super.undo();
                        willChange();
                        removeNode(index);
                        changed();
                    }
                });
                changed();
                evt.consume();
                return true;
            }
        }
        return false;
    }

    @Override
    public void transform(AffineTransform tx) {
        if (get(TRANSFORM) != null ||
                (tx.getType() & (AffineTransform.TYPE_TRANSLATION)) != tx.getType()) {
            if (get(TRANSFORM) == null) {
                TRANSFORM.setClone(this, tx);
            } else {
                AffineTransform t = TRANSFORM.getClone(this);
                t.preConcatenate(tx);
                set(TRANSFORM, t);
            }
        } else {
            super.transform(tx);
        }
    }

    @Override
    public Rectangle2D.Double getDrawingArea() {
        if (cachedDrawingArea == null) {
            if (get(TRANSFORM) == null) {
                cachedDrawingArea = path.getBounds2D();
            } else {
                BezierPath p2 = (BezierPath) path.clone();
                p2.transform(get(TRANSFORM));
                cachedDrawingArea = p2.getBounds2D();
            }
            double strokeTotalWidth = AttributeKeys.getStrokeTotalWidth(this);
            double width = strokeTotalWidth / 2d;
            if (get(STROKE_JOIN) == BasicStroke.JOIN_MITER) {
                width *= get(STROKE_MITER_LIMIT);
            } else if (get(STROKE_CAP) != BasicStroke.CAP_BUTT) {
                width += strokeTotalWidth * 2;
            }
            Geom.grow(cachedDrawingArea, width, width);
        }
        return (Rectangle2D.Double) cachedDrawingArea.clone();
    }

    /**
     * Gets the segment of the polyline that is hit by
     * the given Point2D.Double.
     * @return the index of the segment or -1 if no segment was hit.
     */
    @Override
    public int findSegment(Point2D.Double find, double tolerance) {
        // Apply inverse of transform to point
        if (get(TRANSFORM) != null) {
            try {
                find = (Point2D.Double) get(TRANSFORM).inverseTransform(find, new Point2D.Double());
            } catch (NoninvertibleTransformException ex) {
                System.err.println("Warning: SVGBezierFigure.findSegment. Figure has noninvertible Transform.");
            }
        }

        return getBezierPath().findSegment(find, tolerance);
    }

    /**
     * Joins two segments into one if the given Point2D.Double hits a node
     * of the polyline.
     * @return true if the two segments were joined.
     *
     * @param join a Point at a node on the bezier path
     * @param tolerance a tolerance, tolerance should take into account
     * the line width, plus 2 divided by the zoom factor. 
     */
    @Override
    public boolean joinSegments(Point2D.Double join, double tolerance) {
        // Apply inverse of transform to point
        if (get(TRANSFORM) != null) {
            try {
                join = (Point2D.Double) get(TRANSFORM).inverseTransform(join, new Point2D.Double());
            } catch (NoninvertibleTransformException ex) {
                System.err.println("Warning: SVGBezierFigure.findSegment. Figure has noninvertible Transform.");
            }
        }

        int i = getBezierPath().findSegment(join, tolerance);

        if (i != -1 && i > 1) {
            removeNode(i);
            return true;
        }
        return false;
    }

    /**
     * Splits the segment at the given Point2D.Double if a segment was hit.
     * @return the index of the segment or -1 if no segment was hit.
     *
     * @param split a Point on (or near) a segment of the bezier path
     * @param tolerance a tolerance, tolerance should take into account
     * the line width, plus 2 divided by the zoom factor. 
     */
    @Override
    public int splitSegment(Point2D.Double split, double tolerance) {
        // Apply inverse of transform to point
        if (get(TRANSFORM) != null) {
            try {
                split = (Point2D.Double) get(TRANSFORM).inverseTransform(split, new Point2D.Double());
            } catch (NoninvertibleTransformException ex) {
                System.err.println("Warning: SVGBezierFigure.findSegment. Figure has noninvertible Transform.");
            }
        }

        int i = getBezierPath().findSegment(split, tolerance);

        if (i != -1) {
            addNode(i + 1, new BezierPath.Node(split));
        }
        return i + 1;
    }

    /**
     * Transforms all coords of the figure by the current TRANSFORM attribute
     * and then sets the TRANSFORM attribute to null.
     */
    public void flattenTransform() {
        if (get(TRANSFORM) != null) {
            path.transform(get(TRANSFORM));
            set(TRANSFORM, null);
        }
        invalidate();
    }

    @Override
    public void invalidate() {
        super.invalidate();
        cachedDrawingArea = null;
    }
}
