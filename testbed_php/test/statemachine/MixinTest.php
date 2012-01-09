<?php

class MixinTest extends UnitTestCase
{

  public function test_SharedEvents()
  {
    $course = new CourseM();
    $course->flip();
    
    $this->assertEqual("OneOff",$course->getOne());
    $this->assertEqual("TwoFast", $course->getTwo());
  }

  public function test_AddEvents()
  {
    $course = new CourseN();
    $course->flip();
    $this->assertEqual("OneOff",$course->getOne());
  }
  
  public function test_RemoveEvent()
  {
    $course = new CourseO();
	$this->assertEqual(false, method_exists($course,"flip"));
  }
  
}

