<?php

// Association methods must compare linked objects with equals, as the generated Java does:
// by identity unless the class has a key. Comparing loosely, PHP follows the links of distinct
// but value-equal objects until it gives up ("Nesting level too deep"), or takes such
// objects for one another.
class AssociationEqualsTest extends UnitTestCase
{

  public function test_setOneToMany_movesToValueEqualOwner()
  {
    $mentor1 = new EqMentor("Ann");
    $mentor2 = new EqMentor("Ann");
    new EqStudent("Joe", $mentor1);
    new EqStudent("Joe", $mentor2);
    $student = new EqStudent("Sue", $mentor1);
    new EqStudent("Sue", $mentor2);

    $this->assertTrue($student->setEqMentor($mentor2));
    $this->assertTrue($mentor2 === $student->getEqMentor());
    $this->assertEqual(-1, $mentor1->indexOfStudent($student));
    $this->assertEqual(2, $mentor2->indexOfStudent($student));
  }

  public function test_setOneToOptionalOne_movesToValueEqualOwner()
  {
    $department = new EqDepartment();
    $course1 = new EqCourse("ECSE321", $department);
    $instructor = new EqInstructor("Bob", $course1, $department);
    $course2 = new EqCourse("ECSE321", $department);

    $this->assertTrue($instructor->setEqCourse($course2));
    $this->assertTrue($course2 === $instructor->getEqCourse());
    $this->assertTrue($instructor === $course2->getInstructor());
    $this->assertFalse($course1->hasInstructor());
  }

  public function test_setOptionalOneToOptionalOne_takesValueEqualPartner()
  {
    $owner1 = new EqOwner("Ann");
    $owner2 = new EqOwner("Ann");
    $pet1 = new EqPet("Rex");
    $pet2 = new EqPet("Rex");
    $owner1->setPet($pet1);
    $owner2->setPet($pet2);

    $this->assertTrue($owner1->setPet($pet2));
    $this->assertTrue($pet2 === $owner1->getPet());
    $this->assertTrue($owner1 === $pet2->getOwner());
    $this->assertFalse($owner2->hasPet());
    $this->assertFalse($pet1->hasOwner());
  }

  public function test_setMNToOptionalOne_movesValueEqualMembersFromValueEqualOwners()
  {
    $club1 = new EqClub("Chess", array(new EqMember("Ann")));
    $club2 = new EqClub("Chess", array(new EqMember("Ann")));
    $member1 = new EqMember("Joe");
    $member2 = new EqMember("Joe");
    $club1->addMember($member1);
    $club2->addMember($member2);
    $leaving = new EqMember("Sue");
    $club3 = new EqClub("Go", array($leaving));
    $this->assertTrue($club3 === $leaving->getClub());

    $this->assertTrue($club3->setMembers(array($member1, $member2)));
    $this->assertEqual(2, $club3->numberOfMembers());
    $this->assertEqual(-1, $club1->indexOfMember($member1));
    $this->assertEqual(-1, $club2->indexOfMember($member2));
    $this->assertEqual(1, $club1->numberOfMembers());
    $this->assertEqual(1, $club2->numberOfMembers());
    $this->assertTrue($club3 === $member1->getClub());
    $this->assertTrue($club3 === $member2->getClub());
    $this->assertFalse($leaving->hasClub());
  }

  public function test_setNToOptionalOne_takesValueEqualPlayers()
  {
    $leaving1 = new EqPlayer("Ann");
    $leaving2 = new EqPlayer("Bob");
    $team = new EqTeam("Red", array($leaving1, $leaving2));
    $this->assertTrue($team === $leaving1->getTeam());
    $player1 = new EqPlayer("Joe");
    $player2 = new EqPlayer("Joe");

    $this->assertTrue($team->setPlayers(array($player1, $player2)));
    $this->assertTrue($player1 === $team->getPlayer_index(0));
    $this->assertTrue($player2 === $team->getPlayer_index(1));
    $this->assertTrue($team === $player1->getTeam());
    $this->assertTrue($team === $player2->getTeam());
    $this->assertFalse($leaving1->hasTeam());
    $this->assertFalse($leaving2->hasTeam());
  }

  public function test_setOptionalNToMany_keepsValueEqualWorkersApart()
  {
    $project = new EqProject("Umple");
    $worker1 = new EqWorker("Joe");
    $worker2 = new EqWorker("Joe");
    $worker3 = new EqWorker("Joe");

    $this->assertTrue($project->setWorkers(array($worker1, $worker2)));
    $this->assertTrue($project->setWorkers(array($worker2, $worker3)));
    $this->assertEqual(2, $project->numberOfWorkers());
    $this->assertEqual(0, $worker1->numberOfProjects());
    $this->assertEqual(1, $worker2->numberOfProjects());
    $this->assertEqual(1, $worker3->numberOfProjects());
  }

  public function test_setOptionalNToMany_findsKeyedObjectByKey()
  {
    $project = new EqProject("Umple");
    $skill = new EqSkill("PHP", 1);
    $sameSkill = new EqSkill("PHP", 2);

    $this->assertFalse($project->setSkills(array($skill, $sameSkill)));
    $this->assertTrue($project->setSkills(array($skill)));
    $this->assertEqual(0, $project->indexOfSkill($sameSkill));
  }

  public function test_keyWithOneAssociation_comparesTheAssociatedObjectWithEquals()
  {
    $garage = new EqGarage();
    $owner1 = new EqPerson("Ann");
    $owner2 = new EqPerson("Ann");
    $car1 = new EqCar("ABC123", $owner1, $garage);
    $car2 = new EqCar("ABC123", $owner2, $garage);

    $this->assertEqual(2, $garage->numberOfCars());
    $this->assertFalse($car1->equals($car2));
    $this->assertTrue($car1->equals(new EqCar("ABC123", $owner1, new EqGarage())));
  }

  public function test_keyWithManyAssociation_comparesTheAssociatedObjectsWithEquals()
  {
    $shelf1 = new EqShelf();
    $shelf2 = new EqShelf();
    $book = new EqBook("Dune");
    $shelf1->addBook($book);
    $shelf2->addBook(new EqBook("Dune"));

    $this->assertFalse($shelf1->equals($shelf2));
    $this->assertTrue($shelf1->equals($shelf1));
    $this->assertTrue((new EqShelf())->equals(new EqShelf()));
  }

  public function test_setUnidirectional_acceptsNullAndRejectsKeyDuplicates()
  {
    $bag = new EqBag();
    $skill = new EqSkill("PHP", 1);

    $this->assertTrue($bag->setSkills(array($skill, null, new EqSkill("SQL", 1))));
    $this->assertEqual(3, $bag->numberOfSkills());
    $this->assertFalse($bag->setSkills(array($skill, new EqSkill("PHP", 2))));
  }

  public function test_keyWithManyAssociation_comparesNullItems()
  {
    $bag1 = new EqBag();
    $bag2 = new EqBag();
    $bag3 = new EqBag();
    $bag1->addSkill(null);
    $bag2->addSkill(null);
    $bag3->addSkill(new EqSkill("PHP", 1));

    $this->assertTrue($bag1->equals($bag2));
    $this->assertFalse($bag1->equals($bag3));
    $this->assertFalse($bag3->equals($bag1));
  }

  public function test_setOneToMany_movesToEqualKeyOwner()
  {
    $owner1 = new EqKeyedOwner("same", "old");
    $owner2 = new EqKeyedOwner("same", "new");
    $member = new EqKeyedMember("Joe", $owner1);

    $this->assertTrue($member->setOwner($owner2));
    $this->assertTrue($owner2 === $member->getOwner());
    $this->assertEqual(0, $owner1->numberOfMembers());
    $this->assertEqual(1, $owner2->numberOfMembers());
  }

  public function test_setOptionalOneToOptionalOne_takesEqualKeyPartner()
  {
    $partner1 = new EqKeyedPartner("same", "old");
    $partner2 = new EqKeyedPartner("same", "new");
    $pet = new EqKeyedPet("Rex");
    $partner1->setPet($pet);

    $this->assertTrue($pet->setPartner($partner2));
    $this->assertTrue($partner2 === $pet->getPartner());
    $this->assertTrue($pet === $partner2->getPet());
    $this->assertFalse($partner1->hasPet());
  }

}
?>
