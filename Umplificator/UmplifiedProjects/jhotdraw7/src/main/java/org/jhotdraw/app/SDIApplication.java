/*
 * @(#)SDIApplication.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.app;

import edu.umd.cs.findbugs.annotations.Nullable;
import org.jhotdraw.app.action.app.AbstractPreferencesAction;
import org.jhotdraw.app.action.window.ToggleVisibleAction;
import org.jhotdraw.app.action.file.SaveFileAsAction;
import org.jhotdraw.app.action.file.SaveFileAction;
import org.jhotdraw.app.action.file.LoadDirectoryAction;
import org.jhotdraw.app.action.file.PrintFileAction;
import org.jhotdraw.app.action.file.NewFileAction;
import org.jhotdraw.app.action.file.ClearFileAction;
import org.jhotdraw.app.action.file.OpenFileAction;
import org.jhotdraw.app.action.file.CloseFileAction;
import org.jhotdraw.app.action.file.LoadFileAction;
import org.jhotdraw.app.action.file.OpenDirectoryAction;
import org.jhotdraw.app.action.file.ExportFileAction;
import org.jhotdraw.app.action.app.AboutAction;
import org.jhotdraw.util.*;
import org.jhotdraw.util.prefs.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.net.URI;
import java.util.*;
import java.util.prefs.*;
import javax.swing.*;
import org.jhotdraw.app.action.*;
import org.jhotdraw.app.action.edit.AbstractFindAction;
import org.jhotdraw.app.action.edit.ClearSelectionAction;
import org.jhotdraw.app.action.edit.CopyAction;
import org.jhotdraw.app.action.edit.CutAction;
import org.jhotdraw.app.action.edit.DeleteAction;
import org.jhotdraw.app.action.edit.DuplicateAction;
import org.jhotdraw.app.action.edit.PasteAction;
import org.jhotdraw.app.action.edit.RedoAction;
import org.jhotdraw.app.action.edit.SelectAllAction;
import org.jhotdraw.app.action.edit.UndoAction;
import org.jhotdraw.app.action.file.ClearRecentFilesMenuAction;
import org.jhotdraw.app.action.file.NewWindowAction;
import org.jhotdraw.net.URIUtil;

/**
 * {@code SDIApplication} handles the lifecycle of multiple {@link View}s
 * using a Windows single document interface (SDI).
 * <p>
 * This user interface created by this application follows the guidelines given
 * in the
 * <a href="http://msdn.microsoft.com/en-us/library/aa511258.aspx"
 * >Windows User Experience Interaction Guidelines</a>.
 * <p>
 * An application of this type can open multiple {@link View}s. Each view is
 * shown in a separate {@code JFrame}.
 * <p>
 * Each JFrame contains a menu bar, toolbars and palette bars for
 * the views.
 * <p>
 * The life cycle of the application is tied to the {@code JFrame}s. Closing the
 * last {@code JFrame} quits the application.

 * SDIApplication handles the life cycle of a single document window
 * being presented in a JFrame. The JFrame provides all the functionality needed
 * to work with the document, such as a menu bar, tool bars and palette windows.
 * <p>
 * The life cycle of the application is tied to the JFrame. Closing the JFrame
 * quits the application.
 * <p>
 * The menu bar of a JFrame has the following standard menus:
 * <pre>
 * File &nbsp; Edit &nbsp; View &nbsp; Help</pre>
 *
 * The <b>file menu</b> has the following standard menu items:
 * <pre>
 *  Clear ({@link ClearFileAction#ID}})
 *  New ({@link NewFileAction#ID}})
 *  New Window ({@link NewWindowAction#ID}})
 *  Load... ({@link LoadFileAction#ID}})
 *  Open... ({@link OpenFileAction#ID}})
 *  Load Directory... ({@link LoadDirectoryAction#ID}})
 *  Open Directory... ({@link OpenDirectoryAction#ID}})
 *  Load Recent &gt; "Filename" ({@link org.jhotdraw.app.action.file.LoadRecentFileAction#ID})
 *  Open Recent &gt; "Filename" ({@link org.jhotdraw.app.action.file.OpenRecentFileAction#ID})
 *  -
 *  Save ({@link SaveFileAction#ID})
 *  Save As... ({@link SaveFileAsAction#ID})
 *  Export... ({@link ExportFileAction#ID})
 *  Print... ({@link PrintFileAction#ID})
 *  -
 *  Close ({@link CloseFileAction#ID})
 * </pre>
 *
 * The <b>edit menu</b> has the following standard menu items:
 * <pre>
 *  Undo ({@link UndoAction#ID}})
 *  Redo ({@link RedoAction#ID}})
 *  -
 *  Cut ({@link CutAction#ID}})
 *  Copy ({@link CopyAction#ID}})
 *  Paste ({@link PasteAction#ID}})
 *  Duplicate ({@link DuplicateAction#ID}})
 *  Delete... ({@link DeleteAction#ID}})
 *  -
 *  Select All ({@link SelectAllAction#ID}})
 *  Clear Selection ({@link ClearSelectionAction#ID}})
 *  -
 *  Find ({@link AbstractFindAction#ID}})
 *  -
 *  Preferences... ({@link AbstractPreferencesAction#ID})
 * </pre>
 *
 * The <b>view menu</b> has the following standard menu items:
 * <pre>
 *  "Toolbar" ({@link ToggleVisibleAction})
 * </pre>
 *
 * The <b>view menu</b> has the following standard menu items:
 * <pre>
 *  About ({@link AboutAction#ID})
 * </pre>
 *
 * The menus provided by the {@code ApplicationModel} are inserted between
 * the file menu and the window menu. In case the application model supplies
 * a menu with the title "Help", it is inserted after the window menu.
 *
 * @author Werner Randelshofer
 * @version $Id: SDIApplication.java 732 2011-01-22 20:26:30Z rawcoder $
 */
public class SDIApplication extends AbstractApplication {

    private Preferences prefs;

    /** Creates a new instance. */
    public SDIApplication() {
    }

    @Override
    public void launch(String[] args) {
        System.setProperty("apple.awt.graphics.UseQuartz", "false");
        super.launch(args);
    }

    @Override
    public void init() {
        super.init();
        initLookAndFeel();
        prefs = PreferencesUtil.userNodeForPackage((getModel() == null) ? getClass() : getModel().getClass());
        initLabels();
        setActionMap(createModelActionMap(model));
    }

    @Override
    public void remove(View p) {
        super.remove(p);
        if (views().size() == 0) {
            stop();
        }
    }

    @Override
    public void configure(String[] args) {
        System.setProperty("apple.laf.useScreenMenuBar", "false");
        System.setProperty("com.apple.macos.useScreenMenuBar", "false");
        System.setProperty("apple.awt.graphics.UseQuartz", "false");
        System.setProperty("swing.aatext", "true");
    }

    protected void initLookAndFeel() {
        try {
            String lafName = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(lafName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (UIManager.getString("OptionPane.css") == null) {
            UIManager.put("OptionPane.css", "<head>"
                    + "<style type=\"text/css\">"
                    + "b { font: 13pt \"Dialog\" }"
                    + "p { font: 11pt \"Dialog\"; margin-top: 8px }"
                    + "</style>"
                    + "</head>");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void show(final View view) {
        if (!view.isShowing()) {
            view.setShowing(true);
            final JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            updateViewTitle(view, f);

            JPanel panel = (JPanel) wrapViewComponent(view);
            f.add(panel);
            f.setSize(new Dimension(600, 400));
            f.setJMenuBar(createMenuBar(view));

            PreferencesUtil.installFramePrefsHandler(prefs, "view", f);
            Point loc = f.getLocation();
            boolean moved;
            do {
                moved = false;
                for (Iterator i = views().iterator(); i.hasNext();) {
                    View aView = (View) i.next();
                    if (aView != view
                            && SwingUtilities.getWindowAncestor(aView.getComponent()) != null
                            && SwingUtilities.getWindowAncestor(aView.getComponent()).
                            getLocation().equals(loc)) {
                        loc.x += 22;
                        loc.y += 22;
                        moved = true;
                        break;
                    }
                }
            } while (moved);
            f.setLocation(loc);

            f.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(final WindowEvent evt) {
                    getAction(view, CloseFileAction.ID).actionPerformed(
                            new ActionEvent(f, ActionEvent.ACTION_PERFORMED,
                            "windowClosing"));
                }

                @Override
                public void windowClosed(final WindowEvent evt) {
                    view.stop();
                }

                @Override
                public void windowGainedFocus(WindowEvent e) {
                    setActiveView(view);
                }
            });

            view.addPropertyChangeListener(new PropertyChangeListener() {

                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    String name = evt.getPropertyName();
                    if (name.equals(View.HAS_UNSAVED_CHANGES_PROPERTY)
                            || name.equals(View.URI_PROPERTY)
                            || name.equals(View.TITLE_PROPERTY)
                            || name.equals(View.MULTIPLE_OPEN_ID_PROPERTY)) {
                        updateViewTitle(view, f);
                    }
                }
            });

            f.setVisible(true);
            view.start();
        }
    }

    /**
     * Returns the view component. Eventually wraps it into
     * another component in order to provide additional functionality.
     */
    protected Component wrapViewComponent(View p) {
        JComponent c = p.getComponent();
        if (getModel() != null) {
            LinkedList<Action> toolBarActions = new LinkedList<Action>();

            int id = 0;
            for (JToolBar tb : new ReversedList<JToolBar>(getModel().createToolBars(this, p))) {
                id++;
                JPanel panel = new JPanel(new BorderLayout());
                panel.add(tb, BorderLayout.NORTH);
                panel.add(c, BorderLayout.CENTER);
                c = panel;
                PreferencesUtil.installToolBarPrefsHandler(prefs, "toolbar." + id, tb);
                toolBarActions.addFirst(new ToggleVisibleAction(tb, tb.getName()));
            }
            p.getComponent().putClientProperty("toolBarActions", toolBarActions);
        }
        return c;
    }

    @Override
    public void hide(View p) {
        if (p.isShowing()) {
            if (getActiveView()==p) {
                setActiveView(null);
            }
            p.setShowing(false);
            JFrame f = (JFrame) SwingUtilities.getWindowAncestor(p.getComponent());
            f.setVisible(false);
            f.remove(p.getComponent());
            f.dispose();
        }
    }

    @Override
    public void dispose(View p) {
        super.dispose(p);
        if (views().size() == 0) {
            stop();
        }
    }

    /**
     * Creates a menu bar.
     */
    protected JMenuBar createMenuBar(View v) {
        JMenuBar mb = new JMenuBar();

        // Get menus from application model
        JMenu fileMenu = null;
        JMenu editMenu = null;
        JMenu helpMenu = null;
        JMenu viewMenu = null;
        JMenu windowMenu = null;
        String fileMenuText = labels.getString("file.text");
        String editMenuText = labels.getString("edit.text");
        String viewMenuText = labels.getString("view.text");
        String windowMenuText = labels.getString("window.text");
        String helpMenuText = labels.getString("help.text");
        LinkedList<JMenu> ll = new LinkedList<JMenu>();
        getModel().getMenuBuilder().addOtherMenus(ll, this, v);
        for (JMenu mm : ll) {
            String text = mm.getText();
            if (text == null) {
            } else if (text.equals(fileMenuText)) {
                fileMenu = mm;
                continue;
            } else if (text.equals(editMenuText)) {
                editMenu = mm;
                continue;
            } else if (text.equals(viewMenuText)) {
                viewMenu = mm;
                continue;
            } else if (text.equals(windowMenuText)) {
                windowMenu = mm;
                continue;
            } else if (text.equals(helpMenuText)) {
                helpMenu = mm;
                continue;
            }
            mb.add(mm);
        }

        // Create missing standard menus
        if (fileMenu == null) {
            fileMenu = createFileMenu(v);
        }
        if (editMenu == null) {
            editMenu = createEditMenu(v);
        }
        if (viewMenu == null) {
            viewMenu = createViewMenu(v);
        }
        if (windowMenu == null) {
            windowMenu = createWindowMenu(v);
        }
        if (helpMenu == null) {
            helpMenu = createHelpMenu(v);
        }

        // Insert standard menus into menu bar
        if (fileMenu != null) {
            mb.add(fileMenu, 0);
        }
        if (editMenu != null) {
            mb.add(editMenu, Math.min(1, mb.getComponentCount()));
        }
        if (viewMenu != null) {
            mb.add(viewMenu, Math.min(2, mb.getComponentCount()));
        }
        if (windowMenu != null) {
            mb.add(windowMenu);
        }
        if (helpMenu != null) {
            mb.add(helpMenu);
        }

        return mb;
    }

    @Override
    @Nullable
    public JMenu createFileMenu(View view) {
        JMenu m;

        m = new JMenu();
        labels.configureMenu(m, "file");
        MenuBuilder mb = model.getMenuBuilder();
        mb.addClearFileItems(m, this, view);
        mb.addNewFileItems(m, this, view);
        mb.addNewWindowItems(m, this, view);

        mb.addLoadFileItems(m, this, view);
        mb.addOpenFileItems(m, this, view);

        if (getAction(view, LoadFileAction.ID) != null ||//
                getAction(view, OpenFileAction.ID) != null ||//
                getAction(view, LoadDirectoryAction.ID) != null ||//
                getAction(view, OpenDirectoryAction.ID) != null) {
            m.add(createOpenRecentFileMenu(view));
        }
        maybeAddSeparator(m);

        mb.addSaveFileItems(m, this, view);
        mb.addExportFileItems(m, this, view);
        mb.addPrintFileItems(m, this, view);

        mb.addOtherFileItems(m, this, view);

        maybeAddSeparator(m);
        mb.addCloseFileItems(m, this, view);

        return (m.getItemCount() == 0) ? null : m;
    }

    @Override @Nullable
    public JMenu createEditMenu(View view) {

        JMenu m;
        JMenuItem mi;
        Action a;
        m = new JMenu();
        labels.configureMenu(m, "edit");
        MenuBuilder mb = model.getMenuBuilder();
        mb.addUndoItems(m, this, view);
        maybeAddSeparator(m);
        mb.addClipboardItems(m, this, view);
        maybeAddSeparator(m);
        mb.addSelectionItems(m, this, view);
        maybeAddSeparator(m);
        mb.addFindItems(m, this, view);
        maybeAddSeparator(m);
        mb.addOtherEditItems(m, this, view);
        maybeAddSeparator(m);
        mb.addPreferencesItems(m, this, view);
        removeTrailingSeparators(m);

        return (m.getItemCount() == 0) ? null : m;
    }

    /**
     * Updates the title of a view and displays it in the given frame.
     * 
     * @param view The view.
     * @param f The frame.
     */
    protected void updateViewTitle(View view, JFrame f) {
        URI uri = view.getURI();
        String title;
        if (uri == null) {
            title = labels.getString("unnamedFile");
        } else {
            title = URIUtil.getName(uri);
        }
        if (view.hasUnsavedChanges()) {
            title += "*";
        }
        view.setTitle(labels.getFormatted("frame.title", title, getName(), view.getMultipleOpenId()));
        f.setTitle(view.getTitle());
    }

    @Override
    public boolean isSharingToolsAmongViews() {
        return false;
    }

    @Override
    public Component getComponent() {
        View p = getActiveView();
        return (p == null) ? null : p.getComponent();
    }

    @Override
    @Nullable
    public JMenu createWindowMenu(final View view) {
        JMenu m = new JMenu();
        labels.configureMenu(m, "window");

        MenuBuilder mb = model.getMenuBuilder();
        mb.addOtherWindowItems(m, this, view);

        return (m.getItemCount() > 0) ? m : null;
    }


    /**
     * Creates the view menu.
     * 
     * @param view The View
     * @return A JMenu or null, if the menu doesn't have any items.
     */
    @SuppressWarnings("unchecked")
    @Override
    public JMenu createViewMenu(final View view) {
        Object object = view.getComponent().getClientProperty("toolBarActions");
        LinkedList<Action> viewActions = (LinkedList<Action>) object;

        JMenu m, m2;
        JMenuItem mi;
        JCheckBoxMenuItem cbmi;

        m = new JMenu();
        labels.configureMenu(m, "view");
        if (viewActions != null && viewActions.size() > 0) {
            m2 = (viewActions.size() == 1) ? m : new JMenu(labels.getString("toolBars"));
            for (Action a : viewActions) {
                cbmi = new JCheckBoxMenuItem(a);
                ActionUtil.configureJCheckBoxMenuItem(cbmi, a);
                m2.add(cbmi);
            }
            if (m2 != m) {
                m.add(m2);
            }
        }

        MenuBuilder mb = model.getMenuBuilder();
        mb.addOtherViewItems(m, this, view);

        return (m.getItemCount() > 0) ? m : null;
    }

    @Override
    public JMenu createHelpMenu(View p) {
        JMenu m;
        JMenuItem mi;

        m = new JMenu();
        labels.configureMenu(m, "help");
        m.add(getAction(p, AboutAction.ID));

        return m;
    }

    protected ActionMap createModelActionMap(ApplicationModel mo) {
        ActionMap rootMap = new ActionMap();
        rootMap.put(AboutAction.ID, new AboutAction(this));
        rootMap.put(ClearRecentFilesMenuAction.ID, new ClearRecentFilesMenuAction(this));

        ActionMap moMap = mo.createActionMap(this, null);
        moMap.setParent(rootMap);
        return moMap;
    }

    @Override
    protected ActionMap createViewActionMap(View v) {
        ActionMap intermediateMap = new ActionMap();
        intermediateMap.put(CloseFileAction.ID, new CloseFileAction(this, v));

        ActionMap vMap = model.createActionMap(this, v);
        vMap.setParent(intermediateMap);
        intermediateMap.setParent(getActionMap(null));
        return vMap;
    }
}
