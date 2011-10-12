/*
 * @(#)ODGView.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 *
 */
package org.jhotdraw.samples.odg;

import org.jhotdraw.app.action.edit.RedoAction;
import org.jhotdraw.app.action.edit.UndoAction;
import org.jhotdraw.draw.io.TextInputFormat;
import org.jhotdraw.draw.io.OutputFormat;
import org.jhotdraw.draw.io.InputFormat;
import org.jhotdraw.draw.io.ImageOutputFormat;
import org.jhotdraw.draw.io.ImageInputFormat;
import org.jhotdraw.draw.print.DrawingPageable;
import java.awt.image.BufferedImage;
import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.LinkedList;
import org.jhotdraw.gui.*;
import org.jhotdraw.samples.odg.io.ODGInputFormat;
import org.jhotdraw.samples.svg.figures.*;
import org.jhotdraw.samples.svg.io.*;
import org.jhotdraw.undo.*;
import org.jhotdraw.util.*;
import java.awt.*;
import java.beans.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.*;
import java.net.URI;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileFilter;
import org.jhotdraw.app.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.gui.JFileURIChooser;
import org.jhotdraw.gui.URIChooser;

/**
 * Provides a view on a ODG drawing.
 * <p>
 * See {@link View} interface on how this view interacts with an application.
*
 * @author Werner Randelshofer
 * @version $Id: ODGView.java 731 2011-01-22 09:21:06Z rawcoder $
 */
public class ODGView extends AbstractView {

    public final static String GRID_VISIBLE_PROPERTY = "gridVisible";
    protected JFileURIChooser exportChooser;
    /**
     * Each ODGView uses its own undo redo manager.
     * This allows for undoing and redoing actions per view.
     */
    private UndoRedoManager undo;
    /**
     * Depending on the type of an application, there may be one editor per
     * view, or a single shared editor for all views.
     */
    private DrawingEditor editor;
    private GridConstrainer visibleConstrainer = new GridConstrainer(10, 10);
    private GridConstrainer invisibleConstrainer = new GridConstrainer(1, 1);

    /**
     * Creates a new view.
     */
    public ODGView() {
        initComponents();

        scrollPane.setLayout(new PlacardScrollPaneLayout());
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));

        setEditor(new DefaultDrawingEditor());
        undo = new UndoRedoManager();
        view.setDrawing(createDrawing());
        view.getDrawing().addUndoableEditListener(undo);
        initActions();
        undo.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                setHasUnsavedChanges(undo.hasSignificantEdits());
            }
        });

        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");

        JPanel placardPanel = new JPanel(new BorderLayout());
        javax.swing.AbstractButton pButton;
        pButton = ButtonFactory.createZoomButton(view);
        pButton.putClientProperty("Quaqua.Button.style", "placard");
        pButton.putClientProperty("Quaqua.Component.visualMargin", new Insets(0, 0, 0, 0));
        pButton.setFont(UIManager.getFont("SmallSystemFont"));
        placardPanel.add(pButton, BorderLayout.WEST);
        pButton = ButtonFactory.createToggleGridButton(view);
        pButton.putClientProperty("Quaqua.Button.style", "placard");
        pButton.putClientProperty("Quaqua.Component.visualMargin", new Insets(0, 0, 0, 0));
        pButton.setFont(UIManager.getFont("SmallSystemFont"));
        labels.configureToolBarButton(pButton, "view.toggleGrid.placard");
        placardPanel.add(pButton, BorderLayout.EAST);
        scrollPane.add(placardPanel, JScrollPane.LOWER_LEFT_CORNER);

        propertiesPanel.setVisible(preferences.getBoolean("propertiesPanelVisible", false));
        propertiesPanel.setView(view);
    }

    /**
     * Creates a new Drawing for this view.
     */
    protected Drawing createDrawing() {
        Drawing drawing = new ODGDrawing();
        LinkedList<InputFormat> inputFormats = new LinkedList<InputFormat>();
        inputFormats.add(new ODGInputFormat());
        inputFormats.add(new ImageInputFormat(new SVGImageFigure()));
        inputFormats.add(new TextInputFormat(new SVGTextFigure()));
        drawing.setInputFormats(inputFormats);
        LinkedList<OutputFormat> outputFormats = new LinkedList<OutputFormat>();
        outputFormats.add(new SVGOutputFormat());
        outputFormats.add(new SVGZOutputFormat());
        outputFormats.add(new ImageOutputFormat());
        outputFormats.add(new ImageOutputFormat("JPG", "Joint Photographics Experts Group (JPEG)", "jpg", BufferedImage.TYPE_INT_RGB));
        outputFormats.add(new ImageOutputFormat("BMP", "Windows Bitmap (BMP)", "bmp", BufferedImage.TYPE_BYTE_INDEXED));
        outputFormats.add(new ImageMapOutputFormat());
        drawing.setOutputFormats(outputFormats);
        return drawing;
    }

    /**
     * Creates a Pageable object for printing the view.
     */
    public Pageable createPageable() {
        return new DrawingPageable(view.getDrawing());

    }

    public DrawingEditor getEditor() {
        return editor;
    }

    public void setEditor(DrawingEditor newValue) {
        DrawingEditor oldValue = editor;
        if (oldValue != null) {
            oldValue.remove(view);
        }
        editor = newValue;
        propertiesPanel.setEditor(editor);
        if (newValue != null) {
            newValue.add(view);
        }
    }

    /**
     * Initializes view specific actions.
     */
    private void initActions() {
        getActionMap().put(UndoAction.ID, undo.getUndoAction());
        getActionMap().put(RedoAction.ID, undo.getRedoAction());
    }

    @Override
    protected void setHasUnsavedChanges(boolean newValue) {
        super.setHasUnsavedChanges(newValue);
        undo.setHasSignificantEdits(newValue);
    }

    /**
     * Writes the view to the specified uri.
     */
    @Override
    public void write(URI f, URIChooser fc) throws IOException {
        new SVGOutputFormat().write(new File(f), view.getDrawing());
    }

    /**
     * Reads the view from the specified uri.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void read(URI f, URIChooser fc) throws IOException {
        try {
            final Drawing drawing = createDrawing();
            HashMap<FileFilter, InputFormat> fileFilterInputFormatMap = (HashMap<FileFilter, InputFormat>) ((JFileURIChooser) fc).getClientProperty("ffInputFormatMap");

            InputFormat sf = fileFilterInputFormatMap.get(((JFileURIChooser) fc).getFileFilter());
            if (sf == null) {
                sf = drawing.getInputFormats().get(0);
            }
            sf.read(f, drawing, true);

            System.out.println("ODCView read(" + f + ") drawing.childCount=" + drawing.getChildCount());

            SwingUtilities.invokeAndWait(new Runnable() {

                @Override
                public void run() {
                    view.getDrawing().removeUndoableEditListener(undo);
                    view.setDrawing(drawing);
                    view.getDrawing().addUndoableEditListener(undo);
                    undo.discardAllEdits();
                }
            });
        } catch (InterruptedException e) {
            InternalError error = new InternalError();
            e.initCause(e);
            throw error;
        } catch (InvocationTargetException e) {
            InternalError error = new InternalError();
            error.initCause(e);
            throw error;
        }
    }

    public Drawing getDrawing() {
        return view.getDrawing();
    }

    @Override
    public void setEnabled(boolean newValue) {
        view.setEnabled(newValue);
        super.setEnabled(newValue);
    }

    public void setPropertiesPanelVisible(boolean newValue) {
        boolean oldValue = propertiesPanel.isVisible();
        propertiesPanel.setVisible(newValue);
        firePropertyChange("propertiesPanelVisible", oldValue, newValue);
        preferences.putBoolean("propertiesPanelVisible", newValue);
        validate();
    }

    public boolean isPropertiesPanelVisible() {
        return propertiesPanel.isVisible();
    }

    public boolean isGridVisible() {
        return view.isConstrainerVisible();
    }

    public void setGridVisible(boolean newValue) {
        boolean oldValue = isGridVisible();
        view.setConstrainerVisible(newValue);
        firePropertyChange(GRID_VISIBLE_PROPERTY, oldValue, newValue);
    }

    public double getScaleFactor() {
        return view.getScaleFactor();
    }

    public void setScaleFactor(double newValue) {
        double oldValue = getScaleFactor();
        view.setScaleFactor(newValue);
        firePropertyChange("scaleFactor", oldValue, newValue);
    }

    /**
     * Clears the view.
     */
    @Override
    public void clear() {
        final Drawing newDrawing = createDrawing();
        try {
            SwingUtilities.invokeAndWait(new Runnable() {

                @Override
                public void run() {
                    view.getDrawing().removeUndoableEditListener(undo);
                    view.setDrawing(newDrawing);
                    view.getDrawing().addUndoableEditListener(undo);
                    undo.discardAllEdits();
                }
            });
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean canSaveTo(URI uri) {
        return uri.getPath().endsWith(".odg");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        view = new org.jhotdraw.draw.DefaultDrawingView();
        propertiesPanel = new org.jhotdraw.samples.odg.ODGPropertiesPanel();

        setLayout(new java.awt.BorderLayout());

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(view);

        add(scrollPane, java.awt.BorderLayout.CENTER);
        add(propertiesPanel, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jhotdraw.samples.odg.ODGPropertiesPanel propertiesPanel;
    private javax.swing.JScrollPane scrollPane;
    private org.jhotdraw.draw.DefaultDrawingView view;
    // End of variables declaration//GEN-END:variables
}
