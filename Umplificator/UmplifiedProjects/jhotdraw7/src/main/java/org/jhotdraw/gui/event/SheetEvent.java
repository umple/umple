/*
 * @(#)SheetEvent.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.gui.event;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.*;
import javax.swing.*;
import org.jhotdraw.gui.URIChooser;
import org.jhotdraw.gui.JSheet;

/**
 * SheetEvent.
 *
 * @author  Werner Randelshofer
 * @version $Id: SheetEvent.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class SheetEvent extends EventObject {
    private Object pane;
    private int option;
    @Nullable private Object value;
    @Nullable private Object inputValue;
    
    /**
     * Creates a new instance.
     */
    public SheetEvent(JSheet source) {
        super(source);
    }
    /**
     * Creates a new instance.
     */
    public SheetEvent(JSheet source, JFileChooser fileChooser, int option, @Nullable Object value) {
        super(source);
        this.pane = fileChooser;
        this.option = option;
        this.value = value;
    }
    /**
     * Creates a new instance.
     */
    public SheetEvent(JSheet source, URIChooser chooser, int option, @Nullable Object value) {
        super(source);
        this.pane = chooser;
        this.option = option;
        this.value = value;
    }
    /**
     * Creates a new instance.
     */
    public SheetEvent(JSheet source, JOptionPane optionPane, int option, @Nullable Object value, @Nullable Object inputValue) {
        super(source);
        this.pane = optionPane;
        this.option = option;
        this.value = value;
        this.inputValue = inputValue;
    }
    
    /**
     * Returns the pane on the sheet. This is either a JFileChooser, a URIChooser or a
     * JOptionPane.
     */
    public Object getPane() {
        return pane;
    }
    /**
     * Returns the JFileChooser pane on the sheet.
     */
    public JFileChooser getFileChooser() {
        return (JFileChooser) pane;
    }
    /**
     * Returns the URIChooser pane on the sheet.
     */
    public URIChooser getChooser() {
        return (URIChooser) pane;
    }
    /**
     * Returns the JOptionPane pane on the sheet.
     */
    public JOptionPane getOptionPane() {
        return (JOptionPane) pane;
    }
    /**
     * Returns the option that the JFileChooser or JOptionPane returned.
     */
    public int getOption() {
        return option;
    }
    /**
     * Returns the value that the JFileChooser or JOptionPane returned.
     */
    public Object getValue() {
        return value;
    }    
    /**
     * Returns the input value that the JOptionPane returned, if it wants input.
     */
    public Object getInputValue() {
        return inputValue;
    }    
}
