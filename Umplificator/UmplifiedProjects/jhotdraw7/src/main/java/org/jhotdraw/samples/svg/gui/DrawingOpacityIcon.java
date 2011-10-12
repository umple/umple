/*
 * @(#)DrawingOpacityIcon.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.svg.gui;

import java.awt.*;
import java.net.*;
import org.jhotdraw.draw.*;

/**
 * {@code DrawingOpacityIcon} visualizes an opacity attribute of the
 * {@code Drawing} object which is in the active {@code DrawingView} of a
 * {@code DrawingEditor}.
 * 
 * @author Werner Randelshofer
 * @version $Id: DrawingOpacityIcon.java 723 2010-12-28 14:31:24Z rawcoder $
 */
public class DrawingOpacityIcon extends javax.swing.ImageIcon {

    private DrawingEditor editor;
    private AttributeKey<Double> opacityKey;
    private AttributeKey<Color> fillColorKey;
    private AttributeKey<Color> strokeColorKey;
    private Shape fillShape;
    private Shape strokeShape;

    /** Creates a new instance.
     * @param editor The drawing editor.
     * @param opacityKey The opacityKey of the default attribute
     * @param imageLocation the icon image
     * @param fillShape The shape to be drawn with the fillColor of the default
     * attribute.
     */
    public DrawingOpacityIcon(
            DrawingEditor editor,
            AttributeKey<Double> opacityKey,
            AttributeKey<Color> fillColorKey,
            AttributeKey<Color> strokeColorKey,
            URL imageLocation,
            Shape fillShape,
            Shape strokeShape) {
        super(imageLocation);
        this.editor = editor;
        this.opacityKey = opacityKey;
        this.fillColorKey = fillColorKey;
        this.strokeColorKey = strokeColorKey;
        this.fillShape = fillShape;
        this.strokeShape = strokeShape;
    }

    public DrawingOpacityIcon(
            DrawingEditor editor,
            AttributeKey<Double> opacityKey,
            AttributeKey<Color> fillColorKey,
            AttributeKey<Color> strokeColorKey,
            Image image,
            Shape fillShape,
            Shape strokeShape) {
        super(image);
        this.editor = editor;
        this.opacityKey = opacityKey;
        this.fillColorKey = fillColorKey;
        this.strokeColorKey = strokeColorKey;
        this.fillShape = fillShape;
        this.strokeShape = strokeShape;
    }

    @Override
    public void paintIcon(java.awt.Component c, java.awt.Graphics gr, int x, int y) {
        Graphics2D g = (Graphics2D) gr;
        super.paintIcon(c, g, x, y);
        Double opacity=0d;
        Color fillColor=null;
        Color strokeColor=null;
        if (editor != null) {
            DrawingView view = editor.getActiveView();
            if (view != null && view.getDrawing() != null) {
                Drawing d = view.getDrawing();
                opacity = d.get(opacityKey);
                fillColor = (fillColorKey == null) ? null : d.get(fillColorKey);
                strokeColor = (strokeColorKey == null) ? null : d.get(strokeColorKey);
            } else {
                opacity = opacityKey.get(editor.getDefaultAttributes());
                fillColor = (fillColorKey == null) ? null : fillColorKey.get(editor.getDefaultAttributes());
                strokeColor = (strokeColorKey == null) ? null : strokeColorKey.get(editor.getDefaultAttributes());
            }
        }

        if (fillColorKey != null && fillShape != null) {
            if (opacity != null) {
                if (fillColor == null) {
                    fillColor = Color.BLACK;
                }
                g.setColor(new Color((((int) (opacity * 255)) << 24) | (fillColor.getRGB() & 0xffffff), true));
                g.translate(x, y);
                g.fill(fillShape);
                g.translate(-x, -y);
            }
        }
        if (strokeColorKey != null && strokeShape != null) {
            if (opacity != null) {
                if (strokeColor == null) {
                    strokeColor = Color.BLACK;
                }
                g.setColor(new Color((((int) (opacity * 255)) << 24) | (strokeColor.getRGB() & 0xffffff), true));
                g.translate(x, y);
                g.draw(strokeShape);
                g.translate(-x, -y);
            }
        }
    }
}
