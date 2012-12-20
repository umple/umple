/*
 * @(#)DefaultHandleTracker.java
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
import org.jhotdraw.draw.handle.Handle;
import org.jhotdraw.draw.event.HandleMulticaster;
import org.jhotdraw.draw.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.*;

/**
 * DefaultHandleTracker implements interactions with the handles of a Figure.
 * <p>
 * The <code>DefaultHandleTracker</code> handles one of the three states of the
 * <code>SelectionTool</code>. Iz comes into action, when the user presses
 * the mouse button over a <code>Figure</code>.
 * <p>
 * Design pattern:<br>
 * Name: Chain of Responsibility.<br>
 * Role: Handler.<br>
 * Partners: {@link SelectionTool} as Handler, {@link SelectAreaTracker} as 
 * Handler, {@link DragTracker} as Handler, {@link DefaultHandleTracker} as Handler.
 * <p>
 * Design pattern:<br>
 * Name: State.<br>
 * Role: State.<br>
 * Partners: {@link SelectAreaTracker} as State, {@link DragTracker} as 
 * State, {@link SelectionTool} as Context. 
 *
 * @see SelectionTool
 *
 * @author Werner Randelshofer
 * @version $Id: DefaultHandleTracker.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class DefaultHandleTracker extends AbstractTool implements HandleTracker {
    /** Last dragged mouse location. This variable is only non-null when
     * the mouse is being pressed or dragged.
     */
    @Nullable private Point dragLocation;
    private Handle masterHandle;
    private HandleMulticaster multicaster;
    /**
     * The hover handles, are the handles of the figure over which the
     * mouse pointer is currently hovering.
     */
    private LinkedList<Handle> hoverHandles = new LinkedList<Handle>();
    /**
     * The hover Figure is the figure, over which the mouse is currently
     * hovering.
     */
    @Nullable private Figure hoverFigure = null;

    /** Creates a new instance. */
    public DefaultHandleTracker(Handle handle) {
        masterHandle = handle;
        multicaster = new HandleMulticaster(handle);
    }

    public DefaultHandleTracker(Handle master, Collection<Handle> handles) {
        masterHandle = master;
        multicaster = new HandleMulticaster(handles);
    }

    public DefaultHandleTracker() {
    }

    @Override
    public void draw(Graphics2D g) {
        if (hoverHandles.size() > 0 && !getView().isFigureSelected(hoverFigure)) {
            for (Handle h : hoverHandles) {
                h.draw(g);
            }
        }
    }

    /* FIXME - The handle should draw itself in selected mode
    public void draw(Graphics2D g) {
    g.setColor(Color.RED);
    g.draw(
    masterHandle.getBounds()
    );
    }*/
    @Override
    public void activate(DrawingEditor editor) {
        super.activate(editor);
        getView().setCursor(masterHandle.getCursor());
        getView().setActiveHandle(masterHandle);
        clearHoverHandles();
    }

    @Override
    public void deactivate(DrawingEditor editor) {
        super.deactivate(editor);
        getView().setCursor(Cursor.getDefaultCursor());
        getView().setActiveHandle(null);
        clearHoverHandles();
        dragLocation = null;
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        multicaster.keyPressed(evt);
        if (!evt.isConsumed()) {
            super.keyPressed(evt);

            // Forward key presses to the handler
            if (dragLocation != null) {
                multicaster.trackStep(anchor, dragLocation,
                        evt.getModifiersEx(), getView());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        multicaster.keyReleased(evt);
        // Forward key releases to the handler
        if (dragLocation != null) {
            multicaster.trackStep(anchor, dragLocation,
                    evt.getModifiersEx(), getView());
        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        multicaster.keyTyped(evt);
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            multicaster.trackDoubleClick(new Point(evt.getX(), evt.getY()),
                    evt.getModifiersEx(), getView());
        }
        evt.consume();
    }

    @Override
    public void mouseDragged(MouseEvent evt) {
        dragLocation = new Point(evt.getX(), evt.getY());
        multicaster.trackStep(anchor, dragLocation,
                evt.getModifiersEx(), getView());
        clearHoverHandles();
    }

    @Override
    public void mouseEntered(MouseEvent evt) {
    }

    @Override
    public void mouseExited(MouseEvent evt) {
        DrawingView view = editor.findView((Container) evt.getSource());
        updateHoverHandles(view, null);
        dragLocation = null;
    }

    @Override
    public void mouseMoved(MouseEvent evt) {
        Point point = evt.getPoint();
        updateCursor(editor.findView((Container) evt.getSource()), point);
        DrawingView view = editor.findView((Container) evt.getSource());
        updateCursor(view, point);
        if (view == null || editor.getActiveView() != view) {
            clearHoverHandles();
        } else {
            // Search first, if one of the selected figures contains
            // the current mouse location. Only then search for other
            // figures. This search sequence is consistent with the
            // search sequence of the SelectionTool.
            Figure figure = null;
            Point2D.Double p = view.viewToDrawing(point);
            for (Figure f : view.getSelectedFigures()) {
                if (f.contains(p)) {
                    figure = f;
                }
            }
            if (figure == null) {
                figure = view.findFigure(point);
                Drawing drawing = view.getDrawing();
                while (figure != null && !figure.isSelectable()) {
                    figure = drawing.findFigureBehind(p, figure);
                }
            }

            updateHoverHandles(view, figure);
        }
    }

    @Override
    public void mousePressed(MouseEvent evt) {
        //handle.mousePressed(evt);
        anchor = new Point(evt.getX(), evt.getY());
        multicaster.trackStart(anchor, evt.getModifiersEx(), getView());
        clearHoverHandles();
    }

    @Override
    public void mouseReleased(MouseEvent evt) {
        dragLocation = new Point(evt.getX(), evt.getY());
        multicaster.trackEnd(anchor, dragLocation,
                evt.getModifiersEx(), getView());

        // Note: we must not fire "Tool Done" in this method, because then we can not
        // listen to keyboard events for the handle.

        Rectangle r = new Rectangle(anchor.x, anchor.y, 0, 0);
        r.add(evt.getX(), evt.getY());
        maybeFireBoundsInvalidated(r);
        dragLocation = null;
    }

    protected void clearHoverHandles() {
        updateHoverHandles(null, null);
    }

    protected void updateHoverHandles(@Nullable DrawingView view, @Nullable Figure f) {
        if (f != hoverFigure) {
            Rectangle r = null;
            if (hoverFigure != null && hoverFigure.isSelectable()) {
                for (Handle h : hoverHandles) {
                    if (r == null) {
                        r = h.getDrawingArea();
                    } else {
                        r.add(h.getDrawingArea());
                    }
                    h.setView(null);
                    h.dispose();
                }
                hoverHandles.clear();
            }
            hoverFigure = f;
            if (hoverFigure != null) {
                hoverHandles.addAll(hoverFigure.createHandles(-1));
                for (Handle h : hoverHandles) {
                    h.setView(view);
                    if (r == null) {
                        r = h.getDrawingArea();
                    } else {
                        r.add(h.getDrawingArea());
                    }
                }
            }
            if (r != null) {
                r.grow(1, 1);
                fireAreaInvalidated(r);
            }
        }
    }

    @Override
    public void setHandles(Handle handle, Collection<Handle> compatibleHandles) {
        masterHandle = handle;
        multicaster = new HandleMulticaster(handle);
    }
}
