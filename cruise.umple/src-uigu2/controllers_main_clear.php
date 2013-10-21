<?php

function _clear($controller){
  $controller->clear_data();
  Uigu2_Controller::redirect(); 
}
