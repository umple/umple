<?php
echo "<pre>";
echo "The following should output the java version\n";
exec('java --version', $output, $retval);
echo "Returned with status $retval and output:\n";
print_r($output);

echo "The following should output the umple version\n";
exec('java -jar umple.jar --version', $output, $retval);
echo "Returned with status $retval and output:\n";
print_r($output);
echo "</pre>";


?>