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

import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;
import java.util.*;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * SelectSameAction.
 *
 * @author  Werner Randelshofer
 * @version $Id: SelectSameAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class SelectSameAction extends AbstractSelectedAction {

    public final static String ID = "edit.selectSame";

    /** Creates a new instance. */
    public SelectSameAction(DrawingEditor editor) {
        super(editor);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        labels.configureAction(this, ID);
        updateEnabledState();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        selectSame();
    }

    public void selectSame() {
        HashSet<Class> selectedClasses = new HashSet<Class>();
        for (Figure selected : getView().getSelectedFigures()) {
            selectedClasses.add(selected.getClass());
        }
        for (Figure f : getDrawing().getChildren()) {
            if (selectedClasses.contains(f.getClass())) {
                getView().addToSelection(f);
            }
        }
    }
}
