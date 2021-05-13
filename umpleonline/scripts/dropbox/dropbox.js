// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
var DropboxInitializer = {}

DropboxInitializer.initializeDropbox = function() 
{
  jQuery('.dropbox-add-saver')
    .addClass('dropbox-option')
    .append('<li id="ttDropboxSaver"><span class="dropbox-button-saver"></span></li>');
  jQuery('.dropbox-add-chooser')
    .addClass('dropbox-option')
    .append('<li id="ttDropboxChooser"><input type="dropbox-chooser" class="dropbox-button-chooser"/></li>');
  DropboxChooser.init();
  DropboxSaver.init();
};

DropboxMaster = {
  resetTimeout: 2000,
};
