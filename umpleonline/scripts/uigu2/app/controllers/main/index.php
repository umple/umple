<?php
function _index($controller) {
  $element_names = $controller->get_element_names();
  
  $numbers_of_elements = NULL;
  if(isset($element_names) && is_array($element_names)) {
  	$numbers_of_elements = array();
  	foreach($element_names as $e){
  		$instances = $controller->get_objects($e);
  		if(empty($instances)) {
  			$numbers_of_elements[$e] = 0;
  		} else {
  			$numbers_of_elements[$e] = count($instances);
  		}
    }
  }

  $messages = $controller->get_messages_clear();

  $instantiatable_info = NULL;
  if(isset($element_names) && is_array($element_names)) {
    $instantiatable_info = array();
    foreach($element_names as $e){
      if(can_instantiate($controller, $e)) {
        $instantiatable_info[$e] = true;
      } else {
        $instantiatable_info[$e] = false;
      }
    }
  }

  $layout_parameter_map = array('element_names' => $element_names,
                                'numbers_of_elements' => $numbers_of_elements,
                                'messages' => $messages,
                                'instantiatable_info' => $instantiatable_info);

  $controller->get_view()->show_layout($layout_parameter_map);
  //$controller->get_view()->show($element_names, $messages);
}

function can_instantiate($controller, $element_name) {
  if($element = $controller->get_element($element_name)) {
    if(count($element['constructor_params']) > 0) {

      foreach($element['constructor_params'] as $p) {
        if(!isset($element['attributes'][$p])) {
          $field = $element['associations'][$p];
          //Parameter for an association must be an index ("ID") for an existing instance
          $instances = $controller->get_objects($field['type']);
          if(empty($instances) || count($instances) == 0) {
            return false;
          }
        }
      }

      return true;

    } else {
      return true;
    }
  } else {
    return false;
  }
}
