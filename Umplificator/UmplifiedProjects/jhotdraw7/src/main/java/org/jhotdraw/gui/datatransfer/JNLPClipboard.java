/*
 * @(#)JNLPClipboard.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui.datatransfer;

import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;

/**
 * {@code JNLPClipboard} acts as a proxy to a JNLP
 * {@code ClipboardService} object.
 * <P>
 * Uses Reflection to access the JNLP object, because JNLP is not available
 * in J2SE 5.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Proxy</em><br>
 * {@code JNLPClipboard} acts as a proxy to a JNLP {@code ClipboardService} object.<br>
 * Proxy: {@link JNLPClipboard}; Target: {@code javax.jnlp.ClipboardService}.
 * </hr>
 *
 * @author Werner Randelshofer
 * @version $Id: JNLPClipboard.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class JNLPClipboard extends AbstractClipboard {

    /** The proxy target. */
    private Object target;

    /**
     * Creates a new proxy for the specified target object.
     * The target object must have a getContent and a setContent method
     * as specified by the {@code javax.jnlp.ClipboardService} interface.
     *
     * @param target A Clipboard object.
     */
    public JNLPClipboard(Object target) {
        this.target = target;
    }

    /** Returns the proxy target. */
    public Object getTarget() {
        return target;
    }

    @Override
    public Transferable getContents(Object requestor) {
        try {
            return (Transferable) target.getClass().getMethod("getContents").invoke(target);
        } catch (Exception ex) {
            InternalError error = new InternalError("Failed to invoke getContents() on "+target);
            error.initCause(ex);
            throw error;
        }
    }

    @Override
    public void setContents(Transferable contents, ClipboardOwner owner) {
        try {
            target.getClass().getMethod("setContents", Transferable.class).invoke(target, contents);
        } catch (Exception ex) {
            InternalError error = new InternalError("Failed to invoke setContents(Transferable) on "+target);
            error.initCause(ex);
            throw error;
        }
    }
}
