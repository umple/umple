/*
 * @(#)MultiEditorSample.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.mini;

import org.jhotdraw.draw.tool.CreationTool;
import org.jhotdraw.draw.io.SerializationInputOutputFormat;
import java.awt.*;
import javax.swing.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.action.*;
import org.jhotdraw.util.*;

/**
 * Example showing how to create a drawing editor which acts on four drawing
 * views.
 *
 * @author Werner Randelshofer
 * @version $Id: MultiEditorSample.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class MultiEditorSample {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");

                // Create four drawing views, each one with its own drawing
                DrawingView view1 = new DefaultDrawingView();
                view1.setDrawing(createDrawing());
                DrawingView view2 = new DefaultDrawingView();
                view2.setDrawing(createDrawing());
                DrawingView view3 = new DefaultDrawingView();
                view3.setDrawing(createDrawing());
                DrawingView view4 = new DefaultDrawingView();
                view4.setDrawing(createDrawing());

                // Create a common drawing editor for the views
                DrawingEditor editor = new DefaultDrawingEditor();
                editor.add(view1);
                editor.add(view2);
                editor.add(view3);
                editor.add(view4);

                // Create a tool bar with selection tool and a
                // creation tool for rectangle figures.
                JToolBar tb = new JToolBar();
                ButtonFactory.addSelectionToolTo(tb, editor);
                ButtonFactory.addToolTo(
                        tb, editor,
                        new CreationTool(new RectangleFigure()),
                        "edit.createRectangle",
                        labels);
                tb.setOrientation(JToolBar.VERTICAL);

                // Put all together into a JFrame
                JFrame f = new JFrame("Multi-Editor");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(400, 300);

                // Set up the content pane
                // Place the toolbar on the left
                // Place each drawing view into a scroll pane of its own
                // and put them into a larger scroll pane.
                JPanel innerPane = new JPanel();
                innerPane.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
                JScrollPane sp;
                innerPane.add(sp = new JScrollPane(view1.getComponent()));
                sp.setPreferredSize(new Dimension(200, 200));
                innerPane.add(sp = new JScrollPane(view2.getComponent()));
                sp.setPreferredSize(new Dimension(200, 200));
                innerPane.add(sp = new JScrollPane(view3.getComponent()));
                sp.setPreferredSize(new Dimension(200, 200));
                innerPane.add(sp = new JScrollPane(view4.getComponent()));
                sp.setPreferredSize(new Dimension(200, 200));
                f.getContentPane().add(new JScrollPane(innerPane));

                f.getContentPane().add(tb, BorderLayout.WEST);

                f.setVisible(true);
            }
        });
    }

    /**
     * Creates a drawing with input and output formats, so that drawing figures
     * can be copied and pasted between drawing views.
     * 
     * @return a drawing
     */
    private static Drawing createDrawing() {
        // Create a default drawing with
        // input/output formats for basic clipboard support.
        DefaultDrawing drawing = new DefaultDrawing();
        drawing.addInputFormat(new SerializationInputOutputFormat());
        drawing.addOutputFormat(new SerializationInputOutputFormat());
        return drawing;
    }
}
