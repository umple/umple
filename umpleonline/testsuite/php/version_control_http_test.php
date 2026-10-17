<?php
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Integration tests of UmpleOnline's server-side version history through the
// HTTP requests the browser makes (compiler.php, tab_control.php,
// version_control.php, bookmark.php and umple.php). They run UmpleOnline in
// PHP's built-in web server; the models they create in umpleonline/ump are
// deleted afterwards.

function umpleOnlineDir()
{
  return dirname(__DIR__, 2);
}

function umpDir()
{
  return umpleOnlineDir()."/ump";
}

function httpModelText($model)
{
  return $model."\n//$?[End_of_model]$?\nnamespace -;\n";
}

// Starts UmpleOnline in PHP's built-in web server (once), returning its port
function testServerPort()
{
  static $port = null;
  if ($port !== null) return $port;

  $probe = stream_socket_server("tcp://127.0.0.1:0", $errno, $errstr);
  if ($probe === false) throw new Exception("Cannot find a free port: ".$errstr);
  $name = stream_socket_get_name($probe, false);
  fclose($probe);
  $freePort = (int) substr($name, strrpos($name, ":") + 1);

  $umpExisted = is_dir(umpDir());
  $log = sys_get_temp_dir()."/umpleonline-php-test-server.log";
  $environment = getenv();
  // Several workers, so that requests can be handled simultaneously
  $environment["PHP_CLI_SERVER_WORKERS"] = "4";
  $process = proc_open(
    array(PHP_BINARY, "-S", "127.0.0.1:".$freePort, "-t", umpleOnlineDir()),
    array(0 => array("file", "/dev/null", "r"), 1 => array("file", $log, "w"), 2 => array("file", $log, "w")),
    $pipes, umpleOnlineDir(), $environment);
  if (!is_resource($process)) throw new Exception("Cannot start PHP's built-in web server");

  register_shutdown_function(function() use ($process, $umpExisted) {
    stopTestServer($process);
    // Remove what UmpleOnline's data store creates, if it did not exist before
    if (!$umpExisted) {
      @rmdir(umpDir()."/tasks");
      @unlink(umpDir()."/index.html");
      @rmdir(umpDir());
    }
  });

  for ($attempt = 0; $attempt < 100; $attempt++) {
    $connection = @fsockopen("127.0.0.1", $freePort, $errno, $errstr, 0.2);
    if ($connection !== false) {
      fclose($connection);
      $port = $freePort;
      return $port;
    }
    usleep(50000);
  }
  throw new Exception("PHP's built-in web server did not start; see ".$log);
}

// The server's main process waits for its workers without passing signals on
// to them, so the workers are stopped too
function stopTestServer($process)
{
  $status = proc_get_status($process);
  $pids = childProcessIds($status["pid"]);
  $pids[] = $status["pid"];
  foreach ($pids as $pid) {
    if (function_exists("posix_kill")) posix_kill($pid, 9);
    else exec("kill -9 ".(int) $pid);
  }
  for ($wait = 0; $wait < 50 && proc_get_status($process)["running"]; $wait++) usleep(100000);
  if (!proc_get_status($process)["running"]) proc_close($process);
}

function childProcessIds($pid)
{
  $output = array();
  @exec("pgrep -P ".(int) $pid." 2>/dev/null", $output);
  $children = "/proc/".(int) $pid."/task/".(int) $pid."/children";
  if (count($output) == 0 && is_readable($children)) {
    $output = preg_split('/\s+/', trim(file_get_contents($children)));
  }
  return array_map("intval", array_filter($output, "ctype_digit"));
}

// Sends a request without waiting for the response, returning the connection
function startHttpRequest($method, $path, array $params = array())
{
  $port = testServerPort();
  $query = http_build_query($params);
  $target = "/".$path;
  $body = "";
  if ($method === "POST") {
    $body = $query;
  } else if ($query !== "") {
    $target .= (strpos($target, "?") === false ? "?" : "&").$query;
  }
  $socket = stream_socket_client("tcp://127.0.0.1:".$port, $errno, $errstr, 10);
  if ($socket === false) throw new Exception("Cannot connect to the test server: ".$errstr);
  stream_set_timeout($socket, 60);
  $request = $method." ".$target." HTTP/1.0\r\nHost: 127.0.0.1:".$port."\r\nConnection: close\r\n";
  if ($method === "POST") {
    $request .= "Content-Type: application/x-www-form-urlencoded\r\nContent-Length: ".strlen($body)."\r\n";
  }
  fwrite($socket, $request."\r\n".$body);
  return $socket;
}

// Returns array("status" => int, "headers" => array(lowercase name => value), "body" => string)
function finishHttpRequest($socket)
{
  $raw = stream_get_contents($socket);
  fclose($socket);
  $split = strpos($raw, "\r\n\r\n");
  if ($split === false) throw new Exception("Incomplete HTTP response: ".var_export($raw, true));
  $lines = explode("\r\n", substr($raw, 0, $split));
  $status = (int) explode(" ", array_shift($lines))[1];
  $headers = array();
  foreach ($lines as $line) {
    $colon = strpos($line, ":");
    if ($colon !== false) $headers[strtolower(trim(substr($line, 0, $colon)))] = trim(substr($line, $colon + 1));
  }
  return array("status" => $status, "headers" => $headers, "body" => substr($raw, $split + 4));
}

function httpRequest($method, $path, array $params = array())
{
  return finishHttpRequest(startHttpRequest($method, $path, $params));
}

function deleteModelAfterTest($modelId)
{
  UmpleTest::cleanup(function() use ($modelId) { removeDirectory(umpDir()."/".$modelId); });
}

// Creates a model as UmpleOnline does when a page is opened, returning its id
function createModel($code)
{
  $response = httpRequest("POST", "scripts/compiler.php", array("save" => "1", "umpleCode" => $code));
  assertSame(200, $response["status"], "creating a model");
  if (!preg_match('#^\.\./ump/(tmp[a-z0-9]+)/model\.ump$#', trim($response["body"]), $match)) {
    throw new UmpleTestFailure("Unexpected response creating a model: ".$response["body"]);
  }
  deleteModelAfterTest($match[1]);
  return $match[1];
}

function saveTabParameters($modelId, $tabName, $code, $baseVersion)
{
  $params = array("save" => "1", "lock" => "1", "model" => $modelId, "umpleCode" => $code,
    "filename" => $modelId."/".$tabName.".ump");
  if ($baseVersion !== null) $params["baseVersion"] = (string) $baseVersion;
  return $params;
}

// Saves a tab as TabControl.saveTab does
function saveTab($modelId, $tabName, $code, $baseVersion = null)
{
  $response = httpRequest("POST", "scripts/compiler.php", saveTabParameters($modelId, $tabName, $code, $baseVersion));
  assertSame(200, $response["status"], "saving tab ".$tabName);
  return $response;
}

function versionControl($method, array $params)
{
  return httpRequest($method, "scripts/version_control.php", $params);
}

function versionControlJson($method, array $params)
{
  $response = versionControl($method, $params);
  assertSame(200, $response["status"], "version_control.php ".json_encode($params)." returned ".$response["body"]);
  assertSame("no-store", $response["headers"]["cache-control"]);
  return json_decode($response["body"], true);
}

function listBackups($modelId)
{
  $list = versionControlJson("GET", array("list" => "1", "model" => $modelId));
  return $list["backups"];
}

function backupsWithReason($modelId, $reason)
{
  return array_values(array_filter(listBackups($modelId), function($backup) use ($reason) {
    return $backup["reason"] === $reason;
  }));
}

function versionHeaders($response)
{
  return array(
    isset($response["headers"]["x-umple-version"]) ? (int) $response["headers"]["x-umple-version"] : null,
    isset($response["headers"]["x-umple-version-changed"]) ? $response["headers"]["x-umple-version-changed"] : null);
}

function modelFile($modelId, $name)
{
  $path = umpDir()."/".$modelId."/".$name;
  // The server changes the files, so PHP's cached file status may be out of date
  clearstatcache();
  return is_file($path) ? file_get_contents($path) : null;
}

UmpleTest::add("saving a tab tells the browser the model's new version", function() {
  $modelId = createModel(httpModelText("class A {}"));

  $first = saveTab($modelId, "Untitled", httpModelText("class A {}"), 0);
  assertSame(array(1, "1"), versionHeaders($first));
  assertSame("../ump/".$modelId."/Untitled.ump", trim($first["body"]));

  $unchanged = saveTab($modelId, "Untitled", httpModelText("class A {}"), 1);
  assertSame(array(1, "0"), versionHeaders($unchanged));

  $second = saveTab($modelId, "Untitled", httpModelText("class A { name; }"), 1);
  assertSame(array(2, "1"), versionHeaders($second));
  assertFalse(isset($second["headers"]["x-umple-version-replaced"]));
  assertSame(httpModelText("class A { name; }"), modelFile($modelId, "Untitled.ump"));

  $status = versionControlJson("GET", array("status" => "1", "model" => $modelId));
  assertSame(2, $status["version"]);
  assertTrue(abs(time() - $status["savedAt"]) < 120, "savedAt should be the time of the save");

  $backups = listBackups($modelId);
  assertSame(1, count($backups));
  assertSame("initial", $backups[0]["reason"]);
  assertSame(array("model.ump"), $backups[0]["files"]);
});

UmpleTest::add("a save from a window showing an out-of-date version backs up the newer version first", function() {
  $modelId = createModel(httpModelText("class A {}"));
  saveTab($modelId, "A", httpModelText("class A { one; }"), 0);
  saveTab($modelId, "A", httpModelText("class A { two; }"), 1);
  assertSame(array(), backupsWithReason($modelId, "conflict"));

  $stale = saveTab($modelId, "A", httpModelText("class A { stale; }"), 0);
  assertSame(array(3, "1"), versionHeaders($stale));

  $conflicts = backupsWithReason($modelId, "conflict");
  assertSame(1, count($conflicts));
  assertSame(2, $conflicts[0]["version"]);
  assertSame(0, $conflicts[0]["staleVersion"]);
  assertSame($conflicts[0]["id"], $stale["headers"]["x-umple-version-replaced"],
    "the window is told which backup has the version it replaced");
  $files = versionControlJson("GET", array("files" => "1", "model" => $modelId, "id" => $conflicts[0]["id"]));
  assertSame($conflicts[0]["id"], $files["backup"]["id"]);
  assertSame(array(array("name" => "A.ump", "content" => httpModelText("class A { two; }"))), $files["files"]);
});

UmpleTest::add("simultaneous saves from several windows each get their own version", function() {
  $modelId = createModel(httpModelText("class A {}"));
  $connections = array();
  for ($i = 1; $i <= 6; $i++) {
    $connections[] = startHttpRequest("POST", "scripts/compiler.php",
      saveTabParameters($modelId, "A", httpModelText("class A { v$i; }"), null));
  }
  $versions = array();
  foreach ($connections as $connection) {
    $response = finishHttpRequest($connection);
    assertSame(200, $response["status"]);
    $versions[] = versionHeaders($response)[0];
  }
  sort($versions);
  assertSame(array(1, 2, 3, 4, 5, 6), $versions);
  $status = versionControlJson("GET", array("status" => "1", "model" => $modelId));
  assertSame(6, $status["version"]);
});

UmpleTest::add("the files of unknown versions are not found", function() {
  $modelId = createModel(httpModelText("class A {}"));
  saveTab($modelId, "A", httpModelText("class A { changed; }"));
  foreach (array("backup00042-2026-10-04-09-00-00", "../model.ump", "versionHistory", "") as $id) {
    $response = versionControl("GET", array("files" => "1", "model" => $modelId, "id" => $id));
    assertSame(404, $response["status"], "for id ".$id);
  }
  $response = versionControl("POST", array("restore" => "1", "model" => $modelId, "id" => "backup00042-2026-10-04-09-00-00"));
  assertSame(404, $response["status"]);
});

UmpleTest::add("restoring an earlier version replaces the model's files, and can be undone", function() {
  $modelId = createModel(httpModelText("class A {}"));
  saveTab($modelId, "A", httpModelText("class A {}"));
  saveTab($modelId, "B", httpModelText("class B {}"));
  $backup = versionControlJson("POST", array("backup" => "1", "model" => $modelId, "staleVersion" => "1"));
  assertSame("conflict", $backup["backup"]["reason"]);
  assertSame(array("A.ump", "B.ump"), $backup["backup"]["files"]);
  $restoreId = $backup["backup"]["id"];

  $rename = httpRequest("POST", "scripts/tab_control.php", array("rename" => "1", "model" => $modelId, "oldname" => "B", "newname" => "C"));
  assertSame(array(3, "1"), versionHeaders($rename));
  saveTab($modelId, "A", httpModelText("class A { changed; }"), 3);

  $get = versionControl("GET", array("restore" => "1", "model" => $modelId, "id" => $restoreId));
  assertSame(400, $get["status"], "restoring must be a POST");
  assertSame(httpModelText("class A { changed; }"), modelFile($modelId, "A.ump"));

  $response = versionControl("POST", array("restore" => "1", "model" => $modelId, "id" => $restoreId));
  assertSame(200, $response["status"]);
  assertSame(array(5, "1"), versionHeaders($response));
  $result = json_decode($response["body"], true);
  assertSame(5, $result["version"]);
  assertSame(2, $result["restoredVersion"]);
  assertSame("B.ump", $result["shownFile"]);
  assertSame(httpModelText("class B {}"), $result["shownContent"]);
  assertSame(httpModelText("class A {}"), modelFile($modelId, "A.ump"));
  assertSame(httpModelText("class B {}"), modelFile($modelId, "B.ump"));
  assertSame(null, modelFile($modelId, "C.ump"));
  assertSame(httpModelText("class B {}"), modelFile($modelId, "model.ump"));

  $saved = backupsWithReason($modelId, "beforeRestore");
  assertSame(1, count($saved));
  assertSame($result["savedId"], $saved[0]["id"]);
  assertSame(2, $saved[0]["restoredVersion"]);
  assertSame(array("A.ump", "C.ump"), $saved[0]["files"]);

  $undo = versionControlJson("POST", array("restore" => "1", "model" => $modelId, "id" => $result["savedId"]));
  assertSame(6, $undo["version"]);
  assertSame(httpModelText("class A { changed; }"), modelFile($modelId, "A.ump"));
  assertSame(httpModelText("class B {}"), modelFile($modelId, "C.ump"));
  assertSame(null, modelFile($modelId, "B.ump"));
});

UmpleTest::add("the browser can back up the current files before restoring in the editor", function() {
  $modelId = createModel(httpModelText("class A {}"));
  saveTab($modelId, "Untitled", httpModelText("class A { changed; }"));
  $initial = backupsWithReason($modelId, "initial");
  assertSame(1, count($initial));

  $get = versionControl("GET", array("backup" => "1", "model" => $modelId, "restoring" => $initial[0]["id"]));
  assertSame(400, $get["status"], "backing up must be a POST");

  $result = versionControlJson("POST", array("backup" => "1", "model" => $modelId, "restoring" => $initial[0]["id"]));
  assertSame(1, $result["version"]);
  assertSame("beforeRestore", $result["backup"]["reason"]);
  assertSame(0, $result["backup"]["restoredVersion"]);
  assertSame(1, $result["backup"]["version"]);
  $files = versionControlJson("GET", array("files" => "1", "model" => $modelId, "id" => $result["backup"]["id"]));
  assertSame(httpModelText("class A { changed; }"), $files["files"][0]["content"]);

  // Asking again does not make a duplicate backup
  $again = versionControlJson("POST", array("backup" => "1", "model" => $modelId, "restoring" => $initial[0]["id"]));
  assertSame($result["backup"]["id"], $again["backup"]["id"]);
  assertSame(2, count(listBackups($modelId)));
});

UmpleTest::add("a window that keeps its out-of-date version first backs up the newer one", function() {
  $modelId = createModel(httpModelText("class A {}"));
  saveTab($modelId, "A", httpModelText("class A { newer; }"), 0);
  $result = versionControlJson("POST", array("backup" => "1", "model" => $modelId, "staleVersion" => "0"));
  assertSame(1, $result["version"]);
  assertSame("conflict", $result["backup"]["reason"]);
  assertSame(0, $result["backup"]["staleVersion"]);
  assertSame(1, $result["backup"]["version"]);
});

UmpleTest::add("renaming and deleting tabs are recorded as versions, and deleted tabs can be restored", function() {
  $modelId = createModel(httpModelText("class A {}"));
  saveTab($modelId, "A", httpModelText("class A {}"), 0);
  saveTab($modelId, "B", httpModelText("class B {}"), 1);

  $rename = httpRequest("POST", "scripts/tab_control.php",
    array("rename" => "1", "model" => $modelId, "oldname" => "B", "newname" => "Bee", "baseVersion" => "2"));
  assertSame(200, $rename["status"]);
  assertSame(array(3, "1"), versionHeaders($rename));
  assertSame(httpModelText("class B {}"), modelFile($modelId, "Bee.ump"));

  $delete = httpRequest("POST", "scripts/tab_control.php",
    array("delete" => "1", "model" => $modelId, "name" => "Bee", "baseVersion" => "3"));
  assertSame(200, $delete["status"]);
  assertSame(array(4, "1"), versionHeaders($delete));
  assertSame(null, modelFile($modelId, "Bee.ump"));

  $beforeDelete = backupsWithReason($modelId, "beforeDelete");
  assertSame(1, count($beforeDelete));
  assertSame("Bee.ump", $beforeDelete[0]["deletedFile"]);
  assertSame(array("A.ump", "Bee.ump"), $beforeDelete[0]["files"]);

  versionControlJson("POST", array("restore" => "1", "model" => $modelId, "id" => $beforeDelete[0]["id"]));
  assertSame(httpModelText("class B {}"), modelFile($modelId, "Bee.ump"));

  $staleRename = httpRequest("POST", "scripts/tab_control.php",
    array("rename" => "1", "model" => $modelId, "oldname" => "A", "newname" => "Ay", "baseVersion" => "4"));
  assertSame(array(6, "1"), versionHeaders($staleRename));
  $conflicts = backupsWithReason($modelId, "conflict");
  assertSame(1, count($conflicts));
  assertSame(array("A.ump", "Bee.ump"), $conflicts[0]["files"]);
  assertSame($conflicts[0]["id"], $staleRename["headers"]["x-umple-version-replaced"]);
});

UmpleTest::add("tab requests cannot reach files outside the model", function() {
  $modelId = createModel(httpModelText("class A {}"));
  saveTab($modelId, "A", httpModelText("class A {}"));
  saveTab($modelId, "B", httpModelText("class B {}"));
  $requests = array(
    array("rename" => "1", "model" => $modelId, "oldname" => "A", "newname" => "../A"),
    array("rename" => "1", "model" => $modelId, "oldname" => "../".$modelId."/A", "newname" => "C"),
    array("rename" => "1", "model" => $modelId, "oldname" => "A", "newname" => "B"),
    array("rename" => "1", "model" => $modelId, "oldname" => "Missing", "newname" => "C"),
    array("rename" => "1", "model" => "../".$modelId, "oldname" => "A", "newname" => "C"),
    array("delete" => "1", "model" => $modelId, "name" => "../".$modelId."/A"),
    array("delete" => "1", "model" => $modelId, "name" => "model"),
    array("delete" => "1", "model" => $modelId, "name" => "Missing"),
    array("delete" => "1", "model" => "../".$modelId, "name" => "A")
  );
  foreach ($requests as $params) {
    $response = httpRequest("POST", "scripts/tab_control.php", $params);
    assertSame(404, $response["status"], json_encode($params));
  }
  assertSame(httpModelText("class A {}"), modelFile($modelId, "A.ump"));
  assertSame(httpModelText("class B {}"), modelFile($modelId, "B.ump"));
  $status = versionControlJson("GET", array("status" => "1", "model" => $modelId));
  assertSame(2, $status["version"]);
});

UmpleTest::add("version requests for invalid or missing models are rejected", function() {
  assertSame(400, versionControl("GET", array("status" => "1"))["status"]);
  assertSame(400, versionControl("GET", array("status" => "1", "model" => "../scripts"))["status"]);
  assertSame(400, versionControl("GET", array("status" => "1", "model" => "tmp1/../../scripts"))["status"]);
  assertSame(404, versionControl("GET", array("status" => "1", "model" => "tmpnosuchmodel0"))["status"]);
  $modelId = createModel(httpModelText("class A {}"));
  assertSame(400, versionControl("GET", array("model" => $modelId))["status"]);
  assertSame(400, versionControl("GET", array("files" => "1", "model" => $modelId))["status"]);
  $status = versionControlJson("GET", array("status" => "1", "model" => $modelId));
  assertSame(array("version" => 0, "savedAt" => null), $status);
});

UmpleTest::add("a bookmark keeps the history of its model, and a fork of it gets a copy", function() {
  $modelId = createModel(httpModelText("class A {}"));
  saveTab($modelId, "A", httpModelText("class A { one; }"));
  saveTab($modelId, "A", httpModelText("class A { two; }"));

  $bookmark = httpRequest("GET", "bookmark.php", array("model" => $modelId));
  assertSame(302, $bookmark["status"]);
  assertTrue((bool) preg_match('/^umple\.php\?model=(\d{6}[a-z0-9]+)$/', $bookmark["headers"]["location"], $match),
    "unexpected redirect ".$bookmark["headers"]["location"]);
  $bookmarkId = $match[1];
  deleteModelAfterTest($bookmarkId);
  clearstatcache();
  assertFalse(is_dir(umpDir()."/".$modelId), "the temporary model should be gone");
  $status = versionControlJson("GET", array("status" => "1", "model" => $bookmarkId));
  assertSame(2, $status["version"]);
  assertSame(1, count(listBackups($bookmarkId)));

  $fork = httpRequest("GET", "bookmark.php", array("model" => $bookmarkId, "forkSoMakeTmpOnly" => "1"));
  assertSame(302, $fork["status"]);
  assertTrue((bool) preg_match('/^umple\.php\?model=(tmp[a-z0-9]+)$/', $fork["headers"]["location"], $match));
  $forkId = $match[1];
  deleteModelAfterTest($forkId);
  saveTab($forkId, "A", httpModelText("class A { forked; }"));
  assertSame(3, versionControlJson("GET", array("status" => "1", "model" => $forkId))["version"]);
  assertSame(2, versionControlJson("GET", array("status" => "1", "model" => $bookmarkId))["version"]);
  assertSame(httpModelText("class A { two; }"), modelFile($bookmarkId, "A.ump"));
});

UmpleTest::add("the page tells the browser which version it was loaded with", function() {
  $modelId = createModel(httpModelText("class A {}"));
  saveTab($modelId, "A", httpModelText("class A { one; }"));
  saveTab($modelId, "A", httpModelText("class A { two; }"));

  // umple.php regenerates this (version controlled) example menu when it is a day old
  $exampleMenu = umpleOnlineDir()."/generatedExtraExample1OptionsAD.html";
  if (is_file($exampleMenu)) touch($exampleMenu);

  $page = httpRequest("GET", "umple.php", array("model" => $modelId));
  assertSame(200, $page["status"]);
  assertContains('<input id="modelVersion" type="hidden" value="2" />', $page["body"]);
  assertContains('id="buttonRestoreEarlierVersion"', $page["body"]);
  assertContains('id="versionHistoryModal"', $page["body"]);
  assertContains('id="versionConflictModal"', $page["body"]);

  $readOnly = httpRequest("GET", "umple.php", array("model" => $modelId, "readOnly" => "1"));
  assertSame(200, $readOnly["status"]);
  assertNotContains('id="buttonRestoreEarlierVersion"', $readOnly["body"]);
});

UmpleTest::add("loading a model with one tab shows its latest text, even if it has not been compiled", function() {
  $modelId = createModel(httpModelText("class A {}"));
  saveTab($modelId, "A", httpModelText("class A { latest; }"));
  assertSame(httpModelText("class A {}"), modelFile($modelId, "model.ump"));

  $exampleMenu = umpleOnlineDir()."/generatedExtraExample1OptionsAD.html";
  if (is_file($exampleMenu)) touch($exampleMenu);
  assertSame(200, httpRequest("GET", "umple.php", array("model" => $modelId))["status"]);
  assertSame(httpModelText("class A { latest; }"), modelFile($modelId, "model.ump"));
  $load = httpRequest("POST", "scripts/compiler.php", array("load" => "1", "filename" => "../ump/".$modelId."/model.ump"));
  assertContains("class A { latest; }", $load["body"]);
});
