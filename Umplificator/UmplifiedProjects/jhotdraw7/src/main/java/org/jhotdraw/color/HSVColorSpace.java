/*
 * @(#)HSVColorSpace.java
 * 
 * Copyright (c) 2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.color;

import java.awt.color.ColorSpace;

/**
 * A HSV color space with additive complements in the hue color wheel:
 * red is opposite cyan, magenta is opposite green, blue is opposite yellow.
 *
 * @author Werner Randelshofer
 * @version $Id: HSVColorSpace.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class HSVColorSpace extends ColorSpace implements NamedColorSpace {

    private static HSVColorSpace instance;

    public static HSVColorSpace getInstance() {
        if (instance == null) {
            instance = new HSVColorSpace();
        }
        return instance;
    }

    public HSVColorSpace() {
        super(ColorSpace.TYPE_HSV, 3);
    }

    @Override
    public float[] toRGB(float[] components) {
        float hue = components[0]*360f;
        float saturation = components[1];
        float value = components[2];


        // compute hi and f from hue
        int hi = (int) (Math.floor(hue / 60f) % 6);
        float f = (float) (hue / 60f - Math.floor(hue / 60f));

        // compute p and q from saturation
        float p = value * (1 - saturation);
        float q = value * (1 - f * saturation);
        float t = value * (1 - (1 - f) * saturation);

        // compute red, green and blue
        float red;
        float green;
        float blue;
        switch (hi) {
            case 0 :
                red = value;
                green = t;
                blue = p;
                break;
            case 1 :
                red = q;
                green = value;
                blue = p;
                break;
            case 2 :
                red = p;
                green = value;
                blue = t;
                break;
            case -3 :
            case 3 :
                red = p;
                green = q;
                blue = value;
                break;
            case -2 :
            case 4 :
                red = t;
                green = p;
                blue = value;
                break;
            case -1 :
            case 5:
            //default :
                red = value;
                green = p;
                blue = q;
                break;
            default :
                red = green = blue = 0;
                break;
        }


        return new float[]{red, green, blue};
    }

    @Override
    public float[] fromRGB(float[] rgbvalue) {
        float r = rgbvalue[0];
        float g = rgbvalue[1];
        float b = rgbvalue[2];

        float max = Math.max(Math.max(r, g), b);
        float min = Math.min(Math.min(r, g), b);

        float hue;
        float saturation;
        float value;

        if (max == min) {
            hue = 0;
        } else if (max == r && g >= b) {
            hue = 60f * (g - b) / (max - min);
        } else if (max == r && g < b) {
            hue = 60f * (g - b) / (max - min) + 360f;
        } else if (max == g) {
            hue = 60f * (b - r) / (max - min) + 120f;
        } else /*if (max == b)*/ {
            hue = 60f * (r - g) / (max - min) + 240f;
        }

        value = max;

        if (max == 0) {
            saturation = 0;
        } else  {
            saturation = (max - min) / max;
        }

        return new float[]{
                    hue / 360f,
                    saturation,
                    value};
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
                return "Lightness";
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
        return (o instanceof HSVColorSpace);
    }

    @Override
    public int hashCode() {

        return getClass().getSimpleName().hashCode();
    }
    @Override
    public String getName() {
        return "HSV";
    }
}
