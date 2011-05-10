<?php
require_once("ui/framework.php");

$tracer = StringTracer::getInstance();
if (isset($_POST["buttonNext"]))
{
	$building = retrieveObject("inputBuilding");
	$oldTracer = retrieveObject("inputTracer");
	foreach($oldTracer->getTraces() as $trace)
	{
	  $tracer->addTrace($trace);
	}
  
	if (isset($_POST["inputAction"]) && $_POST["inputAction"] != "")
	{
		handleActions($building, $_POST["inputAction"]);
	}
	$building->nextStep();
	$autoChecked = isset($_POST["inputAutomatic"]) ? "checked" : ""; 
}
else
{
	$building = createBuilding();
	$autoChecked = "";
}
assignRandomFloor($building);

?>
<html>
<head>
<style>
h1 { padding: 2px 0 2px 0; margin: 0; }
h2 { padding: 10px 0 12px 0; margin: 0; }
h3 { padding: 0 0 10px 0; margin: 0; font-size: 12pt; }
table tr td { vertical-align: top; }
table.elevatorshaft, table.elevatorshaft tr {padding:0;margin:0;}
table.elevatorshaft td {width:50px;height:100px;background-color:#7E8B8B;}
div.open {background-color:blue;width:50%;height:100%;}
table.elevatorshaft td.rightdoor {text-align:right;}

table.elevatorshaft div.rightdoor {float:right;background-color:#C0C0C0;width:48%;height:100%}
table.elevatorshaft div.leftdoor {float:left;background-color:#C0C0C0;width:48%;height:100%}

table.elevatorshaft td.buttons {background-color:white; width:10px;}
table.elevatorshaft td.people {background-color:white; width:500px;vertical-align:bottom;}

img.button {cursor:pointer;}



</style>
<script type="text/javascript" src="ui/display.js"></script>

</head>
<body>

<table>
  <tr>
    <td>
      <h1>Welcome to <?php echo $building->getName() ?></h1>
      <h3>For more info: <a href="http://code.google.com/p/umple/wiki/Examples#Elevator_PHP">http://code.google.com/p/umple/wiki/Examples</a></h3>

      <?php displayElevatorShaft($building); ?>

      <br /><br />
      <form action="index.php" method="post">
        <input id="inputAutomatic" name="inputAutomatic" type="checkbox" value="auto" <?php echo$autoChecked?> /> On Automatic<br />
        <input id="buttonNext" name="buttonNext" type="submit" value="next" />
        <input id="buttonReset" name="buttonReset" type="submit" value="reset" />
        <br />
        <?php storeObject("inputBuilding",$building); ?>
        <?php storeObject("inputTracer",$tracer); ?>
        <input id="inputAction" name="inputAction" type="hidden" />
      </form>
    </td>
    <td>
      <h2>TRACING RESULTS (latest on top)</h2>
      <?php displayTraces($tracer); ?>
    </td>
  </tr>
</table>

<script language="javascript">

var inputAutomatic = document.getElementById("inputAutomatic");
var buttonNext = document.getElementById("buttonNext");

if (inputAutomatic.checked)
{
	setTimeout("buttonNext.click()",300);
}

</script>
</body>
</html>