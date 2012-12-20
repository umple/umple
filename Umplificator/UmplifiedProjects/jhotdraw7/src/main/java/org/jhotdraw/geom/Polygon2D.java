/*
 * @(#)Polygon2D.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.geom;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import sun.awt.geom.Crossings;

/**
 * Polygon2D.
 *
 * @author Werner Randelshofer
 * @version $Id: Polygon2D.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public abstract class Polygon2D implements Shape, Cloneable {

    /**
     * The total number of points.  The value of <code>npoints</code>
     * represents the number of valid points in this <code>Polygon</code>
     * and might be less than the number of elements in 
     * {@code xpoints} or {@code ypoints}.
     * This value can be NULL.
     *
     */
    public int npoints;

    /* 
     * JDK 1.1 serialVersionUID 
     */
    private static final long serialVersionUID = -6460061437900069969L;
    /*
     * Default length for xpoints and ypoints.
     */
    private static final int MIN_LENGTH = 4;

    /**
     * Creates an empty polygon.
     * 
     */
    public Polygon2D() {
    }

    /**
     * Resets this <code>Polygon</code> object to an empty polygon.
     * The coordinate arrays and the data in them are left untouched
     * but the number of points is reset to zero to mark the old
     * vertex data as invalid and to start accumulating new vertex
     * data at the beginning.
     * All internally-cached data relating to the old vertices
     * are discarded.
     * Note that since the coordinate arrays from before the reset
     * are reused, creating a new empty <code>Polygon</code> might
     * be more memory efficient than resetting the current one if
     * the number of vertices in the new polygon data is significantly
     * smaller than the number of vertices in the data from before the
     * reset.
     * @see         java.awt.Polygon#invalidate
     * 
     */
    public void reset() {
        npoints = 0;
        invalidate();
    }

    /**
     * Invalidates or flushes any internally-cached data that depends
     * on the vertex coordinates of this <code>Polygon</code>.
     * This method should be called after any direct manipulation
     * of the coordinates in the <code>xpoints</code> or
     * <code>ypoints</code> arrays to avoid inconsistent results
     * from methods such as <code>getBounds</code> or <code>contains</code>
     * that might cache data from earlier computations relating to
     * the vertex coordinates.
     * @see         java.awt.Polygon#getBounds
     * 
     */
    public abstract void invalidate();

    /**
     * Translates the vertices of the <code>Polygon</code> by 
     * <code>deltaX</code> along the x axis and by 
     * <code>deltaY</code> along the y axis.
     * @param deltaX the amount to translate along the X axis
     * @param deltaY the amount to translate along the Y axis
     * 
     */
    public abstract void translate(double deltaX, double deltaY);

    /**
     * Appends the specified coordinates to this <code>Polygon</code>. 
     * <p>
     * If an operation that calculates the bounding box of this     
     * <code>Polygon</code> has already been performed, such as  
     * <code>getBounds</code> or <code>contains</code>, then this 
     * method updates the bounding box. 
     * @param       x the specified X coordinate
     * @param       y the specified Y coordinate
     * @see         java.awt.Polygon#getBounds
     * @see         java.awt.Polygon#contains
     * 
     */
    public abstract void addPoint(double x, double y);

    public void add(Point2D p) {
        addPoint(p.getX(), p.getY());
    }

    /**
     * Gets the bounding box of this <code>Polygon</code>. 
     * The bounding box is the smallest {@link Rectangle} whose
     * sides are parallel to the x and y axes of the 
     * coordinate space, and can completely contain the <code>Polygon</code>.
     * @return a <code>Rectangle</code> that defines the bounds of this 
     * <code>Polygon</code>.
     * 
     */
    @Override
    public Rectangle getBounds() {
        return getBounds2D().getBounds();
    }

    /**
     * Determines whether the specified {@link Point} is inside this 
     * <code>Polygon</code>.
     * @param p the specified <code>Point</code> to be tested
     * @return <code>true</code> if the <code>Polygon</code> contains the
     * 			<code>Point</code>; <code>false</code> otherwise.
     * @see #contains(double, double)
     * 
     */
    public boolean contains(Point p) {
        return contains(p.x, p.y);
    }

    /**
     * Determines whether the specified coordinates are inside this 
     * <code>Polygon</code>.   
     * <p>
     * @param x the specified X coordinate to be tested
     * @param y the specified Y coordinate to be tested
     * @return {@code true} if this {@code Polygon} contains
     *         the specified coordinates {@code (x,y)};
     *         {@code false} otherwise.
     * @see #contains(double, double)
     * 
     */
    public boolean contains(int x, int y) {
        return contains((double) x, (double) y);
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public abstract Rectangle2D getBounds2D();

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public abstract boolean contains(double x, double y);

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean contains(Point2D p) {
        return contains(p.getX(), p.getY());
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public abstract boolean intersects(double x, double y, double w, double h);

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean intersects(Rectangle2D r) {
        return intersects(r.getX(), r.getY(), r.getWidth(), r.getHeight());
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public abstract boolean contains(double x, double y, double w, double h);

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public boolean contains(Rectangle2D r) {
        return contains(r.getX(), r.getY(), r.getWidth(), r.getHeight());
    }

    /**
     * Returns an iterator object that iterates along the boundary of this 
     * <code>Polygon</code> and provides access to the geometry
     * of the outline of this <code>Polygon</code>.  An optional
     * {@link AffineTransform} can be specified so that the coordinates 
     * returned in the iteration are transformed accordingly.
     * @param at an optional <code>AffineTransform</code> to be applied to the
     * 		coordinates as they are returned in the iteration, or 
     *		<code>null</code> if untransformed coordinates are desired
     * @return a {@link PathIterator} object that provides access to the
     *		geometry of this <code>Polygon</code>.      
     * 
     */
    @Override
    public abstract PathIterator getPathIterator(AffineTransform at);

    /**
     * Returns an iterator object that iterates along the boundary of
     * the <code>Shape</code> and provides access to the geometry of the 
     * outline of the <code>Shape</code>.  Only SEG_MOVETO, SEG_LINETO, and 
     * SEG_CLOSE point types are returned by the iterator.
     * Since polygons are already flat, the <code>flatness</code> parameter
     * is ignored.  An optional <code>AffineTransform</code> can be specified 
     * in which case the coordinates returned in the iteration are transformed
     * accordingly.
     * @param at an optional <code>AffineTransform</code> to be applied to the
     * 		coordinates as they are returned in the iteration, or 
     *		<code>null</code> if untransformed coordinates are desired
     * @param flatness the maximum amount that the control points
     * 		for a given curve can vary from colinear before a subdivided
     *		curve is replaced by a straight line connecting the 
     * 		endpoints.  Since polygons are already flat the
     * 		<code>flatness</code> parameter is ignored.
     * @return a <code>PathIterator</code> object that provides access to the
     * 		<code>Shape</code> object's geometry.
     * 
     */
    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return getPathIterator(at);
    }

    /**
     * The {@code Double} class defines a polygon with
     * coordinates stored in double precision floating point.
     */
    public static class Double extends Polygon2D implements Serializable {

        /**
         * The array of X coordinates.  The number of elements in
         * this array might be more than the number of X coordinates
         * in this <code>Polygon</code>.  The extra elements allow new points
         * to be added to this <code>Polygon</code> without re-creating this
         * array.  The value of {@link #npoints npoints} is equal to the
         * number of valid points in this <code>Polygon</code>.
         *
         */
        public double xpoints[];
        /**
         * The array of Y coordinates.  The number of elements in
         * this array might be more than the number of Y coordinates
         * in this <code>Polygon</code>.  The extra elements allow new points
         * to be added to this <code>Polygon</code> without re-creating this
         * array.  The value of <code>npoints</code> is equal to the
         * number of valid points in this <code>Polygon</code>.
         *
         */
        public double ypoints[];
        /**
         * The bounds of this {@code Polygon}.
         * This value can be null.
         *
         * 
         */
        @Nullable protected Rectangle2D.Double bounds;

        public Double() {
            xpoints = new double[MIN_LENGTH];
            ypoints = new double[MIN_LENGTH];
        }

        /**
         * Constructs and initializes a <code>Polygon</code> from the specified
         * parameters.
         * @param xpoints an array of X coordinates
         * @param ypoints an array of Y coordinates
         * @param npoints the total number of points in the
         *				<code>Polygon</code>
         * @exception  NegativeArraySizeException if the value of
         *                       <code>npoints</code> is negative.
         * @exception  IndexOutOfBoundsException if <code>npoints</code> is
         *             greater than the length of <code>xpoints</code>
         *             or the length of <code>ypoints</code>.
         * @exception  NullPointerException if <code>xpoints</code> or
         *             <code>ypoints</code> is <code>null</code>.
         * 
         */
        public Double(double xpoints[], double ypoints[], int npoints) {
            // Fix 4489009: should throw IndexOutofBoundsException instead
            // of OutofMemoryException if npoints is huge and > {x,y}points.length
            if (npoints > xpoints.length || npoints > ypoints.length) {
                throw new IndexOutOfBoundsException("npoints > xpoints.length || "
                        + "npoints > ypoints.length");
            }
            // Fix 6191114: should throw NegativeArraySizeException with
            // negative npoints
            if (npoints < 0) {
                throw new NegativeArraySizeException("npoints < 0");
            }
            // Fix 6343431: Applet compatibility problems if arrays are not
            // exactly npoints in length
            this.npoints = npoints;
            this.xpoints = new double[npoints];
            System.arraycopy(xpoints, 0, this.xpoints, 0,
                    npoints);

            this.ypoints = new double[npoints];
            System.arraycopy(ypoints, 0, this.ypoints, 0,
                    npoints);
        }

        /**
         * Translates the vertices of the <code>Polygon</code> by
         * <code>deltaX</code> along the x axis and by
         * <code>deltaY</code> along the y axis.
         * @param deltaX the amount to translate along the X axis
         * @param deltaY the amount to translate along the Y axis
         * 
         */
        @Override
        public void translate(double deltaX, double deltaY) {
            for (int i = 0; i < npoints; i++) {
                xpoints[i] += deltaX;
                ypoints[i] += deltaY;
            }
            if (bounds != null) {
                bounds.x += deltaX;
                bounds.y += deltaY;
            }
        }

        @Override
        public void invalidate() {
            bounds = null;
        }
        /*
         * Calculates the bounding box of the points passed to the constructor.
         * Sets <code>bounds</code> to the result.
         * @param xpoints[] array of <i>x</i> coordinates
         * @param ypoints[] array of <i>y</i> coordinates
         * @param npoints the total number of points
         */

        void calculateBounds(double xpoints[], double ypoints[], int npoints) {
            double boundsMinX = java.lang.Double.MAX_VALUE;
            double boundsMinY = java.lang.Double.MAX_VALUE;
            double boundsMaxX = -java.lang.Double.MAX_VALUE;
            double boundsMaxY = -java.lang.Double.MAX_VALUE;

            for (int i = 0; i < npoints; i++) {
                double x = xpoints[i];
                boundsMinX = Math.min(boundsMinX, x);
                boundsMaxX = Math.max(boundsMaxX, x);
                double y = ypoints[i];
                boundsMinY = Math.min(boundsMinY, y);
                boundsMaxY = Math.max(boundsMaxY, y);
            }
            bounds = new Rectangle2D.Double(boundsMinX, boundsMinY,
                    boundsMaxX - boundsMinX,
                    boundsMaxY - boundsMinY);
        }
        /*
         * Resizes the bounding box to accomodate the specified coordinates.
         * @param x,&nbsp;y the specified coordinates
         */

        void updateBounds(double x, double y) {
            if (x < bounds.x) {
                bounds.width = bounds.width + (bounds.x - x);
                bounds.x = x;
            } else {
                bounds.width = Math.max(bounds.width, x - bounds.x);
                // bounds.x = bounds.x;
            }

            if (y < bounds.y) {
                bounds.height = bounds.height + (bounds.y - y);
                bounds.y = y;
            } else {
                bounds.height = Math.max(bounds.height, y - bounds.y);
                // bounds.y = bounds.y;
            }
        }

        @Override
        public boolean contains(double x, double y) {
            if (npoints <= 2 || !getBounds2D().contains(x, y)) {
                return false;
            }
            int hits = 0;

            double lastx = xpoints[npoints - 1];
            double lasty = ypoints[npoints - 1];
            double curx, cury;

            // Walk the edges of the polygon
            for (int i = 0; i < npoints; lastx = curx, lasty = cury, i++) {
                curx = xpoints[i];
                cury = ypoints[i];

                if (cury == lasty) {
                    continue;
                }

                double leftx;
                if (curx < lastx) {
                    if (x >= lastx) {
                        continue;
                    }
                    leftx = curx;
                } else {
                    if (x >= curx) {
                        continue;
                    }
                    leftx = lastx;
                }

                double test1, test2;
                if (cury < lasty) {
                    if (y < cury || y >= lasty) {
                        continue;
                    }
                    if (x < leftx) {
                        hits++;
                        continue;
                    }
                    test1 = x - curx;
                    test2 = y - cury;
                } else {
                    if (y < lasty || y >= cury) {
                        continue;
                    }
                    if (x < leftx) {
                        hits++;
                        continue;
                    }
                    test1 = x - lastx;
                    test2 = y - lasty;
                }

                if (test1 < (test2 / (lasty - cury) * (lastx - curx))) {
                    hits++;
                }
            }

            return ((hits & 1) != 0);
        }

        @Override
        public boolean intersects(double x, double y, double w, double h) {
            if (npoints <= 0 || !getBounds2D().intersects(x, y, w, h)) {
                return false;
            }

            Crossings cross = getCrossings(x, y, x + w, y + h);
            return (cross == null || !cross.isEmpty());
        }

        @Nullable
        private Crossings getCrossings(double xlo, double ylo,
                double xhi, double yhi) {
            Crossings cross = new Crossings.EvenOdd(xlo, ylo, xhi, yhi);
            double lastx = xpoints[npoints - 1];
            double lasty = ypoints[npoints - 1];
            double curx, cury;

            // Walk the edges of the polygon
            for (int i = 0; i < npoints; i++) {
                curx = xpoints[i];
                cury = ypoints[i];
                if (cross.accumulateLine(lastx, lasty, curx, cury)) {
                    return null;
                }
                lastx = curx;
                lasty = cury;
            }

            return cross;
        }

        @Override
        public void addPoint(double x, double y) {
            if (npoints >= xpoints.length || npoints >= ypoints.length) {
                int newLength = npoints * 2;
                // Make sure that newLength will be greater than MIN_LENGTH and
                // aligned to the power of 2
                if (newLength < MIN_LENGTH) {
                    newLength = MIN_LENGTH;
                } else if ((newLength & (newLength - 1)) != 0) {
                    newLength = Integer.highestOneBit(newLength);
                }

                double[] helper = new double[newLength];
                System.arraycopy(xpoints, 0, helper, 0,
                        npoints);
                xpoints = helper;

                helper = new double[newLength];
                System.arraycopy(ypoints, 0, helper, 0,
                        npoints);
                ypoints = helper;
            }
            xpoints[npoints] = x;
            ypoints[npoints] = y;
            npoints++;
            if (bounds != null) {
                updateBounds(x, y);
            }
        }

        @Override
        public Rectangle getBounds() {
            Polygon x;
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Rectangle2D getBounds2D() {
            if (npoints == 0) {
                return new Rectangle2D.Double();
            }
            if (bounds == null) {
                calculateBounds(xpoints, ypoints, npoints);
            }
            return (Rectangle2D) bounds.clone();
        }

        @Override
        public boolean contains(double x, double y, double w, double h) {
            if (npoints <= 0 || !getBounds2D().intersects(x, y, w, h)) {
                return false;
            }

            Crossings cross = getCrossings(x, y, x + w, y + h);
            return (cross != null && cross.covers(y, y + h));
        }

        @Override
        public PathIterator getPathIterator(AffineTransform at) {
            return new PolygonPathIteratorDouble(this, at);
        }
    }

    /**
     * The {@code Float} class defines a polygon with
     * coordinates stored in double precision floating point.
     */
    /**
     * The {@code Float} class defines a polygon with
     * coordinates stored in float precision floating point.
     */
    public static class Float extends Polygon2D implements Serializable {

        /**
         * The array of X coordinates.  The number of elements in
         * this array might be more than the number of X coordinates
         * in this <code>Polygon</code>.  The extra elements allow new points
         * to be added to this <code>Polygon</code> without re-creating this
         * array.  The value of {@link #npoints npoints} is equal to the
         * number of valid points in this <code>Polygon</code>.
         */
        public float xpoints[];
        /**
         * The array of Y coordinates.  The number of elements in
         * this array might be more than the number of Y coordinates
         * in this <code>Polygon</code>.  The extra elements allow new points
         * to be added to this <code>Polygon</code> without re-creating this
         * array.  The value of <code>npoints</code> is equal to the
         * number of valid points in this <code>Polygon</code>.
         */
        public float ypoints[];
        /**
         * The bounds of this {@code Polygon}.
         * This value can be null.
         */
        @Nullable protected Rectangle2D.Float bounds;

        public Float() {
            xpoints = new float[MIN_LENGTH];
            ypoints = new float[MIN_LENGTH];
        }

        /**
         * Constructs and initializes a <code>Polygon</code> from the specified
         * parameters.
         * @param xpoints an array of X coordinates
         * @param ypoints an array of Y coordinates
         * @param npoints the total number of points in the
         *				<code>Polygon</code>
         * @exception  NegativeArraySizeException if the value of
         *                       <code>npoints</code> is negative.
         * @exception  IndexOutOfBoundsException if <code>npoints</code> is
         *             greater than the length of <code>xpoints</code>
         *             or the length of <code>ypoints</code>.
         * @exception  NullPointerException if <code>xpoints</code> or
         *             <code>ypoints</code> is <code>null</code>.
         * 
         */
        public Float(float xpoints[], float ypoints[], int npoints) {
            // Fix 4489009: should throw IndexOutofBoundsException instead
            // of OutofMemoryException if npoints is huge and > {x,y}points.length
            if (npoints > xpoints.length || npoints > ypoints.length) {
                throw new IndexOutOfBoundsException("npoints > xpoints.length || "
                        + "npoints > ypoints.length");
            }
            // Fix 6191114: should throw NegativeArraySizeException with
            // negative npoints
            if (npoints < 0) {
                throw new NegativeArraySizeException("npoints < 0");
            }
            // Fix 6343431: Applet compatibility problems if arrays are not
            // exactly npoints in length
            this.npoints = npoints;
            this.xpoints = new float[npoints];
            System.arraycopy(xpoints, 0, this.xpoints, 0,
                    npoints);

            this.ypoints = new float[npoints];
            System.arraycopy(ypoints, 0, this.ypoints, 0,
                    npoints);
        }

        /**
         * Translates the vertices of the <code>Polygon</code> by
         * <code>deltaX</code> along the x axis and by
         * <code>deltaY</code> along the y axis.
         * @param deltaX the amount to translate along the X axis
         * @param deltaY the amount to translate along the Y axis
         * 
         */
        @Override
        public void translate(double deltaX, double deltaY) {
            translate((float) deltaX, (float) deltaY);
        }

        public void translate(float deltaX, float deltaY) {
            for (int i = 0; i < npoints; i++) {
                xpoints[i] += deltaX;
                ypoints[i] += deltaY;
            }
            if (bounds != null) {
                bounds.x += deltaX;
                bounds.y += deltaY;
            }
        }

        @Override
        public void invalidate() {
            bounds = null;
        }
        /*
         * Calculates the bounding box of the points passed to the constructor.
         * Sets <code>bounds</code> to the result.
         * @param xpoints[] array of <i>x</i> coordinates
         * @param ypoints[] array of <i>y</i> coordinates
         * @param npoints the total number of points
         */

        void calculateBounds(float xpoints[], float ypoints[], int npoints) {
            float boundsMinX = java.lang.Float.MAX_VALUE;
            float boundsMinY = java.lang.Float.MAX_VALUE;
            float boundsMaxX = -java.lang.Float.MAX_VALUE;
            float boundsMaxY = -java.lang.Float.MAX_VALUE;

            for (int i = 0; i < npoints; i++) {
                float x = xpoints[i];
                boundsMinX = Math.min(boundsMinX, x);
                boundsMaxX = Math.max(boundsMaxX, x);
                float y = ypoints[i];
                boundsMinY = Math.min(boundsMinY, y);
                boundsMaxY = Math.max(boundsMaxY, y);
            }
            bounds = new Rectangle2D.Float(boundsMinX, boundsMinY,
                    boundsMaxX - boundsMinX,
                    boundsMaxY - boundsMinY);
        }
        /*
         * Resizes the bounding box to accomodate the specified coordinates.
         * @param x,&nbsp;y the specified coordinates
         */

        void updateBounds(float x, float y) {
            if (x < bounds.x) {
                bounds.width = bounds.width + (bounds.x - x);
                bounds.x = x;
            } else {
                bounds.width = Math.max(bounds.width, x - bounds.x);
                // bounds.x = bounds.x;
            }

            if (y < bounds.y) {
                bounds.height = bounds.height + (bounds.y - y);
                bounds.y = y;
            } else {
                bounds.height = Math.max(bounds.height, y - bounds.y);
                // bounds.y = bounds.y;
            }
        }

        @Override
        public boolean contains(double x, double y) {
            return contains((float) x, (float) y);
        }

        public boolean contains(float x, float y) {
            if (npoints <= 2 || !getBounds2D().contains(x, y)) {
                return false;
            }
            int hits = 0;

            float lastx = xpoints[npoints - 1];
            float lasty = ypoints[npoints - 1];
            float curx, cury;

            // Walk the edges of the polygon
            for (int i = 0; i < npoints; lastx = curx, lasty = cury, i++) {
                curx = xpoints[i];
                cury = ypoints[i];

                if (cury == lasty) {
                    continue;
                }

                float leftx;
                if (curx < lastx) {
                    if (x >= lastx) {
                        continue;
                    }
                    leftx = curx;
                } else {
                    if (x >= curx) {
                        continue;
                    }
                    leftx = lastx;
                }

                float test1, test2;
                if (cury < lasty) {
                    if (y < cury || y >= lasty) {
                        continue;
                    }
                    if (x < leftx) {
                        hits++;
                        continue;
                    }
                    test1 = x - curx;
                    test2 = y - cury;
                } else {
                    if (y < lasty || y >= cury) {
                        continue;
                    }
                    if (x < leftx) {
                        hits++;
                        continue;
                    }
                    test1 = x - lastx;
                    test2 = y - lasty;
                }

                if (test1 < (test2 / (lasty - cury) * (lastx - curx))) {
                    hits++;
                }
            }

            return ((hits & 1) != 0);
        }

        @Override
        public boolean intersects(double x, double y, double w, double h) {
            return intersects((float) x, (float) y, (float) w, (float) h);
        }

        public boolean intersects(float x, float y, float w, float h) {
            if (npoints <= 0 || !getBounds2D().intersects(x, y, w, h)) {
                return false;
            }

            Crossings cross = getCrossings(x, y, x + w, y + h);
            return (cross == null || !cross.isEmpty());
        }

        @Nullable
        private Crossings getCrossings(float xlo, float ylo,
                float xhi, float yhi) {
            Crossings cross = new Crossings.EvenOdd(xlo, ylo, xhi, yhi);
            float lastx = xpoints[npoints - 1];
            float lasty = ypoints[npoints - 1];
            float curx, cury;

            // Walk the edges of the polygon
            for (int i = 0; i < npoints; i++) {
                curx = xpoints[i];
                cury = ypoints[i];
                if (cross.accumulateLine(lastx, lasty, curx, cury)) {
                    return null;
                }
                lastx = curx;
                lasty = cury;
            }

            return cross;
        }

        @Override
        public void addPoint(double x, double y) {
            addPoint((float) x, (float) y);
        }

        public void addPoint(float x, float y) {
            if (npoints >= xpoints.length || npoints >= ypoints.length) {
                int newLength = npoints * 2;
                // Make sure that newLength will be greater than MIN_LENGTH and
                // aligned to the power of 2
                if (newLength < MIN_LENGTH) {
                    newLength = MIN_LENGTH;
                } else if ((newLength & (newLength - 1)) != 0) {
                    newLength = Integer.highestOneBit(newLength);
                }
                float[] helper = new float[newLength];
                System.arraycopy(xpoints, 0, helper, 0,
                        npoints);
                xpoints = helper;

                helper = new float[newLength];
                System.arraycopy(ypoints, 0, helper, 0,
                        npoints);
                ypoints = helper;
            }
            xpoints[npoints] = x;
            ypoints[npoints] = y;
            npoints++;
            if (bounds != null) {
                updateBounds(x, y);
            }
        }

        @Override
        public Rectangle getBounds() {
            Polygon x;
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Rectangle2D getBounds2D() {
            if (npoints == 0) {
                return new Rectangle2D.Float();
            }
            if (bounds == null) {
                calculateBounds(xpoints, ypoints, npoints);
            }
            return (Rectangle2D) bounds.clone();
        }

        @Override
        public boolean contains(double x, double y, double w, double h) {
            return contains((float) x, (float) y, (float) w, (float) h);
        }

        public boolean contains(float x, float y, float w, float h) {
            if (npoints <= 0 || !getBounds2D().intersects(x, y, w, h)) {
                return false;
            }

            Crossings cross = getCrossings(x, y, x + w, y + h);
            return (cross != null && cross.covers(y, y + h));
        }

        @Override
        public PathIterator getPathIterator(AffineTransform at) {
            return new PolygonPathIteratorFloat(this, at);
        }
    }

    static class PolygonPathIteratorDouble implements PathIterator {

        Polygon2D.Double poly;
        AffineTransform transform;
        int index;

        public PolygonPathIteratorDouble(Polygon2D.Double pg, AffineTransform at) {
            poly = pg;
            transform = at;
            if (pg.npoints == 0) {
                // Prevent a spurious SEG_CLOSE segment
                index = 1;
            }
        }

        /**
         * Returns the winding rule for determining the interior of the
         * path.
         * @return an integer representing the current winding rule.
         * @see PathIterator#WIND_NON_ZERO
         */
        @Override
        public int getWindingRule() {
            return WIND_EVEN_ODD;
        }

        /**
         * Tests if there are more points to read.
         * @return <code>true</code> if there are more points to read;
         *          <code>false</code> otherwise.
         */
        @Override
        public boolean isDone() {
            return index > poly.npoints;
        }

        /**
         * Moves the iterator forwards, along the primary direction of
         * traversal, to the next segment of the path when there are
         * more points in that direction.
         */
        @Override
        public void next() {
            index++;
        }

        /**
         * Returns the coordinates and type of the current path segment in
         * the iteration.
         * The return value is the path segment type:
         * SEG_MOVETO, SEG_LINETO, or SEG_CLOSE.
         * A <code>float</code> array of length 2 must be passed in and
         * can be used to store the coordinates of the point(s).
         * Each point is stored as a pair of <code>float</code> x,&nbsp;y
         * coordinates.  SEG_MOVETO and SEG_LINETO types return one
         * point, and SEG_CLOSE does not return any points.
         * @param coords a <code>float</code> array that specifies the
         * coordinates of the point(s)
         * @return an integer representing the type and coordinates of the
         * 		current path segment.
         * @see PathIterator#SEG_MOVETO
         * @see PathIterator#SEG_LINETO
         * @see PathIterator#SEG_CLOSE
         */
        @Override
        public int currentSegment(float[] coords) {
            if (index >= poly.npoints) {
                return SEG_CLOSE;
            }
            coords[0] = (float) poly.xpoints[index];
            coords[1] = (float) poly.ypoints[index];
            if (transform != null) {
                transform.transform(coords, 0, coords, 0, 1);
            }
            return (index == 0 ? SEG_MOVETO : SEG_LINETO);
        }

        /**
         * Returns the coordinates and type of the current path segment in
         * the iteration.
         * The return value is the path segment type:
         * SEG_MOVETO, SEG_LINETO, or SEG_CLOSE.
         * A <code>double</code> array of length 2 must be passed in and
         * can be used to store the coordinates of the point(s).
         * Each point is stored as a pair of <code>double</code> x,&nbsp;y
         * coordinates.
         * SEG_MOVETO and SEG_LINETO types return one point,
         * and SEG_CLOSE does not return any points.
         * @param coords a <code>double</code> array that specifies the
         * coordinates of the point(s)
         * @return an integer representing the type and coordinates of the
         * 		current path segment.
         * @see PathIterator#SEG_MOVETO
         * @see PathIterator#SEG_LINETO
         * @see PathIterator#SEG_CLOSE
         */
        @Override
        public int currentSegment(double[] coords) {
            if (index >= poly.npoints) {
                return SEG_CLOSE;
            }
            coords[0] = poly.xpoints[index];
            coords[1] = poly.ypoints[index];
            if (transform != null) {
                transform.transform(coords, 0, coords, 0, 1);
            }
            return (index == 0 ? SEG_MOVETO : SEG_LINETO);
        }
    }

    static class PolygonPathIteratorFloat implements PathIterator {

        Polygon2D.Float poly;
        AffineTransform transform;
        int index;

        public PolygonPathIteratorFloat(Polygon2D.Float pg, AffineTransform at) {
            poly = pg;
            transform = at;
            if (pg.npoints == 0) {
                // Prevent a spurious SEG_CLOSE segment
                index = 1;
            }
        }

        /**
         * Returns the winding rule for determining the interior of the
         * path.
         * @return an integer representing the current winding rule.
         * @see PathIterator#WIND_NON_ZERO
         */
        @Override
        public int getWindingRule() {
            return WIND_EVEN_ODD;
        }

        /**
         * Tests if there are more points to read.
         * @return <code>true</code> if there are more points to read;
         *          <code>false</code> otherwise.
         */
        @Override
        public boolean isDone() {
            return index > poly.npoints;
        }

        /**
         * Moves the iterator forwards, along the primary direction of
         * traversal, to the next segment of the path when there are
         * more points in that direction.
         */
        @Override
        public void next() {
            index++;
        }

        /**
         * Returns the coordinates and type of the current path segment in
         * the iteration.
         * The return value is the path segment type:
         * SEG_MOVETO, SEG_LINETO, or SEG_CLOSE.
         * A <code>float</code> array of length 2 must be passed in and
         * can be used to store the coordinates of the point(s).
         * Each point is stored as a pair of <code>float</code> x,&nbsp;y
         * coordinates.  SEG_MOVETO and SEG_LINETO types return one
         * point, and SEG_CLOSE does not return any points.
         * @param coords a <code>float</code> array that specifies the
         * coordinates of the point(s)
         * @return an integer representing the type and coordinates of the
         * 		current path segment.
         * @see PathIterator#SEG_MOVETO
         * @see PathIterator#SEG_LINETO
         * @see PathIterator#SEG_CLOSE
         */
        @Override
        public int currentSegment(float[] coords) {
            if (index >= poly.npoints) {
                return SEG_CLOSE;
            }
            coords[0] = (float) poly.xpoints[index];
            coords[1] = (float) poly.ypoints[index];
            if (transform != null) {
                transform.transform(coords, 0, coords, 0, 1);
            }
            return (index == 0 ? SEG_MOVETO : SEG_LINETO);
        }

        /**
         * Returns the coordinates and type of the current path segment in
         * the iteration.
         * The return value is the path segment type:
         * SEG_MOVETO, SEG_LINETO, or SEG_CLOSE.
         * A <code>double</code> array of length 2 must be passed in and
         * can be used to store the coordinates of the point(s).
         * Each point is stored as a pair of <code>double</code> x,&nbsp;y
         * coordinates.
         * SEG_MOVETO and SEG_LINETO types return one point,
         * and SEG_CLOSE does not return any points.
         * @param coords a <code>double</code> array that specifies the
         * coordinates of the point(s)
         * @return an integer representing the type and coordinates of the
         * 		current path segment.
         * @see PathIterator#SEG_MOVETO
         * @see PathIterator#SEG_LINETO
         * @see PathIterator#SEG_CLOSE
         */
        @Override
        public int currentSegment(double[] coords) {
            if (index >= poly.npoints) {
                return SEG_CLOSE;
            }
            coords[0] = poly.xpoints[index];
            coords[1] = poly.ypoints[index];
            if (transform != null) {
                transform.transform(coords, 0, coords, 0, 1);
            }
            return (index == 0 ? SEG_MOVETO : SEG_LINETO);
        }
    }
}
