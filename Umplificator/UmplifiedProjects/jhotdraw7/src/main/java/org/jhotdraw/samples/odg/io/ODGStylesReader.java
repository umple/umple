/*
 * @(#)ODGStylesReader.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.odg.io;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.Color;
import java.io.*;
import java.util.*;
import java.util.HashMap;
import net.n3.nanoxml.*;
import org.jhotdraw.draw.*;
import static org.jhotdraw.samples.odg.ODGConstants.*;
import static org.jhotdraw.samples.odg.ODGAttributeKeys.*;

/**
 * ODGStylesReader reads an ODG &lt;document-styles&gt; element,
 * and creates a map of AttributeKey's and values.
 *
 *
 * @author Werner Randelshofer
 * @version $Id: ODGStylesReader.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class ODGStylesReader {

    private final static boolean DEBUG = false;

    private static class Style extends HashMap<AttributeKey, Object> {

        public String name;
        public String family;
        public String parentName;
    }
    /**
     * Most office applications support styles within their user interface.
     * Within this specification, the XML representations of such styles are
     * referred to as styles. When a differentiation from the other types of
     * styles is required, they are referred to as common styles.
     * The term common indicates that this is the type of style that an office
     * application user considers to be a style.
     */
    private HashMap<String, Style> commonStyles;
    /**
     * A master style is a common style that contains formatting information and
     * additional content that is displayed with the document content when the
     * style is applied. An example of a master style are master pages. Master
     * pages can be used in graphical applications. In this case, the additional
     * content is any drawing shapes that are displayed as the background of the
     * draw page. Master pages can also be used in text documents. In this case,
     * the additional content is the headers and footers. Please note that the
     * content that is contained within master styles is additional content that
     * influences the representation of a document but does not change the
     * content of a document.
     */
    private HashMap<String, Style> masterStyles;
    /**
     * An automatic style contains formatting properties that, in the user
     * interface view of a document, are assigned to an object such as a
     * paragraph. The term automatic indicates that the style is generated
     * automatically. In other words, formatting properties that are immediately
     * assigned to a specific object are represented by an automatic style. This
     * way, a separation of content and layout is achieved.
     */
    private HashMap<String, Style> automaticStyles;

    /** Creates a new instance. */
    public ODGStylesReader() {
        reset();
    }

    public Map<AttributeKey, Object> getAttributes(String styleName, String familyName) {
        //String key = familyName+"-"+styleName;
        String key = styleName;
        Style style;
        if (commonStyles.containsKey(key)) {
            style = commonStyles.get(key);
        } else if (automaticStyles.containsKey(key)) {
            style = automaticStyles.get(key);
        } else if (masterStyles.containsKey(key)) {
            style = masterStyles.get(key);
        } else {
            style = new Style();
        }
        if (style.parentName == null) {
            return style;
        } else {
            HashMap<AttributeKey, Object> a = new HashMap<AttributeKey, Object>();
            Map<AttributeKey, Object> parentAttributes = getAttributes(style.parentName, familyName);
            a.putAll(parentAttributes);
            a.putAll(style);
            return a;
        }
    }

    /**
     * Reads a &lt;document-styles&gt; element from the specified
     * XML file.
     *
     *
     * @param file A XML file with a &lt;document&gt; root element
     * or with a &lt;document-styles&gt; root element.
     */
    public void read(File file) throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
        try {
            read(in);
        } finally {
            in.close();
        }
    }

    /**
     * Reads a &lt;document-styles&gt; element from the specified
     * input stream.
     *
     *
     * @param in A input stream with a &lt;document&gt; root element
     * or with a &lt;document-styles&gt; root element.
     */
    public void read(InputStream in) throws IOException {
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
        IXMLElement document;
        try {
            document = (IXMLElement) parser.parse();
        } catch (XMLException ex) {
            IOException e = new IOException(ex.getMessage());
            e.initCause(ex);
            throw e;
        }
        read(document);
    }

    private void reset() {
        commonStyles = new HashMap<String, Style>();
        automaticStyles = new HashMap<String, Style>();
        masterStyles = new HashMap<String, Style>();
    }

    /**
     * Reads a &lt;document-styles&gt; element from the specified
     * XML element.
     *
     *
     * @param root A &lt;document&gt; element or a
     * &lt;document-styles&gt; element.
     */
    public void read(IXMLElement root) throws IOException {
        String name = root.getName();
        String ns = root.getNamespace();
        if (name.equals("document-content") && (ns == null || ns.equals(OFFICE_NAMESPACE))) {
            readDocumentContentElement(root);
        } else if (name.equals("document-styles") && (ns == null || ns.equals(OFFICE_NAMESPACE))) {
            readDocumentStylesElement(root);
        } else {
            if (DEBUG) {
                System.out.println("ODGStylesReader unsupported root element " + root);
            }
        }
    }

    /**
     * Reads a &lt;default-style&gt; element from the specified
     * XML element.
     * <p>
     * A default style specifies default formatting properties for a certain
     * style family. These defaults are used if a formatting property is neither
     * specified by an automatic nor a common style. Default styles exist for
     * all style families that are represented by the &lt;style:style&gt;
     * element specified in section 14.1.
     * Default styles are represented by the &lt;style:default-style&gt;
     * element. The only attribute supported by this element is style:family.
     * Its meaning equals the one of the same attribute for the
     * &lt;style:style&gt; element, and the same properties child elements are
     * supported depending on the style family.
     *
     * @param elem A &lt;default-style&gt; element.
     * @param styles Style attributes to be filled in by this method.
     */
    private void readDefaultStyleElement(IXMLElement elem, HashMap<String, Style> styles) throws IOException {
        String styleName = elem.getAttribute("family", STYLE_NAMESPACE, null);
        String family = elem.getAttribute("family", STYLE_NAMESPACE, null);
        String parentStyleName = elem.getAttribute("parent-style-name", STYLE_NAMESPACE, null);
        if (DEBUG) {
            System.out.println("ODGStylesReader <default-style family=" + styleName + " ...>...</>");
        }
        if (styleName != null) {
            Style a = styles.get(styleName);
            if (a == null) {
                a = new Style();
                a.name = styleName;
                a.family = family;
                a.parentName = parentStyleName;
                styles.put(styleName, a);
            }

            for (IXMLElement child : elem.getChildren()) {
                String ns = child.getNamespace();
                String name = child.getName();
                if (name.equals("drawing-page-properties") && (ns == null || ns.equals(STYLE_NAMESPACE))) {
                    readDrawingPagePropertiesElement(child, a);
                } else if (name.equals("graphic-properties") && (ns == null || ns.equals(STYLE_NAMESPACE))) {
                    readGraphicPropertiesElement(child, a);
                } else if (name.equals("paragraph-properties") && (ns == null || ns.equals(STYLE_NAMESPACE))) {
                    readParagraphPropertiesElement(child, a);
                } else if (name.equals("text-properties") && (ns == null || ns.equals(STYLE_NAMESPACE))) {
                    readTextPropertiesElement(child, a);
                } else {
                    if (DEBUG) {
                        System.out.println("ODGStylesReader unsupported <" + elem.getName() + "> child " + child);
                    }
                }
            }
        }
    }

    /**
     * Reads a &lt;document-content&gt; element from the specified
     * XML element.
     *
     * @param elem A &lt;document-content&gt; element.
     */
    private void readDocumentContentElement(IXMLElement elem) throws IOException {
        if (DEBUG) {
            System.out.println("ODGStylesReader <" + elem.getName() + " ...>");
        }
        for (IXMLElement child : elem.getChildren()) {
            String ns = child.getNamespace();
            String name = child.getName();
            if (name.equals("automatic-styles") && (ns == null || ns.equals(OFFICE_NAMESPACE))) {
                readAutomaticStylesElement(child);
            } else if (name.equals("master-styles") && (ns == null || ns.equals(OFFICE_NAMESPACE))) {
                readStylesElement(child);
            } else if (name.equals("styles") && (ns == null || ns.equals(OFFICE_NAMESPACE))) {
                readStylesElement(child);
            }

        }
        if (DEBUG) {
            System.out.println("ODGStylesReader </" + elem.getName() + ">");
        }
    }

    /**
     * Reads a &lt;document-styles&gt; element from the specified
     * XML element.
     * <p>
     * The document-styles element contains all named styles of
     * a document, along with the automatic styles needed for the named
     * styles.
     *
     *
     * @param elem A &lt;document-styles&gt; element.
     */
    private void readDocumentStylesElement(IXMLElement elem) throws IOException {
        if (DEBUG) {
            System.out.println("ODGStylesReader <" + elem.getName() + " ...>");
        }
        for (IXMLElement child : elem.getChildren()) {
            String ns = child.getNamespace();
            String name = child.getName();
            if (name.equals("styles") && (ns == null || ns.equals(OFFICE_NAMESPACE))) {
                readStylesElement(child);
            } else if (name.equals("automatic-styles") && (ns == null || ns.equals(OFFICE_NAMESPACE))) {
                readAutomaticStylesElement(child);
            } else if (name.equals("master-styles") && (ns == null || ns.equals(OFFICE_NAMESPACE))) {
                readMasterStylesElement(child);
            } else {
                if (DEBUG) {
                    System.out.println("ODGStylesReader unsupported <" + elem.getName() + "> child " + child);
                }
            }
        }
        if (DEBUG) {
            System.out.println("ODGStylesReader </" + elem.getName() + ">");
        }
    }

    /**
     * Reads a &lt;style:drawing-page-properties&gt; element from the specified
     * XML element.
     * <p>
     *
     * @param elem A &lt;style:drawing-page-properties&gt; element.
     */
    private void readDrawingPagePropertiesElement(IXMLElement elem, HashMap<AttributeKey, Object> a) throws IOException {
        if (DEBUG) {
            System.out.println("ODGStylesReader unsupported <" + elem.getName() + "> element.");
        }
    }

    /**
     * Reads a &lt;style:graphic-properties&gt; element from the specified
     * XML element.
     * <p>
     *
     * @param elem A &lt;style:graphic-properties&gt; element.
     */
    private void readGraphicPropertiesElement(IXMLElement elem, HashMap<AttributeKey, Object> a) throws IOException {
        // The attribute draw:stroke specifies the style of the stroke on the current object. The value
        // none means that no stroke is drawn, and the value solid means that a solid stroke is drawn. If
        // the value is dash, the stroke referenced by the draw:stroke-dash property is drawn.
        if (elem.hasAttribute("stroke", DRAWING_NAMESPACE)) {
            STROKE_STYLE.put(a, (StrokeStyle) elem.getAttribute("stroke", DRAWING_NAMESPACE, STROKE_STYLES, null));
        }
        // The attribute svg:stroke-width specifies the width of the stroke on
        // the current object.
        if (elem.hasAttribute("stroke-width", SVG_NAMESPACE)) {
            STROKE_WIDTH.put(a, toLength(elem.getAttribute("stroke-width", SVG_NAMESPACE, null)));
        }
        // The attribute svg:stroke-color specifies the color of the stroke on
        // the current object.
        if (elem.hasAttribute("stroke-color", SVG_NAMESPACE)) {
            STROKE_COLOR.put(a, toColor(elem.getAttribute("stroke-color", SVG_NAMESPACE, null)));
        }
        // FIXME read draw:marker-start-width, draw:marker-start-center, draw:marker-end-width,
        // draw:marker-end-centre

        // The attribute draw:fill specifies the fill style for a graphic
        // object. Graphic objects that are not closed, such as a path without a
        // closepath at the end, will not be filled. The fill operation does not
        // automatically close all open subpaths by connecting the last point of
        // the subpath with the first point of the subpath before painting the
        // fill. The attribute has the following values:
        //  • none:     the drawing object is not filled.
        //  • solid:    the drawing object is filled with color specified by the
        //              draw:fill-color attribute.
        //  • bitmap:   the drawing object is filled with the bitmap specified
        //              by the draw:fill-image-name attribute.
        //  • gradient: the drawing object is filled with the gradient specified
        //              by the draw:fill-gradient-name attribute.
        //  • hatch:    the drawing object is filled with the hatch specified by
        //              the draw:fill-hatch-name attribute.
        if (elem.hasAttribute("fill", DRAWING_NAMESPACE)) {
            FILL_STYLE.put(a, (FillStyle) elem.getAttribute("fill", DRAWING_NAMESPACE, FILL_STYLES, null));
        }
        // The attribute draw:fill-color specifies the color of the fill for a
        // graphic object. It is used only if the draw:fill attribute has the
        // value solid.
        if (elem.hasAttribute("fill-color", DRAWING_NAMESPACE)) {
            FILL_COLOR.put(a, toColor(elem.getAttribute("fill-color", DRAWING_NAMESPACE, null)));
        }
        // FIXME read fo:padding-top, fo:padding-bottom, fo:padding-left,
        // fo:padding-right

        // FIXME read draw:shadow, draw:shadow-offset-x, draw:shadow-offset-y,
        // draw:shadow-color

        for (IXMLElement child : elem.getChildren()) {
            String ns = child.getNamespace();
            String name = child.getName();
            // if (DEBUG) System.out.println("ODGStylesReader unsupported <"+elem.getName()+"> child <"+child.getName()+" ...>...</>");
        }
    }

    /**
     * Reads a &lt;styles&gt; element from the specified
     * XML element.
     * <p>
     * The &lt;style:style&gt; element can represent paragraph, text, and
     * graphic styles.
     *
     *
     * @param elem A &lt;style&gt; element.
     * @param styles Style attributes to be filled in by this method.
     */
    private void readStyleElement(IXMLElement elem, HashMap<String, Style> styles) throws IOException {
        // The style:name attribute identifies the name of the style. This attribute, combined with the
// style:family attribute, uniquely identifies a style. The <office:styles>,
// <office:automatic-styles> and <office:master-styles> elements each must not
// contain two styles with the same family and the same name.
// For automatic styles, a name is generated during document export. If the document is exported
// several times, it cannot be assumed that the same name is generated each time.
// In an XML document, the name of each style is a unique name that may be independent of the
// language selected for an office applications user interface. Usually these names are the ones used
// for the English version of the user interface.
        String styleName = elem.getAttribute("name", STYLE_NAMESPACE, null);
        String family = elem.getAttribute("family", STYLE_NAMESPACE, null);
        String parentStyleName = elem.getAttribute("parent-style-name", STYLE_NAMESPACE, null);

        if (DEBUG) {
            System.out.println("ODGStylesReader <style name=" + styleName + " ...>...</>");
        }

        if (styleName != null) {
            Style a = styles.get(styleName);
            if (a == null) {
                a = new Style();
                a.name = styleName;
                a.family = family;
                a.parentName = parentStyleName;
                styles.put(styleName, a);
            }

            for (IXMLElement child : elem.getChildren()) {
                String ns = child.getNamespace();
                String name = child.getName();
                if (name.equals("drawing-page-properties") && (ns == null || ns.equals(STYLE_NAMESPACE))) {
                    readDrawingPagePropertiesElement(child, a);
                } else if (name.equals("graphic-properties") && (ns == null || ns.equals(STYLE_NAMESPACE))) {
                    readGraphicPropertiesElement(child, a);
                } else if (name.equals("paragraph-properties") && (ns == null || ns.equals(STYLE_NAMESPACE))) {
                    readParagraphPropertiesElement(child, a);
                } else if (name.equals("text-properties") && (ns == null || ns.equals(STYLE_NAMESPACE))) {
                    readTextPropertiesElement(child, a);
                } else {
                    if (DEBUG) {
                        System.out.println("ODGStylesReader unsupported <" + elem.getName() + "> child " + child);
                    }
                }
            }
        }
    }

    /**
     * Reads a &lt;styles&gt; element from the specified
     * XML element.
     * <p>
     * The styles element contains common styles.
     *
     *
     * @param elem A &lt;styles&gt; element.
     */
    private void readStylesElement(IXMLElement elem) throws IOException {
        readStylesChildren(elem, commonStyles);
    }

    /**
     * Reads the children of a styles element.
     *
     *
     * @param elem A &lt;styles&gt;, &lt;automatic-styles&gt;,
     * &lt;document-styles&gt; or a &lt;master-styles&gt; element.
     * @param styles Styles to be filled in by this method.
     */
    private void readStylesChildren(IXMLElement elem,
            HashMap<String, Style> styles) throws IOException {
        for (IXMLElement child : elem.getChildren()) {
            String ns = child.getNamespace();
            String name = child.getName();
            if (name.equals("default-style") && (ns == null || ns.equals(STYLE_NAMESPACE))) {
                readDefaultStyleElement(child, styles);
            } else if (name.equals("layer-set") && (ns == null || ns.equals(DRAWING_NAMESPACE))) {
                readLayerSetElement(child, styles);
            } else if (name.equals("list-style") && (ns == null || ns.equals(TEXT_NAMESPACE))) {
                readListStyleElement(child, styles);
            } else if (name.equals("marker") && (ns == null || ns.equals(DRAWING_NAMESPACE))) {
                readMarkerElement(child, styles);
            } else if (name.equals("master-page") && (ns == null || ns.equals(STYLE_NAMESPACE))) {
                readMasterPageElement(child, styles);
            } else if (name.equals("page-layout") && (ns == null || ns.equals(STYLE_NAMESPACE))) {
                readPageLayoutElement(child, styles);
                //} else if (name.equals("paragraph-properties") && (ns == null || ns.equals(STYLE_NAMESPACE))) {
                //    readParagraphPropertiesElement(child, styles);
            } else if (name.equals("style") && (ns == null || ns.equals(STYLE_NAMESPACE))) {
                readStyleElement(child, styles);
                //} else if (name.equals("text-properties") && (ns == null || ns.equals(STYLE_NAMESPACE))) {
                //    readTextPropertiesElement(child, styles);
            } else {
                if (DEBUG) {
                    System.out.println("ODGStylesReader unsupported <" + elem.getName() + "> child: " + child);
                }
            }
        }
    }

    /**
     * Reads a &lt;automatic-styles&gt; element from the specified
     * XML element.
     * <p>
     * The automatic-styles element contains automatic styles.
     *
     *
     * @param elem A &lt;automatic-styles&gt; element.
     */
    private void readAutomaticStylesElement(IXMLElement elem) throws IOException {
        readStylesChildren(elem, automaticStyles);
    }

    /**
     * Reads a &lt;draw:layer-put&gt; element from the specified
     * XML element.
     * <p>
     *
     * @param elem A &lt;layer-put&gt; element.
     * @param styles Style attributes to be filled in by this method.
     */
    private void readLayerSetElement(IXMLElement elem, HashMap<String, Style> styles) throws IOException {
        if (DEBUG) {
            System.out.println("ODGStylesReader unsupported <" + elem.getName() + "> element.");
        }
    }

    /**
     * Reads a &lt;text:list-style&gt; element from the specified
     * XML element.
     * <p>
     *
     * @param elem A &lt;list-style&gt; element.
     * @param styles Style attributes to be filled in by this method.
     */
    private void readListStyleElement(IXMLElement elem, HashMap<String, Style> styles) throws IOException {
        if (DEBUG) {
            System.out.println("ODGStylesReader unsupported <" + elem.getName() + "> element.");
        }
    }

    /**
     * Reads a &lt;master-styles&gt; element from the specified
     * XML element.
     * <p>
     * The master-styles element contains master styles.
     *
     *
     * @param elem A &lt;master-styles&gt; element.
     */
    private void readMasterStylesElement(IXMLElement elem) throws IOException {
        readStylesChildren(elem, masterStyles);
    }

    /**
     * Reads a &lt;draw:marker&gt; element from the specified
     * XML element.
     * <p>
     * The element &lt;draw:marker&gt; represents a marker, which is used
     * to draw polygons at the start and end points of strokes. Markers
     * are not available as automatic styles.
     *
     *
     * @param elem A &lt;master-styles&gt; element.
     * @param styles Style attributes to be filled in by this method.
     */
    private void readMarkerElement(IXMLElement elem, HashMap<String, Style> styles) throws IOException {
        //if (DEBUG) System.out.println("ODGStylesReader unsupported <"+elem.getName()+"> element.");
    }

    /**
     * Reads a &lt;style:master-page&gt; element from the specified
     * XML element.
     * <p>
     *
     * @param elem A &lt;page-layout&gt; element.
     * @param styles Style attributes to be filled in by this method.
     */
    private void readMasterPageElement(IXMLElement elem, HashMap<String, Style> styles) throws IOException {
        if (DEBUG) {
            System.out.println("ODGStylesReader unsupported <" + elem.getName() + "> element.");
        }
    }

    /**
     * Reads a &lt;style:page-layout&gt; element from the specified
     * XML element.
     * <p>
     * The &lt;style:page-layout&gt; element specifies the physical properties
     * of a page. This element contains a &lt;style:page-layout-properties&gt;
     * element which specifies the formatting properties of the page and two
     * optional elements that specify the properties of headers and footers.
     *
     * @param elem A &lt;page-layout&gt; element.
     * @param styles Style attributes to be filled in by this method.
     */
    private void readPageLayoutElement(IXMLElement elem, HashMap<String, Style> styles) throws IOException {
        //if (DEBUG) System.out.println("ODGStylesReader unsupported <"+elem.getName()+"> element.");
    }

    /**
     * Reads a &lt;style:paragraph-properties&gt; element from the specified
     * XML element.
     * <p>
     * The properties described in this section can be contained within
     * paragraph styles (see section 14.8.2), but also within other styles, like
     * cell styles (see section 14.12.4) They are contained in a
     * &lt;style:paragraph-properties&gt; element.
     *
     *
     * @param elem A &lt;paragraph-properties&gt; element.
     * @param a Style attributes to be filled in by this method.
     */
    private void readParagraphPropertiesElement(IXMLElement elem, HashMap<AttributeKey, Object> a) throws IOException {
        //if (DEBUG) System.out.println("ODGStylesReader unsupported <"+elem.getName()+"> element.");
    }

    /**
     * Reads a &lt;style:text-properties&gt; element from the specified
     * XML element.
     * <p>
     * The properties described in this section can be contained within text
     * styles (see section 14.8.1), but also within other styles, like paragraph
     * styles (see section 14.8.2) or cell styles (see section 14.12.4) They are
     * contained in a &lt;style:text-properties&gt; element.
     *
     *
     * @param elem A &lt;paragraph-properties&gt; element.
     * @param a Style attributes to be filled in by this method.
     */
    private void readTextPropertiesElement(IXMLElement elem, HashMap<AttributeKey, Object> a) throws IOException {
        //if (DEBUG) System.out.println("ODGStylesReader unsupported <"+elem.getName()+"> element.");
    }

    /**
     * Returns a value as a length.
     *
     * &lt;define name="length"&gt;
     * &lt;data type="string"&gt;
     * &lt;param name="pattern"&gt;-?([0-9]+(\.[0-9]*)?|\.[0-9]+)((cm)|(mm)|(in)|
     * (pt)|(pc)|(px))&lt;/param&gt;
     *
     */
    private double toLength(String str) throws IOException {
        double scaleFactor = 1d;
        if (str == null || str.length() == 0) {
            return 0d;
        }

        if (str.endsWith("cm")) {
            str = str.substring(0, str.length() - 2);
            scaleFactor = 35.43307;
        } else if (str.endsWith("mm")) {
            str = str.substring(0, str.length() - 2);
            scaleFactor = 3.543307;
        } else if (str.endsWith("in")) {
            str = str.substring(0, str.length() - 2);
            scaleFactor = 90;
        } else if (str.endsWith("pt")) {
            str = str.substring(0, str.length() - 2);
            scaleFactor = 1.25;
        } else if (str.endsWith("pc")) {
            str = str.substring(0, str.length() - 2);
            scaleFactor = 15;
        } else if (str.endsWith("px")) {
            str = str.substring(0, str.length() - 2);
        }

        return Double.parseDouble(str) * scaleFactor;
    }

    /**
     * Reads a color style attribute.
     * &lt;define name="color"&gt;
     * &lt;data type="string"&gt;
     * &lt;param name="pattern"&gt;#[0-9a-fA-F]{6}&lt;/param&gt;
     * &lt;/data&gt;
     * &lt;/define&gt;
     */
    @Nullable
    private Color toColor(String value) throws IOException {
        String str = value;
        if (str == null) {
            return null;
        }

        if (str.startsWith("#") && str.length() == 7) {
            return new Color(Integer.decode(str));
        } else {
            return null;
        }
    }
}
