/*
 * @(#)OpenFileAction.java
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
import org.jhotdraw.gui.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.URI;
import java.util.prefs.Preferences;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.View;
import org.jhotdraw.app.action.AbstractApplicationAction;
import org.jhotdraw.gui.URIChooser;
import org.jhotdraw.net.URIUtil;
import org.jhotdraw.util.prefs.PreferencesUtil;

/**
 * Presents an {@code URIChooser} and loads the selected URI into an
 * empty view. If no empty view is available, a new view is created.
 * <p>
 * This action is called when the user selects the Open item in the File
 * menu. The menu item is automatically created by the application.
 * A Recent Files sub-menu is also automatically generated.
 * <p>
 * If you want this behavior in your application, you have to create it
 * and put it in your {@code ApplicationModel} in method
 * {@link org.jhotdraw.app.ApplicationModel#initApplication}.
 * <p>
 * This action is designed for applications which automatically
 * create a new view for each opened file. This action goes together with
 * {@link NewFileAction}, {@link OpenDirectoryAction} and {@link CloseFileAction}.
 * This action should not be used together with {@link LoadFileAction}.
 * <hr>
 * <b>Features</b>
 *
 *<p><em>Allow multiple views per URI</em><br>
 * When the feature is disabled, {@code OpenFileAction} prevents opening an URI
 * which* is opened in another view.<br>
 * See {@link org.jhotdraw.app} for a description of the feature.
 * </p>
 *
 * <p><em>Open last URI on launch</em><br>
 * {@code OpenFileAction} supplies data for this feature by calling
 * {@link Application#addRecentURI} when it successfully opened a file.
 * See {@link org.jhotdraw.app} for a description of the feature.
 * </p>
 *
 * @author  Werner Randelshofer
 * @version $Id: OpenFileAction.java 757 2011-09-07 21:29:04Z rawcoder $
 */
public class OpenFileAction extends AbstractApplicationAction {

    public final static String ID = "file.open";

    /** Creates a new instance. */
    public OpenFileAction(Application app) {
        super(app);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
    }

    protected URIChooser getChooser(View view) {
        // Note: We pass null here, because we want the application-wide chooser
        return getApplication().getOpenChooser(null);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        final Application app = getApplication();
        if (app.isEnabled()) {
            app.setEnabled(false);
            // Search for an empty view
            View emptyView = app.getActiveView();
            if (emptyView == null
                    || !emptyView.isEmpty()
                    || !emptyView.isEnabled()) {
                emptyView = null;
            }

            final View view;
            boolean disposeView;
            if (emptyView == null) {
                view = app.createView();
                app.add(view);
                disposeView = true;
            } else {
                view = emptyView;
                disposeView = false;
            }
            URIChooser chooser = getChooser(view);
            chooser.setDialogType(JFileChooser.OPEN_DIALOG);
            if (showDialog(chooser, app.getComponent()) == JFileChooser.APPROVE_OPTION) {
                app.show(view);

                URI uri = chooser.getSelectedURI();

                // Prevent same URI from being opened more than once
                if (!getApplication().getModel().isAllowMultipleViewsPerURI()) {
                    for (View v : getApplication().getViews()) {
                        if (v.getURI() != null && v.getURI().equals(uri)) {
                            v.getComponent().requestFocus();
                            if (disposeView) {
                                app.dispose(view);
                            }
                            app.setEnabled(true);
                            return;
                        }
                    }
                }

                openViewFromURI(view, uri, chooser);
            } else {
                if (disposeView) {
                    app.dispose(view);
                }
                app.setEnabled(true);
            }
        }
    }

    protected void openViewFromURI(final View view, final URI uri, final URIChooser chooser) {
        final Application app = getApplication();
        app.setEnabled(true);
        view.setEnabled(false);

        // If there is another view with the same URI we set the multiple open
        // id of our view to max(multiple open id) + 1.
        int multipleOpenId = 1;
        for (View aView : app.views()) {
            if (aView != view
                    && aView.isEmpty()) {
                multipleOpenId = Math.max(multipleOpenId, aView.getMultipleOpenId() + 1);
            }
        }
        view.setMultipleOpenId(multipleOpenId);
        view.setEnabled(false);

        // Open the file
        view.execute(new Worker() {

            @Override
            public Object construct() throws IOException {
                boolean exists = true;
                try {
                    exists = new File(uri).exists();
                } catch (IllegalArgumentException e) {
                }
                if (exists) {
                    view.read(uri, chooser);
                    return null;
                } else {
                    ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
                    throw new IOException(labels.getFormatted("file.open.fileDoesNotExist.message", URIUtil.getName(uri)));
                }
            }

            @Override
            protected void done(Object value) {
                final Application app = getApplication();
                view.setURI(uri);
                view.setEnabled(true);
                Frame w = (Frame) SwingUtilities.getWindowAncestor(view.getComponent());
                if (w != null) {
                    w.setExtendedState(w.getExtendedState() & ~Frame.ICONIFIED);
                    w.toFront();
                }
                view.getComponent().requestFocus();
                app.addRecentURI(uri);
                app.setEnabled(true);
            }

            @Override
            protected void failed(Throwable value) {
                value.printStackTrace();
                view.setEnabled(true);
                app.setEnabled(true);
                String message = value.getMessage() != null ? value.getMessage() : value.toString();
                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
                JSheet.showMessageSheet(view.getComponent(),
                        "<html>" + UIManager.getString("OptionPane.css")
                        + "<b>" + labels.getFormatted("file.open.couldntOpen.message", URIUtil.getName(uri)) + "</b><p>"
                        + ((message == null) ? "" : message),
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    /** We implement JFileChooser.showDialog by ourselves, so that we can center
     * dialogs properly on screen on Mac OS X.
     */
    public int showDialog(URIChooser chooser, Component parent) {
        final Component finalParent = parent;
        final int[] returnValue = new int[1];
        final JDialog dialog = createDialog(chooser, finalParent);
        dialog.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                returnValue[0] = JFileChooser.CANCEL_OPTION;
            }
        });
        chooser.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("CancelSelection")) {
                    returnValue[0] = JFileChooser.CANCEL_OPTION;
                    dialog.setVisible(false);
                } else if (e.getActionCommand().equals("ApproveSelection")) {
                    returnValue[0] = JFileChooser.APPROVE_OPTION;
                    dialog.setVisible(false);
                }
            }
        });
        returnValue[0] = JFileChooser.ERROR_OPTION;
        chooser.rescanCurrentDirectory();

        dialog.setVisible(true);
        //chooser.firePropertyChange("JFileChooserDialogIsClosingProperty", dialog, null);
        dialog.removeAll();
        dialog.dispose();
        return returnValue[0];
    }

    /** We implement JFileChooser.showDialog by ourselves, so that we can center
     * dialogs properly on screen on Mac OS X.
     */
    protected JDialog createDialog(URIChooser chooser, Component parent) throws HeadlessException {
        String title = chooser.getDialogTitle();
        if (chooser instanceof JFileChooser) {
            ((JFileChooser) chooser).getAccessibleContext().setAccessibleDescription(title);
        }

        JDialog dialog;
        Window window = (parent == null || (parent instanceof Window)) ? (Window) parent : SwingUtilities.getWindowAncestor(parent);
        dialog = new JDialog(window, title, Dialog.ModalityType.APPLICATION_MODAL);

        dialog.setComponentOrientation(chooser.getComponent().getComponentOrientation());

        Container contentPane = dialog.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(chooser.getComponent(), BorderLayout.CENTER);

        if (JDialog.isDefaultLookAndFeelDecorated()) {
            boolean supportsWindowDecorations =
                    UIManager.getLookAndFeel().getSupportsWindowDecorations();
            if (supportsWindowDecorations) {
                dialog.getRootPane().setWindowDecorationStyle(JRootPane.FILE_CHOOSER_DIALOG);
            }
        }
        //dialog.pack();
        Preferences prefs = PreferencesUtil.userNodeForPackage(getApplication().getModel().getClass());

        PreferencesUtil.installFramePrefsHandler(prefs, "openChooser", dialog);
        /*
        if (window.getBounds().isEmpty()) {
        Rectangle screenBounds = window.getGraphicsConfiguration().getBounds();
        dialog.setLocation(screenBounds.x + (screenBounds.width - dialog.getWidth()) / 2, //
        screenBounds.y + (screenBounds.height - dialog.getHeight()) / 3);
        } else {
        dialog.setLocationRelativeTo(parent);
        }*/

        return dialog;
    }
}
