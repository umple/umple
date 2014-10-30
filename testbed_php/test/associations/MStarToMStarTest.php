<?php

class MStarToMStarTest extends UnitTestCase
{


  public function test_CreateStudentWithoutMentor()
  {
    $s = new StudentX(99);
    $this->assertEqual(0,$s->numberOfMentors());
  }
  

  public function test_CreateMentorWithoutStudent()
  {
    $m = new MentorX("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }
  

  public function test_SetStudentsJustEnough()
  {
    $m = new MentorX("blah");
    
    $s = new StudentX(99);
    $s2 = new StudentX(98);
    $s3 = new StudentX(97);
    $s4 = new StudentX(96);
    
    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3,$s4)));
    
    $this->assertEqual(4,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor_index(0));
    $this->assertEqual($m,$s2->getMentor_index(0));
    $this->assertEqual($m,$s3->getMentor_index(0));
    $this->assertEqual($m,$s4->getMentor_index(0));
  }  
  

  public function test_SetStudentsNeverAtMax()
  {
    $m = new MentorX("blah");
    
    $s = new StudentX(99);
    $s2 = new StudentX(98);
    $s3 = new StudentX(97);
    $s4 = new StudentX(96);
    $s5 = new StudentX(95);
    $s6 = new StudentX(94);
    $s7 = new StudentX(93);
    $s8 = new StudentX(92);
    $s9 = new StudentX(91);
    
    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3,$s4,$s5,$s6,$s7,$s8,$s9)));
    
    $this->assertEqual(9,$m->numberOfStudents());
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
    $m = new MentorX("blah");
    
    $s = new StudentX(99);
    
    $this->assertEqual(true,$m->addStudent($s));
    
    for ($i=2; $i<10; $i++)
    {
      $s2 = new StudentX($i);
      $this->assertEqual(true,$m->addStudent($s2));
      $this->assertEqual($i,$m->numberOfStudents());
      $this->assertEqual($m,$s2->getMentor_index(0));
    }
  }   
  

  public function test_RemoveMiddleStudentWhenNotValidMaintainsTheOrder()
  {
    $m = new MentorX("blah");
    
    $s = new StudentX(99);
    $s2 = new StudentX(98);
    $s3 = new StudentX(97);
    $s4 = new StudentX(96);


    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3,$s4)));
    $this->assertEqual(false,$m->removeStudent($s2));
    
    $this->assertEqual(4,$m->numberOfStudents());
//    $this->assertEqual($s2,$m->getStudent(1));
  } 
  

  public function test_RemoveStudents()
  {
    $m = new MentorX("blah");
    $m2 = new MentorX("blah2");
    $m3 = new MentorX("blah3");
    
    $s = new StudentX(99);
    $s2 = new StudentX(98);
    $s3 = new StudentX(97);
    $s4 = new StudentX(96);
    $s5 = new StudentX(95);
    $s6 = new StudentX(94);

    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    $m2->setStudents(array($s,$s2,$s3,$s4,$s5));
    $m3->setStudents(array($s,$s2,$s3,$s4,$s5));
    
    
    $this->assertEqual(false,$m->removeStudent($s6));
    $this->assertEqual(true,$m->removeStudent($s5));
    
    $this->assertEqual(2,$s5->numberOfMentors());
    $this->assertEqual(4,$m->numberOfStudents());
  } 
  

  public function test_SetStudentsTooFew()
  {
    $m = new MentorX("blah");
    
    $s = new StudentX(99);
    $s2 = new StudentX(98);
    $s3 = new StudentX(97);
    $s4 = new StudentX(96);
    $s5 = new StudentX(95);
    $s6 = new StudentX(94);
    
    $this->assertEqual(true,$m->setStudents(array($s,$s2,$s3)));
    
    $this->assertEqual(false,$m->setStudents(array($s4,$s5)));
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor_index(0));
    $this->assertEqual($m,$s2->getMentor_index(0));
    $this->assertEqual($m,$s3->getMentor_index(0));
    $this->assertEqual(0,$s4->numberOfMentors());
    $this->assertEqual(0,$s5->numberOfMentors());
    $this->assertEqual(0,$s6->numberOfMentors());
  }   
  

  public function test_MentorNeverHasEnoughStudents()
  {
    $m = new MentorX("blah");
    
    $s = new StudentX(99);
    $s2 = new StudentX(98);
    $s3 = new StudentX(97);
    $s4 = new StudentX(96);
    $s5 = new StudentX(95);
    
    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    
    $s6 = new StudentX(94);
    $this->assertEqual(true,$m->addStudent($s6));
    
    $this->assertEqual(6,$m->numberOfStudents());
    $this->assertEqual(1,$s6->numberOfMentors());
  }    


  public function test_replaceMentor()
  {
    $m = new MentorX("blah");
    $m2 = new MentorX("blah2");
    $m3 = new MentorX("blah3");

    $s = new StudentX(99);
    $s2 = new StudentX(98);
    $s3 = new StudentX(97);
    $s4 = new StudentX(96);
    $s5 = new StudentX(95);
    
    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    $this->assertEqual(true,$s->setMentors(array($m2,$m3)));

    $this->assertEqual(4,$m->numberOfStudents());
    $this->assertEqual(1,$m2->numberOfStudents());
    $this->assertEqual(1,$m3->numberOfStudents());
    $this->assertEqual(2,$s->numberOfMentors());
  } 

  

  public function test_isNumberOfStudentsValid()
  {
    $m = new MentorX("blah");
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentX(99));
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentX(98));
    $this->assertEqual(false,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentX(97));
    $this->assertEqual(true,$m->isNumberOfStudentsValid());

    $m->addStudent(new StudentX(96));
    $this->assertEqual(true,$m->isNumberOfStudentsValid());
  }
  

  public function test_getBoundsForStudent()
  {
    $this->assertEqual(3,MentorX::minimumNumberOfStudents());
  }  
  

  public function test_deleteMentorAndStudentHasEnough()
  {
    
    $m = new MentorX("blah");
    $m2 = new MentorX("blah2");
    $m3 = new MentorX("blah2");

    $s = new StudentX(99);
    $s2 = new StudentX(98);
    $s3 = new StudentX(97);
    $s4 = new StudentX(96);
    $s5 = new StudentX(95);
    
    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    $m2->setStudents(array($s,$s2,$s3,$s4,$s5));
    $m3->setStudents(array($s,$s2,$s3,$s4,$s5));
    
    $p = new ProgramX();
    $s->setProgram($p);
    
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual($p,$s->getProgram());
    $this->assertEqual(2,$s->numberOfMentors());
  }  


  public function test_deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    $m = new MentorX("blah");
    $m2 = new MentorX("blah2");

    $s = new StudentX(99);
    $s2 = new StudentX(98);
    $s3 = new StudentX(97);
    $s4 = new StudentX(96);
    $s5 = new StudentX(95);
    
    $m->setStudents(array($s,$s2,$s3,$s4,$s5));
    $m2->setStudents(array($s,$s2,$s3));
    
    $p = new ProgramX();
    $s->setProgram($p);
    
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(0,$m2->numberOfStudents());
    $this->assertEqual(0,$s->numberOfMentors());
  }  

}
?>
