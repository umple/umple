/*
 * @(#)SVGApplet.java
 *
 * Copyright (c) 2006-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.svg;

import org.jhotdraw.draw.io.InputFormat;
import org.jhotdraw.draw.io.ImageOutputFormat;
import org.jhotdraw.draw.io.ImageInputFormat;
import org.jhotdraw.io.BoundedRangeInputStream;
import java.applet.AppletContext;
import org.jhotdraw.draw.*;
import org.jhotdraw.gui.*;
import org.jhotdraw.util.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import org.jhotdraw.samples.svg.figures.*;
import org.jhotdraw.samples.svg.io.*;
import org.jhotdraw.samples.svg.gui.*;

/**
 * This is the base class for concrete implementations of SVG drawing
 * applets.
 * <p>
 * The base class loads and saves drawings asynchronously and handles
 * errors. The actual data transmission and the editing of drawings
 * is the responsibility of the subclasses.
 * <p>
 * FIXME - Applet must offer to save file locally, if uploading to server
 * failed.
 * <p>
 * FIXME - Applet must save changes locally and reload them, if the user
 * navigated out of the page and back again, without saving the changes.
 * 
 * @author Werner Randelshofer
 * @version $Id: SVGApplet.java 723 2010-12-28 14:31:24Z rawcoder $
 */
public class SVGApplet extends JApplet {

    private SVGDrawingPanel drawingComponent;
    /**
     * Lazily initialized in method getVersion();
     */
    private String version;
    private long start;

    public SVGApplet() {
        setBackground(Color.WHITE);
        start = System.currentTimeMillis();
        setName("JHotDraw SVG Applet " + getClass().getPackage().getImplementationVersion());
        ((JComponent) getContentPane()).setBorder(new MatteBorder(new Insets(1, 1, 1, 1), new Color(0xa5a5a5)));
        //ResourceBundleUtil.setVerbose(true);
    }

    /**
     * Same as <code>Applet.getParameter()</code> but doesn't throw a
     * NullPointerException when used without an Applet context.
     */
    @Override
    public String getParameter(String name) {
        try {
            return super.getParameter(name);
        } catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Same as <code>Applet.getParameter()</code> but doesn't throw a
     * NullPointerException when used without an Applet context.
     */
    public String getParameter(String name, String defaultValue) {
        try {
            String value = super.getParameter(name);
            return (value == null) ? defaultValue : value;
        } catch (NullPointerException e) {
            return defaultValue;
        }
    }

    /**
     * Displays a progress indicator and then invokes <code>loadDrawing</code>
     * on a worker thread. Displays the drawing panel when done successfully.
     * Displays an error message when done unsuccessfully.
     *
     * @see #loadDrawing
     */
    @Override
    public final void init() {
        // set the language of the applet
        if (getParameter("Locale") != null) {
            Locale.setDefault(new Locale(getParameter("Locale")));
        }


        final ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");

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

        // Display a progress indicator while we are loading the drawing
        // ----------------------------------------------------------
        Container c = getContentPane();
        final ProgressIndicator progress = new ProgressIndicator(
                getName(), labels.getString("progressInitializing"));
        c.add(progress);
        progress.revalidate();

        // Load the drawing using a worker thread
        // --------------------------------------
        new Worker() {

            @Override
            protected Object construct() throws Exception {
                Thread t = new Thread() {

                    @Override
                    public void run() {
                        drawingComponent = createDrawingComponent();
                    }
                };
                t.start();
                progress.setNote(labels.getString("progressLoading"));
                Object drawing = loadDrawing(progress);
                progress.setNote(labels.getString("progressOpeningEditor"));
                progress.setIndeterminate(true);
                t.join();
                return drawing;
            }

            @Override
            protected void done(Object result) {
                Container c = getContentPane();
                c.setLayout(new BorderLayout());
                c.removeAll();
                c.add(drawingComponent.getComponent());
                initComponents();
                if (result != null) {
                    if (result instanceof Drawing) {
                        setDrawing((Drawing) result);
                    } else if (result instanceof Throwable) {
                        setDrawing(createDrawing());
                        getDrawing().add(new SVGTextFigure(result.toString()));
                        ((Throwable) result).printStackTrace();
                    }
                }
                drawingComponent.revalidate();
            }

            @Override
            protected void failed(Throwable result) {
                Container c = getContentPane();
                c.setLayout(new BorderLayout());
                c.removeAll();
                Throwable error = (Throwable) result;
                error.printStackTrace();
                String message = (error.getMessage() == null) ? error.toString() : error.getMessage();
                MessagePanel mp = new MessagePanel(
                        UIManager.getIcon("OptionPane.errorIcon"),
                        labels.getFormatted("messageLoadFailed", htmlencode(getParameter("DrawingURL")), htmlencode(message)));
                c.add(mp);
                mp.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getActionCommand().equals("close")) {
                            close();
                        }
                    }
                });
                mp.revalidate();
            }

            @Override
            protected void finished() {
                long end = System.currentTimeMillis();
                System.out.println("AbstractDrawingApplet startup latency:" + (end - start));
            }
        }.start();
    }

    /**
     * Sets the drawing on the drawing panel.
     */
    private void setDrawing(Drawing d) {
        drawingComponent.setDrawing(d);
    }

    /**
     * Gets the drawing from the drawing panel.
     */
    private Drawing getDrawing() {
        return drawingComponent.getDrawing();
    }

    /**
     * Gets the version of the applet.
     */
    public String getVersion() {
        if (version == null) {
            BufferedReader r = null;
            try {
                InputStream resource = SVGApplet.class.getResourceAsStream("version.txt");
                r = new BufferedReader(new InputStreamReader(resource, "UTF-8"));
                version = r.readLine();
            } catch (IOException e) {
                version = "unknown";
            } catch (NullPointerException e) {
                version = "unknown";
            } finally {
                if (r != null) {
                    try {
                        r.close();
                    } catch (IOException e) {
                        // suppress
                    }
                }
            }
        }
        return version;
    }

    /**
     * Returns information about the applet.
     */
    @Override
    public String getAppletInfo() {
        return getName()
                + "\nVersion " + getVersion()
                + "\n\nCopyright 1996-2010 (c) by the original authors of JHotDraw and all its contributors"
                + "\nThis software is licensed under LGPL or"
                + "\nCreative Commons 2.5 BY";
    }

    /**
     * Creates the drawing.
     */
    /**
     * Creates the drawing.
     */
    protected Drawing createDrawing() {
        DefaultDrawing drawing = new DefaultDrawing();
        drawing.addInputFormat(new SVGZInputFormat());
        drawing.addInputFormat(new ImageInputFormat(new SVGImageFigure()));
        drawing.addOutputFormat(new SVGOutputFormat());
        drawing.addOutputFormat(new SVGZOutputFormat());
        drawing.addOutputFormat(new ImageOutputFormat());
        drawing.addOutputFormat(new ImageOutputFormat("JPG", "Joint Photographics Experts Group (JPEG)", "jpg", BufferedImage.TYPE_INT_RGB));
        drawing.addOutputFormat(new ImageOutputFormat("BMP", "Windows Bitmap (BMP)", "bmp", BufferedImage.TYPE_BYTE_INDEXED));
        return drawing;
    }

    /**
     * Creates the drawing component.
     */
    protected SVGDrawingPanel createDrawingComponent() {
        SVGDrawingPanel p = new SVGDrawingPanel();
        p.setEditor(new DefaultDrawingEditor());

        return p;
    }

    protected SVGDrawingPanel getDrawingComponent() {
        return drawingComponent;
    }

    @Override
    public String[][] getParameterInfo() {
        return new String[][]{
                    {"data", "String", "the data to be displayed by this applet."},
                    {"datafile", "URL", "an URL to a file containing the data to be displayed by this applet."}};
    }

    /**
     * Loads the drawing.
     * By convention this method is invoked on a worker thread.
     *
     * @param progress A ProgressIndicator to inform the user about the progress
     * of the operation.
     * @return The Drawing that was loaded.
     */
    protected Drawing loadDrawing(ProgressIndicator progress) throws IOException {
        Drawing drawing = createDrawing();
        if (getParameter("datafile") != null) {
            URL url = new URL(getDocumentBase(), getParameter("datafile"));
            URLConnection uc = url.openConnection();

            // Disable caching. This ensures that we always request the
            // newest version of the drawing from the server.
            // (Note: The server still needs to set the proper HTTP caching
            // properties to prevent proxies from caching the drawing).
            if (uc instanceof HttpURLConnection) {
                ((HttpURLConnection) uc).setUseCaches(false);
            }

            // Read the data into a buffer
            int contentLength = uc.getContentLength();
            InputStream in = uc.getInputStream();
            try {
                if (contentLength != -1) {
                    in = new BoundedRangeInputStream(in);
                    ((BoundedRangeInputStream) in).setMaximum(contentLength + 1);
                    progress.setProgressModel((BoundedRangeModel) in);
                    progress.setIndeterminate(false);
                }
                BufferedInputStream bin = new BufferedInputStream(in);
                bin.mark(512);

                // Read the data using all supported input formats
                // until we succeed
                IOException formatException = null;
                for (InputFormat format : drawing.getInputFormats()) {
                    try {
                        bin.reset();
                    } catch (IOException e) {
                        uc = url.openConnection();
                        in = uc.getInputStream();
                        in = new BoundedRangeInputStream(in);
                        ((BoundedRangeInputStream) in).setMaximum(contentLength + 1);
                        progress.setProgressModel((BoundedRangeModel) in);
                        bin = new BufferedInputStream(in);
                        bin.mark(512);
                    }
                    try {
                        bin.reset();
                        format.read(bin, drawing, true);
                        formatException = null;
                        break;
                    } catch (IOException e) {
                        formatException = e;
                    }
                }
                if (formatException != null) {
                    throw formatException;
                }
            } finally {
                in.close();
            }
        }
        return drawing;
    }

    /**
     * Closes the applet. This method can be implemented by invoking
     * <code>getAppletContext().showDocument(...)</code>.
     */
    protected void close() {
        AppletContext appletContext;
        try {
            appletContext = getAppletContext();
        } catch (Throwable e) {
            appletContext = null;
        }

        if (appletContext == null) {
            System.exit(0);
        } else {
            try {
                appletContext.showDocument(new URL(getDocumentBase(), getParameter("PageURL")));
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            }

        }
    }

    /**
     * Escapes all '<', '>' and '&' characters in a string.
     * @param str A String.
     * @return HTMlEncoded String.
     */
    private static String htmlencode(String str) {
        if (str == null) {
            return "";
        } else {
            StringBuilder buf = new StringBuilder();
            for (char ch : str.toCharArray()) {
                switch (ch) {
                    case '<':
                        buf.append("&lt;");
                        break;

                    case '>':
                        buf.append("&gt;");
                        break;

                    case '&':
                        buf.append("&amp;");
                        break;

                    default:

                        buf.append(ch);
                        break;
                }
            }
            return buf.toString();
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new JFrame("JHotDraw SVG Sample Applet");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                SVGApplet a = new SVGApplet();
                f.getContentPane().add(a);
                a.init();
                f.setSize(500, 300);
                f.setVisible(true);
                a.start();
            }
        });
    }

    /** This method is called from within the init() method to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
