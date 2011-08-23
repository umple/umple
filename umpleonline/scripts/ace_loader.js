window.onload = function() {
	var editor = ace.edit("umpleModelEditor");
	editor.setTheme("ace/theme/clouds");
	var JavaScriptMode = require("ace/mode/java").Mode;
	editor.getSession().setMode(new JavaScriptMode());
};
