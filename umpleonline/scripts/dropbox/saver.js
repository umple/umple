DropboxSaver = {};

DropboxSaver.init = function() {
  jQuery(".dropbox-saver").each(function() {
    var link = DropboxSaver.getAbsoluteLink();
    console.log(link);
    var saver = Dropbox.createSaveButton({
      files: [{url: link}],
      error: function(err) {
        Page.setFeedbackMessage("Cannot save to the chosen Dropbox location.");
      },
    });
    jQuery(this).append(saver);
  });
}

DropboxSaver.getAbsoluteLink = function() {
  var a = document.createElement('a');
  a.href = Page.getFilename();
  return a.href;
}
