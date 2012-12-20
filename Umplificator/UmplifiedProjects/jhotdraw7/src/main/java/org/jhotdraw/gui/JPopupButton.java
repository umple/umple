/*
 * @(#)JPopupButton.java
 *
 * Copyright (c) 2006-2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui;

import javax.swing.event.PopupMenuEvent;
import org.jhotdraw.gui.plaf.palette.PaletteMenuItemUI;
import java.awt.*;
import java.beans.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.PopupMenuListener;

/**
 * JPopupButton provides a popup menu.
 *
 * @author  Werner Randelshofer
 * @version $Id: JPopupButton.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class JPopupButton extends javax.swing.JButton {

    public final static String CLOSE_AUTOMATICALLY_PROPERTY = "closeAutomatically";
    public final static String COLUMN_COUNT_PROPERTY = "columnCount";
    public final static String ITEM_FONT_PROPERTY = "itemFont";
    private JPopupMenu popupMenu;
    private int columnCount = 1;
    private Action action;
    private Rectangle actionArea;
    private Font itemFont;
    public final static Font ITEM_FONT = new Font("Dialog", Font.PLAIN, 10);
    private int popupAnchor = SwingConstants.SOUTH_WEST;
    /** The time when the popup became invisible. */
    private long popupBecameInvisible;
    /** Whether the popup menu closes automatically, when another popup menu
     * is opened.
     */
    private boolean isCloseAutomatically;

    private class Handler implements PropertyChangeListener, PopupMenuListener, AWTEventListener {
        // Property change listener

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals("enabled")) {
                setEnabled(((Boolean) evt.getNewValue()).booleanValue());
            } else {
                repaint();
            }
        }

        // Popup menu listener
        @Override
        public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            //
        }

        @Override
        public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
            popupBecameInvisible = System.currentTimeMillis();
        }

        @Override
        public void popupMenuCanceled(PopupMenuEvent e) {
        }

        // AWT event listener
        @Override
        public void eventDispatched(AWTEvent ev) {
            if (!(ev instanceof MouseEvent) || !(ev.getSource() instanceof Component)) {
                // We are interested in MouseEvents only
                return;
            }
            Component src = (Component) ev.getSource();

            // Close popup only on mouse press on a component which has
            // the same window ancestor as our popup, but is not in the
            // popup layer of the window.
            if (ev.getID() == MouseEvent.MOUSE_PRESSED) {
                if (SwingUtilities.getWindowAncestor(src)
                        == SwingUtilities.getWindowAncestor(JPopupButton.this)) {
                    JLayeredPane srcLP = (JLayeredPane) SwingUtilities.getAncestorOfClass(JLayeredPane.class, src);
                    Component srcLPChild = src;
                    while (srcLPChild.getParent() != srcLP) {
                        srcLPChild = srcLPChild.getParent();
                    }
                    if (srcLP.getLayer(srcLPChild) < JLayeredPane.POPUP_LAYER) {
                        popupMenu.setVisible(false);
                    }
                }
            } else {
            }
        }
    };
    private Handler handler = new Handler();

    /** Creates new form JToolBarMenu */
    public JPopupButton() {
        initComponents();
        setFocusable(false);
        itemFont = ITEM_FONT;
    }

    /** Sets the font used for popup menu items. */
    public void setItemFont(Font newValue) {
        Font oldValue = itemFont;
        itemFont = newValue;
        if (popupMenu != null) {
            updateItemFont(popupMenu);
        }
        firePropertyChange(ITEM_FONT_PROPERTY, oldValue, newValue);
    }

    /** Updates the font of the popup menu. */
    private void updateItemFont(MenuElement menu) {
        menu.getComponent().setFont(itemFont);
        for (MenuElement child : menu.getSubElements()) {
            updateItemFont(child);
        }
    }

    /** Sets an action which is invoked when the user clicks on the
     * specified click area.
     *
     * @param action An action.
     * @param actionClickArea The click area.
     */
    public void setAction(Action action, Rectangle actionClickArea) {
        if (this.action != null) {
            this.action.removePropertyChangeListener(handler);
        }

        this.action = action;
        this.actionArea = actionClickArea;

        if (action != null) {
            action.addPropertyChangeListener(handler);
        }
    }

    /** Returns the number of columns of the popup menu. */
    public int getColumnCount() {
        return columnCount;
    }

    /** Sets the number of columns of the popup menu. */
    public void setColumnCount(int newValue, boolean isVertical) {
        int oldValue = columnCount;
        columnCount = newValue;
        getPopupMenu().setLayout(new VerticalGridLayout(0, getColumnCount(), isVertical));
        firePropertyChange(COLUMN_COUNT_PROPERTY, oldValue, newValue);
    }

    /** Adds an {@code Action} to the popup menu.
     * <p>
     * The {@code Action} is represented by a {@code JMenuItem}.
     */
    public AbstractButton add(Action action) {
        JMenuItem item = getPopupMenu().add(action);
        if (getColumnCount() > 1) {
            item.setUI(new PaletteMenuItemUI());
        }
        item.setFont(itemFont);
        return item;
    }

    /** Adds a sub-menu to the popup menu. */
    public void add(JMenu submenu) {
        updateItemFont(submenu);
    }

    /** Adds a {@code JComponent} to the popup menu.
     * <p>
     * If the component can open popup menus of its own, for example
     * if contains combo boxes, then you should set {@link JComponentPopup}
     * as the popup menu before adding the component to this popup button.
     * This will prevent the popup menu from closing automatically.
     * <p>
     * Example:
     * <pre>
     * JPopupButton pb=new JPopupButton();
     * pb.setPopupMenu(new JComponentPopup());
     * pb.add(a component);
     * </pre>
     */
    public void add(JComponent submenu) {
        getPopupMenu().add(submenu);
    }

    /** Adds a menu item to the popup menu. */
    public void add(JMenuItem item) {
        getPopupMenu().add(item);
        item.setFont(itemFont);
    }

    /** Adds a separator to the popup menu. */
    public void addSeparator() {
        getPopupMenu().addSeparator();
    }

    /** Removes all items from the popup menu. */
    @Override
    public void removeAll() {
        getPopupMenu().removeAll();
    }

    public void setPopupMenu(JPopupMenu popupMenu) {
        if (this.popupMenu != null) {
            popupMenu.removePopupMenuListener(handler);
        }
        this.popupMenu = popupMenu;
        if (this.popupMenu != null) {
            popupMenu.addPopupMenuListener(handler);
        }
    }

    public JPopupMenu getPopupMenu() {
        if (popupMenu == null) {
            popupMenu = new JPopupMenu();
            popupMenu.setLayout(new VerticalGridLayout(0, getColumnCount()));
            popupMenu.addPopupMenuListener(handler);
            popupMenu.setLightWeightPopupEnabled(false);
        }
        return popupMenu;
    }

    public void setPopupAlpha(float newValue) {
        float oldValue = getPopupAlpha();
        getPopupMenu().putClientProperty("Quaqua.PopupMenu.windowAlpha", newValue);
        firePropertyChange("popupAlpha", oldValue, newValue);
    }

    public float getPopupAlpha() {
        Float value = (Float) getPopupMenu().getClientProperty("Quaqua.PopupMenu.windowAlpha");
        return (value == null) ? 0.948f : value.floatValue();
    }

    /**
     * Gets the popup anchor.
     * 
     * @return SwingConstants.SOUTH_WEST or SOUTH_EAST.
     */
    public int getPopupAnchor() {
        return popupAnchor;
    }

    /**
     * Sets the popup anchor.
     * <p>
     * <ul>
     * <li>SOUTH_WEST places the popup below the button and aligns it with its 
     * left bound.</li>
     * <li>SOUTH_EAST places the popup below the button and aligns it with its 
     * right bound.</li>
     * </ul> 
     * 
     * @param newValue SwingConstants.SOUTH_WEST or SOUTH_EAST.
     */
    public void setPopupAnchor(int newValue) {
        popupAnchor = newValue;
    }

    protected void togglePopup(java.awt.event.MouseEvent evt) {
        if (popupMenu != null && popupMenu.isShowing() || popupBecameInvisible >= evt.getWhen()) {
            popupMenu.setVisible(false);
        } else {
            showPopup(evt);
        }
    }

    protected void showPopup(java.awt.event.MouseEvent evt) {
        // Add your handling code here:
        if (popupMenu != null
                && (actionArea == null
                || !actionArea.contains(evt.getX() - getInsets().left, evt.getY() - getInsets().top))) {
            int x, y;

            switch (popupAnchor) {
                case SOUTH_EAST:
                    x = getWidth() - popupMenu.getPreferredSize().width;
                    ;
                    y = getHeight();
                    break;
                case SOUTH_WEST:
                default:
                    x = 0;
                    y = getHeight();
                    break;
            }
            if (getParent() instanceof JToolBar) {
                JToolBar toolbar = (JToolBar) getParent();
                if (toolbar.getOrientation() == JToolBar.VERTICAL) {
                    y = 0;
                    if (toolbar.getX() > toolbar.getParent().getInsets().left) {
                        x = -popupMenu.getPreferredSize().width;
                    } else {
                        x = getWidth();
                    }
                } else {
                    if (toolbar.getY() > toolbar.getParent().getInsets().top) {
                        y = -popupMenu.getPreferredSize().height;
                    }
                }
            }

            popupMenu.show(this, x, y);
            popupMenu.repaint();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                handleMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                performAction(evt);
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void performAction(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_performAction
        // Add your handling code here:
        if (actionArea != null && actionArea.contains(evt.getX() - getInsets().left, evt.getY() - getInsets().top)) {
            action.actionPerformed(
                    new ActionEvent(this,
                    ActionEvent.ACTION_PERFORMED,
                    null,
                    evt.getWhen(),
                    evt.getModifiers()));

        }
    }//GEN-LAST:event_performAction

    private void handleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_handleMousePressed
        togglePopup(evt);

}//GEN-LAST:event_handleMousePressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
