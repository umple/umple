/*
 * @(#)DefaultDragTracker.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw.tool;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.event.TransformEdit;
import org.jhotdraw.draw.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;

/**
 * <code>DefaultDragTracker</code> implements interactions with the content area of a
 * <code>Figure</code>.
 * <p>
 * The <code>DefaultDragTracker</code> handles one of the three states of the
 * <code>SelectionTool</code>. It comes into action, when the user presses
 * the mouse button over the content area of a <code>Figure</code>.
 * <p>
 * Design pattern:<br>
 * Name: Chain of Responsibility.<br>
 * Role: Handler.<br>
 * Partners: {@link SelectionTool} as Handler, {@link SelectAreaTracker} as 
 * Handler, {@link HandleTracker} as Handler. 
 * <p>
 * Design pattern:<br>
 * Name: State.<br>
 * Role: State.<br>
 * Partners: {@link SelectAreaTracker} as State, {@link SelectionTool} as 
 * Context, {@link HandleTracker} as State. 
 *
 * @see SelectionTool
 *
 * @author Werner Randelshofer
 * @version $Id: DefaultDragTracker.java 752 2011-08-31 05:08:50Z rawcoder $
 */
public class DefaultDragTracker extends AbstractTool implements DragTracker {

    @Nullable
    protected Figure anchorFigure;
    /**
     * The drag rectangle encompasses the bounds of all dragged figures.
     */
    @Nullable
    protected Rectangle2D.Double dragRect;
    /**
     * The previousOrigin holds the origin of all dragged figures of the
     * previous mouseDragged event. This coordinate is constrained using
     * the Constrainer of the DrawingView.
     */
    protected Point2D.Double previousOrigin;
    /**
     * The anchorOrigin holds the origin of all dragged figures of the
     * mousePressed event.
     */
    protected Point2D.Double anchorOrigin;
    /**
     * The previousPoint holds the location of the mouse of the previous
     * mouseDragged event. This coordinate is not constrained using
     * the Constrainer of the DrawingView.
     */
    protected Point2D.Double previousPoint;
    /**
     * The anchorPoint holds the location of the mouse of the
     * mousePressed event. This coordinate is not constrained using
     * the Constrainer of the DrawingView.
     */
    protected Point2D.Double anchorPoint;
    private boolean isDragging;
    @Nullable
    private HashSet<Figure> transformedFigures;

    /** Creates a new instance. */
    public DefaultDragTracker(Figure figure) {
        anchorFigure = figure;
    }

    public DefaultDragTracker() {
    }

    @Override
    public void mouseMoved(MouseEvent evt) {
        updateCursor(editor.findView((Container) evt.getSource()), evt.getPoint());
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        super.mousePressed(evt);
        DrawingView view = getView();

        if (evt.isShiftDown()) {
            view.setHandleDetailLevel(0);
            view.toggleSelection(anchorFigure);
            if (!view.isFigureSelected(anchorFigure)) {
                anchorFigure = null;
            }
        } else if (!view.isFigureSelected(anchorFigure)) {
            view.setHandleDetailLevel(0);
            view.clearSelection();
            view.addToSelection(anchorFigure);
        }

        if (!view.getSelectedFigures().isEmpty()) {

            dragRect = null;
            transformedFigures = new HashSet<Figure>();
            for (Figure f : view.getSelectedFigures()) {
                if (f.isTransformable()) {
                    transformedFigures.add(f);
                    if (dragRect == null) {
                        dragRect = f.getBounds();
                    } else {
                        dragRect.add(f.getBounds());
                    }
                }
            }

            if (dragRect != null) {
                anchorPoint = previousPoint = view.viewToDrawing(anchor);
                anchorOrigin = previousOrigin = new Point2D.Double(dragRect.x, dragRect.y);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent evt) {
        DrawingView view = getView();
        if (!transformedFigures.isEmpty()) {
            if (isDragging == false) {
                isDragging = true;
                updateCursor(editor.findView((Container) evt.getSource()), new Point(evt.getX(), evt.getY()));
            }

            Point2D.Double currentPoint = view.viewToDrawing(new Point(evt.getX(), evt.getY()));

            dragRect.x += currentPoint.x - previousPoint.x;
            dragRect.y += currentPoint.y - previousPoint.y;
            Rectangle2D.Double constrainedRect = (Rectangle2D.Double) dragRect.clone();
            if (view.getConstrainer() != null) {
                view.getConstrainer().constrainRectangle(
                        constrainedRect);
            }

            AffineTransform tx = new AffineTransform();
            tx.translate(
                    constrainedRect.x - previousOrigin.x,
                    constrainedRect.y - previousOrigin.y);
            for (Figure f : transformedFigures) {
                f.willChange();
                f.transform(tx);
                f.changed();
            }

            previousPoint = currentPoint;
            previousOrigin = new Point2D.Double(constrainedRect.x, constrainedRect.y);
        }
    }

    @Override
    public void mouseReleased(MouseEvent evt) {
        super.mouseReleased(evt);
        DrawingView view = getView();
        if (transformedFigures != null && !transformedFigures.isEmpty()) {
            isDragging = false;
            int x = evt.getX();
            int y = evt.getY();
            updateCursor(editor.findView((Container) evt.getSource()), new Point(x, y));
            Point2D.Double newPoint = view.viewToDrawing(new Point(x, y));

            Figure dropTarget = getDrawing().findFigureExcept(newPoint, transformedFigures);
            if (dropTarget != null) {
                boolean snapBack = dropTarget.handleDrop(newPoint, transformedFigures, view);
                if (snapBack) {
                    AffineTransform tx = new AffineTransform();
                    tx.translate(
                            anchorOrigin.x - previousOrigin.x,
                            anchorOrigin.y - previousOrigin.y);
                    for (Figure f : transformedFigures) {
                        f.willChange();
                        f.transform(tx);
                        f.changed();
                    }
                    Rectangle r = new Rectangle(anchor.x, anchor.y, 0, 0);
                    r.add(evt.getX(), evt.getY());
                    maybeFireBoundsInvalidated(r);
                    fireToolDone();
                    return;
                }
            }

            AffineTransform tx = new AffineTransform();
            tx.translate(
                    -anchorOrigin.x + previousOrigin.x,
                    -anchorOrigin.y + previousOrigin.y);
            if (!tx.isIdentity()) {
                getDrawing().fireUndoableEditHappened(new TransformEdit(
                        transformedFigures, tx));
            }
        }
        Rectangle r = new Rectangle(anchor.x, anchor.y, 0, 0);
        r.add(evt.getX(), evt.getY());
        maybeFireBoundsInvalidated(r);
        transformedFigures = null;
        fireToolDone();
    }

    @Override
    public void setDraggedFigure(Figure f) {
        anchorFigure = f;
    }
}
