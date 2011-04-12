<?php

class ImmutableTest extends UnitTestCase
{

  // TODO: Look at writing a helper test to use reflection to make sure the "setX" method is not available   
  public function test_Immutable()
  {
    $door = new DoorC("1",2,3.4,date(1234),time(1235),false,new DoorB(5));

    $this->assertEqual("1",$door->getId());
    // $this->assertEqual(false,$door->setId("2"));
    // $this->assertEqual("1",$door->getId());
  
    $this->assertEqual(2,$door->getIntId());
    // $this->assertEqual(false,$door->setIntId(22));
    // $this->assertEqual(2,$door->getIntId());
  
    $this->assertEqual(3.4,$door->getDoubleId(),0.01);
    // $this->assertEqual(false,$door->setDoubleId(33.44));
    // $this->assertEqual(3.4,$door->getDoubleId(),0.01);
    
    $this->assertEqual(date(1234),$door->getDateId());
    // $this->assertEqual(false,$door->setDateId(date(4321)));
    // $this->assertEqual(date(1234),$door->getDateId());

    $this->assertEqual(time(1235),$door->getTimeId());
    // $this->assertEqual(false,$door->setTimeId(date(5321)));
    // $this->assertEqual(time(1235),$door->getTimeId());

    $this->assertEqual(false,$door->getBooleanId());
    // $this->assertEqual(false,$door->setBooleanId(true));
    // $this->assertEqual(false,$door->getBooleanId());
    
    $this->assertEqual(new DoorB(5),$door->getDoorId());
    // $this->assertEqual(false,$door->setDoorId(new DoorB(6)));
    // $this->assertEqual(new DoorB(5),$door->getDoorId());
  }

  //TODO: Look at writing a helper test to use reflection to make sure the "setX" method is not available
  public function test_ImmutableInitialized()
  {
    $door = new DoorA();
    $this->assertEqual("1",$door->getId());
    // $this->assertEqual(false,$door->setId("2"));
    // $this->assertEqual("1",$door->getId());
  
    $this->assertEqual(2,$door->getIntId());
    // $this->assertEqual(false,$door->setIntId(22));
    // $this->assertEqual(2,$door->getIntId());
  
    $this->assertEqual(3.4,$door->getDoubleId(),0.01);
    // $this->assertEqual(false,$door->setDoubleId(33.44));
    // $this->assertEqual(3.4,$door->getDoubleId(),0.01);
    
    $this->assertEqual(date(1234),$door->getDateId());
    // $this->assertEqual(false,$door->setDateId(date(4321)));
    // $this->assertEqual(date(1234),$door->getDateId());

    $this->assertEqual(time(1235),$door->getTimeId());
    // $this->assertEqual(false,$door->setTimeId(date(5321)));
    // $this->assertEqual(time(1235),$door->getTimeId());

    $this->assertEqual(false,$door->getBooleanId());
    // $this->assertEqual(false,$door->setBooleanId(true));
    // $this->assertEqual(false,$door->getBooleanId());
    
    $this->assertEqual(new DoorB(5),$door->getDoorId());
    // $this->assertEqual(false,$door->setDoorId(new DoorB(6)));
    // $this->assertEqual(new DoorB(5),$door->getDoorId());

  }
}
