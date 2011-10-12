/*
 * @(#)NumberedParagraphView.java
 *
 * Copyright (c) 2005 by the original authors of JHotDraw and all its
 * contributors. All rights reserved.
 *
 * You may not use, copy or modify this file, except in compliance with the
 * license agreement you entered into with the copyright holders. For details
 * see accompanying license terms.
 */

package org.jhotdraw.samples.teddy.text;

import java.awt.*;
import javax.swing.text.*;
/**
 * NumberedParagraphView.
 *
 * @author Werner Randelshofer
 * @version $Id: NumberedParagraphView.java 723 2010-12-28 14:31:24Z rawcoder $
 */
public class NumberedParagraphView extends ParagraphView {
    public final static short NUMBERS_WIDTH=30;
    private static Font numberFont = new Font("Dialog",Font.PLAIN,10);
    private NumberedViewFactory viewFactory;
    public NumberedParagraphView(Element e, NumberedViewFactory viewFactory) {
        super(e);
        this.viewFactory = viewFactory;
    }
    
    
    
    /**
     * Gets the left inset.
     *
     * @return the inset >= 0
     */
    @Override
    protected short getLeftInset() {
        short left = super.getLeftInset();
        return (viewFactory.isLineNumbersVisible()) ? (short) (left + NUMBERS_WIDTH) : left;
    }
    
    
    @Override
    public void paintChild(Graphics g, Rectangle r, int n) {
        super.paintChild(g, r, n);
        if (viewFactory.isLineNumbersVisible()) {
            if (n == 0) {
                g.setColor(Color.gray);
                int lineAscent = g.getFontMetrics().getAscent();
                g.setFont(numberFont);
                //int numberAscent = g.getFontMetrics().getAscent();
                int lineNumber = getDocument().
                        getDefaultRootElement().
                        getElementIndex(getStartOffset());
                
                int numberX = r.x - getLeftInset();
                //int numberY = r.y + g.getFontMetrics().getAscent();
                int numberY = r.y + lineAscent;
                g.drawString(Integer.toString(lineNumber + 1),
                        numberX, numberY);
            }
        }
    }
}
