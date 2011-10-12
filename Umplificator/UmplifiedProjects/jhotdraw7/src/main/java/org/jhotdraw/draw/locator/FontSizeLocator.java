/*
 * @(#)FontSizeLocator.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.locator;

import org.jhotdraw.draw.*;
import java.awt.geom.*;

import static org.jhotdraw.draw.AttributeKeys.*;

/**
 * {@code FontSizeLocator} is used by {@link org.jhotdraw.draw.handle.FontSizeHandle} to locate
 * its position on the drawing.
 *
 * @author  Werner Randelshofer
 * @version $Id: FontSizeLocator.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class FontSizeLocator implements Locator {
    
    /** Creates a new instance. */
    public FontSizeLocator() {
    }
    
    /**
     * Locates a position on the provided figure.
     * @return a Point2D.Double on the figure.
     */
    @Override
    public Point2D.Double locate(Figure owner) {
        Point2D.Double p = (Point2D.Double) owner.getStartPoint().clone();
        
        if (owner instanceof TextHolderFigure) {
            p.y += ((TextHolderFigure) owner).getFontSize();
            p.y += ((TextHolderFigure) owner).getInsets().top;
        } else {
            p.y += owner.get(FONT_SIZE);
        }
        
        if (owner.get(TRANSFORM) != null) {
            owner.get(TRANSFORM).transform(p, p);
        }
        
        return p;
    }
    
    @Override
    public Point2D.Double locate(Figure owner, Figure dependent) {
        return locate(owner);
    }
    
}
