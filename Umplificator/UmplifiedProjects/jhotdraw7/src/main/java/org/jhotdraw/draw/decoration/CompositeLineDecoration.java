/*
 * @(#)CompositeLineDecoration.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.decoration;

import org.jhotdraw.draw.*;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jhotdraw.xml.DOMInput;
import org.jhotdraw.xml.DOMOutput;
import org.jhotdraw.xml.DOMStorable;

/**
 * A {@link LineDecoration} which can compose multiple individual line
 * decorations.
 * <p>
 * An composite implementation of a line decoration. It allows more than
 * one line decoration shape to be rotated and moved to the end of the line.
 * The shape is scaled by the stroke width.
 *
 * @author Huw Jones
 */
public class CompositeLineDecoration implements LineDecoration, DOMStorable {
	private List<LineDecoration> decorations = new ArrayList<LineDecoration>();
	
	/**
     * Constructs a composite line decoration with no decorations.
     */
    public CompositeLineDecoration() {
    }
    
	/**
     * Constructs a composite line decoration with the two supplied decorations.
     */
    public CompositeLineDecoration(LineDecoration decoration1, LineDecoration decoration2) {
    	addDecoration(decoration1);
    	addDecoration(decoration2);
    }

    /**
     * Add another line decoration into the composite line decoration.
     * The new decoration will be appended to the existing decorations
     * and is also the last drawn.
     */
    public void addDecoration(LineDecoration decoration) {
    	if (decoration != null) {
    		decorations.add(decoration);
    	}
    }
    
    /**
     * Draws the arrow tip in the direction specified by the given two
     * Points.. (template method)
     */
    @Override
    public void draw(Graphics2D g, Figure f, Point2D.Double p1, Point2D.Double p2) {
    	for (LineDecoration decoration : decorations) {
    		decoration.draw(g, f, p1, p2);
    	}
    }
    
    /**
     * Returns the drawing area of the decorator.
     */
    @Override
    public Rectangle2D.Double getDrawingArea(Figure f, Point2D.Double p1, Point2D.Double p2) {
    	Rectangle2D.Double r = null;
    	
    	for (LineDecoration decoration : decorations) {
    		Rectangle2D.Double aR = decoration.getDrawingArea(f, p1, p2);
    		if (r == null)
    			r = aR;
    		else
    			r.add(aR);
    	}
    	
    	return r;
    }
    
    /**
     * Returns the radius of the decorator.
     * This is used to crop the end of the line, to prevent it from being
     * drawn it over the decorator.
     */
    @Override
    public double getDecorationRadius(Figure f) {
    	double radius = 0;
    	
    	for (LineDecoration decoration : decorations) {
    		radius = Math.max(radius, decoration.getDecorationRadius(f));
    	}
    	
    	return radius;
    }
    
    @Override
    public void read(DOMInput in) throws IOException {
        for (int i = in.getElementCount("decoration") - 1; i >= 0; i--) {
    		in.openElement("decoration", i);
    		
            Object value = in.readObject();
            
            if (value instanceof LineDecoration)
            	addDecoration((LineDecoration)value);
    		
    		in.closeElement();
    	}
    }
    
    @Override
    public void write(DOMOutput out) throws IOException {
    	for (LineDecoration decoration : decorations) {
        	out.openElement("decoration");
        	
            out.writeObject(decoration);
            
            out.closeElement();
    	}
    }
}
