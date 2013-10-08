<?php

class UniqueTest extends UnitTestCase
{
  private $one, $two;
  
  public function __construct() {
    $this->one = new ItemWithUniqueId("1");
    $this->two = new ItemWithUniqueId("2");
  }

  public function __destruct() {
    $this->one->delete();
    $this->two->delete();
  }

  public function testCreateWithDuplicates() {
    $this->expectException(new RuntimeException("Cannot create due to duplicate id"));
    $duplicate = new ItemWithUniqueId("1"); 
  }
  
  public function testHasWithGetWith() {
    $this->assertTrue(ItemWithUniqueId::hasWithId("1"));
    $this->assertFalse(ItemWithUniqueId::hasWithId("3"));
    $this->assertEqual(ItemWithUniqueId::getWithId("1"), $this->one);
    $this->assertEqual(ItemWithUniqueId::getWithId("2"), $this->two);
  }
  
  public function testSetId() {
    // Attempt to change id to "1", which is already used.
    // This should fail and so id should still be "2".
    $this->assertFalse($this->two->setId("1"));
    $this->assertEqual($this->two->getId(), "2");
    // Attempt to change id to "3", which is free.
    // This should succeed and "2" should become available.
    $this->assertTrue($this->two->setId("3"));
    $this->assertEqual($this->two->getId(), "3");
    $this->assertFalse(ItemWithUniqueId::hasWithId("2"));
    // Now that "2" is available, we can create a new ItemWithUniqueId with id "2" with no error.
    $newTwo = new ItemWithUniqueId("2");
    $newTwo->delete();
  }
}
