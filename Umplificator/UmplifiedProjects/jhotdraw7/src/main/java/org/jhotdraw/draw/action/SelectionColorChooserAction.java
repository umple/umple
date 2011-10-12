/*
 * @(#)SelectionColorChooserAction.java
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
import java.util.*;
import java.awt.*;
import javax.swing.*;
import org.jhotdraw.draw.*;

/**
 * This is like EditorColorChooserAction, but the JColorChooser is initialized with
 * the color of the currently selected Figures.
 * <p>
 * The behavior for choosing the initial color of the JColorChooser matches with
 * {@link SelectionColorIcon }.
 * 
 * @author Werner Randelshofer
 * @version $Id: SelectionColorChooserAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class SelectionColorChooserAction extends EditorColorChooserAction {
    
    /** Creates a new instance. */
    public SelectionColorChooserAction(DrawingEditor editor, AttributeKey<Color> key) {
        this(editor, key, null, null);
    }
    /** Creates a new instance. */
    public SelectionColorChooserAction(DrawingEditor editor, AttributeKey<Color> key, @Nullable Icon icon) {
        this(editor, key, null, icon);
    }
    /** Creates a new instance. */
    public SelectionColorChooserAction(DrawingEditor editor, AttributeKey<Color> key, @Nullable String name) {
        this(editor, key, name, null);
    }
    public SelectionColorChooserAction(DrawingEditor editor, final AttributeKey<Color> key, @Nullable String name, @Nullable Icon icon) {
        this(editor, key, name, icon, new HashMap<AttributeKey,Object>());
    }
    public SelectionColorChooserAction(DrawingEditor editor, final AttributeKey<Color> key, @Nullable String name, @Nullable Icon icon,
            @Nullable Map<AttributeKey,Object> fixedAttributes) {
        super(editor, key, name, icon, fixedAttributes);
    }
    
    @Override
    protected Color getInitialColor() {
        Color initialColor = null;
        
        DrawingView v = getEditor().getActiveView();
        if (v != null && v.getSelectedFigures().size() == 1) {
            Figure f = v.getSelectedFigures().iterator().next();
            initialColor = f.get(key);
        }
        if (initialColor == null) {
            initialColor = super.getInitialColor();
        }
        return initialColor;
    }
}
