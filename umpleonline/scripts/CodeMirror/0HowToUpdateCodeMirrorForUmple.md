To update CodeMirror for Umple:

CodeMirror has not been updated very often ... the version installed is still version 2.x
But we do need to periodically update, if work on editing is to be done.

1. Back up the CodeMirror directory in which this file is found so you can copy stuff from it

2. Ensure you are working in a clean new branch with no other work. The codeMirror update should be done with a single pull request. And there should be no functional differences to the end user. The purpose of updating is to allow us to then keep developing based on the latest CodeMirror.

3. Download the latest Version of CodeMirror from https://codemirror.net and look at migration information. CodeMirror 6 came out, which has radical changes ,although version 5 is still being updated. It might be nice to keep up with version 6, but on the other hand we need to ensure that Umple keeps working.

4. Ensure you know how to apply the various 'mods' (modifications) that were done in the previous version to the new version. In particular, in the lib, directory codemirror.js and codemirror.css were updated slightly by Umple developers, with the original files baing backed up to files containing -original. So do:

diff *.js

and

diff *.css

in the lib directory. This will highlight where changes were made. In particular, there is a change to enable Umple's history mechanism to be used for undo/redo, and certain small css changes. Figure out how to apply the same functionality to the new version (maybe by doing a mod again, or maybe not).

5. Install the new CodeMirror in place of the old one. Some of the directories may be the same. Copy over this file. Then apply needed mods you have figured out.

6. Look in the _load.js file for references to CodeMirror (use grep). Find the various files such as clike, foldcode, searchcursor and ensure they are now being accessed. Check also for minification that may be takeing place.

7. Use grep to find references to CodeMirror in umple_action.js, umple_layout.js, umple_page.js and make sure all of the references are updated as necessary.

8. When it seems to be working do a commit. Then you can do further commits to the branch if you find more bugs./

9. Test all features of Umple extremely thoroughly in the branch. In particular:
  - Test diagram editing
  - Test undo and redo
  - Test re-indenting code
  - Test loading new examples
  - Test the control codes for features such as switching diagram type.
  
10. Do a pull request for the change.