<?php
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Utility functions invoked primarily by compiler.php and umple.php
//
// To run UmpleOnline locally, you may need to set the following constants
// based on your home computer settings

// Windows installations of UmpleOnline Server
//$GLOBALS["JAVA_HOME"] = "C:\Program Files\Java\jdk1.6.0_17";
//$GLOBALS["ANT_EXEC"] = "C:\Ant\apache-ant-1.8.1\bin\ant";
//$GLOBALS["OS"] = "Windows";

// CRUISE SERVER and MAC OS installations
$GLOBALS["JAVA_HOME"] = "/usr/bin/";
$GLOBALS["ANT_EXEC"] = "/h/ralph/cruise/dev/apps/apache-ant-1.8.1/bin/ant";
$GLOBALS["OS"] = "Linux";

// For compatibility with systems that do not have UmpleOnline's shell
// dependencies in their $PATH, add /usr/bin and /usr/local/bin to $PATH
// in the hopes that the programs will be at those locations.
// We gracefully do nothing if the paths are already present.
// If the executables are not in fact at those locations but elsewhere
// and already accessible via $PATH search, adding these redundant
// paths to $PATH will have no effect.
// Note: we append to PATH so that the original system paths still take
// precedence, or we might unwittingly override system administrators'
// settings to prefer different executables than the ones at these paths.
$PATH = getenv("PATH");
if(strpos($PATH, "/usr/bin") == FALSE){
    $PATH .= ":/usr/bin";
}
if(strpos($PATH, "/usr/local/bin") == FALSE){
    $PATH .= ":/usr/local/bin";
}
putenv("PATH=$PATH");

// If we don't set the default timezone we get E_NOTICEs
date_default_timezone_set('UTC');

// Trick to find the root directory of this copy of UmpleOnline
// Assumes this script lives in /scripts; if you move this file it
// will need to change.
$rootDirGlobal = dirname(__DIR__);
function rootDir(){
    global $rootDirGlobal;
    return $rootDirGlobal;
}

/**
A handle to read-only data. As long as it exists it should
hold at least a read lock. When it is destroyed or the request
ends this lock will be released.
*/
class ReadOnlyDataHandle{
    function __construct($root){
        $this->root = $root;
    }
    /**
    Return the unique identifier that this data handle
    points to.
    */
    function getName(){
        return basename($this->root);
    }
    /**
    Returns true if a property with the given name exists.
    */
    function hasData($name){
        return file_exists($this->root.'/'.$name);
    }
    /**
    Reads a property of the data as a string.
    What happens if there is no such data is currently unspecified.
    */
    function readData($name){
        return file_get_contents($this->root.'/'.$name);
    }
    /**
    Upgrades this read-only handle to a read/write handle.
    Returns the new handle, invalidating $this
    */
    function acquireWrite(){
        $result = new DataHandle($this->root);
        $this->root = NULL;
        return $result;
    }
}

/**
Provides access to a data object, allowing exclusive read/write
access.
The data is released on destruction.
*/
class DataHandle extends ReadOnlyDataHandle{
    function __construct($root){
        $this->root = $root;
    }
    /**
    Delete the data object this handle points to.
    Invalidates the handle.
    */
    function delete(){
        //recursiveDelete($this->root);
        delete_directory($this->root);
        $this->root = NULL;
    }
    /**
    Set a named property on the data object, creating it if
    it does not exist.
    */
    function writeData($name, $data){
        return file_put_contents($this->root.'/'.$name, $data);
    }
    /**
    Set up a working directory with all the properties of the given
    data object as files.
    Returns a WorkDir object that can further manipulate the
    directory.
    */
    function getWorkDir(){
        return new WorkDir($this->root);
    }
    /**
    Copy all information from another readable data object.
    */
    function cloneFrom($other){
        foreach (glob($other->root.'/*.ump') as $umpFile) {
            copy($umpFile, $this->root."/".basename($umpFile));
        }
        $index_file = $other->root.'/tab_index';
        if (file_exists($index_file)) {
            copy($index_file, $this->root."/".basename($index_file));
        }
    }
}

/**
Represents a working directory based on a data object. The directory
is guaranteed to exist for the lifetime of this object and no
longer. Implies the existence of a corresponding DataHandle.
*/
class WorkDir{
    function __construct($root){
        $this->root = $root;
    }
    /**
    Returns the path of the root of the temporary directory tree.
    */
    function getPath(){
        return $this->root;
    }
    /**
    Saves any changes to the files representing properties of
    the data object.
    */
    function saveModel(){
        // no-op when using the file system
    }
    /**
    Given a path to a file or directory, return a URL that can be shown
    to users and will persist for some time, allowing them to view
    or download content.

    Could be used to upload to a dedicated fileserver.
    */
    function makePermalink($path){
        // assumes the server root is not just umpleonline/
        $umpsubdirStart = strpos($this->root,"/ump/");
        $umpsubdir=substr($this->root,$umpsubdirStart);
        $theURI = $_SERVER['REQUEST_URI'];
        $choppoint= strlen($theURI)-strlen("/scripts/compiler.php");
        if ($choppoint == 0)
        {
            $serverroot = "";
            $serverpath = $serverroot.$umpsubdir."/".$path;
            return $serverpath;
        } else {
            $serverroot = substr($theURI, 1, $choppoint-1);
        }
        $serverpath ="/".$serverroot.$umpsubdir."/".$path;
        return $serverpath;
    }
}

class DataStore{
    function __construct($root){
        $this->root = rootDir().'/'.$root;
        if(!file_exists($this->root)) {
          mkdir($this->root);
        }
        if(!file_exists($this->root."/tasks")) {
          mkdir($this->root."/tasks");
        }
        if(!file_exists($this->root."/index.html")) {
          copy(rootDir()."/umplibrary/index.html",$this->root."/index.html");
        }
    }
    /**
    Atomically creates a data storage area with a name of the
    format tmp*, with the option of replacing "tmp" with a
    different prefix.

    Should return a handle to the data such that there is exclusive
    read/write access to the data.
    */
    function createData($prefix = 'tmp'){
        while(true)
        {
            $id = base_convert(rand(0,999999999).rand(0,9999999999),10,36);
            $dirname = "{$this->root}/{$prefix}{$id}";
            if (!file_exists($dirname))
            {
                mkdir($dirname);
                return new DataHandle($dirname);
            }
        }
    }
    /**
    Acquires read/write exclusive access to data given a unique name.

    Returns a read/write handle to the data, or NULL if there is no
    such data.
    */
    function openData($name){
        if(file_exists($this->root.'/'.$name)){
            return new DataHandle($this->root.'/'.$name);
        }else{
            return NULL;
        }
    }
    /**
    The same as openData, but allowing for shared read-only
    access.
    */
    function openDataReadOnly($name){
        if(file_exists($this->root.'/'.$name)){
            return new ReadOnlyDataHandle($this->root.'/'.$name);
        }else{
            return NULL;
        }
    }
}

$globalDataStore = new DataStore('ump');
function dataStore(){
    global $globalDataStore;
    return $globalDataStore;
}

// converts an example filename to a full path
function getExamplePath($example){
  $expath=rootDir().'/umplibrary/'.$example;
  if(file_exists($expath)) {
    return $expath;
  }
  else {
    // Fall back to old location
    return rootDir().'/ump/'.$example;
  }
}

$uiguDir="";

function getUIGUDir() {
    return $uiguDir;
}

if (php_uname('s') == "Darwin") {
  $GLOBALS["OS"] = "Mac";
}

function generateMenu($buttonSuffix)
{
  // Elements separated by colons become arguments to Action.generateCode
  // First is style (how) to display using the html formatter
  //   - becomes second argument to Page.showGeneratedCode
  // Second is what generate argument to pass to the compiler
  //   - may be modified in compiler.php if special output needed
  //  The following have been deactivated since they don't work. A developer
  //  working on these can reactivate them in their local version
  //  <option value=\"uigu:uigu\">JSF GUI (under development)</option>
  //  <option value=\"cpp:Cpp\">Simple C++ (under development)</option>
  $generatemenu = "<ul class=\"second center-children\">
        <li class=\"subtitle\"> Generate".$buttonSuffix."</li>
        <li id=\"ttGeneratedCodeType\">
          <select id=\"inputGenerateCode".$buttonSuffix."\" name=\"inputLanguage\" class=\"button\">
            <option id=\"genjava\" value=\"java:Java\">Java Code</option>
            <option id=\"genjavadoc\" value=\"javadoc:javadoc\">Java API Doc</option>
            <option id=\"genphp\" value=\"php:Php\">PHP Code</option>
            <option id=\"gencpp\" value=\"cpp:RTCpp\">C++ Code</option>
            <option id=\"genruby\" value=\"ruby:Ruby\">Ruby Code</option>
            <option id=\"genalloy\" value=\"alloy:Alloy\">Alloy Model</option>
        <option id=\"gennusmv\" value=\"nusmv:NuSMV\">NuSMV Model</option>
            <option value=\"xml:Ecore\">Ecore</option>
            <option value=\"java:TextUml\">TextUml</option>
            <option value=\"xml:Scxml\">Scxml (Experimental)</option>
            <option value=\"xml:Papyrus\">Papyrus XMI</option>
            <option value=\"yumlDiagram:yumlDiagram\">Yuml Class Diagram</option>
            <option value=\"classDiagram:classDiagram\">GraphViz Class Diagram (SVG)</option>
            <option value=\"stateDiagram:stateDiagram\">State Diagram (GraphViz SVG)</option>
            <option value=\"featureDiagram:featureDiagram\">Feature Diagram (GraphViz SVG)</option>
            <option value=\"entityRelationship:entityRelationshipDiagram\">Entity Relationship Diagram (GraphViz SVG)</option>
            <option id=\"genstatetables\" value=\"html:StateTables\">State Tables</option>
            <option id=\"geneventsequence\" value=\"html:EventSequence\">Event Sequence</option>
            <option value=\"structureDiagram:StructureDiagram\">Structure Diagram</option>
            <option id=\"genuigu2\" value=\"Uigu2:Uigu2\">CRUD User Interface</option>            
            <option value=\"java:Json\">Json</option>
            <option id=\"gensql\" value=\"sql:Sql\">Sql</option>
            <option id=\"genmetrics\" value=\"html:SimpleMetrics\">Simple Metrics</option>
            <option value=\"html:CodeAnalysis\">Code Analysis</option>
            <option value=\"java:USE\">USE Model</option>
            <option value=\"java:UmpleSelf\">Internal Umple Representation</option>
            <option id=\"genUmpleAnnotaiveToComposition\" value=\"java:UmpleAnnotaiveToComposition\" >Compositional Mixsets from Inline Mixsets </option>

          </select>
        </li>
        <li id=\"ttGenerateCode\">
          <div id=\"buttonGenerateCode".$buttonSuffix."\" class=\"jQuery-palette-button\" tabindex=\"0\" value=\"Generate It\"></div>
        </li>
        <li><div id=\"genstatus\" align=\"center\">Done. See below</div><li>
      </ul>";

   echo $generatemenu;
}

function saveFile($input, $filename, $openmode = 'w')
{
  $fh = fopen($filename, $openmode);
  if($fh === false) {
    if(strpos($filename,"UmpleOnlineLog.txt") === FALSE) {
      // The following is for DEBUG -- uncomment as needed
      // saveFile("\n* Unable to open file ".$filename." to write output; cwd= ".getcwd()."\n","/tmp/UmpleOnlineLog.txt",'a');
    }
    
    echo "Not able to open file ".$filename." to write output; cwd= ".getcwd();
  }
  else {
    if($GLOBALS["OS"] == "Mac") {
      $contents = stripslashes($input);
    }
    else {
      $contents = $input;
    }

    $fwresult = fwrite($fh, $contents);
    if($fwresult === false) {
      echo "Unable to write to file ".filename." to write output; cwd= ".getcwd();
    }
    else {
      fclose($fh);
    }
  }
  return $filename;
}

function readTemporaryFile($filename)
{
  if (!is_file($filename) || filesize($filename) == 0)
  {
    return "";
  }

  $handle = fopen($filename, "r");
  //$contents = fread($handle, filesize($filename));
  $contents = fread($handle, filesize($filename));
  fclose($handle);
  return $contents;
}

function isBookmark($dataHandle)
{
    $modelId = $dataHandle->getName();
    return substr($modelId,0,3) != "tmp";
}

function isTask($dataHandle)
{
    $modelId = $dataHandle->getName();
    return substr($modelId,0,4) == "task";
}

// delete everything stored in a directory
function recursiveDelete($str){
        if(is_file($str)){
            return @unlink($str);
        }
        elseif(is_dir($str)){
            $scan = glob(rtrim($str,'/').'/*');
            foreach($scan as $index=>$path){
                recursiveDelete($path);
            }
            return @rmdir($str);
        }
    }

function delete_directory($dirname) 
{
    if (is_dir($dirname))
       $dir_handle = opendir($dirname);
    if (!$dir_handle)
      return false;
    while($file = readdir($dir_handle)) 
    {
        if ($file != "." && $file != "..") 
        {
            if (!is_dir($dirname."/".$file))
                 unlink($dirname."/".$file);
            else
                 delete_directory($dirname.'/'.$file);
       }
 }
 closedir($dir_handle);
 rmdir($dirname);
 return true;
}

function ensureFullPath($relativeFilename)
{
  $file_suffix = explode("/umpleonline/", realpath(""));
  $prefixes = explode("/", $file_suffix[1]);
  $suffix_array = explode("../", $relativeFilename);
  $suffix = $suffix_array[1];

  $filename = "../";

  foreach($prefixes as $prefix)
  {
    if($prefix == "scripts")
    {
      continue;
    }

    $filename = "../" . $filename . $prefix . "/";
  }

  $filename .= $suffix;

  return $filename;
}

function getOrCreateDataHandle(){
    if(isset($_REQUEST['filename'])){
        $modelId = dirname($_REQUEST['filename']);
        $filename= basename($_REQUEST['filename']);
        $dataHandle = dataStore()->openData($modelId);
        if($dataHandle){
            return array($filename, $dataHandle);
        }
    }else{
        $filename = 'model.ump';
    }
    $dataHandle = dataStore()->createData();
    return array($filename, $dataHandle);
}

function extractFilename()
{
    // If the argument is model=X, then load that saved tmp or bookmarked model
    if (isset($_REQUEST["model"]))
    {
        if (isset($_REQUEST["task"]))
        {
            $dataHandle = dataStore()->openData("tasks/" . $_REQUEST['model']);
        }
        else
        {
            $dataHandle = dataStore()->openData($_REQUEST['model']);
        }
        // if the model does not exist, create one containing an error message
        if(!$dataHandle){
            $dataHandle = dataStore()->createData();
            $dataHandle->writeData('model.ump', "// Saved URL ending in " . $_REQUEST["model"] . " cannot be found");
        }else{
            if($dataHandle->hasData('readonlylock.txt')){
                // TODO: Open the read only file and check if the
                // There is an argument with a matching overwrite key
                // For now, just ensure that the saved URL can only
                // be overwritten if the argument &overwrite=yes is supplied
                if (!$_REQUEST["overwrite"] == "yes") {
                    $readOnly = true;
                    $dataHandleCopy = dataStore()->createData();
                    $dataHandleCopy->cloneFrom($dataHandle);
                    $dataHandle = $dataHandleCopy;
                }
            }
        }
    }
    // If the argument is example=X then copy the example and open it
    elseif (isset($_REQUEST['example']) && $_REQUEST["example"] != "")
    {
        $fileToCopy = getExamplePath(htmlspecialchars($_REQUEST['example']).'.ump');
        if(!file_exists($fileToCopy)){
            $fileToCopy = getExamplePath('NullExample.ump');
        }
        $dataHandle = dataStore()->createData();
        $workDir = $dataHandle->getWorkDir();
        copy($fileToCopy, $workDir->getPath().'/model.ump');
        $workDir->saveModel();
    }
    elseif (isset($_REQUEST['text']) && $_REQUEST["text"] != "")
    {
        $dataHandle = dataStore()->createData();
        $dataHandle->writeData('model.ump', urldecode(urldecode($_REQUEST["text"])));
    }
    // Starting from scratch; so simply create a blank model
    elseif (!isset($_REQUEST['filename']) || $_REQUEST["filename"] == "")
    {
        $dataHandle = dataStore()->createData();
        $dataHandle->writeData('model.ump', '');
    }

    // The only other option is that there is a filename option
    else
    {
        $dataHandle = dataStore()->createData();
        $dataToWrite = '';
        if(!substr($_REQUEST["filename"],-4)==".ump") {
            $dataToWrite = "// URL in filename argument must end in .ump and the initial http:// must be omitted";
        }
        else
        {
            $dataToWrite = file_get_contents("http://" . $_REQUEST["filename"]);
            if(substr($http_response_header[0],-2)!="OK") {
                // try https
                $dataToWrite = file_get_contents("https://" . $_REQUEST["filename"]);
                if(substr($http_response_header[0],-2)!="OK") {         
                    $dataToWrite = "// URL of the Umple file to be loaded in the URL after ?filename= must omit the initial http:// and end with .ump.\n// The file must be accessible from our server.\n// Could not load http://" . $_REQUEST["filename"];
                }
            }
        }
        $dataHandle->writeData('model.ump', $dataToWrite);
    }
    return $dataHandle;
}

function showYumlImage($dataHandle)
{
  $workDir = $dataHandle->getWorkDir();
  $filename = $workDir->getPath().'/model.ump';
  $yuml = executeCommand("java -jar umplesync.jar -generate Yuml {$filename}");

    $title = "View As YUML Image";
  $icon = "yuml.png";
  ?>
  <head>
    <title> <?php echo $title ?> </title>
    <link rel="shortcut icon" href=<?php echo $icon ?> type="image/x-icon" />
  </head>

  <body>
  <img id="diagram" />
    <textarea id="source" style="display:none">
    <?php echo $yuml; ?>
    </textarea>

        <!-- empty or /scruffy -->
    <input id="diagramType" type="hidden" value="" />

    <script type="text/javascript" charset="utf-8">
      var source = document.getElementById("source");
      var diagramType = document.getElementById("diagramType").value;
      var diagram = document.getElementById("diagram");
      diagram.src = "http://yuml.me/diagram"+ diagramType +"/class/" + source.value;
    </script>
  </body>
  <?php
}

function showUserInterface($dataname, $dataHandle)
{
  $title = "Generate User Interface";
  $icon = "uigu.png";

  ?>
  <html>
  <head>
    <title> <?php echo $title ?> </title>
    <link rel="shortcut icon" href=<?php echo $icon ?> type="image/x-icon" />
  </head>
  </html>
  <?php
    // adding a default namespace if namespace doesn't exist
    $content = $dataHandle->readData($dataname);
    $namespace_location=strpos($content, 'namespace');
    if ($namespace_location===false) {
        $dataHandle->writeData($dataname, "namespace uigu;\n" . $content);
    }
    $dataWorkDir = $dataHandle->workDir();
    $tempDir=$dataWorkDir->getPath();
    $umpDir=dirname($tempDir);
    if (file_exists("$tempDir/files"))
      emptyDir("$tempDir/files");
    else
      mkdir("$tempDir/files");
    rcopy("JSFProvider/files", "$tempDir/files");
    copy("JSFProvider/build.xml", "$tempDir/build.xml");

    chdir($tempDir);

    $output = executeCommand("ant -DxmlFile={rootDir()}/scripts/JSFProvider/UmpleProject.xml -DumpleFile=model.ump -DoutputFolder=TempApp -DprojectName=umpleUIGU");

    $didCompile = strpos($output,"BUILD SUCCESSFUL") > 0;
    if ($didCompile){
        if (!file_exists("TempProj"))
            mkdir("TempProj");
        copy("umpleUIGU.war", "TempProj/umpleUIGU.war");
        chdir("TempProj");
        executeCommand("jar xf umpleUIGU.war");
        unlink('umpleUIGU.war');
        //echo getcwd();
        $umpDir=dirname($tempDir);
        $tmp=basename($tempDir);
        chdir(rootDir()."/uigu");
        $uiguDir=getAvailableUIGUDirectory();
        //echo $uiguDir;
        emptyDir($uiguDir);
        //echo "$tempDir/TempProj";
        chdir(rootDir());
        rcopy($tmp."/TempProj", $umpDir."/uigu/".$uiguDir);

        chdir($tmp);

        $gh=fopen("uigudir.txt", 'w');
        fwrite($gh, $uiguDir);
        fclose($gh);

        $fh=fopen("index.html", 'w') or die("Failed to create/open file!");

        $before = <<< _BEFORE
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="refresh" content="0;url='http://
_BEFORE;
fwrite($fh, $before);
fwrite($fh, $_SERVER['HTTP_HOST']."/".$uiguDir);
$after = <<< _AFTER
'">
</head>
<body>
</body>
</html>
_AFTER;
        fwrite($fh, $after);
        fclose($fh);
    }
    else{
      $errorFilename = "{$filename}.erroroutput";
      $fh = fopen($errorFilename, 'w') or die("can't open file");
      $stringData = "<h2> An error occurred while interpreting your Umple code. Please review it and try again. </h2>";
      fwrite($fh, $stringData);
      $stringData = "<pre>{$output}</pre>";
      fwrite($fh, $stringData);
      fclose($fh);
    }
    return $dataWorkDir;
}

function getAvailableUIGUDirectory()
{
    $files = array();
    if ($handle = opendir(".")) {
        while (false !== ($file = readdir($handle))) {
            if (strstr($file, "uigu")) {
                $files[filemtime($file)] = $file;
            }
        }
        closedir($handle);

        // sort
        ksort($files);
        // find the oldest modification
        $reallyOldModified = reset($files);
        return $reallyOldModified;
    }
    return '';
}

function showUmlImage($json)
{
  $title = "View As UML Image";
  $icon = "png.png";

  ?>
  <html>
  <head>
    <title> <?php echo $title ?> </title>
    <link rel="shortcut icon" href=<?php echo $icon ?> type="image/x-icon" />
  </head>
  </html>
  <?php

  header("Content-type: image/png");
  require_once("canvas.php");

  $canvas = new Canvas(950,350);
  $diagram = $canvas->createDiagram();

  $classIds = array();

  foreach ($json->umpleClasses as $umpleClass)
  {

    $umplePosition = $umpleClass->position;
    $classEntity = new ClassEntity($umpleClass->name,new Position($umplePosition->x,$umplePosition->y,$umplePosition->width,$umplePosition->height));
    $classIds[$umpleClass->id] = $classEntity;
    $classEntity->draw($diagram);
  }


  foreach ($json->umpleAssociations as $umpleAssociation)
  {

    $classEntity1 = $classIds[$umpleAssociation->classOneId];
    $classEntity2 = $classIds[$umpleAssociation->classTwoId];

    $mult1 = new MultiplicityEnd($classEntity1);
    $mult2 = new MultiplicityEnd($classEntity2);
    $association = new Association($mult1, $mult2);

    $c1Position = $classEntity1->getPosition();
    $c1Offset = $umpleAssociation->offsetOnePosition;
    $c2Position = $classEntity2->getPosition();
    $c2Offset = $umpleAssociation->offsetTwoPosition;

    $p1 = new Point($c1Position->getX() + $c1Offset->x,$c1Position->getY() + $c1Offset->y);
    $p2 = new Point($c2Position->getX() + $c2Offset->x,$c2Position->getY() + $c2Offset->y);

    $association->addConnector($p1);
    $association->addConnector($p2);

    $association->draw($diagram);
  }

  ImagePng($diagram);
  ImageDestroy($diagram);
}

function handleUmpleTextChange()
{
  $action = $_REQUEST["action"];
  $input = $_REQUEST["umpleCode"];
  
  $rawActionCode = $_REQUEST["actionCode"];
  if(!is_null($rawActionCode)){
      //Escape all the double quotes
      $rawActionCode = trim(str_replace("\"","\\\"",$rawActionCode));
    }

  //Windows versus Linux PHP issues
  $actionCode = $GLOBALS["OS"] == "Windows" ? json_encode($_REQUEST["actionCode"]) : "\"" . $_REQUEST["actionCode"] . "\"";
  $actionCode = str_replace("<","\<",$actionCode);
  $actionCode = str_replace(">","\>",$actionCode);

  if(!is_null($actionCode)){
      //Escape all the double quotes
      $actionCode = str_replace("\"","\\\"",$actionCode);
      //Trim for any un-standard characters
      $actionCode = trim($actionCode);
      //Trim for escaped doubles quotes in the beginning and end of the actionCode string
      $actionCode = trim($actionCode, "\\\"");
  }

  list($dataname, $dataHandle) = getOrCreateDataHandle();
  //$input = $input . $dataname;
  $dataHandle->writeData($dataname, $input);
  $workDir = $dataHandle->getWorkDir();
  $filename = $workDir->getPath().'/'.$dataname;

  $umpleOutput = executeCommand("java -jar umplesync.jar -{$action} \"{$actionCode}\" {$filename}", "-{$action} \"{$rawActionCode}\" {$filename}");
  //echo $dataHandle->getName();
  //$umpleOutput = $umpleOutput . $dataHandle->getWorkDir()->getPath();
  $dataHandle->writeData($dataname, $umpleOutput);
  echo $umpleOutput;
  return;
}

function executeCommand($command, $rawcommand = null)
{
  // The following is for DEBUG - uncomment as needed
  // saveFile("\n* ".$command."\n","/tmp/UmpleOnlineLog.txt",'a');

  // Set the following to false to avoid the server; true means use server
  // DEBUG - set this to false on order to avoid using the server
  $useServerIfPossble=true;  // Set to false to deactivate the server feature
  
  ob_start();
  if(substr($command,0,23) == "java -jar umplesync.jar" && $useServerIfPossble && !(strtoupper(substr(PHP_OS, 0, 3)) == 'WIN')) {
    serverRun(substr($command,24),$rawcommand);
  }
  else {
    execRun($command);
  }
  $output = trim(ob_get_contents());
  ob_clean();

  // The following TWO LINES are for DEBUG - uncomment as needed
  // saveFile($output,"/tmp/UmpleOnlineLatestOutput.txt",'w');
  // saveFile("---- ".substr_count( $output, "\n" ). " Lines output  characters ".strlen($output)."\n","/tmp/UmpleOnlineLog.txt",'a'); 

  return $output;
}

function execRun($command) {
  set_time_limit(0);
  // the following prevents runaway server execution
  // on Linux servers, but since Windows does not have
  // a ulimit command, we bypass that for Windows  
  if (strtoupper(substr(PHP_OS, 0, 3)) === 'WIN') {
    passthru($command);
  } else {
    passthru("(ulimit -t 10; " . $command . ")");
  }
}

function serverRun($commandLine,$rawcommand=null) {

  $originalCommandLine = $commandLine; // save in case we have to fall back to it

  require_once ("setPortNumber.php");  
  
  // Some output is error output -- save to a file
  $errorFile = null;
  $positionOfErrorRedirect = strpos($commandLine,"2>");
  if($positionOfErrorRedirect !== false) {
    $errorfile = trim(substr($commandLine, $positionOfErrorRedirect+2));
    $commandLine = substr($commandLine,0, $positionOfErrorRedirect);
  }
  
  if($rawcommand == null) {$rawcommand = $commandLine;}
  
  // The following is for DEBUG purposes - uncomment as approproate
  // saveFile("serverRun raw [[".$rawcommand."]]\n  errorfile= ".$errorfile. "\n","/tmp/UmpleOnlineLog.txt",'a');   

  $theSocket = socket_create(AF_INET, SOCK_STREAM, SOL_TCP);
  if($theSocket === FALSE) {
    execRun("java -jar umplesync.jar ".$originalCommandLine);
    return;
  }
  
  $isSuccess= @socket_connect($theSocket, "Localhost",  $portnumber);
  if($isSuccess === FALSE) {
    // Do it by exec anyway this time, then start server
    execRun("java -jar umplesync.jar ".$originalCommandLine);
    exec("java -jar umplesync.jar -server ".$portnumber." > /dev/null 2>&1 &"); // Start the server for the next time
    return;
  }
  
  // The following code can be switched off if the server performs reliablly
  // To turn off comment out all blocks preceded by FAILURECHECK
  // It is to log the last command before a failure
  // 1. Locate the model file in the command
  $modelFileInCommand = "";
  $startOfModelFile = strpos($originalCommandLine, "../ump/");
  if($startOfModelFile !== FALSE) {
    $endOfModelFile = strpos($originalCommandLine,"/model.ump");
    if($endOfModelFile !== FALSE) {
      $modelFileInCommand =
        substr($originalCommandLine,$startOfModelFile,$endOfModelFile+10-$startOfModelFile);
    }
  }
  // Create a temporary file
  $crashLogFile = "../ump/ATempCrashCheck-".uniqid().".ump";
  if($modelFileInCommand != "") {
    copy($modelFileInCommand, $crashLogFile);
  }
  saveFile("\n// ".date("Y-m-d H:i:s ").$originalCommandLine."\n",$crashLogFile,'a');
  // End of FAILURECHECK first block  
   
  // Actually send to the server
  $numBytesSent= socket_write($theSocket, $rawcommand);
  if($numBytesSent === FALSE) {
    execRun("java -jar umplesync.jar ".$originalCommandLine);
    return;
  }
 
  $readMoreLines = TRUE;
  $hasMoreError = FALSE;
  socket_set_option($theSocket, SOL_SOCKET, SO_RCVTIMEO,array("sec"=>1,"usec"=>500000) ); // Wait 5 secs  
  while ($readMoreLines === TRUE) {
    $output = @socket_read($theSocket, 65534, PHP_BINARY_READ);
    if ($output === FALSE) {
      @socket_close($theSocket);;
      // This usually happens at moments of overload; run as exec but give server much higher priority
      execRun("nice -n 10 java -jar umplesync.jar ".$originalCommandLine);
      return;
    }
    if(strlen($output) == 0) {
      $readMoreLines = FALSE;
    }
    else {
      if(substr($output,0,7) == "ERROR!!") {
        $errorEnd = strpos($output, "!!ERROR");
        if ($errorEnd === FALSE) {
          savefile(substr($output, 7),$errorfile);
          $hasMoreError = TRUE;
        } else {
            $hasMoreError = FALSE;
            $errorLength=$errorEnd-7;
            $errorString = substr($output,7,$errorLength);
            $output = substr($output,$errorLength+14); // cut out the error message.
            // The following one line is for DEBUG, uncomment as appropriate
            // saveFile("\n ERRORLOG* [[".$errorString."]] - other output [[".$output."]] ErrorEnd=".$errorEnd."\n","/tmp/UmpleOnlineLog.txt",'a');

            savefile($errorString,$errorfile);
        }
        
      } 
      else if ($hasMoreError === TRUE) { //There is more error in upcoming output
        $errorEnd = strpos($output, "!!ERROR");
        if ($errorEnd === FALSE) {
          savefile($output,$errorfile, 'a');
          $hasMoreError = TRUE;
        } else {
            $hasMoreError = FALSE;
            $errorLength=$errorEnd-7;
            $errorString = substr($output,7,$errorLength);
            $output = substr($output,$errorLength+14); // cut out the error message.
            savefile($errorString,$errorfile, 'a');
        }
      }
      if(strlen($output)>0 && $hasMoreError === FALSE) {
        echo $output;
      }
    }
    usleep(50000); // wait a little bit in case the server is sending more
  }
  socket_close($theSocket);
  
  // Final FAILURECHECK code line (deletes the file ... if does not occur it means failure)
  unlink($crashLogFile);
}


function cleanupOldFiles()
{
  if(rand(1,100) == 50) {
    executeCommand("scripts/cleanumpinbackground");
  // OLD
  // 1 percent of the time delete old temp directories older than 30 days ago
  //  executeCommand("find ./ump -maxdepth 1 -type d -mtime +30 | grep -v .svn | grep /tmp | xargs rm -rf");
  // The following commented out because it takes too long - use ralph script cleanump
  // delete empty directories older than 2 days - typically produced when Javascript off
  //executeCommand("find ./ump -maxdepth 1 -type d -empty -mtime +2 | grep -v .svn |  xargs rm -rf");
  }
}

function rrmdir($dir) {
    foreach(glob($dir . '/*') as $file) {
        if(is_dir($file))
            rrmdir($file);
        else
            unlink($file);
    }
    rmdir($dir);
}

function rcopy($src, $dst) {
  //if (file_exists($dst)) rrmdir($dst);
  if (is_dir($src)) {
    if (!file_exists($dst))
        mkdir($dst);
    $files = scandir($src);
    foreach ($files as $file)
    if ($file != "." && $file != "..") rcopy("$src/$file", "$dst/$file");
  }
  else if (file_exists($src)) copy($src, $dst);
}

function emptyDir($dir) {
    $handle=opendir($dir);

    while (($fl = readdir($handle))!==false) {
        $file="$dir/$fl";
        if (!is_dir($file))
            unlink($file);
        else {
            if ($fl != "." && $fl != "..") {
                $files = scandir($file);
                if (count($files) <= 2)
                    rmdir($file);
                else {
                    emptyDir($file);
                    rmdir($file);
                }
            }
        }
    }

    closedir($handle);
}
