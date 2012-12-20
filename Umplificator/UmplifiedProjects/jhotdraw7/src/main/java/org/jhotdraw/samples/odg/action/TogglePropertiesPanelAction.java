/*
 * @(#)TogglePropertiesPanelAction.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.odg.action;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.event.*;
import javax.swing.*;
import org.jhotdraw.app.*;
import org.jhotdraw.app.action.*;
import org.jhotdraw.samples.odg.*;
import org.jhotdraw.util.*;

/**
 * TogglePropertiesPanelAction.
 * 
 * @author Werner Randelshofer
 * @version $Id: TogglePropertiesPanelAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class TogglePropertiesPanelAction extends AbstractViewAction {
    
    /** Creates a new instance. */
    public TogglePropertiesPanelAction(Application app, @Nullable View view) {
        super(app, view);
        setPropertyName("propertiesPanelVisible");
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.odg.Labels");
        putValue(AbstractAction.NAME, labels.getString("propertiesPanel"));
    }
    
    /**
     * This method is invoked, when the property changed and when
     * the view changed.
     */
    @Override
    protected void updateView() {
        putValue(ActionUtil.SELECTED_KEY,
                getActiveView() != null &&
                ! getActiveView().isPropertiesPanelVisible()
                );
    }
    
    
    @Override
    public ODGView getActiveView() {
        return (ODGView) super.getActiveView();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        getActiveView().setPropertiesPanelVisible(
                ! getActiveView().isPropertiesPanelVisible()
                );
    }
    
}
