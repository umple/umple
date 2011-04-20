package cruise.umple.ui.eclipse;

import junit.framework.Assert;

import org.junit.Test;

import cruise.umple.ui.eclipse.PreferenceFacade;

public class PreferenceFacadeTest {

  @Test
  public void NullSetGet()
  {
    
    PreferenceFacade facade = new PreferenceFacade(null);
    Assert.assertEquals("", facade.getString("a"));

    facade.setDefault("a","1");
    Assert.assertEquals("1", facade.getString("a"));
    
    facade.setValue("a","2");
    Assert.assertEquals("2", facade.getString("a"));
    
  }
  
  @Test
  public void Default()
  {
    PreferenceFacade facade = new PreferenceFacade(null);
    Assert.assertEquals("", facade.getDefault("a"));

    facade.setDefault("a","1");
    Assert.assertEquals("1", facade.getDefault("a"));
  }
  
}
