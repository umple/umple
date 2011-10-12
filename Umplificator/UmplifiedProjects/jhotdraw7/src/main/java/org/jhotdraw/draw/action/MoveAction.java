/*
 * @(#)MoveAction.java
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
import org.jhotdraw.draw.event.TransformEdit;
import org.jhotdraw.undo.CompositeEdit;
import java.awt.geom.*;
import java.util.HashSet;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * Moves the selected figures by one unit.
 *
 * @author  Werner Randelshofer
 * @version $Id: MoveAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public abstract class MoveAction extends AbstractSelectedAction {

    private int dx, dy;

    /** Creates a new instance. */
    public MoveAction(DrawingEditor editor, int dx, int dy) {
        super(editor);
        this.dx = dx;
        this.dy = dy;
        updateEnabledState();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        CompositeEdit edit;
        AffineTransform tx = new AffineTransform();
        tx.translate(dx, dy);

        HashSet<Figure> transformedFigures = new HashSet<Figure>();
        for (Figure f : getView().getSelectedFigures()) {
            if (f.isTransformable()) {
                transformedFigures.add(f);
                f.willChange();
                f.transform(tx);
                f.changed();
            }
        }
        fireUndoableEditHappened(new TransformEdit(transformedFigures, tx));

    }

    public static class East extends MoveAction {

        public final static String ID = "edit.moveEast";

        public East(DrawingEditor editor) {
            super(editor, 1, 0);
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            labels.configureAction(this, ID);
        }
    }

    public static class West extends MoveAction {

        public final static String ID = "edit.moveWest";

        public West(DrawingEditor editor) {
            super(editor, -1, 0);
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            labels.configureAction(this, ID);
        }
    }

    public static class North extends MoveAction {

        public final static String ID = "edit.moveNorth";

        public North(DrawingEditor editor) {
            super(editor, 0, -1);
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            labels.configureAction(this, ID);
        }
    }

    public static class South extends MoveAction {

        public final static String ID = "edit.moveSouth";

        public South(DrawingEditor editor) {
            super(editor, 0, 1);
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            labels.configureAction(this, ID);
        }
    }
}
