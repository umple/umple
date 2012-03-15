<?php

class ClassLevelImmutabilityTest extends UnitTestCase
{

  public function test_noSettersOrDeleteForAssociationsAndAttributesOfImmutableClass()
  {
    $widgetC = new WidgetC("Mutable Widget");
    $this->assertEqual(true,$this->objectClassHasSetters($widgetC));
    $associated = new WidgetImmutableB();

    $widget = new WidgetImmutableA("Big Widget", $associated);
    $this->assertEqual(false,$this->objectClassHasSetters($widget));
    $this->assertEqual($widget->getName(), "Big Widget");
    $this->assertEqual($widget->getWidgetImmutableB(), $associated);

    $widget->delete();
    $this->assertEqual($widget->getName(), "Big Widget");
    $this->assertEqual($widget->getWidgetImmutableB(), $associated);
  }

  
  public function test_noSettersOrDeleteForAssociationsAndAttributesOfSubclassOfImmutableClass()
  {
    $associated = new WidgetImmutableB();

    $widget = new WidgetSubclass("Little Widget", $associated, "myType");
    $this->assertEqual(false,$this->objectClassHasSetters($widget));
    $this->assertEqual($widget->getName(), "Little Widget");
    $this->assertEqual($widget->getType(), "myType");
    $this->assertEqual($widget->getWidgetImmutableB(), $associated);

    $widget->delete();
    $this->assertEqual($widget->getName(), "Little Widget");
    $this->assertEqual($widget->getType(), "myType");
    $this->assertEqual($widget->getWidgetImmutableB(), $associated);
  }
  

  private function objectClassHasSetters($obj)
  {
    $hasSetters = false;

    $clazz = new ReflectionClass(get_class($obj));
    $methods = $clazz->getMethods();

    foreach ($methods as $m)
    {
      if ((preg_match('/^set[A-Z]+[a-zA-Z]*$/', $m->getName()) > 0) && $m->isPublic())
      {
        $hasSetters = true;
        break;
      }
    }
    return $hasSetters;
  }
}
