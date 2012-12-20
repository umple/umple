/*
 * @(#)ODGApplicationModel.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.odg;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.app.action.view.ViewPropertyAction;
import org.jhotdraw.app.action.view.ToggleViewPropertyAction;
import org.jhotdraw.app.action.file.ExportFileAction;
import org.jhotdraw.app.action.edit.PasteAction;
import org.jhotdraw.app.action.edit.CutAction;
import org.jhotdraw.app.action.edit.CopyAction;
import org.jhotdraw.app.action.edit.DuplicateAction;
import org.jhotdraw.app.action.edit.SelectAllAction;
import org.jhotdraw.draw.tool.CreationTool;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import org.jhotdraw.samples.odg.action.*;
import org.jhotdraw.samples.odg.figures.*;
import org.jhotdraw.util.*;
import java.util.*;
import javax.swing.*;
import org.jhotdraw.app.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.draw.io.InputFormat;
import org.jhotdraw.draw.io.OutputFormat;
import org.jhotdraw.gui.JFileURIChooser;
import org.jhotdraw.gui.URIChooser;
import static org.jhotdraw.samples.odg.ODGAttributeKeys.*;

/**
 * Provides meta-data and factory methods for an application.
 * <p>
 * See {@link ApplicationModel} on how this class interacts with an application.
 *
 * @author Werner Randelshofer
 * @version $Id: ODGApplicationModel.java 731 2011-01-22 09:21:06Z rawcoder $
 */
public class ODGApplicationModel extends DefaultApplicationModel {

    private final static double[] scaleFactors = {5, 4, 3, 2, 1.5, 1.25, 1, 0.75, 0.5, 0.25, 0.10};
    /**
     * This editor is shared by all views.
     */
    private DefaultDrawingEditor sharedEditor;

    /** Creates a new instance. */
    public ODGApplicationModel() {
        setViewClass(ODGView.class);
    }

    public DefaultDrawingEditor getSharedEditor() {
        if (sharedEditor == null) {
            sharedEditor = new DefaultDrawingEditor();
        }
        return sharedEditor;
    }

    public static Collection<Action> createDrawingActions(DrawingEditor editor) {
        LinkedList<Action> a = new LinkedList<Action>();
        a.add(new CutAction());
        a.add(new CopyAction());
        a.add(new PasteAction());
        a.add(new SelectAllAction());
        a.add(new SelectSameAction(editor));

        return a;
    }

    public static Collection<Action> createSelectionActions(DrawingEditor editor) {
        LinkedList<Action> a = new LinkedList<Action>();
        a.add(new DuplicateAction());

        a.add(null); // separator
        a.add(new GroupAction(editor, new ODGGroupFigure()));
        a.add(new UngroupAction(editor, new ODGGroupFigure()));
        a.add(new CombineAction(editor));
        a.add(new SplitAction(editor));

        a.add(null); // separator
        a.add(new BringToFrontAction(editor));
        a.add(new SendToBackAction(editor));

        return a;
    }

    private void addCreationButtonsTo(JToolBar tb, final DrawingEditor editor) {
        // AttributeKeys for the entitie sets
        HashMap<AttributeKey, Object> attributes;

        ResourceBundleUtil drawLabels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");

        ButtonFactory.addSelectionToolTo(tb, editor, createDrawingActions(editor), createSelectionActions(editor));
        tb.addSeparator();

        attributes = new HashMap<AttributeKey, Object>();
        ButtonFactory.addToolTo(tb, editor, new CreationTool(new ODGRectFigure(), attributes), "edit.createRectangle", drawLabels);
        attributes = new HashMap<AttributeKey, Object>();
        attributes.put(AttributeKeys.FILL_COLOR, null);
        attributes.put(AttributeKeys.STROKE_COLOR, Color.black);
        ButtonFactory.addToolTo(tb, editor, new CreationTool(new ODGPathFigure(), attributes), "edit.createLine", drawLabels);
        attributes = new HashMap<AttributeKey, Object>();
        attributes.put(AttributeKeys.FILL_COLOR, Color.black);
        attributes.put(AttributeKeys.STROKE_COLOR, null);
        attributes = new HashMap<AttributeKey, Object>();
        attributes.put(AttributeKeys.FILL_COLOR, null);
        attributes.put(AttributeKeys.STROKE_COLOR, null);
    }

    /**
     * Creates toolbar buttons and adds them to the specified JToolBar
     */
    private void addAttributesButtonsTo(JToolBar bar, DrawingEditor editor) {
        JButton b;

        b = bar.add(new PickAttributesAction(editor));
        b.setFocusable(false);
        b = bar.add(new ApplyAttributesAction(editor));
        b.setFocusable(false);
        bar.addSeparator();

        addColorButtonsTo(bar, editor);
        bar.addSeparator();
        addStrokeButtonsTo(bar, editor);
        bar.addSeparator();
        ButtonFactory.addFontButtonsTo(bar, editor);
    }

    private void addColorButtonsTo(JToolBar bar, DrawingEditor editor) {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        HashMap<AttributeKey, Object> defaultAttributes = new HashMap<AttributeKey, Object>();
        STROKE_GRADIENT.put(defaultAttributes, (Gradient) null);
        bar.add(
                ButtonFactory.createEditorColorButton(editor,
                STROKE_COLOR, ButtonFactory.WEBSAVE_COLORS, ButtonFactory.WEBSAVE_COLORS_COLUMN_COUNT,
                "attribute.strokeColor", labels,
                defaultAttributes));
        defaultAttributes = new HashMap<AttributeKey, Object>();
        FILL_GRADIENT.put(defaultAttributes, (Gradient) null);
        bar.add(
                ButtonFactory.createEditorColorButton(editor,
                FILL_COLOR, ButtonFactory.WEBSAVE_COLORS, ButtonFactory.WEBSAVE_COLORS_COLUMN_COUNT,
                "attribute.fillColor", labels,
                defaultAttributes));
    }

    private void addStrokeButtonsTo(JToolBar bar, DrawingEditor editor) {
        bar.add(ButtonFactory.createStrokeWidthButton(editor));
        bar.add(ButtonFactory.createStrokeDashesButton(editor));
        bar.add(ButtonFactory.createStrokeCapButton(editor));
        bar.add(ButtonFactory.createStrokeJoinButton(editor));
    }

    /**
     * Creates toolbars for the application.
     */
    @Override
    public java.util.List<JToolBar> createToolBars(Application a, @Nullable View pr) {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        ODGView p = (ODGView) pr;

        DrawingEditor editor;
        if (p == null) {
            editor = getSharedEditor();
        } else {
            editor = p.getEditor();
        }

        LinkedList<JToolBar> list = new LinkedList<JToolBar>();
        JToolBar tb;
        tb = new JToolBar();
        addCreationButtonsTo(tb, editor);
        tb.setName(labels.getString("window.drawToolBar.title"));
        list.add(tb);
        tb = new JToolBar();
        addAttributesButtonsTo(tb, editor);
        tb.setName(labels.getString("window.attributesToolBar.title"));
        list.add(tb);
        tb = new JToolBar();
        ButtonFactory.addAlignmentButtonsTo(tb, editor);
        tb.setName(labels.getString("window.alignmentToolBar.title"));
        list.add(tb);
        return list;
    }

    @Override
    public void initView(Application a, View p) {
        if (a.isSharingToolsAmongViews()) {
            ((ODGView) p).setEditor(getSharedEditor());
        }
    }

    @Override
    public ActionMap createActionMap(Application a, @Nullable View v) {
        ActionMap m = super.createActionMap(a, v);
        ResourceBundleUtil drawLabels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
        AbstractAction aa;

        m.put(ExportFileAction.ID, new ExportFileAction(a, v));
        m.put("view.toggleGrid", aa = new ToggleViewPropertyAction(a, v, ODGView.GRID_VISIBLE_PROPERTY));
        drawLabels.configureAction(aa, "view.toggleGrid");
        for (double sf : scaleFactors) {
            m.put((int) (sf * 100) + "%",
                    aa = new ViewPropertyAction(a, v, "scaleFactor", Double.TYPE, new Double(sf)));
            aa.putValue(Action.NAME, (int) (sf * 100) + " %");

        }
        return m;
    }

    @Override
    public URIChooser createOpenChooser(Application a, @Nullable View view) {
        final JFileURIChooser c = new JFileURIChooser();
        final HashMap<javax.swing.filechooser.FileFilter, InputFormat> fileFilterInputFormatMap = new HashMap<javax.swing.filechooser.FileFilter, InputFormat>();
        c.putClientProperty("ffInputFormatMap", fileFilterInputFormatMap);
        javax.swing.filechooser.FileFilter firstFF = null;

        if (view == null) {
            view = new ODGView();
        }

        for (InputFormat format : ((ODGView) view).getDrawing().getInputFormats()) {
            javax.swing.filechooser.FileFilter ff = format.getFileFilter();
            if (firstFF == null) {
                firstFF = ff;
            }
            fileFilterInputFormatMap.put(ff, format);
            c.addChoosableFileFilter(ff);
        }
        c.setFileFilter(firstFF);
        c.addPropertyChangeListener(new PropertyChangeListener() {

    @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("fileFilterChanged")) {
                    InputFormat inputFormat = fileFilterInputFormatMap.get(evt.getNewValue());
                    c.setAccessory((inputFormat == null) ? null : inputFormat.getInputFormatAccessory());
                }
            }
        });

        return c;
    }

    @Override
    public URIChooser createSaveChooser(Application a, @Nullable View view) {
        JFileURIChooser c = new JFileURIChooser();
        final HashMap<javax.swing.filechooser.FileFilter, OutputFormat> fileFilterOutputFormatMap = new HashMap<javax.swing.filechooser.FileFilter, OutputFormat>();
        c.putClientProperty("ffOutputFormatMap", fileFilterOutputFormatMap);

        if (view == null) {
            view = new ODGView();
        }
        for (OutputFormat format : ((ODGView)view).getDrawing().getOutputFormats()) {
            javax.swing.filechooser.FileFilter ff = format.getFileFilter();
            fileFilterOutputFormatMap.put(ff, format);
            c.addChoosableFileFilter(ff);
            break; // only add the first uri filter
        }
        return c;
    }
    @Override
    public URIChooser createExportChooser(Application a, @Nullable View view) {
        JFileURIChooser c = new JFileURIChooser();
        final HashMap<javax.swing.filechooser.FileFilter, OutputFormat> fileFilterOutputFormatMap = new HashMap<javax.swing.filechooser.FileFilter, OutputFormat>();
        c.putClientProperty("ffExportFormatMap", fileFilterOutputFormatMap);

        if (view == null) {
            view = new ODGView();
        }
        for (OutputFormat format : ((ODGView)view).getDrawing().getOutputFormats()) {
            javax.swing.filechooser.FileFilter ff = format.getFileFilter();
            fileFilterOutputFormatMap.put(ff, format);
            c.addChoosableFileFilter(ff);
            break; // only add the first uri filter
        }
        return c;
    }
}
