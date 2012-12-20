/*
 * @(#)CompositeModel.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.undo;

import javax.swing.undo.*;
/**
 * This is basically the same like javax.swing.undo.CompoundEdit but
 * it has a slightly different behaviour:
 * The compound edit ends, when it is added to itself. This way it
 * can be fired two times to an UndoManager: The first time, when
 * a sequence of compoundable edits starts, end the last time, when
 * the sequence is over.
 * <p>
 * For example:
 * <pre>
 * // fire CompositeEdit at start of sequence
 * CompositeEdit ce = new CompositeEdit();
 * fireUndoableEditEvent(ce);
 *
 * ...fire edits which shall compounded here...
 *
 * // fire CompositeEdit at end of sequence again, to end it.
 * fireUndoableEditEvent(ce);
 * </pre>
 *
 * @author  Werner Randelshofer
 * @version $Id: CompositeEdit.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class CompositeEdit extends CompoundEdit {
    private String presentationName;
    private boolean isSignificant;
    private boolean isVerbose;
    
    public void setVerbose(boolean b) {
        isVerbose = b;
    }
    /**
     * Creates a new {@code CompositeEdit} which uses CompoundEdit#getPresentationName()
     * and is significant..
     *
     * @see javax.swing.undo.CompoundEdit#getPresentationName()
     */
    public CompositeEdit() {
        isSignificant = true;
    }
    /**
     * Creates a new {@code CompositeEdit} which uses the specified significance.
     * <p>
     * The presentation name is used from CompoundEdit#getPresentationName().
     *
     * @see javax.swing.undo.CompoundEdit#getPresentationName()
     */
    public CompositeEdit(boolean isSignificant) {
        this.isSignificant = isSignificant;
    }
    /**
     * Creates a new {@code CompositeEdit} which uses the specified
     * presentation name.
     * <p>
     * If the presentation name is null, then CompoundEdit.getPresentatioName
     * is used.
     * @see javax.swing.undo.CompoundEdit#getPresentationName()
     */
    public CompositeEdit(String presentationName) {
        this.presentationName = presentationName;
        isSignificant = true;
    }
    /**
     * Creates a new {@code CompositeEdit} which uses the given presentation name
     * and significance.
     * <p>
     * If the presentation name is null, then CompoundEdit.getPresentatioName
     * is used.
     * @see javax.swing.undo.CompoundEdit#getPresentationName()
     */
    public CompositeEdit(String presentationName, boolean isSignificant) {
        this.presentationName = presentationName;
        this.isSignificant = isSignificant;
    }
    
    /**
     * Returns the presentation name.
     * If the presentation name is null, then CompoundEdit.getPresentatioName
     * is returned.
     * @see javax.swing.undo.CompoundEdit#getPresentationName()
     */
    @Override
    public String getPresentationName() {
        return (presentationName != null) ? presentationName : super.getPresentationName();
    }
    /**
     * Returns the undo presentation name.
     * If the presentation name is null, then CompoundEdit.getUndoPresentationName
     * is returned.
     * @see javax.swing.undo.CompoundEdit#getUndoPresentationName()
     */
    @Override
    public String getUndoPresentationName() {
        return ((presentationName != null) ? UndoRedoManager.getLabels().getString("edit.undo.text")+" "+presentationName : super.getUndoPresentationName());
    }
    /**
     * Returns the redo presentation name.
     * If the presentation name is null, then CompoundEdit.getRedoPresentationName
     * is returned.
     * @see javax.swing.undo.CompoundEdit#getRedoPresentationName()
     */
    @Override
    public String getRedoPresentationName() {
        return ((presentationName != null) ? UndoRedoManager.getLabels().getString("edit.redo.text")+" "+presentationName : super.getRedoPresentationName());
    }
    
    /**
     * If this edit is inProgress, accepts anEdit and returns
     * true.
     *
     * <p>The last edit added to this CompositeEdit is given a
     * chance to addEdit(anEdit). If it refuses (returns false), anEdit is
     * given a chance to replaceEdit the last edit. If anEdit returns
     * false here, it is added to edits.</p>
     *
     * <p>If the CompositeEdit is added to itself, then method end()
     * is called, and true is returned.</p>
     */
    @Override
    public boolean addEdit(UndoableEdit anEdit) {
        if (anEdit == this) {
                end();
            return true;
        } else if (isInProgress() && (anEdit instanceof CompositeEdit)) {
            return true;
        } else {
            return super.addEdit(anEdit);
        }
    }
    
    /**
     * Returns false if this edit is insignificant - for example one
     * that maintains the user's selection, but does not change
     * any model state.
     */
    @Override
    public boolean isSignificant() {
        return (isSignificant) ? super.isSignificant() : false;
        //return isSignificant;
    }
    public void setSignificant(boolean newValue) {
      isSignificant = newValue;
    }
}
