#include <iostream>
#include <cassert>
#include "DoorA.h"
#include "DoorB.h"
#include "DoorC.h"

void class_attribute_test() {
    // Create instances of DoorA, DoorB, and DoorC
    DoorA doorA(5);
    DoorB doorB(10);
    DoorC doorC(15);

    // Test getters for initial values
    assert(doorA.getAIntId() == 5);
    assert(doorB.getAIntId() == 10);
    assert(doorC.getAIntId() == 15);

    // Test the setter and getter for DoorA
    assert(doorA.setAIntId(20) == true);
    assert(doorA.getAIntId() == 20);

    // Test the setter and getter for DoorB
    assert(doorB.setAIntId(25) == true);
    assert(doorB.getAIntId() == 25);

    // Test the setter and getter for DoorC
    assert(doorC.setAIntId(30) == true);
    assert(doorC.getAIntId() == 30);


    std::cout << "Class attribute test passed successfully." << std::endl;
}

int main() {
    class_attribute_test();
    return 0;
}
