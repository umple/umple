/implementation is the main directory for unit tests that verify code generation output.

Unit tests have 3 types of files:
    - The .java files which run the junit tests.
    - The .ump files which are the input code for the tests.
    - The language specific .txt files which are the expected output code for the tests.



Items in /implementation:
    - The .java and .ump files for tests that run on multiple languages are kept in /implementation.
         - These tests are typically inherited/run for Java, Python, Php, and Ruby.
    - Subdirectories for language specific testing and the .txt outputs for each language.


Items in language subdirectories:
    - The .txt output files for any tests of this language.
    - The .java files which inherit from the /implementation .java files. 
         - This is required to run the tests; any .java file in /implementation that is not inherited will not be run for this language.
         - Although discouraged, tests can be ignored for this language using the @Ignore tag (See Issue 757)
         - Tests can be added to this file with @Test in order to run them only for this language. 
