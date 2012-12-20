package cruise.umple.ui.eclipse;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

  //```````````````````````
  // STATIC VARIABLES
  //```````````````````````
  
  public static final String PLUGIN_ID = "UMPLE";
  private static Activator plugin;

  //```````````````````````
  // MEMBER VARIABLES
  //```````````````````````
  
  private PreferenceFacade _preferences; 

  //```````````````````````
  // CONSTRUCTOR VARIABLES
  //```````````````````````

  public Activator() {
    init();
  }

  private void init()
  {
    plugin = this;
    _preferences = null;
  }

  //```````````````````````
  // INTERFACE
  //```````````````````````
  
  public void start(BundleContext context) throws Exception {
    super.start(context);
  }

  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }

  public static Activator getDefault() {
    return plugin;
  }
  
  public static void loadDefaultAsRequired()
  {
    if (plugin == null)
    {
      plugin = new Activator();
    }
  }
  
  public static void resetDefault()
  {
    plugin.init();
  }
  
  public static ImageDescriptor getImageDescriptor(String path) {
    return imageDescriptorFromPlugin(PLUGIN_ID, path);
  }
  
  protected void initializeDefaultPreferences(IPreferenceStore store) {
    store.setDefault(UmplePreferencePage.REPOSITORY_FILE_PREFERENCE,UmplePreferencePage.DEFAULT_REPOSITORY_FILE_PREFERENCE);
  }
  
  public PreferenceFacade getPreferences()
  {
    if (_preferences == null)
    {
      _preferences = new PreferenceFacade(this);
    }
    return _preferences;
  }
  
  public void getOff(){}
  
}
