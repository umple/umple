<?php

class MNToNTest extends UnitTestCase
{


  public function test_CreateStudentWithoutMentor()
  {
    $s = new StudentT(99);
    $this->assertEqual(0,$s->numberOfMentors());
  }
  

  public function test_CreateMentorWithoutStudent()
  {
    $m = new MentorT("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }
  

  public function test_SetStudentsJustRightEnough()
  {
    $m = new MentorT("blah");
    
    $s = new StudentT(99);
    $s2 = new StudentT(98);
    $s3 = new StudentT(97);
    
    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3)));
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor_index(0));
    $this->assertEqual($m,$s2->getMentor_index(0));
    $this->assertEqual($m,$s3->getMentor_index(0));
  }  
  

  public function test_SetStudentsTooMany()
  {
    $m = new MentorT("blah");
    
    $s = new StudentT(99);
    $s2 = new StudentT(98);
    $s3 = new StudentT(97);
    $s4 = new StudentT(96);
    
    $this->assertEqual(false,$m->setStudents(array($s,$s2,$s3,$s4)));
  }   
  

  public function test_AddStudents()
  {
    $m = new MentorT("blah");
    
    $s = new StudentT(99);
    $s2 = new StudentT(98);
    $s3 = new StudentT(97);
    $s4 = new StudentT(96);
    $s5 = new StudentT(95);
    $s6 = new StudentT(94);

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
    $m = new MentorT("blah");
    
    $s = new StudentT(99);
    $s2 = new StudentT(98);
    $s3 = new StudentT(97);

    $m->setStudents(array($s,$s2,$s3));
    $this->assertEqual(false,$m->removeStudent($s3));
  } 
  

  public function test_SetStudentsTooManyAndTooFew()
  {
    $m = new MentorT("blah");
    
    $s = new StudentT(99);
    $s2 = new StudentT(98);
    $s3 = new StudentT(97);
    $s4 = new StudentT(96);
    $s5 = new StudentT(95);
    
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
    $m = new MentorT("blah");
    
    $s = new StudentT(99);
    $s2 = new StudentT(98);
    $s3 = new StudentT(97);
    
    $m->setStudents(array($s,$s2,$s3));
    
    $s6 = new StudentT(94);
    $this->assertEqual(false,$m->addStudent($s6));
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual(0,$s6->numberOfMentors());
  }    


  public function test_setMentors()
  {
    $m2 = new MentorT("blah2");
    $m3 = new MentorT("blah3");

    $s = new StudentT(99);
    $s2 = new StudentT(98);
    
    $this->assertEqual(true,$s->setMentors(array($m2,$m3)));
    $this->assertEqual(true,$m2->addStudent($s2));

    
    $this->assertEqual(2,$m2->numberOfStudents());
    $this->assertEqual(1,$m3->numberOfStudents());
    $this->assertEqual(2,$s->numberOfMentors());
  } 

  

  public function test_isNumberOfStudentsValid()
  {
    $m = new MentorT("blah");
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentT(99));
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentT(98));
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentT(97));
    $this->assertEqual(true,$m->isNumberOfStudentsValid());
  }
  

  public function test_getBoundsForStudent()
  {
    $this->assertEqual(3,MentorT::minimumNumberOfStudents());
    $this->assertEqual(3,MentorT::maximumNumberOfStudents());
  }  
  

  public function test_deleteMentorAndStudentHasEnough()
  {
    
    $m = new MentorT("blah");
    $m2 = new MentorT("blah2");
    $m3 = new MentorT("blah3");

    $s = new StudentT(99);
    $s2 = new StudentT(98);
    $s3 = new StudentT(97);
    
    $m->setStudents(array($s,$s2,$s3));
    $m2->setStudents(array($s,$s2,$s3));
    $m3->setStudents(array($s,$s2,$s3));
    
    $p = new ProgramT();
    $s->setProgram($p);
    
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual($p,$s->getProgram());
    $this->assertEqual(2,$s->numberOfMentors());
  }  


  public function test_deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    $m = new MentorT("blah");
    $m2 = new MentorT("blah2");

    $s = new StudentT(99);
    $s2 = new StudentT(98);
    $s3 = new StudentT(97);
    
    $m->setStudents(array($s,$s2,$s3));
    $m2->setStudents(array($s,$s2,$s3));
    
    $p = new ProgramT();
    $s->setProgram($p);
    
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(0,$m2->numberOfStudents());
    $this->assertEqual(0,$s->numberOfMentors());
  }  

}

?>
