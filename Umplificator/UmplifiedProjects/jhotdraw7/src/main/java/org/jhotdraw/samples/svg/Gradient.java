/*
 * @(#)Gradient.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.svg;

import java.awt.*;
import java.awt.geom.AffineTransform;
import org.jhotdraw.draw.*;

/**
 * Represents an SVG Gradient.
 *
 * @author Werner Randelshofer
 * @version $Id: Gradient.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface Gradient extends Cloneable {
    public Paint getPaint(Figure f, double opacity);
    public boolean isRelativeToFigureBounds();
    public void transform(AffineTransform tx);
    public Object clone();
    public void makeRelativeToFigureBounds(Figure f);
}
