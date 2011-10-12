/*
 * @(#)RadialGradient.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.svg;

import java.awt.*;
import java.awt.geom.*;
import java.util.Arrays;
import org.jhotdraw.draw.*;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

/**
 * Represents an SVG RadialGradient.
 *
 * @author Werner Randelshofer
 * @version $Id: RadialGradient.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class RadialGradient implements Gradient {
    private double cx;
    private double cy;
    private double fx;
    private double fy;
    private double r;
    private boolean isRelativeToFigureBounds = true;
    private double[] stopOffsets;
    private Color[] stopColors;
    private AffineTransform transform;
    private double[] stopOpacities;
            
    /** Creates a new instance. */
    public RadialGradient() {
    }
    public RadialGradient(
            double cx, double cy, double fx, double fy, double r,
            double[] stopOffsets, Color[] stopColors, double[] stopOpacities,
            boolean isRelativeToFigureBounds,
            AffineTransform tx) {
        this.cx = cx;
        this.cy = cy;
        this.fx = fx;
        this.fy = fy;
        this.r = r;
        this.stopOffsets = stopOffsets.clone();
        this.stopColors = stopColors.clone();
        this.stopOpacities = stopOpacities.clone();
        this.isRelativeToFigureBounds = isRelativeToFigureBounds;
        this.transform = tx;
    }
    public void setGradientCircle(double cx, double cy, double r) {
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }
    public void setStops(double[] offsets, Color[] colors, double[] stopOpacities) {
        this.stopOffsets = offsets.clone();
        this.stopColors = colors.clone();
        this.stopOpacities = stopOpacities.clone();
    }
    public void setRelativeToFigureBounds(boolean b) {
        isRelativeToFigureBounds = b;
    }
    @Override
    public void makeRelativeToFigureBounds(Figure f) {
        if (! isRelativeToFigureBounds) {
            isRelativeToFigureBounds = true;
            Rectangle2D.Double bounds = f.getBounds();
            cx = (cx - bounds.x) / bounds.width;
            cy = (cy - bounds.y) / bounds.height;
            r = r / Math.sqrt(bounds.width * bounds.width / 2d + bounds.height * bounds.height / 2d);
        }
    }
    
    
    @Override
    public Paint getPaint(Figure f, double opacity) {
        if (stopColors.length == 0 || r <= 0) {
            return new Color(0xa0a0a000,true);
        }
        
        // Compute colors and fractions for the paint
        Color[] colors = new Color[stopColors.length];
        float[] fractions = new float[stopColors.length];
        for (int i=0; i < stopColors.length; i++) {
            fractions[i] = (float) stopOffsets[i];
            colors[i] = new Color(
                    (stopColors[i].getRGB() & 0xffffff) |
                    ((int) (opacity * stopOpacities[i] * 255) << 24),
                    true
                    );
        }
        
        // Compute the dimensions and transforms for the paint
        Point2D.Double cp, fp;
        double rr;
        cp = new Point2D.Double(cx, cy);
        fp = new Point2D.Double(fx, fy);
        rr = r;
        AffineTransform t = transform;
        if (isRelativeToFigureBounds) {
            if (! t.isIdentity()) System.out.println("RadialGradient "+hashCode()+" t="+t);
            t = new AffineTransform();
            Rectangle2D.Double bounds = f.getBounds();
            t.translate(bounds.x, bounds.y);
            t.scale(bounds.width, bounds.height);
        }
        
        // Construct a solid color, if only one stop color is given, or if
        // transform is not invertible
        if (stopColors.length == 1 || t.getDeterminant() == 0) {
            return colors[0];
        }
        // Construct the paint
        RadialGradientPaint gp;
        gp = new RadialGradientPaint(
                cp,
                (float) rr,
                fp,
                fractions,
                colors,
                RadialGradientPaint.CycleMethod.NO_CYCLE,
                RadialGradientPaint.ColorSpaceType.SRGB,
                t
                );
        return gp;
    }
    
    public double getCX() {
        return cx;
    }
    public double getCY() {
        return cy;
    }
    public double getFX() {
        return fx;
    }
    public double getFY() {
        return fy;
    }
    public double getR() {
        return r;
    }
    public double[] getStopOffsets() {
        return stopOffsets.clone();
    }
    public Color[] getStopColors() {
        return stopColors.clone();
    }
    public double[] getStopOpacities() {
        return stopOpacities.clone();
    }
    @Override
    public boolean isRelativeToFigureBounds() {
        return isRelativeToFigureBounds;
    }
    
    public void setTransform(AffineTransform tx) {
        transform = tx;
    }
    public AffineTransform getTransform() {
        return transform;
    }
    
    @Override
    public void transform(AffineTransform tx) {
        if (transform == null) {
            transform = (AffineTransform) tx.clone();
        } else {
            transform.preConcatenate(tx);
        }
    }
    
    @Override
    public Object clone() {
        try {
            RadialGradient that = (RadialGradient) super.clone();
            that.stopOffsets = this.stopOffsets.clone();
            that.stopColors = this.stopColors.clone();
            that.stopOpacities = this.stopOpacities.clone();
            that.transform = (AffineTransform) this.transform.clone();
            return that;
        } catch (CloneNotSupportedException ex) {
            InternalError e = new InternalError();
            e.initCause(ex);
            throw e;
        }
    }
    @Override
    public int hashCode() {
	long bits = Double.doubleToLongBits(cx);
	bits += Double.doubleToLongBits(cy) * 37;
	bits += stopColors[0].hashCode() * 43;
	bits += stopColors[stopColors.length - 1].hashCode() * 47;
	return (((int) bits) ^ ((int) (bits >> 32)));
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof RadialGradient) {
            return equals((RadialGradient) o);
        } else {
            return false;
        }
    }
    public boolean equals(RadialGradient that) {
        return cx == that.cx &&
                cy == that.cy &&
                fx == that.fx &&
                fy == that.fy &&
                r == that.r &&
                isRelativeToFigureBounds == that.isRelativeToFigureBounds &&
                Arrays.equals(stopOffsets, that.stopOffsets) &&
                Arrays.equals(stopOpacities, that.stopOpacities) &&
                Arrays.equals(stopColors, that.stopColors) &&
                transform.equals(that.transform);
    }
}

