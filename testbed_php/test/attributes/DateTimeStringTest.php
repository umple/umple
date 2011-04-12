<?php

class DateTimeStringTest extends UnitTestCase
{

  public function test_Date()
  {
    $door = new DoorE();
    
    $this->assertEqual("78-12-01",$door->getD1());
    $this->assertEqual("78-12-02",$door->getD2());
    $this->assertEqual("78-12-03",$door->getD3());
    $this->assertEqual("1978-12-04",$door->getD4());

    $door->resetD3();
    $this->assertEqual("78-12-03",$door->getD3());
  }

  public function test_Time()
  {
    $door = new DoorF();
    
    $this->assertEqual("12:51:51",$door->getD1());
    $this->assertEqual("12:52:52",$door->getD2());
    $this->assertEqual("12:53:53",$door->getD3());
    $this->assertEqual("12:53:54",$door->getD4());

    $door->resetD3();
    $this->assertEqual("12:53:53",$door->getD3());
  }


}
