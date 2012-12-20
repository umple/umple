/*
 * @(#)Dimension2DDouble.java
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
 * Dimension2DDouble.
 *
 * @author  Werner Randelshofer
 * @version $Id: Dimension2DDouble.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class Dimension2DDouble extends Dimension2D implements java.io.Serializable {
    
    /**
     * The width dimension; negative values can be used. 
     *
     * @serial
     * @see #getSize
     * @see #setSize
     */
    public double width;

    /**
     * The height dimension; negative values can be used. 
     *
     * @serial
     * @see #getSize
     * @see #setSize
     */
    public double height;

    /** 
     * Creates an instance of <code>Dimension2DDouble</code> with a width 
     * of zero and a height of zero. 
     */
    public Dimension2DDouble() {
	this(0, 0);
    }

    /** 
     * Creates an instance of <code>Dimension2DDouble</code> whose width  
     * and height are the same as for the specified dimension. 
     *
     * @param    d   the specified dimension for the 
     *               <code>width</code> and 
     *               <code>height</code> values
     */
    public Dimension2DDouble(Dimension2DDouble d) {
	this(d.width, d.height);
    }

    /** 
     * Constructs a <code>Dimension2DDouble</code> and initializes
     * it to the specified width and specified height.
     *
     * @param width the specified width 
     * @param height the specified height
     */
    public Dimension2DDouble(double width, double height) {
	this.width = width;
	this.height = height;
    }

    /**
     * Returns the width of this dimension in double precision.
     * @return the width of this dimension in double precision
     */
    @Override
    public double getWidth() {
	return width;
    }

    /**
     * Returns the height of this dimension in double precision.
     * @return the height of this dimension in double precision
     */
    @Override
    public double getHeight() {
	return height;
    }

    /**
     * Sets the size of this <code>Dimension2DDouble</code> object to
     * the specified width and height in double precision.
     * Note that if <code>width</code> or <code>height</code>
     * are larger than <code>Integer.MAX_VALUE</code>, they will
     * be reset to <code>Integer.MAX_VALUE</code>.
     *
     * @param width  the new width for the <code>Dimension2DDouble</code> object
     * @param height the new height for the <code>Dimension2DDouble</code> object
     */
    @Override
    public void setSize(double width, double height) {
    	this.width = width;
    	this.height = height;
    }

    /**
     * Gets the size of this <code>Dimension2DDouble</code> object.
     * This method is included for completeness, to parallel the
     * <code>getSize</code> method defined by <code>Component</code>.
     *
     * @return   the size of this dimension, a new instance of 
     *           <code>Dimension2DDouble</code> with the same width and height
     * @see      Dimension2DDouble#setSize
     * @see      java.awt.Component#getSize
     * @since    JDK1.1
     */
    public Dimension2DDouble getSize() {
	return new Dimension2DDouble(width, height);
    }	

    /**
     * Sets the size of this <code>Dimension2DDouble</code> object to the specified size.
     * This method is included for completeness, to parallel the
     * <code>setSize</code> method defined by <code>Component</code>.
     * @param    d  the new size for this <code>Dimension2DDouble</code> object
     * @see      Dimension2DDouble#getSize
     * @see      java.awt.Component#setSize
     * @since    JDK1.1
     */
    public void setSize(Dimension2DDouble d) {
	setSize(d.width, d.height);
    }	

    /**
     * Checks whether two dimension objects have equal values.
     */
    @Override
    public boolean equals(Object obj) {
	if (obj instanceof Dimension2DDouble) {
	    Dimension2DDouble d = (Dimension2DDouble)obj;
	    return (width == d.width) && (height == d.height);
	}
	return false;
    }

    /**
     * Returns the hash code for this <code>Dimension2DDouble</code>.
     *
     * @return    a hash code for this <code>Dimension2DDouble</code>
     */
    @Override
    public int hashCode() {
        float sum = (float) (width + height);
        return Float.floatToIntBits(sum * (sum + 1)/2 + (float) width);
    }

    /**
     * Returns a string representation of the values of this 
     * <code>Dimension2DDouble</code> object's <code>height</code> and 
     * <code>width</code> fields. This method is intended to be used only 
     * for debugging purposes, and the content and format of the returned 
     * string may vary between implementations. The returned string may be 
     * empty but may not be <code>null</code>.
     * 
     * @return  a string representation of this <code>Dimension2DDouble</code> 
     *          object
     */
    @Override
    public String toString() {
	return getClass().getName() + "[width=" + width + ",height=" + height + "]";
    }
}
