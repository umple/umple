/*
 * @(#)MoveConstrainedAction.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw.action;

import org.jhotdraw.draw.event.TransformEdit;
import org.jhotdraw.draw.*;
import org.jhotdraw.undo.CompositeEdit;
import java.awt.geom.*;
import java.util.HashSet;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * Moves the selected figures by one constrained unit.
 *
 * @author  Werner Randelshofer
 * @version $Id: MoveConstrainedAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public abstract class MoveConstrainedAction extends AbstractSelectedAction {

    private TranslationDirection dir;

    /** Creates a new instance. */
    public MoveConstrainedAction(DrawingEditor editor, TranslationDirection dir) {
        super(editor);
        this.dir = dir;
        updateEnabledState();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (getView().getSelectionCount() > 0) {

            Rectangle2D.Double r = null;
            HashSet<Figure> transformedFigures = new HashSet<Figure>();
            for (Figure f : getView().getSelectedFigures()) {
                if (f.isTransformable()) {
                    transformedFigures.add(f);
                    if (r == null) {
                        r = f.getBounds();
                    } else {
                        r.add(f.getBounds());
                    }
                }
            }
            if (transformedFigures.isEmpty()) {
                return;
            }
            Point2D.Double p0 = new Point2D.Double(r.x, r.y);
            if (getView().getConstrainer() != null) {
                getView().getConstrainer().translateRectangle(r, dir);
            } else {
                switch (dir) {
                    case NORTH:
                        r.y -= 1;
                        break;
                    case SOUTH:
                        r.y += 1;
                        break;
                    case WEST:
                        r.x -= 1;
                        break;
                    case EAST:
                        r.x += 1;
                        break;
                }
            }

            AffineTransform tx = new AffineTransform();
            tx.translate(r.x - p0.x, r.y - p0.y);
            for (Figure f : transformedFigures) {
                f.willChange();
                f.transform(tx);
                f.changed();
            }
            CompositeEdit edit;
            fireUndoableEditHappened(new TransformEdit(transformedFigures, tx));
        }
    }

    public static class East extends MoveConstrainedAction {

        public final static String ID = "edit.moveConstrainedEast";

        public East(DrawingEditor editor) {
            super(editor, TranslationDirection.EAST);
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            labels.configureAction(this, ID);
        }
    }

    public static class West extends MoveConstrainedAction {

        public final static String ID = "edit.moveConstrainedWest";

        public West(DrawingEditor editor) {
            super(editor, TranslationDirection.WEST);
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            labels.configureAction(this, ID);
        }
    }

    public static class North extends MoveConstrainedAction {

        public final static String ID = "edit.moveConstrainedNorth";

        public North(DrawingEditor editor) {
            super(editor, TranslationDirection.NORTH);
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            labels.configureAction(this, ID);
        }
    }

    public static class South extends MoveConstrainedAction {

        public final static String ID = "edit.moveConstrainedSouth";

        public South(DrawingEditor editor) {
            super(editor, TranslationDirection.SOUTH);
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            labels.configureAction(this, ID);
        }
    }
}
