#include <iostream>
#include <cassert>
#include "src/Folder.h"

void reflexive_many_test() {
    // Create some Folder instances
    Folder rootFolder;
    Folder subFolder1;
    Folder subFolder2;

    // Initially, rootFolder should have no subfolders
    assert(rootFolder.numberOfSubfolders() == 0);

    // Add subFolder1 and subFolder2 to rootFolder
    bool added = rootFolder.addSubfolder(&subFolder1);
    assert(added == true);
    assert(rootFolder.numberOfSubfolders() == 1);

    added = rootFolder.addSubfolder(&subFolder2);
    assert(added == true);
    assert(rootFolder.numberOfSubfolders() == 2);

    // Check if the subfolders have rootFolder as their parent folder
    assert(subFolder1.numberOfFolders() == 1);
    assert(subFolder1.getFolder(0) == &rootFolder);
    assert(subFolder2.getFolder(0) == &rootFolder);

    // Test removing a subfolder
    bool removed = rootFolder.removeSubfolder(&subFolder1);
    assert(removed == true);
    assert(rootFolder.numberOfSubfolders() == 1);
    assert(subFolder1.numberOfFolders() == 0); // subFolder1 should no longer reference rootFolder

    // Test adding a subfolder at a specific index
    added = rootFolder.addSubfolderAt(&subFolder1, 0);
    assert(added == true);
    assert(rootFolder.getSubfolder(0) == &subFolder1);
    assert(rootFolder.numberOfSubfolders() == 2);

    // Check mutual removal
    removed = subFolder1.removeFolder(&rootFolder);
    assert(removed == true);
    assert(subFolder1.numberOfFolders() == 0);
    assert(rootFolder.numberOfSubfolders() == 1);

    std::cout << "Reflexive many-to-many association test passed successfully." << std::endl;
}

int main() {
    reflexive_many_test();
    return 0;
}
