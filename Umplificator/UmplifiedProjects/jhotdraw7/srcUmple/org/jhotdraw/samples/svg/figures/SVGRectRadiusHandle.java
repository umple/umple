/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package org.jhotdraw.samples.svg.figures;
import org.jhotdraw.draw.handle.HandleAttributeKeys;
import org.jhotdraw.draw.handle.AbstractHandle;
import org.jhotdraw.draw.event.CompositeFigureEdit;
import org.jhotdraw.draw.*;
import org.jhotdraw.geom.*;
import org.jhotdraw.util.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.*;
import org.jhotdraw.undo.PropertyChangeEdit;
import org.jhotdraw.samples.svg.SVGAttributeKeys.*;

public class SVGRectRadiusHandle
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SVGRectRadiusHandle()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private final static boolean DEBUG = false;
private static final int OFFSET = 6;
private Dimension2DDouble originalArc2D;
/**
     * Draws this handle.
     */
    @Override
    public void draw(Graphics2D g) {
        if (getEditor().getTool().supportsHandleInteraction()) {
            drawDiamond(g,
                    (Color) getEditor().getHandleAttribute(HandleAttributeKeys.ATTRIBUTE_HANDLE_FILL_COLOR),
                    (Color) getEditor().getHandleAttribute(HandleAttributeKeys.ATTRIBUTE_HANDLE_STROKE_COLOR));
        } else {
            drawDiamond(g,
                    (Color) getEditor().getHandleAttribute(HandleAttributeKeys.ATTRIBUTE_HANDLE_FILL_COLOR_DISABLED),
                    (Color) getEditor().getHandleAttribute(HandleAttributeKeys.ATTRIBUTE_HANDLE_STROKE_COLOR_DISABLED));
        }
    }
@Override
    protected Rectangle basicGetBounds() {
        Rectangle r = new Rectangle(locate());
        r.grow(getHandlesize() / 2 + 1, getHandlesize() / 2 + 1);
        return r;
    }
private Point locate() {
        SVGRectFigure owner = (SVGRectFigure) getOwner();
        Rectangle2D.Double r = owner.getBounds();
        Point2D.Double p = new Point2D.Double(
                r.x + owner.getArcWidth(),
                r.y + owner.getArcHeight());
        if (owner.get(TRANSFORM) != null) {
            owner.get(TRANSFORM).transform(p, p);
        }
        return view.drawingToView(p);
    }
@Override
    public void trackStart(Point anchor, int modifiersEx) {
        SVGRectFigure svgRect = (SVGRectFigure) getOwner();
        originalArc2D = new Dimension2DDouble(svgRect.getArcWidth(), svgRect.getArcHeight());
    }
@Override
    public void trackStep(Point anchor, Point lead, int modifiersEx) {
        SVGRectFigure owner = (SVGRectFigure) getOwner();
        owner.willChange();
        Point2D.Double p = view.viewToDrawing(lead);
        if (owner.get(TRANSFORM) != null) {
            try {
                owner.get(TRANSFORM).inverseTransform(p, p);
            } catch (NoninvertibleTransformException ex) {
                if (DEBUG) {
                    ex.printStackTrace();
                }
            }
        }
        Rectangle2D.Double r = owner.getBounds();
        owner.setArc(//
                Math.min(owner.getWidth(),Math.max(0, p.x - r.x)),//
                Math.min(owner.getHeight(),Math.max(0, p.y - r.y)));
        owner.changed();
    }
@Override
    public void trackEnd(Point anchor, Point lead, int modifiersEx) {
        final SVGRectFigure svgRect = (SVGRectFigure) getOwner();
        final Dimension2DDouble oldValue = originalArc2D;
        final Dimension2DDouble newValue = new Dimension2DDouble(svgRect.getArcWidth(), svgRect.getArcHeight());

        ResourceBundleUtil labels =
                ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        CompositeFigureEdit edit = new CompositeFigureEdit(svgRect, labels.getString("attribute.roundRectRadius"));
        edit.setVerbose(true);
        fireUndoableEditHappened(edit);
        fireUndoableEditHappened(new PropertyChangeEdit(svgRect, SVGRectFigure.ARC_WIDTH_PROPERTY, oldValue.width, newValue.width));
        fireUndoableEditHappened(new PropertyChangeEdit(svgRect, SVGRectFigure.ARC_HEIGHT_PROPERTY, oldValue.height, newValue.height));
        fireUndoableEditHappened(edit);
    }
@Override
    public void keyPressed(KeyEvent evt) {
        SVGRectFigure owner = (SVGRectFigure) getOwner();
        Dimension2DDouble oldArc = new Dimension2DDouble(owner.getArcWidth(), owner.getArcHeight());
        Dimension2DDouble newArc = new Dimension2DDouble(owner.getArcWidth(), owner.getArcHeight());
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (newArc.height > 0) {
                    newArc.height = Math.max(0, newArc.height - 1);
                }
                evt.consume();
                break;
            case KeyEvent.VK_DOWN:
                newArc.height = Math.min(owner.getHeight(), newArc.height + 1);
                evt.consume();
                break;
            case KeyEvent.VK_LEFT:
                if (newArc.width > 0) {
                    newArc.width = Math.max(0, newArc.width - 1);
                }
                evt.consume();
                break;
            case KeyEvent.VK_RIGHT:
                newArc.width = Math.min(owner.getWidth(), newArc.width + 1);
                evt.consume();
                break;
        }
        if (!newArc.equals(oldArc)) {
            owner.willChange();
            owner.setArc(newArc.width, newArc.height);
            owner.changed();
            ResourceBundleUtil labels =
                    ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            CompositeFigureEdit edit = new CompositeFigureEdit(owner, labels.getString("attribute.roundRectRadius"));
            fireUndoableEditHappened(edit);
            fireUndoableEditHappened(new PropertyChangeEdit(owner, SVGRectFigure.ARC_WIDTH_PROPERTY, oldArc.width, newArc.width));
            fireUndoableEditHappened(new PropertyChangeEdit(owner, SVGRectFigure.ARC_HEIGHT_PROPERTY, oldArc.height, newArc.height));
            fireUndoableEditHappened(edit);
        }
    }
@Override
    public String getToolTipText(Point p) {
        return ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels").//
                getString("handle.roundRectangleRadius.toolTipText");
    }
}