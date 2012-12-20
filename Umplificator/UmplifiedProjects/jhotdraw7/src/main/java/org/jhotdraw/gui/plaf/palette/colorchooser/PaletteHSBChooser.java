/*
 * @(#)PaletteHSBChooser.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui.plaf.palette.colorchooser;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.colorchooser.*;
import javax.swing.plaf.*;
import org.jhotdraw.color.ColorSliderModel;
import org.jhotdraw.color.HSBColorSpace;
import org.jhotdraw.gui.plaf.palette.PaletteLabelUI;
import org.jhotdraw.gui.plaf.palette.PaletteLookAndFeel;
import org.jhotdraw.gui.plaf.palette.PalettePanelUI;
import org.jhotdraw.gui.plaf.palette.PaletteTextFieldUI;

/**
 * A ColorChooser with HSB sliders.
 *
 * @author  Werner Randelshofer
 * @version $Id$
 */
public class PaletteHSBChooser
        extends AbstractColorChooserPanel
        implements UIResource {

    private ColorSliderModel ccModel = new PaletteColorSliderModel(new HSBColorSpace());
    private int updatingChooser;
    private PaletteLookAndFeel labels;

    /** Creates new form. */
    public PaletteHSBChooser() {
    }

    @Override
    protected void buildChooser() {
        PaletteLookAndFeel plaf=labels=PaletteLookAndFeel.getInstance();
        initComponents();
        setUI(PalettePanelUI.createUI(this));
        hueFieldPanel.setUI((PanelUI) PalettePanelUI.createUI(hueFieldPanel));
        saturationFieldPanel.setUI((PanelUI) PalettePanelUI.createUI(saturationFieldPanel));
        brightnessFieldPanel.setUI((PanelUI) PalettePanelUI.createUI(brightnessFieldPanel));
        hueLabel.setUI((LabelUI) PaletteLabelUI.createUI(hueLabel));
        saturationLabel.setUI((LabelUI) PaletteLabelUI.createUI(saturationLabel));
        brightnessLabel.setUI((LabelUI) PaletteLabelUI.createUI(brightnessLabel));
        hueFieldLabel.setUI((LabelUI) PaletteLabelUI.createUI(hueFieldLabel));
        saturationFieldLabel.setUI((LabelUI) PaletteLabelUI.createUI(saturationFieldLabel));
        brightnessFieldLabel.setUI((LabelUI) PaletteLabelUI.createUI(brightnessFieldLabel));
        hueField.setUI((TextUI) PaletteTextFieldUI.createUI(hueField));
        saturationField.setUI((TextUI) PaletteTextFieldUI.createUI(saturationField));
        brightnessField.setUI((TextUI) PaletteTextFieldUI.createUI(brightnessField));

        ccModel.getBoundedRangeModel(0).setMaximum(359);
        ccModel.getBoundedRangeModel(1).setMaximum(100);
        ccModel.getBoundedRangeModel(2).setMaximum(100);
        //
        Font font = plaf.getFont("ColorChooser.font");
        hueLabel.setFont(font);
        hueSlider.setFont(font);
        hueField.setFont(font);
        hueFieldLabel.setFont(font);
        saturationLabel.setFont(font);
        saturationSlider.setFont(font);
        saturationField.setFont(font);
        saturationFieldLabel.setFont(font);
        brightnessLabel.setFont(font);
        brightnessSlider.setFont(font);
        brightnessField.setFont(font);
        brightnessFieldLabel.setFont(font);
        //
        int textSliderGap = plaf.getInt("ColorChooser.textSliderGap");
        if (textSliderGap != 0) {
            Border fieldBorder = new EmptyBorder(0, textSliderGap, 0, 0);
            hueFieldPanel.setBorder(fieldBorder);
            saturationFieldPanel.setBorder(fieldBorder);
            brightnessFieldPanel.setBorder(fieldBorder);
        }

        ccModel.configureSlider(0, hueSlider);
        ccModel.configureSlider(1, saturationSlider);
        ccModel.configureSlider(2, brightnessSlider);
        hueField.setText(Integer.toString(hueSlider.getValue()));
        saturationField.setText(Integer.toString(saturationSlider.getValue()));
        brightnessField.setText(Integer.toString(brightnessSlider.getValue()));
        Insets borderMargin = UIManager.getInsets("Component.visualMargin");
        if (borderMargin != null) {
            borderMargin = (Insets) borderMargin.clone();
            borderMargin.left = 3 - borderMargin.left;
            hueFieldLabel.putClientProperty("Quaqua.Component.visualMargin", borderMargin);
            saturationFieldLabel.putClientProperty("Quaqua.Component.visualMargin", borderMargin);
            brightnessFieldLabel.putClientProperty("Quaqua.Component.visualMargin", borderMargin);
        }
        new ColorSliderTextFieldHandler(hueField, ccModel, 0);
        new ColorSliderTextFieldHandler(saturationField, ccModel, 1);
        new ColorSliderTextFieldHandler(brightnessField, ccModel, 2);

        ccModel.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent evt) {
                setColorToModel(ccModel.getColor());
            }
        });
        hueField.setMinimumSize(hueField.getPreferredSize());
        saturationField.setMinimumSize(saturationField.getPreferredSize());
        brightnessField.setMinimumSize(brightnessField.getPreferredSize());
        EmptyBorder bm = new EmptyBorder(0,0,0,0);
        hueLabel.setBorder(bm);
        saturationLabel.setBorder(bm);
        brightnessLabel.setBorder(bm);
    }

    @Override
    public String getDisplayName() {
        return PaletteLookAndFeel.getInstance().getString("ColorChooser.hsbSliders");
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
        updatingChooser++;
        ccModel.setColor(getColorFromModel());
        updatingChooser--;
    }

    public void setColorToModel(Color color) {
        if (updatingChooser == 0) {
            getColorSelectionModel().setSelectedColor(color);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        hueLabel = new javax.swing.JLabel();
        hueSlider = new javax.swing.JSlider();
        hueFieldPanel = new javax.swing.JPanel();
        hueField = new javax.swing.JTextField();
        hueFieldLabel = new javax.swing.JLabel();
        saturationLabel = new javax.swing.JLabel();
        saturationSlider = new javax.swing.JSlider();
        saturationFieldPanel = new javax.swing.JPanel();
        saturationField = new javax.swing.JTextField();
        saturationFieldLabel = new javax.swing.JLabel();
        brightnessLabel = new javax.swing.JLabel();
        brightnessSlider = new javax.swing.JSlider();
        brightnessFieldPanel = new javax.swing.JPanel();
        brightnessField = new javax.swing.JTextField();
        brightnessFieldLabel = new javax.swing.JLabel();
        springPanel = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        hueLabel.setText(labels.getString("ColorChooser.hsbHueText")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, -4, 0);
        add(hueLabel, gridBagConstraints);

        hueSlider.setMajorTickSpacing(359);
        hueSlider.setMaximum(359);
        hueSlider.setMinorTickSpacing(180);
        hueSlider.setPaintTicks(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        add(hueSlider, gridBagConstraints);

        hueFieldPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        hueField.setColumns(3);
        hueField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        hueField.setText("0");
        hueField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                hueFieldFocusLost(evt);
            }
        });
        hueFieldPanel.add(hueField);

        hueFieldLabel.setText("°");
        hueFieldPanel.add(hueFieldLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        add(hueFieldPanel, gridBagConstraints);

        saturationLabel.setText(labels.getString("ColorChooser.hsbSaturationText")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, -4, 0);
        add(saturationLabel, gridBagConstraints);

        saturationSlider.setMajorTickSpacing(100);
        saturationSlider.setMinorTickSpacing(50);
        saturationSlider.setPaintTicks(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        add(saturationSlider, gridBagConstraints);

        saturationFieldPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        saturationField.setColumns(3);
        saturationField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        saturationField.setText("0");
        saturationField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                saturationFieldFocusLost(evt);
            }
        });
        saturationFieldPanel.add(saturationField);

        saturationFieldLabel.setText("%");
        saturationFieldPanel.add(saturationFieldLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        add(saturationFieldPanel, gridBagConstraints);

        brightnessLabel.setText(labels.getString("ColorChooser.hsbBrightnessText")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, -4, 0);
        add(brightnessLabel, gridBagConstraints);

        brightnessSlider.setMajorTickSpacing(100);
        brightnessSlider.setMinorTickSpacing(50);
        brightnessSlider.setPaintTicks(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        add(brightnessSlider, gridBagConstraints);

        brightnessFieldPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        brightnessField.setColumns(3);
        brightnessField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        brightnessField.setText("0");
        brightnessField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                brightnessFieldFocusLost(evt);
            }
        });
        brightnessFieldPanel.add(brightnessField);

        brightnessFieldLabel.setText("%");
        brightnessFieldPanel.add(brightnessFieldLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        add(brightnessFieldPanel, gridBagConstraints);

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

    private void brightnessFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_brightnessFieldFocusLost
        brightnessField.setText(Integer.toString(ccModel.getBoundedRangeModel(2).getValue()));
    }//GEN-LAST:event_brightnessFieldFocusLost

    private void saturationFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_saturationFieldFocusLost
        saturationField.setText(Integer.toString(ccModel.getBoundedRangeModel(1).getValue()));
    }//GEN-LAST:event_saturationFieldFocusLost

    private void hueFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hueFieldFocusLost
        hueField.setText(Integer.toString(ccModel.getBoundedRangeModel(0).getValue()));
    }//GEN-LAST:event_hueFieldFocusLost
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField brightnessField;
    private javax.swing.JLabel brightnessFieldLabel;
    private javax.swing.JPanel brightnessFieldPanel;
    private javax.swing.JLabel brightnessLabel;
    private javax.swing.JSlider brightnessSlider;
    private javax.swing.JTextField hueField;
    private javax.swing.JLabel hueFieldLabel;
    private javax.swing.JPanel hueFieldPanel;
    private javax.swing.JLabel hueLabel;
    private javax.swing.JSlider hueSlider;
    private javax.swing.JTextField saturationField;
    private javax.swing.JLabel saturationFieldLabel;
    private javax.swing.JPanel saturationFieldPanel;
    private javax.swing.JLabel saturationLabel;
    private javax.swing.JSlider saturationSlider;
    private javax.swing.JPanel springPanel;
    // End of variables declaration//GEN-END:variables
}
