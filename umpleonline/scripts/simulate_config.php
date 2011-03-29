<?php

function __autoload($class_name)
{
  if (file_exists("scripts/{$class_name}.php"))
  {
    require_once "scripts/{$class_name}.php";
    return;
  }
  
  if (isset($GLOBALS['modelId']))
  {
    $modelId = $GLOBALS['modelId'];
    require_once "ump/{$modelId}/{$class_name}.php";
    return;
  }
}

function storeModel($model,$modelId)
{
	?><input id="<?php echo $modelId ?>" name="<?php echo $modelId ?>" type="hidden" value="<?php echo base64_encode(serialize($model)) ?>" /><?php
}

function retrieveModel($modelId,$nullModel)
{
  if (isset($_POST[$modelId]))
  {
    return unserialize(base64_decode($_POST[$modelId]));
  }
  else
  {
    return $nullModel;
  }
}
