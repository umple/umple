<?php

class OneToMandatoryManyTest extends UnitTestCase
{

  public function test_cannotCreateNullStudent()
  {
  	$this->expectException(new Exception("Unable to create student due to mentor"));
    new StudentM(99,null);
  }
  

  public function test_CreateMentorWithoutStudent()
  {
    $m = new MentorM("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }
  

  public function test_CannotSetMentorNull()
  {
    $m = new MentorM("blah");
    $s = new StudentM(99,$m);
    
    $this->assertEqual(false,$s->setMentor(null));
  }  


  public function test_CanAlwaysSetMentorNeverAtMax()
  {
    $m = new MentorM("blah");
    $m2 = new MentorM("blah2");
    
    new StudentM(99,$m);
    new StudentM(98,$m);
    new StudentM(97,$m);
    
    new StudentM(96,$m2);
    new StudentM(95,$m2);
    
    for ($i=1; $i<=10; $i++)
    {
      $s = new StudentM($i,$m2);
      $this->assertEqual(true,$s->setMentor($m));
      $this->assertEqual(2,$m2->numberOfStudents());
      $this->assertEqual(3+$i,$m->numberOfStudents());
    }
  }    


  public function test_CannotSetMentorExistingAtMin()
  {
    $m = new MentorM("blah");
    $m2 = new MentorM("blah2");
    
    new StudentM(99,$m);
    new StudentM(98,$m);
    
    new StudentM(97,$m2);
    $s = new StudentM(96,$m2);
    $this->assertEqual(false,$s->setMentor($m));
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(2,$m2->numberOfStudents());
    $this->assertEqual($m2,$s->getMentor());

  
  }   
  

  public function test_CreateStudentFromMentor()
  {
    $m = new MentorM("blah");
    $s = new StudentM(99,$m);

    $this->assertEqual(99,$s->getNumber());
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual(1,$m->numberOfStudents());
    $this->assertEqual($s,$m->getStudent_index(0));
  }  
  

  public function test_addStudentViaConstructorInformation()
  {
    $m = new MentorM("blah");
    $s = $m->addStudentVia(10);

    $this->assertEqual(10,$s->getNumber());
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual(1,$m->numberOfStudents());
    $this->assertEqual($s,$m->getStudent_index(0));
  }


  public function test_addStudentViaConstructorInformation_neverTooMany()
  {
    $m = new MentorM("blah");
    
    for ($i=1; $i<10; $i++)
    {
      $s = $m->addStudentVia($i);
      $this->assertEqual(true,$s != null);
      $this->assertEqual($i,$m->numberOfStudents());
    }
  }
  

  public function test_createStudentMentoNeverHasEnough()
  {
    $m = new MentorM("blah");
    for ($i=1; $i<12; $i++)
    {
      new StudentM($i,$m);
      $this->assertEqual($i,$m->numberOfStudents());
    }
  }  
  
  

  public function test_cannotReplaceMentorIfNotLeftWithoutEnoughStudents()
  {
    $m = new MentorM("blah");
    $m2 = new MentorM("blah2");

    $s = $m->addStudentVia(123);
    $m2->addStudentVia(125);
    
    $this->assertEqual(false,$s->setMentor($m2));
  }
  

  public function test_replaceMentor()
  {
    $m = new MentorM("blah");
    $m2 = new MentorM("blah2");

    $s = $m->addStudentVia(123);
    $m->addStudentVia(125);
    $m->addStudentVia(124);
    
    $s2 = $m2->addStudentVia(122);
    
    
    $this->assertEqual(true,$s->setMentor($m2));
    
    $this->assertEqual($m2,$s->getMentor());
    $this->assertEqual(2,$m2->numberOfStudents());
    $this->assertEqual($s2,$m2->getStudent_index(0));
    $this->assertEqual($s,$m2->getStudent_index(1));
    
    $this->assertEqual(2,$m->numberOfStudents());
    
  } 
  

  public function test_addToNewMentor()
  {
    $m = new MentorM("blah");
    $m2 = new MentorM("blah2");

    $s = $m->addStudentVia(123);
    $m->addStudentVia(124);
    $m->addStudentVia(125);
    
    $this->assertEqual(true,$m2->addStudent($s));
    $this->assertEqual($m2,$s->getMentor());
    $this->assertEqual($s,$m2->getStudent_index(0));
    $this->assertEqual(2,$m->numberOfStudents());
  }  
  

  public function test_removeFromExistingMentor()
  {
    $m = new MentorM("blah");
    $m2 = new MentorM("blah2");

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
    $m = new MentorM("blah");
    $s = new StudentM(99,$m);
    new StudentM(98,$m);
    new StudentM(97,$m);
    
    $m2 = new MentorM("blah2");
    
    $this->assertEqual(true,$s->setMentor($m2));
    $this->assertEqual($m2,$s->getMentor());
    $this->assertEqual($s,$m2->getStudent_index(0));
    $this->assertEqual(2,$m->numberOfStudents());    
  }
  

  public function test_isNumberOfStudentsValid()
  {
    $m = new MentorM("blah");
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    new StudentM(99,$m);
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    new StudentM(98,$m);
    $this->assertEqual(true,$m->isNumberOfStudentsValid());

    new StudentM(97,$m);
    $this->assertEqual(true,$m->isNumberOfStudentsValid());

  }
  

  public function test_getBoundsForStudent()
  {
    $this->assertEqual(2,MentorM::minimumNumberOfStudents());
  }  


  public function test_addStudentMentorNeverHasTooMany()
  {
    $m = new MentorM("blah");
    $m2 = new MentorM("blah2");
    
    $m->addStudentVia(12);
    $m->addStudentVia(13);
    $m->addStudentVia(14);
    
    $m2->addStudentVia(21);
    $m2->addStudentVia(22);
    $s = $m2->addStudentVia(23);
    
    $this->assertEqual(true,$m->addStudent($s));

    $this->assertEqual(4,$m->numberOfStudents());
    $this->assertEqual(2,$m2->numberOfStudents());
  }  


  public function test_addStudentWhenMentorHasTooFew()
  {
    $m = new MentorM("blah");
    $m2 = new MentorM("blah2");
    
    $m->addStudentVia(12);
    $m->addStudentVia(13);
    
    $m2->addStudentVia(21);
    $s = $m2->addStudentVia(23);
    
    $this->assertEqual(false,$m->addStudent($s));

    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(2,$m2->numberOfStudents());
  }  
}
