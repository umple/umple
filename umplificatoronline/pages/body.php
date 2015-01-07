<?php

?>

<div class="container-fluid" id="container" style="width:100%; height:700px;"></div>

<div class="container-fluid" id="separator">
   <div class="row-fluid">
    <div class="span6">
      <form class="form-horizontal" accept-charset="UTF-8">
        <div id="level_select" class="control-group">
          <label for="level" class="control-label">Refactoring Level</label>
              <div class="controls">
                <select id="level" name="level" class="input-xlarge">

                    <?php
    
                        
                    ?>
                </select>
            </div>
        </div>
        <div id="method_name_select"></div>
        <div id="repo_select" class="control-group">
          <label for="repo" class="control-label">Repository</label>
              <div class="controls">
                <select id="repo" name="repo" class="input-xlarge">

                    <?php
	
                    ?>
                </select>
            </div>
        </div>    
        <div id="group_select" class="control-group">
          <label for="group" class="control-label">Open Source Project</label>
              <div class="controls">
                <select id="group" name="group" class="input-xlarge">
                    <?php
      
                        
                    ?>
                </select>
            </div>
        </div>
        <div id="package_select" class="control-group">
          <label for="package" class="control-label">Package</label>
              <div class="controls">
                <select id="package" name="package" class="input-xlarge">
                    <?php
                  
                        
                    ?>
                </select>
            </div>
        </div>
        <div class="control-group">
          <div class="controls">
              <button class="btn btn-primary" id='update'> Umplify </button>
              <button class="btn btn-primary" id='reset'> Reset</button>
          </div>
        </div>
</form>
</div>
  <div class="span6">
    <div class="panel" id="commit_info_panel">
        <div class="panel-heading">
          <h3 class="panel-title" id="commit_panel_title">Commit Information</h3>
        </div>
        <p id="commit_message"> MODIFIED: a lot of codes and comments</p>
      </div>
   </div>
 </div>
  
</div>
</div>