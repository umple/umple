<?php

class NToMStarTest extends UnitTestCase
{


  public function test_CreateStudentWithoutMentor()
  {
    $s = new StudentW(99);
    $this->assertEqual(0,$s->numberOfMentors());
  }
  

  public function test_CreateMentorWithoutStudent()
  {
    $m = new MentorW("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }
  

  public function test_SetStudentsJustEnough()
  {
    $m = new MentorW("blah");
    
    $s = new StudentW(99);
    $s2 = new StudentW(98);
    $s3 = new StudentW(97);
    $s4 = new StudentW(96);
    
    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3,$s4)));
    
    $this->assertEqual(4, $m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor_index(0));
    $this->assertEqual($m,$s2->getMentor_index(0));
    $this->assertEqual($m,$s3->getMentor_index(0));
    $this->assertEqual($m,$s4->getMentor_index(0));
  }  
  

  public function test_SetStudentsNeverAtMax()
  {
    $m = new MentorW("blah");
    
    $s = new StudentW(99);
    $s2 = new StudentW(98);
    $s3 = new StudentW(97);
    $s4 = new StudentW(96);
    $s5 = new StudentW(95);
    $s6 = new StudentW(94);
    $s7 = new StudentW(93);
    $s8 = new StudentW(92);
    $s9 = new StudentW(91);
    
    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3,$s4,$s5,$s6,$s7,$s8,$s9)));
    
    $this->assertEqual(9, $m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor_index(0));
    $this->assertEqual($m,$s2->getMentor_index(0));
    $this->assertEqual($m,$s3->getMentor_index(0));
    $this->assertEqual($m,$s4->getMentor_index(0));
    $this->assertEqual($m,$s5->getMentor_index(0));
    $this->assertEqual($m,$s6->getMentor_index(0));
    $this->assertEqual($m,$s7->getMentor_index(0));
    $this->assertEqual($m,$s8->getMentor_index(0));
    $this->assertEqual($m,$s9->getMentor_index(0));
  }   
  

  public function test_AddStudents()
  {
    $m = new MentorW("blah");
    
    $s = new StudentW(99);
    
    $this->assertEqual(true,$m->addStudent($s));
    
    for ($i=2; $i<10; $i++)
    {
      $s2 = new StudentW($i);
      $this->assertEqual(true,$m->addStudent($s2));
      $this->assertEqual($i,$m->numberOfStudents());
      $this->assertEqual($m,$s2->getMentor_index(0));
    }
  }   
  

  public function test_RemoveMiddleStudentWhenNotValidMaintainsTheOrder()
  {
    $m = new MentorW("blah");
    
    $s = new StudentW(99);
    $s2 = new StudentW(98);
    $s3 = new StudentW(97);
    $s4 = new StudentW(96);


    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3,$s4)));
    $this->assertEqual(false,$m->removeStudent($s2));
    
    $this->assertEqual(4, $m->numberOfStudents());
    $this->assertEqual($s2,$m->getStudent_index(1));
  } 
  

  public function test_CannotRemoveStudentsBecauseNeedsFixedNumberOfMentors()
  {
    $m = new MentorW("blah");
    $m2 = new MentorW("blah2");
    
    $s = new StudentW(99);
    $s2 = new StudentW(98);
    $s3 = new StudentW(97);
    $s4 = new StudentW(96);
    $s5 = new StudentW(95);
    $s6 = new StudentW(94);

    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    $m2->setStudents(array($s,$s2,$s3,$s4,$s5));
    
    $this->assertEqual(false,$m->removeStudent($s6));
    $this->assertEqual(false,$m->removeStudent($s5));
    
    $this->assertEqual(2,$s5->numberOfMentors());
    $this->assertEqual(5, $m->numberOfStudents());
  } 
  

  public function test_SetStudentsTooFew()
  {
    $m = new MentorW("blah");
    
    $s = new StudentW(99);
    $s2 = new StudentW(98);
    $s3 = new StudentW(97);
    $s4 = new StudentW(96);
    $s5 = new StudentW(95);
    $s6 = new StudentW(94);
    
    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3)));
    
    $this->assertEqual(false,$m->setStudents(array($s4,$s5)));
    
    $this->assertEqual(3, $m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor_index(0));
    $this->assertEqual($m,$s2->getMentor_index(0));
    $this->assertEqual($m,$s3->getMentor_index(0));
    $this->assertEqual(0,$s4->numberOfMentors());
    $this->assertEqual(0,$s5->numberOfMentors());
    $this->assertEqual(0,$s6->numberOfMentors());
  }   
  

  public function test_MentorNeverHasEnoughStudents()
  {
    $m = new MentorW("blah");
    
    $s = new StudentW(99);
    $s2 = new StudentW(98);
    $s3 = new StudentW(97);
    $s4 = new StudentW(96);
    $s5 = new StudentW(95);
    
    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    
    $s6 = new StudentW(94);
    $this->assertEqual(true,$m->addStudent($s6));
    
    $this->assertEqual(6, $m->numberOfStudents());
    $this->assertEqual(1,$s6->numberOfMentors());
  }    


  public function test_replaceMentor()
  {
    $m = new MentorW("blah");
    $m2 = new MentorW("blah2");
    $m3 = new MentorW("blah3");

    $s = new StudentW(99);
    $s2 = new StudentW(98);
    $s3 = new StudentW(97);
    $s4 = new StudentW(96);
    $s5 = new StudentW(95);
    
    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    $this->assertEqual(true,$s->setMentors(array($m2,$m3)));

    $this->assertEqual(4,$m->numberOfStudents());
    $this->assertEqual(1,$m2->numberOfStudents());
    $this->assertEqual(1,$m3->numberOfStudents());
    $this->assertEqual(2,$s->numberOfMentors());
  } 

  

  public function test_isNumberOfStudentsValid()
  {
    $m = new MentorW("blah");
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentW(99));
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentW(98));
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentW(97));
    $this->assertEqual(true,$m->isNumberOfStudentsValid());

  }
  

  public function test_getBoundsForStudent()
  {
    $this->assertEqual(3,MentorW::minimumNumberOfStudents());
  }  
  

  public function test_deleteMentorDeletesStudents()
  {
    $m = new MentorW("blah");
    $m2 = new MentorW("blah2");

    $s = new StudentW(99);
    $s2 = new StudentW(98);
    $s3 = new StudentW(97);
    $s4 = new StudentW(96);
    $s5 = new StudentW(95);
    
    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    $m2->setStudents(array($s,$s2,$s3,$s4,$s5));
    
    $p = new ProgramW();
    $s->setProgram($p);
    
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(null,$s->getProgram());
    $this->assertEqual(0,$s->numberOfMentors());
  }  


  public function test_deleteMentorDeletesStudentThatThenDeletesMentor()
  {
    $m = new MentorW("blah");
    $m2 = new MentorW("blah2");

    $s = new StudentW(99);
    $s2 = new StudentW(98);
    $s3 = new StudentW(97);
    $s4 = new StudentW(96);
    
    $m->setStudents(array($s,$s2,$s3,$s4));
    $m2->setStudents(array($s,$s2,$s3));
    
    $p = new ProgramW();
    $s->setProgram($p);
    
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(0,$m2->numberOfStudents());
    $this->assertEqual(null,$s->getProgram());
    $this->assertEqual(0,$s->numberOfMentors());
  }  


  public function test_deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    $m = new MentorW("blah");
    $m2 = new MentorW("blah2");

    $s = new StudentW(99);
    $s2 = new StudentW(98);
    $s3 = new StudentW(97);
    $s4 = new StudentW(96);
    $s5 = new StudentW(95);
    
    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    $m2->setStudents(array($s,$s2,$s3));
    
    $p = new ProgramW();
    $s->setProgram($p);
    
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(0,$m2->numberOfStudents());
    $this->assertEqual(0,$s->numberOfMentors());
  }  

}
