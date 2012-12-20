<?php
$message = "This was written in php but *outputted* in HTML";

if (isset($_REQUEST["callback"]))
{
  $num = rand(0,100);
  echo "A random number upto 100: {$num}";
  exit;
}
?>
<html>
<head>
<title>Test for Tim</title>
<script src="scripts/ajax.js" type="text/javascript"></script>

<script>
function talkToServer()
{
  Ajax.sendRequest("testfortim.php?",responseFromServer,"callback=1");
}

function responseFromServer(response)
{
  var output = document.getElementById("output");
  output.innerHTML = response.responseText;
}
</script>

</head>
<body>

<p>
STEP 1: Is PHP Working?
Message from PHP Land:
<div style="background-color:#f1f1f1">
<?php print $message ?>
</div>
</p>

STEP 2: Is AJAX Working?

<a href="javascript:talkToServer()">Click Here</a>
<div id="output" style="background-color:#f1f1f1">
This should be replaced by text when you click on the link above
</div>



</body>
</html>