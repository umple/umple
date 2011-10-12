/**
 * @(#)JMixer.java
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
import java.awt.event.MouseEvent;
import java.beans.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * JMixer.
 * 
 * FIXME - This is an experimental class. Do not use it.
 *
 *
 * @author Werner Randelshofer
 * @version $Id: JMixer.java 723 2010-12-28 14:31:24Z rawcoder $
 */
public class JMixer extends javax.swing.JPanel {

    private JList swatchesList;
    private DefaultColorSliderModel sliderModel;
    private int adjusting;

    private class Preset {

        private String name;
        private int index;

        public Preset(String name, int index) {
            this.name = name;
            this.index = index;
        }

        public Color getColor() {
            return new Color(sliderModel.getColorSpace(), new float[]{
                        (index / 8) / 12f, 1f, (index % 8 + 2) / 12f}, 1f);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    /** Creates new form. */
    public JMixer() {
        initComponents();

        DefaultComboBoxModel presets = new DefaultComboBoxModel();
        presets.addElement(new Preset("Powerful", 4));
        presets.addElement(new Preset("Rich", 1));
        presets.addElement(new Preset("Romantic", 7));
        presets.addElement(new Preset("Vital", 12));
        presets.addElement(new Preset("Earthy", 10));
        presets.addElement(new Preset("Friendly", 20));
        presets.addElement(new Preset("Soft", 22));
        presets.addElement(new Preset("Welcoming", 28));
        presets.addElement(new Preset("Moving", 36));
        presets.addElement(new Preset("Elegant", 39));
        presets.addElement(new Preset("Fresh", 52));
        presets.addElement(new Preset("Traditional", 49));
        presets.addElement(new Preset("Refreshing", 60));
        presets.addElement(new Preset("Tropical", 62));
        presets.addElement(new Preset("Classic", 68));
        presets.addElement(new Preset("Dependable", 65));
        presets.addElement(new Preset("Calm", 70));
        presets.addElement(new Preset("Regal", 76));
        presets.addElement(new Preset("Magical", 84));
        presets.addElement(new Preset("Energetic", 92));
        presets.addElement(new Preset("Subdued", 94));

        presetCombo.setModel(presets);

        Font smallFont = new Font("Lucida Grande", Font.PLAIN, 11);
        for (Component c : mixerPanel.getComponents()) {
            c.setFont(smallFont);
        }

        // Create a list, overriding the getToolTipText() method
        swatchesList = new JList() {
            // This method is called as the cursor moves within the list.

            @Override
            public String getToolTipText(MouseEvent evt) {
                // Get item index
                int index = locationToIndex(evt.getPoint());

                // Get item
                Object item = getModel().getElementAt(index);

                JComponent c = (JComponent) getCellRenderer().getListCellRendererComponent(this, item, index, false, false);

                // Return the tool tip text
                return c.getToolTipText();
            }
        };
        swatchesList.setLayoutOrientation(javax.swing.JList.VERTICAL_WRAP);
        swatchesList.setVisibleRowCount(5);
        scrollPane.setViewportView(swatchesList);

        harmonicWheel.setColorSpace(HSLColorSpace.getInstance());

        scrollPane.setPreferredSize(new Dimension(100, 100));
        swatchesList.setModel((ListModel) harmonicWheel.getHarmonicColorModel());
        swatchesList.setCellRenderer(new ColorListCellRenderer());

        sliderModel = new DefaultColorSliderModel(harmonicWheel.getHarmonicColorModel().getColorSpace());
        sliderModel.configureSlider(1, saturationSlider);

        harmonicWheel.getHarmonicColorModel().addListDataListener(new ListDataListener() {

            @Override
            public void intervalAdded(ListDataEvent e) {
            }

            @Override
            public void intervalRemoved(ListDataEvent e) {
            }

            @Override
            public void contentsChanged(ListDataEvent e) {
                adjusting++;
                HarmonicColorModel hcm = harmonicWheel.getHarmonicColorModel();
                Color cc = hcm.get(e.getIndex0());
                if (cc != null) {
                    sliderModel.setColor(cc);
                }
                adjusting--;
            }
        });
        harmonicWheel.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String name = evt.getPropertyName();
                if (name == JHarmonicColorWheel.SELECTED_INDEX_PROPERTY) {
                    adjusting++;
                    int index = harmonicWheel.getSelectedIndex();
                    HarmonicColorModel hcm = harmonicWheel.getHarmonicColorModel();
                    if (index != -1) {
                        sliderModel.setColor(hcm.get(index));
                    }
                    adjusting--;
                }
            }
        });

        sliderModel.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if (adjusting++ == 0) {
                    HarmonicColorModel hcm = harmonicWheel.getHarmonicColorModel();
                    if (!hcm.isAdjusting()) {
                        int index = harmonicWheel.getSelectedIndex();
                        if (index != -1) {
                            Color cc = sliderModel.getColor();
                            Color oldValue = hcm.get(index);
                            Color newValue = new Color(oldValue.getColorSpace(), ColorUtil.fromColor(oldValue.getColorSpace(), cc), 1f);
                            hcm.set(index, newValue);
                        }
                    }
                }
                adjusting--;
            }
        });

        harmonicWheel.setSelectedIndex(0);
        harmonicWheel.getHarmonicColorModel().setSize(25);
        // updateRules();

        HarmonicColorModel h = harmonicWheel.getHarmonicColorModel();
        ColorSpace sys = h.getColorSpace();
        h.set(0, new Color(sys, ColorUtil.fromRGB(sys, 0, 19, 148), 1f));
        h.set(1, new Color(sys, ColorUtil.fromRGB(sys, 218, 37, 26), 1f));
        h.set(2, new Color(sys, ColorUtil.fromRGB(sys, 70, 148, 27), 1f));
        h.set(3, new Color(sys, ColorUtil.fromRGB(sys, 174, 46, 248), 1f));
        h.set(4, new Color(sys, ColorUtil.fromRGB(sys, 255, 252, 76), 1f));
        h.set(5, new Color(sys, ColorUtil.fromRGB(sys, 234, 155, 65), 1f));
        h.set(6, new Color(sys, ColorUtil.fromRGB(sys, 51, 51, 51), 1f));
        h.set(7, new Color(sys, ColorUtil.fromRGB(sys, 153, 153, 153), 1f));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame("Mixer");
                f.add(new JMixer());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.pack();
                f.setVisible(true);
            }
        });
    }

    private void updateRules() {
        HarmonicColorModel m = harmonicWheel.getHarmonicColorModel();
        m.removeAllRules();

        for (int i = 1, n = m.getSize(); i < n; i++) {
            m.set(i, null);
        }

        if (customHueRadio.isSelected()) {
        } else if (analogousRadio.isSelected()) {
            m.addRule(new SimpleHarmonicRule(0, 30f / 360f, 0, 5));
            m.addRule(new SimpleHarmonicRule(0, -30f / 360f, 0, 10));
        } else if (primaryRadio.isSelected()) {
            m.addRule(new SimpleHarmonicRule(0, 120f / 360f, 0, 5));
            m.addRule(new SimpleHarmonicRule(0, -120f / 360f, 0, 10));
        } else if (clashRadio.isSelected()) {
            m.addRule(new SimpleHarmonicRule(0, 90f / 360f, 0, 5));
            m.addRule(new SimpleHarmonicRule(0, -90f / 360f, 0, 10));
        } else if (triadRadio.isSelected()) {
            m.addRule(new SimpleHarmonicRule(0, 120f / 360f, 0, 5));
            m.addRule(new SimpleHarmonicRule(0, -120f / 360f, 0, 10));
        } else if (splitComplementaryRadio.isSelected()) {
            m.addRule(new SimpleHarmonicRule(0, 150f / 360f, 0, 5));
            m.addRule(new SimpleHarmonicRule(0, -150f / 360f, 0, 10));
        } else if (complementaryRadio.isSelected()) {
            m.addRule(new SimpleHarmonicRule(0, 180f / 360f, 0, 5));
        }

        /*if (achromaticCheck.isSelected()) {
        m.addRule(new SimpleHarmonicRule(1, -1f / 12f, 0, 3, 4));
        m.addRule(new SimpleHarmonicRule(1, -1f / 12f, 5, 8, 9));
        m.addRule(new SimpleHarmonicRule(1, -1f / 12f, 10, 13, 14));
        }*/
        if (monochromaticCheck.isSelected()) {
            /*
            m.addRule(new SimpleHarmonicRule(2, 1f/12f, 0, 1, 2));
            m.addRule(new SimpleHarmonicRule(2, 1f/12f, 5, 6, 7));
            m.addRule(new SimpleHarmonicRule(2, 1f/12f, 10, 11, 12));*/
            m.addRule(new SimpleHarmonicRule(2, 1f / 12f, 0, 1, 2));
            m.addRule(new SimpleHarmonicRule(2, 1f / 12f, 5, 6, 7));
            m.addRule(new SimpleHarmonicRule(2, 1f / 12f, 10, 11, 12));
            m.addRule(new SimpleHarmonicRule(2, -1f / 12f, 0, 3, 4));
            m.addRule(new SimpleHarmonicRule(2, -1f / 12f, 5, 8, 9));
            m.addRule(new SimpleHarmonicRule(2, -1f / 12f, 10, 13, 14));
        }

        m.applyRules();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        hueGroup = new javax.swing.ButtonGroup();
        sysGroup = new javax.swing.ButtonGroup();
        scrollPane = new javax.swing.JScrollPane();
        disclosureButton = new javax.swing.JToggleButton();
        sysRGBToggle = new javax.swing.JToggleButton();
        sysRYBToggle = new javax.swing.JToggleButton();
        presetCombo = new javax.swing.JComboBox();
        mixerPanel = new javax.swing.JPanel();
        harmonicWheel = new org.jhotdraw.color.JHarmonicColorWheel();
        customHueRadio = new javax.swing.JRadioButton();
        customHueLabel = new javax.swing.JLabel();
        customHueField = new org.jhotdraw.gui.JLifeFormattedTextField();
        customHueLabel2 = new javax.swing.JLabel();
        analogousRadio = new javax.swing.JRadioButton();
        analogousLabel1 = new javax.swing.JLabel();
        analogousField = new org.jhotdraw.gui.JLifeFormattedTextField();
        analogousLabel2 = new javax.swing.JLabel();
        primaryRadio = new javax.swing.JRadioButton();
        primaryLabel1 = new javax.swing.JLabel();
        primaryField = new org.jhotdraw.gui.JLifeFormattedTextField();
        primaryLabel2 = new javax.swing.JLabel();
        clashRadio = new javax.swing.JRadioButton();
        clashLabel1 = new javax.swing.JLabel();
        clashField = new org.jhotdraw.gui.JLifeFormattedTextField();
        clashLabel2 = new javax.swing.JLabel();
        triadRadio = new javax.swing.JRadioButton();
        triadLabel1 = new javax.swing.JLabel();
        triadField = new org.jhotdraw.gui.JLifeFormattedTextField();
        triadLabel2 = new javax.swing.JLabel();
        splitComplementaryRadio = new javax.swing.JRadioButton();
        splitComplementaryLabel1 = new javax.swing.JLabel();
        splitField = new org.jhotdraw.gui.JLifeFormattedTextField();
        splitComplementaryLabel2 = new javax.swing.JLabel();
        complementaryRadio = new javax.swing.JRadioButton();
        complementaryLabel1 = new javax.swing.JLabel();
        complementaryField = new org.jhotdraw.gui.JLifeFormattedTextField();
        complementaryLabel2 = new javax.swing.JLabel();
        achromaticCheck = new javax.swing.JCheckBox();
        achromaticLabel1 = new javax.swing.JLabel();
        achromaticField = new org.jhotdraw.gui.JLifeFormattedTextField();
        achromaticLabel2 = new javax.swing.JLabel();
        monochromaticCheck = new javax.swing.JCheckBox();
        monochromaticLabel1 = new javax.swing.JLabel();
        monochromaticField = new org.jhotdraw.gui.JLifeFormattedTextField();
        monochromaticLabel2 = new javax.swing.JLabel();
        saturationSlider = new javax.swing.JSlider();
        springPanel = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        add(scrollPane, gridBagConstraints);

        disclosureButton.setSelected(true);
        disclosureButton.setText("Show Mixer");
        disclosureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mixerDisclosurePerformed(evt);
            }
        });
        add(disclosureButton, new java.awt.GridBagConstraints());

        sysGroup.add(sysRGBToggle);
        sysRGBToggle.setSelected(true);
        sysRGBToggle.setText("RGB");
        sysRGBToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                systemChangePerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        add(sysRGBToggle, gridBagConstraints);

        sysGroup.add(sysRYBToggle);
        sysRYBToggle.setText("RYB");
        sysRYBToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                systemChangePerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        add(sysRYBToggle, gridBagConstraints);

        presetCombo.setEditable(true);
        presetCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presetPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(presetCombo, gridBagConstraints);

        mixerPanel.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        mixerPanel.add(harmonicWheel, gridBagConstraints);

        hueGroup.add(customHueRadio);
        customHueRadio.setText("Custom");
        customHueRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruleChangePerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(customHueRadio, gridBagConstraints);

        customHueLabel.setText("±");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(customHueLabel, gridBagConstraints);

        customHueField.setColumns(3);
        customHueField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        customHueField.setText("30");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(customHueField, gridBagConstraints);

        customHueLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        customHueLabel2.setText("°");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(customHueLabel2, gridBagConstraints);

        hueGroup.add(analogousRadio);
        analogousRadio.setSelected(true);
        analogousRadio.setText("Analogous");
        analogousRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruleChangePerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(analogousRadio, gridBagConstraints);

        analogousLabel1.setText("±");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(analogousLabel1, gridBagConstraints);

        analogousField.setColumns(3);
        analogousField.setEditable(false);
        analogousField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        analogousField.setText("30");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(analogousField, gridBagConstraints);

        analogousLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        analogousLabel2.setText("°");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(analogousLabel2, gridBagConstraints);

        hueGroup.add(primaryRadio);
        primaryRadio.setText("Primary");
        primaryRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruleChangePerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(primaryRadio, gridBagConstraints);

        primaryLabel1.setText("±");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(primaryLabel1, gridBagConstraints);

        primaryField.setColumns(3);
        primaryField.setEditable(false);
        primaryField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        primaryField.setText("120");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(primaryField, gridBagConstraints);

        primaryLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        primaryLabel2.setText("°");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(primaryLabel2, gridBagConstraints);

        hueGroup.add(clashRadio);
        clashRadio.setText("Clash");
        clashRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruleChangePerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(clashRadio, gridBagConstraints);

        clashLabel1.setText("±");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(clashLabel1, gridBagConstraints);

        clashField.setColumns(3);
        clashField.setEditable(false);
        clashField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        clashField.setText("90");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(clashField, gridBagConstraints);

        clashLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        clashLabel2.setText("°");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(clashLabel2, gridBagConstraints);

        hueGroup.add(triadRadio);
        triadRadio.setText("Triad");
        triadRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruleChangePerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(triadRadio, gridBagConstraints);

        triadLabel1.setText("±");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(triadLabel1, gridBagConstraints);

        triadField.setColumns(3);
        triadField.setEditable(false);
        triadField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        triadField.setText("120");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(triadField, gridBagConstraints);

        triadLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        triadLabel2.setText("°");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(triadLabel2, gridBagConstraints);

        hueGroup.add(splitComplementaryRadio);
        splitComplementaryRadio.setText("Split Complementary");
        splitComplementaryRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruleChangePerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(splitComplementaryRadio, gridBagConstraints);

        splitComplementaryLabel1.setText("±");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(splitComplementaryLabel1, gridBagConstraints);

        splitField.setColumns(3);
        splitField.setEditable(false);
        splitField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        splitField.setText("150");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(splitField, gridBagConstraints);

        splitComplementaryLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        splitComplementaryLabel2.setText("°");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(splitComplementaryLabel2, gridBagConstraints);

        hueGroup.add(complementaryRadio);
        complementaryRadio.setText("Complementary");
        complementaryRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruleChangePerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(complementaryRadio, gridBagConstraints);

        complementaryLabel1.setText("+");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(complementaryLabel1, gridBagConstraints);

        complementaryField.setColumns(3);
        complementaryField.setEditable(false);
        complementaryField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        complementaryField.setText("180");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(complementaryField, gridBagConstraints);

        complementaryLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        complementaryLabel2.setText("°");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(complementaryLabel2, gridBagConstraints);

        achromaticCheck.setText("Achromatic");
        achromaticCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruleChangePerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(achromaticCheck, gridBagConstraints);

        achromaticLabel1.setText("±");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(achromaticLabel1, gridBagConstraints);

        achromaticField.setColumns(3);
        achromaticField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        achromaticField.setText("10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(achromaticField, gridBagConstraints);

        achromaticLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        achromaticLabel2.setText("%");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(achromaticLabel2, gridBagConstraints);

        monochromaticCheck.setSelected(true);
        monochromaticCheck.setText("Monochromatic");
        monochromaticCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruleChangePerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(monochromaticCheck, gridBagConstraints);

        monochromaticLabel1.setText("±");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(monochromaticLabel1, gridBagConstraints);

        monochromaticField.setColumns(3);
        monochromaticField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        monochromaticField.setText("10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(monochromaticField, gridBagConstraints);

        monochromaticLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        monochromaticLabel2.setText("%");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mixerPanel.add(monochromaticLabel2, gridBagConstraints);

        saturationSlider.setOrientation(javax.swing.JSlider.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        mixerPanel.add(saturationSlider, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weighty = 1.0;
        mixerPanel.add(springPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.5;
        add(mixerPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    private void ruleChangePerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruleChangePerformed
        updateRules();
}//GEN-LAST:event_ruleChangePerformed

private void mixerDisclosurePerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mixerDisclosurePerformed
    mixerPanel.setVisible(disclosureButton.isSelected());
    mixerPanel.getParent().validate();

}//GEN-LAST:event_mixerDisclosurePerformed

private void systemChangePerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_systemChangePerformed
    HarmonicColorModel m = harmonicWheel.getHarmonicColorModel();
    ColorSpace sys;
    if (sysRGBToggle.isSelected()) {
        sys = HSLColorSpace.getInstance();
    } else {
        sys = HSLPhysiologicColorSpace.getInstance();
    }
    m.setColorSpace(sys);
    sliderModel.setColorSpace(sys);
    sliderModel.configureSlider(1, saturationSlider);
    if (harmonicWheel.getSelectedIndex() != -1) {
        sliderModel.setColor(m.get(harmonicWheel.getSelectedIndex()));
    }
}//GEN-LAST:event_systemChangePerformed

private void presetPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presetPerformed
    Object obj = presetCombo.getSelectedItem();
    if (obj instanceof Preset) {
        Preset preset = (Preset) obj;
        HarmonicColorModel m = harmonicWheel.getHarmonicColorModel();
        m.set(m.getBase(), preset.getColor());
    }
}//GEN-LAST:event_presetPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox achromaticCheck;
    private org.jhotdraw.gui.JLifeFormattedTextField achromaticField;
    private javax.swing.JLabel achromaticLabel1;
    private javax.swing.JLabel achromaticLabel2;
    private org.jhotdraw.gui.JLifeFormattedTextField analogousField;
    private javax.swing.JLabel analogousLabel1;
    private javax.swing.JLabel analogousLabel2;
    private javax.swing.JRadioButton analogousRadio;
    private org.jhotdraw.gui.JLifeFormattedTextField clashField;
    private javax.swing.JLabel clashLabel1;
    private javax.swing.JLabel clashLabel2;
    private javax.swing.JRadioButton clashRadio;
    private org.jhotdraw.gui.JLifeFormattedTextField complementaryField;
    private javax.swing.JLabel complementaryLabel1;
    private javax.swing.JLabel complementaryLabel2;
    private javax.swing.JRadioButton complementaryRadio;
    private org.jhotdraw.gui.JLifeFormattedTextField customHueField;
    private javax.swing.JLabel customHueLabel;
    private javax.swing.JLabel customHueLabel2;
    private javax.swing.JRadioButton customHueRadio;
    private javax.swing.JToggleButton disclosureButton;
    private org.jhotdraw.color.JHarmonicColorWheel harmonicWheel;
    private javax.swing.ButtonGroup hueGroup;
    private javax.swing.JPanel mixerPanel;
    private javax.swing.JCheckBox monochromaticCheck;
    private org.jhotdraw.gui.JLifeFormattedTextField monochromaticField;
    private javax.swing.JLabel monochromaticLabel1;
    private javax.swing.JLabel monochromaticLabel2;
    private javax.swing.JComboBox presetCombo;
    private org.jhotdraw.gui.JLifeFormattedTextField primaryField;
    private javax.swing.JLabel primaryLabel1;
    private javax.swing.JLabel primaryLabel2;
    private javax.swing.JRadioButton primaryRadio;
    private javax.swing.JSlider saturationSlider;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel splitComplementaryLabel1;
    private javax.swing.JLabel splitComplementaryLabel2;
    private javax.swing.JRadioButton splitComplementaryRadio;
    private org.jhotdraw.gui.JLifeFormattedTextField splitField;
    private javax.swing.JPanel springPanel;
    private javax.swing.ButtonGroup sysGroup;
    private javax.swing.JToggleButton sysRGBToggle;
    private javax.swing.JToggleButton sysRYBToggle;
    private org.jhotdraw.gui.JLifeFormattedTextField triadField;
    private javax.swing.JLabel triadLabel1;
    private javax.swing.JLabel triadLabel2;
    private javax.swing.JRadioButton triadRadio;
    // End of variables declaration//GEN-END:variables
}
