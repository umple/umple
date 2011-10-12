/*
 * @(#)RelativeLocator.java
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
import java.awt.geom.*;
import static org.jhotdraw.draw.AttributeKeys.*;
import org.jhotdraw.geom.*;
import org.jhotdraw.xml.DOMInput;
import org.jhotdraw.xml.DOMOutput;
/**
 * A locator that specfies a point that is relative to the bounds
 * of a figure.
 *
 * @author Werner Randelshofer
 * @version $Id: RelativeLocator.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class RelativeLocator extends AbstractLocator {
    /**
     * Relative x-coordinate on the bounds of the figure.
     * The value 0 is on the left boundary of the figure, the value 1 on
     * the right boundary.
     */
    protected double relativeX;
    /**
     * Relative y-coordinate on the bounds of the figure.
     * The value 0 is on the top boundary of the figure, the value 1 on
     * the bottom boundary.
     */
    protected double relativeY;
    
    /**
     * If this is set to true, if the locator is transforming with the
     * figure.
     */
    protected boolean isTransform;
    
    /** Creates a new instance. */
    public RelativeLocator() {
        this(0, 0, false);
    }
    
    /** Creates a new instance. */
    public RelativeLocator(double relativeX, double relativeY) {
        this(relativeX, relativeY, false);
    }
    /**
     * @param relativeX x-position relative to bounds expressed as a value
     * between 0 and 1.
     * @param relativeY y-position relative to bounds expressed as a value
     * between 0 and 1.
     * @param isTransform Set this to true, if the locator shall honor the
     * TRANSFORM attribute of the Figure.
     */
    public RelativeLocator(double relativeX, double relativeY, boolean isTransform) {
        this.relativeX = relativeX;
        this.relativeY = relativeY;
        this.isTransform = isTransform;
    }
    
    @Override
    public java.awt.geom.Point2D.Double locate(Figure owner) {
        Rectangle2D.Double bounds = owner.getBounds();
        if ((owner instanceof DecoratedFigure) &&
                ((DecoratedFigure) owner).getDecorator() != null) {
            Insets2D.Double insets = owner.get(DECORATOR_INSETS);
            if (insets != null) {
                insets.addTo(bounds);
            }
        }
        
        Point2D.Double location;
        if (isTransform) {
            location = new Point2D.Double(
                    bounds.x + bounds.width * relativeX,
                    bounds.y + bounds.height * relativeY
                    );
            if (owner.get(TRANSFORM) != null) {
               owner.get(TRANSFORM).transform(location, location);
            }
        } else {
            if (owner.get(TRANSFORM) != null) {
                Rectangle2D r = owner.get(TRANSFORM).createTransformedShape(bounds).getBounds2D();
                bounds.x = r.getX();
                bounds.y = r.getY();
                bounds.width = r.getWidth();
                bounds.height = r.getHeight();
            }
            location = new Point2D.Double(
                    bounds.x + bounds.width * relativeX,
                    bounds.y + bounds.height * relativeY
                    );
        }
        return location;
    }
    
    
    /**
     * Non-transforming East.
     */
    static public Locator east() {
        return east(false);
    }
    /**
     * East.
     * @param isTransform Set this to true, if RelativeLocator shall honour
     * the AttributesKey.TRANSFORM attribute of the Figure.
     */
    static public Locator east(boolean isTransform) {
        return new RelativeLocator(1.0, 0.5, isTransform);
    }
    
    /**
     * Non-transforming North.
     */
    static public Locator north() {
        return north(false);
    }
    /**
     * North.
     * @param isTransform Set this to true, if RelativeLocator shall honour
     * the AttributesKey.TRANSFORM attribute of the Figure.
     */
    static public Locator north(boolean isTransform) {
        return new RelativeLocator(0.5, 0.0, isTransform);
    }
    
    /**
     * Non-transforming West.
     */
    static public Locator west() {
        return west(false);
    }
    /**
     * West.
     * @param isTransform Set this to true, if RelativeLocator shall honour
     * the AttributesKey.TRANSFORM attribute of the Figure.
     */
    static public Locator west(boolean isTransform) {
        return new RelativeLocator(0.0, 0.5, isTransform);
    }
    
    /**
     * Non-transforming North east.
     */
    static public Locator northEast() {
        return northEast(false);
    }
    /**
     * Norht East.
     * @param isTransform Set this to true, if RelativeLocator shall honour
     * the AttributesKey.TRANSFORM attribute of the Figure.
     */
    static public Locator northEast(boolean isTransform) {
        return new RelativeLocator(1.0, 0.0, isTransform);
    }
    
    /**
     * Non-transforming North west.
     */
    static public Locator northWest() {
        return northWest(false);
    }
    /**
     * North West.
     * @param isTransform Set this to true, if RelativeLocator shall honour
     * the AttributesKey.TRANSFORM attribute of the Figure.
     */
    static public Locator northWest(boolean isTransform) {
        return new RelativeLocator(0.0, 0.0, isTransform);
    }
    
    /**
     * Non-transforming South.
     */
    static public Locator south() {
        return south(false);
    }
    /**
     * South.
     * @param isTransform Set this to true, if RelativeLocator shall honour
     * the AttributesKey.TRANSFORM attribute of the Figure.
     */
    static public Locator south(boolean isTransform) {
        return new RelativeLocator(0.5, 1.0, isTransform);
    }
    
    /**
     * Non-transforming South east.
     */
    static public Locator southEast() {
        return southEast(false);
    }
    /**
     * South East.
     * @param isTransform Set this to true, if RelativeLocator shall honour
     * the AttributesKey.TRANSFORM attribute of the Figure.
     */
    static public Locator southEast(boolean isTransform) {
        return new RelativeLocator(1.0, 1.0, isTransform);
    }
    
    /**
     * Non-transforming South west.
     */
    static public Locator southWest() {
        return southWest(false);
    }
    /**
     * South West.
     *
     * @param isTransform Set this to true, if RelativeLocator shall honour
     * the AttributesKey.TRANSFORM attribute of the Figure.
     */
    static public Locator southWest(boolean isTransform) {
        return new RelativeLocator(0.0, 1.0, isTransform);
    }
    
    /**
     * Non-transforming Center.
     */
    static public Locator center() {
        return center(false);
    }
    /**
     * Center.
     *
     * @param isTransform Set this to true, if RelativeLocator shall honour
     * the AttributesKey.TRANSFORM attribute of the Figure.
     */
    static public Locator center(boolean isTransform) {
        return new RelativeLocator(0.5, 0.5, isTransform);
    }
    
    @Override
    public void write(DOMOutput out) {
        out.addAttribute("relativeX", relativeX, 0.5);
        out.addAttribute("relativeY", relativeY, 0.5);
    }
    
    @Override
    public void read(DOMInput in) {
        relativeX = in.getAttribute("relativeX", 0.5);
        relativeY = in.getAttribute("relativeY", 0.5);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RelativeLocator other = (RelativeLocator) obj;
        if (this.relativeX != other.relativeX) {
            return false;
        }
        if (this.relativeY != other.relativeY) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.relativeX) ^ (Double.doubleToLongBits(this.relativeX) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.relativeY) ^ (Double.doubleToLongBits(this.relativeY) >>> 32));
        return hash;
    }
}
