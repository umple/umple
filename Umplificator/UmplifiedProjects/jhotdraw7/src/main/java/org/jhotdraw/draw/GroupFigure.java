/*
 * @(#)GroupFigure.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw;

import java.awt.geom.*;
import org.jhotdraw.geom.*;

/**
 * A {@link org.jhotdraw.draw.Figure} which groups a collection of figures.
 *
 * @author Werner Randelshofer
 * @version $Id: GroupFigure.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class GroupFigure extends AbstractCompositeFigure {
    /** Creates a new instance. */
    public GroupFigure() {
        setConnectable(false);
    }
    
    /**
     * This is a default implementation that chops the point at the rectangle
     * returned by getBounds() of the figure.
     * <p>
     * Figures which have a non-rectangular shape need to override this method.
     * <p>
     * FIXME Invoke chop on each child and return the closest point.
     */
    public Point2D.Double chop(Point2D.Double from) {
        Rectangle2D.Double r = getBounds();
        return Geom.angleToPoint(r, Geom.pointToAngle(r, from));
    }

    /** Returns true if all children of the group are transformable. */
    @Override
    public boolean isTransformable() {
        for (Figure f : children) {
            if (! f.isTransformable()) {
                return false;
            }
        }
        return true;
    }


}
