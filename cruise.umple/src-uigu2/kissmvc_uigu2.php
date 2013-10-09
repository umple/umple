<?php
require_once('kissmvc_core.php');

class Uigu2_Controller extends KISS_Controller {
  const UMPLE_MODEL_INIT_FILE = 'initialize_model.php';
  protected $umple_model;
  protected $view_path='../app/views/'; //with trailing slash
  protected $view;
  
  function __construct($default_controller,$default_action)  {
    $init_file = Uigu2_Controller::UMPLE_MODEL_INIT_FILE;
    if (file_exists($init_file)) {
      require $init_file;
      $this->umple_model = initialize_model();
    } else {
      $this->request_not_found('Controller initialization file not found: ' . $init_file);
    }
    if (defined('CONTROLLER_PATH')){
      $this->controller_path = CONTROLLER_PATH;
    }
    if (defined('WEB_FOLDER')){
      $this->web_folder = WEB_FOLDER;
    }
    if (defined('VIEW_PATH')){
      $this->view_path = VIEW_PATH;
    }
    parent::__construct($default_controller,$default_action);
  }
  
  function parse_http_request() {
    parent::parse_http_request(); 
    if(!empty($_POST))
      $this->params = array_merge($this->params, $_POST);
    $default_view_file=$this->view_path.$this->controller.'/'.$this->action.'.php';
    if(file_exists($default_view_file))
      $this->view = new Uigu2_View($default_view_file);
    return $this;
  }

  public function get_view(){
    if(!empty($this->view)){
      return $this->view;
    } else{
      return false;
    }
  }

  public function get_params(){
    return $this->params;
  }

  public function get_param($key=0){
    if(!empty($this->params[$key])){
      return $this->params[$key];
    }else {
      return false;
    }
  }

  public function get_execution_id(){
    if(!empty($this->umple_model['execution_id'])){
      return $this->umple_model['execution_id'];
    }else{
      return '_default';
    }
  }

  /*
  * Creates an object of an Umple domain class and registers it in the Session
  * under the execution instance given by $execution_id. Returns true if creation was succesful.
  */
  public function create_object($class_name, array $params){
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
      if(!empty($associations[$constructor[$i]])){
        $assoc = $associations[$constructor[$i]];
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
    if(!empty($_SESSION[$execution_id]['instances'][$class_name][$index])){
      return $_SESSION[$execution_id]['instances'][$class_name][$index];
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
    if(!empty($this->umple_model['ELEMENTS'][$element_name])){
      return $this->umple_model['ELEMENTS'][$element_name];
    }else {
      return false;
    }
  }

}

class Uigu2_View extends KISS_View {

  function create_table($array='', $attributes=''){
    if(!is_array($array)||!count($array)){
      return false;
    }
    $table = '<table ';
    if(is_array($attributes)){
      foreach($attributes as $key => $value){
        $table .= $key . "= '" . $value . "' " ;
      }
    }
    $table .= '>';
    foreach($array as $row){
      $table .= '<tr>';
      foreach($row as $cell){
        $table .= '<td>' . $cell . '</td>';
      }
      $table .= '</tr>';
    }
    $table .= '</table>';
    return $table;
  }

}

//no need for database-backed model class for now
//class Uigu2_Model extends KISS_Model  {
