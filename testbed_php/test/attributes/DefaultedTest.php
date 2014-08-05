<?php

class DefaultedTest extends UnitTestCase
{
  
  public function test_defaulted()
  {
    $door = new DoorD();
    
    $this->assertEqual("1",$door->getId());
    $this->assertEqual(true, $door->setId("2"));
    $this->assertEqual("2",$door->getId());
    $this->assertEqual(true, $door->resetId());
    $this->assertEqual("1",$door->getId());
    
    $this->assertEqual(2,$door->getIntId());
    $this->assertEqual(true, $door->setIntId(3));
    $this->assertEqual(3,$door->getIntId());
    $this->assertEqual(true, $door->resetIntId());
    $this->assertEqual(2,$door->getIntId());

    $this->assertEqual(3.4,$door->getDoubleId(),0.01);
    $this->assertEqual(true, $door->setDoubleId(33.44));
    $this->assertEqual(33.44,$door->getDoubleId(),0.01);
    $this->assertEqual(true, $door->resetDoubleId());
    $this->assertEqual(3.4,$door->getDoubleId(),0.01);

    $this->assertEqual(date(1234),$door->getDateId());
    $this->assertEqual(true, $door->setDateId(date(4321)));
    $this->assertEqual(date(4321),$door->getDateId());
    $this->assertEqual(true, $door->resetDateId());
    $this->assertEqual(date(1234),$door->getDateId());

    $this->assertEqual(time(1234),$door->getTimeId());
    $this->assertEqual(true, $door->setTimeId(time(5321)));
    $this->assertEqual(time(5321),$door->getTimeId());
    $this->assertEqual(true, $door->resetTimeId());
    $this->assertEqual(time(1234),$door->getTimeId());

    $this->assertEqual(false,$door->getBooleanId());
    $this->assertEqual(true, $door->setBooleanId(true));
    $this->assertEqual(true,$door->getBooleanId());
    $this->assertEqual(true, $door->resetBooleanId());
    $this->assertEqual(false,$door->getBooleanId());

    $this->assertEqual(new DoorB(5),$door->getDoorId());
    $this->assertEqual(true, $door->setDoorId(new DoorB(6)));
    $this->assertEqual(new DoorB(6),$door->getDoorId());
    $this->assertEqual(true, $door->resetDoorId());
    $this->assertEqual(new DoorB(5),$door->getDoorId());
  }

}
