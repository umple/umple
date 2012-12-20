/*
 * @(#)ColorTrackImageProducer.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.color;

import java.awt.color.ColorSpace;
import java.awt.image.*;
import javax.swing.*;

/**
 * ColorTrackImageProducer creates the image for the track of a 
 * color slider.
 *
 * @see ColorSliderUI
 *
 * @author  Werner Randelshofer
 * @version $Id: ColorTrackImageProducer.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ColorTrackImageProducer extends MemoryImageSource {
    private int[] pixels;
    private int w, h;
    private int trackBuffer;
    private ColorSliderModel colorizer = new DefaultColorSliderModel(ColorSpace.getInstance(ColorSpace.CS_sRGB));
    private boolean isDirty = true;
    private int componentIndex = 0;
    private boolean isHorizontal;
    
    /** Creates a new instance. */
    public ColorTrackImageProducer(int w, int h, int trackBuffer, boolean isHorizontal) {
        super(w, h, null, 0, w);
        pixels = new int[w*h];
        this.w = w;
        this.h = h;
        // trackBuffer must be even
        this.trackBuffer = ((trackBuffer & 1) == 0) ? trackBuffer : trackBuffer - 1;
        //this.componentIndex = componentIndex;
        this.isHorizontal = isHorizontal;
        newPixels(pixels, new DirectColorModel(24,
					      0x00ff0000,	// Red
					      0x0000ff00,	// Green
					      0x000000ff	// Blue
					      )
					      , 0, w);
        setAnimated(true);
    }
    
    public int getWidth() {
        return w;
    }
    public int getHeight() {
        return h;
    }
    
    public void markAsDirty() {
        isDirty = true;
    }
    
    public boolean needsGeneration() {
        return isDirty;
    }
    
    public void regenerateColorTrack() {
        if (isDirty) {
            generateColorTrack();
        }
    }
    
    public void generateColorTrack() {
        if (isHorizontal) {
            generateHorizontalColorTrack();
        } else {
            generateVerticalColorTrack();
        }
        newPixels();
        isDirty = false;
    }
    
    private void generateHorizontalColorTrack() {
        float[] components = colorizer.getComponents();
        ColorSpace cs = colorizer.getColorSpace();
        int offset = trackBuffer / 2;
        float minv = cs.getMinValue(componentIndex);
        float maxv = cs.getMaxValue(componentIndex);
        for (int x = 0, n = w - trackBuffer - 1; x <= n; x++) {
            components[componentIndex] =  (x / (float) n)*(maxv-minv)+minv;
            pixels[x + offset] = ColorUtil.toRGB(cs,components);
        }
        for (int x=0; x < offset; x++) {
            pixels[x] = pixels[offset];
            pixels[w - x - 1] = pixels[w - offset - 1];
        }
        for (int y=w, n = w*h; y < n; y+=w) {
            System.arraycopy(pixels, 0, pixels, y, w);
        }
    }
    private void generateVerticalColorTrack() {
        float[] components = colorizer.getComponents();
        ColorSpace cs = colorizer.getColorSpace();
        int offset = trackBuffer / 2;
        float minv = cs.getMinValue(componentIndex);
        float maxv = cs.getMaxValue(componentIndex);
        for (int y = 0, n = h - trackBuffer - 1; y <= n; y++) {
            // Note: removed + minv - minv from formula below
            components[componentIndex] =  maxv - (y / (float) n)*(maxv-minv);
            pixels[(y + offset) * w] = ColorUtil.toRGB(cs,components);
        }
        for (int y=0; y < offset; y++) {
            pixels[y * w] = pixels[offset * w];
            pixels[(h - y - 1) * w] = pixels[(h - offset - 1) * w];
        }
        for (int x=1; x < w; x++) {
            for (int y=0, n = w*h; y < n; y+=w) {
                pixels[x + y] = pixels[x - 1 + y];
            }
        }
    }
    
    public void setColorSliderModel(ColorSliderModel colorizer) {
        this.colorizer = colorizer;
        isDirty = true;
    }
    public void setColorComponentIndex(int index) {
        this.componentIndex = index;
        isDirty = true;
    }
    public void componentChanged(int index) {
        isDirty |= this.componentIndex != index;
    }
}
