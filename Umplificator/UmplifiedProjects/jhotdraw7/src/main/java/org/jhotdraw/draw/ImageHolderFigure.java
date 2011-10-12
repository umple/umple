/*
 * @(#)ImageHolderFigure.java
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
import java.awt.image.*;
import java.io.*;

/**
 * The interface of a {@link Figure} which has some editable image contents.
 * <p>
 * The {@link org.jhotdraw.draw.tool.ImageTool} can be used to create figures which implement this
 * interface.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Prototype</em><br>
 * The image tool creates new figures by cloning a prototype figure object.
 * That's the reason why {@code Figure} extends the {@code Cloneable} interface.
 * <br>
 * Prototype: {@link ImageHolderFigure}; 
 * Client: {@link org.jhotdraw.draw.tool.ImageTool}.
 *
 *
 * <p><em>Prototype</em><br>
 * The image input format creates new image holder figures by cloning a prototype figure
 * object and assigning an image to it, which was read from data input.
 * That's the reason why {@code Figure} extends the {@code Cloneable} interface.
 * <br>
 * Prototype: {@link ImageHolderFigure};
 * Client: {@link org.jhotdraw.draw.io.ImageInputFormat}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: ImageHolderFigure.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface ImageHolderFigure extends Figure {
    /**
     * Loads an image from a File.
     * By convention this method is never invoked on the AWT Event Dispatcher 
     * Thread.
     */
    public void loadImage(File f) throws IOException;
    /**
     * Loads an image from an Input Stream.
     * By convention this method is never invoked on the AWT Event Dispatcher 
     * Thread.
     */
    public void loadImage(InputStream in) throws IOException;
    /**
     * Gets the buffered image from the figure.
     */
    @Nullable public BufferedImage getBufferedImage();
    /**
     * Sets the buffered image for the figure.
     */
    public void setBufferedImage(@Nullable BufferedImage image);
    
    /**
     * Sets the image.
     *
     * @param imageData The image data. If this is null, a buffered image must
     * be provided.
     * @param bufferedImage An image constructed from the imageData. If this
     * is null, imageData must be provided.
     */
    public void setImage(@Nullable byte[] imageData, @Nullable BufferedImage bufferedImage) throws IOException;
    /**
     * Gets the image data.
     *
     * @return imageData The image data, or null, if the ImageHolderFigure does
     * not have an image.
     */
    @Nullable public byte[] getImageData();

}
