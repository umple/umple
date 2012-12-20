/*
 * @(#)AbstractColorWheelImageProducer.java
 * 
 * Copyright (c) 2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.color;

import java.awt.Color;
import java.awt.Point;
import java.awt.color.ColorSpace;
import java.awt.image.ColorModel;
import java.awt.image.MemoryImageSource;

/**
 * AbstractColorWheelImageProducer.
 *
 * @author Werner Randelshofer
 * @version $Id: AbstractColorWheelImageProducer.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public abstract class AbstractColorWheelImageProducer extends MemoryImageSource {

    protected int[] pixels;
    protected int w, h;
    protected ColorSpace colorSpace;
    protected int radialIndex = 1;
    protected int angularIndex = 0;
    protected int verticalIndex = 2;
    protected boolean isPixelsValid = false;
    protected float verticalValue = 1f;
    protected boolean isLookupValid = false;

    public AbstractColorWheelImageProducer(ColorSpace sys, int w, int h) {
        super(w, h, null, 0, w);
        this.colorSpace = sys;
        pixels = new int[w * h];
        this.w = w;
        this.h = h;
        setAnimated(true);

        newPixels(pixels, ColorModel.getRGBdefault(), 0, w);
    }

    public void setRadialComponentIndex(int newValue) {
        radialIndex = newValue;
        isPixelsValid = false;
    }

    public void setAngularComponentIndex(int newValue) {
        angularIndex = newValue;
        isPixelsValid = false;
    }

    public void setVerticalComponentIndex(int newValue) {
        verticalIndex = newValue;
        isPixelsValid = false;
    }

    public void setVerticalValue(float newValue) {
        isPixelsValid = isPixelsValid && verticalValue == newValue;
        verticalValue = newValue;
    }

    public boolean needsGeneration() {
        return !isPixelsValid;
    }

    public void regenerateColorWheel() {
        if (!isPixelsValid) {
            generateColorWheel();
        }
    }

    public int getRadius() {
        return Math.min(w, h) / 2 - 2;
    }

    protected abstract void generateColorWheel();

    public Point getColorLocation(Color c) {
        float[] components =ColorUtil.fromColor(colorSpace, c);
        return getColorLocation(components);
    }


    public abstract Point getColorLocation(float[] components);

    public abstract float[] getColorAt(int x, int y);
}
