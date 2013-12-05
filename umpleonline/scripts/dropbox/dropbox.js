jQuery(document).ready(function() {
  jQuery('.dropbox-add-saver')
  .addClass('dropbox-option')
  .append('<li><span class="dropbox-button-saver"></span></li>');
  jQuery('.dropbox-add-chooser')
  .addClass('dropbox-option')
  .append('<li><input type="dropbox-chooser" class="dropbox-button-chooser"/></li>');
  DropboxChooser.init();
  DropboxSaver.init();
});

DropboxMaster = {
  resetTimeout: 2000,
};
