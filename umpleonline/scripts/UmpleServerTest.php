<?php
  // This is a test program to ensure that Php and Java socket connection is working

  if($argc <3) {
    echo "Specify exec|server command ...\n";
    exit(0);
  }

  // run on port 5556 if in a directory with 'test' as a substring, otherwise use 5555
  $portnumber = 5555;
  if(strpos(getcwd(),"test") !== false) {
    $portnumber = 5556;
  }  
  
  $argCount = 1;
  $commandLine = "";
  while ($argCount < ($argc -1)) {
    $argCount = $argCount +1;
    if ($argCount > 2) $commandLine = $commandLine . " ";
    $commandLine = $commandLine . $argv[$argCount];
  }
  echo "Arguments to send to server on port ".$portnumber.": ".($argc-2)." <".$commandLine.">\n";
  
  if($argv[1] == "exec") {
    echo("using exec\n");
    exec("java -jar umplesync.jar ".$commandLine);
    exit(0);
  }

  echo("using server\n");
  
  $theSocket = socket_create(AF_INET, SOCK_STREAM, SOL_TCP);
  if($theSocket === FALSE) {
    echo "cannot create socket\n";
    return;
  }
  
  $isSuccess= @socket_connect($theSocket, "Localhost", $portnumber);
  if($isSuccess === FALSE) {
    if(substr($commandLine,0,5) == "-quit") {
      echo("Server is already quit or will not allow to connect\n");
      exit(0);
    }
    
    // Do it by exec anyway this time, then start server
    exec("java -jar umplesync.jar ".$commandLine);
    exec("java -jar umplesync.jar -server ".$portnumber." > /dev/null 2>&1 &"); // Start the server for the next time
    echo("Executed by Exec and Restarted server for next time\n");
    exit(0);
  }
  
  $numBytesSent= socket_write($theSocket, $commandLine);
  if($numBytesSent === FALSE) {
    echo "cannot send to server\n";
    exit(1);
  }
 socket_set_option($theSocket, SOL_SOCKET, SO_RCVTIMEO,array("sec"=>25,"usec"=>500000) ); 
 
  $readMoreLines = TRUE;
  while ($readMoreLines === TRUE) {
 //   stream_set_timeout($theSocket, 2);
    $output = socket_read($theSocket, 65534, PHP_BINARY_READ);
    
  /*  $info = stream_get_meta_data($theSocket);
    if ($info['timed_out']) {
        echo 'Connection timed out!';
        exit(1);
    }*/

    if ($output === FALSE) {
      echo "Socket closed unexpectedly with error code ".socket_last_error($theSocket)."\n";
      echo "Reason: ".socket_strerror(socket_last_error($theSocket))."\n";
      @socket_close($theSocket);;
      exit(0);
    }
    if(strlen($output) == 0) {
      $readMoreLines = FALSE;
    }
    else {
      echo "[[[".$output."]]]\n";
    }
  }
  socket_close($theSocket);

     // http://php.net/manual/en/function.socket-connect.php  
?>