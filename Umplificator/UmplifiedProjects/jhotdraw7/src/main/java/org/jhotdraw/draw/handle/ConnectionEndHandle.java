/*
 * @(#)ConnectionEndHandle.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.handle;

import org.jhotdraw.draw.connector.Connector;
import org.jhotdraw.draw.*;
import java.awt.geom.*;

/**
 * A {@link Handle} which allows to connect the end of a
 * {@link ConnectionFigure} to another figure.
 *
 * @author Werner Randelshofer
 * @version $Id: ConnectionEndHandle.java -1   $
 */
public class ConnectionEndHandle extends AbstractConnectionHandle {
    
    /**
     * Constructs the connection handle for the given start figure.
     */
    public ConnectionEndHandle(ConnectionFigure owner) {
        super(owner);
    }
    
    /**
     * Sets the start of the connection.
     */
    @Override
    protected void connect(Connector c) {
        getOwner().setEndConnector(c);
    }
    
    /**
     * Disconnects the start figure.
     */
    @Override
    protected void disconnect() {
        getOwner().setEndConnector(null);
    }
    
    
    @Override
    protected Connector getTarget() {
        return getOwner().getEndConnector();
    }
    
    /**
     * Sets the start point of the connection.
     */
    @Override
    protected void setLocation(Point2D.Double p) {
        getOwner().willChange();
        getOwner().setEndPoint(p);
        getOwner().changed();
    }
    
    /**
     * Returns the start point of the connection.
     */
    @Override
    protected Point2D.Double getLocation() {
        return getOwner().getEndPoint();
    }
    
    @Override
    protected boolean canConnect(Connector existingEnd, Connector targetEnd) {
        return getOwner().canConnect(existingEnd, targetEnd);
    }
    
    @Override
    protected int getBezierNodeIndex() {
        return getBezierFigure().getNodeCount() - 1;
    }
}
