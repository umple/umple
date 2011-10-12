/*
 * @(#)AbstractPreferencesAction.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.app.action.app;

import org.jhotdraw.app.Application;
import org.jhotdraw.app.action.AbstractApplicationAction;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * Displays a preferences dialog for the application.
 * <p>
 * This action is called when the user selects the Preferences item in the
 * Application menu. The menu item is automatically created by the application.
 * <p>
 * If you want this behavior in your application, you have to create an action
 * with this ID and put it in your {@code ApplicationModel} in method
 * {@link org.jhotdraw.app.ApplicationModel#initApplication}.
 *
 * @author Werner Randelshofer
 * @version $Id: AbstractPreferencesAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public abstract class AbstractPreferencesAction extends AbstractApplicationAction {

    public final static String ID = "application.preferences";

    /** Creates a new instance. */
    public AbstractPreferencesAction(Application app) {
        super(app);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
    }
}
