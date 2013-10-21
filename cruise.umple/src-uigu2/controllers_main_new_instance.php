<?php
function _new_instance($controller) {
  $element_name = $controller->get_param('element_name');
  $constructor_values = $controller->get_param('constructor_values');
  if (!$element_name){
    $controller->set_message('Error creating new instance: the Element name was not provided', true);
    Uigu2_Controller::redirect(); 
  }
  if(!$constructor_values){
    $constructor_values = array();
  }
  $result = $controller->create_object($element_name, $constructor_values);
  if(!$result){
    $controller->set_message('Error creating new instance: error from constructor of Element '.$element_name, true);
    Uigu2_Controller::redirect(); 
  }
  Uigu2_Controller::redirect('show_element/'.$element_name); 
}
