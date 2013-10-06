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
  * under the execution instance given by $execution_id. Returns true if creation was succesful.
  */
  public function create_object($class_name, $params){
    //TODO: test if __autoload() is declared
    //TODO: test if session was started
    $execution_id = $this->get_execution_id();
    $umple_class = $this->umple_model['ELEMENTS'][$class_name];
    $constructor = $umple_class['constructor_params'];
    $associations = $umple_class['associations'];

    if(count($params) != count($constructor)){
      //TODO: set error message
      return false;
    }
    //if constructor parameter is an association, value in $param is the index to obtain the object and must be replaced by it
    for($i = 0; $i < count($constructor); $i++){
      if($assoc = $associations[$constructor[$i]]){
        $obj_ref = $this->get_object($assoc['type'], $params[$i]);
        if(empty($obj_ref)){
          //TODO:object not found - set error message
          return false;
        }else{
          $params[$i] = $obj_ref;
        }
      }
    }
    $reflection = new ReflectionClass($class_name);
    $_SESSION[$execution_id]['instances'][$class_name][] = $reflection->newInstanceArgs($params);
    return true;
  }

  /*
  * Returns a specific Umple Object already instanciated, or false if no such object was found.
  */
  public function get_object($class_name, $index){
    $execution_id = $this->get_execution_id();
    if($obj = $_SESSION[$execution_id]['instances'][$class_name][$index]){
      return $obj;
    }else{
      return false;
    }
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
    if($element = $this->umple_model['ELEMENTS'][$element_name]){
      return $element;
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
