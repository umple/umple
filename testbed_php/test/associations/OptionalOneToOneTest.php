<?php

class OptionalOneToOneTest extends UnitTestCase
{


  public function test_Constructor()
  {
    $student = new StudentB();
    $mentor = new MentorB($student);
    
    $this->assertEqual($student,$mentor->getStudent());
    $this->assertEqual($mentor,$student->getMentor());
  } 
  
  public function test_CannotSetStudentBToNull()
  {
    $student = new StudentB();
    $mentor = new MentorB($student);
    $this->assertEqual(false,$mentor->setStudent(null));
  }
    

  public function test_SetStudent()
  {
    $student = new StudentB();
    $mentor = new MentorB($student);
    
    $student2 = new StudentB();
    $this->assertEqual(true,$mentor->setStudent($student2));
    
    
    $this->assertEqual($mentor,$student2->getMentor());
    $this->assertEqual($student2,$mentor->getStudent());
    $this->assertEqual(null,$student->getMentor());
  } 
  
  public function test_SetMentorCannotReset()
  {
    $s = new StudentB();
    $m = new MentorB($s);
    
    $s2 = new StudentB();
    $m2 = new MentorB($s2);
    
    $this->assertEqual(false,$m->setStudent($s2));
    $this->assertEqual($m,$s->getMentor());
    $this->assertEqual($s,$m->getStudent());
    $this->assertEqual($m2,$s2->getMentor());
    $this->assertEqual($s2,$m2->getStudent());
  } 

  

  public function test_SetMentor()
  {
    $student = new StudentB();
    $mentor = new MentorB($student);
    
    $student2 = new StudentB();
    $student2->setMentor($mentor);
    
    $this->assertEqual($mentor,$student2->getMentor());
    $this->assertEqual($student2,$mentor->getStudent());
    $this->assertEqual(null,$student->getMentor());
  }   

  public function test_UnableToConstructNewSubordinateFromExistingDriverThatAlreadyHasDriver()
  {
  	$this->expectException(new Exception("Unable to create mentor due to student"));
    $student = new StudentB();
    new MentorB($student);
    new MentorB($student); 
  } 


  public function test_DeleteDriverStudentHasNoMentor()
  {
    $student = new StudentB();
    $student->delete();
    $this->assertEqual(null,$student->getMentor());
  }
  

  public function test_DeleteDriverRemovesSubordinate()
  {
    $student = new StudentB();
    $mentor = new MentorB($student);
    $program = new ProgramB();
    $mentor->setProgram($program);
    
    $student->delete();
    $this->assertEqual(null,$student->getMentor());
    $this->assertEqual(null,$mentor->getStudent());
    $this->assertEqual(null,$mentor->getProgram());
  }  
  

  public function test_DeleteSubordinateKeepDriver()
  {
    $student = new StudentB();
    $mentor = new MentorB($student);
    $program = new ProgramB();
    $student->setProgram($program);
    
    $mentor->delete();
    $this->assertEqual(null,$student->getMentor());
    $this->assertEqual(null,$mentor->getStudent());
    $this->assertEqual($program,$student->getProgram());
  }  
  
}
?>