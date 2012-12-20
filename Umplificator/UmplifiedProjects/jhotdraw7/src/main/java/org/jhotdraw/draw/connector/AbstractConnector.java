/*
 * @(#)AbstractConnector.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.connector;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.*;
import java.io.IOException;
import java.awt.*;
import java.awt.geom.*;
import org.jhotdraw.geom.*;
import org.jhotdraw.xml.DOMInput;
import org.jhotdraw.xml.DOMOutput;
import org.jhotdraw.xml.DOMStorable;
/**
 * This abstract class can be extended to implement a {@link Connector}.
 *
 * @see Connector
 *
 * @author Werner Randelshofer
 * @version $Id: AbstractConnector.java 754 2011-09-02 17:42:57Z rawcoder $
 */
public class AbstractConnector implements Connector, DOMStorable {
    /**
     * The owner of the connector
     */
    @Nullable private Figure owner;
    /**
     * Whether we should connect to the figure or to its decorator.
     */
    private boolean isConnectToDecorator;
    
    /**
     * Whether the state of this connector is persistent.
     * Set this to true only, when the user interface allows to change the
     * state of the connector.
     */
    private boolean isStatePersistent;
    
    
    /**
     * Constructs a connector that has no owner. It is only
     * used internally to resurrect a connectors from a
     * StorableOutput. It should never be called directly.
     */
    public AbstractConnector() {
        owner = null;
    }
    /**
     * Constructs a connector with the given owner figure.
     */
    public AbstractConnector(Figure owner) {
        this.owner = owner;
    }
    
    public void setConnectToDecorator(boolean newValue) {
        isConnectToDecorator = newValue;
    }
    public boolean isConnectToDecorator() {
        return isConnectToDecorator;
    }
    protected final Figure getConnectorTarget(Figure f) {
        return (isConnectToDecorator && ((DecoratedFigure) f).getDecorator() != null) ? ((DecoratedFigure) f).getDecorator() : f;
    }
    
    /**
     * Tests if a point is contained in the connector.
     * This implementation tests if the point is contained by the figure
     * object, which owns this connector.
     */
    @Override
    public boolean contains(Point2D.Double p) {
        return getOwner().contains(p);
    }
    
    @Override
    public Point2D.Double findStart(ConnectionFigure connection) {
        return findPoint(connection);
    }
    
    @Override
    public Point2D.Double findEnd(ConnectionFigure connection) {
        return findPoint(connection);
    }
    
    /**
     * Gets the connection point. Override when the connector
     * does not need to distinguish between the start and end
     * point of a connection.
     */
    protected Point2D.Double findPoint(ConnectionFigure connection) {
        return Geom.center(getBounds());
    }
    
    /**
     * Gets the connector's owner.
     */
    @Override
    public Figure getOwner() {
        return owner;
    }
    /**
     * Sets the connector's owner.
     */
    protected void setOwner(Figure newValue) {
        owner = newValue;
    }
    
    @Override
    public Object clone() {
        try {
            AbstractConnector that = (AbstractConnector) super.clone();
            return that;
        } catch (CloneNotSupportedException e) {
            InternalError error = new InternalError(e.toString());
            //error.initCause(e); <- requires JDK 1.4
            throw error;
        }
    }
    /**
     * This is called, when the start location of the connection has been
     * moved by the user. The user has this probably done, to adjust the layout.
     * The connector may use this as a hint to improve the results for the next
     * call to findEnd.
     */
    public void updateStartLocation(Point2D.Double p) {
    }
    /**
     * This is called, when the end location of the connection has been
     * moved by the user. The user has this probably done, to adjust the layout.
     * The connector may use this as a hint to improve the results for the next
     * call to findStart.
     */
    public void updateEndLocation(Point2D.Double p) {
    }
    
    @Override
    public Point2D.Double getAnchor() {
        return Geom.center(getBounds());
    }
    
    @Override
    public void updateAnchor(Point2D.Double p) {
    }
    @Override
    public Rectangle2D.Double getBounds() {
        return isConnectToDecorator() ?
            ((DecoratedFigure) getOwner()).getDecorator().getBounds() :
            getOwner().getBounds();
    }
    
    
    @Override
    public void read(DOMInput in) throws IOException {
        if (isStatePersistent) {
            isConnectToDecorator = in.getAttribute("connectToDecorator", false);
        }
        if (in.getElementCount("Owner") != 0) {
            in.openElement("Owner");
        } else {
            in.openElement("owner");
        }
        this.owner = (Figure) in.readObject(0);
        in.closeElement();
    }
    
    @Override
    public void write(DOMOutput out) throws IOException {
        if (isStatePersistent) {
            if (isConnectToDecorator) {
                out.addAttribute("connectToDecorator", true);
            }
        }
        out.openElement("Owner");
        out.writeObject(getOwner());
        out.closeElement();
    }
    
    @Override
    public Rectangle2D.Double getDrawingArea() {
        Point2D.Double anchor = getAnchor();
        return new Rectangle2D.Double(anchor.x - 4, anchor.y - 4, 8, 8);
    }
    
    @Override
    public void draw(Graphics2D g) {
        Point2D.Double anchor = getAnchor();
        Ellipse2D.Double e = new Ellipse2D.Double(anchor.x - 3, anchor.y - 3, 6, 6);
        g.setColor(Color.BLUE);
        g.fill(e);
        //g.setColor(Color.BLACK);
        //g.draw(e);
    }
}
