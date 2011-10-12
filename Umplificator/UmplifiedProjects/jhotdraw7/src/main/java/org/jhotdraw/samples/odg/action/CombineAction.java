/*
 * @(#)CombinePathsAction.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.odg.action;

import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.samples.odg.figures.*;
import org.jhotdraw.util.*;
import java.util.*;

/**
 * CombinePathsAction.
 *
 * @author  Werner Randelshofer
 * @version $Id: CombineAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class CombineAction extends GroupAction {

    public final static String ID = "edit.combinePaths";
    private ResourceBundleUtil labels =
            ResourceBundleUtil.getBundle("org.jhotdraw.samples.odg.Labels");

    /** Creates a new instance. */
    public CombineAction(DrawingEditor editor) {
        super(editor, new ODGPathFigure());
        labels.configureAction(this, ID);
    }

    @Override
    protected boolean canGroup() {
        boolean canCombine = getView().getSelectionCount() > 1;
        if (canCombine) {
            for (Figure f : getView().getSelectedFigures()) {
                if (!(f instanceof ODGPathFigure)) {
                    canCombine = false;
                    break;
                }
            }
        }
        return canCombine;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Figure> ungroupFigures(DrawingView view, CompositeFigure group) {
        LinkedList<Figure> figures = new LinkedList<Figure>(group.getChildren());
        view.clearSelection();
        group.basicRemoveAllChildren();
        LinkedList<Figure> paths = new LinkedList<Figure>();
        for (Figure f : figures) {
            ODGPathFigure path = new ODGPathFigure();
            path.removeAllChildren();
            for (Map.Entry<AttributeKey, Object> entry : group.getAttributes().entrySet()) {
                path.set(entry.getKey(), entry.getValue());
            }
            path.add(f);
            view.getDrawing().basicAdd(path);
            paths.add(path);
        }
        view.getDrawing().remove(group);
        view.addToSelection(paths);
        return figures;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void groupFigures(DrawingView view, CompositeFigure group, Collection<Figure> figures) {
        Collection<Figure> sorted = view.getDrawing().sort(figures);
        view.getDrawing().basicRemoveAll(figures);
        view.clearSelection();
        view.getDrawing().add(group);
        group.willChange();
        ((ODGPathFigure) group).removeAllChildren();
        for (Map.Entry<AttributeKey, Object> entry : figures.iterator().next().getAttributes().entrySet()) {
            group.set(entry.getKey(), entry.getValue());
        }
        for (Figure f : sorted) {
            ODGPathFigure path = (ODGPathFigure) f;
            // XXX - We must fire an UndoableEdito for the flattenTransform!
            path.flattenTransform();
            for (Figure child : path.getChildren()) {
                group.basicAdd(child);
            }
        }
        group.changed();
        view.addToSelection(group);
    }
}
