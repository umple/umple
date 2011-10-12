/*
 * @(#)ODGDrawingPanel.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.odg;

import org.jhotdraw.app.action.edit.PasteAction;
import org.jhotdraw.app.action.edit.CutAction;
import org.jhotdraw.app.action.edit.DuplicateAction;
import org.jhotdraw.app.action.edit.CopyAction;
import org.jhotdraw.app.action.edit.SelectAllAction;
import org.jhotdraw.draw.tool.CreationTool;
import org.jhotdraw.draw.tool.TextAreaCreationTool;
import org.jhotdraw.gui.JPopupButton;
import org.jhotdraw.samples.svg.action.*;
import org.jhotdraw.samples.svg.figures.*;
import org.jhotdraw.undo.*;
import org.jhotdraw.util.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.*;
/**
 * ODGDrawingPanel.
 * 
 * 
 * @author Werner Randelshofer
 * @version $Id: ODGDrawingPanel.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ODGDrawingPanel extends JPanel  {
    private UndoRedoManager undoManager;
    private Drawing drawing;
    private DrawingEditor editor;
    
    /** Creates new instance. */
    public ODGDrawingPanel() {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        initComponents();
        undoManager = new UndoRedoManager();
        editor = new DefaultDrawingEditor();
        editor.add(view);
        
        addCreationButtonsTo(creationToolbar, editor);
        ButtonFactory.addAttributesButtonsTo(attributesToolbar, editor);
        
        JPopupButton pb = new JPopupButton();
        pb.setItemFont(UIManager.getFont("MenuItem.font"));
        labels.configureToolBarButton(pb, "actions");
        pb.add(new DuplicateAction());
        pb.addSeparator();
        pb.add(new GroupAction(editor));
        pb.add(new UngroupAction(editor));
        pb.addSeparator();
        pb.add(new BringToFrontAction(editor));
        pb.add(new SendToBackAction(editor));
        pb.addSeparator();
        pb.add(new CutAction());
        pb.add(new CopyAction());
        pb.add(new PasteAction());
        pb.add(new SelectAllAction());
        pb.add(new SelectSameAction(editor));
        pb.addSeparator();
        pb.add(undoManager.getUndoAction());
        pb.add(undoManager.getRedoAction());
       // FIXME - We need a toggle grid action
       // pb.addSeparator();
       // pb.add(new ToggleGridAction(editor));
        
        JMenu m = new JMenu(labels.getString("view.zoomFactor.text"));
        JRadioButtonMenuItem rbmi;
        ButtonGroup group = new ButtonGroup();
        m.add(rbmi = new JRadioButtonMenuItem(new ZoomAction(editor, 0.1, null)));
        group.add(rbmi);
        m.add(rbmi = new JRadioButtonMenuItem(new ZoomAction(editor, 0.25, null)));
        group.add(rbmi);
        m.add(rbmi = new JRadioButtonMenuItem(new ZoomAction(editor, 0.5, null)));
        group.add(rbmi);
        m.add(rbmi = new JRadioButtonMenuItem(new ZoomAction(editor, 0.75, null)));
        group.add(rbmi);
        m.add(rbmi = new JRadioButtonMenuItem(new ZoomAction(editor, 1.0, null)));
        rbmi.setSelected(true);
        group.add(rbmi);
        m.add(rbmi = new JRadioButtonMenuItem(new ZoomAction(editor, 1.25, null)));
        group.add(rbmi);
        m.add(rbmi = new JRadioButtonMenuItem(new ZoomAction(editor, 1.5, null)));
        group.add(rbmi);
        m.add(rbmi = new JRadioButtonMenuItem(new ZoomAction(editor, 2, null)));
        group.add(rbmi);
        m.add(rbmi = new JRadioButtonMenuItem(new ZoomAction(editor, 3, null)));
        group.add(rbmi);
        m.add(rbmi = new JRadioButtonMenuItem(new ZoomAction(editor, 4, null)));
        group.add(rbmi);
        pb.add(m);
        pb.setFocusable(false);
        creationToolbar.addSeparator();
        creationToolbar.add(pb);
        
        
        DefaultDrawing drawing = new DefaultDrawing();
        view.setDrawing(drawing);
        drawing.addUndoableEditListener(undoManager);
        
    }
    
    public void setDrawing(Drawing d) {
        undoManager.discardAllEdits();
        view.getDrawing().removeUndoableEditListener(undoManager);
        view.setDrawing(d);
        d.addUndoableEditListener(undoManager);
    }
    public Drawing getDrawing() {
        return view.getDrawing();
    }
    public DrawingView getView() {
        return view;
    }
    public DrawingEditor getEditor() {
        return editor;
    }
    public static Collection<Action> createSelectionActions(DrawingEditor editor) {
        LinkedList<Action> a = new LinkedList<Action>();
        a.add(new DuplicateAction());
        
        a.add(null); // separator
        a.add(new GroupAction(editor, new SVGGroupFigure()));
        a.add(new UngroupAction(editor, new SVGGroupFigure()));
        a.add(new CombineAction(editor));
        a.add(new SplitAction(editor));
        
        a.add(null); // separator
        a.add(new BringToFrontAction(editor));
        a.add(new SendToBackAction(editor));
        
        return a;
    }
    private void addCreationButtonsTo(JToolBar tb, final DrawingEditor editor) {
        // AttributeKeys for the entitie sets
        HashMap<AttributeKey,Object> attributes;
        
        ResourceBundleUtil drawLabels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        
        ButtonFactory.addSelectionToolTo(tb, editor, 
                ButtonFactory.createDrawingActions(editor), 
                createSelectionActions(editor)
                );
        tb.addSeparator();
        
        attributes = new HashMap<AttributeKey,Object>();
        attributes.put(AttributeKeys.FILL_COLOR, Color.white);
        attributes.put(AttributeKeys.STROKE_COLOR, Color.black);
        ButtonFactory.addToolTo(tb, editor, new CreationTool(new SVGRectFigure(), attributes), "edit.createRectangle", drawLabels);
        ButtonFactory.addToolTo(tb, editor, new CreationTool(new SVGEllipseFigure(), attributes), "edit.createEllipse", drawLabels);
        ButtonFactory.addToolTo(tb, editor, new PathTool(new SVGPathFigure(), new SVGBezierFigure(true), attributes), "edit.createPolygon", drawLabels);
        attributes = new HashMap<AttributeKey,Object>();
        attributes.put(AttributeKeys.FILL_COLOR, null);
        attributes.put(AttributeKeys.STROKE_COLOR, Color.black);
        ButtonFactory.addToolTo(tb, editor, new CreationTool(new SVGPathFigure(), attributes), "edit.createLine", drawLabels);
        ButtonFactory.addToolTo(tb, editor, new PathTool(new SVGPathFigure(), new SVGBezierFigure(false), attributes), "edit.createScribble", drawLabels);
        attributes = new HashMap<AttributeKey,Object>();
        attributes.put(AttributeKeys.FILL_COLOR, Color.black);
        attributes.put(AttributeKeys.STROKE_COLOR, null);
        ButtonFactory.addToolTo(tb, editor, new CreationTool(new SVGTextFigure(), attributes), "edit.createText", drawLabels);
        TextAreaCreationTool tat = new TextAreaCreationTool(new SVGTextAreaFigure(), attributes);
        tat.setRubberbandColor(Color.BLACK);
        ButtonFactory.addToolTo(tb, editor, tat, "edit.createTextArea", drawLabels);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        toolButtonGroup = new javax.swing.ButtonGroup();
        scrollPane = new javax.swing.JScrollPane();
        view = new org.jhotdraw.draw.DefaultDrawingView();
        jPanel1 = new javax.swing.JPanel();
        creationToolbar = new javax.swing.JToolBar();
        attributesToolbar = new javax.swing.JToolBar();

        setLayout(new java.awt.BorderLayout());

        scrollPane.setViewportView(view);

        add(scrollPane, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        creationToolbar.setFloatable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(creationToolbar, gridBagConstraints);

        attributesToolbar.setFloatable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(attributesToolbar, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.SOUTH);

    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar attributesToolbar;
    private javax.swing.JToolBar creationToolbar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.ButtonGroup toolButtonGroup;
    private org.jhotdraw.draw.DefaultDrawingView view;
    // End of variables declaration//GEN-END:variables
    
}
