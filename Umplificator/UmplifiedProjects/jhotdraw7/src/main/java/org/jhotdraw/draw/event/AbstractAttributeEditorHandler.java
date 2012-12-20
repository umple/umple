/*
 * @(#)AbstractAttributeEditorHandler.java
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoableEdit;
import org.jhotdraw.app.Disposable;
import org.jhotdraw.beans.WeakPropertyChangeListener;
import org.jhotdraw.draw.AttributeKey;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;

/**
 * AbstractAttributeEditorHandler mediates between an AttributeEditor and the
 * currently selected Figure's in a DrawingEditor.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Observer</em><br>
 * Selection changes of {@code DrawingView} are observed by user interface
 * components:<br>
 * Subject: {@link org.jhotdraw.draw.DrawingView}; Observer: {@link FigureSelectionListener};
 * Concrete-Observer: {@link AbstractAttributeEditorHandler},
 * {@link SelectionComponentDisplayer}, {@link SelectionComponentRepainter}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: AbstractAttributeEditorHandler.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public abstract class AbstractAttributeEditorHandler<T> implements Disposable {

    @Nullable protected DrawingEditor editor;
    @Nullable protected DrawingView view;
    @Nullable protected DrawingView activeView;
    protected AttributeEditor<T> attributeEditor;
    protected AttributeKey<T> attributeKey;
    protected int updateDepth;
    @Nullable protected LinkedList<Object> attributeRestoreData = new LinkedList<Object>();
    protected Map<AttributeKey, Object> defaultAttributes;
    
    /**
     * If this variable is put to true, the attribute editor updates the
     * default values of the drawing editor.
     */
    private boolean isUpdateDrawingEditorDefaults;
    /**
     * To this figures we have registered the EventHandler as FigureListener
     * and as PropertyChangeListener.
     */
    private Set<Figure> figuresOfInterest;

    protected class EventHandler extends FigureAdapter implements FigureSelectionListener, PropertyChangeListener {

        @Override
        public void selectionChanged(FigureSelectionEvent evt) {
            attributeRestoreData = null;
            if (figuresOfInterest != null) {
                for (Figure f : figuresOfInterest) {
                    f.removeFigureListener(this);
                }
            }
            figuresOfInterest = getEditedFigures();
            for (Figure f : figuresOfInterest) {
                f.addFigureListener(this);
            }
            updateAttributeEditor();
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            Object src = evt.getSource();
            String name = evt.getPropertyName();
            if (src == editor && name == DrawingEditor.ACTIVE_VIEW_PROPERTY) {
                updateActiveView();
            } else if (src == editor && name.equals(DrawingEditor.DEFAULT_ATTRIBUTE_PROPERTY_PREFIX+attributeKey.getKey())) {
            updateAttributeEditor();
            } else if (src == attributeEditor && name == AttributeEditor.ATTRIBUTE_VALUE_PROPERTY) {
                updateFigures();
            } else if (src == activeView && name == DrawingView.DRAWING_PROPERTY) {
                updateActiveView();
            } else if (figuresOfInterest != null && figuresOfInterest.contains(src)) {
                updateFigures();
            }
        }

        @Override
        public void attributeChanged(FigureEvent e) {
            if (e.getAttribute() == attributeKey) {
                updateAttributeEditor();
            }
        }
    }
    private EventHandler eventHandler;

    private static class UndoableAttributeEdit<T> extends AbstractUndoableEdit {

        private Set<Figure> editedFigures;
        private AttributeKey<T> attributeKey;
        private T editRedoValue;
        protected LinkedList<Object> editUndoData;

        public UndoableAttributeEdit(Set<Figure> editedFigures, AttributeKey<T> attributeKey, T editRedoValue, LinkedList<Object> editUndoData) {
            this.editedFigures = editedFigures;
            this.attributeKey = attributeKey;
            this.editRedoValue = editRedoValue;
            this.editUndoData = editUndoData;
        }

        @Override
        public String getPresentationName() {
            return attributeKey.getPresentationName();
        }

        @Override
        public void undo() throws CannotRedoException {
            super.undo();
            Iterator<Object> di = editUndoData.iterator();
            for (Figure f : editedFigures) {
                f.willChange();
                f.restoreAttributesTo(di.next());
                f.changed();
            }
        }

        @Override
        public void redo() throws CannotRedoException {
            super.redo();
            for (Figure f : editedFigures) {
                f.set(attributeKey, editRedoValue);
            }
        }

        @Override
        public boolean replaceEdit(UndoableEdit anEdit) {
            if (anEdit instanceof UndoableAttributeEdit) {
                return ((UndoableAttributeEdit) anEdit).editUndoData == this.editUndoData;
            }
            return false;
        }
    }

    public AbstractAttributeEditorHandler(AttributeKey<T> key, AttributeEditor<T> attributeEditor, @Nullable DrawingEditor drawingEditor) {
        this(key, attributeEditor, drawingEditor, true);
    }

    public AbstractAttributeEditorHandler(AttributeKey<T> key, AttributeEditor<T> attributeEditor, @Nullable DrawingEditor drawingEditor, boolean updateDrawingEditorDefaults) {
        this(key, null, attributeEditor, drawingEditor, updateDrawingEditorDefaults);
    }

    @SuppressWarnings("unchecked")
    public AbstractAttributeEditorHandler(AttributeKey<T> key, @Nullable Map<AttributeKey, Object> defaultAttributes, AttributeEditor<T> attributeEditor, @Nullable DrawingEditor drawingEditor, boolean updateDrawingEditorDefaults) {
        eventHandler = new EventHandler();
        this.defaultAttributes = (Map<AttributeKey, Object>) ((defaultAttributes == null) ? Collections.emptyMap() : defaultAttributes);
        attributeEditor.setAttributeValue(key.getDefaultValue());
        setAttributeKey(key);
        setAttributeEditor(attributeEditor);
        setEditor(drawingEditor);
        isUpdateDrawingEditorDefaults = updateDrawingEditorDefaults;
    }

    /**
     * Attaches the FigureAttributeEditorHandler to the specified DrawingEditor.
     * <p>
     * The FigureAttributeEditorHandler listens to view changes and selection
     * changes of the drawing editor and calls setEnabled(boolean) and
     * updateField(Set&lt;Figure&gt;) on the field accordingly.
     *
     * @param newValue a drawing editor.
     */
    public void setEditor(@Nullable DrawingEditor newValue) {
        DrawingEditor oldValue = editor;
        if (editor != null) {
            editor.removePropertyChangeListener(eventHandler);
        }
        this.editor = newValue;
        if (editor != null) {
            editor.addPropertyChangeListener(new WeakPropertyChangeListener(eventHandler));
        }
        updateActiveView();
    }

    /**
     * Returns the DrawingEditor to which this FigureAttributeEditorHandler is
     * attached.
     */
    @Nullable public DrawingEditor getEditor() {
        return editor;
    }

    /**
     * Attaches the FigureAttributeEditorHandler to the specified DrawingView.
     * <p>
     * If a non-null value is provided, the FigureAttributeEditorHandler listens only
     * to selection changes of the specified view. If a null value is provided,
     * the FigureAttributeEditorHandler listens to all views of the drawing editor.
     *
     * @param newValue a drawing view.
     */
    public void setView(@Nullable DrawingView newValue) {
        this.view = newValue;
        updateActiveView();
    }

    /**
     * Returns the DrawingView to which this FigureAttributeEditorHandler is
     * attached. Returns null, if the FigureAttributeEditorHandler is attached
     * to all views of the DrawingEditor.
     */
    @Nullable public DrawingView getView() {
        return view;
    }

    /**
     * Set this to true if you want the attribute editor to update the
     * default values of the drawing editor.
     * 
     * @param newValue
     */
    public void setUpdateDrawingEditorDefaults(boolean newValue) {
        isUpdateDrawingEditorDefaults = newValue;
    }

    /**
     * Returns true if the attribute editor updates the
     * default values of the drawing editor.
     */
    public boolean isUpdateDrawingEditorDefaults() {
        return isUpdateDrawingEditorDefaults;
    }

    @Nullable protected DrawingView getActiveView() {
        if (getView() != null) {
            return getView();
        } else {
            return editor.getActiveView();
        }
    }

    /**
     * Attaches the FigureAttributeEditorHandler to the specified AttributeEditor.
     */
    public void setAttributeEditor(AttributeEditor<T> newValue) {
        if (attributeEditor != null) {
            attributeEditor.removePropertyChangeListener(eventHandler);
        }
        this.attributeEditor = newValue;
        if (attributeEditor != null) {
            attributeEditor.addPropertyChangeListener(eventHandler);
        }
    }

    /**
     * Returns the AttributeEditor to which this FigureAttributeEditorHandler is
     * attached. 
     */
    public AttributeEditor<T> getAttributeEditor() {
        return attributeEditor;
    }

    public AttributeKey<T> getAttributeKey() {
        return attributeKey;
    }

    public void setAttributeKey(AttributeKey<T> newValue) {
        attributeKey = newValue;
    }

    protected void updateActiveView() {
        DrawingView newValue = (view != null) ? //
                view : //
                ((editor != null && editor.getActiveView() != null) ? //
                editor.getActiveView() : null);
        DrawingView oldValue = activeView;
        if (activeView != null) {
            activeView.removePropertyChangeListener(eventHandler);
            activeView.removeFigureSelectionListener(eventHandler);
            if (figuresOfInterest != null) {
                for (Figure f : figuresOfInterest) {
                    f.removeFigureListener(eventHandler);
                }
            }
        }
        activeView = newValue;
        if (activeView != null) {
            activeView.addPropertyChangeListener(eventHandler);
            activeView.addFigureSelectionListener(eventHandler);
            figuresOfInterest = getEditedFigures();
            for (Figure f : figuresOfInterest) {
                f.addFigureListener(eventHandler);
            }
        }
        attributeRestoreData = null;
        updateAttributeEditor();
    }

    protected abstract Set<Figure> getEditedFigures();

    protected void updateAttributeEditor() {
        if (updateDepth++ == 0) {
            Set<Figure> figures = getEditedFigures();
            if (editor==null) {
                attributeEditor.getComponent().setEnabled(false);
            } else if (activeView == null || figures.isEmpty()) {
                attributeEditor.getComponent().setEnabled(true);
                T value = editor.getDefaultAttribute(attributeKey);
                attributeEditor.setAttributeValue(value);
                attributeEditor.setMultipleValues(false);
            } else {
                attributeEditor.getComponent().setEnabled(true);
                T value = figures.iterator().next().get(attributeKey);
                boolean isMultiple = false;
                for (Figure f : figures) {
                    T v = f.get(attributeKey);
                    if ((v == null || value == null) && v != value || //
                            v != null && value != null && !v.equals(value)) {
                        isMultiple = true;
                        break;
                    }
                }
                attributeEditor.setAttributeValue(value);
                attributeEditor.setMultipleValues(isMultiple);
            }
        }
        updateDepth--;
    }

    @SuppressWarnings("unchecked")
    protected void updateFigures() {
        if (updateDepth++ == 0) {
            Set<Figure> figures = getEditedFigures();
            if (activeView == null || figures.isEmpty()) {
            } else {
                T value = attributeEditor.getAttributeValue();
                if (attributeRestoreData == null) {
                    attributeRestoreData = new LinkedList<Object>();
                    for (Figure f : figures) {
                        attributeRestoreData.add(f.getAttributesRestoreData());
                    }
                }
                for (Figure f : figures) {
                    f.willChange();
                    f.set(attributeKey, value);
                    for (Map.Entry<AttributeKey, Object> entry : defaultAttributes.entrySet()) {
                        f.set(entry.getKey(), entry.getValue());
                    }
                    f.changed();
                }
                if (editor != null && isUpdateDrawingEditorDefaults) {
                    editor.setDefaultAttribute(attributeKey, value);
                }
                getActiveView().getDrawing().fireUndoableEditHappened(//
                        new UndoableAttributeEdit<T>(new HashSet<Figure>(figures), attributeKey, value, attributeRestoreData)//
                        );
                if (!attributeEditor.getValueIsAdjusting()) {
                    attributeRestoreData = null;
                }
            }
        }
        updateDepth--;
    }

    @Override
    public void dispose() {
        setEditor(null);
    }
}
