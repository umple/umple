<?php

class OptionalNToOptionalNTest extends UnitTestCase
{


  public function test_CreateNew()
  {
    $s = new StudentAE(99);
    $this->assertEqual(0,$s->numberOfMentors());
    
    $m = new MentorAE("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }
  

  public function test_addStudent()
  {
    $m = new MentorAE("blah");
    $s = new StudentAE(99);
    $m->addStudent($s);
    
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($s, $m->getStudent(0));
  }

  

  public function test_addStudentToMultipleMentors()
  {
    $m = new MentorAE("blah");
    $m2 = new MentorAE("blah2");
    
    
    $s = new StudentAE(99);
    $s2 = new StudentAE(992);
    $m->addStudent($s);
    $m2->addStudent($s2);
    $m2->addStudent($s);
    $s2->addMentor($m);
    
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m2,$s->getMentor(1));
    $this->assertEqual($m2,$s2->getMentor(0));
    $this->assertEqual($m,$s2->getMentor(1));

    
    $this->assertEqual($s, $m->getStudent(0));
    $this->assertEqual($s2, $m->getStudent(1));
    $this->assertEqual($s2, $m2->getStudent(0));
    $this->assertEqual($s, $m2->getStudent(1));
  }
  

  public function test_addToNewMentor()
  {
    $m = new MentorAE("blah");
    $m2 = new MentorAE("blah2");
    $s = new StudentAE(99);
    
    $m->addStudent($s);
    $m2->addStudent($s);
    
    $this->assertEqual(2,$s->numberOfMentors());
    $this->assertEqual($m,$s->getMentor(0));
    $this->assertEqual($m2,$s->getMentor(1));

    $this->assertEqual(1, $m->numberOfStudents());
    $this->assertEqual(1, $m2->numberOfStudents());

    $this->assertEqual($s, $m->getStudent(0));
    $this->assertEqual($s, $m2->getStudent(0));
  }  
  

  public function test_doNotRemoveFromExistingMentor()
  {
    $m = new MentorAE("blah");
    $m2 = new MentorAE("blah2");

    $s1 = new StudentAE(99);
    $s2 = new StudentAE(98);
    
    $m->addStudent($s1);
    $m->addStudent($s2);

    $this->assertEqual(2, $m->numberOfStudents());
    $this->assertEqual(0, $m2->numberOfStudents());
    
    $m2->addStudent($s1);

    $this->assertEqual(2, $m->numberOfStudents());
    $this->assertEqual($s1, $m->getStudent(0));
    $this->assertEqual($s2, $m->getStudent(1));
    
    $this->assertEqual(1, $m2->numberOfStudents());
    $this->assertEqual($s1, $m2->getStudent(0));
    
    $this->assertEqual($m,$s1->getMentor(0));
    $this->assertEqual($m2,$s1->getMentor(1));
    
    $this->assertEqual($m,$s2->getMentor(0));
  }   
  

  public function test_removeStudent()
  {
    $m = new MentorAE("blah");
    $s = new StudentAE(99);
    
    $m->addStudent($s);
    $m->removeStudent($s);
    
    $this->assertEqual(0,$s->numberOfMentors());
    $this->assertEqual(0,$m->numberOfStudents());
  }  


  public function test_deleteAll()
  {
    $m = new MentorAE("blah");
    $m2 = new MentorAE("blah");
    
    $s = new StudentAE(99);
    $s2 = new StudentAE(98);
    $s3 = new StudentAE(97);
    
    $m->addStudent($s);
    $m->addStudent($s2);
    $m->addStudent($s3);

    $m2->addStudent($s2);
    
    $m->delete();

    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(1,$m2->numberOfStudents());
    
    $this->assertEqual(0,$s->numberOfMentors());
    $this->assertEqual(1,$s2->numberOfMentors());
    $this->assertEqual(0,$s3->numberOfMentors());
  }  
  

  public function test_isMaxNumber()
  {
    $this->assertEqual(3,StudentAE::maximumNumberOfMentors());
    $this->assertEqual(2,MentorAE::maximumNumberOfStudents());
  }
  

  public function test_addStudentsMax()
  {
    $m = new MentorAE("blah");
    $this->assertEqual(true,$m->addStudent(new StudentAE(99)));
    $this->assertEqual(true,$m->addStudent(new StudentAE(98)));
    $this->assertEqual(false,$m->addStudent(new StudentAE(97)));
  }


  public function test_addMentorsMax()
  {
    $s = new StudentAE(98);
    $this->assertEqual(true,$s->addMentor(new MentorAE("blah")));
    $this->assertEqual(true,$s->addMentor(new MentorAE("blah")));
    $this->assertEqual(true,$s->addMentor(new MentorAE("blah")));
    $this->assertEqual(false,$s->addMentor(new MentorAE("blah")));
  }

}

?>
