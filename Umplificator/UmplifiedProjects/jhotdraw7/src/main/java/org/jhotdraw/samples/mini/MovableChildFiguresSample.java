/*
 * @(#)MovableChildFiguresSample.java
 *
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.mini;

import org.jhotdraw.draw.tool.DelegationSelectionTool;
import org.jhotdraw.draw.handle.ResizeHandleKit;
import org.jhotdraw.draw.handle.MoveHandle;
import org.jhotdraw.draw.handle.DragHandle;
import org.jhotdraw.draw.handle.Handle;
import java.awt.BorderLayout;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;
import org.jhotdraw.draw.*;

/**
 * Example showing how to create a graphical composite figure which holds
 * component figures that can be moved independently using handles.
 *
 * @author Werner Randelshofer
 * @version $Id: EditorSample.java 527 2009-06-07 14:28:19Z rawcoder $
 */
public class MovableChildFiguresSample {

    private static class LabeledEllipseFigure extends GraphicalCompositeFigure {

        public LabeledEllipseFigure() {
            setPresentationFigure(new EllipseFigure());
            LabelFigure label = new LabelFigure("Label");
            label.transform(new AffineTransform(0, 0, 0, 0, 25, 37));
            add(label);
        }

        /**
         * Return default handles from the presentation figure.
         */
        @Override
        public Collection<Handle> createHandles(int detailLevel) {
            LinkedList<Handle> handles = new LinkedList<Handle>();
            switch (detailLevel) {
                case 0:
                    MoveHandle.addMoveHandles(this, handles);
                    for (Figure child : getChildren()) {
                        MoveHandle.addMoveHandles(child, handles);
                        handles.add(new DragHandle(child));
                    }
                    break;
                case 1:
                    ResizeHandleKit.addResizeHandles(this, handles);
                    break;
                default:
                    break;
            }
            return handles;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                // Create a simple drawing consisting of three
                // text areas and an elbow connection.
                LabeledEllipseFigure ta = new LabeledEllipseFigure();
                ta.setBounds(new Point2D.Double(10, 10), new Point2D.Double(100, 100));
                LabeledEllipseFigure tb = new LabeledEllipseFigure();
                tb.setBounds(new Point2D.Double(220, 120), new Point2D.Double(310, 210));
                LabeledEllipseFigure tc = new LabeledEllipseFigure();
                tc.setBounds(new Point2D.Double(220, 10), new Point2D.Double(310, 100));
                Drawing drawing = new DefaultDrawing();
                drawing.add(ta);
                drawing.add(tb);
                drawing.add(tc);

                // Create a frame with a drawing view and a drawing editor
                JFrame f = new JFrame("My Drawing");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(400, 300);
                DrawingView view = new DefaultDrawingView();
                view.setDrawing(drawing);
                f.add(view.getComponent());
                f.add(new JLabel("Press space bar to toggle handles."), BorderLayout.SOUTH);
                DrawingEditor editor = new DefaultDrawingEditor();
                editor.add(view);
                editor.setTool(new DelegationSelectionTool());
                f.setVisible(true);
            }
        });
    }
}
