/*
 * @(#)WeakPropertyChangeListener.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * The copyright of this software is owned by the authors and  
 * contributors of the JHotDraw project ("the copyright holders").  
 * You may not use, copy or modify this software, except in  
 * accordance with the license agreement you entered into with  
 * the copyright holders. For details see accompanying license terms.
 *
 * This class has been derived from WeakPropertyChangeListener.java,
 * v 1.2 2005-06-20 18:26:16 by Paul Speed.
 *
 * Copyright (c) 2004, Paul Speed
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1) Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2) Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3) Neither the names "Progeeks", "Meta-JB", nor the names of its contributors
 *    may be used to endorse or promote products derived from this software
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package org.jhotdraw.beans;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.beans.*;
import java.lang.ref.*;

/**
 *  Property change listener that holds weak reference to a
 *  target property change listener.  If the weak reference
 *  becomes null (meaning the delegate has been GC'ed) then this
 *  listener will remove itself from any beans that it receives
 *  events from.  It isn't perfect, but it's a lot better than
 *  nothing... and presumably beans that no longer send out events
 *  probably don't care if their listeners weren't properly cleaned
 *  up.
 *
 *  Design pattern: Proxy.
 *
 *  @author Paul Speed
 *  @version $Id: WeakPropertyChangeListener.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class WeakPropertyChangeListener implements PropertyChangeListener {
    private WeakReference<PropertyChangeListener> weakRef;

    public WeakPropertyChangeListener(PropertyChangeListener target) {
        this.weakRef = new WeakReference<PropertyChangeListener>(target);
    }

    /**
     *  Method that can be subclassed to provide additional remove
     *  support.  Default implementation only supports StandardBeans.
     */
    protected void removeFromSource(PropertyChangeEvent event) {
        // Remove ourselves from the source
        Object src = event.getSource();
        try {
            src.getClass().getMethod("removePropertyChangeListener", new Class[] {PropertyChangeListener.class}).invoke(src, this);
        } catch (Exception ex) {
            InternalError ie = new InternalError("Could not remove WeakPropertyChangeListener from "+src+".");
            ie.initCause(ex);
            throw ie;
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        PropertyChangeListener listener = (PropertyChangeListener) weakRef.get();
        if (listener == null) {
            removeFromSource(event);
            return;
        }
        listener.propertyChange(event);
    }

    /**
     * Returns the target of this proxy. Returns null if the target has been
     * garbage collected.
     *
     * @return The target or null.
     */
    @Nullable
    public PropertyChangeListener getTarget() {
        return weakRef.get();
    }

    @Override
    public String toString() {
        return super.toString()+"["+weakRef.get()+"]";
    }
}
