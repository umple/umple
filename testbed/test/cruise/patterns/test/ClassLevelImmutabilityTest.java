package cruise.patterns.test;

import org.junit.*;
import java.lang.reflect.*;
import java.io.Console;

public class ClassLevelImmutabilityTest
{
  @Test
  public void noSettersOrDeleteForAssociationsAndAttributesOfImmutableClass()
  {
    WidgetC widgetC = new WidgetC("Mutable Widget");
    Assert.assertTrue(objectClassHasSetters(widgetC));

    WidgetImmutableB associated = new WidgetImmutableB();

    WidgetImmutableA widget = new WidgetImmutableA("Big Widget", associated);
    Assert.assertFalse(objectClassHasSetters(widget));
    Assert.assertEquals(widget.getName(), "Big Widget");
    Assert.assertEquals(widget.getWidgetImmutableB(), associated);

    widget.delete();
    Assert.assertEquals(widget.getName(), "Big Widget");
    Assert.assertEquals(widget.getWidgetImmutableB(), associated);
  }
  
  @Test
  public void noSettersOrDeleteForAssociationsAndAttributesOfSubclassOfImmutableClass()
  {
    WidgetImmutableB associated = new WidgetImmutableB();

    WidgetSubclass widget = new WidgetSubclass("Little Widget", associated, "myType");
    Assert.assertFalse(objectClassHasSetters(widget));
    Assert.assertEquals(widget.getName(), "Little Widget");
    Assert.assertEquals(widget.getType(), "myType");
    Assert.assertEquals(widget.getWidgetImmutableB(), associated);

    widget.delete();
    Assert.assertEquals(widget.getName(), "Little Widget");
    Assert.assertEquals(widget.getType(), "myType");
    Assert.assertEquals(widget.getWidgetImmutableB(), associated);
  }

  private boolean objectClassHasSetters(Object obj)
  {
    boolean hasSetters = false;

    Class<? extends Object> clazz = obj.getClass();
    Method[] methods = clazz.getMethods();
    String setterNameRegex = "set[A-Z]+[a-zA-Z]*";

    for (Method m : methods)
    {
      if (m.getName().matches(setterNameRegex))
      {
        hasSetters = true;
        break;
      }
    }
    return hasSetters;
  }
}

