<?php
// Lightweight endpoint used by the CRUD UI to request
// randomly generated instance data from the Instance Diagram
// generator and return it as JSON for inspection in the
// browser dev tools.

require_once __DIR__ . '/compiler_config.php';

header('Content-Type: application/json');

// Raw Umple code for the current model
$code = isset($_POST['code']) ? $_POST['code'] : '';
// Optional extra suboptions (e.g., to tweak linking behaviour)
$suboptions = isset($_POST['suboptions']) ? $_POST['suboptions'] : '';

if ($code === '') {
  echo json_encode(array(
    'status' => 'error',
    'message' => 'No Umple code supplied for random data generation.'
  ));
  exit;
}

list($dataname, $dataHandle) = getOrCreateDataHandle();
$dataHandle->writeData($dataname, $code);
$workDir = $dataHandle->getWorkDir();
$filename = $workDir->getPath() . '/' . $dataname;
$errorFilename = $filename . '.erroroutput';

// Always ask the InstanceDiagram generator to emit JSON-only
// random data suitable for CRUD via the custom suboption.
$language = 'InstanceDiagram';
$fullSuboptions = trim($suboptions . ' -s crudRandomJson');

$command = "java -jar umplesync.jar -generate {$language} {$filename} {$fullSuboptions} 2> {$errorFilename}";
$json = executeCommand($command);

// If the generator failed silently, surface a generic error.
if ($json === '') {
  $errors = @file_get_contents($errorFilename);
  echo json_encode(array(
    'status' => 'error',
    'message' => 'No data returned from InstanceDiagram generator.',
    'generatorErrors' => $errors !== false ? $errors : ''
  ));
  exit;
}

echo $json;
