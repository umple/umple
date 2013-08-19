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
      $this->params['UMPLE_MODEL'] = init();
      parent::route_request();
    } else {
      $this->request_not_found('Controller initialization file not found: ' . $this->init_file);
    }
  }
}

class Uigu2_View extends KISS_View {
}

//no need for database-backed model class for now
//class Uigu2_Model extends KISS_Model  {
class Uigu2_Model{
}
