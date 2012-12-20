/*
 * @(#)ODGAttributeKeys.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.odg;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.util.ResourceBundleUtil;
import static org.jhotdraw.samples.odg.ODGConstants.*;

/**
 * ODGAttributeKeys.
 * <p>
 * The descriptions of the attributes have been taken from the
 * Open Document Specification version 1.1.
 * <a href="http://docs.oasis-open.org/office/v1.1/OS/OpenDocument-v1.1.pdf">
 * http://docs.oasis-open.org/office/v1.1/OS/OpenDocument-v1.1.pdf</a>
 *
 * @author Werner Randelshofer
 * @version $Id: ODGAttributeKeys.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ODGAttributeKeys extends AttributeKeys {
     private final static ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
    
    /** Prevent instance creation */
    private ODGAttributeKeys() {
    }
    
    /**
     * The attribute draw:name assigns a name to the drawing shape.
     */
    public final static AttributeKey<String> NAME = new AttributeKey<String>("name", String.class, null, true, labels);
    /**
     * Specifies the overall opacity of a ODG figure.
     * This is a value between 0 and 1 whereas 0 is translucent and 1 is fully opaque.
     */
    public final static AttributeKey<Double> OPACITY = new AttributeKey<Double>("opacity", Double.class, 1d, false, labels);
    
    /**
     * Specifies the fill style of a ODG figure.
     *
     * The attribute draw:fill specifies the fill style for a graphic object. Graphic objects that are not
     * closed, such as a path without a closepath at the end, will not be filled. The fill operation does
     * not automatically close all open subpaths by connecting the last point of the subpath with the first
     * point of the subpath before painting the fill. The attribute has the following values:
     * • none: the drawing object is not filled.
     * • solid: the drawing object is filled with color specified by the draw:fill-color attribute.
     * • bitmap: the drawing object is filled with the bitmap specified by the draw:fill-image-
     * name attribute.
     * • gradient: the drawing object is filled with the gradient specified by the draw:fill-
     * gradient-name attribute.
     * • hatch: the drawing object is filled with the hatch specified by the draw:fill-hatch-name
     * attribute.
     */
    public final static AttributeKey<FillStyle> FILL_STYLE = new AttributeKey<FillStyle>("fill", FillStyle.class, FillStyle.SOLID, false, labels);
    /**
     * Specifies the fill gradient of a ODG figure.
     */
    public final static AttributeKey<Gradient> FILL_GRADIENT = new AttributeKey<Gradient>("fillGradient", Gradient.class, null, true, labels);
    /**
     * Specifies the fill opacity of a ODG figure.
     * This is a value between 0 and 1 whereas 0 is translucent and 1 is fully opaque.
     */
    public final static AttributeKey<Double> FILL_OPACITY = new AttributeKey<Double>("fillOpacity", Double.class, 1d, false, labels);
    /**
     * Specifies the stroke style of a ODG figure.
     *
     * The attribute draw:stroke specifies the style of the stroke on the current object. The value
     * none means that no stroke is drawn, and the value solid means that a solid stroke is drawn. If
     * the value is dash, the stroke referenced by the draw:stroke-dash property is drawn.
     */
    public final static AttributeKey<StrokeStyle> STROKE_STYLE = new AttributeKey<StrokeStyle>("stroke", StrokeStyle.class, StrokeStyle.SOLID, false, labels);
    /**
     * Specifies the stroke gradient of a ODG figure.
     */
    public final static AttributeKey<Gradient> STROKE_GRADIENT = new AttributeKey<Gradient>("strokeGradient", Gradient.class, null, true, labels);
    /**
     * Specifies the stroke opacity of a ODG figure.
     * This is a value between 0 and 1 whereas 0 is translucent and 1 is fully opaque.
     */
    public final static AttributeKey<Double> STROKE_OPACITY = new AttributeKey<Double>("strokeOpacity", Double.class, 1d, false, labels);
    
    /**
     * Gets the fill paint for the specified figure based on the attributes
     * FILL_GRADIENT, FILL_OPACITY, FILL_PAINT and the bounds of the figure.
     * Returns null if the figure is not filled.
     */
    @Nullable
    public static Paint getFillPaint(Figure f) {
        double opacity = f.get(FILL_OPACITY);
        if (f.get(FILL_GRADIENT) != null) {
            return f.get(FILL_GRADIENT).getPaint(f, opacity);
        }
        Color color = f.get(FILL_COLOR);
        if (color != null) {
            if (opacity != 1) {
                color = new Color(
                        (color.getRGB() & 0xffffff) | (int) (opacity * 255) << 24,
                        true);
            }
        }
        return color;
    }
    /**
     * Gets the stroke paint for the specified figure based on the attributes
     * STROKE_GRADIENT, STROKE_OPACITY, STROKE_PAINT and the bounds of the figure.
     * Returns null if the figure is not filled.
     */
    @Nullable
    public static Paint getStrokePaint(Figure f) {
        double opacity = f.get(STROKE_OPACITY);
        if (f.get(STROKE_GRADIENT) != null) {
            return f.get(STROKE_GRADIENT).getPaint(f, opacity);
        }
        Color color = f.get(STROKE_COLOR);
        if (color != null) {
            if (opacity != 1) {
                color = new Color(
                        (color.getRGB() & 0xffffff) | (int) (opacity * 255) << 24,
                        true);
            }
        }
        return color;
    }
    public static Stroke getStroke(Figure f) {
        double strokeWidth = f.get(STROKE_WIDTH);
        if (strokeWidth == 0) {
            strokeWidth = 1;
        }
        return new BasicStroke((float) strokeWidth);
    }
    
    /** Sets ODG default values. */
    public static void setDefaults(Figure f) {
        // Fill properties
        f.set(FILL_COLOR, Color.black);
        f.set(WINDING_RULE, WindingRule.NON_ZERO);
        
        // Stroke properties
        f.set(STROKE_COLOR, null);
        f.set(STROKE_WIDTH, 1d);
        f.set(STROKE_CAP, BasicStroke.CAP_BUTT);
        f.set(STROKE_JOIN, BasicStroke.JOIN_MITER);
        f.set(STROKE_MITER_LIMIT, 4d);
        f.set(IS_STROKE_MITER_LIMIT_FACTOR, false);
        f.set(STROKE_DASHES, null);
        f.set(STROKE_DASH_PHASE, 0d);
        f.set(IS_STROKE_DASH_FACTOR, false);
    }
}
