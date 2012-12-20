/*
 * @(#)Connector.java
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
import java.io.*;

/**
 * A <em>connector</em> knows how to locate the start point or the end point
 * of a {@link ConnectionFigure} on a connected figure.
 * <p>
 * A connector is created and owned by a {@link Figure}.
 * <p>
 * A connector knows its owning figure. A connector has bounds which describe
 * the area of the figure it is responsible for. A connector can be drawn, so
 * that users can see the bounds of the connector.<br>
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Framework</em><br>
 * Two figures can be connected using a connection figure.  The location of
 * the start or end point of the connection is handled by a connector object
 * at each connected figure.<br>
 * Contract: {@link org.jhotdraw.draw.Figure},
 * {@link ConnectionFigure},
 * {@link Connector},
 * {@link org.jhotdraw.draw.tool.ConnectionTool}.
 *
 * <p><em>Strategy</em><br>
 * The location of the start and end points of a connection figure are determined
 * by {@code Connector}s which are owned by the connected figures.<br>
 * Context: {@link Figure}, {@link ConnectionFigure}; Strategy: {@link Connector}.
 * <hr>
 *
 *
 * @author Werner Randelshofer
 * @version $Id: Connector.java 754 2011-09-02 17:42:57Z rawcoder $
 */
public interface Connector extends Cloneable, Serializable {
    
    /**
     * Finds the start point for the connection.
     */
    public Point2D.Double findStart(ConnectionFigure connection);
    
    /**
     * Finds the end point for the connection.
     */
    public Point2D.Double findEnd(ConnectionFigure connection);
    
    /**
     * Gets the connector's owner.
     */
    public Figure getOwner();
    
    /**
     * Gets the anchor of the connector.
     * This is a point at the center or at the bounds of the figure, where
     * the start or the end point will most likely be attached.
     * The purpose of this method is to give the user a hint, where the 
     * connector will most likely be attached to the owner of the connector.
     */
    public Point2D.Double getAnchor();
    /**
     * Gets the bounds of the connector.
     * This usually are the bounds of the Figure which owns the Connector.
     * The bounds can differ from the Figure bounds, if the Connector 
     * connects to a specific region of the Figure.
     */
    public Rectangle2D.Double getBounds();

    /**
     * Updates the anchor of the connector.
     * This method is called when the user manually changes the end point of
     * the ConnectionFigure. The Connector uses this as a hint for choosing
     * a new anchor position.
     */
    public void updateAnchor(Point2D.Double p);
    
    /**
     * Tests if a point is contained in the connector.
     */
    public boolean contains(Point2D.Double p);
    
    /**
     * Returns a clone of the Connection.
     */
    public Object clone();
    
    /**
     * Gets the drawing area of the connector.
     */
    public Rectangle2D.Double getDrawingArea();
    /** Draws the connector.
     */
    public void draw(Graphics2D g);
}
