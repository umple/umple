<?php

class OptionalOneToMStarTest extends UnitTestCase
{


  public function test_CreateStudentWithoutMentor()
  {
    $s = new StudentF();
    $this->assertEqual(null,$s->getMentor());
  }
  

  public function test_ConstructorWithTooFew()
  {
  	$this->expectException(new Exception("Unable to create MentorF, must have at least 2 students"));
    $s = new StudentF();
    new MentorF(array($s));
  }
  
  

  public function test_constructorJustBigEnough()
  {
    $s = new StudentF();
    $s2 = new StudentF();

    $m = new MentorF(array($s,$s2));

    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual($m,$s2->getMentor());
  }
  

  public function test_constructorWatchOutForDuplicateEntries()
  {
  	$this->expectException(new Exception("Unable to create MentorF, must have at least 2 students"));
    $s = new StudentF();
    new MentorF(array($s, $s));
  }
  
  public function test_constructorCheckForExistingMentorNotEnoughToSurvive()
  {
  	$this->expectException(new Exception("Unable to create MentorF, must have at least 2 students"));
    $s1 = new StudentF();
    $s2 = new StudentF();
    $s3 = new StudentF();
    $s4 = new StudentF();
    
    $m = new MentorF(array($s1,$s2,$s3));

    $this->assertEqual(3, $m->numberOfStudents());
    $this->assertEqual($m, $s1->getMentor());
    $this->assertEqual($m, $s2->getMentor());
    $this->assertEqual($m, $s3->getMentor());    
    $this->assertEqual(null, $s4->getMentor());    

    new MentorF(array($s1,$s2,$s4));
  }   
  

  public function test_constructorCheckForExistingMentorFnoughToShare()
  {
    $s1 = new StudentF();
    $s2 = new StudentF();
    $s3 = new StudentF();
    $s4 = new StudentF();
    $s5 = new StudentF();
    
    $m = new MentorF(array($s1,$s2,$s3));

    $this->assertEqual(3, $m->numberOfStudents());
    $this->assertEqual($m, $s1->getMentor());
    $this->assertEqual($m, $s2->getMentor());
    $this->assertEqual($m, $s3->getMentor());    
    $this->assertEqual(null, $s4->getMentor());    
    $this->assertEqual(null, $s5->getMentor());

    $m2 = new MentorF(array($s2,$s4,$s5));

    $this->assertEqual(2, $m->numberOfStudents());
    $this->assertEqual(3, $m2->numberOfStudents());
    $this->assertEqual($m, $s1->getMentor());
    $this->assertEqual($m2, $s2->getMentor());
    $this->assertEqual($m, $s3->getMentor());    
    $this->assertEqual($m2, $s4->getMentor());    
    $this->assertEqual($m2, $s5->getMentor());
  }   
  
  

  public function test_setStudents_lessThanM()
  {
    $s = new StudentF();
    $s2 = new StudentF();    
    $s3 = new StudentF();
    $s4 = new StudentF();
    $s5 = new StudentF();
    $s6 = new StudentF();

    $m = new MentorF(array($s, $s2));
    
    $this->assertEqual(false, $m->setStudents(array($s)));
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual($m,$s2->getMentor());
    $this->assertEqual(null,$s3->getMentor());
    $this->assertEqual(null,$s4->getMentor());    
    $this->assertEqual(null,$s5->getMentor());    
    $this->assertEqual(null,$s6->getMentor());    

  }


  public function test_setStudents_aLot()
  {
    $allStudents = array();
    
    for ($i=0; $i<100; $i++)
    {
      $allStudents[] = new StudentF();
    }
    
    $m = new MentorF($allStudents);
    $this->assertEqual(100,$m->numberOfStudents());
  }
  
  

  public function test_setStudents_atLeastM()
  {
    $s = new StudentF();
    $s2 = new StudentF();    
    $s3 = new StudentF();
    $s4 = new StudentF();

    $m = new MentorF(array($s, $s2));
    
    $this->assertEqual(true, $m->setStudents(array($s2, $s3, $s4)));
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual(null,$s->getMentor());
    $this->assertEqual($m,$s2->getMentor());
    $this->assertEqual($m,$s3->getMentor());
    $this->assertEqual($m,$s4->getMentor());    
  }
  

  public function test_addStudent()
  {
    $s = new StudentF();
    $s2 = new StudentF();    
    $s3 = new StudentF();
    $s4 = new StudentF();
    $s5 = new StudentF();
    $s6 = new StudentF();

    $m = new MentorF(array($s,$s2,$s3,$s4));

    $this->assertEqual(true,$m->addStudent($s5));
    
    $this->assertEqual(5,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual($m,$s2->getMentor());
    $this->assertEqual($m,$s3->getMentor());
    $this->assertEqual($m,$s4->getMentor());    
    $this->assertEqual($m,$s5->getMentor());    

    $this->assertEqual(true,$m->addStudent($s6));
    $this->assertEqual(6,$m->numberOfStudents());
  
  }  


  public function test_addStudentHasExistingMentor()
  {
    $s = new StudentF();
    $s2 = new StudentF();    
    $s3 = new StudentF();
    $s4 = new StudentF();
    $s5 = new StudentF();
    $s6 = new StudentF();

    $m = new MentorF(array($s,$s2,$s3));
    $m2 = new MentorF(array($s4,$s5,$s6));
    
    $this->assertEqual(true,$m->addStudent($s4));
    
    $this->assertEqual(4,$m->numberOfStudents());
    $this->assertEqual(2,$m2->numberOfStudents());
    
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual($m,$s2->getMentor());
    $this->assertEqual($m,$s3->getMentor());
    $this->assertEqual($m,$s4->getMentor());    
    $this->assertEqual($m2,$s5->getMentor());    
    $this->assertEqual($m2,$s6->getMentor());

    $this->assertEqual(false,$m->addStudent($s5));
  }  


  public function test_removeStudent()
  {
    $s = new StudentF();
    $s2 = new StudentF();    
    $s3 = new StudentF();
    $s4 = new StudentF();

    $m = new MentorF(array($s,$s2,$s3));
    
    $this->assertEqual(false,$m->removeStudent($s4));
    $this->assertEqual(true,$m->removeStudent($s3));
    $this->assertEqual(2,$m->numberOfStudents());
    
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual($m,$s2->getMentor());
    $this->assertEqual(null,$s3->getMentor());
    $this->assertEqual(null,$s4->getMentor());    

    $this->assertEqual(false,$m->removeStudent($s2));
    $this->assertEqual(2,$m->numberOfStudents());
    
    
  }  
  
  
  
  

  public function test_setStudents_empty()
  {
    $s = new StudentF();
    $s2 = new StudentF();
    $s3 = new StudentF();
    $m = new MentorF(array($s,$s2,$s3));

    $this->assertEqual(false, $m->setStudents(array()));
    $this->assertEqual(3,$m->numberOfStudents());
  }
  

  public function test_deletStudentDeletesTheMentorIfNotEnoughLeft()
  {
    $s1 = new StudentF();
    $s2 = new StudentF();

    $m = new MentorF(array($s1,$s2));
    $studentP = new ProgramF();
    $mentorP = new ProgramF();
    
    $s2->setProgram($studentP);
    $m->setProgram($mentorP);

    $s1->delete();
    
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(null,$m->getProgram());
    $this->assertEqual(null,$mentorP->getMentor());
    $this->assertEqual($studentP,$s2->getProgram());
    $this->assertEqual(null,$s1->getMentor());
  }  
  

  public function test_deleteStudentLeavesMentorAloneIfHasEnough()
  {
    $s1 = new StudentF();
    $s2 = new StudentF();
    $s3 = new StudentF();

    $m = new MentorF(array($s1,$s2,$s3));
    $studentP = new ProgramF();
    $mentorP = new ProgramF();
    
    $s2->setProgram($studentP);
    $m->setProgram($mentorP);

    $s1->delete();
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($mentorP,$m->getProgram());
    $this->assertEqual($m,$mentorP->getMentor());
    $this->assertEqual($studentP,$s2->getProgram());
    $this->assertEqual(null,$s1->getMentor());
  } 

  
  
}
