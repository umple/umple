/*
 * @(#)EnhancedPath.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.odg.geom;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents an ODG Enhanced Path.
 * <p>
 * The coordinates of a EnhancedPath.Segment can reference a
 * formula or a modifier.
 *
 * @author Werner Randelshofer
 * @version $Id: EnhancedPath.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class EnhancedPath extends ArrayList<EnhancedPath.Segment>
        implements Shape {

    public enum SegType {
        /* moveto x y */

        MOVETO(2),
        /* lineto x y */
        LINETO(2),
        /* curveto x1 y1 x2 y2 x y */
        CURVETO(6),
        /* quadto x1 y1 x y */
        QUADTO(4),
        /* closepath */
        CLOSE(0),
        /* ellipseto x y w h t0 t1 */
        ELLIPSETO(6),
        /* (counter-clockwise) arcto x1 y1 x2 y2 x3 y3 x y */
        ARCTO(8),
        /* clockwise arcto x1 y1 x2 y2 x3 y3 x y */
        CLOCKWISE_ARCTO(8),
        /* elliptical-quadrantx x y */
        QUADRANT_XTO(2),
        /* elliptical-quadranty x y */
        QUADRANT_YTO(2);
        /**
         * len is the number of parameters needed by a segment.
         */
        private int len;

        SegType(int len) {
            this.len = len;
        }

        int getLen() {
            return len;
        }
    }
    /**
     * We cache a Path2D.Double instance to speed up Shape operations.
     */
    @Nullable private transient Path2D.Double generalPath;
    /**
     * We cache a Rectangle2D.Double instance to speed up getBounds operations.
     */
    @Nullable private transient Rectangle2D.Double bounds;
    /**
     * The winding rule for filling the bezier path.
     */
    private int windingRule = Path2D.Double.WIND_EVEN_ODD;

    @Override
    public Rectangle getBounds() {
        return getBounds2D().getBounds();
    }

    @Override
    public Rectangle2D getBounds2D() {
        if (bounds == null) {
        }
        return (Rectangle2D.Double) bounds.clone();
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        validatePath();
        return generalPath.contains(x, y, w, h);
    }

    @Override
    public boolean contains(Point2D p) {
        validatePath();
        return generalPath.contains(p);
    }

    @Override
    public boolean contains(double x, double y) {
        validatePath();
        return generalPath.contains(x, y);
    }

    @Override
    public boolean contains(Rectangle2D r) {
        validatePath();
        return generalPath.contains(r);
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        validatePath();
        return generalPath.intersects(r);
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        validatePath();
        return generalPath.intersects(x, y, w, h);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        validatePath();
        return generalPath.getPathIterator(at);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        validatePath();
        return generalPath.getPathIterator(at, flatness);
    }

    /**
     * Defines a vertex (node) of the bezier path.
     * <p>
     * A vertex consists of three control points: C0, C1 and C2.
     * <ul>
     * <li>The bezier path always passes through C0.</li>
     * <li>C1 is used to control the curve towards C0.
     * </li>
     * <li>C2 is used to control the curve going away from C0.</li>
     * </ul>
     */
    public static class Segment implements Cloneable {

        /**
         * The type of the segment.
         */
        public SegType type;
        /** Control points x and y coordinates. */
        public double[] coords = new double[8];
        /** Modifiers and formulas. */
        public String[] modifiers = new String[8];

        public Segment() {
            type = SegType.LINETO;
        }

        /**
         * Creates a segment.
         */
        public Segment(SegType type, Object... coordOrModifier) {
            this.type = type;
            for (int i = 0; i < coordOrModifier.length; i++) {
                if (coordOrModifier[i] instanceof Double) {
                    coords[i] = (Double) coordOrModifier[i];
                } else {
                    modifiers[i] = (String) coordOrModifier[i];
                }
            }
        }

        public Segment(Segment that) {
            setTo(that);
        }

        public void setTo(Segment that) {
            this.type = that.type;
            System.arraycopy(that.coords, 0, this.coords, 0, that.type.getLen());
            System.arraycopy(that.modifiers, 0, this.modifiers, 0, that.type.getLen());
        }

        @Override
        public Object clone() {
            try {
                Segment that = (Segment) super.clone();
                that.coords = this.coords.clone();
                that.modifiers = this.modifiers.clone();
                return that;
            } catch (CloneNotSupportedException e) {
                InternalError error = new InternalError();
                error.initCause(e);
                throw error;
            }
        }

        @Override
        public int hashCode() {
            return (type.hashCode() << 24)
                    | Arrays.hashCode(coords) & 0x0fff0000
                    | Arrays.hashCode(modifiers) & 0xffff;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof EnhancedPath.Segment) {
                EnhancedPath.Segment that = (EnhancedPath.Segment) o;
                return that.type == this.type
                        && Arrays.equals(that.coords, this.coords)
                        && Arrays.equals(that.modifiers, this.modifiers);
            }
            return false;
        }
    }

    /**
     * Recomputes the EnhancedPath, if it is invalid.
     */
    public void validatePath() {
        if (generalPath == null) {
            generalPath = toGeneralPath();
        }
    }

    /**
     * This must be called after the EnhancedPath has been changed.
     */
    public void invalidatePath() {
        generalPath = null;
        bounds = null;
    }

    /** Converts the EnhancedPath into a Path2D.Double. */
    public Path2D.Double toGeneralPath() {
        Path2D.Double gp = new Path2D.Double();
        // XXX implement me
        return gp;
    }

    /**
     * Opens a new path segment at the specified position.
     */
    public void moveTo(Object xm1, Object ym1) {
        add(new Segment(SegType.MOVETO, xm1, ym1));
    }

    /**
     * Adds a line to the current path segment. 
     * This is only allowed, when the current path segment is open.
     */
    public void lineTo(Object x1, Object y1) {
        if (size() == 0 || get(size() - 1).type == SegType.CLOSE) {
            throw new IllegalPathStateException("lineTo is only allowed when a path segment is open");
        }
        add(new Segment(SegType.LINETO, x1, y1));
    }

    /**
     * Closes the current path segment. 
     * This is only allowed, when the current path segment is open.
     */
    public void close() {
        if (size() == 0 || get(size() - 1).type == SegType.CLOSE) {
            throw new IllegalPathStateException("close is only allowed when a path segment is open");
        }
        add(new Segment(SegType.CLOSE));
    }

    /**
     * Adds a quadratic curve to the current path segment. 
     * This is only allowed, when the current path segment is open.
     */
    public void quadTo(Object x1, Object y1,
            Object x2, Object y2) {
        if (size() == 0 || get(size() - 1).type == SegType.CLOSE) {
            throw new IllegalPathStateException("quadTo is only allowed when a path segment is open");
        }

        add(new Segment(SegType.QUADTO, x1, y1, x2, y2));
    }

    /**
     * Adds a cubic curve to the current path segment. 
     * This is only allowed, when the current path segment is open.
     */
    public void curveTo(Object x1, Object y1,
            Object x2, Object y2,
            Object x3, Object y3) {
        if (size() == 0 || get(size() - 1).type == SegType.CLOSE) {
            throw new IllegalPathStateException("curveTo is only allowed when a path segment is open");
        }
        add(new Segment(SegType.CURVETO, x1, y1, x2, y2, x3, y3));
    }

    /**
     * (x1, y1) and (x2, y2) is defining the bounding
     * box of a ellipse. A line is then drawn from the
     * current point to the start angle of the arc that is
     * specified by the radial vector of point (x3, y3)
     * and then counter clockwise to the end-angle
     * that is specified by point (x4, y4).
     */
    public void arcTo(Object x1, Object y1,
            Object x2, Object y2,
            Object x3, Object y3,
            Object x4, Object y4) {

        if (size() == 0) {
            throw new IllegalPathStateException("arcTo only allowed when not empty");
        }
        add(new Segment(SegType.ARCTO, x1, y1, x2, y2, x3, y3, x4, y4));
    }

    public void clockwiseArcTo(Object x1, Object y1,
            Object x2, Object y2,
            Object x3, Object y3,
            Object x4, Object y4) {

        if (size() == 0) {
            throw new IllegalPathStateException("clockwiseArcTo only allowed when not empty");
        }
        add(new Segment(SegType.CLOCKWISE_ARCTO, x1, y1, x2, y2, x3, y3, x4, y4));
    }

    /**
     * Draws a segment of an ellipse. The ellipse is specified by the
     * center(x, y), the size(w, h) and the start-angle t0 and end-angle t1. 
     */
    public void ellipseTo(Object x, Object y,
            Object w, Object h, Object t0, Object t1) {
        if (size() == 0 || get(size() - 1).type == SegType.CLOSE) {
            throw new IllegalPathStateException("ellipseTo is only allowed when a path segment is open");
        }

        add(new Segment(SegType.ELLIPSETO, x, y, w, h, t0, t1));
    }

    public void quadrantXTo(Object x, Object y) {
        if (size() == 0 || get(size() - 1).type == SegType.CLOSE) {
            throw new IllegalPathStateException("quadrantXTo is only allowed when a path segment is open");
        }

        add(new Segment(SegType.QUADRANT_XTO, x, y));
    }

    public void quadrantYTo(Object x, Object y) {
        if (size() == 0 || get(size() - 1).type == SegType.CLOSE) {
            throw new IllegalPathStateException("quadrantYTo is only allowed when a path segment is open");
        }

        add(new Segment(SegType.QUADRANT_YTO, x, y));
    }

    /**
     * Sets winding rule for filling the bezier path.
     * @param newValue Must be Path2D.Double.WIND_EVEN_ODD or Path2D.Double.WIND_NON_ZERO.
     */
    public void setWindingRule(int newValue) {
        if (newValue != windingRule) {
            invalidatePath();
            int oldValue = windingRule;
            this.windingRule = newValue;
        }
    }

    /**
     * Gets winding rule for filling the bezier path.
     * @return Path2D.Double.WIND_EVEN_ODD or Path2D.Double.WIND_NON_ZERO.
     */
    public int getWindingRule() {
        return windingRule;
    }
}
