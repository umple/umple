/*
 * @(#)ClearFileAction.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.app.action.file;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.gui.Worker;
import org.jhotdraw.util.*;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.View;
import org.jhotdraw.app.action.AbstractSaveUnsavedChangesAction;

/**
 * Clears (empties) the contents of the active view.
 * <p>
 * This action is called when the user selects the Clear item in the File
 * menu. The menu item is automatically created by the application.
 * <p>
 * If you want this behavior in your application, you have to create it
 * and put it in your {@code ApplicationModel} in method
 * {@link org.jhotdraw.app.ApplicationModel#initApplication}.
 * <p>
 * This action is designed for applications which do not automatically
 * create a new view for each opened file. This action goes together with
 * {@link NewWindowAction}, {@link LoadFileAction}, {@link LoadDirectoryAction}
 * and {@link CloseFileAction}.
 * This action should not be used together with {@code NewFileAction}.
 *
 * @author Werner Randelshofer
 * @version $Id: ClearFileAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ClearFileAction extends AbstractSaveUnsavedChangesAction {
    public final static String ID = "file.clear";
    
    /** Creates a new instance. */
    public ClearFileAction(Application app, @Nullable View view) {
        super(app, view);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, "file.clear");
    }
    
    @Override public void doIt(final View view) {
        view.setEnabled(false);
        view.execute(new Worker() {
            @Override
            public Object construct() {
                view.clear();
                return null;
            }
            @Override
            public void finished() {
                view.setEnabled(true);
            }
        });
    }
}
