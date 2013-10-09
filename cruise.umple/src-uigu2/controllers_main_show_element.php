<?php
function _show_element($controller) {

  //TODO make this a parameter-by-url always
  if(($element_name = $controller->get_param('element_name')) ||
      ($element_name = $controller->get_param())){

    if($element = $controller->get_element($element_name)){
      $layout_data['body'][]=$controller->get_view()->fetch($element);
      $layout_data['element_names'] = $controller->get_element_names();
      Uigu2_View::do_dump(VIEW_PATH.'layout.php',$layout_data);
    } else{
      //TODO: redirect and show error message
      //return false;
    }
  } else{
    //TODO: redirect and show error message
    //return false;
  }
}
