/**
 * @(#)PaletteButtonUI.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui.plaf.palette;

import java.awt.Graphics;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;

/**
 * ButtonUI for palette components.
 *
 * @author Werner Randelshofer
 * @version $Id: PaletteButtonUI.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class PaletteButtonUI extends BasicButtonUI {
    // Shared UI object
    private final static PaletteButtonUI buttonUI = new PaletteButtonUI();

    // ********************************
    //          Create PLAF
    // ********************************
    public static ComponentUI createUI(JComponent c) {
        return buttonUI;
    }

    @Override
    protected void installDefaults(AbstractButton b) {
        super.installDefaults(b);

        // load shared instance defaults
        String pp = getPropertyPrefix();

        LookAndFeel.installProperty(b, "opaque", Boolean.FALSE);


        if (b.getMargin() == null || (b.getMargin() instanceof UIResource)) {
            b.setMargin(new InsetsUIResource(0, 0, 0, 0));
        }

        PaletteLookAndFeel.installColorsAndFont(b, pp + "background",
                pp + "foreground", pp + "font");
        PaletteLookAndFeel.installBorder(b, pp + "border");

        Object rollover = UIManager.get(pp + "rollover");
        if (rollover != null) {
            LookAndFeel.installProperty(b, "rolloverEnabled", rollover);
        }
        
        b.setFocusable(false);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        AbstractButton button = (AbstractButton) c;
        if (button.isBorderPainted() && (c.getBorder() instanceof BackdropBorder)) {
            BackdropBorder bb = (BackdropBorder) c.getBorder();
            bb.getBackdropBorder().paintBorder(c, g, 0, 0, c.getWidth(), c.getHeight());
        }
        super.paint(g, c);
    }
}
