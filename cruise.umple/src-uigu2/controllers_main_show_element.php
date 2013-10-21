<?php
function _show_element($controller) {

  //TODO make this a parameter-by-url always
  if(($element_name = $controller->get_param('element_name')) ||
      ($element_name = $controller->get_param())){

    if($element = $controller->get_element($element_name)){
      $view_data = array();
      $view_data['name'] = $element['name'];
      $view_data['element_kind'] = $element['element_kind'];

      //Create table with parameters needed for constructor
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
        $view_data['constructor_table_body'] = $constructor_table_body;
        $view_data['constructor_table_enabled'] = $form_enabled;
      }else {
        $view_data['constructor_table_body'] = "<span class='subtle'> This Class has an empty constructor,"
          .' press the button below to create an instance </span>';
        $view_data['constructor_table_enabled'] = true;
      }

      //Create table with instantiated objects of this class
      $objects = $controller->get_objects($element_name);
      if(!empty($objects) && count($objects) > 0){
        $objects_table = '<tr><th>Object ID</th><th>String Representation</th></tr>';
        for($i=0; $i < count($objects); $i++){
          $objects_table .= '<tr><td>'.$i.'</td><td>'.serialize($objects[$i]).'</td></tr>';
        }
        $view_data['objects_table'] = $objects_table;
      } else{
        $view_data['objects_table'] = "<span class='subtle'> There are no created instances for this Class </span>";
      }
      $layout_data['body'][]=$controller->get_view()->fetch($view_data);
      $layout_data['element_names'] = $controller->get_element_names();
      $layout_data['messages'] = $controller->get_messages_clear();
      Uigu2_View::do_dump(VIEW_PATH.'layout.php',$layout_data);

    } else{
      $controller->set_message('Error showing Element: '.$element_name.' does not exist', true);
      Uigu2_Controller::redirect(); 
    }
  } else{
    $controller->set_message('Error showing Element: the Element name was not provided', true);
    Uigu2_Controller::redirect(); 
  }
}
