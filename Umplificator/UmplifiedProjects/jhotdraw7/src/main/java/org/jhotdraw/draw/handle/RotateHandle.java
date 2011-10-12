/*
 * @(#)RotateHandle.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.handle;

import org.jhotdraw.draw.*;
import java.awt.geom.*;

/**
 * A Handle to rotate a Figure.
 *
 * @author Werner Randelshofer.
 * @version $Id: RotateHandle.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class RotateHandle extends AbstractRotateHandle {
	
    /** Creates a new instance. */
    public RotateHandle(Figure owner) {
        super(owner);
    }
    
    @Override
    protected Point2D.Double getCenter() {
        Rectangle2D.Double bounds = getTransformedBounds();
    	return new Point2D.Double(bounds.getCenterX(), bounds.getCenterY());
    }

    @Override
    protected Point2D.Double getOrigin() {
        // This handle is placed above the figure.
        // We move it up by a handlesizes, so that it won't overlap with
        // the handles from TransformHandleKit.
        Rectangle2D.Double bounds = getTransformedBounds();
        Point2D.Double origin = new Point2D.Double(bounds.getCenterX(),
                bounds.y - getHandlesize() / view.getScaleFactor());
        return origin;
    }
}
