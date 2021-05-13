<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.10.2.2921 modeling language!*/

class Simulator
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Simulator Associations
  private $history;
  private $model;
  private $instances;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aHistory)
  {
    if (!$this->setHistory($aHistory))
    {
      throw new Exception("Unable to create Simulator due to aHistory");
    }
    $this->instances = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getHistory()
  {
    return $this->history;
  }

  public function getModel()
  {
    return $this->model;
  }

  public function getInstance($index)
  {
    $aInstance = $this->instances[$index];
    return $aInstance;
  }

  public function getInstances()
  {
    $newInstances = $this->instances;
    return $newInstances;
  }

  public function numberOfInstances()
  {
    $number = count($this->instances);
    return $number;
  }

  public function hasInstances()
  {
    $has = $this->numberOfInstances() > 0;
    return $has;
  }

  public function indexOfInstance($aInstance)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->instances as $instance)
    {
      if ($instance->equals($aInstance))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function setHistory($newHistory)
  {
    $wasSet = false;
    if ($newHistory != null)
    {
      $this->history = $newHistory;
      $wasSet = true;
    }
    return $wasSet;
  }

  public function setModel($newModel)
  {
    $wasSet = false;
    $this->model = $newModel;
    $wasSet = true;
    return $wasSet;
  }

  public function addInstance($aInstance)
  {
    $wasAdded = false;
    if ($this->indexOfInstance($aInstance) !== -1) { return false; }
    $this->instances[] = $aInstance;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeInstance($aInstance)
  {
    $wasRemoved = false;
    if ($this->indexOfInstance($aInstance) != -1)
    {
      unset($this->instances[$this->indexOfInstance($aInstance)]);
      $this->instances = array_values($this->instances);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $this->history = null;
    $this->model = null;
    $this->instances = array();
  }

  //------------------------
  // DEVELOPER CODE - PROVIDED AS-IS
  //------------------------
  
  function isClassName($className)
  {
    foreach ($GLOBALS['modelOverview']->getClassOverviews() as $classOverview)
    {
      if ($classOverview->getName() == $className)
      {
        return true;
      }
    }
    return false;
  }
  
  function getAvailableMethods()
  {
    $methods = array();
    foreach ($GLOBALS['modelOverview']->getClassOverviews() as $classOverview)
    {
      $className = $classOverview->getName();
      $reflectionObj = new ReflectionClass($className);
      $classMethods = $reflectionObj->getMethods();
      
      $methods[] = "{$className}!name";
      foreach ($classMethods as $classMethod)
      {
        $name = "{$classMethod->getName()}";
        if ($name == "__construct")
        {
          $name = $className;
        }
        $parameters = "";
        foreach ($classMethod->getParameters() as $parameter)
        {
          $paramName = $parameter->getName();
          $parameters = "{$parameters} [{$paramName}]";
        }
       $methods[] = "{$name} {$parameters}";
      }
      
    }
    return $methods;
  }

  function processAction($action)
  {
    try
    {
      $this->history->addAction($action);
      $parts = explode(' ',$action);

      if (count($parts) < 1 || $parts[0] == '')
      {
        $parts = array('');
      }

      $type = $parts[0];
      array_shift($parts);
      if ($type == 'clear')
      {
        $this->processClear($parts);
        return;
      }
      elseif ($type == 'delete')
      {
        $this->processDelete($parts);
        return;
      }
      elseif ($type == 'load')
      {
        $this->processLoad($parts);
        return;
      }
      elseif ($type == 'undo')
      {
        $this->processUndo($parts);
        return;
      }
      elseif ($type == 'event')
      {
        $this->processEvent($parts);
        return;
      }
      elseif ($type == 'new')
      {
        $this->processNew($parts);
        return;
      }
      else
      {
        $this->processMethod($type,$parts);
        return;
      }
    }
    catch (Exception $e) 
    {
      $this->getHistory()->addLog("Exception:" . $e->getMessage());
    }    
    return;
  }

  public function processClear($parts)
  {
    if (count($parts) == 0)
    {
      $this->history = new History();
      $this->model = null;
      $this->instances = array();
    }
    else if ($parts[0] == "history")
    {
      $this->history = new History();
    }
  }
  
  public function processUndo($parts)
  {
    $size = count($parts) > 0 ? $parts[0] : 1;
    $allActions = $this->history->getActions();
    $this->processClear(array());
    array_pop($allActions); # this call, undo
    for ($i=0;$i<$size;$i++)
    {
      array_pop($allActions); # the last actions
    }
    foreach ($allActions as $action)
    {
      $this->processAction($action);
    }
  }
  
  public function processDelete($parts)
  {
    if ($this->numberOfInstances() == 0)
    {
      $this->history->addLog("Please create objects before trying to delete them");
    }
    elseif (count($parts) == 0 || $parts[0] < 1 || $parts[0] > $this->numberOfInstances())
    {
      $this->history->addLog("Please specify an object between 1 and " . $this->numberOfInstances());
    }
    else
    {
      $index = $parts[0] - 1;
      $this->model = $this->getInstance($index);
      $this->removeInstance($this->model);
      $this->model->delete();
      $this->model = null;
      $this->history->addLog("Deleted instance " . $parts[0] );
    }  
  }
  
  public function processLoad($parts)
  {
    if ($this->numberOfInstances() == 0)
    {
      $this->history->addLog("Please create objects before trying to load them");
    }
    elseif (count($parts) == 0 || $parts[0] < 1 || $parts[0] > $this->numberOfInstances())
    {
      $this->history->addLog("Please specify an object between 1 and " . $this->numberOfInstances());
    }
    else
    {
      $index = $parts[0] - 1;
      $this->model = $this->getInstance($index);
      $this->history->addLog("Loaded instance " . $parts[0] );
    }  
  }

  public function processEvent($parts)
  {
    if (count($parts) < 1)
    {
      $this->history->addLog("No event name provided");
      return;
    }

    $eventName = $parts[0];
    
    if ($this->model == null)
    {
      $this->history->addLog("No object available to react to event {$eventName}");
      return;
    }

    if (!method_exists($this->model,$eventName))
    {
      $this->history->addLog("Unknown event {$eventName} for " . get_class($this->model));
    }
    else
    {
      call_user_func(array($this->model,"{$eventName}"));
      $this->history->addLog("Called event {$eventName}");
    }
  }
  
  public function processNew($parts)
  {
    if (count($parts) < 1)
    {
      $this->history->addLog("No object to create");
      return;
    }
    
    $className = $parts[0];
    if (!$this->isClassName($className))
    {
      $this->history->addLog("Unknown class: {$className}");
      return;
    }

    array_shift($parts);
    $args = $this->processArguments($parts);
    $reflectionObj = new ReflectionClass($className);
    $obj = $reflectionObj->newInstanceArgs($args);    
    $this->setModel($obj);
    $this->addInstance($obj);
    $this->history->addLog("Created object: " . get_class($this->getModel()));
  }
  
  public function processMethod($methodName,$parts)
  {
    $args = $this->processArguments($parts);
    $modelIndex = $this->indexOfInstance($this->model);
    $data = array_merge(array($this->model),$parts);
    $result = call_user_func_array(array($this->model,$methodName),$args);
    $log = "Call to {$methodName} returned {$result}";
    $this->history->addLog($log);    
  }

  public function processArguments($parts)
  {
    $args = array();
    $size = count($parts);
    for ($i=0; $i<$size; $i++)
    {
      $entry = $parts[$i];
      if ($entry == "load")
      {
        $objIndex = $parts[$i+1] - 1;
        $obj = $this->getInstance($objIndex);
        $args[] = $obj;
      }
      else
      {
        $args[] = $entry;
      }
    }
    return $args;
  }
}
?>