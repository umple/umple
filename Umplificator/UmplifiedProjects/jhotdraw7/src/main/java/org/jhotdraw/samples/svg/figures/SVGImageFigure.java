 /*
 * @(#)SVGImage.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.samples.svg.figures;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.draw.handle.TransformHandleKit;
import org.jhotdraw.draw.handle.ResizeHandleKit;
import org.jhotdraw.draw.handle.Handle;
import org.jhotdraw.draw.event.TransformRestoreEdit;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import org.jhotdraw.draw.*;
import org.jhotdraw.draw.handle.BoundsOutlineHandle;
import static org.jhotdraw.samples.svg.SVGAttributeKeys.*;
import org.jhotdraw.samples.svg.*;
import org.jhotdraw.util.*;
import org.jhotdraw.geom.*;

/**
 * SVGImage.
 *
 * @author Werner Randelshofer
 * @version $Id: SVGImageFigure.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class SVGImageFigure extends SVGAttributedFigure implements SVGFigure, ImageHolderFigure {

    /**
     * This rectangle describes the bounds into which we draw the image.
     */
    private Rectangle2D.Double rectangle;
    /**
     * This is used to perform faster drawing.
     */
    @Nullable
    private transient Shape cachedTransformedShape;
    /**
     * This is used to perform faster hit testing.
     */
    @Nullable
    private transient Shape cachedHitShape;
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
    private BufferedImage bufferedImage;

    /** Creates a new instance. */
    public SVGImageFigure() {
        this(0, 0, 0, 0);
    }

    public SVGImageFigure(double x, double y, double width, double height) {
        rectangle = new Rectangle2D.Double(x, y, width, height);
        SVGAttributeKeys.setDefaults(this);
        setConnectable(false);
    }

    // DRAWING
    @Override
    public void draw(Graphics2D g) {
        //super.draw(g);

        double opacity = get(OPACITY);
        opacity = Math.min(Math.max(0d, opacity), 1d);
        if (opacity != 0d) {
            Composite savedComposite = g.getComposite();
            if (opacity != 1d) {
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) opacity));
            }

            BufferedImage image = getBufferedImage();
            if (image != null) {
                if (get(TRANSFORM) != null) {
                    // FIXME - We should cache the transformed image.
                    //         Drawing a transformed image appears to be very slow.
                    Graphics2D gx = (Graphics2D) g.create();

                    // Use same rendering hints like parent graphics
                    gx.setRenderingHints(g.getRenderingHints());

                    gx.transform(get(TRANSFORM));
                    gx.drawImage(image, (int) rectangle.x, (int) rectangle.y, (int) rectangle.width, (int) rectangle.height, null);
                    gx.dispose();
                } else {
                    g.drawImage(image, (int) rectangle.x, (int) rectangle.y, (int) rectangle.width, (int) rectangle.height, null);
                }
            } else {
                Shape shape = getTransformedShape();
                g.setColor(Color.red);
                g.setStroke(new BasicStroke());
                g.draw(shape);
            }

            if (opacity != 1d) {
                g.setComposite(savedComposite);
            }
        }
    }

    @Override
    protected void drawFill(Graphics2D g) {
    }

    @Override
    protected void drawStroke(Graphics2D g) {
    }

    // SHAPE AND BOUNDS
    public double getX() {
        return rectangle.x;
    }

    public double getY() {
        return rectangle.y;
    }

    public double getWidth() {
        return rectangle.width;
    }

    public double getHeight() {
        return rectangle.height;
    }

    @Override
    public Rectangle2D.Double getBounds() {
        return (Rectangle2D.Double) rectangle.clone();
    }

    @Override
    public Rectangle2D.Double getDrawingArea() {
        Rectangle2D rx = getTransformedShape().getBounds2D();
        Rectangle2D.Double r = (rx instanceof Rectangle2D.Double) ? (Rectangle2D.Double) rx : new Rectangle2D.Double(rx.getX(), rx.getY(), rx.getWidth(), rx.getHeight());
        return r;
    }

    /**
     * Checks if a Point2D.Double is inside the figure.
     */
    @Override
    public boolean contains(Point2D.Double p) {
        return getHitShape().contains(p);
    }

    @Override
    public void setBounds(Point2D.Double anchor, Point2D.Double lead) {
        invalidateTransformedShape();
        rectangle.x = Math.min(anchor.x, lead.x);
        rectangle.y = Math.min(anchor.y, lead.y);
        rectangle.width = Math.max(0.1, Math.abs(lead.x - anchor.x));
        rectangle.height = Math.max(0.1, Math.abs(lead.y - anchor.y));
    }

    private void invalidateTransformedShape() {
        cachedTransformedShape = null;
        cachedHitShape = null;
    }

    private Shape getTransformedShape() {
        if (cachedTransformedShape == null) {
            cachedTransformedShape = (Shape) rectangle.clone();
            if (get(TRANSFORM) != null) {
                cachedTransformedShape = get(TRANSFORM).createTransformedShape(cachedTransformedShape);
            }
        }
        return cachedTransformedShape;
    }

    private Shape getHitShape() {
        if (cachedHitShape == null) {
            cachedHitShape = new GrowStroke(
                    (float) SVGAttributeKeys.getStrokeTotalWidth(this) / 2f,
                    (float) SVGAttributeKeys.getStrokeTotalMiterLimit(this)).createStrokedShape(getTransformedShape());
        }
        return cachedHitShape;
    }

    /**
     * Transforms the figure.
     * @param tx The transformation.
     */
    @Override
    public void transform(AffineTransform tx) {
        invalidateTransformedShape();
        if (get(TRANSFORM) != null
                || (tx.getType() & (AffineTransform.TYPE_TRANSLATION | AffineTransform.TYPE_MASK_SCALE)) != tx.getType()) {
            if (get(TRANSFORM) == null) {
                set(TRANSFORM, (AffineTransform) tx.clone());
            } else {
                AffineTransform t = TRANSFORM.getClone(this);
                t.preConcatenate(tx);
                set(TRANSFORM, t);
            }
        } else {
            Point2D.Double anchor = getStartPoint();
            Point2D.Double lead = getEndPoint();
            setBounds(
                    (Point2D.Double) tx.transform(anchor, anchor),
                    (Point2D.Double) tx.transform(lead, lead));
        }
    }
    // ATTRIBUTES

    @Override
    public void restoreTransformTo(Object geometry) {
        invalidateTransformedShape();
        Object[] o = (Object[]) geometry;
        rectangle = (Rectangle2D.Double) ((Rectangle2D.Double) o[0]).clone();
        if (o[1] == null) {
            set(TRANSFORM, null);
        } else {
            set(TRANSFORM, (AffineTransform) ((AffineTransform) o[1]).clone());
        }
    }

    @Override
    public Object getTransformRestoreData() {
        return new Object[]{
                    rectangle.clone(),
                    get(TRANSFORM)
                };
    }

    // EDITING
    @Override
    public Collection<Handle> createHandles(int detailLevel) {
        LinkedList<Handle> handles = new LinkedList<Handle>();

        switch (detailLevel % 2) {
            case -1: // Mouse hover handles
                handles.add(new BoundsOutlineHandle(this, false, true));
                break;
            case 0:
                ResizeHandleKit.addResizeHandles(this, handles);
                handles.add(new LinkHandle(this));
                break;
            case 1:
                TransformHandleKit.addTransformHandles(this, handles);
                break;
            default:
                break;
        }
        return handles;
    }

    @Override
    public Collection<Action> getActions(Point2D.Double p) {
        final ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");
        LinkedList<Action> actions = new LinkedList<Action>();
        if (get(TRANSFORM) != null) {
            actions.add(new AbstractAction(labels.getString("edit.removeTransform.text")) {

                @Override
                public void actionPerformed(ActionEvent evt) {
                    willChange();
                    fireUndoableEditHappened(
                            TRANSFORM.setUndoable(SVGImageFigure.this, null));
                    changed();
                }
            });
        }
        if (bufferedImage != null) {
            if (rectangle.width != bufferedImage.getWidth()
                    || rectangle.height != bufferedImage.getHeight()) {
                actions.add(new AbstractAction(labels.getString("edit.setToImageSize.text")) {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Object geometry = getTransformRestoreData();
                        willChange();
                        rectangle = new Rectangle2D.Double(//
                                rectangle.x - (bufferedImage.getWidth() - rectangle.width) / 2d,//
                                rectangle.y - (bufferedImage.getHeight() - rectangle.height) / 2d, //
                                bufferedImage.getWidth(), //
                                bufferedImage.getHeight());
                        fireUndoableEditHappened(
                                new TransformRestoreEdit(SVGImageFigure.this, geometry, getTransformRestoreData()));
                        changed();
                    }
                });
            }
            double imageRatio = bufferedImage.getHeight() / (double) bufferedImage.getWidth();
            double figureRatio = rectangle.height / rectangle.width;
            if (Math.abs(imageRatio - figureRatio) > 0.001) {
                actions.add(new AbstractAction(labels.getString("edit.adjustHeightToImageAspect.text")) {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Object geometry = getTransformRestoreData();
                        willChange();
                        double newHeight = bufferedImage.getHeight() * rectangle.width / bufferedImage.getWidth();
                        rectangle = new Rectangle2D.Double(rectangle.x, rectangle.y - (newHeight - rectangle.height) / 2d, rectangle.width, newHeight);
                        fireUndoableEditHappened(
                                new TransformRestoreEdit(SVGImageFigure.this, geometry, getTransformRestoreData()));
                        changed();
                    }
                });
                actions.add(new AbstractAction(labels.getString("edit.adjustWidthToImageAspect.text")) {

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Object geometry = getTransformRestoreData();
                        willChange();
                        double newWidth = bufferedImage.getWidth() * rectangle.height / bufferedImage.getHeight();
                        rectangle = new Rectangle2D.Double(rectangle.x - (newWidth - rectangle.width) / 2d, rectangle.y, newWidth, rectangle.height);
                        fireUndoableEditHappened(
                                new TransformRestoreEdit(SVGImageFigure.this, geometry, getTransformRestoreData()));
                        changed();
                    }
                });
            }
        }
        return actions;
    }
    // CONNECTING
    // COMPOSITE FIGURES
    // CLONING

    @Override
    public SVGImageFigure clone() {
        SVGImageFigure that = (SVGImageFigure) super.clone();
        that.rectangle = (Rectangle2D.Double) this.rectangle.clone();
        that.cachedTransformedShape = null;
        that.cachedHitShape = null;
        return that;
    }

    @Override
    public boolean isEmpty() {
        Rectangle2D.Double b = getBounds();
        return b.width <= 0 || b.height <= 0 || imageData == null && bufferedImage == null;
    }

    @Override
    public void invalidate() {
        super.invalidate();
        invalidateTransformedShape();
    }

    /**
     * Sets the image.
     * <p>
     * Note: For performance reasons this method stores a reference to the
     * imageData array instead of cloning it. Do not modify the imageData
     * array after invoking this method.
     *
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
     * imageData array instead of cloning it. Do not modify the imageData
     * array after invoking this method.
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
            //System.out.println("recreateing bufferedImage");
            try {
                bufferedImage = ImageIO.read(new ByteArrayInputStream(imageData));
            } catch (Throwable e) {
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
        BufferedImage img;
        try {
            img = ImageIO.read(new ByteArrayInputStream(baos.toByteArray()));
        } catch (Throwable t) {
            img = null;
        }
        if (img == null) {
            ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.draw.Labels");
            throw new IOException(labels.getFormatted("file.failedToLoadImage.message", in.toString()));
        }
        imageData = baos.toByteArray();
        bufferedImage = img;
    }
}
