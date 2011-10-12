/*
 * @(#)ActionsToolBar.java
 *
 * Copyright (c) 2007-2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.svg.gui;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import org.jhotdraw.app.action.edit.PasteAction;
import org.jhotdraw.app.action.edit.CutAction;
import org.jhotdraw.app.action.edit.DeleteAction;
import org.jhotdraw.app.action.edit.DuplicateAction;
import org.jhotdraw.app.action.edit.CopyAction;
import org.jhotdraw.app.action.edit.ClearSelectionAction;
import org.jhotdraw.app.action.edit.SelectAllAction;
import javax.swing.border.*;
import org.jhotdraw.gui.*;
import org.jhotdraw.undo.*;
import org.jhotdraw.util.*;
import org.jhotdraw.gui.plaf.palette.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.samples.svg.figures.*;

/**
 * ActionsToolBar.
 *
 * @author Werner Randelshofer
 * @version $Id: ActionsToolBar.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ActionsToolBar extends AbstractToolBar {
    @Nullable private UndoRedoManager undoManager;
    private ArrayList<Action> actions;
    private JPopupButton popupButton;

    /** Creates new instance. */
    public ActionsToolBar() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        setName(labels.getString(getID() + ".toolbar"));
    }

    @Override
    public void setEditor(@Nullable DrawingEditor newValue) {
        if (this.editor != null && undoManager != null) {
            this.removePropertyChangeListener(getEventHandler());
        }
        this.editor = newValue;
        if (editor != null && undoManager != null) {
            init();
            updatePopupMenu();
            setDisclosureState(prefs.getInt(getID() + ".disclosureState", 1));
            this.addPropertyChangeListener(getEventHandler());
        }
    }

    public void setUndoManager(UndoRedoManager newValue) {
        if (this.editor != null && newValue != null) {
            this.removePropertyChangeListener(getEventHandler());
        }
        this.undoManager = newValue;
        if (editor != null && newValue != null) {
            init();
            setDisclosureState(prefs.getInt(getID() + ".disclosureState", 1));
            this.addPropertyChangeListener(getEventHandler());
        }
    }

    /** Sets the actions for the "Action" popup menu in the toolbar.
     * <p>
     * This list may contain null items which are used to denote a
     * separator in the popup menu.
     * <p>
     * Set this to null to set the drop down menus to the default actions.
     */
    public void setPopupActions(List<Action> actions) {
        if (actions == null) {
            this.actions = null;
        } else {
            this.actions = new ArrayList<Action>();
            this.actions.addAll(actions);
        }
    }

    /** Gets the actions of the "Action" popup menu in the toolbar.
     * This list may contain null items which are used to denote a
     * separator in the popup menu.
     *
     * @return An unmodifiable list with actions.
     */
    public List<Action> getPopupActions() {
        if (actions == null) {
            actions = new ArrayList<Action>();
        }
        return Collections.unmodifiableList(actions);
    }

    @Override
    protected JComponent createDisclosedComponent(int state) {
        JPanel p = null;

        switch (state) {
            case 1: {
                p = new JPanel();
                p.setOpaque(false);
                p.setBorder(new EmptyBorder(5, 5, 5, 8));

                // Abort if no editor is set
                if (editor == null) {
                    break;
                }

                // Preferences prefs = PreferencesUtil.userNodeForPackage(getClass());

                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");

                GridBagLayout layout = new GridBagLayout();
                p.setLayout(layout);

                GridBagConstraints gbc;
                AbstractButton btn;

                btn = new JButton(undoManager.getUndoAction());
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                btn.setText(null);
                labels.configureToolBarButton(btn, "edit.undo");
                btn.putClientProperty("hideActionText", Boolean.TRUE);
                gbc = new GridBagConstraints();
                gbc.gridy = 0;
                gbc.gridx = 0;
                p.add(btn, gbc);

                btn = new JButton(undoManager.getRedoAction());
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                btn.setText(null);
                labels.configureToolBarButton(btn, "edit.redo");
                btn.putClientProperty("hideActionText", Boolean.TRUE);
                gbc = new GridBagConstraints();
                gbc.gridy = 0;
                gbc.insets = new Insets(0, 3, 0, 0);
                p.add(btn, gbc);


                btn = ButtonFactory.createPickAttributesButton(editor, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                labels.configureToolBarButton(btn, "attributesPick");
                gbc = new GridBagConstraints();
                gbc.gridy = 1;
                gbc.insets = new Insets(3, 0, 0, 0);
                p.add(btn, gbc);

                btn = ButtonFactory.createApplyAttributesButton(editor, disposables);
                btn.setUI((PaletteButtonUI) PaletteButtonUI.createUI(btn));
                labels.configureToolBarButton(btn, "attributesApply");
                gbc = new GridBagConstraints();
                gbc.gridy = 1;
                gbc.insets = new Insets(3, 3, 0, 0);
                p.add(btn, gbc);

                JPopupButton pb = new JPopupButton();
                pb.setUI((PaletteButtonUI) PaletteButtonUI.createUI(pb));
                pb.setItemFont(UIManager.getFont("MenuItem.font"));
                labels.configureToolBarButton(pb, "actions");
                popupButton = pb;
                updatePopupMenu();

                gbc = new GridBagConstraints();
                gbc.gridy = 2;
                gbc.insets = new Insets(3, 0, 0, 0);
                p.add(pb, gbc);
                break;
            }
        }
        return p;
    }

    private void updatePopupMenu() {
        if (popupButton != null) {
            AbstractSelectedAction d;
            JPopupButton pb = popupButton;
            pb.removeAll();
            pb.add(new DuplicateAction());
            pb.addSeparator();
            pb.add(d = new GroupAction(editor, new SVGGroupFigure()));
            disposables.add(d);
            pb.add(d = new UngroupAction(editor, new SVGGroupFigure()));
            disposables.add(d);
            pb.addSeparator();
            pb.add(new CutAction());
            pb.add(new CopyAction());
            pb.add(new PasteAction());
            pb.add(new DeleteAction());
            pb.addSeparator();
            pb.add(new SelectAllAction());
            pb.add(d = new SelectSameAction(editor));
            disposables.add(d);
            pb.add(new ClearSelectionAction());
            if (!getPopupActions().isEmpty()) {
                pb.addSeparator();
                for (Action a : getPopupActions()) {
                    if (a == null) {
                        pb.addSeparator();
                    } else {
                        pb.add(a);
                    }
                }
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected String getID() {
        return "actions";
    }

    @Override
    protected int getDefaultDisclosureState() {
        return 1;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
