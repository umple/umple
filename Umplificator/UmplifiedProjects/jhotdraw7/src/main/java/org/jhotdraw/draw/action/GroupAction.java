/*
 * @(#)GroupAction.java
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
import java.util.*;
import javax.swing.undo.*;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * GroupAction.
 *
 * @author  Werner Randelshofer
 * @version $Id: GroupAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class GroupAction extends AbstractSelectedAction {

    public final static String ID = "edit.groupSelection";
    private CompositeFigure prototype;
    /**
     * If this variable is true, this action groups figures.
     * If this variable is false, this action ungroups figures.
     */
    private boolean isGroupingAction;

    /** Creates a new instance. */
    public GroupAction(DrawingEditor editor) {
        this(editor, new GroupFigure(), true);
    }

    public GroupAction(DrawingEditor editor, CompositeFigure prototype) {
        this(editor, prototype, true);
    }

    public GroupAction(DrawingEditor editor, CompositeFigure prototype, boolean isGroupingAction) {
        super(editor);
        this.prototype = prototype;
        this.isGroupingAction = isGroupingAction;
        ResourceBundleUtil labels =
                ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        labels.configureAction(this, ID);
        updateEnabledState();
    }

    @Override
    protected void updateEnabledState() {
        if (getView() != null) {
            setEnabled(isGroupingAction ? canGroup() : canUngroup());
        } else {
            setEnabled(false);
        }
    }

    protected boolean canGroup() {
        return getView() != null && getView().getSelectionCount() > 1;
    }

    protected boolean canUngroup() {
        return getView() != null
                && getView().getSelectionCount() == 1
                && prototype != null
                && getView().getSelectedFigures().iterator().next().getClass().equals(
                prototype.getClass());
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (isGroupingAction) {
            if (canGroup()) {
                final DrawingView view = getView();
                final LinkedList<Figure> ungroupedFigures = new LinkedList<Figure>(view.getSelectedFigures());
                final CompositeFigure group = (CompositeFigure) prototype.clone();
                UndoableEdit edit = new AbstractUndoableEdit() {

                    @Override
                    public String getPresentationName() {
                        ResourceBundleUtil labels =
                                ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                        return labels.getString("edit.groupSelection.text");
                    }

                    @Override
                    public void redo() throws CannotRedoException {
                        super.redo();
                        groupFigures(view, group, ungroupedFigures);
                    }

                    @Override
                    public void undo() throws CannotUndoException {
                        ungroupFigures(view, group);
                        super.undo();
                    }

                    @Override
                    public boolean addEdit(UndoableEdit anEdit) {
                        return super.addEdit(anEdit);
                    }
                };
                groupFigures(view, group, ungroupedFigures);
                fireUndoableEditHappened(edit);
            }
        } else {
            if (canUngroup()) {
                final DrawingView view = getView();
                final CompositeFigure group = (CompositeFigure) getView().getSelectedFigures().iterator().next();
                final LinkedList<Figure> ungroupedFigures = new LinkedList<Figure>();
                UndoableEdit edit = new AbstractUndoableEdit() {

                    @Override
                    public String getPresentationName() {
                        ResourceBundleUtil labels =
                                ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                        return labels.getString("edit.ungroupSelection.text");
                    }

                    @Override
                    public void redo() throws CannotRedoException {
                        super.redo();
                        ungroupFigures(view, group);
                    }

                    @Override
                    public void undo() throws CannotUndoException {
                        groupFigures(view, group, ungroupedFigures);
                        super.undo();
                    }
                };
                ungroupedFigures.addAll(ungroupFigures(view, group));
                fireUndoableEditHappened(edit);
            }
        }
    }

    public Collection<Figure> ungroupFigures(DrawingView view, CompositeFigure group) {
// XXX - This code is redundant with UngroupAction
        LinkedList<Figure> figures = new LinkedList<Figure>(group.getChildren());
        view.clearSelection();
        group.basicRemoveAllChildren();
        view.getDrawing().basicAddAll(view.getDrawing().indexOf(group), figures);
        view.getDrawing().remove(group);
        view.addToSelection(figures);
        return figures;
    }

    public void groupFigures(DrawingView view, CompositeFigure group, Collection<Figure> figures) {
        Collection<Figure> sorted = view.getDrawing().sort(figures);
        int index = view.getDrawing().indexOf(sorted.iterator().next());
        view.getDrawing().basicRemoveAll(figures);
        view.clearSelection();
        view.getDrawing().add(index, group);
        group.willChange();
        for (Figure f : sorted) {
            f.willChange();
            group.basicAdd(f);
        }
        group.changed();
        view.addToSelection(group);
    }
}
