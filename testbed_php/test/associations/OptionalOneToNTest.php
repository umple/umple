<?php

class OptionalOneToNTest extends UnitTestCase
{


  public function test_CreateStudentWithoutMentor()
  {
    $s = new StudentD();
    $this->assertEqual(null,$s->getMentor());
  }
  
  public function test_ConstructorWithoutNStudents()
  {
  	$this->expectException(new Exception("Unable to create MentorD, must have 3 students"));
    $s = new StudentD();
    $s2 = new StudentD();    
    new MentorD(array($s,$s2));
  }
  

  public function test_setStudents_makeSureAlwaysN()
  {
    $s = new StudentD();
    $s2 = new StudentD();
    $s3 = new StudentD();

    $m = new MentorD(array($s,$s2,$s3));
    $s4 = new StudentD();
    $s5 = new StudentD();
    $s6 = new StudentD();
    
    $this->assertEqual(true,$m->setStudents(array($s, $s2, $s3)));
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual($m,$s2->getMentor());
    $this->assertEqual($m,$s3->getMentor());

    $this->assertEqual(true,$m->setStudents(array($s4, $s5, $s6)));
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual(null,$s->getMentor());
    $this->assertEqual(null,$s2->getMentor());
    $this->assertEqual(null,$s3->getMentor());
    $this->assertEqual($m,$s4->getMentor());
    $this->assertEqual($m,$s5->getMentor());
    $this->assertEqual($m,$s6->getMentor());
  }

  public function test_setStudents_watchOutForDuplicateEntries()
  {
  	$this->expectException(new Exception("Unable to create MentorD, must have 3 students"));
    $s = new StudentD();
    $s2 = new StudentD();
    new MentorD(array($s, $s2, $s));
  }
  
  

  public function test_setStudents_replaceExisitingmakeSureAlwaysN()
  {
    $s = new StudentD();
    $s2 = new StudentD();
    $s3 = new StudentD();

    $m = new MentorD(array($s, $s2, $s3));
    $s4 = new StudentD();
    
    $this->assertEqual(false,$m->setStudents(array($s, $s2)));
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual($m,$s2->getMentor());
    $this->assertEqual($m,$s3->getMentor());
    $this->assertEqual(null,$s4->getMentor());    
    
    $this->assertEqual(false,$m->setStudents(array($s, $s2, $s3, $s4)));
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual(null,$s4->getMentor());

  }


  public function test_setStudents_empty()
  {
    $s = new StudentD();
    $s2 = new StudentD();
    $s3 = new StudentD();
    $m = new MentorD(array($s,$s2,$s3));

    
    $this->assertEqual(true,$m->setStudents(array($s, $s2, $s3)));
    $this->assertEqual(3,$m->numberOfStudents());

    $this->assertEqual(false,$m->setStudents(array()));
    $this->assertEqual(3,$m->numberOfStudents());
  }
  
  public function test_checkForExistingMentor()
  {
		$this->expectException(new Exception("Unable to create MentorD, must have 3 students"));
    $s1 = new StudentD();
    $s2 = new StudentD();
    $s3 = new StudentD();

    $m = new MentorD(array($s1,$s2,$s3));

    $s4 = new StudentD();
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($m, $s1->getMentor());
    $this->assertEqual($m, $s2->getMentor());
    $this->assertEqual($m, $s3->getMentor());    
    $this->assertEqual(null, $s4->getMentor());    

    new MentorD(array($s1,$s2,$s4));
  }   
  

  public function test_deletStudentDeletesTheMentor()
  {
    $s1 = new StudentD();
    $s2 = new StudentD();
    $s3 = new StudentD();

    $m = new MentorD(array($s1,$s2,$s3));
    $studentP = new ProgramD();
    $mentorP = new ProgramD();
    
    $s2->setProgram($studentP);
    $m->setProgram($mentorP);

    $s1->delete();
    
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(null,$m->getProgram());
    $this->assertEqual(null,$mentorP->getMentor());
    $this->assertEqual($studentP,$s2->getProgram());
    $this->assertEqual(null,$s1->getMentor());
  }  

  
  
}
