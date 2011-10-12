/*
 * @(#)OpenDirectoryAction.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.app.action.file;

import javax.swing.JFileChooser;
import org.jhotdraw.app.*;
import org.jhotdraw.gui.URIChooser;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * Presents an {@code URIChooser} for selecting a directory and loads the
 * selected URI into an empty view. If no empty view is available, a new view is
 * created.
 * <p>
 * This action is called when the user selects the Open Directory item in the
 * File menu. The menu item is automatically created by the application.
 * <p>
 * If you want this behavior in your application, you have to create it
 * and put it in your {@code ApplicationModel} in method
 * {@link ApplicationModel#initApplication}.
 * <p>
 * This action is designed for applications which automatically
 * create a new view for each opened file. This action goes together with
 * {@link NewFileAction}, {@link OpenFileAction} and {@link CloseFileAction}.
 * This action should not be used together with {@link LoadFileAction}.
 *
 * @author Werner Randelshofer, Hausmatt 10, CH-6405 Immensee
 * @version $Id: OpenDirectoryAction.java 723 2010-12-28 14:31:24Z rawcoder $
 */
public class OpenDirectoryAction extends OpenFileAction {
    public final static String ID = "file.openDirectory";

    /** Creates a new instance. */
    public OpenDirectoryAction(Application app) {
        super(app);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
    }
    @Override
    protected URIChooser getChooser(View view) {
        return getApplication().getModel().createOpenDirectoryChooser(getApplication(), view);
    }
}
