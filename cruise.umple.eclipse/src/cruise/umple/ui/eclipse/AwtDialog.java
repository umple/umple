package cruise.umple.ui.eclipse;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;

import javax.swing.JOptionPane;

public class AwtDialog implements Dialog
{

  //`````````````````````
  // MEMBER VARIABLES
  //`````````````````````   
  
  private Frame _frame;

  //`````````````````````
  // CONSTRUCTOR
  //`````````````````````   
  
  public AwtDialog(Frame aFrame)
  {
    _frame = aFrame;
  }
  
  //`````````````````````
  // INTERFACE
  //`````````````````````   
  
  public File saveDialog()
  {
    FileDialog saveDialog = new FileDialog(_frame,"Save",FileDialog.SAVE);
    saveDialog.setVisible(true);

    String filename = saveDialog.getFile();
    String directory = saveDialog.getDirectory();
    
    if (filename == null)
    {
      return null;
    }
    return new File(directory,filename);    
  }
  
  public File openDialog()
  {
    FileDialog openDialog = new FileDialog(_frame,"Open",FileDialog.LOAD);
    openDialog.setVisible(true);
    
    String filename = openDialog.getFile();
    String directory = openDialog.getDirectory();
    
    if (filename == null)
    {
      return null;
    }
    else
    {
      return new File(directory,filename);
    }
  }
  
  public void messageDialog(String message)
  {
    JOptionPane.showMessageDialog(null, message);    
  }

}
