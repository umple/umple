/*
 * @(#)SelectionToolSample.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.mini;

import org.jhotdraw.draw.tool.SelectionTool;
import java.awt.geom.*;
import javax.swing.*;
import org.jhotdraw.draw.*;

/**
 * SelectionToolSample demonstrates how the <code>SelectionTool</code> works.
 * <p>
 * Internally, the <code>SelectionTool</code> uses three smaller tools 
 * (named as 'Tracker') to fulfill its task. If the user presses the mouse 
 * button over an empty area of a drawing, the <code>SelectAreaTracker</code>
 * comes into action. If the user presses the mouse button over a figure, the
 * <code>DragTracker</code> comes into action. If the user presses the mouse
 * button over a handle, the <code>HandleTracker</code> comes into action. 
 * <p>
 * You need to edit the source code as marked below. 
 * <p>
 * With this program you can:
 * <ol>
 * <li>See how the <code>SelectionTool</code> interacts with a 
 * <code>LineFigure</code>.</li>
 * <li>See how the <code>SelectAreaTracker</code> interacts with a 
 * <code>LineFigure</code>.</li>
 * <li>See how the <code>DragTracker</code> interacts with a 
 * <code>LineFigure</code>.</li>
 * <li>See how the <code>HandleTracker</code> interacts with a 
 * <code>LineFigure</code>.</li>
 * </ol>
 * 
 * 
 * @author Pondus
 * @version $Id: SelectionToolSample.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class SelectionToolSample {

    /**
     * Creates a new instance of SelectionToolSample
     */
    public SelectionToolSample() {
        LineFigure lf = new LineFigure();
        lf.setBounds(new Point2D.Double(40, 40), new Point2D.Double(200,
                40));

        // Add all figures to a drawing
        Drawing drawing = new DefaultDrawing();

        drawing.add(lf);

        // Show the drawing
        JFrame f = new JFrame("UltraMini");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(600, 300);

        DrawingView view = new DefaultDrawingView();
        view.setDrawing(drawing);

        f.getContentPane().add(view.getComponent());
        // set up the drawing editor
        DrawingEditor editor = new DefaultDrawingEditor();
        editor.add(view);


        // Activate the following line to see the SelectionTool in full
        // action.
        editor.setTool(new SelectionTool());

        // Activate the following line to only see the SelectAreaTracker in
        // action.
        //editor.setTool(new SelectAreaTracker());

        // Activate the following line to only see the DragTracker in
        // action.
        //editor.setTool(new DragTracker(lf));

        // Activate the following lines to only see the HandleTracker in
        // action.
        //view.selectAll();
        //editor.setTool(new HandleTracker(view.findHandle(view.drawingToView(lf.getStartPoint()))));

        f.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new SelectionToolSample();
            }
        });
    }
}
