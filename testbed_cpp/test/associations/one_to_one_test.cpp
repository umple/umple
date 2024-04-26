#include <iostream>
#include <cassert>
#include "src/Instructor.h"
#include "src/Course.h"

void one_to_one_test() {
    // Create an Instructor and a Course
    Instructor instructor("Dr. Smith");
    Course course("Biology 101");

    // Initially, no instructor is set
    assert(course.getInstructor() == nullptr);

    // Associate the Course with the Instructor
    bool set = instructor.setCourse(&course);

    // Test if the Course has been successfully linked to the Instructor
    assert(set == true);
    assert(course.getInstructor() == &instructor);
    assert(instructor.getCourse() == &course);

    // Create another Instructor
    Instructor anotherInstructor("Dr. Johnson");

    // Try to set the new instructor for the course which already has one
    set = anotherInstructor.setCourse(&course);

    // Test should confirm that course can only be linked with one instructor at a time
    assert(set == true);
    assert(course.getInstructor() == &anotherInstructor);
    assert(anotherInstructor.getCourse() == &course);

    // The first instructor should no longer have a course linked
    assert(instructor.getCourse() == nullptr);

    std::cout << "One-to-one association test passed successfully." << std::endl;
}

int main() {
    one_to_one_test();
    return 0;
}
