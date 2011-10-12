/*
 * @(#)ArrowTip.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw.decoration;

import org.jhotdraw.draw.*;
import java.awt.geom.*;
import org.jhotdraw.xml.DOMInput;
import org.jhotdraw.xml.DOMOutput;
import org.jhotdraw.xml.DOMStorable;

/**
 * A {@link LineDecoration} which can draws an arrow tip. 
 * <p>
 * The shape of the arrow can be controlled with three parameters:
 * <ul>
 * <li>angle - the angle in radians at which the two legs of the arrow meet.</li>
 * <li>outer radius - the length of the two legs of the arrow.</li>
 * <li>inner radius - the distance from the tip of the arrow to the point where
 * its end meets the line.</li>
 * </ul>
 * 
 * @author Werner Randelshofer
 * @version $Id: ArrowTip.java 750 2011-08-28 09:51:17Z rawcoder $
 */
public class ArrowTip extends AbstractLineDecoration
        implements DOMStorable {

    /**
     * Pointiness of arrow.
     */
    private double angle;
    private double outerRadius;
    private double innerRadius;

    public ArrowTip() {
        this(0.35, 12, 11.3);
    }

    /**
     * Constructs an arrow tip with the specified angle and outer and inner 
     * radius.
     */
    public ArrowTip(double angle, double outerRadius, double innerRadius) {
        this(angle, outerRadius, innerRadius, true, false, true);
    }

    /**
     * Constructs an arrow tip with the specified parameters.
     */
    public ArrowTip(double angle, double outerRadius, double innerRadius, boolean isFilled, boolean isStroked, boolean isSolid) {
        super(isFilled, isStroked, isSolid);
        this.angle = angle;
        this.outerRadius = outerRadius;
        this.innerRadius = innerRadius;
    }

    @Override
    protected Path2D.Double getDecoratorPath(Figure f) {
        // FIXME - This should take the stroke join an the outer radius into
        // account to compute the offset properly.
        double offset = (isStroked()) ? 1 : 0;



        Path2D.Double path = new Path2D.Double();
        path.moveTo((outerRadius * Math.sin(-angle)), (offset + outerRadius * Math.cos(-angle)));
        path.lineTo(0, offset);
        path.lineTo((outerRadius * Math.sin(angle)), (offset + outerRadius * Math.cos(angle)));
        if (innerRadius != 0) {
            path.lineTo(0, (innerRadius + offset));
            path.closePath();
        }

        return path;
    }

    @Override
    protected double getDecoratorPathRadius(Figure f) {
        double offset = (isStroked()) ? 0.5 : -0.1;

        return innerRadius + offset;
    }

    public double getAngle() {
        return angle;
    }

    public double getInnerRadius() {
        return innerRadius;
    }

    public double getOuterRadius() {
        return outerRadius;
    }

    @Override
    public void read(DOMInput in) {
        angle = in.getAttribute("angle", 0.35f);
        innerRadius = in.getAttribute("innerRadius", 12f);
        outerRadius = in.getAttribute("outerRadius", 12f);
        setFilled(in.getAttribute("isFilled", false));
        setStroked(in.getAttribute("isStroked", false));
        setSolid(in.getAttribute("isSolid", false));
    }

    @Override
    public void write(DOMOutput out) {
        out.addAttribute("angle", angle);
        out.addAttribute("innerRadius", innerRadius);
        out.addAttribute("outerRadius", outerRadius);
        out.addAttribute("isFilled", isFilled());
        out.addAttribute("isStroked", isStroked());
        out.addAttribute("isSolid", isSolid());
    }
}
