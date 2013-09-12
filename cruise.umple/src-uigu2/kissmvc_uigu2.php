<?php
require_once('kissmvc_core.php');

class Uigu2_Controller extends KISS_Controller {
  protected $init_file;
  
  function __construct($controller_path,$web_folder,$default_controller,$default_action)  {
    $this->init_file = 'initialize_model.php';
    parent::__construct($controller_path,$web_folder,$default_controller,$default_action);
  }
  
  function route_request() {
    if (file_exists($this->init_file)) {
      require $this->init_file;
      $this->params['UMPLE_MODEL'] = initialize_model();
      parent::route_request();
    } else {
      $this->request_not_found('Controller initialization file not found: ' . $this->init_file);
    }
  }

  /*
  * Creates an object of an Umple domain class and registers it in the Session
  * under the execution instance given by $execution_id
  */
  public static function create_object($execution_id, $class_name, $params){
    //relies on the autoload function, see index.php
    $reflection = new ReflectionClass($class_name);
    $_SESSION[$execution_id]['instances'][$class_name][] = $reflection->newInstanceArgs($params);
  }

  public static function get_object($execution_id, $class_name, $index){
    return $_SESSION[$execution_id]['instances'][$class_name][$index];
  }

}

class Uigu2_View extends KISS_View {
}

//no need for database-backed model class for now
//class Uigu2_Model extends KISS_Model  {
class Uigu2_Model{
}
