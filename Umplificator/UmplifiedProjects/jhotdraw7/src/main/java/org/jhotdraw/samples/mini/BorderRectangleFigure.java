/*
 * @(#)BorderRectangle2D.DoubleFigure.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.mini;

import org.jhotdraw.draw.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * BorderRectangle2D.DoubleFigure.
 *
 * @deprecated This class should be in one of the samples package
 *
 * @author  Werner Randelshofer
 * @version $Id: BorderRectangleFigure.java 718 2010-11-21 17:49:53Z rawcoder $
 */
public class BorderRectangleFigure extends RectangleFigure {
    protected Border border;
    protected final static JComponent borderComponent = new JPanel();
    
    /** Creates a new instance. */
    public BorderRectangleFigure(Border border) {
        this.border = border;
    }
    
    public void drawFigure(Graphics2D g) {
        Rectangle bounds = getBounds().getBounds();
        border.paintBorder(borderComponent, g, bounds.x, bounds.y, bounds.width, bounds.height);
    }
}
