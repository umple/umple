/*
 * @(#)DiamondFigure.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw;

import org.jhotdraw.draw.connector.ChopDiamondConnector;
import org.jhotdraw.draw.connector.Connector;
import java.awt.*;
import java.awt.geom.*;
import org.jhotdraw.geom.Geom;

/**
 * A {@link Figure} with a diamond shape.
 * <p>
 * The diamond vertices are located at the midpoints of its enclosing rectangle.
 *
 *
 * @author Werner Randelshofer
 * @version $Id: DiamondFigure.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class DiamondFigure extends AbstractAttributedFigure {

    /**
     * If the attribute IS_QUADRATIC is put to true, all sides of the diamond have
     * the same length.
     */
    public final static AttributeKey<Boolean> IS_QUADRATIC = new AttributeKey<Boolean>("isQuadratic", Boolean.class, false);
    /**
     * The bounds of the diamond figure.
     */
    private Rectangle2D.Double rectangle;

    /** Creates a new instance. */
    public DiamondFigure() {
        this(0, 0, 0, 0);
    }

    public DiamondFigure(double x, double y, double width, double height) {
        rectangle = new Rectangle2D.Double(x, y, width, height);
        /*
        setFillColor(Color.white);
        setStrokeColor(Color.black);
         */
    }

    // DRAWING
    @Override
    protected void drawFill(Graphics2D g) {
        Rectangle2D.Double r = (Rectangle2D.Double) rectangle.clone();
        if (get(IS_QUADRATIC)) {
            double side = Math.max(r.width, r.height);
            r.x -= (side - r.width) / 2;
            r.y -= (side - r.height) / 2;
            r.width = r.height = side;
        }

        double grow = AttributeKeys.getPerpendicularFillGrowth(this);
        if (grow != 0d) {
            double w = r.width / 2d;
            double h = r.height / 2d;
            double lineLength = Math.sqrt(w * w + h * h);
            double scale = grow / lineLength;
            double yb = scale * w;
            double xa = scale * h;

            double growx, growy;
            growx = ((yb * yb) / xa + xa);
            growy = ((xa * xa) / yb + yb);

            Geom.grow(r, growx, growy);
        }

        Path2D.Double diamond = new Path2D.Double();
        diamond.moveTo((r.x + r.width / 2), r.y);
        diamond.lineTo((r.x + r.width), (r.y + r.height / 2));
        diamond.lineTo((r.x + r.width / 2), (r.y + r.height));
        diamond.lineTo(r.x, (r.y + r.height / 2));
        diamond.closePath();
        g.fill(diamond);
    }

    @Override
    protected void drawStroke(Graphics2D g) {
        Rectangle2D.Double r = (Rectangle2D.Double) rectangle.clone();
        if (get(IS_QUADRATIC)) {
            double side = Math.max(r.width, r.height);
            r.x -= (side - r.width) / 2;
            r.y -= (side - r.height) / 2;
            r.width = r.height = side;
        }

        double grow = AttributeKeys.getPerpendicularDrawGrowth(this);
        if (grow != 0d) {
            double growx, growy;
            double w = r.width / 2d;
            double h = r.height / 2d;
            double lineLength = Math.sqrt(w * w + h * h);
            double scale = grow / lineLength;
            double yb = scale * w;
            double xa = scale * h;

            growx = ((yb * yb) / xa + xa);
            growy = ((xa * xa) / yb + yb);

            Geom.grow(r, growx, growy);
        }

        Path2D.Double diamond = new Path2D.Double();
        diamond.moveTo((r.x + r.width / 2), r.y);
        diamond.lineTo((r.x + r.width), (r.y + r.height / 2));
        diamond.lineTo((r.x + r.width / 2), (r.y + r.height));
        diamond.lineTo(r.x, (r.y + r.height / 2));
        diamond.closePath();
        g.draw(diamond);
    }
// SHAPE AND BOUNDS

    @Override
    public Rectangle2D.Double getBounds() {
        Rectangle2D.Double bounds = (Rectangle2D.Double) rectangle.clone();
        return bounds;
    }

    @Override
    public Rectangle2D.Double getDrawingArea() {
        Rectangle2D.Double r = (Rectangle2D.Double) rectangle.clone();
        if (get(IS_QUADRATIC)) {
            double side = Math.max(r.width, r.height);
            r.x -= (side - r.width) / 2;
            r.y -= (side - r.height) / 2;
            r.width = r.height = side;
        }
        double grow = AttributeKeys.getPerpendicularHitGrowth(this);
        if (grow != 0d) {
            double w = r.width / 2d;
            double h = r.height / 2d;
            double lineLength = Math.sqrt(w * w + h * h);
            double scale = grow / lineLength;
            double yb = scale * w;
            double xa = scale * h;

            double growx, growy;
            growx = ((yb * yb) / xa + xa);
            growy = ((xa * xa) / yb + yb);

            Geom.grow(r, growx, growy);
        }

        return r;
    }

    /**
     * Checks if a Point2D.Double is inside the figure.
     */
    @Override
    public boolean contains(Point2D.Double p) {
        Rectangle2D.Double r = (Rectangle2D.Double) rectangle.clone();
        if (get(IS_QUADRATIC)) {
            double side = Math.max(r.width, r.height);
            r.x -= (side - r.width) / 2;
            r.y -= (side - r.height) / 2;
            r.width = r.height = side;
        }
        //   if (r.contains(p)) {

        double grow = AttributeKeys.getPerpendicularFillGrowth(this);
        if (grow != 0d) {
            double w = r.width / 2d;
            double h = r.height / 2d;
            double lineLength = Math.sqrt(w * w + h * h);
            double scale = grow / lineLength;
            double yb = scale * w;
            double xa = scale * h;

            double growx, growy;
            growx = ((yb * yb) / xa + xa);
            growy = ((xa * xa) / yb + yb);

            Geom.grow(r, growx, growy);
        }

        Path2D.Double diamond = new Path2D.Double();
        diamond.moveTo((r.x + r.width / 2), r.y);
        diamond.lineTo((r.x + r.width), (r.y + r.height / 2));
        diamond.lineTo((r.x + r.width / 2), (r.y + r.height));
        diamond.lineTo(r.x, (r.y + r.height / 2));
        diamond.closePath();
        return diamond.contains(p);
    }

    @Override
    public void setBounds(Point2D.Double anchor, Point2D.Double lead) {
        rectangle.x = Math.min(anchor.x, lead.x);
        rectangle.y = Math.min(anchor.y, lead.y);
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
                (Point2D.Double) tx.transform(lead, lead));
    }

    @Override
    public void restoreTransformTo(Object geometry) {
        Rectangle2D.Double r = (Rectangle2D.Double) geometry;
        rectangle.x = r.x;
        rectangle.y = r.y;
        rectangle.width = r.width;
        rectangle.height = r.height;
    }

    @Override
    public Object getTransformRestoreData() {
        return rectangle.clone();
    }

// ATTRIBUTES
// EDITING
// CONNECTING
    /**
     * Returns the Figures connector for the specified location.
     * By default a ChopDiamondConnector is returned.
     * @see ChopDiamondConnector
     */
    @Override
    public Connector findConnector(Point2D.Double p, ConnectionFigure prototype) {
        return new ChopDiamondConnector(this);
    }

    @Override
    public Connector findCompatibleConnector(Connector c, boolean isStart) {
        return new ChopDiamondConnector(this);
    }
// COMPOSITE FIGURES
// CLONING

    @Override
    public DiamondFigure clone() {
        DiamondFigure that = (DiamondFigure) super.clone();
        that.rectangle = (Rectangle2D.Double) this.rectangle.clone();
        return that;
    }
// EVENT HANDLING
}
