/*
 * @(#)SVGInputFormat.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.svg.io;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.gui.filechooser.ExtensionFileFilter;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import java.text.ParseException;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import javax.swing.text.*;
import net.n3.nanoxml.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.io.InputFormat;
import org.jhotdraw.xml.css.StyleManager;
import org.jhotdraw.geom.*;
import org.jhotdraw.io.*;
import org.jhotdraw.samples.svg.*;
import org.jhotdraw.samples.svg.figures.*;
import org.jhotdraw.text.FontFormatter;
import org.jhotdraw.util.LocaleUtil;
import static org.jhotdraw.samples.svg.SVGConstants.*;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;
import org.jhotdraw.xml.css.CSSParser;

/**
 * SVGInputFormat.
 * This format is aimed to comply to the Scalable Vector Graphics (SVG) Tiny 1.2
 * Specification supporting the <code>SVG-static</code> feature string.
 * <a href="http://www.w3.org/TR/SVGMobile12/">http://www.w3.org/TR/SVGMobile12/</a>
 * <p>
 * Design pattern:<br>
 * Name: Abstract Factory.<br>
 * Role: Client.<br>
 * Partners: {@link SVGFigureFactory} as Abstract Factory.
 *
 *
 * @author Werner Randelshofer
 * @version $Id: SVGInputFormat.java 723 2010-12-28 14:31:24Z rawcoder $
 */
public class SVGInputFormat implements InputFormat {

    /**
     * Set this to true, to getChild debug output on if (DEBUG) System.out.
     */
    private static final boolean DEBUG = false;
    /**
     * The SVGFigure factory is used to create Figure's for the drawing.
     */
    private SVGFigureFactory factory;
    /**
     * URL pointing to the SVG input file. This is used as a base URL for
     * resources that are referenced from the SVG file.
     */
    @Nullable
    private URL url;
    // FIXME - Move these maps to SVGConstants or to SVGAttributeKeys.
    /**
     * Maps to all XML elements that are identified by an xml:id.
     */
    @Nullable
    private HashMap<String, IXMLElement> identifiedElements;
    /**
     * Maps to all drawing objects from the XML elements they were created from.
     */
    @Nullable
    private HashMap<IXMLElement, Object> elementObjects;
    /**
     * Tokenizer for parsing SVG path expressions.
     *
     */
    private StreamPosTokenizer toPathTokenizer;
    /** FontFormatter for parsing font family names. */
    private FontFormatter fontFormatter = new FontFormatter();

    /**
     * Each SVG element establishes a new Viewport.
     */
    private static class Viewport {

        /**
         * The width of the Viewport.
         */
        public double width = 640d;
        /**
         * The height of the Viewport.
         */
        public double height = 480d;
        /**
         * The viewBox specifies the coordinate system within the Viewport.
         */
        public Rectangle2D.Double viewBox = new Rectangle2D.Double(0d, 0d, 640d, 480d);
        /**
         * Factor for percent values relative to Viewport width.
         */
        public double widthPercentFactor = 640d / 100d;
        /**
         * Factor for percent values relative to Viewport height.
         */
        public double heightPercentFactor = 480d / 100d;
        /**
         * Factor for number values in the user coordinate system.
         * This is the smaller value of width / viewBox.width and height / viewBox.height.
         */
        public double numberFactor;
        /**
         * http://www.w3.org/TR/SVGMobile12/coords.html#PreserveAspectRatioAttribute
         * XXX - use a more sophisticated variable here
         */
        public boolean isPreserveAspectRatio = true;
        private HashMap<AttributeKey, Object> attributes = new HashMap<AttributeKey, Object>();

        @Override
        public String toString() {
            return "widthPercentFactor:" + widthPercentFactor + ";"
                    + "heightPercentFactor:" + heightPercentFactor + ";"
                    + "numberFactor:" + numberFactor + ";"
                    + attributes;
        }
    }
    /**
     * Each SVG element creates a new Viewport that we store
     * here.
     */
    @Nullable
    private Stack<Viewport> viewportStack;
    /**
     * Holds the style manager used for applying cascading style sheet CSS rules
     * to the document.
     */
    @Nullable
    private StyleManager styleManager;
    /**
     * Holds the figures that are currently being read.
     */
    private LinkedList<Figure> figures;
    /**
     * Holds the document that is currently being read.
     */
    @Nullable
    private IXMLElement document;

    /** Creates a new instance. */
    public SVGInputFormat() {
        this(new DefaultSVGFigureFactory());
    }

    public SVGInputFormat(SVGFigureFactory factory) {
        this.factory = factory;
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
        this.url = file.toURI().toURL();
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        try {
            read(in, drawing, replace);
        } finally {
            in.close();
        }
        this.url = null;
    }

    public void read(URL url, Drawing drawing, boolean replace) throws IOException {
        this.url = url;
        InputStream in = url.openStream();
        try {
            read(in, drawing, replace);
        } finally {
            in.close();
        }
        this.url = null;
    }

    /**
     * This is the main reading method.
     *
     * @param in The input stream.
     * @param drawing The drawing to which this method adds figures.
     * @param replace Whether attributes on the drawing object
     * should by changed by this method. Set this to false, when reading individual
     * images from the clipboard.
     */
    @Override
    public void read(InputStream in, Drawing drawing, boolean replace) throws IOException {
        long start;
        if (DEBUG) {
            start = System.currentTimeMillis();
        }
        this.figures = new LinkedList<Figure>();
        IXMLParser parser;
        try {
            parser = XMLParserFactory.createDefaultXMLParser();
        } catch (Exception ex) {
            InternalError e = new InternalError("Unable to instantiate NanoXML Parser");
            e.initCause(ex);
            throw e;
        }
        if (DEBUG) {
            System.out.println("SVGInputFormat parser created " + (System.currentTimeMillis() - start));
        }
        IXMLReader reader = new StdXMLReader(in);
        parser.setReader(reader);
        if (DEBUG) {
            System.out.println("SVGInputFormat reader created " + (System.currentTimeMillis() - start));
        }
        try {
            document = (IXMLElement) parser.parse();
        } catch (XMLException ex) {
            IOException e = new IOException(ex.getMessage());
            e.initCause(ex);
            throw e;
        }
        if (DEBUG) {
            System.out.println("SVGInputFormat document created " + (System.currentTimeMillis() - start));
        }

        // Search for the first 'svg' element in the XML document
        // in preorder sequence
        IXMLElement svg = document;
        Stack<Iterator<IXMLElement>> stack = new Stack<Iterator<IXMLElement>>();
        LinkedList<IXMLElement> ll = new LinkedList<IXMLElement>();
        ll.add(document);
        stack.push(ll.iterator());
        while (!stack.empty() && stack.peek().hasNext()) {
            Iterator<IXMLElement> iter = stack.peek();
            IXMLElement node = iter.next();

            Iterator<IXMLElement> children = (node.getChildren() == null) ? null : node.getChildren().iterator();

            if (!iter.hasNext()) {
                stack.pop();
            }
            if (children != null && children.hasNext()) {
                stack.push(children);
            }
            if (node.getName() != null
                    && node.getName().equals("svg")
                    && (node.getNamespace() == null
                    || node.getNamespace().equals(SVG_NAMESPACE))) {
                svg = node;
                break;
            }
        }


        if (svg.getName() == null
                || !svg.getName().equals("svg")
                || (svg.getNamespace() != null
                && !svg.getNamespace().equals(SVG_NAMESPACE))) {
            throw new IOException("'svg' element expected: " + svg.getName());
        }
        //long end1 = System.currentTimeMillis();

        // Flatten CSS Styles
        initStorageContext(document);
        flattenStyles(svg);
        //long end2 = System.currentTimeMillis();

        readElement(svg);

        if (DEBUG) {
            long end = System.currentTimeMillis();
            System.out.println("SVGInputFormat elapsed:" + (end - start));
        }
        /*if (DEBUG) System.out.println("SVGInputFormat read:"+(end1-start));
        if (DEBUG) System.out.println("SVGInputFormat flatten:"+(end2-end1));
        if (DEBUG) System.out.println("SVGInputFormat build:"+(end-end2));
         */
        if (replace) {
            drawing.removeAllChildren();
        }
        drawing.addAll(figures);


        if (replace) {
            Viewport viewport = viewportStack.firstElement();
            drawing.set(VIEWPORT_FILL, VIEWPORT_FILL.get(viewport.attributes));
            drawing.set(VIEWPORT_FILL_OPACITY, VIEWPORT_FILL_OPACITY.get(viewport.attributes));
            drawing.set(VIEWPORT_HEIGHT, VIEWPORT_HEIGHT.get(viewport.attributes));
            drawing.set(VIEWPORT_WIDTH, VIEWPORT_WIDTH.get(viewport.attributes));
        }

        // Get rid of all objects we don't need anymore to help garbage collector.
        document.dispose();
        identifiedElements.clear();
        elementObjects.clear();
        viewportStack.clear();
        styleManager.clear();

        document = null;
        identifiedElements = null;
        elementObjects = null;
        viewportStack = null;
        styleManager = null;

    }

    private void initStorageContext(IXMLElement root) {
        identifiedElements = new HashMap<String, IXMLElement>();
        identifyElements(root);
        elementObjects = new HashMap<IXMLElement, Object>();
        viewportStack = new Stack<Viewport>();
        viewportStack.push(new Viewport());
        styleManager = new StyleManager();
    }

    /**
     * Flattens all CSS styles.
     * Styles defined in a "style" attribute and in CSS rules are converted
     * into attributes with the same name.
     */
    private void flattenStyles(IXMLElement elem)
            throws IOException {
        if (elem.getName() != null && elem.getName().equals("style")
                && readAttribute(elem, "type", "").equals("text/css")
                && elem.getContent() != null) {
            CSSParser cssParser = new CSSParser();
            cssParser.parse(elem.getContent(), styleManager);
        } else {

            if (elem.getNamespace() == null
                    || elem.getNamespace().equals(SVG_NAMESPACE)) {

                String style = readAttribute(elem, "style", null);
                if (style != null) {
                    for (String styleProperty : style.split(";")) {
                        String[] stylePropertyElements = styleProperty.split(":");
                        if (stylePropertyElements.length == 2
                                && !elem.hasAttribute(stylePropertyElements[0].trim(), SVG_NAMESPACE)) {
                            //if (DEBUG) System.out.println("flatten:"+Arrays.toString(stylePropertyElements));
                            elem.setAttribute(stylePropertyElements[0].trim(), SVG_NAMESPACE, stylePropertyElements[1].trim());
                        }
                    }
                }

                styleManager.applyStylesTo(elem);

                for (IXMLElement child : elem.getChildren()) {
                    flattenStyles(child);
                }
            }
        }
    }

    /**
     * Reads an SVG element of any kind.
     * @return Returns the Figure, if the SVG element represents a Figure.
     * Returns null in all other cases.
     */
    @Nullable
    private Figure readElement(IXMLElement elem)
            throws IOException {
        if (DEBUG) {
            System.out.println("SVGInputFormat.readElement " + elem.getName() + " line:" + elem.getLineNr());
        }
        Figure f = null;
        if (elem.getNamespace() == null
                || elem.getNamespace().equals(SVG_NAMESPACE)) {
            String name = elem.getName();
            if (name == null) {
                if (DEBUG) {
                    System.err.println("SVGInputFormat warning: skipping nameless element at line " + elem.getLineNr());
                }
            } else if (name.equals("a")) {
                f = readAElement(elem);
            } else if (name.equals("circle")) {
                f = readCircleElement(elem);
            } else if (name.equals("defs")) {
                readDefsElement(elem);
                f = null;
            } else if (name.equals("ellipse")) {
                f = readEllipseElement(elem);
            } else if (name.equals("g")) {
                f = readGElement(elem);
            } else if (name.equals("image")) {
                f = readImageElement(elem);
            } else if (name.equals("line")) {
                f = readLineElement(elem);
            } else if (name.equals("linearGradient")) {
                readLinearGradientElement(elem);
                f = null;
            } else if (name.equals("path")) {
                f = readPathElement(elem);
            } else if (name.equals("polygon")) {
                f = readPolygonElement(elem);
            } else if (name.equals("polyline")) {
                f = readPolylineElement(elem);
            } else if (name.equals("radialGradient")) {
                readRadialGradientElement(elem);
                f = null;
            } else if (name.equals("rect")) {
                f = readRectElement(elem);
            } else if (name.equals("solidColor")) {
                readSolidColorElement(elem);
                f = null;
            } else if (name.equals("svg")) {
                f = readSVGElement(elem);
                //f = readGElement(elem);
            } else if (name.equals("switch")) {
                f = readSwitchElement(elem);
            } else if (name.equals("text")) {
                f = readTextElement(elem);
            } else if (name.equals("textArea")) {
                f = readTextAreaElement(elem);
            } else if (name.equals("title")) {
                //FIXME - Implement reading of title element
                //f = readTitleElement(elem);
            } else if (name.equals("use")) {
                f = readUseElement(elem);
            } else if (name.equals("style")) {
                // Nothing to do, style elements have been already
                // processed in method flattenStyles
            } else {
                if (DEBUG) {
                    System.out.println("SVGInputFormat not implemented for <" + name + ">");
                }
            }
        }
        if (f instanceof SVGFigure) {
            if (((SVGFigure) f).isEmpty()) {
                // if (DEBUG) System.out.println("Empty figure "+f);
                return null;
            }
        } else if (f != null) {
            if (DEBUG) {
                System.out.println("SVGInputFormat warning: not an SVGFigure " + f);
            }
        }

        return f;
    }

    /**
     * Reads an SVG "defs" element.
     */
    private void readDefsElement(IXMLElement elem)
            throws IOException {
        for (IXMLElement child : elem.getChildren()) {
            Figure childFigure = readElement(child);
        }
    }

    /**
     * Reads an SVG "g" element.
     */
    private Figure readGElement(IXMLElement elem)
            throws IOException {
        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        readCoreAttributes(elem, a);
        readOpacityAttribute(elem, a);
        CompositeFigure g = factory.createG(a);

        for (IXMLElement child : elem.getChildren()) {
            Figure childFigure = readElement(child);
            // skip invisible elements
            if (readAttribute(child, "visibility", "visible").equals("visible")
                    && !readAttribute(child, "display", "inline").equals("none")) {
                if (childFigure != null) {
                    g.basicAdd(childFigure);
                }
            }
        }
        readTransformAttribute(elem, a);
        if (TRANSFORM.get(a) != null) {
            g.transform(TRANSFORM.get(a));
        }
        return g;
    }

    /**
     * Reads an SVG "a" element.
     */
    private Figure readAElement(IXMLElement elem)
            throws IOException {
        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        readCoreAttributes(elem, a);
        CompositeFigure g = factory.createG(a);

        String href = readAttribute(elem, "xlink:href", null);
        if (href == null) {
            href = readAttribute(elem, "href", null);
        }
        String target = readAttribute(elem, "target", null);
        if (DEBUG) {
            System.out.println("SVGInputFormat.readAElement href=" + href);
        }

        for (IXMLElement child : elem.getChildren()) {
            Figure childFigure = readElement(child);
            // skip invisible elements
            if (readAttribute(child, "visibility", "visible").equals("visible")
                    && !readAttribute(child, "display", "inline").equals("none")) {
                if (childFigure != null) {
                    g.basicAdd(childFigure);
                }
            }
            if (childFigure != null) {
                childFigure.set(LINK, href);
                childFigure.set(LINK_TARGET, target);
            } else {
                if (DEBUG) {
                    System.out.println("SVGInputFormat <a> has no child figure");
                }
            }
        }

        return (g.getChildCount() == 1) ? g.getChild(0) : g;
    }

    /**
     * Reads an SVG "svg" element.
     */
    @Nullable
    private Figure readSVGElement(IXMLElement elem)
            throws IOException {
        // Establish a new viewport
        Viewport viewport = new Viewport();

        String widthValue = readAttribute(elem, "width", "100%");
        String heightValue = readAttribute(elem, "height", "100%");

        viewport.width = toWidth(elem, widthValue);
        viewport.height = toHeight(elem, heightValue);

        if (readAttribute(elem, "viewBox", "none").equals("none")) {
            viewport.viewBox.width = viewport.width;
            viewport.viewBox.height = viewport.height;
        } else {
            String[] viewBoxValues = toWSOrCommaSeparatedArray(readAttribute(elem, "viewBox", "none"));
            viewport.viewBox.x = toNumber(elem, viewBoxValues[0]);
            viewport.viewBox.y = toNumber(elem, viewBoxValues[1]);
            viewport.viewBox.width = toNumber(elem, viewBoxValues[2]);
            viewport.viewBox.height = toNumber(elem, viewBoxValues[3]);

            // FIXME - Calculate percentages
            if (widthValue.indexOf('%') > 0) {
                viewport.width = viewport.viewBox.width;
            }
            if (heightValue.indexOf('%') > 0) {
                viewport.height = viewport.viewBox.height;
            }
        }
        if (viewportStack.size() == 1) {
            // We always preserve the aspect ratio for to the topmost SVG element.
            // This is not compliant, but looks much better.
            viewport.isPreserveAspectRatio = true;
        } else {
            viewport.isPreserveAspectRatio = !readAttribute(elem, "preserveAspectRatio", "none").equals("none");
        }

        viewport.widthPercentFactor = viewport.viewBox.width / 100d;
        viewport.heightPercentFactor = viewport.viewBox.height / 100d;
        viewport.numberFactor = Math.min(
                viewport.width / viewport.viewBox.width,
                viewport.height / viewport.viewBox.height);

        AffineTransform viewBoxTransform = new AffineTransform();

        viewBoxTransform.translate(
                -viewport.viewBox.x * viewport.width / viewport.viewBox.width,
                -viewport.viewBox.y * viewport.height / viewport.viewBox.height);
        if (viewport.isPreserveAspectRatio) {
            double factor = Math.min(
                    viewport.width / viewport.viewBox.width,
                    viewport.height / viewport.viewBox.height);
            viewBoxTransform.scale(factor, factor);
        } else {
            viewBoxTransform.scale(
                    viewport.width / viewport.viewBox.width,
                    viewport.height / viewport.viewBox.height);
        }

        viewportStack.push(viewport);
        readViewportAttributes(elem, viewportStack.firstElement().attributes);


        // Read the figures
        for (IXMLElement child : elem.getChildren()) {
            Figure childFigure = readElement(child);
            // skip invisible elements
            if (readAttribute(child, "visibility", "visible").equals("visible")
                    && !readAttribute(child, "display", "inline").equals("none")) {

                if (childFigure != null) {
                    childFigure.transform(viewBoxTransform);
                    figures.add(childFigure);
                }
            }
        }

        viewportStack.pop();
        return null;
    }

    /**
     * Reads an SVG "rect" element.
     */
    private Figure readRectElement(IXMLElement elem)
            throws IOException {
        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        readCoreAttributes(elem, a);
        readTransformAttribute(elem, a);
        readOpacityAttribute(elem, a);
        readShapeAttributes(elem, a);

        double x = toNumber(elem, readAttribute(elem, "x", "0"));
        double y = toNumber(elem, readAttribute(elem, "y", "0"));
        double w = toWidth(elem, readAttribute(elem, "width", "0"));
        double h = toHeight(elem, readAttribute(elem, "height", "0"));

        String rxValue = readAttribute(elem, "rx", "none");
        String ryValue = readAttribute(elem, "ry", "none");
        if (rxValue.equals("none")) {
            rxValue = ryValue;
        }
        if (ryValue.equals("none")) {
            ryValue = rxValue;
        }
        double rx = toNumber(elem, rxValue.equals("none") ? "0" : rxValue);
        double ry = toNumber(elem, ryValue.equals("none") ? "0" : ryValue);

        Figure figure = factory.createRect(x, y, w, h, rx, ry, a);
        elementObjects.put(elem, figure);
        return figure;
    }

    /**
     * Reads an SVG "circle" element.
     */
    private Figure readCircleElement(IXMLElement elem)
            throws IOException {
        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        readCoreAttributes(elem, a);
        readTransformAttribute(elem, a);
        readOpacityAttribute(elem, a);
        readShapeAttributes(elem, a);

        double cx = toWidth(elem, readAttribute(elem, "cx", "0"));
        double cy = toHeight(elem, readAttribute(elem, "cy", "0"));
        double r = toWidth(elem, readAttribute(elem, "r", "0"));

        Figure figure = factory.createCircle(cx, cy, r, a);
        elementObjects.put(elem, figure);
        return figure;
    }

    /**
     * Reads an SVG "ellipse" element.
     */
    private Figure readEllipseElement(IXMLElement elem)
            throws IOException {
        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        readCoreAttributes(elem, a);
        readTransformAttribute(elem, a);
        readOpacityAttribute(elem, a);
        readShapeAttributes(elem, a);

        double cx = toWidth(elem, readAttribute(elem, "cx", "0"));
        double cy = toHeight(elem, readAttribute(elem, "cy", "0"));
        double rx = toWidth(elem, readAttribute(elem, "rx", "0"));
        double ry = toHeight(elem, readAttribute(elem, "ry", "0"));

        Figure figure = factory.createEllipse(cx, cy, rx, ry, a);
        elementObjects.put(elem, figure);
        return figure;
    }

    /**
     * Reads an SVG "image" element.
     */
    private Figure readImageElement(IXMLElement elem)
            throws IOException {
        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        readCoreAttributes(elem, a);
        readTransformAttribute(elem, a);
        readOpacityAttribute(elem, a);

        double x = toNumber(elem, readAttribute(elem, "x", "0"));
        double y = toNumber(elem, readAttribute(elem, "y", "0"));
        double w = toWidth(elem, readAttribute(elem, "width", "0"));
        double h = toHeight(elem, readAttribute(elem, "height", "0"));

        String href = readAttribute(elem, "xlink:href", null);
        if (href == null) {
            href = readAttribute(elem, "href", null);
        }
        byte[] imageData = null;
        if (href != null) {
            if (href.startsWith("data:")) {
                int semicolonPos = href.indexOf(';');
                if (semicolonPos != -1) {
                    if (href.indexOf(";base64,") == semicolonPos) {
                        imageData = Base64.decode(href.substring(semicolonPos + 8));
                    } else {
                        throw new IOException("Unsupported encoding in data href in image element:" + href);
                    }
                } else {
                    throw new IOException("Unsupported data href in image element:" + href);
                }
            } else {
                URL imageUrl = new URL(url, href);

                // Check whether the imageURL is an SVG image.
                // Load it as a group.
                if (imageUrl.getFile().endsWith("svg")) {
                    SVGInputFormat svgImage = new SVGInputFormat(factory);
                    Drawing svgDrawing = new DefaultDrawing();
                    svgImage.read(imageUrl, svgDrawing, true);
                    CompositeFigure svgImageGroup = factory.createG(a);
                    for (Figure f : svgDrawing.getChildren()) {
                        svgImageGroup.add(f);
                    }
                    svgImageGroup.setBounds(new Point2D.Double(x, y), new Point2D.Double(x + w, y + h));
                    return svgImageGroup;
                }

                // Read the image data from the URL into a byte array
                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                byte[] buf = new byte[512];
                int len = 0;
                try {
                    InputStream in = imageUrl.openStream();
                    try {
                        while ((len = in.read(buf)) > 0) {
                            bout.write(buf, 0, len);
                        }
                        imageData = bout.toByteArray();
                    } finally {
                        in.close();
                    }
                } catch (FileNotFoundException e) {
                    // Use empty image
                }
            }
        }
        // Create a buffered image from the image data
        BufferedImage bufferedImage = null;
        if (imageData != null) {
            try {
                bufferedImage = ImageIO.read(new ByteArrayInputStream(imageData));
            } catch (IIOException e) {
                System.err.println("SVGInputFormat warning: skipped unsupported image format.");
                e.printStackTrace();
            }
        }
        // Delete the image data in case of failure
        if (bufferedImage == null) {
            imageData = null;
            //if (DEBUG) System.out.println("FAILED:"+imageUrl);
        }

        // Create a figure from the image data and the buffered image.
        Figure figure = factory.createImage(x, y, w, h, imageData, bufferedImage, a);
        elementObjects.put(elem, figure);
        return figure;
    }

    /**
     * Reads an SVG "line" element.
     */
    private Figure readLineElement(IXMLElement elem)
            throws IOException {
        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        readCoreAttributes(elem, a);
        readTransformAttribute(elem, a);
        readOpacityAttribute(elem, a);
        readLineAttributes(elem, a);

        // Because 'line' elements are single lines and thus are geometrically
        // one-dimensional, they have no interior; thus, 'line' elements are
        // never filled (see the 'fill' property).
        if (FILL_COLOR.get(a) != null && STROKE_COLOR.get(a) == null) {
            STROKE_COLOR.put(a, FILL_COLOR.get(a));
        }
        if (FILL_GRADIENT.get(a) != null && STROKE_GRADIENT.get(a) == null) {
            STROKE_GRADIENT.put(a, FILL_GRADIENT.get(a));
        }
        FILL_COLOR.put(a, null);
        FILL_GRADIENT.put(a, null);

        double x1 = toNumber(elem, readAttribute(elem, "x1", "0"));
        double y1 = toNumber(elem, readAttribute(elem, "y1", "0"));
        double x2 = toNumber(elem, readAttribute(elem, "x2", "0"));
        double y2 = toNumber(elem, readAttribute(elem, "y2", "0"));

        Figure figure = factory.createLine(x1, y1, x2, y2, a);
        elementObjects.put(elem, figure);
        return figure;
    }

    /**
     * Reads an SVG "polyline" element.
     */
    private Figure readPolylineElement(IXMLElement elem)
            throws IOException {
        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        readCoreAttributes(elem, a);
        readTransformAttribute(elem, a);
        readOpacityAttribute(elem, a);
        readLineAttributes(elem, a);

        Point2D.Double[] points = toPoints(elem, readAttribute(elem, "points", ""));

        Figure figure = factory.createPolyline(points, a);
        elementObjects.put(elem, figure);
        return figure;
    }

    /**
     * Reads an SVG "polygon" element.
     */
    private Figure readPolygonElement(IXMLElement elem)
            throws IOException {
        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        readCoreAttributes(elem, a);
        readTransformAttribute(elem, a);
        readOpacityAttribute(elem, a);
        readShapeAttributes(elem, a);

        Point2D.Double[] points = toPoints(elem, readAttribute(elem, "points", ""));

        Figure figure = factory.createPolygon(points, a);
        elementObjects.put(elem, figure);
        return figure;
    }

    /**
     * Reads an SVG "path" element.
     */
    private Figure readPathElement(IXMLElement elem)
            throws IOException {
        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        readCoreAttributes(elem, a);
        readTransformAttribute(elem, a);
        readOpacityAttribute(elem, a);
        readShapeAttributes(elem, a);

        BezierPath[] beziers = toPath(elem, readAttribute(elem, "d", ""));

        Figure figure = factory.createPath(beziers, a);
        elementObjects.put(elem, figure);
        return figure;
    }

    /**
     * Reads an SVG "text" element.
     */
    private Figure readTextElement(IXMLElement elem)
            throws IOException {
        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        readCoreAttributes(elem, a);
        readTransformAttribute(elem, a);
        readOpacityAttribute(elem, a);
        readShapeAttributes(elem, a);
        readFontAttributes(elem, a);
        readTextAttributes(elem, a);

        String[] xStr = toCommaSeparatedArray(readAttribute(elem, "x", "0"));
        String[] yStr = toCommaSeparatedArray(readAttribute(elem, "y", "0"));

        Point2D.Double[] coordinates = new Point2D.Double[Math.max(xStr.length, yStr.length)];
        double lastX = 0;
        double lastY = 0;
        for (int i = 0; i < coordinates.length; i++) {
            if (xStr.length > i) {
                try {
                    lastX = toNumber(elem, xStr[i]);
                } catch (NumberFormatException ex) {
                }
            }
            if (yStr.length > i) {
                try {
                    lastY = toNumber(elem, yStr[i]);
                } catch (NumberFormatException ex) {
                }
            }
            coordinates[i] = new Point2D.Double(lastX, lastY);
        }


        String[] rotateStr = toCommaSeparatedArray(readAttribute(elem, "rotate", ""));
        double[] rotate = new double[rotateStr.length];
        for (int i = 0; i < rotateStr.length; i++) {
            try {
                rotate[i] = toDouble(elem, rotateStr[i]);
            } catch (NumberFormatException ex) {
                rotate[i] = 0;
            }
        }

        DefaultStyledDocument doc = new DefaultStyledDocument();

        try {
            if (elem.getContent() != null) {
                doc.insertString(0, toText(elem, elem.getContent()), null);
            } else {
                for (IXMLElement node : elem.getChildren()) {
                    if (node.getName() == null) {
                        doc.insertString(0, toText(elem, node.getContent()), null);
                    } else if (node.getName().equals("tspan")) {
                        readTSpanElement((IXMLElement) node, doc);
                    } else {
                        if (DEBUG) {
                            System.out.println("SVGInputFormat unsupported text node <" + node.getName() + ">");
                        }
                    }
                }
            }
        } catch (BadLocationException e) {
            InternalError ex = new InternalError(e.getMessage());
            ex.initCause(e);
            throw ex;
        }
        Figure figure = factory.createText(coordinates, rotate, doc, a);
        elementObjects.put(elem, figure);
        return figure;
    }

    /**
     * Reads an SVG "textArea" element.
     */
    private Figure readTextAreaElement(IXMLElement elem)
            throws IOException {
        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        readCoreAttributes(elem, a);
        readTransformAttribute(elem, a);
        readOpacityAttribute(elem, a);
        readShapeAttributes(elem, a);
        readFontAttributes(elem, a);
        readTextAttributes(elem, a);
        readTextFlowAttributes(elem, a);

        double x = toNumber(elem, readAttribute(elem, "x", "0"));
        double y = toNumber(elem, readAttribute(elem, "y", "0"));
// XXX - Handle "auto" width and height
        double w = toWidth(elem, readAttribute(elem, "width", "0"));
        double h = toHeight(elem, readAttribute(elem, "height", "0"));

        DefaultStyledDocument doc = new DefaultStyledDocument();

        try {
            if (elem.getContent() != null) {
                doc.insertString(0, toText(elem, elem.getContent()), null);
            } else {
                for (IXMLElement node : elem.getChildren()) {
                    if (node.getName() == null) {
                        doc.insertString(doc.getLength(), toText(elem, node.getContent()), null);
                    } else if (node.getName().equals("tbreak")) {
                        doc.insertString(doc.getLength(), "\n", null);
                    } else if (node.getName().equals("tspan")) {
                        readTSpanElement((IXMLElement) node, doc);
                    } else {
                        if (DEBUG) {
                            System.out.println("SVGInputFormat unknown  text node " + node.getName());
                        }
                    }
                }
            }
        } catch (BadLocationException e) {
            InternalError ex = new InternalError(e.getMessage());
            ex.initCause(e);
            throw ex;
        }

        Figure figure = factory.createTextArea(x, y, w, h, doc, a);
        elementObjects.put(elem, figure);
        return figure;
    }

    /**
     * Reads an SVG "tspan" element.
     */
    private void readTSpanElement(IXMLElement elem, DefaultStyledDocument doc)
            throws IOException {
        try {
            if (elem.getContent() != null) {
                doc.insertString(doc.getLength(), toText(elem, elem.getContent()), null);
            } else {
                for (IXMLElement node : elem.getChildren()) {
                    if (node.getName() != null && node.getName().equals("tspan")) {
                        readTSpanElement((IXMLElement) node, doc);
                    } else {
                        if (DEBUG) {
                            System.out.println("SVGInputFormat unknown text node " + node.getName());
                        }
                    }
                }
            }
        } catch (BadLocationException e) {
            InternalError ex = new InternalError(e.getMessage());
            ex.initCause(e);
            throw ex;
        }
    }
    private final static HashSet<String> supportedFeatures = new HashSet<String>(
            Arrays.asList(new String[]{
                "http://www.w3.org/Graphics/SVG/feature/1.2/#SVG-static",
                //"http://www.w3.org/Graphics/SVG/feature/1.2/#SVG-static-DOM",
                //"http://www.w3.org/Graphics/SVG/feature/1.2/#SVG-animated",
                //"http://www.w3.org/Graphics/SVG/feature/1.2/#SVG-all",
                "http://www.w3.org/Graphics/SVG/feature/1.2/#CoreAttribute",
                //"http://www.w3.org/Graphics/SVG/feature/1.2/#NavigationAttribute",
                "http://www.w3.org/Graphics/SVG/feature/1.2/#Structure",
                "http://www.w3.org/Graphics/SVG/feature/1.2/#ConditionalProcessing",
                "http://www.w3.org/Graphics/SVG/feature/1.2/#ConditionalProcessingAttribute",
                "http://www.w3.org/Graphics/SVG/feature/1.2/#Image",
                //"http://www.w3.org/Graphics/SVG/feature/1.2/#Prefetch",
                //"http://www.w3.org/Graphics/SVG/feature/1.2/#Discard",
                "http://www.w3.org/Graphics/SVG/feature/1.2/#Shape",
                "http://www.w3.org/Graphics/SVG/feature/1.2/#Text",
                "http://www.w3.org/Graphics/SVG/feature/1.2/#PaintAttribute",
                "http://www.w3.org/Graphics/SVG/feature/1.2/#OpacityAttribute",
                "http://www.w3.org/Graphics/SVG/feature/1.2/#GraphicsAttribute",
                "http://www.w3.org/Graphics/SVG/feature/1.2/#Gradient",
                "http://www.w3.org/Graphics/SVG/feature/1.2/#SolidColor",//
                "http://www.w3.org/Graphics/SVG/feature/1.2/#Hyperlinking",//
            //"http://www.w3.org/Graphics/SVG/feature/1.2/#XlinkAttribute",
            //"http://www.w3.org/Graphics/SVG/feature/1.2/#ExternalResourcesRequired",
            //"http://www.w3.org/Graphics/SVG/feature/1.2/#Scripting",
            //"http://www.w3.org/Graphics/SVG/feature/1.2/#Handler",
            //"http://www.w3.org/Graphics/SVG/feature/1.2/#Listener",
            //"http://www.w3.org/Graphics/SVG/feature/1.2/#TimedAnimation",
            //"http://www.w3.org/Graphics/SVG/feature/1.2/#Animation",
            //"http://www.w3.org/Graphics/SVG/feature/1.2/#Audio",
            //"http://www.w3.org/Graphics/SVG/feature/1.2/#Video",
            //"http://www.w3.org/Graphics/SVG/feature/1.2/#Font",
            //"http://www.w3.org/Graphics/SVG/feature/1.2/#Extensibility",
            //"http://www.w3.org/Graphics/SVG/feature/1.2/#MediaAttribute",
            //"http://www.w3.org/Graphics/SVG/feature/1.2/#TextFlow",
            //"http://www.w3.org/Graphics/SVG/feature/1.2/#TransformedVideo",
            //"http://www.w3.org/Graphics/SVG/feature/1.2/#ComposedVideo",
            }));

    /**
     * Evaluates an SVG "switch" element.
     *
     */
    @Nullable
    private Figure readSwitchElement(IXMLElement elem)
            throws IOException {
        for (IXMLElement child : elem.getChildren()) {
            String[] requiredFeatures = toWSOrCommaSeparatedArray(readAttribute(child, "requiredFeatures", ""));
            String[] requiredExtensions = toWSOrCommaSeparatedArray(readAttribute(child, "requiredExtensions", ""));
            String[] systemLanguage = toWSOrCommaSeparatedArray(readAttribute(child, "systemLanguage", ""));
            String[] requiredFormats = toWSOrCommaSeparatedArray(readAttribute(child, "requiredFormats", ""));
            String[] requiredFonts = toWSOrCommaSeparatedArray(readAttribute(child, "requiredFonts", ""));

            boolean isMatch;

            isMatch = supportedFeatures.containsAll(Arrays.asList(requiredFeatures))
                    && requiredExtensions.length == 0
                    && requiredFormats.length == 0
                    && requiredFonts.length == 0;

            if (isMatch && systemLanguage.length > 0) {
                isMatch = false;
                Locale locale = LocaleUtil.getDefault();
                for (String lng : systemLanguage) {
                    int p = lng.indexOf('-');
                    if (p == -1) {
                        if (locale.getLanguage().equals(lng)) {
                            isMatch = true;
                            break;
                        }
                    } else {
                        if (locale.getLanguage().equals(lng.substring(0, p))
                                && locale.getCountry().toLowerCase().equals(lng.substring(p + 1))) {
                            isMatch = true;
                            break;
                        }
                    }
                }
            }
            if (isMatch) {
                Figure figure = readElement(child);
                if (readAttribute(child, "visibility", "visible").equals("visible")
                        && !readAttribute(child, "display", "inline").equals("none")) {
                    return figure;
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    /**
     * Reads an SVG "use" element.
     */
    @Nullable
    @SuppressWarnings("unchecked")
    private Figure readUseElement(IXMLElement elem)
            throws IOException {
        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        readCoreAttributes(elem, a);
        HashMap<AttributeKey, Object> a2 = new HashMap<AttributeKey, Object>();
        readTransformAttribute(elem, a);
        readOpacityAttribute(elem, a2);
        readUseShapeAttributes(elem, a2);
        readFontAttributes(elem, a2);

        String href = readAttribute(elem, "xlink:href", null);
        if (href != null && href.startsWith("#")) {
            IXMLElement refElem = identifiedElements.get(href.substring(1));
            if (refElem == null) {
                if (DEBUG) {
                    System.out.println("SVGInputFormat couldn't find href for <use> element:" + href);
                }
            } else {
                Figure obj = readElement(refElem);
                if (obj != null) {
                    Figure figure = (Figure) obj.clone();
                    for (Map.Entry<AttributeKey, Object> entry : a2.entrySet()) {
                        figure.set(entry.getKey(), entry.getValue());
                    }

                    AffineTransform tx =
                            (TRANSFORM.get(a) == null) ? new AffineTransform() : TRANSFORM.get(a);
                    double x = toNumber(elem, readAttribute(elem, "x", "0"));
                    double y = toNumber(elem, readAttribute(elem, "y", "0"));
                    tx.translate(x, y);
                    figure.transform(tx);

                    return figure;
                }
            }
        }
        return null;
    }

    /**
     * Reads an attribute that is inherited.
     */
    @Nullable
    private String readInheritAttribute(IXMLElement elem, String attributeName, @Nullable String defaultValue) {
        if (elem.hasAttribute(attributeName, SVG_NAMESPACE)) {
            String value = elem.getAttribute(attributeName, SVG_NAMESPACE, null);
            if (value.equals("inherit")) {
                return readInheritAttribute(elem.getParent(), attributeName, defaultValue);
            } else {
                return value;
            }
        } else if (elem.hasAttribute(attributeName)) {
            String value = elem.getAttribute(attributeName, "");
            if (value.equals("inherit")) {
                return readInheritAttribute(elem.getParent(), attributeName, defaultValue);
            } else {
                return value;
            }
        } else if (elem.getParent() != null
                && (elem.getParent().getNamespace() == null
                || elem.getParent().getNamespace().equals(SVG_NAMESPACE))) {
            return readInheritAttribute(elem.getParent(), attributeName, defaultValue);
        } else {
            return defaultValue;
        }
    }

    /**
     * Reads a color attribute that is inherited.
     * This is similar to {@code readInheritAttribute}, but takes care of the
     * "currentColor" magic attribute value.
     */
    @Nullable
    private String readInheritColorAttribute(IXMLElement elem, String attributeName, @Nullable String defaultValue) {
        String value = null;
        if (elem.hasAttribute(attributeName, SVG_NAMESPACE)) {
            value = elem.getAttribute(attributeName, SVG_NAMESPACE, null);
            if (value.equals("inherit")) {
                return readInheritColorAttribute(elem.getParent(), attributeName, defaultValue);
            }
        } else if (elem.hasAttribute(attributeName)) {
            value = elem.getAttribute(attributeName, "");
            if (value.equals("inherit")) {
                return readInheritColorAttribute(elem.getParent(), attributeName, defaultValue);
            }
        } else if (elem.getParent() != null
                && (elem.getParent().getNamespace() == null
                || elem.getParent().getNamespace().equals(SVG_NAMESPACE))) {
            value = readInheritColorAttribute(elem.getParent(), attributeName, defaultValue);
        } else {
            value = defaultValue;
        }
        if (value != null && value.toLowerCase().equals("currentcolor") && !attributeName.equals("color")) {
            // Lets do some magic stuff for "currentColor" attribute value
            value = readInheritColorAttribute(elem, "color", "defaultValue");
        }
        return value;
    }

    /**
     * Reads a font size attribute that is inherited.
     * As specified by
     * http://www.w3.org/TR/SVGMobile12/text.html#FontPropertiesUsedBySVG
     * http://www.w3.org/TR/2006/CR-xsl11-20060220/#font-getChildCount
     */
    private double readInheritFontSizeAttribute(IXMLElement elem, String attributeName, String defaultValue)
            throws IOException {
        String value = null;
        if (elem.hasAttribute(attributeName, SVG_NAMESPACE)) {
            value = elem.getAttribute(attributeName, SVG_NAMESPACE, null);
        } else if (elem.hasAttribute(attributeName)) {
            value = elem.getAttribute(attributeName, null);
        } else if (elem.getParent() != null
                && (elem.getParent().getNamespace() == null
                || elem.getParent().getNamespace().equals(SVG_NAMESPACE))) {
            return readInheritFontSizeAttribute(elem.getParent(), attributeName, defaultValue);
        } else {
            value = defaultValue;
        }

        if (value.equals("inherit")) {
            return readInheritFontSizeAttribute(elem.getParent(), attributeName, defaultValue);
        } else if (SVG_ABSOLUTE_FONT_SIZES.containsKey(value)) {
            return SVG_ABSOLUTE_FONT_SIZES.get(value);
        } else if (SVG_RELATIVE_FONT_SIZES.containsKey(value)) {
            return SVG_RELATIVE_FONT_SIZES.get(value) * readInheritFontSizeAttribute(elem.getParent(), attributeName, defaultValue);
        } else if (value.endsWith("%")) {
            double factor = Double.valueOf(value.substring(0, value.length() - 1));
            return factor * readInheritFontSizeAttribute(elem.getParent(), attributeName, defaultValue);
        } else {
            //return toScaledNumber(elem, value);
            return toNumber(elem, value);
        }

    }

    /**
     * Reads an attribute that is not inherited, unless its value is "inherit".
     */
    @Nullable
    private String readAttribute(IXMLElement elem, String attributeName, @Nullable String defaultValue) {
        if (elem.hasAttribute(attributeName, SVG_NAMESPACE)) {
            String value = elem.getAttribute(attributeName, SVG_NAMESPACE, null);
            if (value.equals("inherit")) {
                return readAttribute(elem.getParent(), attributeName, defaultValue);
            } else {
                return value;
            }
        } else if (elem.hasAttribute(attributeName)) {
            String value = elem.getAttribute(attributeName, null);
            if (value.equals("inherit")) {
                return readAttribute(elem.getParent(), attributeName, defaultValue);
            } else {
                return value;
            }
        } else {
            return defaultValue;
        }
    }

    /**
     * Returns a value as a width.
     * http://www.w3.org/TR/SVGMobile12/types.html#DataTypeLength
     */
    private double toWidth(IXMLElement elem, String str) throws IOException {
        // XXX - Compute xPercentFactor from viewport
        return toLength(elem, str,
                viewportStack.peek().widthPercentFactor);
    }

    /**
     * Returns a value as a height.
     * http://www.w3.org/TR/SVGMobile12/types.html#DataTypeLength
     */
    private double toHeight(IXMLElement elem, String str) throws IOException {
        // XXX - Compute yPercentFactor from viewport
        return toLength(elem, str,
                viewportStack.peek().heightPercentFactor);
    }

    /**
     * Returns a value as a number.
     * http://www.w3.org/TR/SVGMobile12/types.html#DataTypeNumber
     */
    private double toNumber(IXMLElement elem, String str) throws IOException {
        return toLength(elem, str, viewportStack.peek().numberFactor);
    }

    /**
     * Returns a value as a length.
     * http://www.w3.org/TR/SVGMobile12/types.html#DataTypeLength
     */
    private double toLength(IXMLElement elem, String str, double percentFactor) throws IOException {
        double scaleFactor = 1d;
        if (str == null || str.length() == 0 || str.equals("none")) {
            return 0d;
        }

        if (str.endsWith("%")) {
            str = str.substring(0, str.length() - 1);
            scaleFactor = percentFactor;
        } else if (str.endsWith("px")) {
            str = str.substring(0, str.length() - 2);
        } else if (str.endsWith("pt")) {
            str = str.substring(0, str.length() - 2);
            scaleFactor = 1.25;
        } else if (str.endsWith("pc")) {
            str = str.substring(0, str.length() - 2);
            scaleFactor = 15;
        } else if (str.endsWith("mm")) {
            str = str.substring(0, str.length() - 2);
            scaleFactor = 3.543307;
        } else if (str.endsWith("cm")) {
            str = str.substring(0, str.length() - 2);
            scaleFactor = 35.43307;
        } else if (str.endsWith("in")) {
            str = str.substring(0, str.length() - 2);
            scaleFactor = 90;
        } else if (str.endsWith("em")) {
            str = str.substring(0, str.length() - 2);
            // XXX - This doesn't work
            scaleFactor = toLength(elem, readAttribute(elem, "font-size", "0"), percentFactor);
        } else {
            scaleFactor = 1d;
        }

        return Double.parseDouble(str) * scaleFactor;
    }

    /**
     * Returns a value as a String array.
     * The values are separated by commas with optional white space.
     */
    public static String[] toCommaSeparatedArray(String str) throws IOException {
        return str.split("\\s*,\\s*");
    }

    /**
     * Returns a value as a String array.
     * The values are separated by whitespace or by commas with optional white
     * space.
     */
    public static String[] toWSOrCommaSeparatedArray(String str) throws IOException {
        String[] result = str.split("(\\s*,\\s*|\\s+)");
        if (result.length == 1 && result[0].equals("")) {
            return new String[0];
        } else {
            return result;
        }
    }

    /**
     * Returns a value as a String array.
     * The values are separated by commas with optional quotes and white space.
     */
    public static String[] toQuotedAndCommaSeparatedArray(String str) throws IOException {
        LinkedList<String> values = new LinkedList<String>();
        StreamTokenizer tt = new StreamTokenizer(new StringReader(str));
        tt.wordChars('a', 'z');
        tt.wordChars('A', 'Z');
        tt.wordChars(128 + 32, 255);
        tt.whitespaceChars(0, ' ');
        tt.quoteChar('"');
        tt.quoteChar('\'');

        while (tt.nextToken() != StreamTokenizer.TT_EOF) {
            switch (tt.ttype) {
                case StreamTokenizer.TT_WORD:
                case '"':
                case '\'':
                    values.add(tt.sval);
                    break;
            }
        }
        return values.toArray(new String[values.size()]);
    }

    /**
     * Returns a value as a Point2D.Double array.
     * as specified in http://www.w3.org/TR/SVGMobile12/shapes.html#PointsBNF
     */
    private Point2D.Double[] toPoints(IXMLElement elem, String str) throws IOException {

        StringTokenizer tt = new StringTokenizer(str, " ,");
        Point2D.Double[] points = new Point2D.Double[tt.countTokens() / 2];
        for (int i = 0; i < points.length; i++) {

            points[i] = new Point2D.Double(
                    toNumber(elem, tt.nextToken()),
                    toNumber(elem, tt.nextToken()));
        }
        return points;
    }

    /**
     * Returns a value as a BezierPath array.
     * as specified in http://www.w3.org/TR/SVGMobile12/paths.html#PathDataBNF
     *
     * Also supports elliptical arc commands 'a' and 'A' as specified in
     * http://www.w3.org/TR/SVG/paths.html#PathDataEllipticalArcCommands
     */
    private BezierPath[] toPath(IXMLElement elem, String str) throws IOException {
        LinkedList<BezierPath> paths = new LinkedList<BezierPath>();

        BezierPath path = null;
        Point2D.Double p = new Point2D.Double();
        Point2D.Double c1 = new Point2D.Double();
        Point2D.Double c2 = new Point2D.Double();

        StreamPosTokenizer tt;
        if (toPathTokenizer == null) {
            tt = new StreamPosTokenizer(new StringReader(str));
            tt.resetSyntax();
            tt.parseNumbers();
            tt.parseExponents();
            tt.parsePlusAsNumber();
            tt.whitespaceChars(0, ' ');
            tt.whitespaceChars(',', ',');
            toPathTokenizer = tt;
        } else {
            tt = toPathTokenizer;
            tt.setReader(new StringReader(str));
        }


        char nextCommand = 'M';
        char command = 'M';
        Commands:
        while (tt.nextToken() != StreamPosTokenizer.TT_EOF) {
            if (tt.ttype > 0) {
                command = (char) tt.ttype;
            } else {
                command = nextCommand;
                tt.pushBack();
            }

            BezierPath.Node node;

            switch (command) {
                case 'M':
                    // absolute-moveto x y
                    if (path != null) {
                        paths.add(path);
                    }
                    path = new BezierPath();

                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("x coordinate missing for 'M' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.x = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("y coordinate missing for 'M' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.y = tt.nval;
                    path.moveTo(p.x, p.y);
                    nextCommand = 'L';
                    break;
                case 'm':
                    // relative-moveto dx dy
                    if (path != null) {
                        paths.add(path);
                    }
                    path = new BezierPath();

                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dx coordinate missing for 'm' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.x += tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dy coordinate missing for 'm' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.y += tt.nval;
                    path.moveTo(p.x, p.y);
                    nextCommand = 'l';

                    break;
                case 'Z':
                case 'z':
                    // close path
                    p.x = path.get(0).x[0];
                    p.y = path.get(0).y[0];

                    // If the last point and the first point are the same, we
                    // can merge them
                    if (path.size() > 1) {
                        BezierPath.Node first = path.get(0);
                        BezierPath.Node last = path.get(path.size() - 1);
                        if (first.x[0] == last.x[0]
                                && first.y[0] == last.y[0]) {
                            if ((last.mask & BezierPath.C1_MASK) != 0) {
                                first.mask |= BezierPath.C1_MASK;
                                first.x[1] = last.x[1];
                                first.y[1] = last.y[1];
                            }
                            path.remove(path.size() - 1);
                        }
                    }
                    path.setClosed(true);

                    break;
                case 'L':
                    // absolute-lineto x y
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("x coordinate missing for 'L' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.x = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("y coordinate missing for 'L' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.y = tt.nval;
                    path.lineTo(p.x, p.y);
                    nextCommand = 'L';

                    break;
                case 'l':
                    // relative-lineto dx dy
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dx coordinate missing for 'l' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.x += tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dy coordinate missing for 'l' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.y += tt.nval;
                    path.lineTo(p.x, p.y);
                    nextCommand = 'l';

                    break;
                case 'H':
                    // absolute-horizontal-lineto x
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("x coordinate missing for 'H' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.x = tt.nval;
                    path.lineTo(p.x, p.y);
                    nextCommand = 'H';

                    break;
                case 'h':
                    // relative-horizontal-lineto dx
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dx coordinate missing for 'h' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.x += tt.nval;
                    path.lineTo(p.x, p.y);
                    nextCommand = 'h';

                    break;
                case 'V':
                    // absolute-vertical-lineto y
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("y coordinate missing for 'V' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.y = tt.nval;
                    path.lineTo(p.x, p.y);
                    nextCommand = 'V';

                    break;
                case 'v':
                    // relative-vertical-lineto dy
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dy coordinate missing for 'v' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.y += tt.nval;
                    path.lineTo(p.x, p.y);
                    nextCommand = 'v';

                    break;
                case 'C':
                    // absolute-curveto x1 y1 x2 y2 x y
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("x1 coordinate missing for 'C' at position " + tt.getStartPosition() + " in " + str);
                    }
                    c1.x = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("y1 coordinate missing for 'C' at position " + tt.getStartPosition() + " in " + str);
                    }
                    c1.y = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("x2 coordinate missing for 'C' at position " + tt.getStartPosition() + " in " + str);
                    }
                    c2.x = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("y2 coordinate missing for 'C' at position " + tt.getStartPosition() + " in " + str);
                    }
                    c2.y = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("x coordinate missing for 'C' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.x = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("y coordinate missing for 'C' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.y = tt.nval;
                    path.curveTo(c1.x, c1.y, c2.x, c2.y, p.x, p.y);
                    nextCommand = 'C';
                    break;

                case 'c':
                    // relative-curveto dx1 dy1 dx2 dy2 dx dy
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dx1 coordinate missing for 'c' at position " + tt.getStartPosition() + " in " + str);
                    }
                    c1.x = p.x + tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dy1 coordinate missing for 'c' at position " + tt.getStartPosition() + " in " + str);
                    }
                    c1.y = p.y + tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dx2 coordinate missing for 'c' at position " + tt.getStartPosition() + " in " + str);
                    }
                    c2.x = p.x + tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dy2 coordinate missing for 'c' at position " + tt.getStartPosition() + " in " + str);
                    }
                    c2.y = p.y + tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dx coordinate missing for 'c' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.x += tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dy coordinate missing for 'c' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.y += tt.nval;
                    path.curveTo(c1.x, c1.y, c2.x, c2.y, p.x, p.y);
                    nextCommand = 'c';
                    break;

                case 'S':
                    // absolute-shorthand-curveto x2 y2 x y
                    node = path.get(path.size() - 1);
                    c1.x = node.x[0] * 2d - node.x[1];
                    c1.y = node.y[0] * 2d - node.y[1];
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("x2 coordinate missing for 'S' at position " + tt.getStartPosition() + " in " + str);
                    }
                    c2.x = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("y2 coordinate missing for 'S' at position " + tt.getStartPosition() + " in " + str);
                    }
                    c2.y = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("x coordinate missing for 'S' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.x = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("y coordinate missing for 'S' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.y = tt.nval;
                    path.curveTo(c1.x, c1.y, c2.x, c2.y, p.x, p.y);
                    nextCommand = 'S';
                    break;

                case 's':
                    // relative-shorthand-curveto dx2 dy2 dx dy
                    node = path.get(path.size() - 1);
                    c1.x = node.x[0] * 2d - node.x[1];
                    c1.y = node.y[0] * 2d - node.y[1];
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dx2 coordinate missing for 's' at position " + tt.getStartPosition() + " in " + str);
                    }
                    c2.x = p.x + tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dy2 coordinate missing for 's' at position " + tt.getStartPosition() + " in " + str);
                    }
                    c2.y = p.y + tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dx coordinate missing for 's' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.x += tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dy coordinate missing for 's' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.y += tt.nval;
                    path.curveTo(c1.x, c1.y, c2.x, c2.y, p.x, p.y);
                    nextCommand = 's';
                    break;

                case 'Q':
                    // absolute-quadto x1 y1 x y
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("x1 coordinate missing for 'Q' at position " + tt.getStartPosition() + " in " + str);
                    }
                    c1.x = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("y1 coordinate missing for 'Q' at position " + tt.getStartPosition() + " in " + str);
                    }
                    c1.y = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("x coordinate missing for 'Q' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.x = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("y coordinate missing for 'Q' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.y = tt.nval;
                    path.quadTo(c1.x, c1.y, p.x, p.y);
                    nextCommand = 'Q';

                    break;

                case 'q':
                    // relative-quadto dx1 dy1 dx dy
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dx1 coordinate missing for 'q' at position " + tt.getStartPosition() + " in " + str);
                    }
                    c1.x = p.x + tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dy1 coordinate missing for 'q' at position " + tt.getStartPosition() + " in " + str);
                    }
                    c1.y = p.y + tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dx coordinate missing for 'q' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.x += tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dy coordinate missing for 'q' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.y += tt.nval;
                    path.quadTo(c1.x, c1.y, p.x, p.y);
                    nextCommand = 'q';

                    break;
                case 'T':
                    // absolute-shorthand-quadto x y
                    node = path.get(path.size() - 1);
                    c1.x = node.x[0] * 2d - node.x[1];
                    c1.y = node.y[0] * 2d - node.y[1];
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("x coordinate missing for 'T' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.x = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("y coordinate missing for 'T' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.y = tt.nval;
                    path.quadTo(c1.x, c1.y, p.x, p.y);
                    nextCommand = 'T';

                    break;

                case 't':
                    // relative-shorthand-quadto dx dy
                    node = path.get(path.size() - 1);
                    c1.x = node.x[0] * 2d - node.x[1];
                    c1.y = node.y[0] * 2d - node.y[1];
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dx coordinate missing for 't' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.x += tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("dy coordinate missing for 't' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.y += tt.nval;
                    path.quadTo(c1.x, c1.y, p.x, p.y);
                    nextCommand = 's';

                    break;


                case 'A': {
                    // absolute-elliptical-arc rx ry x-axis-rotation large-arc-flag sweep-flag x y
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("rx coordinate missing for 'A' at position " + tt.getStartPosition() + " in " + str);
                    }
                    // If rX or rY have negative signs, these are dropped;
                    // the absolute value is used instead.
                    double rx = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("ry coordinate missing for 'A' at position " + tt.getStartPosition() + " in " + str);
                    }
                    double ry = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("x-axis-rotation missing for 'A' at position " + tt.getStartPosition() + " in " + str);
                    }
                    double xAxisRotation = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("large-arc-flag missing for 'A' at position " + tt.getStartPosition() + " in " + str);
                    }
                    boolean largeArcFlag = tt.nval != 0;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("sweep-flag missing for 'A' at position " + tt.getStartPosition() + " in " + str);
                    }
                    boolean sweepFlag = tt.nval != 0;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("x coordinate missing for 'A' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.x = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("y coordinate missing for 'A' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.y = tt.nval;

                    path.arcTo(rx, ry, xAxisRotation, largeArcFlag, sweepFlag, p.x, p.y);

                    nextCommand = 'A';
                    break;
                }
                case 'a': {
                    // absolute-elliptical-arc rx ry x-axis-rotation large-arc-flag sweep-flag x y
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("rx coordinate missing for 'A' at position " + tt.getStartPosition() + " in " + str);
                    }
                    // If rX or rY have negative signs, these are dropped;
                    // the absolute value is used instead.
                    double rx = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("ry coordinate missing for 'A' at position " + tt.getStartPosition() + " in " + str);
                    }
                    double ry = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("x-axis-rotation missing for 'A' at position " + tt.getStartPosition() + " in " + str);
                    }
                    double xAxisRotation = tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("large-arc-flag missing for 'A' at position " + tt.getStartPosition() + " in " + str);
                    }
                    boolean largeArcFlag = tt.nval != 0;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("sweep-flag missing for 'A' at position " + tt.getStartPosition() + " in " + str);
                    }
                    boolean sweepFlag = tt.nval != 0;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("x coordinate missing for 'A' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.x += tt.nval;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("y coordinate missing for 'A' at position " + tt.getStartPosition() + " in " + str);
                    }
                    p.y += tt.nval;

                    path.arcTo(rx, ry, xAxisRotation, largeArcFlag, sweepFlag, p.x, p.y);

                    nextCommand = 'a';
                    break;
                }
                default:
                    if (DEBUG) {
                        System.out.println("SVGInputFormat.toPath aborting after illegal path command: " + command + " found in path " + str);
                    }
                    break Commands;
                //throw new IOException("Illegal command: "+command);
            }
        }
        if (path != null) {
            paths.add(path);
        }

        return paths.toArray(new BezierPath[paths.size()]);
    }

    /* Reads core attributes as listed in
     * http://www.w3.org/TR/SVGMobile12/feature.html#CoreAttribute
     */
    private void readCoreAttributes(IXMLElement elem, HashMap<AttributeKey, Object> a)
            throws IOException {
        // read "id" or "xml:id"
        //identifiedElements.putx(elem.get("id"), elem);
        //identifiedElements.putx(elem.get("xml:id"), elem);
        // XXX - Add
        // xml:base
        // xml:lang
        // xml:space
        // class
    }

    /**
     * Puts all elments with an "id" or an "xml:id" attribute into the
     * hashtable {@code identifiedElements}.
     */
    private void identifyElements(IXMLElement elem) {
        identifiedElements.put(elem.getAttribute("id", ""), elem);
        identifiedElements.put(elem.getAttribute("xml:id", ""), elem);

        for (IXMLElement child : elem.getChildren()) {
            identifyElements(child);
        }
    }

    /* Reads object/group opacity as described in
     * http://www.w3.org/TR/SVGMobile12/painting.html#groupOpacity
     */
    private void readOpacityAttribute(IXMLElement elem, Map<AttributeKey, Object> a)
            throws IOException {
        //'opacity'
        //Value:  	<opacity-value> | inherit
        //Initial:  	1
        //Applies to:  	 'image' element
        //Inherited:  	no
        //Percentages:  	N/A
        //Media:  	visual
        //Animatable:  	yes
        //Computed value:  	 Specified value, except inherit
        //<opacity-value>
        //The uniform opacity setting must be applied across an entire object.
        //Any values outside the range 0.0 (fully transparent) to 1.0
        //(fully opaque) shall be clamped to this range.
        //(See Clamping values which are restricted to a particular range.)
        double value = toDouble(elem, readAttribute(elem, "opacity", "1"), 1, 0, 1);
        OPACITY.put(a, value);
    }
    /* Reads text attributes as listed in
     * http://www.w3.org/TR/SVGMobile12/feature.html#Text
     */

    private void readTextAttributes(IXMLElement elem, Map<AttributeKey, Object> a)
            throws IOException {
        Object value;

        //'text-anchor'
        //Value:  	start | middle | end | inherit
        //Initial:  	start
        //Applies to:  	'text' IXMLElement
        //Inherited:  	yes
        //Percentages:  	N/A
        //Media:  	visual
        //Animatable:  	yes
        //Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "text-anchor", "start");
        if (SVG_TEXT_ANCHORS.get(value) != null) {
            TEXT_ANCHOR.put(a, SVG_TEXT_ANCHORS.get(value));
        }

        //'display-align'
        //Value:  	auto | before | center | after | inherit
        //Initial:  	auto
        //Applies to:  	'textArea'
        //Inherited:  	yes
        //Percentages:  	N/A
        //Media:  	visual
        //Animatable:  	yes
        //Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "display-align", "auto");
        // XXX - Implement me properly
        if (!value.equals("auto")) {
            if (value.equals("center")) {
                TEXT_ANCHOR.put(a, TextAnchor.MIDDLE);
            } else if (value.equals("before")) {
                TEXT_ANCHOR.put(a, TextAnchor.END);
            }
        }

        //text-align
        //Value:	 start | end | center | inherit
        //Initial:	 start
        //Applies to:	 textArea elements
        //Inherited:	 yes
        //Percentages:	 N/A
        //Media:	 visual
        //Animatable:	 yes
        value = readInheritAttribute(elem, "text-align", "start");
        // XXX - Implement me properly
        if (!value.equals("start")) {
            TEXT_ALIGN.put(a, SVG_TEXT_ALIGNS.get(value));
        }
    }
    /* Reads text flow attributes as listed in
     * http://www.w3.org/TR/SVGMobile12/feature.html#TextFlow
     */

    private void readTextFlowAttributes(IXMLElement elem, HashMap<AttributeKey, Object> a)
            throws IOException {
        Object value;

        //'line-increment'
        //Value:  	auto | <number> | inherit
        //Initial:  	auto
        //Applies to:  	'textArea'
        //Inherited:  	yes
        //Percentages:  	N/A
        //Media:  	visual
        //Animatable:  	yes
        //Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "line-increment", "auto");
        if (DEBUG) {
            System.out.println("SVGInputFormat not implemented line-increment=" + value);
        }

    }
    /* Reads the transform attribute as specified in
     * http://www.w3.org/TR/SVGMobile12/coords.html#TransformAttribute
     */

    private void readTransformAttribute(IXMLElement elem, HashMap<AttributeKey, Object> a)
            throws IOException {
        String value;
        value = readAttribute(elem, "transform", "none");
        if (!value.equals("none")) {
            TRANSFORM.put(a, toTransform(elem, value));
        }
    }
    /* Reads solid color attributes.
     */

    private void readSolidColorElement(IXMLElement elem)
            throws IOException {
        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        readCoreAttributes(elem, a);

        // 'solid-color'
        //Value:	 currentColor | <color> | inherit
        //Initial:	 black
        //Applies to:	 'solidColor' elements
        //Inherited:	 no
        //Percentages:	 N/A
        //Media:	 visual
        //Animatable:	 yes
        //Computed value:  	 Specified <color> value, except inherit
        Color color = toColor(elem, readAttribute(elem, "solid-color", "black"));

        //'solid-opacity'
        //Value:	<opacity-value> | inherit
        //Initial:	 1
        //Applies to:	 'solidColor' elements
        //Inherited:	 no
        //Percentages:	 N/A
        //Media:	 visual
        //Animatable:	 yes
        //Computed value:  	 Specified value, except inherit
        double opacity = toDouble(elem, readAttribute(elem, "solid-opacity", "1"), 1, 0, 1);
        if (opacity != 1) {
            color = new Color(((int) (255 * opacity) << 24) | (0xffffff & color.getRGB()), true);
        }

        elementObjects.put(elem, color);


    }

    /** Reads shape attributes.
     */
    private void readShapeAttributes(IXMLElement elem, HashMap<AttributeKey, Object> a)
            throws IOException {
        Object objectValue;
        String value;
        double doubleValue;

        //'color'
        // Value:  	<color> | inherit
        // Initial:  	 depends on user agent
        // Applies to:  	None. Indirectly affects other properties via currentColor
        // Inherited:  	 yes
        // Percentages:  	 N/A
        // Media:  	 visual
        // Animatable:  	 yes
        // Computed value:  	 Specified <color> value, except inherit
        //
        // value = readInheritAttribute(elem, "color", "black");
        // if (DEBUG) System.out.println("color="+value);

        //'color-rendering'
        // Value:  	 auto | optimizeSpeed | optimizeQuality | inherit
        // Initial:  	 auto
        // Applies to:  	 container elements , graphics elements and 'animateColor'
        // Inherited:  	 yes
        // Percentages:  	 N/A
        // Media:  	 visual
        // Animatable:  	 yes
        // Computed value:  	 Specified value, except inherit
        //
        // value = readInheritAttribute(elem, "color-rendering", "auto");
        // if (DEBUG) System.out.println("color-rendering="+value);

        // 'fill'
        // Value:  	<paint> | inherit (See Specifying paint)
        // Initial:  	 black
        // Applies to:  	 shapes and text content elements
        // Inherited:  	 yes
        // Percentages:  	 N/A
        // Media:  	 visual
        // Animatable:  	 yes
        // Computed value:  	 "none", system paint, specified <color> value or absolute IRI
        objectValue = toPaint(elem, readInheritColorAttribute(elem, "fill", "black"));
        if (objectValue instanceof Color) {
            FILL_COLOR.put(a, (Color) objectValue);
        } else if (objectValue instanceof Gradient) {
            FILL_GRADIENT.putClone(a, (Gradient) objectValue);
        } else if (objectValue == null) {
            FILL_COLOR.put(a, null);
        } else {
            FILL_COLOR.put(a, null);
            if (DEBUG) {
                System.out.println("SVGInputFormat not implemented  fill=" + objectValue);
            }
        }

        //'fill-opacity'
        //Value:  	 <opacity-value> | inherit
        //Initial:  	 1
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        objectValue = readInheritAttribute(elem, "fill-opacity", "1");
        FILL_OPACITY.put(a, toDouble(elem, (String) objectValue, 1d, 0d, 1d));

        // 'fill-rule'
        // Value:	 nonzero | evenodd | inherit
        // Initial: 	 nonzero
        // Applies to:  	 shapes and text content elements
        // Inherited:  	 yes
        // Percentages:  	 N/A
        // Media:  	 visual
        // Animatable:  	 yes
        // Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "fill-rule", "nonzero");
        WINDING_RULE.put(a, SVG_FILL_RULES.get(value));

        //'stroke'
        //Value:  	<paint> | inherit (See Specifying paint)
        //Initial:  	 none
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 "none", system paint, specified <color> value
        // or absolute IRI
        objectValue = toPaint(elem, readInheritColorAttribute(elem, "stroke", "none"));
        if (objectValue instanceof Color) {
            STROKE_COLOR.put(a, (Color) objectValue);
        } else if (objectValue instanceof Gradient) {
            STROKE_GRADIENT.putClone(a, (Gradient) objectValue);
        } else if (objectValue == null) {
            STROKE_COLOR.put(a, null);
        } else {
            STROKE_COLOR.put(a, null);
            if (DEBUG) {
                System.out.println("SVGInputFormat not implemented  stroke=" + objectValue);
            }
        }

        //'stroke-dasharray'
        //Value:  	 none | <dasharray> | inherit
        //Initial:  	 none
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes (non-additive)
        //Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "stroke-dasharray", "none");
        if (!value.equals("none")) {
            String[] values = toWSOrCommaSeparatedArray(value);
            double[] dashes = new double[values.length];
            for (int i = 0; i < values.length; i++) {
                dashes[i] = toNumber(elem, values[i]);
            }
            STROKE_DASHES.put(a, dashes);
        }

        //'stroke-dashoffset'
        //Value:  	<length> | inherit
        //Initial:  	 0
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        doubleValue = toNumber(elem, readInheritAttribute(elem, "stroke-dashoffset", "0"));
        STROKE_DASH_PHASE.put(a, doubleValue);
        IS_STROKE_DASH_FACTOR.put(a, false);

        //'stroke-linecap'
        //Value:  	 butt | round | square | inherit
        //Initial:  	 butt
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "stroke-linecap", "butt");
        STROKE_CAP.put(a, SVG_STROKE_LINECAPS.get(value));


        //'stroke-linejoin'
        //Value:  	 miter | round | bevel | inherit
        //Initial:  	 miter
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "stroke-linejoin", "miter");
        STROKE_JOIN.put(a, SVG_STROKE_LINEJOINS.get(value));

        //'stroke-miterlimit'
        //Value:  	 <miterlimit> | inherit
        //Initial:  	 4
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        doubleValue = toDouble(elem, readInheritAttribute(elem, "stroke-miterlimit", "4"), 4d, 1d, Double.MAX_VALUE);
        STROKE_MITER_LIMIT.put(a, doubleValue);
        IS_STROKE_MITER_LIMIT_FACTOR.put(a, false);

        //'stroke-opacity'
        //Value:  	 <opacity-value> | inherit
        //Initial:  	 1
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        objectValue = readInheritAttribute(elem, "stroke-opacity", "1");
        STROKE_OPACITY.put(a, toDouble(elem, (String) objectValue, 1d, 0d, 1d));

        //'stroke-width'
        //Value:  	<length> | inherit
        //Initial:  	 1
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        doubleValue = toNumber(elem, readInheritAttribute(elem, "stroke-width", "1"));
        STROKE_WIDTH.put(a, doubleValue);
    }
    /* Reads shape attributes for the SVG "use" element.
     */

    private void readUseShapeAttributes(IXMLElement elem, HashMap<AttributeKey, Object> a)
            throws IOException {
        Object objectValue;
        String value;
        double doubleValue;

        //'color'
        // Value:  	<color> | inherit
        // Initial:  	 depends on user agent
        // Applies to:  	None. Indirectly affects other properties via currentColor
        // Inherited:  	 yes
        // Percentages:  	 N/A
        // Media:  	 visual
        // Animatable:  	 yes
        // Computed value:  	 Specified <color> value, except inherit
        //
        // value = readInheritAttribute(elem, "color", "black");
        // if (DEBUG) System.out.println("color="+value);

        //'color-rendering'
        // Value:  	 auto | optimizeSpeed | optimizeQuality | inherit
        // Initial:  	 auto
        // Applies to:  	 container elements , graphics elements and 'animateColor'
        // Inherited:  	 yes
        // Percentages:  	 N/A
        // Media:  	 visual
        // Animatable:  	 yes
        // Computed value:  	 Specified value, except inherit
        //
        // value = readInheritAttribute(elem, "color-rendering", "auto");
        // if (DEBUG) System.out.println("color-rendering="+value);

        // 'fill'
        // Value:  	<paint> | inherit (See Specifying paint)
        // Initial:  	 black
        // Applies to:  	 shapes and text content elements
        // Inherited:  	 yes
        // Percentages:  	 N/A
        // Media:  	 visual
        // Animatable:  	 yes
        // Computed value:  	 "none", system paint, specified <color> value or absolute IRI
        objectValue = readInheritColorAttribute(elem, "fill", null);
        if (objectValue != null) {
            objectValue = toPaint(elem, (String) objectValue);
            if (objectValue instanceof Color) {
                FILL_COLOR.put(a, (Color) objectValue);
            } else if (objectValue instanceof Gradient) {
                FILL_GRADIENT.put(a, (Gradient) objectValue);
            } else if (objectValue == null) {
                FILL_COLOR.put(a, null);
            } else {
                FILL_COLOR.put(a, null);
                if (DEBUG) {
                    System.out.println("SVGInputFormat not implemented  fill=" + objectValue);
                }
            }
        }

        //'fill-opacity'
        //Value:  	 <opacity-value> | inherit
        //Initial:  	 1
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        objectValue = readInheritAttribute(elem, "fill-opacity", null);
        if (objectValue != null) {
            FILL_OPACITY.put(a, toDouble(elem, (String) objectValue, 1d, 0d, 1d));
        }

        // 'fill-rule'
        // Value:	 nonzero | evenodd | inherit
        // Initial: 	 nonzero
        // Applies to:  	 shapes and text content elements
        // Inherited:  	 yes
        // Percentages:  	 N/A
        // Media:  	 visual
        // Animatable:  	 yes
        // Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "fill-rule", null);
        if (value != null) {
            WINDING_RULE.put(a, SVG_FILL_RULES.get(value));
        }

        //'stroke'
        //Value:  	<paint> | inherit (See Specifying paint)
        //Initial:  	 none
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 "none", system paint, specified <color> value
        // or absolute IRI
        objectValue = toPaint(elem, readInheritColorAttribute(elem, "stroke", null));
        if (objectValue != null) {
            if (objectValue instanceof Color) {
                STROKE_COLOR.put(a, (Color) objectValue);
            } else if (objectValue instanceof Gradient) {
                STROKE_GRADIENT.put(a, (Gradient) objectValue);
            }
        }

        //'stroke-dasharray'
        //Value:  	 none | <dasharray> | inherit
        //Initial:  	 none
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes (non-additive)
        //Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "stroke-dasharray", null);
        if (value != null && !value.equals("none")) {
            String[] values = toCommaSeparatedArray(value);
            double[] dashes = new double[values.length];
            for (int i = 0; i < values.length; i++) {
                dashes[i] = toNumber(elem, values[i]);
            }
            STROKE_DASHES.put(a, dashes);
        }

        //'stroke-dashoffset'
        //Value:  	<length> | inherit
        //Initial:  	 0
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        objectValue = readInheritAttribute(elem, "stroke-dashoffset", null);
        if (objectValue != null) {
            doubleValue = toNumber(elem, (String) objectValue);
            STROKE_DASH_PHASE.put(a, doubleValue);
            IS_STROKE_DASH_FACTOR.put(a, false);
        }

        //'stroke-linecap'
        //Value:  	 butt | round | square | inherit
        //Initial:  	 butt
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "stroke-linecap", null);
        if (value != null) {
            STROKE_CAP.put(a, SVG_STROKE_LINECAPS.get(value));
        }

        //'stroke-linejoin'
        //Value:  	 miter | round | bevel | inherit
        //Initial:  	 miter
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "stroke-linejoin", null);
        if (value != null) {
            STROKE_JOIN.put(a, SVG_STROKE_LINEJOINS.get(value));
        }
        //'stroke-miterlimit'
        //Value:  	 <miterlimit> | inherit
        //Initial:  	 4
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        objectValue = readInheritAttribute(elem, "stroke-miterlimit", null);
        if (objectValue != null) {
            doubleValue = toDouble(elem, (String) objectValue, 4d, 1d, Double.MAX_VALUE);
            STROKE_MITER_LIMIT.put(a, doubleValue);
            IS_STROKE_MITER_LIMIT_FACTOR.put(a, false);
        }

        //'stroke-opacity'
        //Value:  	 <opacity-value> | inherit
        //Initial:  	 1
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        objectValue = readInheritAttribute(elem, "stroke-opacity", null);
        if (objectValue != null) {
            STROKE_OPACITY.put(a, toDouble(elem, (String) objectValue, 1d, 0d, 1d));
        }

        //'stroke-width'
        //Value:  	<length> | inherit
        //Initial:  	 1
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        objectValue = readInheritAttribute(elem, "stroke-width", null);
        if (objectValue != null) {
            doubleValue = toNumber(elem, (String) objectValue);
            STROKE_WIDTH.put(a, doubleValue);
        }
    }

    /** Reads line and polyline attributes.
     */
    private void readLineAttributes(IXMLElement elem, HashMap<AttributeKey, Object> a)
            throws IOException {
        Object objectValue;
        String value;
        double doubleValue;

        //'color'
        // Value:  	<color> | inherit
        // Initial:  	 depends on user agent
        // Applies to:  	None. Indirectly affects other properties via currentColor
        // Inherited:  	 yes
        // Percentages:  	 N/A
        // Media:  	 visual
        // Animatable:  	 yes
        // Computed value:  	 Specified <color> value, except inherit
        //
        // value = readInheritAttribute(elem, "color", "black");
        // if (DEBUG) System.out.println("color="+value);

        //'color-rendering'
        // Value:  	 auto | optimizeSpeed | optimizeQuality | inherit
        // Initial:  	 auto
        // Applies to:  	 container elements , graphics elements and 'animateColor'
        // Inherited:  	 yes
        // Percentages:  	 N/A
        // Media:  	 visual
        // Animatable:  	 yes
        // Computed value:  	 Specified value, except inherit
        //
        // value = readInheritAttribute(elem, "color-rendering", "auto");
        // if (DEBUG) System.out.println("color-rendering="+value);

        // 'fill'
        // Value:  	<paint> | inherit (See Specifying paint)
        // Initial:  	 black
        // Applies to:  	 shapes and text content elements
        // Inherited:  	 yes
        // Percentages:  	 N/A
        // Media:  	 visual
        // Animatable:  	 yes
        // Computed value:  	 "none", system paint, specified <color> value or absolute IRI
        objectValue = toPaint(elem, readInheritColorAttribute(elem, "fill", "none"));
        if (objectValue instanceof Color) {
            FILL_COLOR.put(a, (Color) objectValue);
        } else if (objectValue instanceof Gradient) {
            FILL_GRADIENT.putClone(a, (Gradient) objectValue);
        } else if (objectValue == null) {
            FILL_COLOR.put(a, null);
        } else {
            FILL_COLOR.put(a, null);
            if (DEBUG) {
                System.out.println("SVGInputFormat not implemented  fill=" + objectValue);
            }
        }

        //'fill-opacity'
        //Value:  	 <opacity-value> | inherit
        //Initial:  	 1
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        objectValue = readInheritAttribute(elem, "fill-opacity", "1");
        FILL_OPACITY.put(a, toDouble(elem, (String) objectValue, 1d, 0d, 1d));

        // 'fill-rule'
        // Value:	 nonzero | evenodd | inherit
        // Initial: 	 nonzero
        // Applies to:  	 shapes and text content elements
        // Inherited:  	 yes
        // Percentages:  	 N/A
        // Media:  	 visual
        // Animatable:  	 yes
        // Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "fill-rule", "nonzero");
        WINDING_RULE.put(a, SVG_FILL_RULES.get(value));

        //'stroke'
        //Value:  	<paint> | inherit (See Specifying paint)
        //Initial:  	 none
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 "none", system paint, specified <color> value
        // or absolute IRI
        objectValue = toPaint(elem, readInheritColorAttribute(elem, "stroke", "black"));
        if (objectValue instanceof Color) {
            STROKE_COLOR.put(a, (Color) objectValue);
        } else if (objectValue instanceof Gradient) {
            STROKE_GRADIENT.putClone(a, (Gradient) objectValue);
        } else if (objectValue == null) {
            STROKE_COLOR.put(a, null);
        } else {
            STROKE_COLOR.put(a, null);
            if (DEBUG) {
                System.out.println("SVGInputFormat not implemented  stroke=" + objectValue);
            }
        }

        //'stroke-dasharray'
        //Value:  	 none | <dasharray> | inherit
        //Initial:  	 none
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes (non-additive)
        //Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "stroke-dasharray", "none");
        if (!value.equals("none")) {
            String[] values = toWSOrCommaSeparatedArray(value);
            double[] dashes = new double[values.length];
            for (int i = 0; i < values.length; i++) {
                dashes[i] = toNumber(elem, values[i]);
            }
            STROKE_DASHES.put(a, dashes);
        }

        //'stroke-dashoffset'
        //Value:  	<length> | inherit
        //Initial:  	 0
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        doubleValue = toNumber(elem, readInheritAttribute(elem, "stroke-dashoffset", "0"));
        STROKE_DASH_PHASE.put(a, doubleValue);
        IS_STROKE_DASH_FACTOR.put(a, false);

        //'stroke-linecap'
        //Value:  	 butt | round | square | inherit
        //Initial:  	 butt
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "stroke-linecap", "butt");
        STROKE_CAP.put(a, SVG_STROKE_LINECAPS.get(value));


        //'stroke-linejoin'
        //Value:  	 miter | round | bevel | inherit
        //Initial:  	 miter
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "stroke-linejoin", "miter");
        STROKE_JOIN.put(a, SVG_STROKE_LINEJOINS.get(value));

        //'stroke-miterlimit'
        //Value:  	 <miterlimit> | inherit
        //Initial:  	 4
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        doubleValue = toDouble(elem, readInheritAttribute(elem, "stroke-miterlimit", "4"), 4d, 1d, Double.MAX_VALUE);
        STROKE_MITER_LIMIT.put(a, doubleValue);
        IS_STROKE_MITER_LIMIT_FACTOR.put(a, false);

        //'stroke-opacity'
        //Value:  	 <opacity-value> | inherit
        //Initial:  	 1
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        objectValue = readInheritAttribute(elem, "stroke-opacity", "1");
        STROKE_OPACITY.put(a, toDouble(elem, (String) objectValue, 1d, 0d, 1d));

        //'stroke-width'
        //Value:  	<length> | inherit
        //Initial:  	 1
        //Applies to:  	 shapes and text content elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        doubleValue = toNumber(elem, readInheritAttribute(elem, "stroke-width", "1"));
        STROKE_WIDTH.put(a, doubleValue);
    }
    /* Reads viewport attributes.
     */

    private void readViewportAttributes(IXMLElement elem, HashMap<AttributeKey, Object> a)
            throws IOException {
        Object value;
        Double doubleValue;
        // width of the viewport
        value = readAttribute(elem, "width", null);
        if (DEBUG) {
            System.out.println("SVGInputFormat READ viewport w/h factors:" + viewportStack.peek().widthPercentFactor + "," + viewportStack.peek().heightPercentFactor);
        }
        if (value != null) {
            doubleValue = toLength(elem, (String) value, viewportStack.peek().widthPercentFactor);
            VIEWPORT_WIDTH.put(a, doubleValue);
        }
        // height of the viewport
        value = readAttribute(elem, "height", null);
        if (value != null) {
            doubleValue = toLength(elem, (String) value, viewportStack.peek().heightPercentFactor);
            VIEWPORT_HEIGHT.put(a, doubleValue);
        }

        //'viewport-fill'
        //Value:	 "none" | <color> | inherit
        //Initial:	 none
        //Applies to:	viewport-creating elements
        //Inherited:	 no
        //Percentages:	 N/A
        //Media:	 visual
        //Animatable:	 yes
        //Computed value:  	 "none" or specified <color> value, except inherit
        value = toPaint(elem, readInheritColorAttribute(elem, "viewport-fill", "none"));
        if (value == null || (value instanceof Color)) {
            VIEWPORT_FILL.put(a, (Color) value);
        }

        //'viewport-fill-opacity'
        //Value:	<opacity-value> | inherit
        //Initial:	 1.0
        //Applies to:	viewport-creating elements
        //Inherited:	 no
        //Percentages:	 N/A
        //Media:	 visual
        //Animatable:	 yes
        //Computed value:  	 Specified value, except inherit
        doubleValue = toDouble(elem, readAttribute(elem, "viewport-fill-opacity", "1.0"));
        VIEWPORT_FILL_OPACITY.put(a, doubleValue);
    }
    /* Reads graphics attributes as listed in
     * http://www.w3.org/TR/SVGMobile12/feature.html#GraphicsAttribute
     */

    private void readGraphicsAttributes(IXMLElement elem, Figure f)
            throws IOException {
        Object value;
        // 'display'
        // Value:  	 inline | block | list-item |
        // run-in | compact | marker |
        // table | inline-table | table-row-group | table-header-group |
        // table-footer-group | table-row | table-column-group | table-column |
        // table-cell | table-caption | none | inherit
        // Initial:  	 inline
        // Applies to:  	 'svg' , 'g' , 'switch' , 'a' , 'foreignObject' ,
        // graphics elements (including the text content block elements) and text
        // sub-elements (for example, 'tspan' and 'a' )
        // Inherited:  	 no
        // Percentages:  	 N/A
        // Media:  	 all
        // Animatable:  	 yes
        // Computed value:  	 Specified value, except inherit
        value = readAttribute(elem, "display", "inline");
        if (DEBUG) {
            System.out.println("SVGInputFormat not implemented display=" + value);
        }


        //'image-rendering'
        //Value:  	 auto | optimizeSpeed | optimizeQuality | inherit
        //Initial:  	 auto
        //Applies to:  	 images
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "image-rendering", "auto");
        if (DEBUG) {
            System.out.println("SVGInputFormat not implemented image-rendering=" + value);
        }

        //'pointer-events'
        //Value:  	boundingBox | visiblePainted | visibleFill | visibleStroke | visible |
        //painted | fill | stroke | all | none | inherit
        //Initial:  	visiblePainted
        //Applies to:  	graphics elements
        //Inherited:  	yes
        //Percentages:  	N/A
        //Media:  	visual
        //Animatable:  	yes
        //Computed value:  	Specified value, except inherit
        value = readInheritAttribute(elem, "pointer-events", "visiblePainted");
        if (DEBUG) {
            System.out.println("SVGInputFormat not implemented pointer-events=" + value);
        }

        // 'shape-rendering'
        //Value:  	 auto | optimizeSpeed | crispEdges |
        //geometricPrecision | inherit
        //Initial:  	 auto
        //Applies to:  	 shapes
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "shape-rendering", "auto");
        if (DEBUG) {
            System.out.println("SVGInputFormat not implemented shape-rendering=" + value);
        }

        //'text-rendering'
        //Value:  	 auto | optimizeSpeed | optimizeLegibility |
        //geometricPrecision | inherit
        //Initial:  	 auto
        //Applies to:  	text content block elements
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "text-rendering", "auto");
        if (DEBUG) {
            System.out.println("SVGInputFormat not implemented text-rendering=" + value);
        }

        //'vector-effect'
        //Value:  	 non-scaling-stroke | none | inherit
        //Initial:  	 none
        //Applies to:  	 graphics elements
        //Inherited:  	 no
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        value = readAttribute(elem, "vector-effect", "none");
        if (DEBUG) {
            System.out.println("SVGInputFormat not implemented vector-effect=" + value);
        }

        //'visibility'
        //Value:  	 visible | hidden | collapse | inherit
        //Initial:  	 visible
        //Applies to:  	 graphics elements (including the text content block
        // elements) and text sub-elements (for example, 'tspan' and 'a' )
        //Inherited:  	 yes
        //Percentages:  	 N/A
        //Media:  	 visual
        //Animatable:  	 yes
        //Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "visibility", null);
        if (DEBUG) {
            System.out.println("SVGInputFormat not implemented visibility=" + value);
        }
    }

    /**
     * Reads an SVG "linearGradient" element.
     */
    private void readLinearGradientElement(IXMLElement elem)
            throws IOException {
        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        readCoreAttributes(elem, a);

        double x1 = toLength(elem, readAttribute(elem, "x1", "0"), 0.01);
        double y1 = toLength(elem, readAttribute(elem, "y1", "0"), 0.01);
        double x2 = toLength(elem, readAttribute(elem, "x2", "1"), 0.01);
        double y2 = toLength(elem, readAttribute(elem, "y2", "0"), 0.01);
        boolean isRelativeToFigureBounds = readAttribute(elem, "gradientUnits", "objectBoundingBox").equals("objectBoundingBox");

        ArrayList<IXMLElement> stops = elem.getChildrenNamed("stop", SVG_NAMESPACE);
        if (stops.size() == 0) {
            stops = elem.getChildrenNamed("stop");
        }
        if (stops.size() == 0) {
            // FIXME - Implement xlink support throughouth SVGInputFormat
            String xlink = readAttribute(elem, "xlink:href", "");
            if (xlink.startsWith("#")
                    && identifiedElements.get(xlink.substring(1)) != null) {

                stops = identifiedElements.get(xlink.substring(1)).getChildrenNamed("stop", SVG_NAMESPACE);
                if (stops.size() == 0) {
                    stops = identifiedElements.get(xlink.substring(1)).getChildrenNamed("stop");
                }
            }
        }
        if (stops.size() == 0) {
            if (DEBUG) {
                System.out.println("SVGInpuFormat: Warning no stops in linearGradient " + elem);
            }
        }

        double[] stopOffsets = new double[stops.size()];
        Color[] stopColors = new Color[stops.size()];
        double[] stopOpacities = new double[stops.size()];
        for (int i = 0; i < stops.size(); i++) {
            IXMLElement stopElem = stops.get(i);
            String offsetStr = readAttribute(stopElem, "offset", "0");
            if (offsetStr.endsWith("%")) {
                stopOffsets[i] = toDouble(stopElem, offsetStr.substring(0, offsetStr.length() - 1), 0, 0, 100) / 100d;
            } else {
                stopOffsets[i] = toDouble(stopElem, offsetStr, 0, 0, 1);
            }
            // 'stop-color'
            // Value:  	currentColor | <color> | inherit
            // Initial:  	black
            // Applies to:  	 'stop' elements
            // Inherited:  	no
            // Percentages:  	N/A
            // Media:  	visual
            // Animatable:  	yes
            // Computed value:  	 Specified <color> value, except i
            stopColors[i] = toColor(stopElem, readAttribute(stopElem, "stop-color", "black"));
            if (stopColors[i] == null) {
                stopColors[i] = new Color(0x0, true);
                //throw new IOException("stop color missing in "+stopElem);
            }

            //'stop-opacity'
            //Value:  	<opacity-value> | inherit
            //Initial:  	1
            //Applies to:  	 'stop' elements
            //Inherited:  	no
            //Percentages:  	N/A
            //Media:  	visual
            //Animatable:  	yes
            //Computed value:  	 Specified value, except inherit
            stopOpacities[i] = toDouble(stopElem, readAttribute(stopElem, "stop-opacity", "1"), 1, 0, 1);
        }

        AffineTransform tx = toTransform(elem, readAttribute(elem, "gradientTransform", "none"));

        Gradient gradient = factory.createLinearGradient(
                x1, y1, x2, y2,
                stopOffsets, stopColors, stopOpacities,
                isRelativeToFigureBounds, tx);

        elementObjects.put(elem, gradient);
    }

    /**
     * Reads an SVG "radialGradient" element.
     */
    private void readRadialGradientElement(IXMLElement elem)
            throws IOException {
        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        readCoreAttributes(elem, a);

        double cx = toLength(elem, readAttribute(elem, "cx", "0.5"), 0.01);
        double cy = toLength(elem, readAttribute(elem, "cy", "0.5"), 0.01);
        double fx = toLength(elem, readAttribute(elem, "fx", readAttribute(elem, "cx", "0.5")), 0.01);
        double fy = toLength(elem, readAttribute(elem, "fy", readAttribute(elem, "cy", "0.5")), 0.01);
        double r = toLength(elem, readAttribute(elem, "r", "0.5"), 0.01);
        boolean isRelativeToFigureBounds =
                readAttribute(elem, "gradientUnits", "objectBoundingBox").equals("objectBoundingBox");

        ArrayList<IXMLElement> stops = elem.getChildrenNamed("stop", SVG_NAMESPACE);
        if (stops.size() == 0) {
            stops = elem.getChildrenNamed("stop");
        }
        if (stops.size() == 0) {
            // FIXME - Implement xlink support throughout SVGInputFormat
            String xlink = readAttribute(elem, "xlink:href", "");
            if (xlink.startsWith("#")
                    && identifiedElements.get(xlink.substring(1)) != null) {
                stops = identifiedElements.get(xlink.substring(1)).getChildrenNamed("stop", SVG_NAMESPACE);
                if (stops.size() == 0) {
                    stops = identifiedElements.get(xlink.substring(1)).getChildrenNamed("stop");
                }
            }
        }

        double[] stopOffsets = new double[stops.size()];
        Color[] stopColors = new Color[stops.size()];
        double[] stopOpacities = new double[stops.size()];
        for (int i = 0; i < stops.size(); i++) {
            IXMLElement stopElem = stops.get(i);
            String offsetStr = readAttribute(stopElem, "offset", "0");
            if (offsetStr.endsWith("%")) {
                stopOffsets[i] = toDouble(stopElem, offsetStr.substring(0, offsetStr.length() - 1), 0, 0, 100) / 100d;
            } else {
                stopOffsets[i] = toDouble(stopElem, offsetStr, 0, 0, 1);
            }
            // 'stop-color'
            // Value:  	currentColor | <color> | inherit
            // Initial:  	black
            // Applies to:  	 'stop' elements
            // Inherited:  	no
            // Percentages:  	N/A
            // Media:  	visual
            // Animatable:  	yes
            // Computed value:  	 Specified <color> value, except i
            stopColors[i] = toColor(stopElem, readAttribute(stopElem, "stop-color", "black"));
            if (stopColors[i] == null) {
                stopColors[i] = new Color(0x0, true);
                //throw new IOException("stop color missing in "+stopElem);
            }
            //'stop-opacity'
            //Value:  	<opacity-value> | inherit
            //Initial:  	1
            //Applies to:  	 'stop' elements
            //Inherited:  	no
            //Percentages:  	N/A
            //Media:  	visual
            //Animatable:  	yes
            //Computed value:  	 Specified value, except inherit
            stopOpacities[i] = toDouble(stopElem, readAttribute(stopElem, "stop-opacity", "1"), 1, 0, 1);
        }

        AffineTransform tx = toTransform(elem, readAttribute(elem, "gradientTransform", "none"));

        Gradient gradient = factory.createRadialGradient(
                cx, cy, fx, fy, r,
                stopOffsets, stopColors, stopOpacities,
                isRelativeToFigureBounds,
                tx);
        elementObjects.put(elem, gradient);
    }
    /* Reads font attributes as listed in
     * http://www.w3.org/TR/SVGMobile12/feature.html#Font
     */

    private void readFontAttributes(IXMLElement elem, Map<AttributeKey, Object> a)
            throws IOException {
        String value;
        double doubleValue;

        // 'font-family'
        // Value:  	[[ <family-name> |
        // <generic-family> ],]* [<family-name> |
        // <generic-family>] | inherit
        // Initial:  	depends on user agent
        // Applies to:  	text content elements
        // Inherited:  	yes
        // Percentages:  	N/A
        // Media:  	visual
        // Animatable:  	yes
        // Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "font-family", "Dialog");
        String[] familyNames = toQuotedAndCommaSeparatedArray(value);
        Font font = null;

        // Try to find a font with exactly matching name
        for (int i = 0; i < familyNames.length; i++) {
            try {
                font = (Font) fontFormatter.stringToValue(familyNames[i]);
                break;
            } catch (ParseException e) {
            }
        }
        if (font == null) {
            // Try to create a similar font using the first name in the list
            if (familyNames.length > 0) {
                fontFormatter.setAllowsUnknownFont(true);
                try {
                    font = (Font) fontFormatter.stringToValue(familyNames[0]);
                } catch (ParseException e) {
                }
                fontFormatter.setAllowsUnknownFont(false);
            }
        }
        if (font == null) {
            // Fallback to the system Dialog font
            font = new Font("Dialog", Font.PLAIN, 12);
        }
        FONT_FACE.put(a, font);

        // 'font-getChildCount'
        // Value:  	<absolute-getChildCount> | <relative-getChildCount> |
        // <length> | inherit
        // Initial:  	medium
        // Applies to:  	text content elements
        // Inherited:  	yes, the computed value is inherited
        // Percentages:  	N/A
        // Media:  	visual
        // Animatable:  	yes
        // Computed value:  	 Absolute length
        doubleValue = readInheritFontSizeAttribute(elem, "font-size", "medium");
        FONT_SIZE.put(a, doubleValue);

        // 'font-style'
        // Value:  	normal | italic | oblique | inherit
        // Initial:  	normal
        // Applies to:  	text content elements
        // Inherited:  	yes
        // Percentages:  	N/A
        // Media:  	visual
        // Animatable:  	yes
        // Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "font-style", "normal");
        FONT_ITALIC.put(a, value.equals("italic"));


        //'font-variant'
        //Value:  	normal | small-caps | inherit
        //Initial:  	normal
        //Applies to:  	text content elements
        //Inherited:  	yes
        //Percentages:  	N/A
        //Media:  	visual
        //Animatable:  	no
        //Computed value:  	 Specified value, except inherit
        value = readInheritAttribute(elem, "font-variant", "normal");
        // if (DEBUG) System.out.println("font-variant="+value);

        // 'font-weight'
        // Value:  	normal | bold | bolder | lighter | 100 | 200 | 300
        // | 400 | 500 | 600 | 700 | 800 | 900 | inherit
        // Initial:  	normal
        // Applies to:  	text content elements
        // Inherited:  	yes
        // Percentages:  	N/A
        // Media:  	visual
        // Animatable:  	yes
        // Computed value:  	 one of the legal numeric values, non-numeric
        // values shall be converted to numeric values according to the rules
        // defined below.
        value = readInheritAttribute(elem, "font-weight", "normal");
        FONT_BOLD.put(a, value.equals("bold") || value.equals("bolder")
                || value.equals("400") || value.equals("500") || value.equals("600")
                || value.equals("700") || value.equals("800") || value.equals("900"));

        // Note: text-decoration is an SVG 1.1 feature
        //'text-decoration'
        //Value:  	none | [ underline || overline || line-through || blink ] | inherit
        //Initial:  	none
        //Applies to:  	text content elements
        //Inherited:  	no (see prose)
        //Percentages:  	N/A
        //Media:  	visual
        //Animatable:  	yes
        value = readAttribute(elem, "text-decoration", "none");
        FONT_UNDERLINE.put(a, value.equals("underline"));
    }

    /**
     * Reads a paint style attribute. This can be a Color or a Gradient or null.
     * XXX - Doesn't support url(...) colors yet.
     */
    @Nullable
    private Object toPaint(IXMLElement elem, String value) throws IOException {
        String str = value;
        if (str == null) {
            return null;
        }

        str = str.trim().toLowerCase();

        if (str.equals("none")) {
            return null;
        } else if (str.equals("currentcolor")) {
            String currentColor = readInheritAttribute(elem, "color", "black");
            if (currentColor == null || currentColor.trim().toLowerCase().equals("currentColor")) {
                return null;
            } else {
                return toPaint(elem, currentColor);
            }
        } else if (SVG_COLORS.containsKey(str)) {
            return SVG_COLORS.get(str);
        } else if (str.startsWith("#") && str.length() == 7) {
            return new Color(Integer.decode(str));
        } else if (str.startsWith("#") && str.length() == 4) {
            // Three digits hex value
            int th = Integer.decode(str);
            return new Color(
                    (th & 0xf) | ((th & 0xf) << 4)
                    | ((th & 0xf0) << 4) | ((th & 0xf0) << 8)
                    | ((th & 0xf00) << 8) | ((th & 0xf00) << 12));
        } else if (str.startsWith("rgb")) {
            try {
                StringTokenizer tt = new StringTokenizer(str, "() ,");
                tt.nextToken();
                String r = tt.nextToken();
                String g = tt.nextToken();
                String b = tt.nextToken();
                Color c = new Color(
                        r.endsWith("%") ? (int) (Double.parseDouble(r.substring(0, r.length() - 1)) * 2.55) : Integer.decode(r),
                        g.endsWith("%") ? (int) (Double.parseDouble(g.substring(0, g.length() - 1)) * 2.55) : Integer.decode(g),
                        b.endsWith("%") ? (int) (Double.parseDouble(b.substring(0, b.length() - 1)) * 2.55) : Integer.decode(b));
                return c;
            } catch (Exception e) {
                /*if (DEBUG)*/ System.out.println("SVGInputFormat.toPaint illegal RGB value " + str);
                e.printStackTrace();
                return null;
            }
        } else if (str.startsWith("url(")) {
            String href = value.substring(4, value.length() - 1);
            if (identifiedElements.containsKey(href.substring(1))
                    && elementObjects.containsKey(identifiedElements.get(href.substring(1)))) {
                Object obj = elementObjects.get(identifiedElements.get(href.substring(1)));
                return obj;
            }
            // XXX - Implement me
            if (DEBUG) {
                System.out.println("SVGInputFormat.toPaint not implemented for " + href);
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * Reads a color style attribute. This can be a Color or null.
     * FIXME - Doesn't support url(...) colors yet.
     */
    @Nullable
    private Color toColor(IXMLElement elem, String value) throws IOException {
        String str = value;
        if (str == null) {
            return null;
        }

        str = str.trim().toLowerCase();
        if (str.equals("currentcolor")) {
            String currentColor = readInheritAttribute(elem, "color", "black");
            if (currentColor == null || currentColor.trim().toLowerCase().equals("currentColor")) {
                return null;
            } else {
                return toColor(elem, currentColor);
            }
        } else if (SVG_COLORS.containsKey(str)) {
            return SVG_COLORS.get(str);
        } else if (str.startsWith("#") && str.length() == 7) {
            return new Color(Integer.decode(str));
        } else if (str.startsWith("#") && str.length() == 4) {
            // Three digits hex value
            int th = Integer.decode(str);
            return new Color(
                    (th & 0xf) | ((th & 0xf) << 4)
                    | ((th & 0xf0) << 4) | ((th & 0xf0) << 8)
                    | ((th & 0xf00) << 8) | ((th & 0xf00) << 12));
        } else if (str.startsWith("rgb")) {
            try {
                StringTokenizer tt = new StringTokenizer(str, "() ,");
                tt.nextToken();
                String r = tt.nextToken();
                String g = tt.nextToken();
                String b = tt.nextToken();
                Color c = new Color(
                        r.endsWith("%") ? (int) (Integer.decode(r.substring(0, r.length() - 1)) * 2.55) : Integer.decode(r),
                        g.endsWith("%") ? (int) (Integer.decode(g.substring(0, g.length() - 1)) * 2.55) : Integer.decode(g),
                        b.endsWith("%") ? (int) (Integer.decode(b.substring(0, b.length() - 1)) * 2.55) : Integer.decode(b));
                return c;
            } catch (Exception e) {
                if (DEBUG) {
                    System.out.println("SVGInputFormat.toColor illegal RGB value " + str);
                }
                return null;
            }
        } else if (str.startsWith("url")) {
            // FIXME - Implement me
            if (DEBUG) {
                System.out.println("SVGInputFormat.toColor not implemented for " + str);
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * Reads a double attribute.
     */
    private double toDouble(IXMLElement elem, String value) throws IOException {
        return toDouble(elem, value, 0, Double.MIN_VALUE, Double.MAX_VALUE);
    }

    /**
     * Reads a double attribute.
     */
    private double toDouble(IXMLElement elem, String value, double defaultValue, double min, double max) throws IOException {
        try {
            double d = Double.valueOf(value);
            return Math.max(Math.min(d, max), min);
        } catch (NumberFormatException e) {
            return defaultValue;
            /*
            IOException ex = new IOException(elem.getTagName()+"@"+elem.getLineNr()+" "+e.getMessage());
            ex.initCause(e);
            throw ex;*/
        }
    }

    /**
     * Reads a text attribute.
     * This method takes the "xml:space" attribute into account.
     * http://www.w3.org/TR/SVGMobile12/text.html#WhiteSpace
     */
    private String toText(IXMLElement elem, String value) throws IOException {
        String space = readInheritAttribute(elem, "xml:space", "default");
        if (space.equals("default")) {
            return value.trim().replaceAll("\\s++", " ");
        } else /*if (space.equals("preserve"))*/ {
            return value;
        }
    }
    /* Converts an SVG transform attribute value into an AffineTransform
     * as specified in
     * http://www.w3.org/TR/SVGMobile12/coords.html#TransformAttribute
     */

    public static AffineTransform toTransform(IXMLElement elem, String str) throws IOException {
        AffineTransform t = new AffineTransform();

        if (str != null && !str.equals("none")) {

            StreamPosTokenizer tt = new StreamPosTokenizer(new StringReader(str));
            tt.resetSyntax();
            tt.wordChars('a', 'z');
            tt.wordChars('A', 'Z');
            tt.wordChars(128 + 32, 255);
            tt.whitespaceChars(0, ' ');
            tt.whitespaceChars(',', ',');
            tt.parseNumbers();
            tt.parseExponents();

            while (tt.nextToken() != StreamPosTokenizer.TT_EOF) {
                if (tt.ttype != StreamPosTokenizer.TT_WORD) {
                    throw new IOException("Illegal transform " + str);
                }
                String type = tt.sval;
                if (tt.nextToken() != '(') {
                    throw new IOException("'(' not found in transform " + str);
                }
                if (type.equals("matrix")) {
                    double[] m = new double[6];
                    for (int i = 0; i < 6; i++) {
                        if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                            throw new IOException("Matrix value " + i + " not found in transform " + str + " token:" + tt.ttype + " " + tt.sval);
                        }
                        m[i] = tt.nval;
                    }
                    t.concatenate(new AffineTransform(m));

                } else if (type.equals("translate")) {
                    double tx, ty;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("X-translation value not found in transform " + str);
                    }
                    tx = tt.nval;
                    if (tt.nextToken() == StreamPosTokenizer.TT_NUMBER) {
                        ty = tt.nval;
                    } else {
                        tt.pushBack();
                        ty = 0;
                    }
                    t.translate(tx, ty);

                } else if (type.equals("scale")) {
                    double sx, sy;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("X-scale value not found in transform " + str);
                    }
                    sx = tt.nval;
                    if (tt.nextToken() == StreamPosTokenizer.TT_NUMBER) {
                        sy = tt.nval;
                    } else {
                        tt.pushBack();
                        sy = sx;
                    }
                    t.scale(sx, sy);

                } else if (type.equals("rotate")) {
                    double angle, cx, cy;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("Angle value not found in transform " + str);
                    }
                    angle = tt.nval;
                    if (tt.nextToken() == StreamPosTokenizer.TT_NUMBER) {
                        cx = tt.nval;
                        if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                            throw new IOException("Y-center value not found in transform " + str);
                        }
                        cy = tt.nval;
                    } else {
                        tt.pushBack();
                        cx = cy = 0;
                    }
                    t.rotate(angle * Math.PI / 180d, cx, cy);


                } else if (type.equals("skewX")) {
                    double angle;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("Skew angle not found in transform " + str);
                    }
                    angle = tt.nval;
                    t.concatenate(new AffineTransform(
                            1, 0, Math.tan(angle * Math.PI / 180), 1, 0, 0));

                } else if (type.equals("skewY")) {
                    double angle;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("Skew angle not found in transform " + str);
                    }
                    angle = tt.nval;
                    t.concatenate(new AffineTransform(
                            1, Math.tan(angle * Math.PI / 180), 0, 1, 0, 0));

                } else if (type.equals("ref")) {
                    System.err.println("SVGInputFormat warning: ignored ref(...) transform attribute in element " + elem);
                    while (tt.nextToken() != ')' && tt.ttype != StreamPosTokenizer.TT_EOF) {
                        // ignore tokens between brackets
                    }
                    tt.pushBack();
                } else {
                    throw new IOException("Unknown transform " + type + " in " + str + " in element " + elem);
                }
                if (tt.nextToken() != ')') {
                    throw new IOException("')' not found in transform " + str);
                }
            }
        }
        return t;
    }

    @Override
    public javax.swing.filechooser.FileFilter getFileFilter() {
        return new ExtensionFileFilter("Scalable Vector Graphics (SVG)", "svg");
    }

    @Override
    public JComponent getInputFormatAccessory() {
        return null;
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.getPrimaryType().equals("image")
                && flavor.getSubType().equals("svg+xml");
    }

    @Override
    public void read(Transferable t, Drawing drawing, boolean replace) throws UnsupportedFlavorException, IOException {
        InputStream in = (InputStream) t.getTransferData(new DataFlavor("image/svg+xml", "Image SVG"));
        try {
            read(in, drawing, false);
        } finally {
            in.close();
        }
    }
}
