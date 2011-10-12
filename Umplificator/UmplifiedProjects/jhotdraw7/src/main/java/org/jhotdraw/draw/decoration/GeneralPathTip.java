/*
 * @(#)GeneralPathLineDecoration.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.decoration;

import java.awt.geom.*;

/**
 * A {@link LineDecoration} which draws a general path.
 *
 * @author  Werner Randelshofer
 * @version $Id: GeneralPathTip.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class GeneralPathTip extends AbstractLineDecoration {
    private Path2D.Double path;
    double decorationRadius;
    
    /** Creates a new instance. */
    public GeneralPathTip(Path2D.Double path, double decorationRadius) {
        this(path, decorationRadius, false, true, false);
    }
    public GeneralPathTip(Path2D.Double path, double decorationRadius, boolean isFilled, boolean isStroked, boolean isSolid) {
        super(isFilled, isStroked, isSolid);
        this.path = path;
        this.decorationRadius = decorationRadius;
    }
    
    @Override
    protected Path2D.Double getDecoratorPath(org.jhotdraw.draw.Figure f) {
        return (Path2D.Double) path.clone();
    }
    
    @Override
    protected double getDecoratorPathRadius(org.jhotdraw.draw.Figure f) {
        return decorationRadius;
    }
}
