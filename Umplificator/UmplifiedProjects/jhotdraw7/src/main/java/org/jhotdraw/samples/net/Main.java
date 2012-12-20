/*
 * @(#)Main.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.net;

import org.jhotdraw.app.*;
/**
 * Main entry point of the Net sample application. Creates an {@link Application}
 * depending on the operating system we run, sets the {@link NetApplicationModel}
 * and then launches the application. The application then creates
 * {@link NetView}s and menu bars as specified by the application model.
 *
 * @author Werner Randelshofer.
 * @version $Id: Main.java 731 2011-01-22 09:21:06Z rawcoder $
 */
public class Main {
    
    /** Creates a new instance. */
    public static void main(String[] args) {
        Application app;
        String os = System.getProperty("os.name").toLowerCase();
        if (os.startsWith("mac")) {
            app = new OSXApplication();
        } else if (os.startsWith("win")) {
          //  app = new DefaultMDIApplication();
            app = new SDIApplication();
        } else {
            app = new SDIApplication();
        }
        
        
        DefaultApplicationModel model = new NetApplicationModel();
        model.setName("JHotDraw Net");
        model.setVersion(Main.class.getPackage().getImplementationVersion());
        model.setCopyright("Copyright 2006-2010 (c) by the authors of JHotDraw and all its contributors.\n" +
                "This software is licensed under LGPL and Creative Commons 3.0 Attribution.");
        model.setViewClassName("org.jhotdraw.samples.net.NetView");
        app.setModel(model);
        app.launch(args);
    }
    
}
