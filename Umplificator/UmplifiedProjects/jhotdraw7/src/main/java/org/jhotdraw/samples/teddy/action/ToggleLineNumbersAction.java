/*
 * @(#)ToggleLineNumbersAction.java
 *
 * Copyright (c) 2005 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.teddy.action;

import org.jhotdraw.app.*;
import org.jhotdraw.app.action.*;
import org.jhotdraw.samples.teddy.*;
import org.jhotdraw.util.*;
import java.awt.event.*;
import javax.swing.Action;

/**
 * ToggleLineNumbersAction.
 *
 * @author  Werner Randelshofer
 * @version $Id: ToggleLineNumbersAction.java 723 2010-12-28 14:31:24Z rawcoder $
 */
public class ToggleLineNumbersAction extends AbstractViewAction {
    public final static String ID = "view.toggleLineNumbers";
    private ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.teddy.Labels");
    
    /**
     * Creates a new instance.
     */
    public ToggleLineNumbersAction(Application app, View view) {
        super(app, view);
        labels.configureAction(this, ID);
        setPropertyName("lineNumbersVisible");
    }
    
    @Override
    public TeddyView getActiveView() {
        return (TeddyView) super.getActiveView();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        getActiveView().setLineNumbersVisible(! getActiveView().isLineNumbersVisible());
    }
    
    
    @Override
    protected void updateView() {
        putValue(
                Action.SELECTED_KEY,
                getActiveView() != null && getActiveView().isLineNumbersVisible()
                );
    }
}
