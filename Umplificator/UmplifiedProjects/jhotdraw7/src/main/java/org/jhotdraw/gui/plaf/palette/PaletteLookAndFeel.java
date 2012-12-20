/**
 * @(#)PaletteLookAndFeel.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui.plaf.palette;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.*;
import java.util.Enumeration;
import java.util.ResourceBundle;
import javax.swing.*;
import javax.swing.UIDefaults.*;
import javax.swing.border.Border;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;

/**
 * A LookAndFeel for components in the palette windows of a drawing editor.
 *
 * @author Werner Randelshofer
 * @version $Id: PaletteLookAndFeel.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class PaletteLookAndFeel extends BasicLookAndFeel {

    /** 
     * Shared instance.
     */
    private static PaletteLookAndFeel instance;
    /**
     * Cached defaults.
     */
    private UIDefaults cachedDefaults;

    public static PaletteLookAndFeel getInstance() {
        if (instance == null) {
            instance = new PaletteLookAndFeel();
        }
        return instance;
    }

    @Override
    public String getName() {
        return "Palette Look and Feel";
    }

    @Override
    public String getID() {
        return "Palette";
    }

    @Override
    public String getDescription() {
        return "A look and feel for palette components";
    }

    @Override
    public boolean isNativeLookAndFeel() {
        return false;
    }

    @Override
    public boolean isSupportedLookAndFeel() {
        return true;
    }

    public UIDefaults getCachedDefaults() {
        if (cachedDefaults == null) {
            cachedDefaults = getDefaults();
        }
        return cachedDefaults;
    }

    /**
     * Looks up up the given key in our Hashtable and resolves LazyValues
     * or ActiveValues.
     */
    public Object get(Object key) {
        UIDefaults defaults = getCachedDefaults();

        /* Quickly handle the common case, without grabbing
         * a lock.
         */
        Object value = defaults.get(key);
        if (!(value instanceof ActiveValue)
                && !(value instanceof LazyValue)) {
            return value;
        }

        return value;
    }

    public boolean getBoolean(String key) {
        return ((Boolean) get(key)).booleanValue();
    }

    public Border getBorder(String key) {
        return (Border) get(key);
    }

    public Color getColor(String key) {
        return (Color) get(key);
    }

    public Font getFont(String key) {
        return (Font) get(key);
    }

    public Icon getIcon(String key) {
        return (Icon) get(key);
    }

    public int getInt(String key) {
        return (Integer) get(key);
    }

    public Insets getInsets(String key) {
        return (Insets) get(key);
    }

    public String getString(String key) {
        return (String) get(key);
    }

    /**
     * Convenience method for initializing a components foreground
     * background and font properties with values from the current
     * defaults table.  The properties are only set if the current
     * value is either null or a UIResource.
     * 
     * @param c the target component for installing default color/font properties
     * @param defaultBgName the key for the default background
     * @param defaultFgName the key for the default foreground
     * @param defaultFontName the key for the default font
     * 
     * @see #installColors
     * @see UIManager#getColor
     * @see UIManager#getFont
     */
    public static void installColorsAndFont(JComponent c,
            String defaultBgName,
            String defaultFgName,
            String defaultFontName) {
        Font f = c.getFont();
        if (f == null || f instanceof UIResource) {
            c.setFont(getInstance().getFont(defaultFontName));
        }

        installColors(c, defaultBgName, defaultFgName);
    }

    /**
     * Convenience method for installing a component's default Border 
     * object on the specified component if either the border is 
     * currently null or already an instance of UIResource.
     * @param c the target component for installing default border
     * @param defaultBorderName the key specifying the default border
     */
    public static void installBorder(JComponent c, String defaultBorderName) {
        Border b = c.getBorder();
        if (b == null || b instanceof UIResource) {
            c.setBorder(getInstance().getBorder(defaultBorderName));
        }

    }

    /**
     * Convenience method for initializing a component's foreground
     * and background color properties with values from the current
     * defaults table.  The properties are only set if the current
     * value is either null or a UIResource.
     * 
     * @param c the target component for installing default color/font properties
     * @param defaultBgName the key for the default background
     * @param defaultFgName the key for the default foreground
     * 
     * @see #installColorsAndFont
     * @see UIManager#getColor
     */
    public static void installColors(JComponent c,
            String defaultBgName,
            String defaultFgName) {
        PaletteLookAndFeel plaf = getInstance();
        Color bg = c.getBackground();
        if (bg == null || bg instanceof UIResource) {
            c.setBackground(plaf.getColor(defaultBgName));
        }

        Color fg = c.getForeground();
        if (fg == null || fg instanceof UIResource) {
            c.setForeground(plaf.getColor(defaultFgName));
        }
    }

    @Override
    protected void initComponentDefaults(UIDefaults table) {
        super.initComponentDefaults(table);

        // Add resource bundle to the table.
        // Since this does not seem to work in sandboxed environments, we check
        // whether we succeeded and - in case of failure - put the values in
        // by ourselves.
        table.addResourceBundle("org.jhotdraw.gui.Labels");
        if (table.getString("ColorChooser.rgbSliders") == null) {
            ResourceBundle rb = ResourceBundle.getBundle("org.jhotdraw.gui.Labels");
            for (Enumeration<String> keys = rb.getKeys(); keys.hasMoreElements();) {
                String key = keys.nextElement();
                table.put(key, rb.getObject(key));
            }
        }
        // *** Shared Fonts
        Integer fontPlain = Font.PLAIN;
        Integer fontBold = Font.BOLD;
        Object dialogPlain11 = new ProxyLazyValue(
                "javax.swing.plaf.FontUIResource",
                null,
                new Object[]{"Dialog Sans", fontPlain, 11});
        Object dialogPlain12 = new ProxyLazyValue(
                "javax.swing.plaf.FontUIResource",
                null,
                new Object[]{"Dialog Sans", fontPlain, 12});
        Object fieldPlain12 = new ProxyLazyValue(
                "javax.swing.plaf.FontUIResource",
                null,
                new Object[]{"Verdana", fontPlain, 12});
        Object dialogBold12 = new ProxyLazyValue(
                "javax.swing.plaf.FontUIResource",
                null,
                new Object[]{"Dialog", fontBold, 12});


        // *** Shared Colors
        ColorUIResource black = new ColorUIResource(Color.black);

        ColorUIResource control = new ColorUIResource(0xf0f0f0);
        ColorUIResource controlText = black;

        ColorUIResource selectionBackground = new ColorUIResource(0xb5d5ff);
        ColorUIResource selectionForeground = black;

        ColorUIResource listSelectionBackground = new ColorUIResource(0x3875d7);
        Object focusCellHighlightBorder = new UIDefaults.ProxyLazyValue(
                "javax.swing.plaf.BorderUIResource$LineBorderUIResource",
                // null,
                new Object[]{listSelectionBackground});

        // *** Shared Insets
        InsetsUIResource zeroInsets = new InsetsUIResource(0, 0, 0, 0);

        // *** Shared Borders
	/*Object buttonBorder = 
        new ProxyLazyValue(
        "org.jhotdraw.gui.plaf.palette.BackdropBorder$UIResource",
        new Object[] {new PaletteButtonBorder()});*/
        Object buttonBorder = new BackdropBorder.UIResource(new PaletteButtonBorder());
        Object textBorder = new BackdropBorder.UIResource(new PaletteTextComponentBorder());

        Object[] defaults = {
            // *** Fonts
            "SmallSystemFont", dialogPlain11,
            // *** Buttons
            "Button.font", dialogPlain12,
            "Button.background", control,
            "Button.foreground", controlText,
            "Button.border", buttonBorder,
            "Button.margin", zeroInsets,
            // *** FontChooser
            "Button.background", control,
            "Button.foreground", controlText,
            "Button.border", buttonBorder,
            "Button.margin", zeroInsets,
            // *** ColorChooser
            // class names of default choosers
            "ColorChooser.font", dialogPlain11,
            "ColorChooser.defaultChoosers", new String[]{
                "org.jhotdraw.gui.plaf.palette.colorchooser.PaletteSwatchesChooser",
                "org.jhotdraw.gui.plaf.palette.colorchooser.PaletteColorWheelChooser",
                "org.jhotdraw.gui.plaf.palette.colorchooser.PaletteColorSlidersChooser",},
            "ColorChooser.textSliderGap", 3,
            //
            // *** FormattedTextField
            "FormattedTextField.font", fieldPlain12,
            "FormattedTextField.background", control,
            "FormattedTextField.foreground", controlText,
            "FormattedTextField.border", textBorder,
            "FormattedTextField.margin", zeroInsets,
            "FormattedTextField.opaque", Boolean.TRUE,
            "FormattedTextField.errorIndicatorForeground", new ColorUIResource(0xfe4a41),
            "FormattedTextField.selectionBackground", selectionBackground,
            "FormattedTextField.selectionForeground", selectionForeground,
            // *** Labels
            "Label.font", dialogPlain12,
            "Label.border", new UIDefaults.ProxyLazyValue(
            "javax.swing.plaf.BorderUIResource$EmptyBorderUIResource",
            new Object[]{0, 0, 0, 0}),
            // *** Lists
            "List.focusCellHighlightBorder", focusCellHighlightBorder,
            "List.cellRenderer", new UIDefaults.ProxyLazyValue("org.jhotdraw.gui.plaf.palette.PaletteListCellRenderer"),
            // *** Panels
            "Panel.background", control,
            "Panel.foreground", controlText,
            "Panel.opaque", Boolean.TRUE,
            // *** Ribbons
            "Ribbon.border", new UIDefaults.ProxyLazyValue("javax.swing.border.MatteBorder", new Object[]{new Insets(1, 0, 0, 0), new Color(0x777777)}), //
            // *** ScrollPane
            "ScrollPane.border", new UIDefaults.ProxyLazyValue("javax.swing.border.MatteBorder", new Object[]{new Insets(1, 1, 1, 1), new Color(0xa5a5a5)}), //
            // *** Slider
            "Slider.background", control,
            "Slider.foreground", controlText,
            "Slider.horizontalSize", new DimensionUIResource(100, 20),
            "Slider.verticalSize", new DimensionUIResource(20, 100),
            "Slider.northThumb.small", new UIDefaults.ProxyLazyValue(
            "org.jhotdraw.gui.plaf.palette.PaletteSliderThumbIcon",
            new Object[]{"/org/jhotdraw/gui/plaf/palette/images/Slider.northThumbs.small.png", 6, true}),
            "Slider.westThumb.small", new UIDefaults.ProxyLazyValue(
            "org.jhotdraw.gui.plaf.palette.PaletteSliderThumbIcon",
            new Object[]{"/org/jhotdraw/gui/plaf/palette/images/Slider.westThumbs.small.png", 6, true}),
            // *** TabbedPane
            "TabbedPane.font", dialogPlain12,
            "TabbedPane.selectedFont", dialogBold12,
            "TabbedPane.background", control,
            "TabbedPane.contentAreaColor", control,
            "TabbedPane.foreground", controlText,
            "TabbedPane.highlight", new ColorUIResource(0xa5a5a5),
            "TabbedPane.lightHighlight", new ColorUIResource(0xa5a5a5),
            "TabbedPane.shadow", new ColorUIResource(0xa5a5a5),
            "TabbedPane.darkShadow", new ColorUIResource(0x333333),
            // *** TextArea
            "TextArea.selectionBackground", selectionBackground,
            "TextArea.selectionForeground", selectionForeground,
            // *** TextField
            "TextField.font", fieldPlain12,
            "TextField.background", control,
            "TextField.foreground", controlText,
            "TextField.border", textBorder,
            "TextField.margin", zeroInsets,
            "TextField.opaque", Boolean.TRUE,
            "TextField.selectionBackground", selectionBackground,
            "TextField.selectionForeground", selectionForeground,
            // *** ToolBar
            "ToolBar.font", dialogPlain12,
            "ToolBar.background", control,
            "ToolBar.foreground", controlText,
            "ToolBar.dockingBackground", control,
            //	    "ToolBar.dockingForeground", red,
            "ToolBar.floatingBackground", control,
            //	    "ToolBar.floatingForeground", darkGray,
            //	    "ToolBar.border", etchedBorder,
            "ToolBar.border", new UIDefaults.ProxyLazyValue("org.jhotdraw.gui.plaf.palette.PaletteToolBarBorder$UIResource"), //
        //	    "ToolBar.separatorSize", toolBarSeparatorSize,
        };
        table.putDefaults(defaults);
    }

    /**
     * Returns the ui that is of type <code>klass</code>, or null if
     * one can not be found.
     */
    @Nullable
    static Object getUIOfType(ComponentUI ui, Class klass) {
        if (klass.isInstance(ui)) {
            return ui;
        }
        return null;
    }
}
