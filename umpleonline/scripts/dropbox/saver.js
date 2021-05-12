DropboxSaver = {};

DropboxSaver.init = function() {
  jQuery(".dropbox-button-saver").each(function() {
    DropboxSaver.createSaverIn(this);
  });
}

DropboxSaver.createSaverIn = function(parent) {
  var link = DropboxSaver.getAbsoluteLink(Page.getFilename());
  var saver = Dropbox.createSaveButton({
    files: [{url: link}],
    success: function() {
      window.setTimeout(function() {
        jQuery(parent).children(".dropbox-dropin-btn").remove();
        DropboxSaver.createSaverIn(parent);
      }, DropboxMaster.resetTimeout);
    },
    error: function(err) {
      console.log(err);
      Page.setFeedbackMessage("Cannot save to the chosen Dropbox location.");
    },
  });
  jQuery(parent).append(saver);
}

DropboxSaver.getAbsoluteLink = function(relativeLink) {
  var a = document.createElement('a');
  a.href = relativeLink.replace(/^\.\.\//, "");
  return a.href;
}
