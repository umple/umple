#include <iostream>
#include <cassert>
#include "../RTCpp/Mentor.h"
#include "../RTCpp/Student.h"
#include "../RTCpp/Person.h"

void optional_one_to_many_test() {
    // Create a Mentor
    Mentor mentor("Dr. Smith");

    // Initially, the mentor should have no students
    assert(mentor.numberOfStudents() == 0);

    // Create and associate Students with the Mentor
    Student student1("John Doe");
    bool added1 = mentor.addStudent(&student1);
    assert(added1 == true);
    assert(mentor.numberOfStudents() == 1);
    assert(mentor.getStudent(0) == &student1);

    Student student2("Jane Doe");
    bool added2 = mentor.addStudent(&student2);
    assert(added2 == true);
    assert(mentor.numberOfStudents() == 2);
    assert(mentor.getStudent(1) == &student2);

    // Test removing a Student from the Mentor
    bool removed = mentor.removeStudent(&student1);
    assert(removed == true);
    assert(mentor.numberOfStudents() == 1);
    assert(mentor.getStudent(0) == &student2); // Now, only student2 should be associated with the mentor

    // Removing the same student again should fail
    removed = mentor.removeStudent(&student1);
    assert(removed == false);

    std::cout << "Optional one-to-many association test passed." << std::endl;
}

int main() {
    optional_one_to_many_test();
    return 0;
}
