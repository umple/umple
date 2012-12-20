<?php

class MNToMNTest extends UnitTestCase
{


  public function test_CreateStudentWithoutMentor()
  {
    $s = new StudentS(99);
    $this->assertEqual(0,$s->numberOfMentors());
  }
  

  public function test_CreateMentorWithoutStudent()
  {
    $m = new MentorS("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }
  

  public function test_SetStudentsJustEnough()
  {
    $m = new MentorS("blah");
    
    $s = new StudentS(99);
    $s2 = new StudentS(98);
    $s3 = new StudentS(97);
    
    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3)));
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
  }  
  

  public function test_SetStudentsAtMax()
  {
    $m = new MentorS("blah");
    
    $s = new StudentS(99);
    $s2 = new StudentS(98);
    $s3 = new StudentS(97);
    $s4 = new StudentS(96);
    $s5 = new StudentS(95);
    
    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3,$s4,$s5)));
    
    $this->assertEqual(5,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
    $this->assertEqual($m,$s4->getMentor(0));
    $this->assertEqual($m,$s5->getMentor(0));
  }   
  

  public function test_AddStudents()
  {
    $m = new MentorS("blah");
    
    $s = new StudentS(99);
    $s2 = new StudentS(98);
    $s3 = new StudentS(97);
    $s4 = new StudentS(96);
    $s5 = new StudentS(95);
    $s6 = new StudentS(94);

    $this->assertEqual(true,$m->addStudent($s));
    $this->assertEqual(true,$m->addStudent($s2));
    $this->assertEqual(true,$m->addStudent($s3));
    $this->assertEqual(true,$m->addStudent($s4));
    $this->assertEqual(true,$m->addStudent($s5));
    $this->assertEqual(false,$m->addStudent($s6));
    
    $this->assertEqual(5,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
    $this->assertEqual($m,$s4->getMentor(0));
    $this->assertEqual($m,$s5->getMentor(0));
    $this->assertEqual(0,$s6->numberOfMentors());
  }   
  

  public function test_RemoveMiddleStudentWhenNotValidMaintainsTheOrder()
  {
    $m = new MentorS("blah");
    
    $s = new StudentS(99);
    $s2 = new StudentS(98);
    $s3 = new StudentS(97);


    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3)));
    $this->assertEqual(false,$m->removeStudent($s2));
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($s2,$m->getStudent(1));
  } 
  

  public function test_RemoveStudents()
  {
    $m = new MentorS("blah");
    $m2 = new MentorS("blah2");
    $m3 = new MentorS("blah3");
    
    $s = new StudentS(99);
    $s2 = new StudentS(98);
    $s3 = new StudentS(97);
    $s4 = new StudentS(96);
    $s5 = new StudentS(95);
    $s6 = new StudentS(94);

    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    $m2->setStudents(array($s,$s2,$s3,$s4,$s5));
    $m3->setStudents(array($s,$s2,$s3,$s4,$s5));
    
    
    $this->assertEqual(false,$m->removeStudent($s6));
    $this->assertEqual(true,$m->removeStudent($s5));
    
    $this->assertEqual(2,$s5->numberOfMentors());
    $this->assertEqual(4,$m->numberOfStudents());
  } 
  

  public function test_SetStudentsTooManyAndTooFew()
  {
    $m = new MentorS("blah");
    
    $s = new StudentS(99);
    $s2 = new StudentS(98);
    $s3 = new StudentS(97);
    $s4 = new StudentS(96);
    $s5 = new StudentS(95);
    $s6 = new StudentS(94);
    
    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3)));
    
    $this->assertEqual(false,$m->setStudents(array($s4,$s5)));
    $this->assertEqual(false,$m->setStudents(array($s4,$s5,$s,$s2,$s3,$s6)));
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
    $this->assertEqual(0,$s4->numberOfMentors());
    $this->assertEqual(0,$s5->numberOfMentors());
    $this->assertEqual(0,$s6->numberOfMentors());
  }   
  

  public function test_MentorAlreadyHasEnoughStudents()
  {
    $m = new MentorS("blah");
    
    $s = new StudentS(99);
    $s2 = new StudentS(98);
    $s3 = new StudentS(97);
    $s4 = new StudentS(96);
    $s5 = new StudentS(95);
    
    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    
    $s6 = new StudentS(94);
    $this->assertEqual(false,$m->addStudent($s6));
    
    $this->assertEqual(5,$m->numberOfStudents());
    $this->assertEqual(0,$s6->numberOfMentors());
  }    


  public function test_replaceMentor()
  {
    $m = new MentorS("blah");
    $m2 = new MentorS("blah2");
    $m3 = new MentorS("blah3");

    $s = new StudentS(99);
    $s2 = new StudentS(98);
    $s3 = new StudentS(97);
    $s4 = new StudentS(96);
    $s5 = new StudentS(95);
    
    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    $this->assertEqual(true,$s->setMentors(array($m2,$m3)));

    $this->assertEqual(4,$m->numberOfStudents());
    $this->assertEqual(1,$m2->numberOfStudents());
    $this->assertEqual(1,$m3->numberOfStudents());
    $this->assertEqual(2,$s->numberOfMentors());
  } 

  

  public function test_isNumberOfStudentsValid()
  {
    $m = new MentorS("blah");
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentS(99));
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentS(98));
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentS(97));
    $this->assertEqual(true,$m->isNumberOfStudentsValid());

  }
  

  public function test_getBoundsForStudent()
  {
    $this->assertEqual(3,MentorS::minimumNumberOfStudents());
    $this->assertEqual(5,MentorS::maximumNumberOfStudents());
  }  
  

  public function test_deleteMentorAndStudentHasEnough()
  {
    
    $m = new MentorS("blah");
    $m2 = new MentorS("blah2");
    $m3 = new MentorS("blah3");

    $s = new StudentS(99);
    $s2 = new StudentS(98);
    $s3 = new StudentS(97);
    $s4 = new StudentS(96);
    $s5 = new StudentS(95);
    
    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    $m2->setStudents(array($s,$s2,$s3,$s4,$s5));
    $m3->setStudents(array($s,$s2,$s3,$s4,$s5));
    
    $p = new ProgramS();
    $s->setProgram($p);
    
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual($p,$s->getProgram());
    $this->assertEqual(2,$s->numberOfMentors());
  }  


  public function test_deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    $m = new MentorS("blah");
    $m2 = new MentorS("blah2");

    $s = new StudentS(99);
    $s2 = new StudentS(98);
    $s3 = new StudentS(97);
    $s4 = new StudentS(96);
    $s5 = new StudentS(95);
    
    $m->setStudents($s,$s2,$s3,$s4,$s5);
    $m2->setStudents($s,$s2,$s3);
    
    $p = new ProgramS();
    $s->setProgram($p);
    
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(0,$m2->numberOfStudents());
    $this->assertEqual(0,$s->numberOfMentors());
  }  

}
?>