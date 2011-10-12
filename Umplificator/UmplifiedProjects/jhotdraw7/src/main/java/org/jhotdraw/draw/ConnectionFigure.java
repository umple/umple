/*
 * @(#)ConnectionFigure.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.liner.Liner;
import org.jhotdraw.draw.connector.Connector;
import java.awt.geom.*;
import org.jhotdraw.geom.*;

/**
 * A <em>connection figure</em> connects two figures with a 
 * {@link org.jhotdraw.geom.BezierPath}.
 * <p>
 * The location of the start and end points of the bezier path is defined by
 * {@link Connector} objects, which are supplied by the connected figures.
 * <p>
 * If a connected figure is removed, the connection figure needs to be
 * removed as well. To achieve this, {@code ConnectionFigure} listens to
 * {@code figureRemoved} events sent by the two figures that it connects, and
 * then fires a {@code requestRemove} event to get removed as well.
 * <p>
 * The bezier path of the connection figure can be laid out using a {@link Liner}.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Framework</em><br>
 * Two figures can be connected using a connection figure.  The location of
 * the start or end point of the connection is handled by a connector object
 * at each connected figure.<br>
 * Contract: {@link org.jhotdraw.draw.Figure},
 * {@link org.jhotdraw.draw.ConnectionFigure},
 * {@link org.jhotdraw.draw.connector.Connector},
 * {@link org.jhotdraw.draw.tool.ConnectionTool}.
 *
 * <p><em>Strategy</em><br>
 * The control points of the bezier path of a connection figure can be laid out
 * using different layout algorithms which are implemented by a liner object.<br>
 * Context: {@link ConnectionFigure}; Strategy: {@link Liner}.
 *
 * <p><em>Strategy</em><br>
 * The location of the start and end points of a connection figure are determined
 * by {@code Connector}s which are owned by the connected figures.<br>
 * Context: {@link Figure}, {@link ConnectionFigure}; Strategy: {@link Connector}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: ConnectionFigure.java 754 2011-09-02 17:42:57Z rawcoder $
 */
public interface ConnectionFigure
        extends Figure {
    // DRAWING
    // SHAPE AND BOUNDS
    // ATTRIBUTES
    // EDITING
    // CONNECTING
    /**
     * Sets the start {@code Connector} of the connection.
     * Set this to null to disconnect the start connection.
     * @param start the start Connector of the connection
     */
    public void setStartConnector(@Nullable Connector start);
    /**
     * Gets the start {@code Connector}.
     * Returns null, if there is no start connection.
     */
    @Nullable public Connector getStartConnector();
 
    /**
     * Sets the end Connector of the connection.
     * Set this to null to disconnect the end connection.
     * @param end the end Connector of the connection
     */
    public void setEndConnector(@Nullable Connector end);
    /**
     * Gets the end Connector.
     * Returns null, if there is no end connection.
     */
    @Nullable public Connector getEndConnector();
    
    /**
     * Updates the start and end point of the figure and fires figureChanged
     * events.
     */
    public void updateConnection();
    
    /**
     * Returns true, if this ConnectionFigure can connect the specified
     * {@code Connector}s.
     * Implement this method to constrain the allowed connections between figures.
     */
    public boolean canConnect(Connector start, Connector end);
    /**
     * Checks if this {@code ConnectionFigure} can be connect to the specified
     * {@code Connector}.
     * This is used to provide an early feedback to the user, when he/she
     * creates a new connection.
     */
    public boolean canConnect(Connector start);
    
    /**
     * Sets the start point.
     */
    public void setStartPoint(Point2D.Double p);
    
    /**
     * Sets the end point.
     */
    public void setEndPoint(Point2D.Double p);
    /**
     * Sets the specified point.
     */
    public void setPoint(int index, Point2D.Double p);
    /**
     * Gets the node count.
     */
    public int getNodeCount();
    
    /**
     * Returns the specified point.
     */
    public Point2D.Double getPoint(int index);
    /**
     * Returns the specified node.
     */
    public BezierPath.Node getNode(int index);
    /**
     * Sets the specified node.
     */
    public void setNode(int index, BezierPath.Node node);
    
    /**
     * Gets the start point.
     */
    @Override
    public Point2D.Double getStartPoint();
    
    /**
     * Gets the end point.
     */
    @Override
    public Point2D.Double getEndPoint();
    
    /**
     * Gets the start figure of the connection.
     * This is a convenience method for doing getStartConnector().getOwner()
     * and handling null cases.
     */
    @Nullable public Figure getStartFigure();
    
    /**
     * Gets the end figure of the connection.
     * This is a convenience method for doing getEndConnector().getOwner()
     * and handling null cases.
     */
    @Nullable public Figure getEndFigure();
// COMPOSITE FIGURES
    /**
     * Get a Liner object which encapsulated a lineout
     * algorithm for this figure. Typically, a Liner
     * accesses the child components of this figure and arranges
     * their graphical presentation.
     *
     * @return lineout strategy used by this figure
     */
    @Nullable public Liner getLiner();
    /**
     * Set a Liner object which encapsulated a lineout
     * algorithm for this figure. Typically, a Liner
     * accesses the child components of this figure and arranges
     * their graphical presentation.
     *
     * @param newValue	encapsulation of a lineout algorithm.
     */
    public void setLiner(@Nullable Liner newValue);
    /**
     * A "lineout" algorithm is used to define how the child components
     * should be laid out in relation to each other. The task for
     * layouting the child components for presentation is delegated
     * to a Liner which can be plugged in at runtime.
     */
    public void lineout();
    // CLONING
    // EVENT HANDLING
}
