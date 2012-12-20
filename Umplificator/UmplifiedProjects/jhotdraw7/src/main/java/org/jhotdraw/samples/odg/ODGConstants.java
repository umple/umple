/*
 * @(#)ODGConstants.java
 *
 * Copyright (c) 2007 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.odg;

import java.util.*;

/**
 * ODGConstants.
 *
 * @author Werner Randelshofer
 * @version $Id: ODGConstants.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ODGConstants {
    public final static String OFFICE_NAMESPACE = "urn:oasis:names:tc:opendocument:xmlns:office:1.0";
    public final static String DRAWING_NAMESPACE = "urn:oasis:names:tc:opendocument:xmlns:drawing:1.0";
    public final static String SVG_NAMESPACE = "urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0";
    public final static String STYLE_NAMESPACE = "urn:oasis:names:tc:opendocument:xmlns:style:1.0";
    public final static String TEXT_NAMESPACE = "urn:oasis:names:tc:opendocument:xmlns:text:1.0";
    
    public static enum StrokeStyle {
        NONE, DASH, SOLID
    }
    
    public final static Map<String,StrokeStyle> STROKE_STYLES;
    static {
        HashMap<String, StrokeStyle> m = new HashMap<String, StrokeStyle>();
        m.put("none", StrokeStyle.NONE);
        m.put("dash", StrokeStyle.DASH);
        m.put("solid", StrokeStyle.SOLID);
        STROKE_STYLES = Collections.unmodifiableMap(m);
    }
    
    public static enum FillStyle {
        NONE, SOLID, BITMAP, GRADIENT, HATCH
    }
    
    public final static Map<String,FillStyle> FILL_STYLES;
    static {
        HashMap<String, FillStyle> m = new HashMap<String, FillStyle>();
        m.put("none", FillStyle.NONE);
        m.put("solid", FillStyle.SOLID);
        m.put("bitmap", FillStyle.BITMAP);
        m.put("gradient", FillStyle.GRADIENT);
        m.put("hatch", FillStyle.HATCH);
        FILL_STYLES = Collections.unmodifiableMap(m);
    }
    

    /** Prevent instance creation. */
    private ODGConstants() {
    }
    
}
