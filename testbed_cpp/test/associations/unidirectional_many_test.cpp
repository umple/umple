#include <iostream>
#include <cassert>
#include "src/User.h"
#include "src/Account.h"

void unidirectional_many_test() {
    // Create two Users
    User user1;
    User user2;

    // Create several Accounts
    Account* account1 = new Account();
    Account* account2 = new Account();
    Account* account3 = new Account();

    // Adding accounts to user1
    assert(user1.addAccount(account1));
    assert(user1.addAccount(account2));

    // Check the number of accounts for user1
    assert(user1.numberOfAccounts() == 2);

    // Adding and then removing an account
    assert(user1.addAccount(account3));
    assert(user1.numberOfAccounts() == 3);
    assert(user1.removeAccount(account3));
    assert(user1.numberOfAccounts() == 2);

    // Ensure correct accounts are still associated
    assert(user1.getAccount(0) == account1);
    assert(user1.getAccount(1) == account2);

    // Adding accounts to user2 using different approach
    assert(user2.addAccountAt(account3, 0)); // add at beginning
    assert(user2.numberOfAccounts() == 1);
    assert(user2.getAccount(0) == account3);

    // Clean up
    delete account1;
    delete account2;
    delete account3;

    std::cout << "Unidirectional many-to-many association test passed successfully." << std::endl;
}

int main() {
    unidirectional_many_test();
    return 0;
}
