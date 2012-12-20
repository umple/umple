/*
 * @(#)EllipseFigure.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw;

import org.jhotdraw.draw.connector.ChopEllipseConnector;
import org.jhotdraw.draw.connector.Connector;
import org.jhotdraw.geom.Geom;
import java.awt.*;
import java.awt.geom.*;
import static org.jhotdraw.draw.AttributeKeys.*;

/**
 * A {@link Figure} with an elliptic shape.
 *
 * @author Werner Randelshofer
 * @version $Id: EllipseFigure.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class EllipseFigure extends AbstractAttributedFigure {

    protected Ellipse2D.Double ellipse;

    /**
     * Constructs a new {@code EllipseFigure}, initialized to
     * location (0,&nbsp;0) and size (0,&nbsp;0).
     */
    public EllipseFigure() {
        this(0, 0, 0, 0);
    }

    /**
     * Constructs and initializes an {@code EllipseFigure} from the
     * specified coordinates.
     *
     * @param x the x coordinate of the bounding rectangle
     * @param y the y coordinate of the bounding rectangle
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     */
    public EllipseFigure(double x, double y, double width, double height) {
        ellipse = new Ellipse2D.Double(x, y, width, height);
    }

    // DRAWING
    // SHAPE AND BOUNDS
    // ATTRIBUTES
    // EDITING
    // CONNECTING
    @Override
    public Connector findConnector(Point2D.Double p, ConnectionFigure prototype) {
        return new ChopEllipseConnector(this);
    }

    @Override
    public Connector findCompatibleConnector(Connector c, boolean isStartConnector) {
        return new ChopEllipseConnector(this);
    }
    // COMPOSITE FIGURES
    // CLONING
    // EVENT HANDLING

    @Override
    public Rectangle2D.Double getBounds() {
        return (Rectangle2D.Double) ellipse.getBounds2D();
    }

    @Override
    public Rectangle2D.Double getDrawingArea() {
        Rectangle2D.Double r = (Rectangle2D.Double) ellipse.getBounds2D();
        double grow = AttributeKeys.getPerpendicularHitGrowth(this);
        Geom.grow(r, grow+1, grow+1);
        return r;
    }

    @Override
    protected void drawFill(Graphics2D g) {
        Ellipse2D.Double r = (Ellipse2D.Double) ellipse.clone();
        double grow = AttributeKeys.getPerpendicularFillGrowth(this);
        r.x -= grow;
        r.y -= grow;
        r.width += grow * 2;
        r.height += grow * 2;
        if (r.width > 0 && r.height > 0) {
            g.fill(r);
        }
    }

    @Override
    protected void drawStroke(Graphics2D g) {
        Ellipse2D.Double r = (Ellipse2D.Double) ellipse.clone();
        double grow = AttributeKeys.getPerpendicularDrawGrowth(this);
        r.x -= grow;
        r.y -= grow;
        r.width += grow * 2;
        r.height += grow * 2;

        if (r.width > 0 && r.height > 0) {
            g.draw(r);
        }
    }

    /**
     * Checks if a Point2D.Double is inside the figure.
     */
    @Override
    public boolean contains(Point2D.Double p) {
        Ellipse2D.Double r = (Ellipse2D.Double) ellipse.clone();
        double grow = AttributeKeys.getPerpendicularHitGrowth(this);
        r.x -= grow;
        r.y -= grow;
        r.width += grow * 2;
        r.height += grow * 2;

        return r.contains(p);
    }

    @Override
    public void setBounds(Point2D.Double anchor, Point2D.Double lead) {
        ellipse.x = Math.min(anchor.x, lead.x);
        ellipse.y = Math.min(anchor.y, lead.y);
        ellipse.width = Math.max(0.1, Math.abs(lead.x - anchor.x));
        ellipse.height = Math.max(0.1, Math.abs(lead.y - anchor.y));
    }

    /**
     * Transforms the figure.
     *
     * @param tx the transformation.
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
    public EllipseFigure clone() {
        EllipseFigure that = (EllipseFigure) super.clone();
        that.ellipse = (Ellipse2D.Double) this.ellipse.clone();
        return that;
    }

    @Override
    public void restoreTransformTo(Object geometry) {
        Ellipse2D.Double e = (Ellipse2D.Double) geometry;
        ellipse.x = e.x;
        ellipse.y = e.y;
        ellipse.width = e.width;
        ellipse.height = e.height;
    }

    @Override
    public Object getTransformRestoreData() {
        return ellipse.clone();
    }
}
