/**
 * @(#)FontModel.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.gui.fontchooser;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;

/**
 * This interface defines the methods components like JFontChooser
 * use to get a font from a font collection or a font family.
 * <p>
 * FontChooserModel is a TreeModel with the following structure for 
 * the tree:
 * <ul>
 * <li>The root node must be a MutableTreeNode.</li>
 * <li>A child of the root node must be a FontCollectionNode.</li>
 * <li>A child of a FontCollectionNode must be a FontFamilyNode.</li>
 * <li>A child of a FontFamilyNode must be a FontTypefaceNode.</li>
 * </ul>
 *
 * @author Werner Randelshofer
 * @version $Id: FontChooserModel.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public interface FontChooserModel extends TreeModel {
    /**
     * Returns <code>true</code> if <code>node</code> is editable by the user.
     * This method returns true, if the node and all its parents are editable.
     *
     * @param   node  a node in the tree, obtained from this data source
     * @return  true if <code>node</code> is editable
     */
    public boolean isEditable(MutableTreeNode node);    
}
