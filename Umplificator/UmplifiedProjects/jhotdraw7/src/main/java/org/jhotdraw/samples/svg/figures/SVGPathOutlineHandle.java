/*
 * @(#)SVGPathOutlineHandle.java
 *
 * Copyright (c) 2007-2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.svg.figures;

import org.jhotdraw.draw.handle.HandleAttributeKeys;
import org.jhotdraw.draw.handle.AbstractHandle;
import org.jhotdraw.draw.*;
import java.awt.*;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

/**
 * A non-interactive {@link org.jhotdraw.draw.handle.Handle} which draws the
 * outline of a {@link SVGPathFigure} to make editing easier.
 *
 * @author Werner Randelshofer
 * @version $Id: SVGPathOutlineHandle.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class SVGPathOutlineHandle extends AbstractHandle {

    /**
     * Set this to true, if the handle is used for marking a figure over
     * which the mouse pointer is hovering.
     */
    private boolean isHoverHandle = false;

    /** Creates a new instance. */
    public SVGPathOutlineHandle(SVGPathFigure owner) {
        this(owner, false);
    }

    /** Creates a new instance. */
    public SVGPathOutlineHandle(SVGPathFigure owner, boolean isHoverHandle) {
        super(owner);
        this.isHoverHandle = isHoverHandle;
    }

    @Override
    public SVGPathFigure getOwner() {
        return (SVGPathFigure) super.getOwner();
    }

    @Override
    protected Rectangle basicGetBounds() {
        return view.drawingToView(getOwner().getDrawingArea());
    }

    @Override
    public boolean contains(Point p) {
        return false;
    }

    @Override
    public void trackStart(Point anchor, int modifiersEx) {
    }

    @Override
    public void trackStep(Point anchor, Point lead, int modifiersEx) {
    }

    @Override
    public void trackEnd(Point anchor, Point lead, int modifiersEx) {
    }

    @Override
    public void draw(Graphics2D g) {
        SVGPathFigure o = getOwner();
        Shape bounds = o.getPath();
        if (o.get(TRANSFORM) != null) {
            bounds = o.get(TRANSFORM).createTransformedShape(bounds);
        }
        bounds = view.getDrawingToViewTransform().createTransformedShape(bounds);
        Stroke stroke1;
        Color strokeColor1;
        Stroke stroke2;
        Color strokeColor2;
        DrawingEditor e = getEditor();
        if (e.getTool().supportsHandleInteraction()) {
            if (isHoverHandle) {
                stroke1 = (Stroke) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_STROKE_1_HOVER);
                strokeColor1 = (Color) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_COLOR_1_HOVER);
                stroke2 = (Stroke) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_STROKE_2_HOVER);
                strokeColor2 = (Color) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_COLOR_2_HOVER);
            } else {
                stroke1 = (Stroke) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_STROKE_1);
                strokeColor1 = (Color) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_COLOR_1);
                stroke2 = (Stroke) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_STROKE_2);
                strokeColor2 = (Color) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_COLOR_2);
            }
        } else {
            stroke1 = (Stroke) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_STROKE_1_DISABLED);
            strokeColor1 = (Color) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_COLOR_1_DISABLED);
            stroke2 = (Stroke) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_STROKE_2_DISABLED);
            strokeColor2 = (Color) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_COLOR_2_DISABLED);
        }
        if (stroke1 != null && strokeColor1 != null) {
            g.setStroke(stroke1);
            g.setColor(strokeColor1);
            g.draw(bounds);
        }
        if (stroke2 != null && strokeColor2 != null) {
            g.setStroke(stroke2);
            g.setColor(strokeColor2);
            g.draw(bounds);
        }
    }
}
