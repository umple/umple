package org.cruise.umple.eclipse.plugin.editors;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class UMPConfiguration extends SourceViewerConfiguration {
	private UMPDoubleClickStrategy doubleClickStrategy;
	private UMPScanner scanner;
	private ColorManager colorManager;

	public UMPConfiguration(ColorManager colorManager) {
		this.colorManager = colorManager;
	}

	@Override
	public ITextDoubleClickStrategy getDoubleClickStrategy(
		ISourceViewer sourceViewer,
		String contentType) {
		if (doubleClickStrategy == null)
			doubleClickStrategy = new UMPDoubleClickStrategy();
		return doubleClickStrategy;
	}

	protected UMPScanner getXMLScanner() {
		if (scanner == null) {
			scanner = new UMPScanner(colorManager);
			scanner.setDefaultReturnToken(
				new Token(
					new TextAttribute(
						colorManager.getColor(IUMPColorConstants.DEFAULT))));
		}
		return scanner;
	}
	
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getXMLScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		return reconciler;
	}

	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {
		ContentAssistant ca = new ContentAssistant();
        IContentAssistProcessor cap = new CompletionProcessor();
        ca.setContentAssistProcessor(cap, IDocument.DEFAULT_CONTENT_TYPE);
        ca.enableAutoActivation(true);
        ca.setAutoActivationDelay(500);
        ca.setProposalPopupOrientation(IContentAssistant.CONTEXT_INFO_BELOW);
        ca.setInformationControlCreator(getInformationControlCreator(sourceViewer));
        return ca;
	}
	
	@Override
	public ITextHover getTextHover(ISourceViewer sourceViewer, String contentType) {
		return new TextHover();
	}

}