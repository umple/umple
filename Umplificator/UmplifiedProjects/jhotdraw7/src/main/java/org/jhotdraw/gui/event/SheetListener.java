/*
 * @(#)SheetListener.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.gui.event;

import java.util.*;

/**
 * SheetListener.
 *
 * @author  Werner Randelshofer
 * @version $Id: SheetListener.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface SheetListener extends EventListener {
    /**
     * This method is invoked, when the user selected an option on the
     * JOptionPane or the JFileChooser pane on the JSheet.
     */
    public void optionSelected(SheetEvent evt);
}
