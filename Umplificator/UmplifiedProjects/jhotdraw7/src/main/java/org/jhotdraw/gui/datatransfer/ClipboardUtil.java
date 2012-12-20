/*
 * @(#)ClipboardUtil.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui.datatransfer;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

/**
 * {@code ClipboardUtil} provides utility methods for the Java Clipboard API.
 *
 * @author Werner Randelshofer
 * @version $Id: ClipboardUtil.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ClipboardUtil {

    /** Holds the clipboard service instance. */
    private static Clipboard instance;

    /** Returns the ClipboardService instance. If none is set, creates
     * a new one which tries to access the system clipboard. If this fails,
     * an instance with a JVM local clipboard is created.
     *
     * @return system clipboard or a proxy.
     */
    @SuppressWarnings("unchecked")
    public static Clipboard getClipboard() {
        if (instance != null) {
            return instance;
        }

        // Try to access the system clipboard
        try {
//          instance = new AWTClipboard(Toolkit.getDefaultToolkit().getSystemClipboard());
            instance = new OSXClipboard(Toolkit.getDefaultToolkit().getSystemClipboard());
        } catch (SecurityException e1) {

            // Fall back to JNLP ClipboardService
            try {
                Class serviceManager = Class.forName("javax.jnlp.ServiceManager");
                instance = new JNLPClipboard(serviceManager.getMethod("lookup", String.class).invoke(null, "javax.jnlp.ClipboardService"));
            } catch (Exception e2) {

                // Fall back to JVM local clipboard
                instance = new AWTClipboard(new Clipboard("JVM Local Clipboard"));
            }
        }

        return instance;
    }

    /** Sets the Clipboard singleton used by the JHotDraw framework.
     * <p>
     * If you set this null, the next call to getClipboard will create a new
     * singleton.
     */
    public static void setClipboard(Clipboard instance) {
        ClipboardUtil.instance = instance;
    }
}
