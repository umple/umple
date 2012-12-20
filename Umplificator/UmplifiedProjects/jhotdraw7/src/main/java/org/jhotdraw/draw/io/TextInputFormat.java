/*
 * @(#)TextInputFormat.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw.io;

import org.jhotdraw.gui.filechooser.ExtensionFileFilter;
import org.jhotdraw.draw.*;
import java.awt.datatransfer.*;
import java.awt.geom.*;
import java.io.*;
import java.net.URI;
import java.util.*;
import javax.swing.*;
import org.jhotdraw.geom.Dimension2DDouble;

/**
 * An input format for importing text into a drawing.
 * <p>
 * This class uses the prototype design pattern. A TextHolderFigure figure is used
 * as a prototype for creating a figure that holds the imported text.
 * <p>
 * For text that spans multiple lines, TextInputFormat can either add all the
 * text to the same Figure, or it can create a new Figure for each line.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Prototype</em><br>
 * The text input format creates new text holder figures by cloning a prototype figure
 * object and assigning an image to it, which was read from data input.
 * That's the reason why {@code Figure} extends the {@code Cloneable} interface.
 * <br>
 * Prototype: {@link TextHolderFigure}; Client: {@link org.jhotdraw.draw.io.TextInputFormat}.
 * <hr>
 *
 * @author Werner Randelshofer 
 * @version $Id: TextInputFormat.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class TextInputFormat implements InputFormat {

    /**
     * The prototype for creating a figure that holds the imported text.
     */
    private TextHolderFigure prototype;
    /**
     * Format description used for the file filter.
     */
    private String description;
    /**
     * File name extension used for the file filter.
     */
    private String fileExtension;
    /**
     * Image IO image format name.
     */
    private String formatName;
    /**
     * This should be set to true for ImageHolderFigures that can hold multiple
     * lines of text.
     */
    private boolean isMultiline;

    /** Creates a new image output format for text, for a figure that can not.
     * hold multiple lines of text.
     */
    public TextInputFormat(TextHolderFigure prototype) {
        this(prototype, "Text", "Text", "txt", false);
    }

    /** Creates a new image output format for the specified image format.
     *
     * @param formatName The format name for the javax.imageio.ImageIO object.
     * @param description The format description to be used for the file filter.
     * @param fileExtension The file extension to be used for file filter.
     * @param isMultiline Set this to true, if the TextHolderFigure can hold
     * multiple lines of text. If this is true, multiple lines of text are
     * added to the same figure. If this is false, a new Figure is created for
     * each line of text.
     */
    public TextInputFormat(TextHolderFigure prototype, String formatName,
            String description, String fileExtension, boolean isMultiline) {
        this.prototype = prototype;
        this.formatName = formatName;
        this.description = description;
        this.fileExtension = fileExtension;
        this.isMultiline = isMultiline;
    }

    @Override
    public javax.swing.filechooser.FileFilter getFileFilter() {
        return new ExtensionFileFilter(description, fileExtension);
    }

    public String getFileExtension() {
        return fileExtension;
    }

    @Override
    public JComponent getInputFormatAccessory() {
        return null;
    }

    @Override
    public void read(URI uri, Drawing drawing) throws IOException {
        read(new File(uri), drawing);
    }

    @Override
    public void read(URI uri, Drawing drawing, boolean replace) throws IOException {
        read(new File(uri), drawing, replace);
    }

    public void read(File file, Drawing drawing) throws IOException {
        read(file, drawing, true);
    }

    public void read(File file, Drawing drawing, boolean replace) throws IOException {
        InputStream in = new FileInputStream(file);
        try {
            read(in, drawing, replace);
        } finally {
            in.close();
        }
    }

    @Override
    public void read(InputStream in, Drawing drawing, boolean replace) throws IOException {
        if (replace) {
            drawing.removeAllChildren();
        }
        drawing.basicAddAll(0, createTextHolderFigures(in));
    }

    public LinkedList<Figure> createTextHolderFigures(InputStream in) throws IOException {
        LinkedList<Figure> list = new LinkedList<Figure>();

        BufferedReader r = new BufferedReader(new InputStreamReader(in, "UTF8"));

        if (isMultiline) {
            TextHolderFigure figure = (TextHolderFigure) prototype.clone();
            StringBuilder buf = new StringBuilder();
            for (String line = null; line != null; line = r.readLine()) {
                if (buf.length() != 0) {
                    buf.append('\n');
                }
                buf.append(line);
            }
            figure.setText(buf.toString());
            Dimension2DDouble s = figure.getPreferredSize();
            figure.setBounds(
                    new Point2D.Double(0, 0),
                    new Point2D.Double(
                    s.width, s.height));
        } else {
            double y = 0;
            for (String line = null; line != null; line = r.readLine()) {
                TextHolderFigure figure = (TextHolderFigure) prototype.clone();
                figure.setText(line);
                Dimension2DDouble s = figure.getPreferredSize();
                figure.setBounds(
                        new Point2D.Double(0, y),
                        new Point2D.Double(
                        s.width, s.height));
                list.add(figure);
                y += s.height;
            }
        }
        if (list.size() == 0) {
            throw new IOException("No text found");
        }
        return list;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(DataFlavor.stringFlavor);
    }

    @Override
    public void read(Transferable t, Drawing drawing, boolean replace) throws UnsupportedFlavorException, IOException {
        String text = (String) t.getTransferData(DataFlavor.stringFlavor);

        LinkedList<Figure> list = new LinkedList<Figure>();
        if (isMultiline) {
            TextHolderFigure figure = (TextHolderFigure) prototype.clone();
            figure.setText(text);
            Dimension2DDouble s = figure.getPreferredSize();
            figure.willChange();
            figure.setBounds(
                    new Point2D.Double(0, 0),
                    new Point2D.Double(
                    s.width, s.height));
            figure.changed();
            list.add(figure);
        } else {
            double y = 0;
            for (String line : text.split("\n")) {
                TextHolderFigure figure = (TextHolderFigure) prototype.clone();
                figure.setText(line);
                Dimension2DDouble s = figure.getPreferredSize();
                y += s.height;
                figure.willChange();
                figure.setBounds(
                        new Point2D.Double(0, 0 + y),
                        new Point2D.Double(
                        s.width, s.height + y));
                figure.changed();
                list.add(figure);
            }
        }
        if (replace) {
            drawing.removeAllChildren();
        }
        drawing.addAll(list);
    }
}
