<?php
// Copyright: All contributors to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Main program that generates UmpleOnline
require_once ("scripts/compiler_config.php");
cleanupOldFiles();

if (isset($_REQUEST["model"])) {
  if (!is_file("ump/".$_REQUEST["model"]."/model.ump")) {
  
  
    header('HTTP/1.0 404 Not Found');
    readfile('../404.shtml');
    exit();
  }
}

$diagramtype = "";
$isCachedExample = false;
$imageoutput="";
$messageurl="";
if (isset($_REQUEST['example']) && $_REQUEST["example"] != "") {
  $cachedimage= "ump/imagecache/".htmlspecialchars($_REQUEST['example']).".svg";
  if (file_exists($cachedimage))
  {
    $isCachedExample=true;
  }
  else
  {
    $cachedimage= "ump/imagecachesm/".htmlspecialchars($_REQUEST['example']).".svg";
    if (file_exists($cachedimage))
    {
      $isCachedExample=true;
      $diagramtype="&diagramtype=state";
    }
  }
  if($isCachedExample) {
    $imageoutput = "<br/><iframe src=\"".$cachedimage."\"></iframe><br\>";
    $messageURL = "<a href=\"?example=".$_REQUEST['example'].$diagramtype."\">URL for ".$_REQUEST['example']." example</a>";
  }
}

$filename = extractFilename();

// Core options after ? and between &. One of the first four is allowed

// example=xxx means load the .ump file named xxx

// filename=xxx means load the URL named xxx (but without the leading http://

// model=nnnn means load the saved bookmark

// text=zzzzz means load the URLencoded text for short examples (as in the user manual)

// nochrome means hide the banner at the top to save real estate
if (isset($_REQUEST["nochrome"])) {$showChrome=false;} else {$showChrome=true;}

// nodiagram means suppress creation of the diagram - passed to JavaScript
if (isset($_REQUEST["nodiagram"])) {$showDiagram=false;} else {$showDiagram=true;}

// diagramtype means choose some diagram other than the default which is class
$diagramType = "class";
if (isset($_REQUEST["diagramtype"])) {
  $diagramType=$_REQUEST["diagramtype"];
  if ($diagramType=="state") $diagramType = "GvState";
  else if ($diagramType !="GvState" && $diagramType !="GvClass") $diagramType = "class";
}

// notext means suppress creation of the text pane - passed to JavaScript
// ignored if nodiagram is also set
if ($showDiagram && isset($_REQUEST["notext"])) {$showText=false;} else {$showText=true;}

// nomenu means suppress display of menu. Can only happen if diagram OR text hidden
if ((!$showDiagram || !$showText) && isset($_REQUEST["nomenu"])) {$showMenu=false;} else {$showMenu=true;}

// readOnly means suppress ability to edit - passed to JavaScript
$readOnly = isset($_REQUEST["readOnly"]);

$output = readTemporaryFile("ump/" . $filename);
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script src="scripts/_load.js" type="text/javascript"></script>
  <title>UmpleOnline: Generate Java, C++, PHP, or Ruby code from Umple</title>
  <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
</head>
<body>
<?php if ($showChrome) { ?>
  <table class="pagetitle">
<?php } else { ?>
  <table class="pagetitle" style="display:none;">
<?php } ?>
    <tr>
      <td>
        <img src="scripts/umpleonline_title.jpg" title="UmpleOnline - Draw and Type your next model" />
      </td>
      <td>
        <p class="pagedescription">
        Draw on the right, write (Umple) model code on the left. Generate Java, C++, PHP or Ruby code from your models. <br/>
        Visit <a href="http://manual.umple.org" target=helppage">the User Manual</a> or <a href="http://www.umple.org">the Umple Home Page</a> for help.
        &nbsp;&nbsp;&nbsp;<a href="download_eclipse_umple_plugin.html">Download Umple</a>
        &nbsp;&nbsp;&nbsp;<a href="http://code.google.com/p/umple/issues/entry" target="newissue">Report an Issue</a>


        </p>
      </td>
    </tr>
  </table>

  <noscript>
    <br/><font color="red">JavaScript is disabled so the dynamic features of this page will not work. To use UmpleOnline, turn Javascript on. Otherwise you can download the command-line Umple compiler or use Eclipse.</font>
<?php echo $imageoutput ?>
    <pre>
<?php echo $output ?>
    </pre>
  </noscript> 
          
<input id="filename" type="hidden" value="<?php echo $filename ?>" />
<input id="advancedMode" type="hidden" value="0" />

<div id="topLine" class="bookmarkableUrl">

<span id=linetext>Line=<input size=2 id=linenum value=1 onChange="Action.setCaretPosition(value);"></input>&nbsp; &nbsp;</span> 

<?php if (isBookmark($filename)) { ?>
  <a id="topBookmarkable" href="umple.php?model=<?php echo extractModelId($filename) ?>">Changes at this URL are saved</a>
<?php } else { ?>
  <a id="topBookmarkable" href="bookmark.php?model=<?php echo extractModelId($filename) ?>">Create Bookmarkable URL</a>
<?php } ?>

&nbsp; &nbsp;<span id=exampleMessage><?php echo $messageURL ?></span> <span id=feedbackMessage></span>

</div>

<table id="container" class="container">

<tr class="mainApplication">   

  <td id="textEditorColumn"  tabIndex="2"  class="textEditorColumn">
    <textarea id="umpleModelEditor" class="umpleModelEditor" wrap="off" rows="48" cols="80">
    </textarea>
    <textarea id="umpleLayoutEditor" class="umpleLayoutEditor" wrap="off"> </textarea>
  </td>
  
  <td id="paletteColumn" class="paletteColumn">

  
    <div class="paletteWrapper" id="paletteWrapper">
    <div id="palette" class="palette">


    <!-- GROUP 1 OF OPTIONS -->
    
      <h3><a href="#">SAVE & RESET</a></h3>
      <div class="section">


        <ul class="first">
          <li class="subtitle">SAVE</li>
<?php if (isBookmark($filename)) { ?>
            <div id="menuBookmarkable" class="bookmarkableUrl"><a href="umple.php?model=<?php echo extractModelId($filename) ?>">Bookmark this Link for Future Use</a></div>
<?php } else { ?>
            <div id="menuBookmarkable" class="bookmarkableUrl"><a href="bookmark.php?model=<?php echo extractModelId($filename) ?>">Save Model For Future Editing</a></div>
<?php } ?>
          <li id="buttonCopy" class="copy"><img src="scripts/copy.png" title="Copy" /> Source</li>
          <li id="buttonCopyEncodedURL" class="copyEncoded"><img src="scripts/copy.png" title="Copy" /> Encoded URL</li>
        </ul>
        
        <ul class="dropbox-add-saver"></ul>
        
        <ul class="second">
          <li class="subtitle">RESET</li>
          <li> <div id="buttonStartOver" class="jQueryPaletteButton" value="Start Over"></div> </li>
        </ul>

      </div>

    
    <!-- GROUP 2 OF OPTIONS -->
          
      <h3><a href="#tools">TOOLS</a></h3>
      <div class="section">

      <ul id="mainLoadMenu" class="first">
        <li class="subtitle"> Load </li>
        <li id="exampleType">
          <select id="inputExampleType" name="inputExampleType" class="button" size = "1">
            <option name = "optionExampleType" id = "cdModels" value="cdModels">Class Diagrams</option>
            <option name = "optionExampleType" id = "smModels" value="smModels">State Machines</option>
          </select>
        </li>
        
        <li id="itemLoadExamples">
          <select id="inputExample" name="inputExample" class="button" size = "1">
            <option name = "optionExample" id = "defaultExampleOption" value="">Select Example</option>
            <option name = "optionExample" value="2DShapes.ump">2DShapes</option>
            <option name = "optionExample" value="AccessControl.ump">Access Control</option>
            <option name = "optionExample" value="Accidents.ump">Accidents</option>
            <option name = "optionExample" value="Accommodations.ump">Accommodations</option>
            <option name = "optionExample" value="AfghanRainDesign.ump">Afghan Rain Design</option>
            <option name = "optionExample" value="AirlineExample.ump">Airline</option>
            <option name = "optionExample" value="BankingSystemA.ump">Banking System A</option>
            <option name = "optionExample" value="BankingSystemB.ump">Banking System B</option>
            <option name = "optionExample" value="CanalSystem.ump">Canal</option>
            <option name = "optionExample" value="Decisions.ump">Decisions</option>            
            <option name = "optionExample" value="OhHellWhist.ump">Card Games</option>
            <option name = "optionExample" value="Claim.ump">Claim (Insurance)</option>
            <option name = "optionExample" value="CommunityAssociation.ump">Community Association</option>
            <option name = "optionExample" value="CoOpSystem.ump">Co-Op System</option>
            <option name = "optionExample" value="DMMOverview.ump">DMM Overview</option>

            <!-- <option name = "optionExample" value="DMMModelElementHierarchy.ump">DMM Model Element Hierarchy</option> -->
            <option name = "optionExample" value="DMMSourceObjectHierarchy.ump">DMM Source Object Hierarchy</option>
            <option name = "optionExample" value="DMMRelationshipHierarchy.ump">DMM Relationship Hierarchy</option>
            <option name = "optionExample" value="DMMExtensionCTF.ump">DMM CTF</option>
            <option name = "optionExample" value="ElectionSystem.ump">Election System</option>
            <option name = "optionExample" value="ElevatorSystemA.ump">Elevator System A</option>
            <option name = "optionExample" value="ElevatorSystemB.ump">Elevator System B</option>
            <option name = "optionExample" value="GenealogyA.ump">Genealogy A</option>
            <option name = "optionExample" value="GenealogyB.ump">Genealogy B</option>
            <option name = "optionExample" value="GenealogyC.ump">Genealogy C</option>
            <option name = "optionExample" value="GeographicalInformationSystem.ump">Geographical Information System</option>
            <option name = "optionExample" value="Hospital.ump">Hospital</option>
            <option name = "optionExample" value="Hotel.ump">Hotel</option>
            <option name = "optionExample" value="Insurance.ump">Insurance</option>
            <option name = "optionExample" value="InventoryManagement.ump">Inventory Management</option>
            <option name = "optionExample" value="Library.ump">Library</option>
            <option name = "optionExample" value="MailOrderSystemClientOrder.ump">Mail Order System- Client Order</option>
            <option name = "optionExample" value="ManufactoringPlantController.ump">Manufacturing Plant Controller</option>   
            <option name = "optionExample" value="Pizza.ump">Pizza System</option>  
            <option name = "optionExample" value="PoliceSystem.ump">Police System</option>
            <option name = "optionExample" value="PoliticalEntities.ump">Political Entities</option>
            <option name = "optionExample" value="realestate.ump">Real Estate</option>
            <option name = "optionExample" value="RoutesAndLocations.ump">Routes And Locations</option>
            <option name = "optionExample" value="School.ump">School</option>
            <option name = "optionExample" value="TelephoneSystem.ump">Telephone System</option>
            <option name = "optionExample" value="UniversitySystem.ump">University System</option>
            <option name = "optionExample" value="VendingMachineClassDiagram.ump">Vending Machine</option>
            <option name = "optionExample" value="WarehouseSystem.ump">Warehouse System</option>

          </select>
        </li>
        
        <li id="itemLoadExamples2">
          <select id="inputExample2" name="inputExample2" class="button" size = "1">
            <option name = "optionExample2" id = "defaultExampleOption2" value="">Select Example</option>
            <option name = "optionExample" value="Booking.ump">Booking (Airline)</option>            
            <option name = "optionExample" value="CanalLockStateMachine.ump">Canal Lock</option>
            <option name = "optionExample" value="CarTransmission.ump">Car Transmission</option>
            <option name = "optionExample" value="ComplexStateMachine.ump">Complex Symbolic</option>
            <option name = "optionExample" value="DigitalWatchNested.ump">Digital Watch Nested</option>
            <option name = "optionExample" value="DigitalWatchFlat.ump">Digital Watch (Flat)</option>
            <option name = "optionExample" value="Elevator_State_Machine.ump">Elevator</option>
            <option name = "optionExample" value="GarageDoor.ump">Garage Door</option>
            <option name = "optionExample" value="Phone.ump">Phone and Lines</option>
            <option name = "optionExample" value="SpecificFlight.ump">Specific Flight (Airline)</option>
            <option name = "optionExample" value="SpecificFlightFlat.ump">Specific Flight (Airline - Flat)</option>
            <option name = "optionExample" value="TrafficLightsA.ump">Traffic Lights</option>
          </select>
        </li>
      </ul>
        
      <ul class="dropbox-add-chooser"></ul>
      
      <ul id="mainDrawMenu" class = "second toggle">
        <li class="subtitle"> Draw </li>
        <li id="buttonAddClass" class="toggleToolItem" name="paletteItem" title="Select and click on the canvas to add a new class."><img id="buttonAddClass" src="scripts/class.png" title="Add Class" /> Class</li>
        <li id="buttonAddAssociation" class="toggleToolItem" name="paletteItem" title="Select and click on a class to draw an association."><img id="buttonAddAssociation" src="scripts/assoc.png" title="Add Assocation" /> Association</li>
        <!-- <li id="buttonBendAssociation" class="toggleToolItem" name="paletteItem"><img id="buttonBendAssociation" src="scripts/assocbend.jpg" title="Bend Assocation" /> Bend Assoc.</li> -->
        <li id="buttonAddGeneralization" class="toggleToolItem" name="paletteItem" title="Select and click on the child class to draw a generalization line to the parent class."><img id="buttonAddGeneralization" src="scripts/generalization.png" title="Add Generalization" /> Generalization</li>
        <li id="buttonDeleteEntity" class="toggleToolItem" name="paletteItem" title="Select and click on an element to remove it from your model."><img id="buttonDeleteEntity" src="scripts/delete.png" title="Delete" /> Delete</li>
        <li id="buttonUndo" name="paletteItem"><img src="scripts/undo.png" title="Undo"> Undo </li>
        <li id="buttonRedo" name="paletteItem"><img src="scripts/redo.png" title="Redo"> Redo </li>
        <li id="buttonSyncDiagram" name="paletteItem"><img id="buttonSyncDiagram" src="scripts/sync_diagram.png" title="Manually sync the diagram" /> Sync Diagram </li>
      </ul>

      <?php generateMenu("") ?>
      
      </div>



    <!-- GROUP 2 OF OPTIONS -->
      
      <h3><a href="#options">OPTIONS</a></h3>
      <div class="section">
        <div id="buttonViewComplete" title="View Complete">Selected view has opened in a new window.</div>
        <ul class="first">
          <li class="subtitle"> Show View </li>
          <li> <input id="buttonShowHideCanvas" class="checkbox" type="checkbox" title="Show/hide the canvas" name="buttonShowHideCanvas" value="buttonShowHideCanvas"/> Diagram (Canvas) -> </li>
          <li> <input id="buttonShowHideTextEditor" class="checkbox" type="checkbox" title="Show/hide the text editor" name="buttonShowHideTextEditor" value="buttonShowHideTextEditor"/> Text Editor <- </li>
          <li id="layoutListItem"> <input id="buttonShowHideLayoutEditor" class="checkbox" type="checkbox" title="Show/hide the layout editor" name="buttonShowHideLayoutEditor" value="buttonShowHideLayoutEditor"/> Layout Editor </li>          
          <li id="layoutListItem"> <input id="buttonToggleAttributes" class="checkbox" type="checkbox"  title="Show/hide Attributes"/> Attributes </li>
          <li id="layoutListItem"> <input id="buttonToggleMethods" class="checkbox" type="checkbox"  title="Show/hide Methods"/> Methods </li>
	</ul>
        <ul>
          <li id="diagramTypeTitle" class="subtitle"> Diagram Type </li>
          <li> <input id="buttonShowEditableClassDiagram" class="radio" type="radio" title="Editable class diagram" name="buttonCanvasType" value="buttonCanvasTypeEditableClassDiagram"/> Editable class diagram</li>
          <li> <input id="buttonShowGvClassDiagram" class="radio" type="radio" title="GraphViz class diagram" name="buttonCanvasType" value="buttonCanvasTypeGvClassDiagram"/> GraphViz class diagram</li>
          <li> <input id="buttonShowGvStateDiagram" class="radio" type="radio" title="GraphViz state" name="buttonCanvasType" value="buttonCanvasTypeGVStateDiagram"/> GraphViz state diagram</li>
        </ul>
        <ul>
          <li id="preferencesTitle" class="subtitle"> Preferences </li>
          <li id="photoReadyListItem"> <input id="buttonPhotoReady" class="checkbox" type="checkbox" title="Remove editing handles from diagram" name="photoReady" value="photoReady"/> Photo Ready </li>
          <li id="manualSyncListItem"> <input id="buttonManualSync" class="checkbox" type="checkbox" name="manualSync" value="manualSync"/> Manual Sync </li>          
        </ul>
        <ul>
          <li id="canvasSizeTitle" class="subtitle"> Canvas Size </li>
          <li id="buttonSmaller" name="paletteItem"><img id="buttonSmaller" src="scripts/smaller.png" title="Reduce the size of the canvas" /> Smaller</li>
          <li id="buttonLarger" name="paletteItem"><img id="buttonLarger" src="scripts/larger.png" title="Increase the size of the canvas" /> Larger</li>
        </ul>
        <ul>
          <li class="subtitle"> Other Views </li>
          <!--<li id="buttonPngImage" class="png"><img src="scripts/png.png" title="Generate PNG Image" /> PNG View</li>-->
          <li id="buttonYumlImage" class="yuml"><img src="scripts/yuml.png" title="Generate Yuml Image" /> Yuml View</li>
          <li id="buttonSimulateCode" class="simulate"><img src="scripts/simulate.png" title="Simulate Code" /> Simulate</li>

        </ul>
      </div>
    </div>
    </div> 
  </td>
 
  <td id="umpleCanvasColumn" class="umpleCanvasColumn">
    <div id="umpleCanvas"  tabIndex="1" class="surface"></div>
  </td>   
</tr>
</table>
<div id="generatedCodeRow" colspan="3"></div>

<script language="JavaScript">
  Page.init(
    <?php if($showDiagram) { ?> true  <?php } else { ?> false <?php } ?>,
    <?php if($showText) { ?> true  <?php } else { ?> false <?php } ?>,
    <?php if($showMenu) { ?> true  <?php } else { ?> false <?php } ?>,
    <?php if($readOnly) { ?> true  <?php } else { ?> false <?php } ?>,
    "<?php echo $diagramType ?>"); //
</script>



</body>
</html>
