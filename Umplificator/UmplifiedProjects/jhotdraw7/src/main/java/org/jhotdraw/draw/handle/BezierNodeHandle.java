/*
 * @(#)BezierNodeHandle.java
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
import org.jhotdraw.draw.event.BezierNodeEdit;
import org.jhotdraw.draw.*;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import org.jhotdraw.util.*;
import org.jhotdraw.undo.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import org.jhotdraw.geom.*;
import static org.jhotdraw.draw.AttributeKeys.*;

/**
 * A {@link Handle} which allows to interactively change a node of a bezier path.
 *
 *
 * @author Werner Randelshofer
 * @version $Id: BezierNodeHandle.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class BezierNodeHandle extends AbstractHandle {

    protected int index;
    private CompositeEdit edit;
    private BezierPath.Node oldNode;
    @Nullable private Figure transformOwner;

    /** Creates a new instance. */
    public BezierNodeHandle(BezierFigure owner, int index) {
        this(owner, index, owner);
    }

    public BezierNodeHandle(BezierFigure owner, int index, Figure transformOwner) {
        super(owner);
        this.index = index;
        this.transformOwner = transformOwner;
        transformOwner.addFigureListener(this);
    }

    @Override
    public void dispose() {
        super.dispose();
        transformOwner.removeFigureListener(this);
        transformOwner = null;
    }

    /**
     * Draws this handle.
     */
    @Override
    public void draw(Graphics2D g) {
        BezierFigure f = getOwner();
        int size = f.getNodeCount();
        boolean isClosed = f.isClosed();
        Color fillColor;
        Color strokeColor;
        if (getEditor().getTool().supportsHandleInteraction()) {
            fillColor = (Color) getEditor().getHandleAttribute(HandleAttributeKeys.BEZIER_NODE_HANDLE_FILL_COLOR);
            strokeColor = (Color) getEditor().getHandleAttribute(HandleAttributeKeys.BEZIER_NODE_HANDLE_STROKE_COLOR);
        } else {
            fillColor = (Color) getEditor().getHandleAttribute(HandleAttributeKeys.BEZIER_NODE_HANDLE_FILL_COLOR_DISABLED);
            strokeColor = (Color) getEditor().getHandleAttribute(HandleAttributeKeys.BEZIER_NODE_HANDLE_STROKE_COLOR_DISABLED);
        }
        if (size > index) {
            BezierPath.Node v = f.getNode(index);
            if (v.mask == 0 ||
                    index == 0 && v.mask == BezierPath.C1_MASK && !isClosed ||
                    index == size - 1 && v.mask == BezierPath.C2_MASK && !isClosed) {
                drawRectangle(g, fillColor, strokeColor);
            } else if (v.mask == BezierPath.C1_MASK ||
                    v.mask == BezierPath.C2_MASK ||
                    index == 0 && !isClosed ||
                    index == size - 1 && !isClosed) {
                drawDiamond(g, fillColor, strokeColor);
            } else {
                drawCircle(g, fillColor, strokeColor);
            }
        }
    }

    @Override
    public BezierFigure getOwner() {
        return (BezierFigure) super.getOwner();
    }

    protected Point getLocation() {
        if (getOwner().getNodeCount() > index) {
            Point2D.Double p = getOwner().getPoint(index, 0);
            if (getTransformOwner().get(TRANSFORM) != null) {
                getTransformOwner().get(TRANSFORM).transform(p, p);
            }
            return view.drawingToView(p);
        } else {
            return new Point(10, 10);
        }
    }

    @Nullable
    protected BezierPath.Node getBezierNode() {
        return getOwner().getNodeCount() > index ? getOwner().getNode(index) : null;
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

    protected Figure getTransformOwner() {
        return transformOwner;
    }

    @Override
    public void trackStart(Point anchor, int modifiersEx) {
        BezierFigure figure = getOwner();
        view.getDrawing().fireUndoableEditHappened(edit = new CompositeEdit("Punkt verschieben"));
        oldNode = figure.getNode(index);
        fireHandleRequestSecondaryHandles();
    }

    @Override
    public void trackStep(Point anchor, Point lead, int modifiersEx) {
        BezierFigure figure = getOwner();
        figure.willChange();
        Point2D.Double p = view.getConstrainer().constrainPoint(view.viewToDrawing(lead));

        if (getTransformOwner().get(TRANSFORM) != null) {
            try {
                getTransformOwner().get(TRANSFORM).inverseTransform(p, p);
            } catch (NoninvertibleTransformException ex) {
                ex.printStackTrace();
            }
        }

        BezierPath.Node n = figure.getNode(index);
        //fireAreaInvalidated(n);
        n.moveTo(p);
        //fireAreaInvalidated(n);
        figure.setNode(index, n);
        figure.changed();
    }

    private void fireAreaInvalidated(BezierPath.Node v) {
        Rectangle2D.Double dr = new Rectangle2D.Double(v.x[0], v.y[0], 0, 0);
        for (int i = 1; i < 3; i++) {
            dr.add(v.x[i], v.y[i]);
        }
        Rectangle vr = view.drawingToView(dr);
        vr.grow(getHandlesize(), getHandlesize());
        fireAreaInvalidated(vr);
    }

    @Override
    public void trackEnd(Point anchor, Point lead, int modifiersEx) {
        final BezierFigure f = getOwner();
             BezierPath.Node oldValue = (BezierPath.Node) oldNode.clone();;
             BezierPath.Node newValue = f.getNode(index);

        // Change node type
        if ((modifiersEx & (InputEvent.META_DOWN_MASK | InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK)) != 0 &&
                (modifiersEx & InputEvent.BUTTON2_MASK) == 0) {
            f.willChange();
            if (index > 0 && index < f.getNodeCount() || f.isClosed()) {
                newValue.mask = (newValue.mask + 3) % 4;
            } else if (index == 0) {
                newValue.mask = ((newValue.mask & BezierPath.C2_MASK) == 0) ? BezierPath.C2_MASK : 0;
            } else {
                newValue.mask = ((newValue.mask & BezierPath.C1_MASK) == 0) ? BezierPath.C1_MASK : 0;
            }
            f.setNode(index, newValue);
            f.changed();
            fireHandleRequestSecondaryHandles();
        }
            view.getDrawing().fireUndoableEditHappened(new BezierNodeEdit(f, index, oldValue, newValue) {

                @Override
                public void redo() throws CannotRedoException {
                    super.redo();
                    fireHandleRequestSecondaryHandles();
                }

                @Override
                public void undo() throws CannotUndoException {
                    super.undo();
                    fireHandleRequestSecondaryHandles();
                }
            });
            view.getDrawing().fireUndoableEditHappened(edit);
    }

    @Override
    public boolean isCombinableWith(Handle h) {
        /*
        if (super.isCombinableWith(h)) {
        BezierNodeHandle that = (BezierNodeHandle) h;
        return that.index == this.index &&
        that.getOwner().getNodeCount() ==
        this.getOwner().getNodeCount();
        }*/
        return false;
    }

    @Override
    public void trackDoubleClick(Point p, int modifiersEx) {
        final BezierFigure f = getOwner();
        if (f.getNodeCount() > 2 &&
                (modifiersEx &
                (InputEvent.META_DOWN_MASK | InputEvent.CTRL_DOWN_MASK | InputEvent.ALT_DOWN_MASK)) == 0) {
            Rectangle invalidatedArea = getDrawingArea();
            f.willChange();
            final BezierPath.Node removedNode = f.removeNode(index);
            f.changed();
            fireHandleRequestRemove(invalidatedArea);
            fireUndoableEditHappened(new AbstractUndoableEdit() {

                @Override
                public String getPresentationName() {
                    ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                    return labels.getString("edit.bezierPath.joinSegments.text");
                }

                @Override
                public void redo() throws CannotRedoException {
                    super.redo();
                    view.removeFromSelection(f);
                    f.willChange();
                    f.removeNode(index);
                    f.changed();
                    view.addToSelection(f);
                }

                @Override
                public void undo() throws CannotUndoException {
                    super.undo();
                    view.removeFromSelection(f);
                    f.willChange();
                    f.addNode(index, removedNode);
                    f.changed();
                    view.addToSelection(f);
                }
            });
        }
    }

    @Override
    public Collection<Handle> createSecondaryHandles() {
        BezierFigure f = getOwner();
        LinkedList<Handle> list = new LinkedList<Handle>();
        BezierPath.Node v = f.getNode(index);
        if ((v.mask & BezierPath.C1_MASK) != 0 &&
                (index != 0 || f.isClosed())) {
            list.add(new BezierControlPointHandle(f, index, 1, getTransformOwner()));
        }
        if ((v.mask & BezierPath.C2_MASK) != 0 &&
                (index < f.getNodeCount() - 1 ||
                f.isClosed())) {
            list.add(new BezierControlPointHandle(f, index, 2, getTransformOwner()));
        }
        if (index > 0 || f.isClosed()) {
            int i = (index == 0) ? f.getNodeCount() - 1 : index - 1;
            v = f.getNode(i);
            if ((v.mask & BezierPath.C2_MASK) != 0) {
                list.add(new BezierControlPointHandle(f, i, 2, getTransformOwner()));
            }
        }
        if (index < f.getNodeCount() - 1 || f.isClosed()) {
            int i = (index == f.getNodeCount() - 1) ? 0 : index + 1;
            v = f.getNode(i);
            if ((v.mask & BezierPath.C1_MASK) != 0) {
                list.add(new BezierControlPointHandle(f, i, 1, getTransformOwner()));
            }
        }
        return list;
    }

    @Override
    public String getToolTipText(Point p) {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        BezierPath.Node node = getBezierNode();
        return (node == null) ? null : labels.getFormatted("handle.bezierNode.toolTipText",
                labels.getFormatted(
                (node.getMask() == 0) ? "handle.bezierNode.linear.value" : ((node.getMask() == BezierPath.C1C2_MASK) ? "handle.bezierNode.cubic.value" : "handle.bezierNode.quadratic.value")));
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        final BezierFigure f = getOwner();
        oldNode = f.getNode(index);

        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                f.willChange();
                f.setPoint(index, new Point2D.Double(oldNode.x[0], oldNode.y[0] - 1d));
                f.changed();
                view.getDrawing().fireUndoableEditHappened(new BezierNodeEdit(f, index, oldNode, f.getNode(index)));
                evt.consume();
                break;
            case KeyEvent.VK_DOWN:
                f.willChange();
                f.setPoint(index, new Point2D.Double(oldNode.x[0], oldNode.y[0] + 1d));
                f.changed();
                view.getDrawing().fireUndoableEditHappened(new BezierNodeEdit(f, index, oldNode, f.getNode(index)));
                evt.consume();
                break;
            case KeyEvent.VK_LEFT:
                f.willChange();
                f.setPoint(index, new Point2D.Double(oldNode.x[0] - 1d, oldNode.y[0]));
                f.changed();
                view.getDrawing().fireUndoableEditHappened(new BezierNodeEdit(f, index, oldNode, f.getNode(index)));
                evt.consume();
                break;
            case KeyEvent.VK_RIGHT:
                f.willChange();
                f.setPoint(index, new Point2D.Double(oldNode.x[0] + 1d, oldNode.y[0]));
                f.changed();
                view.getDrawing().fireUndoableEditHappened(new BezierNodeEdit(f, index, oldNode, f.getNode(index)));
                evt.consume();
                break;
            case KeyEvent.VK_DELETE:
            case KeyEvent.VK_BACK_SPACE:
                Rectangle invalidatedArea = getDrawingArea();
                f.willChange();
                final BezierPath.Node removedNode = f.removeNode(index);
                f.changed();
                fireHandleRequestRemove(invalidatedArea);
                fireUndoableEditHappened(new AbstractUndoableEdit() {

                    @Override
                    public String getPresentationName() {
                        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                        return labels.getString("edit.bezierPath.joinSegment.text");
                    }

                    @Override
                    public void redo() throws CannotRedoException {
                        super.redo();
                        view.removeFromSelection(f);
                        f.willChange();
                        f.removeNode(index);
                        f.changed();
                        view.addToSelection(f);
                    }

                    @Override
                    public void undo() throws CannotUndoException {
                        super.undo();
                        view.removeFromSelection(f);
                        f.willChange();
                        f.addNode(index, removedNode);
                        f.changed();
                        view.addToSelection(f);
                    }
                });
                evt.consume();
                break;
        }
    }
}
