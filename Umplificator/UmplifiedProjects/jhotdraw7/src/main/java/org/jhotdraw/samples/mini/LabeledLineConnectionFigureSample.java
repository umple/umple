/*
 * @(#)LabeledConnectionSample.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.mini;

import org.jhotdraw.draw.locator.BezierLabelLocator;
import org.jhotdraw.draw.layouter.LocatorLayouter;
import org.jhotdraw.draw.liner.ElbowLiner;
import java.awt.geom.*;
import javax.swing.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.geom.*;

/**
 * Example showing how to connect two rectangles with a labeled connection,
 * that has a labels at both ends.
 *
 * @author Werner Randelshofer
 * @version $Id: LabeledLineConnectionFigureSample.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class LabeledLineConnectionFigureSample {

    /** Creates a new instance. */
    public LabeledLineConnectionFigureSample() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // Create the two rectangle figures
                RectangleFigure ta = new RectangleFigure();
                ta.setBounds(new Point2D.Double(10, 10), new Point2D.Double(100, 100));

                RectangleFigure tb = new RectangleFigure();
                tb.setBounds(new Point2D.Double(210, 110), new Point2D.Double(300, 200));

                // Create a labeled line connection
                LabeledLineConnectionFigure cf = new LabeledLineConnectionFigure();
                cf.setLiner(new ElbowLiner());
                cf.setLayouter(new LocatorLayouter());

                // Create labels and add them to both ends of the labeled line connection
                TextFigure startLabel = new TextFigure();
                startLabel.set(LocatorLayouter.LAYOUT_LOCATOR, new BezierLabelLocator(0, -Math.PI / 4, 8));
                startLabel.setEditable(false);
                startLabel.setText("start");
                cf.add(startLabel);

                TextFigure endLabel = new TextFigure();
                endLabel.set(LocatorLayouter.LAYOUT_LOCATOR, new BezierLabelLocator(1, Math.PI + Math.PI / 4, 8));
                endLabel.setEditable(false);
                endLabel.setText("end");
                cf.add(endLabel);


                // Connect the figures
                cf.setStartConnector(ta.findConnector(Geom.center(ta.getBounds()), cf));
                cf.setEndConnector(tb.findConnector(Geom.center(tb.getBounds()), cf));

                // Add all figures to a drawing
                Drawing drawing = new DefaultDrawing();
                drawing.add(ta);
                drawing.add(tb);
                drawing.add(cf);

                // Show the drawing
                JFrame f = new JFrame("My Drawing");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(400, 300);

                DrawingView view = new DefaultDrawingView();
                view.setDrawing(drawing);
                f.getContentPane().add(view.getComponent());

                f.setVisible(true);
            }
        });
    }
}
