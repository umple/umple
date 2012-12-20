<?php
class ConstraintTest extends UnitTestCase
{ 

  public function defaulted()
  {
    $StudentA = new Student(20);
	$this->assertEqual(false,$studentA->setAgeId(2));
	$this->assertEqual(True,$studentA->setAgeId(20));
  }
}