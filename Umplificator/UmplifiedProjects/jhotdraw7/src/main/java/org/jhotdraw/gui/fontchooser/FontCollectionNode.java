/**
 * @(#)FontCollectionNode.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui.fontchooser;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * A FontCollectionNode is a MutableTreeNode which only allows FontFamilyNode
 * as child nodes.
 *
 * @author Werner Randelshofer
 * @version $Id: FontCollectionNode.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class FontCollectionNode implements MutableTreeNode, Comparable<FontCollectionNode>, Cloneable {

    @Nullable
    private MutableTreeNode parent;
    private String name;
    private ArrayList<FontFamilyNode> children;
    private boolean isEditable;

    public FontCollectionNode(String name) {
        this.name = name;
        children = new ArrayList<FontFamilyNode>();
    }

    public FontCollectionNode(String name, ArrayList<FontFamilyNode> families) {
        this.name = name;
        this.children = families;
    }

    @Override
    public int compareTo(FontCollectionNode that) {
        return Collator.getInstance().compare(this.name, that.name);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public FontCollectionNode clone() {
        FontCollectionNode that;
        try {
            that = (FontCollectionNode) super.clone();
        } catch (CloneNotSupportedException ex) {
            InternalError error = new InternalError("Clone failed");
            error.initCause(ex);
            throw error;
        }
        that.parent = null;
        that.children = new ArrayList<FontFamilyNode>();
        for (FontFamilyNode f : this.children) {
            that.insert(f.clone(), that.getChildCount());
        }
        return that;
    }

    public void add(FontFamilyNode newChild) {
        insert(newChild, getChildCount());
    }

    public void addAll(Collection<FontFamilyNode> c) {
        children.addAll(c);
    }

    @Override
    public void insert(MutableTreeNode newChild, int index) {
        FontCollectionNode oldParent = (FontCollectionNode) newChild.getParent();
        if (oldParent != null) {
            oldParent.remove(newChild);
        }
        newChild.setParent(this);
        children.add(index, (FontFamilyNode) newChild);
    }

    @Override
    public void remove(int childIndex) {
        MutableTreeNode child = (MutableTreeNode) getChildAt(childIndex);
        children.remove(childIndex);
        child.setParent(null);
    }

    @Override
    public void remove(MutableTreeNode aChild) {
        if (aChild == null) {
            throw new IllegalArgumentException("argument is null");
        }

        if (!isNodeChild(aChild)) {
            throw new IllegalArgumentException("argument is not a child");
        }
        remove(getIndex(aChild));	// linear search
    }

    @Override
    public void setUserObject(Object object) {
        throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public void removeFromParent() {
        if (parent != null) {
            parent.remove(this);
        }
    }

    @Override
    public void setParent(@Nullable MutableTreeNode newParent) {
        this.parent = newParent;
    }

    @Override
    public FontFamilyNode getChildAt(int childIndex) {
        return children.get(childIndex);
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    @Override
    @Nullable
    public MutableTreeNode getParent() {
        return parent;
    }

    @Override
    public int getIndex(TreeNode node) {
        return children.indexOf(node);
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public boolean isLeaf() {
        return children.isEmpty();
    }

    @Override
    public Enumeration children() {
        return Collections.enumeration(children);
    }

    public java.util.List<FontFamilyNode> families() {
        return Collections.unmodifiableList(children);
    }
    //
    //  Child Queries
    //

    /**
     * Returns true if <code>aNode</code> is a child of this node.  If
     * <code>aNode</code> is null, this method returns false.
     *
     * @return	true if <code>aNode</code> is a child of this node; false if 
     *  		<code>aNode</code> is null
     */
    public boolean isNodeChild(TreeNode aNode) {
        boolean retval;

        if (aNode == null) {
            retval = false;
        } else {
            if (getChildCount() == 0) {
                retval = false;
            } else {
                retval = (aNode.getParent() == this);
            }
        }

        return retval;
    }

    public boolean isEditable() {
        return isEditable;
    }

    public void setEditable(boolean newValue) {
        isEditable = newValue;
    }
}
