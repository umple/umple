/*
 * @(#)RemoveAction.java
 * 
 * Copyright (c) 2011 by the original authors of JHotDraw
 * and all its contributors.
 * All rights reserved.
 * 
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms. 
 */
package org.jhotdraw.app.action.edit;

import edu.umd.cs.findbugs.annotations.Nullable;
import javax.swing.JComponent;

/**
 * Same as {@code DeleteAction} but with the title "Remove".
 * <p>
 * Use this action in places where an object is not actually deleted, but
 * just removed from the application.
 *
 * @author Werner Randelshofer
 * @version 1.0 2011-07-28 Created.
 */
public class RemoveAction extends DeleteAction {
     /** The ID for this action. */
    public final static String ID = "edit.remove";
    
     /** Creates a new instance which acts on the currently focused component. */
    public RemoveAction() {
        this(null,ID);
    }

    /** Creates a new instance which acts on the specified component.
     *
     * @param target The target of the action. Specify null for the currently
     * focused component.
     */
    public RemoveAction(@Nullable JComponent target) {
        this(target,ID);
    }
    /** Creates a new instance which acts on the specified component.
     *
     * @param target The target of the action. Specify null for the currently
     * focused component.
     */
    public RemoveAction(@Nullable JComponent target, String id) {
        super(target,id);
    }
}
