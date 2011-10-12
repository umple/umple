/*
 * @(#)ClearRecentFilesMenuAction.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.app.action.file;

import org.jhotdraw.util.*;
import java.awt.event.ActionEvent;
import java.beans.*;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.action.AbstractApplicationAction;

/**
 * Clears (empties) the Recent Files sub-menu in the File menu.
 * <p>
 * This action is called when the user selects the Clear Recent Files item in
 * the Recent Files sub-menu of the File menu. The action and the menu item
 * is automatically created by the application, when the
 * {@code ApplicationModel} provides a {@code LoadFileAction} or a
 * {@code OpenFileAction}.
 *
 *
 * @author Werner Randelshofer.
 * @version $Id: ClearRecentFilesMenuAction.java 732 2011-01-22 20:26:30Z rawcoder $
 */
public class ClearRecentFilesMenuAction extends AbstractApplicationAction {
    public final static String ID = "file.clearRecentFiles";
    
    private PropertyChangeListener applicationListener;
    
    /** Creates a new instance. */
    public ClearRecentFilesMenuAction(Application app) {
        super(app);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
        updateEnabled();
    }

    /**
     * Installs listeners on the application object.
     */
    @Override protected void installApplicationListeners(Application app) {
        super.installApplicationListeners(app);
        if (applicationListener == null) {
            applicationListener = createApplicationListener();
        }
        app.addPropertyChangeListener(applicationListener);
    }
    private PropertyChangeListener createApplicationListener() {
        return new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName() == Application.RECENT_URIS_PROPERTY) { // Strings get interned
                    updateEnabled();
                }
            }
        };
    }
    /**
     * Installs listeners on the application object.
     */
    @Override protected void uninstallApplicationListeners(Application app) {
        super.uninstallApplicationListeners(app);
        app.removePropertyChangeListener(applicationListener);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        getApplication().clearRecentURIs();
    }
    
    private void updateEnabled() {
        setEnabled(getApplication().getRecentURIs().size() > 0);
        
    }
    
}
