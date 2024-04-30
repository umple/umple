#include <iostream>
#include <cassert>
#include "../RTCpp/Magazine.h"
#include "../RTCpp/Publisher.h"

void unidirectional_optional_many_test() {
    // Create Magazine   
    Magazine* magazine = new Magazine("magazineA");

    // Initially, no publishers are set
    assert(magazine->numberOfPublishers() == 0);

    // Create several Publishers
    Publisher* publisher1 = new Publisher("publisher1");
    Publisher* publisher2 = new Publisher("publisher2");

    // Add Publishers to the Magazine
    bool add1 = magazine->addPublisher(publisher1);
    bool add2 = magazine->addPublisher(publisher2);

    // Test if the Publishers have been successfully linked to the Magazine
    assert(add1 == true);
    assert(add2 == true);
    assert(magazine->numberOfPublishers() == 2);

    // Test retrieval of added publishers
    assert(magazine->getPublisher(0) == publisher1);
    assert(magazine->getPublisher(1) == publisher2);

    // Remove a Publisher
    bool remove1 = magazine->removePublisher(publisher1);  
    assert(remove1 == true);
    assert(magazine->numberOfPublishers() == 1);
    assert(magazine->getPublisher(0) != publisher1); 

    // Remove all Publishers
    bool remove2 = magazine->removePublisher(publisher2);
    assert(remove2 == true);
    assert(magazine->numberOfPublishers() == 0);

    std::cout << "Unidirectional optional many association test passed successfully." << std::endl;
}

int main() {
    unidirectional_optional_many_test();
    return 0;
}
