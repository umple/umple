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
 * AttributeAction.
 *
 * @author Werner Randelshofer
 * @version $Id: DrawingAttributeAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class DrawingAttributeAction extends AbstractDrawingViewAction {

    protected Map<AttributeKey, Object> attributes;

    /** Creates a new instance. */
    /** Creates a new instance. */
    public <T> DrawingAttributeAction(DrawingEditor editor, AttributeKey<T> key, @Nullable T value) {
        this(editor, key, value, null, null);
    }

    /** Creates a new instance. */
    public <T> DrawingAttributeAction(DrawingEditor editor, AttributeKey<T> key, @Nullable T value, @Nullable Icon icon) {
        this(editor, key, value, null, icon);
    }

    /** Creates a new instance. */
    public <T> DrawingAttributeAction(DrawingEditor editor, AttributeKey<T> key, @Nullable T value, @Nullable String name) {
        this(editor, key, value, name, null);
    }

    public <T> DrawingAttributeAction(DrawingEditor editor, AttributeKey<T> key, @Nullable T value, @Nullable String name, @Nullable Icon icon) {
        this(editor, key, value, name, icon, null);
    }

    public <T> DrawingAttributeAction(DrawingEditor editor, AttributeKey<T> key, @Nullable T value, @Nullable String name, @Nullable Icon icon, @Nullable Action compatibleTextAction) {
        super(editor);
        this.attributes = new HashMap<AttributeKey, Object>();
        attributes.put(key, value);

        putValue(AbstractAction.NAME, name);
        putValue(AbstractAction.SMALL_ICON, icon);
        setEnabled(true);
    }

    public DrawingAttributeAction(DrawingEditor editor, Map<AttributeKey, Object> attributes, String name, Icon icon) {
        super(editor);
        this.attributes = attributes;

        putValue(AbstractAction.NAME, name);
        putValue(AbstractAction.SMALL_ICON, icon);
        updateEnabledState();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        final ArrayList<Object> restoreData = new ArrayList<Object>();
        final Figure drawing = getView().getDrawing();
        restoreData.add(drawing.getAttributesRestoreData());
        drawing.willChange();
        for (Map.Entry<AttributeKey, Object> entry : attributes.entrySet()) {
            drawing.set(entry.getKey(), entry.getValue());
        }
        drawing.changed();

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

                drawing.willChange();
                drawing.restoreAttributesTo(iRestore.next());
                drawing.changed();
            }

            @Override
            @SuppressWarnings("unchecked")
            public void redo() {
                super.redo();
                //restoreData.add(drawing.getAttributesRestoreData());
                drawing.willChange();
                for (Map.Entry<AttributeKey, Object> entry : attributes.entrySet()) {
                    drawing.set(entry.getKey(), entry.getValue());
                }
                drawing.changed();
            }
        };
        fireUndoableEditHappened(edit);
    }
}
