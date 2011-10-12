/**
 * @(#)HarmonicColorWheelImageProducer.java
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

/**
 * HarmonicColorWheelImageProducer.
 *
 * @author Werner Randelshofer
 * @version $Id: HSVHarmonicColorWheelImageProducer.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class HSVHarmonicColorWheelImageProducer extends PolarColorWheelImageProducer {

    private float wheelScaleFactor;
    private float[] brights;
    private boolean isDiscrete = true;

    public HSVHarmonicColorWheelImageProducer(int w, int h) {
        super(HSVPhysiologicColorSpace.getInstance(), w, h);
    }

    @Override
    protected void generateLookupTables() {
        wheelScaleFactor = 1.35f;
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
                float sat = r * wheelScaleFactor;
                if (r <= 1f) {
                    alphas[index] = 0xff000000;
                    //radials[index] = Math.min(1f, sat * 2f);
                    //brights[index] = Math.min(1f, 2f - sat * 2f);
                    radials[index] = Math.min(1f, sat * 2f);
                    brights[index] = Math.min(1f, 1.5f - sat);
                } else {
                    alphas[index] = (int) ((blend - Math.min(blend, r - 1f)) * 255 / blend) << 24;
                    radials[index] = 1f;
                    //brights[index] = 0f;
                    brights[index] = Math.max(0, Math.min(1f, 1.5f - sat));
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
                float sat = r * wheelScaleFactor;
                if (r <= 1f) {
                    alphas[index] = 0xff000000;
                    radials[index] = (float) Math.round(Math.min(1f, sat * 2f) * 5f) / 5f;
                    brights[index] = (float) Math.round(Math.min(1f, 1.5f - sat) * 10f) / 10f;
                } else {
                    alphas[index] = (int) ((blend - Math.min(blend, r - 1f)) * 255 / blend) << 24;
                    radials[index] = 1f;
                    brights[index] = Math.max(0, Math.round(Math.min(1f, 1.5f - sat * 1f) * 10f) / 10f);
                //brights[index] = 0f;
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
                pixels[index] = alphas[index] | 0xffffff & ColorUtil.toRGB(colorSpace,angulars[index], radials[index], brights[index]);
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
        float hue=hsb[0]; float saturation=hsb[1]; float brightness=hsb[2];
        float radius = Math.min(w, h) / 2f;
        float radiusH = radius / 2f;

        saturation = Math.max(0f, Math.min(1f, saturation));
        brightness = Math.max(0f, Math.min(1f, brightness));
        
        Point p;
        if (brightness == 1f) {
            p = new Point(
                    w / 2 + (int) (radiusH * saturation * Math.cos(hue * Math.PI * 2d) / wheelScaleFactor),
                    h / 2 - (int) (radiusH * saturation * Math.sin(hue * Math.PI * 2d) / wheelScaleFactor));

        } else {
            p = new Point(
                    w / 2 + (int) ((radius + radiusH - radius * brightness) * Math.cos(hue * Math.PI * 2d) / wheelScaleFactor),
                    h / 2 - (int) ((radius + radiusH - radius * brightness) * Math.sin(hue * Math.PI * 2d) / wheelScaleFactor));

        }
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
        float sat = (float) r / radius * wheelScaleFactor;
        float hue = (float) (theta / Math.PI / 2d);
        if (hue < 0) {
            hue += 1f;
        }
        hsb = new float[]{
            hue,
            Math.min(1f, sat * 2f),
            //Math.min(1f, 2f - sat * 2f)
            Math.min(1f, 1.5f - sat)
        };

        return hsb;
    }
}
