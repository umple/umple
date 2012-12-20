/*
 * @(#)ActionUtil.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.app.action;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;

/**
 * Provides constants and static operations on <code>Action</code> objects.
 *
 * @author Werner Randelshofer
 * @version $Id: ActionUtil.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ActionUtil {
    /**
     * Key for the selected state of an action.
     * The value must be a Boolean.
     */
    public final static String SELECTED_KEY = Action.SELECTED_KEY;
    /**
     * All actions with equal value are put into the
     * same submenu.
     * The value must be a String or an array of Strings.
     * Each element of the array represents a menu.
     */
    public final static String SUBMENU_KEY = "submenu";
    /**
     * All actions with equal value are created as
     * a radio button and put into the same group.
     * The value must be an object.
     */
    public final static String BUTTON_GROUP_KEY = "buttonGroup";
    /**
     * UndoableEdit presentation name key.
     *
     * @see javax.swing.undo.UndoableEdit#getPresentationName
     */
    public final static String UNDO_PRESENTATION_NAME_KEY = "undoPresentationName";
    
    /** Prevent instance creation. */
    private ActionUtil() {
    }
    
    /**
     * Configures a JCheckBoxMenuItem for an Action.
     */
    public static void configureJCheckBoxMenuItem(final JCheckBoxMenuItem mi, final Action a) {
        /*mi.setSelected((Boolean) a.getValue(ActionUtil.SELECTED_KEY));
        PropertyChangeListener propertyHandler = new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals(ActionUtil.SELECTED_KEY)) {
                    mi.setSelected((Boolean) a.getValue(ActionUtil.SELECTED_KEY));
                }
            }
        };
        a.addPropertyChangeListener(propertyHandler);
        mi.putClientProperty("actionPropertyHandler", propertyHandler);
        */
        mi.setAction(a);
    }
    
    /**
     * Unconfigures a JCheckBoxMenuItem for an Action.
     */
    public static void unconfigureJCheckBoxMenuItem(JCheckBoxMenuItem mi, Action a) {
        /*PropertyChangeListener propertyHandler = (PropertyChangeListener) mi.getClientProperty("actionPropertyHandler");
        if (propertyHandler != null) {
            a.removePropertyChangeListener(propertyHandler);
        mi.putClientProperty("actionPropertyHandler", null);
        }*/
        mi.setAction(null);
    }
}