/*
 * @(#)LineDecoration.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */


package org.jhotdraw.draw.decoration;

import org.jhotdraw.draw.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;

/**
 * A <em>line decoration</em> can be used to draw a decoration at the start or
 * end of a line.
 * <p>
 * Typically a line decoration is set as an attribute value to a
 * {@link org.jhotdraw.draw.BezierFigure} using the attribute keys
 * {@code org.jhotdraw.draw.AttributeKeys.START_DECORATION} and
 * {@code org.jhotdraw.draw.AttributeKeys.END_DECORATION}.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Decorator</em><br>
 * The start and end point of a {@code BezierFigure} can be decorated with
 * a line decoration.<br>
 * Component: {@link org.jhotdraw.draw.BezierFigure};
 * Decorator: {@link org.jhotdraw.draw.decoration.LineDecoration}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: LineDecoration.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public interface LineDecoration
extends Cloneable, Serializable {
    
    /**
     * Draws the decoration in the direction specified by the two Points.
     */
    public void draw(Graphics2D g, Figure f, Point2D.Double p1, Point2D.Double p2);
    
    /**
     * Returns the radius of the decorator.
     * This is used to crop the end of the line, to prevent it from being
     * drawn over the decorator.
     */
    public abstract double getDecorationRadius(Figure f);
    
    /**
     * Returns the drawing bounds of the decorator.
     */
    public Rectangle2D.Double getDrawingArea(Figure f, Point2D.Double p1, Point2D.Double p2);
}
