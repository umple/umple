<?php

class AutoTransitionEvents extends UnitTestCase
{

  function test_simpleAutoTranslate()
  {
    $cource = new CourseQ();
    $this->assertEqual("OneOn",$cource->getOne());
  }

  function test_combinedWithOtherEntryActions()
  {
    $course = new CourseR();
    $this->assertEqual("OneOn",$course->getOne());
    
    $this->assertEqual(3, $course->numberOfLogs());
    $this->assertEqual("Enter Off",$course->getLog(0));
    $this->assertEqual("Exit Off",$course->getLog(1));
    $this->assertEqual("Enter On",$course->getLog(2));
  }

  function test_autoTransitionWithGuards()
  {
    $course = new CourseT(9);
    $this->assertEqual("OneWait",$course->getOne());

    $course = new CourseT(11);
    $this->assertEqual("OneOn",$course->getOne());
  }    

}
