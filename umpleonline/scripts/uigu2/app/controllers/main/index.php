<?php
function _index($controller) {
  $element_names = $controller->get_element_names();
  $messages = $controller->get_messages_clear();
  $controller->get_view()->show($element_names, $messages);
}
