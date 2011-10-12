/*
 * @(#)ExportFileAction.java
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
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jhotdraw.gui.*;
import org.jhotdraw.gui.event.*;
import org.jhotdraw.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.URI;
import java.util.prefs.Preferences;
import org.jhotdraw.app.*;
import org.jhotdraw.app.action.AbstractViewAction;
import org.jhotdraw.gui.JFileURIChooser;
import org.jhotdraw.gui.URIChooser;
import org.jhotdraw.gui.filechooser.ExtensionFileFilter;
import org.jhotdraw.net.URIUtil;

/**
 * Presents a file chooser to the user and then exports the contents of the
 * active view to the chosen file.
 * <p>
 * This action requires that {@link ApplicationModel#createExportChooser}
 * creates an appropriate {@link URIChooser}.
 * <p>
 * This action is called when the user selects the Export item in the File
 * menu. The menu item is automatically created by the application.
 * <p>
 * When the {@code proposeFileName} property is set on the action, the action
 * will propose the file name without an extension in the URI chooser.
 * Otherwise, the file name will be left empty.
 * <p>
 * If you want this behavior in your application, you have to create an action
 * with this ID and put it in your {@code ApplicationModel} in method
 * {@link ApplicationModel#initApplication}. 
 * <hr>
 * <b>Features</b>
 *
 * <p><em>Allow multiple views for URI</em><br>
 * When the feature is disabled, {@code ExportFileAction} prevents exporting to an URI which
 * is opened in another view.<br>
 * See {@link org.jhotdraw.app} for a description of the feature.
 * </p>
 *
 * @author Werner Randelshofer
 * @version $Id: ExportFileAction.java 760 2011-09-09 09:12:01Z rawcoder $
 */
public class ExportFileAction extends AbstractViewAction {

    public final static String ID = "file.export";
    private Component oldFocusOwner;
    private boolean proposeFileName;

    /** Creates a new instance. */
    public ExportFileAction(Application app, @Nullable View view) {
        this(app, view, false);
    }

    public ExportFileAction(Application app, @Nullable View view, boolean proposeFileName) {
        super(app, view);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
        this.proposeFileName = proposeFileName;
    }

    /** Whether the export file action shall propose a file name or shall
     * leave the filename empty.
     * @return True if filename is proposed.
     */
    public boolean isProposeFileName() {
        return proposeFileName;
    }

    /** Whether the export file action shall propose a file name or shall
     * leave the filename empty.
     * 
     * @param newValue True if filename shall be proposed.
     */
    public void setProposeFileName(boolean newValue) {
        this.proposeFileName = newValue;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        final View view = (View) getActiveView();
        if (view.isEnabled()) {
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");

            oldFocusOwner = SwingUtilities.getWindowAncestor(view.getComponent()).getFocusOwner();
            view.setEnabled(false);
            try {
                URIChooser fileChooser = getApplication().getExportChooser(view);
                if (proposeFileName) {
                    // => try to propose file name without extension
                    URI proposedURI = view.getURI();
                    if (proposedURI != null) {
                        try {
                            URI selectedURI = fileChooser.getSelectedURI();

                            File selectedFolder;
                            if (selectedURI == null) {
                                Preferences prefs = Preferences.userNodeForPackage(getApplication().getModel().getClass());
                                try {
                                    selectedURI = new URI(//
                                            prefs.get("recentExportFile", new File(proposedURI).getParentFile().toURI().toString())//
                                            );
                                    selectedFolder = new File(selectedURI).getParentFile();
                                } catch (URISyntaxException ex) {
                                    // selectedURI is null
                                    selectedFolder = new File(proposedURI).getParentFile();
                                }
                            } else {
                                selectedFolder = new File(selectedURI).getParentFile();
                            }

                            File file = new File(selectedFolder,new File(proposedURI).getName());
                            
                            String name = file.getName();
                            int p = name.lastIndexOf('.');
                            if (p != -1) {
                                name = name.substring(0, p);
                                file = new File(selectedFolder, name);
                                proposedURI = file.toURI();
                            }
                        } catch (IllegalArgumentException e) {
                        }
                    }
                    fileChooser.setSelectedURI(proposedURI);
                }
                JSheet.showSheet(fileChooser, view.getComponent(), labels.getString("filechooser.export"), new SheetListener() {

                    @Override
                    public void optionSelected(final SheetEvent evt) {
                        if (evt.getOption() == JFileChooser.APPROVE_OPTION) {
                            URI uri = evt.getChooser().getSelectedURI();
                            if ((evt.getChooser() instanceof JFileURIChooser) && evt.getFileChooser().getFileFilter() instanceof ExtensionFileFilter) {
                                uri = ((ExtensionFileFilter) evt.getFileChooser().getFileFilter()).makeAcceptable(evt.getFileChooser().getSelectedFile()).toURI();
                            } else {
                                uri = evt.getChooser().getSelectedURI();
                            }
                            Preferences prefs = Preferences.userNodeForPackage(getApplication().getModel().getClass());
                            prefs.put("recentExportFile", uri.toString());


                            if (evt.getChooser() instanceof JFileURIChooser) {
                                exportView(view, uri, evt.getChooser());
                            } else {
                                exportView(view, uri, null);
                            }
                        } else {
                            view.setEnabled(true);
                            if (oldFocusOwner != null) {
                                oldFocusOwner.requestFocus();
                            }
                        }
                    }
                });
            } catch (Error err) {
                view.setEnabled(true);
                throw err;
            }
        }
    }

    protected void exportView(final View view, final URI uri,
            @Nullable final URIChooser chooser) {
        view.execute(new Worker() {

            @Override
            protected Object construct() throws IOException {
                view.write(uri, chooser);
                return null;
            }

            @Override
            protected void failed(Throwable value) {
                System.out.flush();
                ((Throwable) value).printStackTrace();
                // FIXME localize this error messsage
                JSheet.showMessageSheet(view.getComponent(),
                        "<html>" + UIManager.getString("OptionPane.css")
                        + "<b>Couldn't export to the file \"" + URIUtil.getName(uri) + "\".<p>"
                        + "Reason: " + value,
                        JOptionPane.ERROR_MESSAGE);
            }

            @Override
            protected void finished() {
                view.setEnabled(true);
                SwingUtilities.getWindowAncestor(view.getComponent()).toFront();
                if (oldFocusOwner != null) {
                    oldFocusOwner.requestFocus();
                }
            }
        });
    }
}
