/**
 * @(#)AbstractHarmonicRule.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.color;

import edu.umd.cs.findbugs.annotations.NonNull;

/**
 * AbstractHarmonicRule.
 *
 * @author Werner Randelshofer
 * @version $Id: AbstractHarmonicRule.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public abstract class AbstractHarmonicRule implements HarmonicRule {
    protected int baseIndex;
    protected int[] derivedIndices;
    
    
    @Override
    public void setBaseIndex() {
       // this.baseIndex = baseIndex;
    }

    @Override
    public int getBaseIndex() {
        return baseIndex;
    }

    @Override
    public void setDerivedIndices(int... indices) {
        this.derivedIndices = indices;
    }

    @Override
    public int[] getDerivedIndices() {
        return derivedIndices;
    }

}
