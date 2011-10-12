/*
 * @(#)PolyLineDecorationLocator.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.locator;

import org.jhotdraw.draw.*;
import org.jhotdraw.geom.*;
import java.awt.geom.*;
import org.jhotdraw.xml.*;

/**
 * A {@link Locator} which can be used to place a label on the path of
 * a {@link BezierFigure}.
 * <p>
 * The point is located at a distance and an angle relative to the total length
 * of the bezier path.
 * <p>
 * XXX - The angle should be perpendicular to the path.
 *
 * @author  Werner Randelshofer
 * @version $Id: BezierLabelLocator.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class BezierLabelLocator implements Locator, DOMStorable {
    private double relativePosition;
    private double angle;
    private double distance;
    
    /**
     * Creates a new instance.
     * This constructor is for use by DOMStorable only.
     */
    public BezierLabelLocator() {
    }
    /** Creates a new locator.
     *
     * @param relativePosition The relative position of the label on the polyline.
     * 0.0 specifies the start of the bezier path, 1.0 the
     * end of the polyline. Values between 0.0 and 1.0 are relative positions
     * on the bezier path.
     * @param angle The angle of the distance vector.
     * @param distance The length of the distance vector.
     */
    public BezierLabelLocator(double relativePosition, double angle, double distance) {
        this.relativePosition = relativePosition;
        this.angle = angle;
        this.distance = distance;
    }
    
    @Override
    public Point2D.Double locate(Figure owner) {
        return getRelativePoint((BezierFigure) owner);
    }
    @Override
    public Point2D.Double locate(Figure owner, Figure label) {
        Point2D.Double relativePoint = getRelativeLabelPoint((BezierFigure) owner, label);
        return relativePoint;
    }
    
    /**
     * Returns the coordinates of the relative point on the path
     * of the specified bezier figure.
     */
    public Point2D.Double getRelativePoint(BezierFigure owner) {
        Point2D.Double point = owner.getPointOnPath((float) relativePosition, 3);
        Point2D.Double nextPoint = owner.getPointOnPath(
                (relativePosition < 0.5) ? (float) relativePosition + 0.1f : (float) relativePosition - 0.1f,
                3);
        
        double dir = Math.atan2(nextPoint.y - point.y, nextPoint.x - point.x);
        if (relativePosition >= 0.5) {
            dir += Math.PI;
        }
        double alpha = dir + angle;
        
        Point2D.Double p = new Point2D.Double(
                point.x + distance * Math.cos(alpha),
                point.y + distance * Math.sin(alpha)
                );
        
        if (Double.isNaN(p.x)) p = point;
        
        return p;
    }
    
    
    /**
     * Returns a Point2D.Double on the polyline that is at the provided relative position.
     * XXX - Implement this and move it to BezierPath
     */
    public Point2D.Double getRelativeLabelPoint(BezierFigure owner, Figure label) {
        // Get a point on the path an the next point on the path
        Point2D.Double point = owner.getPointOnPath((float) relativePosition, 3);
        if (point == null) {
            return new Point2D.Double(0,0);
        }
        Point2D.Double nextPoint = owner.getPointOnPath(
                (relativePosition < 0.5) ? (float) relativePosition + 0.1f : (float) relativePosition - 0.1f,
                3);
        
        double dir = Math.atan2(nextPoint.y - point.y, nextPoint.x - point.x);
        if (relativePosition >= 0.5) {
            dir += Math.PI;
        }
        double alpha = dir + angle;
        
        Point2D.Double p = new Point2D.Double(
                point.x + distance * Math.cos(alpha),
                point.y + distance * Math.sin(alpha)
                );
        if (Double.isNaN(p.x)) p = point;
        
        Dimension2DDouble labelDim = label.getPreferredSize();
        if (relativePosition == 0.5 && 
                p.x >= point.x - distance / 2 && 
                p.x <= point.x + distance / 2) {
            if (p.y >= point.y) {
                // South East
                return new Point2D.Double(p.x - labelDim.width / 2, p.y);
            } else {
                // North East
                return new Point2D.Double(p.x - labelDim.width / 2, p.y - labelDim.height);
            }
        } else {
            if (p.x >= point.x) {
                if (p.y >= point.y) {
                    // South East
                    return new Point2D.Double(p.x, p.y);
                } else {
                    // North East
                    return new Point2D.Double(p.x, p.y - labelDim.height);
                }
            } else {
                if (p.y >= point.y) {
                    // South West
                    return new Point2D.Double(p.x - labelDim.width,  p.y);
                } else {
                    // North West
                    return new Point2D.Double(p.x - labelDim.width, p.y - labelDim.height);
                }
            }
        }
/*
        int percentage = (int) (relativePosition * 100);
 
        int segment; // relative segment
        Point2D.Double segPoint; // relative Point2D.Double on the segment
        int nPoints = owner.getPointCount();
        Point2D.Double[] Points = owner.getPoints();
 
        if (nPoints < 2) return new Point2D.Double(0, 0);
 
        switch (percentage) {
            case 0 :
                segment = 0;
                segPoint = owner.getStartPoint();
                break;
            case 100 :
                segment = owner.getPointCount() - 2;
                segPoint = owner.getEndPoint();
                break;
            default :
                double totalLength = 0d;
                double[] segLength = new double[nPoints - 1];
                for (int i=1; i < nPoints; i++) {
                    segLength[i-1] = Geom.length(Points[i-1].x, Points[i-1].y, Points[i].x, Points[i].y);
                    totalLength += segLength[i-1];
                }
                double relativeProgress = percentage * totalLength / 101d;
                segment = 0;
                double segMin = 0d;
                for (segment=0; segment < segLength.length - 1; segment++) {
                    if (segMin + segLength[segment] > relativeProgress) break;
                    segMin += segLength[segment];
                }
 
                // Compute the relative Point2D.Double on the line
                segPoint = new Point2D.Double();
                relativeProgress -= segMin;
                segPoint.x = (int) ((Points[segment].x * (segLength[segment] - relativeProgress) + Points[segment + 1].x * relativeProgress) / segLength[segment] +.5);
                segPoint.y = (int) ((Points[segment].y * (segLength[segment] - relativeProgress) + Points[segment + 1].y * relativeProgress) / segLength[segment] +.5);
 
                break;
        }
 
        Dimension2DDouble labelDim = label.getPreferredSize();
 
        Line2D.Double line = new Line2D.Double(Points[segment].x, Points[segment].y, Points[segment + 1].x, Points[segment + 1].y);
        double dir = Math.atan2(Points[segment + 1].y - Points[segment].y, Points[segment + 1].x - Points[segment].x);
        double alpha = dir + angle;
 
        Point2D.Double p = new Point2D.Double(
        (int) (segPoint.x + distance * Math.cos(alpha)),
        (int) (segPoint.y + distance * Math.sin(alpha))
        );
 
        if (p.x >= segPoint.x) {
            if (p.y >= segPoint.y) {
                // South East
                return new Point2D.Double(p.x, p.y);
            } else {
                // North East
                return new Point2D.Double(p.x, p.y - labelDim.height);
            }
        } else {
            if (p.y >= segPoint.y) {
                // South West
                return new Point2D.Double(p.x - labelDim.width,  p.y);
            } else {
                // North West
                return new Point2D.Double(p.x - labelDim.width, p.y - labelDim.height);
            }
        }*/
    }
    
    @Override
    public void read(DOMInput in) {
        relativePosition = in.getAttribute("relativePosition", 0d);
        angle = in.getAttribute("angle", 0d);
        distance = in.getAttribute("distance", 0);
        
    }
    
    @Override
    public void write(DOMOutput out) {
        out.addAttribute("relativePosition", relativePosition);
        out.addAttribute("angle", angle);
        out.addAttribute("distance", distance);
        
    }
    
}
