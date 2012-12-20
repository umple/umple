/*
 * @(#)ReversedList.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.util;

import java.util.*;
/**
 * A ReversedList provides in unmodifiable view on a List in reverse order.
 *
 * @author wrandels
 */
public class ReversedList<T> extends AbstractList<T> {
    private List<T> target;
    
    /** Creates a new instance of ReversedList */
    public ReversedList(List<T> target) {
        this.target = target;
    }

    @Override
    public T get(int index) {
        return target.get(target.size() - 1 - index);
    }

    @Override
    public int size() {
        return target.size();
    }
    
}
