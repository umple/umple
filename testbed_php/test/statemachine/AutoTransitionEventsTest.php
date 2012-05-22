<?php

class AutoTransitionEvents extends UnitTestCase
{

    function test_simpleAutoTranslate()
    {
      $q = new CourseQ();
      $this->assertEqual("OneOn",$q->getOne());
    }

    function test_combinedWithOtherEntryActions()
    {
      $r = new CourseR();
      $this->assertEqual("OneOn",$r->getOne());
    
      $this->assertEqual(3, $r->numberOfLogs());
      $this->assertEqual("Enter Off",$r->getLog(0));
      $this->assertEqual("Exit Off",$r->getLog(1));
      $this->assertEqual("Enter On",$r->getLog(2));
    }
    

}
