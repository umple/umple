/*
 * @(#)HSBColorSpace.java
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
import java.awt.color.ColorSpace;

/**
 * A HSB color space with additive complements in the hue color wheel:
 * red is opposite cyan, magenta is opposite green, blue is opposite yellow.
 *
 * @author Werner Randelshofer
 * @version $Id: HSBColorSpace.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class HSBColorSpace extends ColorSpace implements NamedColorSpace {

    private static HSBColorSpace instance;

    public static HSBColorSpace getInstance() {
        if (instance == null) {
            instance = new HSBColorSpace();
        }
        return instance;
    }

    public HSBColorSpace() {
        super(ColorSpace.TYPE_HSV, 3);
    }

    @Override
    public float[] toRGB(float[] c) {
        int rgb = Color.HSBtoRGB(c[0], c[1], c[2]);

        return new float[]{//
                    ((rgb & 0xff0000) >> 16) / 255f,//
                    ((rgb & 0xff00) >> 8) / 255f,//
                    (rgb & 0xff) / 255f//
                };
    }

    @Override
    public float[] fromRGB(float[] rgbvalue) {
        return Color.RGBtoHSB(//
                (int) (rgbvalue[0] * 255),//
                (int) (rgbvalue[1] * 255),//
                (int) (rgbvalue[2] * 255),//
                new float[3]);
    }

    @Override
    public float[] toCIEXYZ(float[] colorvalue) {
        float[] rgb = toRGB(colorvalue);
        return ColorSpace.getInstance(CS_sRGB).toCIEXYZ(rgb);
    }

    @Override
    public float[] fromCIEXYZ(float[] colorvalue) {
        float[] sRGB = ColorSpace.getInstance(ColorSpace.CS_sRGB).fromCIEXYZ(colorvalue);
        return fromRGB(sRGB);
    }

    @Override
    public String getName(int idx) {
        switch (idx) {
            case 0:
                return "Hue";
            case 1:
                return "Saturation";
            case 2:
                return "Brightness";
            default:
                throw new IllegalArgumentException("index must be between 0 and 2:" + idx);
        }
    }

    @Override
    public float getMaxValue(int component) {
        return 1f;
    }

    @Override
    public float getMinValue(int component) {
        return 0f;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof HSBColorSpace);
    }

    @Override
    public int hashCode() {

        return getClass().getSimpleName().hashCode();
    }
    @Override
    public String getName() {
        return "HSB";
    }
}
