/*
 * @(#)PaletteSliderThumbIcon.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.gui.plaf.palette;

import java.awt.*;
import javax.swing.*;
import org.jhotdraw.util.Images;

/**
 * An Icon with different visuals reflecting the state of the slider
 * on which it draws on.
 *
 * @author  Werner Randelshofer
 * @version $Id: PaletteSliderThumbIcon.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class PaletteSliderThumbIcon extends MultiIcon {
    private final static int E = 0;
    private final static int EP = 1;
    private final static int D = 2;
    private final static int I = 3;
    private final static int DI = 4;
    private final static int FOCUS_RING = 5;
    
    /**
     * Creates a new instance.
     * All icons must have the same dimensions.
     * If an icon is null, an icon is derived for the state from the
     * other icons.
     */
    public PaletteSliderThumbIcon(Icon e, Icon ep, Icon d, Icon i, Icon di) {
        super(new Icon[] {e, ep, d, i, di});
    }
    /**
     * Creates a new instance.
     * All icons must have the same dimensions.
     *
     * The array indices are used to represente the following states:
     * [0] Enabled
     * [1] Enabled Pressed
     * [2] Disabled
     * [3] Enabled Inactive
     * [4] Disabled Inactive
     * [5] Focus Ring
     *
     * If an array element is null, an icon is derived for the state from the
     * other icons.
     */
    public PaletteSliderThumbIcon(Image[] images) {
        super(images);
    }
    /**
     * Creates a new instance.
     * All icons must have the same dimensions.
     * If an icon is null, nothing is drawn for this state.
     */
    public PaletteSliderThumbIcon(Icon[] icons) {
        super(icons);
    }
    
    /**
     * Creates a new instance.
     * The icon representations are created lazily from the image.
     */
    public PaletteSliderThumbIcon(Image tiledImage, int tileCount, boolean isTiledHorizontaly) {
        super(tiledImage, tileCount, isTiledHorizontaly);
    }

    /**
     * Creates a new instance.
     * The icon representations are created lazily from the specified resource.
     *
     * @param resource A resource URL.
     * @param tileCount The number of tiles.
     * @param isTiledHorizontaly True if the image is to be tilled horizontally,
     * false for vertically.
     */
    public PaletteSliderThumbIcon(String resource, int tileCount, boolean isTiledHorizontaly) {
        super(Images.createImage(PaletteSliderThumbIcon.class.getResource(resource)), tileCount, isTiledHorizontaly);
    }
    
    @Override
    protected void generateMissingIcons() {
        Icon[] oldIcons;
        if (icons.length != 6) {
            oldIcons = new Icon[6];
            System.arraycopy(icons, 0, oldIcons, 0, Math.min(icons.length, 6));
        } else {
            oldIcons = icons;
        }
        if (icons[EP] == null) {
            icons[EP] = icons[E];
        }
        if (icons[D] == null) {
            icons[D] = icons[E];
        }
        if (icons[I] == null) {
            icons[I] = icons[E];
        }
        if (icons[DI] == null) {
            icons[DI] = icons[D];
        }
    }
    
    protected Icon getIcon(Component c) {
        Icon icon;
        boolean isActive = true; //QuaquaUtilities.isOnActiveWindow(c);
        
        if (c instanceof JSlider) {
            JSlider slider = (JSlider) c;
            if (isActive) {
                if (c.isEnabled()) {
                    if (slider.getModel().getValueIsAdjusting()) {
                        icon = icons[EP];
                    } else {
                        icon = icons[E];
                    }
                } else {
                    icon = icons[D];
                }
            } else {
                if (c.isEnabled()) {
                    icon = icons[I];
                } else {
                    icon = icons[DI];
                }
            }
        } else {
            if (isActive) {
                if (c.isEnabled()) {
                    icon = icons[E];
                } else {
                    icon = icons[D];
                }
            } else {
                if (c.isEnabled()) {
                    icon = icons[I];
                } else {
                    icon = icons[DI];
                }
            }
        }
        return icon;
    }
    public void paintIcon(java.awt.Component c, java.awt.Graphics g, int x, int y) {
        super.paintIcon(c, g, x, y);
        if (c.isFocusOwner()/*QuaquaUtilities.isFocused(c)*/ &&
                icons[FOCUS_RING] != null) {
            icons[FOCUS_RING].paintIcon(c, g, x, y);
        }
    }
}


