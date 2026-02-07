# Contributing to Umple

Please take a moment to review this document in order to make the contribution
process easy and effective for everyone involved!

## Using the issue tracker

Use the issues tracker for:

* [bug reports](#bug-reports)
* [submitting pull requests](#pull-requests)
* [submitting feature requests](#feature-requests)

Please **check carefully** to see if a bug report or feature request has already been submitted before adding a new one.

We do our best to keep the issue tracker tidy and organized, making it useful
for everyone. For example, we tag open issues by difficulty, urgency, component, and feature making it easier for developers to
[contribute to Umple](#contributing).

## Bug reports

A bug is a _demonstrable problem_ that is caused by the code in the repository.
Good bug reports are extremely helpful - thank you!

Guidelines for bug reports:

1. **Use the GitHub issue search** &mdash; [check if the issue has already been reported](https://github.com/umple/umple/search?type=Issues).

2. **Check if the issue has been fixed** &mdash; try to reproduce it using the
   `master` branch in the repository.

3. **Isolate and report the problem** &mdash; ideally create a reduced test
   case.

Please try to be as detailed as possible in your report. Include information about
your Operating System and the version of the compiler you are using. Please make sure you are using the latest version of Umple. Please provide steps to
reproduce the issue as well as the outcome you were expecting! All these details
will help developers to fix any potential bugs.

Example:

> Short and descriptive example bug report title
>
> A summary of the issue and the environment in which it occurs. If suitable,
> include the steps required to reproduce the bug.
>
> 1. This is the first step
> 2. This is the second step
> 3. Further steps, etc.
>
> `<url>` - a link to the reduced test case (e.g. a [GitHub Gist](https://gist.github.com/), or [UmpleOnline](https://try.umple.org))
>
> Any other information you want to share that is relevant to the issue being
> reported. This might include the lines of code that you have identified as
> causing the bug, and potential solutions (and your opinions on their
> merits).

## Feature requests

Feature requests are welcome. Take a moment to find
out whether your idea fits with the scope and aims of the project. It's up to *you*
to make a strong case to convince the community of the merits of this feature.
Please provide as much detail and context as possible.

## Contributing

Please help us tackle
existing issues! To do so, there are a few things you need to know
about the code.

The umple project is split into many smaller subproject, the folder hierarchy is explained below to better describe the structure.

* `build` - All build related scripts. Also the source files for the user manual are found in the reference subdirectory

* `cruise.umple` - Umple compiler, contains it's own ReadMe.txt, as well as `UmpleTo*` below. The core compiler source code is in the src directory and its subdirectories, and the core compiler tests are below the test subdirectory.

* `cruise.umple.nebula` - Infrastructure used for real-time C++

* `dev-tools` - Tooling for Umple developers

* `dist` - Contents are not pushed to the repository, and only available after building
  * libs/ *Managed build dependencies that umple*.jar require to run*
  * cruise.umple/reference *User manual*
  * qa/ *Test reports*
  * umple.jar *Command-line Compiler* (a symbolic link to the latest version
  * umpledocs.n.n.jar *User manual generator*
  * umplestats.n.n.jar *Statistics generation*
  * umplesync.n.n.jar *UmpleOnline tool to run the internal server of UmpleOnline*

* `sandbox` - A sample project for testing Continuous Integration server

* `testbed` - Test suites for Umple generated Java
* `testbest_ruby` - Test suites for Umple generated Ruby
* `testbest_php` - Test suites for Umple generated PHP

* `UmpleToJava` - Code generation for Java*

* `UmpleToPhp` - Code generation for Php*

* `UmpleToRuby` - Code generation for Ruby*

* `UmpleToRTCpp` - Code generation for C++ *

* `UmpleToSDL` - Code generation to convert Umple to SDL*

* `UmpleToSql` - Code generation SQL from Umple models*

* `UmpleToTemplate` - Template for creating new code generation subprojects*

* `umpleonline` - The UmpleOnline web application
  * UmpleOnline allows generation of code from Umple directly in a web browser, and also editing of Umple both graphically and textually. Available at https://try.umple.org. There is an umplibrary subdirectory that contains many examples, including those that appear in the user manual and UmpleOnline itself.

* `Umplificator` - Reverse engineer code to Umple. Has not been modified for some years.

* `umplewww` - Core files from the Umple.org web pages
  * Includes items used in the user manual that are moved at build time into the appropriate place

You will want to ensure you have a [proper development environment](https://github.com/umple/umple/wiki/DevelopmentSetUp),
and that you are familiar with running the build using our [build cheat sheet](https://github.com/umple/umple/wiki/CheatSheet)

After your changes are done, please remember to run the full suite with the bumple script found in dev-tools

You can check [the build status on Jenkins](https://jenkins.umple.org).

With tests running and passing, you are ready to contribute to Umple and
send your pull requests.

## Pull requests

Good pull requests - patches, improvements, new features - are a fantastic
help. They should remain focused in scope and avoid containing unrelated
commits.

**IMPORTANT**: By submitting a PR, you agree that your work will be
licensed under the license used by the project.

If you have any large pull request in mind (e.g. implementing features,
refactoring code, etc), **please ask first** otherwise you risk spending
a lot of time working on something that the project's developers might
not want to merge into the project.

Please adhere to the coding conventions in the project (indentation,
accurate comments, etc.) and don't forget to add your own tests and
documentation. When working with Git, we recommend the following process
in order to craft an excellent pull request:

1. Clone the project. Do not fork it.

2. If you cloned a while ago, get the latest changes from upstream by doing git pull.

3. Create a new topic branch (off `master`) to contain your feature, change, or fix. Name it with the issue number it is fixing, plus a few words. Do a PR from this branch as soon as possible to help everyone know what you are working on. Mark the PR as DRAFT until you feel it is ready for review.

4. Commit your changes in logical chunks. Keep your commit messages organized,
  with a short description.

5. Make sure all the tests are still passing by doing a full build and checking that all tests are passing (Don't rely on a SUCCESS message).


Thank you for your contributions!
