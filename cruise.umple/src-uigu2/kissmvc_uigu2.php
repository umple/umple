<?php
require_once('kissmvc_core.php');

class Uigu2_Controller extends KISS_Controller {
  const MODEL_INIT_FILE = 'initialize_model.php';
  protected $umple_model;
  
  function __construct($controller_path,$web_folder,$default_controller,$default_action)  {
    $init_file = Uigu2_Controller::MODEL_INIT_FILE;
    if (file_exists($init_file)) {
      require $init_file;
      $this->umple_model = initialize_model();
    } else {
      $this->request_not_found('Controller initialization file not found: ' . $init_file);
    }
    parent::__construct($controller_path,$web_folder,$default_controller,$default_action);
  }
  
  function route_request() {
    $this->params['CONTROLLER'] =& $this;
    parent::route_request();
  }

  public function get_execution_id(){
    if(isset($this->umple_model['execution_id'])){
      return $this->umple_model['execution_id'];
    }else{
      return '_default';
    }
  }

  /*
  * Creates an object of an Umple domain class and registers it in the Session
  * under the execution instance given by $execution_id. Make sure session_start()
  * is called externally prior to using this function.
  */
  public function create_object($class_name, $params){
    $execution_id = $this->get_execution_id();
    //relies on the autoload function declared externally, see index.php
    $reflection = new ReflectionClass($class_name);
    $_SESSION[$execution_id]['instances'][$class_name][] = $reflection->newInstanceArgs($params);
  }

  /*
  * Returns a specific Umple Object already instanciated
  */
  public function get_object($class_name, $index){
    $execution_id = $this->get_execution_id();
    return $_SESSION[$execution_id]['instances'][$class_name][$index];
  }

  /*
  * Returns an array with names of the Umple Elements (classes, interfaces,..) declared in $umple_model
  */
  public function get_element_names(){
    return array_keys($this->umple_model['ELEMENTS']);
  }

  /*
  * Returns a specific Umple Element declared in $umple_model, or false if it doesn't exist 
  */
  public function get_element($element_name){
    if(isset($this->umple_model['ELEMENTS'][$element_name])){
      return $this->umple_model['ELEMENTS'][$element_name];
    }else {
      return false;
    }
  }

}

class Uigu2_View extends KISS_View {
}

//no need for database-backed model class for now
//class Uigu2_Model extends KISS_Model  {
class Uigu2_Model {
}
