/*
 * @(#)ChopEllipseConnector.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.connector;

import org.jhotdraw.draw.*;
import java.awt.*;
import java.awt.geom.*;
import static org.jhotdraw.draw.AttributeKeys.*;
import org.jhotdraw.geom.*;
/**
 * A {@link Connector} which locates a connection point at the bounds
 * of any figure which has an elliptic shape, such as {@link org.jhotdraw.draw.EllipseFigure}.
 * <p>
 *
 * @author Werner Randelshofer
 * @version $Id: ChopEllipseConnector.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class ChopEllipseConnector extends ChopRectangleConnector {
    /** 
     * Only used for DOMStorable input.
     */
    public ChopEllipseConnector() {
    }
    
    public ChopEllipseConnector(Figure owner) {
        super(owner);
    }
    
    private Color getStrokeColor(Figure f) {
        return f.get(STROKE_COLOR);
    }
    private float getStrokeWidth(Figure f) {
        Double w = f.get(STROKE_WIDTH);
        return (w == null) ? 1f : w.floatValue();
    }

    @Override
    protected Point2D.Double chop(Figure target, Point2D.Double from) {
        target =  getConnectorTarget(target);
        Rectangle2D.Double r = target.getBounds();
        if (getStrokeColor(target) != null) {
            double grow;
            switch (target.get(STROKE_PLACEMENT)) {
                case CENTER:
                 default :
                    grow = getStrokeTotalWidth(target) / 2d;
                    break;
                case OUTSIDE :
                    grow = getStrokeTotalWidth(target);
                    break;
                case INSIDE :
                    grow = 0f;
                    break;
            }
            Geom.grow(r, grow, grow);
        }
        double angle = Geom.pointToAngle(r, from);
        return Geom.ovalAngleToPoint(r, angle);
    }
}
