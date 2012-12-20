<?php

class OneToManyTest extends UnitTestCase
{

  public function test_cannotCreateNullStudent()
  {
  	$this->expectException(new Exception("Unable to create student due to mentor"));
    new StudentJ(99,null);
  }
  

  public function test_CreateMentorWithoutStudent()
  {
    $m = new MentorJ("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }


  public function test_CreateStudentFromMentor()
  {
    $m = new MentorJ("blah");
    $s = new StudentJ(99,$m);

    $this->assertEqual(99,$s->getNumber());
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual(1,$m->numberOfStudents());
    $this->assertEqual($s,$m->getStudent(0));
  }  
  

  public function test_addStudentViaConstructorInformation()
  {
    $m = new MentorJ("blah");
    $s = $m->addStudentVia(10);

    $this->assertEqual(10,$s->getNumber());
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual(1,$m->numberOfStudents());
    $this->assertEqual($s,$m->getStudent(0));
  }
  

  public function test_replaceMentor()
  {
    $m = new MentorJ("blah");
    $m2 = new MentorJ("blah2");

    $s = $m->addStudentVia(123);
    $s2 = $m2->addStudentVia(125);
    
    $s->setMentor($m2);
    
    $this->assertEqual($m2,$s->getMentor());
    $this->assertEqual(2,$m2->numberOfStudents());
    $this->assertEqual($s2,$m2->getStudent(0));
    $this->assertEqual($s,$m2->getStudent(1));
    
    $this->assertEqual(0,$m->numberOfStudents());
    
  } 
  

  public function test_addToNewMentor()
  {
    $m = new MentorJ("blah");
    $m2 = new MentorJ("blah2");

    $s = $m->addStudentVia(123);
    $m2->addStudent($s);
    
    $this->assertEqual($m2,$s->getMentor());
    $this->assertEqual($s,$m2->getStudent(0));
    $this->assertEqual(0,$m->numberOfStudents());
  }  
  

  public function test_removeFromExistingMentor()
  {
    $m = new MentorJ("blah");
    $m2 = new MentorJ("blah2");

    $s1 = $m->addStudentVia(123);
    $s2 = $m->addStudentVia(124);
    $s3 = $m->addStudentVia(125);
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual(0,$m2->numberOfStudents());
    
    $m2->addStudent($s1);

    $this->assertEqual(2,$m->numberOfStudents());
    
    $this->assertEqual($s2,$m->getStudent(0));
    $this->assertEqual($s3,$m->getStudent(1));
    
    $this->assertEqual(1,$m2->numberOfStudents());
    $this->assertEqual($s1,$m2->getStudent(0));
    
    $this->assertEqual($m2,$s1->getMentor());
    $this->assertEqual($m,$s2->getMentor());
    $this->assertEqual($m,$s3->getMentor());
  }   


  public function test_cannotSetMentorNull()
  {
    $m = new MentorJ("blah");
    $s = new StudentJ(99,$m);
    $this->assertEqual(false,$s->setMentor(null));
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual($s,$m->getStudent(0));
  }
  

  public function test_setMentorReplacesExistingMentor()
  {
    $m = new MentorJ("blah");
    $s = new StudentJ(99,$m);
    
    $m2 = new MentorJ("blah2");
    
    $s->setMentor($m2);
    $this->assertEqual($m2,$s->getMentor());
    $this->assertEqual($s,$m2->getStudent(0));
    $this->assertEqual(0,$m->numberOfStudents());    
  }  

  public function test_deleteManyEnd()
  {
    $m = new MentorJ("blah");
    $s = new StudentJ(99,$m);
    $s2 = new StudentJ(98,$m);
    
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual($m,$s2->getMentor());
    $this->assertEqual(2,$m->numberOfStudents());

    $s->delete();
    
    $this->assertEqual(null,$s->getMentor());
    $this->assertEqual($m,$s2->getMentor());
    $this->assertEqual(1,$m->numberOfStudents());
    
    $s2->delete();
    $this->assertEqual(null,$s->getMentor());
    $this->assertEqual(null,$s2->getMentor());
    $this->assertEqual(0,$m->numberOfStudents());
  }
}

?>
