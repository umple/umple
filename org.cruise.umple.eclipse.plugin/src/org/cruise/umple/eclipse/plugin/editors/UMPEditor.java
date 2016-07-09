package org.cruise.umple.eclipse.plugin.editors;

import org.eclipse.ui.editors.text.TextEditor;


public class UMPEditor extends TextEditor {

	private ColorManager colorManager;

	public UMPEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new UMPConfiguration(colorManager));
	}
	@Override
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}
}
