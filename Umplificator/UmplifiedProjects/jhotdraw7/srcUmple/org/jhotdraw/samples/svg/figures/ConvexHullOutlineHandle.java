/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package org.jhotdraw.samples.svg.figures;
import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.handle.HandleAttributeKeys;
import org.jhotdraw.draw.handle.AbstractHandle;
import org.jhotdraw.draw.*;
import java.awt.*;
import org.jhotdraw.geom.ConvexHull;
import org.jhotdraw.draw.AttributeKeys.*;

public class ConvexHullOutlineHandle
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ConvexHullOutlineHandle()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  @Nullable private Shape outline;
private AttributeKey<Stroke> stroke1Enabled;
private AttributeKey<Stroke> stroke2Enabled;
private AttributeKey<Stroke> stroke1Disabled;
private AttributeKey<Stroke> stroke2Disabled;
private AttributeKey<Color> strokeColor1Enabled;
private AttributeKey<Color> strokeColor2Enabled;
private AttributeKey<Color> strokeColor1Disabled;
private AttributeKey<Color> strokeColor2Disabled;
@Override
    protected Rectangle basicGetBounds() {
        Shape bounds = getOwner().getBounds();
        if (getOwner().get(TRANSFORM) != null) {
            bounds = getOwner().get(TRANSFORM).createTransformedShape(bounds);
        }
        bounds = view.getDrawingToViewTransform().createTransformedShape(bounds);

        Rectangle r = bounds.getBounds();
        r.grow(2, 2);
        return r;
    }
@Override
    public SVGPathFigure getOwner() {
        return (SVGPathFigure) super.getOwner();
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
        if (outline==null) {
        Shape bounds = getOwner().getPath();
        if (getOwner().get(TRANSFORM) != null) {
            bounds = getOwner().get(TRANSFORM).createTransformedShape(bounds);
        }
        bounds = view.getDrawingToViewTransform().createTransformedShape(bounds);
        outline = ConvexHull.getConvexHullPath2D(bounds);
        }
        Stroke stroke1;
        Color strokeColor1;
        Stroke stroke2;
        Color strokeColor2;

        if (getEditor().getTool().supportsHandleInteraction()) {
            stroke1 = (Stroke) getEditor().getHandleAttribute(stroke1Enabled);
            strokeColor1 = (Color) getEditor().getHandleAttribute(strokeColor1Enabled);
            stroke2 = (Stroke) getEditor().getHandleAttribute(stroke2Enabled);
            strokeColor2 = (Color) getEditor().getHandleAttribute(strokeColor2Enabled);
        } else {
            stroke1 = (Stroke) getEditor().getHandleAttribute(stroke1Disabled);
            strokeColor1 = (Color) getEditor().getHandleAttribute(strokeColor1Disabled);
            stroke2 = (Stroke) getEditor().getHandleAttribute(stroke2Disabled);
            strokeColor2 = (Color) getEditor().getHandleAttribute(strokeColor2Disabled);
        }
        if (stroke1 != null && strokeColor1 != null) {
            g.setStroke(stroke1);
            g.setColor(strokeColor1);
            g.draw(outline);
        }
        if (stroke2 != null && strokeColor2 != null) {
            g.setStroke(stroke2);
            g.setColor(strokeColor2);
            g.draw(outline);
        }
    }
@Override
    protected void updateBounds() {
        outline=null;
        super.updateBounds();
    }
}