/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package org.jhotdraw.samples.svg.figures;
import org.jhotdraw.draw.handle.HandleAttributeKeys;
import org.jhotdraw.draw.handle.AbstractHandle;
import org.jhotdraw.draw.*;
import java.awt.*;
import org.jhotdraw.samples.svg.SVGAttributeKeys.*;

public class SVGPathOutlineHandle
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public SVGPathOutlineHandle()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  private boolean isHoverHandle = false;
@Override
    public SVGPathFigure getOwner() {
        return (SVGPathFigure) super.getOwner();
    }
@Override
    protected Rectangle basicGetBounds() {
        return view.drawingToView(getOwner().getDrawingArea());
    }
@Override
    public boolean contains(Point p) {
        return false;
    }
@Override
    public void trackStart(Point anchor, int modifiersEx) {
    }
@Override
    public void trackStep(Point anchor, Point lead, int modifiersEx) {
    }
@Override
    public void trackEnd(Point anchor, Point lead, int modifiersEx) {
    }
@Override
    public void draw(Graphics2D g) {
        SVGPathFigure o = getOwner();
        Shape bounds = o.getPath();
        if (o.get(TRANSFORM) != null) {
            bounds = o.get(TRANSFORM).createTransformedShape(bounds);
        }
        bounds = view.getDrawingToViewTransform().createTransformedShape(bounds);
        Stroke stroke1;
        Color strokeColor1;
        Stroke stroke2;
        Color strokeColor2;
        DrawingEditor e = getEditor();
        if (e.getTool().supportsHandleInteraction()) {
            if (isHoverHandle) {
                stroke1 = (Stroke) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_STROKE_1_HOVER);
                strokeColor1 = (Color) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_COLOR_1_HOVER);
                stroke2 = (Stroke) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_STROKE_2_HOVER);
                strokeColor2 = (Color) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_COLOR_2_HOVER);
            } else {
                stroke1 = (Stroke) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_STROKE_1);
                strokeColor1 = (Color) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_COLOR_1);
                stroke2 = (Stroke) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_STROKE_2);
                strokeColor2 = (Color) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_COLOR_2);
            }
        } else {
            stroke1 = (Stroke) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_STROKE_1_DISABLED);
            strokeColor1 = (Color) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_COLOR_1_DISABLED);
            stroke2 = (Stroke) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_STROKE_2_DISABLED);
            strokeColor2 = (Color) e.getHandleAttribute(HandleAttributeKeys.BEZIER_PATH_COLOR_2_DISABLED);
        }
        if (stroke1 != null && strokeColor1 != null) {
            g.setStroke(stroke1);
            g.setColor(strokeColor1);
            g.draw(bounds);
        }
        if (stroke2 != null && strokeColor2 != null) {
            g.setStroke(stroke2);
            g.setColor(strokeColor2);
            g.draw(bounds);
        }
    }
}