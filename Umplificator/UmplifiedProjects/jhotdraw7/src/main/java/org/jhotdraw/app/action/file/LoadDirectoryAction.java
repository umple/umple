/*
 * @(#)LoadDirectoryAction.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.app.action.file;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.app.*;
import org.jhotdraw.gui.URIChooser;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * Les the user save unsaved changes of the active view, then presents
 * an {@code URIChooser} and then loads the selected URI into the active view.
 * <p>
 * This action is called when the user selects the Load Directory item in the File
 * menu. The menu item is automatically created by the application.
 * <p>
 * This action is designed for applications which do not automatically
 * create a new view for each opened file. This action goes together with
 * {@code ClearFileAction}, {@code NewWindowAction}, {@code LoadFileAction},
 * {@code LoadDirectoryAction} and {@code CloseFileAction}.
 * This action should not be used together with {@code OpenDirectoryAction}.
 *
 * @author Werner Randelshofer, Hausmatt 10, CH-6405 Immensee
 * @version $Id: LoadDirectoryAction.java 723 2010-12-28 14:31:24Z rawcoder $
 */
public class LoadDirectoryAction extends LoadFileAction {
    public final static String ID = "file.loadDirectory";

    /** Creates a new instance. */
    public LoadDirectoryAction(Application app, @Nullable View view) {
        super(app, view);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
    }
    @Override
    protected URIChooser getChooser(View view) {
        return getApplication().getModel().createOpenDirectoryChooser(getApplication(), view);
    }
}
