/**
 * @(#)HarmonicRule.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.color;

import java.awt.Color;

/**
 * HarmonicRule.
 *
 * @author Werner Randelshofer
 * @version $Id: HarmonicRule.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface HarmonicRule {
    
    public void setBaseIndex();
    
    public int getBaseIndex();
    
    public void setDerivedIndices(int... indices);
    
    public int[] getDerivedIndices();
    
    public void apply(HarmonicColorModel model);
    
    public void colorChanged(HarmonicColorModel model, int index, Color oldValue, Color newValue);
}
