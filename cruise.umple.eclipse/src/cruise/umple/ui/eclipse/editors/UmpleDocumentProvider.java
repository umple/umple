package cruise.umple.ui.eclipse.editors;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

public class UmpleDocumentProvider extends FileDocumentProvider
{

	protected IDocument createDocument(Object element) throws CoreException
	{
		IDocument document = super.createDocument(element);
		if (document != null)
		{
			IDocumentPartitioner partitioner = new FastPartitioner(new UmplePartitionScanner(), new String[] {
					UmplePartitionScanner.Umple_TAG, UmplePartitionScanner.Umple_COMMENT });
			partitioner.connect(document);
			document.setDocumentPartitioner(partitioner);
		}
		return document;
	}
}