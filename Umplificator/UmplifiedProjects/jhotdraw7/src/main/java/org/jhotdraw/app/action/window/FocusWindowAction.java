/*
 * @(#)FocusWindowAction.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.app.action.window;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.util.*;
import java.beans.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URI;
import org.jhotdraw.app.View;
import org.jhotdraw.net.URIUtil;

/**
 * Requests focus for a Frame.
 *
 * @author  Werner Randelshofer
 * @version $Id: FocusWindowAction.java 722 2010-11-26 08:49:25Z rawcoder $
 */
public class FocusWindowAction extends AbstractAction {

    public final static String ID = "window.focus";
    @Nullable private View view;
    private PropertyChangeListener ppc;

    /** Creates a new instance. */
    public FocusWindowAction(@Nullable View view) {
        this.view = view;
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
        //setEnabled(false);
        setEnabled(view != null);

        ppc = new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                String name = evt.getPropertyName();
                if (name.equals(View.TITLE_PROPERTY)) {
                    putValue(Action.NAME, evt.getNewValue());
                }
            }
        };
        if (view != null) {
            view.addPropertyChangeListener(ppc);
        }
    }

    public void dispose() {
        setView(null);
    }

    public void setView(@Nullable View newValue) {
        if (view != null) {
            view.removePropertyChangeListener(ppc);
        }
        view = newValue;
        if (view != null) {
            view.addPropertyChangeListener(ppc);
        }
    }

    @Override
    public Object getValue(String key) {
        if (key == Action.NAME && view != null) {
            return getTitle();
        } else {
            return super.getValue(key);
        }
    }

    private String getTitle() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        String title = labels.getString("unnamedFile");
        if (view != null) {
            URI uri = view.getURI();
            if (uri == null) {
                title = labels.getString("unnamedFile");
            } else {
                title = URIUtil.getName(uri);
            }
            if (view.hasUnsavedChanges()) {
                title += "*";
            }
            title = (labels.getFormatted("internalFrame.title", title,
                    view.getApplication() == null?"":view.getApplication().getName(), view.getMultipleOpenId()));
        }
        return title;

    }

    private JFrame getFrame() {
        return (JFrame) SwingUtilities.getWindowAncestor(
                view.getComponent());
    }

    private Component getRootPaneContainer() {
        return SwingUtilities.getRootPane(
                view.getComponent()).getParent();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        /*
        JFrame frame = getFrame();
        if (frame != null) {
        frame.setExtendedState(frame.getExtendedState() & ~Frame.ICONIFIED);
        frame.toFront();
        frame.requestFocus();
        JRootPane rp = SwingUtilities.getRootPane(view.getComponent());
        if (rp != null && (rp.getParent() instanceof JInternalFrame)) {
        ((JInternalFrame) rp.getParent()).toFront();
        }
        view.getComponent().requestFocus();
        } else {
        Toolkit.getDefaultToolkit().beep();
        }*/
        Component rpContainer = getRootPaneContainer();
        if (rpContainer instanceof Frame) {
            Frame frame = (Frame) rpContainer;
            frame.setExtendedState(frame.getExtendedState() & ~Frame.ICONIFIED);
            frame.toFront();
        } else if (rpContainer instanceof JInternalFrame) {
            JInternalFrame frame = (JInternalFrame) rpContainer;
            frame.toFront();
            try {
                frame.setSelected(true);
            } catch (PropertyVetoException e) {
                // Don't care.
            }
        }
        view.getComponent().requestFocusInWindow();
    }
}
