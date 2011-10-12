/*
 * @(#)StrokeToolBar.java
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
import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.event.SelectionComponentRepainter;
import org.jhotdraw.draw.event.FigureAttributeEditorHandler;
import org.jhotdraw.draw.event.SelectionComponentDisplayer;
import org.jhotdraw.text.JavaNumberFormatter;
import javax.swing.border.*;
import org.jhotdraw.gui.*;
import org.jhotdraw.gui.plaf.palette.*;
import org.jhotdraw.util.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.plaf.SliderUI;
import javax.swing.text.DefaultFormatterFactory;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.text.ColorFormatter;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

/**
 * StrokeToolBar.
 * 
 * @author Werner Randelshofer
 * @version $Id: StrokeToolBar.java 721 2010-11-22 19:42:01Z rawcoder $
 */
public class StrokeToolBar extends AbstractToolBar {

    @Nullable private SelectionComponentDisplayer displayer;

    /** Creates new instance. */
    public StrokeToolBar() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        setName(labels.getString("stroke.toolbar"));
        setDisclosureStateCount(3);
    }

    @Override
    public void setEditor(DrawingEditor newValue) {
        if (displayer != null) {
            displayer.dispose();
            displayer = null;
        }
        super.setEditor(newValue);
        if (newValue != null) {
            displayer = new SelectionComponentDisplayer(editor, this);
        }
    }

    @Override
    protected JComponent createDisclosedComponent(int state) {
        JPanel p = null;

        switch (state) {
            case 1: {
                p = new JPanel();
                p.setOpaque(false);
                p.setBorder(new EmptyBorder(5, 5, 5, 8));

                // Abort if no editor is put
                if (editor == null) {
                    break;
                }

                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");

                GridBagLayout layout = new GridBagLayout();
                p.setLayout(layout);
                GridBagConstraints gbc;
                AbstractButton btn;

                // Stroke color
                Map<AttributeKey, Object> defaultAttributes = new HashMap<AttributeKey, Object>();
                STROKE_GRADIENT.put(defaultAttributes, null);
                btn = ButtonFactory.createSelectionColorChooserButton(editor,
                        STROKE_COLOR, "attribute.strokeColor", labels,
                        defaultAttributes, new Rectangle(3, 3, 10, 10), PaletteColorChooserUI.class, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                ((JPopupButton) btn).setAction(null, null);
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                p.add(btn, gbc);

                // Opacity slider
                JPopupButton opacityPopupButton = new JPopupButton();
                JAttributeSlider opacitySlider = new JAttributeSlider(JSlider.VERTICAL, 0, 100, 100);
                opacityPopupButton.add(opacitySlider);
                labels.configureToolBarButton(opacityPopupButton, "attribute.strokeOpacity");
                opacityPopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(opacityPopupButton));
                opacityPopupButton.setIcon(
                        new SelectionOpacityIcon(editor, STROKE_OPACITY, null, STROKE_COLOR, Images.createImage(getClass(), labels.getString("attribute.strokeOpacity.icon")),
                        new Rectangle(5, 5, 6, 6), new Rectangle(4, 4, 7, 7)));
                opacityPopupButton.setPopupAnchor(SOUTH_EAST);
                disposables.add(new SelectionComponentRepainter(editor, opacityPopupButton));
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.insets = new Insets(3, 0, 0, 0);
                p.add(opacityPopupButton, gbc);
                opacitySlider.setUI((SliderUI) PaletteSliderUI.createUI(opacitySlider));
                opacitySlider.setScaleFactor(100d);
                disposables.add(new FigureAttributeEditorHandler<Double>(STROKE_OPACITY, opacitySlider, editor));

                // Create stroke width popup slider
                JPopupButton strokeWidthPopupButton = new JPopupButton();
                JAttributeSlider strokeWidthSlider = new JAttributeSlider(
                        JSlider.VERTICAL, 0, 50, 1);
                strokeWidthSlider.setUI((SliderUI) PaletteSliderUI.createUI(strokeWidthSlider));
                strokeWidthPopupButton.add(strokeWidthSlider);
                labels.configureToolBarButton(strokeWidthPopupButton, "attribute.strokeWidth");
                strokeWidthPopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(strokeWidthPopupButton));
                gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.gridx = 0;
                gbc.insets = new Insets(3, 0, 0, 0);
                p.add(strokeWidthPopupButton, gbc);
                disposables.add(new FigureAttributeEditorHandler<Double>(STROKE_WIDTH, strokeWidthSlider, editor));

                // Create stroke dashes buttons
                btn = ButtonFactory.createStrokeJoinButton(editor, labels, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.gridy = 0;
                gbc.insets = new Insets(0, 3, 0, 0);
                p.add(btn, gbc);

                btn = ButtonFactory.createStrokeCapButton(editor, labels, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.gridy = 1;
                gbc.insets = new Insets(3, 3, 0, 0);
                p.add(btn, gbc);

                btn = ButtonFactory.createStrokeDashesButton(editor, new double[][]{
                            null,
                            {4d, 4d},
                            {2d, 2d},
                            {4d, 2d},
                            {2d, 4d},
                            {8d, 2d},
                            {6d, 2d, 2d, 2d},}, labels, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.gridy = 2;
                gbc.insets = new Insets(3, 3, 0, 0);
                p.add(btn, gbc);
            }
            break;

            case 2: {
                p = new JPanel();
                p.setOpaque(false);
                p.setBorder(new EmptyBorder(5, 5, 5, 8));

                // Abort if no editor is put
                if (editor == null) {
                    break;
                }

                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");

                GridBagLayout layout = new GridBagLayout();
                p.setLayout(layout);
                GridBagConstraints gbc;
                AbstractButton btn;

                // Stroke color field and button
                Map<AttributeKey, Object> defaultAttributes = new HashMap<AttributeKey, Object>();
                STROKE_GRADIENT.put(defaultAttributes, null);
                JAttributeTextField<Color> colorField = new JAttributeTextField<Color>();
                colorField.setColumns(7);
                colorField.setToolTipText(labels.getString("attribute.strokeColor.toolTipText"));
                colorField.putClientProperty("Palette.Component.segmentPosition", "first");
                colorField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(colorField));
                colorField.setFormatterFactory(ColorFormatter.createFormatterFactory(ColorFormatter.Format.RGB_INTEGER_SHORT, false, false));
                colorField.setHorizontalAlignment(JTextField.LEFT);
                disposables.add(new FigureAttributeEditorHandler<Color>(STROKE_COLOR, defaultAttributes, colorField, editor, true));
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridwidth = 3;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                p.add(colorField, gbc);
                btn = ButtonFactory.createSelectionColorChooserButton(editor,
                        STROKE_COLOR, "attribute.strokeColor", labels,
                        defaultAttributes, new Rectangle(3, 3, 10, 10), PaletteColorChooserUI.class, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                ((JPopupButton) btn).setAction(null, null);
                gbc = new GridBagConstraints();
                gbc.gridx = 3;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                p.add(btn, gbc);

                // Opacity field with slider
                JAttributeTextField<Double> opacityField = new JAttributeTextField<Double>();
                opacityField.setColumns(4);
                opacityField.setToolTipText(labels.getString("attribute.strokeOpacity.toolTipText"));
                opacityField.setHorizontalAlignment(JAttributeTextField.RIGHT);
                opacityField.putClientProperty("Palette.Component.segmentPosition", "first");
                opacityField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(opacityField));
                opacityField.setHorizontalAlignment(JTextField.LEFT);
                JavaNumberFormatter formatter = new JavaNumberFormatter(0d, 100d, 100d, false, "%");
                formatter.setUsesScientificNotation(false);
                formatter.setMaximumFractionDigits(1);
                opacityField.setFormatterFactory(new DefaultFormatterFactory(formatter));
                disposables.add(new FigureAttributeEditorHandler<Double>(STROKE_OPACITY, opacityField, editor));
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.insets = new Insets(3, 0, 0, 0);
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                p.add(opacityField, gbc);
                JPopupButton opacityPopupButton = new JPopupButton();
                JAttributeSlider opacitySlider = new JAttributeSlider(JSlider.VERTICAL, 0, 100, 100);
                opacityPopupButton.add(opacitySlider);
                labels.configureToolBarButton(opacityPopupButton, "attribute.strokeOpacity");
                opacityPopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(opacityPopupButton));
                opacityPopupButton.setIcon(
                        new SelectionOpacityIcon(editor, STROKE_OPACITY, null, STROKE_COLOR, Images.createImage(getClass(), labels.getString("attribute.strokeOpacity.icon")),
                        new Rectangle(5, 5, 6, 6), new Rectangle(4, 4, 7, 7)));
                opacityPopupButton.setPopupAnchor(SOUTH_EAST);
                disposables.add(new SelectionComponentRepainter(editor, opacityPopupButton));
                gbc = new GridBagConstraints();
                gbc.gridx = 1;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.weighty = 1f;
                gbc.insets = new Insets(3, 0, 0, 0);
                p.add(opacityPopupButton, gbc);
                opacitySlider.setUI((SliderUI) PaletteSliderUI.createUI(opacitySlider));
                opacitySlider.setScaleFactor(100d);
                disposables.add(new FigureAttributeEditorHandler<Double>(STROKE_OPACITY, opacitySlider, editor));

                // Create stroke width field with popup slider
                JAttributeTextField<Double> strokeWidthField = new JAttributeTextField<Double>();
                strokeWidthField.setColumns(2);
                strokeWidthField.setToolTipText(labels.getString("attribute.strokeWidth.toolTipText"));
                strokeWidthField.setHorizontalAlignment(JAttributeTextField.LEFT);
                strokeWidthField.putClientProperty("Palette.Component.segmentPosition", "first");
                strokeWidthField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(strokeWidthField));
                formatter = new JavaNumberFormatter(0d, 100d, 1d);
                formatter.setUsesScientificNotation(false);
                formatter.setMaximumFractionDigits(1);
                strokeWidthField.setFormatterFactory(new DefaultFormatterFactory(formatter));
                disposables.add(new FigureAttributeEditorHandler<Double>(STROKE_WIDTH, strokeWidthField, editor));
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.insets = new Insets(3, 0, 0, 0);
                gbc.fill = GridBagConstraints.BOTH;
                p.add(strokeWidthField, gbc);

                JPopupButton strokeWidthPopupButton = new JPopupButton();
                JAttributeSlider strokeWidthSlider = new JAttributeSlider(
                        JSlider.VERTICAL, 0, 50, 1);
                strokeWidthSlider.setUI((SliderUI) PaletteSliderUI.createUI(strokeWidthSlider));
                strokeWidthPopupButton.add(strokeWidthSlider);
                labels.configureToolBarButton(strokeWidthPopupButton, "attribute.strokeWidth");
                strokeWidthPopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(strokeWidthPopupButton));
                gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.gridx = 1;
                gbc.insets = new Insets(3, 0, 0, 0);
                p.add(strokeWidthPopupButton, gbc);
                disposables.add(new FigureAttributeEditorHandler<Double>(STROKE_WIDTH, strokeWidthSlider, editor));


                btn = ButtonFactory.createStrokeJoinButton(editor, labels, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.gridx = 4;
                gbc.gridy = 0;
                gbc.gridwidth = 2;
                gbc.insets = new Insets(0, 3, 0, 0);
                p.add(btn, gbc);

                btn = ButtonFactory.createStrokeCapButton(editor, labels, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                gbc = new GridBagConstraints();
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.gridx = 4;
                gbc.gridy = 1;
                gbc.insets = new Insets(3, 3, 0, 0);
                p.add(btn, gbc);

                // Create dash offset field and dashes button
                JAttributeTextField<Double> dashOffsetField = new JAttributeTextField<Double>();
                dashOffsetField.setColumns(1);
                dashOffsetField.setToolTipText(labels.getString("attribute.strokeDashPhase.toolTipText"));
                dashOffsetField.setHorizontalAlignment(JAttributeTextField.LEFT);
                //dashOffsetField.putClientProperty("Palette.Component.segmentPosition", "first");
                dashOffsetField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(dashOffsetField));
                dashOffsetField.setFormatterFactory(JavaNumberFormatter.createFormatterFactory(-1000d, 1000d, 1d));
                disposables.add(new FigureAttributeEditorHandler<Double>(STROKE_DASH_PHASE, dashOffsetField, editor));
                gbc = new GridBagConstraints();
                gbc.gridx = 2;
                gbc.gridy = 2;
                gbc.insets = new Insets(3, 3, 0, 0);
                gbc.fill = GridBagConstraints.BOTH;
                gbc.gridwidth = 2;
                p.add(dashOffsetField, gbc);

                btn = ButtonFactory.createStrokeDashesButton(editor, new double[][]{
                            null,
                            {4d, 4d},
                            {2d, 2d},
                            {4d, 2d},
                            {2d, 4d},
                            {8d, 2d},
                            {6d, 2d, 2d, 2d},}, labels, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.gridx = 4;
                gbc.gridy = 2;
                gbc.insets = new Insets(3, 3, 0, 0);
                p.add(btn, gbc);
            }
            break;
        }
        return p;
    }

    @Override
    protected String getID() {
        return "stroke";
    }

    @Override
    protected int getDefaultDisclosureState() {
        return 1;
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
