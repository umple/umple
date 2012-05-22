<?php

class EntryAndExitActionTest extends UnitTestCase
{

  function test_EntryCalledOnConstructorForDefault()
  {
    $course = new CourseB();
    $this->assertEqual("entry called",$course->getLog());
  }

  function test_CallEntry()
  {
    $course = new CourseB();
    $course->anEvent();
    $course->anEvent();
    $this->assertEqual("StatusOpen",$course->getStatus());
    $this->assertEqual("entry called", $course->getLog());
  }  

  function test_CallExit()
  {
    $course = new CourseB();
    $course->anEvent();
    $this->assertEqual("StatusClosed",$course->getStatus());
    $this->assertEqual("exit called", $course->getLog());
    
    $course->anEvent();
    $this->assertEqual("StatusOpen", $course->getStatus());
    $this->assertEqual("entry called", $course->getLog());
  }
  
  function test_CallMultipleEntryExit()
  {
    $course = new CourseS();
    
    $this->assertEqual("Enter Off 1", $course->getLog(0));
    $this->assertEqual("Enter Off 2", $course->getLog(1));
    
    $course->flip();
    $this->assertEqual("Exit Off 1", $course->getLog(2));
    $this->assertEqual("Exit Off 2", $course->getLog(3));
  }  

}
