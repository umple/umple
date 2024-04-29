#include <iostream>
#include <cassert>
#include "../RTCpp/Instructor.h"
#include "../RTCpp/Course.h"

void optional_one_to_one_test() {
    // Create an Instructor without a Course initially
    Instructor instructor("Dr. Smith");
    assert(instructor.getCourse() == nullptr);

    // Create a Course without an Instructor initially
    Course course("Biology 101");
    assert(course.getInstructor() == nullptr);

    // Set the Instructor for the Course
    bool linked = instructor.setCourse(&course);
    assert(linked == true);
    assert(course.getInstructor() == &instructor);
    assert(instructor.getCourse() == &course);

    // Unset the Instructor from the Course
    instructor.setCourse(nullptr);
    assert(instructor.getCourse() == nullptr);
    assert(course.getInstructor() == nullptr);

    // Re-assign the Instructor to the Course to test re-linking
    linked = instructor.setCourse(&course);
    assert(linked == true);
    assert(course.getInstructor() == &instructor);
    assert(instructor.getCourse() == &course);

    std::cout << "Optional one-to-one association test passed successfully." << std::endl;
}

int main() {
    optional_one_to_one_test();
    return 0;
}
