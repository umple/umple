/*
 * @(#)RectangleFigure.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */


package org.jhotdraw.draw;

import java.awt.*;
import java.awt.geom.*;
import org.jhotdraw.geom.Geom;

/**
 * A {@link Figure} with a rectangular shape.
 *
 * @author Werner Randelshofer
 * @version $Id: RectangleFigure.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class RectangleFigure extends AbstractAttributedFigure {
    protected Rectangle2D.Double rectangle;
    
    /** Creates a new instance. */
    public RectangleFigure() {
        this(0, 0, 0, 0);
    }
    
    public RectangleFigure(double x, double y, double width, double height) {
        rectangle = new Rectangle2D.Double(x, y, width, height);
    }

    // DRAWING
    @Override
    protected void drawFill(Graphics2D g) {
        Rectangle2D.Double r = (Rectangle2D.Double) rectangle.clone();
            double grow = AttributeKeys.getPerpendicularFillGrowth(this);
            Geom.grow(r, grow, grow);
        g.fill(r);
    }
    
    @Override
    protected void drawStroke(Graphics2D g) {
        Rectangle2D.Double r = (Rectangle2D.Double) rectangle.clone();
        double grow = AttributeKeys.getPerpendicularDrawGrowth(this);
       Geom.grow(r, grow, grow);
       
        g.draw(r);
    }
    // SHAPE AND BOUNDS
    @Override
    public Rectangle2D.Double getBounds() {
        Rectangle2D.Double bounds = (Rectangle2D.Double) rectangle.clone();
        return bounds;
    }
    
    @Override public Rectangle2D.Double getDrawingArea() {
        Rectangle2D.Double r = (Rectangle2D.Double) rectangle.clone();
        double grow = AttributeKeys.getPerpendicularHitGrowth(this) + 1d;
        Geom.grow(r, grow, grow);
        return r;
    }
    /**
     * Checks if a Point2D.Double is inside the figure.
     */
    @Override
    public boolean contains(Point2D.Double p) {
        Rectangle2D.Double r = (Rectangle2D.Double) rectangle.clone();
        double grow = AttributeKeys.getPerpendicularHitGrowth(this) + 1d;
        Geom.grow(r, grow, grow);
        return r.contains(p);
    }
    
    @Override
    public void setBounds(Point2D.Double anchor, Point2D.Double lead) {
        rectangle.x = Math.min(anchor.x, lead.x);
        rectangle.y = Math.min(anchor.y , lead.y);
        rectangle.width = Math.max(0.1, Math.abs(lead.x - anchor.x));
        rectangle.height = Math.max(0.1, Math.abs(lead.y - anchor.y));
    }
    /**
     * Moves the Figure to a new location.
     * @param tx the transformation matrix.
     */
    @Override
    public void transform(AffineTransform tx) {
        Point2D.Double anchor = getStartPoint();
        Point2D.Double lead = getEndPoint();
        setBounds(
                (Point2D.Double) tx.transform(anchor, anchor),
                (Point2D.Double) tx.transform(lead, lead)
                );
    }
    
    @Override
    public void restoreTransformTo(Object geometry) {
        rectangle.setRect( (Rectangle2D.Double) geometry );
    }
    
    @Override
    public Object getTransformRestoreData() {
        return rectangle.clone();
    }
    
    @Override
    public RectangleFigure clone() {
        RectangleFigure that = (RectangleFigure) super.clone();
        that.rectangle = (Rectangle2D.Double) this.rectangle.clone();
        return that;
    }
    // EVENT HANDLING
}
