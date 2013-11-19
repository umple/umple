jQuery(document).ready(function() {
  jQuery('span.dropbox-options')
  .append(
    '<input type="dropbox-chooser" class="dropbox-chooser"/> ' +
    '<span class="dropbox-saver"></span> '
  );
  jQuery('ul.dropbox-options')
  .append(
    '<li><input type="dropbox-chooser" class="dropbox-chooser"/></li> ' +
    '<li><span class="dropbox-saver"></span></li> '
  );
  DropboxChooser.init();
  DropboxSaver.init();
});
