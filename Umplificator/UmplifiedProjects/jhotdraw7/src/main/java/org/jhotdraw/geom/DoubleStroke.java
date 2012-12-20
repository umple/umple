/*
 * @(#)DoubleStroke.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.geom;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.*;
import java.awt.geom.*;

/**
 * Draws a double stroke (an outline of an outline).
 * The inner width of a DoubleStroke defines the distance between the two
 * outlines being drawn. The outline width of a DoubleStroke defines the
 * thickness of the outline.
 *
 * @author Werner Randelshofer
 * @version $Id: DoubleStroke.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class DoubleStroke implements Stroke {

    private BasicStroke outlineStroke;
    private double innerWidth;
    private double outlineWidth;
    private double miterLimit;
    private float[] dashes;
    private float dashPhase;

    public DoubleStroke(double innerWidth, double outlineWidth) {
        this(innerWidth, outlineWidth, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 10f, null, 0f);
    }

    public DoubleStroke(double innerWidth, double outlineWidth, int cap, int join, double miterLimit, @Nullable float[] dashes, float dashPhase) {
        this.innerWidth = innerWidth;
        this.outlineWidth = outlineWidth;
        this.miterLimit = miterLimit;
        // outlineStroke = new BasicStroke(outlineWidth, cap, join, miterLimit, dashes, dashPhase);
        outlineStroke = new BasicStroke((float) outlineWidth, cap, BasicStroke.JOIN_BEVEL, (float) miterLimit, dashes, dashPhase);
    }

    @Override
    public Shape createStrokedShape(Shape s) {
        BezierPath bp = new BezierPath();
        Path2D.Double left = new Path2D.Double();
        Path2D.Double right = new Path2D.Double();

        double[] coords = new double[6];
        // FIXME - We only do a flattened path
        for (PathIterator i = s.getPathIterator(null, 0.1d); !i.isDone(); i.next()) {
            int type = i.currentSegment(coords);

            switch (type) {
                case PathIterator.SEG_MOVETO:
                    if (bp.size() != 0) {
                        traceStroke(bp, left, right);
                    }
                    bp.clear();
                    bp.setClosed(false);
                    bp.moveTo(coords[0], coords[1]);
                    break;
                case PathIterator.SEG_LINETO:
                    if (coords[0] != bp.get(bp.size() - 1).x[0]
                            || coords[1] != bp.get(bp.size() - 1).y[0]) {
                        bp.lineTo(coords[0], coords[1]);
                    }
                    break;
                case PathIterator.SEG_QUADTO:
                    bp.quadTo(coords[0], coords[1], coords[2], coords[3]);
                    break;
                case PathIterator.SEG_CUBICTO:
                    bp.curveTo(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]);
                    break;
                case PathIterator.SEG_CLOSE:
                    bp.setClosed(true);
                    break;
            }
        }
        if (bp.size() != 0) {
            traceStroke(bp, left, right);
        }

        // Note: This could be extended to use different stroke objects for
        // the inner and the outher path.
        right.append(left, false);
        return outlineStroke.createStrokedShape(right);

    }

    protected void traceStroke(BezierPath bp, Path2D.Double left, Path2D.Double right) {
        // XXX - We only support straight line segments here
        // Corners of the current and the previous thick line
        double[] currentCorners = new double[8];
        double[] prevCorners = new double[8];

        Point2D.Double intersect;

        // Remove duplicate nodes from bezier path.
        if (bp.isClosed()) {
            BezierPath.Node prev = bp.get(bp.size() - 1);
            for (int i = 0; i < bp.size(); i++) {
                BezierPath.Node node = bp.get(i);
                if (prev.x[0] == node.x[0] && prev.y[0] == node.y[0]) {
                    bp.remove(i--);

                } else {
                    prev = node;
                }
            }
        } else {
            BezierPath.Node prev = bp.get(0);
            for (int i = 1; i < bp.size(); i++) {
                BezierPath.Node node = bp.get(i);
                if (prev.x[0] == node.x[0] && prev.y[0] == node.y[0]) {
                    bp.remove(i--);

                } else {
                    prev = node;
                }
            }
        }

        // Handle the first point of the bezier path
        if (bp.isClosed() && bp.size() > 1) {
            prevCorners = computeThickLine(
                    bp.get(bp.size() - 1).x[0], bp.get(bp.size() - 1).y[0],
                    bp.get(0).x[0], bp.get(0).y[0],
                    innerWidth, prevCorners);
            currentCorners = computeThickLine(
                    bp.get(0).x[0], bp.get(0).y[0],
                    bp.get(1).x[0], bp.get(1).y[0],
                    innerWidth, currentCorners);

            intersect = Geom.intersect(
                    prevCorners[0], prevCorners[1],
                    prevCorners[4], prevCorners[5],
                    currentCorners[0], currentCorners[1],
                    currentCorners[4], currentCorners[5], miterLimit);

            if (intersect != null) {
                right.moveTo(intersect.x, intersect.y);
            } else {
                right.moveTo(prevCorners[4], prevCorners[5]);
                right.lineTo(currentCorners[0], currentCorners[1]);
            }

            intersect = Geom.intersect(
                    prevCorners[2], prevCorners[3],
                    prevCorners[6], prevCorners[7],
                    currentCorners[2], currentCorners[3],
                    currentCorners[6], currentCorners[7], miterLimit);
            if (intersect != null) {
                left.moveTo(intersect.x, intersect.y);
            } else {
                left.moveTo(prevCorners[6], prevCorners[7]);
                left.lineTo(currentCorners[2], currentCorners[3]);
            }
        } else {
            if (bp.size() > 1) {
                currentCorners = computeThickLine(
                        bp.get(0).x[0], bp.get(0).y[0],
                        bp.get(1).x[0], bp.get(1).y[0],
                        innerWidth, currentCorners);
                right.moveTo(currentCorners[0], currentCorners[1]);
                left.moveTo(currentCorners[2], currentCorners[3]);
            }
        }

        // Handle points in the middle of the bezier path
        for (int i = 1, n = bp.size() - 1; i < n; i++) {
            double[] tmp = prevCorners;
            prevCorners = currentCorners;
            currentCorners = computeThickLine(
                    bp.get(i).x[0], bp.get(i).y[0],
                    bp.get(i + 1).x[0], bp.get(i + 1).y[0],
                    innerWidth, tmp);
            intersect = Geom.intersect(
                    prevCorners[0], prevCorners[1],
                    prevCorners[4], prevCorners[5],
                    currentCorners[0], currentCorners[1],
                    currentCorners[4], currentCorners[5], miterLimit);
            if (intersect != null) {
                right.lineTo(intersect.x, intersect.y);
            } else {
                right.lineTo(prevCorners[4], prevCorners[5]);
                right.lineTo(currentCorners[0], currentCorners[1]);
            }

            intersect = Geom.intersect(
                    prevCorners[2], prevCorners[3],
                    prevCorners[6], prevCorners[7],
                    currentCorners[2], currentCorners[3],
                    currentCorners[6], currentCorners[7], miterLimit);
            if (intersect != null) {
                left.lineTo(intersect.x, intersect.y);
            } else {
                left.lineTo(prevCorners[6], prevCorners[7]);
                left.lineTo(currentCorners[2], currentCorners[3]);
            }
        }

        // Handle the last point of the bezier path
        if (bp.isClosed() && bp.size() > 0) {
            double[] tmp = prevCorners;
            prevCorners = currentCorners;
            currentCorners = computeThickLine(
                    bp.get(bp.size() - 1).x[0], bp.get(bp.size() - 1).y[0],
                    bp.get(0).x[0], bp.get(0).y[0],
                    //bp.get(1).x[0], bp.get(1).y[0],
                    innerWidth, tmp);
            intersect = Geom.intersect(
                    prevCorners[0], prevCorners[1],
                    prevCorners[4], prevCorners[5],
                    currentCorners[0], currentCorners[1],
                    currentCorners[4], currentCorners[5], miterLimit);
            if (intersect != null) {
                right.lineTo(intersect.x, intersect.y);
            } else {
                right.lineTo(prevCorners[4], prevCorners[5]);
                right.lineTo(currentCorners[0], currentCorners[1]);
            }

            intersect = Geom.intersect(
                    prevCorners[2], prevCorners[3],
                    prevCorners[6], prevCorners[7],
                    currentCorners[2], currentCorners[3],
                    currentCorners[6], currentCorners[7], miterLimit);
            if (intersect != null) {
                left.lineTo(intersect.x, intersect.y);
            } else {
                left.lineTo(prevCorners[6], prevCorners[7]);
                left.lineTo(currentCorners[2], currentCorners[3]);
            }

            right.closePath();
            left.closePath();

        } else {
            if (bp.size() > 1) {
                right.lineTo(currentCorners[4], currentCorners[5]);
                left.lineTo(currentCorners[6], currentCorners[7]);
            }
        }
    }

    private double[] computeThickLine(double[] seg, int offset, double corners[]) {
        return computeThickLine(seg[0 + offset], seg[1 + offset], seg[2 + offset], seg[3 + offset], innerWidth, corners);
    }

    private double[] computeThickLine(double x1, double y1, double x2, double y2, double thickness, double corners[]) {
        double dx = x2 - x1;
        double dy = y2 - y1;

        // line length
        double lineLength = Math.sqrt(dx * dx + dy * dy);

        double scale = thickness / (2d * lineLength);

        // The x and y increments from an endpoint needed to create a rectangle...
        double ddx = -scale * dy;
        double ddy = scale * dx;
        /*
        ddx += (ddx > 0) ? 0.5 : -0.5;
        ddy += (ddy > 0) ? 0.5 : -0.5;
         */
        // Now we can compute the corner points...
        corners[0] = x1 + ddx;
        corners[1] = y1 + ddy;
        corners[2] = x1 - ddx;
        corners[3] = y1 - ddy;
        corners[4] = x2 + ddx;
        corners[5] = y2 + ddy;
        corners[6] = x2 - ddx;
        corners[7] = y2 - ddy;

        return corners;
    }
}
