<?php

class ManyToMNTest extends UnitTestCase
{


  public function test_CreateStudentWithoutMentor()
  {
    $s = new StudentO(99);
    $this->assertEqual(0,$s->numberOfMentors());
  }
  
  public function test_ConstructorWithTooFew()
  {
  	$this->expectException(new Exception("Unable to create MentorO, must have 2 to 4 students"));
    $s = new StudentO(99);
    new MentorO("blah",array($s));
  }

  public function test_ConstructorWithTooMany()
  {
  	$this->expectException(new Exception("Unable to create MentorO, must have 2 to 4 students"));
    $s = new StudentO(99);
    $s2 = new StudentO(98);    
    $s3 = new StudentO(97);
    $s4 = new StudentO(96);
    $s5 = new StudentO(95);
    new MentorO("blah",array($s,$s2,$s3,$s4,$s5));
  }
  
  

  public function test_constructorJustBigEnough()
  {
    $s = new StudentO(99);
    $s2 = new StudentO(98);

    $m = new MentorO("blah",array($s,$s2));

    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
  }
  

  public function test_constructorJustSmallEnough()
  {
    $s = new StudentO(99);
    $s2 = new StudentO(98);    
    $s3 = new StudentO(97);
    $s4 = new StudentO(96);

    $m = new MentorO("blah",array($s,$s2,$s3,$s4));

    $this->assertEqual(4,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
    $this->assertEqual($m,$s4->getMentor(0));
  }  


  public function test_constructorWatchOutForDuplicateEntries()
  {
  	$this->expectException(new Exception("Unable to create MentorO, must have 2 to 4 students"));
    $s = new StudentO(99);
    new MentorO("blah",array($s, $s));
  }
  

  public function test_constructorExistingMentorsOkay()
  {
    $s1 = new StudentO(99);
    $s2 = new StudentO(98);
    $s3 = new StudentO(97);
    
    $m = new MentorO("blah",array($s1,$s2));

    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m, $s1->getMentor(0));
    $this->assertEqual($m, $s2->getMentor(0));
    $this->assertEqual(0, $s3->numberOfMentors());    

    $m2 = new MentorO("blah2",array($s1,$s2,$s3));
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m, $s1->getMentor(0));
    $this->assertEqual($m, $s2->getMentor(0));
    
    $this->assertEqual(3,$m2->numberOfStudents());
    $this->assertEqual($m2, $s1->getMentor(1));
    $this->assertEqual($m2, $s2->getMentor(1));
    $this->assertEqual($m2, $s3->getMentor(0));

  }   
  

  public function test_setStudents_outsideNM()
  {
    $s = new StudentO(99);
    $s2 = new StudentO(98);    
    $s3 = new StudentO(97);
    $s4 = new StudentO(96);
    $s5 = new StudentO(95);

    $m = new MentorO("blah",array($s, $s2));
    
    $this->assertEqual(false,$m->setStudents(array($s2, $s3, $s4, $s5, $s)));
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual(0,$s3->numberOfMentors());
    $this->assertEqual(0,$s4->numberOfMentors());
    $this->assertEqual(0,$s5->numberOfMentors());

    $this->assertEqual(false,$m->setStudents($s5));
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual(0,$s3->numberOfMentors());
    $this->assertEqual(0,$s4->numberOfMentors());
    $this->assertEqual(0,$s5->numberOfMentors());
    
    
  }


  public function test_setStudents_doNotAllowDuplicatesNM()
  {
    $s = new StudentO(99);
    $s2 = new StudentO(98);    
    $s3 = new StudentO(97);

    $m = new MentorO("blah",array($s, $s2));
    $this->assertEqual(false,$m->setStudents(array($s2, $s2, $s3)));
  }


  public function test_setStudents_withinNM()
  {
    $s = new StudentO(99);
    $s2 = new StudentO(98);    
    $s3 = new StudentO(97);
    $s4 = new StudentO(96);

    $m = new MentorO("blah",array($s, $s2));
    
    $this->assertEqual(true,$m->setStudents(array($s2, $s3, $s4)));
    $this->assertEqual(3,$m->numberOfStudents());

    $this->assertEqual(0,$s->numberOfMentors());

    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
    $this->assertEqual($m,$s4->getMentor(0));    
  }
  

  public function test_addMentorTooMany()
  {
    $s = new StudentO(99);
    $s2 = new StudentO(98);    
    $s3 = new StudentO(97);
    $s4 = new StudentO(96);
    $s5 = new StudentO(95);

    $m = new MentorO("blah",array($s,$s2,$s3,$s4));
    
    $this->assertEqual(false,$s5->addMentor($m));
    $this->assertEqual(4,$m->numberOfStudents());
    $this->assertEqual(0,$s5->numberOfMentors());
    
  }


  public function test_addMentorOkay()
  {
    $s = new StudentO(99);
    $s2 = new StudentO(98);    
    $s3 = new StudentO(97);
    $s5 = new StudentO(96);

    $m = new MentorO("blah",array($s,$s2,$s3));
    
    $this->assertEqual(true,$s5->addMentor($m));
    $this->assertEqual(4,$m->numberOfStudents());
    $this->assertEqual(1,$s5->numberOfMentors());
    
  }
  
  

  public function test_addStudent()
  {
    $s = new StudentO(99);
    $s2 = new StudentO(98);    
    $s3 = new StudentO(97);
    $s4 = new StudentO(96);
    $s5 = new StudentO(95);

    $m = new MentorO("blah",array($s,$s2,$s3));
    
    $this->assertEqual(true,$m->addStudent($s4));
    
    $this->assertEqual(4,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
    $this->assertEqual($m,$s4->getMentor(0));    
   
    $this->assertEqual(false,$m->addStudent($s5));
    $this->assertEqual(4,$m->numberOfStudents());
  
  }  


  public function test_addStudentHasExistingMentor()
  {
    $s = new StudentO(99);
    $s2 = new StudentO(98);    
    $s3 = new StudentO(97);
    $s4 = new StudentO(96);
    $s5 = new StudentO(95);
    $s6 = new StudentO(94);

    $m = new MentorO("blah",array($s,$s2,$s3));
    $m2 = new MentorO("blah2",array($s4,$s5,$s6));

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

    $this->assertEqual(false,$m->addStudent($s5));
  }  


  public function test_removeStudent()
  {
    $s = new StudentO(99);
    $s2 = new StudentO(98);    
    $s3 = new StudentO(97);
    $s4 = new StudentO(96);

    $m = new MentorO("blah",array($s,$s2,$s3));
    
    $this->assertEqual(false,$m->removeStudent($s4));
    $this->assertEqual(true,$m->removeStudent($s3));
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual(0,$s3->numberOfMentors());
    $this->assertEqual(0,$s4->numberOfMentors());    

    $this->assertEqual(false,$m->removeStudent($s2));
    $this->assertEqual(2,$m->numberOfStudents());
  }  
  
  
  
  

  public function test_setStudents_empty()
  {
    $s = new StudentO(99);
    $s2 = new StudentO(98);
    $s3 = new StudentO(97);
    $m = new MentorO("blah",array($s,$s2,$s3));

    $this->assertEqual(false,$m->setStudents(array()));
    $this->assertEqual(3,$m->numberOfStudents());
  }
  

  public function test_deletStudentDeletesTheMentorIfNotEnoughLeft()
  {
    $s1 = new StudentO(99);
    $s2 = new StudentO(98);

    $m = new MentorO("blah",array($s1,$s2));
    $studentP = new ProgramO();
    $mentorP = new ProgramO();
    
    $s2->setProgram($studentP);
    $m->setProgram($mentorP);

    $s1->delete();
    
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(null,$m->getProgram());
    $this->assertEqual(null,$mentorP->getMentor());
    $this->assertEqual($studentP,$s2->getProgram());
    $this->assertEqual(0,$s1->numberOfMentors());
  }  
  

  public function test_deleteStudentLeavesMentorAloneIfHasEnough()
  {
    $s1 = new StudentO(99);
    $s2 = new StudentO(98);
    $s3 = new StudentO(97);

    $m = new MentorO("blah",array($s1,$s2,$s3));
    $studentP = new ProgramO();
    $mentorP = new ProgramO();
    
    $s2->setProgram($studentP);
    $m->setProgram($mentorP);

    $s1->delete();
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($mentorP,$m->getProgram());
    $this->assertEqual($m,$mentorP->getMentor());
    $this->assertEqual($studentP,$s2->getProgram());
    $this->assertEqual(0,$s1->numberOfMentors());
  } 
  
}
?>