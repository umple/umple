/*
 * @(#)PaletteRGBChooser.java
 *
 * Copyright (c) 2005-2010 Werner Randelshofer
 * Hausmatt 10, Immensee, CH-6405, Switzerland.
 * All rights reserved.
 *
 * The copyright of this software is owned by Werner Randelshofer. 
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * Werner Randelshofer. For details see accompanying license terms. 
 */
package org.jhotdraw.gui.plaf.palette.colorchooser;

import java.awt.*;
import java.awt.color.ICC_ColorSpace;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.colorchooser.*;
import javax.swing.plaf.*;
import org.jhotdraw.color.ColorSliderModel;
import org.jhotdraw.gui.plaf.palette.PaletteLabelUI;
import org.jhotdraw.gui.plaf.palette.PaletteLookAndFeel;
import org.jhotdraw.gui.plaf.palette.PalettePanelUI;
import org.jhotdraw.gui.plaf.palette.PaletteTextFieldUI;

/**
 * PaletteRGBChooser.
 *
 * @author  Werner Randelshofer
 * @version $Id$
 */
public class PaletteRGBChooser extends AbstractColorChooserPanel implements UIResource {

    private ColorSliderModel ccModel = new PaletteColorSliderModel(ICC_ColorSpace.getInstance(ICC_ColorSpace.CS_sRGB));
    private int updateRecursion;
    private PaletteLookAndFeel labels;

    /** Creates new form. */
    public PaletteRGBChooser() {
    }

    @Override
    protected void buildChooser() {
        labels = PaletteLookAndFeel.getInstance();
        initComponents();
        PaletteLookAndFeel plaf = PaletteLookAndFeel.getInstance();

        setUI(PalettePanelUI.createUI(this));
        redLabel.setUI((LabelUI) PaletteLabelUI.createUI(redLabel));
        greenLabel.setUI((LabelUI) PaletteLabelUI.createUI(greenLabel));
        blueLabel.setUI((LabelUI) PaletteLabelUI.createUI(blueLabel));
        redField.setUI((TextUI) PaletteTextFieldUI.createUI(redField));
        greenField.setUI((TextUI) PaletteTextFieldUI.createUI(greenField));
        blueField.setUI((TextUI) PaletteTextFieldUI.createUI(blueField));

        ccModel.getBoundedRangeModel(0).setMaximum(255);
        ccModel.getBoundedRangeModel(1).setMaximum(255);
        ccModel.getBoundedRangeModel(2).setMaximum(255);

        //
        Font font = plaf.getFont("ColorChooser.font");
        redLabel.setFont(font);
        redSlider.setFont(font);
        redField.setFont(font);
        greenLabel.setFont(font);
        greenSlider.setFont(font);
        greenField.setFont(font);
        blueLabel.setFont(font);
        blueSlider.setFont(font);
        blueField.setFont(font);
        //
        int textSliderGap = plaf.getInt("ColorChooser.textSliderGap");
        if (textSliderGap != 0) {
            Insets fieldInsets = new Insets(0, textSliderGap, 0, 0);
            GridBagLayout layout = (GridBagLayout) getLayout();
            GridBagConstraints gbc;
            gbc = layout.getConstraints(redField);
            gbc.insets = fieldInsets;
            layout.setConstraints(redField, gbc);
            gbc = layout.getConstraints(greenField);
            gbc.insets = fieldInsets;
            layout.setConstraints(greenField, gbc);
            gbc = layout.getConstraints(blueField);
            gbc.insets = fieldInsets;
            layout.setConstraints(blueField, gbc);
        }

        ccModel.configureSlider(0, redSlider);
        ccModel.configureSlider(1, greenSlider);
        ccModel.configureSlider(2, blueSlider);

        redField.setText(Integer.toString(redSlider.getValue()));
        greenField.setText(Integer.toString(greenSlider.getValue()));
        blueField.setText(Integer.toString(blueSlider.getValue()));

        new ColorSliderTextFieldHandler(redField, ccModel, 0);
        new ColorSliderTextFieldHandler(greenField, ccModel, 1);
        new ColorSliderTextFieldHandler(blueField, ccModel, 2);

        ccModel.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent evt) {
                if (updateRecursion++ == 0) {
                    //setColorToModel(ccModel.getColor());
                    setColorToModel(new Color(
                            ccModel.getBoundedRangeModel(0).getValue(),
                            ccModel.getBoundedRangeModel(1).getValue(),
                            ccModel.getBoundedRangeModel(2).getValue()
                            ));
                }
                updateRecursion--;
            }
        });
        redField.setMinimumSize(redField.getPreferredSize());
        greenField.setMinimumSize(greenField.getPreferredSize());
        blueField.setMinimumSize(blueField.getPreferredSize());
        EmptyBorder bm = new EmptyBorder(0,0,0,0);
        redLabel.setBorder(bm);
        greenLabel.setBorder(bm);
        blueLabel.setBorder(bm);
    }

    @Override
    public String getDisplayName() {
        return PaletteLookAndFeel.getInstance().getString("ColorChooser.rgbSliders");
    }

    @Override
    public Icon getLargeDisplayIcon() {
        return PaletteLookAndFeel.getInstance().getIcon("ColorChooser.colorSlidersIcon");
    }

    @Override
    public Icon getSmallDisplayIcon() {
        return getLargeDisplayIcon();
    }

    @Override
    public void updateChooser() {
        updateRecursion++;
        ccModel.setColor(getColorFromModel());
        updateRecursion--;
    }

    public void setColorToModel(Color color) {
        getColorSelectionModel().setSelectedColor(color);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        redLabel = new javax.swing.JLabel();
        redSlider = new javax.swing.JSlider();
        redField = new javax.swing.JTextField();
        greenLabel = new javax.swing.JLabel();
        greenSlider = new javax.swing.JSlider();
        greenField = new javax.swing.JTextField();
        blueLabel = new javax.swing.JLabel();
        blueSlider = new javax.swing.JSlider();
        blueField = new javax.swing.JTextField();
        springPanel = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        redLabel.setText(labels.getString("ColorChooser.rgbRedText")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, -4, 0);
        add(redLabel, gridBagConstraints);

        redSlider.setMajorTickSpacing(255);
        redSlider.setMaximum(255);
        redSlider.setMinorTickSpacing(128);
        redSlider.setPaintTicks(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        add(redSlider, gridBagConstraints);

        redField.setColumns(3);
        redField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        redField.setText("0");
        redField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                redFieldFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        add(redField, gridBagConstraints);

        greenLabel.setText(labels.getString("ColorChooser.rgbGreenText")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, -4, 0);
        add(greenLabel, gridBagConstraints);

        greenSlider.setMajorTickSpacing(255);
        greenSlider.setMaximum(255);
        greenSlider.setMinorTickSpacing(128);
        greenSlider.setPaintTicks(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        add(greenSlider, gridBagConstraints);

        greenField.setColumns(3);
        greenField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        greenField.setText("0");
        greenField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                greenFieldFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        add(greenField, gridBagConstraints);

        blueLabel.setText(labels.getString("ColorChooser.rgbBlueText")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, -4, 0);
        add(blueLabel, gridBagConstraints);

        blueSlider.setMajorTickSpacing(255);
        blueSlider.setMaximum(255);
        blueSlider.setMinorTickSpacing(128);
        blueSlider.setPaintTicks(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        add(blueSlider, gridBagConstraints);

        blueField.setColumns(3);
        blueField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        blueField.setText("0");
        blueField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                blueFieldFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        add(blueField, gridBagConstraints);

        springPanel.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 100;
        gridBagConstraints.weighty = 1.0;
        add(springPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void fieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldFocusGained
        ((JTextField) evt.getSource()).selectAll();
    }//GEN-LAST:event_fieldFocusGained

    private void blueFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_blueFieldFocusLost
        blueField.setText(Integer.toString(ccModel.getBoundedRangeModel(2).getValue()));
    }//GEN-LAST:event_blueFieldFocusLost

    private void greenFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_greenFieldFocusLost
        greenField.setText(Integer.toString(ccModel.getBoundedRangeModel(1).getValue()));
    }//GEN-LAST:event_greenFieldFocusLost

    private void redFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_redFieldFocusLost
        redField.setText(Integer.toString(ccModel.getBoundedRangeModel(0).getValue()));
    }//GEN-LAST:event_redFieldFocusLost
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField blueField;
    private javax.swing.JLabel blueLabel;
    private javax.swing.JSlider blueSlider;
    private javax.swing.JTextField greenField;
    private javax.swing.JLabel greenLabel;
    private javax.swing.JSlider greenSlider;
    private javax.swing.JTextField redField;
    private javax.swing.JLabel redLabel;
    private javax.swing.JSlider redSlider;
    private javax.swing.JPanel springPanel;
    // End of variables declaration//GEN-END:variables
}
