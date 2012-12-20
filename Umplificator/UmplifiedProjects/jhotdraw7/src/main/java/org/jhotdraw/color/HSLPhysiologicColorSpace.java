/*
 * @(#)HSLPhysiologicColorSpace.java
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
 * A HSL color space with physiologic opposites in the hue color wheel:
 * red is opposite green and yellow is opposite blue.
 *
 * @author Werner Randelshofer
 * @version $Id: HSLPhysiologicColorSpace.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class HSLPhysiologicColorSpace extends ColorSpace implements NamedColorSpace {

    private static HSLPhysiologicColorSpace instance;

    public static HSLPhysiologicColorSpace getInstance() {
        if (instance == null) {
            instance = new HSLPhysiologicColorSpace();
        }
        return instance;
    }

    public HSLPhysiologicColorSpace() {
        super(ColorSpace.TYPE_HSV, 3);
    }

    @Override
    public float[] toRGB(float[] components) {
        float hue = components[0];
        float saturation = components[1];
        float lightness = components[2];

        // normalize hue
        hue = hue - (float) Math.floor(hue);
        if (hue < 0) {
            hue = 1f + hue;
        }
        // normalize saturation
        if (saturation > 1f) {
            saturation = 1f;
        } else if (saturation < 0f) {
            saturation = 0f;
        }
        // normalize value
        if (lightness > 1f) {
            lightness = 1f;
        } else if (lightness < 0f) {
            lightness = 0f;
        }

        float hueDeg = hue * 360f;
        if (hueDeg < 0) {
            hueDeg += 360f;
        }
        // compute hi and f from hue
       // float f;
        float hk = hue - (float) Math.floor(hue); // / 360f;
        if (hueDeg < 120f) { // red to yellow
            hk /= 2f;
        } else if (hueDeg < 160f) { // yellow to green
            hk = (hk - 120f/360f) * 3f/2f + 60f/360f;
        } else if (hueDeg < 220f) { // green to cyan
            hk = (hk - 160f/360f) + 120f/360f;
        } else if (hueDeg < 280f) { // cyan to blue
            hk = (hk - 220f/360f) + 180f/360f;
        } else if (hueDeg < 340f) { // blue to purple
            hk = (hk - 280f/360f) + 240f/360f;
        } else { // purple to red
            hk = (hk - 340f/360f) *3f + 300f/360f;
        }

        // compute p and q from saturation and lightness
        float q;
        if (lightness < 0.5f) {
            q = lightness * (1f + saturation);
        } else {
            q = lightness + saturation - (lightness * saturation);
        }
        float p = 2f * lightness - q;


        // compute red, green and blue
        float red = hk + 1f / 3f;
        float green = hk;
        float blue = hk - 1f / 3f;

        if (red < 0) {
            red = red + 1f;
        }
        if (green < 0) {
            green = green + 1f;
        }
        if (blue < 0) {
            blue = blue + 1f;
        }
        if (red > 1) {
            red = red - 1f;
        }
        if (green > 1) {
            green = green - 1f;
        }
        if (blue > 1) {
            blue = blue - 1f;
        }

        if (red < 1f / 6f) {
            red = p + ((q - p) * 6 * red);
        } else if (red < 0.5f) {
            red = q;
        } else if (red < 2f / 3f) {
            red = p + ((q - p) * 6 * (2f / 3f - red));
        } else {
            red = p;
        }
        if (green < 1f / 6f) {
            green = p + ((q - p) * 6 * green);
        } else if (green < 0.5f) {
            green = q;
        } else if (green < 2f / 3f) {
            green = p + ((q - p) * 6 * (2f / 3f - green));
        } else {
            green = p;
        }

        if (blue < 1f / 6f) {
            blue = p + ((q - p) * 6 * blue);
        } else if (blue < 0.5f) {
            blue = q;
        } else if (blue < 2f / 3f) {
            blue = p + ((q - p) * 6 * (2f / 3f - blue));
        } else {
            blue = p;
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
        float luminance;

        if (max == min) {
            hue = 0;
        } else if (max == r && g >= b) { // red to yellow
            hue = 120f * (g - b) / (max - min);
        } else if (max == r) { // red to purple
            hue = 20f * (g - b) / (max - min) + 360f;
        } else if (max == g && r >= b) { // yellow to green
            hue = 40f * (b - r) / (max - min) + 120f + 40f;
        } else if (max == g) { // green to cyan
            hue = 60f * (b - r) / (max - min) + 120f + 40f;
        } else if (g >= r) { // cyan to blue
            hue = 60f * (r - g) / (max - min) + 240f + 40f;
        } else { // blue to purple
            hue = 60f * (r - g) / (max - min) + 240f + 40f;
        }

        luminance = (max + min) / 2f;

        if (max == min) {
            saturation = 0;
        } else if (luminance <= 0.5f) {
            saturation = (max - min) / (max + min);
        } else /* if (lightness  > 0.5f)*/ {
            saturation = (max - min) / (2 - (max + min));
        }

        return new float[]{
                    hue / 360f,
                    saturation,
                    luminance};
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
        return (o instanceof HSLPhysiologicColorSpace);
    }

    @Override
    public int hashCode() {

        return getClass().getSimpleName().hashCode();
    }
    @Override
    public String getName() {
        return "physiologic HSL";
    }
}
