<?php
function _new_instance($controller) {
  $element_name = $controller->get_param('element_name');
  $constructor_values = $controller->get_param('constructor_values');
  if (!$element_name){
    //TODO: redirect and show error message
    //return false;
  }
  if(!$constructor_values){
    $constructor_values = array();
  }
  $result = $controller->create_object($element_name, $constructor_values);
  if(!$result){
    //TODO: redirect and show error message
  }
  header('Location: '.WEB_DOMAIN.'/main/show_element/'.$element_name);
}
