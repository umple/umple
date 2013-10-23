<?php
function _new_instance($controller) {
  $element_name = $controller->get_param('element_name');
  $constructor_values = $controller->get_param('constructor_values');
  if (!$element_name){
    $controller->set_message('Error creating new instance: the Element name was not provided', true);
    Uigu2_Controller::redirect('index'); 
  }
  if(!$constructor_values){
    $constructor_values = array();
  }
  if(!$result = $controller->create_object($element_name, $constructor_values)){
    $controller->set_message('Error creating new instance of Element '.$element_name, true);
    Uigu2_Controller::redirect('index'); 
  }
  Uigu2_Controller::redirect('show_element/'.$element_name); 
}
