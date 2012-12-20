/**
 * @(#)DefaultHarmonicColorModel.java
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
import java.beans.*;
import java.util.ArrayList;
import javax.swing.*;
import static org.jhotdraw.color.HarmonicColorModel.*;

/**
 * DefaultHarmonicColorModel.
 *
 * @author Werner Randelshofer
 * @version $Id: DefaultHarmonicColorModel.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class DefaultHarmonicColorModel extends AbstractListModel implements HarmonicColorModel, Cloneable {

    protected PropertyChangeSupport propertySupport = new PropertyChangeSupport(this);
    private ArrayList<Color> colors;
    private ColorSliderModel sliderModel;
    private int base;
    private ArrayList<HarmonicRule> rules;
    private float customHueConstraint = 30f / 360f;
    private int adjusting;

    public DefaultHarmonicColorModel() {
        ColorSpace sys = HSLPhysiologicColorSpace.getInstance();
        sliderModel = new DefaultColorSliderModel(sys);
        colors = new ArrayList<Color>();
        rules = new ArrayList<HarmonicRule>();

        base = 0;
        add(Color.RED);

        DefaultListModel x;
    }

    @Override
    public void setSize(int newValue) {
        int oldSize = size();
        while (colors.size() > newValue) {
            colors.remove(colors.size() - 1);
        }
        while (colors.size() < newValue) {
            colors.add(null);
        }

        if (oldSize < newValue) {
            fireIntervalRemoved(this, oldSize, newValue - 1);
        } else if (oldSize > newValue) {
            fireIntervalRemoved(this, newValue, oldSize - 1);
        }
    }

    @Override
    public int size() {
        return colors.size();
    }

    @Override
    public boolean isAdjusting() {
        return adjusting > 0;
    }

    @Override
    public void set(int index, Color newValue) {
        adjusting++;
        Color oldValue = colors.set(index, newValue);
        for (HarmonicRule r : rules) {
            r.colorChanged(this, index, oldValue, newValue);
        }
        for (HarmonicRule r : rules) {
            if (r.getBaseIndex() == index) {
                r.apply(this);
            }
        }
        adjusting--;
        fireContentsChanged(this, index, index);
    }
    
    @Override
    public void applyRules() {
        for (HarmonicRule r : rules) {
            if (r.getBaseIndex() == base) {
                r.apply(this);
            }
        }
    }

    @Override
    public Color get(int index) {
        return colors.get(index);
    }

    @Override
    public boolean add(Color c) {
        boolean b = colors.add(c);
        if (b) {
            fireIntervalAdded(this, size() - 1, size() - 1);
        }
        return b;
    }

    @Override
    public void setBase(int newValue) {
        base = newValue;
    }

    @Override
    public int getBase() {
        return base;
    }

    @Override
    public float[] RGBtoComponent(int rgb, float[] hsb) {
        return ColorUtil.fromColor(sliderModel.getColorSpace(), new Color(rgb));
    }

    @Override
    public int componentToRGB(float h, float s, float b) {
        return ColorUtil.toRGB(sliderModel.getColorSpace(), h,s,b);
    }

    @Override
    public int getSize() {
        return size();
    }

    @Override
    public Object getElementAt(int index) {
        return get(index);
    }

    @Override
    public ColorSpace getColorSpace() {
        return sliderModel.getColorSpace();
    }

    @Override
    public void addRule(HarmonicRule newValue) {
        rules.add(newValue);
    }

    @Override
    public void removeAllRules() {
        rules.clear();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(propertyName, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(propertyName, listener);
    }

    protected void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
        propertySupport.firePropertyChange(propertyName, oldValue, newValue);
    }

    protected void firePropertyChange(String propertyName, int oldValue, int newValue) {
        propertySupport.firePropertyChange(propertyName, oldValue, newValue);
    }

    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertySupport.firePropertyChange(propertyName, oldValue, newValue);
    }

    @Override
    public DefaultHarmonicColorModel clone() {
        DefaultHarmonicColorModel that;
        try {
            that = (DefaultHarmonicColorModel) super.clone();
        } catch (CloneNotSupportedException ex) {
            InternalError error = new InternalError("Clone failed");
            error.initCause(ex);
            throw error;
        }
        that.propertySupport = new PropertyChangeSupport(that);
        return that;
    }

    @Override
    public void setColorSpace(ColorSpace newValue) {
        ColorSpace oldValue = sliderModel.getColorSpace();
        sliderModel.setColorSpace(newValue);
        firePropertyChange(COLOR_SPACE_PROPERTY, oldValue, newValue);
        for (int i = 0; i < colors.size(); i++) {
            if (get(i) != null) {
                set(i, new Color(newValue, ColorUtil.fromColor(newValue,get(i)),1f));
            }
        }
        fireContentsChanged(this, 0, size() - 1);
    }
}
