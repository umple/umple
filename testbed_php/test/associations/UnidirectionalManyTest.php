<?php

class UnidirectionalManyTest extends UnitTestCase
{

  public function test_addStudent()
  {
    $m = new MentorP("blah");
    $s = new StudentP(1);
    $m->addStudent($s);
    $this->assertEqual($s,$m->getStudent_index(0));
  }
  

  public function test_addSameStudent()
  {
    $m = new MentorP("blah");
    $s = new StudentP(1);
    
    $this->assertEqual(true,$m->addStudent($s));

    $this->assertEqual(1,$m->numberOfStudents());
    $this->assertEqual($s,$m->getStudent_index(0));
  }  
  

  public function test_removeStudent()
  {
    $m = new MentorP("blah");
    $s = new StudentP(1);
    
    $this->assertEqual(true,$m->addStudent($s));
    $this->assertEqual(true,$m->removeStudent($s));
    $this->assertEqual(false,$m->removeStudent($s));

    $this->assertEqual(0,$m->numberOfStudents());
  }   


  public function test_addMultipleMentors()
  {
    $m = new MentorP("blah");
    $m2 = new MentorP("blah");

    $s = new StudentP(99);
    $this->assertEqual(0,$m->numberOfStudents());
    $this->assertEqual(0,$m2->numberOfStudents());

    $m->addStudent($s);
    
    $this->assertEqual(1,$m->numberOfStudents());
    $this->assertEqual(0,$m2->numberOfStudents());

    $m2->addStudent($s);

    $this->assertEqual(1,$m->numberOfStudents());
    $this->assertEqual(1,$m2->numberOfStudents());

    $this->assertEqual($s,$m->getStudent_index(0));
    $this->assertEqual($s,$m2->getStudent_index(0));
  }
  

  public function test_deleteDoesNotRemoveStudentsFromMentors()
  {
    $m = new MentorP("blah");
    $m2 = new MentorP("blah");
    $m3 = new MentorP("blah");
    
    $s = new StudentP(99);
    $s2 = new StudentP(98);
    $s3 = new StudentP(97);
    
    $m->addStudent($s);
    $m->addStudent($s2);
    
    $m2->addStudent($s);
    $m3->addStudent($s3);
    
    $s->delete();
    
    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual(1,$m2->numberOfStudents());
    $this->assertEqual(1,$m3->numberOfStudents());
  }
  
}
?>
