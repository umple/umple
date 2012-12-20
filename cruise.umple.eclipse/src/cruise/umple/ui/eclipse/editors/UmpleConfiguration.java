package cruise.umple.ui.eclipse.editors;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class UmpleConfiguration extends SourceViewerConfiguration {
	private UmpleDoubleClickStrategy doubleClickStrategy;
	private UmpleTagScanner tagScanner;
	private UmpleScanner scanner;
	private ColorManager colorManager;

	public UmpleConfiguration(ColorManager colorManager) {
		this.colorManager = colorManager;
	}
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return new String[] {
			IDocument.DEFAULT_CONTENT_TYPE,
			UmplePartitionScanner.Umple_COMMENT,
			UmplePartitionScanner.Umple_TAG };
	}
	public ITextDoubleClickStrategy getDoubleClickStrategy(
		ISourceViewer sourceViewer,
		String contentType) {
		if (doubleClickStrategy == null)
			doubleClickStrategy = new UmpleDoubleClickStrategy();
		return doubleClickStrategy;
	}

	protected UmpleScanner getUmpleScanner() {
		if (scanner == null) {
			scanner = new UmpleScanner(colorManager);
			scanner.setDefaultReturnToken(
				new Token(
					new TextAttribute(
						colorManager.getColor(IUmpleColorConstants.DEFAULT))));
		}
		return scanner;
	}
	protected UmpleTagScanner getUmpleTagScanner() {
		if (tagScanner == null) {
			tagScanner = new UmpleTagScanner(colorManager);
			tagScanner.setDefaultReturnToken(
				new Token(
					new TextAttribute(
						colorManager.getColor(IUmpleColorConstants.TAG))));
		}
		return tagScanner;
	}

	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		DefaultDamagerRepairer dr =
			new DefaultDamagerRepairer(getUmpleTagScanner());
		reconciler.setDamager(dr, UmplePartitionScanner.Umple_TAG);
		reconciler.setRepairer(dr, UmplePartitionScanner.Umple_TAG);

		dr = new DefaultDamagerRepairer(getUmpleScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		return reconciler;
	}

}