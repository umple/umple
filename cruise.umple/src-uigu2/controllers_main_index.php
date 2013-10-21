<?php
function _index($controller) {
  $layout_data['element_names'] = $controller->get_element_names();
  $layout_data['messages'] = $controller->get_messages_clear();
  $layout_data['body'][]=$controller->get_view()->fetch();
  Uigu2_View::do_dump(VIEW_PATH.'layout.php',$layout_data);
}
