/*
 * @(#)LocatorLayouter.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.layouter;

import org.jhotdraw.draw.locator.Locator;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.CompositeFigure;
import org.jhotdraw.geom.*;
import java.awt.geom.*;

/**
 * A layouter which lays out all children of a CompositeFigure according to their
 * LayoutLocator property..
 * 
 * 
 * @author Werner Randelshofer
 * @version $Id: LocatorLayouter.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class LocatorLayouter implements Layouter {
    /**
     * LayoutLocator property used by the children to specify their location
     * relative to the compositeFigure.
     */
    public final static AttributeKey<Locator> LAYOUT_LOCATOR = new AttributeKey<Locator>("layoutLocator",Locator.class,null);
    
    /** Creates a new instance. */
    public LocatorLayouter() {
    }
    
    @Override
    public Rectangle2D.Double calculateLayout(CompositeFigure compositeFigure, Point2D.Double anchor, Point2D.Double lead) {
        Rectangle2D.Double bounds = null;
        
        for (Figure child : compositeFigure.getChildren()){
            Locator locator = getLocator(child);
            Rectangle2D.Double r;
            if (locator == null) {
                r = child.getBounds();
            } else {
                Point2D.Double p = locator.locate(compositeFigure);
                Dimension2DDouble d = child.getPreferredSize();
                r = new Rectangle2D.Double(p.x, p.y, d.width, d.height);
            }
            if (! r.isEmpty()) {
                if (bounds == null) {
                    bounds = r;
                } else {
                    bounds.add(r);
                }
            }
        }
        
        return (bounds == null) ? new Rectangle2D.Double() : bounds;
    }
    
    @Override
    public Rectangle2D.Double layout(CompositeFigure compositeFigure, Point2D.Double anchor, Point2D.Double lead) {
        Rectangle2D.Double bounds = null;
        
        for (Figure child : compositeFigure.getChildren()) {
            Locator locator = getLocator(child);

            Rectangle2D.Double r;
            if (locator == null) {
                r = child.getBounds();
            } else {
                Point2D.Double p = locator.locate(compositeFigure, child);
                Dimension2DDouble d = child.getPreferredSize();
                r = new Rectangle2D.Double(p.x, p.y, d.width, d.height);
            }
            child.willChange();
            child.setBounds(
            new Point2D.Double(r.getMinX(), r.getMinY()),
            new Point2D.Double(r.getMaxX(), r.getMaxY())
            );
            child.changed();
            if (! r.isEmpty()) {
                if (bounds == null) {
                    bounds = r;
                } else {
                    bounds.add(r);
                }
            }
        }
        
        return (bounds == null) ? new Rectangle2D.Double() : bounds;
    }
    
    private Locator getLocator(Figure f) {
        return f.get(LAYOUT_LOCATOR);
    }
}
