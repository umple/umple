/**
 * @(#)HandleAttributeKeys.java
 *
 * Copyright (c) 2008-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw.handle;

import org.jhotdraw.draw.*;
import java.awt.*;

/**
 * Defines a put of well known {@link Handle} attributes.
 * <p>
 * If you want different attribute values for your own editor, put
 * the desired values using {@link DrawingEditor#setHandleAttribute(org.jhotdraw.draw.AttributeKey, java.lang.Object)}.
 *
 * @author Werner Randelshofer
 * @version $Id: HandleAttributeKeys.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class HandleAttributeKeys {
    /** Fill color of disabled handles. */
    private final static Color FILL_COLOR_DISABLED_ = new Color(0x80000000,true);
    /** Stroke color of disabled handles. */
    private final static Color STROKE_COLOR_DISABLED_ = new Color(0x80ffffff,true);

    /**
     * General handle size.
     */
    public final static AttributeKey<Integer> HANDLE_SIZE = new AttributeKey<Integer>("handleSize", Integer.class, 7);
    /**
     * General handle stroke color.
     */
    public final static AttributeKey<Color> HANDLE_STROKE_COLOR = new AttributeKey<Color>("handleStrokeColor", Color.class, Color.WHITE);
    /**
     * General handle fill color.
     */
    public final static AttributeKey<Color> HANDLE_FILL_COLOR = new AttributeKey<Color>("handleFillColor", Color.class, Color.BLACK);
    /**
     * General handle stroke.
     */
    public final static AttributeKey<Stroke> HANDLE_STROKE = new AttributeKey<Stroke>("handleStroke", Stroke.class, new BasicStroke(1f));
    /**
     * General handle stroke color.
     */
    public final static AttributeKey<Color> HANDLE_STROKE_COLOR_DISABLED = new AttributeKey<Color>("handleStrokeColor", Color.class, STROKE_COLOR_DISABLED_);
    /**
     * General handle fill color.
     */
    public final static AttributeKey<Color> HANDLE_FILL_COLOR_DISABLED = new AttributeKey<Color>("handleFillColor", Color.class, FILL_COLOR_DISABLED_);
    //--
    /**
     * Rotate handle stroke color.
     */
    public final static AttributeKey<Color> ROTATE_HANDLE_STROKE_COLOR = new AttributeKey<Color>("rotateHandleStrokeColor", Color.class, Color.WHITE);
    /**
     * Rotate handle fill color.
     */
    public final static AttributeKey<Color> ROTATE_HANDLE_FILL_COLOR = new AttributeKey<Color>("rotateHandleFillColor", Color.class, Color.MAGENTA);
    //--
    /**
     * Rotate handle stroke color.
     */
    public final static AttributeKey<Color> ROTATE_HANDLE_STROKE_COLOR_DISABLED = new AttributeKey<Color>("rotateHandleStrokeColorDisabled", Color.class, STROKE_COLOR_DISABLED_);
    /**
     * Rotate handle fill color.
     */
    public final static AttributeKey<Color> ROTATE_HANDLE_FILL_COLOR_DISABLED = new AttributeKey<Color>("rotateHandleFillColorDisabled", Color.class, FILL_COLOR_DISABLED_);
    //--
    /**
     * Bezier control point handle stroke color.
     */
    public final static AttributeKey<Color> BEZIER_CONTROL_POINT_HANDLE_STROKE_COLOR = new AttributeKey<Color>("bezierControlPointHandleStrokeColor", Color.class, Color.WHITE);
    /**
     * Bezier control point handle fill color.
     */
    public final static AttributeKey<Color> BEZIER_CONTROL_POINT_HANDLE_FILL_COLOR = new AttributeKey<Color>("bezierControlPointHandleFillColor", Color.class, Color.BLUE);
    /**
     * Bezier tangent line stroke color 1.
     */
    public final static AttributeKey<Color> BEZIER_TANGENT_COLOR_1 = new AttributeKey<Color>("bezierTangentColor1", Color.class, Color.WHITE);
    /**
     * Bezier tangent line stroke color 2.
     */
    public final static AttributeKey<Color> BEZIER_TANGENT_COLOR_2 = new AttributeKey<Color>("bezierTangentColor1", Color.class, Color.BLUE);
    /**
     * Bezier tangent line stroke 1.
     */
    public final static AttributeKey<Stroke> BEZIER_TANGENT_STROKE_1 = new AttributeKey<Stroke>("bezierTangentStroke1", Stroke.class,
            new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0f, new float[]{5f, 5f}, 0f));
    /**
     * Bezier tangent line stroke 2.
     */
    public final static AttributeKey<Stroke> BEZIER_TANGENT_STROKE_2 = new AttributeKey<Stroke>("bezierTangentStroke2", Stroke.class,
            new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0f, new float[]{5f, 5f}, 5f));
    /**
     * Bezier node handle stroke color.
     */
    public final static AttributeKey<Color> BEZIER_NODE_HANDLE_STROKE_COLOR = new AttributeKey<Color>("bezierControlPointStrokeColor", Color.class, Color.WHITE);
    /**
     * Bezier node handle fill color.
     */
    public final static AttributeKey<Color> BEZIER_NODE_HANDLE_FILL_COLOR = new AttributeKey<Color>("bezierControlPointFillColor", Color.class, new Color(0x00a8ff));
    /**
     * Bezier path stroke color 1.
     */
    public final static AttributeKey<Color> BEZIER_PATH_COLOR_1 = new AttributeKey<Color>("bezierPathColor1", Color.class, Color.WHITE);
    /**
     * Bezier path stroke color 2.
     */
    public final static AttributeKey<Color> BEZIER_PATH_COLOR_2 = new AttributeKey<Color>("bezierPathColor2", Color.class, new Color(0x00a8ff));
    /**
     * Bezier path stroke 1.
     */
    public final static AttributeKey<Stroke> BEZIER_PATH_STROKE_1 = new AttributeKey<Stroke>("bezierPathStroke1", Stroke.class,
            new BasicStroke(3f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL));
    /**
     * Bezier path stroke 2.
     */
    public final static AttributeKey<Stroke> BEZIER_PATH_STROKE_2 = new AttributeKey<Stroke>("bezierPathStroke2", Stroke.class,
            new BasicStroke(1f));
    //---
    /**
     * Bezier path hover stroke color 1.
     */
    public final static AttributeKey<Color> BEZIER_PATH_COLOR_1_HOVER = new AttributeKey<Color>("bezierPathColor1Hover", Color.class, null);
    /**
     * Bezier path hover stroke color 2.
     */
    public final static AttributeKey<Color> BEZIER_PATH_COLOR_2_HOVER = new AttributeKey<Color>("bezierPathColor2Hover", Color.class, new Color(0x00a8ff));
    /**
     * Bezier path hover stroke 1.
     */
    public final static AttributeKey<Stroke> BEZIER_PATH_STROKE_1_HOVER = new AttributeKey<Stroke>("bezierPathStroke1Hover", Stroke.class,
            null);
    /**
     * Bezier path hover stroke 2.
     */
    public final static AttributeKey<Stroke> BEZIER_PATH_STROKE_2_HOVER = new AttributeKey<Stroke>("bezierPathStroke2Hover", Stroke.class,
            new BasicStroke(1f));
    //---
    /**
     * Bezier control point handle stroke color.
     */
    public final static AttributeKey<Color> BEZIER_CONTROL_POINT_HANDLE_STROKE_COLOR_DISABLED = new AttributeKey<Color>("bezierControlPointHandleStrokeColorDisabled", Color.class, STROKE_COLOR_DISABLED_);
    /**
     * Bezier control point handle fill color.
     */
    public final static AttributeKey<Color> BEZIER_CONTROL_POINT_HANDLE_FILL_COLOR_DISABLED = new AttributeKey<Color>("bezierControlPointHandleFillColorDisabled", Color.class, FILL_COLOR_DISABLED_);
    /**
     * Bezier tangent line stroke color 1.
     */
    public final static AttributeKey<Color> BEZIER_TANGENT_COLOR_1_DISABLED = new AttributeKey<Color>("bezierTangentColor1Disabled", Color.class, STROKE_COLOR_DISABLED_);
    /**
     * Bezier tangent line stroke color 2.
     */
    public final static AttributeKey<Color> BEZIER_TANGENT_COLOR_2_DISABLED = new AttributeKey<Color>("bezierTangentColor1Disabled", Color.class, FILL_COLOR_DISABLED_);
    /**
     * Bezier tangent line stroke 1.
     */
    public final static AttributeKey<Stroke> BEZIER_TANGENT_STROKE_1_DISABLED = new AttributeKey<Stroke>("bezierTangentStroke1Disabled", Stroke.class,
            new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0f, new float[]{5f, 5f}, 0f));
    /**
     * Bezier tangent line stroke 2.
     */
    public final static AttributeKey<Stroke> BEZIER_TANGENT_STROKE_2_DISABLED = new AttributeKey<Stroke>("bezierTangentStroke2Disabled", Stroke.class,
            new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0f, new float[]{5f, 5f}, 5f));
    /**
     * Bezier node handle stroke color.
     */
    public final static AttributeKey<Color> BEZIER_NODE_HANDLE_STROKE_COLOR_DISABLED = new AttributeKey<Color>("bezierControlPointStrokeColorDisabled", Color.class, STROKE_COLOR_DISABLED_);
    /**
     * Bezier node handle fill color.
     */
    public final static AttributeKey<Color> BEZIER_NODE_HANDLE_FILL_COLOR_DISABLED = new AttributeKey<Color>("bezierControlPointFillColorDisabled", Color.class, FILL_COLOR_DISABLED_);
    /**
     * Bezier path stroke color 1.
     */
    public final static AttributeKey<Color> BEZIER_PATH_COLOR_1_DISABLED = new AttributeKey<Color>("bezierPathColor1Disabled", Color.class, Color.WHITE);
    /**
     * Bezier path stroke color 2.
     */
    public final static AttributeKey<Color> BEZIER_PATH_COLOR_2_DISABLED = new AttributeKey<Color>("bezierPathColor2Disabled", Color.class, new Color(0x0));
    /**
     * Bezier path stroke 1.
     */
    public final static AttributeKey<Stroke> BEZIER_PATH_STROKE_1_DISABLED = new AttributeKey<Stroke>("bezierPathStroke1Disabled", Stroke.class,
            new BasicStroke(3f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL));
    /**
     * Bezier path stroke 2.
     */
    public final static AttributeKey<Stroke> BEZIER_PATH_STROKE_2_DISABLED = new AttributeKey<Stroke>("bezierPathStroke2Disabled", Stroke.class,
            new BasicStroke(1f));
    //---
    /**
     * Scale handle stroke color.
     */
    public final static AttributeKey<Color> SCALE_HANDLE_STROKE_COLOR = new AttributeKey<Color>("scaleHandleStrokeColor", Color.class, Color.WHITE);
    /**
     * Scale handle fill color.
     */
    public final static AttributeKey<Color> SCALE_HANDLE_FILL_COLOR = new AttributeKey<Color>("scaleHandleFillColor", Color.class, Color.ORANGE.darker());
    /**
     * Resize handle stroke color.
     */
    public final static AttributeKey<Color> RESIZE_HANDLE_STROKE_COLOR = new AttributeKey<Color>("resizeHandleStrokeColor", Color.class, Color.WHITE);
    /**
     * Resize handle fill color.
     */
    public final static AttributeKey<Color> RESIZE_HANDLE_FILL_COLOR = new AttributeKey<Color>("resizeHandleFillColor", Color.class, Color.BLUE);
    /**
     * Resize bounds stroke color 1.
     */
    public final static AttributeKey<Color> RESIZE_BOUNDS_COLOR_1 = new AttributeKey<Color>("resizeBoundsColor1", Color.class, Color.WHITE);
    /**
     * Resize bounds stroke color 2.
     */
    public final static AttributeKey<Color> RESIZE_BOUNDS_COLOR_2 = new AttributeKey<Color>("resizeBoundsColor2", Color.class, Color.BLUE);
    /**
     * Resize bounds stroke 1.
     */
    public final static AttributeKey<Stroke> RESIZE_BOUNDS_STROKE_1 = new AttributeKey<Stroke>("resizeBoundsStroke1", Stroke.class,
            new BasicStroke(3f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL));
    /**
     * Resize bounds stroke 2.
     */
    public final static AttributeKey<Stroke> RESIZE_BOUNDS_STROKE_2 = new AttributeKey<Stroke>("resizeBoundsStroke2", Stroke.class,
            new BasicStroke(1f));
    // 
    /**
     * Disabled resize bounds stroke color 1.
     */
    public final static AttributeKey<Color> RESIZE_BOUNDS_COLOR_1_DISABLED = new AttributeKey<Color>("resizeBoundsColor1Hover", Color.class, STROKE_COLOR_DISABLED_);
    /**
     * Disabled resize bounds hover color 2.
     */
    public final static AttributeKey<Color> RESIZE_BOUNDS_COLOR_2_DISABLED = new AttributeKey<Color>("resizeBoundsColor2Hover", Color.class, FILL_COLOR_DISABLED_);
    /**
     * Disabled resize bounds stroke 1.
     */
    public final static AttributeKey<Stroke> RESIZE_BOUNDS_STROKE_1_DISABLED = new AttributeKey<Stroke>("resizeBoundsStroke1Hover", Stroke.class,
            new BasicStroke(3f));
    /**
     * Disabled bounds stroke 2.
     */
    public final static AttributeKey<Stroke> RESIZE_BOUNDS_STROKE_2_DISABLED = new AttributeKey<Stroke>("resizeBoundsStroke2Hover", Stroke.class,
            new BasicStroke(1f));
    //---
    // 
    /**
     * Handle bounds hover stroke color 1.
     */
    public final static AttributeKey<Color> RESIZE_BOUNDS_COLOR_1_HOVER = new AttributeKey<Color>("resizeBoundsColor1Hover", Color.class, null);
    /**
     * Resize bounds hover stroke color 2.
     */
    public final static AttributeKey<Color> RESIZE_BOUNDS_COLOR_2_HOVER = new AttributeKey<Color>("resizeBoundsColor2Hover", Color.class, Color.BLUE);
    /**
     * Resize bounds hover stroke 1.
     */
    public final static AttributeKey<Stroke> RESIZE_BOUNDS_STROKE_1_HOVER = new AttributeKey<Stroke>("resizeBoundsStroke1Hover", Stroke.class,
            null);
    /**
     * Resize bounds hover stroke 2.
     */
    public final static AttributeKey<Stroke> RESIZE_BOUNDS_STROKE_2_HOVER = new AttributeKey<Stroke>("resizeBoundsStroke2Hover", Stroke.class,
            new BasicStroke(1f));
    //---
    /**
     * Transform handle stroke color.
     */
    public final static AttributeKey<Color> TRANSFORM_HANDLE_STROKE_COLOR = new AttributeKey<Color>("transformHandleStrokeColor", Color.class, Color.WHITE);
    /**
     * Transform handle fill color.
     */
    public final static AttributeKey<Color> TRANSFORM_HANDLE_FILL_COLOR = new AttributeKey<Color>("transformHandleFillColor", Color.class, Color.MAGENTA);
    //---
    /**
     * Transform handle stroke color.
     */
    public final static AttributeKey<Color> TRANSFORM_HANDLE_STROKE_COLOR_DISABLED = new AttributeKey<Color>("transformHandleStrokeColorDisabled", Color.class, STROKE_COLOR_DISABLED_);
    /**
     * Transform handle fill color.
     */
    public final static AttributeKey<Color> TRANSFORM_HANDLE_FILL_COLOR_DISABLED = new AttributeKey<Color>("transformHandleFillColorDisabled", Color.class, FILL_COLOR_DISABLED_);
    /**
     * Transform bounds color 1.
     */
    public final static AttributeKey<Color> TRANSFORM_BOUNDS_COLOR_1 = new AttributeKey<Color>("transformBoundsColor1", Color.class, Color.WHITE);
    /**
     * Transform bounds color 2.
     */
    public final static AttributeKey<Color> TRANSFORM_BOUNDS_COLOR_2 = new AttributeKey<Color>("transformBoundsColor2", Color.class, Color.MAGENTA);
    /**
     * Transform bounds stroke 1.
     */
    public final static AttributeKey<Stroke> TRANSFORM_BOUNDS_STROKE_1 = new AttributeKey<Stroke>("transformBoundsStroke1", Stroke.class,
            new BasicStroke(3f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL));
    /**
     * Transform bounds stroke 2.
     */
    public final static AttributeKey<Stroke> TRANSFORM_BOUNDS_STROKE_2 = new AttributeKey<Stroke>("transformBoundsStroke2", Stroke.class,
            new BasicStroke(1f));
    //---
    /**
     * Transform bounds hover color 1.
     */
    public final static AttributeKey<Color> TRANSFORM_BOUNDS_COLOR_1_HOVER = new AttributeKey<Color>("transformBoundsColor1Hover", Color.class, null);
    /**
     * Transform bounds hover color 2.
     */
    public final static AttributeKey<Color> TRANSFORM_BOUNDS_COLOR_2_HOVER = new AttributeKey<Color>("transformBoundsColor2Hover", Color.class, Color.MAGENTA);
    /**
     * Transform bounds hover stroke 1.
     */
    public final static AttributeKey<Stroke> TRANSFORM_BOUNDS_STROKE_1_HOVER = new AttributeKey<Stroke>("transformBoundsStroke1Hover", Stroke.class,
            null);
    /**
     * Transform bounds hover stroke 2.
     */
    public final static AttributeKey<Stroke> TRANSFORM_BOUNDS_STROKE_2_HOVER = new AttributeKey<Stroke>("transformBoundsStroke2Hover", Stroke.class,
            new BasicStroke(1f));
    //---
    //---
    /**
     * Transform bounds disabled color 1.
     */
    public final static AttributeKey<Color> TRANSFORM_BOUNDS_COLOR_1_DISABLED = new AttributeKey<Color>("transformBoundsColor1Disabled", Color.class, STROKE_COLOR_DISABLED_);
    /**
     * Transform bounds disabled color 2.
     */
    public final static AttributeKey<Color> TRANSFORM_BOUNDS_COLOR_2_DISABLED = new AttributeKey<Color>("transformBoundsColor2Disabled", Color.class, FILL_COLOR_DISABLED_);
    /**
     * Transform bounds disabled stroke 1.
     */
    public final static AttributeKey<Stroke> TRANSFORM_BOUNDS_STROKE_1_DISABLED = new AttributeKey<Stroke>("transformBoundsStroke1Disabled", Stroke.class,
            new BasicStroke(3f));
    /**
     * Transform bounds disabled stroke 2.
     */
    public final static AttributeKey<Stroke> TRANSFORM_BOUNDS_STROKE_2_DISABLED = new AttributeKey<Stroke>("transformBoundsStroke2Disabled", Stroke.class,
            new BasicStroke(1f));
    //---
    //---
    /**
     * Group handle stroke color.
     */
    public final static AttributeKey<Color> GROUP_HANDLE_STROKE_COLOR = new AttributeKey<Color>("transformHandleStrokeColor", Color.class, Color.WHITE);
    /**
     * Group handle fill color.
     */
    public final static AttributeKey<Color> GROUP_HANDLE_FILL_COLOR = new AttributeKey<Color>("transformHandleFillColor", Color.class, Color.MAGENTA);
    //---
    /**
     * Group handle stroke color.
     */
    public final static AttributeKey<Color> GROUP_HANDLE_STROKE_COLOR_DISABLED = new AttributeKey<Color>("transformHandleStrokeColorDisabled", Color.class, STROKE_COLOR_DISABLED_);
    /**
     * Group handle fill color.
     */
    public final static AttributeKey<Color> GROUP_HANDLE_FILL_COLOR_DISABLED = new AttributeKey<Color>("transformHandleFillColorDisabled", Color.class, FILL_COLOR_DISABLED_);
    /**
     * Group bounds color 1.
     */
    public final static AttributeKey<Color> GROUP_BOUNDS_COLOR_1 = new AttributeKey<Color>("transformBoundsColor1", Color.class, Color.WHITE);
    /**
     * Group bounds color 2.
     */
    public final static AttributeKey<Color> GROUP_BOUNDS_COLOR_2 = new AttributeKey<Color>("transformBoundsColor2", Color.class, Color.MAGENTA);
    /**
     * Group bounds stroke 1.
     */
    public final static AttributeKey<Stroke> GROUP_BOUNDS_STROKE_1 = new AttributeKey<Stroke>("transformBoundsStroke1", Stroke.class,
            new BasicStroke(3f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL));
    /**
     * Group bounds stroke 2.
     */
    public final static AttributeKey<Stroke> GROUP_BOUNDS_STROKE_2 = new AttributeKey<Stroke>("transformBoundsStroke2", Stroke.class,
            new BasicStroke( 1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1f, new float[] {2f,2f}, 0f));
    //---
    /**
     * Group bounds hover color 1.
     */
    public final static AttributeKey<Color> GROUP_BOUNDS_COLOR_1_HOVER = new AttributeKey<Color>("transformBoundsColor1Hover", Color.class, null);
    /**
     * Group bounds hover color 2.
     */
    public final static AttributeKey<Color> GROUP_BOUNDS_COLOR_2_HOVER = new AttributeKey<Color>("transformBoundsColor2Hover", Color.class, Color.MAGENTA);
    /**
     * Group bounds hover stroke 1.
     */
    public final static AttributeKey<Stroke> GROUP_BOUNDS_STROKE_1_HOVER = new AttributeKey<Stroke>("transformBoundsStroke1Hover", Stroke.class,
            null);
    /**
     * Group bounds hover stroke 2.
     */
    public final static AttributeKey<Stroke> GROUP_BOUNDS_STROKE_2_HOVER = new AttributeKey<Stroke>("transformBoundsStroke2Hover", Stroke.class,
            new BasicStroke( 1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1f, new float[] {2f,2f}, 0f));
    //---
    //---
    /**
     * Group bounds disabled color 1.
     */
    public final static AttributeKey<Color> GROUP_BOUNDS_COLOR_1_DISABLED = new AttributeKey<Color>("transformBoundsColor1Disabled", Color.class, STROKE_COLOR_DISABLED_);
    /**
     * Group bounds disabled color 2.
     */
    public final static AttributeKey<Color> GROUP_BOUNDS_COLOR_2_DISABLED = new AttributeKey<Color>("transformBoundsColor2Disabled", Color.class, FILL_COLOR_DISABLED_);
    /**
     * Group bounds disabled stroke 1.
     */
    public final static AttributeKey<Stroke> GROUP_BOUNDS_STROKE_1_DISABLED = new AttributeKey<Stroke>("transformBoundsStroke1Disabled", Stroke.class,
            new BasicStroke(3f));
    /**
     * Group bounds disabled stroke 2.
     */
    public final static AttributeKey<Stroke> GROUP_BOUNDS_STROKE_2_DISABLED = new AttributeKey<Stroke>("transformBoundsStroke2Disabled", Stroke.class,
            new BasicStroke(1f));
    //---
    /**
     * Handle stroke color.
     */
    public final static AttributeKey<Color> CONNECTED_CONNECTION_HANDLE_STROKE_COLOR = new AttributeKey<Color>("connectedConnectionHandleStrokeColor", Color.class, Color.BLACK);
    /**
     * Handle fill color.
     */
    public final static AttributeKey<Color> CONNECTED_CONNECTION_HANDLE_FILL_COLOR = new AttributeKey<Color>("connectedConnectionHandleFillColor", Color.class, Color.GREEN);
    /**
     * Handle stroke color.
     */
    public final static AttributeKey<Color> DISCONNECTED_CONNECTION_HANDLE_STROKE_COLOR = new AttributeKey<Color>("disconnectedConnectionHandleStrokeColor", Color.class, Color.BLACK);
    /**
     * Handle fill color.
     */
    public final static AttributeKey<Color> DISCONNECTED_CONNECTION_HANDLE_FILL_COLOR = new AttributeKey<Color>("disconnectedConnectionHandleFillColor", Color.class, Color.RED);
    /**
     * Handle stroke color.
     */
    public final static AttributeKey<Color> CONNECTED_CONNECTOR_HANDLE_STROKE_COLOR = new AttributeKey<Color>("connectedConnectorHandleStrokeColor", Color.class, Color.BLACK);
    /**
     * Handle fill color.
     */
    public final static AttributeKey<Color> CONNECTED_CONNECTOR_HANDLE_FILL_COLOR = new AttributeKey<Color>("connectedConnectorHandleFillColor", Color.class, Color.GREEN);
    /**
     * Handle stroke color.
     */
    public final static AttributeKey<Color> DISCONNECTED_CONNECTOR_HANDLE_STROKE_COLOR = new AttributeKey<Color>("disconnectedConnectorHandleStrokeColor", Color.class, Color.BLACK);
    /**
     * Handle fill color.
     */
    public final static AttributeKey<Color> DISCONNECTED_CONNECTOR_HANDLE_FILL_COLOR = new AttributeKey<Color>("disconnectedConnectorHandleFillColor", Color.class, Color.RED);
    /**
     * Handle stroke color.
     */
    public final static AttributeKey<Color> MOVE_HANDLE_STROKE_COLOR = new AttributeKey<Color>("moveHandleStrokeColor", Color.class, Color.BLACK);
    /**
     * Handle fill color.
     */
    public final static AttributeKey<Color> MOVE_HANDLE_FILL_COLOR = new AttributeKey<Color>("moveHandleFillColor", Color.class, Color.WHITE);
    /**
     * Handle stroke color.
     */
    public final static AttributeKey<Color> NULL_HANDLE_STROKE_COLOR = new AttributeKey<Color>("nullHandleStrokeColor", Color.class, Color.DARK_GRAY);
    /**
     * Handle fill color.
     */
    public final static AttributeKey<Color> NULL_HANDLE_FILL_COLOR = new AttributeKey<Color>("nullHandleFillColor", Color.class, null);
    /**
     * Handle stroke color.
     */
    public final static AttributeKey<Color> OVERFLOW_HANDLE_STROKE_COLOR = new AttributeKey<Color>("overlfowHandleStrokeColor", Color.class, Color.RED);
    /**
     * Handle fill color.
     */
    public final static AttributeKey<Color> OVERFLOW_HANDLE_FILL_COLOR = new AttributeKey<Color>("overflowHandleFillColor", Color.class, null);
    //--
    /**
     * Attribute handle stroke color.
     */
    public final static AttributeKey<Color> ATTRIBUTE_HANDLE_STROKE_COLOR = new AttributeKey<Color>("attributeHandleStrokeColor", Color.class, Color.BLACK);
    /**
     * Attribute handle fill color.
     */
    public final static AttributeKey<Color> ATTRIBUTE_HANDLE_FILL_COLOR = new AttributeKey<Color>("attributeSizeHandleFillColor", Color.class, Color.YELLOW);
    //--
    /**
     * Attribute handle stroke color.
     */
    public final static AttributeKey<Color> ATTRIBUTE_HANDLE_STROKE_COLOR_DISABLED = new AttributeKey<Color>("attributeHandleStrokeColorDisabled", Color.class, STROKE_COLOR_DISABLED_);
    /**
     * Attribute handle fill color.
     */
    public final static AttributeKey<Color> ATTRIBUTE_HANDLE_FILL_COLOR_DISABLED = new AttributeKey<Color>("attributeSizeHandleFillColorDisabled", Color.class, FILL_COLOR_DISABLED_);
}
