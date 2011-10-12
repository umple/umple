/*
 * @(#)ToggleLineWrapAction.java
 *
 * Copyright (c) 2005 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.teddy.action;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.app.*;
import org.jhotdraw.app.action.*;
import org.jhotdraw.samples.teddy.*;
import org.jhotdraw.util.*;
import java.awt.event.*;
import javax.swing.Action;

/**
 * ToggleLineWrapAction.
 *
 * @author  Werner Randelshofer
 * @version $Id: ToggleLineWrapAction.java 723 2010-12-28 14:31:24Z rawcoder $
 */
public class ToggleLineWrapAction extends AbstractViewAction {
    public final static String ID = "view.toggleLineWrap";
    private ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.teddy.Labels");
    
    /**
     * Creates a new instance.
     */
    public ToggleLineWrapAction(Application app, @Nullable View view) {
        super(app, view);
        labels.configureAction(this, ID);
        setPropertyName("lineWrap");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        getActiveView().setLineWrap(! getActiveView().isLineWrap());
    }
    
    @Override
    public TeddyView getActiveView() {
        return (TeddyView) super.getActiveView();
    }
    
    @Override
    protected void updateView() {
        putValue(
                Action.SELECTED_KEY,
                getActiveView() != null && getActiveView().isLineWrap()
                );
    }
}
