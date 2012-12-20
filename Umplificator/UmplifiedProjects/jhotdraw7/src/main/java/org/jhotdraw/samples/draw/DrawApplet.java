/*
 * @(#)DrawApplet.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.draw;

import org.jhotdraw.draw.io.TextInputFormat;
import org.jhotdraw.draw.io.OutputFormat;
import org.jhotdraw.draw.io.InputFormat;
import org.jhotdraw.draw.io.ImageOutputFormat;
import org.jhotdraw.draw.io.ImageInputFormat;
import org.jhotdraw.draw.io.DOMStorableInputOutputFormat;
import org.jhotdraw.draw.*;
import org.jhotdraw.gui.*;

import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import org.jhotdraw.xml.*;

/**
 * DrawApplet.
 *
 * @author  wrandels
 * @version $Id: DrawApplet.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class DrawApplet extends JApplet {

    private final static String NAME = "JHotDraw Draw";
    private DrawingPanel drawingPanel;

    /**
     * We override getParameter() to make it work even if we have no Applet
     * context.
     */
    @Override
    public String getParameter(String name) {
        try {
            return super.getParameter(name);
        } catch (NullPointerException e) {
            return null;
        }
    }

    protected String getVersion() {
        return DrawApplet.class.getPackage().getImplementationVersion();
    }

    /** Initializes the applet DrawApplet */
    @Override
    public void init() {
        // Set look and feel
        // -----------------
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            // Do nothing.
            // If we can't set the desired look and feel, UIManager does
            // automaticaly the right thing for us.
        }
        // Set our own popup factory, because the one that comes with Mac OS X
        // creates translucent popups which is not useful for color selection
        // using pop menus.
        try {
            PopupFactory.setSharedInstance(new PopupFactory());
        } catch (Throwable e) {
            // If we can't set the popup factory, we have to use what is there.
        }


        // Display copyright info while we are loading the data
        // ----------------------------------------------------
        Container c = getContentPane();
        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
        String[] labels = getAppletInfo().split("\n");//Strings.split(getAppletInfo(), '\n');
        for (int i = 0; i < labels.length; i++) {
            c.add(new JLabel((labels[i].length() == 0) ? " " : labels[i]));
        }

        // We load the data using a worker thread
        // --------------------------------------
        new Worker<Drawing>() {

            @Override
            protected Drawing construct() throws IOException {
                Drawing result;
                if (getParameter("data") != null) {
                    NanoXMLDOMInput domi = new NanoXMLDOMInput(new DrawFigureFactory(), new StringReader(getParameter("data")));
                    result = (Drawing) domi.readObject(0);
                } else if (getParameter("datafile") != null) {
                    URL url = new URL(getDocumentBase(), getParameter("datafile"));
                    InputStream in = url.openConnection().getInputStream();
                    try {
                        NanoXMLDOMInput domi = new NanoXMLDOMInput(new DrawFigureFactory(), in);
                        result = (Drawing) domi.readObject(0);
                    } finally {
                        in.close();
                    }
                } else {
                    result = null;
                }
                return result;
            }

            @Override
            protected void done(Drawing result) {
                Container c = getContentPane();
                c.setLayout(new BorderLayout());
                c.removeAll();
                c.add(drawingPanel = new DrawingPanel());

                initComponents();
                if (result != null) {
                    setDrawing(result);
                }
            }

            @Override
            protected void failed(Throwable result) {
                Container c = getContentPane();
                c.setLayout(new BorderLayout());
                c.removeAll();
                c.add(drawingPanel = new DrawingPanel());

                result.printStackTrace();
                getDrawing().add(new TextFigure(result.toString()));
                result.printStackTrace();
            }

            @Override
            protected void finished() {
                Container c = getContentPane();
                initDrawing(getDrawing());
                c.validate();
            }
        }.start();
    }

    private void setDrawing(Drawing d) {
        drawingPanel.setDrawing(d);
    }

    private Drawing getDrawing() {
        return drawingPanel.getDrawing();
    }

    /**
     * Configure Drawing object to support copy and paste.
     */
    @SuppressWarnings("unchecked")
    private void initDrawing(Drawing d) {
        d.setInputFormats((java.util.List<InputFormat>) Collections.EMPTY_LIST);
        d.setOutputFormats((java.util.List<OutputFormat>) Collections.EMPTY_LIST);
        DOMStorableInputOutputFormat ioFormat = new DOMStorableInputOutputFormat(
                new DrawFigureFactory());
        d.addInputFormat(ioFormat);
        d.addInputFormat(new ImageInputFormat(new ImageFigure()));
        d.addInputFormat(new TextInputFormat(new TextFigure()));
        d.addOutputFormat(ioFormat);
        d.addOutputFormat(new ImageOutputFormat());
    }

    public void setData(String text) {
        if (text != null && text.length() > 0) {
            StringReader in = new StringReader(text);
            try {
                NanoXMLDOMInput domi = new NanoXMLDOMInput(new DrawFigureFactory(), in);
                setDrawing((Drawing) domi.readObject(0));
            } catch (Throwable e) {
                getDrawing().removeAllChildren();
                TextFigure tf = new TextFigure();
                tf.setText(e.getMessage());
                tf.setBounds(new Point2D.Double(10, 10), new Point2D.Double(100, 100));
                getDrawing().add(tf);
                e.printStackTrace();
            } finally {
                in.close();
            }
        }
    }

    public String getData() {
        CharArrayWriter out = new CharArrayWriter();
        try {
            NanoXMLDOMOutput domo = new NanoXMLDOMOutput(new DrawFigureFactory());
            domo.writeObject(getDrawing());
            domo.save(out);
        } catch (IOException e) {
            TextFigure tf = new TextFigure();
            tf.setText(e.getMessage());
            tf.setBounds(new Point2D.Double(10, 10), new Point2D.Double(100, 100));
            getDrawing().add(tf);
            e.printStackTrace();
        } finally {
            out.close();
        }
        return out.toString();
    }

    @Override
    public String[][] getParameterInfo() {
        return new String[][]{
                    {"data", "String", "the data to be displayed by this applet."},
                    {"datafile", "URL", "an URL to a file containing the data to be displayed by this applet."},};
    }

    @Override
    public String getAppletInfo() {
        return NAME
                + "\nVersion " + getVersion()
                + "\n\nCopyright 1996-2010 (c) by the original authors of JHotDraw and all its contributors"
                + "\nThis software is licensed under LGPL or"
                + "\nCreative Commons 3.0 BY";
    }

    /** This method is called from within the init() method to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        toolButtonGroup = new javax.swing.ButtonGroup();

    }// </editor-fold>//GEN-END:initComponents

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame("JHotDraw Draw Applet");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                DrawApplet a = new DrawApplet();
                f.getContentPane().add(a);
                a.init();
                f.setSize(620, 400);
                f.setVisible(true);
                a.start();
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup toolButtonGroup;
    // End of variables declaration//GEN-END:variables
}
