/*
 * @(#)PropertyChangeEdit.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.undo;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.UndoableEdit;

/**
 * An {@code UndoableEdit} event which can undo a change of a JavaBeans property.
 *
 * @author Werner Randelshofer
 * @version $Id: PropertyChangeEdit.java 740 2011-02-15 14:10:59Z rawcoder $
 */
public class PropertyChangeEdit extends AbstractUndoableEdit {

    /**
     * The object to be provided as the "source" of the JavaBeans property.
     */
    private Object source;
    /**
     * The name of the JavaBeans property.
     */
    private String propertyName;
    /**
     * The old value of the JavaBeans property.
     */
    private Object oldValue;
    /**
     * The new value of the JavaBeans property.
     */
    private Object newValue;
    /** The type of the property. */
    private Class type;
    private String presentationName;

    /** Creates a new PropertyChangeEdit. */
    public PropertyChangeEdit(Object source, String propertyName, Object oldValue, Object newValue) {
        this(source,propertyName,propertyNameToPresentationName(propertyName),oldValue,newValue);
    }
    
    /** Creates a new PropertyChangeEdit. */
    public PropertyChangeEdit(Object source, String propertyName, String presentationName, Object oldValue, Object newValue) {
        this.source = source;
        this.propertyName = propertyName;
        this.presentationName = presentationName;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    /**
     * Returns the setter for the property.
     *
     * @return the setter method.
     */
    protected Method getSetter() {
        try {
            PropertyDescriptor desc=new PropertyDescriptor(propertyName,source.getClass());
            return desc.getWriteMethod();
        } catch (Exception e) {
            InternalError ie = new InternalError("Couldn't find setter for property \"" + propertyName + "\" in " + source);
            ie.initCause(e);
            throw ie;
        }
    }

    /** Undoes the change. */
    @Override
    public void undo() throws CannotRedoException {
        super.undo();
        try {
            getSetter().invoke(source, oldValue);
        } catch (Exception e) {
            InternalError ie = new InternalError("Couldn't invoke setter for property \"" + propertyName + "\" in " + source);
            ie.initCause(e);
            throw ie;
        }
    }

    /** Redoes the change. */
    @Override
    public void redo() throws CannotRedoException {
        super.redo();
        try {
            getSetter().invoke(source, newValue);
        } catch (Exception e) {
            InternalError ie = new InternalError("Couldn't invoke setter for property \"" + propertyName + "\" in " + source);
            ie.initCause(e);
            throw ie;
        }
    }

    /** Returns the presentation name of the undoable edit.
     * This is the same as the property name, unless you have set a different
     * presentation name.
     */
    @Override
    public String getPresentationName() {
        return presentationName;
    }

    /** Sets the presentation name of the undoable edit.
     */
    public void setPresentationName(String presentationName) {
        this.presentationName = presentationName;
    }

    /** Adds the specified edit to this one, if it is a {@code PropertyChangeEdit}
     * from the same owner and the same property.
     *
     * @param anEdit Edit to be added.
     * @return True if added.
     */
    @Override
    public boolean addEdit(UndoableEdit anEdit) {
        if (anEdit instanceof PropertyChangeEdit) {
            PropertyChangeEdit that = (PropertyChangeEdit) anEdit;
            if (that.source == this.source && that.propertyName.equals(this.propertyName)) {
                this.newValue = that.newValue;
                return true;
            }
        }

        return false;
    }

    /** Returns a string representation of this object useful for debugging. */
    @Override
    public String toString() {
        return super.toString() + " [" + propertyName + "," + oldValue + "," + newValue + "]";
    }

    /** Converts a property name into a presentation name. */
    public static String propertyNameToPresentationName(String s) {
        StringBuilder b = new StringBuilder();
        boolean wasUpperCase = true;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                if (!wasUpperCase) {
                    b.append(' ');
                }
                wasUpperCase = true;
            } else {
                wasUpperCase = false;
            }
            b.append(i==0?Character.toUpperCase(s.charAt(i)):s.charAt(i));

        }
        return b.toString();
    }
}
