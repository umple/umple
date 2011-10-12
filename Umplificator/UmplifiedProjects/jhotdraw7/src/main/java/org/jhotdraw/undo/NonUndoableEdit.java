/*
 * @(#)NonUndoableEdit.java
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
 * NonUndoableEdit.
 *
 * @author  Werner Randelshofer
 * @version $Id: NonUndoableEdit.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class NonUndoableEdit extends AbstractUndoableEdit {
    
    /** Creates a new instance. */
    public NonUndoableEdit() {
    }
    
    @Override
    public boolean canUndo() {
        return false;
    }
    @Override
    public boolean canRedo() {
        return false;
    }
}
