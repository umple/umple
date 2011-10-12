/*
 * @(#)JSheet.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import javax.swing.plaf.*;
import org.jhotdraw.gui.event.*;
import org.jhotdraw.util.*;

/**
 * JSheet is a document modal dialog which is displayed below the title bar
 * of a JFrame.
 * <p>
 * A JSheet blocks input on its owner window, while it is visible.
 * <p>
 * Unlike application modal dialogs, the show method of a JSheet does return
 * immediately, when the JSheet has become visible. Applications need to use
 * a SheetListener to get the return value of a JSheet.
 * <p>
 * Requires Java 1.4.
 * <p>
 * Caveats: We are using an unsupported API call to make the JSheet translucent.
 * This API may go away in future versions of the Macintosh Runtime for Java.
 * In such a case, we (hopefully) just end up with a non-opaque sheet.
 *
 * @author  Werner Randelshofer
 * @version $Id: JSheet.java 735 2011-02-02 17:09:47Z rawcoder $
 */
public class JSheet extends JDialog {

    /**
     * Event listener list.
     */
    protected EventListenerList listenerList = new EventListenerList();
    /**
     * This handler is used to handle movements of the owner.
     * If the owner moves, we have to change the location of the sheet as well.
     */
    private ComponentListener ownerMovementHandler;
    /**
     * If this is non-null, we put the owner to the specified location,
     * when the sheet is hidden.
     */
    @Nullable private Point shiftBackLocation;
    /**
     * We need to keep track of the old owner position, in order to avoid
     * processing duplicate owner moved events.
     */
    private Point oldLocation;
    /**
     * Focus owner on the owner window, before the sheet is shown.
     */
    private Component oldFocusOwner;
    /**
     * This is set to true, when the listeners for the JSheet are installed on
     * the parent component.
     */
    private boolean isInstalled;
    /**
     * If this is set to true, the JSheet uses a transition effect when shown
     * and when hidden.
     */
    private boolean isAnimated = true;
    /**
     * If this is set to true, the JSheet uses native Mac OS X sheets.
     */
    private static final boolean isNativeSheetSupported;
    /**
     * If this is set to true, the JSheet uses native document modal dialogs.
     */
    private static final boolean isDocumentModalitySupported;
    /**
     * This variable is only used in Java 1.5 and previous versions.
     * In order to make the sheet document modal, we have to block events on
     * the owner window. We do this by setting a JPanel as the glass
     * pane on the owner window.
     * Before we do this, we store the glass pane of the owner window here,
     * and restore it after we have finished.
     */
    @Nullable private Component ownersGlassPane;

    static {
        // SoyLatte doesn't properly support document modal dialogs yet.
        isDocumentModalitySupported = !System.getProperty("os.name").equals("Darwin")
                && System.getProperty("java.version").compareTo("1.6") >= 0;
        isNativeSheetSupported = System.getProperty("os.name").toLowerCase().startsWith("mac os x")
                && System.getProperty("java.version").compareTo("1.6") >= 0;
    }

    /**
     * Creates a new JSheet.
     */
    public JSheet(Frame owner) {
        super(owner);
        init();
    }

    /**
     * Creates a new JSheet.
     */
    public JSheet(Dialog owner) {
        super(owner);
        init();
    }

    private void init() {
        if (getOwner() != null && isShowAsSheet()) {
            if (isNativeSheetSupported()) {
                getRootPane().putClientProperty("apple.awt.documentModalSheet", Boolean.TRUE);
            } else {
                setUndecorated(true);
                getRootPane().setWindowDecorationStyle(JRootPane.NONE);
                getRootPane().setBorder(UIManager.getBorder("Sheet.border"));
            }
            if (isDocumentModalitySupported()) {
                Methods.invokeIfExistsWithEnum(this, "setModalityType", "java.awt.Dialog$ModalityType", "DOCUMENT_MODAL");
            }
        }

        // We move the sheet when the user moves the owner, so that it
        // will always stay centered below the title bar of the owner.
        // If the user has moved the owner, we 'forget' the shift back location,
        // and don't shift the owner back to the place it was, when we opened
        // the sheet.
        ownerMovementHandler = new ComponentAdapter() {

            @Override
            public void componentMoved(ComponentEvent evt) {
                Window owner = getOwner();
                Point newLocation = owner.getLocation();
                if (!newLocation.equals(oldLocation)) {
                    setLocation(
                            newLocation.x + (owner.getWidth() - getWidth()) / 2,
                            newLocation.y + owner.getInsets().top);
                    shiftBackLocation = null;
                    oldLocation = newLocation;
                }
            }
        };
    }

    protected boolean isShowAsSheet() {
        return UIManager.getLookAndFeel().getID().equals("Aqua") || UIManager.getBoolean("Sheet.showAsSheet");
    }

    /**
     * Installs the sheet on the owner.
     * This method is invoked just before the JSheet is shown.
     */
    protected void installSheet() {
        if (!isNativeSheetSupported() && !isInstalled) {
            Window owner = getOwner();
            if (owner != null) {

                // Determine the location for the sheet and its owner while
                // the sheet will be visible.
                // In case we have to shift the owner to fully display the
                // dialog, we remember the shift back position.
                Point ownerLoc = owner.getLocation();
                Point sheetLoc;
                if (isShowAsSheet()) {
                    if (owner instanceof JFrame) {
                        sheetLoc = new Point(
                                ownerLoc.x + (owner.getWidth() - getWidth()) / 2,
                                ownerLoc.y + owner.getInsets().top + ((JFrame) owner).getRootPane().getContentPane().getY());
                    } else if (owner instanceof JDialog) {
                        sheetLoc = new Point(
                                ownerLoc.x + (owner.getWidth() - getWidth()) / 2,
                                ownerLoc.y + owner.getInsets().top + ((JDialog) owner).getRootPane().getContentPane().getY());
                    } else {
                        sheetLoc = new Point(
                                ownerLoc.x + (owner.getWidth() - getWidth()) / 2,
                                ownerLoc.y + owner.getInsets().top);
                    }

                    if (sheetLoc.x < 0) {
                        owner.setLocation(ownerLoc.x - sheetLoc.x, ownerLoc.y);
                        sheetLoc.x = 0;
                        shiftBackLocation = ownerLoc;
                        oldLocation = owner.getLocation();
                    } else {
                        shiftBackLocation = null;
                        oldLocation = ownerLoc;
                    }
                } else {
                    sheetLoc = new Point(
                            ownerLoc.x + (owner.getWidth() - getWidth()) / 2,
                            ownerLoc.y + (owner.getHeight() - getHeight()) / 3);
                }
                setLocation(sheetLoc);

                oldFocusOwner = owner.getFocusOwner();

                // Note: We mustn't change the windows focusable state because
                // this also affects the focusable state of the JSheet.
                //owner.setFocusableWindowState(false);
                owner.setEnabled(false);
                // ((JFrame) owner).setResizable(false);
                if (isShowAsSheet()) {
                    owner.addComponentListener(ownerMovementHandler);
                } else {
                    if (owner instanceof Frame) {
                        setTitle(((Frame) owner).getTitle());
                    }
                }
            }
            isInstalled = true;
        } else {
            Window owner = getOwner();
            Point ownerLoc = owner.getLocation();
            Point sheetLoc = new Point(
                    ownerLoc.x + (owner.getWidth() - getWidth()) / 2,
                    ownerLoc.y + (owner.getHeight() - getHeight()) / 3);
            setLocation(sheetLoc);
        }
    }

    /**
     * Uninstalls the sheet on the owner.
     * This method is invoked immediately after the JSheet is hidden.
     */
    protected void uninstallSheet() {
        if (isInstalled) {
            Window owner = getOwner();
            if (owner != null) {
                // Note: We mustn't change the windows focusable state because
                // this also affects the focusable state of the JSheet.
                //owner.setFocusableWindowState(true);
                owner.setEnabled(true);
                //((JFrame) owner).setResizable(true);
                owner.removeComponentListener(ownerMovementHandler);

                if (shiftBackLocation != null) {
                    owner.setLocation(shiftBackLocation);
                }
                if (oldFocusOwner != null) {
                    owner.toFront();
                    oldFocusOwner.requestFocus();
                }
            }
            isInstalled = false;
        }
    }

    @Override
    public void addNotify() {
        super.addNotify();
        if (UIManager.getBoolean("Sheet.showAsSheet")) {
            // QuaquaUtilities.setWindowAlpha(this, 240);
        }
    }

    /**
     * If this is set to true, the JSheet uses a transition effect when shown
     * and when hidden.
     */
    public void setAnimated(boolean newValue) {
        boolean oldValue = isAnimated;
        isAnimated = newValue;
        firePropertyChange("animated", oldValue, newValue);
    }

    /**
     * If this returns true, the JSheet uses a transition effect when shown
     * and when hidden.
     */
    public boolean isAnimated() {
        return isAnimated;
    }

    /**
     * If this returns true, the JSheet uses native support for
     * sheet display.
     */
    private static boolean isNativeSheetSupported() {
        return isNativeSheetSupported;
    }

    /**
     * If this returns true, the JSheet uses native support for
     * sheet display.
     */
    private static boolean isDocumentModalitySupported() {
        return isDocumentModalitySupported;
    }

    @Override
    public void dispose() {
        super.dispose();
        uninstallSheet();
    }

    @SuppressWarnings("deprecation")
    protected void hide0() {
        JRootPane rp = null;
        if (getOwner() instanceof JFrame) {
            rp = ((JFrame) getOwner()).getRootPane();
        } else if (getOwner() instanceof JDialog) {
            rp = ((JDialog) getOwner()).getRootPane();
        }
        if (rp != null && !isDocumentModalitySupported()) {
            Component blockingComponent = rp.getGlassPane();
            blockingComponent.setVisible(false);
            if (ownersGlassPane != null) {
                rp.setGlassPane(ownersGlassPane);
                ownersGlassPane = null;
            }
        }
        super.hide();
    }

    @SuppressWarnings("deprecation")
    protected void show0() {
        JRootPane rp = null;
        if (getOwner() instanceof JFrame) {
            rp = ((JFrame) getOwner()).getRootPane();
        } else if (getOwner() instanceof JDialog) {
            rp = ((JDialog) getOwner()).getRootPane();
        }
        if (rp != null && !isDocumentModalitySupported()) {
            ownersGlassPane = rp.getGlassPane();
            JPanel blockingPanel = new JPanel();
            blockingPanel.setOpaque(false);
            rp.setGlassPane(blockingPanel);
            blockingPanel.setVisible(true);
        }
        super.show();
    }

    @SuppressWarnings("deprecation")
    @Override
    public void hide() {
        if (isAnimated() && isShowAsSheet() && !isNativeSheetSupported()) {
            getContentPane().setVisible(false);

            final Rectangle startBounds = getBounds();
            int parentWidth = getParent().getWidth();
            final Rectangle endBounds = new Rectangle(
                    (parentWidth < startBounds.width) ? startBounds.x + (startBounds.width - parentWidth) / 2 : startBounds.x,
                    startBounds.y,
                    Math.min(startBounds.width, parentWidth),
                    0);
            final Timer timer = new Timer(20, null);
            timer.addActionListener(new ActionListener() {

                long startTime;
                long endTime;

                @Override
                public void actionPerformed(ActionEvent evt) {
                    long now = System.currentTimeMillis();
                    if (startTime == 0) {
                        startTime = now;
                        endTime = startTime + 200;
                    }
                    if (now > endTime) {
                        timer.stop();
                        hide0();
                        setBounds(startBounds);
                        getContentPane().setVisible(true);
                        uninstallSheet();
                    } else {
                        float ratio = (now - startTime) / (float) (endTime - startTime);
                        setBounds(
                                (int) (startBounds.x * (1f - ratio) + endBounds.x * ratio),
                                (int) (startBounds.y * (1f - ratio) + endBounds.y * ratio),
                                (int) (startBounds.width * (1f - ratio) + endBounds.width * ratio),
                                (int) (startBounds.height * (1f - ratio) + endBounds.height * ratio));
                    }
                }
            });
            timer.setRepeats(true);
            timer.setInitialDelay(5);
            timer.start();
        } else {
            hide0();
            uninstallSheet();
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void show() {
        if (isAnimated() && isShowAsSheet() && !isNativeSheetSupported()) {
            installSheet();
            getContentPane().setVisible(false);

            final Rectangle endBounds = getBounds();
            int parentWidth = getParent().getWidth();
            final Rectangle startBounds = new Rectangle(
                    (parentWidth < endBounds.width) ? endBounds.x + (endBounds.width - parentWidth) / 2 : endBounds.x,
                    endBounds.y,
                    Math.min(endBounds.width, parentWidth),
                    0);
            setBounds(startBounds);
            if (!isDocumentModalitySupported()) {
                ((Window) getParent()).toFront();
            }
            show0();
            final Timer timer = new Timer(20, null);
            timer.addActionListener(new ActionListener() {

                long startTime;
                long endTime;

                @Override
                public void actionPerformed(ActionEvent evt) {
                    long now = System.currentTimeMillis();
                    if (startTime == 0) {
                        startTime = now;
                        endTime = startTime + 200;
                    }
                    if (now > endTime) {
                        timer.stop();
                        setBounds(endBounds);
                        getContentPane().setVisible(true);

                        Component c = getFocusTraversalPolicy().getInitialComponent(JSheet.this);
                        if (c != null) {
                            c.requestFocus();
                        } else {
                            getContentPane().requestFocus();
                        }
                    } else {
                        float ratio = (now - startTime) / (float) (endTime - startTime);
                        setBounds(
                                (int) (startBounds.x * (1f - ratio) + endBounds.x * ratio),
                                (int) (startBounds.y * (1f - ratio) + endBounds.y * ratio),
                                (int) (startBounds.width * (1f - ratio) + endBounds.width * ratio),
                                (int) (startBounds.height * (1f - ratio) + endBounds.height * ratio));
                    }
                }
            });
            timer.setRepeats(true);
            timer.setInitialDelay(5);
            timer.start();
        } else {
            installSheet();
            show0();
        }
        requestUserAttention(true);
    }

    /**
     * Requests attention from user. This is invoked when the sheet is opened.
     */
    public static void requestUserAttention(boolean requestCritical) {
        /*
        NSApplication app = NSApplication.sharedApplication();
        int id = app.requestUserAttention(
        NSApplication.UserAttentionRequestInformational);
         */
        /*
        try {
        Object app = Methods.invokeStatic("com.apple.cocoa.application.NSApplication", "sharedApplication");
        Methods.invoke(app, "requestUserAttention", app.getClass().getDeclaredField("UserAttentionRequestInformational").getInt(app));
        } catch (Throwable ex) {
        System.err.println("Quaqua Warning: Couldn't invoke NSApplication.requestUserAttention");
        }*/
    }

    /**
     * Adds a sheet listener.
     */
    public void addSheetListener(SheetListener l) {
        listenerList.add(SheetListener.class, l);
    }

    /**
     * Removes a sheet listener.
     */
    public void removeSheetListener(SheetListener l) {
        listenerList.remove(SheetListener.class, l);
    }

    /**
     * Notify all listeners that have registered interest for
     *   notification on this event type.  The event instance
     *   is lazily created using the parameters passed into
     *   the fire method.
     */
    protected void fireOptionSelected(JOptionPane pane) {
        Object value = pane.getValue();
        int option;

        if (value == null) {
            option = JOptionPane.CLOSED_OPTION;
        } else {
            if (pane.getOptions() == null) {
                if (value instanceof Integer) {
                    option = ((Integer) value).intValue();
                } else {
                    option = JOptionPane.CLOSED_OPTION;
                }
            } else {
                option = JOptionPane.CLOSED_OPTION;
                Object[] options = pane.getOptions();
                for (int i = 0, n = options.length; i < n; i++) {
                    if (options[i].equals(value)) {
                        option = i;
                        break;
                    }
                }
                if (option == JOptionPane.CLOSED_OPTION) {
                    value = null;
                }
            }
        }

        fireOptionSelected(pane, option, value, pane.getInputValue());
    }

    /**
     * Notify all listeners that have registered interest for
     *   notification on this event type.  The event instance
     *   is lazily created using the parameters passed into
     *   the fire method.
     */
    protected void fireOptionSelected(JOptionPane pane, int option, @Nullable Object value, @Nullable Object inputValue) {
        SheetEvent sheetEvent = null;
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == SheetListener.class) {
                // Lazily create the event:
                if (sheetEvent == null) {
                    sheetEvent = new SheetEvent(this, pane, option, value, inputValue);
                }
                ((SheetListener) listeners[i + 1]).optionSelected(sheetEvent);
            }
        }
    }

    /**
     * Notify all listeners that have registered interest for
     *   notification on this event type.  The event instance
     *   is lazily created using the parameters passed into
     *   the fire method.
     */
    protected void fireOptionSelected(JFileChooser pane, int option) {
        SheetEvent sheetEvent = null;
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == SheetListener.class) {
                // Lazily create the event:
                if (sheetEvent == null) {
                    sheetEvent = new SheetEvent(this, pane, option, null);
                }
                ((SheetListener) listeners[i + 1]).optionSelected(sheetEvent);
            }
        }
    }

    /**
     * Notify all listeners that have registered interest for
     *   notification on this event type.  The event instance
     *   is lazily created using the parameters passed into
     *   the fire method.
     */
    protected void fireOptionSelected(URIChooser pane, int option) {
        SheetEvent sheetEvent = null;
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == SheetListener.class) {
                // Lazily create the event:
                if (sheetEvent == null) {
                    sheetEvent = new SheetEvent(this, pane, option, null);
                }
                ((SheetListener) listeners[i + 1]).optionSelected(sheetEvent);
            }
        }
    }

    /**
     * Displays an option pane as a sheet on its parent window.
     *
     * @param pane The option pane.
     * @param parentComponent The parent of the option pane.
     * @param listener The listener for SheetEvents.
     */
    public static void showSheet(JOptionPane pane, Component parentComponent, SheetListener listener) {
        final JSheet sheet = createSheet(pane, parentComponent, styleFromMessageType(pane.getMessageType()));
        sheet.addSheetListener(listener);
        sheet.show();
    }

    /**
     * Brings up a sheet with the options <i>Yes</i>,
     * <i>No</i> and <i>Cancel</i>.
     *
     * @param parentComponent determines the <code>Frame</code> in which the
     *			sheet is displayed; if <code>null</code>,
     *			or if the <code>parentComponent</code> has no
     *			<code>Frame</code>, the sheet is displayed as a dialog.
     * @param message   the <code>Object</code> to display
     * @param listener The listener for SheetEvents.
     */
    public static void showConfirmSheet(Component parentComponent, Object message, SheetListener listener) {
        showConfirmSheet(parentComponent, message,
                JOptionPane.YES_NO_CANCEL_OPTION, listener);
    }

    /**
     * Brings up a sheet where the number of choices is determined
     * by the <code>optionType</code> parameter.
     *
     * @param parentComponent determines the <code>Frame</code> in which the
     *			sheet is displayed; if <code>null</code>,
     *			or if the <code>parentComponent</code> has no
     *			<code>Frame</code>, the sheet is displayed as a dialog.
     * @param message   the <code>Object</code> to display
     * @param optionType an int designating the options available on the dialog:
     *                  <code>YES_NO_OPTION</code>, or
     *			<code>YES_NO_CANCEL_OPTION</code>
     * @param listener The listener for SheetEvents.
     */
    public static void showConfirmSheet(Component parentComponent,
            Object message, int optionType, SheetListener listener) {
        showConfirmSheet(parentComponent, message, optionType,
                JOptionPane.QUESTION_MESSAGE, listener);
    }

    /**
     * Brings up a sheet where the number of choices is determined
     * by the <code>optionType</code> parameter, where the
     * <code>messageType</code>
     * parameter determines the icon to display.
     * The <code>messageType</code> parameter is primarily used to supply
     * a default icon from the Look and Feel.
     *
     * @param parentComponent determines the <code>Frame</code> in
     *			which the dialog is displayed; if <code>null</code>,
     *			or if the <code>parentComponent</code> has no
     *			<code>Frame</code>, the sheet is displayed as a dialog.
     * @param message   the <code>Object</code> to display
     * @param optionType an integer designating the options available
     *			on the dialog: <code>YES_NO_OPTION</code>,
     *			or <code>YES_NO_CANCEL_OPTION</code>
     * @param messageType an integer designating the kind of message this is;
     *                  primarily used to determine the icon from the pluggable
     *                  Look and Feel: <code>JOptionPane.ERROR_MESSAGE</code>,
     *			<code>JOptionPane.INFORMATION_MESSAGE</code>,
     *                  <code>JOptionPane.WARNING_MESSAGE</code>,
     *                  <code>JOptionPane.QUESTION_MESSAGE</code>,
     *			or <code>JOptionPane.PLAIN_MESSAGE</code>
     * @param listener The listener for SheetEvents.
     */
    public static void showConfirmSheet(Component parentComponent,
            Object message, int optionType, int messageType, SheetListener listener) {
        showConfirmSheet(parentComponent, message, optionType,
                messageType, null, listener);
    }

    /**
     * Brings up a sheet with a specified icon, where the number of
     * choices is determined by the <code>optionType</code> parameter.
     * The <code>messageType</code> parameter is primarily used to supply
     * a default icon from the look and feel.
     *
     * @param parentComponent determines the <code>Frame</code> in which the
     *			dialog is displayed; if <code>null</code>,
     *			or if the <code>parentComponent</code> has no
     *			<code>Frame</code>, the sheet is displayed as a dialog.
     * @param message   the Object to display
     * @param optionType an int designating the options available on the dialog:
     *                  <code>YES_NO_OPTION</code>,
     *			or <code>YES_NO_CANCEL_OPTION</code>
     * @param messageType an int designating the kind of message this is,
     *                  primarily used to determine the icon from the pluggable
     *                  Look and Feel: <code>JOptionPane.ERROR_MESSAGE</code>,
     *			<code>JOptionPane.INFORMATION_MESSAGE</code>,
     *                  <code>JOptionPane.WARNING_MESSAGE</code>,
     *                  <code>JOptionPane.QUESTION_MESSAGE</code>,
     *			or <code>JOptionPane.PLAIN_MESSAGE</code>
     * @param icon      the icon to display in the dialog
     * @param listener The listener for SheetEvents.
     */
    public static void showConfirmSheet(Component parentComponent,
            Object message, int optionType,
            int messageType, @Nullable Icon icon, SheetListener listener) {
        showOptionSheet(parentComponent, message, optionType,
                messageType, icon, null, null, listener);
    }

    /**
     * Shows a question-message sheet requesting input from the user
     * parented to <code>parentComponent</code>.
     *
     * @param parentComponent  the parent <code>Component</code> for the
     *		dialog
     * @param listener The listener for SheetEvents.
     */
    public static void showInputSheet(Component parentComponent,
            Object message, SheetListener listener) {
        showInputSheet(parentComponent, message, JOptionPane.QUESTION_MESSAGE, listener);
    }

    /**
     * Shows a question-message sheet requesting input from the user and
     * parented to <code>parentComponent</code>. The input value will be
     * initialized to <code>initialSelectionValue</code>.
     *
     * @param parentComponent  the parent <code>Component</code> for the
     *		dialog
     * @param message the <code>Object</code> to display
     * @param initialSelectionValue the value used to initialize the input
     *                 field
     * @param listener The listener for SheetEvents.
     */
    public static void showInputSheet(Component parentComponent, Object message,
            Object initialSelectionValue, SheetListener listener) {
        showInputSheet(parentComponent, message,
                JOptionPane.QUESTION_MESSAGE, null, null,
                initialSelectionValue, listener);
    }

    /**
     * Shows a sheet requesting input from the user parented to
     * <code>parentComponent</code> and message type <code>messageType</code>.
     *
     * @param parentComponent  the parent <code>Component</code> for the
     *			dialog
     * @param message  the <code>Object</code> to display
     * @param messageType the type of message that is to be displayed:
     *                 	<code>JOptionPane.ERROR_MESSAGE</code>,
     *			<code>JOptionPane.INFORMATION_MESSAGE</code>,
     *			<code>JOptionPane.WARNING_MESSAGE</code>,
     *                 	<code>JOptionPane.QUESTION_MESSAGE</code>,
     *			or <code>JOptionPane.PLAIN_MESSAGE</code>
     * @param listener The listener for SheetEvents.
     */
    public static void showInputSheet(Component parentComponent,
            Object message, int messageType, SheetListener listener) {
        showInputSheet(parentComponent, message,
                messageType, null, null, null, listener);
    }

    /**
     * Prompts the user for input in a sheet where the
     * initial selection, possible selections, and all other options can
     * be specified. The user will able to choose from
     * <code>selectionValues</code>, where <code>null</code> implies the
     * user can input
     * whatever they wish, usually by means of a <code>JTextField</code>.
     * <code>initialSelectionValue</code> is the initial value to prompt
     * the user with. It is up to the UI to decide how best to represent
     * the <code>selectionValues</code>, but usually a
     * <code>JComboBox</code>, <code>JList</code>, or
     * <code>JTextField</code> will be used.
     *
     * @param parentComponent  the parent <code>Component</code> for the
     *			dialog
     * @param message  the <code>Object</code> to display
     * @param messageType the type of message to be displayed:
     *                  <code>JOptionPane.ERROR_MESSAGE</code>,
     *			<code>JOptionPane.INFORMATION_MESSAGE</code>,
     *			<code>JOptionPane.WARNING_MESSAGE</code>,
     *                  <code>JOptionPane.QUESTION_MESSAGE</code>,
     *			or <code>JOptionPane.PLAIN_MESSAGE</code>
     * @param icon     the <code>Icon</code> image to display
     * @param selectionValues an array of <code>Object</code>s that
     *			gives the possible selections
     * @param initialSelectionValue the value used to initialize the input
     *                 field
     * @param listener The listener for SheetEvents.
     */
    public static void showInputSheet(Component parentComponent,
            Object message, int messageType, @Nullable Icon icon,
            @Nullable Object[] selectionValues, @Nullable Object initialSelectionValue, SheetListener listener) {

        JOptionPane pane = new JOptionPane(message, messageType,
                JOptionPane.OK_CANCEL_OPTION, icon,
                null, null);

        pane.setWantsInput(true);
        pane.setSelectionValues(selectionValues);
        pane.setInitialSelectionValue(initialSelectionValue);
        pane.setComponentOrientation(((parentComponent == null) ? JOptionPane.getRootFrame() : parentComponent).getComponentOrientation());

        int style = styleFromMessageType(messageType);
        JSheet sheet = createSheet(pane, parentComponent, style);

        pane.selectInitialValue();

        /*
        sheet.addWindowListener(new WindowAdapter() {
        public void windowClosed(WindowEvent evt) {
        sheet.dispose();
        }
        });*/
        sheet.addSheetListener(listener);
        sheet.show();
        sheet.toFront();
    }

    /**
     * Brings up an information-message sheet.
     *
     * @param parentComponent determines the <code>Frame</code> in
     *		which the dialog is displayed; if <code>null</code>,
     *		or if the <code>parentComponent</code> has no
     *		<code>Frame</code>, the sheet is displayed as a dialog.
     * @param message   the <code>Object</code> to display
     */
    public static void showMessageSheet(Component parentComponent,
            Object message) {
        showMessageSheet(parentComponent, message,
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Brings up an information-message sheet.
     *
     * @param parentComponent determines the <code>Frame</code> in
     *		which the dialog is displayed; if <code>null</code>,
     *		or if the <code>parentComponent</code> has no
     *		<code>Frame</code>, the sheet is displayed as a dialog.
     * @param message   the <code>Object</code> to display
     * @param listener This listener is notified when the sheet is dismissed.
     */
    public static void showMessageSheet(Component parentComponent,
            Object message, SheetListener listener) {
        showMessageSheet(parentComponent, message,
                JOptionPane.INFORMATION_MESSAGE, listener);
    }

    /**
     * Brings up a sheet that displays a message using a default
     * icon determined by the <code>messageType</code> parameter.
     *
     * @param parentComponent determines the <code>Frame</code>
     *		in which the dialog is displayed; if <code>null</code>,
     *		or if the <code>parentComponent</code> has no
     *		<code>Frame</code>, the sheet is displayed as a dialog.
     * @param message   the <code>Object</code> to display
     * @param messageType the type of message to be displayed:
     *                  <code>JOptionPane.ERROR_MESSAGE</code>,
     *			<code>JOptionPane.INFORMATION_MESSAGE</code>,
     *			<code>JOptionPane.WARNING_MESSAGE</code>,
     *                  <code>JOptionPane.QUESTION_MESSAGE</code>,
     *			or <code>JOptionPane.PLAIN_MESSAGE</code>
     */
    public static void showMessageSheet(Component parentComponent,
            Object message, int messageType) {
        showMessageSheet(parentComponent, message, messageType, null, new SheetListener() {

            @Override
            public void optionSelected(SheetEvent evt) {
                // empty
            }
        });
    }

    /**
     * Brings up a sheet that displays a message using a default
     * icon determined by the <code>messageType</code> parameter.
     *
     * @param parentComponent determines the <code>Frame</code>
     *		in which the dialog is displayed; if <code>null</code>,
     *		or if the <code>parentComponent</code> has no
     *		<code>Frame</code>, the sheet is displayed as a dialog.
     * @param message   the <code>Object</code> to display
     * @param messageType the type of message to be displayed:
     *                  <code>JOptionPane.ERROR_MESSAGE</code>,
     *			<code>JOptionPane.INFORMATION_MESSAGE</code>,
     *			<code>JOptionPane.WARNING_MESSAGE</code>,
     *                  <code>JOptionPane.QUESTION_MESSAGE</code>,
     *			or <code>JOptionPane.PLAIN_MESSAGE</code>
     * @param listener This listener is notified when the sheet is dismissed.
     */
    public static void showMessageSheet(Component parentComponent,
            Object message, int messageType, SheetListener listener) {
        showMessageSheet(parentComponent, message, messageType, null, listener);
    }

    /**
     * Brings up a sheet displaying a message, specifying all parameters.
     *
     * @param parentComponent determines the <code>Frame</code> in which the
     *			sheet is displayed; if <code>null</code>,
     *			or if the <code>parentComponent</code> has no
     *			<code>Frame</code>, the sheet is displayed as a dialog.
     * @param message   the <code>Object</code> to display
     * @param messageType the type of message to be displayed:
     *                  <code>JOptionPane.ERROR_MESSAGE</code>,
     *			<code>JOptionPane.INFORMATION_MESSAGE</code>,
     *			<code>JOptionPane.WARNING_MESSAGE</code>,
     *                  <code>JOptionPane.QUESTION_MESSAGE</code>,
     *			or <code>JOptionPane.PLAIN_MESSAGE</code>
     * @param icon      an icon to display in the sheet that helps the user
     *                  identify the kind of message that is being displayed
     * @param listener This listener is notified when the sheet is dismissed.
     */
    public static void showMessageSheet(Component parentComponent,
            Object message, int messageType, @Nullable Icon icon, SheetListener listener) {
        showOptionSheet(parentComponent, message, JOptionPane.DEFAULT_OPTION,
                messageType, icon, null, null, listener);
    }

    /**
     * Brings up a sheet with a specified icon, where the initial
     * choice is determined by the <code>initialValue</code> parameter and
     * the number of choices is determined by the <code>optionType</code>
     * parameter.
     * <p>
     * If <code>optionType</code> is <code>YES_NO_OPTION</code>,
     * or <code>YES_NO_CANCEL_OPTION</code>
     * and the <code>options</code> parameter is <code>null</code>,
     * then the options are
     * supplied by the look and feel.
     * <p>
     * The <code>messageType</code> parameter is primarily used to supply
     * a default icon from the look and feel.
     *
     * @param parentComponent determines the <code>Frame</code>
     *			in which the dialog is displayed;  if
     *                  <code>null</code>, or if the
     *			<code>parentComponent</code> has no
     *			<code>Frame</code>, the sheet is displayed as a dialog.
     * @param message   the <code>Object</code> to display
     * @param optionType an integer designating the options available on the
     *			dialog: <code>YES_NO_OPTION</code>,
     *			or <code>YES_NO_CANCEL_OPTION</code>
     * @param messageType an integer designating the kind of message this is,
     *                  primarily used to determine the icon from the
     *			pluggable Look and Feel: <code>JOptionPane.ERROR_MESSAGE</code>,
     *			<code>JOptionPane.INFORMATION_MESSAGE</code>,
     *                  <code>JOptionPane.WARNING_MESSAGE</code>,
     *                  <code>JOptionPane.QUESTION_MESSAGE</code>,
     *			or <code>JOptionPane.PLAIN_MESSAGE</code>
     * @param icon      the icon to display in the dialog
     * @param options   an array of objects indicating the possible choices
     *                  the user can make; if the objects are components, they
     *                  are rendered properly; non-<code>String</code>
     *			objects are
     *                  rendered using their <code>toString</code> methods;
     *                  if this parameter is <code>null</code>,
     *			the options are determined by the Look and Feel
     * @param initialValue the object that represents the default selection
     *                  for the dialog; only meaningful if <code>options</code>
     *			is used; can be <code>null</code>
     * @param listener The listener for SheetEvents.
     */
    public static void showOptionSheet(Component parentComponent,
            Object message, int optionType, int messageType,
            @Nullable Icon icon, @Nullable Object[] options, @Nullable Object initialValue, SheetListener listener) {

        JOptionPane pane = new JOptionPane(message, messageType,
                optionType, icon,
                options, initialValue);

        pane.setInitialValue(initialValue);
        pane.setComponentOrientation(((parentComponent == null) ? JOptionPane.getRootFrame() : parentComponent).getComponentOrientation());

        int style = styleFromMessageType(messageType);
        JSheet sheet = createSheet(pane, parentComponent, style);
        pane.selectInitialValue();
        sheet.addSheetListener(listener);
        sheet.show();
        sheet.toFront();
    }

    private static int styleFromMessageType(int messageType) {
        switch (messageType) {
            case JOptionPane.ERROR_MESSAGE:
                return JRootPane.ERROR_DIALOG;
            case JOptionPane.QUESTION_MESSAGE:
                return JRootPane.QUESTION_DIALOG;
            case JOptionPane.WARNING_MESSAGE:
                return JRootPane.WARNING_DIALOG;
            case JOptionPane.INFORMATION_MESSAGE:
                return JRootPane.INFORMATION_DIALOG;
            case JOptionPane.PLAIN_MESSAGE:
            default:
                return JRootPane.PLAIN_DIALOG;
        }
    }

    private static JSheet createSheet(final JOptionPane pane, Component parent,
            int style) {
        // If the parent is on a popup menu retrieve its invoker
        JPopupMenu popup = parent instanceof JPopupMenu ? (JPopupMenu) parent
                : (JPopupMenu) SwingUtilities.getAncestorOfClass(JPopupMenu.class, parent);
        if (popup != null) {
            parent = popup.getInvoker();
        }

        Window window = getWindowForComponent(parent);
        final JSheet sheet;
        boolean isUndecorated;
        if (window instanceof Frame) {
            isUndecorated = ((Frame) window).isUndecorated();
            sheet = new JSheet((Frame) window);
        } else {
            isUndecorated = ((Dialog) window).isUndecorated();
            sheet = new JSheet((Dialog) window);
        }

        JComponent contentPane = (JComponent) sheet.getContentPane();
        contentPane.setLayout(new BorderLayout());

        if (isNativeSheetSupported() && !isUndecorated) {
            contentPane.setBorder(new EmptyBorder(12, 0, 0, 0));
        }

        contentPane.add(pane, BorderLayout.CENTER);
        sheet.setResizable(false);
        sheet.addWindowListener(new WindowAdapter() {

            private boolean gotFocus = false;

            @Override
            public void windowClosing(WindowEvent we) {
                pane.setValue(null);
            }

            @Override
            public void windowClosed(WindowEvent we) {
                if (pane.getValue() == JOptionPane.UNINITIALIZED_VALUE) {
                    sheet.fireOptionSelected(pane);
                }
            }

            @Override
            public void windowGainedFocus(WindowEvent we) {
                // Once window gets focus, set initial focus
                if (!gotFocus) {
                    //Ugly dirty hack: JOptionPane.selectInitialValue() is protected.
                    //So we call directly into the UI. This may cause mayhem,
                    //because we override the encapsulation.
                    //pane.selectInitialValue();
                    OptionPaneUI ui = pane.getUI();
                    if (ui != null) {
                        ui.selectInitialValue(pane);
                    }
                    gotFocus = true;
                }
            }
        });
        sheet.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentShown(ComponentEvent ce) {
                // reset value to ensure closing works properly
                pane.setValue(JOptionPane.UNINITIALIZED_VALUE);
            }
        });
        pane.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent event) {
                // Let the defaultCloseOperation handle the closing
                // if the user closed the window without selecting a button
                // (newValue = null in that case).  Otherwise, close the sheet.
                if (sheet.isVisible() && event.getSource() == pane
                        && (event.getPropertyName().equals(JOptionPane.VALUE_PROPERTY))
                        && event.getNewValue() != null
                        && event.getNewValue() != JOptionPane.UNINITIALIZED_VALUE) {
                    sheet.setVisible(false);
                    sheet.fireOptionSelected(pane);
                }
            }
        });
        sheet.pack();
        return sheet;
    }

    /**
     * Returns the specified component's toplevel <code>Frame</code> or
     * <code>Dialog</code>.
     *
     * @param parentComponent the <code>Component</code> to check for a
     *		<code>Frame</code> or <code>Dialog</code>
     * @return the <code>Frame</code> or <code>Dialog</code> that
     *		contains the component, or the default
     *         	frame if the component is <code>null</code>,
     *		or does not have a valid
     *         	<code>Frame</code> or <code>Dialog</code> parent
     */
    static Window getWindowForComponent(Component parentComponent) {
        if (parentComponent == null) {
            return JOptionPane.getRootFrame();
        }
        if (parentComponent instanceof Frame || parentComponent instanceof Dialog) {
            return (Window) parentComponent;
        }
        return getWindowForComponent(parentComponent.getParent());
    }

    /**
     * Displays a "Save File" file chooser sheet. Note that the
     * text that appears in the approve button is determined by
     * the L&F.
     *
     * @param    parent  the parent component of the dialog,
     *			can be <code>null</code>.
     * @param listener The listener for SheetEvents.
     */
    public static void showSaveSheet(JFileChooser chooser, Component parent, SheetListener listener) {
        chooser.setDialogType(JFileChooser.SAVE_DIALOG);
        showSheet(chooser, parent, null, listener);
    }

    /**
     * Displays an "Open File" file chooser sheet. Note that the
     * text that appears in the approve button is determined by
     * the L&F.
     *
     * @param    parent  the parent component of the dialog,
     *			can be <code>null</code>.
     * @param listener The listener for SheetEvents.
     */
    public static void showOpenSheet(JFileChooser chooser, Component parent, SheetListener listener) {
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        showSheet(chooser, parent, null, listener);
    }

    /**
     * Displays a "Save File" file chooser sheet. Note that the
     * text that appears in the approve button is determined by
     * the L&F.
     *
     * @param    parent  the parent component of the dialog,
     *			can be <code>null</code>.
     * @param listener The listener for SheetEvents.
     */
    public static void showSaveSheet(URIChooser chooser, Component parent, SheetListener listener) {
        chooser.setDialogType(JFileChooser.SAVE_DIALOG);
        showSheet(chooser, parent, null, listener);
    }

    /**
     * Displays an "Open File" file chooser sheet. Note that the
     * text that appears in the approve button is determined by
     * the L&F.
     *
     * @param    parent  the parent component of the dialog,
     *			can be <code>null</code>.
     * @param listener The listener for SheetEvents.
     */
    public static void showOpenSheet(URIChooser chooser, Component parent, SheetListener listener) {
        chooser.setDialogType(JFileChooser.OPEN_DIALOG);
        showSheet(chooser, parent, null, listener);
    }

    /**
     * Displays a custom file chooser sheet with a custom approve button.
     *
     * @param   parent  the parent component of the dialog;
     *			can be <code>null</code>
     * @param   approveButtonText the text of the <code>ApproveButton</code>
     * @param listener The listener for SheetEvents.
     */
    public static void showSheet(final JFileChooser chooser, Component parent,
            @Nullable String approveButtonText, SheetListener listener) {
        if (approveButtonText != null) {
            chooser.setApproveButtonText(approveButtonText);
            chooser.setDialogType(JFileChooser.CUSTOM_DIALOG);
        }

        // If the parent is on a popup menu retrieve its invoker
        JPopupMenu popup = parent instanceof JPopupMenu ? (JPopupMenu) parent
                : (JPopupMenu) SwingUtilities.getAncestorOfClass(JPopupMenu.class, parent);
        if (popup != null) {
            parent = popup.getInvoker();
        }

        // Begin Create Dialog
        Frame frame = parent instanceof Frame ? (Frame) parent
                : (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);

        String title = chooser.getUI().getDialogTitle(chooser);
        chooser.getAccessibleContext().setAccessibleDescription(title);

        final JSheet sheet = new JSheet(frame);
        sheet.addSheetListener(listener);

        Container contentPane = sheet.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(chooser, BorderLayout.CENTER);
        // End Create Dialog

        final ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                int option;
                if (evt.getActionCommand().equals("ApproveSelection")) {
                    option = JFileChooser.APPROVE_OPTION;
                } else {
                    option = JFileChooser.CANCEL_OPTION;
                }
                sheet.hide();
                sheet.fireOptionSelected(chooser, option);
                chooser.removeActionListener(this);
            }
        };
        chooser.addActionListener(actionListener);
        sheet.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                sheet.fireOptionSelected(chooser, JFileChooser.CANCEL_OPTION);
                chooser.removeActionListener(actionListener);
            }
        });
        chooser.rescanCurrentDirectory();
        sheet.pack();
        sheet.show();
        sheet.toFront();
    }

    /**
     * Displays a custom file chooser sheet with a custom approve button.
     *
     * @param   parent  the parent component of the dialog;
     *			can be <code>null</code>
     * @param   approveButtonText the text of the <code>ApproveButton</code>
     * @param listener The listener for SheetEvents.
     */
    public static void showSheet(final URIChooser chooser, Component parent,
            @Nullable String approveButtonText, SheetListener listener) {
        if (approveButtonText != null) {
            chooser.setApproveButtonText(approveButtonText);
            chooser.setDialogType(URIChooser.CUSTOM_DIALOG);
        }
        // If the parent is on a popup menu retrieve its invoker
        JPopupMenu popup = parent instanceof JPopupMenu ? (JPopupMenu) parent
                : (JPopupMenu) SwingUtilities.getAncestorOfClass(JPopupMenu.class, parent);
        if (popup != null) {
            parent = popup.getInvoker();
        }


        // Begin Create Dialog
        Frame frame = parent instanceof Frame ? (Frame) parent
                : (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);

        if (chooser instanceof JFileChooser) {
            String title = ((JFileChooser) chooser).getUI().getDialogTitle((JFileChooser) chooser);
            ((JFileChooser) chooser).getAccessibleContext().setAccessibleDescription(title);
        }

        final JSheet sheet = new JSheet(frame);
        sheet.addSheetListener(listener);

        Container contentPane = sheet.getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(chooser.getComponent(), BorderLayout.CENTER);
        // End Create Dialog

        final ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                int option;
                if (evt.getActionCommand().equals("ApproveSelection")) {
                    option = JFileChooser.APPROVE_OPTION;
                } else {
                    option = JFileChooser.CANCEL_OPTION;
                }
                sheet.hide();
                sheet.fireOptionSelected(chooser, option);
                chooser.removeActionListener(this);
            }
        };
        chooser.addActionListener(actionListener);
        sheet.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                sheet.fireOptionSelected(chooser, JFileChooser.CANCEL_OPTION);
                chooser.removeActionListener(actionListener);
            }
        });
        chooser.rescanCurrentDirectory();
        sheet.pack();
        sheet.show();
        sheet.toFront();
    }
}
