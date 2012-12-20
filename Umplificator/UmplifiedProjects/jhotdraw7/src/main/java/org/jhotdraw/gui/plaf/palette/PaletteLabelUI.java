/*
 * @(#)QuaquaLabelUI.java
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
import java.beans.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;

/**
 * QuaquaLabelUI.
 *
 * @author  Werner Randelshofer
 * @version $Id: PaletteLabelUI.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class PaletteLabelUI extends BasicLabelUI {

    protected final static PaletteLabelUI labelUI = new PaletteLabelUI();
    /* These rectangles/insets are allocated once for this shared LabelUI
     * implementation.  Re-using rectangles rather than allocating
     * them in each getPreferredSize call sped up the method substantially.
     */
    private static Rectangle iconR = new Rectangle();
    private static Rectangle textR = new Rectangle();
    private static Rectangle viewR = new Rectangle();
    private static Insets viewInsets = new Insets(0, 0, 0, 0);

    /**
     * Preferred spacing between labels and other components.
     * Pixels from colon and associated controls (RadioButton,
     * CheckBox)
     * /
     * private final static Insets associatedRegularSpacing = new Insets(8,8,8,8);
     * private final static Insets associatedSmallSpacing = new Insets(6,6,6,6);
     * private final static Insets associatedMiniSpacing = new Insets(5,5,5,5);
     */
    public static ComponentUI createUI(JComponent c) {
        return labelUI;
    }

    @Override
    protected void installDefaults(JLabel b) {
        super.installDefaults(b);

        // load shared instance defaults
        PaletteLookAndFeel.installBorder(b, "Label.border");
        PaletteLookAndFeel.installColorsAndFont(b, "Label.background", "Label.foreground", "Label.font");

        // FIXME - Very, very dirty trick to achieve small labels on sliders
        //         This hack should be removed, when we implement a SliderUI
        //         on our own.
        if (b.getClass().getName().endsWith("LabelUIResource")) {
            b.setFont(UIManager.getFont("Slider.labelFont"));
        }
    }

    @Override
    public void paint(Graphics gr, JComponent c) {
        Graphics2D g = (Graphics2D) gr;
        Object oldHints = PaletteUtilities.beginGraphics(g);

        // Paint background again so that the texture paint is drawn
        /*
        if (c.isOpaque()) {
            g.setPaint(PaintableColor.getPaint(c.getBackground(), c));
            g.fillRect(0, 0, c.getWidth(), c.getHeight());
        }*/

        // Paint background border
        /*
        Border b = c.getBorder();
        if (b != null && b instanceof BackgroundBorder) {
            ((BackgroundBorder) b).getBackgroundBorder().paintBorder(c, g, 0, 0, c.getWidth(), c.getHeight());
        }*/

        super.paint(g, c);
        PaletteUtilities.endGraphics(g, oldHints);
    }

    /**
     * Paint label with disabled text color.
     *
     * @see #paint
     * @see #paintEnabledText
     */
    @Override
    protected void paintDisabledText(JLabel l, Graphics g, String s, int textX, int textY) {
        Color c = UIManager.getColor("Label.disabledForeground");
        g.setColor((c != null) ? c : l.getForeground());

        int accChar = -1; //l.getDisplayedMnemonicIndex();

        PaletteUtilities.drawString(g, s, accChar,
                textX, textY);
    }

    @Override
    protected void paintEnabledText(JLabel l, Graphics g, String s, int textX, int textY) {
        int mnemIndex = l.getDisplayedMnemonicIndex();

        String style = (String) l.getClientProperty("Quaqua.Label.style");
        if (style != null) {
            if (style.equals("emboss") &&
                    UIManager.getColor("Label.embossForeground") != null) {
                g.setColor(UIManager.getColor("Label.embossForeground"));
                PaletteUtilities.drawString(g, s, mnemIndex, textX, textY + 1);

            } else if (style.equals("shadow") &&
                    UIManager.getColor("Label.shadowForeground") != null) {
                g.setColor(UIManager.getColor("Label.shadowForeground"));
                PaletteUtilities.drawString(g, s, mnemIndex, textX, textY + 1);
            }
        }

        g.setColor(l.getForeground());
        PaletteUtilities.drawString(g, s, mnemIndex, textX, textY);
    //SwingUtilities2.drawStringUnderlineCharAt(l, g, s, mnemIndex,
    //                                             textX, textY);
    }

    /**
     * Forwards the call to SwingUtilities.layoutCompoundLabel().
     * This method is here so that a subclass could do Label specific
     * layout and to shorten the method name a little.
     *
     * @see SwingUtilities#layoutCompoundLabel
     */
    @Override
    protected String layoutCL(
            JLabel label,
            FontMetrics fontMetrics,
            String text,
            Icon icon,
            Rectangle viewR,
            Rectangle iconR,
            Rectangle textR) {
        return SwingUtilities.layoutCompoundLabel(
                (JComponent) label,
                fontMetrics,
                text,
                icon,
                label.getVerticalAlignment(),
                label.getHorizontalAlignment(),
                label.getVerticalTextPosition(),
                label.getHorizontalTextPosition(),
                viewR,
                iconR,
                textR,
                label.getIconTextGap());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String name = evt.getPropertyName();

        if (name.equals("JComponent.sizeVariant")) {
//            QuaquaUtilities.applySizeVariant((JLabel) evt.getSource());
        } else {
            super.propertyChange(evt);
        }
    }
}
