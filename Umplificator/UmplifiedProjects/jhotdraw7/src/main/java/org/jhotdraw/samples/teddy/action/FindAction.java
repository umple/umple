/*
 * @(#)AbstractFindAction.java
 *
 * Copyright (c) 2005 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.teddy.action;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.app.*;
import org.jhotdraw.samples.teddy.*;
import java.awt.event.*;
import org.jhotdraw.app.action.edit.AbstractFindAction;
/**
 * AbstractFindAction shows the find dialog.
 *
 * @author Werner Randelshofer
 * @version $Id: FindAction.java 723 2010-12-28 14:31:24Z rawcoder $
 */
public class FindAction extends AbstractFindAction {
    public final static String ID = AbstractFindAction.ID;
    private FindDialog findDialog;
    
    /**
     * Creates a new instance.
     */
    public FindAction(Application app, @Nullable View v) {
        super(app,v);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (findDialog == null) {
            findDialog = new FindDialog(getApplication());
            if (getApplication() instanceof OSXApplication) {
                findDialog.addWindowListener(new WindowAdapter() {
                    @Override public void windowClosing(WindowEvent evt) {
                        if (findDialog != null) {
                            ((OSXApplication) getApplication()).removePalette(findDialog);
                            findDialog.setVisible(false);
                        }
                    }
                });
            }
        }
        findDialog.setVisible(true);
        if (getApplication() instanceof OSXApplication) {
            ((OSXApplication) getApplication()).addPalette(findDialog);
        }
    }
}
