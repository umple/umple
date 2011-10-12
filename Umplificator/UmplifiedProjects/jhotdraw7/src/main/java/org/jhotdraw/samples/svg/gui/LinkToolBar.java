/*
 * @(#)LinkToolBar.java
 *
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.svg.gui;

import org.jhotdraw.draw.gui.JAttributeTextField;
import org.jhotdraw.draw.gui.JAttributeTextArea;
import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.event.FigureAttributeEditorHandler;
import org.jhotdraw.draw.event.SelectionComponentDisplayer;
import javax.swing.border.*;
import org.jhotdraw.gui.*;
import org.jhotdraw.util.*;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.LabelUI;
import javax.swing.plaf.TextUI;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.DefaultFormatterFactory;
import org.jhotdraw.draw.*;
import org.jhotdraw.gui.plaf.palette.*;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

/**
 * LinkToolBar.
 * 
 * @author Werner Randelshofer
 * @version $Id: LinkToolBar.java 721 2010-11-22 19:42:01Z rawcoder $
 */
public class LinkToolBar extends AbstractToolBar {

    @Nullable private SelectionComponentDisplayer displayer;
    private ResourceBundleUtil labels;

    /** Creates new instance. */
    public LinkToolBar() {
        labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        setName(labels.getString(getID() + ".toolbar"));
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
                p.setLayout(new GridBagLayout());
                p.setBorder(new EmptyBorder(5, 5, 5, 8));

                // Abort if no editor is set
                if (editor == null) {
                    break;
                }

                GridBagConstraints gbc;
                AbstractButton btn;

                // Link field
                JLabel linkLabel;
                JScrollPane scrollPane;
                JAttributeTextArea<String> linkField;

                linkLabel = new javax.swing.JLabel();
                linkLabel.setUI((LabelUI) PaletteLabelUI.createUI(linkLabel));
                linkLabel.setToolTipText(labels.getString("attribute.figureLink.toolTipText"));
                linkLabel.setText(labels.getString("attribute.figureLink.text")); // NOI18N
                linkLabel.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));

                scrollPane = new javax.swing.JScrollPane();
                linkField = new JAttributeTextArea<String>();

                linkLabel.setLabelFor(linkField);
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.insets = new Insets(-2, 0, -2, 0);
                gbc.anchor = GridBagConstraints.SOUTHWEST;
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                p.add(linkLabel, gbc);

                scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.putClientProperty("JComponent.sizeVariant", "small");
                scrollPane.setBorder(PaletteLookAndFeel.getInstance().getBorder("ScrollPane.border"));
                linkField.setToolTipText(labels.getString("attribute.figureLink.toolTipText"));
                linkField.setColumns(8);
                linkField.setLineWrap(true);
                linkField.setRows(2);
                linkField.setWrapStyleWord(true);
                linkField.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
                linkField.setFormatterFactory(new DefaultFormatterFactory(new DefaultFormatter()));
                disposables.add(new FigureAttributeEditorHandler<String>(LINK, linkField, editor, false));

                scrollPane.setViewportView(linkField);
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.insets = new Insets(3, 0, 0, 0);
                gbc.fill = GridBagConstraints.BOTH;
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.weightx = 1d;
                gbc.weighty = 1d;
                p.add(scrollPane, gbc);

                // Target field
                JLabel targetLabel;
                JAttributeTextField<String> targetField;

                targetLabel = new javax.swing.JLabel();
                targetLabel.setUI((LabelUI) PaletteLabelUI.createUI(targetLabel));
                targetLabel.setToolTipText(labels.getString("attribute.figureLinkTarget.toolTipText"));
                targetLabel.setText(labels.getString("attribute.figureLinkTarget.text")); // NOI18N
                //targetLabel.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));

                targetField = new JAttributeTextField<String>();

                targetLabel.setLabelFor(targetField);
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.insets = new Insets(3, 0, 0, 0);
                gbc.fill = GridBagConstraints.BOTH;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                p.add(targetLabel, gbc);

                targetField.setToolTipText(labels.getString("attribute.figureLinkTarget.toolTipText"));
                targetField.setColumns(4);
                //targetField.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
                targetField.setFormatterFactory(new DefaultFormatterFactory(new DefaultFormatter()));
                targetField.setUI((TextUI) PaletteFormattedTextFieldUI.createUI(targetField));
                disposables.add(new FigureAttributeEditorHandler<String>(LINK_TARGET, targetField, editor, false));
                gbc = new GridBagConstraints();
                gbc.gridx = 1;
                gbc.gridy = 2;
                gbc.insets = new Insets(3, 3, 0, 0);
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                p.add(targetField, gbc);

            }
            break;

            case 2: {
                p = new JPanel();
                p.setOpaque(false);
                p.setLayout(new GridBagLayout());
                p.setBorder(new EmptyBorder(5, 5, 5, 8));

                // Abort if no editor is set
                if (editor == null) {
                    break;
                }

                GridBagConstraints gbc;
                AbstractButton btn;

                // Link field
                JScrollPane scrollPane;
                JAttributeTextArea<String> linkField;

                scrollPane = new javax.swing.JScrollPane();
                linkField = new JAttributeTextArea<String>();

                scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.putClientProperty("JComponent.sizeVariant", "small");
                scrollPane.setBorder(PaletteLookAndFeel.getInstance().getBorder("ScrollPane.border"));
                linkField.setToolTipText(labels.getString("attribute.figureLink.toolTipText"));
                linkField.setColumns(12);
                linkField.setLineWrap(true);
                linkField.setRows(2);
                linkField.setWrapStyleWord(true);
                linkField.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
                linkField.setFormatterFactory(new DefaultFormatterFactory(new DefaultFormatter()));
                disposables.add(new FigureAttributeEditorHandler<String>(LINK, linkField, editor, false));

                scrollPane.setViewportView(linkField);
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.insets = new Insets(0, 0, 0, 0);
                gbc.fill = GridBagConstraints.BOTH;
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.weightx = 1d;
                gbc.weighty = 1d;
                p.add(scrollPane, gbc);

                // Target field
                JLabel targetLabel;
                JAttributeTextField<String> targetField;

                targetLabel = new javax.swing.JLabel();
                targetLabel.setUI((LabelUI) PaletteLabelUI.createUI(targetLabel));
                targetLabel.setToolTipText(labels.getString("attribute.figureLinkTarget.toolTipText"));
                targetLabel.setText(labels.getString("attribute.figureLinkTarget.text")); // NOI18N
                //targetLabel.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));

                targetField = new JAttributeTextField<String>();

                targetLabel.setLabelFor(targetField);
                gbc = new GridBagConstraints();
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.insets = new Insets(3, 0, 0, 0);
                gbc.fill = GridBagConstraints.BOTH;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                p.add(targetLabel, gbc);

                targetField.setToolTipText(labels.getString("attribute.figureLinkTarget.toolTipText"));
                targetField.setColumns(7);
                //targetField.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
                targetField.setFormatterFactory(new DefaultFormatterFactory(new DefaultFormatter()));
                targetField.setUI((TextUI) PaletteFormattedTextFieldUI.createUI(targetField));
                disposables.add(new FigureAttributeEditorHandler<String>(LINK_TARGET, targetField, editor, true));
                gbc = new GridBagConstraints();
                gbc.gridx = 1;
                gbc.gridy = 2;
                gbc.insets = new Insets(3, 3, 0, 0);
                gbc.fill = GridBagConstraints.HORIZONTAL;
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                gbc.anchor = GridBagConstraints.FIRST_LINE_START;
                p.add(targetField, gbc);

            }
            break;
        }
        return p;
    }

    @Override
    protected String getID() {
        return "link";
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
