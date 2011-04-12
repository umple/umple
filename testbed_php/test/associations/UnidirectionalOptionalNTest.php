<?php

class UnidirectionalOptionalNTest extends UnitTestCase
{

  public function test_constructorTooFew()
  {
  	$this->expectException(new Exception("Unable to create MentorI, must have 2 to 4 students"));
    $s = new StudentI(99);
    new MentorI("blah",array($s));
  }
  
  public function test_constructorTooMany()
  {
  	$this->expectException(new Exception("Unable to create MentorI, must have 2 to 4 students"));
    $s = new StudentI(99);
    $s2 = new StudentI(98);
    $s3 = new StudentI(97);
    $s4 = new StudentI(96);
    $s5 = new StudentI(96);
    
    new MentorI("blah",array($s,$s2,$s3,$s4,$s5));
  }

  

  public function test_constructorRequiresMinimumToMaximum()
  {
    $s = new StudentI(99);
    $s2 = new StudentI(98);
    $s3 = new StudentI(97);
    $s4 = new StudentI(96);
    
    $m = new MentorI("blah",array($s,$s2));
    $this->assertEqual(2,$m->numberOfStudents());

    $m2 = new MentorI("blah2",array($s,$s2,$s3,$s4));
    $this->assertEqual(4,$m2->numberOfStudents());
  }
  

  public function test_addRemoveWithinLimits()
  {
    $s = new StudentI(99);
    $s2 = new StudentI(98);
    $s3 = new StudentI(97);
    $s4 = new StudentI(96);
    $s5 = new StudentI(95);
    
    $m = new MentorI("blah",array($s,$s2));
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(true,$m->addStudent($s3));
    $this->assertEqual(true,$m->addStudent($s4));
    $this->assertEqual(false,$m->addStudent($s4));
    
    $this->assertEqual(4,$m->numberOfStudents());
    
    $this->assertEqual(false,$m->removeStudent($s5));
    $this->assertEqual(true,$m->removeStudent($s3));
    $this->assertEqual(true,$m->removeStudent($s4));
    $this->assertEqual(false,$m->removeStudent($s));
    $this->assertEqual(2,$m->numberOfStudents());
  }
  
  

  public function test_deleteDoesNotChangeStudent()
  {
    $s = new StudentI(99);
    $s2 = new StudentI(98);

    $p = new ProgramI();
    $s->setProgram($p);
    
    $m = new MentorI("blah",array($s,$s2));
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual($p,$s->getProgram());
  }
}
