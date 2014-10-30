<?php

class OneToOptionalNTest extends UnitTestCase
{

  public function test_cannotCreateNullStudent()
  {
  	$this->expectException(new Exception("Unable to create student due to mentor"));
    new StudentZ(99,null);
  }
  

  public function test_CreateMentorWithoutStudent()
  {
    $m = new MentorZ("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }


  public function test_CannotSetMentorNull()
  {
    $m = new MentorZ("blah");
    $s = new StudentZ(99,$m);
    
    $this->assertEqual(false,$s->setMentor(null));
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual($s,$m->getStudent_index(0));
  } 
  

  public function test_CreateStudentFromMentor()
  {
    $m = new MentorZ("blah");
    $s = new StudentZ(99,$m);

    $this->assertEqual(99,$s->getNumber());
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual(1,$m->numberOfStudents());
    $this->assertEqual($s,$m->getStudent_index(0));
  }  
  
  public function test_CreateStudentFromMentorTooMany()
  {
  	$this->expectException(new Exception("Unable to create student due to mentor"));
    $m = new MentorZ("blah");
    new StudentZ(99,$m);
    new StudentZ(98,$m);
    new StudentZ(97,$m);
    new StudentZ(96,$m);
  }  
  

  public function test_CannotSetMentorAlreadyAtMax()
  {
    $m = new MentorZ("blah");
    $m2 = new MentorZ("blah2");
    
    new StudentZ(99,$m);
    new StudentZ(98,$m);
    new StudentZ(97,$m);
    
    new StudentZ(96,$m2);
    new StudentZ(95,$m2);
    $s = new StudentZ(94,$m2);
    $this->assertEqual(false,$s->setMentor($m));
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual(3,$m2->numberOfStudents());
    $this->assertEqual($m2,$s->getMentor());
  }    

  

  public function test_CreateStudentFromMentorJustEnough()
  {
    $m = new MentorZ("blah");
    $s = new StudentZ(99,$m);
    $s2 = new StudentZ(98,$m);
    $s3 = new StudentZ(97,$m);
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual($m,$s2->getMentor());
    $this->assertEqual($m,$s3->getMentor());
  }   
  

  public function test_MaximumNumberOfStudents()
  {
    $this->assertEqual(3,MentorZ::maximumNumberOfStudents());
  }
  

  public function test_addStudentViaConstructorInformation()
  {
    $m = new MentorZ("blah");
    $s = $m->addStudentVia(10);

    $this->assertEqual(10,$s->getNumber());
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual(1,$m->numberOfStudents());
    $this->assertEqual($s,$m->getStudent_index(0));
  }
  

  public function test_addStudentViaConstructorInformationTooMany()
  {
    $m = new MentorZ("blah");
    $s = $m->addStudentVia(10);
    $s2 = $m->addStudentVia(11);
    $s3 = $m->addStudentVia(12);
    $s4 = $m->addStudentVia(13);

    $this->assertEqual(10,$s->getNumber());
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($s,$m->getStudent_index(0));
    $this->assertEqual($s2,$m->getStudent_index(1));
    $this->assertEqual($s3,$m->getStudent_index(2));
    $this->assertEqual(null,$s4);
  }  
  

  public function test_replaceMentor()
  {
    $m = new MentorZ("blah");
    $m2 = new MentorZ("blah2");

    $s = $m->addStudentVia(123);
    $s2 = $m2->addStudentVia(125);
    
    $this->assertEqual(true,$s->setMentor($m2));
    
    $this->assertEqual($m2,$s->getMentor());
    $this->assertEqual(2,$m2->numberOfStudents());
    $this->assertEqual($s2,$m2->getStudent_index(0));
    $this->assertEqual($s,$m2->getStudent_index(1));
    
    $this->assertEqual(0,$m->numberOfStudents());
    
  } 
  

  public function test_addToNewMentor()
  {
    $m = new MentorZ("blah");
    $m2 = new MentorZ("blah2");

    $s = $m->addStudentVia(123);
    $m2->addStudent($s);
    
    $this->assertEqual($m2,$s->getMentor());
    $this->assertEqual($s,$m2->getStudent_index(0));
    $this->assertEqual(0,$m->numberOfStudents());
  }  
  

  public function test_removeFromExistingMentor()
  {
    $m = new MentorZ("blah");
    $m2 = new MentorZ("blah2");

    $s1 = $m->addStudentVia(123);
    $s2 = $m->addStudentVia(124);
    $s3 = $m->addStudentVia(125);
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual(0,$m2->numberOfStudents());
    
    $m2->addStudent($s1);

    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($s2,$m->getStudent_index(0));
    $this->assertEqual($s3,$m->getStudent_index(1));
    
    $this->assertEqual(1,$m2->numberOfStudents());
    $this->assertEqual($s1,$m2->getStudent_index(0));
    
    $this->assertEqual($m2,$s1->getMentor());
    $this->assertEqual($m,$s2->getMentor());
    $this->assertEqual($m,$s3->getMentor());
  }   

  public function test_setMentorReplacesExistingMentor()
  {
    $m = new MentorZ("blah");
    $s = new StudentZ(99,$m);
    
    $m2 = new MentorZ("blah2");
    
    $s->setMentor($m2);
    $this->assertEqual($m2,$s->getMentor());
    $this->assertEqual($s,$m2->getStudent_index(0));
    $this->assertEqual(0,$m->numberOfStudents());    
  }  
  

  public function test_addStudentWhenMentorHasTooMany()
  {
    $m = new MentorZ("blah");
    $m2 = new MentorZ("blah2");
    
    $m->addStudentVia(12);
    $m->addStudentVia(13);
    $m->addStudentVia(14);
    
    $m2->addStudentVia(21);
    $m2->addStudentVia(22);
    $s = $m2->addStudentVia(23);
    
    $this->assertEqual(false,$m->addStudent($s));

    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual(3,$m2->numberOfStudents());
  }
}
?>
