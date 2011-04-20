package cruise.umple.ui.eclipse;

import org.junit.*;

import cruise.umple.ui.eclipse.Activator;
import cruise.umple.ui.eclipse.UmplePreferencePage;

// to get it to run, be sure to set
// -Djava.library.path=C:\tp\cruise\dev\cruise.umple\lib
public class UmplePreferencePageTest extends SwtTest
{

  private UmplePreferencePage preferencePage;

  @Before
  public void setUp() throws Exception
  {
    super.setUp();
    Activator.loadDefaultAsRequired();
    preferencePage = new UmplePreferencePage();
  }

  @Test
  public void Initialize()
  {
    preferencePage.createContents(parent);
    Assert.assertEquals("Umple File:", preferencePage.labelUmpleFile.getText());
    Assert.assertEquals("", preferencePage.labelStatusTitle.getText());
    Assert.assertEquals("Your umple is configured properly", preferencePage.labelStatus.getText());
  }

  @Test
  public void LoadDefaults()
  {
    Activator.getDefault().getPreferences().setDefault("repository_file", "x");
    preferencePage.createContents(parent);
    Assert.assertEquals("x", preferencePage.inputUmpleFile.getText());

    Activator.getDefault().getPreferences().setValue("repository_file", "y");
    preferencePage.createContents(parent);
    Assert.assertEquals("y", preferencePage.inputUmpleFile.getText());
  }

  @Test
  public void performDefaults()
  {
    Activator.getDefault().getPreferences().setDefault("repository_file", "temp.xml");
    Activator.getDefault().getPreferences().setDefault("user", "aforward");

    preferencePage.createContents(parent);
    preferencePage.inputUmpleFile.setText("nottemp.xml");
    preferencePage.labelStatus.setText("p");
    preferencePage.performDefaults();
    Assert.assertEquals("temp.xml", preferencePage.inputUmpleFile.getText());
    Assert.assertEquals("Your umple is configured properly", preferencePage.labelStatus.getText());
  }

  @Test
  public void performOk()
  {
    preferencePage.createContents(parent);
    preferencePage.inputUmpleFile.setText("y");
    preferencePage.labelStatus.setText("p");
    preferencePage.performOk();
    // Assert.assertEquals("y",
    // Activator.getDefault().getPreferences().getString("repository_file"));
    Assert.assertEquals("Your umple is configured properly", preferencePage.labelStatus.getText());
  }

}
