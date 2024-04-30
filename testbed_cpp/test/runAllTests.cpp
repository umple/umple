#include <iostream>
#include <filesystem>
#include <fstream>
#include <cstdlib>
#include <vector>
#include <unordered_set>
#include <unordered_map>
#include <regex>
#include <sstream> 

namespace fs = std::filesystem;

// Executes a shell command and returns the success status.
int runCommand(const std::string& command, bool& success) {
    //std::cout << "Running command: " << command << std::endl;
    int result = std::system(command.c_str());
    success = (result == 0);// Success if the result is zero
    if (!success) {
        std::cerr << "Command failed with exit code: " << result << std::endl;
    }
    return result;
}

// Parses test files for required cpp file paths based on #include statements.
std::string collectRequiredCppFiles(const std::string& testFilePath, const std::string& sourceDir) {
    std::ifstream testFile(testFilePath);
    std::string line;
    std::regex includeRegex(R"(#include\s+\"(..\/RTCpp\/)([^"]+)\")");// Adjusted to match includes directly in "RTCpp/"
    std::unordered_set<std::string> includedFiles;

    while (getline(testFile, line)) {
        std::smatch matches;
        if (std::regex_search(line, matches, includeRegex) && matches.size() > 2) {
            std::string cppFile = sourceDir + "/RTCpp/" + matches[2].str().substr(0, matches[2].str().rfind(".")) + ".cpp";
            includedFiles.insert(cppFile);// Insert full path to cpp file
        }
    }

    std::string files;
    for (const auto& file : includedFiles) {
        files += " " + file;// Concatenate all file paths with a space
    }
    return files;
}

// Searches for the most recent Umple JAR file in a directory
std::string findUmpleJar(const std::string& directory) {
    std::string latestJar;
    auto latestTime = fs::file_time_type::min();

    for (const auto& entry : fs::directory_iterator(directory)) {
        std::string filename = entry.path().filename().string();
        if (filename.rfind("umple-", 0) == 0 && filename.find(".jar") != std::string::npos) {
            auto currentFileTime = fs::last_write_time(entry);
            if (currentFileTime > latestTime) {
                latestTime = currentFileTime;
                latestJar = entry.path().string();
            }
        }
    }
    return latestJar;
}

// Generates an HTML formatted report but saves it as a .txt file.
std::string generateSummaryReport(const std::unordered_map<std::string, bool>& testResults) {
    std::ostringstream reportStream;
    int totalTests = testResults.size();
    int failedTests = std::count_if(testResults.begin(), testResults.end(),
                                    [](const auto& result) { return !result.second; });
    double failRate = 100.0 * failedTests / totalTests;

    // Generate the report formatted as HTML
    reportStream << "<!DOCTYPE html>\n"
                 << "<html><head><title>Test Report</title></head><body>\n"
                 << "<h1>Test Results Summary</h1>\n"
                 << "<p>Total Tests: " << totalTests << "</p>\n"
                 << "<p>Failed Tests: " << failedTests << "</p>\n"
                 << "<p>Failure Rate: " << failRate << "%</p>\n"
                 << "<h2>List of Failed Tests:</h2>\n<ul>\n";

    for (const auto& result : testResults) {
        if (!result.second) {
            reportStream << "<li>" << result.first << "</li>\n";
        }
    }

    reportStream << "</ul>\n</body></html>";

    return reportStream.str();
}

int main() {
    std::unordered_map<std::string, bool> testResults;
    // Determine operating system-specific paths and file extensions
    std::string umpleJar;
    std::string prefix;
    #if defined(_WIN32) || defined(_WIN64)
    umpleJar = findUmpleJar("..\\..\\dist");
    if (umpleJar.empty()) {
            umpleJar = findUmpleJar("..\\..\\dist\\gradle\\libs");
        }
    prefix = "";
    #else
    umpleJar = findUmpleJar("../../dist");
    if (umpleJar.empty()) {
            umpleJar = findUmpleJar("../../dist/gradle/libs");
        }
    prefix = "./";
    #endif

    if (umpleJar.empty()) {
        std::cerr << "No Umple JAR file found." << std::endl;
        return 1;
    }

    std::string umpleFile = "generate_test.ump";
    std::string compileCommand = "java -jar " + umpleJar + " " + umpleFile;
    bool compileSuccess;

    // Execute Umple compilation command
    runCommand(compileCommand, compileSuccess);
    if (!compileSuccess) {
        std::cerr << "Error compiling Umple file: " << umpleFile << std::endl;
        return 1; // Stop if Umple compilation fails
    }


    // Compile C++ test files in associations and attributes directories
    std::vector<std::string> testDirs = {"associations", "attributes"};
    for (const auto& dir : testDirs) {
        for (const auto& file : fs::directory_iterator(dir)) {
            if (file.path().extension() == ".cpp") {
                std::string filePath = file.path().string(); // Full path to the cpp file
                std::string testName = file.path().stem().string(); // Extracts the base name for executable
                std::string requiredSources = collectRequiredCppFiles(filePath, ".");
                std::string compileTestCmd = "g++ -std=c++11 -o " + testName + requiredSources + " " + filePath + " -I./RTCpp -Wno-deprecated -Wno-write-strings -Wno-return-type -Wno-pointer-arith";
                std::string runTestCmd = prefix + testName;
                bool success;


                runCommand(compileTestCmd, success);
                if (success) {
                    runCommand(runTestCmd, success);
                }

                testResults[testName] = success;
            }
        }
    }

    std::string testSummary = generateSummaryReport(testResults);

    // Save the HTML report as a .txt file
    std::ofstream summaryFile("test_summary.txt");
    summaryFile << testSummary;
    summaryFile.close();

    // Inform user of success
    std::cout << "All tests completed successfully." << std::endl;
    return 0;
}

