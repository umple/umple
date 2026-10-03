<?php
// Copyright: All contributers to the Umple Project
// This file is made available subject to the open source license found at:
// https://umple.org/license
//
// Maps Python runtime errors from UmpleOnline's execution service back to the Umple model.

// Annotates each Python traceback frame that falls inside code copied from the model with its
// model location, for example "[model.ump:12]", which translateToLineNums then links. Generated
// Python brackets such code with a "# line N" comment naming the file and an "# end line" comment;
// frames elsewhere are left as they are. This follows the same rule as
// CodeCompiler.mapPythonTraceback, which maps compile-time errors.
function mapPythonTraceback($text, $modelDir) {
  $mapped = array();
  foreach (explode("\n", $text) as $line) {
    $ending = substr($line, -1) === "\r" ? "\r" : "";
    $content = $ending === "" ? $line : substr($line, 0, -1);
    if (preg_match('/^\s*File "\/input\/([^"]+\.py)", line (\d{1,9})\b/', $content, $frame)) {
      $location = pythonModelLocation($modelDir, $frame[1], intval($frame[2]));
      if ($location !== null) {
        $content .= " [" . $location . "]";
      }
    }
    $mapped[] = $content . $ending;
  }
  return implode("\n", $mapped);
}

function pythonModelLocation($modelDir, $relativePath, $pythonLine) {
  // Only read files that really are inside the model's directory, whatever the path spelling
  $root = realpath($modelDir);
  $pythonPath = realpath($modelDir . "/" . $relativePath);
  if ($root === false || $pythonPath === false || strpos($pythonPath, $root . DIRECTORY_SEPARATOR) !== 0
      || !is_file($pythonPath) || !is_readable($pythonPath)) {
    return null;
  }
  $lines = @file($pythonPath, FILE_IGNORE_NEW_LINES);
  if ($lines === false) {
    return null;
  }
  // A line inside a string literal is text, even when it looks like a marker
  foreach (pythonLinesInsideStrings($lines) as $i => $inside) {
    if ($inside) {
      $lines[$i] = "";
    }
  }
  if ($pythonLine < 1 || $pythonLine > count($lines)
      || preg_match('/^\s*# line (\d{1,9}) "([^"]+)"\s*$|^\s*# end line\s*$/', $lines[$pythonLine - 1])) {
    return null;
  }
  $start = null;
  $startIndex = -1;
  for ($i = $pythonLine - 2; $i >= 0 && $start === null; $i--) {
    if (preg_match('/^\s*# end line\s*$/', $lines[$i])) {
      return null;
    }
    if (preg_match('/^\s*# line (\d{1,9}) "([^"]+)"\s*$/', $lines[$i], $marker)) {
      $start = $marker;
      $startIndex = $i;
    }
  }
  if ($start === null) {
    return null;
  }
  for ($i = $pythonLine; $i < count($lines); $i++) {
    if (preg_match('/^\s*# end line\s*$/', $lines[$i])) {
      return $start[2] . ":" . (intval($start[1]) + ($pythonLine - 1) - ($startIndex + 1));
    }
    if (preg_match('/^\s*# line (\d{1,9}) "([^"]+)"\s*$/', $lines[$i])) {
      return null;
    }
  }
  return null;
}

// Which lines of Python source start inside a string literal, by the same lexical scan as the
// generator's (PythonSource.linesInsideStrings): a backslash protects the next character, a
// comment ends the line's code, and a single-quoted string not continued by a backslash ends with
// its line (a Windows line ending is not part of the line, as in Java).
function pythonLinesInsideStrings($lines) {
  $inside = array();
  $quote = null;
  foreach ($lines as $line) {
    $inside[] = $quote !== null;
    $escapedEnd = false;
    $length = strlen($line) - (substr($line, -1) === "\r" ? 1 : 0);
    for ($i = 0; $i < $length; $i++) {
      $c = $line[$i];
      if ($quote !== null) {
        if ($c === "\\") {
          $i++;
          $escapedEnd = $i >= $length;
        } elseif (substr($line, $i, strlen($quote)) === $quote) {
          $i += strlen($quote) - 1;
          $quote = null;
        }
      } elseif ($c === "#") {
        break;
      } elseif ($c === '"' || $c === "'") {
        $quote = substr($line, $i, 3) === str_repeat($c, 3) ? str_repeat($c, 3) : $c;
        $i += strlen($quote) - 1;
      }
    }
    if ($quote !== null && strlen($quote) === 1 && !$escapedEnd) {
      $quote = null;
    }
  }
  return $inside;
}
