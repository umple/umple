<?php

class ReflexiveOptionalOneTest extends UnitTestCase
{

  public function test_SetSuperMentor()
  {
    $m = new MentorH("m1");
    $m2 = new MentorH("m2");
    
    $m->setSuperMentor($m2);
    $this->assertEqual($m, $m2->getSuperMentor());
    $this->assertEqual($m2, $m->getSuperMentor());
  }
  
}
