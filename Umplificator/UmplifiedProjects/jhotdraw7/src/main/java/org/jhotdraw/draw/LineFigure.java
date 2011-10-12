/*
 * @(#)LineFigure.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw;

import org.jhotdraw.draw.handle.BezierOutlineHandle;
import org.jhotdraw.draw.handle.BezierNodeHandle;
import javax.swing.undo.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import org.jhotdraw.draw.handle.Handle;
import org.jhotdraw.geom.*;

/**
 * A {@link Figure} which draws a continuous bezier path between two points.
 *
 * @author Werner Randelshofer
 * @version $Id: LineFigure.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class LineFigure extends BezierFigure {
    
    /** Creates a new instance. */
    public LineFigure() {
        addNode(new BezierPath.Node(new Point2D.Double(0,0)));
        addNode(new BezierPath.Node(new Point2D.Double(0,0)));
        setConnectable(false);
    }
    
    // DRAWING
    // SHAPE AND BOUNDS
    // ATTRIBUTES
    // EDITING
    @Override
    public Collection<Handle> createHandles(int detailLevel) {
        LinkedList<Handle> handles = new LinkedList<Handle>();
        switch (detailLevel) {
            case -1 : // Mouse hover handles
                handles.add(new BezierOutlineHandle(this, true));
                break;
            case 0 :
                handles.add(new BezierOutlineHandle(this));
                for (int i=0, n = path.size(); i < n; i++) {
                    handles.add(new BezierNodeHandle(this, i));
                }
                break;
        }
        return handles;
    }
// CONNECTING
    // COMPOSITE FIGURES
    // CLONING
    // EVENT HANDLING
    /**
     * Handles a mouse click.
     */
    @Override
    public boolean handleMouseClick(Point2D.Double p, MouseEvent evt, DrawingView view) {
        if (evt.getClickCount() == 2 && view.getHandleDetailLevel() == 0) {
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
                return true;
            }
        }
        return false;
    }
}
