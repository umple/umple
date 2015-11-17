# Contributing to Umple

Please take a moment to review this document in order to make the contribution
process easy and effective for everyone involved!

## Using the issue tracker

Use the issues tracker for:

* [bug reports](#bug-reports)
* [submitting pull requests](#pull-requests)

Please **do not** use the issue tracker for personal support requests nor feature requests. Support requests should be sent to:

* [the umple-dev mailing list](https://groups.google.com/forum/#!forum/umple-dev)

We do our best to keep the issue tracker tidy and organized, making it useful
for everyone. For example, we classify open issues per application and perceived
difficulty of the issue, making it easier for developers to
[contribute to Umple](#contributing).

## Bug reports

A bug is a _demonstrable problem_ that is caused by the code in the repository.
Good bug reports are extremely helpful - thank you!

Guidelines for bug reports:

1. **Use the GitHub issue search** &mdash; [check if the issue has already been
   reported](https://github.com/umple/umple/search?type=Issues).

2. **Check if the issue has been fixed** &mdash; try to reproduce it using the
   `master` branch in the repository.

3. **Isolate and report the problem** &mdash; ideally create a reduced test
   case.

Please try to be as detailed as possible in your report. Include information about
your Operating System, and your Umple version (if not using the latest). Please provide steps to
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
> `<url>` - a link to the reduced test case (e.g. a [GitHub Gist](https://gist.github.com/), or [UmpleOnline](http://cruise.eecs.uottawa.ca/umpleonline/))
>
> Any other information you want to share that is relevant to the issue being
> reported. This might include the lines of code that you have identified as
> causing the bug, and potential solutions (and your opinions on their
> merits).

## Feature requests

Feature requests are welcome and should be discussed on [the umple-core mailing list](https://groups.google.com/forum/#!forum/umple-dev). But take a moment to find
out whether your idea fits with the scope and aims of the project. It's up to *you*
to make a strong case to convince the community of the merits of this feature.
Please provide as much detail and context as possible.

## Contributing

We incentivize everyone to contribute to Umple and help us tackle
existing issues! To do so, there are a few things you need to know
about the code.

The umple project is split into many smaller subproject, the folder hierarchy is explained below to better describe the structure.

* `build` - All build related scripts

* `cruise.umple` - Umple compiler, containers it's own ReadMe.txt, as well as `UmpleTo*` below

* `cruise.umple.eclipse` - *Eclipse plugins*

* `cruise.umplificator` - *Converting outside code to Umple*

* `cruise.umple.validator` - Used by `cruise.umplificator` for validating an umplified project

* `cruise.umple.nebula` - Infrastructure used for real-time C++

* `dev-tools` - Tooling for Umple developers

* `dist` - Contents are not pushed to the repository, and only available after building
  * libs/ *Managed build dependencies that umple*.jar require to run*
  * cruise.umple/reference *User manual*
  * qa/ *Test reports*
  * umple.jar *Command-line Compiler*
  * umpledocs.jar *User manual generator*
  * umplestats.jar *Statistics generation*
  * umplesync.jar *UmpleOnline tool to to synchronize graphical form*
  * vml.jar * Extension for variability modeling*

* `examples` - Developer curated examples
* `externalexamples` - External projects that are used for testing

* `ExternalTextEditorPlugins` - Plugins for external editors, Notepad++, etc

* `sandbox` - A sample project for testing Continuous Integration server

* `testbed` - Test suites for Umple generated Java
* `testbest_ruby` - Test suites for Umple generated Ruby
* `testbest_php` - Test suites for Umple generated PHP

* `UmpleToJava` - Code generation for Java*

* `UmpleToPhp` - Code generation for Php*

* `UmpleToRuby` - Code generation for Ruby*

* `UmpleToRTCpp` - Code generation for Real-time C++ *

* `~~UmpleToCpp/~~` - Code generation for alternative C++ - historical; to be deleted

* `UmpleToSDL` - Code generation to convert Umple to SDL*

* `UmpleToSql` - Code generation SQL from Umple models*

* `UmpleToTemplate` - Template for creating new code generation subprojects*

* `umpleonline` - The UmpleOnline web application
  * UmpleOnline allows generation of code from Umple directly in a web browser, and also editing of Umple both graphically and textually. Available at http://try.umple.org

* `Umplificator` - Reverse engineer code to Umple

* `umplificatoronline` - Online tool for converting code to Umple

* `umpleUI` - Projects for the UIGU tooling
  * Projects for generating a UI through UIGU from Umple. These need work to incorporate them into UmpleOnline

* `umplewww` - Core files from the Umple.org web pages
  * Includes items such as the user manual that are moved at build time into the appropriate place

You will want to ensure you have a [proper development environment](https://github.com/umple/umple/wiki/DevelopmentSetUp),
and that you are familiar with running the build using our [build cheat sheet](https://github.com/umple/umple/wiki/CheatSheet)

After your changes are done, please remember to run the full suite with
`cd build && ant -Dmyenv=local`.

You can check [the official build status on CruiseControl](http://cc.umple.org).

With tests running and passing, you are ready to contribute to Umple and
send your pull requests.

## Pull requests

Good pull requests - patches, improvements, new features - are a fantastic
help. They should remain focused in scope and avoid containing unrelated
commits.

**IMPORTANT**: By submitting a patch, you agree that your work will be
licensed under the license used by the project.

If you have any large pull request in mind (e.g. implementing features,
refactoring code, etc), **please ask first** otherwise you risk spending
a lot of time working on something that the project's developers might
not want to merge into the project.

Please adhere to the coding conventions in the project (indentation,
accurate comments, etc.) and don't forget to add your own tests and
documentation. When working with Git, we recommend the following process
in order to craft an excellent pull request:

1. [Fork](https://help.github.com/fork-a-repo/) the project, clone your fork,
  and configure the remotes:

  ```sh
  # Clone your fork of the repo into the current directory
  git clone https://github.com/<your-username>/umple
  # Navigate to the newly cloned directory
  cd umple
  # Assign the original repo to a remote called "upstream"
  git remote add upstream https://github.com/umple/umple
  ```

2. If you cloned a while ago, get the latest changes from upstream:

  ```sh
  git checkout master
  git pull upstream master
  ```

3. Create a new topic branch (off of `master`) to contain your feature, change,
  or fix.

  **IMPORTANT**: Making changes in `master` is discouraged. You should always
  keep your local `master` in sync with upstream `master` and make your
  changes in topic branches.

  ```sh
  git checkout -b <topic-branch-name>
  ```

4. Commit your changes in logical chunks. Keep your commit messages organized,
  with a short description in the first line and more detailed information on
  the following lines. Feel free to use Git's
  [interactive rebase](https://help.github.com/articles/interactive-rebase)
  feature to tidy up your commits before making them public.

5. Make sure all the tests are still passing.

  ```sh
  cd build ** ant -Dmyenv=local
  ```

  This command will compile the code in your branch and use that
  version of Umple to run the tests. This is needed to ensure your changes can
  pass all the tests.

6. Push your topic branch up to your fork:

  ```sh
  git push origin <topic-branch-name>
  ```

7. [Open a Pull Request](https://help.github.com/articles/using-pull-requests/)
  with a clear title and description.

8. If you haven't updated your pull request for a while, you should consider
  rebasing on master and resolving any conflicts.

  **IMPORTANT**: _Never ever_ merge upstream `master` into your branches. You
  should always `git rebase` on `master` to bring your changes up to date when
  necessary.

  ```sh
  git checkout master
  git pull upstream master
  git checkout <your-topic-branch>
  git rebase master
  ```

Thank you for your contributions!
