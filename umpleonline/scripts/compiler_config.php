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

function createFile($filename,$input)
{
  $fh = fopen($filename, 'w');
  fwrite($fh, $input);
  fclose($fh);
  return $filename;
}

function createTemporaryFile($input, $filename = null)
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

function extractFilename()
{
  if (!isset($_REQUEST['filename']) || $_REQUEST["filename"] == "")
  {
    $filename = "../" . nextFilename("ump");
  }
  else
  {
    $filename = htmlspecialchars($_REQUEST['filename']);
  }
  return $filename;
}

function getFilenameId($filename)
{
  return substr($filename,7,strlen($filename) - strlen("../ump/") - strlen("/model.ump"));
}

// This will create your umple file, as well as the directory used for the uigu
function nextFilename($basedir = "../ump")
{
  while(true)
  {
    $id = rand(0,999999);
    $dirname = "{$basedir}/{$id}";
    $uiguDirname = "{$basedir}/{$id}/uigu";
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
  $yuml = executeCommand("java -jar umpleplayground.jar -generate Yuml {$filename}");

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
  createTemporaryFile("{$buildProjectCommand}\n","runAnt.bat");
  
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

  $filename = createTemporaryFile($input);
  $umpleOutput = executeCommand("java -jar umpleplayground.jar -{$action} {$actionCode} {$filename}");

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
