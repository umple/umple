<?php

class UnidirectionalOptionalOneTest extends UnitTestCase
{


  public function test_setStudent()
  {
    $s = new StudentAI(1);
    $m = new MentorAI("a");
    $this->assertEqual("a",$m->getName());
    $this->assertEqual(null,$m->getStudent());

    $m->setStudent($s);
    $this->assertEqual($s,$m->getStudent());
    $this->assertEqual(1,$m->getStudent()->getNumber());
  }
  

  public function test_deleteLeavesStudentAlone()
  {
    $m = new MentorAI("a");
    $s = new StudentAI(1);
    $m->setStudent($s);
    $p = new ProgramAI();
    $s->setProgram($p);
    $m->delete();
    $this->assertEqual(null,$m->getStudent());
    $this->assertEqual(null,$m->getProgram());
    $this->assertEqual($p,$s->getProgram());
    
  }
  
}
