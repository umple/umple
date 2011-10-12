/*
 * @(#)DrawingEditorProxy.java
 *
 * Copyright (c) 2007-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.draw;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.tool.Tool;
import java.awt.Container;
import java.awt.Cursor;
import java.beans.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import org.jhotdraw.beans.AbstractBean;

/**
 * DrawingEditorProxy.
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Proxy</em><br>
 * To remove the need for null-handling, {@code AbstractTool} makes use of
 * a proxy for {@code DrawingEditor}.
 * Subject: {@link DrawingEditor}; Proxy: {@link DrawingEditorProxy};
 * Client: {@link org.jhotdraw.draw.tool.AbstractTool}.
 * <hr>
 *
 *
 * @author Werner Randelshofer
 * @version $Id: DrawingEditorProxy.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class DrawingEditorProxy extends AbstractBean implements DrawingEditor {
    @Nullable private DrawingEditor target;

    private class Forwarder implements PropertyChangeListener, Serializable {
    @Override
          public void propertyChange(PropertyChangeEvent evt) {
              firePropertyChange(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
          }
    }
    private Forwarder forwarder;
    
    /** Creates a new instance. */
    public DrawingEditorProxy() {
        forwarder = new Forwarder();
    }
    
    /**
     * Sets the target of the proxy.
     */
    public void setTarget(@Nullable DrawingEditor newValue) {
        if (target != null) {
            target.removePropertyChangeListener(forwarder);
        }
        this.target = newValue;
        if (target != null) {
            target.addPropertyChangeListener(forwarder);
        }
    }
    /**
     * Gets the target of the proxy.
     */
    @Nullable public DrawingEditor getTarget() {
        return target;
    }
    
    
    @Override
    public void add(DrawingView view) {
        target.add(view);
    }
    
    @Override
    public void remove(DrawingView view) {
        target.remove(view);
    }
    
    @Override
    public Collection<DrawingView> getDrawingViews() {
        return target.getDrawingViews();
    }
    
    @Override
    public DrawingView getActiveView() {
        return (target == null) ? null : target.getActiveView();
    }
    
    @Override
    public void setActiveView(DrawingView newValue) {
        target.setActiveView(newValue);
    }

    @Nullable
    public DrawingView getFocusedView() {
        return (target == null) ? null : target.getActiveView();
    }
    
    @Override
    public void setTool(Tool t) {
        target.setTool(t);
    }
    
    @Override
    public Tool getTool() {
        return target.getTool();
    }
    
    @Override
    public void setCursor(Cursor c) {
        target.setCursor(c);
    }
    
    @Override
    public DrawingView findView(Container c) {
        return target.findView(c);
    }
    
    @Override
    public <T> void setDefaultAttribute(AttributeKey<T> key, T value) {
        target.setDefaultAttribute(key, value);
    }
    
    @Override
    public <T> T getDefaultAttribute(AttributeKey<T> key) {
        return target.getDefaultAttribute(key);
    }
    
    @Override
    public void applyDefaultAttributesTo(Figure f) {
        target.applyDefaultAttributesTo(f);
    }
    
    @Override
    public Map<AttributeKey, Object> getDefaultAttributes() {
        return target.getDefaultAttributes();
    }
    
    @Override
    public void setEnabled(boolean newValue) {
        target.setEnabled(newValue);
    }
    
    @Override
    public boolean isEnabled() {
        return target.isEnabled();
    }

    @Override
    public <T> void setHandleAttribute(AttributeKey<T> key, T value) {
        target.setHandleAttribute(key, value);
    }

    @Override
    public <T> T getHandleAttribute(AttributeKey<T> key) {
        return target.getHandleAttribute(key);
    }

    @Override
    public void setInputMap(InputMap newValue) {
        target.setInputMap(newValue);
    }

    @Override
    public InputMap getInputMap() {
        return target.getInputMap();
    }

    @Override
    public void setActionMap(ActionMap newValue) {
        target.setActionMap(newValue);
    }

    @Override
    public ActionMap getActionMap() {
        return target.getActionMap();
    }
}
