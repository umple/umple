/*
 * @(#)StickyRectangleConnector.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */


package org.jhotdraw.draw.connector;

import org.jhotdraw.draw.*;
import java.io.IOException;
import org.jhotdraw.geom.Geom;
import java.awt.*;
import java.awt.geom.*;
import org.jhotdraw.xml.DOMInput;
import org.jhotdraw.xml.DOMOutput;

/**
 * A StickyRectangleConnector locates connection points by
 * choping the connection between the centers of the
 * two figures at the display box.
 * <p>
 * The location of the connection point is computed once,
 * when the user connects the figure. Moving the figure
 * around will not change the location.
 * 
 * @author Werner Randelshofer
 * @version $Id: StickyRectangleConnector.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class StickyRectangleConnector extends ChopRectangleConnector {
    private float angle;
    
    /** Creates a new instance.
     * Only used for storable.
     */
    public StickyRectangleConnector() {
    }
    public StickyRectangleConnector(Figure owner) {
        super(owner);
    }
    
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.blue);
        g.setStroke(new BasicStroke());
        g.draw(getBounds());
    }
    
    public void setAngle(float angle) {
        this.angle = angle;
    }
    public double getAngle() {
        return angle;
    }
    
    public StickyRectangleConnector(Figure owner, Point2D.Double p) {
        super(owner);
        this.angle = (float) Geom.pointToAngle(owner.getBounds(), p);
    }
    
    @Override
    public void updateAnchor(Point2D.Double p) {
        this.angle = (float) Geom.pointToAngle(getOwner().getBounds(), p);
    }    
    @Override
    public Point2D.Double getAnchor() {
        return Geom.angleToPoint(getOwner().getBounds(), angle);
    }
    @Override protected Point2D.Double chop(Figure target, Point2D.Double from) {
            return Geom.angleToPoint(target.getBounds(), angle);
    }

    public String getParameters() {
        return Float.toString((float) (angle / Math.PI * 180));
    }
    @Override
    public void read(DOMInput in) throws IOException {
        super.read(in);
        angle = (float) in.getAttribute("angle", 0.0);
    }
    @Override
    public void write(DOMOutput out) throws IOException {
        super.write(out);
        out.addAttribute("angle", angle);
    }
}
