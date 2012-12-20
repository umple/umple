/*
 * @(#)RoundRectangleFigure.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw;

import org.jhotdraw.draw.connector.ChopRoundRectangleConnector;
import org.jhotdraw.draw.handle.RoundRectangleRadiusHandle;
import org.jhotdraw.draw.handle.Handle;
import org.jhotdraw.draw.connector.Connector;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;
import org.jhotdraw.geom.*;
import org.jhotdraw.xml.DOMInput;
import org.jhotdraw.xml.DOMOutput;

/**
 * A {@link Figure} with a rounded rectangular shape.
 * <p>
 * This figure has two JavaBeans properties {@code arcWidth} and
 * {@code arcHeight} which specify the corner radius.
 * <p>
 * This figure creates a {@link RoundRectangleRadiusHandle} which allows
 * to interactively change the corner radius.
 *
 * @author Werner Randelshofer
 * @version $Id: RoundRectangleFigure.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class RoundRectangleFigure extends AbstractAttributedFigure {
    /** Identifies the {@code arcWidth} JavaBeans property. */
    public final static String ARC_WIDTH_PROPERTY = "arcWidth";
    /** Identifies the {@code arcHeight} JavaBeans property. */
    public final static String ARC_HEIGHT_PROPERTY = "arcHeight";

    protected RoundRectangle2D.Double roundrect;
    protected static final double DEFAULT_ARC = 20;

    /** Creates a new instance. */
    public RoundRectangleFigure() {
        this(0, 0, 0, 0);
    }

    public RoundRectangleFigure(double x, double y, double width, double height) {
        roundrect = new RoundRectangle2D.Double(x, y, width, height, DEFAULT_ARC, DEFAULT_ARC);
    /*
    FILL_COLOR.set(this, Color.white);
    STROKE_COLOR.set(this, Color.black);
     */
    }
    // DRAWING
    @Override
    protected void drawFill(Graphics2D g) {
        RoundRectangle2D.Double r = (RoundRectangle2D.Double) roundrect.clone();
        double grow = AttributeKeys.getPerpendicularFillGrowth(this);
        r.x -= grow;
        r.y -= grow;
        r.width += grow * 2;
        r.height += grow * 2;
        r.arcwidth += grow * 2;
        r.archeight += grow * 2;
        if (r.width > 0 && r.height > 0) {
            g.fill(r);
        }
    }

    @Override
    protected void drawStroke(Graphics2D g) {
        RoundRectangle2D.Double r = (RoundRectangle2D.Double) roundrect.clone();
        double grow = AttributeKeys.getPerpendicularDrawGrowth(this);
        r.x -= grow;
        r.y -= grow;
        r.width += grow * 2;
        r.height += grow * 2;
        r.arcwidth += grow * 2;
        r.archeight += grow * 2;
        if (r.width > 0 && r.height > 0) {
            g.draw(r);
        }
    }
    // SHAPE AND BOUNDS
    @Override
    public Rectangle2D.Double getBounds() {
        return (Rectangle2D.Double) roundrect.getBounds2D();
    }

    @Override
    public Rectangle2D.Double getDrawingArea() {
        Rectangle2D.Double r = (Rectangle2D.Double) roundrect.getBounds2D();
        double grow = AttributeKeys.getPerpendicularHitGrowth(this) + 1;
        Geom.grow(r, grow, grow);

        return r;
    }

    /** Gets the arc width. */
    public double getArcWidth() {
        return roundrect.arcwidth;
    }

    /** Gets the arc height. */
    public double getArcHeight() {
        return roundrect.archeight;
    }

    /** Sets the arc width. */
    public void setArcWidth(double newValue) {
        double oldValue = roundrect.arcwidth;
        roundrect.arcwidth = newValue;
        firePropertyChange(ARC_WIDTH_PROPERTY, oldValue, newValue);
    }
    /** Sets the arc height. */
    public void setArcHeight(double newValue) {
        double oldValue = roundrect.archeight;
        roundrect.archeight = newValue;
        firePropertyChange(ARC_HEIGHT_PROPERTY, oldValue, newValue);
    }

    /** Convenience method for setting both the arc width and the arc height. */
    public void setArc(double width, double height) {
        setArcWidth(width);
        setArcHeight(height);
    }

    /**
     * Checks if a Point2D.Double is inside the figure.
     */
    @Override
    public boolean contains(Point2D.Double p) {
        RoundRectangle2D.Double r = (RoundRectangle2D.Double) roundrect.clone();
        double grow = AttributeKeys.getPerpendicularHitGrowth(this);
        r.x -= grow;
        r.y -= grow;
        r.width += grow * 2;
        r.height += grow * 2;
        r.arcwidth += grow * 2;
        r.archeight += grow * 2;
        return r.contains(p);
    }

    @Override
    public void setBounds(Point2D.Double anchor, Point2D.Double lead) {
        roundrect.x = Math.min(anchor.x, lead.x);
        roundrect.y = Math.min(anchor.y, lead.y);
        roundrect.width = Math.max(0.1, Math.abs(lead.x - anchor.x));
        roundrect.height = Math.max(0.1, Math.abs(lead.y - anchor.y));
    }

    /**
     * Transforms the figure.
     * @param tx The transformation.
     */
    @Override
    public void transform(AffineTransform tx) {
        Point2D.Double anchor = getStartPoint();
        Point2D.Double lead = getEndPoint();
        setBounds(
                (Point2D.Double) tx.transform(anchor, anchor),
                (Point2D.Double) tx.transform(lead, lead));
    }
    // EDITING
    @Override
    public Collection<Handle> createHandles(int detailLevel) {
        LinkedList<Handle> handles = (LinkedList<Handle>) super.createHandles(detailLevel);
        handles.add(new RoundRectangleRadiusHandle(this));

        return handles;
    }

    @Override
    public void restoreTransformTo(Object geometry) {
        RoundRectangle2D.Double r = (RoundRectangle2D.Double) geometry;
        roundrect.x = r.x;
        roundrect.y = r.y;
        roundrect.width = r.width;
        roundrect.height = r.height;
    }

    @Override
    public Object getTransformRestoreData() {
        return roundrect.clone();
    }
    // CONNECTING
    @Override
    public Connector findConnector(Point2D.Double p, ConnectionFigure prototype) {
        return new ChopRoundRectangleConnector(this);
    }

    @Override
    public Connector findCompatibleConnector(Connector c, boolean isStartConnector) {
        return new ChopRoundRectangleConnector(this);
    }
    // COMPOSITE FIGURES
    // CLONING
    @Override
    public RoundRectangleFigure clone() {
        RoundRectangleFigure that = (RoundRectangleFigure) super.clone();
        that.roundrect = (RoundRectangle2D.Double) this.roundrect.clone();
        return that;
    }
    // EVENT HANDLING

    // PERSISTENCE
    @Override
    public void read(DOMInput in) throws IOException {
        super.read(in);
        roundrect.arcwidth = in.getAttribute("arcWidth", DEFAULT_ARC);
        roundrect.archeight = in.getAttribute("arcHeight", DEFAULT_ARC);
    }

    @Override
    public void write(DOMOutput out) throws IOException {
        super.write(out);
        out.addAttribute("arcWidth", roundrect.arcwidth);
        out.addAttribute("arcHeight", roundrect.archeight);
    }

}
