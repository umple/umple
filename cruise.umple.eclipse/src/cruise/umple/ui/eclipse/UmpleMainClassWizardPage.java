package cruise.umple.ui.eclipse;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class UmpleMainClassWizardPage extends WizardPage implements IWizardPage, Listener, ModifyListener {
	private Text containerText;
	private UmpleMainClassWizard parent;
	private Text fileText;
	private  String[] possibilities;
    private Combo seatCombo;	
	
	public UmpleMainClassWizardPage(UmpleMainClassWizard parent, String[] possibilities) {
		super("wizardPage");

		setTitle("UMPLE main class selector");
		setDescription("This wizard is for selecting the appropiate main class to run.");
		this.parent = parent;
		this.possibilities = possibilities;
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		layout.verticalSpacing = 9;
		
		new Label (container, SWT.NONE).setText("Main class:");
		seatCombo = new Combo(container, SWT.BORDER | SWT.READ_ONLY);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		seatCombo.setLayoutData(gd);
		seatCombo.setItems(possibilities);
		seatCombo.setText(possibilities[0]);
		seatCombo.addListener(SWT.Selection, this);	
		this.parent.setClassName(possibilities[0]);
		
		Label label = new Label(container, SWT.NULL);
		label.setText("&Arguments:");

		containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
		containerText.setLayoutData(gd);
		containerText.addModifyListener(this);
		setControl(container);
	}

	@Override
	public void handleEvent(Event arg0) {
      parent.setClassName(((Combo)arg0.widget).getText());
	}

	@Override
	public void modifyText(ModifyEvent e) {
	  parent.setArguments(((Text)e.widget).getText());
	}

}
