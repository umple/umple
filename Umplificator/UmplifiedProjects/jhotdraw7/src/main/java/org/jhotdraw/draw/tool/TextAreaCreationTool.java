/*
 * @(#)TextAreaCreationTool.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
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
import org.jhotdraw.draw.text.FloatingTextArea;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoableEdit;
import org.jhotdraw.geom.*;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * A tool to create new or edit existing figures that implement the TextHolderFigure
 * interface, such as TextAreaFigure. The figure to be created is specified by a
 * prototype.
 * <p>
 * To create a figure using the TextAreaCreationTool, the user does the following mouse
 * gestures on a DrawingView:
 * <ol>
 * <li>Press the mouse button over the DrawingView. This defines the
 * start point of the Figure bounds.</li>
 * <li>Drag the mouse while keeping the mouse button pressed, and then release
 * the mouse button. This defines the end point of the Figure bounds.</li>
 * </ol>
 * When the user has performed these mouse gesture, the TextAreaCreationTool overlays
 * a text area over the drawing where the user can enter the text for the Figure.
 * <p>
 * To edit an existing text figure using the TextAreaCreationTool, the user does the
 * following mouse gesture on a DrawingView:
 * </p>
 * <ol>
 * <li>Press the mouse button over a Figure on the DrawingView.</li>
 * </ol>
 * <p>
 * The TextAreaCreationTool then uses Figure.findFigureInside to find a Figure that
 * implements the TextHolderFigure interface and that is editable. Then it overlays
 * a text area over the drawing where the user can enter the text for the Figure.
 * </p>
 * <p>
 * XXX - Maybe this class should be split up into a CreateTextAreaTool and
 * a EditTextAreaTool.
 * </p>
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
 * @version $Id: TextAreaCreationTool.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class TextAreaCreationTool extends CreationTool implements ActionListener {

    private FloatingTextArea textArea;
    @Nullable private TextHolderFigure typingTarget;
    /**
     * Rubberband color of the tool. When this is null, the tool does not
     * draw a rubberband.
     */
    @Nullable private Color rubberbandColor = null;

    /** Creates a new instance. */
    public TextAreaCreationTool(TextHolderFigure prototype) {
        super(prototype);
    }

    public TextAreaCreationTool(TextHolderFigure prototype, Map<AttributeKey,Object> attributes) {
        super(prototype, attributes);
    }

    /**
     * Sets the rubberband color for the tool. Setting this to null, disables
     * the rubberband.
     *
     * @param c Rubberband color or null.
     */
    public void setRubberbandColor(Color c) {
        rubberbandColor = c;
    }

    @Override
    public void deactivate(DrawingEditor editor) {
        endEdit();
        super.deactivate(editor);
    }

    /**
     * Creates a new figure at the mouse location.
     * If editing is in progress, this finishes editing.
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
        }
    }

    /**
     * This method allows subclasses to do perform additonal user interactions
     * after the new figure has been created.
     * The implementation of this class just invokes fireToolDone.
     */
    @Override
    protected void creationFinished(Figure createdFigure) {
        getView().clearSelection();
        getView().addToSelection(createdFigure);
        beginEdit((TextHolderFigure) createdFigure);
    }
    /*
    public void mouseDragged(java.awt.event.MouseEvent e) {
    }
     */

    @Override
    public void draw(Graphics2D g) {
        if (createdFigure != null && rubberbandColor != null) {
            g.setColor(rubberbandColor);
            g.draw(getView().drawingToView(createdFigure.getBounds()));
        }
    }

    protected void beginEdit(TextHolderFigure textHolder) {
        if (textArea == null) {
            textArea = new FloatingTextArea();

        //textArea.addActionListener(this);
        }

        if (textHolder != typingTarget && typingTarget != null) {
            endEdit();
        }
        textArea.createOverlay(getView(), textHolder);
        textArea.setBounds(getFieldBounds(textHolder), textHolder.getText());
        textArea.requestFocus();
        typingTarget = textHolder;
    }

    private Rectangle2D.Double getFieldBounds(TextHolderFigure figure) {
        Rectangle2D.Double r = figure.getDrawingArea();
        Insets2D.Double insets = figure.getInsets();
        insets.subtractTo(r);

        // FIXME - Find a way to determine the parameters for grow.
        //r.grow(1,2);
        //r.width += 16;
        r.x -= 1;
        r.y -= 2;
        r.width += 18;
        r.height += 4;
        return r;
    }

    protected void endEdit() {
        if (typingTarget != null) {
            typingTarget.willChange();

            final TextHolderFigure editedFigure = typingTarget;
            final String oldText = typingTarget.getText();
            final String newText = textArea.getText();

            if (newText.length() > 0) {
                typingTarget.setText(newText);
            } else {
                if (createdFigure != null) {
                    getDrawing().remove((Figure) getAddedFigure());
                // XXX - Fire undoable edit here!!
                } else {
                    typingTarget.setText("");
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

            textArea.endOverlay();
        }
    //	        view().checkDamage();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        endEdit();
        if (isToolDoneAfterCreation()) {
            fireToolDone();
        }
    }
}
