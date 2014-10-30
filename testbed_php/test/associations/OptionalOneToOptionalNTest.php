<?php

class OptionalOneToOptionalNTest extends UnitTestCase
{


  public function test_CreateStudentWithoutMentor()
  {
    $s = new StudentY(99);
    $this->assertEqual(null,$s->getMentor());
  }
  

  public function test_addStudent()
  {
    $m = new MentorY("blah");
    $s = new StudentY(99);
    $m->addStudent($s);
    
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual($s,$m->getStudent_index(0));
  }


  public function test_addStudentCannotAddForever()
  {
    $m = new MentorY("blah");
    $this->assertEqual(true,$m->addStudent(new StudentY(99)));
    $this->assertEqual(true,$m->addStudent(new StudentY(98)));
    $this->assertEqual(true,$m->addStudent(new StudentY(97)));
    $this->assertEqual(true,$m->addStudent(new StudentY(96)));
    $this->assertEqual(false,$m->addStudent(new StudentY(95)));
  }

  

  public function test_replaceMentor()
  {
    $m = new MentorY("blah");
    $m2 = new MentorY("blah2");

    $s = new StudentY(99);
    $m->addStudent($s);
    $s->setMentor($m2);
    
    $this->assertEqual($m2,$s->getMentor());
    $this->assertEqual($s,$m2->getStudent_index(0));
    $this->assertEqual(0,$m->numberOfStudents());
  } 


  public function test_cannotReplaceIfFull()
  {
    $m = new MentorY("blah");
    $m2 = new MentorY("blah2");

    $m2->addStudent(new StudentY(99));
    $m2->addStudent(new StudentY(98));
    $m2->addStudent(new StudentY(97));
    $m2->addStudent(new StudentY(96));
    
    $s = new StudentY(95);
    
    $this->assertEqual(true,$m->addStudent($s));
    $this->assertEqual(false,$s->setMentor($m2));
    
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual(4,$m2->numberOfStudents());
    $this->assertEqual(1,$m->numberOfStudents());
  } 
  

  public function test_addToNewMentor()
  {
    $m = new MentorY("blah");
    $m2 = new MentorY("blah2");
    $s = new StudentY(99);
    
    $m->addStudent($s);
    $m2->addStudent($s);
    
    $this->assertEqual($m2,$s->getMentor());
    $this->assertEqual($s,$m2->getStudent_index(0));
    $this->assertEqual(0,$m->numberOfStudents());
  }  
  

  public function test_cannotAddToFullMentor()
  {
    $m = new MentorY("blah");
    $m2 = new MentorY("blah2");
    $s = new StudentY(99);
    
    $m->addStudent(new StudentY(98));
    $m->addStudent(new StudentY(97));
    $m->addStudent(new StudentY(96));
    $m->addStudent(new StudentY(95));
    
    $m2->addStudent($s);
    $this->assertEqual(false,$m->addStudent($s));
    $this->assertEqual($m2,$s->getMentor());
    $this->assertEqual(4,$m->numberOfStudents());
    $this->assertEqual(1,$m2->numberOfStudents());
  }
  

  public function test_removeFromExistingMentor()
  {
    $m = new MentorY("blah");
    $m2 = new MentorY("blah2");

    $s1 = new StudentY(99);
    $s2 = new StudentY(98);
    $s3 = new StudentY(97);
    
    $m->addStudent($s1);
    $m->addStudent($s2);
    $m->addStudent($s3);

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
  

  public function test_removeStudent()
  {
    $m = new MentorY("blah");
    $s = new StudentY(99);
    
    $m->addStudent($s);
    $m->removeStudent($s);
    
    $this->assertEqual(null,$s->getMentor());
    $this->assertEqual(0,$m->numberOfStudents());
    
  }  


  public function test_maximumNumberOfStudents()
  {
    $this->assertEqual(4,MentorY::maximumNumberOfStudents());
  }
  
  
}
