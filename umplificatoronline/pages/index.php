<?php
include 'header.php';
?>
<div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top" role="navigation">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">Umplification And Statistics Engine</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="mailto:mgarzon@uottawa.ca" target="_top">Contact</a></li>
              </ul>
            </div>
          </div>
        </nav>

      </div>
    </div>

    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkFBQoFBQUFBQ8ICQUKFBEWFhQRExMYHCggGBolGxMTITEhJSkrLi4uFx8zODMsNygtLisBCgoKBQUFDgUFDisZExkrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrK//AABEIAOEA4QMBIgACEQEDEQH/xAAVAAEBAAAAAAAAAAAAAAAAAAAABv/EABQQAQAAAAAAAAAAAAAAAAAAAAD/xAAVAQEBAAAAAAAAAAAAAAAAAAAABf/EABQRAQAAAAAAAAAAAAAAAAAAAAD/2gAMAwEAAhEDEQA/AJsBeSgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH/2Q==" alt="First slide">
          <div class="container">
            <div class="carousel-caption">
			  <h1> Umplification: Reverse Engineering into Umple </h1>
              <p>  A novel approach to <strong>reverse engineering</strong>, in which modeling information such as UML associations, state machines and attributes is <strong>incrementally</strong> added to code written in Java or C++, while maintaining the system in a textual format.</p>
            </div>
          </div>
        </div>
        <div class="item">
          <img src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkFBQoFBQUFBQ8ICQUKFBEWFhQRExMYHCggGBolGxMTITEhJSkrLi4uFx8zODMsNygtLisBCgoKBQUFDgUFDisZExkrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrK//AABEIAOEA4QMBIgACEQEDEQH/xAAVAAEBAAAAAAAAAAAAAAAAAAAABv/EABQQAQAAAAAAAAAAAAAAAAAAAAD/xAAVAQEBAAAAAAAAAAAAAAAAAAAABf/EABQRAQAAAAAAAAAAAAAAAAAAAAD/2gAMAwEAAhEDEQA/AJsBeSgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH/2Q==" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <h1> Umple </h1>
			   <p> An open-source textual <strong>modeling</strong> and <strong>programming</strong> language that adds <strong>UML abstractions</strong> to base programming languages including Java, PHP, C++ and Ruby. </p>
               <p> <code>http://try.umple.org</code></p>
            </div>
          </div>
        </div>
		<div class="item">
          <img src="data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBwgHBgkIBwgKCgkFBQoFBQUFBQ8ICQUKFBEWFhQRExMYHCggGBolGxMTITEhJSkrLi4uFx8zODMsNygtLisBCgoKBQUFDgUFDisZExkrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrKysrK//AABEIAOEA4QMBIgACEQEDEQH/xAAVAAEBAAAAAAAAAAAAAAAAAAAABv/EABQQAQAAAAAAAAAAAAAAAAAAAAD/xAAVAQEBAAAAAAAAAAAAAAAAAAAABf/EABQRAQAAAAAAAAAAAAAAAAAAAAD/2gAMAwEAAhEDEQA/AJsBeSgAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAH/2Q==" alt="Third slide">
          <div class="container">
            <div class="carousel-caption">
              <h1> Umplification Process </h1>
              <p>Umplification involves recursively modifying the Umple model/code to incorporate additional abstractions, while maintaining the semantics of the program. The end product of umplification is an Umple program/model that can be edited
			  and viewed textually just like the original program, and also diagrammatically, using Umple's tools. </p>
            </div>
          </div>
        </div>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->
 <div class="container marketing">

      <div class="row featurette">
        <div class="col-md-7">
          <h2 class="featurette-heading"> Umplify an existing <span class="text-muted">OSS project.</span></h2>
        </div>
        <div class="col-md-5">		
		<form class="form-horizontal" role="form">
			  <div class="form-group">
				<label for="inputEmail3" class="col-sm-4 control-label">Repository:</label>
				<div class="col-sm-8">
					<select class="form-control">
						<option>GitHub</option>
						<option>GoogleCode</option>
					</select>
				</div>
			  </div>
			  <div class="form-group">
				<label for="inputPassword3" class="col-sm-4 control-label">Project:</label>
				<div class="col-sm-8">
					<select class="form-control">
						<option>args4j</option>
						<option>Weka</option>
					</select>
				</div>
			  </div>
			  <div class="form-group">
				<label for="inputPassword3" class="col-sm-4 control-label">Refactoring Level:</label>
				<div class="col-sm-8">
					<div class="radio">
					  <label>
						<input type="radio" name="optionsRadios" id="optionsRadios1" value="level1" checked>
							<mark> Level 1 </mark>- Classes, namespaces, depends
					  </label>
					</div>
					<div class="radio">
					  <label>
						<input type="radio" name="optionsRadios" id="optionsRadios2" value="level2">
							<mark>Level 2 </mark> - (UML/Umple) Attributes 
					  </label>
					</div>
					<div class="radio">
					  <label>
						<input type="radio" name="optionsRadios" id="optionsRadios3" value="level3">
							<mark>Level 3 </mark> - (UML/Umple) Associations 	
					  </label>
					</div>
					<div class="radio disabled">
					  <label>
						<input type="radio" name="optionsRadios" id="optionsRadios3" value="level3" disabled>
							<mark>Level 4 </mark> - (UML/Umple) State Machines 	
					  </label>
					</div>
				</div>
			  </div>
			    <div class="form-group">
				<label for="inputPassword3" class="col-sm-4 control-label">Options:</label>
				<div class="col-sm-8">
					<div class="radio">
						<input type="checkbox" name="optionsRadios" id="optionsRadios1" value="option1" checked>
							<mark> Directories for each package </mark>
					</div>
					<div class="radio">	
						<input type="checkbox" name="optionsRadios" id="optionsRadios2" value="option2">
							<mark> Model code separated from extra code </mark> 
					</div>
				</div>
			  </div>
			  <div class="form-group">
				<div class="col-sm-offset-6 col-sm-10">
				  <button type="submit" class="btn btn-primary">Umplify!</button>
				</div>
			  </div>
		</form>
        </div>
      </div>

      <hr class="featurette-divider">
    </div>
	
<?php
include 'footer.php';
?>

