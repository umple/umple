<?php

class SimpleStateMachineTest extends UnitTestCase
{
    
  function test_OneStateNoEvents()
  {
    $course = new CourseB();
    $this->assertEqual("StatusOpen",$course->getStatus());
  }
}
