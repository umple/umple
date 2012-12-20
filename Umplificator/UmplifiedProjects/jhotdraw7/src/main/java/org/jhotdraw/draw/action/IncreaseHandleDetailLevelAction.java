/*
 * @(#)SelectSameAction.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.action;

import org.jhotdraw.draw.*;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * SelectSameAction.
 *
 * @author  Werner Randelshofer
 * @version $Id: IncreaseHandleDetailLevelAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class IncreaseHandleDetailLevelAction extends AbstractSelectedAction {
    public final static String ID = "view.increaseHandleDetailLevel";
    /** Creates a new instance. */
    public IncreaseHandleDetailLevelAction(DrawingEditor editor) {
        super(editor);
        ResourceBundleUtil labels =
            ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        labels.configureAction(this, ID);
        //putValue(AbstractAction.NAME, labels.getString("editSelectSame"));
        //  putValue(AbstractAction.MNEMONIC_KEY, labels.getString("editSelectSameMnem"));
        updateEnabledState();
    }
    
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        increaseHandleDetaiLevel();
    }
    
    public void increaseHandleDetaiLevel() {
      DrawingView view =  getView();
        if (view != null) {
            view.setHandleDetailLevel(view.getHandleDetailLevel() + 1);
        }
    }
}
