/*
 * @(#)GrowStroke.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.geom;

import java.awt.*;
import java.awt.geom.*;

/**
 * GrowStroke can be used to grow/shrink a figure by a specified line width.
 * This only works with closed convex paths having edges in clockwise direction.
 * <p>
 * Note: Although this is a Stroke object, it does not actually create a stroked
 * shape, but one that can be used for filling. 
 * 
 * @author Werner Randelshofer.
 * @version $Id: GrowStroke.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class GrowStroke extends DoubleStroke {

    private double grow;

    public GrowStroke(double grow, double miterLimit) {
        super(grow * 2d, 1d, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, miterLimit, null, 0f);
        this.grow = grow;
    }

    @Override
    public Shape createStrokedShape(Shape s) {

        BezierPath bp = new BezierPath();
        Path2D.Double left = new Path2D.Double();
        Path2D.Double right = new Path2D.Double();

        if (s instanceof Path2D.Double) {
            left.setWindingRule(((Path2D.Double) s).getWindingRule());
            right.setWindingRule(((Path2D.Double) s).getWindingRule());
        } else if (s instanceof BezierPath) {
            left.setWindingRule(((BezierPath) s).getWindingRule());
            right.setWindingRule(((BezierPath) s).getWindingRule());
        }

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
        if (bp.size() > 1) {
            traceStroke(bp, left, right);
        }


        if (Geom.contains(left.getBounds2D(), right.getBounds2D())) {
            return (grow > 0) ? left : right;
        } else {
            return (grow > 0) ? right : left;
        }
    }
}
