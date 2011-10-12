/*
 * @(#)SelectionTool.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw.tool;

import org.jhotdraw.draw.*;
import org.jhotdraw.draw.handle.Handle;
import org.jhotdraw.draw.event.ToolEvent;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.HashSet;
import org.jhotdraw.draw.event.ToolAdapter;

/**
 * Tool to select and manipulate figures.
 * <p>
 * A selection tool is in one of three states: 1) area
 * selection, 2) figure dragging, 3) handle manipulation. The different
 * states are handled by different tracker objects: the
 * <code>DefaultSelectAreaTracker</code>, the <code>DefaultDragTracker</code> and the
 * <code>DefaultHandleTracker</code>.
 * <p>
 * A Figure can be selected by clicking at it. Holding the alt key or the
 * ctrl key down, selects the Figure behind it.
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Strategy</em><br>
 * The different behavior states of the selection tool are implemented by
 * trackers.<br>
 * Context: {@link SelectionTool}; State: {@link DragTracker},
 * {@link HandleTracker}, {@link SelectAreaTracker}.
 *
 * <p><em>Chain of responsibility</em><br>
 * Mouse and keyboard events of the user occur on the drawing view, and are
 * preprocessed by the {@code DragTracker} of a {@code SelectionTool}. In
 * turn {@code DragTracker} invokes "track" methods on a {@code Handle} which in
 * turn changes an aspect of a figure.<br>
 * Client: {@link SelectionTool}; Handler: {@link DragTracker}, {@link Handle}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: SelectionTool.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class SelectionTool extends AbstractTool {

    /**
     * The tracker encapsulates the current state of the SelectionTool.
     */
    private Tool tracker;
    /**
     * The tracker encapsulates the current state of the SelectionTool.
     */
    private HandleTracker handleTracker;
    /**
     * The tracker encapsulates the current state of the SelectionTool.
     */
    private SelectAreaTracker selectAreaTracker;
    /**
     * The tracker encapsulates the current state of the SelectionTool.
     */
    private DragTracker dragTracker;

    private class TrackerHandler extends ToolAdapter {
        @Override
    public void toolDone(ToolEvent event) {
        // Empty
        Tool newTracker = getSelectAreaTracker();

        if (newTracker != null) {
            if (tracker != null) {
                tracker.deactivate(getEditor());
                tracker.removeToolListener(this);
            }
            tracker = newTracker;
            tracker.activate(getEditor());
            tracker.addToolListener(this);
        }
        fireToolDone();
    }

    /**
     * Sent when an area of the drawing view needs to be repainted.
     */
        @Override
    public void areaInvalidated(ToolEvent e) {
        fireAreaInvalidated(e.getInvalidatedArea());
    }
    /**
     * Sent when the bounds need to be revalidated.
     */
        @Override
    public void boundsInvalidated(ToolEvent e) {
        fireBoundsInvalidated(e.getInvalidatedArea());
    }


    }
    private TrackerHandler trackerHandler;

    /**
     * Constant for the name of the selectBehindEnabled property.
     */
    public final static String SELECT_BEHIND_ENABLED_PROPERTY = "selectBehindEnabled";
    /**
     * Represents the state of the selectBehindEnabled property.
     * By default, this property is set to true.
     */
    private boolean isSelectBehindEnabled = true;

    /** Creates a new instance. */
    public SelectionTool() {
        tracker = getSelectAreaTracker();
        trackerHandler = new TrackerHandler();
        tracker.addToolListener(trackerHandler);
    }

    /**
     * Sets the selectBehindEnabled property.
     * This is a bound property.
     *
     * @param newValue The new value.
     */
    public void setSelectBehindEnabled(boolean newValue) {
        boolean oldValue = isSelectBehindEnabled;
        isSelectBehindEnabled = newValue;
        firePropertyChange(SELECT_BEHIND_ENABLED_PROPERTY, oldValue, newValue);
    }

    /**
     * Returns the value of the selectBehindEnabled property.
     * This is a bound property.
     *
     * @return The property value.
     */
    public boolean isSelectBehindEnabled() {
        return isSelectBehindEnabled;
    }

    @Override
    public void activate(DrawingEditor editor) {
        super.activate(editor);
        tracker.activate(editor);
    }

    @Override
    public void deactivate(DrawingEditor editor) {
        super.deactivate(editor);
        tracker.deactivate(editor);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (getView() != null && getView().isEnabled()) {
            tracker.keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        if (getView() != null && getView().isEnabled()) {
            tracker.keyReleased(evt);
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        if (getView() != null && getView().isEnabled()) {
            tracker.keyTyped(evt);
        }
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        if (getView() != null && getView().isEnabled()) {
            tracker.mouseClicked(evt);
        }
    }

    @Override
    public void mouseDragged(MouseEvent evt) {
        if (getView() != null && getView().isEnabled()) {
            tracker.mouseDragged(evt);
        }
    }

    @Override
    public void mouseEntered(MouseEvent evt) {
        super.mouseEntered(evt);
        tracker.mouseEntered(evt);
    }

    @Override
    public void mouseExited(MouseEvent evt) {
        super.mouseExited(evt);
        tracker.mouseExited(evt);
    }

    @Override
    public void mouseMoved(MouseEvent evt) {
        tracker.mouseMoved(evt);
    }

    @Override
    public void mouseReleased(MouseEvent evt) {
        if (getView() != null && getView().isEnabled()) {
            tracker.mouseReleased(evt);
        }
    }

    @Override
    public void draw(Graphics2D g) {
        tracker.draw(g);
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        if (getView() != null && getView().isEnabled()) {
            super.mousePressed(evt);
            DrawingView view = getView();
            Handle handle = view.findHandle(anchor);
            Tool newTracker = null;
            if (handle != null) {
                newTracker = getHandleTracker(handle);
            } else {
                Figure figure;
                Drawing drawing = view.getDrawing();
                Point2D.Double p = view.viewToDrawing(anchor);
                if (isSelectBehindEnabled() &&
                        (evt.getModifiersEx() &
                        (InputEvent.ALT_DOWN_MASK | InputEvent.CTRL_DOWN_MASK)) != 0) {
                    // Select a figure behind the current selection
                    figure = view.findFigure(anchor);
                    while (figure != null && !figure.isSelectable()) {
                        figure = drawing.findFigureBehind(p, figure);
                    }
                    HashSet<Figure> ignoredFigures = new HashSet<Figure>(view.getSelectedFigures());
                    ignoredFigures.add(figure);
                    Figure figureBehind = view.getDrawing().findFigureBehind(
                            view.viewToDrawing(anchor), ignoredFigures);
                    if (figureBehind != null) {
                        figure = figureBehind;
                    }
                } else {
                    // Note: The search sequence used here, must be
                    // consistent with the search sequence used by the
                    // DefaultHandleTracker, the DefaultSelectAreaTracker and DelegationSelectionTool.

                    // If possible, continue to work with the current selection
                    figure = null;
                    if (isSelectBehindEnabled()) {
                        for (Figure f : view.getSelectedFigures()) {
                            if (f.contains(p)) {
                                figure = f;
                                break;
                            }
                        }
                    }
                    // If the point is not contained in the current selection,
                    // search for a figure in the drawing.
                    if (figure == null) {
                        figure = view.findFigure(anchor);
                        while (figure != null && !figure.isSelectable()) {
                            figure = drawing.findFigureBehind(p, figure);
                        }
                    }
                }

                if (figure != null && figure.isSelectable()) {
                    newTracker = getDragTracker(figure);
                } else {
                    if (!evt.isShiftDown()) {
                        view.clearSelection();
                        view.setHandleDetailLevel(0);
                    }
                    newTracker = getSelectAreaTracker();
                }
            }

            if (newTracker != null) {
                setTracker(newTracker);
            }
            tracker.mousePressed(evt);
        }
    }

    protected void setTracker(Tool newTracker) {
        if (tracker != null) {
            tracker.deactivate(getEditor());
            tracker.removeToolListener(trackerHandler);
        }
        tracker = newTracker;
        if (tracker != null) {
            tracker.activate(getEditor());
            tracker.addToolListener(trackerHandler);
        }
    }

    /**
     * Method to get a {@code HandleTracker} which handles user interaction
     * for the specified handle.
     */
    protected HandleTracker getHandleTracker(Handle handle) {
        if (handleTracker == null) {
            handleTracker = new DefaultHandleTracker();
        }
        handleTracker.setHandles(handle, getView().getCompatibleHandles(handle));
        return handleTracker;
    }

    /**
     * Method to get a {@code DragTracker} which handles user interaction
     * for dragging the specified figure.
     */
    protected DragTracker getDragTracker(Figure f) {
        if (dragTracker == null) {
            dragTracker = new DefaultDragTracker();
        }
        dragTracker.setDraggedFigure(f);
        return dragTracker;
    }

    /**
     * Method to get a {@code SelectAreaTracker} which handles user interaction
     * for selecting an area on the drawing.
     */
    protected SelectAreaTracker getSelectAreaTracker() {
        if (selectAreaTracker == null) {
            selectAreaTracker = new DefaultSelectAreaTracker();
        }
        return selectAreaTracker;
    }

    /**
     * Method to set a {@code HandleTracker}. If you specify null, the
     * {@code SelectionTool} uses the {@code DefaultHandleTracker}.
     */
    public void setHandleTracker(HandleTracker newValue) {
        handleTracker = newValue;
    }

    /**
     * Method to set a {@code SelectAreaTracker}. If you specify null, the
     * {@code SelectionTool} uses the {@code DefaultSelectAreaTracker}.
     */
    public void setSelectAreaTracker(SelectAreaTracker newValue) {
        selectAreaTracker = newValue;
    }

    /**
     * Method to set a {@code DragTracker}. If you specify null, the
     * {@code SelectionTool} uses the {@code DefaultDragTracker}.
     */
    public void setDragTracker(DragTracker newValue) {
        dragTracker = newValue;
    }


    /**
     * Returns true, if this tool lets the user interact with handles.
     * <p>
     * Handles may draw differently, if interaction is not possible.
     * 
     * @return True, if this tool supports interaction with the handles.
     */
    public boolean supportsHandleInteraction() {
        return true;
    }
}