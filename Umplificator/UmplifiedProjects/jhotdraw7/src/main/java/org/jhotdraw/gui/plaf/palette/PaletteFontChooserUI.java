/**
 * @(#)PaletteFontChooserUI.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui.plaf.palette;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.ComponentUI;
import javax.swing.tree.*;
import org.jhotdraw.gui.JFontChooser;
import org.jhotdraw.gui.fontchooser.*;
import org.jhotdraw.gui.plaf.FontChooserUI;

/**
 * PaletteFontChooserUI.
 *
 * @author Werner Randelshofer
 * @version $Id: PaletteFontChooserUI.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class PaletteFontChooserUI extends FontChooserUI {

    private FontCollectionNode familyListParent;
    private FontFamilyNode faceListParent;
    private JFontChooser fontChooser;
    private PaletteFontChooserSelectionPanel selectionPanel;
    private PaletteFontChooserPreviewPanel previewPanel;
    @Nullable private SelectionPanelHandler selectionPanelHandler;
    @Nullable private FontChooserHandler chooserHandler;
    /**
     * The value of this counter is greater 0, if the palette
     * font chooser is updating, and should ignore incoming events.
     */
    private int isUpdating;

    public PaletteFontChooserUI(JFontChooser fontChooser) {
        this.fontChooser = fontChooser;
    }

    /**
     * Returns an instance of the UI delegate for the specified component.
     * Each subclass must provide its own static <code>createUI</code>
     * method that returns an instance of that UI delegate subclass.
     * If the UI delegate subclass is stateless, it may return an instance
     * that is shared by multiple components.  If the UI delegate is
     * stateful, then it should return a new instance per component.
     * The default implementation of this method throws an error, as it
     * should never be invoked.
     */
    public static ComponentUI createUI(JComponent c) {
        PaletteFontChooserUI ui = new PaletteFontChooserUI((JFontChooser) c);
        return ui;
    }

    /**
     * Configures the specified component appropriate for the look and feel.
     * This method is invoked when the <code>ComponentUI</code> instance is being installed
     * as the UI delegate on the specified component.  This method should
     * completely configure the component for the look and feel,
     * including the following:
     * <ol>
     * <li>Install any default property values for color, fonts, borders,
     *     icons, opacity, etc. on the component.  Whenever possible, 
     *     property values initialized by the client program should <i>not</i> 
     *     be overridden.
     * <li>Install a <code>LayoutManager</code> on the component if necessary.
     * <li>Create/add any required sub-components to the component.
     * <li>Create/install event listeners on the component.
     * <li>Create/install a <code>PropertyChangeListener</code> on the component in order
     *     to detect and respond to component property changes appropriately.
     * <li>Install keyboard UI (mnemonics, traversal, etc.) on the component.
     * <li>Initialize any appropriate instance data.
     * </ol>
     * @param c the component where this UI delegate is being installed
     *
     * @see #uninstallUI
     * @see javax.swing.JComponent#setUI
     * @see javax.swing.JComponent#updateUI
     */
    @Override
    public void installUI(JComponent c) {
        installComponents(fontChooser);
        installListeners(fontChooser);
    }

    protected void installComponents(JFontChooser fc) {
        fc.removeAll();
        fc.setLayout(new BorderLayout());
        selectionPanel = new PaletteFontChooserSelectionPanel();
        fc.add(selectionPanel, BorderLayout.CENTER);
        previewPanel = new PaletteFontChooserPreviewPanel();
        fc.add(previewPanel, BorderLayout.NORTH);

        updateCollectionList();
        updateFamilyList();
        updateFaceList();
        updatePreview();
    }

    protected void installListeners(JFontChooser fc) {
        selectionPanelHandler = new SelectionPanelHandler();
        selectionPanel.getCollectionList().addListSelectionListener(selectionPanelHandler);
        selectionPanel.getFamilyList().addListSelectionListener(selectionPanelHandler);
        selectionPanel.getFaceList().addListSelectionListener(selectionPanelHandler);
        selectionPanel.getCollectionList().addKeyListener(selectionPanelHandler);
        selectionPanel.getFamilyList().addKeyListener(selectionPanelHandler);
        selectionPanel.getFaceList().addKeyListener(selectionPanelHandler);
        selectionPanel.getCollectionList().addMouseListener(selectionPanelHandler);
        selectionPanel.getFamilyList().addMouseListener(selectionPanelHandler);
        selectionPanel.getFaceList().addMouseListener(selectionPanelHandler);

        chooserHandler = new FontChooserHandler();
        fontChooser.addPropertyChangeListener(chooserHandler);
        if (fontChooser.getModel() != null) {
            fontChooser.getModel().addTreeModelListener(chooserHandler);
        }
    }

    /**
     * Reverses configuration which was done on the specified component during
     * <code>installUI</code>.  This method is invoked when this 
     * <code>UIComponent</code> instance is being removed as the UI delegate 
     * for the specified component.  This method should undo the
     * configuration performed in <code>installUI</code>, being careful to 
     * leave the <code>JComponent</code> instance in a clean state (no 
     * extraneous listeners, look-and-feel-specific property objects, etc.).
     * This should include the following:
     * <ol>
     * <li>Remove any UI-set borders from the component.
     * <li>Remove any UI-set layout managers on the component.
     * <li>Remove any UI-added sub-components from the component.
     * <li>Remove any UI-added event/property listeners from the component.
     * <li>Remove any UI-installed keyboard UI from the component.
     * <li>Nullify any allocated instance data objects to allow for GC.
     * </ol>
     * @param c the component from which this UI delegate is being removed;
     *          this argument is often ignored,
     *          but might be used if the UI object is stateless
     *          and shared by multiple components
     *
     * @see #installUI
     * @see javax.swing.JComponent#updateUI
     */
    @Override
    public void uninstallUI(JComponent c) {
        uninstallListeners(fontChooser);
        uninstallComponents(fontChooser);
    }

    protected void uninstallComponents(JFontChooser fc) {
        fontChooser.removeAll();
    }

    protected void uninstallListeners(JFontChooser fc) {
        fontChooser.removePropertyChangeListener(chooserHandler);
        selectionPanel.getCollectionList().removeListSelectionListener(selectionPanelHandler);
        selectionPanel.getFamilyList().removeListSelectionListener(selectionPanelHandler);
        selectionPanel.getFaceList().removeListSelectionListener(selectionPanelHandler);
        selectionPanel.getCollectionList().removeKeyListener(selectionPanelHandler);
        selectionPanel.getFamilyList().removeKeyListener(selectionPanelHandler);
        selectionPanel.getFaceList().removeKeyListener(selectionPanelHandler);
        selectionPanel.getCollectionList().removeMouseListener(selectionPanelHandler);
        selectionPanel.getFamilyList().removeMouseListener(selectionPanelHandler);
        selectionPanel.getFaceList().removeMouseListener(selectionPanelHandler);
        if (fontChooser.getModel() != null) {
            fontChooser.getModel().removeTreeModelListener(chooserHandler);
        }
        chooserHandler = null;
        selectionPanelHandler = null;
    }

    private void updateCollectionList() {
        isUpdating++;
        JList list = selectionPanel.getCollectionList();
        DefaultListModel lm = (DefaultListModel) list.getModel();
        lm.removeAllElements();
        FontChooserModel model = fontChooser.getModel();
        Object parent = model.getRoot();
        for (int i = 0, n = model.getChildCount(parent); i < n; i++) {
            lm.addElement(model.getChild(parent, i));
        }

        TreePath path = fontChooser.getSelectionPath();
        if (path == null || path.getPathCount() < 2) {
            list.clearSelection();
        } else {
            list.setSelectedIndex(
                    ((TreeNode) path.getPathComponent(0)).getIndex((TreeNode) path.getPathComponent(1)));
            list.scrollRectToVisible(list.getCellBounds(list.getSelectedIndex(), list.getSelectedIndex()));
        }
        isUpdating--;
    }

    private void updateFamilyList() {
        isUpdating++;
        JList list = selectionPanel.getFamilyList();
        FontChooserModel model = fontChooser.getModel();
        FontCollectionNode newParent = null;
        TreePath path = fontChooser.getSelectionPath();
        if (path != null && path.getPathCount() > 1) {
            newParent = (FontCollectionNode) path.getPathComponent(1);
        }

        if (newParent != familyListParent) {
            DefaultListModel lm = (DefaultListModel) list.getModel();
            lm.removeAllElements();
            familyListParent = newParent;
            if (familyListParent != null) {
                for (int i = 0, n = model.getChildCount(familyListParent); i < n; i++) {
                    lm.addElement(model.getChild(familyListParent, i));
                }
            }
        }

        if (path == null || path.getPathCount() < 3) {
            list.clearSelection();
        } else {
            list.setSelectedIndex(
                    ((TreeNode) path.getPathComponent(1)).getIndex((TreeNode) path.getPathComponent(2)));
            list.scrollRectToVisible(list.getCellBounds(list.getSelectedIndex(), list.getSelectedIndex()));
        }
        isUpdating--;
    }

    private void updateFaceList() {
        isUpdating++;
        JList list = selectionPanel.getFaceList();
        FontChooserModel model = fontChooser.getModel();
        FontFamilyNode newParent = null;
        TreePath path = fontChooser.getSelectionPath();
        if (path != null && path.getPathCount() > 2) {
            newParent = (FontFamilyNode) path.getPathComponent(2);
        }

        if (newParent != faceListParent) {
            DefaultListModel lm = (DefaultListModel) list.getModel();
            lm.removeAllElements();
            faceListParent = newParent;
            if (faceListParent != null) {
                for (int i = 0, n = model.getChildCount(faceListParent); i < n; i++) {
                    lm.addElement(model.getChild(faceListParent, i));
                }
            }
        }

        if (path == null || path.getPathCount() < 4) {
            list.clearSelection();
        } else {
            list.setSelectedIndex(
                    ((TreeNode) path.getPathComponent(2)).getIndex((TreeNode) path.getPathComponent(3)));
            list.scrollRectToVisible(list.getCellBounds(list.getSelectedIndex(), list.getSelectedIndex()));
        }
        isUpdating--;
    }

    private void updatePreview() {
        isUpdating++;
        previewPanel.setSelectedFont(fontChooser.getSelectedFont());
        isUpdating--;
    }

    private void doCollectionChanged() {
        JList list = selectionPanel.getCollectionList();

        TreePath path = fontChooser.getSelectionPath();
        FontCollectionNode oldCollection = (path != null && path.getPathCount() > 1) ? (FontCollectionNode) path.getPathComponent(1) : null;
        FontFamilyNode oldFamily = (path != null && path.getPathCount() > 2) ? (FontFamilyNode) path.getPathComponent(2) : null;
        FontFaceNode oldFace = (path != null && path.getPathCount() > 3) ? (FontFaceNode) path.getPathComponent(3) : null;

        FontCollectionNode newCollection = (FontCollectionNode) list.getSelectedValue();
        FontFamilyNode newFamily = null;
        FontFaceNode newFace = null;

        if ((oldFamily == null || oldFace == null) && fontChooser.getSelectedFont() != null) {
            oldFace = new FontFaceNode(fontChooser.getSelectedFont());
            oldFamily = new FontFamilyNode(fontChooser.getSelectedFont().getFamily());
        }

        if (newCollection != null && oldFamily != null) {
            for (int i = 0,  n = newCollection.getChildCount(); i < n; i++) {
                FontFamilyNode aFamily = newCollection.getChildAt(i);
                if (aFamily.compareTo(oldFamily) == 0) {
                    newFamily = aFamily;
                    break;
                }
            }
        }
        if (newFamily != null && oldFace != null) {
            // search in the new family for the face
            for (FontFaceNode aFace : newFamily.faces()) {
                if (aFace.compareTo(oldFace) == 0) {
                    newFace = aFace;
                    break;
                }
            }
        } else if (newFace == null && oldFamily != null && oldFace != null) {
            OuterLoop:
            for (FontFamilyNode aFamily : newCollection.families()) {
                for (FontFaceNode aFace : aFamily.faces()) {
                    if (aFace.compareTo(oldFace) == 0) {
                        newFace = aFace;
                        newFamily = (FontFamilyNode) aFace.getParent();
                        break OuterLoop;
                    }
                }
            }
        }
        if (newCollection != null) {
            if (newFamily == null && newCollection.getChildCount() > 0) {
                newFamily = newCollection.getChildAt(0);
            }
            if (newFamily != null) {
                if (newFace == null && newFamily.getChildCount() > 0) {
                    newFace = newFamily.getChildAt(0);
                }
            }
        }

        setNewSelectionPath(newCollection, newFamily, newFace);
    }

    private void doFamilyChanged() {
        JList list = selectionPanel.getFamilyList();

        TreePath path = fontChooser.getSelectionPath();
        FontCollectionNode oldCollection = (path != null && path.getPathCount() > 1) ? (FontCollectionNode) path.getPathComponent(1) : null;
        FontFamilyNode oldFamily = (path != null && path.getPathCount() > 2) ? (FontFamilyNode) path.getPathComponent(2) : null;
        FontFaceNode oldFace = (path != null && path.getPathCount() > 3) ? (FontFaceNode) path.getPathComponent(3) : null;

        FontCollectionNode newCollection = oldCollection;
        FontFamilyNode newFamily = (FontFamilyNode) list.getSelectedValue();

        FontFaceNode newFace = null;
        if (newFamily != null && oldFace != null) {
            for (int i = 0,  n = newFamily.getChildCount(); i < n; i++) {
                FontFaceNode aFace = newFamily.getChildAt(i);
                if (aFace.compareTo(oldFace) == 0) {
                    newFace = aFace;
                    break;
                }
            }
        }

        if (newCollection != null) {
            if (newFamily == null && newCollection.getChildCount() > 0) {
                newFamily = newCollection.getChildAt(0);
            }
            if (newFamily != null) {
                if (newFace == null && newFamily.getChildCount() > 0) {
                    newFace = newFamily.getChildAt(0);
                }
            }
        }
        setNewSelectionPath(newCollection, newFamily, newFace);
    }

    private void doFaceChanged() {
        JList list = selectionPanel.getFaceList();

        TreePath path = fontChooser.getSelectionPath();
        FontCollectionNode oldCollection = (path != null && path.getPathCount() > 1) ? (FontCollectionNode) path.getPathComponent(1) : null;
        FontFamilyNode oldFamily = (path != null && path.getPathCount() > 2) ? (FontFamilyNode) path.getPathComponent(2) : null;
        FontFaceNode oldFace = (path != null && path.getPathCount() > 3) ? (FontFaceNode) path.getPathComponent(3) : null;

        FontCollectionNode newCollection = oldCollection;
        FontFamilyNode newFamily = oldFamily;
        FontFaceNode newFace = (FontFaceNode) list.getSelectedValue();

        setNewSelectionPath(newCollection, newFamily, newFace);
    }

    private void setNewSelectionPath(@Nullable FontCollectionNode newCollection, @Nullable FontFamilyNode newFamily, @Nullable FontFaceNode newFace) {
        FontChooserModel model = fontChooser.getModel();

        TreePath newPath;
        if (newFace != null) {
            newPath = new TreePath(new Object[]{
                        model.getRoot(),
                        newCollection,
                        newFamily,
                        newFace
                    });
        } else if (newFamily != null) {
            newPath = new TreePath(new Object[]{
                        model.getRoot(),
                        newCollection,
                        newFamily
                    });
        } else if (newCollection != null) {
            newPath = new TreePath(new Object[]{
                        model.getRoot(),
                        newCollection
                    });
        } else {
            newPath = new TreePath(model.getRoot());
        }
        fontChooser.setSelectionPath(newPath);
    }

    private class SelectionPanelHandler implements KeyListener, MouseListener, ListSelectionListener {

    @Override
        public void valueChanged(ListSelectionEvent evt) {
            if (isUpdating ==
                    0) {
                Object src = evt.getSource();
                if (src == selectionPanel.getCollectionList()) {
                    doCollectionChanged();
                } else if (src == selectionPanel.getFamilyList()) {
                    doFamilyChanged();
                } else if (src == selectionPanel.getFaceList()) {
                    doFaceChanged();
                }
            }
        }

    @Override
        public void keyReleased(KeyEvent evt) {
            Object src = evt.getSource();
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (src == selectionPanel.getCollectionList()) {
                        //
                    } else if (src == selectionPanel.getFamilyList()) {
                        selectionPanel.getCollectionList().requestFocus();
                    } else if (src == selectionPanel.getFaceList()) {
                        selectionPanel.getFamilyList().requestFocus();
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_RIGHT:
                    if (src == selectionPanel.getCollectionList()) {
                        selectionPanel.getFamilyList().requestFocus();
                    } else if (src == selectionPanel.getFamilyList()) {
                        selectionPanel.getFaceList().requestFocus();
                    } else if (src == selectionPanel.getFaceList()) {
                        //
                    }
                    evt.consume();
                    break;
                case KeyEvent.VK_ESCAPE:
                    fontChooser.cancelSelection();
                    evt.consume();
                    break;
                case KeyEvent.VK_ENTER:
                    fontChooser.approveSelection();
                    evt.consume();
                    break;
            }
        }

    @Override
        public void keyPressed(KeyEvent evt) {
        }

    @Override
        public void keyTyped(KeyEvent evt) {
        }

    @Override
        public void mouseClicked(MouseEvent evt) {
            if (evt.getClickCount() == 2 && evt.getButton() == MouseEvent.BUTTON1) {
                fontChooser.approveSelection();
            }
        }

    @Override
        public void mousePressed(MouseEvent e) {
        }

    @Override
        public void mouseReleased(MouseEvent e) {
        }

    @Override
        public void mouseEntered(MouseEvent e) {
        }

    @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class FontChooserHandler implements PropertyChangeListener, TreeModelListener {

    @Override
        public void propertyChange(PropertyChangeEvent evt) {
            String name = evt.getPropertyName();
            if (name == JFontChooser.SELECTION_PATH_PROPERTY) {
                updateCollectionList();
                updateFamilyList();
                updateFaceList();
            } else if (name == JFontChooser.SELECTED_FONT_PROPERTY) {
                updatePreview();
            } else if (name == JFontChooser.MODEL_PROPERTY) {
                FontChooserModel m = (FontChooserModel) evt.getOldValue();
                if (m != null) {
                    m.removeTreeModelListener(this);
                }
                m = (FontChooserModel) evt.getNewValue();
                if (m != null) {
                    m.addTreeModelListener(this);
                }
                updateCollectionList();
                updateFamilyList();
                updateFaceList();
            }
        }

    @Override
        public void treeNodesChanged(TreeModelEvent e) {
            updateCollectionList();
            updateFamilyList();
            updateFaceList();
        }

    @Override
        public void treeNodesInserted(TreeModelEvent e) {
            updateCollectionList();
            updateFamilyList();
            updateFaceList();
        }

    @Override
        public void treeNodesRemoved(TreeModelEvent e) {
            updateCollectionList();
            updateFamilyList();
            updateFaceList();
        }

    @Override
        public void treeStructureChanged(TreeModelEvent e) {
            updateCollectionList();
            updateFamilyList();
            updateFaceList();
        }
    }
}
