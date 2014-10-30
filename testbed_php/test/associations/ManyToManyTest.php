<?php

class ManyToManyTest extends UnitTestCase
{
    
  function test_CreateNew()
  {
    $s = new StudentN(99);
    $this->assertEqual(0,$s->numberOfMentors());
    
    $m = new MentorN("blah");
    $this->assertEqual(0,$m->numberOfStudents());
  }
  
  function test_addStudent()
  {
    $m = new MentorN("blah");
    $s = new StudentN(99);
    $m->addStudent($s);
    
    $this->assertEqual($m, $s->getMentor_index(0));
    $this->assertEqual($s, $m->getStudent_index(0));
  }

  function test_addStudentToMultipleMentors()
  {
    $m = new MentorN("blah");
    $m2 = new MentorN("blah2");
    
    
    $s = new StudentN(99);
    $s2 = new StudentN(992);
    $m->addStudent($s);
    $m2->addStudent($s2);
    $m2->addStudent($s);
    $s2->addMentor($m);
    
    $this->assertEqual($m, $s->getMentor_index(0));
    $this->assertEqual($m2, $s->getMentor_index(1));
    $this->assertEqual($m2, $s2->getMentor_index(0));
    $this->assertEqual($m, $s2->getMentor_index(1));

    
    $this->assertEqual($s, $m->getStudent_index(0));
    $this->assertEqual($s2, $m->getStudent_index(1));
    $this->assertEqual($s2, $m2->getStudent_index(0));
    $this->assertEqual($s, $m2->getStudent_index(1));
  }
  

  function test_addToNewMentor()
  {
    $m = new MentorN("blah");
    $m2 = new MentorN("blah2");
    $s = new StudentN(99);
    
    $m->addStudent($s);
    $m2->addStudent($s);
    
    $this->assertEqual(2, $s->numberOfMentors());
    $this->assertEqual($m, $s->getMentor_index(0));
    $this->assertEqual($m2, $s->getMentor_index(1));

    $this->assertEqual(1, $m->numberOfStudents());
    $this->assertEqual(1, $m2->numberOfStudents());

    $this->assertEqual($s, $m->getStudent_index(0));
    $this->assertEqual($s, $m2->getStudent_index(0));
  }  
  

  function test_doNotRemoveFromExistingMentor()
  {
    $m = new MentorN("blah");
    $m2 = new MentorN("blah2");

    $s1 = new StudentN(99);
    $s2 = new StudentN(98);
    $s3 = new StudentN(97);
    
    $m->addStudent($s1);
    $m->addStudent($s2);
    $m->addStudent($s3);

    $this->assertEqual(3, $m->numberOfStudents());
    $this->assertEqual(0, $m2->numberOfStudents());
    
    $m2->addStudent($s1);

    $this->assertEqual(3, $m->numberOfStudents());
    $this->assertEqual($s1, $m->getStudent_index(0));
    $this->assertEqual($s2, $m->getStudent_index(1));
    $this->assertEqual($s3, $m->getStudent_index(2));
    
    $this->assertEqual(1, $m2->numberOfStudents());
    $this->assertEqual($s1, $m2->getStudent_index(0));
    
    $this->assertEqual($m, $s1->getMentor_index(0));
    $this->assertEqual($m2, $s1->getMentor_index(1));
    
    $this->assertEqual($m, $s2->getMentor_index(0));
    $this->assertEqual($m, $s3->getMentor_index(0));
  }   
  

  function test_removeStudent()
  {
    $m = new MentorN("blah");
    $s = new StudentN(99);
    
    $m->addStudent($s);
    $m->removeStudent($s);
    
    $this->assertEqual(0,$s->numberOfMentors());
    $this->assertEqual(0,$m->numberOfStudents());
  }  


  function test_deleteAll()
  {
    $m = new MentorN("blah");
    $m2 = new MentorN("blah2");
    
    $s = new StudentN(99);
    $s2 = new StudentN(98);
    $s3 = new StudentN(97);
    
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
  
}

?>
