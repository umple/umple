#include <iostream>
#include <cassert>
#include "../RTCpp/Employee.h"

void reflexive_optional_one_test() {
    // Create Employees
    Employee emp1;
    Employee emp2;
    Employee emp3;

    // Initially, no supervisor is set
    assert(emp1.getSupervisor() == nullptr);
    assert(emp2.getSupervisor() == nullptr);
    assert(emp3.getSupervisor() == nullptr);

    // Associate emp1 as the supervisor of emp2
    bool set = emp2.setSupervisor(&emp1);
    assert(set == true);
    assert(emp2.getSupervisor() == &emp1);
    assert(emp1.getEmployee(0) == &emp2);

    // Associate emp3 as the supervisor of emp1
    set = emp1.setSupervisor(&emp3);
    assert(set == true);
    assert(emp1.getSupervisor() == &emp3);
    assert(emp3.getEmployee(0) == &emp1);

    // Remove emp1 as the supervisor of emp2 and check
    emp1.removeEmployee(&emp2);
    assert(emp2.getSupervisor() == nullptr);
    assert(emp1.numberOfEmployees() == 0);

    // Remove emp1 from emp3 and check
    emp3.removeEmployee(&emp1);
    assert(emp1.getSupervisor() == nullptr);
    assert(emp3.numberOfEmployees() == 0);

    std::cout << "Reflexive optional one association test passed successfully." << std::endl;
}

int main() {
    reflexive_optional_one_test();
    return 0;
}
