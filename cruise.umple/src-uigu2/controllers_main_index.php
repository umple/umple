<?php
function _index($params) {
  //get the names to be shown in the select menu
  $data['element_names'] = array_keys($params['UMPLE_MODEL']['ELEMENTS']);
  
  $data['body'][]=Uigu2_View::do_fetch(VIEW_PATH.'main/index.php');
  Uigu2_View::do_dump(VIEW_PATH.'layout.php',$data);
}