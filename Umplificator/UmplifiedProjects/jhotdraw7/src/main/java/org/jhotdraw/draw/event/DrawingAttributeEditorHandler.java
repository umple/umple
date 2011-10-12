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

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.gui.*;
import java.util.HashSet;
import java.util.Set;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.Drawing;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.Figure;

/**
 * FigureAttributeEditorHandler mediates between an AttributeEditor and the
 * currently selected Figure's in a DrawingEditor.
 *
 * @author Werner Randelshofer
 * @version $Id: DrawingAttributeEditorHandler.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class DrawingAttributeEditorHandler<T> extends AbstractAttributeEditorHandler<T> {

    private Drawing drawing;

    public DrawingAttributeEditorHandler(AttributeKey<T> key, AttributeEditor<T> attributeEditor, @Nullable DrawingEditor drawingEditor) {
        super(key, attributeEditor, drawingEditor, false);
    }

    public void setDrawing(Drawing newValue) {
        drawing = newValue;
        updateAttributeEditor();
    }

    public Drawing getDrawing() {
        return drawing;
    }

    @Override
    protected Set<Figure> getEditedFigures() {
        HashSet<Figure> s = new HashSet<Figure>();
        if (drawing != null) {
            s.add(drawing);
        } else if (activeView != null) {
            s.add(activeView.getDrawing());
        }
        return s;
    }
}
