/*
 * @(#)ChopRoundRectangleConnector.java
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
import java.awt.geom.*;
import static org.jhotdraw.draw.AttributeKeys.*;
import org.jhotdraw.geom.*;

/**
 * A {@link Connector} which locates a connection point at the bounds
 * of a {@link RoundRectangleFigure}.
 * <p>
 *
 * @author  Werner Randelshofer
 * @version $Id: ChopRoundRectangleConnector.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class ChopRoundRectangleConnector extends ChopRectangleConnector {
    
    /**
     * Only used for DOMStorable input.
     */
    public ChopRoundRectangleConnector() {
    }
    
    public ChopRoundRectangleConnector(Figure owner) {
        super(owner);
    }
       
    @Override
    protected Point2D.Double chop(Figure target, Point2D.Double from) {
        target =  getConnectorTarget(target);
        RoundRectangleFigure rrf = (RoundRectangleFigure) target;
        Rectangle2D.Double outer = rrf.getBounds();

        double grow;
        switch (target.get(STROKE_PLACEMENT)) {
            case CENTER :
            default :
                grow = AttributeKeys.getStrokeTotalWidth(target) / 2d;
                break;
            case OUTSIDE :
                grow = AttributeKeys.getStrokeTotalWidth(target);
                break;
            case INSIDE :
                grow = 0;
                break;
        }
        Geom.grow(outer, grow, grow);
        
        
        
        Rectangle2D.Double inner = (Rectangle2D.Double) outer.clone();
        double gw = -(rrf.getArcWidth() + grow * 2) / 2;
        double gh = -(rrf.getArcHeight() + grow *2) / 2;
        inner.x -= gw;
        inner.y -= gh;
        inner.width += gw * 2;
        inner.height += gh * 2;
        
        Point2D.Double p = Geom.angleToPoint(outer, Geom.pointToAngle(outer, from));
        
        if (p.x == outer.x
        || p.x == outer.x + outer.width) {
            p.y = Math.min(Math.max(p.y, inner.y), inner.y + inner.height);
        } else {
            p.x = Math.min(Math.max(p.x, inner.x), inner.x + inner.width);
        }
        return p;
    }
}
