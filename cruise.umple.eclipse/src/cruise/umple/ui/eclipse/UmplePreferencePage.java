package cruise.umple.ui.eclipse;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import cruise.umple.util.Language;

public class UmplePreferencePage extends PreferencePage implements IWorkbenchPreferencePage 
{

  //```````````````````````
  // STATIC VARIABLES
  //```````````````````````
  
  public static final String REPOSITORY_FILE_PREFERENCE = "repository_file";
  public static final String USER_PREFERENCE = "user";
  
  public static final String DEFAULT_REPOSITORY_FILE_PREFERENCE = ".\\Project.ump";
    
  //```````````````````````
  // MEMBER VARIABLES
  //```````````````````````
  
  public Label labelUmpleFile;
  public Text inputUmpleFile;

  public Label labelStatusTitle;
  public Label labelStatus;

  
	protected Control createContents(Composite parent) 
  {
    
    Composite preference = createPreferenceComposite(parent);
    
    labelUmpleFile = createLabel(preference,Language.getInstance().lookup("Umple File:"));
    inputUmpleFile = new Text(preference,SWT.LEFT | SWT.SINGLE | SWT.BORDER);
    
    labelStatusTitle = createLabel(preference,"");
    labelStatus = new Label(preference,SWT.LEFT | SWT.WRAP );
    
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
    inputUmpleFile.setLayoutData(data);

    data = new GridData(GridData.FILL_VERTICAL);
    labelStatus.setLayoutData(data);

    
    initialPreferences();
    return preference;
	}

	/*
	 * @see IWorkbenchPreferencePage#init(IWorkbench)
	 */
	public void init(IWorkbench workbench) {
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
	}

	protected void performDefaults() {
		inputUmpleFile.setText(Activator.getDefault().getPreferences().getDefault(REPOSITORY_FILE_PREFERENCE));
    updateStatus();
	}

	public boolean performOk() 
  {
    Activator.getDefault().getPreferences().setValue(REPOSITORY_FILE_PREFERENCE,inputUmpleFile.getText());
    updateStatus();
    return super.performOk();
	}

  public void initialPreferences()
  {
    inputUmpleFile.setText(Activator.getDefault().getPreferences().getString(REPOSITORY_FILE_PREFERENCE));
    updateStatus();
  }

  //```````````````````````
  // PRIVATE METHODS
  //```````````````````````
  
  private Composite createPreferenceComposite(Composite parent)
  {
    Composite preference = new Composite(parent, SWT.NULL);

    GridData data = new GridData(GridData.FILL_HORIZONTAL);
    data.grabExcessHorizontalSpace = true;
    preference.setLayoutData(data);
    
    GridLayout layout = new GridLayout();
    layout.numColumns = 2;
    preference.setLayout(layout);     
    
    return preference;
  }
  
  private Label createLabel(Composite parent, String text)
  {
    Label label = new Label(parent,SWT.RIGHT | SWT.TOP);
    label.setText(text);
    return label;
  }
  
  private void updateStatus()
  {
    labelStatus.setText(Language.getInstance().lookup("Your umple is configured properly"));
  }

}