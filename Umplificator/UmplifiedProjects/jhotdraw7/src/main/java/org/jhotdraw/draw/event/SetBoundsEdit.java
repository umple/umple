/*
 * @(#)SetBoundsEdit.java
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
import java.awt.geom.*;
/**
 * SetBoundsEdit.
 *
 * @author Werner Randelshofer
 * @version $Id: SetBoundsEdit.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class SetBoundsEdit extends AbstractUndoableEdit {
    private AbstractFigure owner;
    private Point2D.Double oldAnchor, oldLead;
    private Point2D.Double newAnchor, newLead;
    
    /** Creates a new instance. */
    public SetBoundsEdit(AbstractFigure owner, Point2D.Double oldAnchor, Point2D.Double oldLead, Point2D.Double newAnchor, Point2D.Double newLead) {
        this.owner = owner;
        this.oldAnchor = oldAnchor;
        this.oldLead = oldLead;
        this.newAnchor = newAnchor;
        this.newLead = newLead;
    }
    @Override
    public String getPresentationName() {
        // XXX - Localize me
        return "Abmessungen \u00e4ndern";
    }
    
    @Override
    public boolean addEdit(UndoableEdit anEdit) {
        if (anEdit instanceof SetBoundsEdit) {
            SetBoundsEdit that = (SetBoundsEdit) anEdit;
            if (that.owner == this.owner) {
                this.newAnchor = that.newAnchor;
                this.newLead = that.newLead;
                that.die();
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean replaceEdit(UndoableEdit anEdit) {
        if (anEdit instanceof SetBoundsEdit) {
            SetBoundsEdit that = (SetBoundsEdit) anEdit;
            if (that.owner == this.owner) {
                that.oldAnchor = this.oldAnchor;
                that.oldLead = this.oldLead;
                this.die();
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void redo() throws CannotRedoException {
        super.redo();
        owner.willChange();
        owner.setBounds(newAnchor, newLead);
        owner.changed();
    }
    @Override
    public void undo() throws CannotUndoException {
        super.undo();
        owner.willChange();
        owner.setBounds(oldAnchor, oldLead);
        owner.changed();
    }
}

