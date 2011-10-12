/*
 * @(#)BezierPointLocator.java
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
import org.jhotdraw.xml.*;

/**
 * A {@link Locator} which locates a node on the bezier path of a BezierFigure.
 * 
 * 
 * @author Werner Randelshofer
 * @version $Id: BezierPointLocator.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class BezierPointLocator extends AbstractLocator {
    private int index;
    private int coord;
    
    public BezierPointLocator(int index) {
        this.index = index;
        this.coord = 0;
    }
    public BezierPointLocator(int index, int coord) {
        this.index = index;
        this.coord = index;
    }
    
    @Override
    public Point2D.Double locate(Figure owner) {
        BezierFigure plf = (BezierFigure) owner;
        if (index < plf.getNodeCount()) {
            return plf.getPoint(index, coord);
        }
        return new Point2D.Double(0, 0);
    }

    @Override
    public void write(DOMOutput out) {
        out.addAttribute("index", index, 0);
        out.addAttribute("coord", coord, 0);
    }

    @Override
    public void read(DOMInput in) {
       index = in.getAttribute("index", 0);
       coord = in.getAttribute("coord", 0);
    }
    
    
}
