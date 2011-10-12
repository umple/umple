/*
 * @(#)NamedColorSpace.java
 * 
 * Copyright (c) 2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.color;

import edu.umd.cs.findbugs.annotations.NonNull;
/**
 * Interface for {@code ColorSpace} classes which have a name.
 *
 * @author Werner Randelshofer
 * @version $Id: NamedColorSpace.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface NamedColorSpace {

    public String getName();
}
