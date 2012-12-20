/*
 * @(#)FigureAttributeEditorHandler.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw.event;

import org.jhotdraw.gui.*;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;

/**
 * FigureAttributeEditorHandler mediates between an AttributeEditor and the
 * currently selected Figure's in a DrawingEditor.
 *
 * @author Werner Randelshofer
 * @version $Id: FigureAttributeEditorHandler.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class FigureAttributeEditorHandler<T> extends AbstractAttributeEditorHandler<T> {

    public FigureAttributeEditorHandler(AttributeKey<T> key, AttributeEditor<T> attributeEditor, DrawingEditor drawingEditor) {
        super(key, attributeEditor, drawingEditor);
    }

    public FigureAttributeEditorHandler(AttributeKey<T> key, AttributeEditor<T> attributeEditor, DrawingEditor drawingEditor, boolean updateDrawingEditorDefaults) {
        super(key, attributeEditor, drawingEditor, updateDrawingEditorDefaults);
    }
    public FigureAttributeEditorHandler(AttributeKey<T> key, Map<AttributeKey,Object> defaultAttributes, AttributeEditor<T> attributeEditor, DrawingEditor drawingEditor, boolean updateDrawingEditorDefaults) {
        super(key, defaultAttributes, attributeEditor, drawingEditor, updateDrawingEditorDefaults);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Set<Figure> getEditedFigures() {
        return (Set<Figure>) ((activeView == null) ? Collections.emptySet() : activeView.getSelectedFigures());
    }

}
