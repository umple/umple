<?php

class ManyToNTest extends UnitTestCase
{


  public function test_CreateStudentWithoutMentor()
  {
    $s = new StudentQ(99);
    $this->assertEqual(0,$s->numberOfMentors());
  }
  
  public function test_ConstructorWithTooFew()
  {
  	$this->expectException(new Exception("Unable to create MentorQ, must have 2 students"));
    $s = new StudentQ(99);
    new MentorQ("blah",array($s));
  }

  public function test_ConstructorWithTooMany()
  {
  	$this->expectException(new Exception("Unable to create MentorQ, must have 2 students"));
    $s = new StudentQ(99);
    $s2 = new StudentQ(98);    
    $s3 = new StudentQ(97);
    new MentorQ("blah",array($s,$s2,$s3));
  }
  
  

  public function test_constructorJustRight()
  {
    $s = new StudentQ(99);
    $s2 = new StudentQ(98);

    $m = new MentorQ("blah",array($s,$s2));

    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor_index(0));
    $this->assertEqual($m,$s2->getMentor_index(0));
  }
  
  public function test_constructorWatchOutForDuplicateEntries()
  {
  	$this->expectException(new Exception("Unable to create MentorQ, must have 2 students"));
    $s = new StudentQ(99);
    new MentorQ("blah",array($s, $s));
  }
  

  public function test_constructorExistingMentorsOkay()
  {
    $s1 = new StudentQ(99);
    $s2 = new StudentQ(98);
    $s3 = new StudentQ(97);
    
    $m = new MentorQ("blah",array($s1,$s2));

    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m,$s1->getMentor_index(0));
    $this->assertEqual($m,$s2->getMentor_index(0));
    $this->assertEqual(0,$s3->numberOfMentors());    

    $m2 = new MentorQ("blah2",array($s2,$s3));
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m,$s1->getMentor_index(0));
    $this->assertEqual($m,$s2->getMentor_index(0));
    
    $this->assertEqual(2,$m2->numberOfStudents());
    $this->assertEqual($m2,$s2->getMentor_index(1));
    $this->assertEqual($m2,$s3->getMentor_index(0));

  }   
  

  public function test_setStudents_outsideN()
  {
    $s = new StudentQ(99);
    $s2 = new StudentQ(98);    
    $s3 = new StudentQ(97);
    $s4 = new StudentQ(96);
    $s5 = new StudentQ(95);

    $m = new MentorQ("blah",array($s,$s2));
    
    $this->assertEqual(false,$m->setStudents($s2,$s3,$s4));
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor_index(0));
    $this->assertEqual($m,$s2->getMentor_index(0));
    $this->assertEqual(0,$s3->numberOfMentors());
    $this->assertEqual(0,$s4->numberOfMentors());
    $this->assertEqual(0,$s5->numberOfMentors());

    $this->assertEqual(false,$m->setStudents($s5));
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor_index(0));
    $this->assertEqual($m,$s2->getMentor_index(0));
    $this->assertEqual(0,$s3->numberOfMentors());
    $this->assertEqual(0,$s4->numberOfMentors());
    $this->assertEqual(0,$s5->numberOfMentors());
    
    
  }


  public function test_setStudents_doNotAllowDuplicatesNM()
  {
    $s = new StudentQ(99);
    $s2 = new StudentQ(98);    
    $s3 = new StudentQ(97);

    $m = new MentorQ("blah",array($s,$s2));
    $this->assertEqual(false,$m->setStudents($s2,$s2,$s3));
  }


  public function test_setStudents_withinN()
  {
    $s = new StudentQ(99);
    $s2 = new StudentQ(98);    
    $s3 = new StudentQ(97);

    $m = new MentorQ("blah",array($s,$s2));
    
    $this->assertEqual(true,$m->setStudents(array($s3,$s2)));
    $this->assertEqual(2,$m->numberOfStudents());

    $this->assertEqual(0,$s->numberOfMentors());

    $this->assertEqual($m,$s2->getMentor_index(0));
    $this->assertEqual($m,$s3->getMentor_index(0));
  }
  



  public function test_setStudents_empty()
  {
    $s = new StudentQ(99);
    $s2 = new StudentQ(98);
    $m = new MentorQ("blah",array($s,$s2));

    $this->assertEqual(false,$m->setStudents(array()));
    $this->assertEqual(2,$m->numberOfStudents());
  }
  

  public function test_deletStudentDeletesTheMentorIfNotEnoughLeft()
  {
    $s1 = new StudentQ(99);
    $s2 = new StudentQ(98);

    $m = new MentorQ("blah",array($s1,$s2));
    $studentP = new ProgramQ();
    $mentorP = new ProgramQ();
    
    $s2->setProgram($studentP);
    $m->setProgram($mentorP);

    $s1->delete();
    
    
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(null,$m->getProgram());
    $this->assertEqual(null,$mentorP->getMentor());
    $this->assertEqual($studentP,$s2->getProgram());
    $this->assertEqual(0,$s1->numberOfMentors());
  }  
    

  public function test_addMentorTooMany()
  {
    $s = new StudentQ(99);
    $s2 = new StudentQ(98);    
    $s3 = new StudentQ(97);

    $m = new MentorQ("blah",array($s,$s2));
    
    $this->assertEqual(false,$s3->addMentor($m));
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(0,$s3->numberOfMentors());
    
  }

}

?>
