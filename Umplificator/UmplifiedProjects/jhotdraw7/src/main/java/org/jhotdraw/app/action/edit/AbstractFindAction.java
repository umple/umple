/*
 * @(#)AbstractFindAction.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.app.action.edit;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.app.*;
import org.jhotdraw.app.action.AbstractViewAction;
import org.jhotdraw.util.*;

/**
 * Presents a find dialog to the user and then highlights the found items
 * in the active view.
 * <p>
 * This action is called when the user selects the Find item in the Edit
 * menu. The menu item is automatically created by the application.
 * <p>
 * If you want this behavior in your application, you have to create an action
 * with this ID and put it in your {@code ApplicationModel} in method
 * {@link ApplicationModel#initApplication}.
 *
 * @author Werner Randelshofer
 * @version $Id: AbstractFindAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public abstract class AbstractFindAction extends AbstractViewAction {
    public final static String ID = "edit.find";
    
    /** Creates a new instance. */
    public AbstractFindAction(Application app, @Nullable View view) {
        super(app, view);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
    }    
}
