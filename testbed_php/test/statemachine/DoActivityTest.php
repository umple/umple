<?php

class DoActivityTest extends UnitTestCase
{
    
  
  public function test_doActivity()
  {
    $course = new CourseC();
    $course->flip();
    $course->flip();
    $course->flip();
    
    sleep(3);
    $this->assertEqual("Excepted 5 or more, but only produced " + $course->numberOfLogs(), true,$course->numberOfLogs() >= 5);
    $this->assertEqual("Open Entry", $course->getLog(0));
    $this->assertEqual("Do Activity On Open",$course->getLog(1));
    $this->assertEqual("Closed Entry",$course->getLog(2));
    $this->assertEqual("Open Entry",$course->getLog(3));
    $this->assertEqual("Do Activity On Open",$course->getLog(4));

  }
    
}