<?php
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// http://umple.org/license
//
// Checks that the hand-maintained lists of scripts bundled into allumple-min.js agree with
// the umple_action*.js files on disk. Ant silently skips a listed file that does not exist,
// so a missing or stale entry would drop Action functions from UmpleOnline without failing
// the build.

define("REPO_ROOT", realpath(__DIR__."/../../.."));
define("SCRIPTS_DIR", REPO_ROOT."/umpleonline/scripts");
define("ACTION_CORE", "core/umple_action_core.js");

// The umple_action*.js files, relative to umpleonline/scripts, sorted
function actionScriptsOnDisk()
{
  $paths = array_merge(glob(SCRIPTS_DIR."/umple_action*.js"), glob(SCRIPTS_DIR."/*/umple_action*.js"));
  $names = array_map(function($path) { return substr($path, strlen(SCRIPTS_DIR) + 1); }, $paths);
  sort($names);
  return $names;
}

function firstMatch($pattern, $text, $description)
{
  assertTrue(preg_match($pattern, $text, $match) === 1, "could not find ".$description);
  return $match[0];
}

function allMatches($pattern, $text)
{
  preg_match_all($pattern, $text, $matches);
  return $matches[1];
}

// Each list's umple_action*.js entries, relative to umpleonline/scripts, in list order
function actionScriptLists()
{
  $ant = firstMatch('#<target name="compressAllScripts">.*?</target>#s',
    file_get_contents(REPO_ROOT."/build/build.umple.xml"), "the compressAllScripts target");
  $gradle = firstMatch('#task concat .*?target = file#s',
    file_get_contents(REPO_ROOT."/build.gradle"), "the concat task");
  $lists = array(
    "build/build.umple.xml" => allMatches('#<fileset file="\$\{scriptPath\}/([^"]+)"#', $ant),
    "build.gradle" => allMatches("#'umpleonline/scripts/([^']+)'#", $gradle),
    "allumple-minifyscript" => allMatches('#^\s*(\S+\.js)\s*\\\\?\s*$#m',
      file_get_contents(SCRIPTS_DIR."/allumple-minifyscript")),
    "_load.js" => allMatches('#src="scripts/([^"]+)"#', file_get_contents(SCRIPTS_DIR."/_load.js")),
  );
  foreach ($lists as $name => $entries) {
    $lists[$name] = array_values(array_filter($entries, function($entry) {
      return preg_match('#(^|/)umple_action[^/]*\.js$#', $entry) === 1;
    }));
  }
  return $lists;
}

UmpleTest::add("every list of bundled scripts has each umple_action file exactly once", function() {
  $onDisk = actionScriptsOnDisk();
  assertTrue(in_array(ACTION_CORE, $onDisk), ACTION_CORE." should exist");
  foreach (actionScriptLists() as $name => $entries) {
    $problems = array();
    foreach (array_diff($onDisk, $entries) as $entry) $problems[] = "missing ".$entry;
    foreach (array_diff($entries, $onDisk) as $entry) $problems[] = "no such file ".$entry;
    foreach (array_count_values($entries) as $entry => $count) {
      if ($count > 1) $problems[] = "listed ".$count." times ".$entry;
    }
    assertSame(array(), $problems, "umple_action entries in ".$name);
  }
});

UmpleTest::add("the script creating Action is bundled before every script that adds functions to it", function() {
  $definers = array_filter(actionScriptsOnDisk(), function($name) {
    return $name !== ACTION_CORE && preg_match('#^\s*Action\.\w+\s*=\s*function#m',
      file_get_contents(SCRIPTS_DIR."/".$name)) === 1;
  });
  assertTrue(count($definers) > 0, "expected scripts that add functions to Action");
  foreach (actionScriptLists() as $name => $entries) {
    $corePosition = array_search(ACTION_CORE, $entries);
    if ($corePosition === false) continue;  // missing entries fail the test above
    foreach ($definers as $definer) {
      $position = array_search($definer, $entries);
      assertTrue($position === false || $position > $corePosition,
        $name." lists ".$definer." before ".ACTION_CORE.", which creates Action");
    }
  }
});
