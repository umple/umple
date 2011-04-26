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

}
