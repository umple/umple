/*
 * @(#)NodeFigure.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.net.figures;

import org.jhotdraw.draw.locator.RelativeLocator;
import org.jhotdraw.draw.handle.MoveHandle;
import org.jhotdraw.draw.handle.Handle;
import org.jhotdraw.draw.connector.LocatorConnector;
import org.jhotdraw.draw.handle.ConnectorHandle;
import org.jhotdraw.draw.connector.Connector;
import java.awt.geom.*;
import java.io.*;
import java.util.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.handle.BoundsOutlineHandle;
import org.jhotdraw.geom.*;
import static org.jhotdraw.draw.AttributeKeys.*;
import org.jhotdraw.util.*;
import org.jhotdraw.xml.*;

/**
 * NodeFigure.
 *
 * @author Werner Randelshofer
 * @version $Id: NodeFigure.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class NodeFigure extends TextFigure {

    private LinkedList<Connector> connectors;
    private static LocatorConnector north;
    private static LocatorConnector south;
    private static LocatorConnector east;
    private static LocatorConnector west;

    /** Creates a new instance. */
    public NodeFigure() {
        RectangleFigure rf = new RectangleFigure();
        setDecorator(rf);
        createConnectors();
        set(DECORATOR_INSETS, new Insets2D.Double(6, 10, 6, 10));
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.net.Labels");
        setText(labels.getString("nodeDefaultName"));
        setAttributeEnabled(DECORATOR_INSETS, false);
    }

    private void createConnectors() {
        connectors = new LinkedList<Connector>();
        connectors.add(new LocatorConnector(this, RelativeLocator.north()));
        connectors.add(new LocatorConnector(this, RelativeLocator.east()));
        connectors.add(new LocatorConnector(this, RelativeLocator.west()));
        connectors.add(new LocatorConnector(this, RelativeLocator.south()));
    }

    @Override
    public Collection<Connector> getConnectors(ConnectionFigure prototype) {
        return (List<Connector>) Collections.unmodifiableList(connectors);
    }

    @Override
    public Collection<Handle> createHandles(int detailLevel) {
        java.util.List<Handle> handles = new LinkedList<Handle>();
        switch (detailLevel) {
            case -1:
                handles.add(new BoundsOutlineHandle(getDecorator(), false, true));
                break;
            case 0:
                handles.add(new MoveHandle(this, RelativeLocator.northWest()));
                handles.add(new MoveHandle(this, RelativeLocator.northEast()));
                handles.add(new MoveHandle(this, RelativeLocator.southWest()));
                handles.add(new MoveHandle(this, RelativeLocator.southEast()));
                for (Connector c : connectors) {
                    handles.add(new ConnectorHandle(c, new LineConnectionFigure()));
                }
                break;
        }
        return handles;
    }

    @Override
    public Rectangle2D.Double getFigureDrawingArea() {
        Rectangle2D.Double b = super.getFigureDrawingArea();
        // Grow for connectors
        Geom.grow(b, 10d, 10d);
        return b;
    }

    @Override
    public Connector findConnector(Point2D.Double p, ConnectionFigure figure) {
        // return closest connector
        double min = Double.MAX_VALUE;
        Connector closest = null;
        for (Connector c : connectors) {
            Point2D.Double p2 = Geom.center(c.getBounds());
            double d = Geom.length2(p.x, p.y, p2.x, p2.y);
            if (d < min) {
                min = d;
                closest = c;
            }
        }
        return closest;
    }

    @Override
    public Connector findCompatibleConnector(Connector c, boolean isStart) {
        if (c instanceof LocatorConnector) {
            LocatorConnector lc = (LocatorConnector) c;
            for (Connector cc : connectors) {
                LocatorConnector lcc = (LocatorConnector) cc;
                if (lcc.getLocator().equals(lc.getLocator())) {
                    return lcc;
                }
            }
        }
        return connectors.getFirst();
    }

    @Override
    public NodeFigure clone() {
        NodeFigure that = (NodeFigure) super.clone();
        that.createConnectors();
        return that;
    }

    @Override
    public int getLayer() {
        return -1; // stay below ConnectionFigures
    }

    @Override
    protected void writeDecorator(DOMOutput out) throws IOException {
        // do nothing
    }

    @Override
    protected void readDecorator(DOMInput in) throws IOException {
        // do nothing
    }

    @Override
    public <T> void set(AttributeKey<T> key, T newValue) {
        super.set(key, newValue);
        if (getDecorator() != null) {
            getDecorator().set(key, newValue);
        }
    }
}

