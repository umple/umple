<?php

class NToOptionalNTest extends UnitTestCase
{


  public function test_CreateStudentWithoutMentors()
  {
    $m = new MentorAC("blah");
    new StudentAC(99);
  }
  

  public function test_CreateStudentJustEnoughMentors()
  {
    $m = new MentorAC("blah");
    $m2 = new MentorAC("blah2");
    $m3 = new MentorAC("blah2");
    $s = new StudentAC(99);
    
    $this->assertEqual(true,$s->addMentor($m));
    $this->assertEqual(true,$s->addMentor($m2));
    $this->assertEqual(false,$s->addMentor($m3));
    $this->assertEqual(2,$s->numberOfMentors());
  }


  public function test_CreateMentorWithoutStudent()
  {
    $m = new MentorAC("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }
  

  public function test_SetMentorsOutsideRange()
  {
    $s = new StudentAC(99);

    $m = new MentorAC("blah");
    $m2 = new MentorAC("blah");
    $m3 = new MentorAC("blah");

    $this->assertEqual(true,$s->addMentor($m));
    $this->assertEqual(true,$s->addMentor($m2));
    $this->assertEqual(false,$s->addMentor($m3));
    
    $this->assertEqual(2, $s->numberOfMentors());
    $this->assertEqual($s,$m->getStudent(0));
    $this->assertEqual($s,$m2->getStudent(0));
    $this->assertEqual(0,$m3->numberOfStudents());
  }
  

  public function test_AddStudents()
  {
    $m = new MentorAC("blah");
    
    $s = new StudentAC(99);
    $s2 = new StudentAC(98);
    $s3 = new StudentAC(97);
    $s4 = new StudentAC(96);

    $this->assertEqual(true,$m->addStudent($s));
    $this->assertEqual(true,$m->addStudent($s2));
    $this->assertEqual(true,$m->addStudent($s3));
    $this->assertEqual(false,$m->addStudent($s4));
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual($m,$s3->getMentor(0));
    $this->assertEqual(1,$s3->numberOfMentors());
  }   
  

  public function test_RemoveMiddleMentorWhenNotValidMaintainsTheOrder()
  {
    $s = new StudentAC(99);
    
    $m = new MentorAC("blah");
    $m2 = new MentorAC("blah");

    $s->addMentor($m);
    $s->addMentor($m2);
    $this->assertEqual(false,$s->removeMentor($m2));
    
    $this->assertEqual(2, $s->numberOfMentors());
    $this->assertEqual($m2,$s->getMentor(1));
  } 
  

  public function test_CannotRemoveStudents()
  {
    $m = new MentorAC("blah");
    $m2 = new MentorAC("blah2");
    $m3 = new MentorAC("blah3");
    
    $s = new StudentAC(99);
    $s2 = new StudentAC(98);
    $s3 = new StudentAC(97);
    
    $m->addStudent($s);
    $m->addStudent($s2);
    $m2->addStudent($s);
    $m2->addStudent($s2);
    $this->assertEqual(false,$m3->addStudent($s));
    $this->assertEqual(false,$m3->addStudent($s2));
    
    $this->assertEqual(false,$m->removeStudent($s3));
    $this->assertEqual(false,$m->removeStudent($s2));
    
    $this->assertEqual(2,$s2->numberOfMentors());
    $this->assertEqual(2,$m->numberOfStudents());
  } 
  

  public function test_SetStudentsTooMany()
  {
    $m = new MentorAC("blah");
    
    $s = new StudentAC(99);
    $s2 = new StudentAC(98);
    $s3 = new StudentAC(97);
    $s4 = new StudentAC(96);
    
    $m->addStudent($s);
    $m->addStudent($s2);
    $this->assertEqual(true,$m->addStudent($s3));
    $this->assertEqual(false,$m->addStudent($s4));
  }   
  

  public function test_MentorAlreadyHasEnoughStudents()
  {
    $m = new MentorAC("blah");
    
    $s = new StudentAC(99);
    $s2 = new StudentAC(98);
    $s3 = new StudentAC(97);
    $s4 = new StudentAC(96);
    
    $m->addStudent($s);
    $m->addStudent($s2);
    $m->addStudent($s3);
    
    $this->assertEqual(false,$m->addStudent($s4));
    
    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual(1,$s3->numberOfMentors());
  }    


  public function test_addMentor()
  {
    $m = new MentorAC("blah");
    $m2 = new MentorAC("blah2");
    $m3 = new MentorAC("blah2");

    $s = new StudentAC(99);
    $s2 = new StudentAC(98);
    
    $this->assertEqual(true,$m->addStudent($s));
    $this->assertEqual(true,$m->addStudent($s2));
    $this->assertEqual(true,$s->addMentor($m2));
    $this->assertEqual(false,$s->addMentor($m3));

    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(1,$m2->numberOfStudents());
    $this->assertEqual(0,$m3->numberOfStudents());
    $this->assertEqual(2,$s->numberOfMentors());
  } 
  

  public function test_getBoundsForStudent()
  {
    $this->assertEqual(3,MentorAC::maximumNumberOfStudents());
  }  
  

  public function test_getBoundsForMentor()
  {
    $this->assertEqual(2,StudentAC::minimumNumberOfMentors());
    $this->assertEqual(2,StudentAC::maximumNumberOfMentors());
  }    
  

  public function test_deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    $m = new MentorAC("blah");
    $m2 = new MentorAC("blah2");
    $m3 = new MentorAC("blah2");

    $s = new StudentAC(99);
    $s2 = new StudentAC(98);
    
    $s->addMentor($m);
    $s->addMentor($m2);
    $s->addMentor($m3);
    $s2->addMentor($m);
    $s2->addMentor($m2);
    $s2->addMentor($m3);
    
    $m3->addStudent($s);
    $m3->addStudent($s2);
    
    $p = new ProgramAC();
    $s->setProgram($p);
    
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(0,$m2->numberOfStudents());
    $this->assertEqual(0,$s->numberOfMentors());
  }  

}
