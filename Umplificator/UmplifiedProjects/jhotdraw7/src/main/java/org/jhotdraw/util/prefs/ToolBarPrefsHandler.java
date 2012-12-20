/*
 * @(#)ToolBarPrefsHandler.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.util.prefs;

import java.awt.*;
import java.awt.event.*;
import java.util.prefs.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;
import javax.swing.event.*;

/**
 * ToolBarPrefsHandler.
 *
 * @author Werner Randelshofer
 * @version $Id: ToolBarPrefsHandler.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class ToolBarPrefsHandler implements ComponentListener, AncestorListener {
    private JToolBar toolbar;
    private String prefsPrefix;
    private Preferences prefs;
    
    public ToolBarPrefsHandler(JToolBar toolbar, String prefsPrefix, Preferences prefs) {
        this.toolbar = toolbar;
        this.prefsPrefix = prefsPrefix;
        this.prefs = prefs;
        
        String constraint = prefs.get(prefsPrefix+".constraint", BorderLayout.NORTH);
        int orientation = (constraint.equals(BorderLayout.NORTH) || constraint.equals(BorderLayout.SOUTH)) ? JToolBar.HORIZONTAL : JToolBar.VERTICAL;
        toolbar.setOrientation(orientation);
        toolbar.getParent().add(constraint, toolbar);
        toolbar.setVisible(prefs.getBoolean(prefsPrefix+".visible", true));
        /*
        if (prefs.getBoolean(prefsPrefix+".isFloating", false)) {
            makeToolBarFloat();
        }*/
        
        toolbar.addComponentListener(this);
        toolbar.addAncestorListener(this);
    }
    
    
    
    /*
     * XXX - This does not work
    private void makeToolBarFloat() {
        BasicToolBarUI ui = (BasicToolBarUI) toolbar.getUI();
        Window window = SwingUtilities.getWindowAncestor(toolbar);
        System.out.println("Window Ancestor:"+window+" instanceof Frame:"+(window instanceof Frame));
        ui.setFloating(true, new Point(
        prefs.getInt(prefsPrefix+".floatingX", 0),
        prefs.getInt(prefsPrefix+".floatingY", 0)
        ));
        window = SwingUtilities.getWindowAncestor(toolbar);
        window.setLocation(
        prefs.getInt(prefsPrefix+".floatingX", 0),
        prefs.getInt(prefsPrefix+".floatingY", 0)
        );
        window.toFront();
    }*/
    @Override
    public void componentHidden(ComponentEvent e) {
        prefs.putBoolean(prefsPrefix+".visible", false);
    }
    
    @Override
    public void componentMoved(ComponentEvent e) {
        locationChanged();
    }
    private void locationChanged() {
        // FIXME : use reflection to get hold of method 'isFloating'.
        if (toolbar.getUI() instanceof BasicToolBarUI) {
            BasicToolBarUI ui = (BasicToolBarUI) toolbar.getUI();
            boolean floating = ui.isFloating();
            prefs.putBoolean(prefsPrefix+".isFloating", floating);
            if (floating) {
                Window window = SwingUtilities.getWindowAncestor(toolbar);
                prefs.putInt(prefsPrefix+".floatingX", window.getX());
                prefs.putInt(prefsPrefix+".floatingY", window.getY());
            } else if (toolbar.getParent() != null) {
                int x = toolbar.getX();
                int y = toolbar.getY();
                Insets insets = toolbar.getParent().getInsets();
                String constraint;
                if (x == insets.left && y == insets.top) {
                    constraint = (toolbar.getOrientation() == JToolBar.HORIZONTAL) ? BorderLayout.NORTH : BorderLayout.WEST;
                } else {
                    constraint = (toolbar.getOrientation() == JToolBar.HORIZONTAL) ? BorderLayout.SOUTH : BorderLayout.EAST;
                }
                prefs.put(prefsPrefix+".constraint", constraint);
            }
        } else {
            if (toolbar.getParent() != null) {
                int x = toolbar.getX();
                int y = toolbar.getY();
                Insets insets = toolbar.getParent().getInsets();
                String constraint;
                if (x == insets.left && y == insets.top) {
                    constraint = (toolbar.getOrientation() == JToolBar.HORIZONTAL) ? BorderLayout.NORTH : BorderLayout.WEST;
                } else {
                    constraint = (toolbar.getOrientation() == JToolBar.HORIZONTAL) ? BorderLayout.SOUTH : BorderLayout.EAST;
                }
                prefs.put(prefsPrefix+".constraint", constraint);
            }
        }
    }
    
    @Override
    public void componentResized(ComponentEvent e) {
        locationChanged();
    }
    
    @Override
    public void componentShown(ComponentEvent e) {
        prefs.putBoolean(prefsPrefix+".visible", true);
    }
    
    @Override
    public void ancestorAdded(AncestorEvent event) {
        locationChanged();
    }
    
    @Override
    public void ancestorMoved(AncestorEvent event) {
        if (toolbar.getUI() instanceof BasicToolBarUI) {
            if (((BasicToolBarUI) toolbar.getUI()).isFloating()) {
                locationChanged();
            }
        }
    }
    
    @Override
    public void ancestorRemoved(AncestorEvent event) {
        if (toolbar.getUI() instanceof BasicToolBarUI) {
            if (((BasicToolBarUI) toolbar.getUI()).isFloating()) {
                locationChanged();
            }
        }
    }
}
