<?php
  // Tries to Quit the UmpleOnline server running.
  // If that fails, kills it.

  require_once ("setPortNumber.php"); 

  $commandLine = "-quit";
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <script src="scripts/_load.js" type="text/javascript"></script>
  <title>Umpleonline internal server log</title>
  <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" /> 
</head>
<body>
<h2>Reset utility for UmpleOnline internal server</h2>
<p>This utility should only be used if the UmpleOnline server appears hung and is running overly slowly</p>
<?php
  $isSuccess = TRUE;
  $javaprocess = 0;
  exec('lsof -i :'.$portnumber.' | grep LISTEN ',$op);
  if(count($op)==0) {
    echo("No running UmpleOnline process on port ".$portnumber."<br/>\n");
    $isSuccess = FALSE;
  }
  else {
    if(substr($op[0],0,5)!="java ") {
      echo("Unexpected value returned for process number of Java");
      $isSuccess = FALSE;      
    }
    else {
      $opwords = explode(" ",$op[0],2);
      $javaprocess = (int)$opwords[1];
      echo("Java process on port ".$portnumber." is ".$javaprocess."<br/>");
    }
  }
  // At this point if we have no Java process, then we are done.
  
  // If we have one, we try to send a quit command to it
  if($javaprocess == 0) {
    echo("Cannot terminate server since one is not running. Try starting server using UmpleOnline.<br/>\n");
  }
  else {
    $theSocket = socket_create(AF_INET, SOCK_STREAM, SOL_TCP);
    if($theSocket === FALSE) {
      echo "<p>Cannot create socket\n";
      $isSuccess = FALSE;
    }
    else {
      $isSuccess= @socket_connect($theSocket, "Localhost", $portnumber);
      if($isSuccess === FALSE) {
        // Exec to start server first, then sleep a bit then try again
        echo "<p>Created socket but cannot connect\n";
      }
    }
  
    if($isSuccess) {
      echo "<p>Successfully established connection to server<br/>\n";
     
      echo "\n<p>php version: ";
      passthru("php -version");
        
      echo "<p>Java version: ";
      passthru("java -version 2>&1");

$isSuccess = FALSE;    
//      $numBytesSent= socket_write($theSocket, $commandLine);
//      if($numBytesSent === FALSE) {
//        echo "<p>Could not send quit command to server<br/>\n";
//        $isSuccess = FALSE;
//      }
    }
  
    if($isSuccess) {
      echo "<p>Successfully sent quit command to server.<br/> \n";  
      socket_set_option($theSocket, SOL_SOCKET, SO_RCVTIMEO,array("sec"=>25,"usec"=>500000) ); 
      $readMoreLines = TRUE;
      while ($readMoreLines === TRUE) {
        $output = socket_read($theSocket, 65534, PHP_BINARY_READ);
    
        if ($output === FALSE) {
          $isSuccess = FALSE;
          echo "<p>Socket closed unexpectedly with error code ".socket_last_error($theSocket)."\n";
          echo "<p>Reason: ".socket_strerror(socket_last_error($theSocket))."\n";
          @socket_close($theSocket);;
          break;
        }
        if(strlen($output) == 0) {
          $readMoreLines = FALSE;
        }
        else {
          echo $output;
        }
      }
      echo "</pre>\n";
      socket_close($theSocket);
    }
    // At this point if we have not successfully quit, then we kill it
    if(!$isSuccess) {
      echo("Killing Java process since we can't connect to socket and get results");
      passthru("kill -9 ".$javaprocess);
    }
  }
?>
</body>
</html>

