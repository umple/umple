/*
 * @(#)SaveFileAsAction.java
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
import org.jhotdraw.util.*;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.View;

/**
 * Presents an {@code URIChooser} and then saves the active view to the
 * specified location.
 * <p>
 * This action is called when the user selects the Save As item in the File
 * menu. The menu item is automatically created by the application.
 * <p>
 * If you want this behavior in your application, you have to create it
 * and put it in your {@code ApplicationModel} in method
 * {@link org.jhotdraw.app.ApplicationModel#initApplication}.
 *
 * @author  Werner Randelshofer
 * @version $Id: SaveFileAsAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class SaveFileAsAction extends SaveFileAction {
    public final static String ID = "file.saveAs";

    /** Creates a new instance. */
    public SaveFileAsAction(Application app, @Nullable View view) {
        super(app, view, true);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
    }
}