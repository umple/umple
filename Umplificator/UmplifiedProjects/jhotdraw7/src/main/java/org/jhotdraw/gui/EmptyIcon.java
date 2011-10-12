/**
 * @(#)EmptyIcon.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.gui;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.Icon;

/**
 * EmptyIcon.
 *
 * @author Werner Randelshofer
 * @version $Id: EmptyIcon.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class EmptyIcon implements Icon {
    private int width;
    private int height;
    
    public EmptyIcon(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
    }

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }

}
