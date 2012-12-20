/*
 * @(#)ODGInputFormat.java
 *
 * Copyright (c) 2007-2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.odg.io;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.gui.filechooser.ExtensionFileFilter;
import org.jhotdraw.draw.io.InputFormat;
import java.awt.datatransfer.*;
import java.awt.geom.*;
import java.io.*;
import java.net.URI;
import java.util.*;
import java.util.zip.*;
import javax.swing.*;
import net.n3.nanoxml.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.geom.BezierPath;
import org.jhotdraw.io.*;
import static org.jhotdraw.samples.odg.ODGConstants.*;
import static org.jhotdraw.samples.odg.ODGAttributeKeys.*;
import org.jhotdraw.samples.odg.figures.*;
import org.jhotdraw.samples.odg.geom.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * ODGInputFormat.
 * This format is aimed to comply to the Open Document Version 1.1 Drawing
 * format.
 * http://docs.oasis-open.org/office/v1.1/OS/OpenDocument-v1.1.pdf
 *
 * @author Werner Randelshofer
 * @version $Id: ODGInputFormat.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class ODGInputFormat implements InputFormat {

    /**
     * Set this to true, to get debug output on System.out.
     */
    private static final boolean DEBUG = true;
    /**
     * Holds the figures that are currently being read.
     */
    private LinkedList<Figure> figures;
    /**
     * Holds the document that is currently being read.
     */
    private IXMLElement document;
    private ODGStylesReader styles;

    /** Creates a new instance. */
    public ODGInputFormat() {
    }

    @Override
    public javax.swing.filechooser.FileFilter getFileFilter() {
        return new ExtensionFileFilter("Open Document Drawing (ODG)", "odg");
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

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.getPrimaryType().equals("application")
                && flavor.getSubType().equals("vnd.oasis.opendocument.graphics");
    }

    @Override
    public void read(Transferable t, Drawing drawing, boolean replace) throws UnsupportedFlavorException, IOException {
        InputStream in = (InputStream) t.getTransferData(new DataFlavor("application/vnd.oasis.opendocument.graphics", "Image SVG"));
        try {
            read(in, drawing, replace);
        } finally {
            in.close();
        }
    }

    /**
     * Reads all bytes from the InputStreams until EOF is reached.
     */
    private byte[] readAllBytes(InputStream in) throws IOException {
        ByteArrayOutputStream tmp = new ByteArrayOutputStream();
        byte[] buf = new byte[512];
        for (int len; -1 != (len = in.read(buf));) {
            tmp.write(buf, 0, len);
        }
        tmp.close();
        return tmp.toByteArray();
    }

    @Override
    public void read(InputStream in, Drawing drawing, boolean replace) throws IOException {
        // Read the file into a byte array.
        byte[] tmp = readAllBytes(in);

        // Input stream of the content.xml file
        InputStream contentIn = null;

        // Input stream of the styles.xml file
        InputStream stylesIn = null;

        // Try to read "tmp" as a ZIP-File.
        boolean isZipped = true;
        try {
            ZipInputStream zin = new ZipInputStream(new ByteArrayInputStream(tmp));
            for (ZipEntry entry; null != (entry = zin.getNextEntry());) {
                if (entry.getName().equals("content.xml")) {
                    contentIn = new ByteArrayInputStream(
                            readAllBytes(zin));
                } else if (entry.getName().equals("styles.xml")) {
                    stylesIn = new ByteArrayInputStream(
                            readAllBytes(zin));
                }
            }

        } catch (ZipException e) {
            isZipped = false;
        }
        if (contentIn == null) {
            contentIn = new ByteArrayInputStream(tmp);
        }
        if (stylesIn == null) {
            stylesIn = new ByteArrayInputStream(tmp);
        }

        styles = new ODGStylesReader();
        styles.read(stylesIn);

        readFiguresFromDocumentContent(contentIn, drawing, replace);
    }

    /**
     * Reads figures from the content.xml file of an ODG open document drawing
     * document.
     */
    @SuppressWarnings("unchecked")
    public void readFiguresFromDocumentContent(InputStream in, Drawing drawing, boolean replace) throws IOException {
        this.figures = new LinkedList<Figure>();
        IXMLParser parser;
        try {
            parser = XMLParserFactory.createDefaultXMLParser();
        } catch (Exception ex) {
            InternalError e = new InternalError("Unable to instantiate NanoXML Parser");
            e.initCause(ex);
            throw e;
        }
        IXMLReader reader = new StdXMLReader(in);
        parser.setReader(reader);
        try {
            document = (IXMLElement) parser.parse();
        } catch (XMLException ex) {
            IOException e = new IOException(ex.getMessage());
            e.initCause(ex);
            throw e;
        }

        if (styles == null) {
            styles = new ODGStylesReader();
        }
        styles.read(document);


        // Search for the first 'office:drawing' element in the XML document
        // in preorder sequence
        IXMLElement drawingElem = document;
        Stack<Iterator> stack = new Stack<Iterator>();
        LinkedList<IXMLElement> ll = new LinkedList<IXMLElement>();
        ll.add(document);
        stack.push(ll.iterator());
        while (!stack.empty() && stack.peek().hasNext()) {
            Iterator<IXMLElement> iter = stack.peek();
            IXMLElement node = iter.next();
            Iterator<IXMLElement> children = node.getChildren().iterator();

            if (!iter.hasNext()) {
                stack.pop();
            }
            if (children.hasNext()) {
                stack.push(children);
            }
            if (node.getName() != null
                    && node.getName().equals("drawing")
                    && (node.getNamespace() == null
                    || node.getNamespace().equals(OFFICE_NAMESPACE))) {
                drawingElem = node;
                break;
            }
        }

        if (drawingElem.getName() == null
                || !drawingElem.getName().equals("drawing")
                || (drawingElem.getNamespace() != null
                && !drawingElem.getNamespace().equals(OFFICE_NAMESPACE))) {
            throw new IOException("'office:drawing' element expected: " + drawingElem.getName());
        }

        readDrawingElement(drawingElem);

        if (replace) {
            drawing.removeAllChildren();
        }
        drawing.addAll(figures);
    }

    /**
     * Reads an ODG "office:drawing" element.
     */
    private void readDrawingElement(IXMLElement elem)
            throws IOException {
        /*
        2.3.2Drawing Documents
        The content of drawing document consists of a sequence of draw pages.
        <define name="office-body-content" combine="choice">
        <element name="office:drawing">
        <ref name="office-drawing-attlist"/>
        <ref name="office-drawing-content-prelude"/>
        <ref name="office-drawing-content-main"/>
        <ref name="office-drawing-content-epilogue"/>
        </element>
        </define>
        <define name="office-drawing-attlist">
        <empty/>
        </define>

        Drawing Document Content Model
        The drawing document prelude may contain text declarations only. To allow office applications to
        implement functionality that usually is available in spreadsheets for drawing documents, it may
        also contain elements that implement enhanced table features. See also section 2.3.4.
        <define name="office-drawing-content-prelude">
        <ref name="text-decls"/>
        <ref name="table-decls"/>
        </define>

        The main document content contains a sequence of draw pages.
        <define name="office-drawing-content-main">
        <zeroOrMore>
        <ref name="draw-page"/>
        </zeroOrMore>
        </define>

        There are no drawing documents specific epilogue elements, but the epilogue may contain
        elements that implement enhanced table features. See also section 2.3.4.
        <define name="office-drawing-content-epilogue">
        <ref name="table-functions"/>
        </define>
         */

        for (IXMLElement child : elem.getChildren()) {
            if (child.getNamespace() == null
                    || child.getNamespace().equals(DRAWING_NAMESPACE)) {
                String name = child.getName();
                if (name.equals("page")) {
                    readPageElement(child);
                }
            }
        }
    }

    /**
     * Reads an ODG "draw:page" element.
     */
    private void readPageElement(IXMLElement elem)
            throws IOException {
        /* 9.1.4Drawing Pages
         *
        The element <draw:page> is a container for content in a drawing or presentation document.
        Drawing pages are used for the following:
        • Forms (see section 11.1)
        • Drawings (see section 9.2)
        • Frames (see section 9.3)
        • Presentation Animations (see section 9.7)
        • Presentation Notes (see section 9.1.5)
         *
        A master page must be assigned to each drawing page.
         *
        <define name="draw-page">
        <element name="draw:page">
        <ref name="common-presentation-header-footer-attlist"/>
        <ref name="draw-page-attlist"/>
        <optional>
        <ref name="office-forms"/>
        </optional>
        <zeroOrMore>
        <ref name="shape"/>
        </zeroOrMore>
        <optional>
        <choice>
        <ref name="presentation-animations"/>
        <ref name="animation-element"/>
        </choice>
        </optional>
        <optional>
        <ref name="presentation-notes"/>
        </optional>
        </element>
        </define>
         *
        The attributes that may be associated with the <draw:page> element are:
        • Page name
        • Page style
        • Master page
        • Presentation page layout
        • Header declaration
        • Footer declaration
        • Date and time declaration
        • ID
         *
        The elements that my be included in the <draw:page> element are:
        • Forms
        • Shapes
        • Animations
        • Presentation notes
         */
        for (IXMLElement child : elem.getChildren()) {
            ODGFigure figure = readElement(child);
            if (figure != null) {
                figures.add(figure);
            }
        }
    }

    /**
     * Reads an ODG element.
     */
    @Nullable
    private ODGFigure readElement(IXMLElement elem)
            throws IOException {
        /*
        Drawing Shapes
        This section describes drawing shapes that might occur within all kind of applications.
        <define name="shape">
        <choice>
        <ref name="draw-rect"/>
        <ref name="draw-line"/>
        <ref name="draw-polyline"/>
        <ref name="draw-polygon"/>
        <ref name="draw-regular-polygon"/>
        <ref name="draw-path"/>
        <ref name="draw-circle"/>
        <ref name="draw-ellipse"/>
        <ref name="draw-g"/>
        <ref name="draw-page-thumbnail"/>
        <ref name="draw-frame"/>
        <ref name="draw-measure"/>
        <ref name="draw-caption"/>
        <ref name="draw-connector"/>
        <ref name="draw-control"/>
        <ref name="dr3d-scene"/>
        <ref name="draw-custom-shape"/>
        </choice>
        </define>
         */
        ODGFigure f = null;
        if (elem.getNamespace() == null
                || elem.getNamespace().equals(DRAWING_NAMESPACE)) {
            String name = elem.getName();
            if (name.equals("caption")) {
                f = readCaptionElement(elem);
            } else if (name.equals("circle")) {
                f = readCircleElement(elem);
            } else if (name.equals("connector")) {
                f = readCircleElement(elem);
            } else if (name.equals("custom-shape")) {
                f = readCustomShapeElement(elem);
            } else if (name.equals("ellipse")) {
                f = readEllipseElement(elem);
            } else if (name.equals("frame")) {
                f = readFrameElement(elem);
            } else if (name.equals("g")) {
                f = readGElement(elem);
            } else if (name.equals("line")) {
                f = readLineElement(elem);
            } else if (name.equals("measure")) {
                f = readMeasureElement(elem);
            } else if (name.equals("path")) {
                f = readPathElement(elem);
            } else if (name.equals("polygon")) {
                f = readPolygonElement(elem);
            } else if (name.equals("polyline")) {
                f = readPolylineElement(elem);
            } else if (name.equals("rect")) {
                f = readRectElement(elem);
            } else if (name.equals("regularPolygon")) {
                f = readRegularPolygonElement(elem);
            } else {
                if (DEBUG) {
                    System.out.println("ODGInputFormat.readElement(" + elem + ") not implemented.");
                }
            }
        }
        if (f != null) {
            if (f.isEmpty()) {
                if (DEBUG) {
                    System.out.println("ODGInputFormat.readElement():null - discarded empty figure " + f);
                }
                return null;
            }
            if (DEBUG) {
                System.out.println("ODGInputFormat.readElement():" + f + ".");
            }
        }
        return f;
    }

    private ODGFigure readEllipseElement(IXMLElement elem)
            throws IOException {
        throw new UnsupportedOperationException("not implemented");
    }

    private ODGFigure readCircleElement(IXMLElement elem)
            throws IOException {
        throw new UnsupportedOperationException("not implemented");
    }

    /** A <draw:custom-shape> represents a shape that is capable of rendering
     * complex figures. It is offering font work and extrusion functiona-
     * lity. A custom shape may have a geometry that influences its shape.
     * This geometry may be visualized in office application user
     * interfaces, for instance by displaying interaction handles, that
     * provide a simple way to modify the geometry.
     */
    private ODGFigure readCustomShapeElement(IXMLElement elem)
            throws IOException {
        String styleName = elem.getAttribute("style-name", DRAWING_NAMESPACE, null);
        Map<AttributeKey, Object> a = styles.getAttributes(styleName, "graphic");

        Rectangle2D.Double figureBounds = new Rectangle2D.Double(
                toLength(elem.getAttribute("x", SVG_NAMESPACE, "0"), 1),
                toLength(elem.getAttribute("y", SVG_NAMESPACE, "0"), 1),
                toLength(elem.getAttribute("width", SVG_NAMESPACE, "0"), 1),
                toLength(elem.getAttribute("height", SVG_NAMESPACE, "0"), 1));

        ODGFigure figure = null;
        for (IXMLElement child : elem.getChildrenNamed("enhanced-geometry", DRAWING_NAMESPACE)) {
            figure = readEnhancedGeometryElement(child, a, figureBounds);
        }

        return figure;
    }

    @Nullable
    private ODGFigure readEnhancedGeometryElement(
            IXMLElement elem,
            Map<AttributeKey, Object> a,
            Rectangle2D.Double figureBounds)
            throws IOException {
        /* The <draw:enhanced-geometry> element contains the geometry for a
         * <draw:custom-shape> element if its draw:engine attribute has been
         * omitted.
         */
        /* The draw:type attribute contains the name of a shape type. This name
         * can be used to offer specialized user interfaces for certain classes
         * of shapes, like for arrows, smileys, etc.
         * The shape type is rendering engine dependent and does not influence
         * the geometry of the shape.
         * If the value of the draw:type attribute is non-primitive, then no
         * shape type is available.
         */
        String type = elem.getAttribute("type", DRAWING_NAMESPACE, "non-primitive");

        EnhancedPath path;
        if (elem.hasAttribute("enhanced-path", DRAWING_NAMESPACE)) {
            path = toEnhancedPath(
                    elem.getAttribute("enhanced-path", DRAWING_NAMESPACE, null));
        } else {
            path = null;
        }

        /* The svg:viewBox attribute establishes a user coordinate system inside
         * the physical coordinate system of the shape specified by the position
         * and size attributes. This user coordinate system is used by the
         * <draw:enhanced-path> element.
         * The syntax for using this attribute is the same as the [SVG] syntax.
         * The value of the attribute are four numbers separated by white
         * spaces, which define the left, top, right, and bottom dimensions
         * of the user coordinate system.
         */
        String[] viewBoxValues = toWSOrCommaSeparatedArray(
                elem.getAttribute("viewBox", DRAWING_NAMESPACE, "0 0 100 100"));
        Rectangle2D.Double viewBox = new Rectangle2D.Double(
                toNumber(viewBoxValues[0]),
                toNumber(viewBoxValues[1]),
                toNumber(viewBoxValues[2]),
                toNumber(viewBoxValues[3]));
        AffineTransform viewTx = new AffineTransform();
        if (!viewBox.isEmpty()) {
            viewTx.scale(figureBounds.width / viewBox.width, figureBounds.height / viewBox.height);
            viewTx.translate(figureBounds.x - viewBox.x, figureBounds.y - viewBox.y);
        }

        /* The draw:mirror-vertical and draw:mirror-horizontal attributes
         * specify if the geometry of the shape is to be mirrored.
         */
        boolean mirrorVertical = elem.getAttribute("mirror-vertical", DRAWING_NAMESPACE, "false").equals("true");
        boolean mirrorHorizontal = elem.getAttribute("mirror-horizontal", DRAWING_NAMESPACE, "false").equals("true");

        // FIXME - Implement Text Rotate Angle
        // FIXME - Implement Extrusion Allowed
        // FIXME - Implement Text Path Allowed
        // FIXME - Implement Concentric Gradient Allowed

        ODGFigure figure;
        if (type.equals("rectangle")) {
            figure = createEnhancedGeometryRectangleFigure(figureBounds, a);
        } else if (type.equals("ellipse")) {
            figure = createEnhancedGeometryEllipseFigure(figureBounds, a);
        } else {
            System.out.println("ODGInputFormat.readEnhancedGeometryElement not implemented for " + elem);
            figure = null;
        }



        return figure;
    }

    /**
     * Creates a Ellipse figure.
     */
    private ODGFigure createEnhancedGeometryEllipseFigure(
            Rectangle2D.Double bounds, Map<AttributeKey, Object> a)
            throws IOException {
        ODGEllipseFigure figure = new ODGEllipseFigure();
        figure.setBounds(bounds);
        figure.setAttributes(a);
        return figure;
    }

    /**
     * Creates a Rect figure.
     */
    private ODGFigure createEnhancedGeometryRectangleFigure(
            Rectangle2D.Double bounds, Map<AttributeKey, Object> a)
            throws IOException {
        ODGRectFigure figure = new ODGRectFigure();
        figure.setBounds(bounds);
        figure.setAttributes(a);
        return figure;
    }

    /**
     * Creates a Line figure.
     */
    private ODGFigure createLineFigure(
            Point2D.Double p1, Point2D.Double p2,
            Map<AttributeKey, Object> a)
            throws IOException {
        ODGPathFigure figure = new ODGPathFigure();
        figure.setBounds(p1, p2);
        figure.setAttributes(a);
        return figure;
    }

    /**
     * Creates a Polyline figure.
     */
    private ODGFigure createPolylineFigure(
            Point2D.Double[] points,
            Map<AttributeKey, Object> a)
            throws IOException {
        ODGPathFigure figure = new ODGPathFigure();
        ODGBezierFigure bezier = new ODGBezierFigure();
        for (Point2D.Double p : points) {
            bezier.addNode(new BezierPath.Node(p.x, p.y));
        }
        figure.removeAllChildren();
        figure.add(bezier);
        figure.setAttributes(a);
        return figure;
    }

    /**
     * Creates a Polygon figure.
     */
    private ODGFigure createPolygonFigure(
            Point2D.Double[] points,
            Map<AttributeKey, Object> a)
            throws IOException {
        ODGPathFigure figure = new ODGPathFigure();
        ODGBezierFigure bezier = new ODGBezierFigure();
        for (Point2D.Double p : points) {
            bezier.addNode(new BezierPath.Node(p.x, p.y));
        }
        bezier.setClosed(true);
        figure.removeAllChildren();
        figure.add(bezier);
        figure.setAttributes(a);
        return figure;
    }

    /**
     * Creates a Path figure.
     */
    private ODGFigure createPathFigure(
            BezierPath[] paths,
            Map<AttributeKey, Object> a)
            throws IOException {
        ODGPathFigure figure = new ODGPathFigure();
        figure.removeAllChildren();
        for (BezierPath p : paths) {
            ODGBezierFigure bezier = new ODGBezierFigure();
            bezier.setBezierPath(p);
            figure.add(bezier);
        }
        figure.setAttributes(a);
        return figure;
    }

    /**
     * Reads a &lt;draw:frame&gt; element from the specified
     * XML element.
     * <p>
     * A frame is a rectangular container where that contains enhanced content
     * like text boxes, images or objects. Frames are very similar to regular
     * drawing shapes, but support some features that are not available for
     * regular drawing shapes, like contours, image maps and hyperlinks. In
     * particular, a frame allows to have multiple renditions of an object. That
     * is, a frame may for instance contain an object as well as an image. In
     * this case, the application may choose the content that it supports best.
     * If the application supports the object type contained in the frame, it
     * probably will render the object. If it does not support the object, it
     * will render the image.
     * <p>
     * In general, an application must not render more than one of the content
     * elements contained in a frame. The order of content elements dictates
     * the document author's preference for rendering, with the first child
     * being the most preferred. This means that applications should render the
     * first child element that it supports. A frame must contain at least one
     * content element. The inclusion of multiple content elements is optional.
     * Application may preserve the content elements they don't render, but
     * don't have to.
     * <p>
     * Within text documents, frames are also used to position content outside
     * the default text flow of a document.
     * <p>
     * Frames can contain:
     * • Text boxes
     * • Objects represented either in the OpenDocument format or in a object
     *      specific binary format
     * • Images
     * • Applets
     * • Plug-ins
     * • Floating frames
     * <p>
     * Like the formatting properties of drawing shapes, frame formatting
     * properties are stored in styles belonging to the graphic family. The way
     * a frame is contained in a document also is the same as for drawing shapes.
     *
     *
     * @param elem A &lt;frame&gt; element.
     */
    private ODGFigure readFrameElement(IXMLElement elem) throws IOException {
        throw new UnsupportedOperationException("not implemented.");
    }

    /**
     * Creates a ODGGroupFigure.
     */
    private CompositeFigure createGroupFigure()
            throws IOException {
        ODGGroupFigure figure = new ODGGroupFigure();
        return figure;
    }

    private ODGFigure readGElement(IXMLElement elem)
            throws IOException {
        CompositeFigure g = createGroupFigure();

        for (IXMLElement child : elem.getChildren()) {
            Figure childFigure = readElement(child);
            if (childFigure != null) {
                g.basicAdd(childFigure);
            }
        }
        /*
        readTransformAttribute(elem, a);
        if (TRANSFORM.get(a) != null) {
        g.transform(TRANSFORM.get(a));
        }*/
        return (ODGFigure) g;
    }

    /**
     * The &lt;draw:line&gt; element represents a line.
     * <p>
     * The attributes that may be associated with the &lt;draw:line&gt; element
     * are:
     * • Style, Layer, Z-Index, ID, Caption ID and Transformation – see section
     * 9.2.15.
     * • Text anchor, table background, draw end position– see section 9.2.16.
     * • Start point
     * • End point
     * <p>
     * The elements that may be contained in the &lt;draw:line&gt; element are:
     * • Title (short accessible name) – see section 9.2.20.
     * • Long description (in support of accessibility) – see section 9.2.20.
     * • Event listeners – see section 9.2.21.
     * • Glue points – see section 9.2.19.
     * • Text – see section 9.2.17.
     */
    private ODGFigure readLineElement(IXMLElement elem)
            throws IOException {
        Point2D.Double p1 = new Point2D.Double(
                toLength(elem.getAttribute("x1", SVG_NAMESPACE, "0"), 1),
                toLength(elem.getAttribute("y1", SVG_NAMESPACE, "0"), 1));
        Point2D.Double p2 = new Point2D.Double(
                toLength(elem.getAttribute("x2", SVG_NAMESPACE, "0"), 1),
                toLength(elem.getAttribute("y2", SVG_NAMESPACE, "0"), 1));

        String styleName = elem.getAttribute("style-name", DRAWING_NAMESPACE, null);
        Map<AttributeKey, Object> a = styles.getAttributes(styleName, "graphic");

        ODGFigure f = createLineFigure(p1, p2, a);

        return f;
    }

    private ODGFigure readPathElement(IXMLElement elem)
            throws IOException {
        AffineTransform viewBoxTransform = readViewBoxTransform(elem);

        BezierPath[] paths = toPath(elem.getAttribute("d", SVG_NAMESPACE, null));
        for (BezierPath p : paths) {
            p.transform(viewBoxTransform);
        }
        String styleName = elem.getAttribute("style-name", DRAWING_NAMESPACE, null);

        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        a.putAll(styles.getAttributes(styleName, "graphic"));
        readCommonDrawingShapeAttributes(elem, a);

        ODGFigure f = createPathFigure(paths, a);
        return f;
    }

    /**
     * The &lt;draw:polygon&gt; element represents a polygon. A polygon is a
     * closed put of straight lines.
     * Some implementations may ignore the size attribute, and instead determine
     * the size of a shape exclusively from the shape data (i.e., polygon vertices).
     * <p>
     * The attributes that may be associated with the &lt;draw:polygon&gt; element
     * are:
     * • Position, Size, View box, Style, Layer, Z-Index, ID, Caption ID and
     * Transformation – see section 9.2.15
     * • Text anchor, table background, draw end position – see section 9.2.16
     * • Points – see section 9.2.3
     * The elements that may be contained in the &lt;draw:polygon&gt; element are:
     * • Title (short accessible name) – see section 9.2.20.
     * • Long description (in support of accessibility) – see section 9.2.20.
     * • Event listeners – see section 9.2.21.
     * • Glue points – see section 9.2.19.
     * • Text – see section 9.2.17.
     *
     */
    private ODGFigure readPolygonElement(IXMLElement elem)
            throws IOException {
        AffineTransform viewBoxTransform = readViewBoxTransform(elem);

        String[] coords = toWSOrCommaSeparatedArray(elem.getAttribute("points", DRAWING_NAMESPACE, null));
        Point2D.Double[] points = new Point2D.Double[coords.length / 2];
        for (int i = 0; i < coords.length; i += 2) {
            Point2D.Double p = new Point2D.Double(toNumber(coords[i]), toNumber(coords[i + 1]));
            points[i / 2] = (Point2D.Double) viewBoxTransform.transform(p, p);
        }
        String styleName = elem.getAttribute("style-name", DRAWING_NAMESPACE, null);

        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        a.putAll(styles.getAttributes(styleName, "graphic"));
        readCommonDrawingShapeAttributes(elem, a);

        ODGFigure f = createPolygonFigure(points, a);
        return f;
    }

    /**
     * The &lt;draw:polyline&gt; element represents a polyline drawing shape.
     * Some implementations may ignore the size attribute, and instead determine the size of a shape
     * exclusively from the shape data (i.e., polygon vertices).
     * <p>
     * The attributes that may be associated with the &lt;draw:polyline&gt;
     * element are:
     * • Position, Size, View box, Style, Layer, Z-Index, ID, Caption ID and Transformation – see
     * section 9.2.15
     * • Text anchor, table background, draw end position – see section 9.2.16
     * • Points
     * The elements that may be contained in the &lt;draw:polyline&gt; element are:
     * • Title (short accessible name) – see section 9.2.20.
     * • Long description (in support of accessibility) – see section 9.2.20.
     * • Event listeners – see section 9.2.21.
     * • Glue points – see section 9.2.19.
     * • Text – see section 9.2.17.
     */
    private ODGFigure readPolylineElement(IXMLElement elem)
            throws IOException {
        AffineTransform viewBoxTransform = readViewBoxTransform(elem);

        String[] coords = toWSOrCommaSeparatedArray(elem.getAttribute("points", DRAWING_NAMESPACE, null));
        Point2D.Double[] points = new Point2D.Double[coords.length / 2];
        for (int i = 0; i < coords.length; i += 2) {
            Point2D.Double p = new Point2D.Double(toNumber(coords[i]), toNumber(coords[i + 1]));
            points[i / 2] = (Point2D.Double) viewBoxTransform.transform(p, p);
        }
        String styleName = elem.getAttribute("style-name", DRAWING_NAMESPACE, null);

        HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
        a.putAll(styles.getAttributes(styleName, "graphic"));
        readCommonDrawingShapeAttributes(elem, a);

        ODGFigure f = createPolylineFigure(points, a);
        return f;
    }

    private ODGFigure readRectElement(IXMLElement elem)
            throws IOException {
        throw new UnsupportedOperationException("ODGInputFormat.readRectElement(" + elem + "):null - not implemented");
    }

    private ODGFigure readRegularPolygonElement(IXMLElement elem)
            throws IOException {
        throw new UnsupportedOperationException("ODGInputFormat.readRegularPolygonElement(" + elem + "):null - not implemented");
    }

    private ODGFigure readMeasureElement(IXMLElement elem)
            throws IOException {
        throw new UnsupportedOperationException("ODGInputFormat.readMeasureElement(" + elem + "):null - not implemented");
    }

    private ODGFigure readCaptionElement(IXMLElement elem)
            throws IOException {
        throw new UnsupportedOperationException("ODGInputFormat.readCaptureElement(" + elem + "):null - not implemented");
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
     * Returns a value as a number.
     * http://www.w3.org/TR/SVGMobile12/types.html#DataTypeNumber
     */
    private double toNumber(String str) throws IOException {
        return toLength(str, 100);
    }

    /**
     * Returns a value as a length.
     * http://www.w3.org/TR/SVGMobile12/types.html#DataTypeLength
     */
    private double toLength(String str, double percentFactor) throws IOException {
        double scaleFactor = 1d;
        if (str == null || str.length() == 0) {
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
        } else {
            scaleFactor = 1d;
        }

        return Double.parseDouble(str) * scaleFactor;
    }

    private static double toUnitFactor(String str) throws IOException {
        double scaleFactor;
        if (str.equals("px")) {
            scaleFactor = 1d;
        } else if (str.endsWith("pt")) {
            scaleFactor = 1.25;
        } else if (str.endsWith("pc")) {
            scaleFactor = 15;
        } else if (str.endsWith("mm")) {
            scaleFactor = 3.543307;
        } else if (str.endsWith("cm")) {
            scaleFactor = 35.43307;
        } else if (str.endsWith("in")) {
            scaleFactor = 90;
        } else {
            scaleFactor = 1d;
        }
        return scaleFactor;
    }

    /**
     * Returns a value as a EnhancedPath array.
     *
     * The draw:enhanced-path attribute specifies a path similar to the svg:d attribute of the
     * <svg:path> element. Instructions such as moveto, lineto, arcto and other instructions
     * together with its parameter are describing the geometry of a shape which can be filled and or
     * stroked. Relative commands are not supported.
     * The syntax of draw:enhanced-path attribute is as follows:
     * • Instructions are expressed as one character (e.g., a moveto is expressed as an M).
     * • A prefix notation is being used, that means that each command is followed by its parameter.
     * • Superfluous white space and separators such as commas can be eliminated. (e.g., “M 10 10
     * L 20 20 L 30 20” can also be written: “M10 10L20 20L30 20”
     * • If the command is repeated multiple times, only the first command is required. (e.g., “M 10 10
     * L 20 20 L 30 20” can also be expressed as followed “M 10 10 L 20 20 30 20”
     * • Floats can be used, therefore the only allowable decimal point is a dot (“.”)
     * The above mentioned rules are the same as specified for the <svg:path> element.
     * A parameter can also have one of the following enhancements:
     * • A “?” is used to mark the beginning of a formula name. The result of the element's
     * draw:formula attribute is used as parameter value in this case.
     * • If “$” is preceding a integer value, the value is indexing a draw:modifiers attribute. The
     * corresponding modifier value is used as parameter value then.
     *
     */
    private EnhancedPath toEnhancedPath(String str) throws IOException {
        if (DEBUG) {
            System.out.println("ODGInputFormat toEnhancedPath " + str);
        }
        EnhancedPath path = null;

        Object x, y;
        Object x1, y1, x2, y2, x3, y3;

        StreamPosTokenizer tt = new StreamPosTokenizer(new StringReader(str));
        tt.resetSyntax();
        tt.parseNumbers();
        tt.parseExponents();
        tt.parsePlusAsNumber();
        tt.whitespaceChars(0, ' ');
        tt.whitespaceChars(',', ',');


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
            nextCommand = command;

            switch (command) {
                case 'M':
                    // moveto (x y)+
                    // Start a new sub-path at the given (x,y)
                    // coordinate. If a moveto is followed by multiple
                    // pairs of coordinates, they are treated as lineto.
                    if (path == null) {
                        path = new EnhancedPath();
                    }
                    // path.setFilled(isFilled);
                    //path.setStroked(isStroked);
                    x = nextEnhancedCoordinate(tt, str);
                    y = nextEnhancedCoordinate(tt, str);
                    path.moveTo(x, y);
                    nextCommand = 'L';
                    break;

                case 'L':
                    // lineto (x y)+
                    // Draws a line from the current point to (x, y). If
                    // multiple coordinate pairs are following, they
                    // are all interpreted as lineto.

                    x = nextEnhancedCoordinate(tt, str);
                    y = nextEnhancedCoordinate(tt, str);
                    path.lineTo(x, y);
                    break;

                case 'C':
                    // curveto (x1 y1 x2 y2 x y)+
                    // Draws a cubic Bézier curve from the current
                    // point to (x,y) using (x1,y1) as the control point
                    // at the beginning of the curve and (x2,y2) as
                    // the control point at the end of the curve.

                    x1 = nextEnhancedCoordinate(tt, str);
                    y1 = nextEnhancedCoordinate(tt, str);
                    x2 = nextEnhancedCoordinate(tt, str);
                    y2 = nextEnhancedCoordinate(tt, str);
                    x = nextEnhancedCoordinate(tt, str);
                    y = nextEnhancedCoordinate(tt, str);
                    path.curveTo(x1, y1, x2, y2, x, y);
                    break;

                case 'Z':
                    // closepath
                    // Close the current sub-path by drawing a
                    // straight line from the current point to current
                    // sub-path's initial point.
                    path.close();
                    break;

                case 'N':
                    // endpath
                    // Ends the current put of sub-paths. The sub-
                    // paths will be filled by using the “even-odd”
                    // filling rule. Other following subpaths will be
                    // filled independently.
                    break;

                case 'F':
                    // nofill
                    // Specifies that the current put of sub-paths
                    // won't be filled.
                    break;

                case 'S':
                    // nostroke
                    // Specifies that the current put of sub-paths
                    // won't be stroked.
                    break;

                case 'T':
                    // angle-ellipseto (x y w h t0 t1) +
                    // Draws a segment of an ellipse. The ellipse is specified
                    // by the center(x, y), the size(w, h) and the start-angle
                    // t0 and end-angle t1.
                    x = nextEnhancedCoordinate(tt, str);
                    y = nextEnhancedCoordinate(tt, str);
                    x1 = nextEnhancedCoordinate(tt, str);
                    y1 = nextEnhancedCoordinate(tt, str);
                    x2 = nextEnhancedCoordinate(tt, str);
                    y2 = nextEnhancedCoordinate(tt, str);
                    path.ellipseTo(x, y, x1, y1, x2, y2);
                    break;

                case 'U':
                    // angle-ellipse (x y w h t0 t1) +
                    // The same as the “T” command, except that a implied moveto
                    // to the starting point is done.
                    x = nextEnhancedCoordinate(tt, str);
                    y = nextEnhancedCoordinate(tt, str);
                    x1 = nextEnhancedCoordinate(tt, str);
                    y1 = nextEnhancedCoordinate(tt, str);
                    x2 = nextEnhancedCoordinate(tt, str);
                    y2 = nextEnhancedCoordinate(tt, str);
                    path.moveTo(x1, y1);
                    path.ellipseTo(x, y, x1, y1, x2, y2);
                    break;

                case 'A':
                    // arcto (x1 y1 x2 y2 x3 y3 x y) +
                    // (x1, y1) and (x2, y2) is defining the bounding
                    // box of a ellipse. A line is then drawn from the
                    // current point to the start angle of the arc that is
                    // specified by the radial vector of point (x3, y3)
                    // and then counter clockwise to the end-angle
                    // that is specified by point (x4, y4).
                    x1 = nextEnhancedCoordinate(tt, str);
                    y1 = nextEnhancedCoordinate(tt, str);
                    x2 = nextEnhancedCoordinate(tt, str);
                    y2 = nextEnhancedCoordinate(tt, str);
                    x3 = nextEnhancedCoordinate(tt, str);
                    y3 = nextEnhancedCoordinate(tt, str);
                    x = nextEnhancedCoordinate(tt, str);
                    y = nextEnhancedCoordinate(tt, str);
                    path.arcTo(x1, y1, x2, y2, x3, y3, x, y);
                    break;

                case 'B':
                    // arc (x1 y1 x2 y2 x3 y3 x y) +
                    // The same as the “A” command, except that a
                    // implied moveto to the starting point is done.
                    x1 = nextEnhancedCoordinate(tt, str);
                    y1 = nextEnhancedCoordinate(tt, str);
                    x2 = nextEnhancedCoordinate(tt, str);
                    y2 = nextEnhancedCoordinate(tt, str);
                    x3 = nextEnhancedCoordinate(tt, str);
                    y3 = nextEnhancedCoordinate(tt, str);
                    x = nextEnhancedCoordinate(tt, str);
                    y = nextEnhancedCoordinate(tt, str);
                    path.moveTo(x1, y1);
                    path.arcTo(x1, y1, x2, y2, x3, y3, x, y);
                    break;
                case 'W':
                    // clockwisearcto (x1 y1 x2 y2 x3 y3 x y) +
                    // The same as the “A” command except, that the arc is drawn
                    // clockwise.
                    x1 = nextEnhancedCoordinate(tt, str);
                    y1 = nextEnhancedCoordinate(tt, str);
                    x2 = nextEnhancedCoordinate(tt, str);
                    y2 = nextEnhancedCoordinate(tt, str);
                    x3 = nextEnhancedCoordinate(tt, str);
                    y3 = nextEnhancedCoordinate(tt, str);
                    x = nextEnhancedCoordinate(tt, str);
                    y = nextEnhancedCoordinate(tt, str);
                    path.clockwiseArcTo(x1, y1, x2, y2, x3, y3, x, y);
                    break;
                case 'V':
                    // clockwisearc (x1 y1 x2 y2 x3 y3 x y)+
                    // The same as the “A” command, except that a implied moveto
                    // to the starting point is done and the arc is drawn
                    // clockwise.
                    x1 = nextEnhancedCoordinate(tt, str);
                    y1 = nextEnhancedCoordinate(tt, str);
                    x2 = nextEnhancedCoordinate(tt, str);
                    y2 = nextEnhancedCoordinate(tt, str);
                    x3 = nextEnhancedCoordinate(tt, str);
                    y3 = nextEnhancedCoordinate(tt, str);
                    x = nextEnhancedCoordinate(tt, str);
                    y = nextEnhancedCoordinate(tt, str);
                    path.moveTo(x1, y1);
                    path.clockwiseArcTo(x1, y1, x2, y2, x3, y3, x, y);
                    break;
                case 'X':
                    // elliptical-quadrantx (x y) +
                    // Draws a quarter ellipse, whose initial segment is
                    // tangential to the x-axis, is drawn from the
                    // current point to (x, y).
                    x = nextEnhancedCoordinate(tt, str);
                    y = nextEnhancedCoordinate(tt, str);
                    path.quadrantXTo(x, y);
                    break;
                case 'Y':
                    // elliptical-quadranty (x y) +
                    // Draws a quarter ellipse, whose initial segment is
                    // tangential to the y-axis, is drawn from the
                    // current point to(x, y).
                    x = nextEnhancedCoordinate(tt, str);
                    y = nextEnhancedCoordinate(tt, str);
                    path.quadrantYTo(x, y);
                    break;
                case 'Q':
                    // quadratic-curveto(x1 y1 x y)+
                    // Draws a quadratic Bézier curve from the current point
                    // to(x, y) using(x1, y1) as the control point. (x, y)
                    // becomes the new current point at the end of the command.
                    x1 = nextEnhancedCoordinate(tt, str);
                    y1 = nextEnhancedCoordinate(tt, str);
                    x = nextEnhancedCoordinate(tt, str);
                    y = nextEnhancedCoordinate(tt, str);
                    path.quadTo(x1, y1, x, y);
                    break;
                default:
                    if (DEBUG) {
                        System.out.println("ODGInputFormat.toEnhancedPath aborting after illegal path command: " + command + " found in path " + str);
                    }
                    break Commands;
                //throw new IOException("Illegal command: "+command);
            }
        }
        return path;
    }

    /**
     * Retrieves an enhanced coordinate from the specified tokenizer.
     * An enhanced coordinate can be a double, or a '?' followed by a
     * formula name, or a '$' followed by an index to a modifier.
     */
    private Object nextEnhancedCoordinate(StreamPosTokenizer tt, String str) throws IOException {
        switch (tt.nextToken()) {
            case '?': {
                StringBuilder buf = new StringBuilder();
                buf.append('?');
                int ch = tt.nextChar();
                for (; ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9';
                        ch = tt.nextChar()) {
                    buf.append((char) ch);
                }
                tt.pushCharBack(ch);
                return buf.toString();
            }
            case '$': {
                StringBuilder buf = new StringBuilder();
                buf.append('$');
                int ch = tt.nextChar();
                for (; ch >= '0' && ch <= '9';
                        ch = tt.nextChar()) {
                    buf.append((char) ch);
                }
                tt.pushCharBack(ch);
                return buf.toString();
            }
            case StreamPosTokenizer.TT_NUMBER:
                return tt.nval;
            default:
                throw new IOException("coordinate missing at position" + tt.getStartPosition() + " in " + str);
        }
    }

    private void readCommonDrawingShapeAttributes(IXMLElement elem, HashMap<AttributeKey, Object> a) throws IOException {
        // The attribute draw:name assigns a name to the drawing shape.
        NAME.put(a, elem.getAttribute("name", DRAWING_NAMESPACE, null));

        // The draw:transform attribute specifies a list of transformations that
        // can be applied to a drawing shape.
        TRANSFORM.put(a, toTransform(elem.getAttribute("transform", DRAWING_NAMESPACE, null)));
    }

    private AffineTransform readViewBoxTransform(IXMLElement elem) throws IOException {
        AffineTransform tx = new AffineTransform();
        Rectangle2D.Double figureBounds = new Rectangle2D.Double(
                toLength(elem.getAttribute("x", SVG_NAMESPACE, "0"), 1),
                toLength(elem.getAttribute("y", SVG_NAMESPACE, "0"), 1),
                toLength(elem.getAttribute("width", SVG_NAMESPACE, "0"), 1),
                toLength(elem.getAttribute("height", SVG_NAMESPACE, "0"), 1));

        tx.translate(figureBounds.x, figureBounds.y);

        // The svg:viewBox attribute establishes a user coordinate system inside the physical coordinate
        // system of the shape specified by the position and size attributes. This user coordinate system is
        // used by the svg:points attribute and the <draw:path> element.
        // The syntax for using this attribute is the same as the [SVG] syntax. The value of the attribute are
        // four numbers separated by white spaces, which define the left, top, right, and bottom dimensions
        // of the user coordinate system.
        // Some implementations may ignore the view box attribute. The implied coordinate system then has
        // its origin at the left, top corner of the shape, without any scaling relative to the shape.
        String[] viewBoxValues = toWSOrCommaSeparatedArray(elem.getAttribute("viewBox", SVG_NAMESPACE, null));
        if (viewBoxValues.length == 4) {
            Rectangle2D.Double viewBox = new Rectangle2D.Double(
                    toNumber(viewBoxValues[0]),
                    toNumber(viewBoxValues[1]),
                    toNumber(viewBoxValues[2]),
                    toNumber(viewBoxValues[3]));
            if (!viewBox.isEmpty() && !figureBounds.isEmpty()) {
                tx.scale(figureBounds.width / viewBox.width,
                        figureBounds.height / viewBox.height);
                tx.translate(-viewBox.x, -viewBox.y);
            }
        }

        return tx;
    }

    /** Converts an ODG draw:transform attribute value into an AffineTransform.
     * <p>
     * The draw:transform attribute specifies a list of transformations that can be applied to a
     * drawing shape.
     * The value of this attribute is a list of transform definitions, which are applied to the drawing shape
     * in the order in which they are listed. The transform definitions in the list must be separated by a
     * white space and/or a comma. The types of transform definitions available include:
     * • matrix(<a> <b> <c> <d> <e> <f>), which specifies a transformation in the form of a
     * transformation matrix of six values. matrix(a,b,c,d,e,f) is the equivalent of applying the
     * transformation matrix [a b c d e f].
     * • translate(<tx> [<ty>]), which specifies a translation by tx and ty.
     * • scale(<sx> [<sy>]), which specifies a scale operation by sx and sy. If <sy> is not
     * provided, it is assumed to be equal to <sx>.
     * • rotate(<rotate-angle>), which specifies a rotation by <rotate-angle> about the
     * origin of the shapes coordinate system.
     * • skewX(<skew-angle>), which specifies a skew transformation along the X axis.
     * • skewY(<skew-angle>), which specifies a skew transformation along the Y axis.
     */
    public static AffineTransform toTransform(String str) throws IOException {
        AffineTransform t = new AffineTransform();
        AffineTransform t2 = new AffineTransform();

        if (str != null) {

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
                    t.preConcatenate(new AffineTransform(m));

                } else if (type.equals("translate")) {
                    double tx, ty;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("X-translation value not found in transform " + str);
                    }
                    tx = tt.nval;
                    if (tt.nextToken() == StreamPosTokenizer.TT_WORD) {
                        tx *= toUnitFactor(tt.sval);
                    } else {
                        tt.pushBack();
                    }

                    if (tt.nextToken() == StreamPosTokenizer.TT_NUMBER) {
                        ty = tt.nval;
                        if (tt.nextToken() == StreamPosTokenizer.TT_WORD) {
                            ty *= toUnitFactor(tt.sval);
                        } else {
                            tt.pushBack();
                        }
                    } else {
                        tt.pushBack();
                        ty = 0;
                    }
                    t2.setToIdentity();
                    t2.translate(tx, ty);
                    t.preConcatenate(t2);

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
                    t2.setToIdentity();
                    t2.scale(sx, sy);
                    t.preConcatenate(t2);

                } else if (type.equals("rotate")) {
                    double angle, cx, cy;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("Angle value not found in transform " + str);
                    }
                    angle = tt.nval;
                    t2.setToIdentity();
                    t2.rotate(-angle);
                    t.preConcatenate(t2);


                } else if (type.equals("skewX")) {
                    double angle;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("Skew angle not found in transform " + str);
                    }
                    angle = tt.nval;
                    t.preConcatenate(new AffineTransform(
                            1, 0, Math.tan(angle * Math.PI / 180), 1, 0, 0));

                } else if (type.equals("skewY")) {
                    double angle;
                    if (tt.nextToken() != StreamPosTokenizer.TT_NUMBER) {
                        throw new IOException("Skew angle not found in transform " + str);
                    }
                    angle = tt.nval;
                    t.preConcatenate(new AffineTransform(
                            1, Math.tan(angle * Math.PI / 180), 0, 1, 0, 0));

                } else {
                    throw new IOException("Unknown transform " + type + " in " + str);
                }
                if (tt.nextToken() != ')') {
                    throw new IOException("')' not found in transform " + str);
                }
            }
        }
        return t;
    }

    /**
     * Returns a value as a BezierPath array.
     * as specified in http://www.w3.org/TR/SVGMobile12/shapes.html#PointsBNF
     *
     * Also supports elliptical arc commands 'a' and 'A' as specified in
     * http://www.w3.org/TR/SVG/paths.html#PathDataEllipticalArcCommands
     */
    private BezierPath[] toPath(String str) throws IOException {
        LinkedList<BezierPath> paths = new LinkedList<BezierPath>();

        BezierPath path = null;
        Point2D.Double p = new Point2D.Double();
        Point2D.Double c1 = new Point2D.Double();
        Point2D.Double c2 = new Point2D.Double();

        StreamPosTokenizer tt = new StreamPosTokenizer(new StringReader(str));
        tt.resetSyntax();
        tt.parseNumbers();
        tt.parseExponents();
        tt.parsePlusAsNumber();
        tt.whitespaceChars(0, ' ');
        tt.whitespaceChars(',', ',');


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
}
