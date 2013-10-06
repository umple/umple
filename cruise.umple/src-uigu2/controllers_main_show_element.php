<?php
function _show_element($params) {
  $controller = $params['CONTROLLER'];

  //parameters can be received from POST or from the URL (mod_rewrite)
  if(!empty($params[0])){
    $element_name = $params[0];
  }else if(!empty($_POST['element_name'])){
    $element_name = $_POST['element_name'];
  }else{
    //TODO: redirect and show error message
    //return false;
  }
  $element = $controller->get_element($element_name);
  if(!$element){
    //TODO: redirect and show error message
    //return false;
  }

  //the view will have direct access to variables inside $element
  $data['body'][]=Uigu2_View::do_fetch(VIEW_PATH.'main/show_element.php', $element);
  $data['element_names'] = $controller->get_element_names();
  Uigu2_View::do_dump(VIEW_PATH.'layout.php',$data);
}
