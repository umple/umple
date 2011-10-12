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

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.tool.TextCreationTool;
import org.jhotdraw.draw.tool.TextAreaCreationTool;
import org.jhotdraw.draw.event.SelectionComponentRepainter;
import org.jhotdraw.draw.event.SelectionComponentDisplayer;
import javax.swing.border.*;
import org.jhotdraw.util.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.SliderUI;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.draw.event.FigureAttributeEditorHandler;
import org.jhotdraw.draw.gui.JAttributeSlider;
import org.jhotdraw.draw.gui.JAttributeTextField;
import org.jhotdraw.gui.JFontChooser;
import org.jhotdraw.gui.JPopupButton;
import org.jhotdraw.gui.plaf.palette.*;
import org.jhotdraw.text.FontFormatter;
import org.jhotdraw.text.JavaNumberFormatter;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

/**
 * StrokeToolBar.
 * 
 * @author Werner Randelshofer
 * @version $Id: FontToolBar.java 721 2010-11-22 19:42:01Z rawcoder $
 */
public class FontToolBar extends AbstractToolBar {

    @Nullable private SelectionComponentDisplayer displayer;

    /** Creates new instance. */
    public FontToolBar() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        setName(labels.getString("font.toolbar"));
        JFontChooser.loadAllFonts();
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
            displayer = new SelectionComponentDisplayer(editor, this) {

                @Override
                public void updateVisibility() {
                    boolean newValue = editor != null &&
                            editor.getActiveView() != null &&
                            (isVisibleIfCreationTool && ((editor.getTool() instanceof TextCreationTool) || editor.getTool() instanceof TextAreaCreationTool) ||
                            containsTextHolderFigure(editor.getActiveView().getSelectedFigures()));
                    JComponent component = getComponent();
                    if (component == null) {
                        dispose();
                        return;
                    }
                    component.setVisible(newValue);

                    // The following is needed to trick BoxLayout
                    if (newValue) {
                        component.setPreferredSize(null);
                    } else {
                        component.setPreferredSize(new Dimension(0, 0));
                    }

                    component.revalidate();
                }

                private boolean containsTextHolderFigure(Collection<Figure> figures) {
                    for (Figure f : figures) {
                        if (f instanceof TextHolderFigure) {
                            return true;
                        } else if (f instanceof CompositeFigure) {
                            if (containsTextHolderFigure(((CompositeFigure) f).getChildren())) {
                                return true;
                            }
                        }
                    }
                    return false;

                }
            };
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


                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");

                GridBagLayout layout = new GridBagLayout();
                p.setLayout(layout);

                GridBagConstraints gbc;
                AbstractButton btn;

                // Font face field and popup button
                JAttributeTextField<Font> faceField = new JAttributeTextField<Font>();
                faceField.setColumns(2);
                faceField.setToolTipText(labels.getString("attribute.font.toolTipText"));
                faceField.setHorizontalAlignment(JAttributeTextField.RIGHT);
                faceField.putClientProperty("Palette.Component.segmentPosition", "first");
                faceField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(faceField));
                faceField.setHorizontalAlignment(JTextField.LEADING);
                faceField.setFormatterFactory(FontFormatter.createFormatterFactory());
                disposables.add(new FigureAttributeEditorHandler<Font>(FONT_FACE, faceField, editor));
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.insets = new Insets(0, 0, 0, 0);
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.gridwidth = 2;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                p.add(faceField, gbc);
                btn = ButtonFactory.createFontButton(editor, FONT_FACE, labels, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.anchor = GridBagConstraints.WEST;
                p.add(btn, gbc);


                // Font size field with slider
                JAttributeTextField<Double> sizeField = new JAttributeTextField<Double>();
                sizeField.setColumns(1);
                sizeField.setToolTipText(labels.getString("attribute.fontSize.toolTipText"));
                sizeField.setHorizontalAlignment(JAttributeTextField.RIGHT);
                sizeField.putClientProperty("Palette.Component.segmentPosition", "first");
                sizeField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(sizeField));
                sizeField.setFormatterFactory(JavaNumberFormatter.createFormatterFactory(0d, 1000d, 1d));
                sizeField.setHorizontalAlignment(JTextField.LEADING);
                disposables.add(new FigureAttributeEditorHandler<Double>(FONT_SIZE, sizeField, editor));
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.insets = new Insets(3, 0, 0, 0);
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.gridwidth = 2;
                gbc.weightx = 1f;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                p2.add(sizeField, gbc);

                JPopupButton sizePopupButton = new JPopupButton();
                JAttributeSlider sizeSlider = new JAttributeSlider(JSlider.VERTICAL, 0, 100, 12);
                sizePopupButton.add(sizeSlider);
                labels.configureToolBarButton(sizePopupButton, "attribute.fontSize");
                sizePopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(sizePopupButton));
                sizePopupButton.setPopupAnchor(SOUTH_EAST);
                disposables.add(new SelectionComponentRepainter(editor, sizePopupButton));
                gbc = new GridBagConstraints();
                gbc.gridx = 2;
                gbc.gridy = 1;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.insets = new Insets(3, 0, 0, 0);
                p2.add(sizePopupButton, gbc);
                sizeSlider.setUI((SliderUI) PaletteSliderUI.createUI(sizeSlider));
                sizeSlider.setScaleFactor(1d);
                disposables.add(new FigureAttributeEditorHandler<Double>(FONT_SIZE, sizeSlider, editor));

                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.gridwidth = 2;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.insets = new Insets(0, 0, 0, 0);
                p.add(p2, gbc);

                // Font style buttons
                btn = ButtonFactory.createFontStyleBoldButton(editor, labels, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                btn.putClientProperty("Palette.Component.segmentPosition", "first");
                gbc = new GridBagConstraints();
                gbc.gridy = 2;
                gbc.insets = new Insets(3, 0, 0, 0);
                p.add(btn, gbc);
                btn = ButtonFactory.createFontStyleItalicButton(editor, labels, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                btn.putClientProperty("Palette.Component.segmentPosition", "middle");
                gbc = new GridBagConstraints();
                gbc.gridy = 2;
                gbc.insets = new Insets(3, 0, 0, 0);
                p.add(btn, gbc);
                btn = ButtonFactory.createFontStyleUnderlineButton(editor, labels, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                btn.putClientProperty("Palette.Component.segmentPosition", "last");
                gbc = new GridBagConstraints();
                gbc.gridy = 2;
                gbc.insets = new Insets(3, 0, 0, 0);
                gbc.anchor = GridBagConstraints.WEST;
                p.add(btn, gbc);

            }
            break;
            case 2: {
                p = new JPanel();
                p.setOpaque(false);
                p.setBorder(new EmptyBorder(5, 5, 5, 8));

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


                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");

                GridBagLayout layout = new GridBagLayout();
                p.setLayout(layout);

                GridBagConstraints gbc;
                AbstractButton btn;

                // Font face field and popup button
                JAttributeTextField<Font> faceField = new JAttributeTextField<Font>();
                faceField.setColumns(12);
                faceField.setToolTipText(labels.getString("attribute.font.toolTipText"));
                faceField.setHorizontalAlignment(JAttributeTextField.RIGHT);
                faceField.putClientProperty("Palette.Component.segmentPosition", "first");
                faceField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(faceField));
                faceField.setHorizontalAlignment(JTextField.LEADING);
                faceField.setFormatterFactory(FontFormatter.createFormatterFactory());
                disposables.add(new FigureAttributeEditorHandler<Font>(FONT_FACE, faceField, editor));
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.insets = new Insets(0, 0, 0, 0);
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.gridwidth = 3;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                p.add(faceField, gbc);
                btn = ButtonFactory.createFontButton(editor, FONT_FACE, labels, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.anchor = GridBagConstraints.WEST;
                p.add(btn, gbc);

                // Font size field with slider
                JAttributeTextField<Double> sizeField = new JAttributeTextField<Double>();
                sizeField.setColumns(1);
                sizeField.setToolTipText(labels.getString("attribute.fontSize.toolTipText"));
                sizeField.setHorizontalAlignment(JAttributeTextField.RIGHT);
                sizeField.putClientProperty("Palette.Component.segmentPosition", "first");
                sizeField.setUI((PaletteFormattedTextFieldUI) PaletteFormattedTextFieldUI.createUI(sizeField));
                sizeField.setFormatterFactory(JavaNumberFormatter.createFormatterFactory(0d, 1000d, 1d));
                sizeField.setHorizontalAlignment(JTextField.LEADING);
                disposables.add(new FigureAttributeEditorHandler<Double>(FONT_SIZE, sizeField, editor));
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.insets = new Insets(3, 0, 0, 0);
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.gridwidth = 2;
                gbc.weightx = 1f;
                gbc.fill = GridBagConstraints.HORIZONTAL;
                p2.add(sizeField, gbc);

                JPopupButton sizePopupButton = new JPopupButton();
                JAttributeSlider sizeSlider = new JAttributeSlider(JSlider.VERTICAL, 0, 100, 12);
                sizePopupButton.add(sizeSlider);
                labels.configureToolBarButton(sizePopupButton, "attribute.fontSize");
                sizePopupButton.setUI((PaletteButtonUI) PaletteButtonUI.createUI(sizePopupButton));
                sizePopupButton.setPopupAnchor(SOUTH_EAST);
                disposables.add(new SelectionComponentRepainter(editor, sizePopupButton));
                gbc = new GridBagConstraints();
                gbc.gridx = 2;
                gbc.gridy = 1;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.insets = new Insets(3, 0, 0, 0);
                p2.add(sizePopupButton, gbc);
                sizeSlider.setUI((SliderUI) PaletteSliderUI.createUI(sizeSlider));
                sizeSlider.setScaleFactor(1d);
                disposables.add(new FigureAttributeEditorHandler<Double>(FONT_SIZE, sizeSlider, editor));

                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.gridwidth = 2;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                gbc.insets = new Insets(0, 0, 0, 0);
                p.add(p2, gbc);

                // Font style buttons
                btn = ButtonFactory.createFontStyleBoldButton(editor, labels, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                btn.putClientProperty("Palette.Component.segmentPosition", "first");
                gbc = new GridBagConstraints();
                gbc.gridy = 2;
                gbc.insets = new Insets(3, 0, 0, 0);
                p.add(btn, gbc);
                btn = ButtonFactory.createFontStyleItalicButton(editor, labels, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                btn.putClientProperty("Palette.Component.segmentPosition", "middle");
                gbc = new GridBagConstraints();
                gbc.gridy = 2;
                gbc.insets = new Insets(3, 0, 0, 0);
                p.add(btn, gbc);
                btn = ButtonFactory.createFontStyleUnderlineButton(editor, labels, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                btn.putClientProperty("Palette.Component.segmentPosition", "last");
                gbc = new GridBagConstraints();
                gbc.gridy = 2;
                gbc.insets = new Insets(3, 0, 0, 0);
                gbc.anchor = GridBagConstraints.WEST;
                p.add(btn, gbc);

            }
            break;
        }
        return p;
    }

    @Override
    protected String getID() {
        return "font";
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
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
