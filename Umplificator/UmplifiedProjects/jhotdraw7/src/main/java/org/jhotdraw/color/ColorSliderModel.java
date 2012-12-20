/**
 * @(#)ColorSliderModel.java
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
import java.awt.color.ColorSpace;
import javax.swing.BoundedRangeModel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

/**
 * ColorSliderModel.
 * <p>
 * Colors are represented as arrays of color components represented as
 * BoundedRangeModel's. Each BoundedRangeModel can be visualized using a JSlider
 * having a ColorSliderUI.
 *
 * @author Werner Randelshofer
 * @version $Id: ColorSliderModel.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface ColorSliderModel {
    /**
     * Returns the ColorSpace used by this ColorSliderModel.
     * 
     * @return ColorSpace.
     */
    public ColorSpace getColorSpace();
    /**
     * Changes the ColorSpace used by this ColorSliderModel.
     * 
     * @param newValue ColorSpace.
     */
    public void setColorSpace(ColorSpace newValue);
    /**
     * Returns the number of components used by this ColorSliderModel.
     * 
     * @return Component count.
     */
    public int getComponentCount();
    /**
     * Returns the BoundedRangeModel used for the specified component
     * index.
     * 
     * @param componentIndex .
     * 
     * @return BoundedRangeModel.
     */
    public BoundedRangeModel getBoundedRangeModel(int componentIndex);
    
    /**
     * Returns an RGB value based on the value of the specified component index
     * and value, based on the values of all other components of the model.
     * 
     * @param componentIndex
     * @param componentValue
     * @return RGB value.
     */
    public int getInterpolatedRGB(int componentIndex, float componentValue);
    
    /**
     * Sets a value for an individual component.
     * 
     * @param componentIndex
     * @param newValue
     */
    public void setComponent(int componentIndex, float newValue);
    /**
     * Gets a value of an individual component.
     * 
     * @param componentIndex
     * @return Value
     */
    public float getComponent(int componentIndex);
    /**
     * Gets all component values.
     *
     * @return Values.
     */
    public float[] getComponents();
    
    public void addChangeListener(ChangeListener l);

    public void removeChangeListener(ChangeListener l);
    
    /**
     * Configures a JSlider.
     */
    public void configureSlider(int componentIndex, JSlider slider);
    /**
     * Unconfigures a JSlider.
     */
    public void unconfigureSlider(JSlider slider);
    
    /**
     * Returns the color value of the model.
     * This is a convenience method for calling getCompositeColor().getColor().
     * 
     * @return color.
     */
    public Color getColor();
    /**
     * Sets the color value of the model.
     * This is a convenience method for calling setCompositeColor(new CompositeColor(getColorSpace(), color.getRGB());
     * 
     * @param newValue .
     */
    public void setColor(Color newValue);
}
