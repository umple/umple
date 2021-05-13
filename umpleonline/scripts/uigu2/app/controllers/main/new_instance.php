<?php
function _new_instance($controller) {
  $element_name = $controller->get_param('element_name');
  $constructor_values = $controller->get_param('constructor_values');
  $attribute_types = $controller->get_param('attribute_types');

  if (!$element_name){
    $controller->set_message('Error creating new instance: the Element name was not provided', true);
    Uigu2_Controller::redirect('index'); 
  }
  if(!$constructor_values){
    $constructor_values = array();
  }
  if(!$attribute_types) {
    $attribute_types = array();
  }

  $num = count($constructor_values);
  for ($i = 0; $i < $num; $i++) { 
    if($attribute_types[$i] == "Boolean" || $attribute_types[$i] == "boolean" || $attribute_types[$i] == "bool") {
      if($constructor_values[$i] == "unassigned") {
        $controller->set_message('Error: Unassigned boolean variable', true);
        Uigu2_Controller::redirect('index');
        return;
      }
    } else if($attribute_types[$i] == "Integer" || $attribute_types[$i] == "int") {
      if(!preg_match("/^-?\d+$/", $constructor_values[$i])) {
        $controller->set_message('Error: Cannot convert "'.$constructor_values[$i].'" into an integer', true);
        Uigu2_Controller::redirect('index');
        return;
      }
    } else if($attribute_types[$i] == "Float" || $attribute_types[$i] == "float") {
      if(!preg_match("/^(-?\d+)(\.\d+)?$/", $constructor_values[$i])) {
        $controller->set_message('Error: Cannot convert "'.$constructor_values[$i].'" into a single-precision floating point number', true);
        Uigu2_Controller::redirect('index');
        return;
      }
    } else if($attribute_types[$i] == "Double" || $attribute_types[$i] == "double") {
      if(!preg_match("/^(-?\d+)(\.\d+)?$/", $constructor_values[$i])) {
        $controller->set_message('Error: Cannot convert "'.$constructor_values[$i].'" into a double-precision floating point number', true);
        Uigu2_Controller::redirect('index');
        return;
      }
    } else if($attribute_types[$i] == "String" || $attribute_types[$i] == "string") {

    } else if($attribute_types[$i] == "Character" || $attribute_types[$i] == "Char" || $attribute_types[$i] == "char") {
      if(strlen($constructor_values[$i]) != 1) {
        $controller->set_message('Error: Cannot convert "'.$constructor_values[$i].'" into a character', true);
        Uigu2_Controller::redirect('index');
        return;
      }
    } else if($attribute_types[$i] == "Date") {
      if(!preg_match("/^[0-9]{4}-[0-9]{2}-[0-9]{2}$/", $constructor_values[$i]) || !is_valid_date($constructor_values[$i])) {
        $controller->set_message('Error: "'.$constructor_values[$i].'" is not a valid date', true);
        Uigu2_Controller::redirect('index');
        return;
      }

    } else if($attribute_types[$i] == "Time") {
      if(!preg_match("/^[0-9]{2}:[0-9]{2}:[0-9]{2}$/", $constructor_values[$i]) || !is_valid_time($constructor_values[$i])) {
        $controller->set_message('Error: "'.$constructor_values[$i].'" is not a valid time', true);
        Uigu2_Controller::redirect('index');
        return;
      }
    }
  }

  if(!$result = $controller->create_object($element_name, $constructor_values)){
    $controller->set_message('Error creating new instance of Element '.$element_name, true);
    Uigu2_Controller::redirect('index'); 
  }
  Uigu2_Controller::redirect('show_element/'.$element_name); 
}

function is_valid_date($date) {
  $date_info = explode("-", $date);
  $year = intval($date_info[0]);
  $month = intval($date_info[1]);
  $day = intval($date_info[2]);

  if($month <= 0 || $month >= 13) {
    return false;
  }

  if($day <= 0 || $day >= 32) {
    return false;
  }

  if(($month == 4 || $month == 6 || $month == 9 || $month == 11) && $day >= 31) {
    return false;
  }

  if($month == 2 && is_leap_year($year) && $day >= 30) {
    return false;
  }

  if($month == 2 && !is_leap_year($year) && $day >= 29) {
    return false;
  }

  return true;
}

function is_leap_year($year) {
  if($year % 100 == 0) {
    return ($year % 400 == 0);
  }

  if($year % 4 == 0) {
    return true;
  } else {
    return false;
  }
}

function is_valid_time($time) {
  $time_info = explode(":", $time);
  $hour = intval($time_info[0]);
  $minute = intval($time_info[1]);
  $second = intval($time_info[2]);

  if($hour < 0 || $hour >= 24) {
    return false;
  }

  if($minute < 0 || $minute > 59) {
    return false;
  }

  if($second < 0 || $second > 59) {
    return false;
  }

  return true;
}
