<?php
  $allProjects = array();
  $allProjects["Umple Core Tests"] = "cruise.umple/index.html";
  // $allProjects["Umple Eclipse Plugin Tests"] = "cruise.umple.eclipse/index.html";
  $allProjects["Java+Umple Tests"] = "testbed_java/index.html";
  $allProjects["PHP+Umple Tests"] = "testbed_php/index.html";
  $allProjects["Ruby+Umple Tests"] = "testbed_ruby/index.html";
  $allProjects["Sample Project Tests"] = "sandbox/index.html";

?>
<html>
<head>
<style>

.project { padding: 10px; }
.title { padding: 0 0 10px 0;}
.tests { width: 1000px; height:300px; padding: 0 0 20px 0; }
.tests iframe { width: 100%; height:100%; }

</style>
</head>
<body>
  
<h1>Umple unit test results</h1>
  
<?php foreach($allProjects as $name => $path) { ?>
  <div class="project">
    <div class="title"><a href="<?php echo $path ?>"><?php echo $name ?></a></div>
    <div class="tests"><iframe src="<?php echo $path ?>"> </iframe></div>
  </div>
<?php } ?>
  
</body>
</html>