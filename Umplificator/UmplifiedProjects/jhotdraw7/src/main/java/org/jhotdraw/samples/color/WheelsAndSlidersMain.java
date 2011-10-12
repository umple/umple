/**
 * @(#)WheelsAndSlidersMain.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.color;

import org.jhotdraw.color.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.color.ICC_ColorSpace;
import java.awt.color.ICC_Profile;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * A demo of color wheels and color sliders using all kinds of color systems.
 *
 * @author Werner Randelshofer
 * @version $Id: WheelsAndSlidersMain.java 736 2011-02-02 17:11:03Z rawcoder $
 */
public class WheelsAndSlidersMain extends javax.swing.JPanel {

    private Color color;
    private JLabel colorLabel;
    private LinkedList<ColorSliderModel> models;

    private class Handler implements ChangeListener {

        private int adjusting;

        @Override
        public void stateChanged(ChangeEvent e) {
            if (adjusting++ == 0) {
                ColorSliderModel m = (ColorSliderModel) e.getSource();
                color = m.getColor();
                previewLabel.setBackground(color);
                for (ColorSliderModel c : models) {
                    if (c != m) {
                        if (c.getColorSpace().equals(m.getColorSpace())) {
                            // If the color system is the same, directly set the components (=lossless)
                            for (int i = 0; i < m.getComponentCount(); i++) {
                                c.setComponent(i, m.getComponent(i));
                            }
                        } else {
                            // If the color system is different, set the RGB color (=lossy)
                            c.setColor(color);
                        }
                    }
                }
            }
            adjusting--;
        }
    }
    private Handler handler;

    /** Creates new form. */
    public WheelsAndSlidersMain() {
        initComponents();

        models = new LinkedList<ColorSliderModel>();
        handler = new Handler();

        previewLabel.setOpaque(true);

//        chooserPanel.add(createColorWheelChooser(new HSVRGBColorSpace()));
        chooserPanel.add(createColorWheelChooser(HSBColorSpace.getInstance()));
        chooserPanel.add(createColorWheelChooser(HSVColorSpace.getInstance(),1,0,2,JColorWheel.Type.SQUARE,false,false));
        chooserPanel.add(createColorWheelChooser(HSLColorSpace.getInstance()));
        chooserPanel.add(createColorWheelChooser(HSLColorSpace.getInstance(), 0, 2, 1));
        CIELABColorSpace cielab=new CIELABColorSpace();
        cielab.setOutsideGamutHandling(CIELABColorSpace.OutsideGamutHandling.LEAVE_OUTSIDE);
        chooserPanel.add(createColorWheelChooser(cielab,1,2,0,JColorWheel.Type.COMPLEX));
  //      chooserPanel.add(new JPanel());
        chooserPanel.add(createColorWheelChooser(HSVPhysiologicColorSpace.getInstance()));
        chooserPanel.add(createColorWheelChooser(HSLPhysiologicColorSpace.getInstance()));
        chooserPanel.add(createColorWheelChooser(HSLPhysiologicColorSpace.getInstance(), 0, 2, 1));
        chooserPanel.add(createColorWheelChooser(ICC_ColorSpace.getInstance(ICC_ColorSpace.CS_LINEAR_RGB),0,1,2,JColorWheel.Type.SQUARE));
        chooserPanel.add(createColorWheelChooser(ICC_ColorSpace.getInstance(ICC_ColorSpace.CS_CIEXYZ),1,0,2,JColorWheel.Type.SQUARE));
        chooserPanel.add(createColorWheelChooser(ICC_ColorSpace.getInstance(ICC_ColorSpace.CS_PYCC),1,2,0,JColorWheel.Type.SQUARE));
        chooserPanel.add(new JPanel());
        chooserPanel.add(createColorWheelChooser(ICC_ColorSpace.getInstance(ICC_ColorSpace.CS_sRGB),0,1,2,JColorWheel.Type.SQUARE));
        
        try {
            chooserPanel.add(createColorWheelChooser(new ICC_ColorSpace(ICC_Profile.getInstance(WheelsAndSlidersMain.class.getResourceAsStream("/org/jhotdraw/color/Munsell CIELab_to_UPLab.icc"))), 2, 1, 0, JColorWheel.Type.SQUARE));
            chooserPanel.add(createColorWheelChooser(new ICC_ColorSpace(ICC_Profile.getInstance(WheelsAndSlidersMain.class.getResourceAsStream("/org/jhotdraw/color/Munsell CIELab_to_UPLab2.icc"))), 2, 1, 0, JColorWheel.Type.SQUARE));
        } catch (Throwable ex) {
            ex.printStackTrace();
        }
//      chooserPanel.add(createColorWheelChooser("Munsell CIELab_to_UPLab.icc","Munsell UP LAB"),2,1,0,JColorWheel.Type.COMPLEX));
        chooserPanel.add(createSliderChooser(ColorSpace.getInstance(ColorSpace.CS_sRGB)));
        chooserPanel.add(createSliderChooser(CMYKGenericColorSpace.getInstance()));
        chooserPanel.add(createSliderChooser(CMYKNominalColorSpace.getInstance()));
 //       chooserPanel.add(createSliderChooser("Munsell CIELab_to_UPLab.icc","Munsell UP LAB")));
    }

    private JPanel createColorWheelChooser(ColorSpace sys) {
        return createColorWheelChooser(sys, 0, 1, 2);
    }

    private JPanel createColorWheelChooser(ColorSpace sys, int angularIndex, int radialIndex, int verticalIndex) {
        return createColorWheelChooser(sys, angularIndex, radialIndex, verticalIndex, JColorWheel.Type.POLAR);
    }
    private JPanel createColorWheelChooser(ColorSpace sys, int angularIndex, int radialIndex, int verticalIndex, JColorWheel.Type type) {
        return createColorWheelChooser(sys, angularIndex, radialIndex, verticalIndex, type,false,false);
    }
    private JPanel createColorWheelChooser(ColorSpace sys, int angularIndex, int radialIndex, int verticalIndex, JColorWheel.Type type, boolean flipX,boolean flipY) {
        JPanel p = new JPanel(new BorderLayout());
        DefaultColorSliderModel m = new DefaultColorSliderModel(sys);
        models.add(m);
        m.addChangeListener(handler);
        JColorWheel w = new JColorWheel();
        w.setType(type);
        w.setAngularComponentIndex(angularIndex);
        w.setRadialComponentIndex(radialIndex);
        w.setVerticalComponentIndex(verticalIndex);
w.setFlipX(flipX);
w.setFlipY(flipY);
        w.setModel(m);
        JSlider s = new JSlider(JSlider.VERTICAL);
        m.configureSlider(verticalIndex, s);
        p.add(new JLabel("<html>" + ColorUtil.getName(sys) + "<br>α:" + angularIndex + " r:" + radialIndex + " v:" + verticalIndex), BorderLayout.NORTH);
        p.add(w, BorderLayout.CENTER);
        p.add(s, BorderLayout.EAST);
        return p;
    }

    private JPanel createSliderChooser(ColorSpace sys) {
        return createSliderChooser(sys, false);
    }

    private JPanel createSliderChooser(ColorSpace sys, boolean vertical) {
        JPanel p = new JPanel(new GridLayout(vertical ? 1 : 0, vertical ? 0 : 1));
        DefaultColorSliderModel m = new DefaultColorSliderModel(sys);

        models.add(m);
        if (!vertical) {
            p.add(new JLabel(
                    "<html>" + ColorUtil.getName(sys)), BorderLayout.NORTH);
        }
        m.addChangeListener(handler);

        for (int i = 0;
                i < m.getComponentCount();
                i++) {
            JSlider s = new JSlider(JSlider.HORIZONTAL);
            s.setMajorTickSpacing(50);
            s.setPaintTicks(true);
            s.setOrientation(vertical ? JSlider.VERTICAL : JSlider.HORIZONTAL);
            m.configureSlider(i, s);
            p.add(s);
        }
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame("Color Wheels, Squares and Sliders");
                f.add(new WheelsAndSlidersMain());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setVisible(true);


            }
        });


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooserPanel = new javax.swing.JPanel();
        previewLabel = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        chooserPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        chooserPanel.setLayout(new java.awt.GridLayout(0, 4, 10, 10));
        add(chooserPanel, java.awt.BorderLayout.CENTER);

        previewLabel.setText("Selected Color");
        add(previewLabel, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chooserPanel;
    private javax.swing.JLabel previewLabel;
    // End of variables declaration//GEN-END:variables
}
