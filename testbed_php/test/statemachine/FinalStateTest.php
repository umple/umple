<?php

class FinalStateTest extends UnitTestCase
{
    
  function test_CallDeleteOnceInFinalState()
  {
    $course = new CourseK();
    $course->flip();
    $this->assertEqual(1,$course->numberOfLogs());
    $this->assertEqual("deleted",$course->getLog(0));
  }
  
  function test_CallDeleteOnlyOnceAllFinalStatesAreReached()
  {
    $c = new CourseL();
    $this->assertEqual("StatusOn",$c->getStatus());
    $this->assertEqual("StatusMotorIdleMotorIdle",$c->getStatusMotorIdle());
    $this->assertEqual("StatusFanIdleFanIdle",$c->getStatusFanIdle());

    $c->flip();

    $this->assertEqual("StatusOn",$c->getStatus());
    $this->assertEqual("StatusMotorIdleFinal",$c->getStatusMotorIdle());
    $this->assertEqual("StatusFanIdleFanIdle",$c->getStatusFanIdle());
    
    
    $this->assertEqual(0,$c->numberOfLogs());
    $c->flop();

    $this->assertEqual("StatusOn",$c->getStatus());
    $this->assertEqual("StatusMotorIdleFinal",$c->getStatusMotorIdle());
    $this->assertEqual("StatusFanIdleFinal",$c->getStatusFanIdle());
    
    $this->assertEqual(1,$c->numberOfLogs());
    $this->assertEqual("deleted",$c->getLog(0));
  }
  
}