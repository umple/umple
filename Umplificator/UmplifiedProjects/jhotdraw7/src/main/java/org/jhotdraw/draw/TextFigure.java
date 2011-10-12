/*
 * @(#)TextFigure.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.draw;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.tool.Tool;
import org.jhotdraw.draw.tool.TextEditingTool;
import org.jhotdraw.draw.handle.FontSizeHandle;
import org.jhotdraw.util.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.util.*;
import java.io.*;
import org.jhotdraw.draw.handle.BoundsOutlineHandle;
import org.jhotdraw.draw.handle.Handle;
import org.jhotdraw.draw.handle.MoveHandle;
import org.jhotdraw.draw.locator.RelativeLocator;
import static org.jhotdraw.draw.AttributeKeys.*;
import org.jhotdraw.geom.*;
import org.jhotdraw.xml.DOMInput;
import org.jhotdraw.xml.DOMOutput;

/**
 * A {@code TextHolderFigure} which holds a single line of text.
 * <p>
 * A DrawingEditor should provide the 
 * {@link org.jhotdraw.draw.tool.TextCreationTool} to create a
 * {@code TextFigure}.
 *
 * @author Werner Randelshofer
 * @version $Id: TextFigure.java 764 2011-09-09 19:57:15Z rawcoder $
 */
public class TextFigure extends AbstractAttributedDecoratedFigure
        implements TextHolderFigure {

    protected Point2D.Double origin = new Point2D.Double();
    protected boolean editable = true;
    // cache of the TextFigure's layout
    @Nullable transient protected TextLayout textLayout;

    /** Creates a new instance. */
    public TextFigure() {
        this(ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels").
                getString("TextFigure.defaultText"));

    }

    public TextFigure(String text) {
        setText(text);
    }

    // DRAWING
    @Override
    protected void drawStroke(java.awt.Graphics2D g) {
    }

    @Override
    protected void drawFill(java.awt.Graphics2D g) {
    }

    @Override
    protected void drawText(java.awt.Graphics2D g) {
        if (getText() != null || isEditable()) {
            TextLayout layout = getTextLayout();
            layout.draw(g, (float) origin.x, (float) (origin.y + layout.getAscent()));
        }
    }

    // SHAPE AND BOUNDS
    @Override
    public void transform(AffineTransform tx) {
        tx.transform(origin, origin);
    }

    @Override
    public void setBounds(Point2D.Double anchor, Point2D.Double lead) {
        origin = new Point2D.Double(anchor.x, anchor.y);
    }

    @Override
    public boolean figureContains(Point2D.Double p) {
        if (getBounds().contains(p)) {
            return true;
        }
        return false;
    }

    protected TextLayout getTextLayout() {
        if (textLayout == null) {
            String text = getText();
            if (text == null || text.length() == 0) {
                text = " ";
            }

            FontRenderContext frc = getFontRenderContext();
            HashMap<TextAttribute, Object> textAttributes = new HashMap<TextAttribute, Object>();
            textAttributes.put(TextAttribute.FONT, getFont());
            if (get(FONT_UNDERLINE)) {
                textAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_LOW_ONE_PIXEL);
            }
            textLayout = new TextLayout(text, textAttributes, frc);
        }
        return textLayout;
    }

    @Override
    public Rectangle2D.Double getBounds() {
        TextLayout layout = getTextLayout();
        Rectangle2D.Double r = new Rectangle2D.Double(origin.x, origin.y, layout.getAdvance(),
                layout.getAscent() + layout.getDescent());
        return r;
    }

    @Override
    public Dimension2DDouble getPreferredSize() {
        Rectangle2D.Double b = getBounds();
        return new Dimension2DDouble(b.width, b.height);
    }

    @Override
    public double getBaseline() {
        TextLayout layout = getTextLayout();
        return origin.y + layout.getAscent() - getBounds().y;
    }

    /**
     * Gets the drawing area without taking the decorator into account.
     */
    @Override
    protected Rectangle2D.Double getFigureDrawingArea() {
        if (getText() == null) {
            return getBounds();
        } else {
            TextLayout layout = getTextLayout();
            Rectangle2D.Double r = new Rectangle2D.Double(
                    origin.x, origin.y, layout.getAdvance(), layout.getAscent());
            Rectangle2D lBounds = layout.getBounds();
            if (!lBounds.isEmpty() && !Double.isNaN(lBounds.getX())) {
                r.add(new Rectangle2D.Double(
                        lBounds.getX() + origin.x,
                        (lBounds.getY() + origin.y + layout.getAscent()),
                        lBounds.getWidth(),
                        lBounds.getHeight()));
            }
            // grow by two pixels to take antialiasing into account
            Geom.grow(r, 2d, 2d);
            return r;
        }
    }

    @Override
    public void restoreTransformTo(Object geometry) {
        Point2D.Double p = (Point2D.Double) geometry;
        origin.x = p.x;
        origin.y = p.y;
    }

    @Override
    public Object getTransformRestoreData() {
        return origin.clone();
    }

    // ATTRIBUTES
    /**
     * Gets the text shown by the text figure.
     */
    @Override
    public String getText() {
        return get(TEXT);
    }

    /**
     * Sets the text shown by the text figure.
     * This is a convenience method for calling {@code set(TEXT,newText)}.
     */
    @Override
    public void setText(String newText) {
        set(TEXT, newText);
    }

    @Override
    public int getTextColumns() {
        //return (getText() == null) ? 4 : Math.max(getText().length(), 4);
        return 4;
    }

    /**
     * Gets the number of characters used to expand tabs.
     */
    @Override
    public int getTabSize() {
        return 8;
    }

    @Override
    public TextHolderFigure getLabelFor() {
        return this;
    }

    @Override
    public Insets2D.Double getInsets() {
        return new Insets2D.Double();
    }

    @Override
    public Font getFont() {
        return AttributeKeys.getFont(this);
    }

    @Override
    public Color getTextColor() {
        return get(TEXT_COLOR);
    }

    @Override
    public Color getFillColor() {
        return get(FILL_COLOR);
    }

    @Override
    public void setFontSize(float size) {
        set(FONT_SIZE, new Double(size));
    }

    @Override
    public float getFontSize() {
        return get(FONT_SIZE).floatValue();
    }

    // EDITING
    @Override
    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean b) {
        this.editable = b;
    }

    @Override
    public Collection<Handle> createHandles(int detailLevel) {
        LinkedList<Handle> handles = new LinkedList<Handle>();
        switch (detailLevel) {
            case -1:
                handles.add(new BoundsOutlineHandle(this, false, true));
                break;
            case 0:
                handles.add(new BoundsOutlineHandle(this));
                handles.add(new MoveHandle(this, RelativeLocator.northWest()));
                handles.add(new MoveHandle(this, RelativeLocator.northEast()));
                handles.add(new MoveHandle(this, RelativeLocator.southWest()));
                handles.add(new MoveHandle(this, RelativeLocator.southEast()));
                handles.add(new FontSizeHandle(this));
                break;
        }
        return handles;
    }

    /**
     * Returns a specialized tool for the given coordinate.
     * <p>Returns null, if no specialized tool is available.
     */
    @Override
    public Tool getTool(Point2D.Double p) {
        if (isEditable() && contains(p)) {
            TextEditingTool t = new TextEditingTool(this);
            return t;
        }
        return null;
    }

    // CONNECTING
    // COMPOSITE FIGURES
    // CLONING
    // EVENT HANDLING
    @Override
    public void invalidate() {
        super.invalidate();
        textLayout = null;
    }

    @Override
    protected void validate() {
        super.validate();
        textLayout = null;
    }

    @Override
    public void read(DOMInput in) throws IOException {
        setBounds(
                new Point2D.Double(in.getAttribute("x", 0d), in.getAttribute("y", 0d)),
                new Point2D.Double(0, 0));
        readAttributes(in);
        readDecorator(in);
        invalidate();
    }

    @Override
    public void write(DOMOutput out) throws IOException {
        Rectangle2D.Double b = getBounds();
        out.addAttribute("x", b.x);
        out.addAttribute("y", b.y);
        writeAttributes(out);
        writeDecorator(out);
    }

    @Override
    public TextFigure clone() {
        TextFigure that = (TextFigure) super.clone();
        that.origin = (Point2D.Double) this.origin.clone();
        that.textLayout = null;
        return that;
    }

    @Override
    public boolean isTextOverflow() {
        return false;
    }
}
