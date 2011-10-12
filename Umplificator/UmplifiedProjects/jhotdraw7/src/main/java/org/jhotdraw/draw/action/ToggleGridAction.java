/*
 * @(#)ToggleGridAction.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.action;

import org.jhotdraw.app.action.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * Toggles the grid of the current view.
 *
 * @author  Werner Randelshofer
 * @version $Id: ToggleGridAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ToggleGridAction extends AbstractDrawingViewAction {
    public final static String ID = "view.toggleGrid";
    /**
     * Creates a new instance.
     */
    public ToggleGridAction(DrawingEditor editor) {
        super(editor);
        ResourceBundleUtil labels =
                ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        labels.configureAction(this, ID);
        updateViewState();
    }
    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        DrawingView view = getView();
        if (view != null) {
            view.setConstrainerVisible(! view.isConstrainerVisible());
        }
    }
    
    @Override
    protected void updateViewState() {
        DrawingView view = getView();
        putValue(ActionUtil.SELECTED_KEY, view != null && view.isConstrainerVisible());
    }
}
