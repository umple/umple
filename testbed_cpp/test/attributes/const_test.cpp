#include <iostream>
#include <cassert>
#include <ctime>
#include "Const.h"

void const_test() {
    // Create time objects for testing
    time_t rawtime;
    time(&rawtime);
    tm* timeInfo = localtime(&rawtime);

    // Create const objects with various parameters
    Const constObject1(1, "TestString1", "TestString2", 3.14f, 2.718, true, timeInfo, &rawtime);
    Const constObject2(constObject1);  // Copy constructor


    // Test getters
    assert(constObject1.getI() == 1);
    assert(constObject1.getStr() == "TestString1");
    assert(constObject1.getFlt() == 3.14f);
    assert(constObject1.getDbl() == 2.718);
    assert(constObject1.getBln() == true);

    // Change attributes using setters
    constObject1.setI(2);
    constObject1.setStr("ChangedString");
    constObject1.setFlt(1.41f);
    constObject1.setDbl(1.618);
    constObject1.setBln(false);

    // Verify changes
    assert(constObject1.getI() == 2);
    assert(constObject1.getStr() == "ChangedString");
    assert(constObject1.getFlt() == 1.41f);
    assert(constObject1.getDbl() == 1.618);
    assert(constObject1.getBln() == false);

    // Output results
    std::cout << "Const test passed successfully." << std::endl;
}

int main() {
    const_test();
    return 0;
}
