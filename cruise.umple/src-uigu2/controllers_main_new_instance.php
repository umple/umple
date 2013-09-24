<?php

function _new_instance($params) {
  $controller = $params['CONTROLLER'];

  if (!empty($_POST['element_name'])) {
    $element_name = $_POST['element_name'];
  } else {
    //TODO: redirect and show error message
    //return false;
  }
  $obj_params = $_POST['constructor_values'];

  $exec_id = $controller->get_execution_id();
  $controller->create_object($element_name, $obj_params);

  //Redirect after job is done
  header('Location: '.WEB_DOMAIN.'/main/show_element/'.$element_name);
}
