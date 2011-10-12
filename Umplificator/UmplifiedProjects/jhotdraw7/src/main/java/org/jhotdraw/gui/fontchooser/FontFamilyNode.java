/**
 * @(#)FontFamily.java
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
import java.util.*;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * A FontFamilyNode is a MutableTreeNode which only allows FontFaceNode
 * as child nodes.
 *
 * @author Werner Randelshofer
 * @version $Id: FontFamilyNode.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class FontFamilyNode implements MutableTreeNode, Comparable<FontFamilyNode>, Cloneable {

    @Nullable
    private FontCollectionNode parent;
    private String name;
    private ArrayList<FontFaceNode> children = new ArrayList<FontFaceNode>();

    public FontFamilyNode(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(FontFamilyNode that) {
        return Collator.getInstance().compare(this.name, that.name);
    }

    @Override
    public FontFamilyNode clone() {
        FontFamilyNode that;
        try {
            that = (FontFamilyNode) super.clone();
        } catch (CloneNotSupportedException ex) {
            InternalError error = new InternalError("Clone failed");
            error.initCause(ex);
            throw error;
        }
        that.parent = null;
        that.children = new ArrayList<FontFaceNode>();
        for (FontFaceNode f : this.children) {
            that.insert(f.clone(), that.getChildCount());
        }
        return that;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void add(FontFaceNode newChild) {
        insert(newChild, getChildCount());
    }

    @Override
    public void insert(MutableTreeNode newChild, int index) {
        FontFamilyNode oldParent = (FontFamilyNode) newChild.getParent();
        if (oldParent != null) {
            oldParent.remove(newChild);
        }
        newChild.setParent(this);
        children.add(index, (FontFaceNode) newChild);
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
        this.parent = (FontCollectionNode) newParent;
    }

    @Override
    public FontFaceNode getChildAt(int childIndex) {
        return children.get(childIndex);
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    @Override
    @Nullable
    public TreeNode getParent() {
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

    public java.util.List<FontFaceNode> faces() {
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
        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof FontFamilyNode) {
            FontFamilyNode that = (FontFamilyNode) o;
            return that.name.equals(this.name);
        }
        return false;
    }
}
