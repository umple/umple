<?php

class MNToOptionalNTest extends UnitTestCase
{


  public function xtest_CreateStudentWihtoutMentor()
  {
    $s = new StudentAB(99);
    $this->assertEqual(false,$s->isNumberOfMentorsValid());
  }
  

  public function xtest_CreateMentorWithoutStudent()
  {
    $m = new MentorAB("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }
  

  public function xtest_AddStudentsAndMentorsOkay()
  {
    $m = new MentorAB("blah");
    $m2 = new MentorAB("blah");
    $m3 = new MentorAB("blah");
    $m4 = new MentorAB("blah");
    $m5 = new MentorAB("blah");
    $m6 = new MentorAB("blah");
    
    $s = new StudentAB(99);
    $s2 = new StudentAB(98);
    $s3 = new StudentAB(97);

    $this->assertEqual(true,$m->addStudent($s));
    $this->assertEqual(true,$m->addStudent($s2));
    $this->assertEqual(false,$m->addStudent($s3));
    
    $this->assertEqual(true,$s->addMentor($m2));
    $this->assertEqual(true,$s->addMentor($m3));
    $this->assertEqual(true,$s->addMentor($m4));
    $this->assertEqual(true,$s->addMentor($m5));
    $this->assertEqual(false,$s->addMentor($m6));
    
    $this->assertEqual(2, $m->numberOfStudents());
    $this->assertEqual($m4,$s->getMentor_index(3));
    $this->assertEqual($m,$s2->getMentor_index(0));
    $this->assertEqual(5,$s->numberOfMentors());
  }   
  

  public function xtest_RemoveMiddleMentorWhenNotValidMaintainsTheOrder()
  {
    $s = new StudentAB(99);
    
    $m = new MentorAB("blah");
    $m2 = new MentorAB("blah");
    $m3 = new MentorAB("blah");

    $s->addMentor($m);
    $s->addMentor($m2);
    $s->addMentor($m3);
    $this->assertEqual(false,$s->removeMentor($m2));
    $this->assertEqual(3, $s->numberOfMentors());
    $this->assertEqual($m2,$s->getMentor_index(1));
  } 
  

  public function xtest_RemoveStudents()
  {
    $m = new MentorAB("blah");
    $m2 = new MentorAB("blah2");
    $m3 = new MentorAB("blah3");
    $m4 = new MentorAB("blah4");
    
    $s = new StudentAB(99);
    $s2 = new StudentAB(98);
    $s3 = new StudentAB(97);
    
    $m->addStudent($s);
    $m->addStudent($s2);
    $m2->addStudent($s);
    $m2->addStudent($s2);
    $m3->addStudent($s);
    $m3->addStudent($s2);
    $m4->addStudent($s);
    $m4->addStudent($s2);
    
    $this->assertEqual(false,$m->removeStudent($s3));
    $this->assertEqual(true,$m->removeStudent($s2));
    
    $this->assertEqual(3,$s2->numberOfMentors());
    $this->assertEqual(1, $m->numberOfStudents());
  } 
  

  public function xtest_SetStudentsTooMany()
  {
    $m = new MentorAB("blah");
    
    $s = new StudentAB(99);
    $s2 = new StudentAB(98);
    $s3 = new StudentAB(97);
    
    $this->assertEqual(true,$m->addStudent($s));
    $this->assertEqual(true,$m->addStudent($s2));
    $this->assertEqual(false,$m->addStudent($s3));
    
    $this->assertEqual(2, $m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor_index(0));
    $this->assertEqual($m,$s2->getMentor_index(0));
    $this->assertEqual(0,$s3->numberOfMentors());
  }   
  

  public function xtest_MentorAlreadyHasEnoughStudents()
  {
    $m = new MentorAB("blah");
    
    $s = new StudentAB(99);
    $s2 = new StudentAB(98);
    $s3 = new StudentAB(97);
    
    $m->addStudent($s);
    $m->addStudent($s2);
    
    $this->assertEqual(false,$m->addStudent($s3));
    
    $this->assertEqual(2, $m->numberOfStudents());
    $this->assertEqual(0,$s3->numberOfMentors());
  }    
  

  public function xtest_getBoundsForStudent()
  {
    $this->assertEqual(2,MentorAB::maximumNumberOfStudents());
  }  
  

  public function xtest_getBoundsForMentor()
  {
    $this->assertEqual(3,StudentAB::minimumNumberOfMentors());
    $this->assertEqual(5,StudentAB::maximumNumberOfMentors());
  }    
  

  public function xtest_deleteMentorAndStudentHasEnough()
  {
    
    $m = new MentorAB("blah");
    $m2 = new MentorAB("blah2");
    $m3 = new MentorAB("blah2");
    $m4 = new MentorAB("blah2");

    $s = new StudentAB(99);
    $s2 = new StudentAB(98);
    
    $m->addStudent($s);
    $m->addStudent($s2);
    $m2->addStudent($s);
    $m2->addStudent($s2);
    $m3->addStudent($s);
    $m3->addStudent($s2);
    $m4->addStudent($s);
    $m4->addStudent($s2);
    
    $p = new ProgramAB();
    $s->setProgram($p);
    
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual($p,$s->getProgram());
    $this->assertEqual(3,$s->numberOfMentors());
  }  


  public function test_deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    $m = new MentorAB("blah");
    $m2 = new MentorAB("blah2");
    $m3 = new MentorAB("blah3");

    $s = new StudentAB(99);
    $s2 = new StudentAB(98);
    
    $m->addStudent($s);
    $m->addStudent($s2);
    $m2->addStudent($s);
    $m2->addStudent($s2);
    $m3->addStudent($s);
    $m3->addStudent($s2);
    
    $p = new ProgramAB();
    $s->setProgram($p);

    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(2,$m2->numberOfStudents());
    $this->assertEqual(2,$m3->numberOfStudents());
    $this->assertEqual(3,$s->numberOfMentors());
    $this->assertEqual(3,$s2->numberOfMentors());
    
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(0,$m2->numberOfStudents());
    $this->assertEqual(0,$m3->numberOfStudents());
    $this->assertEqual(0,$s->numberOfMentors());
    $this->assertEqual(0,$s2->numberOfMentors());
  }  

}
