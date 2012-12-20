/**
 * @(#)PaletteRootPaneUI.java
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
import java.io.Serializable;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.BasicRootPaneUI;

/**
 * PaletteRootPaneUI.
 *
 * @author Werner Randelshofer
 * @version $Id: PaletteRootPaneUI.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class PaletteRootPaneUI extends BasicRootPaneUI {

    private static RootPaneUI rootPaneUI = new PaletteRootPaneUI();

    public static ComponentUI createUI(JComponent c) {
        return rootPaneUI;
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        c.setLayout(new PaletteRootLayout((JRootPane) c));

    }

    /** 
     * A custom layout manager that is responsible for the layout of 
     * layeredPane, glassPane, and menuBar.
     * <p>
     * <strong>Warning:</strong>
     * Serialized objects of this class will not be compatible with
     * future Swing releases. The current serialization support is
     * appropriate for short term storage or RMI between applications running
     * the same version of Swing.  As of 1.4, support for long term storage
     * of all JavaBeans<sup><font size="-2">TM</font></sup>
     * has been added to the <code>java.beans</code> package.
     * Please see {@link java.beans.XMLEncoder}.
     */
    protected static class PaletteRootLayout implements LayoutManager2, Serializable {

        private JRootPane rootPane;

        public PaletteRootLayout(JRootPane rootPane) {
            this.rootPane = rootPane;
        }

        /**
         * Returns the amount of space the layout would like to have.
         *
         * @param parent the Container for which this layout manager
         * is being used
         * @return a Dimension object containing the layout's preferred size
         */
        @Override
        public Dimension preferredLayoutSize(Container parent) {
            Dimension rd, mbd;
            Insets i = rootPane.getInsets();
            Container contentPane = rootPane.getContentPane();
            JMenuBar menuBar = rootPane.getJMenuBar();
            if (contentPane.isVisible()) {
                rd = contentPane.getPreferredSize();
            } else {
                rd = new Dimension(0, contentPane.getPreferredSize().height);
            }
            if (menuBar != null && menuBar.isVisible()) {
                mbd = menuBar.getPreferredSize();
            } else {
                mbd = new Dimension(0, 0);
            }
            return new Dimension(Math.max(rd.width, mbd.width) + i.left + i.right,
                    rd.height + mbd.height + i.top + i.bottom);
        }

        /**
         * Returns the minimum amount of space the layout needs.
         *
         * @param parent the Container for which this layout manager
         * is being used
         * @return a Dimension object containing the layout's minimum size
         */
        public Dimension minimumLayoutSize(Container parent) {
            Dimension rd, mbd;
            Insets i = rootPane.getInsets();
            Container contentPane = rootPane.getContentPane();
            JMenuBar menuBar = rootPane.getJMenuBar();
            if (contentPane != null && contentPane.isVisible()) {
                rd = contentPane.getMinimumSize();
            } else if (contentPane != null) {
                rd = new Dimension(0, contentPane.getPreferredSize().height);
            } else {
                rd = new Dimension(0,0);
            }
            if (menuBar != null && menuBar.isVisible()) {
                mbd = menuBar.getMinimumSize();
            } else {
                mbd = new Dimension(0, 0);
            }
            return new Dimension(Math.max(rd.width, mbd.width) + i.left + i.right,
                    rd.height + mbd.height + i.top + i.bottom);
        }

        /**
         * Returns the maximum amount of space the layout can use.
         *
         * @param target the Container for which this layout manager
         * is being used
         * @return a Dimension object containing the layout's maximum size
         */
        public Dimension maximumLayoutSize(Container target) {
            Dimension rd, mbd;
            Insets i = rootPane.getInsets();
            Container contentPane = rootPane.getContentPane();
            JMenuBar menuBar = rootPane.getJMenuBar();
            if (menuBar != null && menuBar.isVisible()) {
                mbd = menuBar.getMaximumSize();
            } else {
                mbd = new Dimension(0, 0);
            }
            if (contentPane != null && contentPane.isVisible()) {
                rd = contentPane.getMaximumSize();
            } else {
                // This is silly, but should stop an overflow error
                rd = new Dimension(Integer.MAX_VALUE,
                        Integer.MAX_VALUE - i.top - i.bottom - mbd.height - 1);
            }
            return new Dimension(Math.min(rd.width, mbd.width) + i.left + i.right,
                    rd.height + mbd.height + i.top + i.bottom);
        }

        /**
         * Instructs the layout manager to perform the layout for the specified
         * container.
         *
         * @param parent the Container for which this layout manager
         * is being used
         */
        public void layoutContainer(Container parent) {
            Rectangle b = parent.getBounds();
            Insets i = rootPane.getInsets();
            JLayeredPane layeredPane = rootPane.getLayeredPane();
            Component glassPane = rootPane.getGlassPane();
            Container contentPane = rootPane.getContentPane();
            JMenuBar menuBar = rootPane.getJMenuBar();

            int contentY = 0;
            int w = b.width - i.right - i.left;
            int h = b.height - i.top - i.bottom;

            if (layeredPane != null) {
                layeredPane.setBounds(i.left, i.top, w, h);
            }
            if (glassPane != null) {
                glassPane.setBounds(i.left, i.top, w, h);
            }
            // Note: This is laying out the children in the layeredPane,
            // technically, these are not our children.
            if (menuBar != null && menuBar.isVisible()) {
                Dimension mbd = menuBar.getPreferredSize();
                menuBar.setBounds(0, 0, w, mbd.height);
                contentY += mbd.height;
            }
            if (contentPane != null) {
                contentPane.setBounds(0, contentY, w, h - contentY);
            }
        }

        public void addLayoutComponent(String name, Component comp) {
        }

        public void removeLayoutComponent(Component comp) {
        }

        public void addLayoutComponent(Component comp, Object constraints) {
        }

        public float getLayoutAlignmentX(Container target) {
            return 0.0f;
        }

        public float getLayoutAlignmentY(Container target) {
            return 0.0f;
        }

        public void invalidateLayout(Container target) {
        }
    }
}
