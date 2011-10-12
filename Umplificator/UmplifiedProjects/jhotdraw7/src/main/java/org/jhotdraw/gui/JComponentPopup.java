/*
 * @(#)JComponentPopup.java
 * 
 * Copyright (c) 2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui;

import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.security.AccessControlException;
import javax.swing.JLayeredPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

/**
 * This is an extension of the Swing {@code JPopupMenu} which can be used to
 * display a {@code JComponent} in a popup menu.
 * <p>
 * Unlike {@code JPopupMenu}, the popup will stay open if the {@code JComponent}
 * opens a popup menu of its own.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public class JComponentPopup extends JPopupMenu {

    /** Wether we are permitted to listen on AWT events. */
    private boolean isAWTEventListenerPermitted = true;

    private class Handler implements AWTEventListener {

        @Override
        public void eventDispatched(AWTEvent ev) {
            if (!(ev instanceof MouseEvent) || !(ev.getSource() instanceof Component)) {
                // We are interested in MouseEvents only
                return;
            }
            MouseEvent me = (MouseEvent) ev;
            Component src = (Component) ev.getSource();
            Component invoker = JComponentPopup.this.getInvoker();

            if (ev.getID() == MouseEvent.MOUSE_PRESSED) {
                // Close popup if the mouse press occured on a component which is
                // not descending from this popup menu, but has the same
                // window ancestor.
                if (!SwingUtilities.isDescendingFrom(src, JComponentPopup.this)
                        && SwingUtilities.getWindowAncestor(src)
                        == SwingUtilities.getWindowAncestor(invoker)) {
                    JLayeredPane srcLP = (JLayeredPane) SwingUtilities.getAncestorOfClass(JLayeredPane.class, src);
                    Component srcLPChild = src;
                    while (srcLPChild.getParent() != srcLP) {
                        srcLPChild = srcLPChild.getParent();
                    }
                    if (srcLP.getLayer(srcLPChild) < JLayeredPane.POPUP_LAYER) {
                        JComponentPopup.this.setVisible(false);
                    }
                }
            } else if (ev.getID() == MouseEvent.MOUSE_CLICKED) {
                // Close popup if a double click occured on the popup component.
                if (me.getClickCount() == 2
                        && SwingUtilities.isDescendingFrom(src, JComponentPopup.this)) {
                    JComponentPopup.this.setVisible(false);
                }
            }
        }
    };
    private Handler handler = new Handler();

    public JComponentPopup() {
        setLightWeightPopupEnabled(false);


    }

    @Override
    public void menuSelectionChanged(boolean isIncluded) {
        if (isAWTEventListenerPermitted) {
            // Don't let the MenuSelectionManager hide this popup.
            return;
        } else {
            // Since we are not allowed to use an AWTEventListener we
            // grab the current AWT Event ourselves (hoping that this method
            // invocation is associated to it) and try to decide whether
            // we want to close the popup.
            //
            // This will prevent undesired closing of the popup component when
            // a combo box is opened on the popup component.
            // After this happened though, menuSelectionChanged is not invoked
            // anymore and we lose the ability to close the popup component.
            AWTEvent evt = EventQueue.getCurrentEvent();
            if (evt != null && evt.getSource() instanceof Component) {
                Component src = (Component) evt.getSource();
                Component invoker = getInvoker();
                if (!SwingUtilities.isDescendingFrom(src, JComponentPopup.this)
                        && SwingUtilities.getWindowAncestor(src)
                        == SwingUtilities.getWindowAncestor(invoker)) {
                    JLayeredPane srcLP = (JLayeredPane) SwingUtilities.getAncestorOfClass(JLayeredPane.class, src);
                    Component srcLPChild = src;
                    while (srcLPChild.getParent() != srcLP) {
                        srcLPChild = srcLPChild.getParent();
                    }
                    if (srcLP.getLayer(srcLPChild) < JLayeredPane.POPUP_LAYER) {
                        JComponentPopup.this.setVisible(false);
                    }
                }
            } else {
                super.menuSelectionChanged(isIncluded);
            }
        }
    }

    @Override
    public void setVisible(boolean newValue) {
        // Attach/detach AWTEventListener on "visible" property change.
        if (isVisible() != newValue) {
            if (isAWTEventListenerPermitted) {
                try {
                    if (newValue) {
                        Toolkit.getDefaultToolkit().addAWTEventListener(handler, AWTEvent.MOUSE_EVENT_MASK);
                    } else {
                        Toolkit.getDefaultToolkit().removeAWTEventListener(handler);
                    }
                } catch (AccessControlException e) {
                    // Unsigned Applets are not allowed to use an AWTEventListener.
                    isAWTEventListenerPermitted = false;
                }
            }
            super.setVisible(newValue);

        }
    }
}
