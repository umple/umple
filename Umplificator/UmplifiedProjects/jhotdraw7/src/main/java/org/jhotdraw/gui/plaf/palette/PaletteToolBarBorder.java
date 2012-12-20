/*
 * @(#)PaletteToolBarBorder.java
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
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * PaletteToolBarBorder.
 *
 * @author  Werner Randelshofer
 * @version $Id: PaletteToolBarBorder.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class PaletteToolBarBorder
        extends AbstractBorder
        implements SwingConstants {

    private final static float[] enabledStops = new float[]{0f, 0.5f, 1f};
    private final static Color[] enabledStopColors = new Color[]{new Color(0xf8f8f8), new Color(0xc8c8c8), new Color(0xf8f8f8)};
    private final static float[] selectedStops = new float[]{0f, 0.1f, 0.9f, 1f};
    private final static Color[] selectedStopColors = new Color[]{new Color(0x666666), new Color(0xcccccc), new Color(0x999999), new Color(0xb1b1b1)};
    private final static Color bright = new Color(0x999999, true);
    private final static Color dark = new Color(0x8c8c8c);
    private final static Color divider = new Color(0x9f9f9f);
    /*
    private final static Color dark = new Color(0x999999);
    private final static Color bright = new Color(0xb3b3b3);
    /*
     *//*
    private final static Color dark = new Color(0x808080);
    private final static Color bright = new Color(0xcccccc);
     **/


    @Override
    public void paintBorder(Component component, Graphics gr, int x, int y, int w, int h) {
        Graphics2D g = (Graphics2D) gr;
        
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if ((component instanceof JToolBar) && ((((JToolBar) component).getUI()) instanceof PaletteToolBarUI)) {
            JToolBar c = (JToolBar) component;
            if (c.isFloatable()) {
                int hx = x, hy = y, hw = w, hh = h;
                if (c.getOrientation() == HORIZONTAL) {
                    if (c.getComponentOrientation().isLeftToRight()) {
                        int barW = 18;
                        int barH = h;
                        int barX = 0;
                        int barY = 0;
                        
                        
                        int borderColor = 0xffa5a5a5;
                        float[] stops = enabledStops;
                        Color[] stopColors = enabledStopColors;
                        g.setColor(new Color(borderColor, true));
                        g.drawRect(barX, barY, barW - 1, barH - 1);
                        LinearGradientPaint lgp = new LinearGradientPaint(
                                new Point2D.Float(1, 1), new Point2D.Float(19, 1),
                                stops, stopColors,
                                MultipleGradientPaint.CycleMethod.REPEAT);
                        g.setPaint(lgp);
                        g.fillRect(barX + 1, barX + 1, barW - 2, barH - 2);

                        // paint the icon
                        Icon icon = (Icon) c.getClientProperty(PaletteToolBarUI.TOOLBAR_ICON_PROPERTY);
                        if (icon != null) {
                            icon.paintIcon(component, gr, barX + (barW - icon.getIconWidth()) / 2, 
                                    barY + barH - 4 - icon.getIconHeight());
                        }
                        
                        int textIconGap = (c.getClientProperty(PaletteToolBarUI.TOOLBAR_ICON_PROPERTY) instanceof Integer) ? 
                            (Integer) c.getClientProperty(PaletteToolBarUI.TOOLBAR_ICON_PROPERTY) : 2;
                        
                        String theTitle = c.getName();
                        if (theTitle != null) {
                            FontMetrics fm = g.getFontMetrics();
                            int titleW;
                            titleW = barH - 8;
                            
                            if (icon != null) {
                                titleW -= icon.getIconHeight() + textIconGap;
                            }
                            
                            theTitle = clippedText(theTitle, fm, titleW);


                            AffineTransform savedTransform = g.getTransform();
                            AffineTransform t = g.getTransform();
                            t.rotate(Math.PI / -2d, barX + 2 + fm.getAscent(), titleW + 4);
                            g.setTransform(t);
                            g.setColor(Color.black);
                            g.drawString(theTitle, barX + 2 + fm.getAscent(), titleW + 4);
                            g.setTransform(savedTransform);
                        }
                    } else {
                        g.setColor(bright);
                        g.fillRect(hw - hx - 3, hy + 2, 1, hh - 4);
                        g.fillRect(hw - hx - 5, hy + 2, 1, hh - 4);
                        g.setColor(dark);
                        g.fillRect(hw - hx - 2, hy + 2, 1, hh - 4);
                        g.fillRect(hw - hx - 6, hy + 2, 1, hh - 4);
                    }
                } else // vertical
                {
                    g.setColor(bright);
                    g.fillRect(hx + 2, hy + 2, hw - 4, 1);
                    g.fillRect(hx + 2, hy + 5, hw - 4, 1);
                    g.setColor(dark);
                    g.fillRect(hx + 2, hy + 3, hw - 4, 1);
                    g.fillRect(hx + 2, hy + 6, hw - 4, 1);
                }
            }
        }
    }
    
    @Override
    public Insets getBorderInsets(Component c) {
        return getBorderInsets(c, new Insets(0, 0, 0, 0));
    }
    
    /**
     * These insets are used by PaletteToolBarUI, to determine if
     * the toolbar should be dragged.
     * 
     * @param c JToolBar.
     * @return Return drag insets.
     */
    public Insets getDragInsets(Component c) {
        return new Insets(0,18,0,0);
    }

    @Override
    public Insets getBorderInsets(Component component, Insets newInsets) {
        if (newInsets == null) {
            newInsets = new Insets(0,0,0,0);
        }
        JComponent c = (JComponent) component;
        if (c.getClientProperty(PaletteToolBarUI.TOOLBAR_INSETS_OVERRIDE_PROPERTY) instanceof Insets) {
            Insets override = (Insets) c.getClientProperty(PaletteToolBarUI.TOOLBAR_INSETS_OVERRIDE_PROPERTY);
            newInsets.top = override.top;
            newInsets.left = override.left;
            newInsets.bottom = override.bottom;
            newInsets.right = override.right;
            return newInsets;
        }
        
        newInsets.top = 0;
        newInsets.left = 18;
        newInsets.bottom = 0;
        newInsets.right = 0;
        return newInsets;
    }

    /**
     * Convenience method to clip the passed in text to the specified
     * size.
     */
    private String clippedText(String text, FontMetrics fm,
            int availTextWidth) {
        if ((text == null) || (text.equals(""))) {
            return "";
        }
        int textWidth = SwingUtilities.computeStringWidth(fm, text);
        String clipString = "…";
        if (textWidth > availTextWidth) {
            int totalWidth = SwingUtilities.computeStringWidth(fm, clipString);
            int nChars;
            for (nChars = 0; nChars < text.length(); nChars++) {
                totalWidth += fm.charWidth(text.charAt(nChars));
                if (totalWidth > availTextWidth) {
                    break;
                }
            }
            text = text.substring(0, nChars) + clipString;
        }
        return text;
    }

    public static class UIResource extends PaletteToolBarBorder implements javax.swing.plaf.UIResource {
    }
}
