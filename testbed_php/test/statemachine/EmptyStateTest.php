<?php

class EmptyStateTest extends UnitTestCase
{
    
  function test_getStateMachine()
  {
    $course = new CourseA();
    $this->assertEqual(null,$course->getStatus());
  }
}