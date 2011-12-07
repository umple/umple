<?php

class NestedStateMachineTest extends UnitTestCase
{

  function test_EntryState()
  {
    $course = new CourseE();
    $this->assertEqual("StatusOff", $course->getStatus());
    $this->assertEqual("StatusOnNull", $course->getStatusOn());    
    
    $this->assertEqual(1,$course->numberOfLogs());
    $this->assertEqual("Enter Off", $course->getLog(0));
  }
  
  function test_EnterNestedStateMachine()
  {
    
    $course = new CourseE();
    $course->turnOn();
  
    $this->assertEqual(4,$course->numberOfLogs());
    $this->assertEqual("Enter Off", $course->getLog(0));
    $this->assertEqual("Exit Off", $course->getLog(1));
    $this->assertEqual("Enter On", $course->getLog(2));
    $this->assertEqual("Enter Play", $course->getLog(3));
    
    $this->assertEqual("StatusOn", $course->getStatus());
    $this->assertEqual("StatusOnPlay", $course->getStatusOn());    
  }
  
  function test_fullName()
  {
    $course = new CourseE();
  
    $this->assertEqual("StatusOff",$course->getStatusFullName());
  
    $course->turnOn();
    $this->assertEqual("StatusOn.StatusOnPlay",$course->getStatusFullName());
  }
  
  function test_ExitFromNestedState()
  {
    
    $course = new CourseE();
    $course->turnOn();
    $course->push();
    $course->turnOff();
  
    $this->assertEqual(9,$course->numberOfLogs());
    $this->assertEqual("Enter Off", $course->getLog(0));
    $this->assertEqual("Exit Off", $course->getLog(1));
    $this->assertEqual("Enter On", $course->getLog(2));
    $this->assertEqual("Enter Play", $course->getLog(3));
    $this->assertEqual("Exit Play", $course->getLog(4));
    $this->assertEqual("Enter Pause", $course->getLog(5));
    $this->assertEqual("Exit Pause", $course->getLog(6));
    $this->assertEqual("Exit On", $course->getLog(7));
    $this->assertEqual("Enter Off", $course->getLog(8));
    
    $this->assertEqual("StatusOff", $course->getStatus());
    $this->assertEqual("StatusOnNull", $course->getStatusOn());    
  }  
  
  function test_EnterNonStartStateOfNestedState()
  {
    
    $course = new CourseE();
    $this->assertEqual("StatusOff",$course->getStatus());
    $course->turnSleep();
    $course->wake();
  
    $this->assertEqual(6,$course->numberOfLogs());
    $this->assertEqual("Enter Off", $course->getLog(0));
    $this->assertEqual("Exit Off", $course->getLog(1));
    $this->assertEqual("Enter Sleep", $course->getLog(2));
    $this->assertEqual("Exit Sleep", $course->getLog(3));
    $this->assertEqual("Enter On", $course->getLog(4));
    $this->assertEqual("Enter Pause", $course->getLog(5));
    
    $this->assertEqual("StatusOn", $course->getStatus());
    $this->assertEqual("StatusOnPause", $course->getStatusOn());    
  }    


  function test_ShouldOnlyApplyEventsToCurrentState()
  {
    $course = new CourseG();
    $this->assertEqual("StatusOn",$course->getStatus());
    $course->turnOff();
    $course->flip();
    $this->assertEqual("StatusOn",$course->getStatus());
    $this->assertEqual("StatusOnIdle",$course->getStatusOn());
  }

  function test_ShouldStartInTheMostNestedStartState_SimpleStateMachine()
  {
    $course = new CourseH();
    $this->assertEqual("StatusOn.StatusOnRunning.StatusOnRunningPlay",$course->getStatusFullName());
    $this->assertEqual("StatusOn",$course->getStatus());
    $this->assertEqual("StatusOnRunning",$course->getStatusOn());
    $this->assertEqual("StatusOnRunningPlay",$course->getStatusOnRunning());
    
    $course->setStatus("StatusOff");
    $this->assertEqual("StatusOff.StatusOffIdle",$course->getStatusFullName());
    $this->assertEqual("StatusOff",$course->getStatus());
    $this->assertEqual("StatusOffIdle",$course->getStatusOff());
    $this->assertEqual("StatusOnNull",$course->getStatusOn());
    $this->assertEqual("StatusOnRunningNull",$course->getStatusOnRunning());
  }
  
  function test_ShouldStartInTheMostNestedStartState_ComplexStateMachine()
  {
    $course = new CourseI();
    $this->assertEqual("StatusOn.StatusOnRunning.StatusOnRunningPlay",$course->getStatusFullName());
    $this->assertEqual("StatusOn",$course->getStatus());
    $this->assertEqual("StatusOnRunning",$course->getStatusOn());
    $this->assertEqual("StatusOnRunningPlay",$course->getStatusOnRunning());
    
    $course->flip();
    $this->assertEqual("StatusOff.StatusOffFull",$course->getStatusFullName());
    $this->assertEqual("StatusOff",$course->getStatus());
    $this->assertEqual("StatusOffFull",$course->getStatusOff());
    $this->assertEqual("StatusOnNull",$course->getStatusOn());
    $this->assertEqual("StatusOnRunningNull",$course->getStatusOnRunning());
    
  }  
  
  
}
