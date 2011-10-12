/*
 * @(#)JActivityIndicator.java
 * 
 * Copyright (c) 2011 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the  
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui;

import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.DefaultBoundedRangeModel;
import org.jhotdraw.gui.event.ActivityManagerEvent;
import org.jhotdraw.gui.event.ActivityManagerListener;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * This indicator displays a progress bar when an {@code ActivityModel} is active.
 * <p>
 * The indicator can indicate all activities or only those belonging to a
 * specific owner, see {@link #setActivityOwner}.
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Framework</em><br>
 * The interfaces and classes listed below define a framework for progress
 * management.<br>
 * Contract: {@link ActivityManager}, {@link ActivityModel}, 
 * {@link JActivityWindow}, {@link JActivityIndicator}.
 *
 * @author Werner Randelshofer
 * @version 1.0 2011-09-08 Created.
 */
public class JActivityIndicator extends javax.swing.JPanel {

    private ArrayList<ActivityModel> models = new ArrayList<ActivityModel>();

    private class Handler implements ActivityManagerListener, PropertyChangeListener {

        @Override
        public void activityModelAdded(ActivityManagerEvent evt) {
            ActivityModel pm = evt.getActivityModel();
            if (progressOwner == null || progressOwner.equals(pm.getOwner())) {
                addActivityModel(pm);
            }
        }

        @Override
        public void activityModelRemoved(ActivityManagerEvent evt) {
            ActivityModel pm = evt.getActivityModel();
            removeActivityModel(pm);
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName() == ActivityModel.INDETERMINATE_PROPERTY) {
                updateIndeterminate();
            }
            if (evt.getPropertyName() == ActivityModel.NOTE_PROPERTY) {
                updateToolTip();
            }
        }
    }
    private Handler handler = new Handler();
    private ActivityManager manager;
    private Object progressOwner;
    private ResourceBundleUtil labels;

    /** Creates new form JActivityIndicator */
    public JActivityIndicator() {
        labels = ResourceBundleUtil.getBundle("org.jhotdraw.gui.Labels");
        initComponents();
        setActivityManager(ActivityManager.getInstance());

    }

    public ActivityManager getActivityManager() {
        return manager;
    }

    public void setActivityManager(ActivityManager newValue) {
        if (manager != null) {
            manager.removeActivityManagerListener(handler);
        }
        this.manager = newValue;
        if (manager != null) {
            manager.addActivityManagerListener(handler);
        }
        updateActivityModels();
        updateProgressBar();
        updateToolTip();
    }

    public Object getActivityOwner() {
        return progressOwner;
    }

    public void setActivityOwner(Object progressOwner) {
        this.progressOwner = progressOwner;
        updateActivityModels();
    }

    public void addActivityModel(final ActivityModel model) {
        if (progressOwner == null || model.getOwner() == progressOwner) {
            models.add(model);
            model.addPropertyChangeListener(handler);
            updateProgressBar();
            updateToolTip();
            updateIndeterminate();
        }
    }

    public void removeActivityModel(final ActivityModel model) {
        if (models.remove(model)) {
            model.removePropertyChangeListener(handler);
            updateProgressBar();
            updateToolTip();
            updateIndeterminate();
        }
    }

    private void updateActivityModels() {
        for (ActivityModel pm : models) {
            pm.removePropertyChangeListener(handler);
        }
        models.clear();
        if (manager != null) {
            for (ActivityModel pm : manager.getActivityModels()) {
                if (progressOwner == null || pm.getOwner() == progressOwner) {
                    models.add(pm);
                }
            }
        }
        updateProgressBar();
        updateIndeterminate();
        updateToolTip();
    }

    @Override
    public Dimension getPreferredSize() {
        return progressBar.getPreferredSize();
    }

    private void updateProgressBar() {
        if (models.isEmpty()) {
            progressBar.setModel(new DefaultBoundedRangeModel());
            progressBar.setEnabled(false);
            progressBar.setVisible(false);
        } else if (models.size() == 1) {
            progressBar.setModel(models.get(0));
            progressBar.setEnabled(true);
            progressBar.setVisible(true);
        } else {
            progressBar.setModel(new DefaultBoundedRangeModel());
            progressBar.setEnabled(true);
            progressBar.setVisible(true);
        }
    }

    private void updateToolTip() {
        if (models.isEmpty()) {
            setToolTipText(labels.getString("ActivityIndicator.noActivities.toolTipText"));
        } else if (models.size() == 1) {
            setToolTipText(models.get(0).getTitle());
            //setToolTipText(labels.getString("ActivityIndicator.oneActivity.toolTipText"));
        } else {
            setToolTipText(labels.getFormatted("ActivityIndicator.nActivities.toolTipText", models.size()));
        }
    }

    private void updateIndeterminate() {
        if (models.size() == 0) {
            progressBar.setIndeterminate(false);
        } else if (models.size() == 1) {
            progressBar.setIndeterminate(models.get(0).isIndeterminate());
        } else {
            progressBar.setIndeterminate(true);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressBar = new javax.swing.JProgressBar();

        setLayout(new java.awt.BorderLayout());
        add(progressBar, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
