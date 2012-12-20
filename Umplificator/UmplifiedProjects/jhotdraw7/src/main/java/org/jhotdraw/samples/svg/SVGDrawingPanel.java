/*
 * @(#)JSVGDrawingAppletPanel.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.svg;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import org.jhotdraw.draw.io.TextInputFormat;
import org.jhotdraw.draw.io.OutputFormat;
import org.jhotdraw.draw.io.InputFormat;
import org.jhotdraw.draw.io.ImageOutputFormat;
import org.jhotdraw.draw.io.ImageInputFormat;
import java.lang.reflect.InvocationTargetException;
import java.util.prefs.*;
import org.jhotdraw.undo.*;
import org.jhotdraw.util.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import org.jhotdraw.app.Disposable;
import org.jhotdraw.gui.ToolBarLayout;
import org.jhotdraw.draw.*;
import org.jhotdraw.gui.plaf.palette.PaletteLookAndFeel;
import org.jhotdraw.samples.svg.figures.SVGImageFigure;
import org.jhotdraw.samples.svg.figures.SVGTextFigure;
import org.jhotdraw.samples.svg.io.ImageMapOutputFormat;
import org.jhotdraw.samples.svg.io.SVGOutputFormat;
import org.jhotdraw.samples.svg.io.SVGZInputFormat;
import org.jhotdraw.samples.svg.io.SVGZOutputFormat;
import org.jhotdraw.util.prefs.PreferencesUtil;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;

/**
 * JSVGDrawingAppletPanel.
 * 
 * @author Werner Randelshofer
 * @version $Id: SVGDrawingPanel.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class SVGDrawingPanel extends JPanel implements Disposable {

    private UndoRedoManager undoManager;
    @Nullable private DrawingEditor editor;
    private ResourceBundleUtil labels;
    private Preferences prefs;
    @Nullable private ContainerListener containerHandler;

    public UndoRedoManager getUndoRedoManager() {
        return undoManager;
    }

    public void setUndoRedoManager(UndoRedoManager undo) {
        if (undoManager != null && getView().getDrawing() != null) {
            getView().getDrawing().removeUndoableEditListener(undoManager);
        }
        undoManager = undo;
        if (undoManager != null && getView().getDrawing() != null) {
            getView().getDrawing().addUndoableEditListener(undoManager);
        }
    }

    private class ItemChangeHandler implements ItemListener {

        private JToolBar toolbar;
        private String prefkey;

        public ItemChangeHandler(JToolBar toolbar, String prefkey) {
            this.toolbar = toolbar;
            this.prefkey = prefkey;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            boolean b = e.getStateChange() == ItemEvent.SELECTED;
            toolbar.setVisible(b);
            prefs.putBoolean(prefkey, b);
            validate();
        }
    }

    /** Creates new instance. */
    public SVGDrawingPanel() {
        labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");

        try {
            prefs = PreferencesUtil.userNodeForPackage(getClass());
        } catch (SecurityException e) {
            // prefs is null, because we are not permitted to read preferences
        }
        
        initComponents();

        toolsPane.setLayout(new ToolBarLayout());
        toolsPane.setBackground(new Color(0xf0f0f0));
        toolsPane.setOpaque(true);

        viewToolBar.setView(view);

        undoManager = new UndoRedoManager();

        Drawing drawing = createDrawing();
        view.setDrawing(drawing);
        drawing.addUndoableEditListener(undoManager);

        // Try to install the DnDDrawingViewTransferHandler
        // Since this class only works on J2SE 6, we have to use reflection.
        try {
            view.setTransferHandler((TransferHandler) Class.forName("org.jhotdraw.draw.DnDDrawingViewTransferHandler").newInstance());
        } catch (Exception e) {
            // bail silently
        }

        // Sort the toolbars according to the user preferences
        ArrayList<JToolBar> sortme = new ArrayList<JToolBar>();
        for (Component c : toolsPane.getComponents()) {
            if (c instanceof JToolBar) {
                sortme.add((JToolBar) c);
            }
        }
        Collections.sort(sortme, new Comparator<JToolBar>() {

            @Override
            public int compare(JToolBar tb1, JToolBar tb2) {
                int i1 = prefs.getInt("toolBarIndex." + tb1.getName(), 0);
                int i2 = prefs.getInt("toolBarIndex." + tb2.getName(), 0);
                return i1 - i2;
            }
        });
        toolsPane.removeAll();
        for (JToolBar tb : sortme) {
            toolsPane.add(tb);
        }

        toolsPane.addContainerListener(containerHandler = new ContainerListener() {

            @Override
            public void componentAdded(ContainerEvent e) {
                int i = 0;
                for (Component c : toolsPane.getComponents()) {
                    if (c instanceof JToolBar) {
                        JToolBar tb = (JToolBar) c;
                        prefs.putInt("toolBarIndex." + tb.getName(), i);
                        i++;
                    }
                }
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
            }
        });


        setEditor(new DefaultDrawingEditor());
    }

    @Override
    public void dispose() {
        toolsPane.removeContainerListener(containerHandler);
        containerHandler = null;
        setEditor(null);
        for (PropertyChangeListener pcl : view.getListeners(PropertyChangeListener.class)) {
            view.removePropertyChangeListener(pcl);
        }
        view.setDrawing(null);
        actionToolBar.dispose();
        alignToolBar.dispose();
        arrangeToolBar.dispose();
        canvasToolBar.dispose();
        creationToolBar.dispose();
        figureToolBar.dispose();
        fillToolBar.dispose();
        fontToolBar.dispose();
        linkToolBar.dispose();
        strokeToolBar.dispose();
        viewToolBar.dispose();
        removeAll();
    }

    /**
     * Creates a new Drawing object which can be used with this
     * {@code SVGDrawingPanel}.
     */
    public Drawing createDrawing() {
        Drawing drawing = new QuadTreeDrawing();
        LinkedList<InputFormat> inputFormats = new LinkedList<InputFormat>();
        inputFormats.add(new SVGZInputFormat());
        inputFormats.add(new ImageInputFormat(new SVGImageFigure(), "PNG", "Portable Network Graphics (PNG)", "png", "image/png"));
        inputFormats.add(new ImageInputFormat(new SVGImageFigure(), "JPG", "Joint Photographics Experts Group (JPEG)", "jpg","image/jpg"));
        inputFormats.add(new ImageInputFormat(new SVGImageFigure(), "GIF", "Graphics Interchange Format (GIF)", "gif", "image/gif"));
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

    public void setDrawing(Drawing d) {
        undoManager.discardAllEdits();
        if (view.getDrawing() != null) {
            view.getDrawing().removeUndoableEditListener(undoManager);
        }
        view.setDrawing(d);
        d.addUndoableEditListener(undoManager);
    }

    public Drawing getDrawing() {
        return view.getDrawing();
    }

    public DrawingView getView() {
        return view;
    }

    @Nullable public DrawingEditor getEditor() {
        return editor;
    }

    public void setEditor(@Nullable DrawingEditor newValue) {
        DrawingEditor oldValue = editor;
        if (oldValue != null) {
            oldValue.remove(view);
        }
        editor = newValue;
        if (newValue != null) {
            newValue.add(view);
        }
        creationToolBar.setEditor(editor);
        fillToolBar.setEditor(editor);
        strokeToolBar.setEditor(editor);
        actionToolBar.setUndoManager(undoManager);
        actionToolBar.setEditor(editor);
        alignToolBar.setEditor(editor);
        arrangeToolBar.setEditor(editor);
        fontToolBar.setEditor(editor);
        figureToolBar.setEditor(editor);
        linkToolBar.setEditor(editor);
        DrawingView temp = (editor == null) ? null : editor.getActiveView();
        if (editor != null) {
            editor.setActiveView(view);
        }
        canvasToolBar.setEditor(editor);
        viewToolBar.setEditor(editor);
        if (editor != null) {
            editor.setActiveView(temp);
        }
    }

    /**
     * Reads a drawing from the specified file into the SVGDrawingPanel.
     * <p>
     * This method should be called from a worker thread.
     * Calling it from the Event Dispatcher Thread will block the user
     * interface, until the drawing is read.
     */
    public void read(URI f) throws IOException {
        // Create a new drawing object
        Drawing newDrawing = createDrawing();
        if (newDrawing.getInputFormats().size() == 0) {
            throw new InternalError("Drawing object has no input formats.");
        }

        // Try out all input formats until we succeed
        IOException firstIOException = null;
        for (InputFormat format : newDrawing.getInputFormats()) {
            try {
                format.read(f, newDrawing);
                final Drawing loadedDrawing = newDrawing;
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        // Set the drawing on the Event Dispatcher Thread
                        setDrawing(loadedDrawing);
                    }
                };
                if (SwingUtilities.isEventDispatchThread()) {
                    r.run();
                } else {
                    try {
                        SwingUtilities.invokeAndWait(r);
                    } catch (InterruptedException ex) {
                        // suppress silently
                    } catch (InvocationTargetException ex) {
                        InternalError ie = new InternalError("Error setting drawing.");
                        ie.initCause(ex);
                        throw ie;
                    }
                }
                // We get here if reading was successful.
                // We can return since we are done.
                return;
                //
            } catch (IOException e) {
                // We get here if reading failed.
                // We only preserve the exception of the first input format,
                // because that's the one which is best suited for this drawing.
                if (firstIOException == null) {
                    firstIOException = e;
                }
            }
        }
        throw firstIOException;
    }

    /**
     * Reads a drawing from the specified file into the SVGDrawingPanel using
     * the specified input format.
     * <p>
     * This method should be called from a worker thread.
     * Calling it from the Event Dispatcher Thread will block the user
     * interface, until the drawing is read.
     */
    public void read(URI f, InputFormat format) throws IOException {
        if (format == null) {
            read(f);
            return;
        }

        // Create a new drawing object
        Drawing newDrawing = createDrawing();
        if (newDrawing.getInputFormats().size() == 0) {
            throw new InternalError("Drawing object has no input formats.");
        }

        format.read(f, newDrawing);
        final Drawing loadedDrawing = newDrawing;
        Runnable r = new Runnable() {

            @Override
            public void run() {
                // Set the drawing on the Event Dispatcher Thread
                setDrawing(loadedDrawing);
            }
        };
        if (SwingUtilities.isEventDispatchThread()) {
            r.run();
        } else {
            try {
                SwingUtilities.invokeAndWait(r);
            } catch (InterruptedException ex) {
                // suppress silently
            } catch (InvocationTargetException ex) {
                InternalError ie = new InternalError("Error setting drawing.");
                ie.initCause(ex);
                throw ie;
            }
        }
    }

    /**
     * Writes the drawing from the SVGDrawingPanel into a file.
     * <p>
     * This method should be called from a worker thread.
     * Calling it from the Event Dispatcher Thread will block the user
     * interface, until the drawing is written.
     */
    public void write(URI uri) throws IOException {
        // Defensively clone the drawing object, so that we are not
        // affected by changes of the drawing while we write it into the file.
        final Drawing[] helper = new Drawing[1];
        Runnable r = new Runnable() {

            @Override
            public void run() {
                helper[0] = (Drawing) getDrawing().clone();
            }
        };
        if (SwingUtilities.isEventDispatchThread()) {
            r.run();
        } else {
            try {
                SwingUtilities.invokeAndWait(r);
            } catch (InterruptedException ex) {
                // suppress silently
            } catch (InvocationTargetException ex) {
                InternalError ie = new InternalError("Error getting drawing.");
                ie.initCause(ex);
                throw ie;
            }

        }

        Drawing saveDrawing = helper[0];
        if (saveDrawing.getOutputFormats().size() == 0) {
            throw new InternalError("Drawing object has no output formats.");
        }

        // Try out all output formats until we find one which accepts the
        // filename entered by the user.
        File f = new File(uri);
        for (OutputFormat format : saveDrawing.getOutputFormats()) {
            if (format.getFileFilter().accept(f)) {
                format.write(uri, saveDrawing);
                // We get here if writing was successful.
                // We can return since we are done.
                return;

            }


        }
        throw new IOException("No output format for " + f.getName());
    }

    /**
     * Writes the drawing from the SVGDrawingPanel into a file using the
     * specified output format.
     * <p>
     * This method should be called from a worker thread.
     * Calling it from the Event Dispatcher Thread will block the user
     * interface, until the drawing is written.
     */
    public void write(URI f, OutputFormat format) throws IOException {
        if (format == null) {
            write(f);
            return;
        }

        // Defensively clone the drawing object, so that we are not
        // affected by changes of the drawing while we write it into the file.
        final Drawing[] helper = new Drawing[1];
        Runnable r = new Runnable() {

            @Override
            public void run() {
                helper[0] = (Drawing) getDrawing().clone();
            }
        };
        if (SwingUtilities.isEventDispatchThread()) {
            r.run();
        } else {
            try {
                SwingUtilities.invokeAndWait(r);
            } catch (InterruptedException ex) {
                // suppress silently
            } catch (InvocationTargetException ex) {
                InternalError ie = new InternalError("Error getting drawing.");
                ie.initCause(ex);
                throw ie;
            }

        }

        // Write drawing to file
        Drawing saveDrawing = helper[0];
        format.write(f, saveDrawing);
    }

    /** Sets the actions for the "Action" popup menu in the toolbar.
     * <p>
     * This list may contain null items which are used to denote a
     * separator in the popup menu.
     * <p>
     * Set this to null to set the drop down menus to the default actions.
     */
    public void setPopupActions(List<Action> actions) {
        actionToolBar.setPopupActions(actions);
    }
    /** Gets the actions of the "Action" popup menu in the toolbar.
     * This list may contain null items which are used to denote a
     * separator in the popup menu.
     *
     * @return An unmodifiable list with actions.
     */
    public List<Action> getPopupActions() {
        return actionToolBar.getPopupActions();
    }
    
    public JComponent getComponent() {
        return this;
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        toolButtonGroup = new javax.swing.ButtonGroup();
        scrollPane = new javax.swing.JScrollPane();
        view = new org.jhotdraw.draw.DefaultDrawingView();
        toolsPanel = new javax.swing.JPanel();
        toolsScrollPane = new javax.swing.JScrollPane();
        toolsPane = new javax.swing.JPanel();
        creationToolBar = new org.jhotdraw.samples.svg.gui.ToolsToolBar();
        actionToolBar = new org.jhotdraw.samples.svg.gui.ActionsToolBar();
        fillToolBar = new org.jhotdraw.samples.svg.gui.FillToolBar();
        strokeToolBar = new org.jhotdraw.samples.svg.gui.StrokeToolBar();
        fontToolBar = new org.jhotdraw.samples.svg.gui.FontToolBar();
        arrangeToolBar = new org.jhotdraw.samples.svg.gui.ArrangeToolBar();
        alignToolBar = new org.jhotdraw.samples.svg.gui.AlignToolBar();
        figureToolBar = new org.jhotdraw.samples.svg.gui.FigureToolBar();
        linkToolBar = new org.jhotdraw.samples.svg.gui.LinkToolBar();
        canvasToolBar = new org.jhotdraw.samples.svg.gui.CanvasToolBar();
        viewToolBar = new org.jhotdraw.samples.svg.gui.ViewToolBar();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        scrollPane.setBorder(null);
        scrollPane.setViewportView(view);

        add(scrollPane, java.awt.BorderLayout.CENTER);

        toolsPanel.setBackground(new java.awt.Color(255, 255, 255));
        toolsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        toolsPanel.setOpaque(true);
        toolsPanel.setLayout(new java.awt.GridBagLayout());

        toolsScrollPane.setBorder(PaletteLookAndFeel.getInstance().getBorder("Ribbon.border"));
        toolsScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        toolsScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        toolsScrollPane.setMinimumSize(new java.awt.Dimension(0, 0));

        toolsPane.setForeground(new java.awt.Color(153, 153, 153));
        toolsPane.add(creationToolBar);
        toolsPane.add(actionToolBar);
        toolsPane.add(fillToolBar);

        strokeToolBar.setMargin(new java.awt.Insets(0, 10, 0, 0));
        toolsPane.add(strokeToolBar);
        toolsPane.add(fontToolBar);
        toolsPane.add(arrangeToolBar);
        toolsPane.add(alignToolBar);
        toolsPane.add(figureToolBar);
        toolsPane.add(linkToolBar);
        toolsPane.add(canvasToolBar);
        toolsPane.add(viewToolBar);

        toolsScrollPane.setViewportView(toolsPane);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        toolsPanel.add(toolsScrollPane, gridBagConstraints);

        add(toolsPanel, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jhotdraw.samples.svg.gui.ActionsToolBar actionToolBar;
    private org.jhotdraw.samples.svg.gui.AlignToolBar alignToolBar;
    private org.jhotdraw.samples.svg.gui.ArrangeToolBar arrangeToolBar;
    private org.jhotdraw.samples.svg.gui.CanvasToolBar canvasToolBar;
    private org.jhotdraw.samples.svg.gui.ToolsToolBar creationToolBar;
    private org.jhotdraw.samples.svg.gui.FigureToolBar figureToolBar;
    private org.jhotdraw.samples.svg.gui.FillToolBar fillToolBar;
    private org.jhotdraw.samples.svg.gui.FontToolBar fontToolBar;
    private org.jhotdraw.samples.svg.gui.LinkToolBar linkToolBar;
    private javax.swing.JScrollPane scrollPane;
    private org.jhotdraw.samples.svg.gui.StrokeToolBar strokeToolBar;
    private javax.swing.ButtonGroup toolButtonGroup;
    private javax.swing.JPanel toolsPane;
    private javax.swing.JPanel toolsPanel;
    private javax.swing.JScrollPane toolsScrollPane;
    private org.jhotdraw.draw.DefaultDrawingView view;
    private org.jhotdraw.samples.svg.gui.ViewToolBar viewToolBar;
    // End of variables declaration//GEN-END:variables
}
