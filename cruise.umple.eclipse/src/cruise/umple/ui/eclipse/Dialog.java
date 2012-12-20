package cruise.umple.ui.eclipse;

import java.io.File;

public interface Dialog
{
  public File openDialog();
  public File saveDialog();
  public void messageDialog(String message);
}
