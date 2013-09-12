<?php
function _show_element($params) {
  //get the names to be shown in the select menu
  $data['element_names'] = array_keys($params['UMPLE_MODEL']['ELEMENTS']);
  
  if(!empty($params[0])){
    $element_name = $params[0];
  }else if(!empty($_POST['element_name'])){
    $element_name = $_POST['element_name'];
  }else{
    //TODO: redirect and show error message
    //return false;
  }
  if(isset($params['UMPLE_MODEL']['ELEMENTS'][$element_name])){
    $element = $params['UMPLE_MODEL']['ELEMENTS'][$element_name];
    $element['name'] = $element_name;
  }else{
    //TODO: redirect and show error message
    //return false;
  }

  //the view will have direct access to variables inside $element
  $data['body'][]=Uigu2_View::do_fetch(VIEW_PATH.'main/show_element.php', $element);
  Uigu2_View::do_dump(VIEW_PATH.'layout.php',$data);
}
