// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Loads all the js code for UmpleLine

// ** CSS ***

// Jquery
document.write('<link href="scripts/jquery/showLoading/css/showLoading.css" rel="stylesheet" media="screen" /> ');
document.write('<link href="scripts/jquery/jquery-ui-1.13.2.min.css" rel="stylesheet" media="screen" /> ');

// Syntax highlighter
document.write('<link href="scripts/shCore.css" rel="stylesheet" type="text/css" />');
document.write('<link href="scripts/shThemeDefault.css" rel="stylesheet" type="text/css" id="shThemeDefault" />');
document.write('<link href="scripts/shThemeMidnight.css" rel="stylesheet" type="text/css" id="shThemeMidnight" disabled />');

// Code mirror
document.write('<link href="scripts/CodeMirror/lib/codemirror.css" rel="stylesheet" type="text/css" />');

// Dropbox
document.write('<link href="scripts/dropbox/dropbox.css" rel="stylesheet" type="text/css"/>');

// Umple
document.write('<link href="scripts/styles.css" rel="stylesheet" type="text/css" />');

// JointJS
document.write('<link href="scripts/jjs/joint.css" rel="stylesheet" type="text/css" />');


// *** JAVASCRIPT ***

//JQUERY
document.write('<script type="text/javascript" src="scripts/jquery/jquery-3.6.3.min.js"></script>');
// Jquery UI
document.write('<script type="text/javascript" src="scripts/jquery/jquery-ui-1.13.2.min.js"></script>');
document.write('<script type="text/javascript" src="scripts/jquery.ui.touch-punch.min.js"></script>');
// JQuery Plugins
document.write('<script type="text/javascript" src="scripts/jquery/showLoading/js/jquery.showLoading.min.js"></script>');

//Mouse shortcut
document.write('<script type="text/javascript" src="scripts/mousetrap.min.js"></script>');

// Dropbox
//document.write('<script type="text/javascript" src="https://www.dropbox.com/static/api/1/dropins.js" id="dropboxjs" data-app-key="akix6305j3tm11i"></script>');


// CodeMirror (cannot be minified due to logic that includes other files)
document.write('<script type="text/javascript" src="scripts/CodeMirror/lib/codemirror.js"></script>');
document.write('<script type="text/javascript" src="scripts/CodeMirror/mode/clike/clike.js"></script>');  // contains C-like mode

// CodeMirror addons
document.write('<script type="text/javascript" src="scripts/CodeMirror/addon/fold/foldcode.js"></script>');
document.write('<script type="text/javascript" src="scripts/CodeMirror/addon/fold/foldgutter.js"></script>');
document.write('<script type="text/javascript" src="scripts/CodeMirror/addon/fold/brace-fold.js"></script>');
document.write('<script type="text/javascript" src="scripts/CodeMirror/addon/search/searchcursor.js"></script>');
document.write('<script type="text/javascript" src="scripts/CodeMirror/addon/edit/matchbrackets.js"></script>');

// socket io to connect to UmpleCollabServer using sockets
document.write('<script type="text/javascript" src="scripts/socket.io/socket.io.js"></script>');

// OpenAI SDK
document.write('<script type="text/javascript" src="scripts/openai-sdk/openai.bundle.js"></script>');

// ====== The following minified version of the subsequent group can be commented out when testing
// Regenerate this using the allumple-minifyscript unix script (relies on esbuild, formerly yuicompressor)
// regenerated in the build using ant -f build.umple.xml compressAllScripts
document.write('<script type="text/javascript" src="scripts/allumple-min.js"></script>');

// ------ The following should be commented out, and the above min version used, except when testing
// If you change any constituent file, regenerate allumple-min.js as above
/*

//Prototype
document.write('<script type="text/javascript" src="scripts/prototype.js"></script>');

//General helpers
document.write('<script type="text/javascript" src="scripts/dom.js"></script>');
document.write('<script type="text/javascript" src="scripts/ajax.js"></script>');
document.write('<script type="text/javascript" src="scripts/helper.js"></script>');
document.write('<script type="text/javascript" src="scripts/json.js"></script>');
document.write('<script type="text/javascript" src="scripts/debugger.js"></script>');

//Syntax Highlighter
document.write('<script type="text/javascript" src="scripts/shCore.js"></script>');
document.write('<script type="text/javascript" src="scripts/shBrushJava.js"></script>');
document.write('<script type="text/javascript" src="scripts/shBrushPython.js"></script>');
document.write('<script type="text/javascript" src="scripts/shBrushPhp.js"></script>');
document.write('<script type="text/javascript" src="scripts/shBrushRuby.js"></script>');
document.write('<script type="text/javascript" src="scripts/shBrushSql.js"></script>');
document.write('<script type="text/javascript" src="scripts/shBrushCpp.js"></script>');
document.write('<script type="text/javascript" src="scripts/shBrushAlloy.js"></script>');
document.write('<script type="text/javascript" src="scripts/shBrushNuSMV.js"></script>');
document.write('<script type="text/javascript" src="scripts/shBrushXml.js"></script>');

//INLINE EDITING
document.write('<script type="text/javascript" src="scripts/inlineeditor.js"></script>');

// Dropbox internal

document.write('<script type="text/javascript" src="scripts/dropbox/dropbox.js"></script>');
document.write('<script type="text/javascript" src="scripts/dropbox/chooser.js"></script>');
document.write('<script type="text/javascript" src="scripts/dropbox/saver.js"></script>');

// AI modules
document.write('<script type="text/javascript" src="scripts/ai/config/umple_ai_config.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/core/umple_ai_errors.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/core/umple_ai_storage.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/core/umple_ai_chat_context.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/utils/umple_ai_constants.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/utils/umple_ai_provider_utils.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/utils/umple_ai_prompt_utils.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/utils/umple_ai_text_utils.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/utils/umple_ai_markdown_utils.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/utils/umple_ai_stream_utils.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/core/umple_ai_config_validation.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/core/umple_ai_compiler_service.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/core/umple_ai_providers.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/core/umple_ai_controller.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/prompts/umple_ai_base_prompt.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/features/settings/umple_ai_settings_view.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/features/settings/umple_ai_settings.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/features/requirements/umple_ai_requirements-prompt_builder.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/features/requirements/umple_ai_requirements_dialog.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/features/requirements/umple_ai_requirements_self_correction.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/features/requirements/umple_ai_requirements.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/features/explain/umple_ai_explain-prompt_builder.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/features/explain/umple_ai_explain.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/features/fix/umple_ai_fix-prompt_builder.js"></script>');
document.write('<script type="text/javascript" src="scripts/ai/features/fix/umple_ai_fix.js"></script>');

//Umple System
document.write('<script type="text/javascript" src="scripts/umple_page.js"></script>');
document.write('<script type="text/javascript" src="scripts/umple_layout.js"></script>');
document.write('<script type="text/javascript" src="scripts/umple_action.js"></script>');
document.write('<script type="text/javascript" src="scripts/umple_position.js"></script>');
document.write('<script type="text/javascript" src="scripts/umple_line.js"></script>');
document.write('<script type="text/javascript" src="scripts/umple_system.js"></script>');
document.write('<script type="text/javascript" src="scripts/umple_class.js"></script>');
document.write('<script type="text/javascript" src="scripts/umple_association.js"></script>');
document.write('<script type="text/javascript" src="scripts/umple_generalization.js"></script>');
document.write('<script type="text/javascript" src="scripts/umple_transition.js"></script>');
document.write('<script type="text/javascript" src="scripts/umple_attribute.js"></script>');
document.write('<script type="text/javascript" src="scripts/umple_method.js"></script>');
document.write('<script type="text/javascript" src="scripts/umple_history.js"></script>');
document.write('<script type="text/javascript" src="scripts/umple_restore.js"></script>');
document.write('<script type="text/javascript" src="scripts/umple_action_diagram.js"></script>');
document.write('<script type="text/javascript" src="scripts/umple_tooltips.js"></script>');
document.write('<script type="text/javascript" src="scripts/umple_tab_control.js"></script>');
//CRUD UI
document.write('<script type="text/javascript" src="scripts/umple_crudui.js"></script>');
// The following script includes configuration file for collab_server
// where serverURL and path have to be set to connect specific instance of a collaboration server
document.write('<script type="text/javascript" src="scripts/collab-server-config.js"></script>')

//For styling and colouring statetables
document.write('<script type="text/javascript" src="scripts/statetable/state_table_colourer.js"></script>');

*/

// ----------- END OF FILES THAT ARE MINIFIED -----------

document.write('<script type="text/javascript" src="scripts/umpleCollab.js"></script>');
document.write('<script type="text/javascript" src="scripts/structureDiagram.js" ></script>');

// JointJS support from local directories

document.write('<script type="text/javascript" src="scripts/jjs/index.js"></script>');
document.write('<script type="text/javascript" src="scripts/jjs/backbone.js"></script>');
document.write('<script type="text/javascript" src="scripts/jjs/graphlib.min.js"></script>');
document.write('<script type="text/javascript" src="scripts/jjs/dagre.min.js"></script>');
document.write('<script type="text/javascript" src="scripts/jjs/joint.js"></script>');

// Own plug-in for JointJS to draw the state machines
document.write('<script type="text/javascript" src="scripts/jjs/joint.shapes.umpleuml.js"></script>');
// Own plug-in for JointJS to draw the state machines
document.write('<script type="text/javascript" src="scripts/jjs/joint.shapes.uml-state-machine.js"></script>');
// Own script to glue Umple to JointJS
document.write('<script type="text/javascript" src="scripts/jjs/jjs_parse.js"></script>');


// JointJS support from CDN OBSOLETE
// document.write('<script src="https://cdnjs.cloudflare.com/ajax/libs/lodash.js/4.16.4/lodash.min.js"></script>');
// document.write('<script src="https://cdnjs.cloudflare.com/ajax/libs/backbone.js/1.3.3/backbone-min.js"></script>');
// document.write('<script src="https://cdnjs.cloudflare.com/ajax/libs/jointjs/1.0.1/joint.js"></script>');
// document.write('<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jointjs/1.0.1/joint.min.css" />');

// GREYBOX OBSOLETE
//document.write('<script type="text/javascript">var GB_ROOT_DIR = "./scripts/";</script>');
//document.write('<script type="text/javascript" src="scripts/AJS.js"></script>');
//document.write('<script type="text/javascript" src="scripts/AJS_fx.js"></script>');
//document.write('<script type="text/javascript" src="scripts/gb_scripts.js"></script>');
//document.write('<link href="scripts/gb_styles.css" rel="stylesheet" type="text/css" media="all" />');

// OBSOLETE
//document.write('<script type="text/javascript" src="scripts/scriptaculous.js"></script>');
