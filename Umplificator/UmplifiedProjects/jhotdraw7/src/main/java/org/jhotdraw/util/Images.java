/*
 * @(#)Images.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.util;

import java.awt.*;
import java.awt.image.*;
import java.net.*;

import javax.swing.*;

/**
 * Image processing methods.
 *
 * @author  Werner Randelshofer
 * @version $Id: Images.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class Images {

    /** Prevent instance creation. */
    private Images() {
    }

    public static Image createImage(Class baseClass, String resourceName) {
        URL resource = baseClass.getResource(resourceName);
        if (resource == null) {
            throw new InternalError("Ressource \"" + resourceName + "\" not found for class " + baseClass);
        }
        Image image = Toolkit.getDefaultToolkit().createImage(resource);
        return image;
    }

    public static Image createImage(URL resource) {
        if (resource == null) {
            throw new IllegalArgumentException("resource must not be null");
        }
        Image image = Toolkit.getDefaultToolkit().createImage(resource);
        return image;
    }

    /**
     * Converts an Image to BufferedImage. If the Image is already a
     * BufferedImage, the same image is returned.
     * 
     * @param rImg An Image.
     * @return A BufferedImage.
     */
    public static BufferedImage toBufferedImage(RenderedImage rImg) {
        BufferedImage image;
        if (rImg instanceof BufferedImage) {
            image = (BufferedImage) rImg;
        } else {
            Raster r = rImg.getData();
            WritableRaster wr = WritableRaster.createWritableRaster(
                    r.getSampleModel(), null);
            rImg.copyData(wr);
            image = new BufferedImage(
                    rImg.getColorModel(),
                    wr,
                    rImg.getColorModel().isAlphaPremultiplied(),
                    null);
        }
        return image;
    }

    public static BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }

        // This code ensures that all the pixels in the image are loaded
        image = new ImageIcon(image).getImage();

        // Create a buffered image with a format that's compatible with the screen
        BufferedImage bimage = null;

        if (System.getProperty("java.version").startsWith("1.4.1_")) {
            // Workaround for Java 1.4.1 on Mac OS X.
            // For this JVM, we always create an ARGB image to prevent a class
            // cast exception in
            // sun.awt.image.BufImgSurfaceData.createData(BufImgSurfaceData.java:434)
            // when we attempt to draw the buffered image.
            bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        } else {
            // Determine if the image has transparent pixels; for this method's
            // implementation, see e661 Determining If an Image Has Transparent Pixels
            boolean hasAlpha;
            try {
                hasAlpha = hasAlpha(image);
            } catch (IllegalAccessError e) {
                // If we can't determine this, we assume that we have an alpha,
                // in order not to loose data.
                hasAlpha = true;
            }


            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            try {
                // Determine the type of transparency of the new buffered image
                int transparency = Transparency.OPAQUE;
                if (hasAlpha) {
                    transparency = Transparency.TRANSLUCENT;
                }

                // Create the buffered image
                GraphicsDevice gs = ge.getDefaultScreenDevice();
                GraphicsConfiguration gc = gs.getDefaultConfiguration();
                bimage = gc.createCompatibleImage(
                        image.getWidth(null), image.getHeight(null), transparency);
            } catch (Exception e) {
                //} catch (HeadlessException e) {
                // The system does not have a screen
            }

            if (bimage == null) {
                // Create a buffered image using the default color model
                int type = BufferedImage.TYPE_INT_RGB;
                if (hasAlpha) {
                    type = BufferedImage.TYPE_INT_ARGB;
                }
                bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
            }
        }

        // Copy image to buffered image
        Graphics g = bimage.createGraphics();

        // Paint the image onto the buffered image
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return bimage;
    }

    /**
     * This method returns true if the specified image has transparent pixels
     *
     * Code taken from the Java Developers Almanac 1.4
     * http://javaalmanac.com/egs/java.awt.image/HasAlpha.html
     */
    public static boolean hasAlpha(Image image) {
        // If buffered image, the color model is readily available
        if (image instanceof BufferedImage) {
            BufferedImage bimage = (BufferedImage) image;
            return bimage.getColorModel().hasAlpha();
        }

        // Use a pixel grabber to retrieve the image's color model;
        // grabbing a single pixel is usually sufficient
        PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
        try {
            pg.grabPixels();
        } catch (InterruptedException e) {
        }

        // Get the image's color model
        ColorModel cm = pg.getColorModel();
        return cm.hasAlpha();
    }

    /**
     * Splits an image into count subimages.
     */
    public static BufferedImage[] split(Image image, int count, boolean isHorizontal) {
        BufferedImage src = Images.toBufferedImage(image);
        if (count == 1) {
            return new BufferedImage[]{src};
        }

        BufferedImage[] parts = new BufferedImage[count];
        for (int i = 0; i < count; i++) {
            if (isHorizontal) {
                parts[i] = src.getSubimage(
                        src.getWidth() / count * i, 0,
                        src.getWidth() / count, src.getHeight());
            } else {
                parts[i] = src.getSubimage(
                        0, src.getHeight() / count * i,
                        src.getWidth(), src.getHeight() / count);
            }
        }
        return parts;
    }

    /** Creates a scaled instanceof the image.
     * <p>
     * If either width or height is a negative number then a value is s
     * ubstituted to maintain the aspect ratio of the original image dimensions.
     * If both width and height are negative, then the original image dimensions
     * are used.
     * <p>
     * On Mac OS X 10.6, this method has a much better performance than
     * BufferedImage.getScaledInstance.
     *
     *
     * @param image the image.
     * @param width the width to which to scale the image.
     * @param height the height to which to scale the image.
     */
    public static BufferedImage getScaledInstance(Image image, int width, int height) {
        int w, h;
        if (width<0&&height<0) {
            w=image.getWidth(null);
            h=image.getHeight(null);
        } else if (width<0) {
            w=image.getWidth(null)*height/image.getHeight(null);
            h=height;
        } else if (height<0) {
            w=width;
            h=image.getHeight(null)*width/image.getWidth(null);
        } else {
            w=width;
            h=height;
        }

        BufferedImage scaled = new BufferedImage(w,h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = scaled.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.drawImage(image, 0, 0, w, h, null);
        g.dispose();

        return scaled;
    }
}
