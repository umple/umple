/*
 * @(#)ODGDrawing.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.odg;

import org.jhotdraw.draw.*;
/**
 * ODGDrawing.
 * <p>
 * XXX - This class is going away in future versions: We don't need
 * to subclass QuadTreeDrawing for ODG since we can represent all ODG-specific
 * AttributeKey's instead of using JavaBeans properties.
 * 
 * @author Werner Randelshofer
 * @version $Id: ODGDrawing.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ODGDrawing extends QuadTreeDrawing {
    private String title;
    private String description;
    
    /** Creates a new instance. */
    public ODGDrawing() {
    }
    
    public void setTitle(String newValue) {
        String oldValue = title;
        title = newValue;
        firePropertyChange("title", oldValue, newValue);
    }
    public String getTitle() {
        return title;
    }
    public void setDescription(String newValue) {
        String oldValue = description;
        description = newValue;
        firePropertyChange("description", oldValue, newValue);
    }
    public String getDescription() {
        return description;
    }
}
