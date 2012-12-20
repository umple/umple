/*
 * @(#)BezierScaleHandle.java
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
import org.jhotdraw.draw.event.TransformRestoreEdit;
import org.jhotdraw.draw.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import org.jhotdraw.geom.*;

/**
 * A {@link Handle} which allows to interactively scale and rotate a BezierFigure.
 * <p>
 * Pressing the alt key or the shift key while manipulating the handle restricts
 * the handle to rotate the BezierFigure without scaling it.
 *
 * @author Werner Randelshofer.
 * @version $Id: BezierScaleHandle.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class BezierScaleHandle extends AbstractHandle {
    @Nullable private Point location;
    private Object restoreData;
    private AffineTransform transform;
    private Point2D.Double center;
    private double startTheta;
    private double startLength;
    
    /** Creates a new instance. */
    public BezierScaleHandle(BezierFigure owner) {
        super(owner);
    }
    
    @Override
    public boolean isCombinableWith(Handle h) {
        return false;
    }
    
    
    /**
     * Draws this handle.
     */
    @Override
    public void draw(Graphics2D g) {
        drawCircle(g, 
                (Color) getEditor().getHandleAttribute(HandleAttributeKeys.SCALE_HANDLE_FILL_COLOR),
                (Color) getEditor().getHandleAttribute(HandleAttributeKeys.SCALE_HANDLE_STROKE_COLOR)
                );
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
    
    public Point getLocation() {
        if (location == null) {
            return  /*location =*/ view.drawingToView(getOrigin());
        }
        return location;
    }
    
    private BezierFigure getBezierFigure() {
        return (BezierFigure) getOwner();
    }
    
    private Point2D.Double getOrigin() {
        // find a nice place to put handle
        // Need to pick a place that will not overlap with point handle
        // and is internal to polygon
        int handlesize = getHandlesize();
        
        // Try for one handlesize step away from outermost toward center
        Point2D.Double outer = getBezierFigure().getOutermostPoint();
        Point2D.Double ctr = getBezierFigure().getCenter();
        double len = Geom.length(outer.x, outer.y, ctr.x, ctr.y);
        if (len == 0) { // best we can do?
            return new Point2D.Double(outer.x - handlesize/2, outer.y + handlesize/2);
        }
        
        double u = handlesize / len;
        if (u > 1.0) { // best we can do?
            return new Point2D.Double((outer.x * 3 + ctr.x)/4, (outer.y * 3 + ctr.y)/4);
        } else {
            return new Point2D.Double(outer.x * (1.0 - u) + ctr.x * u,
                    outer.y * (1.0 - u) + ctr.y * u);
        }
    }
    @Override
    public void trackStart(Point anchor, int modifiersEx) {
        location = new Point(anchor.x, anchor.y);
        restoreData = getBezierFigure().getTransformRestoreData();
        transform = new AffineTransform();
        center = getBezierFigure().getCenter();
        Point2D.Double anchorPoint = view.viewToDrawing(anchor);
        startTheta = Geom.angle(center.x, center.y, anchorPoint.x, anchorPoint.y);
        startLength = Geom.length(center.x, center.y, anchorPoint.x, anchorPoint.y);
    }
    
    @Override
    public void trackStep(Point anchor, Point lead, int modifiersEx) {
        location = new Point(lead.x, lead.y);
        Point2D.Double leadPoint = view.viewToDrawing(lead);
        double stepTheta = Geom.angle(center.x, center.y, leadPoint.x, leadPoint.y);
        double stepLength = Geom.length(center.x, center.y, leadPoint.x, leadPoint.y);
        double scaleFactor = (modifiersEx & (InputEvent.ALT_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK)) != 0 ? 1d : stepLength / startLength;
        transform.setToIdentity();
        transform.translate(center.x, center.y);
        transform.scale(scaleFactor, scaleFactor);
        transform.rotate(stepTheta - startTheta);
        transform.translate(-center.x, -center.y);
        getOwner().willChange();
        getOwner().restoreTransformTo(restoreData);
        getOwner().transform(transform);
        getOwner().changed();
    }
    /*
     *	public  void scaleRotate(Point anchor, Polygon originalPolygon, Point p) {
                willChange();
     
                // use center to determine relative angles and lengths
                Point ctr = center(originalPolygon);
                double anchorLen = Geom.length(ctr.x, ctr.y, anchor.x, anchor.y);
     
                if (anchorLen > 0.0) {
                        double newLen = Geom.length(ctr.x, ctr.y, p.x, p.y);
                        double ratio = newLen / anchorLen;
     
                        double anchorAngle = Math.atan2(anchor.y - ctr.y, anchor.x - ctr.x);
                        double newAngle = Math.atan2(p.y - ctr.y, p.x - ctr.x);
                        double rotation = newAngle - anchorAngle;
     
                        int n = originalPolygon.npoints;
                        int[] xs = new int[n];
                        int[] ys = new int[n];
     
                        for (int i = 0; i < n; ++i) {
                                int x = originalPolygon.xpoints[i];
                                int y = originalPolygon.ypoints[i];
                                double l = Geom.length(ctr.x, ctr.y, x, y) * ratio;
                                double a = Math.atan2(y - ctr.y, x - ctr.x) + rotation;
                                xs[i] = (int)(ctr.x + l * Math.cos(a) + 0.5);
                                ys[i] = (int)(ctr.y + l * Math.sin(a) + 0.5);
                        }
                        setInternalPolygon(new Polygon(xs, ys, n));
                }
                changed();
        }
     */
    
    @Override
    public void trackEnd(Point anchor, Point lead, int modifiersEx) {
        view.getDrawing().fireUndoableEditHappened(
                new TransformRestoreEdit(getOwner(), restoreData, getOwner().getTransformRestoreData()));
        location = null;
    }
    
}
