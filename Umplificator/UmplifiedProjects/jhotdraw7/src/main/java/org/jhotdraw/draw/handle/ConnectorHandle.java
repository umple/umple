/*
 * @(#)ConnectorHandle.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw.handle;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.connector.Connector;
import org.jhotdraw.draw.ConnectionFigure;
import java.util.*;
import javax.swing.undo.*;
import org.jhotdraw.util.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * A {@link Handle} associated to a {@link Connector} which allows to create a
 * new {@link ConnectionFigure} by dragging the handle to another connector.
 *
 * @author Werner Randelshofer.
 * @version $Id: ConnectorHandle.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ConnectorHandle extends AbstractHandle {

    /**
     * Holds the ConnectionFigure which is currently being created.
     */
    @Nullable private ConnectionFigure createdConnection;
    /**
     * The prototype for the ConnectionFigure to be created
     */
    private ConnectionFigure prototype;
    /**
     * The Connector.
     */
    private Connector connector;
    /**
     * The current connectable Figure.
     */
    @Nullable private Figure connectableFigure;
    /**
     * The current connectable Connector.
     */
    @Nullable private Connector connectableConnector;
    /**
     * All connectors of the connectable Figure.
     */
    protected Collection<Connector> connectors = Collections.emptyList();

    /** Creates a new instance. */
    public ConnectorHandle(Connector connector, ConnectionFigure prototype) {
        super(connector.getOwner());
        this.connector = connector;
        this.prototype = prototype;
    }

    public Point2D.Double getLocationOnDrawing() {
        return connector.getAnchor();
    }

    public Point getLocation() {
        return view.drawingToView(connector.getAnchor());
    }

    @Override
    public void draw(Graphics2D g) {
        Graphics2D gg = (Graphics2D) g.create();
        gg.transform(view.getDrawingToViewTransform());
        for (Connector c : connectors) {
            c.draw(gg);
        }
        if (createdConnection == null) {
            drawCircle(g,
                     getEditor().getHandleAttribute(HandleAttributeKeys.DISCONNECTED_CONNECTOR_HANDLE_FILL_COLOR),
                     getEditor().getHandleAttribute(HandleAttributeKeys.DISCONNECTED_CONNECTOR_HANDLE_STROKE_COLOR));
        } else {
            drawCircle(g,
                    getEditor().getHandleAttribute(HandleAttributeKeys.CONNECTED_CONNECTOR_HANDLE_FILL_COLOR),
                    getEditor().getHandleAttribute(HandleAttributeKeys.CONNECTED_CONNECTOR_HANDLE_STROKE_COLOR));
            Point p = view.drawingToView(createdConnection.getEndPoint());
            g.setColor((Color) getEditor().getHandleAttribute(HandleAttributeKeys.CONNECTED_CONNECTOR_HANDLE_FILL_COLOR));
            int width = getHandlesize();
            g.fillOval(p.x - width / 2, p.y - width / 2, width, width);
            g.setColor((Color) getEditor().getHandleAttribute(HandleAttributeKeys.CONNECTED_CONNECTOR_HANDLE_STROKE_COLOR));
            g.drawOval(p.x - width / 2, p.y - width / 2, width, width);
        }
    }

    @Override
    public void trackStart(Point anchor, int modifiersEx) {
        setConnection(createConnection());

        Point2D.Double p = getLocationOnDrawing();
        getConnection().setStartPoint(p);
        getConnection().setEndPoint(p);
        view.getDrawing().add(getConnection());
    }

    @Override
    public void trackStep(Point anchor, Point lead, int modifiersEx) {
        //updateConnectors(lead);
        Point2D.Double p = view.viewToDrawing(lead);

        fireAreaInvalidated(getDrawingArea());
        Figure figure = findConnectableFigure(p, view.getDrawing());
        if (figure != connectableFigure) {
            connectableFigure = figure;
            repaintConnectors();
        }
        connectableConnector = findConnectableConnector(figure, p);
        if (connectableConnector != null) {
            p = connectableConnector.getAnchor();
        }
        getConnection().willChange();
        getConnection().setEndPoint(p);
        getConnection().changed();
        fireAreaInvalidated(getDrawingArea());
    }

    @Override
    public Rectangle getDrawingArea() {
        if (getConnection() != null) {
            Rectangle r = new Rectangle(
                    view.drawingToView(getConnection().getEndPoint()));
            r.grow(getHandlesize(), getHandlesize());
            return r;
        } else {
            return new Rectangle(); // empty rectangle
        }
    }

    @Override
    public void trackEnd(Point anchor, Point lead, int modifiersEx) {
        Point2D.Double p = view.viewToDrawing(lead);
        view.getConstrainer().constrainPoint(p);
        Figure f = findConnectableFigure(p, view.getDrawing());
        connectableConnector = findConnectableConnector(f, p);
        if (connectableConnector != null) {
            final Drawing drawing = view.getDrawing();
            final ConnectionFigure c = getConnection();
            getConnection().setStartConnector(connector);
            getConnection().setEndConnector(connectableConnector);
            getConnection().updateConnection();
            view.clearSelection();
            view.addToSelection(c);
            view.getDrawing().fireUndoableEditHappened(new AbstractUndoableEdit() {

                @Override
                public String getPresentationName() {
                    ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                    return labels.getString("edit.createConnectionFigure.text");
                }

                @Override
                public void undo() throws CannotUndoException {
                    super.undo();
                    drawing.remove(c);
                }

                @Override
                public void redo() throws CannotRedoException {
                    super.redo();
                    drawing.add(c);
                    view.clearSelection();
                    view.addToSelection(c);
                }
            });
        } else {
            view.getDrawing().remove(getConnection());
            fireAreaInvalidated(getDrawingArea());
        }
        connectableConnector = null;
        connectors = Collections.emptyList();
        setConnection(null);
        setTargetFigure(null);
    }

    /**
     * Creates the ConnectionFigure. By default the figure prototype is
     * cloned.
     */
    protected ConnectionFigure createConnection() {
        return (ConnectionFigure) prototype.clone();
    }

    protected void setConnection(@Nullable ConnectionFigure newConnection) {
        createdConnection = newConnection;
    }

    @Nullable protected ConnectionFigure getConnection() {
        return createdConnection;
    }

    @Nullable protected Figure getTargetFigure() {
        return connectableFigure;
    }

    protected void setTargetFigure(@Nullable Figure newTargetFigure) {
        connectableFigure = newTargetFigure;
    }

    @Nullable private Figure findConnectableFigure(Point2D.Double p, Drawing drawing) {
        for (Figure figure : drawing.getFiguresFrontToBack()) {
            if (!figure.includes(getConnection()) &&
                    figure.isConnectable() &&
                    figure.contains(p)) {
                return figure;
            }

        }
        return null;
    }

    /**
     * Finds a connection end figure.
     */
    @Nullable protected Connector findConnectableConnector(Figure connectableFigure, Point2D.Double p) {
        Connector target = (connectableFigure == null) ? null : connectableFigure.findConnector(p, getConnection());

        if ((connectableFigure != null) && connectableFigure.isConnectable() && !connectableFigure.includes(getOwner()) && getConnection().canConnect(connector, target)) {
            return target;
        }
        return null;
    }

    @Override
    protected Rectangle basicGetBounds() {
        Rectangle r = new Rectangle(getLocation());
        int h = getHandlesize();
        r.x -= h / 2;
        r.y -= h / 2;
        r.width = r.height = h;
        return r;
    }

    @Override
    public boolean isCombinableWith(Handle handle) {
        return false;
    }

    /**
     * Updates the list of connectors that we draw when the user
     * moves or drags the mouse over a figure to which can connect.
     */
    public void repaintConnectors() {
        Rectangle2D.Double invalidArea = null;
        for (Connector c : connectors) {
            if (invalidArea == null) {
                invalidArea = c.getDrawingArea();
            } else {
                invalidArea.add(c.getDrawingArea());
            }
        }
        connectors = (connectableFigure == null) ? new java.util.LinkedList<Connector>() : connectableFigure.getConnectors(prototype);
        for (Connector c : connectors) {
            if (invalidArea == null) {
                invalidArea = c.getDrawingArea();
            } else {
                invalidArea.add(c.getDrawingArea());
            }
        }
        if (invalidArea != null) {
            view.getComponent().repaint(
                    view.drawingToView(invalidArea));
        }
    }
}
