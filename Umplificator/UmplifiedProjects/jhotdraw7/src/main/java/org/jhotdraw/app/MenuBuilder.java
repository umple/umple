/*
 * @(#)MenuBuilder.java
 * 
 * Copyright (c) 2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 * 
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.app;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.util.List;
import javax.swing.JMenu;

/**
 * {@code MenuBuilder} is used by {@link Application} to build to build its menu
 * bar(s) and popup menu(s).
 * <p>
 * Each method adds a logical group of menu items to a menu provided by the
 * {@code Application}.
 * <p>
 * Implementors of this interface typically use actions retrieved from the
 * application to build the menu items. See {@link DefaultMenuBuilder} for a
 * typical implementation.
 * <p>
 * Menus may be associated to a specific view or to all views (global) of the
 * application. In the former case the corresponding view is provided, in the
 * latter case null is passed. Note that some applications, specifically
 * {@link OSXApplication}, need to create both kinds of menus.
 * <p>
 * During the lifetime of an application many menus may be created and destroyed.
 * Implementors must take care that menu items can be garbage collected.
 *
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Abstract Factory</em><br>
 * {@code MenuBuilder} is used by {@code Application} for creating menu items.
 * The {@code MenuBuilder} is provided by {@code ApplicationModel}.
 * Abstract Factory: {@link MenuBuilder}<br>
 * Client: {@link Application}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: MenuBuilder.java 719 2010-11-22 16:53:51Z rawcoder $
 */
public interface MenuBuilder {

    /** Optionally adds one or more "Preferences" items to a menu.
     * <p>
     * Most applications use this method for adding items to the last section
     * of the "Edit" menu.
     * <p>
     * Note that {@link OSXApplication} does <b>not</b> invoke this method and
     * instead retrieves an action with ID {@code AbstractPreferencesAction.ID}
     * from the action map of the {@code ApplicationModel} and adds it to the
     * "Application" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addPreferencesItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more "Exit" items to a menu.
     * <p>
     * Most applications use this method for adding items to the last section
     * of the "File" menu.
     * <p>
     * Note that {@link OSXApplication} does <b>not</b> invoke this method and
     * instead retrieves an action with ID {@code ExitAction.ID}
     * from the action map of the {@code ApplicationModel} and adds it to the
     * "Application" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addExitItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more "Clear File" items to a menu.
     * <p>
     * Most applications use this method for adding items to the first section
     * of the "File" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addClearFileItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more "New Window" items to a menu.
     * <p>
     * Most applications use this method for adding items to the first section
     * of the "File" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addNewWindowItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more "New File" items to a menu.
     * <p>
     * Most applications use this method for adding items to the first section
     * of the "File" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addNewFileItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more "Load file" items to a menu.
     * <p>
     * Most applications use this method for adding items to the first section
     * of the "File" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addLoadFileItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more "Open File" items to a menu.
     * <p>
     * Most applications use this method for adding items to the first section
     * of the "File" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addOpenFileItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more "Close File" items to a menu.
     * <p>
     * Most applications use this method for adding items to the second section
     * of the "File" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addCloseFileItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more "Save File" items to a menu.
     * <p>
     * Most applications use this method for adding items to the second section
     * of the "File" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addSaveFileItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more "Export File" items to a menu.
     * <p>
     * Most applications use this method for adding items to the second section
     * of the "File" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addExportFileItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more "Print File" items to a menu.
     * <p>
     * Most applications use this method for adding items to the third section
     * of the "File" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addPrintFileItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more file related items to a menu.
     * <p>
     * Most applications use this method for adding items to the third section
     * of the "File" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addOtherFileItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more "Undo" items to a menu.
     * <p>
     * Most applications use this method for adding items to the first section
     * of the "Edit" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addUndoItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more "Clipboard" items to a menu.
     * <p>
     * Most applications use this method for adding items to the second section
     * of the "Edit" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addClipboardItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more "Selection" items to a menu.
     * <p>
     * Most applications use this method for adding items to the third section
     * of the "Edit" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addSelectionItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more "Find" items to a menu.
     * <p>
     * Most applications use this method for adding items to the fourth section
     * of the "Edit" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addFindItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more editing related items to a menu.
     * <p>
     * Most applications use this method for adding items to the fifth section
     * of the "Edit" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addOtherEditItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more view related items to a menu.
     * <p>
     * Most applications use this method for adding items to the first section
     * of the "View" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addOtherViewItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more additional menus to a menu bar or a pop up
     * menu.
     * <p>
     * Most applications add additional menus between the "View" menu and the
     * "Window" menu to the menu bar.
     *
     * @param m A (potentially non-empty) list of menus.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addOtherMenus(List<JMenu> m, Application app, @Nullable View v);

    /** Optionally adds one or more window related items to a menu.
     * <p>
     * Most applications use this method for adding items to the second section
     * of the "Window" menu. (The first section usually contains application
     * specific items). Some applications, such as {@link SDIApplication} add
     * these items to the "View" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addOtherWindowItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more "Help" items to a menu.
     * <p>
     * Most applications use this method for adding items to the first section
     * of the "Help" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addHelpItems(JMenu m, Application app, @Nullable View v);

    /** Optionally adds one or more "About" items to a menu.
     * <p>
     * Most applications use this method for adding items to the last section
     * of the "Help" menu.
     * <p>
     * Note that {@link OSXApplication} does <b>not</b> invoke this method and
     * instead retrieves an action with ID {@code AboutAction.ID}
     * from the action map of the {@code ApplicationModel} and adds it to the
     * "Application" menu.
     *
     * @param m A (potentially non-empty) menu.
     * @param app The Application for which the menu is built.
     * @param v A view the menu is used exclusively for a specific view, null
     * if the menu is shared by all views.
     */
    void addAboutItems(JMenu m, Application app, @Nullable View v);
}
