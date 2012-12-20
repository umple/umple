<?php

class ManyToMStarTest extends UnitTestCase
{


  public function test_CreateStudentWithoutMentor()
  {
    $s = new StudentR(99);
    $this->assertEqual(0,$s->numberOfMentors());
  }
  
  public function test_ConstructorWithTooFew()
  {
  	$this->expectException(new Exception("Unable to create MentorR, must have at least 3 students"));
    $s = new StudentR(99);
    new MentorR("blah",array($s));
  }


  public function test_ConstructorCannotHaveTooMany()
  {
    $s = new StudentR(99);
    $s2 = new StudentR(98);    
    $s3 = new StudentR(97);
    $s4 = new StudentR(96);
    $s5 = new StudentR(95);
    $s6 = new StudentR(94);
    $s7 = new StudentR(93);
    $s8 = new StudentR(92);
    new MentorR("blah",array($s,$s2,$s3,$s4,$s5,$s6,$s7,$s8));
  }
  
  

  public function test_constructorJustBigEnough()
  {
    $s = new StudentR(99);
    $s2 = new StudentR(98);    
    $s3 = new StudentR(97);

    $m = new MentorR("blah",array($s,$s2,$s3));

    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
  }
  

  public function test_constructorMoreThanBigEnough()
  {
    $s = new StudentR(99);
    $s2 = new StudentR(98);    
    $s3 = new StudentR(97);
    $s4 = new StudentR(96);

    $m = new MentorR("blah",array($s,$s2,$s3,$s4));

    $this->assertEqual(4,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
    $this->assertEqual($m,$s4->getMentor(0));
  }  


  public function test_constructorWatchOutForDuplicateEntries()
  {
  	$this->expectException(new Exception("Unable to create MentorR, must have at least 3 students"));
    $s = new StudentR(99);
    new MentorR("blah",array($s,$s));
  }
  

  public function test_constructorExistingMentorsOkay()
  {
    $s = new StudentR(99);
    $s2 = new StudentR(98);    
    $s3 = new StudentR(97);
    $s4 = new StudentR(96);
    
    $m = new MentorR("blah",array($s,$s2,$s3));

    $this->assertEqual(3, $m->numberOfStudents());
    $this->assertEqual($m, $s->getMentor(0));
    $this->assertEqual($m, $s2->getMentor(0));
    $this->assertEqual($m, $s3->getMentor(0));
    $this->assertEqual(0, $s4->numberOfMentors());    

    $m2 = new MentorR("blah",array($s,$s2,$s4));
    
    $this->assertEqual(3, $m->numberOfStudents());
    $this->assertEqual($m, $s->getMentor(0));
    $this->assertEqual($m, $s2->getMentor(0));
    $this->assertEqual($m, $s3->getMentor(0));
    
    $this->assertEqual(3, $m2->numberOfStudents());
    $this->assertEqual($m2, $s->getMentor(1));
    $this->assertEqual($m2, $s2->getMentor(1));
    $this->assertEqual($m2, $s4->getMentor(0));

  }   
  

  public function test_setStudents_tooFew()
  {
    $s = new StudentR(99);
    $s2 = new StudentR(98);    
    $s3 = new StudentR(97);
    $s4 = new StudentR(96);
    $s5 = new StudentR(95);

    $m = new MentorR("blah",array($s,$s2,$s3));
    
    $this->assertEqual(false, $m->setStudents(array($s5,$s4)));
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
    $this->assertEqual(0,$s4->numberOfMentors());
    $this->assertEqual(0,$s5->numberOfMentors());
    
    
  }


  public function test_setStudents_doNotAllowDuplicates()
  {
    $s = new StudentR(99);
    $s2 = new StudentR(98);    
    $s3 = new StudentR(97);
    
    $m = new MentorR("blah",array($s,$s2,$s3));
    $this->assertEqual(false, $m->setStudents($s2,$s2,$s3));
  }


  public function test_setStudents_aboveMinimum()
  {
    $s = new StudentR(99);
    $s2 = new StudentR(98);    
    $s3 = new StudentR(97);
    $s4 = new StudentR(96);

    $m = new MentorR("blah",array($s,$s2,$s3));
    
    $this->assertEqual(true, $m->setStudents(array($s2,$s3,$s4)));
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual(0,$s->numberOfMentors());

    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
    $this->assertEqual($m,$s4->getMentor(0));    
  }
  

  public function test_addMentorNeverTooMany()
  {
    $s = new StudentR(99);
    $s2 = new StudentR(98);    
    $s3 = new StudentR(97);
    $s4 = new StudentR(96);
    $s5 = new StudentR(95);

    $m = new MentorR("blah",array($s,$s2,$s3,$s4));
    
    $this->assertEqual(true,$s5->addMentor($m));
    $this->assertEqual(5,$m->numberOfStudents());
    $this->assertEqual(1,$s5->numberOfMentors());
    
  }
  

  public function test_addStudent()
  {
    $s = new StudentR(99);
    $s2 = new StudentR(98);    
    $s3 = new StudentR(97);
    $s4 = new StudentR(96);
    $s5 = new StudentR(95);

    $m = new MentorR("blah",array($s,$s2,$s3));

    $this->assertEqual(true,$m->addStudent($s4));
    
    $this->assertEqual(4,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
    $this->assertEqual($m,$s4->getMentor(0));    
   
    $this->assertEqual(true,$m->addStudent($s5));
    $this->assertEqual(5,$m->numberOfStudents());
  
  }  


  public function test_addStudentHasExistingMentor()
  {
    $s = new StudentR(99);
    $s2 = new StudentR(98);    
    $s3 = new StudentR(97);
    $s4 = new StudentR(96);
    $s5 = new StudentR(95);
    $s6 = new StudentR(94);

    $m = new MentorR("blah",array($s,$s2,$s3));
    $m2 = new MentorR("blah2",array($s4,$s5,$s6));

    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
    
    $this->assertEqual($m2,$s4->getMentor(0));
    $this->assertEqual($m2,$s5->getMentor(0));
    $this->assertEqual($m2,$s6->getMentor(0));
    
    $this->assertEqual(true,$m->addStudent($s4));
    
    $this->assertEqual(4,$m->numberOfStudents());
    $this->assertEqual(3,$m2->numberOfStudents());
    
    $this->assertEqual(2,$s4->numberOfMentors());    
    $this->assertEqual($m2,$s4->getMentor(0));    
    $this->assertEqual($m,$s4->getMentor(1));

    $this->assertEqual(true,$m->addStudent($s5));
  }  


  public function test_removeStudent()
  {
    $s = new StudentR(99);
    $s2 = new StudentR(98);    
    $s3 = new StudentR(97);
    $s4 = new StudentR(96);
    $s5 = new StudentR(95);

    $m = new MentorR("blah",array($s,$s2,$s3,$s5));
    
    $this->assertEqual(false,$m->removeStudent($s4));
    $this->assertEqual(true,$m->removeStudent($s3));
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual(0,$s3->numberOfMentors());
    $this->assertEqual(0,$s4->numberOfMentors());   
    $this->assertEqual($m,$s5->getMentor(0));

    $this->assertEqual(false,$m->removeStudent($s2));
    $this->assertEqual(3,$m->numberOfStudents());
  }  
  

  public function test_setStudents_empty()
  {
    $s = new StudentR(99);
    $s2 = new StudentR(98);    
    $s3 = new StudentR(97);

    $m = new MentorR("blah",array($s,$s2,$s3));

    $this->assertEqual(false, $m->setStudents(array()));
    $this->assertEqual(3,$m->numberOfStudents());
  }
  

  public function test_deletStudentDeletesTheMentorIfNotEnoughLeft()
  {
    $s = new StudentR(99);
    $s2 = new StudentR(98);    
    $s3 = new StudentR(97);

    $m = new MentorR("blah",array($s,$s2,$s3));
    $studentP = new ProgramR();
    $mentorP = new ProgramR();
    
    $s2->setProgram($studentP);
    $m->setProgram($mentorP);

    $s->delete();
    
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(null,$m->getProgram());
    $this->assertEqual(null,$mentorP->getMentor());
    $this->assertEqual($studentP,$s2->getProgram());
    $this->assertEqual(0,$s->numberOfMentors());
  }  
  

  public function test_deleteStudentLeavesMentorAloneIfHasEnough()
  {
    $s = new StudentR(99);
    $s2 = new StudentR(98);    
    $s3 = new StudentR(97);
    $s4 = new StudentR(96);

    $m = new MentorR("blah",array($s,$s2,$s3,$s4));
    $studentP = new ProgramR();
    $mentorP = new ProgramR();
    
    $s2->setProgram($studentP);
    $m->setProgram($mentorP);

    $s->delete();
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($mentorP,$m->getProgram());
    $this->assertEqual($m,$mentorP->getMentor());
    $this->assertEqual($studentP,$s2->getProgram());
    $this->assertEqual(0,$s->numberOfMentors());
  } 

  
  
}
