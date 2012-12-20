/*
 * @(#)ConnectingFiguresSample.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.mini;

import org.jhotdraw.draw.liner.ElbowLiner;
import java.awt.geom.*;
import javax.swing.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.geom.*;

/**
 * Example showing how to connect two text areas with an elbow connection.
 *
 * @author Werner Randelshofer
 * @version $Id: ConnectingFiguresSample.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class ConnectingFiguresSample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
                // Create the two text areas
                TextAreaFigure ta = new TextAreaFigure();
                ta.setBounds(new Point2D.Double(10,10),new Point2D.Double(100,100));
                
                TextAreaFigure tb = new TextAreaFigure();
                tb.setBounds(new Point2D.Double(210,110),new Point2D.Double(300,200));
                
                // Create an elbow connection
                ConnectionFigure cf = new LineConnectionFigure();
                cf.setLiner(new ElbowLiner());
                
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
                f.setSize(400,300);
                
                DrawingView view = new DefaultDrawingView();
                view.setDrawing(drawing);
                f.getContentPane().add(view.getComponent());
                
                f.setVisible(true);
            }
        });
    }
}
