package org.cruise.umple.eclipse.plugin.editors;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;

public class TextHover implements ITextHover {

	@Override
	public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		try {
            IDocument doc = textViewer.getDocument();
            return "Hello! I am a hover at offset "+hoverRegion.getOffset();
         }
         catch (Exception e) {            
            return ""; 
         }
	}

	@Override
	public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		return new Region (offset,0);
	}

}
