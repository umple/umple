<?php
class ConstraintTest extends UnitTestCase
{

  public function test_checkConstraint()
  {
    $boat = new BoatA(20);
    $this->assertEqual(false, $boat->setAge(18));
    $this->assertEqual(true, $boat->setAge(19));
  }

  public function test_checkNegation()
  {
    $boat = new BoatB(2);
    $this->assertEqual(true, $boat->setAge(18));
    $this->assertEqual(false, $boat->setAge(19));
  }

}