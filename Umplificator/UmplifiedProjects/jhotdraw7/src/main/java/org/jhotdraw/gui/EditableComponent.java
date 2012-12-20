/*
 * @(#)EditableComponent.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui;

import java.beans.PropertyChangeListener;

/**
 * This interface must be implemented by components
 * which are editable.
 * <p>
 * FIXME - Investigate if we can replace this interface by querying the 
 * TransferHandler of a component and retrieve its cut/copy/paste actions.
 * See http://java.sun.com/docs/books/tutorial/uiswing/dnd/intro.html#cut
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Framework</em><br>
 * The interfaces and classes listed below work together:
 * <br>
 * Contract: {@link org.jhotdraw.gui.EditableComponent}, {@code JTextComponent}.<br>
 * Client: {@link org.jhotdraw.app.action.edit.AbstractSelectionAction},
 * {@link org.jhotdraw.app.action.edit.DeleteAction},
 * {@link org.jhotdraw.app.action.edit.DuplicateAction},
 * {@link org.jhotdraw.app.action.edit.SelectAllAction},
 * {@link org.jhotdraw.app.action.edit.ClearSelectionAction}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: EditableComponent.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface EditableComponent {

    /** The name of the "selectionEmpty" property. */
    public final static String SELECTION_EMPTY_PROPERTY = "selectionEmpty";

    /**
     * Deletes the selected components or the component at (or after) the
     * caret position.
     */
    public void delete();

    /**
     * Duplicates the selected region.
     */
    public void duplicate();

    /**
     * Selects all.
     */
    public void selectAll();

    /**
     * Selects nothing.
     */
    public void clearSelection();

    /**
     * Returns true if the selection is empty.
     * This is a bound property.
     */
    public boolean isSelectionEmpty();

    /** Adds a property change listener. */
    public void addPropertyChangeListener(PropertyChangeListener l);
    
    /** Removes a property change listener. */
    public void removePropertyChangeListener(PropertyChangeListener l);
}
