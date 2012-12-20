/*
 * @(#)ODGPathFigure.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.odg.figures;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.handle.TransformHandleKit;
import org.jhotdraw.draw.handle.Handle;
import org.jhotdraw.draw.connector.Connector;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;
import javax.swing.undo.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.geom.*;
import org.jhotdraw.samples.odg.*;
import org.jhotdraw.samples.odg.ODGConstants;
import org.jhotdraw.util.*;
import static org.jhotdraw.samples.odg.ODGAttributeKeys.*;

/**
 * ODGPath is a composite Figure which contains one or more
 * ODGBezierFigures as its children.
 *
 * @author Werner Randelshofer
 * @version $Id: ODGPathFigure.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class ODGPathFigure extends AbstractAttributedCompositeFigure implements ODGFigure {

    /**
     * This cachedPath is used for drawing.
     */
    @Nullable private transient Path2D.Double cachedPath;
    //private transient Rectangle2D.Double cachedDrawingArea;
    private final static boolean DEBUG = false;

    /** Creates a new instance. */
    public ODGPathFigure() {
        add(new ODGBezierFigure());
        ODGAttributeKeys.setDefaults(this);
    }

    @Override
    public void draw(Graphics2D g) {
        double opacity = get(OPACITY);
        opacity = Math.min(Math.max(0d, opacity), 1d);
        if (opacity != 0d) {
            if (opacity != 1d) {
                Rectangle2D.Double drawingArea = getDrawingArea();

                Rectangle2D clipBounds = g.getClipBounds();
                if (clipBounds != null) {
                    Rectangle2D.intersect(drawingArea, clipBounds, drawingArea);
                }

                if (!drawingArea.isEmpty()) {

                    BufferedImage buf = new BufferedImage(
                            Math.max(1, (int) ((2 + drawingArea.width) * g.getTransform().getScaleX())),
                            Math.max(1, (int) ((2 + drawingArea.height) * g.getTransform().getScaleY())),
                            BufferedImage.TYPE_INT_ARGB);
                    Graphics2D gr = buf.createGraphics();
                    gr.scale(g.getTransform().getScaleX(), g.getTransform().getScaleY());
                    gr.translate((int) -drawingArea.x, (int) -drawingArea.y);
                    gr.setRenderingHints(g.getRenderingHints());
                    drawFigure(gr);
                    gr.dispose();
                    Composite savedComposite = g.getComposite();
                    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) opacity));
                    g.drawImage(buf, (int) drawingArea.x, (int) drawingArea.y,
                            2 + (int) drawingArea.width, 2 + (int) drawingArea.height, null);
                    g.setComposite(savedComposite);
                }
            } else {
                drawFigure(g);
            }
        }
    }

    @Override
    public void drawFigure(Graphics2D g) {
        AffineTransform savedTransform = null;
        if (get(TRANSFORM) != null) {
            savedTransform = g.getTransform();
            g.transform(get(TRANSFORM));
        }
        if (get(FILL_STYLE) != ODGConstants.FillStyle.NONE) {
            Paint paint = ODGAttributeKeys.getFillPaint(this);
            if (paint != null) {
                g.setPaint(paint);
                drawFill(g);
            }
        }

        if (get(STROKE_STYLE) != ODGConstants.StrokeStyle.NONE) {
            Paint paint = ODGAttributeKeys.getStrokePaint(this);
            if (paint != null) {
                g.setPaint(paint);
                g.setStroke(ODGAttributeKeys.getStroke(this));
                drawStroke(g);
            }
        }
        if (get(TRANSFORM) != null) {
            g.setTransform(savedTransform);
        }
    }

    @Override
    public void drawFill(Graphics2D g) {
        boolean isClosed = getChild(0).get(PATH_CLOSED);
        if (isClosed) {
            g.fill(getPath());
        }
    }

    @Override
    public void drawStroke(Graphics2D g) {
        g.draw(getPath());
    }

    @Override
    public void invalidate() {
        super.invalidate();
        cachedPath = null;
        cachedDrawingArea = null;
    }

    protected Path2D.Double getPath() {
        if (cachedPath == null) {
            cachedPath = new Path2D.Double();
            cachedPath.setWindingRule(get(WINDING_RULE) == WindingRule.EVEN_ODD
                    ? Path2D.Double.WIND_EVEN_ODD
                    : Path2D.Double.WIND_NON_ZERO);
            for (Figure child : getChildren()) {
                ODGBezierFigure b = (ODGBezierFigure) child;
                cachedPath.append(b.getBezierPath(), false);
            }
        }
        return cachedPath;
    }

    @Override
    public Rectangle2D.Double getDrawingArea() {
        if (cachedDrawingArea == null) {
            double strokeTotalWidth = AttributeKeys.getStrokeTotalWidth(this);
            double width = strokeTotalWidth / 2d;
            if (get(STROKE_JOIN) == BasicStroke.JOIN_MITER) {
                width *= get(STROKE_MITER_LIMIT);
            } else if (get(STROKE_CAP) != BasicStroke.CAP_BUTT) {
                width += strokeTotalWidth * 2;
            }
            Path2D.Double gp = (Path2D.Double) getPath();
            Rectangle2D strokeRect = new Rectangle2D.Double(0, 0, width, width);
            if (get(TRANSFORM) != null) {
                gp = (Path2D.Double) gp.clone();
                gp.transform(get(TRANSFORM));
                strokeRect = get(TRANSFORM).createTransformedShape(strokeRect).getBounds2D();
            }
            Rectangle2D rx = gp.getBounds2D();
            Rectangle2D.Double r = (rx instanceof Rectangle2D.Double)
                    ? (Rectangle2D.Double) rx
                    : new Rectangle2D.Double(rx.getX(), rx.getY(), rx.getWidth(), rx.getHeight());
            Geom.grow(r, strokeRect.getWidth(), strokeRect.getHeight());
            cachedDrawingArea = r;
        }
        return (Rectangle2D.Double) cachedDrawingArea.clone();
    }

    @Override
    public boolean contains(Point2D.Double p) {
        getPath();
        if (get(TRANSFORM) != null) {
            try {
                p = (Point2D.Double) get(TRANSFORM).inverseTransform(p, new Point2D.Double());
            } catch (NoninvertibleTransformException ex) {
                ex.printStackTrace();
            }
        }
        /*
        return cachedPath.contains(p2);
         */
        boolean isClosed = getChild(0).get(PATH_CLOSED);
        double tolerance = Math.max(2f, AttributeKeys.getStrokeTotalWidth(this) / 2d);
        if (isClosed) {
            if (getPath().contains(p)) {
                return true;
            }
            double grow = AttributeKeys.getPerpendicularHitGrowth(this) * 2d;
            GrowStroke gs = new GrowStroke(grow,
                    (AttributeKeys.getStrokeTotalWidth(this)
                    * get(STROKE_MITER_LIMIT)));
            if (gs.createStrokedShape(getPath()).contains(p)) {
                return true;
            } else {
                if (isClosed) {
                    return false;
                }
            }
        }
        if (!isClosed) {
            if (Shapes.outlineContains(getPath(), p, tolerance)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void setBounds(Point2D.Double anchor, Point2D.Double lead) {
        if (getChildCount() == 1 && ((ODGBezierFigure) getChild(0)).getNodeCount() <= 2) {
            ODGBezierFigure b = (ODGBezierFigure) getChild(0);
            b.setBounds(anchor, lead);
            invalidate();
        } else {
            super.setBounds(anchor, lead);
        }
    }

    @Override
    public void transform(AffineTransform tx) {
        if (get(TRANSFORM) != null
                || (tx.getType() & (AffineTransform.TYPE_TRANSLATION)) != tx.getType()) {
            if (get(TRANSFORM) == null) {
                TRANSFORM.setClone(this, tx);
            } else {
                AffineTransform t = TRANSFORM.getClone(this);
                t.preConcatenate(tx);
                set(TRANSFORM, t);
            }
        } else {
            for (Figure f : getChildren()) {
                f.transform(tx);
            }
            if (get(FILL_GRADIENT) != null
                    && !get(FILL_GRADIENT).isRelativeToFigureBounds()) {
                Gradient g = FILL_GRADIENT.getClone(this);
                g.transform(tx);
                set(FILL_GRADIENT, g);
            }
            if (get(STROKE_GRADIENT) != null
                    && !get(STROKE_GRADIENT).isRelativeToFigureBounds()) {
                Gradient g = STROKE_GRADIENT.getClone(this);
                g.transform(tx);
                set(STROKE_GRADIENT, g);
            }
        }
        invalidate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public void restoreTransformTo(Object geometry) {
        invalidate();
        Object[] restoreData = (Object[]) geometry;
        ArrayList<BezierPath> paths = (ArrayList<BezierPath>) restoreData[0];
        for (int i = 0, n = getChildCount(); i < n; i++) {
            getChild(i).setBezierPath(paths.get(i));
        }
        TRANSFORM.setClone(this, (AffineTransform) restoreData[1]);
        FILL_GRADIENT.setClone(this, (Gradient) restoreData[2]);
        STROKE_GRADIENT.setClone(this, (Gradient) restoreData[3]);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object getTransformRestoreData() {
        ArrayList<BezierPath> paths = new ArrayList<BezierPath>(getChildCount());
        for (int i = 0, n = getChildCount(); i < n; i++) {
            paths.add(getChild(i).getBezierPath());
        }
        return new Object[]{
                    paths,
                    TRANSFORM.getClone(this),
                    FILL_GRADIENT.getClone(this),
                    STROKE_GRADIENT.getClone(this),};
    }

    @Override
    public <T> void set(AttributeKey<T> key, T newValue) {
        super.set(key, newValue);
        invalidate();
    }

    @Override
    protected <T> void setAttributeOnChildren(AttributeKey<T> key, T newValue) {
        // empty!
    }

    @Override
    public boolean isEmpty() {
        for (Figure child : getChildren()) {
            ODGBezierFigure b = (ODGBezierFigure) child;
            if (b.getNodeCount() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Collection<Handle> createHandles(int detailLevel) {
        LinkedList<Handle> handles = new LinkedList<Handle>();
        switch (detailLevel % 2) {
            case 0:
                handles.add(new ODGPathOutlineHandle(this));
                for (Figure child : getChildren()) {
                    handles.addAll(((ODGBezierFigure) child).createHandles(this, detailLevel));
                }
                break;
            case 1:
                TransformHandleKit.addTransformHandles(this, handles);
                break;
            default:
                break;
        }
        return handles;
    }

    @Override
    public Collection<Action> getActions(Point2D.Double p) {
        final ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.odg.Labels");
        LinkedList<Action> actions = new LinkedList<Action>();
        if (get(TRANSFORM) != null) {
            actions.add(new AbstractAction(labels.getString("edit.removeTransform.text")) {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    willChange();
                    fireUndoableEditHappened(
                            TRANSFORM.setUndoable(ODGPathFigure.this, null));
                    changed();
                }
            });
            actions.add(new AbstractAction(labels.getString("edit.flattenTransform.text")) {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    // CompositeEdit edit = new CompositeEdit(labels.getString("flattenTransform"));
                    //TransformEdit edit = new TransformEdit(ODGPathFigure.this, )
                    final Object restoreData = getTransformRestoreData();
                    UndoableEdit edit = new AbstractUndoableEdit() {

                        @Override
                        public String getPresentationName() {
                            return labels.getString("flattenTransform");
                        }

                        @Override
                        public void undo() throws CannotUndoException {
                            super.undo();
                            willChange();
                            restoreTransformTo(restoreData);
                            changed();
                        }

                        @Override
                        public void redo() throws CannotRedoException {
                            super.redo();
                            willChange();
                            restoreTransformTo(restoreData);
                            flattenTransform();
                            changed();
                        }
                    };
                    willChange();
                    flattenTransform();
                    changed();
                    fireUndoableEditHappened(edit);
                }
            });
        }
        actions.add(new AbstractAction(labels.getString("closePath")) {

            @Override
            public void actionPerformed(ActionEvent evt) {
                for (Figure child : getChildren()) {
                    willChange();
                    getDrawing().fireUndoableEditHappened(
                            PATH_CLOSED.setUndoable(child, true));
                    changed();
                }
            }
        });
        actions.add(new AbstractAction(labels.getString("openPath")) {

            @Override
            public void actionPerformed(ActionEvent evt) {
                for (Figure child : getChildren()) {
                    willChange();
                    getDrawing().fireUndoableEditHappened(
                            PATH_CLOSED.setUndoable(child, false));
                    changed();
                }
            }
        });
        actions.add(new AbstractAction(labels.getString("windingRule.evenOdd")) {

            @Override
            public void actionPerformed(ActionEvent evt) {
                willChange();
                getDrawing().fireUndoableEditHappened(
                        WINDING_RULE.setUndoable(ODGPathFigure.this, WindingRule.EVEN_ODD));
                changed();
            }
        });
        actions.add(new AbstractAction(labels.getString("windingRule.nonZero")) {

            @Override
            public void actionPerformed(ActionEvent evt) {
                ODGPathFigure.this.willChange();
                getDrawing().fireUndoableEditHappened(
                        WINDING_RULE.setUndoable(ODGPathFigure.this, WindingRule.NON_ZERO));
                ODGPathFigure.this.changed();
            }
        });
        return actions;
    }
    // CONNECTING

    @Override
    public Connector findConnector(Point2D.Double p, ConnectionFigure prototype) {
        return null; // ODG does not support connectors
    }

    @Override
    public Connector findCompatibleConnector(Connector c, boolean isStartConnector) {
        return null; // ODG does not support connectors
    }

    /**
     * Handles a mouse click.
     */
    @Override
    public boolean handleMouseClick(Point2D.Double p, MouseEvent evt, DrawingView view) {
        if (evt.getClickCount() == 2 && view.getHandleDetailLevel() % 2 == 0) {
            for (Figure child : getChildren()) {
                ODGBezierFigure bf = (ODGBezierFigure) child;
                int index = bf.getBezierPath().findSegment(p, 5f / view.getScaleFactor());
                if (index != -1) {
                    bf.handleMouseClick(p, evt, view);
                    evt.consume();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void add(final int index, final Figure figure) {
        super.add(index, (ODGBezierFigure) figure);
    }

    @Override
    public ODGBezierFigure getChild(int index) {
        return (ODGBezierFigure) super.getChild(index);
    }

    @Override
    public ODGPathFigure clone() {
        ODGPathFigure that = (ODGPathFigure) super.clone();
        return that;
    }

    public void flattenTransform() {
        willChange();
        AffineTransform tx = get(TRANSFORM);
        if (tx != null) {
            for (Figure child : getChildren()) {
                ((ODGBezierFigure) child).transform(tx);
                ((ODGBezierFigure) child).flattenTransform();
            }
        }
        set(TRANSFORM, null);
        changed();
    }
}
