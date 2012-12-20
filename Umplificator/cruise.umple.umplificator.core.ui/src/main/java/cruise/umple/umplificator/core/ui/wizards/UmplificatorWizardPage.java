package cruise.umple.umplificator.core.ui.wizards;

import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;


abstract public class UmplificatorWizardPage extends WizardPage {


    /**
     * Constructor for UmplificatorWizardPage.
     * 
     * @param pageName
     */
    public UmplificatorWizardPage(ISelection selection, String pageTitle) {
        super("UmplificatorWizardPage");
        this.setTitle(pageTitle);

    }
    
    /**
     * @see IDialogPage#createControl(Composite)
     */
    abstract public void createControl(Composite parent);

    /**
     * Ensures that both text fields are set.
     */

    protected void dialogChanged() {
        this.updateStatus(null);
    }
    
    
    protected void updateStatus(String message) {
        this.setErrorMessage(message);
        this.setPageComplete(message == null);
    }
}