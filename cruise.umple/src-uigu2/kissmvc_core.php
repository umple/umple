<?php
/*****************************************************************
Copyright (c) 2008-2012 {kissmvc.php version 0.72}
Eric Koh <erickoh75@gmail.com> http://kissmvc.com

Permission is hereby granted, free of charge, to any person
obtaining a copy of this software and associated documentation
files (the "Software"), to deal in the Software without
restriction, including without limitation the rights to use,
copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following
conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.
*****************************************************************/
//===============================================================
// Controller
// Parses the HTTP request and routes to the appropriate function
//===============================================================
abstract class KISS_Controller {
  protected $controller_path='../app/controllers/'; //with trailing slash
  protected $web_folder='/'; //with trailing slash
  protected $request_uri_parts=array();
  protected $controller;
  protected $action;
  protected $params=array();

  function __construct($default_controller,$default_action)  {
    $this->controller=$default_controller;
    $this->action=$default_action;
    $this->explode_http_request()->parse_http_request()->route_request();
  }

  function explode_http_request() {
    $requri = $_SERVER['REQUEST_URI'];
    if (strpos($requri,$this->web_folder)===0)
      $requri=substr($requri,strlen($this->web_folder));
    $this->request_uri_parts = $requri ? explode('/',$requri) : array();
    return $this;
  }

  //This function parses the HTTP request to get the controller name, action name and parameter array.
  function parse_http_request() {
    $this->params = array();
    $p = $this->request_uri_parts;
    if (isset($p[0]) && $p[0] && $p[0][0]!='?')
      $this->controller=$p[0];
    if (isset($p[1]) && $p[1] && $p[1][0]!='?')
      $this->action=$p[1];
    if (isset($p[2]))
      $this->params=array_slice($p,2);
    return $this;
  }

  //This function maps the controller name and action name to the file location of the .php file to include
  function route_request() {
    $controllerfile=$this->controller_path.$this->controller.'/'.$this->action.'.php';
    if (!preg_match('#^[A-Za-z0-9_-]+$#',$this->controller) || !file_exists($controllerfile))
      $this->request_not_found('Controller file not found: '.$controllerfile);
    $function='_'.$this->action;
    if (!preg_match('#^[A-Za-z_][A-Za-z0-9_-]*$#',$function) || function_exists($function))
      $this->request_not_found('Invalid function name: '.$function);
    require($controllerfile);
    if (!function_exists($function))
      $this->request_not_found('Function not found: '.$function);
    //sending the array is a workaround to passing parameter as reference
    call_user_func_array($function,array(&$this));
    return $this;
  }

  //Override this function for your own custom 404 page
  function request_not_found($msg='') {
    header("HTTP/1.0 404 Not Found");
    die('<html><head><title>404 Not Found</title></head><body><h1>Not Found</h1><p>'.$msg.'<p>The requested URL was not found on this server.</p><p>Please go <a href="javascript: history.back(1)">back</a> and try again.</p><hr /><p>Powered By: <a href="http://kissmvc.com">KISSMVC</a></p></body></html>');
  }
}

//===============================================================
// View
// For plain .php templates
//===============================================================
abstract class KISS_View {
  protected $file='';
  protected $vars=array();

  function __construct($file='',$vars='')  {
    if ($file)
      $this->file = $file;
    if (is_array($vars))
      $this->vars=$vars;
    return $this;
  }

  function __set($key,$var) {
    return $this->set($key,$var);
  }

  function set($key,$var) {
    $this->vars[$key]=$var;
    return $this;
  }

  //for adding to an array
  function add($key,$var) {
    $this->vars[$key][]=$var;
  }

  function fetch($vars='') {
    if (is_array($vars))
      $this->vars=array_merge($this->vars,$vars);
    extract($this->vars);
    ob_start();
    require($this->file);
    return ob_get_clean();
  }

  function dump($vars='') {
    if (is_array($vars))
      $this->vars=array_merge($this->vars,$vars);
    extract($this->vars);
    require($this->file);
  }

  static function do_fetch($file='',$vars='') {
    if (is_array($vars))
      extract($vars);
    ob_start();
    require($file);
    return ob_get_clean();
  }

  static function do_dump($file='',$vars='') {
    if (is_array($vars))
      extract($vars);
    require($file);
  }

  static function do_fetch_str($str,$vars='') {
    if (is_array($vars))
      extract($vars);
    ob_start();
    eval('?>'.$str);
    return ob_get_clean();
  }

  static function do_dump_str($str,$vars='') {
    if (is_array($vars))
      extract($vars);
    eval('?>'.$str);
  }
}

abstract class KISS_Model  {

}
