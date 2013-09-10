<?php

function _clear($params){
  $exec_id = $params['UMPLE_MODEL']['execution_id'];
  unset($_SESSION[$exec_id]);
  header('Location: '.WEB_DOMAIN);
}
