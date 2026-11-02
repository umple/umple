<?php

// The default equals must be identity: comparing loosely, two distinct but value-equal objects
// either recurse without end through their associations or are taken for the same object.
class EqualsIdentityTest extends UnitTestCase
{

  public function test_valueEqualObjectsInACycleDoNotRecurse()
  {
    $department = new EqDepartment();
    $course1 = new EqCourse("ECSE321", $department);
    $instructor1 = new EqInstructor("Bob", $course1, $department);
    $course2 = new EqCourse("ECSE321", $department);
    $instructor2 = new EqInstructor("Bob", $course2, $department);

    $this->assertEqual(2, $department->numberOfCourses());
    $this->assertEqual(2, $department->numberOfInstructors());
    $this->assertTrue($instructor2 === $department->getInstructor_index(1));
    $this->assertTrue($instructor2 === $course2->getInstructor());
  }

  public function test_valueEqualObjectsAreBothAdded()
  {
    $mentor = new EqMentor("Ann");
    $student1 = new EqStudent("Joe", $mentor);
    $student2 = new EqStudent("Joe", $mentor);

    $this->assertEqual(2, $mentor->numberOfStudents());
    $this->assertEqual(0, $mentor->indexOfStudent($student1));
    $this->assertEqual(1, $mentor->indexOfStudent($student2));
  }

  public function test_equalsIsIdentity()
  {
    $mentor = new EqMentor("Ann");
    $student1 = new EqStudent("Joe", $mentor);
    $student2 = new EqStudent("Joe", $mentor);

    $this->assertTrue($student1->equals($student1));
    $this->assertFalse($student1->equals($student2));
  }

}
?>
