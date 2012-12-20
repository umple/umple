<?php

class ClassLevelImmutabilityTest extends UnitTestCase
{

  public function test_noDeleteForAssociationsAndAttributesOfImmutableClass()
  {
    $associated = new WidgetImmutableB("name");

    $widget = new WidgetImmutableA("Big Widget", $associated);
    $this->assertEqual($widget->getName(), "Big Widget");
    $this->assertEqual($widget->getWidgetImmutableB(), $associated);

    $widget->delete();
    $this->assertEqual($widget->getName(), "Big Widget");
    $this->assertEqual($widget->getWidgetImmutableB(), $associated);
  }

  
  public function test_noDeleteForAssociationsAndAttributesOfSubclassOfImmutableClass()
  {
    $associated = new WidgetImmutableB("name");

    $widget = new WidgetSubclass("Little Widget", "myType", array($associated));
    $this->assertEqual($widget->getName(), "Little Widget");
    $this->assertEqual($widget->getType(), "myType");
    $this->assertEqual($widget->getWidgetImmutableB(0), $associated);

    $widget->delete();
    $this->assertEqual($widget->getName(), "Little Widget");
    $this->assertEqual($widget->getType(), "myType");
    $this->assertEqual($widget->getWidgetImmutableB(0), $associated);
  }


  public function test_mutableClassHasSettersRemoversAndAddMethods()
  {
    $widget = new WidgetMutableB();
    $this->assertTrue($this->objectClassHasSettersAddersOrRemovers($widget));
  }

  
  public function test_unidirectionalManyAssociation()
  {
    $other1 = new ClassOtherclass("otherClass1");
    $other2 = new ClassOtherclass("otherClass2");

    $many = new ClassMany(array());
    $this->assertFalse($many->hasClassOtherclasses());
    $many = new ClassMany(array($other1));
    $this->assertTrue($many->hasClassOtherclasses());
    $many = new ClassMany(array($other1, $other2));
    $this->assertTrue($many->hasClassOtherclasses());
    $this->assertTrue($many->indexOfClassOtherclass($other1) >= 0);
    $this->assertTrue($many->indexOfClassOtherclass($other2) >= 0);
    $this->assertFalse($this->objectClassHasSettersAddersOrRemovers($many));
  }

  
  public function test_unidirectionalMToNAssociation()
  {
    $other1 = new ClassOtherclass("other1");
    $other2 = new ClassOtherclass("other2");
    $other3 = new ClassOtherclass("other3");
    $other4 = new ClassOtherclass("other4");

    try {
      $mToN = new ClassMToN(array());
      $this->fail("Constructor should have thrown Exception");
    } catch (Exception $ex) {}

    try {
      $mToN = new ClassMToN(array($other1));
      $this->fail("Constructor should have thrown Exception");
    } catch (Exception $ex) {}

    $mToN = new ClassMToN(array($other1,$other2));
    $this->assertTrue($mToN->hasClassOtherclasses());
    $this->assertTrue($mToN->indexOfClassOtherclass($other1) >= 0);
    $this->assertTrue($mToN->indexOfClassOtherclass($other2) >= 0);

    $mToN = new ClassMToN(array($other1,$other2,$other3));
    $this->assertTrue($mToN->hasClassOtherclasses());

    try {
      $mToN = new ClassMToN(array($other1,$other2,$other3,$other4));
      $this->fail("Constructor should have thrown Exception");
    } catch (Exception $ex) {}
    
    $this->assertFalse($this->objectClassHasSettersAddersOrRemovers($mToN));
  }

  
  public function test_unidirectionalMStarAssociation()
  {
    $other1 = new ClassOtherclass("other1");
    $other2 = new ClassOtherclass("other2");
    $other3 = new ClassOtherclass("other3");

    try {
      $mStar = new ClassMStar(array());
      $this->fail("Constructor should have thrown Exception");
    } catch (Exception $ex) {}

    try {
      $mStar = new ClassMStar(array($other1));
      $this->fail("Constructor should have thrown Exception");
    } catch (Exception $ex) {}

    $mStar = new ClassMStar(array($other1,$other2));
    $this->assertTrue($mStar->hasClassOtherclasses());
    $this->assertTrue($mStar->indexOfClassOtherclass($other1) >= 0);
    $this->assertTrue($mStar->indexOfClassOtherclass($other2) >= 0);

    $mStar = new ClassMStar(array($other1,$other2,$other3));
    $this->assertTrue($mStar->hasClassOtherclasses());
    
    $this->assertFalse($this->objectClassHasSettersAddersOrRemovers($mStar));
  }

  
  public function test_unidirectionalNAssociation()
  {
    $other1 = new ClassOtherclass("other1");
    $other2 = new ClassOtherclass("other2");
    $other3 = new ClassOtherclass("other3");

    try {
      $n = new ClassN(array());
      $this->fail("Constructor should have thrown Exception");
    } catch (Exception $ex) {}

    try {
      $n = new ClassN(array($other1));
      $this->fail("Constructor should have thrown Exception");
    } catch (Exception $ex) {}

    $n = new ClassN(array($other1,$other2));
    $this->assertTrue($n->hasClassOtherclasses());
    $this->assertTrue($n->indexOfClassOtherclass($other1) >= 0);
    $this->assertTrue($n->indexOfClassOtherclass($other2) >= 0);

    try {
      $n = new ClassN(array($other1,$other2,$other3));
    } catch (Exception $ex) {}
    
    $this->assertFalse($this->objectClassHasSettersAddersOrRemovers($n));
  }

  
  public function test_unidirectionalOneAssociation()
  {
    $other = new ClassOtherclass("otherClass");

    $one = new ClassOne($other);
    $this->assertTrue($one->getClassOtherclass() == $other);

    try {
      $one = new ClassOne(null);
      $this->fail("Constructor should have thrown Exception");
    } catch (Exception $ex) {}
    
    $this->assertFalse($this->objectClassHasSettersAddersOrRemovers($one));  
  }

  
  public function test_unidirectionalOptionalNAssociation()
  {
    $other1 = new ClassOtherclass("other1");
    $other2 = new ClassOtherclass("other2");
    $other3 = new ClassOtherclass("other3");

    $optN = new ClassOptionalN(array());
    $this->assertFalse($optN->hasClassOtherclasses());
    
    $optN = new ClassOptionalN(array($other1));
    $this->assertTrue($optN->hasClassOtherclasses());
    $this->assertTrue($optN->indexOfClassOtherclass($other1) >= 0);

    $optN = new ClassOptionalN(array($other1,$other2));
    $this->assertTrue($optN->hasClassOtherclasses());
    $this->assertTrue($optN->indexOfClassOtherclass($other1) >= 0);
    $this->assertTrue($optN->indexOfClassOtherclass($other2) >= 0);

    try {
      $optN = new ClassOptionalN(array($other1,$other2,$other3));
      $this->fail("Constructor should have thrown RuntimeException");
    } catch (Exception $ex) {}

    $this->assertFalse($this->objectClassHasSettersAddersOrRemovers($optN));   
  }

  
  public function test_unidirectionalOptionalOneAssociation()
  {
    $other = new ClassOtherclass("otherClass");

    $optOne = new ClassOptionalOne($other);
    $this->assertTrue($optOne->getClassOtherclass() == $other);

    $optOne = new ClassOptionalOne(null);
    $this->assertTrue($optOne->getClassOtherclass() == null);
    
    $this->assertFalse($this->objectClassHasSettersAddersOrRemovers($optOne));    
  }
  

  private function objectClassHasSettersAddersOrRemovers($obj)
  {
    $hasMethods = false;

    $clazz = new ReflectionClass(get_class($obj));
    $methods = $clazz->getMethods();

    foreach ($methods as $m)
    {
      if ((preg_match('/^(set|add|remove)[A-Z]+[a-zA-Z]*$/', $m->getName()) > 0) && $m->isPublic())
      {
        $hasMethods = true;
        break;
      }
    }
    return $hasMethods;
  }
}

?>
