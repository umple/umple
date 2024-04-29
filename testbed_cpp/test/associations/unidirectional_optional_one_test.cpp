#include <iostream>
#include <cassert>
#include "../RTCpp/Group.h"
#include "../RTCpp/Description.h"

void unidirectional_optional_one_test() {
    // Create a Group
    Group* group = new Group("groupA");

    // Initially, no description is set
    assert(group->getDescription() == nullptr);

    // Create and associate a Description with the Group
    Description* description = new Description("description1"); 
    bool set = group->setDescription(description); 

    // Test if the Description has been successfully linked to the Group
    assert(set == true);
    assert(group->getDescription() == description);

    // Reset the description to NULL
    set = group->setDescription(nullptr);

    // Test should confirm that the Group now has no Description linked
    assert(set == true);
    assert(group->getDescription() == nullptr);

    std::cout << "Unidirectional optional one association test passed successfully." << std::endl;
}

int main() {
    unidirectional_optional_one_test();
    return 0;
}
