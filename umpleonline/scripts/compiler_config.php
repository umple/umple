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

$uiguDir="";

function getUIGUDir() {
	return $uiguDir;
}

if (php_uname('s') == "Darwin") {
  $GLOBALS["OS"] = "Mac";
}

function generateMenu($buttonSuffix)
{
  $generatemenu = "<ul class=\"second\">
        <li class=\"subtitle\"> Generate".$buttonSuffix."</li>
        <li>
          <select id=\"inputGenerateCode".$buttonSuffix."\" name=\"inputLanguage\" class=\"button\">
            <option value=\"java:Java\">Java Code</option>
            <option value=\"javadoc:javadoc\">Java API Doc</option>
            <option value=\"php:Php\">PHP Code</option>
            <option value=\"ruby:Ruby\">Ruby Code</option>
            <option value=\"xml:Ecore\">Ecore</option>
            <option value=\"java:TextUml\">TextUml</option>
            <option value=\"xml:Papyrus\">Papyrus XMI</option>
            <option value=\"java:Yuml\">Yuml</option>
            <option value=\"java:Json\">Json</option>
            <option value=\"sql:Sql\">Sql</option>
            <option value=\"uigu:uigu\">JSF GUI (under development)</option>
            <option value=\"cpp:Cpp\">C++ (under development)</option>
          </select>
        </li>
        <li><div id=\"buttonGenerateCode".$buttonSuffix."\" class=\"jQueryPaletteButton\" value=\"Generate Code\"></div></li>
        <li><div id=\"genstatus\" align=\"center\">Done. See below</div><li>
      </ul>";

   echo $generatemenu;
}

function saveFile($input, $filename = null)
{
  if ($filename == null)
  {
    if (!isset($_REQUEST["filename"]))
    {
      $filename = nextFilename();  
    }
    else
    {
      $filename = $_REQUEST["filename"];
    }
  }
  
  $fh = fopen($filename, 'w');
  
  if($GLOBALS["OS"] == "Mac") {
    $contents = stripslashes($input);
  }
  else {
    $contents = $input;
  }
  
  fwrite($fh, $contents);
  fclose($fh);
  return $filename;
}

function readTemporaryFile($filename)
{
  if (!is_file($filename) || filesize($filename) == 0)
  {
    return "";
  }

  $handle = fopen($filename, "r");
  $contents = fread($handle, filesize($filename));
  fclose($handle);
  return $contents;
}

function isBookmark($filename)
{
  $modelId = extractModelId($filename);
  return substr($modelId,0,3) != "tmp";
}

function extractModelId($filename)
{
  if ($filename == null)
  {
    return "";
  }
  else
  {
    $index = strpos($filename,"/model.ump");
    $prefix = substr($filename,0,$index);
    if(!strpos($prefix,"/")) return $prefix;
    return substr(strrchr($prefix,"/"),1);
  }
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

function extractFilename()
{
  // If the argument is model=X, then load that saved tmp or bookmarked model
  if (isset($_REQUEST["model"]))
  {
    $filename = "../ump/". $_REQUEST["model"] ."/model.ump";
    if (!file_exists("ump/" . $filename)) {
      $destfile = nextFilename("ump");
      $filename = "../" . $destfile;

      file_put_contents($destfile, "// Saved URL ending in " . $_REQUEST["model"] . " cannot be found");
    }
    else  // file does exist
    {
      // Check if there is a password lock on the model
      if (file_exists("ump/" . $_REQUEST["model"] ."/readonlylock.txt"))
      {
        // TODO: Open the read only file and check if the
        // There is an argument with a matching overwrite key
        // For now, just ensure that the saved URL can only
        // be overwritten if the argument &overwrite=yes is supplied
        if (!$_REQUEST["overwrite"] == "yes") { 
          $readOnly = true;
          $fileToCopy = "ump/" . $filename;
          $destfile = nextFilename("ump");
          $filename = "../" . $destfile;
          copy($fileToCopy, $destfile);
        }
      }
    }
  }
  // If the argument is example=X then copy the example and open it
  elseif (isset($_REQUEST['example']) && $_REQUEST["example"] != "")
  {
    $fileToCopy = "ump/".htmlspecialchars($_REQUEST['example']).".ump";
    if (!file_exists($fileToCopy))
    {
       $fileToCopy = "ump/NullExample.ump";
    }
    $destfile = nextFilename("ump");
    $filename = "../" . $destfile;

    copy($fileToCopy, $destfile);
  }
  elseif (isset($_REQUEST['text']) && $_REQUEST["text"] != "")
  {
    $destfile = nextFilename("ump");
    $filename = "../" . $destfile;

    file_put_contents($destfile, urldecode($_REQUEST["text"]));
  }
  // Starting from scratch; so simply create a blank model
  elseif (!isset($_REQUEST['filename']) || $_REQUEST["filename"] == "")
  {
    $filename = "../" . nextFilename("ump");
  }
 
  // The only other option is that there is a filename option
  else
  {
    $destfile = nextFilename("ump");
    $filename = "../" . $destfile;
    
    if(!substr($_REQUEST["filename"],-4)==".ump") {
       file_put_contents($destfile, "// URL in filename argument must end in .ump and the initial http:// must be omitted");
    }
    else
    {
      file_put_contents($destfile, file_get_contents("http://" . $_REQUEST["filename"]));
      if(substr($http_response_header[0],-2)!="OK") {
        file_put_contents($destfile, "// URL of the Umple file to be loaded in the URL after ?filename= must omit the initial http:// and end with .ump.\n// The file must be accessible from our server.\n// Could not load http://" . $_REQUEST["filename"]);
      }
    }
  }
  return $filename;
}

function getFilenameId($filename)
{
  return substr($filename,7,strlen($filename) - strlen("../ump/") - strlen("/model.ump"));
}

// This will create your umple file, as well as the directory used for the uigu
function nextFilename($basedir = "../ump", $prefix = "tmp")
{
  while(true)
  {
    $id = rand(0,999999);
    $dirname = "{$basedir}/{$prefix}{$id}";
    $filename = "{$dirname}/model.ump";
    
    if (!file_exists($dirname))
    {
        
      mkdir($dirname);
      return $filename;
    }
  }
}

function showYumlImage($filename)
{
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

function showUserInterface($filename)
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
	$content = file_get_contents($filename);
	$namespace_location=strpos($content, 'namespace');
	if ($namespace_location===false) {
		file_put_contents($filename,"namespace uigu;\n" . $content);
	}
	
	$tempDir=dirname($filename);
	$umpDir=dirname($tempDir);
	mkdir("$tempDir/files");
	rcopy("JSFProvider/files", "$tempDir/files");
	copy("JSFProvider/build.xml", "$tempDir/build.xml");

    chdir($tempDir);
	
	$output = executeCommand("ant -DxmlFile=../../scripts/JSFProvider/UmpleProject.xml -DumpleFile=model.ump -DoutputFolder=TempApp -DprojectName=umpleUIGU");
	
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
		chdir("../../uigu");
		$uiguDir=getAvailableUIGUDirectory();
		//echo $uiguDir;
		emptyDir($uiguDir);
		//echo "$tempDir/TempProj";
		chdir("..");
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
  
  //Windows versus Linux PHP issues
  $actionCode = $GLOBALS["OS"] == "Windows" ? json_encode($_REQUEST["actionCode"]) : "\"" . $_REQUEST["actionCode"] . "\""; 

  $filename = saveFile($input);
  $umpleOutput = executeCommand("java -jar umplesync.jar -{$action} {$actionCode} {$filename}");
  saveFile($umpleOutput,$filename);
  echo urldecode($umpleOutput);
  return;
}

function executeCommand($command)
{
  ob_start();
  set_time_limit(0);
  passthru($command);
  $output = trim(ob_get_contents());
  ob_clean();
  return $output;
}


function cleanupOldFiles()
{
  if(rand(1,100) == 50) {
  // 1 percent of the time delete old temp directories older than 30 days ago
    executeCommand("find ./ump -maxdepth 1 -type d -mtime +30 | grep -v .svn | grep /tmp | xargs rm -rf");
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