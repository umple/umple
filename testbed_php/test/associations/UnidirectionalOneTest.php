<?php

class UnidirectionalOneTest extends UnitTestCase
{

  public function test_ConstructorManySide()
  {
    $s = new StudentAH(1);
    $m = new MentorAH("a",$s);
    $this->assertEqual("a",$m->getName());
    $this->assertEqual(1,$m->getStudent()->getNumber());
  }
  
  public function test_ConstructorCannotSetNull()
  {
  	$this->expectException(new Exception("Unable to create MentorAH due to aStudent"));
    new MentorAH("a",null);
  }   
  

  public function test_deleteLeavesStudentAlone()
  {
    $m = new MentorAH("a",new StudentAH(1));
    $s = $m->getStudent();
    $p = new ProgramAH();
    $s->setProgram($p);
    $m->delete();
    $this->assertEqual(null,$m->getStudent());
    $this->assertEqual(null,$m->getProgram());
    $this->assertEqual($p,$s->getProgram());
    
  }
  
}
