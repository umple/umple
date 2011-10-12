/*
 * @(#)BoundsOutlineHandle.java
 *
 * Copyright (c) 2007-2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw.handle;

import java.awt.*;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.Figure;
import static org.jhotdraw.draw.AttributeKeys.*;

/**
 * A non-interactive {@link Handle} which draws the bounds of a {@link Figure} to
 * make adjustments easier.
 *
 * @author Werner Randelshofer
 * @version $Id: BoundsOutlineHandle.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class BoundsOutlineHandle extends AbstractHandle {

    private AttributeKey<Stroke> stroke1Enabled;
    private AttributeKey<Stroke> stroke2Enabled;
    private AttributeKey<Stroke> stroke1Disabled;
    private AttributeKey<Stroke> stroke2Disabled;
    private AttributeKey<Color> strokeColor1Enabled;
    private AttributeKey<Color> strokeColor2Enabled;
    private AttributeKey<Color> strokeColor1Disabled;
    private AttributeKey<Color> strokeColor2Disabled;

    /**
     * Creates a bounds outline handle for resizing a component.
     * 
     * @param owner
     */
    public BoundsOutlineHandle(Figure owner) {
        this(owner, false, false);
    }

    /**
     * Creates a bounds outline handle for resizing or transforming a component.
     * 
     * @param owner
     */
    public BoundsOutlineHandle(Figure owner, boolean isTransformHandle, boolean isHoverHandle) {
        super(owner);
        if (isTransformHandle) {
            if (isHoverHandle) {
                stroke1Enabled = HandleAttributeKeys.TRANSFORM_BOUNDS_STROKE_1_HOVER;
                strokeColor1Enabled = HandleAttributeKeys.TRANSFORM_BOUNDS_COLOR_1_HOVER;
                stroke2Enabled = HandleAttributeKeys.TRANSFORM_BOUNDS_STROKE_2_HOVER;
                strokeColor2Enabled = HandleAttributeKeys.TRANSFORM_BOUNDS_COLOR_2_HOVER;
            } else {
                stroke1Enabled = HandleAttributeKeys.TRANSFORM_BOUNDS_STROKE_1;
                strokeColor1Enabled = HandleAttributeKeys.TRANSFORM_BOUNDS_COLOR_1;
                stroke2Enabled = HandleAttributeKeys.TRANSFORM_BOUNDS_STROKE_2;
                strokeColor2Enabled = HandleAttributeKeys.TRANSFORM_BOUNDS_COLOR_2;
            }
            stroke1Disabled = HandleAttributeKeys.TRANSFORM_BOUNDS_STROKE_1_DISABLED;
            strokeColor1Disabled = HandleAttributeKeys.TRANSFORM_BOUNDS_COLOR_1_DISABLED;
            stroke2Disabled = HandleAttributeKeys.TRANSFORM_BOUNDS_STROKE_2_DISABLED;
            strokeColor2Disabled = HandleAttributeKeys.TRANSFORM_BOUNDS_COLOR_2_DISABLED;
        } else {
            if (isHoverHandle) {
                stroke1Enabled = HandleAttributeKeys.RESIZE_BOUNDS_STROKE_1_HOVER;
                strokeColor1Enabled = HandleAttributeKeys.RESIZE_BOUNDS_COLOR_1_HOVER;
                stroke2Enabled = HandleAttributeKeys.RESIZE_BOUNDS_STROKE_2_HOVER;
                strokeColor2Enabled = HandleAttributeKeys.RESIZE_BOUNDS_COLOR_2_HOVER;
            } else {
                stroke1Enabled = HandleAttributeKeys.RESIZE_BOUNDS_STROKE_1;
                strokeColor1Enabled = HandleAttributeKeys.RESIZE_BOUNDS_COLOR_1;
                stroke2Enabled = HandleAttributeKeys.RESIZE_BOUNDS_STROKE_2;
                strokeColor2Enabled = HandleAttributeKeys.RESIZE_BOUNDS_COLOR_2;
            }
            stroke1Disabled = HandleAttributeKeys.RESIZE_BOUNDS_STROKE_1_DISABLED;
            strokeColor1Disabled = HandleAttributeKeys.RESIZE_BOUNDS_COLOR_1_DISABLED;
            stroke2Disabled = HandleAttributeKeys.RESIZE_BOUNDS_STROKE_2_DISABLED;
            strokeColor2Disabled = HandleAttributeKeys.RESIZE_BOUNDS_COLOR_2_DISABLED;
        }
    }

    /**
     * Creates a bounds outline handle for resizing or transforming a component.
     *
     * @param owner
     */
    public BoundsOutlineHandle(Figure owner, //
            AttributeKey<Stroke> stroke1Enabled, AttributeKey<Color> strokeColor1Enabled,//
            AttributeKey<Stroke> stroke2Enabled, AttributeKey<Color> strokeColor2Enabled,//
            AttributeKey<Stroke> stroke1Disabled, AttributeKey<Color> strokeColor1Disabled,//
            AttributeKey<Stroke> stroke2Disabled, AttributeKey<Color> strokeColor2Disabled
            ) {
        super(owner);
        this.stroke1Enabled = stroke1Enabled;
        this.strokeColor1Enabled = strokeColor1Enabled;
        this.stroke2Enabled = stroke2Enabled;
        this.strokeColor2Enabled = strokeColor2Enabled;
        this.stroke1Disabled = stroke1Disabled;
        this.strokeColor1Disabled = strokeColor1Disabled;
        this.stroke2Disabled = stroke2Disabled;
        this.strokeColor2Disabled = strokeColor2Disabled;
        }
    @Override
    protected Rectangle basicGetBounds() {
        Shape bounds = getOwner().getBounds();
        if (getOwner().get(TRANSFORM) != null) {
            bounds = getOwner().get(TRANSFORM).createTransformedShape(bounds);
        }
        bounds = view.getDrawingToViewTransform().createTransformedShape(bounds);

        Rectangle r = bounds.getBounds();
        r.grow(2, 2);
        return r;
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
        Shape bounds = getOwner().getBounds();
        if (getOwner().get(TRANSFORM) != null) {
            bounds = getOwner().get(TRANSFORM).createTransformedShape(bounds);
        }
        bounds = view.getDrawingToViewTransform().createTransformedShape(bounds);
        Stroke stroke1;
        Color strokeColor1;
        Stroke stroke2;
        Color strokeColor2;

        if (getEditor().getTool().supportsHandleInteraction()) {
            stroke1 = (Stroke) getEditor().getHandleAttribute(stroke1Enabled);
            strokeColor1 = (Color) getEditor().getHandleAttribute(strokeColor1Enabled);
            stroke2 = (Stroke) getEditor().getHandleAttribute(stroke2Enabled);
            strokeColor2 = (Color) getEditor().getHandleAttribute(strokeColor2Enabled);
        } else {
            stroke1 = (Stroke) getEditor().getHandleAttribute(stroke1Disabled);
            strokeColor1 = (Color) getEditor().getHandleAttribute(strokeColor1Disabled);
            stroke2 = (Stroke) getEditor().getHandleAttribute(stroke2Disabled);
            strokeColor2 = (Color) getEditor().getHandleAttribute(strokeColor2Disabled);
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