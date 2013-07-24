<?php

function _clear(){
  session_destroy();
  header('Location: '.WEB_DOMAIN);
}