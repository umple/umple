/**
 * @(#)PaletteUtilities.java
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
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicGraphicsUtils;

/**
 * PaletteUtilities.
 *
 * @author Werner Randelshofer
 * @version $Id: PaletteUtilities.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class PaletteUtilities  extends BasicGraphicsUtils {

    public static final Object beginGraphics(Graphics2D graphics2d) {
        Object object = graphics2d.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING);

        /*
        AffineTransform tx = graphics2d.getTransform();
        AffineTransform savedTransform = (AffineTransform) tx.clone();
        tx.scale(0.9,0.9);
        graphics2d.setTransform(tx);
         */
        graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        /*graphics2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
        RenderingHints.VALUE_FRACTIONALMETRICS_ON);*/

        //if (true) return savedTransform;
        return object;
    }

    public static final void endGraphics(Graphics2D graphics2d, Object oldHints) {
        /*
        if (true) {
        graphics2d.setTransform((AffineTransform) oldHints);
        return;
        }*/

        if (oldHints != null) {
            graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    oldHints);
        }
    }

    /**
     * Draw a string with the graphics <code>g</code> at location
     * (<code>x</code>, <code>y</code>)
     * just like <code>g.drawString</code> would.
     * The character at index <code>underlinedIndex</code>
     * in text will be underlined. If <code>index</code> is beyond the
     * bounds of <code>text</code> (including < 0), nothing will be
     * underlined.
     *
     * @param g Graphics to draw with
     * @param text String to draw
     * @param underlinedIndex Index of character in text to underline
     * @param x x coordinate to draw at
     * @param y y coordinate to draw at
     * @since 1.4
     */
    public static void drawStringUnderlineCharAt(JComponent c, Graphics g, String text,
            int underlinedIndex, int x, int y) {
        g.drawString(text, x, y);
        if (underlinedIndex >= 0 && underlinedIndex < text.length()) {
            FontMetrics fm = g.getFontMetrics();
            int underlineRectX = x + fm.stringWidth(text.substring(0, underlinedIndex));
            int underlineRectY = y;
            int underlineRectWidth = fm.charWidth(text.charAt(underlinedIndex));
            int underlineRectHeight = 1;
            g.fillRect(underlineRectX, underlineRectY + fm.getDescent() - 1,
                    underlineRectWidth, underlineRectHeight);
        }
    }

    /*
     * Convenience function for determining ComponentOrientation.  Helps us
     * avoid having Munge directives throughout the code.
     */
    static boolean isLeftToRight( Component c ) {
        return c.getComponentOrientation().isLeftToRight();
    }

    /**
     * Returns the FontMetrics for the current Font of the passed
     * in Graphics.  This method is used when a Graphics
     * is available, typically when painting.  If a Graphics is not
     * available the JComponent method of the same name should be used.
     * <p>
     * Callers should pass in a non-null JComponent, the exception
     * to this is if a JComponent is not readily available at the time of
     * painting.
     * <p>
     * This does not necessarily return the FontMetrics from the
     * Graphics.
     *
     * @param c JComponent requesting FontMetrics, may be null
     * @param g Graphics Graphics
     */
    public static FontMetrics getFontMetrics(JComponent c, Graphics g) {
        return getFontMetrics(c, g, g.getFont());
    }


    /**
     * Returns the FontMetrics for the specified Font.
     * This method is used when a Graphics is available, typically when
     * painting.  If a Graphics is not available the JComponent method of
     * the same name should be used.
     * <p>
     * Callers should pass in a non-null JComonent, the exception
     * to this is if a JComponent is not readily available at the time of
     * painting.
     * <p>
     * This does not necessarily return the FontMetrics from the
     * Graphics.
     *
     * @param c JComponent requesting FontMetrics, may be null
     * @param g Graphics
     * @param font Font to get FontMetrics for
     */
    @SuppressWarnings("deprecation")
    public static FontMetrics getFontMetrics(JComponent c, Graphics g,
                                             Font font) {
        if (c != null) {
            // Note: We assume that we're using the FontMetrics
            // from the widget to layout out text, otherwise we can get
            // mismatches when printing.
            return c.getFontMetrics(font);
        }
        return Toolkit.getDefaultToolkit().getFontMetrics(font);
    }
}
