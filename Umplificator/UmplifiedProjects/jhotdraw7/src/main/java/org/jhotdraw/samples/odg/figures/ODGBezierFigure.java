/*
 * @(#)ODGBezierFigure.java
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
import org.jhotdraw.draw.handle.BezierNodeHandle;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.undo.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.geom.*;
import static org.jhotdraw.samples.odg.ODGAttributeKeys.*;

/**
 * ODGBezierFigure is not an actual ODG element, it is used by ODGPathFigure to
 * represent a single BezierPath segment within an ODG path.
 * 
 * @author Werner Randelshofer
 * @version $Id: ODGBezierFigure.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class ODGBezierFigure extends BezierFigure {

    @Nullable private transient Rectangle2D.Double cachedDrawingArea;

    /** Creates a new instance. */
    public ODGBezierFigure() {
        this(false);
    }

    public ODGBezierFigure(boolean isClosed) {
        super(isClosed);
        set(UNCLOSED_PATH_FILLED, true);
    }

    public Collection<Handle> createHandles(ODGPathFigure pathFigure, int detailLevel) {
        LinkedList<Handle> handles = new LinkedList<Handle>();
        switch (detailLevel % 2) {
            case 0:
                for (int i = 0, n = path.size(); i < n; i++) {
                    handles.add(new BezierNodeHandle(this, i, pathFigure));
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
    public boolean handleMouseClick(Point2D.Double p, MouseEvent evt, DrawingView view) {
        if (evt.getClickCount() == 2/* && view.getHandleDetailLevel() == 0*/) {
            willChange();
            final int index = splitSegment(p, (float) (5f / view.getScaleFactor()));
            if (index != -1) {
                final BezierPath.Node newNode = getNode(index);
                fireUndoableEditHappened(new AbstractUndoableEdit() {

                    @Override
                    public void redo() throws CannotRedoException {
                        super.redo();
                        willChange();
                        addNode(index, newNode);
                        changed();
                    }

                    @Override
                    public void undo() throws CannotUndoException {
                        super.undo();
                        willChange();
                        removeNode(index);
                        changed();
                    }
                });
                changed();
                evt.consume();
                return true;
            }
        }
        return false;
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
            super.transform(tx);
        }
    }

    @Override
    public Rectangle2D.Double getDrawingArea() {
        if (cachedDrawingArea == null) {

            if (get(TRANSFORM) == null) {
                cachedDrawingArea = path.getBounds2D();
            } else {
                BezierPath p2 = (BezierPath) path.clone();
                p2.transform(get(TRANSFORM));
                cachedDrawingArea = p2.getBounds2D();
            }
        }
        return (Rectangle2D.Double) cachedDrawingArea.clone();
    }

    /**
     * Transforms all coords of the figure by the current TRANSFORM attribute
     * and then sets the TRANSFORM attribute to null.
     */
    public void flattenTransform() {
        if (get(TRANSFORM) != null) {
            path.transform(get(TRANSFORM));
            set(TRANSFORM, null);
        }
        invalidate();
    }

    @Override
    public void invalidate() {
        super.invalidate();
        cachedDrawingArea = null;
    }
}
