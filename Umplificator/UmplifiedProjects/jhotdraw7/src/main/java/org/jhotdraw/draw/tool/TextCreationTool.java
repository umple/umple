/*
 * @(#)TextCreationTool.java
 *
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */


package org.jhotdraw.draw.tool;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.text.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.text.FloatingTextField;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.util.*;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoableEdit;
import org.jhotdraw.util.ResourceBundleUtil;
/**
 * A tool to create figures which implement the {@code TextHolderFigure}
 * interface, such as {@code TextFigure}. The figure to be created is specified
 * by a prototype.
 * <p>
 * To create a figure using this tool, the user does the following mouse
 * gestures on a DrawingView:
 * <ol>
 * <li>Press the mouse button over an area on the DrawingView on which there
 * isn't a text figure present. This defines the location of the figure.</li>
 * </ol>
 * When the user has performed this mouse gesture, the TextCreationTool overlays
 * a text field over the drawing where the user can enter the text for the Figure.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Framework</em><br>
 * The text creation and editing tools and the {@code TextHolderFigure}
 * interface define together the contracts of a smaller framework inside of the
 * JHotDraw framework for  structured drawing editors.<br>
 * Contract: {@link TextHolderFigure}, {@link TextCreationTool},
 * {@link TextAreaCreationTool}, {@link TextEditingTool},
 * {@link TextAreaEditingTool}, {@link FloatingTextField},
 * {@link FloatingTextArea}.
 *
 * <p><em>Prototype</em><br>
 * The text creation tools create new figures by cloning a prototype
 * {@code TextHolderFigure} object.<br>
 * Prototype: {@link TextHolderFigure}; Client: {@link TextCreationTool},
 * {@link TextAreaCreationTool}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: TextCreationTool.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class TextCreationTool extends CreationTool implements ActionListener {
    @Nullable private FloatingTextField   textField;
    @Nullable private TextHolderFigure  typingTarget;
    
    /** Creates a new instance. */
    public TextCreationTool(TextHolderFigure prototype) {
        super(prototype);
    }
    /** Creates a new instance. */
    public TextCreationTool(TextHolderFigure prototype, Map<AttributeKey,Object> attributes) {
        super(prototype, attributes);
    }
    
    @Override
    public void deactivate(DrawingEditor editor) {
        endEdit();
        super.deactivate(editor);
    }
    /**
     * Creates a new figure at the location where the mouse was pressed.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        // Note: The search sequence used here, must be
        // consistent with the search sequence used by the
        // HandleTracker, SelectAreaTracker, DelegationSelectionTool, SelectionTool.

        if (typingTarget != null) {
            endEdit();
            if (isToolDoneAfterCreation()) {
                fireToolDone();
            }
        } else {
            super.mousePressed(e);
            // update view so the created figure is drawn before the floating text
            // figure is overlaid. 
            TextHolderFigure textHolder = (TextHolderFigure)getCreatedFigure();
            getView().clearSelection();
            getView().addToSelection(textHolder);
            beginEdit(textHolder);
            updateCursor(getView(), e.getPoint());
        }
    }
    
    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
    }
    
    protected void beginEdit(TextHolderFigure textHolder) {
        if (textField == null) {
            textField = new FloatingTextField();
            textField.addActionListener(this);
        }
        
        if (textHolder != typingTarget && typingTarget != null) {
            endEdit();
        }
        
        textField.createOverlay(getView(), textHolder);
        textField.requestFocus();
        typingTarget = textHolder;
    }
    
    
    @Override
    public void mouseReleased(MouseEvent evt) {
    }
    
    protected void endEdit() {
        if (typingTarget != null) {
            typingTarget.willChange();

            final TextHolderFigure editedFigure = typingTarget;
            final String oldText = typingTarget.getText();
            final String newText = textField.getText();

            if (newText.length() > 0) {
                typingTarget.setText(newText);
            } else {
                if (createdFigure != null) {
                    getDrawing().remove((Figure)getAddedFigure());
                // XXX - Fire undoable edit here!!
                } else {
                    typingTarget.setText("");
                    typingTarget.changed();
                }
            }
            UndoableEdit edit = new AbstractUndoableEdit() {

                @Override
                public String getPresentationName() {
                    ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
                    return labels.getString("attribute.text.text");
                }

                @Override
                public void undo() {
                    super.undo();
                    editedFigure.willChange();
                    editedFigure.setText(oldText);
                    editedFigure.changed();
                }

                @Override
                public void redo() {
                    super.redo();
                    editedFigure.willChange();
                    editedFigure.setText(newText);
                    editedFigure.changed();
                }
            };
            getDrawing().fireUndoableEditHappened(edit);

            typingTarget.changed();
            typingTarget = null;
            
            textField.endOverlay();
        }
        //	        view().checkDamage();
    }
    
    @Override
    public void keyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE || isToolDoneAfterCreation()) {
            fireToolDone();
        }
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        endEdit();
        if (isToolDoneAfterCreation()) {
            fireToolDone();
        }
    }
    @Override
    protected void creationFinished(Figure createdFigure) {
        beginEdit((TextHolderFigure) createdFigure);
        updateCursor(getView(), new Point(0,0));
    }
    
    public boolean isEditing() {
        return typingTarget != null;
    }
    
    @Override
    public void updateCursor(DrawingView view, Point p) {
        if (view.isEnabled()) {
            view.setCursor(Cursor.getPredefinedCursor(isEditing() ? Cursor.DEFAULT_CURSOR : Cursor.CROSSHAIR_CURSOR));
        } else {
            view.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        }
    }
}
