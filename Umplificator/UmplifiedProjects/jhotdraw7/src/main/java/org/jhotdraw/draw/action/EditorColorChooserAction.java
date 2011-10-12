/*
 * @(#)EditorColorChooserAction.java
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
import org.jhotdraw.draw.event.FigureSelectionEvent;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * EditorColorChooserAction.
 * <p>
 * The behavior for choosing the initial color of the JColorChooser matches with
 * {@link EditorColorIcon }.
 *
 * @author Werner Randelshofer
 * @version $Id: EditorColorChooserAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class EditorColorChooserAction extends AttributeAction {

    protected AttributeKey<Color> key;
    protected static JColorChooser colorChooser;

    /** Creates a new instance. */
    public EditorColorChooserAction(DrawingEditor editor, AttributeKey<Color> key) {
        this(editor, key, null, null);
        updateEnabledState();
    }

    /** Creates a new instance. */
    public EditorColorChooserAction(DrawingEditor editor, AttributeKey<Color> key, @Nullable Icon icon) {
        this(editor, key, null, icon);
    }

    /** Creates a new instance. */
    public EditorColorChooserAction(DrawingEditor editor, AttributeKey<Color> key, @Nullable String name) {
        this(editor, key, name, null);
    }

    public EditorColorChooserAction(DrawingEditor editor, final AttributeKey<Color> key, @Nullable String name, @Nullable Icon icon) {
        this(editor, key, name, icon, new HashMap<AttributeKey, Object>());
    }

    public EditorColorChooserAction(DrawingEditor editor, final AttributeKey<Color> key, @Nullable String name, @Nullable Icon icon,
            @Nullable Map<AttributeKey, Object> fixedAttributes) {
        super(editor, fixedAttributes, name, icon);
        this.key = key;
        putValue(AbstractAction.NAME, name);
        putValue(AbstractAction.SMALL_ICON, icon);
        updateEnabledState();
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (colorChooser == null) {
            colorChooser = new JColorChooser();
        }
        Color initialColor = getInitialColor();
        // FIXME - Reuse colorChooser object instead of calling static method here.
        ResourceBundleUtil labels =
                ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        Color chosenColor = JColorChooser.showDialog((Component) e.getSource(), labels.getString("attribute.color.text"), initialColor);
        if (chosenColor != null) {
            HashMap<AttributeKey, Object> attr = new HashMap<AttributeKey, Object>(attributes);
            attr.put(key, chosenColor);
            applyAttributesTo(attr, getView().getSelectedFigures());
        }
    }

    public void selectionChanged(FigureSelectionEvent evt) {
        //setEnabled(getView().getSelectionCount() > 0);
    }

    protected Color getInitialColor() {
        Color initialColor = (Color) getEditor().getDefaultAttribute(key);
        if (initialColor == null) {
            initialColor = Color.red;
        }
        return initialColor;
    }
}
