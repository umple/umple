<?php

class OneToNTest extends UnitTestCase
{

  public function test_cannotCreateNullStudent()
  {
  	$this->expectException(new Exception("Unable to create student due to mentor"));
    new StudentL(99,null);
  }
  

  public function test_CreateMentorWithoutStudent()
  {
    $m = new MentorL("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }
  

  public function test_CannotSetMentorNull()
  {
    $m = new MentorL("blah");
    $s = new StudentL(99,$m);
    
    $this->assertEqual(false,$s->setMentor(null));
  }  


  public function test_CannotSetMentorAlreadyAtMax()
  {
    $m = new MentorL("blah");
    $m2 = new MentorL("blah2");
    
    new StudentL(99,$m);
    new StudentL(98,$m);
    
    new StudentL(97,$m2);
    $s = new StudentL(96,$m2);
    $this->assertEqual(false,$s->setMentor($m));
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(2,$m2->numberOfStudents());
    $this->assertEqual($m2,$s->getMentor());
  }    


  public function test_CannotSetMentorExistingAtMin()
  {
    $m = new MentorL("blah");
    $m2 = new MentorL("blah2");
    
    new StudentL(99,$m);
    new StudentL(98,$m);
    
    new StudentL(97,$m2);
    $s = new StudentL(96,$m2);
    $this->assertEqual(false,$s->setMentor($m));
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(2,$m2->numberOfStudents());
    $this->assertEqual($m2,$s->getMentor());

  
  }   
  

  public function test_CreateStudentFromMentor()
  {
    $m = new MentorL("blah");
    $s = new StudentL(99,$m);

    $this->assertEqual(99,$s->getNumber());
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual(1,$m->numberOfStudents());
    $this->assertEqual($s,$m->getStudent_index(0));
  }  
  

  public function test_addStudentViaConstructorInformation()
  {
    $m = new MentorL("blah");
    $s = $m->addStudentVia(10);

    $this->assertEqual(10,$s->getNumber());
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual(1,$m->numberOfStudents());
    $this->assertEqual($s,$m->getStudent_index(0));
  }


  public function test_addStudentViaConstructorInformation_tooMany()
  {
    $m = new MentorL("blah");
    $m->addStudentVia(10);
    $m->addStudentVia(11);
    $m->addStudentVia(12);
    $this->assertEqual(null,$m->addStudentVia(13));
  }
  
  public function test_createStudentWhenMentorAlreadyHasEnogh()
  {
  	$this->expectException(new Exception("Unable to create student due to mentor"));
    $m = new MentorL("blah");
    new StudentL(10,$m);
    new StudentL(11,$m);
    new StudentL(12,$m);
    new StudentL(13,$m);
  }  
  
  

  public function test_cannotReplaceMentor()
  {
    $m = new MentorL("blah");
    $m2 = new MentorL("blah2");

    $s = $m->addStudentVia(123);
    $m2->addStudentVia(125);
    
    $this->assertEqual(false,$s->setMentor($m2));
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual(1,$m2->numberOfStudents());
    
    $this->assertEqual(1,$m->numberOfStudents());
    
  } 
  

  public function test_cannotReassign()
  {
    $m = new MentorL("blah");
    $m2 = new MentorL("blah2");

    $s = $m->addStudentVia(123);
    $this->assertEqual(false,$m2->addStudent($s));
  }  
  

  public function test_cannotRemoveFromExistingMentor()
  {
    $m = new MentorL("blah");
    $m2 = new MentorL("blah2");

    $s1 = $m->addStudentVia(123);
    $m->addStudentVia(124);
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(0,$m2->numberOfStudents());
    
    $this->assertEqual(false,$m2->addStudent($s1));
  }
  

  public function test_isNumberOfStudentsValid()
  {
    $m = new MentorL("blah");
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    new StudentL(99,$m);
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    new StudentL(98,$m);
    $this->assertEqual(true,$m->isNumberOfStudentsValid());

  }
  

  public function test_getBoundsForStudent()
  {
    $this->assertEqual(2,MentorL::minimumNumberOfStudents());
    $this->assertEqual(2,MentorL::maximumNumberOfStudents());
  }  


  public function test_addStudentWhenMentorHasTooMany()
  {
    $m = new MentorL("blah");
    $m2 = new MentorL("blah2");
    
    $m->addStudentVia(12);
    $m->addStudentVia(13);
    
    $m2->addStudentVia(21);
    $m2->addStudentVia(22);
    $s = $m2->addStudentVia(23);
    
    $this->assertEqual(false,$m->addStudent($s));

    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(2,$m2->numberOfStudents());
  }  


  public function test_addStudentWhenMentorHasTooFew()
  {
    $m = new MentorL("blah");
    $m2 = new MentorL("blah2");
    
    $m->addStudentVia(12);
    $m->addStudentVia(13);
    
    $m2->addStudentVia(21);
    $s = $m2->addStudentVia(23);
    
    $this->assertEqual(false,$m->addStudent($s));

    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(2,$m2->numberOfStudents());
  }  
}
