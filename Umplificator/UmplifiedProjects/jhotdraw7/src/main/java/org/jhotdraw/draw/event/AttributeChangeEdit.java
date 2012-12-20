/*
 * @(#)AttributeChangeEdit.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw.event;

import org.jhotdraw.draw.*;
import javax.swing.undo.*;

/**
 * An {@code UndoableEdit} event which can undo a change of a {@link Figure}
 * attribute.
 *
 * @author  Werner Randelshofer
 * @version $Id: AttributeChangeEdit.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class AttributeChangeEdit<T> extends AbstractUndoableEdit {
    private Figure owner;
    private AttributeKey<T> name;
    private T oldValue;
    private T newValue;
    
    /** Creates a new instance. */
    public AttributeChangeEdit(Figure owner, AttributeKey<T> name, T oldValue, T newValue) {
        this.owner = owner;
        this.name = name;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }    
    @Override
    public String getPresentationName() {
        // FIXME - Localize me
        return "Eigenschaft \u00e4ndern";
    }
    
    @Override
    public void redo() throws CannotRedoException {
        super.redo();
        owner.willChange();
        owner.set(name, newValue);
        owner.changed();
    }
    @Override
    public void undo() throws CannotUndoException {
        super.undo();
        owner.willChange();
        owner.set(name, oldValue);
        owner.changed();
    }
}
