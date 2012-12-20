<?php

class UnidirectionalMStarTest extends UnitTestCase
{

  public function test_constructorTooFew()
  {
  	$this->expectException(new Exception("Unable to create MentorAL, must have at least 3 students"));
    $s = new StudentAL(99);
    $s2 = new StudentAL(98);
    new MentorAL("blah",array($s,$s2));
  }
  
  

  public function test_constructorRequiresMinimum()
  {
    $s = new StudentAL(99);
    $s2 = new StudentAL(98);
    $s3 = new StudentAL(97);
    
    $m = new MentorAL("blah",array($s,$s2,$s3));
    $this->assertEqual(3,$m->numberOfStudents());
  }
  

  public function test_addRemoveWithinLimits()
  {
    $s = new StudentAL(99);
    $s2 = new StudentAL(98);
    $s3 = new StudentAL(97);
    $s4 = new StudentAL(96);
    $s5 = new StudentAL(95);
    $s6 = new StudentAL(94);
    
    $m = new MentorAL("blah",array($s,$s2,$s3));
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual(true,$m->addStudent($s4));
    $this->assertEqual(true,$m->addStudent($s5));
    
    $this->assertEqual(5,$m->numberOfStudents());
    
    $this->assertEqual(false,$m->removeStudent($s6));
    $this->assertEqual(true,$m->removeStudent($s3));
    $this->assertEqual(true,$m->removeStudent($s4));
    $this->assertEqual(false,$m->removeStudent($s));
    $this->assertEqual(3,$m->numberOfStudents());
  }
  
  

  public function test_deleteDoesNotChangeStudent()
  {
    $s = new StudentAL(99);
    $s2 = new StudentAL(98);
    $s3 = new StudentAL(97);

    $p = new ProgramAL();
    $s->setProgram($p);
    
    $m = new MentorAL("blah",array($s,$s2,$s3));
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual($p,$s->getProgram());
  }
}
