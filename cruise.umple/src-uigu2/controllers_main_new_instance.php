<?php

function _new_instance($params) {
  if (!empty($_POST['element_name'])) {
    $element_name = $_POST['element_name'];
  } else {
    //TODO: redirect and show error message
    //return false;
  }
  $obj_params = $_POST['constructor_values'];
  $exec_id = $params['UMPLE_MODEL']['execution_id'];
  Uigu2_Controller::create_object($exec_id, $element_name, $obj_params);
  header('Location: '.WEB_DOMAIN.'/main/show_element/'.$element_name);
}
