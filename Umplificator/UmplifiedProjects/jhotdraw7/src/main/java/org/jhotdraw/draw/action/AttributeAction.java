/*
 * @(#)AttributeAction.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw.action;

import edu.umd.cs.findbugs.annotations.Nullable;
import javax.swing.undo.*;
import org.jhotdraw.app.action.ActionUtil;
import javax.swing.*;
import java.util.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * {@code AttributeAction} applies attribute values on the selected figures of
 * the current {@code DrawingView} of a {@code DrawingEditor}.
 *
 * @author Werner Randelshofer
 * @version $Id: AttributeAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class AttributeAction extends AbstractSelectedAction {

    protected Map<AttributeKey, Object> attributes;

    /** Creates a new instance. */
    /** Creates a new instance. */
    public AttributeAction(DrawingEditor editor, AttributeKey key, Object value) {
        this(editor, key, value, null, null);
    }

    /** Creates a new instance. */
    public AttributeAction(DrawingEditor editor, AttributeKey key, Object value, @Nullable Icon icon) {
        this(editor, key, value, null, icon);
    }

    /** Creates a new instance. */
    public AttributeAction(DrawingEditor editor, AttributeKey key, Object value, @Nullable String name) {
        this(editor, key, value, name, null);
    }

    public AttributeAction(DrawingEditor editor, AttributeKey key, Object value, @Nullable String name, @Nullable Icon icon) {
        this(editor, key, value, name, icon, null);
    }

    public AttributeAction(DrawingEditor editor, AttributeKey key, Object value, @Nullable String name, @Nullable Icon icon, @Nullable Action compatibleTextAction) {
        super(editor);
        this.attributes = new HashMap<AttributeKey, Object>();
        attributes.put(key, value);

        putValue(AbstractAction.NAME, name);
        putValue(AbstractAction.SMALL_ICON, icon);
        putValue(ActionUtil.UNDO_PRESENTATION_NAME_KEY, key.getPresentationName());
        updateEnabledState();
    }

    public AttributeAction(DrawingEditor editor, @Nullable Map<AttributeKey, Object> attributes, @Nullable String name, @Nullable Icon icon) {
        super(editor);
        this.attributes = (attributes == null) ? new HashMap<AttributeKey, Object>() : attributes;

        putValue(AbstractAction.NAME, name);
        putValue(AbstractAction.SMALL_ICON, icon);
        updateEnabledState();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        applyAttributesTo(attributes, getView().getSelectedFigures());
    }

    /**
     * Applies the specified attributes to the currently selected figures
     * of the drawing.
     *
     * @param a The attributes.
     * @param figures The figures to which the attributes are applied.
     */
    @SuppressWarnings("unchecked")
    public void applyAttributesTo(final Map<AttributeKey, Object> a, Set<Figure> figures) {
        for (Map.Entry<AttributeKey, Object> entry : a.entrySet()) {
            getEditor().setDefaultAttribute(entry.getKey(), entry.getValue());
        }

        final ArrayList<Figure> selectedFigures = new ArrayList<Figure>(figures);
        final ArrayList<Object> restoreData = new ArrayList<Object>(selectedFigures.size());
        for (Figure figure : selectedFigures) {
            restoreData.add(figure.getAttributesRestoreData());
            figure.willChange();
            for (Map.Entry<AttributeKey, Object> entry : a.entrySet()) {
                figure.set(entry.getKey(), entry.getValue());
            }
            figure.changed();
        }
        UndoableEdit edit = new AbstractUndoableEdit() {

            @Override
            public String getPresentationName() {
                String name = (String) getValue(ActionUtil.UNDO_PRESENTATION_NAME_KEY);
                if (name == null) {
                    name = (String) getValue(AbstractAction.NAME);
                }
                if (name == null) {
                    ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                    name = labels.getString("attribute.text");
                }
                return name;
            }

            @Override
            public void undo() {
                super.undo();
                Iterator<Object> iRestore = restoreData.iterator();
                for (Figure figure : selectedFigures) {
                    figure.willChange();
                    figure.restoreAttributesTo(iRestore.next());
                    figure.changed();
                }
            }

            @Override
            public void redo() {
                super.redo();
                for (Figure figure : selectedFigures) {
                    //restoreData.add(figure.getAttributesRestoreData());
                    figure.willChange();
                    for (Map.Entry<AttributeKey, Object> entry : a.entrySet()) {
                        figure.set(entry.getKey(), entry.getValue());
                    }
                    figure.changed();
                }
            }
        };
        getDrawing().fireUndoableEditHappened(edit);
    }

    @Override
    protected void updateEnabledState() {
        if (getEditor() != null) {
            setEnabled(getEditor().isEnabled());
        }
    }
}
