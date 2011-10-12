/*
 * @(#)DrawingComponent.java
 *
 * Copyright (c) 2007-2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.svg.gui;

import java.awt.event.*;
import javax.swing.*;
import org.jhotdraw.draw.*;

/**
 * The DrawingComponent holds the drawing editor used by the DrawingApplet.
 * <p>
 * The DrawingComponent covers the whole content pane of the DrawingApplet. 
 * It thus has to provide the user interface elements for saving the drawing and
 * canceling the applet on its own. The DrawingApplet registers with the 
 * DrawingComponent as an ActionListener to receive "save" and "cancel" action 
 * commands.
 * 
 * @author Werner Randelshofer
 * @version $Id: DrawingComponent.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface DrawingComponent {
    /**
     * Returns the component of the DrawingComponent.
     */
    public JComponent getComponent();
    /**
     * Returns the drawing of the DrawingComponent.
     */
    public Drawing getDrawing();
    /**
     * Sets the drawing of the DrawingComponent.
     */
    public void setDrawing(Drawing newValue);
    
    /**
     * Adds an ActionListener.
     * <p>
     * The ActionListener receives an ActionEvent with action command "save"
     * when the user clicks at the save button on the drawing component.
     * <p>
     * The ActionListener receives an ActionEvent with action command "cancel"
     * when the user clicks at the cancel button on the drawing component.
     */
    public void addActionListener(ActionListener listener);
    
    /**
     * Removes an ActionListener.
     */
    public void removeActionListener(ActionListener listener);

    /**
     * Returns a summary about the changes made on the drawing.
     */
    public String getSummary();
}
