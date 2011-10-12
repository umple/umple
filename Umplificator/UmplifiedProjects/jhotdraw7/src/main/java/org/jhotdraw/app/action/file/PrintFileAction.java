/*
 * @(#)PrintFileAction.java
 *
 * Copyright (c) 1996-2010 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the 
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */
package org.jhotdraw.app.action.file;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;
import javax.swing.*;
import org.jhotdraw.app.*;
import org.jhotdraw.app.action.AbstractViewAction;
import org.jhotdraw.gui.*;
import org.jhotdraw.util.*;

/**
 * Presents a printer chooser to the user and then prints the
 * {@link org.jhotdraw.app.View}.
 * <p>
 * This action requires that the view implements the {@link PrintableView}
 * interface.
 * <p>
 * This action is called when the user selects the Print item in the File
 * menu. The menu item is automatically created by the application.
 * <p>
 * If you want this behavior in your application, you have to create it
 * and put it in your {@code ApplicationModel} in method
 * {@link org.jhotdraw.app.ApplicationModel#initApplication}.
 * <p>
 * You should also create a {@link PrintFileAction} when you create this action.
 * <hr>
 * <b>Design Patterns</b>
 *
 * <p><em>Framework</em><br>
 * The interfaces and classes listed below define together the contracts
 * of a smaller framework inside of the JHotDraw framework for document oriented
 * applications.<br>
 * Contract: {@link PrintableView}.<br>
 * Client: {@link org.jhotdraw.app.action.file.PrintFileAction}.
 * <hr>
 *
 * @author Werner Randelshofer
 * @version $Id: PrintFileAction.java 717 2010-11-21 12:30:57Z rawcoder $
 */
public class PrintFileAction extends AbstractViewAction {

    public final static String ID = "file.print";

    /** Creates a new instance. */
    public PrintFileAction(Application app, @Nullable View view) {
        super(app, view);
        ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
        labels.configureAction(this, ID);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        PrintableView view = (PrintableView)getActiveView();
        view.setEnabled(false);
        if (System.getProperty("apple.awt.graphics.UseQuartz", "false").equals("true")) {
            printQuartz(view);
        } else {
            printJava2D(view);
        }
        view.setEnabled(true);
    }
    /*
     * This prints at 72 DPI only. We might need this for some JVM versions on
     * Mac OS X.*/

    public void printJava2D(PrintableView v) {
        Pageable pageable = v.createPageable();
        if (pageable == null) {
            throw new InternalError("View does not have a method named java.awt.Pageable createPageable()");
        }

        try {
            PrinterJob job = PrinterJob.getPrinterJob();
            // FIXME - PrintRequestAttributeSet should be retrieved from View
            PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
            attr.add(new PrinterResolution(300, 300, PrinterResolution.DPI));
            job.setPageable(pageable);
            if (job.printDialog()) {
                try {
                    job.print();
                } catch (PrinterException e) {
                    String message = (e.getMessage() == null) ? e.toString() : e.getMessage();
                    View view = getActiveView();
                    ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
                    JSheet.showMessageSheet(view.getComponent(),
                            "<html>" + UIManager.getString("OptionPane.css") +
                            "<b>" + labels.getString("couldntPrint") + "</b><br>" +
                            ((message == null) ? "" : message));
                }
            } else {
                System.out.println("JOB ABORTED!");
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
    /*
     * This prints at 72 DPI only. We might need this for some JVM versions on
     * Mac OS X.*/

    public void printJava2DAlternative(PrintableView v) {
        Pageable pageable = v.createPageable();
        if (pageable == null) {
            throw new InternalError("View does not have a method named java.awt.Pageable createPageable()");
        }

        try {
            final PrinterJob job = PrinterJob.getPrinterJob();
            PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
            attr.add(new PrinterResolution(300, 300, PrinterResolution.DPI));
            job.setPageable(pageable);
            if (job.printDialog(attr)) {
                try {
                    job.print();
                } catch (PrinterException e) {
                    ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.app.Labels");
                    JSheet.showMessageSheet(getActiveView().getComponent(),
                            labels.getFormatted("couldntPrint", e));
                }
            } else {
                System.out.println("JOB ABORTED!");
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    /**
     * On Mac OS X with the Quartz rendering engine, the following code achieves
     * the best results.
     */
    public void printQuartz(PrintableView v) {
        Frame frame = (Frame) SwingUtilities.getWindowAncestor(v.getComponent());
        final Pageable pageable = v.createPageable();
        final double resolution = 300d;
        JobAttributes jobAttr = new JobAttributes();
        // FIXME - PageAttributes should be retrieved from View
        PageAttributes pageAttr = new PageAttributes();
        pageAttr.setMedia(PageAttributes.MediaType.A4);
        pageAttr.setPrinterResolution((int) resolution);
        final PrintJob pj = frame.getToolkit().getPrintJob(
                frame,
                "Job Title",
                jobAttr,
                pageAttr);

        getActiveView().setEnabled(false);
        new Worker() {

            @Override
            protected Object construct() throws PrinterException {

                // Compute page format from settings of the print job
                Paper paper = new Paper();
                paper.setSize(
                        pj.getPageDimension().width / resolution * 72d,
                        pj.getPageDimension().height / resolution * 72d);
                paper.setImageableArea(64d, 32d, paper.getWidth() - 96d, paper.getHeight() - 64);
                PageFormat pageFormat = new PageFormat();
                pageFormat.setPaper(paper);

                // Print the job
                try {
                    for (int i = 0,  n = pageable.getNumberOfPages(); i < n; i++) {
                        PageFormat pf = pageable.getPageFormat(i);
                        pf = pageFormat;
                        Graphics g = pj.getGraphics();
                        if (g instanceof Graphics2D) {
                            pageable.getPrintable(i).print(g, pf, i);
                        } else {
                            BufferedImage buf = new BufferedImage(
                                    (int) (pf.getImageableWidth() * resolution / 72d),
                                    (int) (pf.getImageableHeight() * resolution / 72d),
                                    BufferedImage.TYPE_INT_RGB);
                            Graphics2D bufG = buf.createGraphics();


                            bufG.setBackground(Color.WHITE);
                            bufG.fillRect(0, 0, buf.getWidth(), buf.getHeight());
                            bufG.scale(resolution / 72d, resolution / 72d);
                            bufG.translate(-pf.getImageableX(), -pf.getImageableY());
                            pageable.getPrintable(i).print(bufG, pf, i);
                            bufG.dispose();
                            g.drawImage(buf,
                                    (int) (pf.getImageableX() * resolution / 72d),
                                    (int) (pf.getImageableY() * resolution / 72d),
                                    null);
                            buf.flush();
                        }
                        g.dispose();
                    }
                } finally {
                    pj.end();
                }
                return null;
            }

            @Override
            protected void failed(Throwable error) {
               error.printStackTrace();
            }
            @Override
            protected void finished() {
                getActiveView().setEnabled(true);
            }
        }.start();
    }
    /**
     * Returns true if the action is enabled.
     * The enabled state of the action depends on the state that has been set
     * using setEnabled() and on the enabled state of the application.
     *
     * @return true if the action is enabled, false otherwise
     * @see Action#isEnabled
     */
    @Override public boolean isEnabled() {
        return super.isEnabled() && (getActiveView() instanceof PrintableView);
    }
}
