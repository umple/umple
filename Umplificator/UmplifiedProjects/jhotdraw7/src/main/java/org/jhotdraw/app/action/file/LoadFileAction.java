/*
 * @(#)LoadFileAction.java
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
import java.awt.Component;
import java.awt.Window;
import org.jhotdraw.util.*;
import org.jhotdraw.gui.*;
import org.jhotdraw.gui.event.*;
import javax.swing.*;
import java.io.*;
import java.net.URI;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.View;
import org.jhotdraw.app.action.AbstractSaveUnsavedChangesAction;
import org.jhotdraw.gui.URIChooser;
import org.jhotdraw.gui.filechooser.ExtensionFileFilter;
import org.jhotdraw.net.URIUtil;

/**
 * Lets the user save unsaved changes of the active view, then presents
 * an {@code URIChooser} and loads the selected URI into the active view.
 * <p>
 * This action is called when the user selects the Load item in the File
 * menu. The menu item is automatically created by the application.
 * A Recent Files sub-menu is also automatically generated.
 * <p>
 * If you want this behavior in your application, you have to create it
 * and put it in your {@code ApplicationModel} in method
 * {@link org.jhotdraw.app.ApplicationModel#initApplication}.
 * <p>
 * This action is designed for applications which do not automatically
 * create a new view for each opened file. This action goes together with
 * {@link ClearFileAction}, {@link NewWindowAction}, {@link LoadFileAction},
 * {@link LoadDirectoryAction} and {@link CloseFileAction}.
 * This action should not be used together with {@link OpenFileAction}.
 *
 * <hr>
 * <b>Features</b>
 *
 * <p><em>Open last URI on launch</em><br>
 * When the application is started, the last opened URI is opened in a view.<br>
 * {@code LoadFileAction} supplies data for this feature by calling
 * {@link Application#addRecentURI} when it successfully loaded a file.
 * See {@link org.jhotdraw.app} for a description of the feature.
 * </p>
 *
 * <p><em>Allow multiple views per URI</em><br>
 * When the feature is disabled, {@code LoadFileAction} prevents exporting to an URI which
 * is opened in another view.<br>
 * See {@link org.jhotdraw.app} for a description of the feature.
 * </p>
 *
 * @author  Werner Randelshofer
 * @version $Id: LoadFileAction.java 753 2011-09-01 09:02:46Z rawcoder $
 */
public class LoadFileAction extends AbstractSaveUnsavedChangesAction {

    public final static String ID = "file.load";

    /** Creates a new instance. */
    public LoadFileAction(Application app, @Nullable View view) {
        super(app, view);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
    }

    @Override
    protected URIChooser getChooser(View view) {
        URIChooser chsr = (URIChooser) (view.getComponent()).getClientProperty("loadChooser");
        if (chsr == null) {
            chsr = getApplication().getModel().createOpenChooser(getApplication(), view);
            view.getComponent().putClientProperty("loadChooser", chsr);
        }
        return chsr;
    }

    @Override
    public void doIt(final View view) {
        URIChooser fileChooser = getChooser(view);
        Window wAncestor = SwingUtilities.getWindowAncestor(view.getComponent());
        final Component oldFocusOwner = (wAncestor == null) ? null : wAncestor.getFocusOwner();

        JSheet.showOpenSheet(fileChooser, view.getComponent(), new SheetListener() {

            @Override
            public void optionSelected(final SheetEvent evt) {
                if (evt.getOption() == JFileChooser.APPROVE_OPTION) {
                    final URI uri;
                    if ((evt.getChooser() instanceof JFileURIChooser) && evt.getFileChooser().getFileFilter() instanceof ExtensionFileFilter) {
                        uri = ((ExtensionFileFilter) evt.getFileChooser().getFileFilter()).makeAcceptable(evt.getFileChooser().getSelectedFile()).toURI();
                    } else {
                        uri = evt.getChooser().getSelectedURI();
                    }

                    // Prevent same URI from being opened more than once
                    if (!getApplication().getModel().isAllowMultipleViewsPerURI()) {
                        for (View v : getApplication().getViews()) {
                            if (v != view && v.getURI() != null && v.getURI().equals(uri)) {
                                v.getComponent().requestFocus();
                                return;
                            }
                        }
                    }

                    loadViewFromURI(view, uri, evt.getChooser());
                } else {
                    view.setEnabled(true);
                    if (oldFocusOwner != null) {
                        oldFocusOwner.requestFocus();
                    }
                }
            }
        });
    }

    public void loadViewFromURI(final View view, final URI uri, final URIChooser chooser) {
        view.setEnabled(false);

        // Open the file
        view.execute(new Worker() {

            @Override
            protected Object construct() throws IOException {
                view.read(uri, chooser);
                return null;
            }

            @Override
            protected void done(Object value) {
                view.setURI(uri);
                view.setEnabled(true);
                getApplication().addRecentURI(uri);
            }

            @Override
            protected void failed(Throwable value) {
                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
                JSheet.showMessageSheet(view.getComponent(),
                        "<html>" + UIManager.getString("OptionPane.css")
                        + "<b>" + labels.getFormatted("file.load.couldntLoad.message", URIUtil.getName(uri)) + "</b><p>"
                        + ((value == null) ? "" : value),
                        JOptionPane.ERROR_MESSAGE, new SheetListener() {

                    @Override
                    public void optionSelected(SheetEvent evt) {
                        view.clear();
                        view.setEnabled(true);
                    }
                });
            }
        });
    }
}
