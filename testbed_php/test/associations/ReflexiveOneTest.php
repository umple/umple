<?php

class ReflexiveOneTest extends UnitTestCase
{


  public function test_getFriend()
  {
    $m = MentorAF::newInstance("m1","m2");
    $m2 = $m->getFriend();
    
    $this->assertEqual($m2,$m->getFriend());
    $this->assertEqual($m,$m2->getFriend());
  }
  
}
