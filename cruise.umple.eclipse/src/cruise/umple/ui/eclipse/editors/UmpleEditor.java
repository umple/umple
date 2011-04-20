package cruise.umple.ui.eclipse.editors;

import org.eclipse.ui.editors.text.TextEditor;

public class UmpleEditor extends TextEditor {

  private ColorManager colorManager;
  
	public UmpleEditor() {
		super();
    colorManager = new ColorManager();
    setSourceViewerConfiguration(new UmpleConfiguration(colorManager));
    setDocumentProvider(new UmpleDocumentProvider());
	}
	public void dispose() {
		super.dispose();
	}

}
