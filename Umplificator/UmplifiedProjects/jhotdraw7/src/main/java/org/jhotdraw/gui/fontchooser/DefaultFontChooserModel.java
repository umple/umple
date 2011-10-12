/**
 * @(#)DefaultFontModel.java
 *
 * Copyright (c) 2008 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.gui.fontchooser;

import java.awt.*;
import java.util.*;
import java.util.ArrayList;
import javax.swing.tree.*;
import org.jhotdraw.util.ResourceBundleUtil;

/**
 * DefaultFontChooserModel with a predefined set of font collections.
 * <p>
 * Loading the fonts may take a lot of time. Therefore it is recommended to 
 * create a Future during the startup of an application, and set the fonts in 
 * the font chooser model when they are needed.
 * <p>
 * Example:
 * <pre>
 *   private static FutureTask<Font[]> future = new FutureTask<Font[]>(new Callable<Font[]>() {
 *
 *      public Font[] call() throws Exception {
 *          return GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
 *
 *       }
 *   });
 * </pre>
 * 
 * @author Werner Randelshofer
 * @version $Id: DefaultFontChooserModel.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class DefaultFontChooserModel extends AbstractFontChooserModel {

    /**
     * Root node.
     */
    protected DefaultMutableTreeNode root;

    public DefaultFontChooserModel() {
        root = new DefaultMutableTreeNode();
    }

    public DefaultFontChooserModel(Font[] fonts) {
        root = new DefaultMutableTreeNode();
        setFonts(fonts);
    }

    /**
     * Sets the fonts of the DefaultFontChooserModel.
     * <p>
     * Fires treeStructureChanged event on the root node.
     * 
     * @param fonts
     */
    @SuppressWarnings("unchecked")
    public void setFonts(Font[] fonts) {
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.gui.Labels");

        // collect families and sort them alphabetically
        ArrayList<FontFamilyNode> families = new ArrayList<FontFamilyNode>();
        HashMap<String, FontFamilyNode> familyMap = new HashMap<String, FontFamilyNode>();
        for (Font f : fonts) {
            String familyName = f.getFamily();
            FontFamilyNode family;
            if (familyMap.containsKey(familyName)) {
                family = familyMap.get(familyName);
            } else {
                family = new FontFamilyNode(familyName);
                familyMap.put(familyName, family);
            }
            family.add(new FontFaceNode(f));
        }
        families.addAll(familyMap.values());
        Collections.sort(families);

        // group families into collections
        root.removeAllChildren();

        root.add(new FontCollectionNode(labels.getString("FontCollection.allFonts"), (ArrayList<FontFamilyNode>) families.clone()));

        // Web-save fonts
        root.add(
                new FontCollectionNode(labels.getString("FontCollection.web"), collectFamiliesNamed(families,
                "Arial",
                "Arial Black",
                "Comic Sans MS",
                "Georgia",
                "Impact",
                "Times New Roman",
                "Trebuchet MS",
                "Verdana",
                "Webdings")));

        /*
        // PDF Fonts
        root.add(
        new FontCollectionNode(labels.getString("FontCollection.pdf"), collectFamiliesNamed(families,
        "Andale Mono",
        "Courier",
        "Helvetica",
        "Symbol",
        "Times",
        "Zapf Dingbats")));
         */
        // Java System fonts
        root.add(
                new FontCollectionNode(labels.getString("FontCollection.system"), collectFamiliesNamed(families,
                "Dialog",
                "DialogInput",
                "Monospaced",
                "SansSerif",
                "Serif")));
        // Serif fonts
        root.add(
                new FontCollectionNode(labels.getString("FontCollection.serif"), collectFamiliesNamed(families,
                // Fonts on Mac OS X 10.5:
                "Adobe Caslon Pro",
                "Adobe Garamond Pro",
                "American Typewriter",
                "Arno Pro",
                "Baskerville",
                "Baskerville Old Face",
                "Bell MT",
                "Big Caslon",
                "Bodoni SvtyTwo ITC TT",
                "Bodoni SvtyTwo OS ITC TT",
                "Bodoni SvtyTwo SC ITC TT",
                "Book Antiqua",
                "Bookman Old Style",
                "Calisto MT",
                "Chaparral Pro",
                "Century",
                "Century Schoolbook",
                "Cochin",
                "Footlight MT Light",
                "Garamond",
                "Garamond Premier Pro",
                "Georgia",
                "Goudy Old Style",
                "Hoefler Text",
                "Lucida Bright",
                "Lucida Fax",
                "Minion Pro",
                "Palatino",
                "Times",
                "Times New Roman",
                //
                // Fonts on Mac OS X 10.6:
                "Didot",
                //
                // Fonts on Windows XP:
                "Palatino Linotype",
                "Bitstream Vera Serif Bold",
                "Bodoni MT",
                "Bodoni MT Black",
                "Bodoni MT Condensed",
                "Californian FB",
                "Cambria",
                "Cambria Math",
                "Centaur",
                "Constantia",
                "High Tower Text",
                "Perpetua",
                "Poor Richard",
                "Rockwell Condensed",
                "Slimbach-Black",
                "Slimbach-BlackItalic",
                "Slimbach-Bold",
                "Slimbach-BoldItalic",
                "Slimbach-Book",
                "Slimbach-BookItalic",
                "Slimbach-Medium",
                "Slimbach-MediumItalic",
                "Sylfaen",
                // Fonts on Windows Vista
                "Andalus",
                "Angsana New",
                "AngsanaUPC",
                "Arabic Typesetting",
                "Cambria",
                "Cambria Math",
                "Constantia",
                "DaunPenh",
                "David",
                "DilleniaUPC",
                "EucrosiaUPC",
                "Frank Ruehl",
                "IrisUPC",
                "Iskoola Pota",
                "JasmineUPC",
                "KodchiangUPC",
                "Narkisim")));
        // Sans Serif
        root.add(
                new FontCollectionNode(labels.getString("FontCollection.sansSerif"), collectFamiliesNamed(families,
                // Fonts on Mac OS X 10.5:
                "Abadi MT Condensed Extra Bold",
                "Abadi MT Condensed Light",
                "AppleGothic",
                "Arial",
                "Arial Black",
                "Arial Narrow",
                "Arial Rounded MT Bold",
                "Arial Unicode MS",
                "Bell Gothic Std",
                "Blair MdITC TT",
                "Century Gothic",
                "Frutiger",
                "Futura",
                "Geneva",
                "Gill Sans",
                "Gulim",
                "Helvetica",
                "Helvetica Neue",
                "Lucida Grande",
                "Lucida Sans",
                "Microsoft Sans Serif",
                "Myriad Pro",
                "News Gothic",
                "Tahoma",
                "Trebuchet MS",
                "Verdana",
                //
                // Fonts on Mac OS X 10.6:
                "Charcoal",
                "Euphemia UCAS",
                //
                // Fonts on Windows XP:
                "Franklin Gothic Medium",
                "Lucida Sans Unicode",
                "Agency FB",
                "Berlin Sans FB",
                "Berlin Sans FB Demi Bold",
                "Bitstream Vera Sans Bold",
                "Calibri",
                "Candara",
                "Corbel",
                "Estrangelo Edessa",
                "Eras Bold ITC",
                "Eras Demi ITC",
                "Eras Light ITC",
                "Eras Medium ITC",
                "Franklin Gothic Book",
                "Franklin Gothic Demi",
                "Franklin Gothic Demi Cond",
                "Franklin Gothic Heavy",
                "Franklin Gothic Medium Cond",
                "Gill Sans MT",
                "Gill Sans MT Condensed",
                "Gill Sans MT Ext Condensed Bold",
                "Maiandra GD",
                "MS Reference Sans...",
                "Tw Cen MT",
                "Tw Cen MT Condensed",
                "Tw Cen MT Condensed Extra Bold",
                //
                // Fonts on Windows Vista:
                "Aharoni",
                "Browallia New",
                "BrowalliaUPC",
                "Calibri",
                "Candara",
                "Corbel",
                "Cordia New",
                "CordiaUPC",
                "DokChampa",
                "Dotum",
                "Estrangelo Edessa",
                "Euphemia",
                "Freesia UPC",
                "Gautami",
                "Gisha",
                "Kalinga",
                "Kartika",
                "Levenim MT",
                "LilyUPC",
                "Malgun Gothic",
                "Meiryo",
                "Miriam",
                "Segoe UI")));

        // Scripts 
        root.add(
                new FontCollectionNode(labels.getString("FontCollection.script"), collectFamiliesNamed(families,
                // Fonts on Mac OS X 10.5:
                "Apple Chancery",
                "Bickham Script Pro",
                "Blackmoor LET",
                "Bradley Hand ITC TT",
                "Brush Script MT",
                "Brush Script Std",
                "Chalkboard",
                "Charlemagne Std",
                "Comic Sans MS",
                "Curlz MT",
                "Edwardian Script ITC",
                "Footlight MT Light",
                "Giddyup Std",
                "Handwriting - Dakota",
                "Harrington",
                "Herculanum",
                "Kokonor",
                "Lithos Pro",
                "Lucida Blackletter",
                "Lucida Calligraphy",
                "Lucida Handwriting",
                "Marker Felt",
                "Matura MT Script Capitals",
                "Mistral",
                "Monotype Corsiva",
                "Party LET",
                "Papyrus",
                "Santa Fe LET",
                "Savoye LET",
                "SchoolHouse Cursive B",
                "SchoolHouse Printed A",
                "Skia",
                "Snell Roundhand",
                "Tekton Pro",
                "Trajan Pro",
                "Zapfino",
                //
                // Fonts on Mac OS X 10.6:
                "Casual",
                "Chalkduster",
                //
                // Fonts on Windows XP:
                "Blackadder ITC",
                "Bradley Hand ITC",
                "Chiller",
                "Freestyle Script",
                "French Script MT",
                "Gigi",
                "Harlow Solid Italic",
                "Informal Roman",
                "Juice ITC",
                "Kristen ITC",
                "Kunstler Script",
                "Magneto Bold",
                "Maiandra GD",
                "Old English Text",
                "Palace Script MT",
                "Parchment",
                "Pristina",
                "Rage Italic",
                "Ravie",
                "Script MT Bold",
                "Tempus Sans ITC",
                "Viner Hand ITC",
                "Vivaldi Italic",
                "Vladimir Script",
                // Fonts on Windows Vista
                "Segoe Print",
                "Segoe Script")));

        // Monospaced
        root.add(
                new FontCollectionNode(labels.getString("FontCollection.monospaced"), collectFamiliesNamed(families,
                // Fonts on Mac OS X 10.5:
                "Andale Mono",
                "Courier",
                "Courier New",
                "Letter Gothic Std",
                "Lucida Sans Typewriter",
                "Monaco",
                "OCR A Std",
                "Orator Std",
                "Prestige Elite Std",
                //
                // Fonts on Mac OS X 10.6:
                "Menlo",
                //
                // Fonts on Windows XP:
                "Lucida Console",
                "Bitstream Vera S...",
                "Consolas",
                "OCR A Extended",
                "OCR B",
                //
                // Fonts on Windows Vista
                "Consolas",
                "DotumChe",
                "Miriam Fixed",
                "Rod")));

        // Decorative
        root.add(
                new FontCollectionNode(labels.getString("FontCollection.decorative"), collectFamiliesNamed(families,
                // Fonts on Mac OS X 10.5:
                "Academy Engraved LET",
                "Arial Black",
                "Bank Gothic",
                "Bauhaus 93",
                "Bernard MT Condensed",
                "Birch Std",
                "Blackoak Std",
                "BlairMdITC TT",
                "Bordeaux Roman Bold LET",
                "Braggadocio",
                "Britannic Bold",
                "Capitals",
                "Colonna MT",
                "Cooper Black",
                "Cooper Std",
                "Copperplate",
                "Copperplate Gothic Bold",
                "Copperplate Gothic Light",
                "Cracked",
                "Desdemona",
                "Didot",
                "Eccentric Std",
                "Engravers MT",
                "Eurostile",
                "Gill Sans Ultra Bold",
                "Gloucester MT Extra Condensed",
                "Haettenschweiler",
                "Hobo Std",
                "Impact",
                "Imprint MT Shadow",
                "Jazz LET",
                "Kino MT",
                "Matura MT Script Capitals",
                "Mesquite Std",
                "Modern No. 20",
                "Mona Lisa Solid ITC TT",
                "MS Gothic",
                "Nueva Std",
                "Onyx",
                "Optima",
                "Perpetua Titling MT",
                "Playbill",
                "Poplar Std",
                "PortagoITC TT",
                "Princetown LET",
                "Rockwell",
                "Rockwell Extra Bold",
                "Rosewood Std",
                "Santa Fe LET",
                "Stencil",
                "Stencil Std",
                "Stone Sans ITC TT",
                "Stone Sans OS ITC TT",
                "Stone Sans Sem ITC TT",
                "Stone Sans Sem OS ITCTT",
                "Stone Sans Sem OS ITC TT",
                "Synchro LET",
                "Wide Latin",
                //
                // Fonts on Mac OS X 10.5:
                "HeadLineA",
                //
                // Fonts on Windows XP:
                "Algerian",
                "Bodoni MT Black",
                "Bodoni MT Poster Compressed",
                "Broadway",
                "Castellar",
                "Elephant",
                "Felix Titling",
                "Franklin Gothic Heavy",
                "Gill Sans MT Ext Condensed Bold",
                "Gill Sans Ultra Bold Condensed",
                "Goudy Stout",
                "Jokerman",
                "Juice ITC",
                "Magneto",
                "Magneto Bold",
                "Niagara Engraved",
                "Niagara Solid",
                "Poor Richard",
                "Ravie",
                "Rockwell Condensed",
                "Showcard Gothic",
                "Slimbach-Black",
                "Slimbach-BlackItalic",
                "Snap ITC" // Fonts on Windows Vista:
                )));
        root.add(
                new FontCollectionNode(labels.getString("FontCollection.symbols"), collectFamiliesNamed(families,
                // Fonts on Mac OS X 10.5:
                "Apple Symbols",
                "Blackoack Std",
                "Bodoni Ornaments ITC TT",
                "EuropeanPi",
                "Monotype Sorts",
                "MT Extra",
                "Symbol",
                "Type Embellishments One LET",
                "Webdings",
                "Wingdings",
                "Wingdings 2",
                "Wingdings 3",
                "Zapf Dingbats",
                //
                // Fonts on Windows XP:

                "Bookshelf Symbol" //
                // Fonts on Windows Vista:
                )));

        // Collect font families, which are not in one of the other collections
        // (except the collection AllFonts).
        FontCollectionNode others = new FontCollectionNode(labels.getString("FontCollection.other"));
        HashSet<FontFamilyNode> otherFamilySet = new HashSet<FontFamilyNode>();
        otherFamilySet.addAll(families);
        for (int i = 1, n = root.getChildCount(); i < n; i++) {
            FontCollectionNode fcn = (FontCollectionNode) root.getChildAt(i);
            for (FontFamilyNode ffn : fcn.families()) {
                otherFamilySet.remove(ffn);
            }
        }
        ArrayList<FontFamilyNode> otherFamilies = new ArrayList<FontFamilyNode>();
        for (FontFamilyNode ffn : otherFamilySet) {
            otherFamilies.add(ffn.clone());
        }
        Collections.sort(otherFamilies);
        others.addAll(otherFamilies);
        root.add(others);

        fireTreeStructureChanged(this, new TreePath(root));
    }

    protected ArrayList<FontFamilyNode> collectFamiliesNamed(ArrayList<FontFamilyNode> families, String... names) {
        ArrayList<FontFamilyNode> coll = new ArrayList<FontFamilyNode>();
        HashSet<String> nameMap = new HashSet<String>();
        nameMap.addAll(Arrays.asList(names));
        for (FontFamilyNode family : families) {
            String fName = family.getName();
            if (nameMap.contains(family.getName())) {
                coll.add(family.clone());
            }

        }
        return coll;
    }

    @Override
    public boolean isEditable(MutableTreeNode node) {
        boolean result = true;
        if (node instanceof FontFaceNode) {
            result &= ((FontFaceNode) node).isEditable();
            node = (MutableTreeNode) node.getParent();
        }

        if (result && (node instanceof FontFamilyNode)) {
            result &= ((FontFamilyNode) node).isEditable();
            node = (MutableTreeNode) node.getParent();
        }

        if (result && (node instanceof FontCollectionNode)) {
            result &= ((FontCollectionNode) node).isEditable();
        }

        return result;
    }

    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object getChild(
            Object parent, int index) {
        return ((TreeNode) parent).getChildAt(index);
    }

    @Override
    public int getChildCount(Object parent) {
        return ((TreeNode) parent).getChildCount();
    }

    @Override
    public boolean isLeaf(Object node) {
        return ((TreeNode) node).isLeaf();
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        return ((TreeNode) parent).getIndex((TreeNode) child);
    }

    public static class UIResource extends DefaultFontChooserModel implements javax.swing.plaf.UIResource {
    }
}
