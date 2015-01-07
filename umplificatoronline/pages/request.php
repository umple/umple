<?php
/*
 * Copyright (c) 2014 Jeremy S. Bradbury, Joseph Heron
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
 
require_once 'inc/auth.php';
require_once 'inc/db_interface.php';
//TODO make db same as the threshold db.
$mysqli_stats = new mysqli("localhost", $db_user, $db_pass, $db_stats);

global $selectedOwner, $selectedRepo;
?>

<!-- TODO Change header to GitView -->
<!-- TODO Add email and name, add note that its not shared or sold, its academic project, it will only be used for informing them about the status of their project and of GitView -->

<div class="container-fluid" id="seperator">

  <div class="hero-unit">
      <h1>Submit a New Repository</h1>
      <br/>
      <div class="row">
      <!-- TODO Display an error if they entered invalid credentials -->
      <?php
        /*if (isset($invalid))
        {
          echo '<div class="alert alert-error span8">
                      <button type="button" class="close" data-dismiss="alert">×</button>
                    <strong>Invalid Credentials!</strong> Please enter a valid username and password.
                    </div>';
        }*/
        ?>
        </div>
      
        <p> Intrested in having your project visualized in GitView? Please enter a GitHub 
          username and repository for the Java project to be visualized. It may take up to
          48 hours for your project to be added. </p>
        <p> Please note that this is an academic
          project and your name and email will only be used to provide information about
          the progress of your request and updates about GitView.</p>

      <form class="form-inline" accept-charset="UTF-8">
        <div class="control-group">
          <div class="controls">
            <input id="username" type="text" placeholder="Username">
            <label class="control-label">/</label>
            <input id="repository" type="text" placeholder="Repository">
          </div>
        </div>
        <div class="control-group">
         <div>
            <input id="name" type="text" placeholder="Name">
            <input id="email" type="text" placeholder="Email">
          </div>
        </div>
        <button class="btn btn-primary" id='submit' >Submit</button>
      </form>
    </div>
  
    
</div>