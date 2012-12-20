/*
 * @(#)TextEditingTool.java
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
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoableEdit;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * A tool to edit figures which implement the {@code TextHolderFigure} interface,
 * such as {@code TextFigure}.
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
 * @version $Id: TextEditingTool.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class TextEditingTool extends AbstractTool implements ActionListener {

    @Nullable private FloatingTextField textField;
    @Nullable private TextHolderFigure typingTarget;

    /** Creates a new instance. */
    public TextEditingTool(TextHolderFigure typingTarget) {
        this.typingTarget = typingTarget;
    }

    @Override
    public void deactivate(DrawingEditor editor) {
        endEdit();
        super.deactivate(editor);
    }

    /**
     * If the pressed figure is a TextHolderFigure it can be edited.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (typingTarget != null) {
            beginEdit(typingTarget);
            updateCursor(getView(), e.getPoint());
        }
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
                typingTarget.willChange();
                typingTarget.setText(newText);
                typingTarget.changed();
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
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            fireToolDone();
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        endEdit();
        fireToolDone();
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

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
