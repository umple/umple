/*
 * @(#)MaximizeWindowAction.java
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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.View;
import org.jhotdraw.app.action.AbstractViewAction;

/**
 * Maximizes the window of the active view.
 * 
 * @author Werner Randelshofer
 * @version $Id: MaximizeWindowAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class MaximizeWindowAction extends AbstractViewAction {
    public final static String ID = "window.maximize";
    
    /** Creates a new instance. */
    public MaximizeWindowAction(Application app, @Nullable View view) {
        super(app, view);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
    }
    
    private JFrame getFrame() {
        return (JFrame) SwingUtilities.getWindowAncestor(
                getActiveView().getComponent()
                );
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        JFrame frame = getFrame();
        if (frame != null) {
            frame.setExtendedState(frame.getExtendedState() ^ Frame.MAXIMIZED_BOTH);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
