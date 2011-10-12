/*
 * @(#)CanvasToolBar.java
 *
 * Copyright (c) 2007-2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.svg.gui;

import org.jhotdraw.draw.gui.JAttributeTextField;
import org.jhotdraw.draw.gui.JAttributeSlider;
import org.jhotdraw.draw.event.DrawingAttributeEditorHandler;
import org.jhotdraw.draw.event.DrawingComponentRepainter;
import org.jhotdraw.text.JavaNumberFormatter;
import javax.swing.border.*;
import org.jhotdraw.gui.*;
import org.jhotdraw.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.LabelUI;
import javax.swing.plaf.SliderUI;
import javax.swing.plaf.TextUI;
import javax.swing.text.DefaultFormatterFactory;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.gui.plaf.palette.*;
import org.jhotdraw.text.ColorFormatter;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

/**
 * CanvasToolBar.
 *
 * @author Werner Randelshofer
 * @version $Id: CanvasToolBar.java 721 2010-11-22 19:42:01Z rawcoder $
 */
public class CanvasToolBar extends AbstractToolBar {

    /** Creates new instance. */
    public CanvasToolBar() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        setName(labels.getString(getID() + ".toolbar"));
        setDisclosureStateCount(3);
    }

    @Override
    protected JComponent createDisclosedComponent(int state) {
        JPanel p = null;

        switch (state) {
            case 1: {
                p = new JPanel();
                p.setOpaque(false);
                p.setBorder(new EmptyBorder(5, 5, 5, 8));

                // Abort if no editor is set
                if (editor == null) {
                    break;
                }

                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
                GridBagLayout layout = new GridBagLayout();
                p.setLayout(layout);
                GridBagConstraints gbc;
                AbstractButton btn;
                AbstractSelectedAction d;

                // Fill color
                 btn = ButtonFactory.createDrawingColorChooserButton(editor,
                        CANVAS_FILL_COLOR, "attribute.canvasFillColor", labels,
                        null, new Rectangle(3, 3, 10, 10), PaletteColorChooserUI.class, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                disposables.add(new DrawingComponentRepainter(editor, btn));
                ((JPopupButton) btn).setAction(null, null);
                gbc = new GridBagConstraints();
                gbc.gridy = 0;
                gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                p.add(btn, gbc);

                // Opacity slider
                JPopupButton opacityPopupButton = new JPopupButton();
                JAttributeSlider opacitySlider = new JAttributeSlider(JSlider.VERTICAL, 0, 100, 100);
                opacitySlider.setUI((SliderUI) PaletteSliderUI.createUI(opacitySlider));
                opacitySlider.setScaleFactor(100d);
                disposables.add(new DrawingAttributeEditorHandler<Double>(CANVAS_FILL_OPACITY, opacitySlider, editor));
                opacityPopupButton.add(opacitySlider);
                labels.configureToolBarButton(opacityPopupButton, "attribute.canvasFillOpacity");
                opacityPopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(opacityPopupButton));
                opacityPopupButton.setIcon(
                        new DrawingOpacityIcon(editor, CANVAS_FILL_OPACITY, CANVAS_FILL_COLOR, null, Images.createImage(getClass(), labels.getString("attribute.canvasFillOpacity.icon")),
                        new Rectangle(5, 5, 6, 6), new Rectangle(4, 4, 7, 7)));
                disposables.add(new DrawingComponentRepainter(editor, opacityPopupButton));
                gbc = new GridBagConstraints();
                gbc.gridx = 2;
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.insets = new Insets(0, 3, 0, 0);
                p.add(opacityPopupButton, gbc);

                // Width and height fields
                JLabel widthLabel, heightLabel;
                JAttributeTextField<Double> widthField, heightField;

                widthLabel = new javax.swing.JLabel();
                heightLabel = new javax.swing.JLabel();
                widthField = new JAttributeTextField<Double>();
                heightField = new JAttributeTextField<Double>();

                widthLabel.setUI((LabelUI) PaletteLabelUI.createUI(widthLabel));
                widthLabel.setLabelFor(widthField);
                widthLabel.setToolTipText(labels.getString("attribute.canvasWidth.toolTipText"));
                widthLabel.setText(labels.getString("attribute.canvasWidth.text")); // NOI18N
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(3, 0, 0, 0);
                p.add(widthLabel, gbc);

                widthField.setUI((TextUI) PaletteFormattedTextFieldUI.createUI(widthField));
                widthField.setColumns(3);
                widthField.setToolTipText(labels.getString("attribute.canvasWidth.toolTipText"));
                JavaNumberFormatter formatter = new JavaNumberFormatter(1d, 4096d, 1d, true);
                formatter.setUsesScientificNotation(false);
                widthField.setFormatterFactory(new DefaultFormatterFactory(formatter));
                widthField.setHorizontalAlignment(JTextField.LEADING);
                disposables.add(new DrawingAttributeEditorHandler<Double>(CANVAS_WIDTH, widthField, editor));
                gbc = new GridBagConstraints();
                gbc.gridx = 1;
                gbc.gridy = 1;
                gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(3, 3, 0, 0);
                p.add(widthField, gbc);

                heightLabel.setUI((LabelUI) PaletteLabelUI.createUI(heightLabel));
                heightLabel.setLabelFor(widthField);
                heightLabel.setToolTipText(labels.getString("attribute.canvasHeight.toolTipText"));
                heightLabel.setText(labels.getString("attribute.canvasHeight.text")); // NOI18N
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(3, 0, 0, 0);
                p.add(heightLabel, gbc);

                heightField.setUI((TextUI) PaletteFormattedTextFieldUI.createUI(widthField));
                heightField.setColumns(3);
                heightField.setToolTipText(labels.getString("attribute.canvasHeight.toolTipText"));
                 formatter = new JavaNumberFormatter(1d, 4096d, 1d, true);
                formatter.setUsesScientificNotation(false);
                heightField.setFormatterFactory(new DefaultFormatterFactory(formatter));
                heightField.setHorizontalAlignment(JTextField.LEADING);
                disposables.add(new DrawingAttributeEditorHandler<Double>(CANVAS_HEIGHT, heightField, editor));
                gbc = new GridBagConstraints();
                gbc.gridx = 1;
                gbc.gridy = 2;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(3, 3, 0, 0);
                gbc.gridwidth = 2;
                p.add(heightField, gbc);

            }
            break;
            case 2: {
                p = new JPanel();
                p.setOpaque(false);

                // Abort if no editor is set
                if (editor == null) {
                    break;
                }

                JPanel p1 = new JPanel(new GridBagLayout());
                JPanel p2 = new JPanel(new GridBagLayout());
                JPanel p3 = new JPanel(new GridBagLayout());
                p1.setOpaque(false);
                p2.setOpaque(false);
                p3.setOpaque(false);

                p.removeAll();
                p.setBorder(new EmptyBorder(5, 5, 5, 8));
                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
                GridBagLayout layout = new GridBagLayout();
                p.setLayout(layout);
                GridBagConstraints gbc;
                AbstractButton btn;

                // Fill color field with button
                JAttributeTextField<Color> colorField = new JAttributeTextField<Color>();
                colorField.setColumns(7);
                colorField.setToolTipText(labels.getString("attribute.canvasFillColor.toolTipText"));
                colorField.putClientProperty("Palette.Component.segmentPosition", "first");
                colorField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(colorField));
                colorField.setFormatterFactory(ColorFormatter.createFormatterFactory());
                colorField.setHorizontalAlignment(JTextField.LEFT);
                disposables.add(new DrawingAttributeEditorHandler<Color>(CANVAS_FILL_COLOR, colorField, editor));
                gbc = new GridBagConstraints();
                gbc.gridwidth = 2;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                p1.add(colorField, gbc);
                 btn = ButtonFactory.createDrawingColorChooserButton(editor,
                        CANVAS_FILL_COLOR, "attribute.canvasFillColor", labels,
                        null, new Rectangle(3, 3, 10, 10), PaletteColorChooserUI.class, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                disposables.add(new DrawingComponentRepainter(editor, btn));
                ((JPopupButton) btn).setAction(null, null);
                gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                p1.add(btn, gbc);

                // Opacity field with slider
                JAttributeTextField<Double> opacityField = new JAttributeTextField<Double>();
                opacityField.setColumns(4);
                opacityField.setToolTipText(labels.getString("attribute.figureOpacity.toolTipText"));
                opacityField.setHorizontalAlignment(JAttributeTextField.RIGHT);
                opacityField.putClientProperty("Palette.Component.segmentPosition", "first");
                opacityField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(opacityField));
                JavaNumberFormatter formatter = new JavaNumberFormatter(0d, 100d, 100d, false, "%");
                formatter.setUsesScientificNotation(false);
                formatter.setMaximumFractionDigits(1);
                opacityField.setFormatterFactory(new DefaultFormatterFactory(formatter));
                opacityField.setHorizontalAlignment(JTextField.LEADING);
                disposables.add(new DrawingAttributeEditorHandler<Double>(CANVAS_FILL_OPACITY, opacityField, editor));
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.insets = new Insets(3, 0, 0, 0);
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                p1.add(opacityField, gbc);
                JPopupButton opacityPopupButton = new JPopupButton();
                JAttributeSlider opacitySlider = new JAttributeSlider(JSlider.VERTICAL, 0, 100, 100);
                opacitySlider.setUI((SliderUI) PaletteSliderUI.createUI(opacitySlider));
                opacitySlider.setScaleFactor(100d);
                disposables.add(new DrawingAttributeEditorHandler<Double>(CANVAS_FILL_OPACITY, opacitySlider, editor));
                opacityPopupButton.add(opacitySlider);
                labels.configureToolBarButton(opacityPopupButton, "attribute.canvasFillOpacity");
                opacityPopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(opacityPopupButton));
                opacityPopupButton.setIcon(
                        new DrawingOpacityIcon(editor, CANVAS_FILL_OPACITY, CANVAS_FILL_COLOR, null, Images.createImage(getClass(), labels.getString("attribute.canvasFillOpacity.icon")),
                        new Rectangle(5, 5, 6, 6), new Rectangle(4, 4, 7, 7)));
                disposables.add(new DrawingComponentRepainter(editor, opacityPopupButton));
                gbc = new GridBagConstraints();
                gbc.gridx = 1;
                gbc.gridy = 1;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.insets = new Insets(3, 0, 0, 0);
                p1.add(opacityPopupButton, gbc);

                // Width and height fields
                JLabel widthLabel, heightLabel;
                JAttributeTextField<Double> widthField, heightField;

                widthLabel = new javax.swing.JLabel();
                heightLabel = new javax.swing.JLabel();
                widthField = new JAttributeTextField<Double>();
                heightField = new JAttributeTextField<Double>();

                widthLabel.setUI((LabelUI) PaletteLabelUI.createUI(widthLabel));
                widthLabel.setLabelFor(widthField);
                widthLabel.setToolTipText(labels.getString("attribute.canvasWidth.toolTipText"));
                widthLabel.setText(labels.getString("attribute.canvasWidth.text")); // NOI18N
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(3, 0, 0, 0);
                p3.add(widthLabel, gbc);

                widthField.setUI((TextUI) PaletteFormattedTextFieldUI.createUI(widthField));
                widthField.setColumns(3);
                widthField.setToolTipText(labels.getString("attribute.canvasWidth.toolTipText"));
                widthField.setFormatterFactory(JavaNumberFormatter.createFormatterFactory(1d, 4096d, 1d, true));
                widthField.setHorizontalAlignment(JTextField.LEADING);
                disposables.add(new DrawingAttributeEditorHandler<Double>(CANVAS_WIDTH, widthField, editor));
                gbc = new GridBagConstraints();
                gbc.gridx = 1;
                gbc.gridy = 2;
                gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(3, 3, 0, 0);
                p3.add(widthField, gbc);

                heightLabel.setUI((LabelUI) PaletteLabelUI.createUI(heightLabel));
                heightLabel.setLabelFor(widthField);
                heightLabel.setToolTipText(labels.getString("attribute.canvasHeight.toolTipText"));
                heightLabel.setText(labels.getString("attribute.canvasHeight.text")); // NOI18N
                gbc = new GridBagConstraints();
                gbc.gridx = 3;
                gbc.gridy = 2;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(3, 3, 0, 0);
                p3.add(heightLabel, gbc);

                heightField.setUI((TextUI) PaletteFormattedTextFieldUI.createUI(widthField));
                heightField.setColumns(3);
                heightField.setToolTipText(labels.getString("attribute.canvasHeight.toolTipText"));
                heightField.setFormatterFactory(JavaNumberFormatter.createFormatterFactory(1d, 4096d, 1d, true));
                heightField.setHorizontalAlignment(JTextField.LEADING);
                disposables.add(new DrawingAttributeEditorHandler<Double>(CANVAS_HEIGHT, heightField, editor));
                gbc = new GridBagConstraints();
                gbc.gridx = 4;
                gbc.gridy = 2;
                gbc.gridwidth = 2;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets = new Insets(3, 3, 0, 0);
                p3.add(heightField, gbc);

                // Add horizontal strips
                gbc = new GridBagConstraints();
                gbc.gridy = 0;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                p.add(p1, gbc);
                gbc = new GridBagConstraints();
                gbc.gridy = 1;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                p.add(p2, gbc);
                gbc = new GridBagConstraints();
                gbc.gridy = 2;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                p.add(p3, gbc);
            }
            break;
        }
        return p;
    }

    @Override
    protected String getID() {
        return "canvas";
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setOpaque(false);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
