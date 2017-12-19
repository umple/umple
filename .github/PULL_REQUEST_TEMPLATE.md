**IMPORTANT**: By submitting a patch, you agree that your work will be licensed under the [license](https://github.com/umple/umple/blob/master/LICENSE.md) used by the project.

If your pull request does not pass CI, it will **not** be merged (unless *heavily* justified). Before submitting, do a git pull to bring in other changes from master; then also do a full build and verify that the words 'error' or 'failure' do not appear anywhere in the build transcript (don't rely on BUILD SUCCESSFUL appearing). The 'bumple' script in dev-tools can help with this.

PRs should always be made from a branch you have created on umple/umple, not from a fork: This ensures that a Docker image of your PR can be automatically generated for manual testing.

## Pull request title

In the title, include a 3-10 word summary of what improvements the PR makes.

If the PR fixes one or more issues, the title must have the format "Fixes #ISSUE_NUM1[, #ISSUE_NUM2...] summary ..." This will automatically close the issue when the PR is merged. If the PR partially fixes an issue, but not completely, say "Progress on #ISSUE_NUM  summary".

If your PR only updates .txt files that are not used in the build, then you can tell Travis and Appeyor to not build by including [ci skip] in the title.

## Pull request description

Select and replace this entire text with a description of what this PR is meant to fix, and how it works (if it's not clear from the code changes). 

## Pull request content

Include automated tests for  every change to the compiler and all other parts of the system where automated tests are possible. 

Add updates to the user manual in build/reference if you are making changes to syntax and semantics

Verify you have included all needed files and have not included extraneous changed files. Make each PR as small (agile) as possible.

After you have submitted a PR, watch the Travis and Appveyor. If the build fails on these CI servers, you can push additional changes to the branch associated with the PR to update it.
