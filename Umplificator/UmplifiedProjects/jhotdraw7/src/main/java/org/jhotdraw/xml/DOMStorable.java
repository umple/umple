/*
 * @(#)DOMStorable.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.xml;

import java.io.*;
/**
 * Interface for objects that can be made persistent using 
 * <code>DOMOutput.writeObject</code> and <code>DOMInput.readObject</code>.
 * <p>
 * By convention every object implementing the DOMStorable interface MUST
 * provide a public parameterless constructor.
 * <p>
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Strategy</em><br>
 * {@code DOMFactory} is used by {@code DOMInput} and {@code DOMOutput} for
 * reading and writing objects.
 * Client: {@link DOMInput}, {@link DOMOutput}.<br>
 * Strategy: {@link DOMFactory}.<br>
 *
 * <p><em>Chain of Responsibility</em><br>
 * {@code DOMFactory} can delegate reading and writing to objects which implement
 * the {@code DOMStorable} interface.
 * Client: {@link DOMFactory}.<br>
 * Strategy: {@link DOMStorable}.<br>
 *
 * @author  Werner Randelshofer
 * @version $Id: DOMStorable.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface DOMStorable {
    public void write(DOMOutput out) throws IOException;
    public void read(DOMInput in) throws IOException;
}
