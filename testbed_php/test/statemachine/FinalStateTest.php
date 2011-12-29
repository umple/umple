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
}