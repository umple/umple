<?php

function _clear($params){
  $exec_id = $params['CONTROLLER']->get_execution_id();
  unset($_SESSION[$exec_id]);
  header('Location: '.WEB_DOMAIN);
}
