/*
 * @(#)ConvexHull.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.geom;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Provides utility methods for computing the convex hull from a set of points.
 *
 * @author Werner Randelshofer
 * @version $Id: ConvexHull.java 727 2011-01-09 13:23:59Z rawcoder $
 */
public class ConvexHull {

    /**
     * Computes the convex hull from a set of points.
     *
     * @param points
     * @return convex hull of the points as a polygon object.
     */
    public static Polygon getConvexHullPolygon(List<Point> points) {
        Polygon convexHull = new Polygon();
        for (Point p : getConvexHull(points.toArray(new Point[points.size()]))) {
            convexHull.addPoint(p.x, p.y);
        }
        return convexHull;
    }

    /**
     * Computes the convex hull from a set of points.
     *
     * @param points
     * @return convex hull of the points as a Polygon2D object.
     */
    public static Polygon2D.Double getConvexHullPath2D(List<Point2D.Double> points) {
        Polygon2D.Double convexHull = new Polygon2D.Double();
        for (Point p : getConvexHull(points.toArray(new Point[points.size()]))) {
            convexHull.add(p);
        }
        return convexHull;
    }

    /**
     * Computes the convex hull from a shape.
     *
     * @param shape an arbitray shape
     * @return convex hull of the points as a Polygon2D object.
     */
    public static Polygon2D.Double getConvexHullPath2D(Shape shape) {
        List<Point2D.Double> points = new LinkedList<Point2D.Double>();
        double[] coords = new double[6];
        for (PathIterator i = shape.getPathIterator(null); !i.isDone(); i.next()) {
            switch (i.currentSegment(coords)) {
                case PathIterator.SEG_CLOSE:
                    break;
                case PathIterator.SEG_MOVETO:
                case PathIterator.SEG_LINETO:
                    points.add(new Point2D.Double(coords[0], coords[1]));
                    break;
                case PathIterator.SEG_QUADTO:
                    points.add(new Point2D.Double(coords[0], coords[1]));
                    points.add(new Point2D.Double(coords[2], coords[3]));
                    break;
                case PathIterator.SEG_CUBICTO:
                    points.add(new Point2D.Double(coords[0], coords[1]));
                    points.add(new Point2D.Double(coords[2], coords[3]));
                    points.add(new Point2D.Double(coords[4], coords[5]));
                    break;
            }

        }
        Polygon2D.Double convexHull = new Polygon2D.Double();
        for (Point2D.Double p : getConvexHull2D(points.toArray(new Point2D.Double[points.size()]))) {
            convexHull.add(p);
        }
        return convexHull;
    }

    /**
     * Computes the convex hull from a set of points.
     *
     * @param points
     * @return convex hull of the points
     */
    public static List<Point> getConvexHull(List<Point> points) {
        return Arrays.asList(getConvexHull(points.toArray(new Point[points.size()])));
    }

    /**
     * Computes the convex hull from a set of points.
     *
     * @param points
     * @return convex hull of the points
     */
    public static List<Point2D.Double> getConvexHull2D(List<Point2D.Double> points) {
        return Arrays.asList(getConvexHull2D(points.toArray(new Point2D.Double[points.size()])));
    }

    /**
     * Computes the convex hull from a set of points.
     *
     * @param points
     * @return convex hull of the points
     */
    public static Point[] getConvexHull(Point[] points) {
        // Quickly return if no work is needed
        if (points.length < 3) {
            return points.clone();
        }

        // Sort points from left to right O(n log n)
        Point[] sorted = points.clone();
        Arrays.sort(sorted, new Comparator<Point>() {

    @Override
            public int compare(Point o1, Point o2) {
                int v = o1.x - o2.x;
                return (v == 0) ? o1.y - o2.y : v;
            }
        });

        Point[] hull = new Point[sorted.length + 2];

        // Process upper part of convex hull O(n)
        int upper = 0; // Number of points in upper part of convex hull
        hull[upper++] = sorted[0];
        hull[upper++] = sorted[1];
        for (int i = 2; i < sorted.length; i++) {
            hull[upper++] = sorted[i];
            while (upper > 2 && !isRightTurn(hull[upper - 3], hull[upper - 2], hull[upper - 1])) {
                hull[upper - 2] = hull[upper - 1];
                upper--;
            }
        }

        // Process lower part of convex hull O(n)
        int lower = upper; // (lower - number + 1) = number of points in the lower part of the convex hull
        hull[lower++] = sorted[sorted.length - 2];
        for (int i = sorted.length - 3; i >= 0; i--) {
            hull[lower++] = sorted[i];
            while (lower - upper > 1 && !isRightTurn(hull[lower - 3], hull[lower - 2], hull[lower - 1])) {
                hull[lower - 2] = hull[lower - 1];
                lower--;
            }
        }
        lower -= 1;

        // Reduce array
        Point[] convexHull = new Point[lower];
        System.arraycopy(hull, 0, convexHull, 0, lower);
        return convexHull;
    }

    /**
     * Returns true, if the three given points make a right turn.
     * 
     * @param p1 first point
     * @param p2 second point
     * @param p3 third point
     * @return true if right turn.
     */
    public static boolean isRightTurn(Point p1, Point p2, Point p3) {
        if (p1.equals(p2)||p2.equals(p3)) {
            // no right turn if points are at same location
            return false;
        }
        double val = (p2.x * p3.y + p1.x * p2.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
        return val > 0;
    }

    /**
     * Computes the convex hull from a set of points.
     *
     * @param points
     * @return convex hull of the points
     */
    public static Point2D.Double[] getConvexHull2D(Point2D.Double[] points) {
        // Quickly return if no work is needed
        if (points.length < 3) {
            return points.clone();
        }

        // Sort points from left to right O(n log n)
        Point2D.Double[] sorted = points.clone();
        Arrays.sort(sorted, new Comparator<Point2D.Double>() {
    @Override
            public int compare(Point2D.Double o1, Point2D.Double o2) {
                double v = o1.x - o2.x;
                if (v == 0) {
                    v = o1.y - o2.y;
                }
                return (v > 0) ? 1 : ((v < 0) ? -1 : 0);
            }
        });

        Point2D.Double[] hull = new Point2D.Double[sorted.length + 2];

        // Process upper part of convex hull O(n)
        int upper = 0; // Number of points in upper part of convex hull
        hull[upper++] = sorted[0];
        hull[upper++] = sorted[1];
        for (int i = 2; i < sorted.length; i++) {
            hull[upper++] = sorted[i];
            while (upper > 2 && !isRightTurn2D(hull[upper - 3], hull[upper - 2], hull[upper - 1])) {
                hull[upper - 2] = hull[upper - 1];
                upper--;
            }
        }

        // Process lower part of convex hull O(n)
        int lower = upper; // (lower - number + 1) = number of points in the lower part of the convex hull
        hull[lower++] = sorted[sorted.length - 2];
        for (int i = sorted.length - 3; i >= 0; i--) {
            hull[lower++] = sorted[i];
            while (lower - upper > 1 && !isRightTurn2D(hull[lower - 3], hull[lower - 2], hull[lower - 1])) {
                hull[lower - 2] = hull[lower - 1];
                lower--;
            }
        }
        lower -= 1;

        // Reduce array
        Point2D.Double[] convexHull = new Point2D.Double[lower];
        System.arraycopy(hull, 0, convexHull, 0, lower);
        return convexHull;
    }

    /**
     * Returns true, if the three given points make a right turn.
     *
     * @param p1 first point
     * @param p2 second point
     * @param p3 third point
     * @return true if right turn.
     */
    public static boolean isRightTurn2D(Point.Double p1, Point.Double p2, Point.Double p3) {
        if (p1.equals(p2)||p2.equals(p3)) {
            // no right turn if points are at same location
            return false;
        }
        
        double val = (p2.x * p3.y + p1.x * p2.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y);
        return val > 0;
    }
}
