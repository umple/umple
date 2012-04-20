/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.15.0.963 modeling language!*/

package org.jhotdraw.samples.svg.figures;
import org.jhotdraw.draw.handle.HandleAttributeKeys;
import org.jhotdraw.draw.handle.AbstractHandle;
import org.jhotdraw.draw.*;
import java.awt.*;
import java.awt.geom.*;
import org.jhotdraw.samples.svg.SVGAttributeKeys.*;
import org.jhotdraw.util.ResourceBundleUtil;

public class LinkHandle
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public LinkHandle()
  {}

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {}
  
  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  @Override
    public boolean contains(Point p) {
        return false;
    }
/**
     * Draws this handle.
     */
    @Override public void draw(Graphics2D g) {
        Figure o = getOwner();
        if (o.get(LINK)!=null&&o.get(LINK).trim().length()>0) {
            g.setColor((Color) getEditor().getHandleAttribute(HandleAttributeKeys.OVERFLOW_HANDLE_STROKE_COLOR));
            Rectangle r = basicGetBounds();
            g.drawLine(r.x+(r.width/2)-1, r.y, r.x, r.y);
            g.drawLine(r.x, r.y, r.x, r.y+r.height-1);
            g.drawLine(r.x, r.y+r.height-1, r.x+(r.width/2)-1, r.y+r.height-1);
            g.drawLine(r.x+(r.width/3), r.y+r.height/2, r.x+r.width-1, r.y+r.height/2);
            g.drawLine(r.x+r.width-1, r.y+r.height/2, (int)(r.x+r.width*.75-1), (int)(r.y+r.height*.25));
            g.drawLine(r.x+r.width-1, r.y+r.height/2, (int)(r.x+r.width*.75-1), (int)(r.y+r.height*.75));
        }
    }
@Override protected Rectangle basicGetBounds() {
        Figure o = getOwner();
        Rectangle2D.Double b = o.getBounds();
        Point2D.Double p = new Point2D.Double(b.x + b.width, b.y  + b.height);
        if (o.get(TRANSFORM) != null) {
            o.get(TRANSFORM).transform(p, p);
        }
        Rectangle r = new Rectangle(view.drawingToView(p));
        int h = getHandlesize();
        r.x -= h*4;
        r.y -= h;
        r.width = h*2;
                r.height = h;
        return r;
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
@Override public String getToolTipText(Point p) {
        
        return (getOwner().get(LINK)!=null)  ?
            ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels").//
            getString("handle.link.toolTipText") :
            null;
    }
}