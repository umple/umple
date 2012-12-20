/*
 * @(#)PaletteTabbedPaneUI.java
 * 
 * Copyright (c) 2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui.plaf.palette;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.LinearGradientPaint;
import java.awt.MultipleGradientPaint;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import javax.swing.plaf.metal.MetalTabbedPaneUI;
import javax.swing.text.View;

/**
 * PaletteTabbedPaneUI.
 *
 * @author Werner Randelshofer
 * @version $Id: PaletteTabbedPaneUI.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class PaletteTabbedPaneUI extends BasicTabbedPaneUI {

    private final static float[] enabledStops = new float[]{0f, 0.35f, 0.4f, 1f};
    private final static Color[] enabledStopColors = new Color[]{new Color(0xf8f8f8), new Color(0xeeeeee), new Color(0xcacaca), new Color(0xffffff)};
    private boolean tabsOverlapBorder;
    private Color selectedColor;
    private boolean tabsOpaque = true;
    private boolean contentOpaque = true;

    public static ComponentUI createUI(JComponent c) {
        return new PaletteTabbedPaneUI();
    }

    @Override
    protected void installDefaults() {
        PaletteLookAndFeel laf = PaletteLookAndFeel.getInstance();
        MetalTabbedPaneUI mtpui;
        PaletteLookAndFeel.installColorsAndFont(tabPane, "TabbedPane.background",
                "TabbedPane.foreground", "TabbedPane.font");
        highlight = laf.getColor("TabbedPane.light");
        lightHighlight = laf.getColor("TabbedPane.highlight");
        shadow = laf.getColor("TabbedPane.shadow");
        darkShadow = laf.getColor("TabbedPane.darkShadow");
        focus = laf.getColor("TabbedPane.focus");
        selectedColor = laf.getColor("TabbedPane.selected"); // will probably not
        // work as expected since we don't override enough colors from BasicTabbedPaneUI

        textIconGap = laf.getInt("TabbedPane.textIconGap");
        tabInsets = laf.getInsets("TabbedPane.tabInsets");
        selectedTabPadInsets = laf.getInsets("TabbedPane.selectedTabPadInsets");
        tabAreaInsets = laf.getInsets("TabbedPane.tabAreaInsets");
        tabsOverlapBorder = laf.getBoolean("TabbedPane.tabsOverlapBorder");
        ;  // will probably not
        // work as expected since we don't override enough colors from BasicTabbedPaneUI
        contentBorderInsets = laf.getInsets("TabbedPane.contentBorderInsets");
        tabRunOverlay = laf.getInt("TabbedPane.tabRunOverlay");
        tabsOpaque = laf.getBoolean("TabbedPane.tabsOpaque");// will probably not
        // work as expected since we don't override enough colors from BasicTabbedPaneUI
        contentOpaque = laf.getBoolean("TabbedPane.contentOpaque");// will probably not
        // work as expected since we don't override enough colors from BasicTabbedPaneUI
        Object opaque = laf.get("TabbedPane.opaque");
        if (opaque == null) {
            opaque = Boolean.FALSE;
        }
        PaletteLookAndFeel.installProperty(tabPane, "opaque", opaque);

        // Fix for 6711145 BasicTabbedPanuUI should not throw a NPE if these
        // keys are missing. So we are setting them to there default values here
        // if the keys are missing.
        if (tabInsets == null) {
            tabInsets = new Insets(0, 4, 1, 4);
        }
        if (selectedTabPadInsets == null) {
            selectedTabPadInsets = new Insets(2, 2, 2, 1);
        }
        if (tabAreaInsets == null) {
            tabAreaInsets = new Insets(3, 2, 0, 2);
        }
        if (contentBorderInsets == null) {
            contentBorderInsets = new Insets(2, 2, 3, 3);
        }
    }

    @Override
    protected void paintTab(Graphics g, int tabPlacement,
            Rectangle[] rects, int tabIndex,
            Rectangle iconRect, Rectangle textRect) {
        Rectangle tabRect = rects[tabIndex];
        int selectedIndex = tabPane.getSelectedIndex();
        boolean isSelected = selectedIndex == tabIndex;

        if (tabsOpaque || tabPane.isOpaque()) {
            paintTabBackground(g, tabPlacement, tabIndex, tabRect.x, tabRect.y,
                    tabRect.width, tabRect.height, isSelected);
        }

        paintTabBorder(g, tabPlacement, tabIndex, tabRect.x, tabRect.y,
                tabRect.width, tabRect.height, isSelected);

        String title = tabPane.getTitleAt(tabIndex);
        Font font = isSelected ? PaletteLookAndFeel.getInstance().getFont("TabbedPane.selectedFont") : tabPane.getFont();
        FontMetrics metrics = PaletteUtilities.getFontMetrics(tabPane, g, font);
        Icon icon = getIconForTab(tabIndex);

        layoutLabel(tabPlacement, metrics, tabIndex, title, icon,
                tabRect, iconRect, textRect, isSelected);

        if (tabPane.getTabComponentAt(tabIndex) == null) {
            String clippedTitle = title;

            // XXX - Implement scrollable tab layout support.
            /*
            if (scrollableTabLayoutEnabled() && tabScroller.croppedEdge.isParamsSet() &&
            tabScroller.croppedEdge.getTabIndex() == tabIndex && isHorizontalTabPlacement()) {
            int availTextWidth = tabScroller.croppedEdge.getCropline() -
            (textRect.x - tabRect.x) - tabScroller.croppedEdge.getCroppedSideWidth();
            clippedTitle = SwingUtilities2.clipStringIfNecessary(null, metrics, title, availTextWidth);
            }*/

            paintText(g, tabPlacement, font, metrics,
                    tabIndex, clippedTitle, textRect, isSelected);

            paintIcon(g, tabPlacement, tabIndex, icon, iconRect, isSelected);
        }
        paintFocusIndicator(g, tabPlacement, rects, tabIndex,
                iconRect, textRect, isSelected);
    }

    /**
     * this function draws the border around each tab
     * note that this function does now draw the background of the tab.
     * that is done elsewhere
     */
    @Override
    protected void paintTabBorder(Graphics g, int tabPlacement,
            int tabIndex,
            int x, int y, int w, int h,
            boolean isSelected) {
        g.setColor(isSelected ? darkShadow : shadow);

        switch (tabPlacement) {
            case LEFT:
                g.drawLine(x + 1, y + h - 2, x + 1, y + h - 2); // bottom-left highlight
                g.drawLine(x, y + 2, x, y + h - 3); // left highlight
                g.drawLine(x + 1, y + 1, x + 1, y + 1); // top-left highlight
                g.drawLine(x + 2, y, x + w - 1, y); // top highlight

                g.drawLine(x + 2, y + h - 2, x + w - 1, y + h - 2); // bottom shadow

                g.drawLine(x + 2, y + h - 1, x + w - 1, y + h - 1); // bottom dark shadow
                break;
            case RIGHT:
                g.drawLine(x, y, x + w - 3, y); // top highlight

                g.drawLine(x, y + h - 2, x + w - 3, y + h - 2); // bottom shadow
                g.drawLine(x + w - 2, y + 2, x + w - 2, y + h - 3); // right shadow

                g.drawLine(x + w - 2, y + 1, x + w - 2, y + 1); // top-right dark shadow
                g.drawLine(x + w - 2, y + h - 2, x + w - 2, y + h - 2); // bottom-right dark shadow
                g.drawLine(x + w - 1, y + 2, x + w - 1, y + h - 3); // right dark shadow
                g.drawLine(x, y + h - 1, x + w - 3, y + h - 1); // bottom dark shadow
                break;
            case BOTTOM:
                g.drawLine(x, y, x, y + h - 2); // left highlight
//              g.drawLine(x+1, y+h-1, x+1, y+h-1); // bottom-left highlight

                g.drawLine(x + 1, y + h - 2, x + w - 1, y + h - 2); // bottom shadow
                g.drawLine(x + w - 1, y, x + w - 1, y + h - 2); // right shadow

                /*
                g.drawLine(x+2, y+h-1, x+w-3, y+h-1); // bottom dark shadow
                g.drawLine(x+w-2, y+h-2, x+w-2, y+h-2); // bottom-right dark shadow
                g.drawLine(x+w-1, y, x+w-1, y+h-3); // right dark shadow
                 */
                break;
            case TOP:
            default:
                g.drawLine(x, y + 2, x, y + h - 1); // left highlight
                g.drawLine(x + 1, y + 1, x + 1, y + 1); // top-left highlight
                g.drawLine(x + 2, y, x + w - 3, y); // top highlight

                g.drawLine(x + w - 2, y + 2, x + w - 2, y + h - 1); // right shadow

                g.drawLine(x + w - 1, y + 2, x + w - 1, y + h - 1); // right dark-shadow
                g.drawLine(x + w - 2, y + 1, x + w - 2, y + 1); // top-right shadow
        }
    }

    @Override
    protected void paintTabBackground(Graphics gr, int tabPlacement,
            int tabIndex,
            int x, int y, int w, int h,
            boolean isSelected) {
        Graphics2D g = (Graphics2D) gr;
        g.setColor(!isSelected || selectedColor == null
                ? tabPane.getBackgroundAt(tabIndex) : selectedColor);
        switch (tabPlacement) {
            case LEFT:
                g.fillRect(x + 1, y + 1, w - 1, h - 3);
                break;
            case RIGHT:
                g.fillRect(x, y + 1, w - 2, h - 3);
                break;
            case BOTTOM:
                if (!isSelected) {
                    LinearGradientPaint lgp = new LinearGradientPaint(
                            new Point2D.Float(x, y), new Point2D.Float(x, y + h - 1),
                            enabledStops, enabledStopColors,
                            MultipleGradientPaint.CycleMethod.REPEAT);
                    g.setPaint(lgp);
                }
                g.fillRect(x + 1, y, w - 3, h - 1);
                break;
            case TOP:
            default:
                g.fillRect(x + 1, y + 1, w - 3, h - 1);
        }
    }

    @Override
    protected void paintText(Graphics g, int tabPlacement,
            Font font, FontMetrics metrics, int tabIndex,
            String title, Rectangle textRect,
            boolean isSelected) {

        g.setFont(font);

        View v = getTextViewForTab(tabIndex);
        if (v != null) {
            // html
            v.paint(g, textRect);
        } else {
            // plain text
            int mnemIndex = tabPane.getDisplayedMnemonicIndexAt(tabIndex);

            if (tabPane.isEnabled() && tabPane.isEnabledAt(tabIndex)) {
                Color fg = tabPane.getForegroundAt(tabIndex);
                if (isSelected && (fg instanceof UIResource)) {
                    Color selectedFG = PaletteLookAndFeel.getInstance().getColor(
                            "TabbedPane.selectedForeground");
                    if (selectedFG != null) {
                        fg = selectedFG;
                    }
                }
                g.setColor(fg);
                PaletteUtilities.drawStringUnderlineCharAt(tabPane, g,
                        title, mnemIndex,
                        textRect.x, textRect.y + metrics.getAscent());

            } else { // tab disabled
                g.setColor(tabPane.getBackgroundAt(tabIndex).brighter());
                PaletteUtilities.drawStringUnderlineCharAt(tabPane, g,
                        title, mnemIndex,
                        textRect.x, textRect.y + metrics.getAscent());
                g.setColor(tabPane.getBackgroundAt(tabIndex).darker());
                PaletteUtilities.drawStringUnderlineCharAt(tabPane, g,
                        title, mnemIndex,
                        textRect.x - 1, textRect.y + metrics.getAscent() - 1);

            }
        }
    }

    @Override
    protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
        int width = tabPane.getWidth();
        int height = tabPane.getHeight();
        Insets insets = tabPane.getInsets();
        Insets tabAreaInsets = getTabAreaInsets(tabPlacement);

        int x = insets.left;
        int y = insets.top;
        int w = width - insets.right - insets.left;
        int h = height - insets.top - insets.bottom;

        switch (tabPlacement) {
            case LEFT:
                x += calculateTabAreaWidth(tabPlacement, runCount, maxTabWidth);
                if (tabsOverlapBorder) {
                    x -= tabAreaInsets.right;
                }
                w -= (x - insets.left);
                break;
            case RIGHT:
                w -= calculateTabAreaWidth(tabPlacement, runCount, maxTabWidth);
                if (tabsOverlapBorder) {
                    w += tabAreaInsets.left;
                }
                break;
            case BOTTOM:
                h -= calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);
                if (tabsOverlapBorder) {
                    h += tabAreaInsets.top;
                }
                break;
            case TOP:
            default:
                y += calculateTabAreaHeight(tabPlacement, runCount, maxTabHeight);
                if (tabsOverlapBorder) {
                    y -= tabAreaInsets.bottom;
                }
                h -= (y - insets.top);
        }

        if (tabPane.getTabCount() > 0 && (contentOpaque || tabPane.isOpaque())) {
            // Fill region behind content area
            Color color = PaletteLookAndFeel.getInstance().getColor("TabbedPane.contentAreaColor");
            if (color != null) {
                g.setColor(color);
            } else if (selectedColor == null || selectedIndex == -1) {
                g.setColor(tabPane.getBackground());
            } else {
                g.setColor(selectedColor);
            }
            g.fillRect(x, y, w, h);
        }

        boolean paintBorder = tabPane.getClientProperty("Palette.TabbedPane.paintContentBorder") != Boolean.FALSE;

        if (tabPlacement == TOP || paintBorder) {
            paintContentBorderTopEdge(g, tabPlacement, selectedIndex, x, y, w, h);
        }
        if (tabPlacement == LEFT || paintBorder) {
            paintContentBorderLeftEdge(g, tabPlacement, selectedIndex, x, y, w, h);
        }
        if (tabPlacement == BOTTOM || paintBorder) {
            paintContentBorderBottomEdge(g, tabPlacement, selectedIndex, x, y, w, h);
        }
        if (tabPlacement == RIGHT || paintBorder) {
            paintContentBorderRightEdge(g, tabPlacement, selectedIndex, x, y, w, h);
        }

    }

    @Override
    protected void paintContentBorderTopEdge(Graphics g, int tabPlacement,
            int selectedIndex,
            int x, int y, int w, int h) {
        Rectangle selRect = selectedIndex < 0 ? null
                : getTabBounds(selectedIndex, calcRect);

        g.setColor(lightHighlight);

        // Draw unbroken line if tabs are not on TOP, OR
        // selected tab is not in run adjacent to content, OR
        // selected tab is not visible (SCROLL_TAB_LAYOUT)
        //
        if (tabPlacement != TOP || selectedIndex < 0
                || (selRect.y + selRect.height + 1 < y)
                || (selRect.x < x || selRect.x > x + w)) {
            g.drawLine(x, y, x + w - 2, y);
        } else {
            // Break line to show visual connection to selected tab
            g.drawLine(x, y, selRect.x - 1, y);
            if (selRect.x + selRect.width < x + w - 2) {
                g.drawLine(selRect.x + selRect.width, y,
                        x + w - 2, y);
            } else {
                g.setColor(shadow);
                g.drawLine(x + w - 2, y, x + w - 2, y);
            }
        }
    }

    @Override
    protected void paintContentBorderLeftEdge(Graphics g, int tabPlacement,
            int selectedIndex,
            int x, int y, int w, int h) {
        Rectangle selRect = selectedIndex < 0 ? null
                : getTabBounds(selectedIndex, calcRect);

        g.setColor(lightHighlight);

        // Draw unbroken line if tabs are not on LEFT, OR
        // selected tab is not in run adjacent to content, OR
        // selected tab is not visible (SCROLL_TAB_LAYOUT)
        //
        if (tabPlacement != LEFT || selectedIndex < 0
                || (selRect.x + selRect.width + 1 < x)
                || (selRect.y < y || selRect.y > y + h)) {
            g.drawLine(x, y, x, y + h - 2);
        } else {
            // Break line to show visual connection to selected tab
            g.drawLine(x, y, x, selRect.y - 1);
            if (selRect.y + selRect.height < y + h - 2) {
                g.drawLine(x, selRect.y + selRect.height,
                        x, y + h - 2);
            }
        }
    }

    @Override
    protected void paintContentBorderBottomEdge(Graphics g, int tabPlacement,
            int selectedIndex,
            int x, int y, int w, int h) {
        Rectangle selRect = selectedIndex < 0 ? null
                : getTabBounds(selectedIndex, calcRect);

        g.setColor(shadow);

        // Draw unbroken line if tabs are not on BOTTOM, OR
        // selected tab is not in run adjacent to content, OR
        // selected tab is not visible (SCROLL_TAB_LAYOUT)
        //
        if (tabPlacement != BOTTOM || selectedIndex < 0
                || (selRect.y - 1 > h)
                || (selRect.x < x || selRect.x > x + w)) {
            //g.drawLine(x + 1, y + h - 2, x + w - 1, y + h - 2);
            g.setColor(shadow);
            g.drawLine(x, y + h - 1, x + w - 1, y + h - 1);
        } else {
            // Break line to show visual connection to selected tab
            //g.drawLine(x + 1, y + h - 2, selRect.x - 1, y + h - 2);
            g.setColor(shadow);
            g.drawLine(x, y + h - 1, selRect.x , y + h - 1);
            if (selRect.x + selRect.width < x + w - 2) {
                //g.setColor(shadow);
                //g.drawLine(selRect.x + selRect.width, y+h-2, x+w-2, y+h-2);
                g.setColor(shadow);
                g.drawLine(selRect.x + selRect.width-1, y + h - 1, x + w - 1, y + h - 1);
            }
        }

    }

    @Override
    protected void paintContentBorderRightEdge(Graphics g, int tabPlacement,
            int selectedIndex,
            int x, int y, int w, int h) {
        Rectangle selRect = selectedIndex < 0 ? null
                : getTabBounds(selectedIndex, calcRect);

        g.setColor(shadow);

        // Draw unbroken line if tabs are not on RIGHT, OR
        // selected tab is not in run adjacent to content, OR
        // selected tab is not visible (SCROLL_TAB_LAYOUT)
        //
        if (tabPlacement != RIGHT || selectedIndex < 0
                || (selRect.x - 1 > w)
                || (selRect.y < y || selRect.y > y + h)) {
            g.drawLine(x + w - 2, y + 1, x + w - 2, y + h - 3);
            g.setColor(darkShadow);
            g.drawLine(x + w - 1, y, x + w - 1, y + h - 1);
        } else {
            // Break line to show visual connection to selected tab
            g.drawLine(x + w - 2, y + 1, x + w - 2, selRect.y - 1);
            g.setColor(darkShadow);
            g.drawLine(x + w - 1, y, x + w - 1, selRect.y - 1);

            if (selRect.y + selRect.height < y + h - 2) {
                g.setColor(shadow);
                g.drawLine(x + w - 2, selRect.y + selRect.height,
                        x + w - 2, y + h - 2);
                g.setColor(darkShadow);
                g.drawLine(x + w - 1, selRect.y + selRect.height,
                        x + w - 1, y + h - 2);
            }
        }
    }

    @Override
    protected int getTabLabelShiftX(int tabPlacement, int tabIndex, boolean isSelected) {
        Rectangle tabRect = rects[tabIndex];
        int nudge = 0;
        switch (tabPlacement) {
            case LEFT:
                nudge = isSelected ? -1 : 1;
                break;
            case RIGHT:
                nudge = isSelected ? 1 : -1;
                break;
            case BOTTOM:
            case TOP:
            default:
                nudge = tabRect.width % 2;
        }
        return nudge;
    }

    @Override
    protected int getTabLabelShiftY(int tabPlacement, int tabIndex, boolean isSelected) {
        Rectangle tabRect = rects[tabIndex];
        int nudge = 0;
        switch (tabPlacement) {
            case BOTTOM:
                //nudge = isSelected? 1 : -1;
                nudge = -1;
                break;
            case LEFT:
            case RIGHT:
                nudge = tabRect.height % 2;
                break;
            case TOP:
            default:
                nudge = isSelected ? -1 : 1;
        }
        return nudge;
    }

    private boolean scrollableTabLayoutEnabled() {
        return tabPane.getTabLayoutPolicy() == JTabbedPane.SCROLL_TAB_LAYOUT;
    }

    @Override
    protected LayoutManager createLayoutManager() {
        if (tabPane.getTabLayoutPolicy() == JTabbedPane.SCROLL_TAB_LAYOUT) {
            return super.createLayoutManager();
        }
        return new TabbedPaneLayout();
    }
    @Override
    protected FontMetrics getFontMetrics() {
        //Font font = tabPane.getFont();
        Font font = PaletteLookAndFeel.getInstance().getFont("TabbedPane.selectedFont");
        return tabPane.getFontMetrics(font);
    }

    protected class TabbedPaneLayout extends BasicTabbedPaneUI.TabbedPaneLayout {

        public TabbedPaneLayout() {
            PaletteTabbedPaneUI.this.super();
        }

        @Override
        protected void normalizeTabRuns(int tabPlacement, int tabCount,
                int start, int max) {
            // Only normalize the runs for top & bottom;  normalizing
            // doesn't look right for Metal's vertical tabs
            // because the last run isn't padded and it looks odd to have
            // fat tabs in the first vertical runs, but slimmer ones in the
            // last (this effect isn't noticeable for horizontal tabs).
            if (tabPlacement == TOP || tabPlacement == BOTTOM) {
                super.normalizeTabRuns(tabPlacement, tabCount, start, max);
            }
        }

        // Don't rotate runs!
        @Override
        protected void rotateTabRuns(int tabPlacement, int selectedRun) {
        }

        // Don't pad selected tab
        @Override
        protected void padSelectedTab(int tabPlacement, int selectedIndex) {
        }
    }
}
