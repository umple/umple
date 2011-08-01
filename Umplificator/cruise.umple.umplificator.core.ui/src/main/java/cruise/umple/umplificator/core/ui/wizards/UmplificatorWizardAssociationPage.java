package cruise.umple.umplificator.core.ui.wizards;

import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;


public class UmplificatorWizardAssociationPage extends UmplificatorWizardPage {

	private Text attributeText;
	private Text classText;
	private Label classLabel;

	/**
	 * Constructor for CreateAdapterWizardPage.
	 * 
	 * @param pageName
	 */
	public UmplificatorWizardAssociationPage(ISelection selection) {
		super(selection, "Association Refactoring");
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {

		Label label;

		Composite container = new Composite(parent, SWT.NULL);

		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		container.setLayout(layout);   

		GridData gd = new GridData();
		gd.widthHint = 420;
		container.setLayoutData(gd);


		this.classLabel = new Label(container, SWT.WRAP ); 
		classLabel.setText("Class X");
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		gd.widthHint = 420;
		this.classLabel.setLayoutData(gd);

		label = new Label(container, SWT.NULL);
		label.setText("Associations:");
		this.classText = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		this.classText.setLayoutData(gd);
		this.classText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				UmplificatorWizardAssociationPage.this.dialogChanged();
			}
		});        

		setPageComplete(true);
		this.setControl(container);
	}

	/**
	 * Ensures that both text fields are set.
	 */

	protected void dialogChanged() {



	}



}