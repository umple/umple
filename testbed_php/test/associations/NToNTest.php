<?php

class NToNTest extends UnitTestCase
{


  public function test_CreateStudentWithoutMentor()
  {
    $s = new StudentV(99);
    $this->assertEqual(0,$s->numberOfMentors());
  }
  

  public function test_CreateMentorWithoutStudent()
  {
    $m = new MentorV("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }
  

  public function test_SetStudentsJustRightEnough()
  {
    $m = new MentorV("blah");
    
    $s = new StudentV(99);
    $s2 = new StudentV(98);
    $s3 = new StudentV(97);
    
    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3)));
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor_index(0));
    $this->assertEqual($m,$s2->getMentor_index(0));
    $this->assertEqual($m,$s3->getMentor_index(0));
  }  
  

  public function test_SetStudentsTooMany()
  {
    $m = new MentorV("blah");
    
    $s = new StudentV(99);
    $s2 = new StudentV(98);
    $s3 = new StudentV(97);
    $s4 = new StudentV(96);
    
    $this->assertEqual(false,$m->setStudents(array($s,$s2,$s3,$s4)));
  }   
  

  public function test_AddStudents()
  {
    $m = new MentorV("blah");
    
    $s = new StudentV(99);
    $s2 = new StudentV(98);
    $s3 = new StudentV(97);
    $s4 = new StudentV(96);
    $s5 = new StudentV(95);
    $s6 = new StudentV(94);

    $this->assertEqual(true,$m->addStudent($s));
    $this->assertEqual(true,$m->addStudent($s2));
    $this->assertEqual(true,$m->addStudent($s3));
    $this->assertEqual(false,$m->addStudent($s4));
    $this->assertEqual(false,$m->addStudent($s5));
    $this->assertEqual(false,$m->addStudent($s6));
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor_index(0));
    $this->assertEqual($m,$s2->getMentor_index(0));
    $this->assertEqual($m,$s3->getMentor_index(0));
    $this->assertEqual(0,$s4->numberOfMentors());
    $this->assertEqual(0,$s5->numberOfMentors());
    $this->assertEqual(0,$s6->numberOfMentors());
  }   
  

  public function test_CannotRemoveStudents()
  {
    $m = new MentorV("blah");
    
    $s = new StudentV(99);
    $s2 = new StudentV(98);
    $s3 = new StudentV(97);

    $m->setStudents(array($s,$s2,$s3));
    $this->assertEqual(false,$m->removeStudent($s3));
  } 
  

  public function test_SetStudentsTooManyAndTooFew()
  {
    $m = new MentorV("blah");
    
    $s = new StudentV(99);
    $s2 = new StudentV(98);
    $s3 = new StudentV(97);
    $s4 = new StudentV(96);
    $s5 = new StudentV(95);
    
    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3)));
    
    $this->assertEqual(false,$m->setStudents(array($s4,$s5)));
    $this->assertEqual(false,$m->setStudents(array($s4,$s5,$s,$s2)));
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor_index(0));
    $this->assertEqual($m,$s2->getMentor_index(0));
    $this->assertEqual($m,$s3->getMentor_index(0));
    $this->assertEqual(0,$s4->numberOfMentors());
    $this->assertEqual(0,$s5->numberOfMentors());
    $this->assertEqual(0,$s5->numberOfMentors());
  }   
  

  public function test_MentorAlreadyHasEnoughStudents()
  {
    $m = new MentorV("blah");
    
    $s = new StudentV(99);
    $s2 = new StudentV(98);
    $s3 = new StudentV(97);
    
    $m->setStudents(array($s,$s2,$s3));
    
    $s6 = new StudentV(94);
    $this->assertEqual(false,$m->addStudent($s6));
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual(0,$s6->numberOfMentors());
  }    


  public function test_setMentors()
  {
    $m = new MentorV("blah");
    $m2 = new MentorV("blah2");
    $m3 = new MentorV("blah3");
    $m4 = new MentorV("blah4");

    $s = new StudentV(99);
    $s2 = new StudentV(98);
    
    $this->assertEqual(true,$s->setMentors(array($m2,$m3,$m,$m4)));
    $this->assertEqual(true,$m2->addStudent($s2));

    
    $this->assertEqual(2,$m2->numberOfStudents());
    $this->assertEqual(1,$m3->numberOfStudents());
    $this->assertEqual(4,$s->numberOfMentors());
  } 

  

  public function test_isNumberOfStudentsValid()
  {
    $m = new MentorV("blah");
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentV(99));
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentV(98));
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentV(97));
    $this->assertEqual(true,$m->isNumberOfStudentsValid());
  }
  

  public function test_getBoundsForStudent()
  {
    $this->assertEqual(3,MentorV::minimumNumberOfStudents());
    $this->assertEqual(3,MentorV::maximumNumberOfStudents());
  }  
  


  public function test_deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    $m = new MentorV("blah");
    $m2 = new MentorV("blah2");

    $s = new StudentV(99);
    $s2 = new StudentV(98);
    $s3 = new StudentV(97);
    
    $m->setStudents(array($s,$s2,$s3));
    $m2->setStudents(array($s,$s2,$s3));
    
    $p = new ProgramV();
    $s->setProgram($p);
    
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(0,$m2->numberOfStudents());
    $this->assertEqual(0,$s->numberOfMentors());
  }  

}
