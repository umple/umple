/*
 * @(#)PaletteColorSliderUI.java
 * 
 * Copyright (c) 2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.gui.plaf.palette;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.plaf.ComponentUI;
import org.jhotdraw.color.ColorSliderUI;

/**
 * PaletteColorSliderUI.
 *
 * @author Werner Randelshofer
 * @version $Id$
 */
public class PaletteColorSliderUI extends ColorSliderUI {
    /** Creates a new instance. */
    public PaletteColorSliderUI(JSlider b) {
        super(b);
    }

    public static ComponentUI createUI(JComponent b) {
        return new PaletteColorSliderUI((JSlider) b);
    }
    @Override
    protected Icon getThumbIcon() {
        String key;
        if (slider.getOrientation() == JSlider.HORIZONTAL) {
            key="Slider.northThumb.small";
        } else {
            key="Slider.westThumb.small";
        }
            Icon icon = PaletteLookAndFeel.getInstance().getIcon(key);
            if (icon==null) {
                throw new InternalError(key+" missing in PaletteLookAndFeel");
            }
            return icon;
    }

}
