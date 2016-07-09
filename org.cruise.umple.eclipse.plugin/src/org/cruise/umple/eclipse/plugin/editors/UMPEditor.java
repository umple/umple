package org.cruise.umple.eclipse.plugin.editors;

import org.eclipse.jface.action.IAction;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.ContentAssistAction;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;

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
	
	@Override
	protected void createActions() {	
		super.createActions();
//		IAction action = new ContentAssistAction(new UmpResourceBoundle(), "ContentAssistProposal.", this); 
//		String id = ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS;
//		action.setActionDefinitionId(id);
//		setAction("ContentAssistProposal", action); 
//		markAsStateDependentAction("ContentAssistProposal", true);
	}
}
