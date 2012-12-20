/*
 * @(#)URIChooser.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.net.URI;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

/**
 *{@code URIChooser} provides a mechanism for the user to choose a URI.
 *
 * @author Werner Randelshofer
 * @version $Id: URIChooser.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface URIChooser {
    // ************************
    // ***** Dialog Types *****
    // ************************

    /**
     * Type value indicating that the {@code URIChooser}  supports an
     * "Open" file operation.
     */
    public static final int OPEN_DIALOG = JFileChooser.OPEN_DIALOG;
    /**
     * Type value indicating that the {@code URIChooser}  supports a
     * "Save" file operation.
     */
    public static final int SAVE_DIALOG = JFileChooser.SAVE_DIALOG;
    /**
     * Type value indicating that the {@code URIChooser}  supports a
     * developer-specified file operation.
     */
    public static final int CUSTOM_DIALOG = JFileChooser.CUSTOM_DIALOG;
    // ********************************
    // ***** Dialog Return Values *****
    // ********************************
    /**
     * Return value if cancel is chosen.
     */
    public static final int CANCEL_OPTION = JFileChooser.CANCEL_OPTION;
    /**
     * Return value if approve (yes, ok) is chosen.
     */
    public static final int APPROVE_OPTION = JFileChooser.APPROVE_OPTION;
    /**
     * Return value if an error occured.
     */
    public static final int ERROR_OPTION = JFileChooser.ERROR_OPTION;
    // **********************************
    // ***** URIChooser properties *****
    // **********************************
    /** Instruction to cancel the current selection. */
    public static final String CANCEL_SELECTION = JFileChooser.CANCEL_SELECTION;
    /**
     * Instruction to approve the current selection
     * (same as pressing yes or ok).
     */
    public static final String APPROVE_SELECTION = JFileChooser.APPROVE_SELECTION;
    /**
     * Identifies a change in the selected URI.
     */
    public static final String SELECTED_URI_PROPERTY = "selectedURI";
    /** 
     * Identifies a change in the dialog title.
     */
    public static final String DIALOG_TITLE_PROPERTY = JFileChooser.DIALOG_TITLE_CHANGED_PROPERTY;

    /**
     * Returns the selected URI.
     *
     * @see #setSelectedURI
     * @return the selected uri
     */
    @Nullable public URI getSelectedURI();

    /**
     * Sets the selected URI.
     *
     * @param uri the selected uri
     */
    public void setSelectedURI(@Nullable URI uri);

    /**
     * Returns the type of this dialog.  The default is
     * {@code URIChooser.OPEN_DIALOG}.
     *
     * @return   the type of dialog to be displayed:
     * <ul>
     * <li>URIChooser.OPEN_DIALOG
     * <li>URIChooser.SAVE_DIALOG
     * <li>URIChooser.CUSTOM_DIALOG
     * </ul>
     *
     * @see #setDialogType
     */
    public int getDialogType();

    /**
     * Sets the type of this dialog. Use {@code OPEN_DIALOG} when you
     * want to bring up a chooser that the user can use to open an URI.
     * Likewise, use {@code SAVE_DIALOG} for letting the user choose
     * an URI for saving.
     * Use {@code CUSTOM_DIALOG} when you want to use the
     * chooser in a context other than "Open" or "Save".
     * For instance, you might want to bring up a chooser that allows
     * the user to choose an URI to execute. Note that you normally would not
     * need to set the {@code URIChooser} to use
     * {@code CUSTOM_DIALOG}
     * since a call to {@code setApproveButtonText} does this for you.
     * The default dialog type is {@code URIChooser.OPEN_DIALOG}.
     *
     * @param dialogType the type of dialog to be displayed:
     * <ul>
     * <li>URIChooser.OPEN_DIALOG
     * <li>URIChooser.SAVE_DIALOG
     * <li>URIChooser.CUSTOM_DIALOG
     * </ul>
     *
     * @exception IllegalArgumentException if {@code dialogType} is
     *				not legal
     * @see #getDialogType
     * @see #setApproveButtonText
     */
    public void setDialogType(int dialogType);

    /**
     * Returns the text used in the {@code ApproveButton} .
     * If {@code null} , the UI object will determine the button's text.
     *
     * Typically, this would be "Open" or "Save".
     *
     * @return the text used in the {@code ApproveButton}
     *
     * @see #setApproveButtonText
     * @see #setDialogType
     * @see #showDialog
     */
    @Nullable public String getApproveButtonText();

    /**
     * Sets the text used in the {@code ApproveButton}  in the
     * {@code FileChooserUI} .
     *
     * @param approveButtonText the text used in the {@code ApproveButton}
     *
     * @see #getApproveButtonText
     * @see #setDialogType
     */
    public void setApproveButtonText(String approveButtonText);

    /**
     * Returns the approve button's mnemonic.
     * @return an integer value for the mnemonic key
     *
     * @see #setApproveButtonMnemonic
     */
    public int getApproveButtonMnemonic();

    /**
     * Sets the approve button's mnemonic using a numeric keycode.
     *
     * @param mnemonic  an integer value for the mnemonic key
     *
     * @see #getApproveButtonMnemonic
     */
    public void setApproveButtonMnemonic(int mnemonic);

    /**
     * Returns the component of the URIChooser.
     * <p>
     * Typically, this would return {@code this}.
     *
     * @return The component.
     */
    public JComponent getComponent();

    /**
     * Adds an {@code ActionListener}  to the chooser.
     *
     * @param l  the listener to be added
     */
    public void addActionListener(ActionListener l);

    /**
     * Removes an {@code ActionListener}  from the chooser.
     *
     * @param l  the listener to be removed
     *
     * @see #addActionListener
     */
    public void removeActionListener(ActionListener l);

    /**
     * Sets the string that goes in the {@code URIChooser}  window's
     * title bar.
     *
     * @param dialogTitle the new {@code String}  for the title bar
     *
     * @see #getDialogTitle
     *
     */
    public void setDialogTitle(String dialogTitle);

    /**
     * Gets the string that goes in the {@code URIChooser} 's titlebar.
     *
     * @see #setDialogTitle
     */
    public String getDialogTitle();

    /**
     * Tells the UI to rescan its files list from the current directory.
     */
    public void rescanCurrentDirectory();

    // **************************************
    // ***** URIChooser Dialog methods *****
    // **************************************
    /**
     * Pops up an "Open" chooser dialog. Note that the
     * text that appears in the approve button is determined by
     * the L&F.
     *
     * @param    parent  the parent component of the dialog,
     *			can be {@code null};
     *                  see {@code showDialog}  for details
     * @return   the return state of the file chooser on popdown:
     * <ul>
     * <li>URIChooser.CANCEL_OPTION
     * <li>URIChooser.APPROVE_OPTION
     * <li>URIChooser.ERROR_OPTION if an error occurs or the
     *			dialog is dismissed
     * </ul>
     * @exception HeadlessException if GraphicsEnvironment.isHeadless()
     * returns true.
     * @see java.awt.GraphicsEnvironment#isHeadless
     * @see #showDialog
     */
    public int showOpenDialog(@Nullable Component parent) throws HeadlessException;

    /**
     * Pops up a "Save File" file chooser dialog. Note that the
     * text that appears in the approve button is determined by
     * the L&F.
     *
     * @param    parent  the parent component of the dialog,
     *			can be {@code null} ;
     *                  see {@code showDialog}  for details
     * @return   the return state of the file chooser on popdown:
     * <ul>
     * <li>URIChooser.CANCEL_OPTION
     * <li>URIChooser.APPROVE_OPTION
     * <li>URIChooser.ERROR_OPTION if an error occurs or the
     *			dialog is dismissed
     * </ul>
     * @exception HeadlessException if GraphicsEnvironment.isHeadless()
     * returns true.
     * @see java.awt.GraphicsEnvironment#isHeadless
     * @see #showDialog
     */
    public int showSaveDialog(@Nullable Component parent) throws HeadlessException;

    /**
     * Pops a custom file chooser dialog with a custom approve button.
     * For example, the following code
     * pops up a file chooser with a "Run Application" button
     * (instead of the normal "Save" or "Open" button):
     * <pre>
     * filechooser.showDialog(parentFrame, "Run Application");
     * </pre>
     *
     * Alternatively, the following code does the same thing:
     * <pre>
     *    URIChooser chooser = new URIChooser(null);
     *    chooser.setApproveButtonText("Run Application");
     *    chooser.showDialog(parentFrame, null);
     * </pre>
     *
     * <!--PENDING(jeff) - the following method should be added to the api:
     *      showDialog(Component parent);-->
     * <!--PENDING(kwalrath) - should specify modality and what
     *      "depends" means.-->
     *
     * <p>
     *
     * The {@code parent}  argument determines two things:
     * the frame on which the open dialog depends and
     * the component whose position the look and feel
     * should consider when placing the dialog.  If the parent
     * is a {@code Frame</code> object (such as a <code>JFrame} )
     * then the dialog depends on the frame and
     * the look and feel positions the dialog
     * relative to the frame (for example, centered over the frame).
     * If the parent is a component, then the dialog
     * depends on the frame containing the component,
     * and is positioned relative to the component
     * (for example, centered over the component).
     * If the parent is {@code null} , then the dialog depends on
     * no visible window, and it's placed in a
     * look-and-feel-dependent position
     * such as the center of the screen.
     *
     * @param   parent  the parent component of the dialog;
     *			can be {@code null}
     * @param   approveButtonText the text of the {@code ApproveButton}
     * @return  the return state of the file chooser on popdown:
     * <ul>
     * <li>URIChooser.CANCEL_OPTION
     * <li>URIChooser.APPROVE_OPTION
     * <li>JFileCHooser.ERROR_OPTION if an error occurs or the
     *			dialog is dismissed
     * </ul>
     * @exception HeadlessException if GraphicsEnvironment.isHeadless()
     * returns true.
     * @see java.awt.GraphicsEnvironment#isHeadless
     */
    public int showDialog(@Nullable Component parent, String approveButtonText) throws HeadlessException;
}
