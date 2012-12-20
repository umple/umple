package cruise.umple.ui.eclipse;

import java.util.Hashtable;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class PreferenceFacade
{

  // ```````````````````````
  // MEMBER VARIABLES
  // ```````````````````````

  private IPreferenceStore _preferences;
  private Hashtable<String, String> _allPreferences;
  private Hashtable<String, String> _defaultPreferences;

  // ```````````````````````
  // CONSTRUCTOR
  // ```````````````````````

  public PreferenceFacade(AbstractUIPlugin activator)
  {
    init(activator);
  }

  private void init(AbstractUIPlugin activator)
  {

    if (activator != null && activator.getBundle() != null)
    {
      _preferences = activator.getPreferenceStore();
    }
    else
    {
      _preferences = null;
    }

    _allPreferences = new Hashtable<String, String>();
    _defaultPreferences = new Hashtable<String, String>();
  }

  // ```````````````````````
  // INTERFACE
  // ```````````````````````

  public String getString(String id)
  {

    if (_preferences != null)
    {
      return _preferences.getString(id);
    }
    else if (_allPreferences.containsKey(id))
    {
      return (String) _allPreferences.get(id);
    }
    else
    {
      return getDefault(id);
    }
  }

  public void setValue(String id, String value)
  {
    if (_preferences != null)
    {
      _preferences.setValue(id, value);
    }
    else
    {
      _allPreferences.put(id, value);
    }
  }

  public void setDefault(String id, String defaultValue)
  {
    if (_preferences != null)
    {
      _preferences.setDefault(id, defaultValue);
    }
    else
    {
      _defaultPreferences.put(id, defaultValue);
    }
  }

  public String getDefault(String id)
  {
    if (_preferences != null)
    {
      return _preferences.getDefaultString(id);
    }
    else if (_defaultPreferences.containsKey(id))
    {
      return (String) _defaultPreferences.get(id);
    }
    else
    {
      return "";
    }
  }

}
