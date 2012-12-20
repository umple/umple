<?php

class OneToMNTest extends UnitTestCase
{

  public function test_cannotCreateNullStudent()
  {
  	$this->expectException(new Exception("Unable to create student due to mentor"));
    new StudentK(99,null);
  }
  

  public function test_CreateMentorWithoutStudent()
  {
    $m = new MentorK("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }
  

  public function test_CannotSetMentorNull()
  {
    $m = new MentorK("blah");
    $s = new StudentK(99,$m);
    
    $this->assertEqual(false,$s->setMentor(null));
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual($s,$m->getStudent(0));
    
  }  


  public function test_CannotSetMentorAlreadyAtMax()
  {
    $m = new MentorK("blah");
    $m2 = new MentorK("blah2");
    
    new StudentK(99,$m);
    new StudentK(98,$m);
    new StudentK(97,$m);
    
    new StudentK(96,$m2);
    new StudentK(95,$m2);
    $s = new StudentK(94,$m2);
    $this->assertEqual(false,$s->setMentor($m));
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual(3,$m2->numberOfStudents());
    $this->assertEqual($m2,$s->getMentor());
  }    


  public function test_CannotSetMentorExistingAtMin()
  {
    $m = new MentorK("blah");
    $m2 = new MentorK("blah2");
    
    new StudentK(99,$m);
    new StudentK(98,$m);
    
    new StudentK(97,$m2);
    $s = new StudentK(96,$m2);
    $this->assertEqual(false,$s->setMentor($m));
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(2,$m2->numberOfStudents());
    $this->assertEqual($m2,$s->getMentor());

  
  }   
  

  public function test_CreateStudentFromMentor()
  {
    $m = new MentorK("blah");
    $s = new StudentK(99,$m);

    $this->assertEqual(99,$s->getNumber());
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual(1,$m->numberOfStudents());
    $this->assertEqual($s,$m->getStudent(0));
  }  
  

  public function test_addStudentViaConstructorInformation()
  {
    $m = new MentorK("blah");
    $s = $m->addStudentVia(10);

    $this->assertEqual(10,$s->getNumber());
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual(1,$m->numberOfStudents());
    $this->assertEqual($s,$m->getStudent(0));
  }


  public function test_addStudentViaConstructorInformationTooMany()
  {
    $m = new MentorK("blah");
    $m->addStudentVia(10);
    $m->addStudentVia(11);
    $m->addStudentVia(12);
    $this->assertEqual(null,$m->addStudentVia(13));
  }
  
  public function test_createStudentWhenMentorAlreadyHasEnogh()
  {
  	$this->expectException(new Exception("Unable to create student due to mentor"));
    $m = new MentorK("blah");
    new StudentK(10,$m);
    new StudentK(11,$m);
    new StudentK(12,$m);
    new StudentK(13,$m);
  }  
  
  

  public function test_replaceMentor()
  {
    $m = new MentorK("blah");
    $m2 = new MentorK("blah2");

    $s = $m->addStudentVia(123);
    $m->addStudentVia(125);
    $m->addStudentVia(126);
    $s2 = $m2->addStudentVia(124);
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual(1,$m2->numberOfStudents());
    
    $this->assertEqual(true,$s->setMentor($m2));
    $this->assertEqual($m2,$s->getMentor());
    $this->assertEqual(2,$m2->numberOfStudents());
    $this->assertEqual($s2,$m2->getStudent(0));
    $this->assertEqual($s,$m2->getStudent(1));
    
    $this->assertEqual(2,$m->numberOfStudents());
  } 
  

  public function test_addToNewMentor()
  {
    $m = new MentorK("blah");
    $m2 = new MentorK("blah2");

    $s = $m->addStudentVia(123);
    $m->addStudentVia(124);
    $m->addStudentVia(125);
    
    $this->assertEqual(true,$m2->addStudent($s));
    $this->assertEqual($m2,$s->getMentor());
    $this->assertEqual($s,$m2->getStudent(0));
    $this->assertEqual(2,$m->numberOfStudents());
  }  
  

  public function test_removeFromExistingMentor()
  {
    $m = new MentorK("blah");
    $m2 = new MentorK("blah2");

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
  

  public function test_setMentorReplacesExistingMentor()
  {
    $m = new MentorK("blah");
    $s = new StudentK(99,$m);
    new StudentK(98,$m);
    new StudentK(97,$m);
    
    $m2 = new MentorK("blah2");
    
    $this->assertEqual(true,$s->setMentor($m2));
    $this->assertEqual($m2,$s->getMentor());
    $this->assertEqual($s,$m2->getStudent(0));
    $this->assertEqual(2,$m->numberOfStudents());    
  }
  

  public function test_isNumberOfStudentsValid()
  {
    $m = new MentorK("blah");
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    new StudentK(99,$m);
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    new StudentK(98,$m);
    $this->assertEqual(true,$m->isNumberOfStudentsValid());

    new StudentK(97,$m);
    $this->assertEqual(true,$m->isNumberOfStudentsValid());

  }
  

  public function test_getBoundsForStudent()
  {
    $this->assertEqual(2,MentorK::minimumNumberOfStudents());
    $this->assertEqual(3,MentorK::maximumNumberOfStudents());
  }  


  public function test_addStudentWhenMentorHasTooMany()
  {
    $m = new MentorK("blah");
    $m2 = new MentorK("blah2");
    
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


  public function test_addStudentWhenMentorHasTooFew()
  {
    $m = new MentorK("blah");
    $m2 = new MentorK("blah2");
    
    $m->addStudentVia(12);
    $m->addStudentVia(13);
    
    $m2->addStudentVia(21);
    $s = $m2->addStudentVia(23);
    
    $this->assertEqual(false,$m->addStudent($s));

    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(2,$m2->numberOfStudents());
  }  
}
?>
