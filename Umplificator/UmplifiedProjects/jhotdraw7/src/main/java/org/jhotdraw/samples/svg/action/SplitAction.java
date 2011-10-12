/*
 * @(#)SplitPathsAction.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.svg.action;

import org.jhotdraw.draw.*;
import org.jhotdraw.samples.svg.figures.*;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * SplitPathsAction.
 *
 * @author  Werner Randelshofer
 * @version $Id: SplitAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class SplitAction extends CombineAction {
    public final static String ID = "edit.splitPath";
    private ResourceBundleUtil labels =
            ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
    
    /** Creates a new instance. */
    public SplitAction(DrawingEditor editor) {
        super(editor, new SVGPathFigure(), false);
        labels.configureAction(this, ID);
    }
    public SplitAction(DrawingEditor editor, SVGPathFigure prototype) {
        super(editor, prototype, false);
        labels.configureAction(this, ID);
    }
}
