<?php

class MNToMStarTest extends UnitTestCase
{


  public function test_CreateStudentWithoutMentor()
  {
    $s = new StudentU(99);
    $this->assertEqual(0,$s->numberOfMentors());
  }
  

  public function test_CreateMentorWithoutStudent()
  {
    $m = new MentorU("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }
  

  public function test_SetStudentsJustEnough()
  {
    $m = new MentorU("blah");
    
    $s = new StudentU(99);
    $s2 = new StudentU(98);
    $s3 = new StudentU(97);
    $s4 = new StudentU(96);
    
    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3,$s4)));
    
    $this->assertEqual(4, $m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
    $this->assertEqual($m,$s4->getMentor(0));
  }  
  

  public function test_SetStudentsNeverAtMax()
  {
    $m = new MentorU("blah");
    
    $s = new StudentU(99);
    $s2 = new StudentU(98);
    $s3 = new StudentU(97);
    $s4 = new StudentU(96);
    $s5 = new StudentU(95);
    $s6 = new StudentU(94);
    $s7 = new StudentU(93);
    $s8 = new StudentU(92);
    $s9 = new StudentU(91);
    
    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3,$s4,$s5,$s6,$s7,$s8,$s9)));
    
    $this->assertEqual(9, $m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
    $this->assertEqual($m,$s4->getMentor(0));
    $this->assertEqual($m,$s5->getMentor(0));
    $this->assertEqual($m,$s6->getMentor(0));
    $this->assertEqual($m,$s7->getMentor(0));
    $this->assertEqual($m,$s8->getMentor(0));
    $this->assertEqual($m,$s9->getMentor(0));
  }   
  

  public function test_AddStudents()
  {
    $m = new MentorU("blah");
    
    $s = new StudentU(99);
    
    $this->assertEqual(true,$m->addStudent($s));
    
    for ($i=2; $i<10; $i++)
    {
      $s2 = new StudentU($i);
      $this->assertEqual(true,$m->addStudent($s2));
      $this->assertEqual($i,$m->numberOfStudents());
      $this->assertEqual($m,$s2->getMentor(0));
    }
  }   
  

  public function test_RemoveMiddleStudentWhenNotValidMaintainsTheOrder()
  {
    $m = new MentorU("blah");
    
    $s = new StudentU(99);
    $s2 = new StudentU(98);
    $s3 = new StudentU(97);
    $s4 = new StudentU(96);


    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3,$s4)));
    $this->assertEqual(false,$m->removeStudent($s2));
    
    $this->assertEqual(4, $m->numberOfStudents());
    $this->assertEqual($s2,$m->getStudent(1));
  } 
  

  public function test_RemoveStudents()
  {
    $m = new MentorU("blah");
    $m2 = new MentorU("blah2");
    $m3 = new MentorU("blah3");
    
    $s = new StudentU(99);
    $s2 = new StudentU(98);
    $s3 = new StudentU(97);
    $s4 = new StudentU(96);
    $s5 = new StudentU(95);
    $s6 = new StudentU(94);

    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    $m2->setStudents(array($s,$s2,$s3,$s4,$s5));
    $m3->setStudents(array($s,$s2,$s3,$s4,$s5));
    
    
    $this->assertEqual(false,$m->removeStudent($s6));
    $this->assertEqual(true,$m->removeStudent($s5));
    
    $this->assertEqual(2,$s5->numberOfMentors());
    $this->assertEqual(4, $m->numberOfStudents());
  } 
  

  public function test_SetStudentsTooManyAndTooFew()
  {
    $m = new MentorU("blah");
    
    $s = new StudentU(99);
    $s2 = new StudentU(98);
    $s3 = new StudentU(97);
    $s4 = new StudentU(96);
    $s5 = new StudentU(95);
    $s6 = new StudentU(94);
    
    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3,$s4)));
    
    $this->assertEqual(false,$m->setStudents(array($s4,$s5,$s3)));
    
    $this->assertEqual(4, $m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
    $this->assertEqual($m,$s4->getMentor(0));
    $this->assertEqual(0,$s5->numberOfMentors());
    $this->assertEqual(0,$s6->numberOfMentors());
  }   
  

  public function test_MentorNeverHasEnoughStudents()
  {
    $m = new MentorU("blah");
    
    $s = new StudentU(99);
    $s2 = new StudentU(98);
    $s3 = new StudentU(97);
    $s4 = new StudentU(96);
    $s5 = new StudentU(95);
    
    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    
    $s6 = new StudentU(94);
    $this->assertEqual(true,$m->addStudent($s6));
    
    $this->assertEqual(6, $m->numberOfStudents());
    $this->assertEqual(1,$s6->numberOfMentors());
  }    


  public function test_replaceMentor()
  {
    $m = new MentorU("blah");
    $m2 = new MentorU("blah2");
    $m3 = new MentorU("blah3");

    $s = new StudentU(99);
    $s2 = new StudentU(98);
    $s3 = new StudentU(97);
    $s4 = new StudentU(96);
    $s5 = new StudentU(95);
    
    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    $this->assertEqual(true,$s->setMentors(array($m2,$m3)));

    $this->assertEqual(4,$m->numberOfStudents());
    $this->assertEqual(1,$m2->numberOfStudents());
    $this->assertEqual(1,$m3->numberOfStudents());
    $this->assertEqual(2,$s->numberOfMentors());
  } 

  

  public function test_isNumberOfStudentsValid()
  {
    $m = new MentorU("blah");
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentU(99));
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentU(98));
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentU(97));
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentU(96));
    $this->assertEqual(true,$m->isNumberOfStudentsValid());
  }
  

  public function test_getBoundsForStudent()
  {
    $this->assertEqual(4,MentorU::minimumNumberOfStudents());
  }  
  

  public function test_deleteMentorAndStudentHasEnough()
  {
    
    $m = new MentorU("blah");
    $m2 = new MentorU("blah2");
    $m3 = new MentorU("blah2");

    $s = new StudentU(99);
    $s2 = new StudentU(98);
    $s3 = new StudentU(97);
    $s4 = new StudentU(96);
    $s5 = new StudentU(95);
    
    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    $m2->setStudents(array($s,$s2,$s3,$s4,$s5));
    $m3->setStudents(array($s,$s2,$s3,$s4,$s5));
    
    $p = new ProgramU();
    $s->setProgram($p);
    
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual($p,$s->getProgram());
    $this->assertEqual(2,$s->numberOfMentors());
  }  


  public function test_deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    $m = new MentorU("blah");
    $m2 = new MentorU("blah2");

    $s = new StudentU(99);
    $s2 = new StudentU(98);
    $s3 = new StudentU(97);
    $s4 = new StudentU(96);
    $s5 = new StudentU(95);
    
    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    $m2->setStudents(array($s,$s2,$s3));
    
    $p = new ProgramU();
    $s->setProgram($p);
    
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(0,$m2->numberOfStudents());
    $this->assertEqual(0,$s->numberOfMentors());
  }  

}
?>