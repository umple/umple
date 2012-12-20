/*
 * @(#)DOMStorableOutputFormat.java
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
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JComponent;
import org.jhotdraw.gui.datatransfer.InputStreamTransferable;
import org.jhotdraw.xml.*;

/**
 * An OutputFormat that can write Drawings with DOMStorable Figure's.
 * <p>
 * This class is here to support quick-and-dirty implementations of drawings
 * that can be read and written from/to output streams. For example, in student
 * projects.
 * <p>
 * This class should no be used as a means to implement long-term storage of
 * drawings, since it does not support structural changes that might occur in
 * a drawing application over time.
 *
 * @author Werner Randelshofer
 * @version $Id: DOMStorableInputOutputFormat.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class DOMStorableInputOutputFormat implements OutputFormat, InputFormat {

    private DOMFactory factory;
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
     * The mime type is used for clipboard access.
     */
    private String mimeType;
    /**
     * The data flavor constructed from the mime type.
     */
    private DataFlavor dataFlavor;

    /** Creates a new instance with format name "Drawing", file extension "xml"
     * and mime type "image/x-jhotdraw".
     */
    public DOMStorableInputOutputFormat(DOMFactory factory) {
        this(factory, "Drawing", "xml", "image/x-jhotdraw");
    }

    /** Creates a new instance using the specified parameters.
     *
     * @param factory The factory for creating Figures from XML elements.
     * @param description The format description to be used for the file filter.
     * @param fileExtension The file extension to be used for file filter.
     * @param mimeType The Mime Type is used for clipboard access.
     */
    public DOMStorableInputOutputFormat(
            DOMFactory factory,
            String description, String fileExtension, String mimeType) {
        this.factory = factory;
        this.description = description;
        this.fileExtension = fileExtension;
        this.mimeType = mimeType;
        try {
            this.dataFlavor = new DataFlavor(mimeType);
        } catch (ClassNotFoundException ex) {
            InternalError error = new InternalError("Unable to create data flavor for mime type:" + mimeType);
            error.initCause(ex);
            throw error;
        }
    }

    @Override
    public javax.swing.filechooser.FileFilter getFileFilter() {
        return new ExtensionFileFilter(description, fileExtension);
    }

    @Override
    public JComponent getOutputFormatAccessory() {
        return null;
    }

    @Override
    public JComponent getInputFormatAccessory() {
        return null;
    }

    /**
     * Reads a list of figures into the specified drawing.
     * This method expects that there is a child element named "figures"
     * in the element that represents the drawing.
     */
    protected void read(URL url, InputStream in, Drawing drawing, LinkedList<Figure> figures) throws IOException {
        NanoXMLDOMInput domi = new NanoXMLDOMInput(factory, in);
        domi.openElement(factory.getName(drawing));
        domi.openElement("figures", 0);
        figures.clear();
        for (int i = 0, n = domi.getElementCount(); i < n; i++) {
            Figure f = (Figure) domi.readObject();
            figures.add(f);
        }
        domi.closeElement();
        domi.closeElement();
        drawing.basicAddAll(drawing.getChildCount(), figures);
    }

    @Override
    public String getFileExtension() {
        return fileExtension;
    }
    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(dataFlavor);
    }

    @Override
    public void write(URI uri, Drawing drawing) throws IOException {
        write(new File(uri),drawing);
    }

    public void write(File file, Drawing drawing) throws IOException {
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
        try {
            write(out, drawing);
        } finally {
            out.close();
        }
    }

    @Override
    public void write(OutputStream out, Drawing drawing) throws IOException {
        NanoXMLDOMOutput domo = new NanoXMLDOMOutput(factory);
        domo.openElement(factory.getName(drawing));
        drawing.write(domo);
        domo.closeElement();
        domo.save(out);
        domo.dispose();
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
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        try {
            read(in, drawing, replace);
        } finally {
            in.close();
        }
    }

    @Override
    public void read(InputStream in, Drawing drawing, boolean replace) throws IOException {
        NanoXMLDOMInput domi = new NanoXMLDOMInput(factory, in);
        domi.openElement(factory.getName(drawing));
        if (replace) {
            drawing.removeAllChildren();
        }
        drawing.read(domi);
        domi.closeElement();
        domi.dispose();
    }

    @Override
    public void read(Transferable t, Drawing drawing, boolean replace) throws UnsupportedFlavorException, IOException {
        LinkedList<Figure> figures = new LinkedList<Figure>();
        InputStream in = (InputStream) t.getTransferData(new DataFlavor(mimeType, description));
        NanoXMLDOMInput domi = new NanoXMLDOMInput(factory, in);
        domi.openElement("Drawing-Clip");
        for (int i = 0, n = domi.getElementCount(); i < n; i++) {
            Figure f = (Figure) domi.readObject(i);
            figures.add(f);
        }
        domi.closeElement();
        if (replace) {
            drawing.removeAllChildren();
        }
        drawing.addAll(figures);
    }

    @Override
    public Transferable createTransferable(Drawing drawing, List<Figure> figures, double scaleFactor) throws IOException {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        NanoXMLDOMOutput domo = new NanoXMLDOMOutput(factory);
        domo.openElement("Drawing-Clip");
        for (Figure f : figures) {
            domo.writeObject(f);
        }
        domo.closeElement();
        domo.save(buf);
        return new InputStreamTransferable(new DataFlavor(mimeType, description), buf.toByteArray());
    }
}
