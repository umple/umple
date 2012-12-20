<?php

class UnidirectionalNTest extends UnitTestCase
{

  public function test_constructorEmpty()
  {
    $m = new MentorAK("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }
  
  public function test_setTooMany()
  {
    $s = new StudentAK(99);
    $s2 = new StudentAK(98);
    $s3 = new StudentAK(97);
    $s4 = new StudentAK(96);
    
    $m = new MentorAK("blah");
    $this->assertEqual(false,$m->setStudents(array($s,$s2,$s3,$s4)));
    $this->assertEqual(0, $m->numberOfStudents());
  }

  

  public function test_setStudents()
  {
    $s = new StudentAK(99);
    $s2 = new StudentAK(98);
    $s3 = new StudentAK(97);
    $s4 = new StudentAK(97);
    
    $m = new MentorAK("blah");
    
    $this->assertEqual(false,$m->setStudents(array($s,$s2,$s3,$s4)));
    $this->assertEqual(false,$m->setStudents(array($s,$s2,$s2)));
    $this->assertEqual(true,$m->setStudents(array($s,$s2)));
    
    $this->assertEqual(2,$m->numberOfStudents());
  }
  

  public function test_deleteDoesNotChangeStudent()
  {
    $s = new StudentAK(99);
    $s2 = new StudentAK(98);
    $s3 = new StudentAK(97);

    $p = new ProgramAK();
    $s->setProgram($p);
    
    $m = new MentorAK("blah");
    $m->setStudents(array($s,$s2,$s3));
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual($p,$s->getProgram());
  }
}
