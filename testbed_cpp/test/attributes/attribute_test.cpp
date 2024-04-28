#include <iostream>
#include <cassert>
#include "../RTCpp/Chat.h"

void attribute_test() {
    
    Chat chat1(1, "Initial", 3.14f, "User1");
    
    // Testing getters
    assert(chat1.getI() == 1);
    assert(chat1.getStr() == "Initial");
    assert(chat1.getU() == "User1");
    assert(chat1.getF() == 3.14f);


    // Testing setters
    chat1.setI(2);
    chat1.setU("User2");
    chat1.setF(-3.14f);

    // Verify changes
    assert(chat1.getI() == 2);
    assert(chat1.getStr() != "Updated");
    assert(chat1.getU() == "User2");
    assert(chat1.getF() == -3.14f);

    // Print results to validate visually
    std::cout << "Attribute test passed successfully." << std::endl;
}

int main() {
    attribute_test();
    return 0;
}
