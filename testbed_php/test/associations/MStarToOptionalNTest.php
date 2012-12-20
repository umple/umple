<?php

class MStarToOptionalNTest extends UnitTestCase
{

  public function test_CreateStudentWihtoutMentor()
  {
    $s = new StudentAD(99);
    $this->assertEqual(false,$s->isNumberOfMentorsValid());
  }
  

  public function test_CreateMentorWithoutStudent()
  {
    $m = new MentorAD("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }
  

  public function test_AddStudentsAndMentorsOkay()
  {
    $m = new MentorAD("blah");
    $m2 = new MentorAD("blah2");
    $m3 = new MentorAD("blah3");
    $m4 = new MentorAD("blah4");
    $m5 = new MentorAD("blah5");
    $m6 = new MentorAD("blah6");
    
    $s = new StudentAD(99);
    $s2 = new StudentAD(98);
    $s3 = new StudentAD(97);

    $this->assertEqual(true,$m->addStudent($s));
    $this->assertEqual(true,$m->addStudent($s2));
    $this->assertEqual(false,$m->addStudent($s3));
    
    $this->assertEqual(true,$s->addMentor($m2));
    $this->assertEqual(true,$s->addMentor($m3));
    $this->assertEqual(true,$s->addMentor($m4));
    $this->assertEqual(true,$s->addMentor($m5));
    $this->assertEqual(true,$s->addMentor($m6));
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m4,$s->getMentor(3));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual(6,$s->numberOfMentors());
  }
  

  public function test_isNumberOfValid()
  {
    $s = new StudentAD(99);
    $this->assertEqual(false,$s->isNumberOfMentorsValid());

    $s->addMentor(new MentorAD("blah"));
    $this->assertEqual(false,$s->isNumberOfMentorsValid());

    $s->addMentor(new MentorAD("blah2"));
    $this->assertEqual(false,$s->isNumberOfMentorsValid());

    $s->addMentor(new MentorAD("blah3"));
    $this->assertEqual(true,$s->isNumberOfMentorsValid());

    $s->addMentor(new MentorAD("blah4"));
    $this->assertEqual(true,$s->isNumberOfMentorsValid());
  }
  

  public function test_RemoveMiddleMentorWhenNotValidMaintainsTheOrder()
  {
    $s = new StudentAD(99);
    
    $m = new MentorAD("blah");
    $m2 = new MentorAD("blah2");
    $m3 = new MentorAD("blah3");

    $s->addMentor($m);
    $s->addMentor($m2);
    $s->addMentor($m3);
    $this->assertEqual(false,$s->removeMentor($m2));
    $this->assertEqual(3,$s->numberOfMentors());
    $this->assertEqual($m2,$s->getMentor(1));
  } 
  

  public function test_RemoveStudents()
  {
    $m = new MentorAD("blah");
    $m2 = new MentorAD("blah2");
    $m3 = new MentorAD("blah3");
    $m4 = new MentorAD("blah4");
    
    $s = new StudentAD(99);
    $s2 = new StudentAD(98);
    $s3 = new StudentAD(97);
    
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
    $this->assertEqual(1,$m->numberOfStudents());
  } 
  

  public function test_SetStudentsTooMany()
  {
    $m = new MentorAD("blah");
    
    $s = new StudentAD(99);
    $s2 = new StudentAD(98);
    $s3 = new StudentAD(97);
    
    $this->assertEqual(true,$m->addStudent($s));
    $this->assertEqual(true,$m->addStudent($s2));
    $this->assertEqual(false,$m->addStudent($s3));
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(0));
    $this->assertEqual(0,$s3->numberOfMentors());
  }   
  

  public function test_MentorAlreadyHasEnoughStudents()
  {
    $m = new MentorAD("blah");
    
    $s = new StudentAD(99);
    $s2 = new StudentAD(98);
    $s3 = new StudentAD(97);
    
    $m->addStudent($s);
    $m->addStudent($s2);
    
    $this->assertEqual(false,$m->addStudent($s3));
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(0,$s3->numberOfMentors());
  }    
  

  public function test_getBoundsForStudent()
  {
    $this->assertEqual(2,MentorAD::maximumNumberOfStudents());
  }  
  

  public function test_getBoundsForMentor()
  {
    $this->assertEqual(3,StudentAD::minimumNumberOfMentors());
  }    
  

  public function test_deleteMentorAndStudentHasEnough()
  {
    
    $m = new MentorAD("blah");
    $m2 = new MentorAD("blah2");
    $m3 = new MentorAD("blah3");
    $m4 = new MentorAD("blah4");

    $s = new StudentAD(99);
    $s2 = new StudentAD(98);
    
    $m->addStudent($s);
    $m->addStudent($s2);
    $m2->addStudent($s);
    $m2->addStudent($s2);
    $m3->addStudent($s);
    $m3->addStudent($s2);
    $m4->addStudent($s);
    $m4->addStudent($s2);
    
    $p = new ProgramAD();
    $s->setProgram($p);
    
    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual($p,$s->getProgram());
    $this->assertEqual(3,$s->numberOfMentors());
  }  


  public function test_deleteMentorAndStudentNowHasTooFewMentors()
  {
    
    $m = new MentorAD("blah");
    $m2 = new MentorAD("blah2");
    $m3 = new MentorAD("blah3");

    $s = new StudentAD(99);
    $s2 = new StudentAD(98);
    
    $m->addStudent($s);
    $m->addStudent($s2);
    $m2->addStudent($s);
    $m2->addStudent($s2);
    $m3->addStudent($s);
    $m3->addStudent($s2);
    
    $p = new ProgramAD();
    $s->setProgram($p);

    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(2,$m2->numberOfStudents());
    $this->assertEqual(3,$s->numberOfMentors());

    $m->delete();
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(0,$m2->numberOfStudents());
    $this->assertEqual(0,$s->numberOfMentors());
  }  

}
