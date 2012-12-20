/**
 * @(#)PaletteTextFieldUI.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui.plaf.palette;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;
import javax.swing.text.*;

/**
 * PaletteTextFieldUI.
 *
 * @author Werner Randelshofer
 * @version $Id: PaletteTextFieldUI.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class PaletteTextFieldUI extends BasicTextFieldUI {

    /**
     * Creates a UI for a JTextField.
     *
     * @param c the text field
     * @return the UI
     */
    public static ComponentUI createUI(JComponent c) {
        return new PaletteTextFieldUI();
    }

    /**
     * Initializes component properties, e.g. font, foreground, 
     * background, caret color, selection color, selected text color,
     * disabled text color, and border color.  The font, foreground, and
     * background properties are only set if their current value is either null
     * or a UIResource, other properties are set if the current
     * value is null.
     * 
     * @see #uninstallDefaults
     * @see #installUI
     */
    @Override
    protected void installDefaults() {
        JTextComponent editor = getComponent();
        PaletteLookAndFeel plaf = PaletteLookAndFeel.getInstance();

        String prefix = getPropertyPrefix();
        Font f = editor.getFont();
        if ((f == null) || (f instanceof UIResource)) {
            editor.setFont(plaf.getFont(prefix + ".font"));
        }

        Color bg = editor.getBackground();
        if ((bg == null) || (bg instanceof UIResource)) {
            editor.setBackground(plaf.getColor(prefix + ".background"));
        }

        Color fg = editor.getForeground();
        if ((fg == null) || (fg instanceof UIResource)) {
            editor.setForeground(plaf.getColor(prefix + ".foreground"));
        }

        Color color = editor.getCaretColor();
        if ((color == null) || (color instanceof UIResource)) {
            editor.setCaretColor(plaf.getColor(prefix + ".caretForeground"));
        }

        Color s = editor.getSelectionColor();
        if ((s == null) || (s instanceof UIResource)) {
            editor.setSelectionColor(plaf.getColor(prefix + ".selectionBackground"));
        }

        Color sfg = editor.getSelectedTextColor();
        if ((sfg == null) || (sfg instanceof UIResource)) {
            editor.setSelectedTextColor(plaf.getColor(prefix + ".selectionForeground"));
        }

        Color dfg = editor.getDisabledTextColor();
        if ((dfg == null) || (dfg instanceof UIResource)) {
            editor.setDisabledTextColor(plaf.getColor(prefix + ".inactiveForeground"));
        }

        Border b = editor.getBorder();
        if ((b == null) || (b instanceof UIResource)) {
            editor.setBorder(plaf.getBorder(prefix + ".border"));
        }

        Insets margin = editor.getMargin();
        if (margin == null || margin instanceof UIResource) {
            editor.setMargin(plaf.getInsets(prefix + ".margin"));
        }

        editor.setOpaque(plaf.getBoolean(prefix + ".opaque"));
    }

    @Override
    protected void paintSafely(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        super.paintSafely(g);
    }

    @Override
    public void paintBackground(Graphics g) {
        JTextComponent c = getComponent();
        if (c.getBorder() instanceof BackdropBorder) {
            BackdropBorder bb = (BackdropBorder) c.getBorder();
            bb.getBackdropBorder().paintBorder(c, g, 0, 0, c.getWidth(), c.getHeight());
        } else {
            super.paintBackground(g);
        }
    }
}
