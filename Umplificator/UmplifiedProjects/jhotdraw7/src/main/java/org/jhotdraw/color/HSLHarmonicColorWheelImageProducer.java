/**
 * @(#)HSLHarmonicColorWheelImageProducer.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
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

/**
 * HSLHarmonicColorWheelImageProducer.
 *
 * @author Werner Randelshofer
 * @version $Id: HSLHarmonicColorWheelImageProducer.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class HSLHarmonicColorWheelImageProducer extends PolarColorWheelImageProducer {

    private float[] brights;
    private boolean isDiscrete = true;

    public HSLHarmonicColorWheelImageProducer(int w, int h) {
        super(HSLPhysiologicColorSpace.getInstance(), w, h);
    }

    public HSLHarmonicColorWheelImageProducer(ColorSpace sys, int w, int h) {
        super(sys, w, h);
    }

    @Override
    protected void generateLookupTables() {
        isDiscrete = false;
        if (isDiscrete) {
            generateDiscreteLookupTables();
        } else {
            generateContiguousLookupTables();
        }
    }

    protected void generateContiguousLookupTables() {
        radials = new float[w * h];
        angulars = new float[w * h];
        brights = new float[w * h];
        alphas = new int[w * h];
        float radius = getRadius();

        // blend is used to create a linear alpha gradient of two extra pixels
        float blend = (radius + 2f) / radius - 1f;

        // Center of the color wheel circle
        int cx = w / 2;
        int cy = h / 2;

        for (int x = 0; x < w; x++) {
            int kx = x - cx; // Kartesian coordinates of x
            int squarekx = kx * kx; // Square of kartesian x

            for (int y = 0; y < h; y++) {
                int ky = cy - y; // Kartesian coordinates of y

                int index = x + y * w;
                float r = (float) Math.sqrt(squarekx + ky * ky) / radius;
                float sat = r;
                if (r <= 1f) {
                    alphas[index] = 0xff000000;
                    radials[index] = 1f;
                    brights[index] = 1f - sat;
                } else {
                    alphas[index] = (int) ((blend - Math.min(blend, r - 1f)) * 255 / blend) << 24;
                    radials[index] = 1f;
                    brights[index] = 0;
                }
                if (alphas[index] != 0) {
                    angulars[index] = (float) (Math.atan2(ky, kx) / Math.PI / 2d);
                }
            }
        }
    }

    protected void generateDiscreteLookupTables() {
        radials = new float[w * h];
        angulars = new float[w * h];
        brights = new float[w * h];
        alphas = new int[w * h];
        float radius = getRadius();

        // blend is used to create a linear alpha gradient of two extra pixels
        float blend = (radius + 2f) / radius - 1f;

        // Center of the color wheel circle
        int cx = w / 2;
        int cy = h / 2;
        for (int x = 0; x < w; x++) {
            int kx = x - cx; // Kartesian coordinates of x
            int squarekx = kx * kx; // Square of kartesian x

            for (int y = 0; y < h; y++) {
                int ky = cy - y; // Kartesian coordinates of y

                int index = x + y * w;
                float r = (float) Math.sqrt(squarekx + ky * ky) / radius;
                float sat = r;
                if (r <= 1f) {
                    alphas[index] = 0xff000000;
                    radials[index] = 1f;
                    brights[index] = (float) Math.round((1f - sat) * 12f) / 12f;
                } else {
                    alphas[index] = (int) ((blend - Math.min(blend, r - 1f)) * 255 / blend) << 24;
                    radials[index] = 1f;
                    brights[index] = 0f;
                }
                if (alphas[index] != 0) {
                    angulars[index] = Math.round((float) (Math.atan2(ky, kx) / Math.PI / 2d) * 12f) / 12f;
                }
            }
        }
    }

    @Override
    public void generateColorWheel() {
        for (int index = 0; index < pixels.length; index++) {
            if (alphas[index] != 0) {
                pixels[index] = alphas[index] | 0xffffff & ColorUtil.toRGB(colorSpace, angulars[index], radials[index], brights[index]);
            }
        }
        newPixels();
        isPixelsValid = false;
    }

    @Override
    public Point getColorLocation(Color c) {
        float[] hsb = ColorUtil.fromColor(colorSpace, c);
        return getColorLocation(hsb);
    }

    @Override
    public Point getColorLocation(float[] hsb) {
        float hue = hsb[0];
        float brightness = hsb[2];
        float radius = Math.min(w, h) / 2f;

        brightness = Math.max(0f, Math.min(1f, brightness));

        Point p;
        p = new Point(
                w / 2 + (int) ((radius - radius * brightness) * Math.cos(hue * Math.PI * 2d)),
                h / 2 - (int) ((radius - radius * brightness) * Math.sin(hue * Math.PI * 2d)));
        return p;
    }

    @Override
    public float[] getColorAt(int x, int y) {
        x -= w / 2;
        y -= h / 2;
        float r = (float) Math.sqrt(x * x + y * y);
        float theta = (float) Math.atan2(-y, x);
        float radius = Math.min(w, h) / 2f;

        float[] hsb;
        float sat = (float) r / radius;
        float hue = (float) (theta / Math.PI / 2d);
        if (hue < 0) {
            hue += 1f;
        }
        hsb = new float[]{
                    hue,
                    1f,
                    1f - sat
                };

        return hsb;
    }
}
