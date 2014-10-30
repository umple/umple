<?php

class OptionalOneToManyTest extends UnitTestCase
{


  public function test_CreateStudentWithoutMentor()
  {
    $s = new StudentC(99);
    $this->assertEqual(null,$s->getMentor());
  }
  

  public function test_addStudent()
  {
    $m = new MentorC("m1");
    $s = new StudentC(99);
    $m->addStudent($s);
    
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual($s,$m->getStudent_index(0));
  }
  

  public function test_replaceMentor()
  {
    $m = new MentorC("m1");
    $m2 = new MentorC("m2");

    $s = new StudentC(99);
    $m->addStudent($s);
    $this->assertEqual(1,$m->numberOfStudents());
 
    $s->setMentor($m2);
    
    $this->assertEqual($m2,$s->getMentor());
    $this->assertEqual($s,$m2->getStudent_index(0));
    $this->assertEqual(0,$m->numberOfStudents());
  } 
  

  public function test_addToNewMentor()
  {
    $m = new MentorC("m1");
    $m2 = new MentorC("m2");
    $s = new StudentC(99);
    
    $m->addStudent($s);
    $m2->addStudent($s);
    
    $this->assertEqual($m2,$s->getMentor());
    $this->assertEqual($s,$m2->getStudent_index(0));
    $this->assertEqual(0,$m->numberOfStudents());
  }  
  

  public function test_removeFromExistingMentor()
  {
    $m = new MentorC("m1");
    $m2 = new MentorC("m2");

    $s1 = new StudentC(99);
    $s2 = new StudentC(98);
    $s3 = new StudentC(97);
    
    $m->addStudent($s1);
    $m->addStudent($s2);
    $m->addStudent($s3);

    $this->assertEqual(3,$m->numberOfStudents());
    $this->assertEqual(0,$m2->numberOfStudents());
    
    $m2->addStudent($s1);

    $this->assertEqual(2,$m->numberOfStudents());
    $this->assertEqual($s2,$m->getStudent_index(0));
    $this->assertEqual($s3,$m->getStudent_index(1));
    
    $this->assertEqual(1,$m2->numberOfStudents());
    $this->assertEqual($s1,$m2->getStudent_index(0));
    
    $this->assertEqual($m2,$s1->getMentor());
    $this->assertEqual($m,$s2->getMentor());
    $this->assertEqual($m,$s3->getMentor());
  }   
  

  public function test_removeStudent()
  {
    $m = new MentorC("m1");
    $s = new StudentC(99);
    
    $m->addStudent($s);
    $m->removeStudent($s);
    
    $this->assertEqual(null,$s->getMentor());
    $this->assertEqual(0,$m->numberOfStudents());
    
  }  


  public function test_delete()
  {
    $m = new MentorC("m1");
    $s = new StudentC(99);

    $m->addStudent($s);

    $m->delete();
    $this->assertNull($s->getMentor());
    $this->assertFalse($m->hasStudents());
  }

  
  public function test_deleteSubclass()
  {
    $m = new MentorCSub("m1");
    $s = new StudentC(99);

    $m->addStudent($s);

    $m->delete();
    $this->assertNull($s->getMentor());
    $this->assertFalse($m->hasStudents());
  } 
  
}

?>
