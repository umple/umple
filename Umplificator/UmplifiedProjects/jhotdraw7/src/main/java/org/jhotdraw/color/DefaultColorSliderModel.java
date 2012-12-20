/**
 * @(#)DefaultColorSliderModel.java
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
import java.awt.color.ICC_ColorSpace;
import java.util.LinkedList;
import javax.swing.*;
import javax.swing.event.*;

/**
 * DefaultColorSliderModel.
 *
 * @author Werner Randelshofer
 * @version $Id: DefaultColorSliderModel.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class DefaultColorSliderModel extends AbstractColorSlidersModel {

    protected ColorSpace colorSpace;
    /**
     * JSlider's associated to this model.
     */
    protected LinkedList<JSlider> sliders = new LinkedList<JSlider>();
    /**
     * Components of the color model.
     */
    protected DefaultBoundedRangeModel[] componentModels;

    /** Creates a color slider model with an ICC sRGB color space. */
    public DefaultColorSliderModel() {
        setColorSpace(ICC_ColorSpace.getInstance(ICC_ColorSpace.CS_sRGB));
    }

    /** Creates a color slider model with the specified color space. */
    public DefaultColorSliderModel(ColorSpace sys) {
        setColorSpace(sys);
    }

    @Override
    public void setColorSpace(ColorSpace newValue) {
        ColorSpace oldValue = colorSpace;
        colorSpace = newValue;
        componentModels = new DefaultBoundedRangeModel[colorSpace.getNumComponents()];

        for (int i = 0; i < componentModels.length; i++) {
            componentModels[i] = new DefaultBoundedRangeModel();
            if ((colorSpace.getMaxValue(i)-colorSpace.getMinValue(i))>=10f) {
                componentModels[i].setMinimum((int)colorSpace.getMinValue(i));
                componentModels[i].setMaximum((int)colorSpace.getMaxValue(i));
            } else {
                componentModels[i].setMinimum((int)(colorSpace.getMinValue(i)*100f));
                componentModels[i].setMaximum((int)(colorSpace.getMaxValue(i)*100f));
            }
            final int componentIndex = i;
            componentModels[i].addChangeListener(
                    new ChangeListener() {

                        @Override
                        public void stateChanged(ChangeEvent e) {
                            fireColorChanged(componentIndex);
                            fireStateChanged();
                        }
                    });
        }
    }

    /**
     * Configures a JSlider for this model.
     * If the JSlider is already configured for another model,
     * it is unconfigured first.
     */
    @Override
    public void configureSlider(int componentIndex, JSlider slider) {
        if (slider.getClientProperty("colorSliderModel") != null) {
            ((DefaultColorSliderModel) slider.getClientProperty("colorSliderModel")).unconfigureSlider(slider);
        }
        if (!(slider.getUI() instanceof ColorSliderUI)) {
            slider.setUI((ColorSliderUI) ColorSliderUI.createUI(slider));
        }
        slider.setModel(getBoundedRangeModel(componentIndex));
        slider.putClientProperty("colorSliderModel", this);
        slider.putClientProperty("colorComponentIndex", componentIndex);
        addColorSlider(slider);
    }

    /**
     * Unconfigures a JSlider from this model.
     */
    @Override
    public void unconfigureSlider(JSlider slider) {
        if (slider.getClientProperty("colorSliderModel") == this) {
            // XXX - This creates a NullPointerException ??
            //slider.setUI((SliderUI) UIManager.getUI(slider));
            slider.setModel(new DefaultBoundedRangeModel());
            slider.putClientProperty("colorSliderModel", null);
            slider.putClientProperty("colorComponentIndex", null);
            removeColorSlider(slider);
        }
    }

    /**
     * Returns the bounded range model of the specified color componentIndex.
     */
    @Override
    public DefaultBoundedRangeModel getBoundedRangeModel(int componentIndex) {
        return componentModels[componentIndex];
    }

    /**
     * Returns the value of the specified color componentIndex.
     */
    public int getSliderValue(int componentIndex) {
        return componentModels[componentIndex].getValue();
    }

    /**
     * Sets the value of the specified color componentIndex.
     */
    public void setSliderValue(int componentIndex, int value) {
        componentModels[componentIndex].setValue(value);
    }

    public void addColorSlider(JSlider slider) {
        sliders.add(slider);
    }

    public void removeColorSlider(JSlider slider) {
        sliders.remove(slider);
    }

    protected void fireColorChanged(int componentIndex) {
        Integer index = componentIndex;
        Color value = getColor();
        for (JSlider slider : sliders) {
            slider.putClientProperty("colorComponentChange", index);
            slider.putClientProperty("colorComponentValue", value);
        }
    }

    @Override
    public ColorSpace getColorSpace() {
        return colorSpace;
    }

    @Override
    public int getComponentCount() {
        return colorSpace.getNumComponents();
    }

    @Override
    public Color getColor() {
        float[] c = new float[getComponentCount()];
        int i = 0;
        for (DefaultBoundedRangeModel brm : componentModels) {
            c[i] = (brm.getValue() - brm.getMinimum())
                    / (float) (brm.getMaximum() - brm.getMinimum())
                    * (colorSpace.getMaxValue(i) - colorSpace.getMinValue(i))
                    + colorSpace.getMinValue(i);
            i++;
        }
        try {
            return ColorUtil.toColor(colorSpace, c);
        } catch (IllegalArgumentException e) {
            for (i = 0; i < c.length; i++) {
                System.err.println(i + "=" + c[i]+" "+colorSpace.getMinValue(i)+".."+colorSpace.getMaxValue(i));
            }
            throw e;
        }
    }

    @Override
    public int getInterpolatedRGB(int i, float componentValue) {
        float[] c = new float[getComponentCount()];
        int j = 0;
        for (DefaultBoundedRangeModel brm : componentModels) {
            c[j] = ((brm.getValue() - brm.getMinimum())
                    / (float) (brm.getMaximum() - brm.getMinimum()))
                    * (colorSpace.getMaxValue(j) - colorSpace.getMinValue(j))
                    + colorSpace.getMinValue(j);
            j++;
        }
        c[i] = componentValue;
        return ColorUtil.toRGB(colorSpace, c);
    }

    @Override
    public void setComponent(int i, float newValue) {
        BoundedRangeModel brm = componentModels[i];
        brm.setValue((int) (((newValue - colorSpace.getMinValue(i))//
                / (colorSpace.getMaxValue(i) - colorSpace.getMinValue(i)))//
                * (brm.getMaximum() - brm.getMinimum())) + brm.getMinimum());
    }

    @Override
    public float getComponent(int i) {
        BoundedRangeModel brm = componentModels[i];
        return (brm.getValue() - brm.getMinimum()) //
                / (float) (brm.getMaximum() - brm.getMinimum())//
                * (colorSpace.getMaxValue(i) - colorSpace.getMinValue(i))//
                + colorSpace.getMinValue(i);
    }

    @Override
    public void setColor(Color newValue) {
        float[] c = ColorUtil.fromColor(colorSpace, newValue);
        int i = 0;
        for (DefaultBoundedRangeModel brm : componentModels) {
            brm.setValue(//
                    (int) (((c[i] - colorSpace.getMinValue(i))//
                    / (colorSpace.getMaxValue(i) - colorSpace.getMinValue(i))) //
                    * (brm.getMaximum() - brm.getMinimum()) + brm.getMinimum()));
            i++;
        }
    }

    @Override
    public float[] getComponents() {
        float[] c = new float[getComponentCount()];
        for (int i = 0; i < c.length; i++) {
            BoundedRangeModel brm = componentModels[i];
            c[i] = (brm.getValue() - brm.getMinimum()) //
                    / (float) (brm.getMaximum() - brm.getMinimum())//
                    * (colorSpace.getMaxValue(i) - colorSpace.getMinValue(i))//
                    + colorSpace.getMinValue(i);
        }
        return c;
    }
}
