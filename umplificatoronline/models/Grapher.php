<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.21.0.4666 modeling language!*/

class Grapher
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Grapher Attributes
  private $projectUmpleSource;
  private $numberOfClasses;
  private $numberOfAttributes;
  private $numberOfAssociations;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aProjectUmpleSource)
  {
    $this->projectUmpleSource = $aProjectUmpleSource;
    $this->numberOfClasses = 0;
    $this->numberOfAttributes = 0;
    $this->numberOfAssociations = 0;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setProjectUmpleSource($aProjectUmpleSource)
  {
    $wasSet = false;
    $this->projectUmpleSource = $aProjectUmpleSource;
    $wasSet = true;
    return $wasSet;
  }

  public function setNumberOfClasses($aNumberOfClasses)
  {
    $wasSet = false;
    $this->numberOfClasses = $aNumberOfClasses;
    $wasSet = true;
    return $wasSet;
  }

  public function setNumberOfAttributes($aNumberOfAttributes)
  {
    $wasSet = false;
    $this->numberOfAttributes = $aNumberOfAttributes;
    $wasSet = true;
    return $wasSet;
  }

  public function setNumberOfAssociations($aNumberOfAssociations)
  {
    $wasSet = false;
    $this->numberOfAssociations = $aNumberOfAssociations;
    $wasSet = true;
    return $wasSet;
  }

  public function getProjectUmpleSource()
  {
    return $this->projectUmpleSource;
  }

  public function getNumberOfClasses()
  {
    return $this->numberOfClasses;
  }

  public function getNumberOfAttributes()
  {
    return $this->numberOfAttributes;
  }

  public function getNumberOfAssociations()
  {
    return $this->numberOfAssociations;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {}

   public function run()
  {
    $this->fetchClasses();
    $this->fetchAttributesAndAssociations();
  }

   public function fetchClasses()
  {
    echo("** Getting Number of Classes...\n");
  	$htmlFile = file($this->projectUmpleSource . "Master.html");
  	
  	// Find number of rows in the class table (substract last "Total" row)
  	$this->numberOfClasses = substr_count($htmlFile[2], "TableRow0") - 1;
  }

   public function fetchAttributesAndAssociations()
  {
    echo("** Getting Number of Attributes & Associations...\n");
  	$htmlFile = file($this->projectUmpleSource . "Master.html");

  	// Find the word "Total" and fetch the number in the next table cell for attributes
  	$substringStartWithNumberOfAttributes = substr($htmlFile[4], strpos($htmlFile[4], "Total")+14);

  	$substringNumberOfAttributes = substr($substringStartWithNumberOfAttributes, 0, strpos($substringStartWithNumberOfAttributes, "</td>"));
  	$this->numberOfAttributes = (int)$substringNumberOfAttributes;

  	// Scan the next table cell for associations
	$substringStartWithNumberOfAssociations = substr($substringStartWithNumberOfAttributes, strpos($substringStartWithNumberOfAttributes, "<td>")+4);
  	
  	$substringNumberOfAssociations = substr($substringStartWithNumberOfAssociations, 0, strpos($substringStartWithNumberOfAssociations, "</td>"));
  	$this->numberOfAssociations = (int)$substringNumberOfAssociations;
  }

   public function generateGraph()
  {
    echo("** Generating Graph...\n");

    $num = 75;
  	
    $graphDependency1 = getcwd() . "/app/vendor/excanvas.js";
    $graphDependency2 = getcwd() . "/app/vendor/html5-canvas-bar-graph.js";

  	$fileLocation = $this->projectUmpleSource . "Result.html";
  	$htmlFile = fopen($fileLocation, "w") or die("Unable to open file!");

  	$content = <<<EOD
  		<!DOCTYPE html>
  		<head>
  			<title>Project Umplification Result</title>
  		</head>
		<body>
			<h1>Modeling Results for Project</h1>
			
			<div id="graphDiv1"></div>
			<!--[if IE]><script src="$graphDependency1"></script><![endif]-->
			<script src="$graphDependency2"></script>
			<script>(function () {
				function createCanvas(divName) {
					var div = document.getElementById(divName);
					var canvas = document.createElement('canvas');
					div.appendChild(canvas);
					if (typeof G_vmlCanvasManager != 'undefined') {
						canvas = G_vmlCanvasManager.initElement(canvas);
					}	
					var ctx = canvas.getContext("2d");
					return ctx;
				}
				var ctx = createCanvas("graphDiv1");				
				var graph = new BarGraph(ctx);
				graph.margin = 2;
				graph.colors = ["#87421f", "#9bce43", "#ee0000"];
				graph.xAxisLabelArr = ["Classes", "Attributes", "Associations"];
				graph.update([$this->numberOfClasses, $this->numberOfAttributes, $this->numberOfAssociations]);
			}());</script>
		</body>
		</html>
EOD;

  	fwrite($htmlFile, $content);
  	fclose($htmlFile);

    // Print success and file location
    echo("** Graph sucessfully generated in " . $fileLocation . "\n");
  }

}
?>