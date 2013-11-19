DropboxSaver = {};

DropboxSaver.init = function() {
  jQuery(".dropbox-saver").each(function() {
    var link = DropboxSaver.getAbsoluteLink(Page.getFilename());
    console.log(link);
    var saver = Dropbox.createSaveButton({
      files: [{url: link}],
      error: function(err) {
        console.log(err);
        Page.setFeedbackMessage("Cannot save to the chosen Dropbox location.");
      },
    });
    jQuery(this).append(saver);
  });
}

DropboxSaver.getAbsoluteLink = function(relativeLink) {
  var a = document.createElement('a');
  a.href = relativeLink.replace(/^\.\.\//, "");
  return a.href;
}
