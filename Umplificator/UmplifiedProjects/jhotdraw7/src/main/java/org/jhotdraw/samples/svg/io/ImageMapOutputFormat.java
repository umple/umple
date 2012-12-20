/*
 * @(#)ImageMapOutputFormat.java
 *
 * Copyright (c) 2007-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.svg.io;

import org.jhotdraw.gui.filechooser.ExtensionFileFilter;
import org.jhotdraw.draw.io.OutputFormat;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.geom.*;
import java.io.*;
import java.net.URI;
import javax.swing.*;
import net.n3.nanoxml.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.geom.*;
import org.jhotdraw.gui.datatransfer.*;
import org.jhotdraw.samples.svg.figures.*;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;
import org.jhotdraw.util.*;

/**
 * ImageMapOutputFormat exports a SVG drawing as an HTML 4.01 <code>MAP</code>
 * element.
 * For more information see:
 * http://www.w3.org/TR/html401/struct/objects.html#h-13.6.2
 *
 *
 * @author Werner Randelshofer
 * @version $Id: ImageMapOutputFormat.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ImageMapOutputFormat implements OutputFormat {

    /**
     * The affine transformation for the output. This is used
     * to create scaled image maps.
     */
    private AffineTransform drawingTransform = new AffineTransform();
    private static boolean DEBUG = true;
    /**
     * Set this to true, if AREA elements with <code>nohref="true"</code>
     * shall e included in the image map.
     */
    private boolean isIncludeNohref = false;
    /**
     * Image dimension. We only include AREA elements which are within the
     * image dimension.
     */
    private Rectangle bounds = new Rectangle(0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);

    /** Creates a new instance. */
    public ImageMapOutputFormat() {
    }

    @Override
    public javax.swing.filechooser.FileFilter getFileFilter() {
        return new ExtensionFileFilter("HTML Image Map", "html");
    }

    @Override
    public String getFileExtension() {
        return "html";
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
        BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream(file));
        try {
            write(out, drawing);
        } finally {
            out.close();
        }
    }

    @Override
    public void write(OutputStream out, Drawing drawing) throws IOException {
        write(out, drawing.getChildren());
    }

    /**
     * Writes the drawing to the specified output stream.
     * This method applies the specified drawingTransform to the drawing, and draws
     * it on an image of the specified getChildCount.
     */
    public void write(OutputStream out, Drawing drawing,
            AffineTransform drawingTransform, Dimension imageSize) throws IOException {
        write(out, drawing.getChildren(), drawingTransform, imageSize);
    }

    /**
     * Writes the figures to the specified output stream.
     * This method applies the specified drawingTransform to the drawing, and draws
     * it on an image of the specified getChildCount.
     * 
     * All other write methods delegate their work to here.
     */
    public void write(OutputStream out, java.util.List<Figure> figures,
            AffineTransform drawingTransform, Dimension imageSize) throws IOException {

        this.drawingTransform = (drawingTransform == null) ? new AffineTransform() : drawingTransform;
        this.bounds = (imageSize == null) ? new Rectangle(0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE) : new Rectangle(0, 0, imageSize.width, imageSize.height);

        XMLElement document = new XMLElement("map");

        // Note: Image map elements need to be written from front to back
        for (Figure f : new ReversedList<Figure>(figures)) {
            writeElement(document, f);
        }

        // Strip AREA elements with "nohref" attributes from the end of the
        // map
        if (!isIncludeNohref) {
            for (int i = document.getChildrenCount() - 1; i >= 0; i--) {
                XMLElement child = (XMLElement) document.getChildAtIndex(i);
                if (child.hasAttribute("nohref")) {
                    document.removeChildAtIndex(i);
                }
            }
        }


        // Write XML content
        PrintWriter writer = new PrintWriter(
                new OutputStreamWriter(out, "UTF-8"));
        //new XMLWriter(writer).write(document);
        for (Object o : document.getChildren()) {
            XMLElement child = (XMLElement) o;
            new XMLWriter(writer).write(child);
        }

        // Flush writer
        writer.flush();
    }

    /**
     * All other write methods delegate their work to here.
     */
    public void write(OutputStream out, java.util.List<Figure> figures) throws IOException {
        Rectangle2D.Double drawingRect = null;

        for (Figure f : figures) {
            if (drawingRect == null) {
                drawingRect = f.getBounds();
            } else {
                drawingRect.add(f.getBounds());
            }
        }

        AffineTransform tx = new AffineTransform();
        tx.translate(
                -Math.min(0, drawingRect.x),
                -Math.min(0, drawingRect.y));

        write(out, figures, tx,
                new Dimension(
                (int) (Math.abs(drawingRect.x) + drawingRect.width),
                (int) (Math.abs(drawingRect.y) + drawingRect.height)));
    }

    @Override
    public Transferable createTransferable(Drawing drawing, java.util.List<Figure> figures, double scaleFactor) throws IOException {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        write(buf, figures);
        return new InputStreamTransferable(new DataFlavor("text/html", "HTML Image Map"), buf.toByteArray());
    }

    protected void writeElement(IXMLElement parent, Figure f) throws IOException {
        if (f instanceof SVGEllipseFigure) {
            writeEllipseElement(parent, (SVGEllipseFigure) f);
        } else if (f instanceof SVGGroupFigure) {
            writeGElement(parent, (SVGGroupFigure) f);
        } else if (f instanceof SVGImageFigure) {
            writeImageElement(parent, (SVGImageFigure) f);
        } else if (f instanceof SVGPathFigure) {
            SVGPathFigure path = (SVGPathFigure) f;
            if (path.getChildCount() == 1) {
                BezierFigure bezier = (BezierFigure) path.getChild(0);
                boolean isLinear = true;
                for (int i = 0, n = bezier.getNodeCount(); i < n; i++) {
                    if (bezier.getNode(i).getMask() != 0) {
                        isLinear = false;
                        break;
                    }
                }
                if (isLinear) {
                    if (bezier.isClosed()) {
                        writePolygonElement(parent, path);
                    } else {
                        if (bezier.getNodeCount() == 2) {
                            writeLineElement(parent, path);
                        } else {
                            writePolylineElement(parent, path);
                        }
                    }
                } else {
                    writePathElement(parent, path);
                }
            } else {
                writePathElement(parent, path);
            }
        } else if (f instanceof SVGRectFigure) {
            writeRectElement(parent, (SVGRectFigure) f);
        } else if (f instanceof SVGTextFigure) {
            writeTextElement(parent, (SVGTextFigure) f);
        } else if (f instanceof SVGTextAreaFigure) {
            writeTextAreaElement(parent, (SVGTextAreaFigure) f);
        } else {
            System.out.println("Unable to write: " + f);
        }
    }

    /**
     * Writes the <code>shape</code>, <code>coords</code>, <code>href</code>,
     * <code>nohref</code> Attribute for the specified figure and ellipse.
     *
     * @return Returns true, if the circle is inside of the image bounds.
     */
    private boolean writeCircleAttributes(IXMLElement elem, SVGFigure f, Ellipse2D.Double ellipse) {
        AffineTransform t = TRANSFORM.getClone(f);
        if (t == null) {
            t = drawingTransform;
        } else {
            t.preConcatenate(drawingTransform);
        }

        if ((t.getType() &
                (AffineTransform.TYPE_UNIFORM_SCALE | AffineTransform.TYPE_TRANSLATION)) ==
                t.getType() &&
                ellipse.width == ellipse.height) {

            Point2D.Double start = new Point2D.Double(ellipse.x, ellipse.y);
            Point2D.Double end = new Point2D.Double(ellipse.x + ellipse.width, ellipse.y + ellipse.height);
            t.transform(start, start);
            t.transform(end, end);
            ellipse.x = Math.min(start.x, end.x);
            ellipse.y = Math.min(start.y, end.y);
            ellipse.width = Math.abs(start.x - end.x);
            ellipse.height = Math.abs(start.y - end.y);

            elem.setAttribute("shape", "circle");
            elem.setAttribute("coords",
                    (int) (ellipse.x + ellipse.width / 2d) + "," +
                    (int) (ellipse.y + ellipse.height / 2d) + "," +
                    (int) (ellipse.width / 2d));
            writeHrefAttribute(elem, f);
            return bounds.intersects(ellipse.getBounds());
        } else {
            return writePolyAttributes(elem, f, (Shape) ellipse);
        }
    }

    /**
     * Writes the <code>shape</code>, <code>coords</code>, <code>href</code>,
     * <code>nohref</code> Attribute for the specified figure and rectangle.
     *
     * @return Returns true, if the rect is inside of the image bounds.
     */
    private boolean writeRectAttributes(IXMLElement elem, SVGFigure f, Rectangle2D.Double rect) {
        AffineTransform t = TRANSFORM.getClone(f);
        if (t == null) {
            t = drawingTransform;
        } else {
            t.preConcatenate(drawingTransform);
        }

        if ((t.getType() &
                (AffineTransform.TYPE_UNIFORM_SCALE | AffineTransform.TYPE_TRANSLATION)) ==
                t.getType()) {

            Point2D.Double start = new Point2D.Double(rect.x, rect.y);
            Point2D.Double end = new Point2D.Double(rect.x + rect.width, rect.y + rect.height);
            t.transform(start, start);
            t.transform(end, end);
            Rectangle r = new Rectangle(
                    (int) Math.min(start.x, end.x),
                    (int) Math.min(start.y, end.y),
                    (int) Math.abs(start.x - end.x),
                    (int) Math.abs(start.y - end.y));

            elem.setAttribute("shape", "rect");
            elem.setAttribute("coords",
                    r.x + "," +
                    r.y + "," +
                    (r.x + r.width) + "," +
                    (r.y + r.height));
            writeHrefAttribute(elem, f);
            return bounds.intersects(r);
        } else {
            return writePolyAttributes(elem, f, (Shape) rect);
        }
    }

    private void writeHrefAttribute(IXMLElement elem, SVGFigure f) {
        String link = f.get(LINK);
        if (link != null && link.trim().length() > 0) {
            elem.setAttribute("href", link);
            elem.setAttribute("title", link);
            elem.setAttribute("alt", link);
            String linkTarget = f.get(LINK_TARGET);
            if (linkTarget != null && linkTarget.trim().length() > 0) {
                elem.setAttribute("target", linkTarget);
            }
        } else {
            elem.setAttribute("nohref", "true");
        }
    }

    /**
     * Writes the <code>shape</code>, <code>coords</code>, <code>href</code>,
     * <code>nohref</code> Attribute for the specified figure and shape.
     *
     * @return Returns true, if the polygon is inside of the image bounds.
     */
    private boolean writePolyAttributes(IXMLElement elem, SVGFigure f, Shape shape) {
        AffineTransform t = TRANSFORM.getClone(f);
        if (t == null) {
            t = drawingTransform;
        } else {
            t.preConcatenate(drawingTransform);
        }

        StringBuilder buf = new StringBuilder();
        float[] coords = new float[6];
        Path2D.Double path = new Path2D.Double();
        for (PathIterator i = shape.getPathIterator(t, 1.5f);
                !i.isDone(); i.next()) {
            switch (i.currentSegment(coords)) {
                case PathIterator.SEG_MOVETO:
                    if (buf.length() != 0) {
                        throw new IllegalArgumentException("Illegal shape " + shape);
                    }
                    if (buf.length() != 0) {
                        buf.append(',');
                    }
                    buf.append((int) coords[0]);
                    buf.append(',');
                    buf.append((int) coords[1]);
                    path.moveTo(coords[0], coords[1]);
                    break;
                case PathIterator.SEG_LINETO:
                    if (buf.length() != 0) {
                        buf.append(',');
                    }
                    buf.append((int) coords[0]);
                    buf.append(',');
                    buf.append((int) coords[1]);
                    path.lineTo(coords[0], coords[1]);
                    break;
                case PathIterator.SEG_CLOSE:
                    path.closePath();
                    break;
                default:
                    throw new InternalError("Illegal segment type " + i.currentSegment(coords));
            }
        }
        elem.setAttribute("shape", "poly");
        elem.setAttribute("coords", buf.toString());
        writeHrefAttribute(elem, f);
        return path.intersects(new Rectangle2D.Float(bounds.x, bounds.y, bounds.width, bounds.height));
    }

    private void writePathElement(IXMLElement parent, SVGPathFigure f) throws IOException {
        GrowStroke growStroke = new GrowStroke( (getStrokeTotalWidth(f) / 2d),  getStrokeTotalWidth(f));
        BasicStroke basicStroke = new BasicStroke((float) getStrokeTotalWidth(f));
        for (Figure child : f.getChildren()) {
            SVGBezierFigure bezier = (SVGBezierFigure) child;
            IXMLElement elem = parent.createElement("area");
            if (bezier.isClosed()) {
                writePolyAttributes(elem, f, growStroke.createStrokedShape(bezier.getBezierPath()));
            } else {
                writePolyAttributes(elem, f, basicStroke.createStrokedShape(bezier.getBezierPath()));
            }
            parent.addChild(elem);
        }
    }

    private void writePolygonElement(IXMLElement parent, SVGPathFigure f) throws IOException {
        IXMLElement elem = parent.createElement("area");
        if (writePolyAttributes(elem, f, new GrowStroke( (getStrokeTotalWidth(f) / 2d),  getStrokeTotalWidth(f)).createStrokedShape(f.getChild(0).getBezierPath()))) {
            parent.addChild(elem);
        }
    }

    private void writePolylineElement(IXMLElement parent, SVGPathFigure f) throws IOException {
        IXMLElement elem = parent.createElement("area");

        if (writePolyAttributes(elem, f, new BasicStroke((float) getStrokeTotalWidth(f)).createStrokedShape(f.getChild(0).getBezierPath()))) {
            parent.addChild(elem);
        }
    }

    private void writeLineElement(IXMLElement parent, SVGPathFigure f) throws IOException {
        IXMLElement elem = parent.createElement("area");
        if (writePolyAttributes(elem, f, new GrowStroke( (getStrokeTotalWidth(f) / 2d),  getStrokeTotalWidth(f)).createStrokedShape(new Line2D.Double(
                f.getStartPoint(), f.getEndPoint())))) {
            parent.addChild(elem);
        }
    }

    private void writeRectElement(IXMLElement parent, SVGRectFigure f) throws IOException {
        IXMLElement elem = parent.createElement("AREA");
        boolean isContained;
        if (f.getArcHeight() == 0 && f.getArcWidth() == 0) {
            Rectangle2D.Double rect = f.getBounds();
            double grow = getPerpendicularHitGrowth(f);
            rect.x -= grow;
            rect.y -= grow;
            rect.width += grow;
            rect.height += grow;
            isContained = writeRectAttributes(elem, f, rect);
        } else {
            isContained = writePolyAttributes(elem, f,
                    new GrowStroke( (getStrokeTotalWidth(f) / 2d),  getStrokeTotalWidth(f)).createStrokedShape(new RoundRectangle2D.Double(
                    f.getX(), f.getY(), f.getWidth(), f.getHeight(),
                    f.getArcWidth(), f.getArcHeight())));
        }
        if (isContained) {
            parent.addChild(elem);
        }
    }

    private void writeTextElement(IXMLElement parent, SVGTextFigure f) throws IOException {
        IXMLElement elem = parent.createElement("AREA");
        Rectangle2D.Double rect = f.getBounds();
        double grow = getPerpendicularHitGrowth(f);
        rect.x -= grow;
        rect.y -= grow;
        rect.width += grow;
        rect.height += grow;
        if (writeRectAttributes(elem, f, rect)) {
            parent.addChild(elem);
        }
    }

    private void writeTextAreaElement(IXMLElement parent, SVGTextAreaFigure f) throws IOException {
        IXMLElement elem = parent.createElement("AREA");
        Rectangle2D.Double rect = f.getBounds();
        double grow = getPerpendicularHitGrowth(f);
        rect.x -= grow;
        rect.y -= grow;
        rect.width += grow;
        rect.height += grow;
        if (writeRectAttributes(elem, f, rect)) {
            parent.addChild(elem);
        }
    }

    private void writeEllipseElement(IXMLElement parent, SVGEllipseFigure f) throws IOException {
        IXMLElement elem = parent.createElement("area");
        Rectangle2D.Double r = f.getBounds();
        double grow = getPerpendicularHitGrowth(f);
        Ellipse2D.Double ellipse = new Ellipse2D.Double(r.x - grow, r.y - grow, r.width + grow, r.height + grow);
        if (writeCircleAttributes(elem, f, ellipse)) {
            parent.addChild(elem);
        }
    }

    private void writeGElement(IXMLElement parent, SVGGroupFigure f) throws IOException {
        // Note: Image map elements need to be written from front to back
        for (Figure child : new ReversedList<Figure>(f.getChildren())) {
            writeElement(parent, child);
        }
    }

    private void writeImageElement(IXMLElement parent, SVGImageFigure f) {
        IXMLElement elem = parent.createElement("area");
        Rectangle2D.Double rect = f.getBounds();
        writeRectAttributes(elem, f, rect);
        parent.addChild(elem);
    }
}
