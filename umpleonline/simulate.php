<?php

if (!isset($_REQUEST["model"]))
{
  ?>No model provided<?php
  exit;
}
require_once('scripts/simulate_config.php');

$modelId = htmlspecialchars($_REQUEST["model"]);
$simulator = retrieveModel('inputSimulator', new Simulator(new History()));
require_once("ump/{$modelId}/model.php");
$modelOverview = $GLOBALS['modelOverview'];

if (isset($_REQUEST['buttonRun']))
{
  $action = htmlspecialchars($_REQUEST['buttonRun']);
  $simulator->processAction($action);
}
elseif (isset($_REQUEST['buttonAction']))
{
  $actions = htmlspecialchars($_REQUEST['inputAction']);
  $allActions = explode("\n",$actions);
  foreach ($allActions as $action)
  {
    if (trim($action) == "")
    {
      continue;
    }
    $simulator->processAction($action);
  }
}
$classOverview = $modelOverview->getClass($simulator->getModel());

?>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="scripts/simulate.css" />
  <script src="scripts/simulate.js" type="text/javascript"></script>
  <script type="text/javascript" src="scripts/jquery/jquery-1.4.2.min.js"></script>
  <title> Simulate </title>
  <link rel="shortcut icon" href="scripts/simulate.png" type="image/x-icon" /> 
</head>

<body>
<div class="pagetitle"><img src="scripts/umpleonline_title.jpg" title="Simulation Tool" /></div>
<form action="simulate.php?model=<?php echo $GLOBALS['modelId'] ;?>" method="post">
  <?php storeModel($simulator,"inputSimulator"); ?>

<div class="action-view">
  <h3>ACTION</h3>
  <table class="action-view">
  <tr>
    <td class="input">
      <textarea id="inputAction" name="inputAction" class="action"></textarea>
      <input id="buttonAction" name="buttonAction" type="submit" value="run" />
    </td>
    <td class="available-commands">
      <h4>AVAILABLE COMMANDS</h4>
      <ul class="none">
        <li title = "Create new instance of a class;  To specify an instance as a parameter, use 'load [Instance #]'">new [ClassName] [Argument]*</li>
        <li title = "Load existing object into 'Loaded Object' view">load [Instance #]</li>
        <li title = "Execute method on currently loaded object; See log for return value">[MethodName] [Argument]*</li>
        <li title = "Delete specified instance">delete [Instance #]</li>
        <li title = "Undo specified number of actions">undo [#]?</li>
        <li title = "Delete all objects and history logs from current simulation">clear</li>
      </ul>
    </td>
    <td class="available-methods" rowspan="4">
      <table>
        <tr>
          <td><h4>AVAILABLE METHODS</h4></td>
          <td style="padding-top:10;">Select a method, edit the parameters and click "run".</td>
        </tr>    
        <?php
        $isFirst = true;
        foreach ($simulator->getAvailableMethods() as $method)
        {
          $specialStr = "!name";
          if (substr_count($method, $specialStr) > 0)
          {
            if (!$isFirst)
            {
              ?>
              </select>
                </td>
                  </tr>
              <?php                    
            }
            $isFirst = false;  
            $className = substr($method, 0, strlen($method) - strlen($specialStr));              
            ?>
            <tr>
              <td><?php echo $className; ?></td>
              <td>
                <select class="methods" id="inputMethod<?php echo $className?>" name="inputMethod">
                  <option><?php echo "Select {$className} method" ?></option>
            <?php
          }
          else
          {
            $isConstructor = strcmp(substr($method, 0, strlen($className)), $className) == 0 ? true : false;
            if ($isConstructor)
            {
              ?>
              <option><?php echo "new {$method}"; ?></option>
              <?php
            }
            else
            {
              ?>
              <option><?php echo $method; ?></option>
              <?php
            }
          }
        }
        ?>        
      </table>
    </td>
  </tr>
  <tr colspan="2">
    <td class="examples-code"> <h4> EXAMPLES </h4> </tr> </td>
  <tr>
    <td class="examples-code">
      <ul class="none">
        <li> <code> new Airline </code> </li>
        <li> <code> new Person Sandra 56943 load 1 </code> </li>
        <li> <code> new RegularFlight 6pm load 1 </code> </li>
        <li> <code> load 2 </code> </li>
        <li> <code> setName Joan </code> </li>
      </ul>
    </td>
    <td class="examples-description">
      <ul class="none">
        <li> Create a new instance of Airline </li>
        <li> Create a new instance of Person</li>
        <li> Create a new instance of RegularFlight </li>
        <li> Load the instance of Person (instance #2) </li>
        <li> Execute a method on the currently loaded instance </li>
      </ul>
    </td>
  </tr>
  <tr>
    <td colspan="2"> <h5> The above commands refer to the Airline example available on UmpleOnline.</h5> </td>
  </tr>
  </table>  
</div>

<div class="simulation-view">
  <h3> VIEW </h3>
  <table>
    <tr>
      <td class="summary-view">
        <h4>ALL OBJECTS</h4>
        <ul class="all-instances">
          <?php
          $offset = 0;
          foreach ($simulator->getInstances() as $obj)
          {
            $offset += 1;
            $objType = get_class($obj);
            $loadAnchor = "<a href=\"javascript:simulateCommand('load {$offset}');\" class=\"load\">{$objType}</a>";
            $deleteAnchor = "<a href=\"javascript:simulateCommand('delete {$offset}');\" class=\"delete\"><img src=\"scripts/delete4.jpg\" class=\"button\" title=\"delete {$offset}\" /></a>";
            $cssClass = $obj == $simulator->getModel() ? "selected" : "not-selected";
            echo "<li class=\"{$cssClass}\">{$offset} {$loadAnchor} {$deleteAnchor}</li>";
          }  
          ?>
        </ul> 
      </td>
      <td class="loaded-object-view">
        <h4>LOADED OBJECT</h4>
        <?php if ($classOverview != null) { ?>    
          <h2 class="selected-object"><?php echo $classOverview->getName() ?></h2>
          <dl class="attribute">
            <?php   foreach ($classOverview->getAttributes() as $attr) {?>
              <dt><?php echo $attr->getDisplayName(); ?></dt>
              <dd><?php echo $attr->getValue($simulator); ?></dd>
            <?php   } ?>
          </dl>
          
          <?php   if (count($classOverview->getAssociationEnds()) > 0) { ?>      
          <dl class="associationEnd">
            <?php     foreach ($classOverview->getAssociationEnds() as $assocEnd) { ?>        
              <dt><?php echo $assocEnd->getRoleName();  ?></dt>
              <dd><?php echo $assocEnd->getValue($simulator); ?></dd>
            <?php     } ?>
          <?php   } ?>
          </dl>
          <?php   foreach ($classOverview->getStateMachines() as $smOverview) {?>
            <dl class="state">
              <dt><?php echo $smOverview->getName() ?></dt>
              <dd><?php print $smOverview->getCurrentState($simulator->getModel()); ?></dd>
              <dt>EVENTS</dt>
              <dd>
                <ul>
                  <?php foreach ($smOverview->getEvents() as $eventName) {?>
                  <li><input id="buttonRun" name="buttonRun" type="submit" value="<?php echo $eventName ?>" /></li>
                  <?php } ?>          
                </ul>
              </dd>
            </dl>
          <?php   } ?>  
        <?php } ?>
      </td>
    </tr>
  </table>
</div>

<div class="history-view">
  <h3> HISTORY </h3>
  <table class="history-view">
    <tr>
      <td class="log-history-view">
        <h4>LOG (NEWEST TO OLDEST)</h4>
        <?php
        foreach ($simulator->getHistory()->getLatestLogs() as $action)
        {
          echo "<li>{$action}</li>";
        }
        ?>
      </td>
      <td class="action-history-view">
        <h4>ACTIONS </h4>
        <?php
        $newestToOldest = array_reverse($simulator->getHistory()->getActions());
        foreach ($newestToOldest as $action)
        {
          echo "<li>{$action}</li>";
        }
        ?>
      </td>
    </tr>
  </table>
</div>

<script language="JavaScript"> Simulate.init(); </script>

</form>
</body>
</html>