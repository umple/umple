<?php

function _clear($controller){
  unset($_SESSION[$controller->get_execution_id()]);
  header('Location: '.WEB_DOMAIN);
}
