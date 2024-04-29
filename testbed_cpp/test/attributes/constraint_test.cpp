#include <iostream>
#include <exception>
#include "../RTCpp/Alcohol.h"

void constraint_test() {
    try {
        Alcohol drinkA(23);  // Valid age, should be successful.
        
        try {
            Alcohol drinkB(20);  // Invalid age, should throw an exception.
            std::cout << "Constraint test failed: drinkB was created with invalid age." << std::endl;
        } catch (const char* msg) {
            // std::cout << "Caught an exception for drinkB as expected: " << msg << std::endl;
        }
        
        std::cout << "Constraint test completed successfully." << std::endl;
    } catch (const char* msg) {
        std::cout << "Unexpected exception: " << msg << std::endl;
    }
}

int main() {
    constraint_test();
    return 0;
}
