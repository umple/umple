/*
 * @(#)DefaultDrawingEditor.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw;

import org.jhotdraw.app.action.edit.PasteAction;
import org.jhotdraw.app.action.edit.CutAction;
import org.jhotdraw.app.action.edit.DeleteAction;
import org.jhotdraw.app.action.edit.CopyAction;
import org.jhotdraw.app.action.edit.SelectAllAction;
import org.jhotdraw.draw.tool.Tool;
import org.jhotdraw.draw.event.ToolEvent;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import org.jhotdraw.beans.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.*;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.draw.event.ToolAdapter;
import static org.jhotdraw.draw.AttributeKeys.*;

/**
 * A default implementation of {@link DrawingEditor}.
 *
 * XXX - DefaultDrawingEditor should not publicly implement ToolListener.
 *
 * @author Werner Randelshofer
 * @version $Id: DefaultDrawingEditor.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class DefaultDrawingEditor extends AbstractBean implements DrawingEditor {

    private HashMap<AttributeKey, Object> defaultAttributes = new HashMap<AttributeKey, Object>();
    private HashMap<AttributeKey, Object> handleAttributes = new HashMap<AttributeKey, Object>();
    private Tool tool;
    private HashSet<DrawingView> views;
    private DrawingView activeView;
    private boolean isEnabled = true;
    private ToolHandler toolHandler;

    private class ToolHandler extends ToolAdapter {

        @Override
        public void areaInvalidated(ToolEvent evt) {
            Rectangle r = evt.getInvalidatedArea();
            evt.getView().getComponent().repaint(r.x, r.y, r.width, r.height);
        }

        @Override
        public void toolStarted(ToolEvent evt) {
            setActiveView(evt.getView());
        }

        @Override
        public void boundsInvalidated(ToolEvent evt) {
            Drawing d = evt.getView().getDrawing();
            for (DrawingView v : views) {
                if (v.getDrawing() == d) {
                    JComponent c = v.getComponent();
                    c.revalidate();
                }
            }
        }
    }
    /**
     * The input map of the drawing editor.
     */
    private InputMap inputMap;
    /**
     * The action map of the drawing editor.
     */
    private ActionMap actionMap;
    /**
     * The focus handler.
     */
    private FocusListener focusHandler = new FocusListener() {

    @Override
        public void focusGained(FocusEvent e) {
            setActiveView((DrawingView) findView((Container) e.getSource()));
        }

    @Override
        public void focusLost(FocusEvent e) {
            /*
            if (! e.isTemporary()) {
            setFocusedView(null);
            }*/
        }
    };

    /** Creates a new instance. */
    public DefaultDrawingEditor() {
        toolHandler = new ToolHandler();
        setDefaultAttribute(FILL_COLOR, Color.white);
        setDefaultAttribute(STROKE_COLOR, Color.black);
        setDefaultAttribute(TEXT_COLOR, Color.black);

        views = new HashSet<DrawingView>();
        inputMap = createInputMap();
        actionMap = createActionMap();
    }

    @Override
    public void setTool(Tool newValue) {
        Tool oldValue = tool;

        if (newValue == tool) {
            return;
        }
        if (tool != null) {
            for (DrawingView v : views) {
                v.removeMouseListener(tool);
                v.removeMouseMotionListener(tool);
                v.removeKeyListener(tool);
            }
            tool.deactivate(this);
            tool.removeToolListener(toolHandler);
        }
        tool = newValue;
        if (tool != null) {
            tool.activate(this);
            for (DrawingView v : views) {
                v.addMouseListener(tool);
                v.addMouseMotionListener(tool);
                v.addKeyListener(tool);
            }
            tool.addToolListener(toolHandler);
        }

        firePropertyChange(TOOL_PROPERTY, oldValue, newValue);
    }

    @Override
    public void setActiveView(DrawingView newValue) {
        DrawingView oldValue = activeView;
        activeView = newValue;

        firePropertyChange(ACTIVE_VIEW_PROPERTY, oldValue, newValue);
    }

    @Override
    public Tool getTool() {
        return tool;
    }

    @Override
    public DrawingView getActiveView() {
        return activeView;
    }

    private void updateActiveView() {
        DrawingView aView = null;
        for (DrawingView v : views) {
            if (v.getComponent().isFocusOwner()) {
                setActiveView(v);
                return;
            }
            aView = v;
        }
        setActiveView(aView);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void applyDefaultAttributesTo(Figure f) {
        for (Map.Entry<AttributeKey, Object> entry : defaultAttributes.entrySet()) {
            f.set(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public <T> T getDefaultAttribute(AttributeKey<T> key) {
        if (defaultAttributes.containsKey(key)) {
            return key.get(defaultAttributes);
        } else {
            return key.getDefaultValue();
        }
    }

    @Override
    public void setDefaultAttribute(AttributeKey key, Object newValue) {
        Object oldValue = defaultAttributes.put(key, newValue);
        firePropertyChange(DEFAULT_ATTRIBUTE_PROPERTY_PREFIX+key.getKey(), oldValue, newValue);
    }

    @Override
    public void remove(DrawingView view) {
        view.getComponent().removeFocusListener(focusHandler);
        views.remove(view);
        if (tool != null) {
            view.removeMouseListener(tool);
            view.removeMouseMotionListener(tool);
            view.removeKeyListener(tool);
        }

        view.removeNotify(this);
        if (activeView == view) {
            view = (views.size() > 0) ? views.iterator().next() : null;
        }
        updateActiveView();
    }

    @Override
    public void add(DrawingView view) {
        views.add(view);
        view.addNotify(this);
        view.getComponent().addFocusListener(focusHandler);
        if (tool != null) {
            view.addMouseListener(tool);
            view.addMouseMotionListener(tool);
            view.addKeyListener(tool);
        }
        updateActiveView();
    }

    @Override
    public void setCursor(Cursor c) {
    }

    @Override
    public Collection<DrawingView> getDrawingViews() {
        return Collections.unmodifiableCollection(views);
    }

    @Override
    public DrawingView findView(Container c) {
        for (DrawingView v : views) {
            if (v.getComponent() == c) {
                return v;
            }
        }
        return null;
    }

    @Override
    public void setEnabled(boolean newValue) {
        if (newValue != isEnabled) {
            boolean oldValue = isEnabled;
            isEnabled = newValue;
            firePropertyChange("enabled", oldValue, newValue);
        }
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public Map<AttributeKey, Object> getDefaultAttributes() {
        return Collections.unmodifiableMap(defaultAttributes);
    }

    @Override
    public void setHandleAttribute(AttributeKey key, Object value) {
        handleAttributes.put(key, value);
    }

    @Override
    public <T> T getHandleAttribute(AttributeKey<T> key) {
        if (handleAttributes.containsKey(key)) {
            return key.get(handleAttributes);
        } else {
            return key.getDefaultValue();
        }
    }

    @Override
    public void setInputMap(InputMap newValue) {
        InputMap oldValue = inputMap;
        inputMap = newValue;
        firePropertyChange(INPUT_MAP_PROPERTY, oldValue, newValue);
    }

    @Override
    public InputMap getInputMap() {
        return inputMap;
    }

    @Override
    public void setActionMap(ActionMap newValue) {
        ActionMap oldValue = actionMap;
        actionMap = newValue;
        firePropertyChange(ACTION_MAP_PROPERTY, oldValue, newValue);
    }

    @Override
    public ActionMap getActionMap() {
        return actionMap;
    }

    /** Override this method to create a tool-specific input map, which
     * overrides the input map of the drawing edtior.
     * <p>
     * The implementation of this class creates an input map for the following
     * action ID's:
     * <ul>
     * <li>DeleteAction</li>
     * <li>SelectAllAction/li>
     * <li>IncreaseHandleDetailLevelAction</li>
     * <li>MoveConstrainedAction.West, .East, .North, .South</li>
     * <li>MoveAction.West, .East, .North, .South</li>
     * <li>CutAction</li>
     * <li>CopyAction</li>
     * <li>PasteAction</li>
     * </ul>
     */
    protected InputMap createInputMap() {
        InputMap m = new InputMap();

        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), DeleteAction.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), DeleteAction.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), SelectAllAction.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK), SelectAllAction.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.META_DOWN_MASK), SelectAllAction.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), IncreaseHandleDetailLevelAction.ID);

        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), MoveConstrainedAction.West.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), MoveConstrainedAction.East.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), MoveConstrainedAction.North.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), MoveConstrainedAction.South.ID);

        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, InputEvent.ALT_DOWN_MASK), MoveAction.West.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, InputEvent.ALT_DOWN_MASK), MoveAction.East.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.ALT_DOWN_MASK), MoveAction.North.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.ALT_DOWN_MASK), MoveAction.South.ID);

        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, InputEvent.SHIFT_DOWN_MASK), MoveAction.West.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, InputEvent.SHIFT_DOWN_MASK), MoveAction.East.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.SHIFT_DOWN_MASK), MoveAction.North.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.SHIFT_DOWN_MASK), MoveAction.South.ID);

        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, InputEvent.CTRL_DOWN_MASK), MoveAction.West.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, InputEvent.CTRL_DOWN_MASK), MoveAction.East.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, InputEvent.CTRL_DOWN_MASK), MoveAction.North.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, InputEvent.CTRL_DOWN_MASK), MoveAction.South.ID);

        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK), CopyAction.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.META_DOWN_MASK), CopyAction.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK), PasteAction.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.META_DOWN_MASK), PasteAction.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK), CutAction.ID);
        m.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.META_DOWN_MASK), CutAction.ID);


        return m;
    }

    /** Override this method to create a tool-specific action map, which
     * overrides the action map of the drawing edtior.
     * <p>
     * The implementation of this class creates an action map which maps
     * the following action ID's to the classes which define them:
     * <ul>
     * <li>DeleteAction</li>
     * <li>SelectAllAction/li>
     * <li>IncreaseHandleDetailLevelAction</li>
     * <li>MoveConstrainedAction.West, .East, .North, .South</li>
     * <li>MoveAction.West, .East, .North, .South</li>
     * <li>CutAction</li>
     * <li>CopyAction</li>
     * <li>PasteAction</li>
     * </ul>
     */
    protected ActionMap createActionMap() {
        ActionMap m = new ActionMap();

        m.put(DeleteAction.ID, new DeleteAction());
        m.put(SelectAllAction.ID, new SelectAllAction());
        m.put(IncreaseHandleDetailLevelAction.ID, new IncreaseHandleDetailLevelAction(this));

        m.put(MoveAction.East.ID, new MoveAction.East(this));
        m.put(MoveAction.West.ID, new MoveAction.West(this));
        m.put(MoveAction.North.ID, new MoveAction.North(this));
        m.put(MoveAction.South.ID, new MoveAction.South(this));
        m.put(MoveConstrainedAction.East.ID, new MoveConstrainedAction.East(this));
        m.put(MoveConstrainedAction.West.ID, new MoveConstrainedAction.West(this));
        m.put(MoveConstrainedAction.North.ID, new MoveConstrainedAction.North(this));
        m.put(MoveConstrainedAction.South.ID, new MoveConstrainedAction.South(this));

        m.put(CutAction.ID, new CutAction());
        m.put(CopyAction.ID, new CopyAction());
        m.put(PasteAction.ID, new PasteAction());

        return m;
    }
}
