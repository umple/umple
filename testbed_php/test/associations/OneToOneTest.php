<?php

class OneToOneTest extends UnitTestCase
{


  public function test_ConstructorBuildsBoth()
  {
    $m = MentorG::newInstance("a",1);
    $this->assertEqual("a",$m->getName());
    $this->assertEqual(1,$m->getStudent()->getNumber());
  }
  
  public function test_ConstructorIfAlreadySet()
  {
  	$this->expectException(new Exception("Unable to create StudentG due to aMentor"));
    $m = MentorG::newInstance("a",1);
    new StudentG(1,$m);
  }  
  
  public function test_ConstructorCannotSetNull()
  {
  	$this->expectException(new Exception("Unable to create MentorG due to aStudent"));
    new MentorG("a",null);
  }   
  

  public function test_delete()
  {
    $m = MentorG::newInstance("a",1);
    $s = $m->getStudent();
    $m->getStudent()->setProgram(new ProgramG());
    $m->delete();
    $this->assertEqual(null,$m->getStudent());
    $this->assertEqual(null,$m->getProgram());
    $this->assertEqual(null,$s->getMentor());
    $this->assertEqual(null,$s->getProgram());
    
  }
  
}

?>
