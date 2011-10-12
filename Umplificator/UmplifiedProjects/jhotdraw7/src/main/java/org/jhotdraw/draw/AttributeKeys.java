/*
 * @(#)AttributeKeys.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.decoration.LineDecoration;
import org.jhotdraw.draw.liner.Liner;
import org.jhotdraw.util.ResourceBundleUtil;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import org.jhotdraw.geom.*;

/**
 * Defines a put of well known {@link Figure} attributes.
 * <p>
 * If you are developing an applications that uses a different put or an
 * extended put of attributes, it is recommended to create a new AttributeKeys
 * class, and to define all needed AttributeKeys as static variables in there.
 *
 * @author Werner Randelshofer
 * @version $Id: AttributeKeys.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class AttributeKeys {

    private final static ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
    /**
     * Canvas fill color. The value of this attribute is a Color object.
     * This attribute is used by a Drawing object to specify the fill color
     * of the drawing. The default value is white.
     */
    public final static AttributeKey<Color> CANVAS_FILL_COLOR = new AttributeKey<Color>("canvasFillColor", Color.class, Color.white, true, labels);
    /**
     * Canvas fill opacity. The value of this attribute is a Double object.
     * This is a value between 0 and 1 whereas 0 is translucent and 1 is fully opaque.
     */
    public final static AttributeKey<Double> CANVAS_FILL_OPACITY = new AttributeKey<Double>("canvasFillOpacity", Double.class, 1d, false, labels);
    /**
     * The width of the canvas. The value of this attribute is a Double object.
     * This is a value between 1 and Double.MAX_VALUE. If the value is null, the
     * width is dynamically adapted to the content of the drawing.
     */
    public final static AttributeKey<Double> CANVAS_WIDTH = new AttributeKey<Double>("canvasWidth", Double.class, null, true, labels);
    /**
     * The height of the canvas. The value of this attribute is a Double object.
     * This is a value between 1 and Double.MAX_VALUE. If the value is null, the
     * height is dynamically adapted to the content of the drawing.
     */
    public final static AttributeKey<Double> CANVAS_HEIGHT = new AttributeKey<Double>("canvasHeight", Double.class, null, true, labels);
    /**
     * Figure fill color. The value of this attribute is a Color object.
     */
    public final static AttributeKey<Color> FILL_COLOR = new AttributeKey<Color>("fillColor", Color.class, Color.white, true, labels);
    /**
     * Whether to path a BezierFigure is closed. The value of this attribute is a Boolean object.
     */
    public final static AttributeKey<Boolean> PATH_CLOSED = new AttributeKey<Boolean>("pathClosed", Boolean.class, false, false, labels);
    /**
     * Whether an unclosed path of a BezierFigure is filled. The value of this attribute is a Boolean object.
     */
    public final static AttributeKey<Boolean> UNCLOSED_PATH_FILLED = new AttributeKey<Boolean>("unclosedPathFilled", Boolean.class, false, false, labels);

    public static enum WindingRule {

        /**
         * If WINDING_RULE is put to this value, an even-odd winding rule
         * is used for determining the interior of a path.  
         */
        EVEN_ODD,
        /**
         * If WINDING_RULE is put to this value, a non-zero winding rule
         * is used for determining the interior of a path.  
         */
        NON_ZERO
    }
    /**
     * Fill under stroke. The value of this attribute is a Boolean object.
     */
    public final static AttributeKey<WindingRule> WINDING_RULE = new AttributeKey<WindingRule>("windingRule", WindingRule.class, WindingRule.EVEN_ODD, false, labels);

    public static enum Underfill {

        /**
         * If FILL_UNDER_STROKE is put to this value, the area under the
         * stroke will not be filled.
         */
        NONE,
        /**
         * If FILL_UNDER_STROKE is put to this value, the area under the stroke
         * is filled to the center of the stroke. This is the default behavior
         * of Graphics2D.fill(Shape), Graphics2D.draw(Shape) when using the
         * same shape object.
         */
        CENTER,
        /**
         * If FILL_UNDER_STROKE is put to this value, the area under the
         * stroke will be filled.
         */
        FULL
    }
    /**
     * Fill under stroke. The value of this attribute is a Boolean object.
     */
    public final static AttributeKey<Underfill> FILL_UNDER_STROKE = new AttributeKey<Underfill>("fillUnderStroke", Underfill.class, Underfill.CENTER, false, labels);
    /**
     * Stroke color. The value of this attribute is a Color object.
     */
    public final static AttributeKey<Color> STROKE_COLOR = new AttributeKey<Color>("strokeColor", Color.class, Color.black, true, labels);
    /**
     * Stroke width. A double used to construct a BasicStroke or the
     * outline of a DoubleStroke.
     */
    public final static AttributeKey<Double> STROKE_WIDTH = new AttributeKey<Double>("strokeWidth", Double.class, 1d, false, labels);
    /**
     * Factor for the stroke inner width. This is a double. The default value
     * is 2.
     * <p>
     * FIXME - This is not flexible enough. Lets replace this with a
     * STROKE_STRIPES_ARRAY<Double[]> and a IS_STROKE_STRIPES_FACTOR.
     */
    public final static AttributeKey<Double> STROKE_INNER_WIDTH_FACTOR = new AttributeKey<Double>("innerStrokeWidthFactor", Double.class, 2d, false, labels);
    /**
     * Stroke join. One of the BasicStroke.JOIN_... values used to
     * construct a BasicStroke.
     */
    public final static AttributeKey<Integer> STROKE_JOIN = new AttributeKey<Integer>("strokeJoin", Integer.class, BasicStroke.JOIN_MITER, false, labels);
    /**
     * Stroke join. One of the BasicStroke.CAP_... values used to
     * construct a BasicStroke.
     */
    public final static AttributeKey<Integer> STROKE_CAP = new AttributeKey<Integer>("strokeCap", Integer.class, BasicStroke.CAP_BUTT, false, labels);
    /**
     * Stroke miter limit factor. A double multiplied by total stroke width,
     * used to construct the miter limit of a BasicStroke.
     */
    public final static AttributeKey<Double> STROKE_MITER_LIMIT = new AttributeKey<Double>("strokeMiterLimitFactor", Double.class, 3d, false, labels);
    /**
     * A boolean used to indicate whether STROKE_MITER_LIMIT is a factor of 
     * STROKE_WIDTH, or whether it represents an absolute value.
     */
    public final static AttributeKey<Boolean> IS_STROKE_MITER_LIMIT_FACTOR = new AttributeKey<Boolean>("isStrokeMiterLimitFactor", Boolean.class, true, false, labels);
    /**
     * An array of doubles used to specify the dash pattern in
     * a BasicStroke;
     */
    public final static AttributeKey<double[]> STROKE_DASHES = new AttributeKey<double[]>("strokeDashes", double[].class, null, true, labels);
    /**
     * A double used to specify the starting phase of the stroke dashes.
     */
    public final static AttributeKey<Double> STROKE_DASH_PHASE = new AttributeKey<Double>("strokeDashPhase", Double.class, 0d, false, labels);
    /**
     * A boolean used to indicate whether STROKE_DASHES and STROKE_DASH_PHASE
     * shall be interpreted as factors of STROKE_WIDTH, or whether they are
     * absolute values.
     */
    public final static AttributeKey<Boolean> IS_STROKE_DASH_FACTOR = new AttributeKey<Boolean>("isStrokeDashFactor", Boolean.class, true, false, labels);

    public static enum StrokeType {

        /**
         * If STROKE_TYPE is put to this value, a BasicStroke instance is used
         * for stroking.
         */
        BASIC,
        /**
         * If STROKE_TYPE is put to this value, a DoubleStroke instance is used
         * for stroking.
         */
        DOUBLE
    }
    /**
     * Stroke type. The value of this attribute is either VALUE_STROKE_TYPE_BASIC
     * or VALUE_STROKE_TYPE_DOUBLE.
     * FIXME - Type should be an enumeration.
     */
    public final static AttributeKey<StrokeType> STROKE_TYPE = new AttributeKey<StrokeType>("strokeType", StrokeType.class, StrokeType.BASIC, false, labels);

    public static enum StrokePlacement {

        /**
         * If STROKE_PLACEMENT is put to this value, the stroke is centered
         * on the path.
         */
        CENTER,
        /**
         * If STROKE_PLACEMENT is put to this value, the stroke is placed
         * inside of a closed path.
         */
        INSIDE,
        /**
         * If STROKE_PLACEMENT is put to this value, the stroke is placed
         * outside of a closed path.
         */
        OUTSIDE
    }
    /**
     * Stroke placement. The value is either StrokePlacement.CENTER,
     * StrokePlacement.INSIDE or StrokePlacement.OUTSIDE.
     * This only has effect for closed paths. On open paths, the stroke
     * is always centered on the path.
     * <p>
     * The default value is StrokePlacement.CENTER.
     */
    public final static AttributeKey<StrokePlacement> STROKE_PLACEMENT = new AttributeKey<StrokePlacement>("strokePlacement", StrokePlacement.class, StrokePlacement.CENTER, false, labels);
    /**
     * The value of this attribute is a String object, which is used to
     * display the text of the figure.
     */
    public final static AttributeKey<String> TEXT = new AttributeKey<String>("text", String.class, null, true, labels);
    /**
     * Text color. The value of this attribute is a Color object.
     */
    public final static AttributeKey<Color> TEXT_COLOR = new AttributeKey<Color>("textColor", Color.class, Color.BLACK, false, labels);
    /**
     * Text shadow color. The value of this attribute is a Color object.
     */
    public final static AttributeKey<Color> TEXT_SHADOW_COLOR = new AttributeKey<Color>("textShadowColor", Color.class, null, true, labels);
    /**
     * Text shadow offset. The value of this attribute is a Dimension2DDouble object.
     */
    public final static AttributeKey<Dimension2DDouble> TEXT_SHADOW_OFFSET = new AttributeKey<Dimension2DDouble>("textShadowOffset", Dimension2DDouble.class, new Dimension2DDouble(1d, 1d), false, labels);

    public static enum Alignment {

        /** align on the left or the top */
        LEADING,
        /** align on the right or the bottom */
        TRAILING,
        /** align in the center */
        CENTER,
        /** stretch to fill horizontally, or vertically */
        BLOCK,
    }
    /**
     * Text alignment. The value of this attribute is a Alignment enum.
     */
    public final static AttributeKey<Alignment> TEXT_ALIGNMENT = new AttributeKey<Alignment>("textAlignment", Alignment.class, Alignment.LEADING, false, labels);
    /**
     * The value of this attribute is a Font object, which is used as a prototype
     * to create the font for the text.
     */
    public final static AttributeKey<Font> FONT_FACE = new AttributeKey<Font>("fontFace", Font.class, new Font("VERDANA", Font.PLAIN, 10), false, labels);
    /**
     * The value of this attribute is a double object.
     */
    public final static AttributeKey<Double> FONT_SIZE = new AttributeKey<Double>("fontSize", Double.class, 12d, false, labels);
    /**
     * The value of this attribute is a Boolean object.
     */
    public final static AttributeKey<Boolean> FONT_BOLD = new AttributeKey<Boolean>("fontBold", Boolean.class, false, false, labels);
    /**
     * The value of this attribute is a Boolean object.
     */
    public final static AttributeKey<Boolean> FONT_ITALIC = new AttributeKey<Boolean>("fontItalic", Boolean.class, false, false, labels);
    /**
     * The value of this attribute is a Boolean object.
     */
    public final static AttributeKey<Boolean> FONT_UNDERLINE = new AttributeKey<Boolean>("fontUnderline", Boolean.class, false, false, labels);
    /**
     * The value of this attribute is a Liner object.
     */
    public final static AttributeKey<Liner> BEZIER_PATH_LAYOUTER = new AttributeKey<Liner>("bezierPathLayouter", Liner.class, null, true, labels);
    public static final AttributeKey<LineDecoration> END_DECORATION = new AttributeKey<LineDecoration>("endDecoration", LineDecoration.class, null, true, labels);
    public static final AttributeKey<LineDecoration> START_DECORATION = new AttributeKey<LineDecoration>("startDecoration", LineDecoration.class, null, true, labels);
    /**
     * The value of this attribute is a Insets2D.Double object.
     */
    public static final AttributeKey<Insets2D.Double> DECORATOR_INSETS = new AttributeKey<Insets2D.Double>("decoratorInsets", Insets2D.Double.class, new Insets2D.Double(), false, labels);
    /**
     * The value of this attribute is a Insets2D.Double object.
     * <p>
     * This attribute can be put on a CompositeFigure, which uses
     * a Layouter to lay out its children.
     * <p>
     * The insets are used to determine the insets between the bounds
     * of the CompositeFigure and its children.
     */
    public final static AttributeKey<Insets2D.Double> LAYOUT_INSETS = new AttributeKey<Insets2D.Double>("borderInsets", Insets2D.Double.class, new Insets2D.Double(), false, labels);
    /**
     * The value of this attribute is a Alignment object.
     * <p>
     * This attribute can be put on a CompositeFigure, which uses
     * a Layouter to lay out its children.
     * <p>
     * The insets are used to determine the default alignment of
     * the children of the CompositeFigure.
     */
    public final static AttributeKey<Alignment> COMPOSITE_ALIGNMENT = new AttributeKey<Alignment>("layoutAlignment", Alignment.class, Alignment.BLOCK, false, labels);
    /**
     * The value of this attribute is a Alignment object.
     * <p>
     * This attribute can be put on a child of a CompositeFigure, which uses
     * a Layouter to lay out its children.
     * <p>
     * Layouters should use this attribute, to determine the default alignment
     * of the child figures contained in the CompositeFigure which they lay out.
     */
    public final static AttributeKey<Alignment> CHILD_ALIGNMENT = new AttributeKey<Alignment>("layoutAlignment", Alignment.class, null, true, labels);
    /**
     * Specifies the transform of a Figure.
     */
    public final static AttributeKey<AffineTransform> TRANSFORM = new AttributeKey<AffineTransform>("transform", AffineTransform.class, null, true, labels);

    public static enum Orientation {

        NORTH,
        NORTH_EAST,
        EAST,
        SOUTH_EAST,
        SOUTH,
        SOUTH_WEST,
        WEST,
        NORTH_WEST
    }
    /**
     * Specifies the orientation of a Figure.
     */
    public final static AttributeKey<Orientation> ORIENTATION = new AttributeKey<Orientation>("orientation", Orientation.class, Orientation.NORTH, false, labels);
    /**
     * A put with all attributes defined by this class.
     */
    public final static Set<AttributeKey> supportedAttributes;
    public final static Map<String, AttributeKey> supportedAttributeMap;


    static {
        HashSet<AttributeKey> as = new HashSet<AttributeKey>();
        as.addAll(Arrays.asList(new AttributeKey[]{
                    FILL_COLOR,
                    FILL_UNDER_STROKE,
                    STROKE_COLOR,
                    STROKE_WIDTH,
                    STROKE_INNER_WIDTH_FACTOR,
                    STROKE_JOIN,
                    STROKE_CAP,
                    STROKE_MITER_LIMIT,
                    STROKE_DASHES,
                    STROKE_DASH_PHASE,
                    STROKE_TYPE,
                    STROKE_PLACEMENT,
                    TEXT,
                    TEXT_COLOR,
                    TEXT_SHADOW_COLOR,
                    TEXT_SHADOW_OFFSET,
                    TRANSFORM,
                    FONT_FACE,
                    FONT_SIZE,
                    FONT_BOLD,
                    FONT_ITALIC,
                    FONT_UNDERLINE,
                    BEZIER_PATH_LAYOUTER,
                    END_DECORATION,
                    START_DECORATION,
                    DECORATOR_INSETS,
                    ORIENTATION,
                    WINDING_RULE,}));
        supportedAttributes = Collections.unmodifiableSet(as);
        HashMap<String, AttributeKey> am = new HashMap<String, AttributeKey>();
        for (AttributeKey a : as) {
            am.put(a.getKey(), a);
        }
        supportedAttributeMap = Collections.unmodifiableMap(am);
    }

    /**
     * Convenience method for computing the total stroke width from the
     * STROKE_WIDTH, STROKE_INNER_WIDTH and STROKE_TYPE attributes.
     */
    public static double getStrokeTotalWidth(Figure f) {
        switch (f.get(STROKE_TYPE)) {
            case BASIC:
            default:
                return f.get(STROKE_WIDTH);
            // break; not reached
            case DOUBLE:
                return f.get(STROKE_WIDTH) * (1d + f.get(STROKE_INNER_WIDTH_FACTOR));
            // break; not reached
        }
    }

    /**
     * Convenience method for computing the total stroke miter limit from the
     * STROKE_MITER_LIMIT, and IS_STROKE_MITER_LIMIT factor.
     */
    public static double getStrokeTotalMiterLimit(Figure f) {
        if (f.get(IS_STROKE_MITER_LIMIT_FACTOR)) {
            return f.get(STROKE_MITER_LIMIT) * f.get(STROKE_WIDTH);
        } else {
            return f.get(STROKE_MITER_LIMIT);
        }
    }

    public static Stroke getStroke(Figure f) {
        double strokeWidth = f.get(STROKE_WIDTH);
        float miterLimit = (float) getStrokeTotalMiterLimit(f);
        double dashFactor = f.get(IS_STROKE_DASH_FACTOR) ? strokeWidth : 1d;
        double dashPhase = f.get(STROKE_DASH_PHASE);
        double[] ddashes = f.get(STROKE_DASHES);
        float[] dashes = null;
        boolean isAllZeroes = true;
        if (ddashes != null) {
            dashes = new float[ddashes.length];
            double dashSize = 0f;
            for (int i = 0; i < dashes.length; i++) {
                dashes[i] = Math.max(0f, (float) (ddashes[i] * dashFactor));
                dashSize += dashes[i];
                if (isAllZeroes && dashes[i] != 0) {
                    isAllZeroes = false;
                }
            }
            if (dashes.length % 2 == 1) {
                dashSize *= 2;
            }
            if (dashPhase < 0) {
                dashPhase = dashSize + dashPhase % dashSize;
            }
        }
        if (isAllZeroes) {
            // don't draw dashes, if all values are 0.
            dashes = null;
        }
        switch (f.get(STROKE_TYPE)) {
            case BASIC:
            default:
                return new BasicStroke((float) strokeWidth,
                        f.get(STROKE_CAP),
                        f.get(STROKE_JOIN),
                        miterLimit,
                        dashes, Math.max(0, (float) (dashPhase * dashFactor)));
            //not reached

            case DOUBLE:
                return new DoubleStroke(
                        (float) (f.get(STROKE_INNER_WIDTH_FACTOR) * strokeWidth),
                        (float) strokeWidth,
                        f.get(STROKE_CAP),
                        f.get(STROKE_JOIN),
                        miterLimit,
                        dashes, Math.max(0, (float) (dashPhase * dashFactor)));
            //not reached
        }
    }

    /**
     * Returns a stroke which is useful for hit-testing.
     * The stroke reflects the stroke width, but not the stroke dashes
     * attribute.
     * @param f
     * @return A stroke suited for creating a shape for hit testing.
     */
    public static Stroke getHitStroke(Figure f) {
        double strokeWidth = Math.max(1, f.get(STROKE_WIDTH));
        float miterLimit = (float) getStrokeTotalMiterLimit(f);
        double dashFactor = f.get(IS_STROKE_DASH_FACTOR) ? strokeWidth : 1d;
        switch (f.get(STROKE_TYPE)) {
            case BASIC:
            default:
                return new BasicStroke((float) strokeWidth,
                        f.get(STROKE_CAP),
                        f.get(STROKE_JOIN),
                        miterLimit,
                        null, Math.max(0, (float) (f.get(STROKE_DASH_PHASE) * dashFactor)));
            //not reached

            case DOUBLE:
                return new DoubleStroke(
                        (float) (f.get(STROKE_INNER_WIDTH_FACTOR) * strokeWidth),
                        (float) strokeWidth,
                        f.get(STROKE_CAP),
                        f.get(STROKE_JOIN),
                        miterLimit,
                        null, Math.max(0, (float) (f.get(STROKE_DASH_PHASE).floatValue() * dashFactor)));
            //not reached
        }
    }

    @Nullable public static Font getFont(Figure f) {
        Font prototype = f.get(FONT_FACE);
        if (prototype == null) {
            return null;
        }
        if (getFontStyle(f) != Font.PLAIN) {
            return prototype.deriveFont(getFontStyle(f), f.get(FONT_SIZE).floatValue());
        } else {
            return prototype.deriveFont(f.get(FONT_SIZE).floatValue());
        }
    }

    public static int getFontStyle(Figure f) {
        int style = Font.PLAIN;
        if (f.get(FONT_BOLD)) {
            style |= Font.BOLD;
        }
        if (f.get(FONT_ITALIC)) {
            style |= Font.ITALIC;
        }
        return style;
    }

    /**
     * Returns the distance, that a Rectangle needs to grow (or shrink) to
     * fill its shape as specified by the FILL_UNDER_STROKE and STROKE_POSITION
     * attributes of a figure.
     * The value returned is the number of units that need to be grown (or shrunk)
     * perpendicular to a stroke on an outline of the shape.
     */
    public static double getPerpendicularFillGrowth(Figure f) {
        double grow;
        double strokeWidth = AttributeKeys.getStrokeTotalWidth(f);
        StrokePlacement placement = f.get(STROKE_PLACEMENT);
        switch (f.get(FILL_UNDER_STROKE)) {
            case FULL:
                switch (placement) {
                    case INSIDE:
                        grow = 0f;
                        break;
                    case OUTSIDE:
                        grow = strokeWidth;
                        break;
                    case CENTER:
                    default:
                        grow = strokeWidth / 2d;
                        break;
                }
                break;
            case NONE:
                switch (placement) {
                    case INSIDE:
                        grow = -strokeWidth;
                        break;
                    case OUTSIDE:
                        grow = 0f;
                        break;
                    case CENTER:
                    default:
                        grow = strokeWidth / -2d;
                        break;
                }
                break;
            case CENTER:
            default:
                switch (placement) {
                    case INSIDE:
                        grow = strokeWidth / -2d;
                        break;
                    case OUTSIDE:
                        grow = strokeWidth / 2d;
                        break;
                    case CENTER:
                    default:
                        grow = 0d;
                        break;
                }
                break;
        }
        return grow;
    }

    /**
     * Returns the distance, that a Rectangle needs to grow (or shrink) to
     * draw (aka stroke) its shape as specified by the FILL_UNDER_STROKE and 
     * STROKE_POSITION attributes of a figure.
     * The value returned is the number of units that need to be grown (or shrunk)
     * perpendicular to a stroke on an outline of the shape.
     */
    public static double getPerpendicularDrawGrowth(Figure f) {
        double grow;

        double strokeWidth = AttributeKeys.getStrokeTotalWidth(f);
        switch (f.get(STROKE_PLACEMENT)) {
            case INSIDE:
                grow = strokeWidth / -2d;
                break;
            case OUTSIDE:
                grow = strokeWidth / 2d;
                break;
            case CENTER:
            default:
                grow = 0f;
                break;
        }
        return grow;
    }

    /**
     * Returns the distance, that a Rectangle needs to grow (or shrink) to
     * make hit detections on a shape as specified by the FILL_UNDER_STROKE and STROKE_POSITION
     * attributes of a figure.
     * The value returned is the number of units that need to be grown (or shrunk)
     * perpendicular to a stroke on an outline of the shape.
     */
    public static double getPerpendicularHitGrowth(Figure f) {
        double grow;
        if (f.get(STROKE_COLOR) == null) {
            grow = getPerpendicularFillGrowth(f);
        } else {
            double strokeWidth = AttributeKeys.getStrokeTotalWidth(f);
            grow = getPerpendicularDrawGrowth(f) + strokeWidth / 2d;
        }
        return grow;
    }
}
