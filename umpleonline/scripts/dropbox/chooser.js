DropboxChooser = {};

DropboxChooser.init = function() {
  jQuery(".dropbox-button-chooser").each(function() {
    this.setAttribute("data-link-type", "direct");
    this.setAttribute("data-extensions", ".ump");
    var button = this;
    this.addEventListener("DbxChooserSuccess", function(e) {
      DropboxChooser.load(e.files[0].link);
    }, false);
  });
}

DropboxChooser.load = function(link) {
  UmpleSystem.merge(null);
  Page.showCanvasLoading(true);
  Page.showModelLoading(true);
  Page.showLayoutLoading(true);
  
  jQuery.get(link)
  .done(function(content) {
    Action.freshLoad = true;
    Page.setUmpleCode(content);
    Page.hideLoading();
    History.save(content, "dropboxLoad");
    Action.updateUmpleDiagram();
    Action.setCaretPosition("0");
    Action.updateLineNumberDisplay();
  })
  .fail(function() {
    Page.setFeedbackMessage("Cannot load from the chosen Dropbox file.");
    Page.hideLoading();
  });
}
