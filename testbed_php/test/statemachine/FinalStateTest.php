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
    $this->assertEqual("StatusOnMotorIdleMotorIdle",$c->getStatusOnMotorIdle());
    $this->assertEqual("StatusOnFanIdleFanIdle",$c->getStatusOnFanIdle());

    $c->flip();

    $this->assertEqual(1,$c->numberOfLogs());
    $this->assertEqual("deleted",$c->getLog(0));

    $this->assertEqual("StatusOn",$c->getStatus());
    $this->assertEqual("StatusOnMotorIdleFinal",$c->getStatusOnMotorIdle());
    $this->assertEqual("StatusOnFanIdleFanIdle",$c->getStatusOnFanIdle());
  }
  
}