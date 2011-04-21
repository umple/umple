<?php
  $allProjects = array();
  $allProjects["Umple Core Tests"] = "cruise.umple/index.html";
  // $allProjects["Umple Eclipse Plugin Tests"] = "cruise.umple.eclipse/index.html";
  $allProjects["Java+Umple Tests"] = "testbed_java/index.html";
  $allProjects["PHP+Umple Tests"] = "testbed_php/index.html";
  $allProjects["Ruby+Umple Tests"] = "testbed_ruby/index.html";
  $allProjects["Sample Project Tests"] = "sandbox/index.html";

  $url = "http://cruise.site.uottawa.ca:8080/dashboard/tab/build/detail/Umple";
  $raw = file_get_contents($url);
  $newlines = array("\t","\n","\r","\x20\x20","\0","\x0B");
  $content = str_replace($newlines, "", html_entity_decode($raw));
  $start = strpos($content,'<div class="round_corner" id="build_detail_summary_container">');
  $start = strpos($content,'<h3 >',$start) + 5;
  $end = strpos($content,'</h3>',$start);
  $ccSummary = substr($content,$start,$end-$start);  

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
  
<h1><a href="http://cruise.site.uottawa.ca:8080/dashboard/tab/build/detail/Umple"><?php echo $ccSummary ?></a></h1>
  
<?php foreach($allProjects as $name => $path) { ?>
  <div class="project">
    <div class="title"><a href="<?php echo $path ?>"><?php echo $name ?></a></div>
    <div class="tests"><iframe src="<?php echo $path ?>"> </iframe></div>
  </div>
<?php } ?>
  
</body>
</html>