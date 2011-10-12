/*
 * @(#)ProjectPropertyAction.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.app.action.view;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.event.*;
import java.beans.*;
import org.jhotdraw.app.Application;
import org.jhotdraw.app.View;
import org.jhotdraw.app.action.AbstractViewAction;
import org.jhotdraw.app.action.ActionUtil;

/**
 * ToggleViewPropertyAction.
 *
 * @author Werner Randelshofer.
 * @version $Id: ToggleViewPropertyAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ToggleViewPropertyAction extends AbstractViewAction {
    final private String propertyName;
    private Class[] parameterClass;
    private Object selectedPropertyValue;
    private Object deselectedPropertyValue;
    final private String setterName;
    final private String getterName;
    
    private PropertyChangeListener viewListener = new PropertyChangeListener() {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName() == propertyName) { // Strings get interned
                updateView();
            }
        }
    };
    
    /** Creates a new instance. */
    public ToggleViewPropertyAction(Application app, @Nullable View view, String propertyName) {
        this(app, view, propertyName, Boolean.TYPE, true, false);
    }
    public ToggleViewPropertyAction(Application app, @Nullable View view, String propertyName, Class propertyClass,
            Object selectedPropertyValue, Object deselectedPropertyValue) {
        super(app, view);
        if (propertyName==null) {
            throw new IllegalArgumentException("Parameter propertyName must not be null");
        }
        this.propertyName = propertyName;
        this.parameterClass = new Class[] { propertyClass };
        this.selectedPropertyValue = selectedPropertyValue;
        this.deselectedPropertyValue = deselectedPropertyValue;
        setterName = "set"+Character.toUpperCase(propertyName.charAt(0)) +
                propertyName.substring(1);
        getterName = ((propertyClass == Boolean.TYPE || propertyClass == Boolean.class) ? "is" : "get")+
                Character.toUpperCase(propertyName.charAt(0)) +
                propertyName.substring(1);
        updateView();
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        View p = getActiveView();
        Object value = getCurrentValue();
        Object newValue = (value == selectedPropertyValue ||
                        value != null && selectedPropertyValue != null &&
                        value.equals(selectedPropertyValue)) ?
                            deselectedPropertyValue :
                            selectedPropertyValue;
        try {
            p.getClass().getMethod(setterName, parameterClass).invoke(p, new Object[] {newValue});
        } catch (Throwable e) {
                InternalError error = new InternalError("No "+setterName+" method on "+p);
            error.initCause(e);
            throw error;
        }
    }

    @Nullable
    private Object getCurrentValue() {
        View p = getActiveView();
        if (p != null) {
            try {
                return p.getClass().getMethod(getterName, (Class[]) null).invoke(p);
            } catch (Throwable e) {
                InternalError error = new InternalError("No "+getterName+" method on "+p);
                error.initCause(e);
                throw error;
            }
        }
        return null;
    }
    
    
    @Override
    protected void installViewListeners(View p) {
        super.installViewListeners(p);
        p.addPropertyChangeListener(viewListener);
        updateView();
    }
    /**
     * Installs listeners on the view object.
     */
    @Override
    protected void uninstallViewListeners(View p) {
        super.uninstallViewListeners(p);
        p.removePropertyChangeListener(viewListener);
    }
    
    @Override protected void updateView() {
        if (getterName == null) {
            // This happens, when updateView is called before the constructor
            // has been completed.
            return;
        }
        boolean isSelected = false;
        View p = getActiveView();
        if (p != null) {
            try {
                Object value = p.getClass().getMethod(getterName, (Class[]) null).invoke(p);
                isSelected = value == selectedPropertyValue ||
                        value != null && selectedPropertyValue != null &&
                        value.equals(selectedPropertyValue);
            } catch (Throwable e) {
                InternalError error = new InternalError("No "+getterName+" method on "+p+" for property "+propertyName);
                error.initCause(e);
                throw error;
            }
        }
        putValue(ActionUtil.SELECTED_KEY, isSelected);
    }
}
