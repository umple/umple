/*
 * @(#)ODGAttributedFigure.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.odg.figures;

import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import org.jhotdraw.draw.*;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import org.jhotdraw.samples.odg.*;
import static org.jhotdraw.samples.odg.ODGAttributeKeys.*;
import org.jhotdraw.util.*;
/**
 * ODGAttributedFigure.
 *
 * @author Werner Randelshofer
 * @version $Id: ODGAttributedFigure.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public abstract class ODGAttributedFigure extends AbstractAttributedFigure implements ODGFigure {
    
    /** Creates a new instance. */
    public ODGAttributedFigure() {
    }
    
    @Override
    public void draw(Graphics2D g)  {
        double opacity = get(OPACITY);
        opacity = Math.min(Math.max(0d, opacity), 1d);
        if (opacity != 0d) {
            if (opacity != 1d) {
                Rectangle2D.Double drawingArea = getDrawingArea();
                
                Rectangle2D clipBounds = g.getClipBounds();
                if (clipBounds != null) {
                    Rectangle2D.intersect(drawingArea, clipBounds, drawingArea);
                }
                
                if (! drawingArea.isEmpty()) {
                    
                    BufferedImage buf = new BufferedImage(
                            (int) ((2 + drawingArea.width) * g.getTransform().getScaleX()),
                            (int) ((2 + drawingArea.height) * g.getTransform().getScaleY()),
                            BufferedImage.TYPE_INT_ARGB);
                    Graphics2D gr = buf.createGraphics();
                    gr.scale(g.getTransform().getScaleX(), g.getTransform().getScaleY());
                    gr.translate((int) -drawingArea.x, (int) -drawingArea.y);
                    gr.setRenderingHints(g.getRenderingHints());
                    drawFigure(gr);
                    gr.dispose();
                    Composite savedComposite = g.getComposite();
                    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) opacity));
                    g.drawImage(buf, (int) drawingArea.x, (int) drawingArea.y,
                            2 + (int) drawingArea.width, 2 + (int) drawingArea.height, null);
                    g.setComposite(savedComposite);
                }
            } else {
                drawFigure(g);
            }
        }
    }
    
    /**
     * This method is invoked before the rendered image of the figure is
     * composited.
     */
    public void drawFigure(Graphics2D g) {
        AffineTransform savedTransform = null;
        if (get(TRANSFORM) != null) {
            savedTransform = g.getTransform();
            g.transform(get(TRANSFORM));
        }
        
        if (get(FILL_STYLE) != ODGConstants.FillStyle.NONE) {
            Paint paint = ODGAttributeKeys.getFillPaint(this);
            if (paint != null) {
                g.setPaint(paint);
                drawFill(g);
            }
        }
        
        if (get(STROKE_STYLE) != ODGConstants.StrokeStyle.NONE) {
            Paint paint = ODGAttributeKeys.getStrokePaint(this);
            if (paint != null) {
                g.setPaint(paint);
                g.setStroke(ODGAttributeKeys.getStroke(this));
                drawStroke(g);
            }
        }
        if (get(TRANSFORM) != null) {
            g.setTransform(savedTransform);
        }
    }
    @Override
    public <T> void set(AttributeKey<T> key, T newValue) {
        if (key == TRANSFORM) {
            invalidate();
        }
        super.set(key, newValue);
    }
    @Override public Collection<Action> getActions(Point2D.Double p) {
        LinkedList<Action> actions = new LinkedList<Action>();
        if (get(TRANSFORM) != null) {
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.odg.Labels");
            actions.add(new AbstractAction(labels.getString("edit.removeTransform.text")) {
                public void actionPerformed(ActionEvent evt) {
                    willChange();
                    fireUndoableEditHappened(
                            TRANSFORM.setUndoable(ODGAttributedFigure.this, null)
                            );
                    changed();
                }
            });
        }
        return actions;
    }
}
