/*
 * @(#)Insets2D.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.geom;

import java.awt.Insets;
import java.awt.geom.*;
import java.io.Serializable;
/**
 * Insets2D.
 *
 * @author Werner Randelshofer
 * @version $Id: Insets2D.java 727 2011-01-09 13:23:59Z rawcoder $
 * expectations of people used to the java.awt.geom.xxx2D.Double/xxx2D.Float
 * idioms.
 */
public abstract class Insets2D implements Cloneable, Serializable {
    
    /** Creates a new instance. */
    protected Insets2D() {
    }
    
    /**
     * Returns the top insets in double precision.
     * @return the top insets of this <code>Insets2D</code>.
     */
    public abstract double getTop();
    
    /**
     * Returns the left insets in double precision.
     * @return the left insets of this <code>Insets2D</code>.
     */
    public abstract double getLeft();
    
    /**
     * Returns the bottom insets in double precision.
     * @return the bottom insets of this <code>Insets2D</code>.
     */
    public abstract double getBottom();
    
    /**
     * Returns the right insets in double precision.
     * @return the right insets of this <code>Insets2D</code>.
     */
    public abstract double getRight();
    
    /**
     * Sets the insets.
     *
     * @param top The top insets.
     * @param left The left insets.
     * @param bottom The bottom insets.
     * @param right The right insets.
     */
    public abstract void set(double top, double left, double bottom, double right);
    
    /**
     * Sets the insets.
     *
     * @param i The new insets.
     */
    public void set(Insets2D i) {
        set(i.getTop(), i.getLeft(), i.getBottom(), i.getRight());
    }
    
    /**
     * Adds the specified insets to the current insets.
     *
     * @param top The top insets.
     * @param left The left insets.
     * @param bottom The bottom insets.
     * @param right The right insets.
     */
    public void add(double top, double left, double bottom, double right) {
        set(
                getTop() + top,
                getLeft() + left,
                getBottom() + bottom,
                getRight() + right
                );
    }
    /**
     * Adds the specified insets to the current insets.
     *
     * @param i The insets to be added.
     */
    public void add(Insets2D i) {
        set(
                getTop() + i.getTop(),
                getLeft() + i.getLeft(),
                getBottom() + i.getBottom(),
                getRight() + i.getRight()
                );
    }
    
    /**
     * Adds the current insets to the specified Rectangle2D making the
     * rectangle larger.
     *
     * @param r The Rectangle2D.
     */
    public void addTo(Rectangle2D r) {
        r.setRect(
                r.getX() - getLeft(),
                r.getY() - getTop(),
                r.getWidth() + getLeft() + getRight(),
                r.getHeight() + getTop() + getBottom()
                );
    }
    /**
     * Subtracts the specified insets from the current insets.
     *
     * @param top The top insets.
     * @param left The left insets.
     * @param bottom The bottom insets.
     * @param right The right insets.
     */
    public void subtract(double top, double left, double bottom, double right) {
        set(
                getTop() - top,
                getLeft() - left,
                getBottom() - bottom,
                getRight() - right
                );
    }
    /**
     * Subtracts the specified insets from the current insets.
     *
     * @param i The insets to be subtracted.
     */
    public void subtract(Insets2D i) {
        set(
                getTop() - i.getTop(),
                getLeft() - i.getLeft(),
                getBottom() - i.getBottom(),
                getRight() - i.getRight()
                );
    }
    /**
     * Subtracts the current insets to the specified Rectangle2D making the
     * rectangle smaller.
     *
     * @param r The Rectangle2D.
     */
    public void subtractTo(Rectangle2D r) {
        r.setRect(
                r.getX() + getLeft(),
                r.getY() + getTop(),
                r.getWidth() - getLeft() - getRight(),
                r.getHeight() - getTop() - getBottom()
                );
    }
    /**
     * Checks whether two insets objects are equal. Two instances
     * of <code>Insets2DDouble</code> are equal if the four integer values
     * of the fields <code>top</code>, <code>left</code>,
     * <code>bottom</code>, and <code>right</code> are all equal.
     * @return      <code>true</code> if the two insets are equal;
     *                          otherwise <code>false</code>.
     * @since       JDK1.1
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Insets2D) {
            Insets2D that = (Insets2D)obj;
            return ((getTop() == that.getTop()) &&
                    (getLeft() == that.getLeft()) &&
                    (getBottom() == that.getBottom()) &&
                    (getRight() == that.getRight()));
        }
        return false;
    }
    
    /**
     * Returns the hash code for this Insets2DDouble.
     *
     * @return    a hash code for this Insets2DDouble.
     */
    @Override
    public int hashCode() {
        double sum1 = getLeft() + getBottom();
        double sum2 = getRight() + getTop();
        double val1 = sum1 * (sum1 + 1)/2 + getLeft();
        double val2 = sum2 * (sum2 + 1)/2 + getTop();
        double sum3 = val1 + val2;
        return java.lang.Float.floatToIntBits((float) (sum3 * (sum3 + 1)/2 + val2));
    }
    /**
     * Creates a new object of the same class as this object.
     */
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError();
        }
    }

    /**
     * Returns a string representation of this <code>Insets</code> object.
     * This method is intended to be used only for debugging purposes, and
     * the content and format of the returned string may vary between
     * implementations. The returned string may be empty but may not be
     * <code>null</code>.
     *
     * @return  a string representation of this <code>Insets</code> object.
     */
    @Override
    public String toString() {
	return getClass().getName().substring(getClass().getName().lastIndexOf('.')+1) + "[top="  + getTop() + ",left=" + getLeft() + ",bottom=" + getBottom() + ",right=" + getRight() + "]";
    }
    /**
     * The <code>Float</code> class defines insets specified in
     * <code>float</code> precision.
     */
    public static class Float extends Insets2D {
        public float top;
        public float left;
        public float bottom;
        public float right;
        
        /**
         * Constructs and initializes an <code>Insets2D</code> with
         * all insets set to 0.
         */
        public Float() {
        }
        
        /**
         * Constructs and initializes an <code>Insets2D</code> with the
         * specified insets.
         *
         * @param top The top insets.
         * @param left The left insets.
         * @param bottom The bottom insets.
         * @param right The right insets.
         */
        public Float(float top, float left, float bottom, float right) {
            this.top = top;
            this.left = left;
            this.bottom = bottom;
            this.right = right;
        }
        
    @Override
        public double getTop() {
            return top;
        }
        
    @Override
        public double getLeft() {
            return left;
        }
        
    @Override
        public double getBottom() {
            return bottom;
        }
        
    @Override
        public double getRight() {
            return right;
        }
        
    @Override
        public void set(double top, double left, double bottom, double right) {
            this.top = (float) top;
            this.left = (float) left;
            this.bottom = (float) bottom;
            this.right = (float) right;
        }
        
        public void set(float top, float left, float bottom, float right) {
            this.top = top;
            this.left = left;
            this.bottom = bottom;
            this.right = right;
        }
    }
    /**
     * The <code>Double</code> class defines insets specified in
     * <code>double</code> precision.
     */
    public static class Double extends Insets2D {
        public double top;
        public double left;
        public double bottom;
        public double right;
        
        /**
         * Constructs and initializes an <code>Insets2D</code> with
         * all insets set to 0.
         */
        public Double() {
        }
        
        /**
         * Constructs and initializes an <code>Insets2D</code> with the
         * specified insets.
         *
         * @param top The top insets.
         * @param left The left insets.
         * @param bottom The bottom insets.
         * @param right The right insets.
         */
        public Double(double top, double left, double bottom, double right) {
            this.top = top;
            this.left = left;
            this.bottom = bottom;
            this.right = right;
        }
        
    @Override
        public double getTop() {
            return top;
        }
        
    @Override
        public double getLeft() {
            return left;
        }
        
    @Override
        public double getBottom() {
            return bottom;
        }
        
    @Override
        public double getRight() {
            return right;
        }
        
    @Override
        public void set(double top, double left, double bottom, double right) {
            this.top = top;
            this.left = left;
            this.bottom = bottom;
            this.right = right;
        }
    }
}

