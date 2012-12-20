/*
 * @(#)AbstractLineDecoration.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 *
 */

package org.jhotdraw.draw.decoration;

import org.jhotdraw.draw.*;
import java.awt.*;
import java.awt.geom.*;
import org.jhotdraw.geom.Geom;
import static org.jhotdraw.draw.AttributeKeys.*;

/**
 * This abstract class can be extended to implement a {@link LineDecoration}.
 *
 * @author Werner Randelshofer
 * @version $Id: AbstractLineDecoration.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public abstract class AbstractLineDecoration implements LineDecoration {
    /**
     * If this is true, the decoration is filled.
     */
    private boolean isFilled;
    /**
     * If this is true, the decoration is stroked.
     */
    private boolean isStroked;
    /**
     * If this is true, the stroke color is used to fill the decoration.
     */
    private boolean isSolid;
    /**
     * Constructs an arrow tip with the given angle and radius.
     */
    public AbstractLineDecoration(boolean isFilled, boolean isStroked, boolean isSolid) {
        this.isFilled = isFilled;
        this.isStroked = isStroked;
        this.isSolid = isSolid;
    }
    
    protected boolean isFilled() {
        return isFilled;
    }
    protected boolean isStroked() {
        return isStroked;
    }
    protected boolean isSolid() {
        return isSolid;
    }
    
    /**
     * Draws the arrow tip in the direction specified by the given two
     * Points. (template method)
     */
    @Override
    public void draw(Graphics2D g, Figure f, Point2D.Double p1, Point2D.Double p2) {
        Path2D.Double path = getTransformedDecoratorPath(f, p1, p2);
        Color color;
        if (isFilled) {
            if (isSolid) {
                color = f.get(STROKE_COLOR);
            } else {
                color = f.get(FILL_COLOR);
            }
            if (color != null) {
                g.setColor(color);
                g.fill(path);
            }
        }
        if (isStroked) {
            color = f.get(STROKE_COLOR);
            if (color != null) {
                g.setColor(color);
                g.setStroke(AttributeKeys.getStroke(f));
                g.draw(path);
            }
        }
    }
    
    /**
     * Returns the drawing area of the decorator.
     */
    @Override
    public Rectangle2D.Double getDrawingArea(Figure f, Point2D.Double p1, Point2D.Double p2) {
        Path2D.Double path = getTransformedDecoratorPath(f, p1, p2);
        Rectangle2D b = path.getBounds2D();
        Rectangle2D.Double area = new Rectangle2D.Double(b.getX(), b.getY(), b.getWidth(), b.getHeight());
        
        if (isStroked) {
            double strokeWidth = f.get(STROKE_WIDTH);
            int strokeJoin = f.get(STROKE_JOIN);
            double miterLimit = (f.get(STROKE_MITER_LIMIT) * strokeWidth);
            
            double grow;
            if (strokeJoin == BasicStroke.JOIN_MITER) {
                grow  = (int) (1 + strokeWidth / 2 * miterLimit);
            } else {
                grow  = (int) (1 + strokeWidth / 2);
            }
            Geom.grow(area, grow, grow);
        } else {
            Geom.grow(area, 1, 1); // grow due to antialiasing
        }
        
        return area;
    }
    
    @Override
    public double getDecorationRadius(Figure f) {
        double strokeWidth = f.get(STROKE_WIDTH);
        double scaleFactor;
        if (strokeWidth > 1f) {
            scaleFactor = 1d + (strokeWidth - 1d) / 2d;
        } else {
            scaleFactor = 1d;
        }
        return getDecoratorPathRadius(f) * scaleFactor;
    }
    
    private Path2D.Double getTransformedDecoratorPath(Figure f, Point2D.Double p1, Point2D.Double p2) {
        Path2D.Double path = getDecoratorPath(f);
        double strokeWidth = f.get(STROKE_WIDTH);
        
        AffineTransform transform = new AffineTransform();
        transform.translate(p1.x, p1.y);
        transform.rotate(Math.atan2(p1.x - p2.x, p2.y - p1.y));
       // transform.rotate(Math.PI / 2);
        if (strokeWidth > 1f) {
            transform.scale(1d + (strokeWidth - 1d) / 2d, 1d + (strokeWidth - 1d) / 2d);
        }
        path.transform(transform);
        
        return path;
    }
    
    protected void setFilled(boolean b) {
        isFilled = b;
    }
    protected void setStroked(boolean b) {
        isStroked = b;
    }
    protected void setSolid(boolean b) {
        isSolid = b;
    }
    
    /**
     * Hook method to calculate the path of the decorator.
     */
    protected abstract Path2D.Double getDecoratorPath(Figure f);
    
    /**
     * Hook method to calculate the radius of the decorator path.
     */
    protected abstract double getDecoratorPathRadius(Figure f);
}
