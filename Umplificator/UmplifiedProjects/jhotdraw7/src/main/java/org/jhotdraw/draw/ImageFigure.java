/*
 * @(#)ImageFigure.java
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
import org.jhotdraw.draw.connector.ChopRectangleConnector;
import org.jhotdraw.draw.connector.Connector;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import org.jhotdraw.geom.*;
import org.jhotdraw.io.Base64;
import org.jhotdraw.util.*;
import org.jhotdraw.xml.*;
import static org.jhotdraw.draw.AttributeKeys.*;

/**
 * A default implementation of {@link ImageHolderFigure} which can hold a
 * buffered image.
 *
 * @author Werner Randelshofer
 * @version $Id: ImageFigure.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ImageFigure extends AbstractAttributedDecoratedFigure
        implements ImageHolderFigure {

    /**
     * This rectangle describes the bounds into which we draw the image.
     */
    private Rectangle2D.Double rectangle;
    /**
     * The image data. This can be null, if the image was created from a
     * BufferedImage.
     */
    @Nullable
    private byte[] imageData;
    /**
     * The buffered image. This can be null, if we haven't yet parsed the
     * imageData.
     */
    @Nullable
    private transient BufferedImage bufferedImage;

    /** Creates a new instance. */
    public ImageFigure() {
        this(0, 0, 0, 0);
    }

    public ImageFigure(double x, double y, double width, double height) {
        rectangle = new Rectangle2D.Double(x, y, width, height);
    }

    // DRAWING
    @Override
    protected void drawFigure(Graphics2D g) {
        if (get(FILL_COLOR) != null) {
            g.setColor(get(FILL_COLOR));
            drawFill(g);
        }
        drawImage(g);

        if (get(STROKE_COLOR) != null && get(STROKE_WIDTH) > 0d) {
            g.setStroke(AttributeKeys.getStroke(this));
            g.setColor(get(STROKE_COLOR));

            drawStroke(g);
        }
        if (get(TEXT_COLOR) != null) {
            if (get(TEXT_SHADOW_COLOR) != null
                    && get(TEXT_SHADOW_OFFSET) != null) {
                Dimension2DDouble d = get(TEXT_SHADOW_OFFSET);
                g.translate(d.width, d.height);
                g.setColor(get(TEXT_SHADOW_COLOR));
                drawText(g);
                g.translate(-d.width, -d.height);
            }
            g.setColor(get(TEXT_COLOR));
            drawText(g);
        }
    }

    @Override
    protected void drawFill(Graphics2D g) {
        Rectangle2D.Double r = (Rectangle2D.Double) rectangle.clone();
        double grow = AttributeKeys.getPerpendicularFillGrowth(this);
        Geom.grow(r, grow, grow);
        g.fill(r);
    }

    protected void drawImage(Graphics2D g) {
        BufferedImage image = getBufferedImage();
        if (image != null) {
            g.drawImage(image, (int) rectangle.x, (int) rectangle.y, (int) rectangle.width, (int) rectangle.height, null);
        } else {
            g.setStroke(new BasicStroke());
            g.setColor(Color.red);
            g.draw(rectangle);
            g.draw(new Line2D.Double(rectangle.x, rectangle.y, rectangle.x + rectangle.width, rectangle.y + rectangle.height));
            g.draw(new Line2D.Double(rectangle.x + rectangle.width, rectangle.y, rectangle.x, rectangle.y + rectangle.height));
        }
    }

    @Override
    protected void drawStroke(Graphics2D g) {
        Rectangle2D.Double r = (Rectangle2D.Double) rectangle.clone();
        double grow = AttributeKeys.getPerpendicularDrawGrowth(this);
        Geom.grow(r, grow, grow);

        g.draw(r);
    }

    // SHAPE AND BOUNDS
    @Override
    public Rectangle2D.Double getBounds() {
        Rectangle2D.Double bounds = (Rectangle2D.Double) rectangle.clone();
        return bounds;
    }

    @Override
    public Rectangle2D.Double getFigureDrawingArea() {
        Rectangle2D.Double r = (Rectangle2D.Double) rectangle.clone();
        double grow = AttributeKeys.getPerpendicularHitGrowth(this);
        Geom.grow(r, grow, grow);
        return r;
    }

    /**
     * Checks if a Point2D.Double is inside the figure.
     */
    @Override
    public boolean figureContains(Point2D.Double p) {
        Rectangle2D.Double r = (Rectangle2D.Double) rectangle.clone();
        double grow = AttributeKeys.getPerpendicularHitGrowth(this) + 1d;
        Geom.grow(r, grow, grow);
        return r.contains(p);
    }

    @Override
    public void setBounds(Point2D.Double anchor, Point2D.Double lead) {
        rectangle.x = Math.min(anchor.x, lead.x);
        rectangle.y = Math.min(anchor.y, lead.y);
        rectangle.width = Math.max(0.1, Math.abs(lead.x - anchor.x));
        rectangle.height = Math.max(0.1, Math.abs(lead.y - anchor.y));
    }

    /**
     * Transforms the figure.
     * @param tx The transformation.
     */
    @Override
    public void transform(AffineTransform tx) {
        Point2D.Double anchor = getStartPoint();
        Point2D.Double lead = getEndPoint();
        setBounds(
                (Point2D.Double) tx.transform(anchor, anchor),
                (Point2D.Double) tx.transform(lead, lead));
    }
    // ATTRIBUTES

    @Override
    public void restoreTransformTo(Object geometry) {
        rectangle.setRect((Rectangle2D.Double) geometry);
    }

    @Override
    public Object getTransformRestoreData() {
        return (Rectangle2D.Double) rectangle.clone();
    }

    // EDITING
    @Override
    public Collection<Action> getActions(Point2D.Double p) {
        LinkedList<Action> actions = new LinkedList<Action>();
        return actions;
    }
    // CONNECTING

    @Override
    public Connector findConnector(Point2D.Double p, ConnectionFigure prototype) {
        // XXX - This doesn't work with a transformed rect
        return new ChopRectangleConnector(this);
    }

    @Override
    public Connector findCompatibleConnector(Connector c, boolean isStartConnector) {
        // XXX - This doesn't work with a transformed rect
        return new ChopRectangleConnector(this);
    }

    // COMPOSITE FIGURES
    // CLONING
    @Override
    public ImageFigure clone() {
        ImageFigure that = (ImageFigure) super.clone();
        that.rectangle = (Rectangle2D.Double) this.rectangle.clone();
        return that;
    }

    @Override
    public void read(DOMInput in) throws IOException {
        super.read(in);
        if (in.getElementCount("imageData") > 0) {
            in.openElement("imageData");
            String base64Data = in.getText();
            if (base64Data != null) {
                setImageData(Base64.decode(base64Data));
            }
            in.closeElement();
        }
    }

    @Override
    public void write(DOMOutput out) throws IOException {
        super.write(out);
        if (getImageData() != null) {
            out.openElement("imageData");
            out.addText(Base64.encodeBytes(getImageData()));
            out.closeElement();
        }
    }

    /**
     * Sets the image.
     *
     * @param imageData The image data. If this is null, a buffered image must
     * be provided.
     * @param bufferedImage An image constructed from the imageData. If this
     * is null, imageData must be provided.
     */
    @Override
    public void setImage(byte[] imageData, BufferedImage bufferedImage) {
        willChange();
        this.imageData = imageData;
        this.bufferedImage = bufferedImage;
        changed();
    }

    /**
     * Sets the image data.
     * This clears the buffered image.
     * <p>
     * Note: For performance reasons this method stores a reference to the
     * imageData array instead of cloning it. Do not modify the image data array
     * after invoking this method.
     */
    public void setImageData(byte[] imageData) {
        willChange();
        this.imageData = imageData;
        this.bufferedImage = null;
        changed();
    }

    /**
     * Sets the buffered image.
     * This clears the image data.
     */
    @Override
    public void setBufferedImage(BufferedImage image) {
        willChange();
        this.imageData = null;
        this.bufferedImage = image;
        changed();
    }

    /**
     * Gets the buffered image. If necessary, this method creates the buffered
     * image from the image data.
     */
    @Override
    @Nullable
    public BufferedImage getBufferedImage() {
        if (bufferedImage == null && imageData != null) {
            try {
                bufferedImage = ImageIO.read(new ByteArrayInputStream(imageData));
            } catch (IOException e) {
                e.printStackTrace();
                // If we can't create a buffered image from the image data,
                // there is no use to keep the image data and try again, so
                // we drop the image data.
                imageData = null;
            }
        }
        return bufferedImage;
    }

    /**
     * Gets the image data. If necessary, this method creates the image
     * data from the buffered image.
     * <p>
     * Note: For performance reasons this method returns a reference to
     * the internally used image data array instead of cloning it. Do not
     * modify this array.
     */
    @Override
    @Nullable
    public byte[] getImageData() {
        if (bufferedImage != null && imageData == null) {
            try {
                ByteArrayOutputStream bout = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "PNG", bout);
                bout.close();
                imageData = bout.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
                // If we can't create image data from the buffered image,
                // there is no use to keep the buffered image and try again, so
                // we drop the buffered image.
                bufferedImage = null;
            }
        }
        return imageData;
    }

    @Override
    public void loadImage(File file) throws IOException {
        InputStream in = new FileInputStream(file);
        try {
            loadImage(in);
        } catch (Throwable t) {
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            IOException e = new IOException(labels.getFormatted("file.failedToLoadImage.message", file.getName()));
            e.initCause(t);
            throw e;
        } finally {
            in.close();
        }
    }

    @Override
    public void loadImage(InputStream in) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[512];
        int bytesRead;
        while ((bytesRead = in.read(buf)) > 0) {
            baos.write(buf, 0, bytesRead);
        }
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(baos.toByteArray()));
        if (img == null) {
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            throw new IOException(labels.getFormatted("file.failedToLoadImage.message", in.toString()));
        }
        imageData = baos.toByteArray();
        bufferedImage = img;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        // The call to getImageData() ensures that we have serializable data
        // in the imageData array.
        getImageData();
        out.defaultWriteObject();
    }
}
