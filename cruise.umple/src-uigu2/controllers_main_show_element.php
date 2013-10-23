<?php
function _show_element($controller) {

  //TODO make this a parameter-by-url always
  if(($element_name = $controller->get_param('element_name')) ||
      ($element_name = $controller->get_param())){

    $view = $controller->get_view();
    if($element = $controller->get_element($element_name)){
      $view->set('name', $element['name']);
      $view->set('element_kind', $element['element_kind']);

      //Create table with parameters needed for constructor
      //TODO do not create html here, leave it to the view
      if(count($element['constructor_params']) > 0){
        $constructor_table_body = '<tr><th>Attribute Name</th><th>Type</th><th>Value</th></tr>';
        $form_enabled = true;
        foreach($element['constructor_params'] as $p){
          $field = array();
          if(isset($element['attributes'][$p])){
            $field = $element['attributes'][$p];
            $value = isset($field['value']) ? $att['value'] : ''; 
            $input_field = "<input type='text' name='constructor_values[]' value='$value'/>";
          }else{
            $field = $element['associations'][$p];
            //Parameter for an association must be an index ("ID") for an existing instance
            $instances = $controller->get_objects($field['type']); 
            if(!empty($instances) && count($instances) > 0){
              $input_field = "<select name='constructor_values[]'>";
              for($i=0; $i < count($instances); $i++){
                $input_field .=  "<option value='{$i}'>Object ID {$i}</option>";
              }
              $input_field .= '</select>';

            }else {
              $input_field = "<input type='text' disabled='disabled'/>";
              $form_enabled = false;
            }
          }
          $constructor_table_body .= "<tr><td>{$field['name']}</td>".
                 "<td>{$field['type']}</td>".
                 "<td>{$input_field}</td></tr>";
        }
        $view->set('constructor_table_enabled', $form_enabled);
      }else {
        $constructor_table_body = "<span class='subtle'> This Class has an empty constructor,"
          .' press the button below to create an instance </span>';
        $view->set('constructor_table_enabled', true);
      }
      $view->set('constructor_table_body', $constructor_table_body);

      //Create table with instantiated objects of this class
      $objects = $controller->get_objects($element_name);
      if(!empty($objects) && count($objects) > 0){
        $objects_table = '<tr><th>Object ID</th><th>String Representation</th></tr>';
        for($i=0; $i < count($objects); $i++){
          $objects_table .= '<tr><td>'.$i.'</td><td>'.serialize($objects[$i]).'</td></tr>';
        }
      } else{
        $objects_table = "<span class='subtle'> There are no created instances for this Class </span>";
      }
      $view->set('objects_table', $objects_table);
      $element_names = $controller->get_element_names();
      $messages = $controller->get_messages_clear();
      $view->show($element_names, $messages);

    } else{
      $controller->set_message('Error showing Element: '.$element_name.' does not exist', true);
      Uigu2_Controller::redirect('index'); 
    }
  } else{
    $controller->set_message('Error showing Element: the Element name was not provided', true);
    Uigu2_Controller::redirect('index'); 
  }
}
