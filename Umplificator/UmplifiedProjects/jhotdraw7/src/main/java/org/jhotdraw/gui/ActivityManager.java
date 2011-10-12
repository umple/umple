/*
 * @(#)ActivityManager.java
 * 
 * Copyright (c) 2011 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the  
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import org.jhotdraw.gui.event.ActivityManagerEvent;
import org.jhotdraw.gui.event.ActivityManagerListener;

/**
 * The activity manager keeps track of all active {@code ActivityModel} objects.
 * 
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Framework</em><br>
 * The interfaces and classes listed below define a framework for progress
 * management.<br>
 * Contract: {@link ActivityManager}, {@link ActivityModel}, 
 * {@link JActivityWindow}, {@link JActivityIndicator}.
 *
 *
 * @author Werner Randelshofer
 * @version 1.0 2011-09-07 Created.
 */
public class ActivityManager {

    private static ActivityManager instance;

    public synchronized static ActivityManager getInstance() {
        if (instance == null) {
            instance = new ActivityManager();
        }
        return instance;
    }
    private ArrayList<ActivityModel> models = new ArrayList<ActivityModel>();
    private ArrayList<ActivityManagerListener> listeners = new ArrayList<ActivityManagerListener>();

    /** Adds a listener to the progress manager. */
    public synchronized void addActivityManagerListener(ActivityManagerListener l) {
        listeners.add(l);
    }

    /** Removes a listener from the progress manager. */
    public synchronized void removeActivityManagerListener(ActivityManagerListener l) {
        listeners.remove(l);
    }

    /** Adds a progress model to the manager. This method is thread safe. */
    public void add(final ActivityModel pm) {
        invokeAndWait(new Runnable() {

            @Override @SuppressWarnings("unchecked")
            public void run() {
                if (models.add(pm)) {
                    ArrayList<ActivityManagerListener> ls;
                    synchronized (ActivityManager.this) {
                        ls = (ArrayList<ActivityManagerListener>) listeners.clone();
                    }
                    ActivityManagerEvent evt = new ActivityManagerEvent(ActivityManager.this, pm);
                    for (ActivityManagerListener l : ls) {
                        l.activityModelAdded(evt);
                    }
                }
            }
        });
    }

    /** Removes a progress model from the manager. This method is thread safe. */
    public void remove(final ActivityModel pm) {
        invokeAndWait(new Runnable() {

            @Override @SuppressWarnings("unchecked")
            public void run() {
                if (models.remove(pm)) {
                    ArrayList<ActivityManagerListener> ls;
                    synchronized (ActivityManager.this) {
                        ls = (ArrayList<ActivityManagerListener>) listeners.clone();
                    }
                    ActivityManagerEvent evt = new ActivityManagerEvent(ActivityManager.this, pm);
                    for (ActivityManagerListener l : ls) {
                        l.activityModelRemoved(evt);
                    }
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    public ArrayList<ActivityModel> getActivityModels() {
        return (ArrayList<ActivityModel>) models.clone();
    }
    
    /** Invokes a runnable on the EDT and wait until it is finished.
     * FIXME - Maybe move this into a utility class?
     */
    protected static void invokeAndWait(Runnable r) {
        if (SwingUtilities.isEventDispatchThread()) {
            r.run();
        } else {
            try {
                SwingUtilities.invokeAndWait(r);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (InvocationTargetException ex) {
                ex.printStackTrace();
            }
        }
    }
}
