/*
 * @(#)SmartConnectionFigureSample.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.mini;

import org.jhotdraw.draw.tool.DelegationSelectionTool;
import org.jhotdraw.draw.liner.ElbowLiner;
import org.jhotdraw.draw.connector.Connector;
import java.awt.geom.*;
import javax.swing.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.geom.*;
import static org.jhotdraw.draw.AttributeKeys.*;

/**
 * Example showing how to connect two text areas with an elbow connection.
 * <p>
 * The 'SmartConnectionFigure', that is used to connect the two areas draws
 * with double stroke, if the Figure at the start and at the end of the connection
 * is the same. 
 * <p>
 * In order to prevent editing of the stroke type by the user, the 
 * SmartConnectionFigure disables the stroke type attribute. Unless it needs
 * to be changed by the SmartConnectionFigure by itself.
 * 
 *
 * @author Werner Randelshofer
 * @version $Id: SmartConnectionFigureSample.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class SmartConnectionFigureSample {

    private static class SmartConnectionFigure extends LineConnectionFigure {

        public SmartConnectionFigure() {
            setAttributeEnabled(STROKE_TYPE, false);
        }

        @Override
        public void handleConnect(Connector start, Connector end) {
            setAttributeEnabled(STROKE_TYPE, true);
            willChange();
            set(STROKE_TYPE,
                    (start.getOwner() == end.getOwner()) ? StrokeType.DOUBLE : StrokeType.BASIC);
            changed();
            setAttributeEnabled(STROKE_TYPE, false);
        }

        @Override
        public void handleDisconnect(Connector start, Connector end) {
            setAttributeEnabled(STROKE_TYPE, true);
            willChange();
            set(STROKE_TYPE, StrokeType.BASIC);
            changed();
            setAttributeEnabled(STROKE_TYPE, false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                // Create a simple drawing consisting of three
                // text areas and an elbow connection.
                TextAreaFigure ta = new TextAreaFigure();
                ta.setBounds(new Point2D.Double(10, 30), new Point2D.Double(100, 100));
                TextAreaFigure tb = new TextAreaFigure();
                tb.setBounds(new Point2D.Double(220, 130), new Point2D.Double(310, 210));
                TextAreaFigure tc = new TextAreaFigure();
                tc.setBounds(new Point2D.Double(220, 30), new Point2D.Double(310, 100));
                ConnectionFigure cf = new SmartConnectionFigure();
                cf.setLiner(new ElbowLiner());
                cf.setStartConnector(ta.findConnector(Geom.center(ta.getBounds()), cf));
                cf.setEndConnector(tb.findConnector(Geom.center(tb.getBounds()), cf));
                Drawing drawing = new DefaultDrawing();
                drawing.add(ta);
                drawing.add(tb);
                drawing.add(tc);
                drawing.add(cf);

                // Show the drawing
                JFrame f = new JFrame("'Smart' ConnectionFigure Sample");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(400, 300);

                // Set up the drawing view
                DrawingView view = new DefaultDrawingView();
                view.setDrawing(drawing);
                f.getContentPane().add(view.getComponent());

                // Set up the drawing editor
                DrawingEditor editor = new DefaultDrawingEditor();
                editor.add(view);
                editor.setTool(new DelegationSelectionTool());

                f.setVisible(true);
            }
        });
    }
}
