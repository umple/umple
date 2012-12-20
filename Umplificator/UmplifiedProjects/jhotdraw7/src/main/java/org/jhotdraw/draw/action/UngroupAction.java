/*
 * @(#)UngroupAction.java
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
 * UngroupAction.
 *
 * @author  Werner Randelshofer
 * @version $Id: UngroupAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class UngroupAction extends GroupAction {

    public final static String ID = "edit.ungroupSelection";
    /** Creates a new instance. */
    private CompositeFigure prototype;

    /** Creates a new instance. */
    public UngroupAction(DrawingEditor editor) {
        super(editor, new GroupFigure(), false);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        labels.configureAction(this, ID);
        updateEnabledState();
    }

    public UngroupAction(DrawingEditor editor, CompositeFigure prototype) {
        super(editor, prototype, false);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        labels.configureAction(this, ID);
        updateEnabledState();
    }
}
