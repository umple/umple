/*
 * @(#)SerializationInputOutputFormat.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw.io;

import org.jhotdraw.draw.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.filechooser.FileFilter;
import org.jhotdraw.gui.datatransfer.AbstractTransferable;
import org.jhotdraw.gui.filechooser.ExtensionFileFilter;

/**
 * {@code SerializationInputOutputFormat} uses Java Serialization for reading and
 * and writing {@code Drawing} objects.
 *
 * @author Werner Randelshofer
 * @version $Id: SerializationInputOutputFormat.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class SerializationInputOutputFormat implements InputFormat, OutputFormat {

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
    private Drawing prototype;

    /** Creates a new instance with format name "Drawing", file extension "xml"
     * and mime type "image/x-jhotdraw".
     */
    public SerializationInputOutputFormat() {
        this("Drawing", "ser", new DefaultDrawing());
    }

    /** Creates a new instance using the specified parameters.
     */
    public SerializationInputOutputFormat(
            String description, String fileExtension, Drawing prototype) {
        this.description = description;
        this.fileExtension = fileExtension;
        this.mimeType = DataFlavor.javaSerializedObjectMimeType;
        this.prototype = prototype;
        this.dataFlavor = new DataFlavor(prototype.getClass(), description);
    }

    @Override
    public FileFilter getFileFilter() {
        return new ExtensionFileFilter(description, fileExtension);
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
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        try {
            read(in, drawing, replace);
        } finally {
            in.close();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void read(InputStream in, Drawing drawing, boolean replace) throws IOException {
        try {
            ObjectInputStream oin = new ObjectInputStream(in);
            Drawing d = (Drawing) oin.readObject();
            if (replace) {
                for (Map.Entry<AttributeKey, Object> e : d.getAttributes().entrySet()) {
                    drawing.set(e.getKey(), e.getValue());
                }
            }
            for (Figure f : d.getChildren()) {
                drawing.add(f);
            }
        } catch (ClassNotFoundException ex) {
            IOException ioe = new IOException("Couldn't read drawing.");
            ioe.initCause(ex);
            throw ioe;
        }
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(dataFlavor);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void read(Transferable t, Drawing drawing, boolean replace) throws UnsupportedFlavorException, IOException {
        try {
            Drawing d = (Drawing) t.getTransferData(dataFlavor);

            if (replace) {
                for (Map.Entry<AttributeKey, Object> e : d.getAttributes().entrySet()) {
                    drawing.set(e.getKey(), e.getValue());
                }
            }
            for (Figure f : d.getChildren()) {
                drawing.add(f);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override
    public String getFileExtension() {
        return fileExtension;
    }

    @Override
    public JComponent getOutputFormatAccessory() {
        return null;
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
        ObjectOutputStream oout = new ObjectOutputStream(out);
        oout.writeObject(drawing);
        oout.flush();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Transferable createTransferable(Drawing drawing, List<Figure> figures, double scaleFactor) throws IOException {
        final Drawing d = (Drawing) prototype.clone();

        HashMap<Figure, Figure> originalToDuplicateMap = new HashMap<Figure, Figure>(figures.size());
        final ArrayList<Figure> duplicates = new ArrayList<Figure>(figures.size());
        for (Figure f : figures) {
            Figure df = (Figure) f.clone();
            d.add(df);
            duplicates.add(df);
            originalToDuplicateMap.put(f, df);
        }
        for (Figure f : duplicates) {
            f.remap(originalToDuplicateMap, true);
        }


        return new AbstractTransferable(dataFlavor) {

            @Override
            public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
                if (isDataFlavorSupported(flavor)) {
                    return d;
                } else {
                    throw new UnsupportedFlavorException(flavor);
                }
            }
        };
    }
}
