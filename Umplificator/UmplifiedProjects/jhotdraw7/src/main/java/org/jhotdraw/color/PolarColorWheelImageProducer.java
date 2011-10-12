/*
 * @(#)PolarColorWheelImageProducer.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.color;

import java.awt.*;
import java.awt.color.ColorSpace;

/**
 * Produces the image of a {@link JColorWheel} by interpreting two components
 * of a {@code ColorSpace} as polar coordinates (angle and radius).
 *
 * @author  Werner Randelshofer
 * @version $Id: PolarColorWheelImageProducer.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class PolarColorWheelImageProducer extends AbstractColorWheelImageProducer {
    /** Lookup table for angular component values. */
    protected float[] angulars;
    /** Lookup table for radial component values. */
    protected float[] radials;
    /** Lookup table for alphas. 
     * The alpha value is used for antialiasing the
     * color wheel.
     */
    protected int[] alphas;

    /** Creates a new instance. */
    public PolarColorWheelImageProducer(ColorSpace sys, int w, int h) {
        super(sys, w, h);
    }

    protected void generateLookupTables() {
        radials = new float[w * h];
        angulars = new float[w * h];
        alphas = new int[w * h];
        float radius = getRadius();

        // blend is used to create a linear alpha gradient of two extra pixels
        float blend = (radius + 2f) / radius - 1f;

        // Center of the color wheel circle
        int cx = w / 2;
        int cy = h / 2;

        float maxR = colorSpace.getMaxValue(radialIndex);
        float minR = colorSpace.getMinValue(radialIndex);
        float extentR = maxR - minR;
        float maxA = colorSpace.getMaxValue(angularIndex);
        float minA = colorSpace.getMinValue(angularIndex);
        float extentA = maxA - minA;

        for (int x = 0; x < w; x++) {
            int kx = x - cx; // Kartesian coordinates of x
            int squarekx = kx * kx; // Square of kartesian x

            for (int y = 0; y < h; y++) {
                int ky = cy - y; // Kartesian coordinates of y

                int index = x + y * w;
                float radiusRatio = (float) (Math.sqrt(squarekx + ky * ky) / radius);
                if (radiusRatio <= 1f) {
                    alphas[index] = 0xff000000;
                    radials[index] = radiusRatio * extentR + minR;
                } else {
                    alphas[index] = (int) ((blend - Math.min(blend, radiusRatio - 1f)) * 255 / blend) << 24;
                    radials[index] = maxR;
                }
                if (alphas[index] != 0) {
                    angulars[index] = (float) (Math.atan2(ky, kx) / Math.PI / 2d) * extentA + minA;
                }
            }
        }
        isLookupValid = true;
    }

    @Override
    public void generateColorWheel() {
        if (!isLookupValid) {
            generateLookupTables();
        }

        float[] components = new float[colorSpace.getNumComponents()];
        for (int index = 0; index < pixels.length; index++) {
            if (alphas[index] != 0) {
                components[angularIndex] = angulars[index];
                components[radialIndex] = radials[index];
                components[verticalIndex] = verticalValue;
                pixels[index] = alphas[index] | 0xffffff & ColorUtil.toRGB(colorSpace, components);
            }
        }
        newPixels();
        isPixelsValid = true;
    }

    @Override
    public Point getColorLocation(Color c) {
        float[] hsb = ColorUtil.fromColor(colorSpace, c);
        return getColorLocation(hsb);
    }

    @Override
    public Point getColorLocation(float[] components) {
        float radial = (components[radialIndex] - colorSpace.getMinValue(radialIndex))//
                / (colorSpace.getMaxValue(radialIndex) - colorSpace.getMinValue(radialIndex));
        float angular = (components[angularIndex] - colorSpace.getMinValue(angularIndex))//
                / (colorSpace.getMaxValue(angularIndex) - colorSpace.getMinValue(angularIndex));


        float radius = Math.min(w, h) / 2f;
        radial = Math.max(0f, Math.min(1f, radial));
        Point p = new Point(
                w / 2 + (int) (radius * radial * Math.cos(angular * Math.PI * 2d)),
                h / 2 - (int) (radius * radial * Math.sin(angular * Math.PI * 2d)));
        return p;
    }

    @Override
    public float[] getColorAt(int x, int y) {
        x -= w / 2;
        y -= h / 2;
        float r = (float) Math.sqrt(x * x + y * y);
        float theta = (float) Math.atan2(y, -x);

        float angular = (float) (0.5 + (theta / Math.PI / 2d));
        float radial=Math.min(1f, (float) r / getRadius());

        float[] hsb = new float[3];
        hsb[angularIndex] = angular//
                * (colorSpace.getMaxValue(angularIndex) - colorSpace.getMinValue(angularIndex))//
                + colorSpace.getMinValue(angularIndex);
        hsb[radialIndex] = radial//
                * (colorSpace.getMaxValue(radialIndex) - colorSpace.getMinValue(radialIndex))//
                + colorSpace.getMinValue(radialIndex);
        hsb[verticalIndex] = verticalValue;
        return hsb;
    }
}
