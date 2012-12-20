/*
 * @(#)ButtonFactory.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw.action;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.app.action.edit.PasteAction;
import org.jhotdraw.app.action.edit.CutAction;
import org.jhotdraw.app.action.edit.CopyAction;
import org.jhotdraw.app.action.edit.DuplicateAction;
import org.jhotdraw.draw.tool.Tool;
import org.jhotdraw.draw.tool.DelegationSelectionTool;
import org.jhotdraw.draw.event.ToolEvent;
import org.jhotdraw.draw.event.ToolListener;
import org.jhotdraw.draw.decoration.LineDecoration;
import org.jhotdraw.draw.decoration.ArrowTip;
import org.jhotdraw.draw.event.SelectionComponentRepainter;
import org.jhotdraw.gui.JPopupButton;
import org.jhotdraw.util.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.*;
import java.beans.*;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.ColorChooserUI;
import javax.swing.text.*;
import org.jhotdraw.app.action.*;
import org.jhotdraw.app.Disposable;
import org.jhotdraw.color.HSBColorSpace;
import static org.jhotdraw.draw.AttributeKeys.*;
import org.jhotdraw.geom.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.event.ToolAdapter;
import org.jhotdraw.gui.JComponentPopup;
import org.jhotdraw.gui.JFontChooser;

/**
 * ButtonFactory.
 * <p>
 * Design pattern:<br>
 * Name: Abstract Factory.<br>
 * Role: Abstract Factory.<br>
 * Partners: {@link org.jhotdraw.samples.draw.DrawApplicationModel} as Client, 
 * {@link org.jhotdraw.samples.draw.DrawView} as Client,
 * {@link org.jhotdraw.samples.draw.DrawingPanel} as Client.
 *
 * FIXME - All buttons created using the ButtonFactory must automatically
 * become disabled/enabled, when the DrawingEditor is disabled/enabled.
 *
 * @author Werner Randelshofer
 * @version $Id: ButtonFactory.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ButtonFactory {

    /**
     * Mac OS X 'Apple Color Palette'. 
     * This palette has 8 columns.
     */
    public final static java.util.List<ColorIcon> DEFAULT_COLORS;

    static {
        LinkedList<ColorIcon> m = new LinkedList<ColorIcon>();
        m.add(new ColorIcon(0x800000, "Cayenne"));
        m.add(new ColorIcon(0x808000, "Asparagus"));
        m.add(new ColorIcon(0x008000, "Clover"));
        m.add(new ColorIcon(0x008080, "Teal"));
        m.add(new ColorIcon(0x000080, "Midnight"));
        m.add(new ColorIcon(0x800080, "Plum"));
        m.add(new ColorIcon(0x7f7f7f, "Tin"));
        m.add(new ColorIcon(0x808080, "Nickel"));
        m.add(new ColorIcon(0xff0000, "Maraschino"));
        m.add(new ColorIcon(0xffff00, "Lemon"));
        m.add(new ColorIcon(0x00ff00, "Spring"));
        m.add(new ColorIcon(0x00ffff, "Turquoise"));
        m.add(new ColorIcon(0x0000ff, "Blueberry"));
        m.add(new ColorIcon(0xff00ff, "Magenta"));
        m.add(new ColorIcon(0x666666, "Steel"));
        m.add(new ColorIcon(0x999999, "Aluminium"));
        m.add(new ColorIcon(0xff6666, "Salmon"));
        m.add(new ColorIcon(0xffff66, "Banana"));
        m.add(new ColorIcon(0x66ff66, "Flora"));
        m.add(new ColorIcon(0x66ffff, "Ice"));
        m.add(new ColorIcon(0x6666ff, "Orchid"));
        m.add(new ColorIcon(0xff66ff, "Bubblegum"));
        m.add(new ColorIcon(0x4c4c4c, "Iron"));
        m.add(new ColorIcon(0xb3b3b3, "Magnesium"));
        m.add(new ColorIcon(0x804000, "Mocha"));
        m.add(new ColorIcon(0x408000, "Fern"));
        m.add(new ColorIcon(0x008040, "Moss"));
        m.add(new ColorIcon(0x004080, "Ocean"));
        m.add(new ColorIcon(0x400080, "Eggplant"));
        m.add(new ColorIcon(0x800040, "Maroon"));
        m.add(new ColorIcon(0x333333, "Tungsten"));
        m.add(new ColorIcon(0xcccccc, "Silver"));
        m.add(new ColorIcon(0xff8000, "Tangerine"));
        m.add(new ColorIcon(0x80ff00, "Lime"));
        m.add(new ColorIcon(0x00ff80, "Sea Foam"));
        m.add(new ColorIcon(0x0080ff, "Aqua"));
        m.add(new ColorIcon(0x8000ff, "Grape"));
        m.add(new ColorIcon(0xff0080, "Strawberry"));
        m.add(new ColorIcon(0x191919, "Lead"));
        m.add(new ColorIcon(0xe6e6e6, "Mercury"));
        m.add(new ColorIcon(0xffcc66, "Cantaloupe"));
        m.add(new ColorIcon(0xccff66, "Honeydew"));
        m.add(new ColorIcon(0x66ffcc, "Spindrift"));
        m.add(new ColorIcon(0x66ccff, "Sky"));
        m.add(new ColorIcon(0xcc66ff, "Lavender"));
        m.add(new ColorIcon(0xff6fcf, "Carnation"));
        m.add(new ColorIcon(0x000000, "Licorice"));
        m.add(new ColorIcon(0xffffff, "Snow"));
        DEFAULT_COLORS = Collections.unmodifiableList(m);
    }
    public final static int DEFAULT_COLORS_COLUMN_COUNT = 8;
    /**
     * Websave color palette as used by Macromedia Fireworks. 
     * This palette has 19 columns.
     * The leftmost column contains a redundant set of color
     * icons to make selection of gray scales and of the 
     * primary colors easier.
     */
    public final static java.util.List<ColorIcon> WEBSAVE_COLORS;

    static {
        LinkedList<ColorIcon> m = new LinkedList<ColorIcon>();
        for (int b = 0; b <= 0xff; b += 0x33) {
            int rgb = (b << 16) | (b << 8) | b;
            m.add(new ColorIcon(rgb));
            for (int r = 0; r <= 0x66; r += 0x33) {
                for (int g = 0; g <= 0xff; g += 0x33) {
                    rgb = (r << 16) | (g << 8) | b;
                    m.add(new ColorIcon(rgb));
                }
            }
        }
        int[] firstColumn = {
            0xff0000,
            0x00ff00,
            0x0000ff,
            0xff00ff,
            0x00ffff,
            0xffff00,};
        for (int b = 0x0, i = 0; b <= 0xff; b += 0x33, i++) {
            int rgb = (b << 16) | (b << 8) | b;
            m.add(new ColorIcon(firstColumn[i]));
            for (int r = 0x99; r <= 0xff; r += 0x33) {
                for (int g = 0; g <= 0xff; g += 0x33) {
                    rgb = 0xff000000 | (r << 16) | (g << 8) | b;
                    m.add(new ColorIcon(rgb, "#" + Integer.toHexString(rgb).substring(2)));
                }
            }
        }
        WEBSAVE_COLORS = Collections.unmodifiableList(m);
    }
    public final static int WEBSAVE_COLORS_COLUMN_COUNT = 19;
    /**
     * HSB color palette with a set of colors chosen based on a physical criteria.
     * <p>
     * This is a 'human friendly' color palette which arranges the color in a
     * way that makes it easy for humans to select the desired
     * color. The colors are ordered in a way which minimizes the color contrast
     * effect in the human visual system.
     * <p>
     * This palette has 12 columns and 10 rows.
     * <p>
     * The topmost row contains a null-color and a gray scale from white to
     * black in 10 percent steps.
     * <p>
     * The remaining rows contain colors taken from the outer hull of the HSB
     * color model:
     * <p>
     * The columns are ordered by hue starting with red - the lowest wavelength -
     * and ending with purple - the highest wavelength. There are 12 different
     * hues, so that all primary colors with their additive complements can be
     * selected. 
     * <p>
     * The rows are orderd by brightness with the brightest color at the top (sky)
     * and the darkest color at the bottom (earth).
     * The first 5 rows contain colors with maximal brightness and a saturation
     * ranging form 20% up to 100%. The remaining 4 rows contain colors with
     * maximal saturation and a brightness ranging from 90% to 20% (this also
     * makes for a range from 100% to 20% if the 5th row is taken into account).
     */
    public final static java.util.List<ColorIcon> HSB_COLORS;
    public final static int HSB_COLORS_COLUMN_COUNT = 12;
    /**
     * This is the same palette as HSB_COLORS, but all color values are
     * specified in the sRGB color space.
     */
    public final static java.util.List<ColorIcon> HSB_COLORS_AS_RGB;
    public final static int HSB_COLORS_AS_RGB_COLUMN_COUNT = 12;

    static {
        ColorSpace grayCS = ColorSpace.getInstance(ColorSpace.CS_GRAY);
        HSBColorSpace hsbCS = HSBColorSpace.getInstance();
        LinkedList<ColorIcon> m = new LinkedList<ColorIcon>();
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        m.add(new ColorIcon(new Color(0, true), labels.getToolTipTextProperty("attribute.color.noColor")));

        for (int b = 10; b >= 0; b--) {
            Color c = new Color(grayCS, new float[]{b / 10f}, 1f);
            m.add(new ColorIcon(c,//
                    labels.getFormatted("attribute.color.grayComponents.toolTipText", b * 10)));
        }
        for (int s = 2; s <= 8; s += 2) {
            for (int h = 0; h < 12; h++) {
                Color c = new Color(hsbCS, new float[]{(h) / 12f, s * 0.1f, 1f}, 1f);
                m.add(new ColorIcon(c,//
                        labels.getFormatted("attribute.color.hsbComponents.toolTipText", h * 360 / 12, s * 10, 100)));
            }
        }
        for (int b = 10; b >= 2; b -= 2) {
            for (int h = 0; h < 12; h++) {
                Color c = new Color(hsbCS, new float[]{(h) / 12f, 1f, b * 0.1f}, 1f);
                m.add(new ColorIcon(new Color(hsbCS, new float[]{(h) / 12f, 1f, b * 0.1f}, 1f),//
                        labels.getFormatted("attribute.color.hsbComponents.toolTipText", h * 360 / 12, 100, b * 10)));
            }
        }
        HSB_COLORS = Collections.unmodifiableList(m);

        m = new LinkedList<ColorIcon>();
        for (ColorIcon ci : HSB_COLORS) {
            if (ci.getColor() == null) {
                m.add(new ColorIcon(new Color(0, true), labels.getToolTipTextProperty("attribute.color.noColor")));
            } else {
                Color c = ci.getColor();
                c = c.getColorSpace() == grayCS //
                        ? new Color(c.getGreen(), c.getGreen(), c.getGreen(), c.getAlpha())//workaround for rounding error
                        : new Color(c.getRed(), c.getGreen(), c.getBlue(), c.getAlpha());
                m.add(new ColorIcon(c,//
                        labels.getFormatted("attribute.color.rgbComponents.toolTipText", c.getRed(), c.getGreen(), c.getBlue())));
            }
        }

        HSB_COLORS_AS_RGB = Collections.unmodifiableList(m);
    }

    private static class ToolButtonListener implements ItemListener {

        private Tool tool;
        private DrawingEditor editor;

        public ToolButtonListener(Tool t, DrawingEditor editor) {
            this.tool = t;
            this.editor = editor;
        }

        @Override
        public void itemStateChanged(ItemEvent evt) {
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                editor.setTool(tool);
            }
        }
    }

    /** Prevent instance creation. */
    private ButtonFactory() {
    }

    public static Collection<Action> createDrawingActions(DrawingEditor editor) {
        return createDrawingActions(editor, new LinkedList<Disposable>());
    }

    public static Collection<Action> createDrawingActions(DrawingEditor editor, java.util.List<Disposable> dsp) {
        LinkedList<Action> list = new LinkedList<Action>();
        AbstractSelectedAction a;
        list.add(new CutAction());
        list.add(new CopyAction());
        list.add(new PasteAction());
        list.add(a = new SelectSameAction(editor));
        dsp.add(a);
        return list;
    }

    public static Collection<Action> createSelectionActions(DrawingEditor editor) {
        LinkedList<Action> a = new LinkedList<Action>();
        a.add(new DuplicateAction());

        a.add(null); // separator

        a.add(new GroupAction(editor));
        a.add(new UngroupAction(editor));

        a.add(null); // separator

        a.add(new BringToFrontAction(editor));
        a.add(new SendToBackAction(editor));

        return a;
    }

    public static JToggleButton addSelectionToolTo(JToolBar tb, final DrawingEditor editor) {
        return addSelectionToolTo(tb, editor, createDrawingActions(editor), createSelectionActions(editor));
    }

    public static JToggleButton addSelectionToolTo(JToolBar tb, final DrawingEditor editor,
            Collection<Action> drawingActions, Collection<Action> selectionActions) {

        Tool selectionTool = new DelegationSelectionTool(
                drawingActions, selectionActions);

        return addSelectionToolTo(tb, editor, selectionTool);
    }

    public static JToggleButton addSelectionToolTo(JToolBar tb, final DrawingEditor editor, Tool selectionTool) {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");

        JToggleButton t;
        Tool tool;
        HashMap<String, Object> attributes;

        ButtonGroup group;
        if (tb.getClientProperty("toolButtonGroup") instanceof ButtonGroup) {
            group = (ButtonGroup) tb.getClientProperty("toolButtonGroup");
        } else {
            group = new ButtonGroup();
            tb.putClientProperty("toolButtonGroup", group);
        }

        // Selection tool
        editor.setTool(selectionTool);
        t = new JToggleButton();
        final JToggleButton defaultToolButton = t;

        if (!(tb.getClientProperty("toolHandler") instanceof ToolListener)) {
            ToolListener toolHandler;
            toolHandler = new ToolAdapter() {

                @Override
                public void toolDone(ToolEvent event) {
                    defaultToolButton.setSelected(true);
                }
            };
            tb.putClientProperty("toolHandler", toolHandler);
        }

        labels.configureToolBarButton(t, "selectionTool");
        t.setSelected(true);
        t.addItemListener(
                new ToolButtonListener(selectionTool, editor));
        t.setFocusable(false);
        group.add(t);
        tb.add(t);

        return t;
    }

    /**
     * Method addSelectionToolTo must have been invoked prior to this on the
     * JToolBar.
     *
     */
    public static JToggleButton addToolTo(JToolBar tb, DrawingEditor editor,
            Tool tool, String labelKey,
            ResourceBundleUtil labels) {

        ButtonGroup group = (ButtonGroup) tb.getClientProperty("toolButtonGroup");
        ToolListener toolHandler = (ToolListener) tb.getClientProperty("toolHandler");

        JToggleButton t = new JToggleButton();
        labels.configureToolBarButton(t, labelKey);
        t.addItemListener(new ToolButtonListener(tool, editor));
        t.setFocusable(false);
        tool.addToolListener(toolHandler);
        group.add(t);
        tb.add(t);

        return t;
    }

    public static void addZoomButtonsTo(JToolBar bar, final DrawingEditor editor) {
        bar.add(createZoomButton(editor));
    }

    public static AbstractButton createZoomButton(final DrawingEditor editor) {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");

        final JPopupButton zoomPopupButton = new JPopupButton();

        labels.configureToolBarButton(zoomPopupButton, "view.zoomFactor");
        zoomPopupButton.setFocusable(false);
        if (editor.getDrawingViews().size() == 0) {
            zoomPopupButton.setText("100 %");
        } else {
            zoomPopupButton.setText((int) (editor.getDrawingViews().iterator().next().getScaleFactor() * 100) + " %");
        }
        editor.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                // String constants are interned
                if (evt.getPropertyName() == DrawingEditor.ACTIVE_VIEW_PROPERTY) {
                    if (evt.getNewValue() == null) {
                        zoomPopupButton.setText("100 %");
                    } else {
                        zoomPopupButton.setText((int) (editor.getActiveView().getScaleFactor() * 100) + " %");
                    }
                }
            }
        });

        double[] factors = {16, 8, 5, 4, 3, 2, 1.5, 1.25, 1, 0.75, 0.5, 0.25, 0.10};
        for (int i = 0; i < factors.length; i++) {
            zoomPopupButton.add(
                    new ZoomEditorAction(editor, factors[i], zoomPopupButton) {

                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            super.actionPerformed(e);
                            zoomPopupButton.setText((int) (editor.getActiveView().getScaleFactor() * 100) + " %");
                        }
                    });
        }
        //zoomPopupButton.setPreferredSize(new Dimension(16,16));
        zoomPopupButton.setFocusable(false);
        return zoomPopupButton;
    }

    public static AbstractButton createZoomButton(DrawingView view) {
        return createZoomButton(view, new double[]{
                    5, 4, 3, 2, 1.5, 1.25, 1, 0.75, 0.5, 0.25, 0.10
                });
    }

    public static AbstractButton createZoomButton(final DrawingView view, double[] factors) {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");

        final JPopupButton zoomPopupButton = new JPopupButton();

        labels.configureToolBarButton(zoomPopupButton, "view.zoomFactor");
        zoomPopupButton.setFocusable(false);
        zoomPopupButton.setText((int) (view.getScaleFactor() * 100) + " %");

        view.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                // String constants are interned
                if (evt.getPropertyName() == "scaleFactor") {
                    zoomPopupButton.setText((int) (view.getScaleFactor() * 100) + " %");
                }
            }
        });

        for (int i = 0; i < factors.length; i++) {
            zoomPopupButton.add(
                    new ZoomAction(view, factors[i], zoomPopupButton) {

                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent e) {
                            super.actionPerformed(e);
                            zoomPopupButton.setText((int) (view.getScaleFactor() * 100) + " %");
                        }
                    });
        }
        //zoomPopupButton.setPreferredSize(new Dimension(16,16));
        zoomPopupButton.setFocusable(false);
        return zoomPopupButton;
    }

    /**
     * Creates toolbar buttons and adds them to the specified JToolBar
     */
    public static void addAttributesButtonsTo(JToolBar bar, DrawingEditor editor) {
        JButton b;
        b = bar.add(new PickAttributesAction(editor));
        b.setFocusable(false);
        b = bar.add(new ApplyAttributesAction(editor));
        b.setFocusable(false);
        bar.addSeparator();

        addColorButtonsTo(bar, editor);
        bar.addSeparator();
        addStrokeButtonsTo(bar, editor);
        bar.addSeparator();
        addFontButtonsTo(bar, editor);
    }

    public static void addColorButtonsTo(JToolBar bar, DrawingEditor editor) {
        addColorButtonsTo(bar, editor, DEFAULT_COLORS, DEFAULT_COLORS_COLUMN_COUNT);
    }

    public static void addColorButtonsTo(JToolBar bar, DrawingEditor editor,
            java.util.List<ColorIcon> colors, int columnCount) {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");

        bar.add(createEditorColorButton(editor, STROKE_COLOR, colors, columnCount, "attribute.strokeColor", labels, new HashMap<AttributeKey, Object>()));
        bar.add(createEditorColorButton(editor, FILL_COLOR, colors, columnCount, "attribute.fillColor", labels, new HashMap<AttributeKey, Object>()));
        bar.add(createEditorColorButton(editor, TEXT_COLOR, colors, columnCount, "attribute.textColor", labels, new HashMap<AttributeKey, Object>()));
    }

    /**
     * Creates a color button, with an action region and a popup menu. The
     * button works like the color button in Microsoft Office:
     * <ul>
     * <li>When the user clicks on the action region, the default color of the
     * DrawingEditor is applied to the selected figures.</li>
     * <li>When the user opens the popup menu, a color palette is displayed.
     * Choosing a color from the palette changes the default color of the
     * editor and also changes the color of the selected figures.</li>
     * <li>A rectangle on the color button displays the current default color of
     * the DrawingEditor. The rectangle has the dimensions 1, 17, 20, 4 (x, y,
     * width, height).</li>
     * </ul>
     *
     * @param editor The DrawingEditor.
     * @param attributeKey The AttributeKey of the color.
     * @param swatches A list with labeled colors containing the color palette
     * of the popup menu. The actual labels are retrieved from the supplied
     * resource bundle. This is usually a LinkedMap, so that the colors have
     * a predictable order.
     * @param columnCount The number of columns of the color palette.
     * @param labelKey The resource bundle key used for retrieving the icon and
     * the tooltip of the button.
     * @param labels The resource bundle.
     */
    public static JPopupButton createEditorColorButton(
            DrawingEditor editor, AttributeKey<Color> attributeKey,
            java.util.List<ColorIcon> swatches, int columnCount,
            String labelKey, ResourceBundleUtil labels) {
        return createEditorColorButton(
                editor, attributeKey,
                swatches, columnCount,
                labelKey, labels,
                null);
    }

    /**
     * Creates a color button, with an action region and a popup menu. The
     * button works like the color button in Microsoft Office:
     * <ul>
     * <li>When the user clicks on the action region, the default color of the
     * DrawingEditor is applied to the selected figures.</li>
     * <li>When the user opens the popup menu, a color palette is displayed.
     * Choosing a color from the palette changes the default color of the
     * editor and also changes the color of the selected figures.</li>
     * <li>A rectangle on the color button displays the current default color of
     * the DrawingEditor. The rectangle has the dimensions 1, 17, 20, 4 (x, y,
     * width, height).</li>
     * </ul>
     *
     * @param editor The DrawingEditor.
     * @param attributeKey The AttributeKey of the color.
     * @param swatches A list with labeled colors containing the color palette
     * of the popup menu. The actual labels are retrieved from the supplied
     * resource bundle. This is usually a LinkedMap, so that the colors have
     * a predictable order.
     * @param columnCount The number of columns of the color palette.
     * @param labelKey The resource bundle key used for retrieving the icon and
     * the tooltip of the button.
     * @param labels The resource bundle.
     * @param defaultAttributes A set of attributes which are also applied to
     * the selected figures, when a color is selected. This can be used, to
     * set attributes that otherwise prevent the color from being shown. For
     * example, when the color attribute is set, we wan't the gradient attribute
     * of the Figure to be cleared.
     */
    public static JPopupButton createEditorColorButton(
            DrawingEditor editor, AttributeKey<Color> attributeKey,
            java.util.List<ColorIcon> swatches, int columnCount,
            String labelKey, ResourceBundleUtil labels,
            @Nullable Map<AttributeKey, Object> defaultAttributes) {
        return createEditorColorButton(editor, attributeKey,
                swatches, columnCount, labelKey, labels, defaultAttributes,
                new Rectangle(1, 17, 20, 4));
    }

    /**
     * Creates a color button, with an action region and a popup menu. The
     * button works like the color button in Microsoft Office:
     * <ul>
     * <li>When the user clicks on the action region, the default color of the
     * DrawingEditor is applied to the selected figures.</li>
     * <li>When the user opens the popup menu, a color palette is displayed.
     * Choosing a color from the palette changes the default color of the
     * editor and also changes the color of the selected figures.</li>
     * <li>A shape on the color button displays the current default color of the
     * DrawingEditor.</li>
     * </ul>
     *
     * @param editor The DrawingEditor.
     * @param attributeKey The AttributeKey of the color.
     * @param swatches A list with labeled colors containing the color palette
     * of the popup menu. The actual labels are retrieved from the supplied
     * resource bundle. This is usually a LinkedHashMap, so that the colors have
     * a predictable order.
     * @param columnCount The number of columns of the color palette.
     * @param labelKey The resource bundle key used for retrieving the icon and
     * the tooltip of the button.
     * @param labels The resource bundle.
     * @param defaultAttributes A set of attributes which are also applied to
     * the selected figures, when a color is selected. This can be used, to
     * set attributes that otherwise prevent the color from being shown. For
     * example, when the color attribute is set, we wan't the gradient attribute
     * of the Figure to be cleared.
     * @param colorShape This shape is superimposed on the icon of the button.
     * The shape is drawn with the default color of the DrawingEditor.
     */
    public static JPopupButton createEditorColorButton(
            DrawingEditor editor, AttributeKey<Color> attributeKey,
            java.util.List<ColorIcon> swatches, int columnCount,
            String labelKey, ResourceBundleUtil labels,
            @Nullable Map<AttributeKey, Object> defaultAttributes,
            Shape colorShape) {
        final JPopupButton popupButton = new JPopupButton();
        popupButton.setPopupAlpha(1f);
        if (defaultAttributes == null) {
            defaultAttributes = new HashMap<AttributeKey, Object>();
        }

        popupButton.setAction(
                new DefaultAttributeAction(editor, attributeKey, defaultAttributes),
                new Rectangle(0, 0, 22, 22));
        popupButton.setColumnCount(columnCount, false);
        boolean hasNullColor = false;
        for (ColorIcon swatch : swatches) {
            AttributeAction a;
            HashMap<AttributeKey, Object> attributes = new HashMap<AttributeKey, Object>(defaultAttributes);
            Color swatchColor = swatch.getColor();
            attributes.put(attributeKey, swatchColor);
            if (swatchColor == null || swatchColor.getAlpha() == 0) {
                hasNullColor = true;
            }
            popupButton.add(a =
                    new AttributeAction(
                    editor,
                    attributes,
                    labels.getToolTipTextProperty(labelKey),
                    swatch));
            a.putValue(Action.SHORT_DESCRIPTION, swatch.getName());
            a.setUpdateEnabledState(false);
        }

        // No color
        if (!hasNullColor) {
            AttributeAction a;
            HashMap<AttributeKey, Object> attributes = new HashMap<AttributeKey, Object>(defaultAttributes);
            attributes.put(attributeKey, null);
            popupButton.add(a =
                    new AttributeAction(
                    editor,
                    attributes,
                    labels.getToolTipTextProperty("attribute.color.noColor"),
                    new ColorIcon(null, labels.getToolTipTextProperty("attribute.color.noColor"), swatches.get(0).getIconWidth(), swatches.get(0).getIconHeight())));
            a.putValue(Action.SHORT_DESCRIPTION, labels.getToolTipTextProperty("attribute.color.noColor"));
            a.setUpdateEnabledState(false);
        }

        // Color chooser
        ImageIcon chooserIcon = new ImageIcon(
                Images.createImage(
                ButtonFactory.class, "/org/jhotdraw/draw/action/images/attribute.color.colorChooser.png"));
        Action a;
        popupButton.add(
                a = new EditorColorChooserAction(
                editor,
                attributeKey,
                "color",
                chooserIcon,
                defaultAttributes));
        labels.configureToolBarButton(popupButton, labelKey);
        a.putValue(Action.SHORT_DESCRIPTION, labels.getToolTipTextProperty("attribute.color.colorChooser"));
        Icon icon = new EditorColorIcon(editor,
                attributeKey,
                labels.getIconProperty(labelKey, ButtonFactory.class).getImage(),
                colorShape);
        popupButton.setIcon(icon);
        popupButton.setDisabledIcon(icon);
        popupButton.setFocusable(false);

        editor.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                popupButton.repaint();
            }
        });

        return popupButton;
    }

    /**
     * Creates a color button, with an action region and a popup menu. The
     * button works like the color button in Adobe Fireworks:
     * <ul>
     * <li>When the user clicks at the button a popup menu with a color palette
     * is displayed.
     * Choosing a color from the palette changes the default color of the
     * editor and also changes the color of the selected figures.</li>
     * <li>A shape on the color button displays the color of the selected
     * figures. If no figures are selected, the default color of the
     * DrawingEditor is displayed.</li>
     * <li>A rectangle on the color button displays the current default color of
     * the DrawingEditor. The rectangle has the dimensions 1, 17, 20, 4 (x, y,
     * width, height).</li>
     * </ul>
     *
     * @param editor The DrawingEditor.
     * @param attributeKey The AttributeKey of the color.
     * @param swatches A list with labeled colors containing the color palette
     * of the popup menu. The actual labels are retrieved from the supplied
     * resource bundle. This is usually a LinkedHashMap, so that the colors have
     * a predictable order.
     * @param columnCount The number of columns of the color palette.
     * @param labelKey The resource bundle key used for retrieving the icon and
     * the tooltip of the button.
     * @param labels The resource bundle.
     */
    public static JPopupButton createSelectionColorButton(
            DrawingEditor editor, AttributeKey<Color> attributeKey,
            java.util.List<ColorIcon> swatches, int columnCount,
            String labelKey, ResourceBundleUtil labels) {
        return createSelectionColorButton(
                editor, attributeKey,
                swatches, columnCount,
                labelKey, labels,
                null);
    }

    /**
     * Creates a color button, with an action region and a popup menu. The
     * button works like the color button in Adobe Fireworks:
     * <ul>
     * <li>When the user clicks at the button a popup menu with a color palette
     * is displayed.
     * Choosing a color from the palette changes the default color of the
     * editor and also changes the color of the selected figures.</li>
     * <li>A rectangle on the color button displays the current default color of
     * the DrawingEditor. The rectangle has the dimensions 1, 17, 20, 4 (x, y,
     * width, height).</li>
     * </ul>
     *
     * @param editor The DrawingEditor.
     * @param attributeKey The AttributeKey of the color.
     * @param swatches A list with labeled colors containing the color palette
     * of the popup menu. The actual labels are retrieved from the supplied
     * resource bundle. This is usually a LinkedHashMap, so that the colors have
     * a predictable order.
     * @param columnCount The number of columns of the color palette.
     * @param labelKey The resource bundle key used for retrieving the icon and
     * the tooltip of the button.
     * @param labels The resource bundle.
     * @param defaultAttributes A set of attributes which are also applied to
     * the selected figures, when a color is selected. This can be used, to
     * set attributes that otherwise prevent the color from being shown. For
     * example, when the color attribute is set, we wan't the gradient attribute
     * of the Figure to be cleared.
     */
    public static JPopupButton createSelectionColorButton(
            DrawingEditor editor, AttributeKey<Color> attributeKey,
            java.util.List<ColorIcon> swatches, int columnCount,
            String labelKey, ResourceBundleUtil labels,
            @Nullable Map<AttributeKey, Object> defaultAttributes) {
        return createSelectionColorButton(editor, attributeKey,
                swatches, columnCount, labelKey, labels, defaultAttributes,
                new Rectangle(1, 17, 20, 4));
    }

    /**
     * Creates a color button, with an action region and a popup menu. The
     * button works like the color button in Adobe Fireworks:
     * <ul>
     * <li>When the user clicks at the button a popup menu with a color palette
     * is displayed.
     * Choosing a color from the palette changes the default color of the
     * editor and also changes the color of the selected figures.</li>
     * <li>A shape on the color button displays the color of the selected
     * figures. If no figures are selected, the default color of the
     * DrawingEditor is displayed.</li>
     * </ul>
     *
     * @param editor The DrawingEditor.
     * @param attributeKey The AttributeKey of the color.
     * @param swatches A list with labeled colors containing the color palette
     * of the popup menu. The actual labels are retrieved from the supplied
     * resource bundle. This is usually a LinkedHashMap, so that the colors have
     * a predictable order.
     * @param columnCount The number of columns of the color palette.
     * @param labelKey The resource bundle key used for retrieving the icon and
     * the tooltip of the button.
     * @param labels The resource bundle.
     * @param defaultAttributes A set of attributes which are also applied to
     * the selected figures, when a color is selected. This can be used, to
     * set attributes that otherwise prevent the color from being shown. For
     * example, when the color attribute is set, we wan't the gradient attribute
     * of the Figure to be cleared.
     * @param colorShape This shape is superimposed on the icon of the button.
     * The shape is drawn with the default color of the DrawingEditor.
     */
    public static JPopupButton createSelectionColorButton(
            DrawingEditor editor, AttributeKey<Color> attributeKey,
            java.util.List<ColorIcon> swatches, int columnCount,
            String labelKey, ResourceBundleUtil labels,
            @Nullable Map<AttributeKey, Object> defaultAttributes,
            Shape colorShape) {
        return createSelectionColorButton(editor, attributeKey,
                swatches, columnCount, labelKey, labels, defaultAttributes,
                colorShape, new LinkedList<Disposable>());
    }

    /**
     * Creates a color button, with an action region and a popup menu. The
     * button works like the color button in Adobe Fireworks:
     * <ul>
     * <li>When the user clicks at the button a popup menu with a color palette
     * is displayed.
     * Choosing a color from the palette changes the default color of the
     * editor and also changes the color of the selected figures.</li>
     * <li>A shape on the color button displays the color of the selected
     * figures. If no figures are selected, the default color of the
     * DrawingEditor is displayed.</li>
     * </ul>
     *
     * @param editor The DrawingEditor.
     * @param attributeKey The AttributeKey of the color.
     * @param swatches A list with labeled colors containing the color palette
     * of the popup menu. The actual labels are retrieved from the supplied
     * resource bundle. This is usually a LinkedHashMap, so that the colors have
     * a predictable order.
     * @param columnCount The number of columns of the color palette.
     * @param labelKey The resource bundle key used for retrieving the icon and
     * the tooltip of the button.
     * @param labels The resource bundle.
     * @param defaultAttributes A set of attributes which are also applied to
     * the selected figures, when a color is selected. This can be used, to
     * set attributes that otherwise prevent the color from being shown. For
     * example, when the color attribute is set, we wan't the gradient attribute
     * of the Figure to be cleared.
     * @param colorShape This shape is superimposed on the icon of the button.
     * The shape is drawn with the default color of the DrawingEditor.
     */
    public static JPopupButton createSelectionColorButton(
            DrawingEditor editor, AttributeKey<Color> attributeKey,
            java.util.List<ColorIcon> swatches, int columnCount,
            String labelKey, ResourceBundleUtil labels,
            @Nullable Map<AttributeKey, Object> defaultAttributes,
            Shape colorShape, java.util.List<Disposable> dsp) {
        final JPopupButton popupButton = new JPopupButton();
        popupButton.setPopupAlpha(1f);
        if (defaultAttributes == null) {
            defaultAttributes = new HashMap<AttributeKey, Object>();
        }

        popupButton.setColumnCount(columnCount, false);
        boolean hasNullColor = false;
        for (ColorIcon swatch : swatches) {
            AttributeAction a;
            HashMap<AttributeKey, Object> attributes = new HashMap<AttributeKey, Object>(defaultAttributes);
            if (swatch != null) {
                Color swatchColor = swatch.getColor();
                attributes.put(attributeKey, swatchColor);
                if (swatchColor == null || swatchColor.getAlpha() == 0) {
                    hasNullColor = true;
                }
                popupButton.add(a =
                        new AttributeAction(
                        editor,
                        attributes,
                        labels.getToolTipTextProperty(labelKey),
                        swatch));
                a.putValue(Action.SHORT_DESCRIPTION, swatch.getName());
                a.setUpdateEnabledState(false);
                dsp.add(a);
            } else {
                popupButton.add(new JPanel());
            }

        }

        // No color
        if (!hasNullColor) {
            AttributeAction a;
            HashMap<AttributeKey, Object> attributes = new HashMap<AttributeKey, Object>(defaultAttributes);
            attributes.put(attributeKey, null);
            popupButton.add(a =
                    new AttributeAction(
                    editor,
                    attributes,
                    labels.getToolTipTextProperty("attribute.color.noColor"),
                    new ColorIcon(null, labels.getToolTipTextProperty("attribute.color.noColor"))));
            a.putValue(Action.SHORT_DESCRIPTION, labels.getToolTipTextProperty("attribute.color.noColor"));
            a.setUpdateEnabledState(false);
            dsp.add(a);
        }
        // Color chooser
        ImageIcon chooserIcon = new ImageIcon(
                Images.createImage(ButtonFactory.class, "/org/jhotdraw/draw/action/images/attribute.color.colorChooser.png"));
        AttributeAction a;
        popupButton.add(
                a = new SelectionColorChooserAction(
                editor,
                attributeKey,
                labels.getToolTipTextProperty("attribute.color.colorChooser"),
                chooserIcon,
                defaultAttributes));
        a.putValue(Action.SHORT_DESCRIPTION, labels.getToolTipTextProperty("attribute.color.colorChooser"));
        dsp.add(a);
        labels.configureToolBarButton(popupButton, labelKey);
        Icon icon = new SelectionColorIcon(editor,
                attributeKey,
                labels.getIconProperty(labelKey, ButtonFactory.class).getImage(),
                colorShape);
        popupButton.setIcon(icon);
        popupButton.setDisabledIcon(icon);
        popupButton.setFocusable(false);

        dsp.add(new SelectionComponentRepainter(editor, popupButton));
        return popupButton;
    }

    public static JPopupButton createSelectionColorChooserButton(final DrawingEditor editor,
            final AttributeKey<Color> attributeKey, String labelKey,
            ResourceBundleUtil labels,
            @Nullable Map<AttributeKey, Object> defaultAttributes,
            Shape colorShape, final java.util.List<Disposable> dsp) {
        return createSelectionColorChooserButton(
                editor, attributeKey, labelKey, labels, defaultAttributes, colorShape, null, dsp);
    }

    public static JPopupButton createSelectionColorChooserButton(final DrawingEditor editor,
            final AttributeKey<Color> attributeKey, String labelKey,
            ResourceBundleUtil labels,
            @Nullable Map<AttributeKey, Object> defaultAttributes,
            Shape colorShape, @Nullable final Class uiclass, @Nullable final java.util.List<Disposable> dsp) {

        JPopupButton popupButton;

        popupButton = new JPopupButton();
        labels.configureToolBarButton(popupButton, labelKey);
        popupButton.setFocusable(true);
        popupButton.setRequestFocusEnabled(false);

        // We lazily initialize the popup menu because creating a JColorChooser
        // takes a lot of time.
        JComponentPopup popupMenu = new JComponentPopup() {

            private JColorChooser colorChooser;

            @Override
            public void show(Component invoker, int x, int y) {
                if (colorChooser == null) {
                    initialize();
                }
                Color c;
                if (editor.getActiveView() != null && editor.getActiveView().getSelectionCount() > 0) {
                    c = editor.getActiveView().getSelectedFigures().iterator().next().get(attributeKey);
                } else {
                    c = editor.getDefaultAttribute(attributeKey);
                }
                colorChooser.setColor(c == null ? new Color(0, true) : c);
                super.show(invoker, x, y);
            }

            private void initialize() {
                colorChooser = new JColorChooser();
                colorChooser.setOpaque(true);
                colorChooser.setBackground(Color.WHITE);
                if (uiclass != null) {
                    try {
                        colorChooser.setUI((ColorChooserUI) Methods.invokeStatic(uiclass, "createUI", new Class[]{JComponent.class}, new Object[]{colorChooser}));
                    } catch (NoSuchMethodException ex) {
                        ex.printStackTrace();
                    }
                }
                dsp.add(new SelectionColorChooserHandler(editor, attributeKey, colorChooser, this));
                add(colorChooser);
            }
        };


        popupButton.setPopupMenu(popupMenu);
        popupButton.setPopupAlpha(1.0f);// must be set after we set the popup menu
        Icon icon = new SelectionColorIcon(editor,
                attributeKey,
                labels.getIconProperty(labelKey, ButtonFactory.class).getImage(),
                colorShape);
        popupButton.setIcon(icon);
        popupButton.setDisabledIcon(icon);
        popupButton.setFocusable(false);

        if (dsp != null) {
            dsp.add(new SelectionComponentRepainter(editor, popupButton));
        }
        return popupButton;
    }

    /**
     * Creates a color button, with an action region and a popup menu. The
     * button acts on attributes of the Drawing object in the current DrawingView
     * of the DrawingEditor.
     *
     * @param editor The DrawingEditor.
     * @param attributeKey The AttributeKey of the color.
     * @param swatches A list with labeled colors containing the color palette
     * of the popup menu. The actual labels are retrieved from the supplied
     * resource bundle. This is usually a LinkedHashMap, so that the colors have
     * a predictable order.
     * @param columnCount The number of columns of the color palette.
     * @param labelKey The resource bundle key used for retrieving the icon and
     * the tooltip of the button.
     * @param labels The resource bundle.
     */
    public static JPopupButton createDrawingColorButton(
            DrawingEditor editor, AttributeKey<Color> attributeKey,
            java.util.List<ColorIcon> swatches, int columnCount,
            String labelKey, ResourceBundleUtil labels) {
        return createDrawingColorButton(
                editor, attributeKey,
                swatches, columnCount,
                labelKey, labels,
                null);
    }

    /**
     * Creates a color button, with an action region and a popup menu. The
     * button acts on attributes of the Drawing object in the current DrawingView
     * of the DrawingEditor.
     *
     * @param editor The DrawingEditor.
     * @param attributeKey The AttributeKey of the color.
     * @param swatches A list with labeled colors containing the color palette
     * of the popup menu. The actual labels are retrieved from the supplied
     * resource bundle. This is usually a LinkedHashMap, so that the colors have
     * a predictable order.
     * @param columnCount The number of columns of the color palette.
     * @param labelKey The resource bundle key used for retrieving the icon and
     * the tooltip of the button.
     * @param labels The resource bundle.
     * @param defaultAttributes A set of attributes which are also applied to
     * the selected figures, when a color is selected. This can be used, to
     * set attributes that otherwise prevent the color from being shown. For
     * example, when the color attribute is set, we wan't the gradient attribute
     * of the Figure to be cleared.
     */
    public static JPopupButton createDrawingColorButton(
            DrawingEditor editor, AttributeKey<Color> attributeKey,
            java.util.List<ColorIcon> swatches, int columnCount,
            String labelKey, ResourceBundleUtil labels,
            @Nullable Map<AttributeKey, Object> defaultAttributes) {
        return createDrawingColorButton(editor, attributeKey,
                swatches, columnCount, labelKey, labels, defaultAttributes,
                new Rectangle(1, 17, 20, 4));
    }

    /**
     * Creates a color button, with an action region and a popup menu. The
     * button acts on attributes of the Drawing object in the current DrawingView
     * of the DrawingEditor.
     *
     * @param editor The DrawingEditor.
     * @param attributeKey The AttributeKey of the color.
     * @param swatches A list with labeled colors containing the color palette
     * of the popup menu. The actual labels are retrieved from the supplied
     * resource bundle. This is usually a LinkedHashMap, so that the colors have
     * a predictable order.
     * @param columnCount The number of columns of the color palette.
     * @param labelKey The resource bundle key used for retrieving the icon and
     * the tooltip of the button.
     * @param labels The resource bundle.
     * @param defaultAttributes A set of attributes which are also applied to
     * the selected figures, when a color is selected. This can be used, to
     * set attributes that otherwise prevent the color from being shown. For
     * example, when the color attribute is set, we wan't the gradient attribute
     * of the Figure to be cleared.
     * @param colorShape This shape is superimposed on the icon of the button.
     * The shape is drawn with the default color of the DrawingEditor.
     */
    public static JPopupButton createDrawingColorButton(
            DrawingEditor editor, AttributeKey<Color> attributeKey,
            java.util.List<ColorIcon> swatches, int columnCount,
            String labelKey, ResourceBundleUtil labels,
            @Nullable Map<AttributeKey, Object> defaultAttributes,
            Shape colorShape) {
        return createDrawingColorButton(editor, attributeKey,
                swatches, columnCount, labelKey, labels, defaultAttributes,
                colorShape, new LinkedList<Disposable>());
    }

    /**
     * Creates a color button, with an action region and a popup menu. The
     * button acts on attributes of the Drawing object in the current DrawingView
     * of the DrawingEditor.
     *
     * @param editor The DrawingEditor.
     * @param attributeKey The AttributeKey of the color.
     * @param swatches A list with labeled colors containing the color palette
     * of the popup menu. The actual labels are retrieved from the supplied
     * resource bundle. This is usually a LinkedHashMap, so that the colors have
     * a predictable order.
     * @param columnCount The number of columns of the color palette.
     * @param labelKey The resource bundle key used for retrieving the icon and
     * the tooltip of the button.
     * @param labels The resource bundle.
     * @param defaultAttributes A set of attributes which are also applied to
     * the selected figures, when a color is selected. This can be used, to
     * set attributes that otherwise prevent the color from being shown. For
     * example, when the color attribute is set, we wan't the gradient attribute
     * of the Figure to be cleared.
     * @param colorShape This shape is superimposed on the icon of the button.
     * The shape is drawn with the default color of the DrawingEditor.
     */
    public static JPopupButton createDrawingColorButton(
            DrawingEditor editor, AttributeKey<Color> attributeKey,
            java.util.List<ColorIcon> swatches, int columnCount,
            String labelKey, ResourceBundleUtil labels,
            @Nullable Map<AttributeKey, Object> defaultAttributes,
            Shape colorShape, java.util.List<Disposable> dsp) {
        final JPopupButton popupButton = new JPopupButton();
        popupButton.setPopupAlpha(1f);
        if (defaultAttributes == null) {
            defaultAttributes = new HashMap<AttributeKey, Object>();
        }

        popupButton.setColumnCount(columnCount, false);
        boolean hasNullColor = false;
        for (ColorIcon swatch : swatches) {
            DrawingAttributeAction a;
            HashMap<AttributeKey, Object> attributes = new HashMap<AttributeKey, Object>(defaultAttributes);
            if (swatch != null) {
                Color swatchColor = swatch.getColor();
                attributes.put(attributeKey, swatchColor);
                if (swatchColor == null || swatchColor.getAlpha() == 0) {
                    hasNullColor = true;
                }
                popupButton.add(a =
                        new DrawingAttributeAction(
                        editor,
                        attributes,
                        labels.getToolTipTextProperty(labelKey),
                        swatch));
                dsp.add(a);
                a.putValue(Action.SHORT_DESCRIPTION, swatch.getName());
                a.setUpdateEnabledState(false);
            } else {
                popupButton.add(new JPanel());
            }
        }

        // No color
        if (!hasNullColor) {
            DrawingAttributeAction a;
            HashMap<AttributeKey, Object> attributes = new HashMap<AttributeKey, Object>(defaultAttributes);
            attributes.put(attributeKey, null);
            popupButton.add(a =
                    new DrawingAttributeAction(
                    editor,
                    attributes,
                    labels.getToolTipTextProperty("attribute.color.noColor"),
                    new ColorIcon(null, labels.getToolTipTextProperty("attribute.color.noColor"))));
            dsp.add(a);
            a.putValue(Action.SHORT_DESCRIPTION, labels.getToolTipTextProperty("attribute.color.noColor"));
            a.setUpdateEnabledState(false);
        }

        // Color chooser
        ImageIcon chooserIcon = new ImageIcon(
                Images.createImage(ButtonFactory.class, "/org/jhotdraw/draw/action/images/attribute.color.colorChooser.png"));
        DrawingColorChooserAction a;
        popupButton.add(
                a = new DrawingColorChooserAction(
                editor,
                attributeKey,
                "color",
                chooserIcon,
                defaultAttributes));
        dsp.add(a);
        labels.configureToolBarButton(popupButton, labelKey);
        a.putValue(Action.SHORT_DESCRIPTION, labels.getToolTipTextProperty("attribute.color.colorChooser"));
        Icon icon = new DrawingColorIcon(editor,
                attributeKey,
                labels.getIconProperty(labelKey, ButtonFactory.class).getImage(),
                colorShape);
        popupButton.setIcon(icon);
        popupButton.setDisabledIcon(icon);
        popupButton.setFocusable(false);

        if (editor != null) {
            dsp.add(new SelectionComponentRepainter(editor, popupButton));
        }

        return popupButton;
    }

    public static JPopupButton createDrawingColorChooserButton(final DrawingEditor editor,
            final AttributeKey<Color> attributeKey, String labelKey,
            ResourceBundleUtil labels, @Nullable Map<AttributeKey, Object> defaultAttributes,
            Shape colorShape, @Nullable final java.util.List<Disposable> dsp) {
        return createSelectionColorChooserButton(
                editor, attributeKey, labelKey, labels, defaultAttributes, colorShape, null, dsp);
    }

    public static JPopupButton createDrawingColorChooserButton(final DrawingEditor editor,
            final AttributeKey<Color> attributeKey, String labelKey,
            ResourceBundleUtil labels, @Nullable Map<AttributeKey, Object> defaultAttributes,
            Shape colorShape, @Nullable final Class uiclass, @Nullable final java.util.List<Disposable> dsp) {

        JPopupButton popupButton;

        popupButton = new JPopupButton();
        labels.configureToolBarButton(popupButton, labelKey);
        popupButton.setFocusable(true);
        popupButton.setRequestFocusEnabled(false);

        // We lazily initialize the popup menu because creating a JColorChooser
        // takes a lot of time.
        JComponentPopup popupMenu = new JComponentPopup() {

            private JColorChooser colorChooser;

            @Override
            public void show(Component invoker, int x, int y) {
                if (colorChooser == null) {
                    initialize();
                }
                Color c;
                if (editor.getActiveView() != null) {
                    c = editor.getActiveView().getDrawing().get(attributeKey);
                } else {
                    c = editor.getDefaultAttribute(attributeKey);
                }
                colorChooser.setColor(c == null ? new Color(0, true) : c);
                super.show(invoker, x, y);
            }

            private void initialize() {
                colorChooser = new JColorChooser();
                colorChooser.setOpaque(true);
                colorChooser.setBackground(Color.WHITE);
                if (uiclass != null) {
                    try {
                        colorChooser.setUI((ColorChooserUI) Methods.invokeStatic(uiclass, "createUI", new Class[]{JComponent.class}, new Object[]{colorChooser}));
                    } catch (NoSuchMethodException ex) {
                        ex.printStackTrace();
                    }
                }
                dsp.add(new DrawingColorChooserHandler(editor, attributeKey, colorChooser, this));
                add(colorChooser);
            }
        };


        popupButton.setPopupMenu(popupMenu);
        popupButton.setPopupAlpha(1.0f);// must be set after we set the popup menu
        Icon icon = new DrawingColorIcon(editor,
                attributeKey,
                labels.getIconProperty(labelKey, ButtonFactory.class).getImage(),
                colorShape);
        popupButton.setIcon(icon);
        popupButton.setDisabledIcon(icon);
        popupButton.setFocusable(false);

        if (dsp != null) {
            dsp.add(new SelectionComponentRepainter(editor, popupButton));
        }
        return popupButton;
    }

    public static void addStrokeButtonsTo(JToolBar bar, DrawingEditor editor) {
        bar.add(createStrokeDecorationButton(editor));
        bar.add(createStrokeWidthButton(editor));
        bar.add(createStrokeDashesButton(editor));
        bar.add(createStrokeTypeButton(editor));
        bar.add(createStrokePlacementButton(editor));
        bar.add(createStrokeCapButton(editor));
        bar.add(createStrokeJoinButton(editor));
    }

    public static JPopupButton createStrokeWidthButton(DrawingEditor editor) {
        return createStrokeWidthButton(
                editor,
                new double[]{0.5d, 1d, 2d, 3d, 5d, 9d, 13d},
                ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels"));
    }

    public static JPopupButton createStrokeWidthButton(DrawingEditor editor,
            ResourceBundleUtil labels) {
        return createStrokeWidthButton(
                editor,
                new double[]{0.5d, 1d, 2d, 3d, 5d, 9d, 13d},
                labels);
    }

    public static JPopupButton createStrokeWidthButton(DrawingEditor editor,
            double[] widths) {
        return createStrokeWidthButton(
                editor, new double[]{0.5d, 1d, 2d, 3d, 5d, 9d, 13d},
                ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels"));
    }

    public static JPopupButton createStrokeWidthButton(
            DrawingEditor editor, double[] widths, ResourceBundleUtil labels) {
        JPopupButton strokeWidthPopupButton = new JPopupButton();

        labels.configureToolBarButton(strokeWidthPopupButton, "attribute.strokeWidth");
        strokeWidthPopupButton.setFocusable(false);

        NumberFormat formatter = NumberFormat.getInstance();
        if (formatter instanceof DecimalFormat) {
            ((DecimalFormat) formatter).setMaximumFractionDigits(1);
            ((DecimalFormat) formatter).setMinimumFractionDigits(0);
        }
        for (int i = 0; i < widths.length; i++) {
            String label = Double.toString(widths[i]);
            Icon icon = new StrokeIcon(new BasicStroke((float) widths[i], BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
            AttributeAction a = new AttributeAction(
                    editor,
                    STROKE_WIDTH,
                    new Double(widths[i]),
                    label,
                    icon);
            a.putValue(ActionUtil.UNDO_PRESENTATION_NAME_KEY, labels.getString("attribute.strokeWidth.text"));
            AbstractButton btn = strokeWidthPopupButton.add(a);
            btn.setDisabledIcon(icon);
        }
        return strokeWidthPopupButton;
    }

    public static JPopupButton createStrokeDecorationButton(DrawingEditor editor) {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");

        JPopupButton strokeDecorationPopupButton = new JPopupButton();
        labels.configureToolBarButton(strokeDecorationPopupButton, "attribute.strokeDecoration");
        strokeDecorationPopupButton.setFocusable(false);
        strokeDecorationPopupButton.setColumnCount(2, false);
        LineDecoration[] decorations = {
            // Arrow
            new ArrowTip(0.35, 12, 11.3),
            // Arrow
            new ArrowTip(0.35, 13, 7),
            // Generalization triangle
            new ArrowTip(Math.PI / 5, 12, 9.8, true, true, false),
            // Dependency arrow
            new ArrowTip(Math.PI / 6, 12, 0, false, true, false),
            // Link arrow
            new ArrowTip(Math.PI / 11, 13, 0, false, true, true),
            // Aggregation diamond
            new ArrowTip(Math.PI / 6, 10, 18, false, true, false),
            // Composition diamond
            new ArrowTip(Math.PI / 6, 10, 18, true, true, true),
            null
        };
        for (int i = 0; i < decorations.length; i++) {
            strokeDecorationPopupButton.add(
                    new AttributeAction(
                    editor,
                    START_DECORATION,
                    decorations[i],
                    null,
                    new LineDecorationIcon(decorations[i], true)));
            strokeDecorationPopupButton.add(
                    new AttributeAction(
                    editor,
                    END_DECORATION,
                    decorations[i],
                    null,
                    new LineDecorationIcon(decorations[i], false)));
        }

        return strokeDecorationPopupButton;
    }

    public static JPopupButton createStrokeDashesButton(DrawingEditor editor) {
        return createStrokeDashesButton(editor,
                ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels"));
    }

    public static JPopupButton createStrokeDashesButton(DrawingEditor editor,
            ResourceBundleUtil labels) {
        return createStrokeDashesButton(editor, new double[][]{
                    null,
                    {4d, 4d},
                    {2d, 2d},
                    {4d, 2d},
                    {2d, 4d},
                    {8d, 2d},
                    {6d, 2d, 2d, 2d},},
                labels);
    }

    public static JPopupButton createStrokeDashesButton(DrawingEditor editor,
            double[][] dashes) {
        return createStrokeDashesButton(editor, dashes,
                ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels"));
    }

    public static JPopupButton createStrokeDashesButton(DrawingEditor editor,
            double[][] dashes,
            ResourceBundleUtil labels) {
        return createStrokeDashesButton(editor, dashes,
                labels, new LinkedList<Disposable>());
    }

    public static JPopupButton createStrokeDashesButton(DrawingEditor editor, double[][] dashes,
            ResourceBundleUtil labels, java.util.List<Disposable> dsp) {
        JPopupButton strokeDashesPopupButton = new JPopupButton();
        labels.configureToolBarButton(strokeDashesPopupButton, "attribute.strokeDashes");
        strokeDashesPopupButton.setFocusable(false);
        //strokeDashesPopupButton.setColumnCount(2, false);
        for (int i = 0; i < dashes.length; i++) {

            float[] fdashes;
            if (dashes[i] == null) {
                fdashes = null;
            } else {
                fdashes = new float[dashes[i].length];
                for (int j = 0; j < dashes[i].length; j++) {
                    fdashes[j] = (float) dashes[i][j];
                }
            }

            Icon icon = new StrokeIcon(
                    new BasicStroke(2f, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_BEVEL, 10f, fdashes, 0));

            AttributeAction a;
            AbstractButton btn = strokeDashesPopupButton.add(
                    a = new AttributeAction(
                    editor,
                    STROKE_DASHES,
                    dashes[i],
                    null,
                    icon));
            dsp.add(a);
            btn.setDisabledIcon(icon);
        }
        return strokeDashesPopupButton;
    }

    public static JPopupButton createStrokeTypeButton(DrawingEditor editor) {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");

        JPopupButton strokeTypePopupButton = new JPopupButton();
        labels.configureToolBarButton(strokeTypePopupButton, "attribute.strokeType");
        strokeTypePopupButton.setFocusable(false);

        strokeTypePopupButton.add(
                new AttributeAction(
                editor,
                STROKE_TYPE,
                AttributeKeys.StrokeType.BASIC,
                labels.getString("attribute.strokeType.basic"),
                new StrokeIcon(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL))));
        HashMap<AttributeKey, Object> attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_TYPE, AttributeKeys.StrokeType.DOUBLE);
        attr.put(STROKE_INNER_WIDTH_FACTOR, 2d);
        strokeTypePopupButton.add(
                new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokeType.double"),
                new StrokeIcon(new DoubleStroke(2, 1))));
        attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_TYPE, AttributeKeys.StrokeType.DOUBLE);
        attr.put(STROKE_INNER_WIDTH_FACTOR, 3d);
        strokeTypePopupButton.add(
                new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokeType.double"),
                new StrokeIcon(new DoubleStroke(3, 1))));
        attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_TYPE, AttributeKeys.StrokeType.DOUBLE);
        attr.put(STROKE_INNER_WIDTH_FACTOR, 4d);
        strokeTypePopupButton.add(
                new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokeType.double"),
                new StrokeIcon(new DoubleStroke(4, 1))));


        return strokeTypePopupButton;
    }

    public static JPopupButton createStrokePlacementButton(DrawingEditor editor) {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");

        JPopupButton strokePlacementPopupButton = new JPopupButton();
        labels.configureToolBarButton(strokePlacementPopupButton, "attribute.strokePlacement");
        strokePlacementPopupButton.setFocusable(false);

        HashMap<AttributeKey, Object> attr;
        attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_PLACEMENT, AttributeKeys.StrokePlacement.CENTER);
        attr.put(FILL_UNDER_STROKE, AttributeKeys.Underfill.CENTER);
        strokePlacementPopupButton.add(
                new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokePlacement.center"),
                null));
        attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_PLACEMENT, AttributeKeys.StrokePlacement.INSIDE);
        attr.put(FILL_UNDER_STROKE, AttributeKeys.Underfill.CENTER);
        strokePlacementPopupButton.add(
                new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokePlacement.inside"),
                null));
        attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_PLACEMENT, AttributeKeys.StrokePlacement.OUTSIDE);
        attr.put(FILL_UNDER_STROKE, AttributeKeys.Underfill.CENTER);
        strokePlacementPopupButton.add(
                new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokePlacement.outside"),
                null));
        attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_PLACEMENT, AttributeKeys.StrokePlacement.CENTER);
        attr.put(FILL_UNDER_STROKE, AttributeKeys.Underfill.FULL);
        strokePlacementPopupButton.add(
                new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokePlacement.centerFilled"),
                null));
        attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_PLACEMENT, AttributeKeys.StrokePlacement.INSIDE);
        attr.put(FILL_UNDER_STROKE, AttributeKeys.Underfill.FULL);
        strokePlacementPopupButton.add(
                new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokePlacement.insideFilled"),
                null));
        attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_PLACEMENT, AttributeKeys.StrokePlacement.OUTSIDE);
        attr.put(FILL_UNDER_STROKE, AttributeKeys.Underfill.FULL);
        strokePlacementPopupButton.add(
                new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokePlacement.outsideFilled"),
                null));
        attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_PLACEMENT, AttributeKeys.StrokePlacement.CENTER);
        attr.put(FILL_UNDER_STROKE, AttributeKeys.Underfill.NONE);
        strokePlacementPopupButton.add(
                new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokePlacement.centerUnfilled"),
                null));
        attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_PLACEMENT, AttributeKeys.StrokePlacement.INSIDE);
        attr.put(FILL_UNDER_STROKE, AttributeKeys.Underfill.NONE);
        strokePlacementPopupButton.add(
                new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokePlacement.insideUnfilled"),
                null));
        attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_PLACEMENT, AttributeKeys.StrokePlacement.OUTSIDE);
        attr.put(FILL_UNDER_STROKE, AttributeKeys.Underfill.NONE);
        strokePlacementPopupButton.add(
                new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokePlacement.outsideUnfilled"),
                null));

        return strokePlacementPopupButton;
    }

    public static void addFontButtonsTo(JToolBar bar, DrawingEditor editor) {
        bar.add(createFontButton(editor));
        bar.add(createFontStyleBoldButton(editor));
        bar.add(createFontStyleItalicButton(editor));
        bar.add(createFontStyleUnderlineButton(editor));
    }

    public static JPopupButton createFontButton(DrawingEditor editor) {
        return createFontButton(editor,
                ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels"));
    }

    public static JPopupButton createFontButton(DrawingEditor editor,
            ResourceBundleUtil labels) {
        return createFontButton(editor, FONT_FACE, labels);

    }

    public static JPopupButton createFontButton(DrawingEditor editor,
            AttributeKey<Font> key,
            ResourceBundleUtil labels) {
        return createFontButton(editor, key, labels, new LinkedList<Disposable>());
    }

    public static JPopupButton createFontButton(DrawingEditor editor,
            AttributeKey<Font> key,
            ResourceBundleUtil labels, java.util.List<Disposable> dsp) {

        JPopupButton fontPopupButton;

        fontPopupButton = new JPopupButton();

        labels.configureToolBarButton(fontPopupButton, "attribute.font");
        fontPopupButton.setFocusable(false);

        JComponentPopup popupMenu = new JComponentPopup();
        JFontChooser fontChooser = new JFontChooser();
        dsp.add(new FontChooserHandler(editor, key, fontChooser, popupMenu));

        popupMenu.add(fontChooser);
        fontPopupButton.setPopupMenu(popupMenu);
        fontPopupButton.setFocusable(false);

        return fontPopupButton;
    }

    public static JButton createFontStyleBoldButton(DrawingEditor editor) {
        return createFontStyleBoldButton(editor,
                ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels"));
    }

    public static JButton createFontStyleBoldButton(DrawingEditor editor,
            ResourceBundleUtil labels) {
        return createFontStyleBoldButton(editor,
                labels, new LinkedList<Disposable>());
    }

    public static JButton createFontStyleBoldButton(DrawingEditor editor,
            ResourceBundleUtil labels, java.util.List<Disposable> dsp) {
        JButton btn;
        btn = new JButton();
        labels.configureToolBarButton(btn, "attribute.fontStyle.bold");
        btn.setFocusable(false);

        AbstractAction a = new AttributeToggler<Boolean>(editor,
                FONT_BOLD, Boolean.TRUE, Boolean.FALSE,
                new StyledEditorKit.BoldAction());
        a.putValue(ActionUtil.UNDO_PRESENTATION_NAME_KEY, labels.getString("attribute.fontStyle.bold.text"));
        btn.addActionListener(a);
        return btn;
    }

    public static JButton createFontStyleItalicButton(DrawingEditor editor) {
        return createFontStyleItalicButton(editor,
                ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels"));
    }

    public static JButton createFontStyleItalicButton(DrawingEditor editor,
            ResourceBundleUtil labels) {
        return createFontStyleItalicButton(editor,
                labels, new LinkedList<Disposable>());
    }

    public static JButton createFontStyleItalicButton(DrawingEditor editor,
            ResourceBundleUtil labels, java.util.List<Disposable> dsp) {
        JButton btn;
        btn = new JButton();
        labels.configureToolBarButton(btn, "attribute.fontStyle.italic");
        btn.setFocusable(false);

        AbstractAction a = new AttributeToggler<Boolean>(editor,
                FONT_ITALIC, Boolean.TRUE, Boolean.FALSE,
                new StyledEditorKit.BoldAction());
        a.putValue(ActionUtil.UNDO_PRESENTATION_NAME_KEY, labels.getString("attribute.fontStyle.italic.text"));
        btn.addActionListener(a);
        return btn;
    }

    public static JButton createFontStyleUnderlineButton(DrawingEditor editor) {
        return createFontStyleUnderlineButton(editor,
                ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels"));
    }

    public static JButton createFontStyleUnderlineButton(DrawingEditor editor,
            ResourceBundleUtil labels) {
        return createFontStyleUnderlineButton(editor,
                labels, new LinkedList<Disposable>());
    }

    public static JButton createFontStyleUnderlineButton(DrawingEditor editor,
            ResourceBundleUtil labels, java.util.List<Disposable> dsp) {
        JButton btn;
        btn = new JButton();
        labels.configureToolBarButton(btn, "attribute.fontStyle.underline");
        btn.setFocusable(false);

        AbstractAction a = new AttributeToggler<Boolean>(editor,
                FONT_UNDERLINE, Boolean.TRUE, Boolean.FALSE,
                new StyledEditorKit.BoldAction());
        a.putValue(ActionUtil.UNDO_PRESENTATION_NAME_KEY, labels.getString("attribute.fontStyle.underline.text"));
        btn.addActionListener(a);
        return btn;
    }

    /**
     * Creates toolbar buttons and adds them to the specified JToolBar
     */
    public static void addAlignmentButtonsTo(JToolBar bar, final DrawingEditor editor) {
        addAlignmentButtonsTo(bar, editor, new LinkedList<Disposable>());
    }

    /**
     * Creates toolbar buttons and adds them to the specified JToolBar.
     */
    public static void addAlignmentButtonsTo(JToolBar bar, final DrawingEditor editor, java.util.List<Disposable> dsp) {
        AbstractSelectedAction d;
        bar.add(d = new AlignAction.West(editor)).setFocusable(false);
        dsp.add(d);
        bar.add(d = new AlignAction.East(editor)).setFocusable(false);
        dsp.add(d);
        bar.add(d = new AlignAction.Horizontal(editor)).setFocusable(false);
        dsp.add(d);
        bar.add(d = new AlignAction.North(editor)).setFocusable(false);
        dsp.add(d);
        bar.add(d = new AlignAction.South(editor)).setFocusable(false);
        dsp.add(d);
        bar.add(d = new AlignAction.Vertical(editor)).setFocusable(false);
        dsp.add(d);
        bar.addSeparator();
        bar.add(d = new MoveAction.West(editor)).setFocusable(false);
        dsp.add(d);
        bar.add(d = new MoveAction.East(editor)).setFocusable(false);
        dsp.add(d);
        bar.add(d = new MoveAction.North(editor)).setFocusable(false);
        dsp.add(d);
        bar.add(d = new MoveAction.South(editor)).setFocusable(false);
        dsp.add(d);
        bar.addSeparator();
        bar.add(new BringToFrontAction(editor)).setFocusable(false);
        dsp.add(d);
        bar.add(new SendToBackAction(editor)).setFocusable(false);
        dsp.add(d);

    }

    /**
     * Creates a button which toggles between two GridConstrainer for
     * a DrawingView.
     */
    public static AbstractButton createToggleGridButton(final DrawingView view) {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        final JToggleButton toggleButton;

        toggleButton = new JToggleButton();
        labels.configureToolBarButton(toggleButton, "view.toggleGrid");
        toggleButton.setFocusable(false);
        toggleButton.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent event) {
                view.setConstrainerVisible(toggleButton.isSelected());
                //view.getComponent().repaint();
            }
        });
        view.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                // String constants are interned
                if (evt.getPropertyName() == DrawingView.CONSTRAINER_VISIBLE_PROPERTY) {
                    toggleButton.setSelected(view.isConstrainerVisible());
                }
            }
        });

        return toggleButton;
    }

    public static JPopupButton createStrokeCapButton(DrawingEditor editor) {
        return createStrokeCapButton(editor,
                ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels"));
    }

    public static JPopupButton createStrokeCapButton(DrawingEditor editor,
            ResourceBundleUtil labels) {
        return createStrokeCapButton(editor,
                labels, new LinkedList<Disposable>());
    }

    public static JPopupButton createStrokeCapButton(DrawingEditor editor,
            ResourceBundleUtil labels, java.util.List<Disposable> dsp) {

        JPopupButton popupButton = new JPopupButton();
        labels.configureToolBarButton(popupButton, "attribute.strokeCap");
        popupButton.setFocusable(false);

        HashMap<AttributeKey, Object> attr;
        attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_CAP, BasicStroke.CAP_BUTT);
        AttributeAction a;
        popupButton.add(
                a = new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokeCap.butt"),
                null));
        dsp.add(a);
        attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_CAP, BasicStroke.CAP_ROUND);
        popupButton.add(
                a = new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokeCap.round"),
                null));
        dsp.add(a);
        attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_CAP, BasicStroke.CAP_SQUARE);
        popupButton.add(
                a = new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokeCap.square"),
                null));
        dsp.add(a);
        return popupButton;
    }

    public static JPopupButton createStrokeJoinButton(DrawingEditor editor) {
        return createStrokeJoinButton(editor,
                ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels"));
    }

    public static JPopupButton createStrokeJoinButton(DrawingEditor editor,
            ResourceBundleUtil labels) {
        return createStrokeJoinButton(editor,
                labels, new LinkedList<Disposable>());
    }

    public static JPopupButton createStrokeJoinButton(DrawingEditor editor,
            ResourceBundleUtil labels, java.util.List<Disposable> dsp) {

        JPopupButton popupButton = new JPopupButton();
        labels.configureToolBarButton(popupButton, "attribute.strokeJoin");
        popupButton.setFocusable(false);

        HashMap<AttributeKey, Object> attr;
        attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_JOIN, BasicStroke.JOIN_BEVEL);
        AttributeAction a;
        popupButton.add(
                a = new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokeJoin.bevel"),
                null));
        dsp.add(a);
        attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_JOIN, BasicStroke.JOIN_ROUND);
        popupButton.add(
                a = new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokeJoin.round"),
                null));
        dsp.add(a);
        attr = new HashMap<AttributeKey, Object>();
        attr.put(STROKE_JOIN, BasicStroke.JOIN_MITER);
        popupButton.add(
                a = new AttributeAction(
                editor,
                attr,
                labels.getString("attribute.strokeJoin.miter"),
                null));
        dsp.add(a);
        return popupButton;
    }

    public static JButton createPickAttributesButton(DrawingEditor editor) {
        return createPickAttributesButton(editor, new LinkedList<Disposable>());
    }

    public static JButton createPickAttributesButton(DrawingEditor editor, java.util.List<Disposable> dsp) {
        JButton btn;
        AbstractSelectedAction d;
        btn = new JButton(d = new PickAttributesAction(editor));
        dsp.add(d);
        if (btn.getIcon() != null) {
            btn.putClientProperty("hideActionText", Boolean.TRUE);
        }
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.BOTTOM);
        btn.setText(null);
        btn.setFocusable(false);
        return btn;
    }

    /**
     * Creates a button that applies the default attributes of the editor to
     * the current selection.
     */
    public static JButton createApplyAttributesButton(DrawingEditor editor) {
        return createApplyAttributesButton(editor, new LinkedList<Disposable>());
    }

    public static JButton createApplyAttributesButton(DrawingEditor editor, java.util.List<Disposable> dsp) {
        JButton btn;
        AbstractSelectedAction d;
        btn = new JButton(d = new ApplyAttributesAction(editor));
        dsp.add(d);
        if (btn.getIcon() != null) {
            btn.putClientProperty("hideActionText", Boolean.TRUE);
        }
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setVerticalTextPosition(JButton.BOTTOM);
        btn.setText(null);
        btn.setFocusable(false);
        return btn;
    }
}
