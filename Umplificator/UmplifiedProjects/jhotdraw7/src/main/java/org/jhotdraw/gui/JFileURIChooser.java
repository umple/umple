/*
 * @(#)JFileURIChooser.java
 * 
 * Copyright (c) 2009-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.io.File;
import java.net.URI;
import javax.swing.JComponent;
import javax.swing.JFileChooser;

/**
 * JFileURIChooser.
 *
 * @author Werner Randelshofer
 * @version $Id: JFileURIChooser.java 759 2011-09-08 14:55:19Z rawcoder $
 */
public class JFileURIChooser extends JFileChooser implements URIChooser {

    @Override
    public void setSelectedURI(@Nullable URI uri) {
        setSelectedFile(uri==null?null:new File(uri));
    }

    @Override @Nullable
    public URI getSelectedURI() {
        return getSelectedFile() == null ? null : getSelectedFile().toURI();
    }

    @Override
    public JComponent getComponent() {
        return this;
    }
}
