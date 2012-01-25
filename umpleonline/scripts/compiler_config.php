<?php

//To run UmpleOnline locally, you will need to set the following constants based on your home computer settings

// JULIE FILION
// $GLOBALS["JAVA_HOME"] = "C:\Program Files\Java\jdk1.6.0_17";
// $GLOBALS["ANT_EXEC"] = "C:\Ant\apache-ant-1.8.1\bin\ant";
// $GLOBALS["OS"] = "Windows";
 
// CRUISE SERVER
$GLOBALS["JAVA_HOME"] = "/usr/bin/";
$GLOBALS["ANT_EXEC"] = "/h/ralph/cruise/dev/apps/apache-ant-1.8.1/bin/ant";
$GLOBALS["OS"] = "Linux";

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
            <option value=\"sql:SQL\">SQL (under development)</option>
            <option value=\"cpp:Cpp\">C++ (under development)</option>
          </select>
        </li>
        <li><div id=\"buttonGenerateCode".$buttonSuffix."\" class=\"jQueryPaletteButton\" value=\"Generate Code\"></div></li>      
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
  fwrite($fh, $input);
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
    $length = $index - strlen($filename);
    $modelId = substr($filename,7,$length);
    return $modelId;
  }
}

function extractFilename()
{
  // If the argument is model=X, then load that saved tmp or bookmarked model
  if (isset($_REQUEST["model"]))
  {
    $filename = "../ump/". $_REQUEST["model"] ."/model.ump";
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
 
  // Open any file. Needs maintenance TODO consider removing
  else
  {
    $destfile = nextFilename("ump");
    $filename = "../" . $destfile;

    file_put_contents($destfile, file_get_contents("http://" . $_REQUEST["filename"]));
    
    // To ensure the file is http file_get_contents(preg_match('@^http://@i', $_REQUEST['url'])?$_REQUEST['url']:$default_file);
    // Copy the file as in example=above
    // http://php.net/manual/en/function.file-get-contents.php
    // or http://www.bin-co.com/php/scripts/load/
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
    $uiguDirname = "{$dirname}/uigu";
    $filename = "{$dirname}/model.ump";
    
    if (!file_exists($dirname))
    {
        
      mkdir($dirname);
      mkdir($uiguDirname);
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
  
  $umpleFile = "../{$filename}";
  $umpleDir = dirname($filename);

  $uiguDirectory = "../{$umpleDir}/uigu";
  $uiguProjectName = "../{$umpleDir}/model";
  $buildFile = "../../scripts/JFXProvider/build.xml";
  $urlPath = "{$umpleDir}/model.jnlp";
  
  chdir($umpleDir);
  
  $buildProjectCommand = "#! /bin/sh\n";
  $buildProjectCommand .= "set JAVA_HOME={$GLOBALS['JAVA_HOME']}\n";
  $buildProjectCommand .= "{$GLOBALS['ANT_EXEC']} -f {$buildFile} -DxmlFile=UmpleProject.xml -DumpleFile={$umpleFile} -DoutputFolder={$uiguDirectory} -DprojectName={$uiguProjectName}";
  saveFile("{$buildProjectCommand}\n","runAnt.bat");
  
  //Fix the permissions so the runAnt.bat will work
  chmod("runAnt.bat",0755); 

  $output = executeCommand("./runAnt.bat");
  $didCompile = strpos($output,"BUILD SUCCESSFUL") > 0;
  

  if ($didCompile){
    ?> 
    <script> 
      location.href="<?php echo $urlPath ?>";
      setTimeout("closePopup()",2000);

      function closePopup()
      {
        parent.parent.GB_hide();
      }
    </script> 
    <?php
  }
  else{
    print "<h2> An error occurred while interpreting your Umple code. Please review it and try again. </h2>"; 
    print "<pre>{$output}</pre>";
  }
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
  executeCommand("find ump -type f -mtime +3 | grep -v .svn | grep /tmp | xargs rm -rf");
}