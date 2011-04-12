<?php

class ManyToOptionalNTest extends UnitTestCase
{


  public function test_CreateStudentWithoutMentor()
  {
    $s = new StudentAA(99);
    $this->assertEqual(0,$s->numberOfMentors());
  }
  

  public function test_CreateMentorWithoutStudent()
  {
    $m = new MentorAA("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }


  public function test_setTooMany()
  {
    $s = new StudentAA(99);
    $s2 = new StudentAA(98);    
    $s3 = new StudentAA(97);
    $m = new MentorAA("blah");
    $this->assertEqual(false,$m->setStudents(array($s,$s2,$s3))); 
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(0,$s->numberOfMentors());
    $this->assertEqual(0,$s2->numberOfMentors());
    $this->assertEqual(0,$s3->numberOfMentors());
  }
  
  

  public function test_setStudentsAtMax()
  {
    $s = new StudentAA(99);
    $s2 = new StudentAA(98);

    $m = new MentorAA("blah");
    $m->setStudents(array($s,$s2));
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
  }
  

  public function test_setStudentsWatchOutForDuplicates()
  {
    $s = new StudentAA(99);
    $m = new MentorAA("blah");
    $this->assertEqual(false,$m->setStudents(array($s,$s)));
  }
  

  public function test_setStudentsDoNotEraseExisting()
  {
    $s = new StudentAA(99);
    $s2 = new StudentAA(98);
    $s3 = new StudentAA(97);
    
    $m = new MentorAA("blah");
    $m->setStudents(array($s,$s2));

    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual(0,$s3->numberOfMentors());    

    $m2 = new MentorAA("blah");
    $m2->setStudents(array($s,$s3));
    
    $this->assertEqual(2, $m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    
    $this->assertEqual(2, $m2->numberOfStudents());
    $this->assertEqual($m2,$s->getMentor(1));
    $this->assertEqual($m2,$s3->getMentor(0));

  }   
  

  public function test_setStudents_aboveNKeepsExistingIntact()
  {
    $s = new StudentAA(99);
    $s2 = new StudentAA(98);    
    $s3 = new StudentAA(97);
    $s4 = new StudentAA(96);
    $s5 = new StudentAA(95);

    $m = new MentorAA("blah");
    
    $this->assertEqual(true,$m->setStudents(array($s,$s2)));
    $this->assertEqual(false, $m->setStudents($s2,$s3,$s4,$s5,$s));
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual(0,$s3->numberOfMentors());
    $this->assertEqual(0,$s4->numberOfMentors());
    $this->assertEqual(0,$s5->numberOfMentors());

  }


  public function test_setStudents_doNotAllowDuplicatesNM()
  {
    $s = new StudentAA(99);
    $s2 = new StudentAA(98);    

    $m = new MentorAA("blah");
    $this->assertEqual(false, $m->setStudents(array($s,$s2,$s)));
  }


  public function test_setStudents_atNOverwritesExisting()
  {
    $s = new StudentAA(99);
    $s2 = new StudentAA(98);    
    $s3 = new StudentAA(97);

    $m = new MentorAA("blah");
    
    $this->assertEqual(true, $m->setStudents(array($s,$s2)));
    $this->assertEqual(true, $m->setStudents(array($s2,$s3)));
    $this->assertEqual(2,$m->numberOfStudents());

    $this->assertEqual(0,$s->numberOfMentors());
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
   
  }
  

  public function test_addMentorTooMany()
  {
    $s = new StudentAA(99);
    $s2 = new StudentAA(98);    
    $s3 = new StudentAA(97);

    $m = new MentorAA("blah");
    $m->setStudents(array($s,$s2));
    
    $this->assertEqual(false,$s3->addMentor($m));
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(0,$s3->numberOfMentors());
    
  }


  public function test_addMentorTOkay()
  {
    $s = new StudentAA(99);
    $s2 = new StudentAA(98);    

    $m = new MentorAA("blah");
    $m->setStudents(array($s));
    
    $this->assertEqual(true,$s2->addMentor($m));
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(1,$s2->numberOfMentors());
    
  }
  
  

  public function test_addStudent()
  {
    $s = new StudentAA(99);
    $s2 = new StudentAA(98);
    $s3 = new StudentAA(97); 

    $m = new MentorAA("blah");
    $this->assertEqual(true,$m->setStudents(array($s)));

    $this->assertEqual(true,$m->addStudent($s2));
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
   
    $this->assertEqual(false,$m->addStudent($s3));
    $this->assertEqual(2,$m->numberOfStudents());
  
  }  


  public function test_addStudentHasExistingMentor()
  {
    $s = new StudentAA(99);
    $s2 = new StudentAA(98);    
    $s3 = new StudentAA(97);

    $m = new MentorAA("blah");
    $m2 = new MentorAA("blah2");

    $m->setStudents(array($s,$s2));
    $m2->setStudents(array($s3));
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(1,$m2->numberOfStudents());

    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    
    $this->assertEqual($m2,$s3->getMentor(0));
    
    $this->assertEqual(true,$m2->addStudent($s2));
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(2,$m2->numberOfStudents());
    
    $this->assertEqual(2,$s2->numberOfMentors());    
    $this->assertEqual($m,$s2->getMentor(0));    
    $this->assertEqual($m2,$s2->getMentor(1));

    $this->assertEqual(false,$m->addStudent($s3));
    $this->assertEqual(2,$s2->numberOfMentors());    
  }  


  public function test_removeStudent()
  {
    $s = new StudentAA(99);
    $s2 = new StudentAA(98);    
    $s3 = new StudentAA(97);

    $m = new MentorAA("blah");
    $m->setStudents(array($s,$s2));
    
    $this->assertEqual(false,$m->removeStudent($s3));
    $this->assertEqual(true,$m->removeStudent($s2));
    
    $this->assertEqual(1,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual(0,$s2->numberOfMentors());
    $this->assertEqual(0,$s3->numberOfMentors());

    $this->assertEqual(true,$m->removeStudent($s));
    $this->assertEqual(0,$m->numberOfStudents());
  }  

  public function test_setStudents_empty()
  {
    $s = new StudentAA(99);
    $s2 = new StudentAA(98);
    $m = new MentorAA("blah");
    $m->setStudents(array($s,$s2));
    $this->assertEqual(true, $m->setStudents(array()));
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(0,$s->numberOfMentors());
    $this->assertEqual(0,$s2->numberOfMentors());
  }

  

  public function test_deleteStudentLeavesMentorAlone()
  {
    $s1 = new StudentAA(99);
    $s2 = new StudentAA(98);

    $m = new MentorAA("blah");
    $m->setStudents(array($s1,$s2));
    $studentP = new ProgramAA();
    $mentorP = new ProgramAA();
    
    $s2->setProgram($studentP);
    $m->setProgram($mentorP);

    $s1->delete();
    
    $this->assertEqual(1,$m->numberOfStudents());
    $this->assertEqual($mentorP,$m->getProgram());
    $this->assertEqual($m,$mentorP->getMentor());
    $this->assertEqual($studentP,$s2->getProgram());
    $this->assertEqual(0,$s1->numberOfMentors());
  } 
  

  public function test_studentBounds()
  {
    $this->assertEqual(2,MentorAA::maximumNumberOfStudents());
  }

  
  
}
?>