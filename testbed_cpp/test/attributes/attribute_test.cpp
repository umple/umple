#include <iostream>
#include <cassert>
#include "Chat.h"

void attribute_test() {
    // Create a Chat object with initial values
    tm currentDate = {0};
    time_t rawtime;
    time(&rawtime);
    tm* timeInfo = localtime(&rawtime);
    
    Chat chat1(1, "Initial", timeInfo, "User1");
    
    // Testing getters
    assert(chat1.getI() == 1);
    assert(chat1.getStr() == "Initial");
    assert(chat1.getU() == "User1");

    // Testing setters
    chat1.setI(2);
    chat1.setU("User2");

    // Verify changes
    assert(chat1.getI() == 2);
    assert(chat1.getStr() != "Updated");
    assert(chat1.getU() == "User2");

    // Print results to validate visually
    std::cout << "Attribute test passed successfully." << std::endl;
}

int main() {
    attribute_test();
    return 0;
}
