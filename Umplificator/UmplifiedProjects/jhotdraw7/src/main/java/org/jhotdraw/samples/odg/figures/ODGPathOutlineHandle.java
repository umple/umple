/*
 * @(#)ODGPathOutlineHandle.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.odg.figures;

import org.jhotdraw.draw.handle.AbstractHandle;
import java.awt.*;
import static org.jhotdraw.samples.odg.ODGAttributeKeys.*;

/**
 * A non-interactive {@link org.jhotdraw.draw.handle.Handle} which draws the outline of a
 * {@link ODGPathFigure} to make adjustments easier.
 * 
 * @author Werner Randelshofer
 * @version $Id: ODGPathOutlineHandle.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class ODGPathOutlineHandle extends AbstractHandle {
    private final static Color HANDLE_FILL_COLOR = new Color(0x00a8ff);
    private final static Color HANDLE_STROKE_COLOR = Color.WHITE;
    
    /** Creates a new instance. */
    public ODGPathOutlineHandle(ODGPathFigure owner) {
        super(owner);
    }
    
    @Override
    public ODGPathFigure getOwner() {
        return (ODGPathFigure) super.getOwner();
    }
    
    @Override
    protected Rectangle basicGetBounds() {
        return view.drawingToView(getOwner().getDrawingArea());
    }
    @Override public boolean contains(Point p) {
        return false;
    }
    
    @Override
    public void trackStart(Point anchor, int modifiersEx) {
    }
    
    @Override
    public void trackStep(Point anchor, Point lead, int modifiersEx) {
    }
    
    public void trackEnd(Point anchor, Point lead, int modifiersEx) {
    }
    
    @Override public void draw(Graphics2D g) {
        Shape bounds = getOwner().getPath();
        if (getOwner().get(TRANSFORM) != null) {
            bounds = getOwner().get(TRANSFORM).createTransformedShape(bounds);
        }
        bounds = view.getDrawingToViewTransform().createTransformedShape(bounds);
        g.setColor(HANDLE_FILL_COLOR);
        g.draw(bounds);
    }
}
