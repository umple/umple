<?php

class AssociationImmutableTest extends UnitTestCase
{

  public function test_mutableClassHasSettersRemoversAndAddMethodsAssociation()
  {
    $mentor = new MentorA();
    $this->assertTrue($this->objectClassHasSettersAddersOrRemoversAssociation($mentor));
  }

  
  public function test_unidirectionalManyAssociation()
  {
    $other1 = new Otherclass("otherClass1");
    $other2 = new Otherclass("otherClass2");

    $many = new ClassManyAssociation(array());
    $this->assertFalse($many->hasOtherclasses());
    $many = new ClassManyAssociation(array($other1));
    $this->assertTrue($many->hasOtherclasses());
    $many = new ClassManyAssociation(array($other1, $other2));
    $many->delete();
    $this->assertTrue($many->hasOtherclasses());

    $this->assertTrue($many->hasOtherclasses());
    $this->assertTrue($many->indexOfOtherclass($other1) >= 0);
    $this->assertTrue($many->indexOfOtherclass($other2) >= 0);
    $this->assertFalse($this->objectClassHasSettersAddersOrRemoversAssociation($many));
  }

  
  public function test_unidirectionalMToNAssociation()
  {
    $other1 = new Otherclass("other1");
    $other2 = new Otherclass("other2");
    $other3 = new Otherclass("other3");
    $other4 = new Otherclass("other4");

    try {
      $mToN = new ClassMToNAssociation(array());
      $this->fail("Constructor should have thrown Exception");
    } catch (Exception $ex) {}

    try {
      $mToN = new ClassMToNAssociation(array($other1));
      $this->fail("Constructor should have thrown Exception");
    } catch (Exception $ex) {}

    $mToN = new ClassMToNAssociation(array($other1,$other2));
    $this->assertTrue($mToN->hasOtherclasses());
    $this->assertTrue($mToN->indexOfOtherclass($other1) >= 0);
    $this->assertTrue($mToN->indexOfOtherclass($other2) >= 0);

    $mToN = new ClassMToNAssociation(array($other1,$other2,$other3));
    $this->assertTrue($mToN->hasOtherclasses());
    $mToN->delete();
    $this->assertTrue($mToN->hasOtherclasses());

    try {
      $mToN = new ClassMToNAssociation(array($other1,$other2,$other3,$other4));
      $this->fail("Constructor should have thrown Exception");
    } catch (Exception $ex) {}
    
    $this->assertFalse($this->objectClassHasSettersAddersOrRemoversAssociation($mToN));
  }

  
  public function test_unidirectionalMStarAssociation()
  {
    $other1 = new Otherclass("other1");
    $other2 = new Otherclass("other2");
    $other3 = new Otherclass("other3");

    try {
      $mStar = new ClassMStarAssociation(array());
      $this->fail("Constructor should have thrown Exception");
    } catch (Exception $ex) {}

    try {
      $mStar = new ClassMStarAssociation(array($other1));
      $this->fail("Constructor should have thrown Exception");
    } catch (Exception $ex) {}

    $mStar = new ClassMStarAssociation(array($other1,$other2));
    $this->assertTrue($mStar->hasOtherclasses());
    $this->assertTrue($mStar->indexOfOtherclass($other1) >= 0);
    $this->assertTrue($mStar->indexOfOtherclass($other2) >= 0);

    $mStar = new ClassMStarAssociation(array($other1,$other2,$other3));
    $this->assertTrue($mStar->hasOtherclasses());
    $mStar->delete();
    $this->assertTrue($mStar->hasOtherclasses());
    
    $this->assertFalse($this->objectClassHasSettersAddersOrRemoversAssociation($mStar));
  }

  
  public function test_unidirectionalNAssociation()
  {
    $other1 = new Otherclass("other1");
    $other2 = new Otherclass("other2");
    $other3 = new Otherclass("other3");

    try {
      $n = new ClassNAssociation(array());
      $this->fail("Constructor should have thrown Exception");
    } catch (Exception $ex) {}

    try {
      $n = new ClassNAssociation(array($other1));
      $this->fail("Constructor should have thrown Exception");
    } catch (Exception $ex) {}

    $n = new ClassNAssociation(array($other1,$other2));
    $this->assertTrue($n->hasOtherclasses());
    $this->assertTrue($n->indexOfOtherclass($other1) >= 0);
    $this->assertTrue($n->indexOfOtherclass($other2) >= 0);
    $n->delete();
    $this->assertTrue($n->hasOtherclasses());

    try {
      $n = new ClassNAssociation(array($other1,$other2,$other3));
    } catch (Exception $ex) {}
    
    $this->assertFalse($this->objectClassHasSettersAddersOrRemoversAssociation($n));
  }

  
  public function test_unidirectionalOneAssociation()
  {
    $other = new Otherclass("otherClass");

    $one = new ClassOneAssociation($other);
    $this->assertTrue($one->getOtherclass() == $other);
    $one->delete();
    $this->assertTrue($one->getOtherclass() == $other);

    try {
      $one = new ClassOneAssociation(null);
      $this->fail("Constructor should have thrown Exception");
    } catch (Exception $ex) {}
    
    $this->assertFalse($this->objectClassHasSettersAddersOrRemoversAssociation($one));  
  }

  
  public function test_unidirectionalOptionalNAssociation()
  {
    $other1 = new Otherclass("other1");
    $other2 = new Otherclass("other2");
    $other3 = new Otherclass("other3");

    $optN = new ClassOptionalNAssociation(array());
    $this->assertFalse($optN->hasOtherclasses());
    
    $optN = new ClassOptionalNAssociation(array($other1));
    $this->assertTrue($optN->hasOtherclasses());
    $this->assertTrue($optN->indexOfOtherclass($other1) >= 0);

    $optN = new ClassOptionalNAssociation(array($other1,$other2));
    $this->assertTrue($optN->hasOtherclasses());
    $this->assertTrue($optN->indexOfOtherclass($other1) >= 0);
    $this->assertTrue($optN->indexOfOtherclass($other2) >= 0);
    $optN->delete();
    $this->assertTrue($optN->hasOtherclasses());

    try {
      $optN = new ClassOptionalNAssociation(array($other1,$other2,$other3));
      $this->fail("Constructor should have thrown RuntimeException");
    } catch (Exception $ex) {}

    $this->assertFalse($this->objectClassHasSettersAddersOrRemoversAssociation($optN));   
  }

  
  public function test_unidirectionalOptionalOneAssociation()
  {
    $other = new Otherclass("otherClass");

    $optOne = new ClassOptionalOneAssociation($other);
    $this->assertTrue($optOne->getOtherclass() == $other);
    $optOne->delete();
    $this->assertTrue($optOne->getOtherclass() == $other);

    $optOne = new ClassOptionalOneAssociation(null);
    $this->assertTrue($optOne->getOtherclass() == null);
    
    $this->assertFalse($this->objectClassHasSettersAddersOrRemoversAssociation($optOne));    
  }
  

  private function objectClassHasSettersAddersOrRemoversAssociation($obj)
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
